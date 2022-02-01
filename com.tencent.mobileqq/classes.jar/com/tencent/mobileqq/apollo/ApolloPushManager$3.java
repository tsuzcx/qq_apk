package com.tencent.mobileqq.apollo;

import amts;
import android.text.TextUtils;
import anlk;
import annx;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPush;

public class ApolloPushManager$3
  implements Runnable
{
  public ApolloPushManager$3(amts paramamts, ApolloActionPush paramApolloActionPush, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface;
    SpriteTaskParam localSpriteTaskParam;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam != null))
    {
      localQQAppInterface = amts.a(this.this$0);
      localSpriteTaskParam = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush.mContent)) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      anlk.a(localQQAppInterface, localSpriteTaskParam, bool, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.b);
      if ((amts.a(this.this$0) != null) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush != null)) {
        ((annx)amts.a(this.this$0).getManager(155)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush.mId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPushManager.3
 * JD-Core Version:    0.7.0.1
 */