package com.tencent.mobileqq.activity;

import afcl;
import android.os.Handler;
import bgkf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;

public class TroopGagActivity$2$1
  implements Runnable
{
  public TroopGagActivity$2$1(afcl paramafcl, Handler paramHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = ((bgkf)this.jdField_a_of_type_Afcl.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_Afcl.a.a, false);
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopGagActivity.2.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1
 * JD-Core Version:    0.7.0.1
 */