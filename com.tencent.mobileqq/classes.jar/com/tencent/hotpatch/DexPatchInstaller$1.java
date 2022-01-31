package com.tencent.hotpatch;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import yss;
import ytb;
import ytc;

public final class DexPatchInstaller$1
  implements Runnable
{
  public DexPatchInstaller$1(ytb paramytb, Context paramContext) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_Ytb.b();
    int i = PatchSharedPreUtil.getCountFailStartupPatch(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str);
    if (i <= 5) {
      PatchSharedPreUtil.updateCountFailStartupPatch(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str, i + 1);
    }
    ytc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ytb);
    if ((501 == yss.a) || (502 == yss.a))
    {
      i = PatchSharedPreUtil.getCountFailInstallPatch(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str);
      PatchSharedPreUtil.updateCountFailInstallPatch(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str, i + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.DexPatchInstaller.1
 * JD-Core Version:    0.7.0.1
 */