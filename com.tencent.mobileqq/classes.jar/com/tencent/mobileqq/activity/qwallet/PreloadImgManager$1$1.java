package com.tencent.mobileqq.activity.qwallet;

import aklv;
import aklw;
import android.os.Bundle;
import bhhf;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(aklw paramaklw, bhhf parambhhf) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bhhf.a.size();
    Bundle localBundle = this.jdField_a_of_type_Bhhf.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Bhhf.a.get(i);
      aklv.a(this.jdField_a_of_type_Aklw.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */