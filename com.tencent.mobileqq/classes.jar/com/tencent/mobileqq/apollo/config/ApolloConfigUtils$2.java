package com.tencent.mobileqq.apollo.config;

import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import java.util.Map;
import mqq.app.AppRuntime;

final class ApolloConfigUtils$2
  implements Runnable
{
  ApolloConfigUtils$2(AppRuntime paramAppRuntime, Map paramMap) {}
  
  public void run()
  {
    ((ApolloResManagerImpl)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IApolloResManager.class, "all")).updateAndDownloadPreRes(this.jdField_a_of_type_JavaUtilMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloConfigUtils.2
 * JD-Core Version:    0.7.0.1
 */