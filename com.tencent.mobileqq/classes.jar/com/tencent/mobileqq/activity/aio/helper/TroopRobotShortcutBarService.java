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
  private IAIOShortcutBarLogic a;
  private AIOShortcutBarContext b;
  private QQAppInterface c;
  private Context d;
  private SessionInfo e;
  private XEditTextEx f;
  private RobotPanelLayoutBase.RobotPanelLayoutListener g = null;
  private boolean h;
  private TroopAIORobotLayout i;
  private RobotChatPanelLayout j;
  private boolean k;
  private String l;
  private String m;
  private boolean n = false;
  private int o = 0;
  private boolean p = false;
  private DrawerFrame.TouchEventConsumer q = new TroopRobotShortcutBarService.9(this);
  
  private int b(int paramInt)
  {
    if (paramInt == 4) {
      return AIOUtils.b(-11.0F, this.d.getResources());
    }
    return 0;
  }
  
  private void w()
  {
    Object localObject = (ISpriteScriptManager)this.c.getRuntimeService(ISpriteScriptManager.class, "all");
    ISpriteContext localISpriteContext = ((ISpriteScriptManager)localObject).getSpriteContext();
    if (localISpriteContext == null) {
      return;
    }
    if (localISpriteContext.a()) {
      return;
    }
    localObject = ((ISpriteScriptManager)localObject).getUIHandler();
    if (localObject != null) {
      ((ISpriteUIHandler)localObject).a(this.c, this.e.a, this.e.b);
    }
  }
  
  public View a()
  {
    return i();
  }
  
  public void a(int paramInt)
  {
    Object localObject = i();
    if (localObject != null)
    {
      if (!k()) {
        return;
      }
      int i1 = ((RobotPanelLayoutBase)localObject).getInputLineCount();
      if (paramInt == i1) {
        return;
      }
      ((RobotPanelLayoutBase)localObject).setInputLineCount(paramInt);
      if ((i1 == 4) || (paramInt == 4))
      {
        paramInt = b(paramInt);
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
                e(false);
                b(false);
                return;
              case 25: 
                this.l = paramBundle.getString("mCurrentRobotUin", this.l);
                this.m = paramBundle.getString("mCurrentRobotNickname", this.m);
                this.n = paramBundle.getBoolean("isSending", this.n);
                this.k = paramBundle.getBoolean("mHasRobotOlgFlag", this.k);
                paramBundle.putBoolean("isSending", this.n);
                paramBundle.putBoolean("mIsShowRobotIcon", this.h);
                paramBundle.putString("mCurrentRobotUin", this.l);
                return;
              case 24: 
                paramBundle.putBoolean("result", t());
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
                m();
                return;
              case 22: 
                e();
                return;
              }
              break;
            case 20: 
              a(paramBundle);
              return;
            case 19: 
              n();
              return;
            case 18: 
              paramBundle.putBoolean("result", a(paramBundle.getBoolean("isSendToRobotServer", false)));
              return;
            case 17: 
              q();
              return;
            case 16: 
              d(false);
              return;
            case 15: 
              d(true);
              return;
            case 14: 
              a(true, paramBundle.getLong("roBotUin"));
              return;
            case 13: 
              paramBundle.putBoolean("result", a(null, paramBundle.getBoolean("isJubaoMode", false)));
              return;
            }
          } else {
            f();
          }
        }
        else {
          h();
        }
      }
      else {
        g();
      }
    }
    else
    {
      long l1 = SystemClock.uptimeMillis();
      if (((this.d instanceof Activity)) && (this.b.b())) {
        a(((Activity)this.d).getIntent().getBundleExtra("key_invoke_troop_robot_function"));
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
    this.a = paramIAIOShortcutBarLogic;
    this.b = this.a.a();
    paramIAIOShortcutBarLogic = this.b;
    if (paramIAIOShortcutBarLogic == null) {
      return;
    }
    this.c = ((QQAppInterface)paramIAIOShortcutBarLogic.c());
    this.d = this.b.e();
    this.e = this.b.d();
    this.f = this.b.k();
    this.g = new TroopRobotShortcutBarService.1(this);
  }
  
  public void a(String paramString)
  {
    long l1;
    try
    {
      l1 = Long.parseLong(paramString);
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RobotRed UpdateRobotInfoInSubThread EXCEP");
      localStringBuilder.append(paramString.toString());
      QLog.e("TroopRobotShortcutBarService", 2, localStringBuilder.toString());
      l1 = 0L;
    }
    if (l1 == 0L)
    {
      QLog.e("TroopRobotShortcutBarService", 2, "RobotRed troopUin is 0 ");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new TroopRobotShortcutBarService.8(this, l1));
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramLong);
      this.l = ((StringBuilder)localObject).toString();
      this.m = ContactUtils.d(this.c, this.l);
      localObject = this.i;
      if (localObject == null) {
        return;
      }
      ((TroopAIORobotLayout)localObject).a(this.e.b, this.l, this.m, this.b, new TroopRobotShortcutBarService.2(this));
      localObject = (ITroopRobotService)this.c.getRuntimeService(ITroopRobotService.class, "all");
      ((ITroopRobotService)localObject).openTalking(this.e.b, this.l, this.m);
      localObject = ((ITroopRobotService)localObject).readRobotPanelData(this.e.b, this.l);
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
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (k())
    {
      if (paramMotionEvent == null) {
        return false;
      }
      RobotPanelLayoutBase localRobotPanelLayoutBase = i();
      if (localRobotPanelLayoutBase == null) {
        return false;
      }
      int i1 = (int)(paramMotionEvent.getX() + 0.5F);
      int i2 = (int)(paramMotionEvent.getY() + 0.5F);
      paramMotionEvent = new int[2];
      localRobotPanelLayoutBase.getLocationOnScreen(paramMotionEvent);
      if (new RectF(paramMotionEvent[0], paramMotionEvent[1], paramMotionEvent[0] + localRobotPanelLayoutBase.getWidth(), paramMotionEvent[1] + localRobotPanelLayoutBase.getHeight()).contains(i1, i2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    RobotPanelLayoutBase localRobotPanelLayoutBase = i();
    if (!paramBoolean)
    {
      paramMotionEvent = this.c;
      if (paramMotionEvent != null)
      {
        paramMotionEvent = ((ISpriteScriptManager)paramMotionEvent.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteContext();
        break label40;
      }
    }
    paramMotionEvent = null;
    label40:
    if ((paramMotionEvent != null) && (paramMotionEvent.a()) && (localRobotPanelLayoutBase != null) && (k()))
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
      RobotPanelLayoutBase localRobotPanelLayoutBase = i();
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
      Object localObject = (ITroopRobotService)this.c.getRuntimeService(ITroopRobotService.class, "all");
      if (this.b.b())
      {
        if (!paramString1.equals(this.e.b)) {
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
        if (this.b.a() != 6) {
          break label252;
        }
        if (!paramString2.equals(this.e.b)) {
          return false;
        }
      }
      localRobotPanelLayoutBase.a(this.b, paramString1, paramString2, paramString3, paramString5, paramString4, paramString7, paramString6);
      return true;
    }
    label252:
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = this.p;
    this.p = paramBoolean;
    return bool;
  }
  
  public ViewGroup.LayoutParams b()
  {
    return r();
  }
  
  public String b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showRobotLayout : ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("TroopRobotShortcutBarService", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = i();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = ((RobotPanelLayoutBase)localObject2).getCurrentRobotUin();
    if (paramBoolean)
    {
      if (((RobotPanelLayoutBase)localObject2).getItemCount() == 0) {
        return localObject1;
      }
      if (!k()) {
        RobotUtils.a(this.c, "0X8009FA1", (String)localObject1, "");
      }
      this.a.b(c());
      w();
      if (((RobotPanelLayoutBase)localObject2).getInputLineCount() == 0)
      {
        localObject2 = this.f;
        if (localObject2 != null) {
          a(((XEditTextEx)localObject2).getLineCount());
        }
      }
    }
    else
    {
      this.a.a(c());
    }
    c(paramBoolean);
    this.b.g();
    this.b.h();
    return localObject1;
  }
  
  public int c()
  {
    return 1;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!j())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotShortcutBarService", 2, "adjustBlurView : pie is invalid");
      }
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.b.i();
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
        localLayoutParams1.addRule(6, 2131428088);
        localLayoutParams1.topMargin = 0;
      }
      else
      {
        localLayoutParams1.addRule(6, 2131435809);
      }
    }
    this.b.a(localLayoutParams);
  }
  
  public int d()
  {
    return l();
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryShowRobotLayout:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopRobotShortcutBarService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = i();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotShortcutBarService", 2, "tryShowRobotLayout, panel is null");
      }
      return;
    }
    if (!paramBoolean)
    {
      if (!k())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRobotShortcutBarService", 2, "tryShowRobotLayout, panel is hide");
        }
        return;
      }
      b(paramBoolean);
      return;
    }
    if (k())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotShortcutBarService", 2, "tryShowRobotLayout, panel is show");
      }
      return;
    }
    if ((this.b.b()) && (this.h))
    {
      String str = this.l;
      ((TroopAIORobotLayout)localObject).a(this.e.b, str, this.m, this.b, new TroopRobotShortcutBarService.3(this, str));
      return;
    }
    if (this.b.a() == 6)
    {
      n();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotShortcutBarService", 2, "tryShowRobotLayout, mIsShowRobotIcon = false");
    }
  }
  
  void e()
  {
    if ((this.b != null) && (this.a.b() == c())) {
      this.b.q();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  void f()
  {
    if ((this.b != null) && (this.a.b() == c())) {
      this.b.p();
    }
  }
  
  void g()
  {
    SessionInfo localSessionInfo = this.e;
    if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.b))) {
      a(this.e.b);
    }
  }
  
  void h()
  {
    p();
    s();
    v();
  }
  
  public RobotPanelLayoutBase i()
  {
    if (this.b.a() == 6) {
      return this.j;
    }
    return this.i;
  }
  
  public boolean j()
  {
    return (this.b.b()) || (this.b.a() == 3) || (this.b.a() == 6);
  }
  
  public boolean k()
  {
    RobotPanelLayoutBase localRobotPanelLayoutBase = i();
    boolean bool2 = false;
    if (localRobotPanelLayoutBase == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.a.b() == c())
    {
      bool1 = bool2;
      if (i().getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int l()
  {
    Object localObject = i();
    if (localObject == null) {
      return 0;
    }
    int i2 = ((RobotPanelLayoutBase)localObject).getHeight();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRobotPanelHeight : robotheight:");
      localStringBuilder.append(i2);
      QLog.d("TroopRobotShortcutBarService", 2, localStringBuilder.toString());
    }
    int i1 = i2;
    if (i2 == 0)
    {
      i1 = this.o;
      if (i1 != 0) {
        return i1;
      }
      ((RobotPanelLayoutBase)localObject).measure(0, 0);
      i2 = ((RobotPanelLayoutBase)localObject).getMeasuredHeight();
      this.o = i2;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRobotPanelHeight : measure height:");
        ((StringBuilder)localObject).append(i2);
        QLog.d("TroopRobotShortcutBarService", 2, ((StringBuilder)localObject).toString());
        i1 = i2;
      }
    }
    if (i1 == 0) {
      return 0;
    }
    return i1;
  }
  
  public void m()
  {
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.c.getRuntimeService(ITroopRobotService.class, "all");
    if (localITroopRobotService.isRobotTroop(this.e.b))
    {
      if (!this.n)
      {
        Object localObject = (AtTroopMemberSpan[])this.f.getEditableText().getSpans(0, this.f.getEditableText().toString().length(), AtTroopMemberSpan.class);
        String str = this.e.b;
        int i1 = 0;
        for (;;)
        {
          int i2 = localObject.length;
          bool2 = true;
          if (i1 >= i2) {
            break;
          }
          if (localITroopRobotService.isRobotUin(localObject[i1].a()))
          {
            this.l = localObject[i1].a();
            localITroopRobotService.setCurrentAtRobotUin(this.l);
            this.m = localObject[i1].b();
            bool1 = bool2;
            if (!this.m.startsWith("@")) {
              break label191;
            }
            this.m = this.m.substring(1);
            bool1 = bool2;
            break label191;
          }
          i1 += 1;
        }
        boolean bool1 = false;
        label191:
        localObject = this.i;
        boolean bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (((TroopAIORobotLayout)localObject).getCurrentRobotUin() != null)
          {
            bool2 = bool1;
            if (!this.i.getCurrentRobotUin().equals(this.l)) {
              bool2 = false;
            }
          }
        }
        ((SimpleUIAIOHelper)this.b.a(29)).d(bool2);
        if (this.k == bool2)
        {
          if (bool2) {
            a(this.f.getLineCount());
          }
          return;
        }
        this.k = bool2;
        if (!bool2)
        {
          e(false);
          b(false);
          if (localITroopRobotService.isTalking())
          {
            localITroopRobotService.closeTalking();
            localITroopRobotService.report("panel", "talk_out", this.e.b, this.i.getCurrentRobotUin(), "2", "");
            localITroopRobotService.reqGrayTips(Long.parseLong(this.e.b), Long.parseLong(this.l), "off", new TroopRobotShortcutBarService.5(this));
          }
        }
        else if (!this.h)
        {
          this.i.a(str, this.l, this.m, this.b, new TroopRobotShortcutBarService.6(this));
        }
      }
    }
    else if (this.h)
    {
      e(false);
      b(false);
    }
  }
  
  void n()
  {
    this.j.a(this.e.b, o(), this.b, new TroopRobotShortcutBarService.7(this));
  }
  
  public String o()
  {
    SessionInfo localSessionInfo = this.e;
    if (localSessionInfo != null)
    {
      if (!TextUtils.isEmpty(localSessionInfo.e)) {
        return this.e.e;
      }
      return this.e.b;
    }
    return null;
  }
  
  public void p()
  {
    if (this.b.a() == 3)
    {
      ITroopRobotService localITroopRobotService = (ITroopRobotService)this.c.getRuntimeService(ITroopRobotService.class, "all");
      localITroopRobotService.release(this.e.b, this.l, "off");
      localITroopRobotService.setOnTalkingChangeListener(null);
    }
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotShortcutBarService", 2, "initRobotPanel");
    }
    if (!j()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotShortcutBarService", 2, "initRobotPanel, create panel ");
    }
    Object localObject;
    if (this.b.a() == 6) {
      localObject = (RobotChatPanelLayout)LayoutInflater.from(this.d).inflate(2131624131, null);
    } else {
      localObject = (TroopAIORobotLayout)LayoutInflater.from(this.d).inflate(2131624153, null);
    }
    u();
    if (localObject == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = ((RobotPanelLayoutBase)localObject).getLayoutParams();
    if ((localLayoutParams instanceof RelativeLayout.LayoutParams)) {
      ((RelativeLayout.LayoutParams)localLayoutParams).addRule(2, 2131435809);
    }
    if (this.b.a() == 6) {
      this.j = ((RobotChatPanelLayout)localObject);
    } else {
      this.i = ((TroopAIORobotLayout)localObject);
    }
    ((RobotPanelLayoutBase)localObject).setListener(this.g);
    b(false);
  }
  
  ViewGroup.LayoutParams r()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(2, 2131435809);
    return localLayoutParams;
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotShortcutBarService", 2, "unInitRobotPanel");
    }
    if (!j()) {
      return;
    }
    Object localObject;
    if (this.b.b()) {
      localObject = this.i;
    } else if (this.b.a() == 6) {
      localObject = this.j;
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    ((RobotPanelLayoutBase)localObject).setListener(null);
  }
  
  public boolean t()
  {
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.c.getRuntimeService(ITroopRobotService.class, "all");
    Object localObject = this.f;
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
    int i1 = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= localObject.length) {
        break;
      }
      if (localITroopRobotService.isRobotUin(localObject[i1].a()))
      {
        bool1 = true;
        break;
      }
      i1 += 1;
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
  
  public void u()
  {
    this.b.a(this.q);
  }
  
  public void v()
  {
    this.b.b(this.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService
 * JD-Core Version:    0.7.0.1
 */