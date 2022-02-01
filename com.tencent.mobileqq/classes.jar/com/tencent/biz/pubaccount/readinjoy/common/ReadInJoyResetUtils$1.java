package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.ugc.CollectionUtils.IPredicate;

final class ReadInJoyResetUtils$1
  implements CollectionUtils.IPredicate<String>
{
  public boolean a(String paramString)
  {
    return (paramString.toLowerCase().contains("readinjoy")) && (!paramString.contains("readinjoy_local_reset_config_version")) && (!paramString.contains("readinjoy_remote_reset_config_version"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyResetUtils.1
 * JD-Core Version:    0.7.0.1
 */