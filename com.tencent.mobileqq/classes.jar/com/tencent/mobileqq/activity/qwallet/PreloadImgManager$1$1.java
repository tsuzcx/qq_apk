package com.tencent.mobileqq.activity.qwallet;

import aiux;
import aiuy;
import android.os.Bundle;
import beae;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.List;

public class PreloadImgManager$1$1
  implements Runnable
{
  public PreloadImgManager$1$1(aiuy paramaiuy, beae parambeae) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Beae.a.size();
    Bundle localBundle = this.jdField_a_of_type_Beae.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_Beae.a.get(i);
      aiux.a(this.jdField_a_of_type_Aiuy.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.1.1
 * JD-Core Version:    0.7.0.1
 */