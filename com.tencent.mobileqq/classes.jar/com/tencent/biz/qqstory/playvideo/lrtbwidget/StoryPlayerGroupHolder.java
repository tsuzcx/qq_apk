package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3;
import com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.NewGuideNodeWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.ProgressBarVideoInfoWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.UploadStatusVideoInfoWidget;
import com.tencent.biz.qqstory.playvideo.playerwidget.WeishiTagVideoInfoWidget;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryPlayerGroupHolder
  extends GroupHolderContainer
  implements StoryPageSuperCapacity
{
  public XViewPager j;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter k;
  public int l = -1;
  private StoryPlayerGlobalHolder m;
  private OnSuperPageChangeListener n;
  private VideoViewVideoHolder.VideoViewListener o;
  private ViewGroup p;
  private int q = 0;
  private XViewPager.OnPageChangeListener r = new StoryPlayerGroupHolder.3(this);
  private VideoViewVideoHolder.VideoViewListener s = new StoryPlayerGroupHolder.4(this);
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder)
  {
    super(paramViewGroup);
    this.m = paramStoryPlayerGlobalHolder;
    u();
    a(new VideoCoverListGroupHolder((ViewGroup)this.b));
    a(new PlayerGestureGroupHolder((ViewGroup)this.b));
    a(new WeishiTagVideoInfoWidget((ViewGroup)this.b.findViewById(2131450116)));
    a(new UploadStatusVideoInfoWidget((LinearLayout)this.b.findViewById(2131449159)));
    a(new DetailVideoInfoWidget((LinearLayout)this.b.findViewById(2131431791)));
    a(new BannerVideoInfoWidget3((LinearLayout)this.b.findViewById(2131429288)));
    a(new ProgressBarVideoInfoWidget((LinearLayout)this.b.findViewById(2131440739)));
    a(new BottomVideoInfoWidget((LinearLayout)this.b.findViewById(2131429684)));
    a(new LoadingMoreWidget((LinearLayout)this.b.findViewById(2131437618)));
    a(new MoreVideoInfoWidget(this.b.findViewById(2131444858).findViewById(2131438862)));
    a(new NewGuideNodeWidget(this.b.findViewById(2131439220)));
  }
  
  private int t()
  {
    boolean bool = ScreenUtil.checkDeviceHasNavigationBar(this.b.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryPlayerGroupHolder: hasNavi ");
    localStringBuilder.append(bool);
    SLog.b("FredguoFix", localStringBuilder.toString());
    if (bool) {
      return 0;
    }
    return (int)Math.min(ScreenUtil.SCREEN_HIGHT - ScreenUtil.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  private void u()
  {
    if (LiuHaiUtils.b)
    {
      View localView = this.b.findViewById(2131440406);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (LiuHaiUtils.d / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628177, paramViewGroup, false);
    this.p = ((ViewGroup)paramViewGroup.findViewById(2131444769));
    return paramViewGroup;
  }
  
  public void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    boolean bool = this.h;
    super.a(paramInt, paramGroupInfo, paramArrayList);
    if (bool) {
      SLog.b(this.a, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.d), Integer.valueOf(paramInt), Integer.valueOf(this.f.size()), Integer.valueOf(paramArrayList.size()), paramGroupInfo.b.b });
    } else {
      SLog.a(this.a, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramGroupInfo.b.b);
    }
    this.q = i().mUIStyle.mPlayerRepeatMode;
    this.k.a(paramArrayList, paramInt);
    paramGroupInfo = a(paramGroupInfo.b.b);
    if (paramGroupInfo != null)
    {
      paramInt = 0;
      while (paramInt < paramArrayList.size())
      {
        if (TextUtils.equals(((StoryPlayerVideoData)paramArrayList.get(paramInt)).b, paramGroupInfo)) {
          break label193;
        }
        paramInt += 1;
      }
    }
    paramInt = -1;
    label193:
    paramGroupInfo = (LoadingMoreWidget)b(LoadingMoreWidget.class);
    if ((q()) && (paramGroupInfo != null) && (paramGroupInfo.B()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("Q.qqstory.weishi");
      SLog.a(localStringBuilder.toString(), "onBind, weishi hide loading state", Integer.valueOf(paramInt));
      paramGroupInfo.p();
      if (paramInt > 0)
      {
        int i = paramInt + 1;
        if (i < paramArrayList.size())
        {
          this.j.setCurrentItem(i);
          paramGroupInfo = new StringBuilder();
          paramGroupInfo.append(this.a);
          paramGroupInfo.append("Q.qqstory.weishi");
          SLog.a(paramGroupInfo.toString(), "onBind, change to next video", Integer.valueOf(paramInt));
          return;
        }
      }
      paramGroupInfo = h();
      if ((paramGroupInfo instanceof VideoHolderContainer))
      {
        paramGroupInfo = (VideoViewVideoHolder)((VideoHolderContainer)paramGroupInfo).b(VideoViewVideoHolder.class);
        if (paramGroupInfo != null)
        {
          paramGroupInfo.h();
          paramGroupInfo = new StringBuilder();
          paramGroupInfo.append(this.a);
          paramGroupInfo.append("Q.qqstory.weishi");
          SLog.a(paramGroupInfo.toString(), "onBind, resume play", Integer.valueOf(paramInt));
        }
      }
    }
    if (paramInt == -1)
    {
      paramInt = this.j.getCurrentItem();
      SLog.a(this.a, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
    }
    if (paramInt < 0) {
      paramInt = 0;
    }
    SLog.b(this.a, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(paramArrayList.size()), this.e.b, Integer.valueOf(this.j.getCurrentItem()), Integer.valueOf(paramInt), Integer.valueOf(this.q) });
    if (this.j.getCurrentItem() == paramInt)
    {
      paramGroupInfo = b(paramInt);
      SLog.a(this.a, "onBind, getPageHolderOfPosition = %s", paramGroupInfo);
      if ((paramGroupInfo != null) && (paramGroupInfo.f()))
      {
        SLog.a(this.a, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramGroupInfo);
        return;
      }
      SLog.a(this.a, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
      this.r.a(paramInt);
      paramGroupInfo = this.j.getOnPageChangeListeners().iterator();
      while (paramGroupInfo.hasNext()) {
        ((XViewPager.OnPageChangeListener)paramGroupInfo.next()).a(paramInt);
      }
    }
    this.j.setCurrentItem(paramInt);
  }
  
  public void a(OnSuperPageChangeListener paramOnSuperPageChangeListener, VideoViewVideoHolder.VideoViewListener paramVideoViewListener)
  {
    this.n = paramOnSuperPageChangeListener;
    this.o = paramVideoViewListener;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.p.setVisibility(0);
      return;
    }
    this.p.setVisibility(4);
  }
  
  public VideoHolderBase b(int paramInt)
  {
    VideoHolderBase localVideoHolderBase = null;
    if (paramInt >= 0)
    {
      XViewPager.ItemInfo localItemInfo = this.j.b(paramInt);
      if (localItemInfo != null) {
        localVideoHolderBase = (VideoHolderBase)localItemInfo.a;
      }
      return localVideoHolderBase;
    }
    SLog.d(this.a, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void e()
  {
    this.j = ((XViewPager)this.b.findViewById(2131449793));
    int i = (int)this.b.getResources().getDisplayMetrics().density;
    this.j.setPageTurningThreshold(0.3F);
    this.j.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.j.setEnableScrollDirection(true, true, false, false);
    this.j.setOverScrollMode(2);
    this.j.setEnableOverScroll(true);
    this.j.setPageMargin(10);
    XViewPager localXViewPager = this.j;
    StoryPlayerGroupHolder.StoryPlayerVideoAdapter localStoryPlayerVideoAdapter = new StoryPlayerGroupHolder.StoryPlayerVideoAdapter(this, k(), this);
    this.k = localStoryPlayerVideoAdapter;
    localXViewPager.setAdapter(localStoryPlayerVideoAdapter);
    this.k.a(this.s);
    this.j.setOnPageChangeListener(this.r);
    this.j.post(new StoryPlayerGroupHolder.1(this));
    super.e();
    this.j.setOnVisibilityChangeListener(new StoryPlayerGroupHolder.2(this));
  }
  
  public void f()
  {
    super.f();
    this.k.a(new ArrayList(0), this.d);
  }
  
  public VideoHolderBase h()
  {
    return b(this.l);
  }
  
  public boolean p()
  {
    return this.l == this.k.getCount() - 1;
  }
  
  public boolean q()
  {
    if ((this.e instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {
      return MsgTabStoryManager.a(QQStoryContext.j()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.e).a());
    }
    return false;
  }
  
  public VideoViewVideoHolder r()
  {
    VideoHolderBase localVideoHolderBase = h();
    if (localVideoHolderBase != null) {
      return (VideoViewVideoHolder)localVideoHolderBase.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public boolean s()
  {
    if (TextUtils.equals(this.m.o().b, this.e.b))
    {
      Object localObject = a(this.e.b);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = h();
        SLog.a(this.a, "no selected Vid, current = %s", localObject);
        if (localObject != null)
        {
          a((VideoHolderBase)localObject);
          return true;
        }
      }
      else
      {
        int i = 0;
        while (i < StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.k).size())
        {
          VideoHolderBase localVideoHolderBase = (VideoHolderBase)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.k).valueAt(i);
          if (TextUtils.equals(localVideoHolderBase.c.b, (CharSequence)localObject))
          {
            a(localVideoHolderBase);
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VerticalPagerHolder{mPosition=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mData=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder
 * JD-Core Version:    0.7.0.1
 */