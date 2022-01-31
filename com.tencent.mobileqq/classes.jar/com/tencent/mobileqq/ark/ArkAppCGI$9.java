package com.tencent.mobileqq.ark;

import android.os.Bundle;
import annc;
import annj;
import anno;
import beae;
import beag;
import beaj;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(annc paramannc, anno paramanno) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)annc.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((beag)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(annc.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      beae localbeae = new beae(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbeae.n = true;
      localbeae.p = true;
      if (this.a.b != null) {
        localbeae.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbeae.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((beaj)localObject).a(localbeae, new annj(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      annc.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */