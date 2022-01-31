package com.tencent.mobileqq.ark;

import alsb;
import alsh;
import alsm;
import android.os.Bundle;
import bbwu;
import bbww;
import bbwz;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(alsb paramalsb, alsm paramalsm) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)alsb.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((bbww)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(alsb.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      bbwu localbbwu = new bbwu(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbbwu.n = true;
      localbbwu.p = true;
      if (this.a.b != null) {
        localbbwu.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbbwu.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((bbwz)localObject).a(localbbwu, new alsh(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      alsb.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */