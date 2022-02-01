package com.tencent.biz.qqstory.storyHome.detail.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.RequestDataListener;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.BannerProfileSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailDoubleTabSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailLikeListSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailTagListSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.GeneralFeedProfileSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.ShareGroupFeedProfileSegment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class StoryDetailFragment
  extends ReportV4Fragment
  implements View.OnTouchListener, RequestDataListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DetailFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem;
  public DetailCommentHelper a;
  public StoryDetailListView a;
  private StoryDetailPresenter jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter;
  public FeedManager a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  
  public static StoryDetailFragment a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, String paramString2, int paramInt3, int paramInt4)
  {
    StoryDetailFragment localStoryDetailFragment = new StoryDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("feed_id", paramString1);
    localBundle.putInt("source", paramInt1);
    localBundle.putBoolean("should_up_keyboard", paramBoolean);
    localBundle.putInt("focus_comment_id", paramInt2);
    localBundle.putString("focus_video_id", paramString2);
    localBundle.putInt("play_source", paramInt3);
    localBundle.putInt("focus_tab", paramInt4);
    localStoryDetailFragment.setArguments(localBundle);
    return localStoryDetailFragment;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (StoryApi.a())
    {
      localIntent = new Intent(getActivity(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent(getActivity(), QQStoryMainActivity.class);
    localIntent.putExtra("new_video_extra_info", paramString);
    if (paramBoolean) {
      localIntent.putExtra("selfSet_leftViewText", getActivity().getString(2131690778));
    }
    startActivity(localIntent);
  }
  
  public String a(String paramString)
  {
    paramString = UIUtils.a(paramString);
    return paramString[1] + HardCodeUtil.a(2131714283) + paramString[2] + HardCodeUtil.a(2131714282);
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b() + paramInt, 0);
    SLog.b("Q.qqstory.detail.StoryDetailFragment", "scoll to the comment. position is %d.", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b() + paramInt));
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    SLog.b("Q.qqstory.detail.StoryDetailFragment", "update feed all info. %s.", paramDetailFeedItem.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (getActivity() != null) {
      getActivity().setTitle(a(paramDetailFeedItem.a.date));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper = new DetailCommentHelper(getActivity(), getView(), paramDetailFeedItem, true, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter);
    }
    Object localObject = (GeneralFeedProfileSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("GeneralFeedProfileSegment");
    ((GeneralFeedProfileSegment)localObject).a(paramDetailFeedItem);
    ((GeneralFeedProfileSegment)localObject).a(this.jdField_b_of_type_JavaLangString);
    ((GeneralFeedProfileSegment)localObject).e_(true);
    localObject = (ShareGroupFeedProfileSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("ShareGroupFeedProfileSegment");
    ((ShareGroupFeedProfileSegment)localObject).a(paramDetailFeedItem);
    ((ShareGroupFeedProfileSegment)localObject).a(this.jdField_b_of_type_JavaLangString);
    ((ShareGroupFeedProfileSegment)localObject).e_(true);
    localObject = (BannerProfileSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("BannerProfileSegment");
    ((BannerProfileSegment)localObject).a(paramDetailFeedItem);
    ((BannerProfileSegment)localObject).e_(true);
    ((DetailInteractSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailInteractSegment")).a(paramDetailFeedItem, this.jdField_a_of_type_Int, this.d);
    ((DetailDoubleTabSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailLikeListSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailCommentSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailTagListSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailTagListSegment")).a(paramDetailFeedItem);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
    localObject = paramDetailFeedItem.a(paramBoolean);
    int i;
    if ((this.jdField_b_of_type_Int != -1) && (localObject != null)) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((List)localObject).size())
      {
        if (((CommentEntry)((List)localObject).get(i)).commentId == this.jdField_b_of_type_Int) {
          a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          getView().postDelayed(new StoryDetailFragment.2(this), 100);
          StoryReportor.a("home_page", "auto_reply", StoryReportor.a(paramDetailFeedItem.a), 0, new String[0]);
        }
        return;
      }
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    ((GeneralFeedProfileSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("GeneralFeedProfileSegment")).a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a(paramBoolean1);
    StoryDetailListView localStoryDetailListView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView;
    if (!paramBoolean2) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localStoryDetailListView.setLoadMoreComplete("StoryDetailFragment", paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public boolean a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    return (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a()) || (paramDetailFeedItem == null) || (paramDetailFeedItem.a(paramBoolean)) || (paramDetailFeedItem.a(paramBoolean) != null);
  }
  
  public void b()
  {
    SLog.c("Q.qqstory.detail.StoryDetailFragment", "show empty page.");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setProfileSegmentDisplay(false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
  }
  
  public void b(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    ((DetailDoubleTabSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailLikeListSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailCommentSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramDetailFeedItem, paramBoolean);
    paramBoolean = a(paramDetailFeedItem, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new StoryDetailFragment.3(this));
    paramDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramDetailFeedItem.setLoadMoreComplete("StoryDetailFragment", true, paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.L_();
  }
  
  public void e()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(i, 0);
    SLog.b("Q.qqstory.detail.StoryDetailFragment", "scoll to last comment. position is %d.", Integer.valueOf(i));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a(getActivity());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.j();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setRequestDataListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new StoryDetailFragment.1(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setLoadMoreComplete("StoryDetailFragment", true, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter = new StoryDetailPresenter(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.d);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.e();
    if (this.c != 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.c(2);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setCallback(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a(paramInt1, paramInt2, paramIntent);
      }
      return;
      String str = paramIntent.getStringExtra("new_video_extra_info");
      Object localObject1;
      if ((this.jdField_a_of_type_Int == 211) || (this.jdField_a_of_type_Int == 221))
      {
        localObject1 = new Intent(getActivity(), TroopStoryMainActivity.class);
        ((Intent)localObject1).putExtra("new_video_extra_info", str);
        ((Intent)localObject1).setFlags(335544320);
        startActivity((Intent)localObject1);
      }
      for (;;)
      {
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
        break;
        if (this.d == 106)
        {
          localObject1 = (QQStoryActivityManager)SuperManager.a(18);
          if ((((QQStoryActivityManager)localObject1).jdField_a_of_type_Boolean) && (((QQStoryActivityManager)localObject1).jdField_a_of_type_JavaUtilMap != null))
          {
            Iterator localIterator = ((QQStoryActivityManager)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              Object localObject2 = (String)localIterator.next();
              localObject2 = (QQStoryBaseActivity)((WeakReference)((QQStoryActivityManager)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject2)).get();
              if ((localObject2 != null) && (getActivity() != localObject2) && (!((QQStoryBaseActivity)localObject2).isFinishing())) {
                ((QQStoryBaseActivity)localObject2).finish();
              }
            }
          }
          a(str, true);
        }
        else
        {
          a(str, false);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper != null)
      {
        AtVideoTextWatcher.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.a, paramIntent);
        ThreadManager.getUIHandler().postDelayed(new StoryDetailFragment.4(this), 100L);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("feed_id");
    this.jdField_a_of_type_Int = paramBundle.getInt("source");
    this.d = paramBundle.getInt("play_source");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("should_up_keyboard");
    this.jdField_b_of_type_Int = paramBundle.getInt("focus_comment_id", -1);
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("focus_video_id");
    this.c = paramBundle.getInt("focus_tab");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561782, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131365255));
    if (QQStoryContext.a())
    {
      ((InputLinearLayout)paramViewGroup.findViewById(2131376931)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166513));
      ((LinearLayout)paramViewGroup.findViewById(2131363819)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166512));
      ((XEditTextEx)paramViewGroup.findViewById(2131366436)).setHintTextColor(paramLayoutInflater.getContext().getResources().getColor(2131166514));
      paramViewGroup.findViewById(2131365922).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166513));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370761));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView = ((StoryDetailListView)paramViewGroup.findViewById(2131365724));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.jdField_b_of_type_Int = 0;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.l();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.g();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.e();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    }
    StoryReportor.a("home_page-comment_suc-d1", null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper == null) {}
    while (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b()) {
      return;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b();
    paramAdapterView = ((DetailCommentSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramAdapterView == null)
    {
      SLog.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramAdapterView.type == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.L_();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.a(paramAdapterView, paramInt, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.a());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper == null) {
      return false;
    }
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b()) {
      return false;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b();
    paramView = ((DetailCommentSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      SLog.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a != null)) {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {
        break label160;
      }
    }
    label160:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      StoryReportor.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, StoryReportor.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.L_();
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.b(paramView, paramInt, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.a());
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.k();
  }
  
  public void onResume()
  {
    super.onResume();
    String str = null;
    if ((this.d == 106) || (this.d == 108)) {
      str = String.valueOf(this.d);
    }
    StoryReportor.a("home_page-comment_suc-d1", str);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailPresenter.h();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.o();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.a()))
    {
      int i;
      if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailCommentHelper.c();
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null)
        {
          paramMotionEvent = StoryQQTextCacher.a().jdField_a_of_type_JavaLangString;
          i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a);
          if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner().isMe()) {
            break label136;
          }
        }
      }
      label136:
      for (paramView = "1";; paramView = "2")
      {
        StoryReportor.a("home_page", "cancel_reply", i, 0, new String[] { paramView, StoryReportor.a(this.jdField_a_of_type_Int), paramMotionEvent, this.jdField_a_of_type_JavaLangString });
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.detail.StoryDetailFragment", 2, "touch list while keyboard is showing, so hide the keyboard");
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment
 * JD-Core Version:    0.7.0.1
 */