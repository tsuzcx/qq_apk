package com.tencent.mobileqq.activity.qwallet;

import agwl;
import agwm;
import android.os.Bundle;
import bbwg;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(agwm paramagwm, bbwg parambbwg) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bbwg.a.size();
    Bundle localBundle = this.jdField_a_of_type_Bbwg.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Bbwg.a.get(i);
      agwl.a(this.jdField_a_of_type_Agwm.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */