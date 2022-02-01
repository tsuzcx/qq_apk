package com.tencent.mobileqq.apollo.debug;

import com.tencent.mobileqq.utils.FileUtils;

class ApolloDebugFragment$3
  implements Runnable
{
  ApolloDebugFragment$3(ApolloDebugFragment paramApolloDebugFragment) {}
  
  public void run()
  {
    FileUtils.deleteDirectory("/sdcard/cmshow/ce/frameCallback/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.ApolloDebugFragment.3
 * JD-Core Version:    0.7.0.1
 */