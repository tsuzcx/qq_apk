package com.tencent.biz.qqstory.storyHome.memory;

import amtj;
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
import bcef;
import bjnw;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.os.MqqHandler;
import vkm;
import vpl;
import wgz;
import wkp;
import xfx;
import xgj;
import xke;
import xkh;
import xlj;
import xlp;
import xlq;
import xmd;
import xsi;
import xvv;
import xwa;
import ynm;
import yqm;
import yqu;
import ysg;

public class StoryMemoriesFragment
  extends ReportV4Fragment
  implements View.OnClickListener, xsi
{
  public static final String a;
  public static final String b;
  public static final String c = amtj.a(2131713523);
  public static final String d = amtj.a(2131713536);
  public static final String e = amtj.a(2131713535);
  public static final String f = amtj.a(2131713528);
  public static final String g = amtj.a(2131713534);
  public static final String h = amtj.a(2131713527);
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StoryInputBarView jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  public StoryMemoriesListView a;
  private wgz jdField_a_of_type_Wgz;
  private xlj jdField_a_of_type_Xlj;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = amtj.a(2131713524);
    jdField_b_of_type_JavaLangString = vkm.jdField_a_of_type_JavaLangString + amtj.a(2131713530);
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
    if (TextUtils.equals(paramString, getString(2131690620))) {
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
    bjnw localbjnw = bjnw.a(getActivity());
    if (this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
    {
      localbjnw.a(h, 5);
      localbjnw.a(jdField_a_of_type_JavaLangString, 5);
      localbjnw.a(jdField_b_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      localbjnw.c(2131690620);
      localbjnw.a(new xke(this, localbjnw));
      if (!localbjnw.isShowing()) {
        localbjnw.show();
      }
      return;
      if (!this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend()) {
        break;
      }
      localbjnw.a(h, 5);
      localbjnw.a(f, 5);
      localbjnw.a(c, 5);
      localbjnw.a(g, 5);
    }
    if (xlq.a(this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem)) {
      localbjnw.a(d, 5);
    }
    for (;;)
    {
      localbjnw.a(h, 5);
      localbjnw.a(g, 5);
      break;
      if (this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe()) {
        localbjnw.a(e, 5);
      }
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(getActivity(), StoryMessageListActivity.class);
    localIntent.putExtra("qqstory_message_list_source", 1);
    localIntent.putExtra("qqstory_jump_source", "3");
    localIntent.putExtra("leftViewText", amtj.a(2131713529));
    localIntent.putExtra("selfSet_leftViewText", amtj.a(2131713521));
    startActivity(localIntent);
  }
  
  private void k()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryShieldActivity.class);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq));
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", amtj.a(2131713519));
    localIntent.putExtra("selfSet_leftViewText", amtj.a(2131713518));
    startActivity(localIntent);
  }
  
  private void l()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryFriendSettings.class);
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", amtj.a(2131713531));
    localIntent.putExtra("selfSet_leftViewText", amtj.a(2131713533));
    startActivity(localIntent);
  }
  
  public StoryInputBarView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  }
  
  public ysg a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.a(paramString);
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.sourceTagType == 1))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      b();
      xwa.a("weishi_share", "person_data_exp", 0, 0, new String[] { "", this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid });
      bcef.b(null, "dc00898", "", "", "weishi_share_prof", "story_entry_exp", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
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
    paramString = ynm.a();
    if (paramString.a())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("entrance_type", paramInt);
      paramString.a(getActivity(), localBundle, 1200);
      getActivity().overridePendingTransition(2130772240, 2130772041);
      return;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (c()))
    {
      bool = true;
      paramString = new xfx(wkp.a()).a(getActivity(), paramBoolean1, bool);
      paramString.putExtra("entrance_type", paramInt);
      if (!bool) {
        break label223;
      }
      paramString.putExtra("extra_memories_from", this.jdField_a_of_type_Xlj.jdField_a_of_type_Int);
      paramString.putExtra("extra_now_tab", vpl.a());
      paramString.putExtra("start_origin", 3);
      paramString.putExtra("start_time", l);
      startActivityForResult(paramString, 1200);
      if (!paramBoolean2) {
        break label211;
      }
      getActivity().overridePendingTransition(2130772240, 2130772041);
    }
    for (;;)
    {
      xvv.b("Q.qqstory.memories.StoryMemoriesFragment", "launchNewVideoTakeActivity end");
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
    boolean bool = yqu.a(getActivity());
    if (bool != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = bool;
      String str = amtj.a(2131713526);
      if (bool) {
        str = amtj.a(2131713525);
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
    xmd localxmd = (xmd)a("MemoriesProfileSegment");
    if (localxmd != null) {
      localxmd.a(true);
    }
  }
  
  public boolean c()
  {
    if (ShortVideoUtils.isVideoSoLibLoaded()) {}
    do
    {
      return true;
      ShortVideoUtils.loadShortVideoSo(wkp.a());
    } while (ShortVideoUtils.isVideoSoLibLoaded());
    return false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()))
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
      xvv.e("Q.qqstory.memories.StoryMemoriesFragment", "update title bar failed because activity is null.");
      return;
    }
    ImageView localImageView = (ImageView)getActivity().findViewById(2131369082);
    TextView localTextView1 = (TextView)getActivity().findViewById(2131369099);
    TextView localTextView2 = (TextView)getActivity().findViewById(2131369115);
    localTextView1.setGravity(16);
    if (this.jdField_a_of_type_Xlj.jdField_a_of_type_Int == 2)
    {
      localImageView.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(2131698615);
      localTextView1.setOnClickListener(this);
      return;
    }
    localTextView2.setText(wkp.a(this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid));
    localTextView1.setVisibility(8);
    localImageView.setVisibility(0);
    localImageView.setContentDescription(amtj.a(2131713537));
    localImageView.getLayoutParams().width = -2;
    localImageView.setPadding(0, 0, DisplayUtil.dip2px(getActivity(), 5.0F), 0);
    localImageView.setOnClickListener(this);
  }
  
  protected void f()
  {
    Object localObject = new yqm(getActivity(), 155);
    ((yqm)localObject).a(this.jdField_a_of_type_AndroidViewView);
    ((yqm)localObject).a(false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setOnScrollListener(new xkh(this, (yqm)localObject));
    if (QQStoryContext.a().a(this.jdField_a_of_type_Xlj.jdField_a_of_type_JavaLangString)) {}
    for (localObject = new xlp(getActivity(), this.jdField_a_of_type_Xlj.jdField_a_of_type_Int, this.jdField_a_of_type_Xlj.jdField_a_of_type_JavaLangString, xlp.jdField_a_of_type_Int, this);; localObject = new xlp(getActivity(), this.jdField_a_of_type_Xlj.jdField_a_of_type_Int, this.jdField_a_of_type_Xlj.jdField_a_of_type_JavaLangString, xlp.b, this))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setConfig((xlp)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.j();
      if (this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)
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
    this.jdField_a_of_type_Xlj.a();
    if (xlq.a(this.jdField_a_of_type_Xlj.jdField_a_of_type_JavaLangString)) {
      f();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setContentBackground(2130839432);
    if ((this.jdField_a_of_type_Xlj.jdField_a_of_type_Int == 2) && (FrameHelperActivity.b()))
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.t();
    }
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      xvv.e("Q.qqstory.memories.StoryMemoriesFragment", "onActivityResult, data is null.");
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
        if (this.jdField_a_of_type_Wgz != null)
        {
          this.jdField_a_of_type_Wgz.a(paramInt1, paramInt2, paramIntent);
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
        if (vpl.a())
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
        xgj.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
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
        yqu.a(getActivity(), "biz_src_jc_hyws", this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.wsScahema);
        label95:
        if (!this.jdField_b_of_type_Boolean) {
          break label207;
        }
        i = 2;
        label104:
        xwa.a("weishi_share", "person_data_clk", 0, i, new String[] { "", this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid });
        if (!this.jdField_b_of_type_Boolean) {
          break label212;
        }
      }
      label207:
      label212:
      for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
      {
        bcef.b(null, "dc00898", "", "", "weishi_share_prof", (String)localObject, 0, 0, "", "", "", "");
        break;
        QQToast.a(getActivity(), amtj.a(2131713522), 0).a();
        yqu.a(getActivity(), "biz_src_jc_hyws");
        break label95;
        i = 1;
        break label104;
      }
      if (this.jdField_a_of_type_Xlj.jdField_a_of_type_Int == 2) {}
      for (;;)
      {
        a(false, true, i, null);
        xwa.a("memory", "clk_shoot", a(this.jdField_a_of_type_Xlj.jdField_a_of_type_Int), 0, new String[0]);
        break;
        i = 3;
      }
      if (vpl.a()) {}
      for (i = 1;; i = 0)
      {
        xvv.b("Q.qqstory.memories.StoryMemoriesFragment", "startStoryMainActivity, isNowTabShow==%d", Integer.valueOf(i));
        localObject = new Intent(getActivity(), QQStoryMainActivity.class);
        ((Intent)localObject).putExtra("from_memeories", true);
        ((Intent)localObject).putExtra("leftViewText", amtj.a(2131713532));
        ((Intent)localObject).putExtra("selfSet_leftViewText", amtj.a(2131713520));
        startActivity((Intent)localObject);
        xwa.a("memory", "enter_story", a(this.jdField_a_of_type_Xlj.jdField_a_of_type_Int), 0, new String[] { "", "", "", "" });
        this.jdField_a_of_type_Boolean = true;
        break;
      }
      i();
      i = a(this.jdField_a_of_type_Xlj.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
      for (localObject = "1";; localObject = "2")
      {
        xwa.a("memory", "clk_more", i, 0, new String[] { localObject });
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
    this.jdField_a_of_type_Xlj = new xlj(paramBundle.getInt("source", 1), paramBundle.getString("union_id"), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561648, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView = ((StoryMemoriesListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370687));
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370686));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131370690));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378435));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364600);
    paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369068);
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
    this.jdField_a_of_type_Xlj.b();
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
    Object localObject = this.jdField_a_of_type_Xlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    int i = a(this.jdField_a_of_type_Xlj.jdField_a_of_type_Int);
    int j = vpl.a(2131427362);
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
      xwa.a("memory", "exp", i, j, new String[] { str, localObject, "", "" });
      return;
      str = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment
 * JD-Core Version:    0.7.0.1
 */