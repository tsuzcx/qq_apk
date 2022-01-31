package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import java.util.ArrayList;
import java.util.Iterator;
import uut;

public class ArkAppLocationManager
{
  private SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList b = new ArrayList();
  private final ArrayList c = new ArrayList();
  
  public ArkAppLocationManager()
  {
    this(0L);
  }
  
  public ArkAppLocationManager(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new uut(this, 3, true, true, paramLong, true, true, "ArkAppLocationManager");
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
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(ArkAppLocationManager.AddressCallback paramAddressCallback)
  {
    if (paramAddressCallback == null) {
      return;
    }
    synchronized (this.c)
    {
      this.c.add(paramAddressCallback);
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
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
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      return;
    }
  }
  
  public void b()
  {
    if ((this.b.size() == 0) && (this.c.size() == 0)) {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
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
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager
 * JD-Core Version:    0.7.0.1
 */