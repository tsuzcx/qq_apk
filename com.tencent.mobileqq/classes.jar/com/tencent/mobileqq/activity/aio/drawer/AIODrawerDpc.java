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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInstance: ");
      localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc);
      QLog.d("AIODrawerDpc", 2, localStringBuilder.toString());
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
    try
    {
      long l1 = System.currentTimeMillis();
      if (jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc == null)
      {
        jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc = new AIODrawerDpc();
        paramBoolean = true;
      }
      if (paramBoolean) {
        try
        {
          Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(jdField_a_of_type_JavaLangString);
          jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_JavaLangString = ((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((String)localObject1).split("\\|");
            if (localObject1.length >= 19)
            {
              if (Integer.valueOf(localObject1[18]).intValue() == 1) {
                jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_a_of_type_Boolean = true;
              } else {
                jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_a_of_type_Boolean = false;
              }
            }
            else {
              jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_a_of_type_Boolean = true;
            }
            if (localObject1.length >= 20)
            {
              if (Integer.valueOf(localObject1[19]).intValue() == 1) {
                jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_Boolean = true;
              } else {
                jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_Boolean = false;
              }
            }
            else {
              jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_Boolean = true;
            }
          }
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("load exp:");
          localStringBuilder2.append(localException.getMessage());
          QLog.d("AIODrawerDpc", 1, localStringBuilder2.toString());
          jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_a_of_type_Boolean = true;
          jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc.jdField_b_of_type_Boolean = true;
        }
      }
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("loadDpc: ");
        localStringBuilder1.append(jdField_a_of_type_ComTencentMobileqqActivityAioDrawerAIODrawerDpc);
        localStringBuilder1.append(", costMills: ");
        localStringBuilder1.append(l2 - l1);
        QLog.d("AIODrawerDpc", 2, localStringBuilder1.toString());
      }
      return;
    }
    finally {}
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AIODrawerDpc{dpcValue='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSupport=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", needPreInflate=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc
 * JD-Core Version:    0.7.0.1
 */