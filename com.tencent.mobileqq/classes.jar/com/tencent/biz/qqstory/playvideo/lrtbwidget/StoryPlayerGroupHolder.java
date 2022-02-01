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
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private OnSuperPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener;
  private StoryPlayerGlobalHolder jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  private VideoViewVideoHolder.VideoViewListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener;
  private XViewPager.OnPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener = new StoryPlayerGroupHolder.3(this);
  public XViewPager a;
  public int b;
  private VideoViewVideoHolder.VideoViewListener b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener = new StoryPlayerGroupHolder.4(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder = paramStoryPlayerGlobalHolder;
    d();
    a(new VideoCoverListGroupHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new CloseBtnGroupHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new PlayerGestureGroupHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new WeishiTagVideoInfoWidget(this.jdField_a_of_type_AndroidViewView.findViewById(2131381889)));
    a(new UploadStatusVideoInfoWidget((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380976)));
    a(new DetailVideoInfoWidget((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365727)));
    a(new BannerVideoInfoWidget3((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363471)));
    a(new ProgressBarVideoInfoWidget((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373556)));
    a(new BottomVideoInfoWidget((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363833)));
    a(new LoadingMoreWidget((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370719)));
    a(new MoreVideoInfoWidget(this.jdField_a_of_type_AndroidViewView.findViewById(2131377124).findViewById(2131371865)));
    a(new NewGuideNodeWidget(this.jdField_a_of_type_AndroidViewView.findViewById(2131372201)));
  }
  
  private int b()
  {
    boolean bool = ScreenUtil.checkDeviceHasNavigationBar(this.jdField_a_of_type_AndroidViewView.getContext());
    SLog.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(ScreenUtil.SCREEN_HIGHT - ScreenUtil.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (LiuHaiUtils.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373272);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (LiuHaiUtils.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561951, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131377041));
    return paramViewGroup;
  }
  
  public VideoHolderBase a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public VideoHolderBase a(int paramInt)
  {
    VideoHolderBase localVideoHolderBase = null;
    if (paramInt >= 0)
    {
      XViewPager.ItemInfo localItemInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localItemInfo != null) {
        localVideoHolderBase = (VideoHolderBase)localItemInfo.a;
      }
      return localVideoHolderBase;
    }
    SLog.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public VideoViewVideoHolder a()
  {
    VideoHolderBase localVideoHolderBase = a();
    if (localVideoHolderBase != null) {
      return (VideoViewVideoHolder)localVideoHolderBase.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    super.a(paramInt, paramGroupInfo, paramArrayList);
    if (bool)
    {
      SLog.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramGroupInfo = a(paramGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
      if (paramGroupInfo == null) {
        break label620;
      }
      paramInt = 0;
      label125:
      if (paramInt >= paramArrayList.size()) {
        break label620;
      }
      if (!TextUtils.equals(((StoryPlayerVideoData)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramGroupInfo)) {
        break label305;
      }
    }
    for (;;)
    {
      paramGroupInfo = (LoadingMoreWidget)b(LoadingMoreWidget.class);
      if ((d()) && (paramGroupInfo != null) && (paramGroupInfo.c()))
      {
        SLog.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramGroupInfo.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          SLog.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          SLog.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
          break;
          label305:
          paramInt += 1;
          break label125;
        }
        paramGroupInfo = a();
        if ((paramGroupInfo instanceof VideoHolderContainer))
        {
          paramGroupInfo = (VideoViewVideoHolder)((VideoHolderContainer)paramGroupInfo).b(VideoViewVideoHolder.class);
          if (paramGroupInfo != null)
          {
            paramGroupInfo.d();
            SLog.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        SLog.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          SLog.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label608;
          }
          paramGroupInfo = a(paramInt);
          SLog.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramGroupInfo);
          if ((paramGroupInfo != null) && (paramGroupInfo.c())) {
            break label592;
          }
          SLog.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt);
          paramGroupInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramGroupInfo.hasNext()) {
            ((XViewPager.OnPageChangeListener)paramGroupInfo.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label592:
        SLog.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramGroupInfo);
        return;
        label608:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label620:
      paramInt = -1;
    }
  }
  
  public void a(OnSuperPageChangeListener paramOnSuperPageChangeListener, VideoViewVideoHolder.VideoViewListener paramVideoViewListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener = paramOnSuperPageChangeListener;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener = paramVideoViewListener;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    CloseBtnGroupHolder localCloseBtnGroupHolder;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localCloseBtnGroupHolder = (CloseBtnGroupHolder)a(CloseBtnGroupHolder.class);
        if (localCloseBtnGroupHolder != null) {
          localCloseBtnGroupHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      } while (!paramBoolean2);
      localCloseBtnGroupHolder = (CloseBtnGroupHolder)a(CloseBtnGroupHolder.class);
    } while (localCloseBtnGroupHolder == null);
    localCloseBtnGroupHolder.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131381588));
    int i = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.3F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(true, true, false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    XViewPager localXViewPager = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    StoryPlayerGroupHolder.StoryPlayerVideoAdapter localStoryPlayerVideoAdapter = new StoryPlayerGroupHolder.StoryPlayerVideoAdapter(this, a(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter = localStoryPlayerVideoAdapter;
    localXViewPager.setAdapter(localStoryPlayerVideoAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new StoryPlayerGroupHolder.2(this));
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(new ArrayList(0), this.jdField_a_of_type_Int);
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId)) {
      bool = MsgTabStoryManager.a(QQStoryContext.a()).a(((MsgTabPlayPageLoader.MsgTabGroupId)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      SLog.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((VideoHolderBase)localObject);
        bool1 = true;
      }
    }
    return bool1;
    label83:
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).size()) {
        break;
      }
      VideoHolderBase localVideoHolderBase = (VideoHolderBase)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localVideoHolderBase.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localVideoHolderBase);
        return true;
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    return "VerticalPagerHolder{mPosition=" + this.jdField_a_of_type_Int + ", mData=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder
 * JD-Core Version:    0.7.0.1
 */