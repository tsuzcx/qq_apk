package com.tencent.mobileqq.ark;

import alsc;
import alsi;
import alsn;
import android.os.Bundle;
import bbwg;
import bbwi;
import bbwl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(alsc paramalsc, alsn paramalsn) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)alsc.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((bbwi)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(alsc.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      bbwg localbbwg = new bbwg(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbbwg.n = true;
      localbbwg.p = true;
      if (this.a.b != null) {
        localbbwg.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbbwg.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((bbwl)localObject).a(localbbwg, new alsi(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      alsc.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */