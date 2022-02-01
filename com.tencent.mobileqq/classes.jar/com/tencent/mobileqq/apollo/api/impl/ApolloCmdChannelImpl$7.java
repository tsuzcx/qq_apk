package com.tencent.mobileqq.apollo.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import java.nio.ByteBuffer;

class ApolloCmdChannelImpl$7
  implements ApolloCmdChannelImpl.openApiHeadCallback
{
  ApolloCmdChannelImpl$7(ApolloCmdChannelImpl paramApolloCmdChannelImpl, long paramLong, String paramString) {}
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null)
    {
      localByteBuffer = ByteBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
      paramBitmap.copyPixelsToBuffer(localByteBuffer);
      if ((CmGameUtil.a() != null) && (ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl) != null) && (ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl).a(CmGameUtil.a().a()) != null)) {
        ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl).a(CmGameUtil.a().a()).runRenderTask(new ApolloCmdChannelImpl.7.1(this, paramInt, paramBitmap, localByteBuffer));
      }
    }
    while ((CmGameUtil.a() == null) || (ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl) == null) || (ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl).a(CmGameUtil.a().a()) == null))
    {
      ByteBuffer localByteBuffer;
      return;
    }
    ApolloCmdChannelImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloCmdChannelImpl).a(CmGameUtil.a().a()).runRenderTask(new ApolloCmdChannelImpl.7.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloCmdChannelImpl.7
 * JD-Core Version:    0.7.0.1
 */