package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarApi;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarLogic;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteUIHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelLayoutListener;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class TroopRobotShortcutBarService
  implements IAIOShortcutBarApi
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private IAIOShortcutBarLogic jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RobotChatPanelLayout jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout;
  private RobotPanelLayoutBase.RobotPanelLayoutListener jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelLayoutListener = null;
  private TroopAIORobotLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout;
  private DrawerFrame.TouchEventConsumer jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer = new TroopRobotShortcutBarService.9(this);
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = false;
  private boolean d = false;
  
  private int a(int paramInt)
  {
    if (paramInt == 4) {
      return AIOUtils.b(-11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    return 0;
  }
  
  private void l()
  {
    Object localObject = (ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
    ISpriteContext localISpriteContext = ((ISpriteScriptManager)localObject).getSpriteContext();
    if (localISpriteContext == null) {
      return;
    }
    if (localISpriteContext.a()) {
      return;
    }
    localObject = ((ISpriteScriptManager)localObject).getUIHandler();
    if (localObject != null) {
      ((ISpriteUIHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a()
  {
    return a();
  }
  
  public ViewGroup.LayoutParams a()
  {
    return b();
  }
  
  public RobotPanelLayoutBase a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 6) {
      return this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout;
  }
  
  public String a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localSessionInfo != null)
    {
      if (!TextUtils.isEmpty(localSessionInfo.d)) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public String a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showRobotLayout : ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("TroopRobotShortcutBarService", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = a();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = ((RobotPanelLayoutBase)localObject2).a();
    if (paramBoolean)
    {
      if (((RobotPanelLayoutBase)localObject2).b() == 0) {
        return localObject1;
      }
      if (!b()) {
        RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA1", (String)localObject1, "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.b(a());
      l();
      if (((RobotPanelLayoutBase)localObject2).c() == 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
        if (localObject2 != null) {
          a(((XEditTextEx)localObject2).getLineCount());
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.a(a());
    }
    a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.b();
    return localObject1;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.a() == a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.e();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      if (!b()) {
        return;
      }
      int i = ((RobotPanelLayoutBase)localObject).c();
      if (paramInt == i) {
        return;
      }
      ((RobotPanelLayoutBase)localObject).setInputLineCount(paramInt);
      if ((i == 4) || (paramInt == 4))
      {
        paramInt = a(paramInt);
        localObject = ((RobotPanelLayoutBase)localObject).getLayoutParams();
        if ((localObject instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
        }
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 9) {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                return;
              case 26: 
                c(false);
                a(false);
                return;
              case 25: 
                this.jdField_a_of_type_JavaLangString = paramBundle.getString("mCurrentRobotUin", this.jdField_a_of_type_JavaLangString);
                this.jdField_b_of_type_JavaLangString = paramBundle.getString("mCurrentRobotNickname", this.jdField_b_of_type_JavaLangString);
                this.c = paramBundle.getBoolean("isSending", this.c);
                this.jdField_b_of_type_Boolean = paramBundle.getBoolean("mHasRobotOlgFlag", this.jdField_b_of_type_Boolean);
                paramBundle.putBoolean("isSending", this.c);
                paramBundle.putBoolean("mIsShowRobotIcon", this.jdField_a_of_type_Boolean);
                paramBundle.putString("mCurrentRobotUin", this.jdField_a_of_type_JavaLangString);
                return;
              case 24: 
                paramBundle.putBoolean("result", c());
                return;
              case 23: 
                if (paramBundle.getBoolean("isRobot"))
                {
                  a(paramBundle.getInt("nInputLineCount"));
                  return;
                }
                if (!paramBundle.getBoolean("isTroop")) {
                  break;
                }
                e();
                return;
              case 22: 
                a();
                return;
              }
              break;
            case 20: 
              a(paramBundle);
              return;
            case 19: 
              f();
              return;
            case 18: 
              paramBundle.putBoolean("result", a(paramBundle.getBoolean("isSendToRobotServer", false)));
              return;
            case 17: 
              h();
              return;
            case 16: 
              b(false);
              return;
            case 15: 
              b(true);
              return;
            case 14: 
              a(true, paramBundle.getLong("roBotUin"));
              return;
            case 13: 
              paramBundle.putBoolean("result", a(null, paramBundle.getBoolean("isJubaoMode", false)));
              return;
            }
          } else {
            b();
          }
        }
        else {
          d();
        }
      }
      else {
        c();
      }
    }
    else
    {
      long l1 = SystemClock.uptimeMillis();
      if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a())) {
        a(((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBundleExtra("key_invoke_troop_robot_function"));
      }
      long l2 = SystemClock.uptimeMillis();
      paramBundle = new StringBuilder();
      paramBundle.append("robot: AllTime = ");
      paramBundle.append(l2 - l1);
      paramBundle.append("ms");
      QLog.i("TroopRobotShortcutBarService", 2, paramBundle.toString());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str1 = paramBundle.getString("troopuin");
    String str2 = paramBundle.getString("robotuin");
    String str3 = paramBundle.getString("robotname");
    String str4 = paramBundle.getString("onurl");
    String str5 = paramBundle.getString("ontitle");
    String str6 = paramBundle.getString("offurl");
    paramBundle = paramBundle.getString("offtitle");
    ThreadManager.getUIHandler().post(new TroopRobotShortcutBarService.4(this, str1, str2, str3, str6, paramBundle, str4, str5));
  }
  
  public void a(IAIOShortcutBarLogic paramIAIOShortcutBarLogic)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic = paramIAIOShortcutBarLogic;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.a();
    paramIAIOShortcutBarLogic = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
    if (paramIAIOShortcutBarLogic == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramIAIOShortcutBarLogic.a());
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelLayoutListener = new TroopRobotShortcutBarService.1(this);
  }
  
  public void a(String paramString)
  {
    long l;
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RobotRed UpdateRobotInfoInSubThread EXCEP");
      localStringBuilder.append(paramString.toString());
      QLog.e("TroopRobotShortcutBarService", 2, localStringBuilder.toString());
      l = 0L;
    }
    if (l == 0L)
    {
      QLog.e("TroopRobotShortcutBarService", 2, "RobotRed troopUin is 0 ");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new TroopRobotShortcutBarService.8(this, l));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotShortcutBarService", 2, "adjustBlurView : pie is invalid");
      }
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
    if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
    {
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localLayoutParams;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("adjustBlurView :");
        localStringBuilder.append(paramBoolean);
        QLog.d("TroopRobotShortcutBarService", 2, localStringBuilder.toString());
      }
      if (paramBoolean)
      {
        localLayoutParams1.addRule(6, 2131362479);
        localLayoutParams1.topMargin = 0;
      }
      else
      {
        localLayoutParams1.addRule(6, 2131368875);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(localLayoutParams);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramLong);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      this.jdField_b_of_type_JavaLangString = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout;
      if (localObject == null) {
        return;
      }
      ((TroopAIORobotLayout)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, new TroopRobotShortcutBarService.2(this));
      localObject = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
      ((ITroopRobotService)localObject).openTalking(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      localObject = ((ITroopRobotService)localObject).readRobotPanelData(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        try
        {
          new cmd0x934.RspBody().mergeFrom((byte[])localObject);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopRobotShortcutBarService", 2, localInvalidProtocolBufferMicroException.getMessage());
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 6);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (b())
    {
      if (paramMotionEvent == null) {
        return false;
      }
      RobotPanelLayoutBase localRobotPanelLayoutBase = a();
      if (localRobotPanelLayoutBase == null) {
        return false;
      }
      int i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      paramMotionEvent = new int[2];
      localRobotPanelLayoutBase.getLocationOnScreen(paramMotionEvent);
      if (new RectF(paramMotionEvent[0], paramMotionEvent[1], paramMotionEvent[0] + localRobotPanelLayoutBase.getWidth(), paramMotionEvent[1] + localRobotPanelLayoutBase.getHeight()).contains(i, j)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (!paramBoolean)
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramMotionEvent != null)
      {
        paramMotionEvent = ((ISpriteScriptManager)paramMotionEvent.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteContext();
        break label40;
      }
    }
    paramMotionEvent = null;
    label40:
    if ((paramMotionEvent != null) && (paramMotionEvent.a()) && (localRobotPanelLayoutBase != null) && (b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotShortcutBarService", 2, "onDoubleTap, do not show sprite!!");
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      RobotPanelLayoutBase localRobotPanelLayoutBase = a();
      if (localRobotPanelLayoutBase == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("invokeRobotFunction, troopuin:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" robotuin:");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(" robotname:");
        ((StringBuilder)localObject).append(paramString3);
        QLog.d("TroopRobotShortcutBarService", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a())
      {
        if (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          return false;
        }
        if (!((ITroopRobotService)localObject).isRobotTroop(paramString1))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("invokeRobotFunction, is not rotot troop:");
            paramString2.append(paramString1);
            QLog.d("TroopRobotShortcutBarService", 2, paramString2.toString());
          }
          return false;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() != 6) {
          break label250;
        }
        if (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          return false;
        }
      }
      localRobotPanelLayoutBase.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, paramString1, paramString2, paramString3, paramString5, paramString4, paramString7, paramString6);
      return true;
    }
    label250:
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = this.d;
    this.d = paramBoolean;
    return bool;
  }
  
  public int b()
  {
    return c();
  }
  
  ViewGroup.LayoutParams b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(2, 2131368875);
    return localLayoutParams;
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.a() == a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.d();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryShowRobotLayout:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopRobotShortcutBarService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotShortcutBarService", 2, "tryShowRobotLayout, panel is null");
      }
      return;
    }
    if (!paramBoolean)
    {
      if (!b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRobotShortcutBarService", 2, "tryShowRobotLayout, panel is hide");
        }
        return;
      }
      a(paramBoolean);
      return;
    }
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotShortcutBarService", 2, "tryShowRobotLayout, panel is show");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a()) && (this.jdField_a_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      ((TroopAIORobotLayout)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, new TroopRobotShortcutBarService.3(this, str));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 6)
    {
      f();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotShortcutBarService", 2, "tryShowRobotLayout, mIsShowRobotIcon = false");
    }
  }
  
  public boolean b()
  {
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    boolean bool2 = false;
    if (localRobotPanelLayoutBase == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.a() == a())
    {
      bool1 = bool2;
      if (a().getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int c()
  {
    Object localObject = a();
    if (localObject == null) {
      return 0;
    }
    int j = ((RobotPanelLayoutBase)localObject).getHeight();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRobotPanelHeight : robotheight:");
      localStringBuilder.append(j);
      QLog.d("TroopRobotShortcutBarService", 2, localStringBuilder.toString());
    }
    int i = j;
    if (j == 0)
    {
      i = this.jdField_a_of_type_Int;
      if (i != 0) {
        return i;
      }
      ((RobotPanelLayoutBase)localObject).measure(0, 0);
      j = ((RobotPanelLayoutBase)localObject).getMeasuredHeight();
      this.jdField_a_of_type_Int = j;
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRobotPanelHeight : measure height:");
        ((StringBuilder)localObject).append(j);
        QLog.d("TroopRobotShortcutBarService", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
    }
    if (i == 0) {
      return 0;
    }
    return i;
  }
  
  void c()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString))) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if (localObject != null) {
      localObject = ((XEditTextEx)localObject).getEditableText();
    } else {
      localObject = null;
    }
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (AtTroopMemberSpan[])((Editable)localObject).getSpans(0, localObject.toString().length(), AtTroopMemberSpan.class);
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= localObject.length) {
        break;
      }
      if (localITroopRobotService.isRobotUin(localObject[i].a()))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("needFilterRobot : ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("TroopRobotShortcutBarService", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  void d()
  {
    g();
    i();
    k();
  }
  
  public void e()
  {
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    if (localITroopRobotService.isRobotTroop(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!this.c)
      {
        Object localObject = (AtTroopMemberSpan[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString().length(), AtTroopMemberSpan.class);
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        int i = 0;
        for (;;)
        {
          int j = localObject.length;
          bool2 = true;
          if (i >= j) {
            break;
          }
          if (localITroopRobotService.isRobotUin(localObject[i].a()))
          {
            this.jdField_a_of_type_JavaLangString = localObject[i].a();
            localITroopRobotService.setCurrentAtRobotUin(this.jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_JavaLangString = localObject[i].b();
            bool1 = bool2;
            if (!this.jdField_b_of_type_JavaLangString.startsWith("@")) {
              break label191;
            }
            this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.substring(1);
            bool1 = bool2;
            break label191;
          }
          i += 1;
        }
        boolean bool1 = false;
        label191:
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout;
        boolean bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (((TroopAIORobotLayout)localObject).a() != null)
          {
            bool2 = bool1;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a().equals(this.jdField_a_of_type_JavaLangString)) {
              bool2 = false;
            }
          }
        }
        ((SimpleUIAIOHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(29)).d(bool2);
        if (this.jdField_b_of_type_Boolean == bool2)
        {
          if (bool2) {
            a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
          }
          return;
        }
        this.jdField_b_of_type_Boolean = bool2;
        if (!bool2)
        {
          c(false);
          a(false);
          if (localITroopRobotService.isTalking())
          {
            localITroopRobotService.closeTalking();
            localITroopRobotService.report("panel", "talk_out", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(), "2", "");
            localITroopRobotService.reqGrayTips(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), Long.parseLong(this.jdField_a_of_type_JavaLangString), "off", new TroopRobotShortcutBarService.5(this));
          }
        }
        else if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, new TroopRobotShortcutBarService.6(this));
        }
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      c(false);
      a(false);
    }
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, new TroopRobotShortcutBarService.7(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 3)
    {
      ITroopRobotService localITroopRobotService = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
      localITroopRobotService.release(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "off");
      localITroopRobotService.setOnTalkingChangeListener(null);
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotShortcutBarService", 2, "initRobotPanel");
    }
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotShortcutBarService", 2, "initRobotPanel, create panel ");
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 6) {
      localObject = (RobotChatPanelLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558574, null);
    } else {
      localObject = (TroopAIORobotLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558594, null);
    }
    j();
    if (localObject == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = ((RobotPanelLayoutBase)localObject).getLayoutParams();
    if ((localLayoutParams instanceof RelativeLayout.LayoutParams)) {
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(2, 2131368875);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 6) {
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout = ((RobotChatPanelLayout)localObject);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout = ((TroopAIORobotLayout)localObject);
    }
    ((RobotPanelLayoutBase)localObject).setListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelLayoutListener);
    a(false);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotShortcutBarService", 2, "unInitRobotPanel");
    }
    if (!a()) {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a()) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout;
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 6) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatPanelLayout;
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    ((RobotPanelLayoutBase)localObject).setListener(null);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService
 * JD-Core Version:    0.7.0.1
 */