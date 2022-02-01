package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.utils.ApolloRecordUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ApolloScreenshotController$onRecordFrame$1
  implements Runnable
{
  ApolloScreenshotController$onRecordFrame$1(IApolloActionRecordListener paramIApolloActionRecordListener, int paramInt1, int paramInt2, byte[] paramArrayOfByte, ApolloCoderResource paramApolloCoderResource) {}
  
  public final void run()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
        if (localObject1 == null) {
          break label240;
        }
        i = ((IApolloActionRecordListener)localObject1).c();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
        if (localObject1 != null) {
          j = ((IApolloActionRecordListener)localObject1).d();
        }
        i = ApolloScreenshotController.a(ApolloScreenshotController.a, i, this.jdField_a_of_type_Int);
        j = ApolloScreenshotController.a(ApolloScreenshotController.a, j, this.b);
        Object localObject2;
        if (this.jdField_a_of_type_Int == this.b)
        {
          localObject1 = ApolloRecordUtil.a(this.jdField_a_of_type_ArrayOfByte, i, j);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "framePixels");
          ((IApolloScreenshotEncoder)localObject2).a((byte[])localObject1, i, j);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
          if (localObject2 != null) {
            ((IApolloActionRecordListener)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a().a() - 1, (byte[])localObject1, i, j, this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.d());
          }
        }
        else
        {
          localObject1 = ApolloRecordUtil.a(this.jdField_a_of_type_ArrayOfByte, i, j, j);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "framePixels");
          ((IApolloScreenshotEncoder)localObject2).a((byte[])localObject1, j, j);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
          if (localObject2 != null)
          {
            ((IApolloActionRecordListener)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a().a() - 1, (byte[])localObject1, j, j, this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.d());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloScrshot", 1, "onRecordFrame error in handler", (Throwable)localException);
      }
      return;
      label240:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrame.1
 * JD-Core Version:    0.7.0.1
 */