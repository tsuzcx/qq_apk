package com.tencent.mobileqq.ark.component;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.QLog;
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
    Object localObject = QBaseActivity.sTopActivity;
    boolean bool;
    if ((localObject != null) && (Build.VERSION.SDK_INT >= 23) && ((((QBaseActivity)localObject).checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) || (((QBaseActivity)localObject).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))) {
      bool = false;
    } else {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CheckPermission is = ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("GetArkLocPermission", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      synchronized (this.b)
      {
        this.b.clear();
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
        return;
      }
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
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
      return;
    }
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
      while (((Iterator)???).hasNext()) {
        ((ArkAppLocationManager.LocationCallback)((Iterator)???).next()).a();
      }
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      }
    }
    for (;;)
    {
      throw localObject3;
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
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (!a())
    {
      localQBaseActivity.requestPermissions(new ArkAppLocationManager.2(this, localQBaseActivity), 1, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    grant();
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    QLog.i("GetArkLocPermission", 1, "CheckPermission location is denied");
  }
  
  @QQPermissionGrant(1)
  @TargetApi(23)
  public void grant()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    QLog.i("GetArkLocPermission", 1, "CheckPermission location is granted ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppLocationManager
 * JD-Core Version:    0.7.0.1
 */