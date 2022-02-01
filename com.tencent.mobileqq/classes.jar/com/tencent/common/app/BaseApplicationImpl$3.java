package com.tencent.common.app;

import bctj;
import java.util.HashMap;

class BaseApplicationImpl$3
  implements Runnable
{
  BaseApplicationImpl$3(BaseApplicationImpl paramBaseApplicationImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(this.jdField_a_of_type_Int));
    localHashMap.put("param_uin", this.jdField_a_of_type_JavaLangString);
    bctj.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_JavaLangString, "PcActiveSuccB", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.3
 * JD-Core Version:    0.7.0.1
 */