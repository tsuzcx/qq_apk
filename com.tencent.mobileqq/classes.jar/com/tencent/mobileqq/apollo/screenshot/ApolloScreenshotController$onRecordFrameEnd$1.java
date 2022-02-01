package com.tencent.mobileqq.apollo.screenshot;

import anbi;
import anbo;
import anbp;
import anbq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class ApolloScreenshotController$onRecordFrameEnd$1
  implements Runnable
{
  public ApolloScreenshotController$onRecordFrameEnd$1(anbi paramanbi, boolean paramBoolean, anbp paramanbp, long paramLong) {}
  
  public final void run()
  {
    Object localObject2 = null;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        Object localObject3 = this.jdField_a_of_type_Anbi;
        if (localObject3 == null) {
          break;
        }
        String str1 = ((anbi)localObject3).a();
        if (this.jdField_a_of_type_Boolean)
        {
          Object localObject1 = this.jdField_a_of_type_Anbp;
          if (localObject1 != null) {
            ((anbp)localObject1).a();
          }
          if (((anbi)localObject3).a().a(str1, ((anbi)localObject3).d()))
          {
            localObject1 = this.jdField_a_of_type_Anbp;
            if (localObject1 != null) {
              ((anbp)localObject1).a(true);
            }
            anbo.a(anbo.a, str1, ((anbi)localObject3).b());
            bool1 = true;
            anbp localanbp = this.jdField_a_of_type_Anbp;
            if (localanbp != null)
            {
              int i = ((anbi)localObject3).a();
              String str2 = ((anbi)localObject3).b();
              localObject1 = localObject2;
              if (bool1)
              {
                localObject3 = anbo.a.a(((anbi)localObject3).b());
                localObject1 = localObject2;
                if (localObject3 != null) {
                  localObject1 = ((File)localObject3).getAbsolutePath();
                }
              }
              localanbp.a(i, str2, (String)localObject1);
            }
            QLog.d("ApolloScrshot", 4, "onRecordFrameEnd key:" + this.jdField_a_of_type_Anbi.b() + " taskId:" + this.jdField_a_of_type_Anbi.c() + " director:" + this.jdField_a_of_type_Long + ", success:" + bool1 + ", resultPath?" + str1);
            return;
          }
          localObject1 = this.jdField_a_of_type_Anbp;
          bool1 = bool2;
          if (localObject1 == null) {
            continue;
          }
          ((anbp)localObject1).a(false);
          bool1 = bool2;
          continue;
        }
        ((anbi)localObject3).a().b();
      }
      catch (Exception localException)
      {
        QLog.e("ApolloScrshot", 1, "onRecordFrameEnd error", (Throwable)localException);
        return;
      }
      boolean bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrameEnd.1
 * JD-Core Version:    0.7.0.1
 */