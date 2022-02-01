package com.tencent.mobileqq.apollo.debug;

import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.utils.FileUtils;

class ApolloDebugFragment$2
  implements Runnable
{
  ApolloDebugFragment$2(ApolloDebugFragment paramApolloDebugFragment) {}
  
  public void run()
  {
    FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
    FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
    FileUtils.deleteDirectory(ApolloConstant.j);
    FileUtils.deleteDirectory(ApolloConstant.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.ApolloDebugFragment.2
 * JD-Core Version:    0.7.0.1
 */