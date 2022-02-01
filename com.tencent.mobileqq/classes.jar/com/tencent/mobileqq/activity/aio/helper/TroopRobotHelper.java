package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteUIHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.RobotPanelLayoutListener;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public class TroopRobotHelper
  implements ILifeCycleHelper
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RobotPanelLayoutBase.RobotPanelLayoutListener jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelLayoutListener = null;
  private DrawerFrame.TouchEventConsumer jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer = new TroopRobotHelper.5(this);
  
  public TroopRobotHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelLayoutListener = new TroopRobotHelper.1(this);
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 4) {
      return AIOUtils.a(-11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    return 0;
  }
  
  private void e()
  {
    Object localObject = (ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
    ISpriteContext localISpriteContext = ((ISpriteScriptManager)localObject).getSpriteContext();
    if (localISpriteContext == null) {}
    do
    {
      do
      {
        return;
      } while (localISpriteContext.a());
      localObject = ((ISpriteScriptManager)localObject).getUIHandler();
    } while (localObject == null);
    ((ISpriteUIHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public int a()
  {
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (localRobotPanelLayoutBase == null) {}
    int i;
    do
    {
      return 0;
      int j = localRobotPanelLayoutBase.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "getRobotPanelHeight : robotheight:" + j);
      }
      i = j;
      if (j == 0)
      {
        if (this.jdField_a_of_type_Int != 0) {
          return this.jdField_a_of_type_Int;
        }
        localRobotPanelLayoutBase.measure(0, 0);
        j = localRobotPanelLayoutBase.getMeasuredHeight();
        this.jdField_a_of_type_Int = j;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopRobotHelper", 2, "getRobotPanelHeight : measure height:" + j);
          i = j;
        }
      }
    } while (i == 0);
    return i;
  }
  
  public RobotPanelLayoutBase a()
  {
    TroopAIORobotLayout localTroopAIORobotLayout = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) {
      localTroopAIORobotLayout = ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a;
    }
    while (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie)) {
      return localTroopAIORobotLayout;
    }
    return ((RobotChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a;
  }
  
  public String a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "showRobotLayout : " + paramBoolean);
    }
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    Object localObject;
    if (localRobotPanelLayoutBase == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = localRobotPanelLayoutBase.a();
      if (!paramBoolean) {
        break;
      }
      localObject = str;
    } while (localRobotPanelLayoutBase.b() == 0);
    if (localRobotPanelLayoutBase.getVisibility() != 0) {
      RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA1", str, "");
    }
    localRobotPanelLayoutBase.setVisibility(0);
    e();
    if ((localRobotPanelLayoutBase.c() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
    }
    for (;;)
    {
      a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.requestLayout();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestLayout();
      return str;
      localRobotPanelLayoutBase.setVisibility(8);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "initRobotPanel");
    }
    if (!a()) {}
    label405:
    label406:
    for (;;)
    {
      return;
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364598);
      if ((localViewGroup != null) && (this.jdField_a_of_type_AndroidContentContext != null))
      {
        Object localObject1 = (RobotPanelLayoutBase)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131362523);
        c();
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopRobotHelper", 2, "initRobotPanel, find panel , reinit");
          }
          ((RobotPanelLayoutBase)localObject1).d();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) {
            ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a = ((TroopAIORobotLayout)localObject1);
          }
          for (;;)
          {
            ((RobotPanelLayoutBase)localObject1).setListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelLayoutListener);
            return;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie)) {
              ((RobotChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a = ((RobotChatPanelLayout)localObject1);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopRobotHelper", 2, "initRobotPanel, create panel ");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) {
          localObject1 = (TroopAIORobotLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558696, localViewGroup, false);
        }
        for (;;)
        {
          label193:
          if (localObject1 == null) {
            break label406;
          }
          Object localObject2 = ((RobotPanelLayoutBase)localObject1).getLayoutParams();
          if ((localObject2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131369142);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131362415);
          int i = 1;
          if (localObject2 != null) {
            i = localViewGroup.indexOfChild((View)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopRobotHelper", 2, "initRobotPanel, addview index:" + i);
          }
          localViewGroup.addView((View)localObject1, i);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) {
            ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a = ((TroopAIORobotLayout)localObject1);
          }
          for (;;)
          {
            ((RobotPanelLayoutBase)localObject1).setListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelLayoutListener);
            localObject1 = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(23);
            if (localObject1 == null) {
              break;
            }
            ((TroopRobotHelper)localObject1).a(false);
            return;
            if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie)) {
              break label405;
            }
            localObject1 = (RobotChatPanelLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558676, localViewGroup, false);
            break label193;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie)) {
              ((RobotChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a = ((RobotChatPanelLayout)localObject1);
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = a();
    if ((localObject == null) || (((RobotPanelLayoutBase)localObject).getVisibility() != 0)) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          i = ((RobotPanelLayoutBase)localObject).c();
        } while (paramInt == i);
        ((RobotPanelLayoutBase)localObject).setInputLineCount(paramInt);
      } while ((i != 4) && (paramInt != 4));
      paramInt = a(paramInt);
      localObject = ((RobotPanelLayoutBase)localObject).getLayoutParams();
    } while (!(localObject instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
  }
  
  public void a(int paramInt, RobotPanelLayoutBase paramRobotPanelLayoutBase, RelativeLayout paramRelativeLayout)
  {
    if ((paramRobotPanelLayoutBase == null) || (paramRelativeLayout == null)) {}
    do
    {
      do
      {
        return;
        paramRobotPanelLayoutBase = (TextView)paramRelativeLayout.findViewById(2131371965);
        if (paramRobotPanelLayoutBase != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopRobotHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRobotPanelLayoutBase = paramRobotPanelLayoutBase.getLayoutParams();
    } while (!(paramRobotPanelLayoutBase instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRobotPanelLayoutBase).addRule(2, 2131362523);
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
    ThreadManager.getUIHandler().post(new TroopRobotHelper.3(this, str1, str2, str3, str6, paramBundle, str4, str5));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
      } while (a() == null);
      paramView = paramView.getLayoutParams();
    } while (!(paramView instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramView).addRule(2, 2131362523);
  }
  
  public void a(String paramString)
  {
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l == 0L)
      {
        QLog.e("TroopRobotHelper", 2, "RobotRed troopUin is 0 ");
        return;
      }
    }
    catch (Exception paramString)
    {
      long l;
      for (;;)
      {
        QLog.e("TroopRobotHelper", 2, "RobotRed UpdateRobotInfoInSubThread EXCEP" + paramString.toString());
        l = 0L;
      }
      ThreadManager.getSubThreadHandler().post(new TroopRobotHelper.4(this, l));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "adjustBlurView : pie is invalid");
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131381097);
        if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopRobotHelper", 2, "adjustBlurView : blur not visible");
      return;
      localObject = ((View)localObject).getLayoutParams();
    } while (!(localObject instanceof RelativeLayout.LayoutParams));
    Object localObject = (RelativeLayout.LayoutParams)localObject;
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "adjustBlurView :" + paramBoolean);
    }
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131362523);
      return;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131369142);
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie));
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((!b()) || (paramMotionEvent == null)) {}
    RobotPanelLayoutBase localRobotPanelLayoutBase;
    int i;
    int j;
    float f1;
    float f2;
    float f3;
    int k;
    do
    {
      do
      {
        return false;
        localRobotPanelLayoutBase = a();
      } while (localRobotPanelLayoutBase == null);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      paramMotionEvent = new int[2];
      localRobotPanelLayoutBase.getLocationOnScreen(paramMotionEvent);
      f1 = paramMotionEvent[0];
      f2 = paramMotionEvent[1];
      f3 = paramMotionEvent[0] + localRobotPanelLayoutBase.getWidth();
      k = paramMotionEvent[1];
    } while (!new RectF(f1, f2, f3, localRobotPanelLayoutBase.getHeight() + k).contains(i, j));
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    Object localObject = null;
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    paramMotionEvent = localObject;
    if (!paramBoolean)
    {
      paramMotionEvent = localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        paramMotionEvent = ((ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteContext();
      }
    }
    if ((paramMotionEvent != null) && (paramMotionEvent.a()) && (localRobotPanelLayoutBase != null) && (localRobotPanelLayoutBase.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "onDoubleTap, do not show sprite!!");
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (localRobotPanelLayoutBase == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "invokeRobotFunction, troopuin:" + paramString1 + " robotuin:" + paramString2 + " robotname:" + paramString3);
    }
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie))
    {
      if (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      if (!localTroopRobotManager.a(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRobotHelper", 2, "invokeRobotFunction, is not rotot troop:" + paramString1);
        }
        return false;
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie))
    {
      if (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return false;
      }
    }
    else
    {
      return false;
    }
    localRobotPanelLayoutBase.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramString1, paramString2, paramString3, paramString5, paramString4, paramString7, paramString6);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "unInitRobotPanel");
    }
    if (!a()) {}
    for (;;)
    {
      return;
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) {
        localObject = ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a;
      }
      while (localObject != null)
      {
        ((RobotPanelLayoutBase)localObject).setListener(null);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie)) {
          localObject = ((RobotChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a;
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout:" + paramBoolean);
    }
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (localRobotPanelLayoutBase == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout, panel is null");
      }
    }
    label91:
    do
    {
      do
      {
        do
        {
          return;
          if (paramBoolean) {
            break label91;
          }
          if (localRobotPanelLayoutBase.getVisibility() == 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout, panel is hide");
        return;
        a(paramBoolean);
        return;
        if (localRobotPanelLayoutBase.getVisibility() != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout, panel is show");
      return;
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) && (((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).R))
      {
        String str1 = ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).f;
        String str2 = ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).g;
        ((TroopAIORobotLayout)localRobotPanelLayoutBase).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str1, str2, (BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, new TroopRobotHelper.2(this, str1));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof RobotChatPie))
      {
        if (localRobotPanelLayoutBase.b() > 0)
        {
          a(true);
          return;
        }
        a(false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopRobotHelper", 2, "tryShowRobotLayout, mIsShowRobotIcon = false");
  }
  
  public boolean b()
  {
    RobotPanelLayoutBase localRobotPanelLayoutBase = a();
    if (localRobotPanelLayoutBase == null) {}
    while (localRobotPanelLayoutBase.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
    }
  }
  
  public String getTag()
  {
    return "TroopRobotHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      break;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper
 * JD-Core Version:    0.7.0.1
 */