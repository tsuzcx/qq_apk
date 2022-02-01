package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class TroopAppShortcutHelper
  implements ILifeCycleHelper
{
  public NavigateBarManager a;
  private QQAppInterface b;
  private Context c;
  private Activity d;
  private BaseChatPie e;
  private SessionInfo f;
  
  public TroopAppShortcutHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie.d;
    this.c = paramBaseChatPie.e;
    this.d = paramBaseChatPie.f;
    this.e = paramBaseChatPie;
    this.f = paramBaseChatPie.ah;
  }
  
  private BaseChatDrawer f()
  {
    Object localObject = this.f;
    if ((localObject != null) && (!TextUtils.isEmpty(((SessionInfo)localObject).b)))
    {
      localObject = this.e;
      if (localObject != null) {
        return new TroopAppShortcutDrawer((BaseChatPie)localObject);
      }
    }
    QLog.d("TroopAppShortcutHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
    return null;
  }
  
  public void a()
  {
    NavigateBarManager localNavigateBarManager = this.a;
    if (localNavigateBarManager != null)
    {
      localNavigateBarManager.b();
      this.a = null;
    }
  }
  
  public void b()
  {
    BaseChatPie localBaseChatPie = this.e;
    if ((localBaseChatPie instanceof TroopChatPie)) {
      ((ChatDrawerHelper)localBaseChatPie.q(124)).b = f();
    }
    if ((((ChatDrawerHelper)this.e.q(124)).b != null) && ((this.e instanceof TroopChatPie)))
    {
      if (!AnonymousChatHelper.a().a(this.e.ah.b))
      {
        SimpleModeHelper.a((InputLinearLayout)this.e.aZ.findViewById(2131435809));
        if (!ThemeUtil.isDefaultTheme()) {
          this.e.p.setBackgroundResource(2130852228);
        } else {
          this.e.p.setBackgroundResource(2130852229);
        }
        this.e.ba.setBackgroundDrawable(this.e.ah.H.c);
        return;
      }
      this.e.ba.setBackgroundResource(2130844752);
      this.e.p.setBackgroundResource(2130844758);
    }
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    if (this.a == null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.e.aZ.findViewById(2131430542);
      this.a = new NavigateBarManager(this.e, this.b, this.c, this.f, localRelativeLayout);
    }
    this.a.a(3);
    this.a.c(75);
    this.a.a();
  }
  
  public void e()
  {
    NavigateBarManager localNavigateBarManager = this.a;
    if (localNavigateBarManager == null) {
      return;
    }
    localNavigateBarManager.d(3);
  }
  
  public String getTag()
  {
    return "TroopAppShortcutHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        a();
        return;
      }
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutHelper
 * JD-Core Version:    0.7.0.1
 */