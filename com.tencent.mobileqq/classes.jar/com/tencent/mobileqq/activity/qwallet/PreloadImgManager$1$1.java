package com.tencent.mobileqq.activity.qwallet;

import agjw;
import agjx;
import android.os.Bundle;
import batm;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(agjx paramagjx, batm parambatm) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Batm.a.size();
    Bundle localBundle = this.jdField_a_of_type_Batm.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Batm.a.get(i);
      agjw.a(this.jdField_a_of_type_Agjx.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */