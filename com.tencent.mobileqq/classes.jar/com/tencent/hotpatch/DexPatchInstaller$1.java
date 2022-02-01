package com.tencent.hotpatch;

import acln;
import aclx;
import acly;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

public final class DexPatchInstaller$1
  implements Runnable
{
  public DexPatchInstaller$1(aclx paramaclx, Context paramContext) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_Aclx.b();
    int i = PatchSharedPreUtil.getCountFailStartupPatch(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str);
    if (i <= 5) {
      PatchSharedPreUtil.updateCountFailStartupPatch(this.jdField_a_of_type_AndroidContentContext, BaseApplicationImpl.processName, str, i + 1);
    }
    acly.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aclx);
    if ((501 == acln.a) || (502 == acln.a))
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