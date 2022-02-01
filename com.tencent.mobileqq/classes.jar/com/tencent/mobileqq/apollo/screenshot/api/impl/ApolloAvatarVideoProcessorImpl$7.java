package com.tencent.mobileqq.apollo.screenshot.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.screenshot.ApolloVideoUtils;
import java.io.File;

class ApolloAvatarVideoProcessorImpl$7
  implements Runnable
{
  ApolloAvatarVideoProcessorImpl$7(ApolloAvatarVideoProcessorImpl paramApolloAvatarVideoProcessorImpl, int paramInt, AppInterface paramAppInterface, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApolloAvatarVideoProcessorImpl.access$900(this.this$0));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("_compress.mp4");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = ApolloVideoUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplicationContext(), this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_a_of_type_Int);
    ApolloAvatarVideoProcessorImpl.access$1700(this.this$0).a(bool, this.jdField_a_of_type_Int, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl.7
 * JD-Core Version:    0.7.0.1
 */