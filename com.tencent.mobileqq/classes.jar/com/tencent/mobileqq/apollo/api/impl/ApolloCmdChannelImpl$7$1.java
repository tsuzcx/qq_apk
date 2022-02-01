package com.tencent.mobileqq.apollo.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import java.nio.ByteBuffer;

class ApolloCmdChannelImpl$7$1
  extends IApolloRunnableTask
{
  ApolloCmdChannelImpl$7$1(ApolloCmdChannelImpl.7 param7, int paramInt, Bitmap paramBitmap, ByteBuffer paramByteBuffer) {}
  
  public String a()
  {
    return "getOpenApiHead";
  }
  
  public void run()
  {
    if ((CmGameUtil.a() != null) && (CmGameUtil.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$7.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl.nativeOpenApiGetHeadCallBack(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$7.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl$7.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_JavaNioByteBuffer.array());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloCmdChannelImpl.7.1
 * JD-Core Version:    0.7.0.1
 */