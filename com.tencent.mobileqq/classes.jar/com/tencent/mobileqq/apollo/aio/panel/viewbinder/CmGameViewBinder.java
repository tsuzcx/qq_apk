package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.view.hippy.CMBattleGameFragment;
import com.tencent.mobileqq.apollo.view.hippy.ICmHippyCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class CmGameViewBinder
  extends ApolloViewBinder
  implements ICmHippyCallback
{
  private CMBattleGameFragment a;
  private int b = 0;
  
  public CmGameViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.m = paramSessionInfo;
    int i = ApolloPanelUtil.a(this.m.a);
    int j = ApolloPanelUtil.b(this.m.a);
    a(i, j, CMBattleGameFragment.a(this.j, i, j));
  }
  
  private void a(int paramInt1, int paramInt2, OpenHippyInfo paramOpenHippyInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createFragment sceneId=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" gameStyle=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("CmGameViewBinder", 2, ((StringBuilder)localObject).toString());
    }
    this.a = new CMBattleGameFragment();
    this.a.a(this);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("sceneId", paramInt1);
    ((Bundle)localObject).putInt("cmBattleGameStyle", paramInt2);
    ((Bundle)localObject).putBundle("params", paramOpenHippyInfo.toBundle());
    this.a.setArguments((Bundle)localObject);
  }
  
  private void h()
  {
    if (this.a == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showFragment mFragment.isAdded()=");
      ((StringBuilder)localObject).append(this.a.isAdded());
      QLog.d("CmGameViewBinder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AppActivity)this.i;
    if (this.a.isAdded())
    {
      ((AppActivity)localObject).getSupportFragmentManager().beginTransaction().show(this.a).commitAllowingStateLoss();
      return;
    }
    ((AppActivity)localObject).getSupportFragmentManager().beginTransaction().add(2131433669, this.a, "CMBattleGameFragment").commitAllowingStateLoss();
  }
  
  private void l()
  {
    int i = this.b;
    if (i > 3)
    {
      QLog.e("CmGameViewBinder", 1, "reload more than three times!");
      return;
    }
    this.b = (i + 1);
    i = ApolloPanelUtil.a(this.m.a);
    int j = ApolloPanelUtil.b(this.m.a);
    OpenHippyInfo localOpenHippyInfo = CMBattleGameFragment.a(this.j, i, j);
    boolean bool = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage(localOpenHippyInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reload isPreload=");
      localStringBuilder.append(bool);
      localStringBuilder.append(" retryCount=");
      localStringBuilder.append(this.b);
      QLog.d("CmGameViewBinder", 2, localStringBuilder.toString());
    }
    ((AppActivity)this.i).getSupportFragmentManager().beginTransaction().remove(this.a).commitAllowingStateLoss();
    a(i, j, localOpenHippyInfo);
    h();
  }
  
  public View a()
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.i).inflate(2131624169, null);
    h();
    return localViewGroup;
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
  }
  
  public void b()
  {
    super.b();
    CMBattleGameFragment localCMBattleGameFragment = this.a;
    if (localCMBattleGameFragment != null) {
      localCMBattleGameFragment.onDestroy();
    }
    this.j = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPanelIconClickBeforeCreate retryCount=");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("CmGameViewBinder", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b > 0)
    {
      this.b = 0;
      l();
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((CMBattleGameFragment)localObject).a();
    }
  }
  
  public void e()
  {
    QLog.e("CmGameViewBinder", 1, "Hippy load success!");
    this.b = 0;
  }
  
  public void f()
  {
    QLog.e("CmGameViewBinder", 1, "Hippy load timeout!");
    QQToast.makeText(this.i, 1, 2131887824, 0).show();
    l();
  }
  
  public void g()
  {
    QLog.e("CmGameViewBinder", 1, "Hippy load failed!");
    QQToast.makeText(this.i, 1, 2131888632, 0).show();
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.CmGameViewBinder
 * JD-Core Version:    0.7.0.1
 */