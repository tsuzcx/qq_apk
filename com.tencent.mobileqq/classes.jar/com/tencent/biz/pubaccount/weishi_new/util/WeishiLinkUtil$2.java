package com.tencent.biz.pubaccount.weishi_new.util;

import cooperation.qzone.LocalMultiProcConfig;

public final class WeishiLinkUtil$2
  implements Runnable
{
  public WeishiLinkUtil$2(String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = LocalMultiProcConfig.getInt("weishi_usergrowth", this.a, 0);
    LocalMultiProcConfig.putInt("weishi_usergrowth", this.a, i + 1);
    LocalMultiProcConfig.putLong("weishi_usergrowth", this.b, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil.2
 * JD-Core Version:    0.7.0.1
 */