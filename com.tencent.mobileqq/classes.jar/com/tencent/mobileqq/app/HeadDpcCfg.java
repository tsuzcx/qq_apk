package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class HeadDpcCfg
{
  private static HeadDpcCfg jdField_a_of_type_ComTencentMobileqqAppHeadDpcCfg;
  private static final String jdField_a_of_type_JavaLangString = DPCNames.headDpcCfg.name();
  private int jdField_a_of_type_Int = 1;
  private DPCObserver jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new HeadDpcCfg.1(this);
  
  private HeadDpcCfg()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
    a();
  }
  
  public static HeadDpcCfg a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppHeadDpcCfg == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqAppHeadDpcCfg == null) {
          jdField_a_of_type_ComTencentMobileqqAppHeadDpcCfg = new HeadDpcCfg();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqAppHeadDpcCfg;
  }
  
  public void a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length >= 1) {
        try
        {
          this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadConfig exception :");
          localStringBuilder.append(localException.getMessage());
          QLog.d("HeadDpcCfg", 1, localStringBuilder.toString());
          this.jdField_a_of_type_Int = 1;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HeadDpcCfg", 2, String.format("loadConfig, mDualStackPrefIpv6: %s, dpc=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str }));
    }
  }
  
  public boolean a()
  {
    QLog.d("HeadDpcCfg", 1, String.format("preferIpv6 mDualStackPrefIpv6=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    return this.jdField_a_of_type_Int != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.HeadDpcCfg
 * JD-Core Version:    0.7.0.1
 */