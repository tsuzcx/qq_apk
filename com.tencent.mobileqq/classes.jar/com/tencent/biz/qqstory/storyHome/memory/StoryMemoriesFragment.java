package com.tencent.biz.qqstory.storyHome.memory;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;
import com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileListViewConfig;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesProfileSegment;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import mqq.os.MqqHandler;
import nwm;
import nwn;
import nwq;
import nwr;

public class StoryMemoriesFragment
  extends Fragment
  implements View.OnClickListener, IMyStoryListView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StoryInputBarView jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  private StoryShare jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
  private QQStoryMemoriesPresenter jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter;
  public StoryMemoriesListView a;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 1000: 
      return 1;
    case 1002: 
      return 4;
    }
    return 3;
  }
  
  private int a(String paramString)
  {
    if (TextUtils.equals(paramString, "消息列表")) {
      return 1;
    }
    if ((TextUtils.equals(paramString, "日迹设置")) || (TextUtils.equals(paramString, "屏蔽"))) {
      return 2;
    }
    if ((TextUtils.equals(paramString, "关注")) || (TextUtils.equals(paramString, "取消关注"))) {
      return 3;
    }
    if (TextUtils.equals(paramString, "更多资料")) {
      return 4;
    }
    if (TextUtils.equals(paramString, "举报")) {
      return 5;
    }
    if (TextUtils.equals(paramString, getString(2131433015))) {
      return 7;
    }
    if (TextUtils.equals(paramString, "分享")) {
      return 8;
    }
    throw new IllegalArgumentException("get action id with unidentifiable action content.");
  }
  
  public static StoryMemoriesFragment a(int paramInt, String paramString)
  {
    StoryMemoriesFragment localStoryMemoriesFragment = new StoryMemoriesFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("union_id", paramString);
    localBundle.putInt("source", paramInt);
    localStoryMemoriesFragment.setArguments(localBundle);
    return localStoryMemoriesFragment;
  }
  
  public static String a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt)
    {
    case 6: 
    case 7: 
    default: 
      return "";
    case 1: 
      return "1";
    case 2: 
      if (paramBoolean1) {
        return "2";
      }
      return "6";
    case 3: 
      if (paramBoolean2) {
        return "4";
      }
      return "3";
    case 4: 
      return "5";
    case 5: 
      return "7";
    }
    return "8";
  }
  
  private void f()
  {
    ActionSheet localActionSheet = ActionSheet.a(getActivity());
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
    {
      localActionSheet.a("分享", 5);
      localActionSheet.a("消息列表", 5);
      localActionSheet.a("日迹设置", 5);
    }
    for (;;)
    {
      localActionSheet.c(2131433015);
      localActionSheet.a(new nwn(this, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      return;
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend()) {
        break;
      }
      localActionSheet.a("分享", 5);
      localActionSheet.a("更多资料", 5);
      localActionSheet.a("屏蔽", 5);
      localActionSheet.a("举报", 5);
    }
    if (StoryProfileUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem)) {
      localActionSheet.a("关注", 5);
    }
    for (;;)
    {
      localActionSheet.a("分享", 5);
      localActionSheet.a("举报", 5);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe()) {
        localActionSheet.a("取消关注", 5);
      }
    }
  }
  
  private void g()
  {
    Intent localIntent = new Intent(getActivity(), StoryMessageListActivity.class);
    localIntent.putExtra("qqstory_message_list_source", 1);
    localIntent.putExtra("qqstory_jump_source", "3");
    localIntent.putExtra("leftViewText", "返回");
    localIntent.putExtra("selfSet_leftViewText", "返回");
    startActivity(localIntent);
  }
  
  private void h()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryShieldActivity.class);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq));
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", "返回");
    localIntent.putExtra("selfSet_leftViewText", "返回");
    startActivity(localIntent);
  }
  
  private void i()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryFriendSettings.class);
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", "返回");
    localIntent.putExtra("selfSet_leftViewText", "返回");
    startActivity(localIntent);
  }
  
  public StoryInputBarView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  }
  
  public SegmentView a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.a(paramString);
  }
  
  public void a()
  {
    boolean bool = WeishiGuideUtils.a(getActivity());
    if (bool != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = bool;
      String str = "下载微视看看";
      if (bool) {
        str = "打开微视看看";
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    Intent localIntent = new Intent(getActivity(), FriendProfileCardActivity.class);
    localIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramQQUserUIItem.qq, 59));
    startActivity(localIntent);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramString = StoryPublishLauncher.a();
    if (paramString.a())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("entrance_type", paramInt);
      paramString.a(getActivity(), localBundle, 1200);
      getActivity().overridePendingTransition(2131034327, 2131034167);
      return;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (c()))
    {
      bool = true;
      paramString = new QQStoryTakeVideoActivityLauncher(PlayModeUtils.a()).a(getActivity(), paramBoolean1, bool);
      paramString.putExtra("entrance_type", paramInt);
      if (!bool) {
        break label223;
      }
      paramString.putExtra("extra_memories_from", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int);
      paramString.putExtra("extra_now_tab", StoryApi.b());
      paramString.putExtra("start_origin", 3);
      paramString.putExtra("start_time", l);
      startActivityForResult(paramString, 1200);
      if (!paramBoolean2) {
        break label211;
      }
      getActivity().overridePendingTransition(2131034327, 2131034167);
    }
    for (;;)
    {
      SLog.b("Q.qqstory.memories.StoryMemoriesFragment", "launchNewVideoTakeActivity end");
      this.jdField_a_of_type_Boolean = true;
      return;
      bool = false;
      break;
      label211:
      getActivity().overridePendingTransition(0, 0);
    }
    label223:
    startActivityForResult(paramString, 20001);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getVisibility() == 0))
    {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.clearFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setVisibility(8);
      c();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    MemoriesProfileSegment localMemoriesProfileSegment = (MemoriesProfileSegment)a("MemoriesProfileSegment");
    if (localMemoriesProfileSegment != null) {
      localMemoriesProfileSegment.a(true);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return getActivity().isResume();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()))
    {
      this.c.setVisibility(0);
      this.c.setOnClickListener(this);
      return;
    }
    this.c.setVisibility(8);
    this.c.setOnClickListener(null);
  }
  
  public boolean c()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(PlayModeUtils.a());
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public void d()
  {
    if (getActivity() == null)
    {
      SLog.e("Q.qqstory.memories.StoryMemoriesFragment", "update title bar failed because activity is null.");
      return;
    }
    ImageView localImageView = (ImageView)getActivity().findViewById(2131363474);
    TextView localTextView1 = (TextView)getActivity().findViewById(2131363428);
    TextView localTextView2 = (TextView)getActivity().findViewById(2131363381);
    localTextView1.setGravity(16);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int == 2)
    {
      localImageView.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(2131438712);
      localTextView1.setOnClickListener(this);
      return;
    }
    localTextView2.setText(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid));
    localTextView1.setVisibility(8);
    localImageView.setVisibility(0);
    localImageView.setContentDescription("更多");
    localImageView.getLayoutParams().width = -2;
    localImageView.setPadding(0, 0, DisplayUtil.a(getActivity(), 5.0F), 0);
    localImageView.setOnClickListener(this);
  }
  
  protected void e()
  {
    Object localObject = new TranslucentTitleBarHelper(getActivity(), 155);
    ((TranslucentTitleBarHelper)localObject).a(this.jdField_a_of_type_AndroidViewView);
    ((TranslucentTitleBarHelper)localObject).a(false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setOnScrollListener(new nwr(this, (TranslucentTitleBarHelper)localObject));
    if (QQStoryContext.a().a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString)) {}
    for (localObject = new StoryProfileListViewConfig(getActivity(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString, StoryProfileListViewConfig.jdField_a_of_type_Int, this);; localObject = new StoryProfileListViewConfig(getActivity(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString, StoryProfileListViewConfig.b, this))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setConfig((StoryProfileListViewConfig)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.k();
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)
      {
        d();
        b();
        c();
      }
      return;
    }
  }
  
  public void j()
  {
    ThreadManager.getUIHandler().postDelayed(new nwq(this), 300L);
  }
  
  public void k()
  {
    this.c.setVisibility(8);
  }
  
  public void l() {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.a();
    if (StoryProfileUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString)) {
      e();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setContentBackground(2130838583);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int == 2) && (FrameHelperActivity.a()))
    {
      FrameHelperActivity.b(true);
      FrameHelperActivity.o();
    }
    paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    if ((paramBundle != null) && (paramBundle.isVip()) && (!paramBundle.isMe()) && (!paramBundle.isFriend()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      a();
      StoryReportor.a("weishi_share", "person_data_exp", 0, 0, new String[] { "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid });
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
        if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(paramInt1, paramInt2, paramIntent);
        }
        break;
      }
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView == null)
    {
      return;
      a(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
      return;
      paramIntent = paramIntent.getStringExtra("new_video_extra_info");
      Intent localIntent;
      if (StoryApi.b())
      {
        localIntent = new Intent(getActivity(), SplashActivity.class);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("main_tab_id", 6);
        localIntent.putExtra("open_now_tab_fragment", true);
        localIntent.putExtra("extra_from_share", true);
        localIntent.putExtra("new_video_extra_info", paramIntent);
        localIntent.setFlags(335544320);
        startActivity(localIntent);
      }
      for (;;)
      {
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
        return;
        localIntent = new Intent(getActivity(), QQStoryMainActivity.class);
        localIntent.putExtra("new_video_extra_info", paramIntent);
        startActivity(localIntent);
      }
      AtVideoTextWatcher.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
      ThreadManager.getUIHandler().postDelayed(new nwm(this), 100L);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    int i = 4;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371877: 
      a();
      if (this.jdField_b_of_type_Boolean)
      {
        WeishiGuideUtils.a(getActivity(), 4, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.wsScahema);
        if (!this.jdField_b_of_type_Boolean) {
          break label154;
        }
      }
      for (i = 2;; i = 1)
      {
        StoryReportor.a("weishi_share", "person_data_clk", 0, i, new String[] { "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid });
        return;
        QQToast.a(getActivity(), "正在下载，请稍候。", 0).a();
        WeishiGuideUtils.a(getActivity());
        break;
      }
    case 2131371875: 
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int == 2) {}
      for (;;)
      {
        a(false, true, i, null);
        StoryReportor.a("memory", "clk_shoot", a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int), 0, new String[0]);
        return;
        i = 3;
      }
    case 2131363428: 
      if (StoryApi.b()) {}
      for (i = 1;; i = 0)
      {
        SLog.b("Q.qqstory.memories.StoryMemoriesFragment", "startStoryMainActivity, isNowTabShow==%d", Integer.valueOf(i));
        paramView = new Intent(getActivity(), QQStoryMainActivity.class);
        paramView.putExtra("from_memeories", true);
        paramView.putExtra("leftViewText", "返回");
        paramView.putExtra("selfSet_leftViewText", "返回");
        startActivity(paramView);
        StoryReportor.a("memory", "enter_story", a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int), 0, new String[] { "", "", "", "" });
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    case 2131363474: 
      label154:
      f();
      i = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        StoryReportor.a("memory", "clk_more", i, 0, new String[] { paramView });
        return;
      }
    }
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter = new QQStoryMemoriesPresenter(paramBundle.getInt("source", 1), paramBundle.getString("union_id"), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130970767, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView = ((StoryMemoriesListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371874));
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371876));
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131371875);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370766));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371877);
    paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363245);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.m();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.b();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.d();
    this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(false);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.c();
    c();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.l();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.i();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.p();
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    int i = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int);
    int j = StoryApi.a(2131689488);
    String str;
    if ((localObject != null) && (((QQUserUIItem)localObject).isMe()))
    {
      str = "1";
      if ((localObject == null) || (!((QQUserUIItem)localObject).isVip())) {
        break label138;
      }
    }
    label138:
    for (localObject = "1";; localObject = "2")
    {
      StoryReportor.a("memory", "exp", i, j, new String[] { str, localObject, "", "" });
      return;
      str = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment
 * JD-Core Version:    0.7.0.1
 */