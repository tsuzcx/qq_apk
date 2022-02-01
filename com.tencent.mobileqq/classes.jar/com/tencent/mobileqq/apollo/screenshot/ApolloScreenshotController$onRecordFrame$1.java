package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.utils.ApolloRecordUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ApolloScreenshotController$onRecordFrame$1
  implements Runnable
{
  ApolloScreenshotController$onRecordFrame$1(ApolloScreenshotController paramApolloScreenshotController, int paramInt1, int paramInt2, byte[] paramArrayOfByte, ApolloCoderResource paramApolloCoderResource, IApolloActionRecordListener paramIApolloActionRecordListener) {}
  
  public final void run()
  {
    try
    {
      int i = this.a;
      int j = this.b;
      byte[] arrayOfByte;
      Object localObject;
      if (i == j)
      {
        arrayOfByte = ApolloRecordUtil.a(this.c, this.a, this.b);
        localObject = this.d.d();
        Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "framePixels");
        ((IApolloScreenshotEncoder)localObject).a(arrayOfByte, this.a, this.b);
        localObject = this.e;
        if (localObject != null) {
          ((IApolloActionRecordListener)localObject).a(this.d.d().c() - 1, arrayOfByte, this.a, this.b, this.d.j());
        }
      }
      else
      {
        arrayOfByte = ApolloRecordUtil.a(this.c, this.a, this.b, this.b);
        localObject = this.d.d();
        Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "framePixels");
        ((IApolloScreenshotEncoder)localObject).a(arrayOfByte, this.b, this.b);
        localObject = this.e;
        if (localObject != null)
        {
          ((IApolloActionRecordListener)localObject).a(this.d.d().c() - 1, arrayOfByte, this.b, this.b, this.d.j());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e(ApolloScreenshotController.a(this.this$0), 1, "onRecordFrame error in handler", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrame.1
 * JD-Core Version:    0.7.0.1
 */