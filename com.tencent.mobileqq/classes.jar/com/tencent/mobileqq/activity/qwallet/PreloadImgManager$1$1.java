package com.tencent.mobileqq.activity.qwallet;

import aiqi;
import aiqj;
import android.os.Bundle;
import bdvv;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(aiqj paramaiqj, bdvv parambdvv) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bdvv.a.size();
    Bundle localBundle = this.jdField_a_of_type_Bdvv.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Bdvv.a.get(i);
      aiqi.a(this.jdField_a_of_type_Aiqj.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */