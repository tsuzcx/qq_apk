package com.tencent.mobileqq.activity;

import aere;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import mqq.os.MqqHandler;

public class FriendProfileMoreInfoActivity$15$1
  implements Runnable
{
  public FriendProfileMoreInfoActivity$15$1(aere paramaere, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    ((TroopManager)this.jdField_a_of_type_Aere.a.app.getManager(52)).a(this.jdField_a_of_type_Aere.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, this.c, this.d);
    ThreadManager.getUIHandler().post(new FriendProfileMoreInfoActivity.15.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.15.1
 * JD-Core Version:    0.7.0.1
 */