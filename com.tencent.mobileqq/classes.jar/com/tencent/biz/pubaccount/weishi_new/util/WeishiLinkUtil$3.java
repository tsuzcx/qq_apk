package com.tencent.biz.pubaccount.weishi_new.util;

import cooperation.qzone.LocalMultiProcConfig;

public final class WeishiLinkUtil$3
  implements Runnable
{
  public WeishiLinkUtil$3(String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    LocalMultiProcConfig.putInt("weishi_usergrowth", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    LocalMultiProcConfig.putLong("weishi_usergrowth", this.b, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.3
 * JD-Core Version:    0.7.0.1
 */