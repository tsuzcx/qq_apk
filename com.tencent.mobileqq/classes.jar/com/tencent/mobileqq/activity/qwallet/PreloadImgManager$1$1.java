package com.tencent.mobileqq.activity.qwallet;

import ajux;
import ajuy;
import android.os.Bundle;
import bgoe;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(ajuy paramajuy, bgoe parambgoe) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Bgoe.a.size();
    Bundle localBundle = this.jdField_a_of_type_Bgoe.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Bgoe.a.get(i);
      ajux.a(this.jdField_a_of_type_Ajuy.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */