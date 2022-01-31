package com.tencent.mobileqq.apollo;

import aiga;
import aisk;
import aiwi;
import aiyu;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPush;

public class ApolloPushManager$3
  implements Runnable
{
  public ApolloPushManager$3(aiga paramaiga, ApolloActionPush paramApolloActionPush, aisk paramaisk) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface;
    aisk localaisk;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush != null) && (this.jdField_a_of_type_Aisk != null))
    {
      localQQAppInterface = aiga.a(this.this$0);
      localaisk = this.jdField_a_of_type_Aisk;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush.mContent)) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      aiwi.a(localQQAppInterface, localaisk, bool, this.jdField_a_of_type_Aisk.b);
      if ((aiga.a(this.this$0) != null) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush != null)) {
        ((aiyu)aiga.a(this.this$0).getManager(155)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush.mId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPushManager.3
 * JD-Core Version:    0.7.0.1
 */