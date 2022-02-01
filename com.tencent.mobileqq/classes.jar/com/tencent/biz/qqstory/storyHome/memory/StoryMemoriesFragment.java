package com.tencent.biz.qqstory.storyHome.memory;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
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
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import mqq.os.MqqHandler;

public class StoryMemoriesFragment
  extends BaseFragment
  implements View.OnClickListener, IMyStoryListView
{
  public static final String a;
  public static final String b;
  public static final String c = HardCodeUtil.a(2131714287);
  public static final String d = HardCodeUtil.a(2131714300);
  public static final String e = HardCodeUtil.a(2131714299);
  public static final String f = HardCodeUtil.a(2131714292);
  public static final String g = HardCodeUtil.a(2131714298);
  public static final String h = HardCodeUtil.a(2131714291);
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714288);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(HardCodeUtil.a(2131714294));
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 1002: 
      return 4;
    case 1001: 
      return 3;
    }
    return 1;
  }
  
  private int a(String paramString)
  {
    if (TextUtils.equals(paramString, jdField_a_of_type_JavaLangString)) {
      return 1;
    }
    if ((!TextUtils.equals(paramString, jdField_b_of_type_JavaLangString)) && (!TextUtils.equals(paramString, c)))
    {
      if ((!TextUtils.equals(paramString, d)) && (!TextUtils.equals(paramString, e)))
      {
        if (TextUtils.equals(paramString, f)) {
          return 4;
        }
        if (TextUtils.equals(paramString, g)) {
          return 5;
        }
        if (TextUtils.equals(paramString, getString(2131690728))) {
          return 7;
        }
        if (TextUtils.equals(paramString, h)) {
          return 8;
        }
        throw new IllegalArgumentException("get action id with unidentifiable action content.");
      }
      return 3;
    }
    return 2;
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 8) {
                return "";
              }
              return "8";
            }
            return "7";
          }
          return "5";
        }
        if (paramBoolean2) {
          return "4";
        }
        return "3";
      }
      if (paramBoolean1) {
        return "2";
      }
      return "6";
    }
    return "1";
  }
  
  private void i()
  {
    ActionSheet localActionSheet = ActionSheet.create(getBaseActivity());
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
    {
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(jdField_a_of_type_JavaLangString, 5);
      localActionSheet.addButton(jdField_b_of_type_JavaLangString, 5);
    }
    else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend())
    {
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(f, 5);
      localActionSheet.addButton(c, 5);
      localActionSheet.addButton(g, 5);
    }
    else
    {
      if (StoryProfileUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem)) {
        localActionSheet.addButton(d, 5);
      } else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe()) {
        localActionSheet.addButton(e, 5);
      }
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(g, 5);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new StoryMemoriesFragment.2(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(getBaseActivity(), StoryMessageListActivity.class);
    localIntent.putExtra("qqstory_message_list_source", 1);
    localIntent.putExtra("qqstory_jump_source", "3");
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131714293));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131714285));
    startActivity(localIntent);
  }
  
  private void k()
  {
    Intent localIntent = new Intent(getBaseActivity(), QQStoryShieldActivity.class);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq));
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131714283));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131714282));
    startActivity(localIntent);
  }
  
  private void l()
  {
    Intent localIntent = new Intent(getBaseActivity(), QQStoryFriendSettings.class);
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131714295));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131714297));
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
    paramQQUserUIItem = new AllInOne(paramQQUserUIItem.qq, 59);
    ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).openProfileCard(getActivity(), paramQQUserUIItem);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramString = StoryPublishLauncher.a();
    if (paramString.a())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("entrance_type", paramInt);
      paramString.a(getBaseActivity(), localBundle, 1200);
      getBaseActivity().overridePendingTransition(2130772281, 2130772067);
      return;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((paramBoolean2) && (!c())) {
      bool = false;
    } else {
      bool = true;
    }
    paramString = new QQStoryTakeVideoActivityLauncher(PlayModeUtils.a()).a(getBaseActivity(), paramBoolean1, bool);
    paramString.putExtra("entrance_type", paramInt);
    if (bool)
    {
      paramString.putExtra("extra_memories_from", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int);
      paramString.putExtra("extra_now_tab", StoryApi.a());
      paramString.putExtra("start_origin", 3);
      paramString.putExtra("start_time", l);
      startActivityForResult(paramString, 1200);
      if (paramBoolean2) {
        getBaseActivity().overridePendingTransition(2130772281, 2130772067);
      } else {
        getBaseActivity().overridePendingTransition(0, 0);
      }
      SLog.b("Q.qqstory.memories.StoryMemoriesFragment", "launchNewVideoTakeActivity end");
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    startActivityForResult(paramString, 20001);
  }
  
  public boolean a()
  {
    return getBaseActivity().isResume();
  }
  
  public void b()
  {
    boolean bool = WeishiGuideUtils.a(getBaseActivity());
    if (bool != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = bool;
      String str = HardCodeUtil.a(2131714290);
      if (bool) {
        str = HardCodeUtil.a(2131714289);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    StoryInputBarView localStoryInputBarView = this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
    if ((localStoryInputBarView != null) && (localStoryInputBarView.getVisibility() == 0))
    {
      ((InputMethodManager)getBaseActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getWindowToken(), 0);
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
    if (getBaseActivity() == null)
    {
      SLog.e("Q.qqstory.memories.StoryMemoriesFragment", "update title bar failed because activity is null.");
      return;
    }
    ImageView localImageView = (ImageView)getBaseActivity().findViewById(2131369216);
    TextView localTextView1 = (TextView)getBaseActivity().findViewById(2131369233);
    TextView localTextView2 = (TextView)getBaseActivity().findViewById(2131369249);
    localTextView1.setGravity(16);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int == 2)
    {
      localImageView.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(2131699359);
      localTextView1.setOnClickListener(this);
      return;
    }
    localTextView2.setText(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid));
    localTextView1.setVisibility(8);
    localImageView.setVisibility(0);
    localImageView.setContentDescription(HardCodeUtil.a(2131714301));
    localImageView.getLayoutParams().width = -2;
    localImageView.setPadding(0, 0, DisplayUtil.a(getBaseActivity(), 5.0F), 0);
    localImageView.setOnClickListener(this);
  }
  
  protected void f()
  {
    Object localObject = new TranslucentTitleBarHelper(getBaseActivity(), 155);
    ((TranslucentTitleBarHelper)localObject).a(this.jdField_a_of_type_AndroidViewView);
    ((TranslucentTitleBarHelper)localObject).a(false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setOnScrollListener(new StoryMemoriesFragment.4(this, (TranslucentTitleBarHelper)localObject));
    if (QQStoryContext.a().a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString)) {
      localObject = new StoryProfileListViewConfig(getBaseActivity(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString, StoryProfileListViewConfig.jdField_a_of_type_Int, this);
    } else {
      localObject = new StoryProfileListViewConfig(getBaseActivity(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_JavaLangString, StoryProfileListViewConfig.b, this);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setConfig((StoryProfileListViewConfig)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.j();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)
    {
      e();
      c();
      d();
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
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setContentBackground(2130839388);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int == 2) && (FrameHelperActivity.b()))
    {
      FrameHelperActivity.b(true);
      FrameHelperActivity.w();
    }
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      SLog.e("Q.qqstory.memories.StoryMemoriesFragment", "onActivityResult, data is null.");
      return;
    }
    if (paramInt2 == -1)
    {
      Object localObject;
      if ((paramInt1 != 1200) && (paramInt1 != 1300)) {
        if (paramInt1 != 20004)
        {
          if (paramInt1 != 20001)
          {
            if (paramInt1 != 20002)
            {
              localObject = this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
              if (localObject != null)
              {
                ((StoryShare)localObject).a(paramInt1, paramInt2, paramIntent);
                return;
              }
              localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView;
              if (localObject == null) {
                return;
              }
              ((StoryMemoriesListView)localObject).a(paramInt1, paramInt2, paramIntent);
            }
          }
          else {
            a(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
          }
        }
        else
        {
          AtVideoTextWatcher.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
          ThreadManager.getUIHandler().postDelayed(new StoryMemoriesFragment.1(this), 100L);
          return;
        }
      }
      paramIntent = paramIntent.getStringExtra("new_video_extra_info");
      if (StoryApi.a())
      {
        localObject = new Intent(getBaseActivity(), SplashActivity.class);
        ((Intent)localObject).putExtra("fragment_id", 1);
        ((Intent)localObject).putExtra("main_tab_id", 6);
        ((Intent)localObject).putExtra("open_now_tab_fragment", true);
        ((Intent)localObject).putExtra("extra_from_share", true);
        ((Intent)localObject).putExtra("new_video_extra_info", paramIntent);
        ((Intent)localObject).setFlags(335544320);
        startActivity((Intent)localObject);
      }
      else
      {
        localObject = new Intent(getBaseActivity(), QQStoryMainActivity.class);
        ((Intent)localObject).putExtra("new_video_extra_info", paramIntent);
        startActivity((Intent)localObject);
      }
      getBaseActivity().finish();
      getBaseActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void onClick(View paramView)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561699, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView = ((StoryMemoriesListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370777));
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370776));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131370780));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378521));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364685);
    paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369202);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    StoryMemoriesListView localStoryMemoriesListView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView;
    if (localStoryMemoriesListView != null) {
      localStoryMemoriesListView.l();
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
    StoryMemoriesListView localStoryMemoriesListView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView;
    if (localStoryMemoriesListView != null) {
      localStoryMemoriesListView.k();
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
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView;
    if (localObject != null) {
      ((StoryMemoriesListView)localObject).o();
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    int i = a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerQQStoryMemoriesPresenter.jdField_a_of_type_Int);
    int j = StoryApi.a(2131427366);
    String str = "1";
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isMe())) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
      str = "2";
    }
    StoryReportor.a("memory", "exp", i, j, new String[] { localObject, str, "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment
 * JD-Core Version:    0.7.0.1
 */