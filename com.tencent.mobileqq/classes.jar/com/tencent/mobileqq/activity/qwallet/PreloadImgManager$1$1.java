package com.tencent.mobileqq.activity.qwallet;

import akqq;
import akqr;
import android.os.Bundle;
import bhyo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(akqr paramakqr, bhyo parambhyo) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bhyo.a.size();
    Bundle localBundle = this.jdField_a_of_type_Bhyo.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Bhyo.a.get(i);
      akqq.a(this.jdField_a_of_type_Akqr.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */