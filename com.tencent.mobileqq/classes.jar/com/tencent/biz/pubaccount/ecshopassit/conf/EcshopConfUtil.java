package com.tencent.biz.pubaccount.ecshopassit.conf;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class EcshopConfUtil
{
  public static EcshopConfBean.TabConfBean a(int paramInt)
  {
    Object localObject = a().jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EcshopConfBean.TabConfBean localTabConfBean = (EcshopConfBean.TabConfBean)((Iterator)localObject).next();
        if (localTabConfBean.jdField_a_of_type_Int == paramInt) {
          return localTabConfBean;
        }
      }
    }
    return new EcshopConfBean.TabConfBean();
  }
  
  public static EcshopConfBean a()
  {
    EcshopConfBean localEcshopConfBean2 = EcshopConfProcessor.a();
    EcshopConfBean localEcshopConfBean1 = localEcshopConfBean2;
    if (localEcshopConfBean2 == null) {
      localEcshopConfBean1 = new EcshopConfBean();
    }
    return localEcshopConfBean1;
  }
  
  public static boolean a()
  {
    return a(EcshopConfProcessor.a());
  }
  
  public static boolean a(EcshopConfBean paramEcshopConfBean)
  {
    return a(paramEcshopConfBean, 1, 1);
  }
  
  public static boolean a(EcshopConfBean paramEcshopConfBean, int paramInt1, int paramInt2)
  {
    if ((paramEcshopConfBean == null) || (paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList == null) || (paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    paramEcshopConfBean = paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramEcshopConfBean.hasNext())
    {
      EcshopConfBean.TabConfBean localTabConfBean = (EcshopConfBean.TabConfBean)paramEcshopConfBean.next();
      if ((localTabConfBean.b == paramInt1) && (localTabConfBean.jdField_a_of_type_Int == paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    EcshopConfBean localEcshopConfBean = a();
    if (localEcshopConfBean == null) {}
    for (String str = "false";; str = localEcshopConfBean.jdField_a_of_type_Int + "")
    {
      QLog.i("EcshopEcshopConfUtil", 2, str);
      if (localEcshopConfBean != null) {
        break;
      }
      return false;
    }
    if (localEcshopConfBean.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfUtil
 * JD-Core Version:    0.7.0.1
 */