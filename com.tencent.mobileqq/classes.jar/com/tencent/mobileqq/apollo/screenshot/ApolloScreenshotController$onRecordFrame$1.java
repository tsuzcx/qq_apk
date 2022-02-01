package com.tencent.mobileqq.apollo.screenshot;

import anbi;
import anbq;
import anlz;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class ApolloScreenshotController$onRecordFrame$1
  implements Runnable
{
  public ApolloScreenshotController$onRecordFrame$1(int paramInt1, int paramInt2, anbi paramanbi, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    try
    {
      if (this.jdField_a_of_type_Int == this.b)
      {
        localanbq = this.jdField_a_of_type_Anbi.a();
        arrayOfByte = anlz.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b);
        Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "ApolloRecordUtil.flipVer…nedPixels, width, height)");
        localanbq.a(arrayOfByte, this.b, this.b);
        return;
      }
      anbq localanbq = this.jdField_a_of_type_Anbi.a();
      byte[] arrayOfByte = anlz.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b, this.b);
      Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "ApolloRecordUtil.flipVer…s, width, height, height)");
      localanbq.a(arrayOfByte, this.b, this.b);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloScrshot", 1, "onRecordFrame error in handler", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrame.1
 * JD-Core Version:    0.7.0.1
 */