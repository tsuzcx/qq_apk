package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.NetWorkUtil;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class a
  implements IBridgeActivityDelegate
{
  public WeakReference<Activity> a;
  public IBridgeActivityDelegate b;
  protected UpdateBean c = null;
  protected b d = null;
  protected boolean e = false;
  protected int f = -1;
  protected String g = null;
  protected String h = null;
  protected int i = 0;
  protected String j = null;
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    default: 
      return "";
    case 0: 
      return l.class.getName();
    case 6: 
      return m.class.getName();
    case 5: 
      return i.class.getName();
    case 4: 
      return h.class.getName();
    case 2: 
      return g.class.getName();
    }
    return c.class.getName();
  }
  
  private void a(UpdateBean paramUpdateBean)
  {
    this.c = paramUpdateBean;
  }
  
  private void a(ArrayList paramArrayList)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      if (paramArrayList.size() > 0) {
        localObject1 = a(((Integer)paramArrayList.get(0)).intValue());
      }
    }
    if (localObject1 == null) {
      return;
    }
    try
    {
      this.b = ((IBridgeActivityDelegate)Class.forName((String)localObject1).asSubclass(IBridgeActivityDelegate.class).newInstance());
      return;
    }
    catch (ClassCastException paramArrayList)
    {
      HMSLog.e("AbsUpdateWizard", "getBridgeActivityDelegate error" + paramArrayList.getMessage());
      return;
    }
    catch (ClassNotFoundException paramArrayList)
    {
      break label58;
    }
    catch (InstantiationException paramArrayList)
    {
      break label58;
    }
    catch (IllegalAccessException paramArrayList)
    {
      label58:
      break label58;
    }
  }
  
  private String c(int paramInt1, int paramInt2)
  {
    String str = String.valueOf(paramInt1);
    switch (paramInt2)
    {
    case 1: 
    case 3: 
    default: 
      return str;
    case 0: 
      return "0000" + str;
    case 2: 
      return "2000" + str;
    case 6: 
      return "4000" + str;
    case 5: 
      return "5000" + str;
    }
    return "6000" + str;
  }
  
  abstract void a();
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (!SystemUtils.isChinaROM()) {
      HMSLog.i("AbsUpdateWizard", "not ChinaROM ");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = b();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    int k = new PackageManagerHelper(localActivity).getPackageVersionCode(this.g);
    HashMap localHashMap = new HashMap();
    localHashMap.put("package", localActivity.getPackageName());
    localHashMap.put("target_package", this.g);
    localHashMap.put("target_ver", String.valueOf(k));
    localHashMap.put("sdk_ver", String.valueOf(50000301));
    localHashMap.put("app_id", AGCUtils.getAppId(localActivity));
    localHashMap.put("trigger_api", "core.connnect");
    localHashMap.put("update_type", String.valueOf(paramInt2));
    localHashMap.put("net_type", String.valueOf(NetWorkUtil.getNetworkType(localActivity)));
    localHashMap.put("result", c(paramInt1, paramInt2));
    HiAnalyticsUtils.getInstance().onEvent(localActivity, "HMS_SDK_UPDATE", localHashMap);
  }
  
  public void a(b paramb) {}
  
  abstract void a(Class<? extends b> paramClass);
  
  protected boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = b();
    } while ((localActivity == null) || (localActivity.isFinishing()) || (new PackageManagerHelper(localActivity).getPackageVersionCode(paramString) < paramInt));
    return true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    Activity localActivity = b();
    if (localActivity == null) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = this.c.getTypeList();
      if (localArrayList.size() > 0) {
        localArrayList.remove(0);
      }
      if (this.b == null) {
        a(localArrayList);
      }
    } while (this.b == null);
    this.e = true;
    this.c.setTypeList(localArrayList);
    this.c.setNeedConfirm(paramBoolean);
    if ((this.b instanceof a)) {
      ((a)this.b).a(this.c);
    }
    this.b.onBridgeActivityCreate(localActivity);
    return true;
  }
  
  protected Activity b()
  {
    if (this.a == null) {
      return null;
    }
    return (Activity)this.a.get();
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    a(paramInt1, paramInt2);
    Intent localIntent = new Intent();
    localIntent.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", getClass().getName());
    localIntent.putExtra("intent.extra.RESULT", paramInt1);
    localActivity.setResult(-1, localIntent);
    localActivity.finish();
  }
  
  public void b(b paramb) {}
  
  protected void c()
  {
    if (this.d == null) {
      return;
    }
    try
    {
      this.d.c();
      this.d = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      HMSLog.e("AbsUpdateWizard", "In dismissDialog, Failed to dismiss the dialog." + localIllegalStateException.getMessage());
    }
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
    if (this.c == null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity == null) {}
      do
      {
        return;
        this.c = ((UpdateBean)paramActivity.getSerializableExtra("intent.extra.update.info"));
      } while (this.c == null);
    }
    this.g = this.c.b();
    this.h = this.c.getClientAppName();
    this.i = this.c.c();
    this.j = this.c.d();
    this.b = null;
    this.e = false;
    this.f = -1;
  }
  
  public void onBridgeActivityDestroy()
  {
    this.a = null;
    c();
    if ((this.e) && (this.b != null)) {
      this.b.onBridgeActivityDestroy();
    }
  }
  
  public void onBridgeConfigurationChanged()
  {
    if ((this.e) && (this.b != null)) {
      this.b.onBridgeConfigurationChanged();
    }
    while (this.d == null) {
      return;
    }
    Class localClass = this.d.getClass();
    this.d.c();
    this.d = null;
    a(localClass);
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.e) && (this.b != null)) {
      this.b.onKeyUp(paramInt, paramKeyEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.ui.a
 * JD-Core Version:    0.7.0.1
 */