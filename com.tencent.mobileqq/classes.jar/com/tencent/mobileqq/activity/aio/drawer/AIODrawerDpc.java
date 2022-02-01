package com.tencent.mobileqq.activity.aio.drawer;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class AIODrawerDpc
{
  private static AIODrawerDpc jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc;
  public static DPCObserver a;
  private static final String jdField_a_of_type_JavaLangString = DPCNames.aio_config.name();
  public boolean a;
  private String b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new AIODrawerDpc.1();
  }
  
  private AIODrawerDpc()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
  }
  
  public static AIODrawerDpc a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc == null) {
      b(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIODrawerDpc", 2, "getInstance: " + jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc);
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc;
  }
  
  public static boolean a()
  {
    AIODrawerDpc localAIODrawerDpc = a();
    if (localAIODrawerDpc != null) {
      return localAIODrawerDpc.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  private static void b(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc == null)
        {
          jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc = new AIODrawerDpc();
          paramBoolean = true;
        }
        if (paramBoolean) {}
        try
        {
          Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(jdField_a_of_type_JavaLangString);
          jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_JavaLangString = ((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((String)localObject1).split("\\|");
            if (localObject1.length < 19) {
              break label250;
            }
            if (Integer.valueOf(localObject1[18]).intValue() != 1) {
              continue;
            }
            jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_a_of_type_Boolean = true;
            if (localObject1.length < 20) {
              break label270;
            }
            if (Integer.valueOf(localObject1[19]).intValue() != 1) {
              break label260;
            }
            jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_Boolean = true;
          }
        }
        catch (Exception localException)
        {
          long l2;
          QLog.d("AIODrawerDpc", 1, "load exp:" + localException.getMessage());
          jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_a_of_type_Boolean = true;
          jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_Boolean = true;
          continue;
        }
        if (QLog.isColorLevel())
        {
          l2 = System.currentTimeMillis();
          QLog.d("AIODrawerDpc", 2, "loadDpc: " + jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc + ", costMills: " + (l2 - l1));
        }
        return;
      }
      finally {}
      jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_a_of_type_Boolean = false;
      continue;
      label250:
      jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_a_of_type_Boolean = true;
      continue;
      label260:
      jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_Boolean = false;
      continue;
      label270:
      jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_Boolean = true;
    }
  }
  
  public static boolean b()
  {
    AIODrawerDpc localAIODrawerDpc = a();
    if (localAIODrawerDpc != null) {
      return localAIODrawerDpc.jdField_b_of_type_Boolean;
    }
    return true;
  }
  
  public String toString()
  {
    return "AIODrawerDpc{dpcValue='" + this.jdField_b_of_type_JavaLangString + '\'' + ", isSupport=" + this.jdField_a_of_type_Boolean + ", needPreInflate=" + this.jdField_b_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc
 * JD-Core Version:    0.7.0.1
 */