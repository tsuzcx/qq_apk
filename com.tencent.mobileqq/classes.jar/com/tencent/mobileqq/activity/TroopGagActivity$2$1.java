package com.tencent.mobileqq.activity;

import aecv;
import android.os.Handler;
import bcnu;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class TroopGagActivity$2$1
  implements Runnable
{
  public TroopGagActivity$2$1(aecv paramaecv, Handler paramHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = ((bcnu)this.jdField_a_of_type_Aecv.a.app.getManager(48)).a(this.jdField_a_of_type_Aecv.a.a, false);
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopGagActivity.2.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1
 * JD-Core Version:    0.7.0.1
 */