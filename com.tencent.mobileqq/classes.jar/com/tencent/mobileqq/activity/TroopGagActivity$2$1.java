package com.tencent.mobileqq.activity;

import acgw;
import android.os.Handler;
import baky;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class TroopGagActivity$2$1
  implements Runnable
{
  public TroopGagActivity$2$1(acgw paramacgw, Handler paramHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = ((baky)this.jdField_a_of_type_Acgw.a.app.getManager(48)).a(this.jdField_a_of_type_Acgw.a.a, false);
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopGagActivity.2.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1
 * JD-Core Version:    0.7.0.1
 */