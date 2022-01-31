package com.tencent.mobileqq.armap.config;

import abfp;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ShopScanCheckHandler
{
  private ArMapInterface jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
  private ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new abfp(this);
  private ShopScanCheckHandler.Info jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info;
  private ShopScanCheckHandler.OnResCheckResultListener jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$OnResCheckResultListener;
  private boolean jdField_a_of_type_Boolean;
  
  public ShopScanCheckHandler(ArMapInterface paramArMapInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
  }
  
  private void a(ShopScanCheckHandler.Info paramInfo, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanCheckHandler", 2, "setCheckResult, rsult=" + paramInt1 + ", extra=" + paramInt2);
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$OnResCheckResultListener != null)
    {
      ShopScanCheckHandler.OnResCheckResultListener localOnResCheckResultListener = this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$OnResCheckResultListener;
      if (paramInt1 == 0) {
        bool = true;
      }
      localOnResCheckResultListener.a(bool, paramInfo, paramInt1, paramInt2);
    }
  }
  
  private boolean a(File paramFile, String paramString)
  {
    if (!paramFile.exists()) {
      return false;
    }
    if (!paramString.equalsIgnoreCase(PortalUtils.a(paramFile.getAbsolutePath())))
    {
      paramFile.delete();
      return false;
    }
    return true;
  }
  
  public void a(ShopScanCheckHandler.Info paramInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanCheckHandler", 2, "startShopScan=" + paramInfo);
    }
    if (this.jdField_a_of_type_Boolean) {}
    while (paramInfo == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info = paramInfo;
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    ((ArMapHandler)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a(2)).a(paramInfo.b, paramInfo.a, null);
  }
  
  public void a(ShopScanCheckHandler.OnResCheckResultListener paramOnResCheckResultListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$OnResCheckResultListener = paramOnResCheckResultListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ShopScanCheckHandler
 * JD-Core Version:    0.7.0.1
 */