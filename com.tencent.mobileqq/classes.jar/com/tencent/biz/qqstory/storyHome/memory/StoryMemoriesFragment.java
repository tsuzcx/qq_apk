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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ActionSheet;
import mqq.os.MqqHandler;

public class StoryMemoriesFragment
  extends ReportV4Fragment
  implements View.OnClickListener, IMyStoryListView
{
  public static final String a;
  public static final String b;
  public static final String c = HardCodeUtil.a(2131714366);
  public static final String d = HardCodeUtil.a(2131714379);
  public static final String e = HardCodeUtil.a(2131714378);
  public static final String f = HardCodeUtil.a(2131714371);
  public static final String g = HardCodeUtil.a(2131714377);
  public static final String h = HardCodeUtil.a(2131714370);
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StoryInputBarView jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  private StoryShare jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
  private QQStoryMemoriesPresenter jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter;
  public StoryMemoriesListView a;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714367);
    jdField_b_of_type_JavaLangString = QQStoryConstant.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131714373);
  }
  
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
    if (TextUtils.equals(paramString, jdField_a_of_type_JavaLangString)) {
      return 1;
    }
    if ((TextUtils.equals(paramString, jdField_b_of_type_JavaLangString)) || (TextUtils.equals(paramString, c))) {
      return 2;
    }
    if ((TextUtils.equals(paramString, d)) || (TextUtils.equals(paramString, e))) {
      return 3;
    }
    if (TextUtils.equals(paramString, f)) {
      return 4;
    }
    if (TextUtils.equals(paramString, g)) {
      return 5;
    }
    if (TextUtils.equals(paramString, getString(2131690800))) {
      return 7;
    }
    if (TextUtils.equals(paramString, h)) {
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
  
  private void i()
  {
    ActionSheet localActionSheet = ActionSheet.create(getActivity());
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
    {
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(jdField_a_of_type_JavaLangString, 5);
      localActionSheet.addButton(jdField_b_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new StoryMemoriesFragment.2(this, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      return;
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend()) {
        break;
      }
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(f, 5);
      localActionSheet.addButton(c, 5);
      localActionSheet.addButton(g, 5);
    }
    if (StoryProfileUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem)) {
      localActionSheet.addButton(d, 5);
    }
    for (;;)
    {
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(g, 5);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe()) {
        localActionSheet.addButton(e, 5);
      }
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(getActivity(), StoryMessageListActivity.class);
    localIntent.putExtra("qqstory_message_list_source", 1);
    localIntent.putExtra("qqstory_jump_source", "3");
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131714372));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131714364));
    startActivity(localIntent);
  }
  
  private void k()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryShieldActivity.class);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq));
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131714362));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131714361));
    startActivity(localIntent);
  }
  
  private void l()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryFriendSettings.class);
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131714374));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131714376));
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
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.sourceTagType == 1))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      b();
      StoryReportor.a("weishi_share", "person_data_exp", 0, 0, new String[] { "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid });
      ReportController.b(null, "dc00898", "", "", "weishi_share_prof", "story_entry_exp", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(QQUserUIItem paramQQUserUIItem)
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
      getActivity().overridePendingTransition(2130772253, 2130772045);
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
      paramString.putExtra("extra_now_tab", StoryApi.a());
      paramString.putExtra("start_origin", 3);
      paramString.putExtra("start_time", l);
      startActivityForResult(paramString, 1200);
      if (!paramBoolean2) {
        break label211;
      }
      getActivity().overridePendingTransition(2130772253, 2130772045);
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
    return getActivity().isResume();
  }
  
  public void b()
  {
    boolean bool = WeishiGuideUtils.a(getActivity());
    if (bool != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = bool;
      String str = HardCodeUtil.a(2131714369);
      if (bool) {
        str = HardCodeUtil.a(2131714368);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getVisibility() == 0))
    {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.clearFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setVisibility(8);
      d();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    MemoriesProfileSegment localMemoriesProfileSegment = (MemoriesProfileSegment)a("MemoriesProfileSegment");
    if (localMemoriesProfileSegment != null) {
      localMemoriesProfileSegment.a(true);
    }
  }
  
  public boolean c()
  {
    return VideoEnvironment.checkAndLoadAVCodec();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(null);
  }
  
  public void e()
  {
    if (getActivity() == null)
    {
      SLog.e("Q.qqstory.memories.StoryMemoriesFragment", "update title bar failed because activity is null.");
      return;
    }
    ImageView localImageView = (ImageView)getActivity().findViewById(2131369501);
    TextView localTextView1 = (TextView)getActivity().findViewById(2131369518);
    TextView localTextView2 = (TextView)getActivity().findViewById(2131369534);
    localTextView1.setGravity(16);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int == 2)
    {
      localImageView.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(2131699254);
      localTextView1.setOnClickListener(this);
      return;
    }
    localTextView2.setText(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid));
    localTextView1.setVisibility(8);
    localImageView.setVisibility(0);
    localImageView.setContentDescription(HardCodeUtil.a(2131714380));
    localImageView.getLayoutParams().width = -2;
    localImageView.setPadding(0, 0, DisplayUtil.b(getActivity(), 5.0F), 0);
    localImageView.setOnClickListener(this);
  }
  
  protected void f()
  {
    Object localObject = new TranslucentTitleBarHelper(getActivity(), 155);
    ((TranslucentTitleBarHelper)localObject).a(this.jdField_a_of_type_AndroidViewView);
    ((TranslucentTitleBarHelper)localObject).a(false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setOnScrollListener(new StoryMemoriesFragment.4(this, (TranslucentTitleBarHelper)localObject));
    if (QQStoryContext.a().a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString)) {}
    for (localObject = new StoryProfileListViewConfig(getActivity(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString, StoryProfileListViewConfig.jdField_a_of_type_Int, this);; localObject = new StoryProfileListViewConfig(getActivity(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString, StoryProfileListViewConfig.b, this))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setConfig((StoryProfileListViewConfig)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.j();
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)
      {
        e();
        c();
        d();
      }
      return;
    }
  }
  
  public void g()
  {
    ThreadManager.getUIHandler().postDelayed(new StoryMemoriesFragment.3(this), 300L);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.a();
    if (StoryProfileUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString)) {
      f();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setContentBackground(2130839532);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int == 2) && (FrameHelperActivity.b()))
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.w();
    }
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      SLog.e("Q.qqstory.memories.StoryMemoriesFragment", "onActivityResult, data is null.");
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      switch (paramInt1)
      {
      default: 
        if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(paramInt1, paramInt2, paramIntent);
          return;
        }
        break;
      case 20001: 
        a(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
        return;
      case 1200: 
      case 1300: 
      case 20002: 
        paramIntent = paramIntent.getStringExtra("new_video_extra_info");
        Intent localIntent;
        if (StoryApi.a())
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
      case 20004: 
        AtVideoTextWatcher.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
        ThreadManager.getUIHandler().postDelayed(new StoryMemoriesFragment.1(this), 100L);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView == null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    int i = 4;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      if (this.jdField_b_of_type_Boolean)
      {
        WeishiGuideUtils.a(getActivity(), "biz_src_jc_hyws", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.wsScahema);
        label95:
        if (!this.jdField_b_of_type_Boolean) {
          break label207;
        }
        i = 2;
        label104:
        StoryReportor.a("weishi_share", "person_data_clk", 0, i, new String[] { "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid });
        if (!this.jdField_b_of_type_Boolean) {
          break label212;
        }
      }
      label207:
      label212:
      for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
      {
        ReportController.b(null, "dc00898", "", "", "weishi_share_prof", (String)localObject, 0, 0, "", "", "", "");
        break;
        QQToast.a(getActivity(), HardCodeUtil.a(2131714365), 0).a();
        WeishiGuideUtils.a(getActivity(), "biz_src_jc_hyws");
        break label95;
        i = 1;
        break label104;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int == 2) {}
      for (;;)
      {
        a(false, true, i, null);
        StoryReportor.a("memory", "clk_shoot", a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int), 0, new String[0]);
        break;
        i = 3;
      }
      if (StoryApi.a()) {}
      for (i = 1;; i = 0)
      {
        SLog.b("Q.qqstory.memories.StoryMemoriesFragment", "startStoryMainActivity, isNowTabShow==%d", Integer.valueOf(i));
        localObject = new Intent(getActivity(), QQStoryMainActivity.class);
        ((Intent)localObject).putExtra("from_memeories", true);
        ((Intent)localObject).putExtra("leftViewText", HardCodeUtil.a(2131714375));
        ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131714363));
        startActivity((Intent)localObject);
        StoryReportor.a("memory", "enter_story", a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int), 0, new String[] { "", "", "", "" });
        this.jdField_a_of_type_Boolean = true;
        break;
      }
      i();
      i = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
      for (localObject = "1";; localObject = "2")
      {
        StoryReportor.a("memory", "clk_more", i, 0, new String[] { localObject });
        break;
      }
      getActivity().finish();
    }
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561848, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView = ((StoryMemoriesListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371153));
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371152));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131371156));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379158));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364797);
    paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369487);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.l();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.b();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.d();
    this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(false);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.c();
    d();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.k();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.h();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.o();
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    int i = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int);
    int j = StoryApi.a(2131427362);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment
 * JD-Core Version:    0.7.0.1
 */