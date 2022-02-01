package com.tencent.mobileqq.ark;

import java.util.ArrayList;

class ArkAppCGI$2
  implements ArkAppCGI.ITaskHttpResult
{
  public void a(ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] arg3)
  {
    if ((paramBoolean) && (??? != null)) {
      ArkAppCGI.a(this.a, ???);
    }
    synchronized (this.a)
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramQueryTask);
      paramBoolean = this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty();
      if (paramBoolean) {
        this.a.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback.a(true, this.a.jdField_a_of_type_JavaLangObject, this.a.b);
      }
      return;
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("queryActionAppNeedUpdate, subTask fail", new Object[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.2
 * JD-Core Version:    0.7.0.1
 */