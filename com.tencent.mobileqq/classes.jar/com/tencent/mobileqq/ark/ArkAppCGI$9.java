package com.tencent.mobileqq.ark;

import android.os.Bundle;
import anit;
import anja;
import anjf;
import bdvv;
import bdvx;
import bdwa;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(anit paramanit, anjf paramanjf) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)anit.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((bdvx)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(anit.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      bdvv localbdvv = new bdvv(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbdvv.n = true;
      localbdvv.p = true;
      if (this.a.b != null) {
        localbdvv.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbdvv.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((bdwa)localObject).a(localbdvv, new anja(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      anit.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */