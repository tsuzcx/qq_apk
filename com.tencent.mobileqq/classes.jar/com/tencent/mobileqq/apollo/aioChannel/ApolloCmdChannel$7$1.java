package com.tencent.mobileqq.apollo.aioChannel;

import akmz;
import akro;
import aktr;
import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import java.nio.ByteBuffer;

public class ApolloCmdChannel$7$1
  extends IApolloRunnableTask
{
  public ApolloCmdChannel$7$1(akmz paramakmz, int paramInt, Bitmap paramBitmap, ByteBuffer paramByteBuffer) {}
  
  public String a()
  {
    return "getOpenApiHead";
  }
  
  public void run()
  {
    if ((akro.a() != null) && (akro.a().a())) {
      this.jdField_a_of_type_Akmz.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.nativeOpenApiGetHeadCallBack(this.jdField_a_of_type_Akmz.jdField_a_of_type_Long, this.jdField_a_of_type_Akmz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_JavaNioByteBuffer.array());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.7.1
 * JD-Core Version:    0.7.0.1
 */