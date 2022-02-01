package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ApolloScreenshotController$onRecordFrameEnd$2
  implements Runnable
{
  ApolloScreenshotController$onRecordFrameEnd$2(ApolloCoderResource paramApolloCoderResource, boolean paramBoolean, IApolloActionRecordListener paramIApolloActionRecordListener, long paramLong) {}
  
  public final void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource == null) {
        return;
      }
      ApolloScreenshotController.a(ApolloScreenshotController.a).execute((Runnable)new ApolloScreenshotController.onRecordFrameEnd.2.1(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloScrshot", 1, "onRecordFrameEnd error", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrameEnd.2
 * JD-Core Version:    0.7.0.1
 */