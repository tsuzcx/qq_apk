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
import anvx;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
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
import weg;
import who;
import wjg;
import wjs;
import wkw;
import xuy;
import xve;
import xwc;
import xwr;
import xxg;
import xxh;
import xxi;
import xya;
import xyb;
import xyf;
import xyi;
import xym;
import xyn;
import xyr;
import xyt;
import yck;
import ykq;
import ykv;

public class StoryDetailFragment
  extends ReportV4Fragment
  implements View.OnTouchListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, xuy
{
  private int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public StoryDetailListView a;
  private String jdField_a_of_type_JavaLangString;
  private xwc jdField_a_of_type_Xwc;
  public xwr a;
  private xxi jdField_a_of_type_Xxi;
  public yck a;
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
    if (weg.a())
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
      localIntent.putExtra("selfSet_leftViewText", getActivity().getString(2131690676));
    }
    startActivity(localIntent);
  }
  
  public String a(String paramString)
  {
    paramString = UIUtils.parseDate(paramString);
    return paramString[1] + anvx.a(2131713787) + paramString[2] + anvx.a(2131713786);
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Yck.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Xxi.a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b() + paramInt, 0);
    ykq.b("Q.qqstory.detail.StoryDetailFragment", "scoll to the comment. position is %d.", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b() + paramInt));
  }
  
  public void a(xwc paramxwc, boolean paramBoolean)
  {
    ykq.b("Q.qqstory.detail.StoryDetailFragment", "update feed all info. %s.", paramxwc.toString());
    this.jdField_a_of_type_Xwc = paramxwc;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (getActivity() != null) {
      getActivity().setTitle(a(paramxwc.a.date));
    }
    if (this.jdField_a_of_type_Xwr == null) {
      this.jdField_a_of_type_Xwr = new xwr(getActivity(), getView(), paramxwc, true, this.jdField_a_of_type_Int, this.jdField_a_of_type_Xxi);
    }
    Object localObject = (xyr)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("GeneralFeedProfileSegment");
    ((xyr)localObject).a(paramxwc);
    ((xyr)localObject).a(this.jdField_b_of_type_JavaLangString);
    ((xyr)localObject).d_(true);
    localObject = (xyt)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("ShareGroupFeedProfileSegment");
    ((xyt)localObject).a(paramxwc);
    ((xyt)localObject).a(this.jdField_b_of_type_JavaLangString);
    ((xyt)localObject).d_(true);
    localObject = (xya)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("BannerProfileSegment");
    ((xya)localObject).a(paramxwc);
    ((xya)localObject).d_(true);
    ((xyi)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailInteractSegment")).a(paramxwc, this.jdField_a_of_type_Int, this.d);
    ((xyf)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).a(paramxwc, paramBoolean);
    ((xym)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).a(paramxwc, paramBoolean);
    ((xyb)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramxwc, paramBoolean);
    ((xyn)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailTagListSegment")).a(paramxwc);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
    localObject = paramxwc.a(paramBoolean);
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
          ykv.a("home_page", "auto_reply", ykv.a(paramxwc.a), 0, new String[0]);
        }
        return;
      }
      i += 1;
    }
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
  
  public boolean a(xwc paramxwc, boolean paramBoolean)
  {
    return (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a()) || (paramxwc == null) || (paramxwc.a(paramBoolean)) || (paramxwc.a(paramBoolean) != null);
  }
  
  public void b()
  {
    ykq.c("Q.qqstory.detail.StoryDetailFragment", "show empty page.");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setProfileSegmentDisplay(false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
  }
  
  public void b(xwc paramxwc, boolean paramBoolean)
  {
    ((xyf)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).a(paramxwc, paramBoolean);
    ((xym)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).a(paramxwc, paramBoolean);
    ((xyb)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramxwc, paramBoolean);
    paramBoolean = a(paramxwc, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new xxh(this));
    paramxwc = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramxwc.setLoadMoreComplete("StoryDetailFragment", true, paramBoolean);
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
    this.jdField_a_of_type_Xxi.J_();
  }
  
  public void e()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(i, 0);
    ykq.b("Q.qqstory.detail.StoryDetailFragment", "scoll to last comment. position is %d.", Integer.valueOf(i));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Yck.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a(getActivity());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.j();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setRequestDataListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new xxg(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setLoadMoreComplete("StoryDetailFragment", true, false);
    this.jdField_a_of_type_Xxi = new xxi(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.d);
    this.jdField_a_of_type_Xxi.e();
    if (this.c != 0) {
      this.jdField_a_of_type_Xxi.c(2);
    }
    this.jdField_a_of_type_Xxi.a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setCallback(this.jdField_a_of_type_Xxi);
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
          localObject1 = (wjg)wjs.a(18);
          if ((((wjg)localObject1).jdField_a_of_type_Boolean) && (((wjg)localObject1).jdField_a_of_type_JavaUtilMap != null))
          {
            Iterator localIterator = ((wjg)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              Object localObject2 = (String)localIterator.next();
              localObject2 = (QQStoryBaseActivity)((WeakReference)((wjg)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject2)).get();
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
      if (this.jdField_a_of_type_Xwr != null)
      {
        xve.a(this.jdField_a_of_type_Xwr.a, paramIntent);
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
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561650, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131365119));
    if (QQStoryContext.a())
    {
      ((InputLinearLayout)paramViewGroup.findViewById(2131376538)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166510));
      ((LinearLayout)paramViewGroup.findViewById(2131363725)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166509));
      ((XEditTextEx)paramViewGroup.findViewById(2131366264)).setHintTextColor(paramLayoutInflater.getContext().getResources().getColor(2131166511));
      paramViewGroup.findViewById(2131365759).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166510));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370478));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView = ((StoryDetailListView)paramViewGroup.findViewById(2131365563));
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
    if (this.jdField_a_of_type_Xxi != null)
    {
      this.jdField_a_of_type_Xxi.g();
      this.jdField_a_of_type_Xxi = null;
    }
    if (this.jdField_a_of_type_Xwr != null) {
      this.jdField_a_of_type_Xwr.e();
    }
    if (this.jdField_a_of_type_Yck != null) {
      this.jdField_a_of_type_Yck.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    }
    ykv.a("home_page-comment_suc-d1", null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Xwr == null) {}
    while (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b()) {
      return;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b();
    paramAdapterView = ((xyb)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramAdapterView == null)
    {
      ykq.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramAdapterView.type == 1)
    {
      this.jdField_a_of_type_Xxi.J_();
      return;
    }
    this.jdField_a_of_type_Xwr.a(paramAdapterView, paramInt, this.jdField_a_of_type_Xxi.a());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Xwr == null) {
      return false;
    }
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b()) {
      return false;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b();
    paramView = ((xyb)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      ykq.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    if ((this.jdField_a_of_type_Xwc != null) && (this.jdField_a_of_type_Xwc.a != null)) {
      if (!this.jdField_a_of_type_Xwc.a.getOwner().isMe()) {
        break label160;
      }
    }
    label160:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      ykv.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, ykv.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Xxi.J_();
      return true;
    }
    this.jdField_a_of_type_Xwr.b(paramView, paramInt, this.jdField_a_of_type_Xxi.a());
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
    ykv.a("home_page-comment_suc-d1", str);
    this.jdField_a_of_type_Xxi.h();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.o();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Xwr != null) && (this.jdField_a_of_type_Xwr.a()))
    {
      int i;
      if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_a_of_type_Xwr.c();
        if (this.jdField_a_of_type_Xwc != null)
        {
          paramMotionEvent = who.a().jdField_a_of_type_JavaLangString;
          i = ykv.a(this.jdField_a_of_type_Xwc.a);
          if (!this.jdField_a_of_type_Xwc.a.getOwner().isMe()) {
            break label136;
          }
        }
      }
      label136:
      for (paramView = "1";; paramView = "2")
      {
        ykv.a("home_page", "cancel_reply", i, 0, new String[] { paramView, ykv.a(this.jdField_a_of_type_Int), paramMotionEvent, this.jdField_a_of_type_JavaLangString });
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.detail.StoryDetailFragment", 2, "touch list while keyboard is showing, so hide the keyboard");
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment
 * JD-Core Version:    0.7.0.1
 */