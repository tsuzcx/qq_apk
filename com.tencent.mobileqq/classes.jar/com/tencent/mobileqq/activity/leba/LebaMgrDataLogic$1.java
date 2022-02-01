package com.tencent.mobileqq.activity.leba;

import akgq;
import akgr;
import aogd;
import arsh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class LebaMgrDataLogic$1
  implements Runnable
{
  public LebaMgrDataLogic$1(akgq paramakgq, arsh paramarsh, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (!(localObject instanceof QQAppInterface)))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "handleData AppRuntime error ");
      return;
    }
    localObject = (QQAppInterface)localObject;
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginItem name: " + this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + this.jdField_a_of_type_Arsh.jdField_a_of_type_Byte);
    long l = NetConnInfoCenter.getServerTimeMillis();
    akgr.a().a((QQAppInterface)localObject, this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, this.jdField_a_of_type_Boolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
    ((aogd)((QQAppInterface)localObject).a(31)).a(String.valueOf(this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), this.jdField_a_of_type_Boolean, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaMgrDataLogic.1
 * JD-Core Version:    0.7.0.1
 */