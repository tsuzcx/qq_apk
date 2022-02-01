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
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class LocalVideoPushSegment
  extends SegmentView
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private StoryScanManager jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager = (StoryScanManager)SuperManager.a(30);
  private StoryAlbum jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
  protected StoryConfigManager a;
  RoundedTransformation jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  private LocalVideoPushSegment.EventListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentLocalVideoPushSegment$EventListener;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean = false;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public LocalVideoPushSegment(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation = new RoundedTransformation(UIUtils.a(paramContext, 3.0F), 0, 1.351351F, null, null);
  }
  
  private LocalVideoPushSegment.LoadAlbumResult a()
  {
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.a();
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
          ((List)localObject2).add(((StoryAlbum.PicInfo)((Iterator)localObject1).next()).a());
        }
        SLog.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new LocalVideoPushSegment.LoadAlbumResult((List)localObject2, localList.size(), localStoryAlbum);
      }
    }
    return null;
  }
  
  private LocalVideoPushSegment.LoadPhotoResult a()
  {
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((StoryAlbum.PicInfo)((Iterator)localObject).next()).a());
      }
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new LocalVideoPushSegment.LoadPhotoResult(localArrayList, null);
    }
    return null;
  }
  
  private String a(int paramInt)
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
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(URLDrawableDecodeHandler.b(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 74.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalVideoPushSegment.LoadAlbumResult paramLoadAlbumResult)
  {
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramLoadAlbumResult.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum, Integer.valueOf(paramLoadAlbumResult.jdField_a_of_type_Int), paramLoadAlbumResult.jdField_a_of_type_JavaUtilList });
    this.f = paramLoadAlbumResult.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum = paramLoadAlbumResult.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
    a(paramLoadAlbumResult.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(LocalVideoPushSegment.LoadPhotoResult paramLoadPhotoResult)
  {
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramLoadPhotoResult.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, LocalVideoPushSegment.OnLoadThumbBitmapListener paramOnLoadThumbBitmapListener)
  {
    if ((paramLocalMediaInfo == null) || (paramOnLoadThumbBitmapListener == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramOnLoadThumbBitmapListener));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("first_enter_home_page", Boolean.valueOf(false));
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.a())
    {
      i();
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    SLog.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
  }
  
  private void h()
  {
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.1(this));
  }
  
  private void i()
  {
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.2(this));
  }
  
  private void j()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      SLog.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
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
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = paramBaseViewHolder;
    }
    paramBaseViewHolder = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131375013);
    paramViewGroup = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131375012);
    Button localButton = (Button)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131375014);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131375010);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131375009);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131375011);
    if (this.e == 1)
    {
      paramBaseViewHolder.setText(HardCodeUtil.a(2131706322));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(HardCodeUtil.a(2131706330));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "https://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder);
      localImageView1.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder);
      localImageView2.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(new LocalVideoPushSegment.4(this));
      }
      if (this.e != 4) {
        StoryReportor.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a();
      if (this.e == 2)
      {
        paramBaseViewHolder.setText(String.format(HardCodeUtil.a(2131706320), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(HardCodeUtil.a(2131706319));
        localButton.setText(HardCodeUtil.a(2131706323));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramBaseViewHolder.setText(String.format(HardCodeUtil.a(2131706329), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(HardCodeUtil.a(2131706328));
        localButton.setText(HardCodeUtil.a(2131706327));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new LocalVideoPushSegment.3(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561842, paramViewGroup, false));
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public LocalVideoPushSegment a(LocalVideoPushSegment.EventListener paramEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentLocalVideoPushSegment$EventListener = paramEventListener;
    return this;
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    int i = a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.e = paramInt;
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    int j = a();
    if (i != j)
    {
      c(true);
      SLog.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        SLog.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    SLog.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  public void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131375010);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = null;
    }
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment
 * JD-Core Version:    0.7.0.1
 */