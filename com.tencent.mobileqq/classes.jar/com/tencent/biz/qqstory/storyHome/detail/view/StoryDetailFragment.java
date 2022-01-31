package com.tencent.biz.qqstory.storyHome.detail.view;

import alpo;
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
import bhqp;
import bhqq;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import ume;
import upm;
import urf;
import urr;
import usv;
import wdd;
import wdj;
import weh;
import wew;
import wfl;
import wfm;
import wfn;
import wgf;
import wgg;
import wgk;
import wgn;
import wgr;
import wgs;
import wgw;
import wgy;
import wkp;
import wsv;
import wta;
import xod;

public class StoryDetailFragment
  extends Fragment
  implements View.OnTouchListener, bhqp, bhqq, wdd
{
  private int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public StoryDetailListView a;
  private String jdField_a_of_type_JavaLangString;
  private weh jdField_a_of_type_Weh;
  public wew a;
  private wfn jdField_a_of_type_Wfn;
  public wkp a;
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
    if (ume.a())
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
      localIntent.putExtra("selfSet_leftViewText", getActivity().getString(2131690623));
    }
    startActivity(localIntent);
  }
  
  public String a(String paramString)
  {
    paramString = xod.a(paramString);
    return paramString[1] + alpo.a(2131714786) + paramString[2] + alpo.a(2131714785);
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Wkp.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Wfn.a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b() + paramInt, 0);
    wsv.b("Q.qqstory.detail.StoryDetailFragment", "scoll to the comment. position is %d.", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b() + paramInt));
  }
  
  public void a(weh paramweh, boolean paramBoolean)
  {
    wsv.b("Q.qqstory.detail.StoryDetailFragment", "update feed all info. %s.", paramweh.toString());
    this.jdField_a_of_type_Weh = paramweh;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (getActivity() != null) {
      getActivity().setTitle(a(paramweh.a.date));
    }
    if (this.jdField_a_of_type_Wew == null) {
      this.jdField_a_of_type_Wew = new wew(getActivity(), getView(), paramweh, true, this.jdField_a_of_type_Int, this.jdField_a_of_type_Wfn);
    }
    Object localObject = (wgw)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("GeneralFeedProfileSegment");
    ((wgw)localObject).a(paramweh);
    ((wgw)localObject).a(this.jdField_b_of_type_JavaLangString);
    ((wgw)localObject).e_(true);
    localObject = (wgy)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("ShareGroupFeedProfileSegment");
    ((wgy)localObject).a(paramweh);
    ((wgy)localObject).a(this.jdField_b_of_type_JavaLangString);
    ((wgy)localObject).e_(true);
    localObject = (wgf)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("BannerProfileSegment");
    ((wgf)localObject).a(paramweh);
    ((wgf)localObject).e_(true);
    ((wgn)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailInteractSegment")).a(paramweh, this.jdField_a_of_type_Int, this.d);
    ((wgk)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).a(paramweh, paramBoolean);
    ((wgr)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).a(paramweh, paramBoolean);
    ((wgg)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramweh, paramBoolean);
    ((wgs)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailTagListSegment")).a(paramweh);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
    localObject = paramweh.a(paramBoolean);
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
          wta.a("home_page", "auto_reply", wta.a(paramweh.a), 0, new String[0]);
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
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Wew == null) {
      return false;
    }
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b()) {
      return false;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b();
    paramView = ((wgg)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      wsv.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    if ((this.jdField_a_of_type_Weh != null) && (this.jdField_a_of_type_Weh.a != null)) {
      if (!this.jdField_a_of_type_Weh.a.getOwner().isMe()) {
        break label160;
      }
    }
    label160:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      wta.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, wta.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Wfn.T_();
      return true;
    }
    this.jdField_a_of_type_Wew.b(paramView, paramInt, this.jdField_a_of_type_Wfn.a());
    return true;
  }
  
  public boolean a(weh paramweh, boolean paramBoolean)
  {
    return (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a()) || (paramweh == null) || (paramweh.a(paramBoolean)) || (paramweh.a(paramBoolean) != null);
  }
  
  public void b()
  {
    wsv.c("Q.qqstory.detail.StoryDetailFragment", "show empty page.");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setProfileSegmentDisplay(false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
  }
  
  public void b(weh paramweh, boolean paramBoolean)
  {
    ((wgk)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).a(paramweh, paramBoolean);
    ((wgr)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).a(paramweh, paramBoolean);
    ((wgg)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramweh, paramBoolean);
    paramBoolean = a(paramweh, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new wfm(this));
    paramweh = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramweh.setLoadMoreComplete("StoryDetailFragment", true, paramBoolean);
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
    this.jdField_a_of_type_Wfn.T_();
  }
  
  public void e()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(i, 0);
    wsv.b("Q.qqstory.detail.StoryDetailFragment", "scoll to last comment. position is %d.", Integer.valueOf(i));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Wkp.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a(getActivity());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.j();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setRequestDataListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new wfl(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setLoadMoreComplete("StoryDetailFragment", true, false);
    this.jdField_a_of_type_Wfn = new wfn(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.d);
    this.jdField_a_of_type_Wfn.e();
    if (this.c != 0) {
      this.jdField_a_of_type_Wfn.c(2);
    }
    this.jdField_a_of_type_Wfn.a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setCallback(this.jdField_a_of_type_Wfn);
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
          localObject1 = (urf)urr.a(18);
          if ((((urf)localObject1).jdField_a_of_type_Boolean) && (((urf)localObject1).jdField_a_of_type_JavaUtilMap != null))
          {
            Iterator localIterator = ((urf)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              Object localObject2 = (String)localIterator.next();
              localObject2 = (QQStoryBaseActivity)((WeakReference)((urf)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject2)).get();
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
      if (this.jdField_a_of_type_Wew != null)
      {
        wdj.a(this.jdField_a_of_type_Wew.a, paramIntent);
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
    this.jdField_a_of_type_Wkp = ((wkp)urr.a(11));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561407, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364735));
    if (QQStoryContext.a())
    {
      ((InputLinearLayout)paramViewGroup.findViewById(2131375609)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166397));
      ((LinearLayout)paramViewGroup.findViewById(2131363406)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166396));
      ((XEditTextEx)paramViewGroup.findViewById(2131365835)).setHintTextColor(paramLayoutInflater.getContext().getResources().getColor(2131166398));
      paramViewGroup.findViewById(2131365353).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166397));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369774));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView = ((StoryDetailListView)paramViewGroup.findViewById(2131365151));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.jdField_b_of_type_Int = 0;
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
    if (this.jdField_a_of_type_Wfn != null)
    {
      this.jdField_a_of_type_Wfn.g();
      this.jdField_a_of_type_Wfn = null;
    }
    if (this.jdField_a_of_type_Wew != null) {
      this.jdField_a_of_type_Wew.e();
    }
    if (this.jdField_a_of_type_Wkp != null) {
      this.jdField_a_of_type_Wkp.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    }
    wta.a("home_page-comment_suc-d1", null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Wew == null) {}
    while (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b()) {
      return;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b();
    paramAdapterView = ((wgg)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramAdapterView == null)
    {
      wsv.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramAdapterView.type == 1)
    {
      this.jdField_a_of_type_Wfn.T_();
      return;
    }
    this.jdField_a_of_type_Wew.a(paramAdapterView, paramInt, this.jdField_a_of_type_Wfn.a());
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
    wta.a("home_page-comment_suc-d1", str);
    this.jdField_a_of_type_Wfn.h();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.o();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Wew != null) && (this.jdField_a_of_type_Wew.a()))
    {
      int i;
      if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_a_of_type_Wew.c();
        if (this.jdField_a_of_type_Weh != null)
        {
          paramMotionEvent = upm.a().jdField_a_of_type_JavaLangString;
          i = wta.a(this.jdField_a_of_type_Weh.a);
          if (!this.jdField_a_of_type_Weh.a.getOwner().isMe()) {
            break label136;
          }
        }
      }
      label136:
      for (paramView = "1";; paramView = "2")
      {
        wta.a("home_page", "cancel_reply", i, 0, new String[] { paramView, wta.a(this.jdField_a_of_type_Int), paramMotionEvent, this.jdField_a_of_type_JavaLangString });
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.detail.StoryDetailFragment", 2, "touch list while keyboard is showing, so hide the keyboard");
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment
 * JD-Core Version:    0.7.0.1
 */