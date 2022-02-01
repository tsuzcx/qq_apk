package com.tencent.biz.qqstory.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.boundaries.delegates.ActivityDelegate;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserConfig;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class QQStoryFriendSettingDelegate
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, KeepConstructor, ActivityDelegate<QQStoryFriendSettings>
{
  protected int a;
  protected QQStoryObserver a;
  protected QQStoryFriendSettings a;
  protected View[] a;
  
  public QQStoryFriendSettingDelegate()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new QQStoryFriendSettingDelegate.1(this);
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561702, null);
    ((TextView)localView.findViewById(2131379432)).setText(paramString);
    ((TextView)localView.findViewById(2131369051)).setText("");
    localView.setTag(Integer.valueOf(paramInt1));
    localView.setOnClickListener(this);
    localView.setBackgroundResource(paramInt2);
    return localView;
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561705, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1] = localView;
    Object localObject = (FormSwitchItem)localView.findViewById(2131369444);
    ((FormSwitchItem)localObject).a().setTextSize(1, 18.0F);
    ((FormSwitchItem)localObject).setText(paramString);
    ((FormSwitchItem)localObject).setContentDescription(paramString);
    ((FormSwitchItem)localObject).setBgType(paramInt2);
    localObject = ((FormSwitchItem)localObject).a();
    ((Switch)localObject).setTag(Integer.valueOf(paramInt1));
    ((Switch)localObject).setOnCheckedChangeListener(null);
    ((Switch)localObject).setChecked(paramBoolean);
    ((Switch)localObject).setOnCheckedChangeListener(this);
    ((Switch)localObject).setContentDescription(paramString);
    ((TextView)localView.findViewById(2131369114)).setVisibility(8);
    return localView;
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, paramInt, paramString, 0).b(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].findViewById(2131369444);
    localFormSwitchItem.setOnCheckedChangeListener(null);
    localFormSwitchItem.setChecked(paramBoolean);
    localFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings)
  {
    paramQQStoryFriendSettings.app.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings = paramQQStoryFriendSettings;
    this.jdField_a_of_type_Int = paramQQStoryFriendSettings.getIntent().getIntExtra("from", 1);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings);
    paramBundle = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setBackgroundResource(2130838980);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(0, AIOUtils.a(20.0F, paramQQStoryFriendSettings.getResources()), 0, 0);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
    localLinearLayout.addView(a(0, HardCodeUtil.a(2131710820) + QQStoryConstant.b, 2130839591));
    localLinearLayout.addView(a(1, HardCodeUtil.a(2131710854) + QQStoryConstant.b, 2130839582));
    localLinearLayout.addView(View.inflate(paramQQStoryFriendSettings, 2131561722, null));
    paramBundle = (QQStoryManager)paramQQStoryFriendSettings.app.getManager(QQManagerFactory.QQSTORY_MANAGER);
    localLinearLayout.addView(a(2, HardCodeUtil.a(2131710852), 1, paramBundle.a()));
    localLinearLayout.addView(a(3, HardCodeUtil.a(2131710849) + QQStoryConstant.b + HardCodeUtil.a(2131710836), 2, paramBundle.b()));
    if (paramBundle.d())
    {
      int i = paramBundle.b();
      localLinearLayout.addView(a(5, String.format(HardCodeUtil.a(2131710830), new Object[] { Integer.valueOf(i), HardCodeUtil.a(2131710853) }), 2, paramBundle.c()));
      StoryReportor.a("friend_story_settings", "exp_strange", 0, 0, new String[0]);
    }
    paramBundle = (StoryConfigManager)SuperManager.a(10);
    boolean bool1 = ((Boolean)paramBundle.b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
    boolean bool2 = ((Boolean)paramBundle.b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
    SLog.d("QQStoryFriendSettingDelegate", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561722, null));
      localLinearLayout.addView(a(7, HardCodeUtil.a(2131710850) + QQStoryConstant.a, 0, bool2));
    }
    paramBundle = (MsgTabStoryNodeConfigManager)paramQQStoryFriendSettings.app.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
    if ((paramBundle.b) && (paramBundle.c))
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561722, null));
      localLinearLayout.addView(a(8, HardCodeUtil.a(2131710826) + QQStoryConstant.b, 1, paramBundle.d));
      if (!paramBundle.d) {
        break label680;
      }
    }
    label680:
    for (paramBundle = "1";; paramBundle = "2")
    {
      StoryReportor.a("msg_tab", "exp_set", 0, 0, new String[] { "1", paramBundle });
      paramQQStoryFriendSettings.setContentView(localLinearLayout);
      paramQQStoryFriendSettings.setTitle(QQStoryConstant.a + HardCodeUtil.a(2131710843));
      paramQQStoryFriendSettings.app.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      ((QQStoryHandler)paramQQStoryFriendSettings.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).d();
      StoryReportor.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "1", "", "", "" });
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    qqstory_struct.UserConfig localUserConfig = new qqstory_struct.UserConfig();
    localUserConfig.config_key.set(ByteStringMicro.copyFromUtf8("self_notify"));
    Object localObject = localUserConfig.config_value;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((List)localObject).add(localUserConfig);
      localReqSetConfig.user_config.set((List)localObject);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new QQStoryFriendSettingDelegate.2(this, paramBoolean), localReqSetConfig.toByteArray(), QQStoryHandler.b);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    qqstory_struct.UserConfig localUserConfig = new qqstory_struct.UserConfig();
    localUserConfig.config_key.set(ByteStringMicro.copyFromUtf8("special_notify"));
    Object localObject = localUserConfig.config_value;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((List)localObject).add(localUserConfig);
      localReqSetConfig.user_config.set((List)localObject);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new QQStoryFriendSettingDelegate.3(this, paramBoolean), localReqSetConfig.toByteArray(), QQStoryHandler.b);
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    qqstory_struct.UserConfig localUserConfig = new qqstory_struct.UserConfig();
    localUserConfig.config_key.set(ByteStringMicro.copyFromUtf8("allow_stranger_state"));
    Object localObject = localUserConfig.config_value;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((List)localObject).add(localUserConfig);
      localReqSetConfig.user_config.set((List)localObject);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new QQStoryFriendSettingDelegate.4(this, paramBoolean), localReqSetConfig.toByteArray(), QQStoryHandler.b);
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    qqstory_struct.UserConfig localUserConfig = new qqstory_struct.UserConfig();
    localUserConfig.config_key.set(ByteStringMicro.copyFromUtf8("story_publish_flag_compress"));
    Object localObject = localUserConfig.config_value;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((List)localObject).add(localUserConfig);
      localReqSetConfig.user_config.set((List)localObject);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new QQStoryFriendSettingDelegate.5(this, paramBoolean), localReqSetConfig.toByteArray(), QQStoryHandler.b);
      return;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject = paramCompoundButton.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      switch (((Integer)localObject).intValue())
      {
      case 6: 
      default: 
        break;
      case 2: 
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = true;; bool1 = false)
          {
            a(2, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692257));
            break;
          }
        }
        a(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          StoryReportor.a("friend_story_settings", "receive_me", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 3: 
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (;;)
          {
            a(3, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692257));
            break;
            bool1 = false;
          }
        }
        b(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          StoryReportor.a("friend_story_settings", "receive_care", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 5: 
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = bool2;; bool1 = false)
          {
            a(5, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692257));
            break;
          }
        }
        c(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          StoryReportor.a("friend_story_settings", "clk_strange", 0, 0, new String[] { localObject });
          break;
        }
      case 7: 
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = bool3;; bool1 = false)
          {
            a(7, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692257));
            break;
          }
        }
        d(paramBoolean);
        SLog.d("QQStoryFriendSettingDelegate", "VIEW_ID_ALLOW_SKIP_ENCODE_THREAD %s", new Object[] { Boolean.valueOf(paramBoolean) });
        break;
      case 4: 
        ((QQStoryManager)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(QQManagerFactory.QQSTORY_MANAGER)).g(paramBoolean);
      }
    }
    ((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a(paramBoolean);
    localObject = (QQStoryHandler)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
    int i;
    if (paramBoolean)
    {
      i = 2;
      label539:
      ((QQStoryHandler)localObject).b(i);
      if (!paramBoolean) {
        break label588;
      }
    }
    label588:
    for (localObject = "1";; localObject = "2")
    {
      StoryReportor.a("msg_tab", "turn_story", 0, 0, new String[] { "1", localObject });
      break;
      i = 1;
      break label539;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, QQStoryShieldListActivity.class);
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent.putExtra("sheild_type", 2);
      StoryReportor.a("friend_story_settings", "clk_notletsee", 0, 0, new String[] { "", "", "", "" });
      continue;
      localIntent.putExtra("sheild_type", 1);
      StoryReportor.a("friend_story_settings", "clk_notsee", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate
 * JD-Core Version:    0.7.0.1
 */