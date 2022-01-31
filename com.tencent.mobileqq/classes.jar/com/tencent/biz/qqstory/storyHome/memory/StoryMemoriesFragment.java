package com.tencent.biz.qqstory.storyHome.memory;

import alud;
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
import azqs;
import bhuf;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;
import ulg;
import uqn;
import vic;
import vls;
import whg;
import whs;
import wln;
import wlq;
import wms;
import wmy;
import wmz;
import wnm;
import wtr;
import wxe;
import wxj;
import xin;
import xpk;
import xsk;
import xsx;
import xvp;

public class StoryMemoriesFragment
  extends Fragment
  implements View.OnClickListener, wtr
{
  public static final String a;
  public static final String b;
  public static final String c = alud.a(2131714881);
  public static final String d = alud.a(2131714894);
  public static final String e = alud.a(2131714893);
  public static final String f = alud.a(2131714886);
  public static final String g = alud.a(2131714892);
  public static final String h = alud.a(2131714885);
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StoryInputBarView jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  public StoryMemoriesListView a;
  private vic jdField_a_of_type_Vic;
  private wms jdField_a_of_type_Wms;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131714882);
    jdField_b_of_type_JavaLangString = ulg.jdField_a_of_type_JavaLangString + alud.a(2131714888);
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
    if (TextUtils.equals(paramString, getString(2131690648))) {
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
    bhuf localbhuf = bhuf.a(getActivity());
    if (this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
    {
      localbhuf.a(h, 5);
      localbhuf.a(jdField_a_of_type_JavaLangString, 5);
      localbhuf.a(jdField_b_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      localbhuf.c(2131690648);
      localbhuf.a(new wln(this, localbhuf));
      if (!localbhuf.isShowing()) {
        localbhuf.show();
      }
      return;
      if (!this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend()) {
        break;
      }
      localbhuf.a(h, 5);
      localbhuf.a(f, 5);
      localbhuf.a(c, 5);
      localbhuf.a(g, 5);
    }
    if (wmz.a(this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem)) {
      localbhuf.a(d, 5);
    }
    for (;;)
    {
      localbhuf.a(h, 5);
      localbhuf.a(g, 5);
      break;
      if (this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe()) {
        localbhuf.a(e, 5);
      }
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(getActivity(), StoryMessageListActivity.class);
    localIntent.putExtra("qqstory_message_list_source", 1);
    localIntent.putExtra("qqstory_jump_source", "3");
    localIntent.putExtra("leftViewText", alud.a(2131714887));
    localIntent.putExtra("selfSet_leftViewText", alud.a(2131714879));
    startActivity(localIntent);
  }
  
  private void k()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryShieldActivity.class);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq));
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", alud.a(2131714877));
    localIntent.putExtra("selfSet_leftViewText", alud.a(2131714876));
    startActivity(localIntent);
  }
  
  private void l()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryFriendSettings.class);
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", alud.a(2131714889));
    localIntent.putExtra("selfSet_leftViewText", alud.a(2131714891));
    startActivity(localIntent);
  }
  
  public StoryInputBarView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  }
  
  public xvp a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.a(paramString);
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.sourceTagType == 1))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      b();
      wxj.a("weishi_share", "person_data_exp", 0, 0, new String[] { "", this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid });
      azqs.b(null, "dc00898", "", "", "weishi_share_prof", "story_entry_exp", 0, 0, "", "", "", "");
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
    paramString = xpk.a();
    if (paramString.a())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("entrance_type", paramInt);
      paramString.a(getActivity(), localBundle, 1200);
      getActivity().overridePendingTransition(2130772233, 2130772038);
      return;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (c()))
    {
      bool = true;
      paramString = new whg(vls.a()).a(getActivity(), paramBoolean1, bool);
      paramString.putExtra("entrance_type", paramInt);
      if (!bool) {
        break label223;
      }
      paramString.putExtra("extra_memories_from", this.jdField_a_of_type_Wms.jdField_a_of_type_Int);
      paramString.putExtra("extra_now_tab", uqn.a());
      paramString.putExtra("start_origin", 3);
      paramString.putExtra("start_time", l);
      startActivityForResult(paramString, 1200);
      if (!paramBoolean2) {
        break label211;
      }
      getActivity().overridePendingTransition(2130772233, 2130772038);
    }
    for (;;)
    {
      wxe.b("Q.qqstory.memories.StoryMemoriesFragment", "launchNewVideoTakeActivity end");
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
    boolean bool = xsx.a(getActivity());
    if (bool != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = bool;
      String str = alud.a(2131714884);
      if (bool) {
        str = alud.a(2131714883);
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
    wnm localwnm = (wnm)a("MemoriesProfileSegment");
    if (localwnm != null) {
      localwnm.a(true);
    }
  }
  
  public boolean c()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(vls.a());
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()))
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
      wxe.e("Q.qqstory.memories.StoryMemoriesFragment", "update title bar failed because activity is null.");
      return;
    }
    ImageView localImageView = (ImageView)getActivity().findViewById(2131368638);
    TextView localTextView1 = (TextView)getActivity().findViewById(2131368655);
    TextView localTextView2 = (TextView)getActivity().findViewById(2131368670);
    localTextView1.setGravity(16);
    if (this.jdField_a_of_type_Wms.jdField_a_of_type_Int == 2)
    {
      localImageView.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(2131699892);
      localTextView1.setOnClickListener(this);
      return;
    }
    localTextView2.setText(vls.a(this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid));
    localTextView1.setVisibility(8);
    localImageView.setVisibility(0);
    localImageView.setContentDescription(alud.a(2131714895));
    localImageView.getLayoutParams().width = -2;
    localImageView.setPadding(0, 0, xin.b(getActivity(), 5.0F), 0);
    localImageView.setOnClickListener(this);
  }
  
  protected void f()
  {
    Object localObject = new xsk(getActivity(), 155);
    ((xsk)localObject).a(this.jdField_a_of_type_AndroidViewView);
    ((xsk)localObject).a(false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setOnScrollListener(new wlq(this, (xsk)localObject));
    if (QQStoryContext.a().a(this.jdField_a_of_type_Wms.jdField_a_of_type_JavaLangString)) {}
    for (localObject = new wmy(getActivity(), this.jdField_a_of_type_Wms.jdField_a_of_type_Int, this.jdField_a_of_type_Wms.jdField_a_of_type_JavaLangString, wmy.jdField_a_of_type_Int, this);; localObject = new wmy(getActivity(), this.jdField_a_of_type_Wms.jdField_a_of_type_Int, this.jdField_a_of_type_Wms.jdField_a_of_type_JavaLangString, wmy.b, this))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setConfig((wmy)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.j();
      if (this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)
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
    this.jdField_a_of_type_Wms.a();
    if (wmz.a(this.jdField_a_of_type_Wms.jdField_a_of_type_JavaLangString)) {
      f();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setContentBackground(2130839212);
    if ((this.jdField_a_of_type_Wms.jdField_a_of_type_Int == 2) && (FrameHelperActivity.b()))
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.s();
    }
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      wxe.e("Q.qqstory.memories.StoryMemoriesFragment", "onActivityResult, data is null.");
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
        if (this.jdField_a_of_type_Vic != null)
        {
          this.jdField_a_of_type_Vic.a(paramInt1, paramInt2, paramIntent);
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
        if (uqn.a())
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
        whs.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
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
    default: 
      return;
    case 2131364319: 
      b();
      if (this.jdField_b_of_type_Boolean)
      {
        xsx.a(getActivity(), "biz_src_jc_hyws", this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.wsScahema);
        if (!this.jdField_b_of_type_Boolean) {
          break label198;
        }
        i = 2;
        wxj.a("weishi_share", "person_data_clk", 0, i, new String[] { "", this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid });
        if (!this.jdField_b_of_type_Boolean) {
          break label203;
        }
      }
      for (paramView = "story_clk_ws";; paramView = "story_dl_ws")
      {
        azqs.b(null, "dc00898", "", "", "weishi_share_prof", paramView, 0, 0, "", "", "", "");
        return;
        QQToast.a(getActivity(), alud.a(2131714880), 0).a();
        xsx.a(getActivity(), "biz_src_jc_hyws");
        break;
        i = 1;
        break label97;
      }
    case 2131370177: 
      if (this.jdField_a_of_type_Wms.jdField_a_of_type_Int == 2) {}
      for (;;)
      {
        a(false, true, i, null);
        wxj.a("memory", "clk_shoot", a(this.jdField_a_of_type_Wms.jdField_a_of_type_Int), 0, new String[0]);
        return;
        i = 3;
      }
    case 2131368655: 
      if (uqn.a()) {}
      for (i = 1;; i = 0)
      {
        wxe.b("Q.qqstory.memories.StoryMemoriesFragment", "startStoryMainActivity, isNowTabShow==%d", Integer.valueOf(i));
        paramView = new Intent(getActivity(), QQStoryMainActivity.class);
        paramView.putExtra("from_memeories", true);
        paramView.putExtra("leftViewText", alud.a(2131714890));
        paramView.putExtra("selfSet_leftViewText", alud.a(2131714878));
        startActivity(paramView);
        wxj.a("memory", "enter_story", a(this.jdField_a_of_type_Wms.jdField_a_of_type_Int), 0, new String[] { "", "", "", "" });
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    case 2131368638: 
      label97:
      i();
      label198:
      label203:
      i = a(this.jdField_a_of_type_Wms.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        wxj.a("memory", "clk_more", i, 0, new String[] { paramView });
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
    this.jdField_a_of_type_Wms = new wms(paramBundle.getInt("source", 1), paramBundle.getString("union_id"), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561494, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView = ((StoryMemoriesListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370174));
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370173));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131370177));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377671));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364319);
    paramLayoutInflater = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368624);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.l();
    }
    this.jdField_a_of_type_Wms.b();
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
    Object localObject = this.jdField_a_of_type_Wms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
    int i = a(this.jdField_a_of_type_Wms.jdField_a_of_type_Int);
    int j = uqn.a(2131427362);
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
      wxj.a("memory", "exp", i, j, new String[] { str, localObject, "", "" });
      return;
      str = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment
 * JD-Core Version:    0.7.0.1
 */