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
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.boundaries.delegates.ActivityDelegate;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

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
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561545, null);
    ((TextView)localView.findViewById(2131378784)).setText(paramString);
    ((TextView)localView.findViewById(2131368773)).setText("");
    localView.setTag(Integer.valueOf(paramInt1));
    localView.setOnClickListener(this);
    localView.setBackgroundResource(paramInt2);
    return localView;
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561548, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1] = localView;
    Object localObject = (FormSwitchItem)localView.findViewById(2131369172);
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
    ((TextView)localView.findViewById(2131368846)).setVisibility(8);
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
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].findViewById(2131369172);
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
    localLinearLayout.setBackgroundResource(2130838740);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    int i = AIOUtils.b(20.0F, paramQQStoryFriendSettings.getResources());
    paramBundle = Boolean.valueOf(false);
    localLinearLayout.setPadding(0, i, 0, 0);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131710797));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    localLinearLayout.addView(a(0, ((StringBuilder)localObject).toString(), 2130839449));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131710831));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    localLinearLayout.addView(a(1, ((StringBuilder)localObject).toString(), 2130839440));
    localLinearLayout.addView(View.inflate(paramQQStoryFriendSettings, 2131561565, null));
    localObject = (QQStoryManager)paramQQStoryFriendSettings.app.getManager(QQManagerFactory.QQSTORY_MANAGER);
    localLinearLayout.addView(a(2, HardCodeUtil.a(2131710829), 1, ((QQStoryManager)localObject).a()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131710826));
    localStringBuilder.append(QQStoryConstant.b);
    localStringBuilder.append(HardCodeUtil.a(2131710813));
    localLinearLayout.addView(a(3, localStringBuilder.toString(), 2, ((QQStoryManager)localObject).b()));
    if (((QQStoryManager)localObject).d())
    {
      i = ((QQStoryManager)localObject).b();
      localLinearLayout.addView(a(5, String.format(HardCodeUtil.a(2131710807), new Object[] { Integer.valueOf(i), HardCodeUtil.a(2131710830) }), 2, ((QQStoryManager)localObject).c()));
      StoryReportor.a("friend_story_settings", "exp_strange", 0, 0, new String[0]);
    }
    localObject = (StoryConfigManager)SuperManager.a(10);
    boolean bool1 = ((Boolean)((StoryConfigManager)localObject).b("story_publish_flag_compress_configurable", paramBundle)).booleanValue();
    boolean bool2 = ((Boolean)((StoryConfigManager)localObject).b("story_publish_flag_compress", paramBundle)).booleanValue();
    SLog.d("QQStoryFriendSettingDelegate", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561565, null));
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131710827));
      paramBundle.append(QQStoryConstant.a);
      localLinearLayout.addView(a(7, paramBundle.toString(), 0, bool2));
    }
    paramBundle = (MsgTabStoryNodeConfigManager)paramQQStoryFriendSettings.app.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
    if ((paramBundle.b) && (paramBundle.c))
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561565, null));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131710803));
      ((StringBuilder)localObject).append(QQStoryConstant.b);
      localLinearLayout.addView(a(8, ((StringBuilder)localObject).toString(), 1, paramBundle.d));
      if (paramBundle.d) {
        paramBundle = "1";
      } else {
        paramBundle = "2";
      }
      StoryReportor.a("msg_tab", "exp_set", 0, 0, new String[] { "1", paramBundle });
    }
    paramQQStoryFriendSettings.setContentView(localLinearLayout);
    paramBundle = new StringBuilder();
    paramBundle.append(QQStoryConstant.a);
    paramBundle.append(HardCodeUtil.a(2131710820));
    paramQQStoryFriendSettings.setTitle(paramBundle.toString());
    paramQQStoryFriendSettings.app.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    ((QQStoryHandler)paramQQStoryFriendSettings.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a();
    StoryReportor.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "1", "", "", "" });
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void c(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void d(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = paramCompoundButton.getTag();
    if ((localObject instanceof Integer))
    {
      int i = ((Integer)localObject).intValue();
      localObject = "2";
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 7)
              {
                if (i == 8)
                {
                  ((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a(paramBoolean);
                  QQStoryHandler localQQStoryHandler = (QQStoryHandler)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
                  if (paramBoolean) {
                    i = 2;
                  } else {
                    i = 1;
                  }
                  localQQStoryHandler.b(i);
                  if (paramBoolean) {
                    localObject = "1";
                  }
                  StoryReportor.a("msg_tab", "turn_story", 0, 0, new String[] { "1", localObject });
                }
              }
              else if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
              {
                a(7, paramBoolean ^ true);
                a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692183));
              }
              else
              {
                d(paramBoolean);
                SLog.d("QQStoryFriendSettingDelegate", "VIEW_ID_ALLOW_SKIP_ENCODE_THREAD %s", new Object[] { Boolean.valueOf(paramBoolean) });
              }
            }
            else if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
            {
              a(5, paramBoolean ^ true);
              a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692183));
            }
            else
            {
              c(paramBoolean);
              if (paramBoolean) {
                localObject = "1";
              }
              StoryReportor.a("friend_story_settings", "clk_strange", 0, 0, new String[] { localObject });
            }
          }
          else {
            ((QQStoryManager)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(QQManagerFactory.QQSTORY_MANAGER)).g(paramBoolean);
          }
        }
        else if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          a(3, paramBoolean ^ true);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692183));
        }
        else
        {
          b(paramBoolean);
          if (paramBoolean) {
            localObject = "1";
          }
          StoryReportor.a("friend_story_settings", "receive_care", 0, 0, new String[] { localObject, "", "", "" });
        }
      }
      else if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        a(2, paramBoolean ^ true);
        a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692183));
      }
      else
      {
        a(paramBoolean);
        if (paramBoolean) {
          localObject = "1";
        }
        StoryReportor.a("friend_story_settings", "receive_me", 0, 0, new String[] { localObject, "", "", "" });
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, QQStoryShieldListActivity.class);
    if (i != 0)
    {
      if (i == 1)
      {
        localIntent.putExtra("sheild_type", 2);
        StoryReportor.a("friend_story_settings", "clk_notletsee", 0, 0, new String[] { "", "", "", "" });
      }
    }
    else
    {
      localIntent.putExtra("sheild_type", 1);
      StoryReportor.a("friend_story_settings", "clk_notsee", 0, 0, new String[] { "", "", "", "" });
    }
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate
 * JD-Core Version:    0.7.0.1
 */