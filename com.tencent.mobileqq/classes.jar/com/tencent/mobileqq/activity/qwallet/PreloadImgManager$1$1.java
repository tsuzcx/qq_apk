package com.tencent.mobileqq.activity.qwallet;

import agwj;
import agwk;
import android.os.Bundle;
import bbwu;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(agwk paramagwk, bbwu parambbwu) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bbwu.a.size();
    Bundle localBundle = this.jdField_a_of_type_Bbwu.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Bbwu.a.get(i);
      agwj.a(this.jdField_a_of_type_Agwk.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */