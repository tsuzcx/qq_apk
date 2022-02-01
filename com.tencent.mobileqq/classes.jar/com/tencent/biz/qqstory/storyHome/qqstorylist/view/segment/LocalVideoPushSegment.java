package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.ThumbSlideShowView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class LocalVideoPushSegment
  extends SegmentView
{
  public static final String KEY = "LocalVideoPushSegment";
  protected StoryConfigManager a = (StoryConfigManager)SuperManager.a(10);
  RoundedTransformation b;
  private final int c = 1;
  private final int d = 2;
  private final int e = 3;
  private final int f = 4;
  private int g = 4;
  private ArrayList<LocalMediaInfo> h = new ArrayList();
  private StoryAlbum i;
  private int j;
  private boolean k = false;
  private BaseViewHolder n;
  private LocalVideoPushSegment.EventListener o;
  private StoryScanManager p = (StoryScanManager)SuperManager.a(30);
  
  public LocalVideoPushSegment(Context paramContext)
  {
    super(paramContext);
    this.b = new RoundedTransformation(UIUtils.a(paramContext, 3.0F), 0, 1.351351F, null, null);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = UIUtils.a(this.l, 74.0F);
    localURLDrawableOptions.mRequestHeight = UIUtils.a(this.l, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(URLDrawableDecodeHandler.b(UIUtils.a(this.l, 74.0F), UIUtils.a(this.l, 100.0F), UIUtils.a(this.l, 3.0F)));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalVideoPushSegment.LoadAlbumResult paramLoadAlbumResult)
  {
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramLoadAlbumResult.c, Integer.valueOf(paramLoadAlbumResult.b), paramLoadAlbumResult.a });
    this.j = paramLoadAlbumResult.b;
    this.i = paramLoadAlbumResult.c;
    a(paramLoadAlbumResult.a, 2);
    this.a.d("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(LocalVideoPushSegment.LoadPhotoResult paramLoadPhotoResult)
  {
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramLoadPhotoResult.a, 3);
    this.a.d("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, LocalVideoPushSegment.OnLoadThumbBitmapListener paramOnLoadThumbBitmapListener)
  {
    if (paramLocalMediaInfo != null)
    {
      if (paramOnLoadThumbBitmapListener == null) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramOnLoadThumbBitmapListener));
    }
  }
  
  private String c(int paramInt)
  {
    if (paramInt == 1) {
      return "1";
    }
    if (paramInt == 2) {
      return "2";
    }
    if (paramInt == 3) {
      return "3";
    }
    return "";
  }
  
  private void j()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.p.c(this.l))
    {
      a(null, 4);
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.a.c("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.a.d("first_enter_home_page", Boolean.valueOf(false));
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.a.c("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.p.h())
    {
      m();
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    k();
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
  }
  
  private void k()
  {
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.1(this));
  }
  
  private void m()
  {
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.2(this));
  }
  
  private LocalVideoPushSegment.LoadAlbumResult n()
  {
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.p.c();
    if ((localList != null) && (!localList.isEmpty()))
    {
      StoryAlbum localStoryAlbum = (StoryAlbum)localList.get(0);
      Object localObject2 = localStoryAlbum.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)((Iterator)localObject2).next();
          if (localPicInfo.a()) {
            ((List)localObject1).add(localPicInfo);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((StoryAlbum.PicInfo)((Iterator)localObject1).next()).d());
        }
        SLog.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new LocalVideoPushSegment.LoadAlbumResult((List)localObject2, localList.size(), localStoryAlbum);
      }
    }
    return null;
  }
  
  private LocalVideoPushSegment.LoadPhotoResult p()
  {
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.p.a(this.l);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((StoryAlbum.PicInfo)((Iterator)localObject).next()).d());
      }
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new LocalVideoPushSegment.LoadPhotoResult(localArrayList, null);
    }
    return null;
  }
  
  private void q()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.a.c("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.a.c("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.g == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.n == null) {
      this.n = paramBaseViewHolder;
    }
    paramBaseViewHolder = (TextView)this.n.a(2131442714);
    paramViewGroup = (TextView)this.n.a(2131442713);
    Button localButton = (Button)this.n.a(2131442715);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.n.a(2131442711);
    ImageView localImageView1 = (ImageView)this.n.a(2131442710);
    ImageView localImageView2 = (ImageView)this.n.a(2131442712);
    paramInt = this.g;
    if (paramInt == 1)
    {
      paramBaseViewHolder.setText(HardCodeUtil.a(2131904232));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(HardCodeUtil.a(2131904240));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "https://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    else if (paramInt == 2)
    {
      paramBaseViewHolder.setText(String.format(HardCodeUtil.a(2131904230), new Object[] { Integer.valueOf(this.j) }));
      paramViewGroup.setText(HardCodeUtil.a(2131904229));
      localButton.setText(HardCodeUtil.a(2131904233));
      localThumbSlideShowView.setVisibility(0);
      localThumbSlideShowView.a(this.h);
      localImageView2.setVisibility(8);
    }
    else if (paramInt == 3)
    {
      paramBaseViewHolder.setText(String.format(HardCodeUtil.a(2131904239), new Object[] { Integer.valueOf(this.h.size()) }));
      paramViewGroup.setText(HardCodeUtil.a(2131904238));
      localButton.setText(HardCodeUtil.a(2131904237));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      if (!this.h.isEmpty())
      {
        localImageView2.setVisibility(0);
        a((LocalMediaInfo)this.h.get(0), new LocalVideoPushSegment.3(this, localImageView2));
      }
    }
    localButton.setOnClickListener(this.n);
    localImageView1.setOnClickListener(this.n);
    localThumbSlideShowView.setOnClickListener(this.n);
    localImageView2.setOnClickListener(this.n);
    if (this.n.i == null) {
      this.n.a(new LocalVideoPushSegment.4(this));
    }
    paramInt = this.g;
    if (paramInt != 4) {
      StoryReportor.a("home_page", "exp_smartalbum", 0, 0, new String[] { c(paramInt) });
    }
    return this.n.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.n = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628072, paramViewGroup, false));
    return this.n;
  }
  
  public LocalVideoPushSegment a(LocalVideoPushSegment.EventListener paramEventListener)
  {
    this.o = paramEventListener;
    return this;
  }
  
  public void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    int m = a();
    this.h.clear();
    this.g = paramInt;
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.h.addAll(paramList);
    }
    int i1 = a();
    if (m != i1)
    {
      e(true);
      SLog.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
      return;
    }
    if (i1 == 0)
    {
      SLog.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
      return;
    }
    paramList = f(0);
    if ((paramList != null) && (e(paramList)))
    {
      a(0, paramList, w());
      SLog.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
    }
  }
  
  public String b()
  {
    return "LocalVideoPushSegment";
  }
  
  protected void g() {}
  
  public void h()
  {
    super.h();
    Object localObject = this.n;
    if (localObject != null)
    {
      localObject = (ThumbSlideShowView)((BaseViewHolder)localObject).a(2131442711);
      if (localObject != null) {
        ((ThumbSlideShowView)localObject).a();
      }
      this.n = null;
    }
  }
  
  protected void i()
  {
    this.k = false;
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment
 * JD-Core Version:    0.7.0.1
 */