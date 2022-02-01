package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import java.util.Map;
import mqq.app.AppRuntime;

final class ApolloConfigUtils$3
  implements Runnable
{
  ApolloConfigUtils$3(AppRuntime paramAppRuntime, Map paramMap) {}
  
  public void run()
  {
    ((ApolloManagerServiceImpl)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).updateAndDownloadPreRes(this.jdField_a_of_type_JavaUtilMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigUtils.3
 * JD-Core Version:    0.7.0.1
 */