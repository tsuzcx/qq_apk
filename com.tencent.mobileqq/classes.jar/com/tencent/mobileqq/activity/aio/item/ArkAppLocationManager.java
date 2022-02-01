package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class ArkAppLocationManager
{
  private SosoInterfaceOnLocationListener jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener;
  protected String a;
  private final ArrayList<ArkAppLocationManager.LocationCallback> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList<ArkAppLocationManager.LocationCallback> b = new ArrayList();
  private final ArrayList<ArkAppLocationManager.AddressCallback> c = new ArrayList();
  
  public ArkAppLocationManager(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = new ArkAppLocationManager.1(this, 3, true, true, paramLong, true, true, "ArkAppLocationManager");
  }
  
  public static boolean a()
  {
    boolean bool2 = true;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1 = bool2;
    if (localBaseActivity != null)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23) {
        if ((localBaseActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) || (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
          break label68;
        }
      }
    }
    label68:
    for (bool1 = bool2;; bool1 = false)
    {
      ArkAppCenter.c("GetArkLocPermission", "CheckPermission is = " + bool1);
      return bool1;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    synchronized (this.b)
    {
      this.b.clear();
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(ArkAppLocationManager.AddressCallback paramAddressCallback, boolean paramBoolean)
  {
    if (paramAddressCallback == null) {
      return;
    }
    synchronized (this.c)
    {
      this.c.add(paramAddressCallback);
      if (paramBoolean)
      {
        c();
        return;
      }
    }
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
  }
  
  public void a(ArkAppLocationManager.LocationCallback paramLocationCallback)
  {
    if (paramLocationCallback == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramLocationCallback);
      c();
      return;
    }
  }
  
  public void b()
  {
    if ((this.b.size() == 0) && (this.c.size() == 0)) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((ArkAppLocationManager.LocationCallback)((Iterator)???).next()).a();
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void b(ArkAppLocationManager.LocationCallback paramLocationCallback)
  {
    if (paramLocationCallback == null) {
      return;
    }
    synchronized (this.b)
    {
      this.b.add(paramLocationCallback);
      c();
      return;
    }
  }
  
  protected void c()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!a())
    {
      localBaseActivity.requestPermissions(new ArkAppLocationManager.2(this, localBaseActivity), 1, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    grant();
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    ArkAppCenter.c("GetArkLocPermission", "CheckPermission location is denied");
  }
  
  @QQPermissionGrant(1)
  @TargetApi(23)
  public void grant()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    ArkAppCenter.c("GetArkLocPermission", "CheckPermission location is granted ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager
 * JD-Core Version:    0.7.0.1
 */