package com.tencent.biz.qqstory.storyHome.detail.view;

import ajya;
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
import bfpt;
import bfpu;
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
import sxm;
import tau;
import tcn;
import tcz;
import ted;
import uol;
import uor;
import upp;
import uqe;
import uqt;
import uqu;
import uqv;
import urn;
import uro;
import urs;
import urv;
import urz;
import usa;
import use;
import usg;
import uvx;
import ved;
import vei;
import vzl;

public class StoryDetailFragment
  extends Fragment
  implements View.OnTouchListener, bfpt, bfpu, uol
{
  private int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public StoryDetailListView a;
  private String jdField_a_of_type_JavaLangString;
  private upp jdField_a_of_type_Upp;
  public uqe a;
  private uqv jdField_a_of_type_Uqv;
  public uvx a;
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
    if (sxm.a())
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
      localIntent.putExtra("selfSet_leftViewText", getActivity().getString(2131690572));
    }
    startActivity(localIntent);
  }
  
  public String a(String paramString)
  {
    paramString = vzl.a(paramString);
    return paramString[1] + ajya.a(2131714414) + paramString[2] + ajya.a(2131714413);
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Uvx.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Uqv.a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b() + paramInt, 0);
    ved.b("Q.qqstory.detail.StoryDetailFragment", "scoll to the comment. position is %d.", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b() + paramInt));
  }
  
  public void a(upp paramupp, boolean paramBoolean)
  {
    ved.b("Q.qqstory.detail.StoryDetailFragment", "update feed all info. %s.", paramupp.toString());
    this.jdField_a_of_type_Upp = paramupp;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (getActivity() != null) {
      getActivity().setTitle(a(paramupp.a.date));
    }
    if (this.jdField_a_of_type_Uqe == null) {
      this.jdField_a_of_type_Uqe = new uqe(getActivity(), getView(), paramupp, true, this.jdField_a_of_type_Int, this.jdField_a_of_type_Uqv);
    }
    Object localObject = (use)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("GeneralFeedProfileSegment");
    ((use)localObject).a(paramupp);
    ((use)localObject).a(this.jdField_b_of_type_JavaLangString);
    ((use)localObject).e_(true);
    localObject = (usg)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("ShareGroupFeedProfileSegment");
    ((usg)localObject).a(paramupp);
    ((usg)localObject).a(this.jdField_b_of_type_JavaLangString);
    ((usg)localObject).e_(true);
    localObject = (urn)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("BannerProfileSegment");
    ((urn)localObject).a(paramupp);
    ((urn)localObject).e_(true);
    ((urv)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailInteractSegment")).a(paramupp, this.jdField_a_of_type_Int, this.d);
    ((urs)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).a(paramupp, paramBoolean);
    ((urz)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).a(paramupp, paramBoolean);
    ((uro)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramupp, paramBoolean);
    ((usa)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailTagListSegment")).a(paramupp);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
    localObject = paramupp.a(paramBoolean);
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
          vei.a("home_page", "auto_reply", vei.a(paramupp.a), 0, new String[0]);
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
    if (this.jdField_a_of_type_Uqe == null) {
      return false;
    }
    if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b()) {
      return false;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b();
    paramView = ((uro)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      ved.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    if ((this.jdField_a_of_type_Upp != null) && (this.jdField_a_of_type_Upp.a != null)) {
      if (!this.jdField_a_of_type_Upp.a.getOwner().isMe()) {
        break label160;
      }
    }
    label160:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      vei.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, vei.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Uqv.L_();
      return true;
    }
    this.jdField_a_of_type_Uqe.b(paramView, paramInt, this.jdField_a_of_type_Uqv.a());
    return true;
  }
  
  public boolean a(upp paramupp, boolean paramBoolean)
  {
    return (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a()) || (paramupp == null) || (paramupp.a(paramBoolean)) || (paramupp.a(paramBoolean) != null);
  }
  
  public void b()
  {
    ved.c("Q.qqstory.detail.StoryDetailFragment", "show empty page.");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setProfileSegmentDisplay(false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.p();
  }
  
  public void b(upp paramupp, boolean paramBoolean)
  {
    ((urs)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailDoubleTabSegment")).a(paramupp, paramBoolean);
    ((urz)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailLikeListSegment")).a(paramupp, paramBoolean);
    ((uro)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramupp, paramBoolean);
    paramBoolean = a(paramupp, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new uqu(this));
    paramupp = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramupp.setLoadMoreComplete("StoryDetailFragment", true, paramBoolean);
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
    this.jdField_a_of_type_Uqv.L_();
  }
  
  public void e()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setSelectionFromBottom(i, 0);
    ved.b("Q.qqstory.detail.StoryDetailFragment", "scoll to last comment. position is %d.", Integer.valueOf(i));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Uvx.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a(getActivity());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.j();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setRequestDataListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setOnLoadMoreListener("StoryDetailFragment", new uqt(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setLoadMoreComplete("StoryDetailFragment", true, false);
    this.jdField_a_of_type_Uqv = new uqv(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.d);
    this.jdField_a_of_type_Uqv.e();
    if (this.c != 0) {
      this.jdField_a_of_type_Uqv.c(2);
    }
    this.jdField_a_of_type_Uqv.a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.setCallback(this.jdField_a_of_type_Uqv);
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
          localObject1 = (tcn)tcz.a(18);
          if ((((tcn)localObject1).jdField_a_of_type_Boolean) && (((tcn)localObject1).jdField_a_of_type_JavaUtilMap != null))
          {
            Iterator localIterator = ((tcn)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              Object localObject2 = (String)localIterator.next();
              localObject2 = (QQStoryBaseActivity)((WeakReference)((tcn)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject2)).get();
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
      if (this.jdField_a_of_type_Uqe != null)
      {
        uor.a(this.jdField_a_of_type_Uqe.a, paramIntent);
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
    this.jdField_a_of_type_Uvx = ((uvx)tcz.a(11));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561217, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364656));
    if (QQStoryContext.a())
    {
      ((InputLinearLayout)paramViewGroup.findViewById(2131375129)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166350));
      ((LinearLayout)paramViewGroup.findViewById(2131363367)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166349));
      ((XEditTextEx)paramViewGroup.findViewById(2131365749)).setHintTextColor(paramLayoutInflater.getContext().getResources().getColor(2131166351));
      paramViewGroup.findViewById(2131365268).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131166350));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369512));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView = ((StoryDetailListView)paramViewGroup.findViewById(2131365066));
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
    if (this.jdField_a_of_type_Uqv != null)
    {
      this.jdField_a_of_type_Uqv.g();
      this.jdField_a_of_type_Uqv = null;
    }
    if (this.jdField_a_of_type_Uqe != null) {
      this.jdField_a_of_type_Uqe.e();
    }
    if (this.jdField_a_of_type_Uvx != null) {
      this.jdField_a_of_type_Uvx.jdField_a_of_type_JavaUtilMap.remove("2_" + this.jdField_a_of_type_JavaLangString);
    }
    vei.a("home_page-comment_suc-d1", null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Uqe == null) {}
    while (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b()) {
      return;
    }
    paramInt -= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.b();
    paramAdapterView = ((uro)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("DetailCommentSegment")).a(paramInt);
    if (paramAdapterView == null)
    {
      ved.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramAdapterView.type == 1)
    {
      this.jdField_a_of_type_Uqv.L_();
      return;
    }
    this.jdField_a_of_type_Uqe.a(paramAdapterView, paramInt, this.jdField_a_of_type_Uqv.a());
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
    vei.a("home_page-comment_suc-d1", str);
    this.jdField_a_of_type_Uqv.h();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.o();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Uqe != null) && (this.jdField_a_of_type_Uqe.a()))
    {
      int i;
      if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_a_of_type_Uqe.c();
        if (this.jdField_a_of_type_Upp != null)
        {
          paramMotionEvent = tau.a().jdField_a_of_type_JavaLangString;
          i = vei.a(this.jdField_a_of_type_Upp.a);
          if (!this.jdField_a_of_type_Upp.a.getOwner().isMe()) {
            break label136;
          }
        }
      }
      label136:
      for (paramView = "1";; paramView = "2")
      {
        vei.a("home_page", "cancel_reply", i, 0, new String[] { paramView, vei.a(this.jdField_a_of_type_Int), paramMotionEvent, this.jdField_a_of_type_JavaLangString });
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.detail.StoryDetailFragment", 2, "touch list while keyboard is showing, so hide the keyboard");
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment
 * JD-Core Version:    0.7.0.1
 */