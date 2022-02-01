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
  public static final String a = HardCodeUtil.a(2131911807);
  public static final String b;
  public static final String c = HardCodeUtil.a(2131911806);
  public static final String d = HardCodeUtil.a(2131899712);
  public static final String e = HardCodeUtil.a(2131911814);
  public static final String f = HardCodeUtil.a(2131911811);
  public static final String g = HardCodeUtil.a(2131911813);
  public static final String h = HardCodeUtil.a(2131911810);
  public StoryMemoriesListView i;
  private QQStoryMemoriesPresenter j;
  private View k;
  private View l;
  private TextView m;
  private StoryInputBarView n;
  private ImageButton o;
  private StoryShare p;
  private boolean q = false;
  private boolean r = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.a);
    localStringBuilder.append(HardCodeUtil.a(2131911812));
    b = localStringBuilder.toString();
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
    if (TextUtils.equals(paramString, a)) {
      return 1;
    }
    if ((!TextUtils.equals(paramString, b)) && (!TextUtils.equals(paramString, c)))
    {
      if ((!TextUtils.equals(paramString, d)) && (!TextUtils.equals(paramString, e)))
      {
        if (TextUtils.equals(paramString, f)) {
          return 4;
        }
        if (TextUtils.equals(paramString, g)) {
          return 5;
        }
        if (TextUtils.equals(paramString, getString(2131887648))) {
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
  
  private void m()
  {
    ActionSheet localActionSheet = ActionSheet.create(getBaseActivity());
    if (this.j.c.isMe())
    {
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(a, 5);
      localActionSheet.addButton(b, 5);
    }
    else if (this.j.c.isFriend())
    {
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(f, 5);
      localActionSheet.addButton(c, 5);
      localActionSheet.addButton(g, 5);
    }
    else
    {
      if (StoryProfileUtils.a(this.j.c)) {
        localActionSheet.addButton(d, 5);
      } else if (this.j.c.isSubscribe()) {
        localActionSheet.addButton(e, 5);
      }
      localActionSheet.addButton(h, 5);
      localActionSheet.addButton(g, 5);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new StoryMemoriesFragment.2(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void n()
  {
    Intent localIntent = new Intent(getBaseActivity(), StoryMessageListActivity.class);
    localIntent.putExtra("qqstory_message_list_source", 1);
    localIntent.putExtra("qqstory_jump_source", "3");
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131901576));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    startActivity(localIntent);
  }
  
  private void o()
  {
    Intent localIntent = new Intent(getBaseActivity(), QQStoryShieldActivity.class);
    localIntent.putExtra("uin", String.valueOf(this.j.c.qq));
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131901576));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    startActivity(localIntent);
  }
  
  private void p()
  {
    Intent localIntent = new Intent(getBaseActivity(), QQStoryFriendSettings.class);
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", HardCodeUtil.a(2131901576));
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    startActivity(localIntent);
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
    if (paramString.b())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("entrance_type", paramInt);
      paramString.a(getBaseActivity(), localBundle, 1200);
      getBaseActivity().overridePendingTransition(2130772373, 2130772092);
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    boolean bool;
    if ((paramBoolean2) && (!g())) {
      bool = false;
    } else {
      bool = true;
    }
    paramString = new QQStoryTakeVideoActivityLauncher(PlayModeUtils.b()).a(getBaseActivity(), paramBoolean1, bool);
    paramString.putExtra("entrance_type", paramInt);
    if (bool)
    {
      paramString.putExtra("extra_memories_from", this.j.a);
      paramString.putExtra("extra_now_tab", StoryApi.a());
      paramString.putExtra("start_origin", 3);
      paramString.putExtra("start_time", l1);
      startActivityForResult(paramString, 1200);
      if (paramBoolean2) {
        getBaseActivity().overridePendingTransition(2130772373, 2130772092);
      } else {
        getBaseActivity().overridePendingTransition(0, 0);
      }
      SLog.b("Q.qqstory.memories.StoryMemoriesFragment", "launchNewVideoTakeActivity end");
      this.q = true;
      return;
    }
    startActivityForResult(paramString, 20001);
  }
  
  public boolean a()
  {
    StoryInputBarView localStoryInputBarView = this.n;
    if ((localStoryInputBarView != null) && (localStoryInputBarView.getVisibility() == 0))
    {
      ((InputMethodManager)getBaseActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.n.getWindowToken(), 0);
      this.n.clearFocus();
      this.n.setVisibility(8);
      e();
      return true;
    }
    return false;
  }
  
  public SegmentView b(String paramString)
  {
    return this.i.b(paramString);
  }
  
  public void b()
  {
    if (this.l == null) {
      return;
    }
    QQUserUIItem localQQUserUIItem = this.j.c;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.sourceTagType == 1))
    {
      this.l.setVisibility(0);
      c();
      StoryReportor.a("weishi_share", "person_data_exp", 0, 0, new String[] { "", this.j.c.uid });
      ReportController.b(null, "dc00898", "", "", "weishi_share_prof", "story_entry_exp", 0, 0, "", "", "", "");
      return;
    }
    this.l.setVisibility(8);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    boolean bool = WeishiGuideUtils.a(getBaseActivity());
    if (bool != this.r)
    {
      this.r = bool;
      String str = HardCodeUtil.a(2131911809);
      if (bool) {
        str = HardCodeUtil.a(2131911808);
      }
      this.m.setText(str);
    }
  }
  
  public void d()
  {
    MemoriesProfileSegment localMemoriesProfileSegment = (MemoriesProfileSegment)b("MemoriesProfileSegment");
    if (localMemoriesProfileSegment != null) {
      localMemoriesProfileSegment.a(true);
    }
  }
  
  public void e()
  {
    if ((this.j.c != null) && (this.j.c.isMe()))
    {
      this.o.setVisibility(0);
      this.o.setOnClickListener(this);
      return;
    }
    this.o.setVisibility(8);
    this.o.setOnClickListener(null);
  }
  
  public void f()
  {
    if (getBaseActivity() == null)
    {
      SLog.e("Q.qqstory.memories.StoryMemoriesFragment", "update title bar failed because activity is null.");
      return;
    }
    ImageView localImageView = (ImageView)getBaseActivity().findViewById(2131436194);
    TextView localTextView1 = (TextView)getBaseActivity().findViewById(2131436211);
    TextView localTextView2 = (TextView)getBaseActivity().findViewById(2131436227);
    localTextView1.setGravity(16);
    if (this.j.a == 2)
    {
      localImageView.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(2131897376);
      localTextView1.setOnClickListener(this);
      return;
    }
    localTextView2.setText(PlayModeUtils.a(this.j.c.uid));
    localTextView1.setVisibility(8);
    localImageView.setVisibility(0);
    localImageView.setContentDescription(HardCodeUtil.a(2131911815));
    localImageView.getLayoutParams().width = -2;
    localImageView.setPadding(0, 0, DisplayUtil.a(getBaseActivity(), 5.0F), 0);
    localImageView.setOnClickListener(this);
  }
  
  public boolean g()
  {
    return VideoEnvironment.checkAndLoadAVCodec();
  }
  
  public StoryInputBarView h()
  {
    return this.n;
  }
  
  public boolean i()
  {
    return getBaseActivity().isResume();
  }
  
  public void j()
  {
    ThreadManager.getUIHandler().postDelayed(new StoryMemoriesFragment.3(this), 300L);
  }
  
  public void k()
  {
    this.o.setVisibility(8);
  }
  
  protected void l()
  {
    Object localObject = new TranslucentTitleBarHelper(getBaseActivity(), 155);
    ((TranslucentTitleBarHelper)localObject).a(this.k);
    ((TranslucentTitleBarHelper)localObject).a(false, false);
    this.i.setOnScrollListener(new StoryMemoriesFragment.4(this, (TranslucentTitleBarHelper)localObject));
    if (QQStoryContext.a().b(this.j.b)) {
      localObject = new StoryProfileListViewConfig(getBaseActivity(), this.j.a, this.j.b, StoryProfileListViewConfig.a, this);
    } else {
      localObject = new StoryProfileListViewConfig(getBaseActivity(), this.j.a, this.j.b, StoryProfileListViewConfig.b, this);
    }
    this.i.setConfig((StoryProfileListViewConfig)localObject);
    this.i.k();
    if (this.j.c != null)
    {
      f();
      d();
      e();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.j.a();
    if (StoryProfileUtils.a(this.j.b)) {
      l();
    }
    this.i.setContentBackground(2130839572);
    if ((this.j.a == 2) && (FrameHelperActivity.G()))
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.H();
    }
    b();
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
              localObject = this.p;
              if (localObject != null)
              {
                ((StoryShare)localObject).a(paramInt1, paramInt2, paramIntent);
                return;
              }
              localObject = this.i;
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
          AtVideoTextWatcher.a(this.n.e, paramIntent);
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
    this.j = new QQStoryMemoriesPresenter(paramBundle.getInt("source", 1), paramBundle.getString("union_id"), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.k = paramLayoutInflater.inflate(2131628078, paramViewGroup, false);
    this.k.setFitsSystemWindows(true);
    this.i = ((StoryMemoriesListView)this.k.findViewById(2131438083));
    this.n = ((StoryInputBarView)this.k.findViewById(2131438082));
    this.o = ((ImageButton)this.k.findViewById(2131438086));
    this.m = ((TextView)this.k.findViewById(2131447140));
    this.l = this.k.findViewById(2131430776);
    paramLayoutInflater = (TextView)this.k.findViewById(2131436180);
    this.l.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    paramLayoutInflater = this.k;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    StoryMemoriesListView localStoryMemoriesListView = this.i;
    if (localStoryMemoriesListView != null) {
      localStoryMemoriesListView.m();
    }
    this.j.b();
    this.n.d();
    this.k.setFitsSystemWindows(false);
  }
  
  public void onPause()
  {
    super.onPause();
    this.n.c();
    e();
    StoryMemoriesListView localStoryMemoriesListView = this.i;
    if (localStoryMemoriesListView != null) {
      localStoryMemoriesListView.l();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.q)
    {
      this.q = false;
      this.i.i();
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((StoryMemoriesListView)localObject).p();
    }
    QQUserUIItem localQQUserUIItem = this.j.c;
    int i1 = a(this.j.a);
    int i2 = StoryApi.d(2131492921);
    String str = "1";
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isMe())) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    if ((localQQUserUIItem == null) || (!localQQUserUIItem.isVip())) {
      str = "2";
    }
    StoryReportor.a("memory", "exp", i1, i2, new String[] { localObject, str, "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment
 * JD-Core Version:    0.7.0.1
 */