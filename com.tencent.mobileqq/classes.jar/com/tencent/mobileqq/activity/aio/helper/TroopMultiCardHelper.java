package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.TroopMultiCardDrawer;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.GroupIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.GroupIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigData;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopMultiCardHelper
  implements ILifeCycleHelper
{
  private static int g = -1;
  public NavigateBarManager a;
  private QQAppInterface b;
  private Context c;
  private BaseChatPie d;
  private SessionInfo e;
  private MultiAIOEntranceConfigData f;
  
  public static boolean f()
  {
    if (g == -1) {
      g = i();
    }
    return g != 0;
  }
  
  public static boolean g()
  {
    GroupIntimateRelationshipBean localGroupIntimateRelationshipBean = GroupIntimateRelationshipConfProcessor.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSwitchOn:");
      localStringBuilder.append(localGroupIntimateRelationshipBean.a);
      QLog.d("TroopMultiCardHelper", 2, localStringBuilder.toString());
    }
    return localGroupIntimateRelationshipBean.a;
  }
  
  private static int i()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "getLocalMultiCardSwitchStatus() called load from sp");
      }
      localObject = (QQAppInterface)localObject;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("multicard_switch_sp");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getInt("key_multicard_switch", 1);
    }
    return -1;
  }
  
  private boolean j()
  {
    if (!f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "isLocalSwitchOn: false");
      }
      return false;
    }
    if (!g()) {
      return false;
    }
    h();
    Object localObject1 = this.f.c();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.MANUFACTURER);
    ((StringBuilder)localObject2).append(Build.MODEL);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("devicetype:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" version:");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.d("TroopMultiCardHelper", 2, localStringBuilder.toString());
    }
    localObject2 = ((String)localObject2).trim();
    if ((localObject1 != null) && (((List)localObject1).contains(localObject2))) {
      return false;
    }
    localObject1 = this.f.b();
    return (TextUtils.isEmpty((CharSequence)localObject1)) || (QmcfDevicesStrategy.b((String)localObject1) > 0);
  }
  
  private BaseChatDrawer k()
  {
    if (!AIODrawerDpc.b())
    {
      QLog.d("TroopMultiCardHelper", 1, "createChatDrawer, not support!");
      return null;
    }
    Object localObject = this.e;
    if ((localObject != null) && (!TextUtils.isEmpty(((SessionInfo)localObject).b)))
    {
      localObject = this.d;
      if (localObject != null) {
        return new TroopMultiCardDrawer((BaseChatPie)localObject);
      }
    }
    QLog.d("TroopMultiCardHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
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
    if (((this.d instanceof TroopChatPie)) && (j())) {
      ((ChatDrawerHelper)this.d.q(124)).b = k();
    }
    if ((((ChatDrawerHelper)this.d.q(124)).b != null) && ((this.d instanceof TroopChatPie)))
    {
      if (!AnonymousChatHelper.a().a(this.d.ah.b))
      {
        AIOUtils.a((InputLinearLayout)this.d.aZ.findViewById(2131435809), 2130851968);
        if (!ThemeUtil.isDefaultTheme()) {
          this.d.p.setBackgroundResource(2130852228);
        } else {
          this.d.p.setBackgroundResource(2130852229);
        }
        this.d.ba.setBackgroundDrawable(this.d.ah.H.c);
        return;
      }
      this.d.ba.setBackgroundResource(2130844752);
      this.d.p.setBackgroundResource(2130844758);
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
      RelativeLayout localRelativeLayout = (RelativeLayout)this.d.aZ.findViewById(2131430542);
      this.a = new NavigateBarManager(this.d, this.b, this.c, this.e, localRelativeLayout);
    }
    this.a.a(2);
    this.a.c(75);
    this.a.a();
  }
  
  public void e()
  {
    NavigateBarManager localNavigateBarManager = this.a;
    if (localNavigateBarManager == null) {
      return;
    }
    localNavigateBarManager.d(2);
  }
  
  public String getTag()
  {
    return "TroopMultiCardHelper";
  }
  
  public void h()
  {
    this.f = ((MultiAIOEntranceConfigData)QConfigManager.b().b(478));
    if (this.f == null)
    {
      this.f = new MultiAIOEntranceConfigData();
      if (QLog.isColorLevel()) {
        QLog.d("TroopMultiCardHelper", 2, "MultiAIOEntranceConfigData =null, general new bean");
      }
    }
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopMultiCardHelper
 * JD-Core Version:    0.7.0.1
 */