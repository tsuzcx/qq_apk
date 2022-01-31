package com.tencent.mobileqq.apollo.utils;

import alfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.utils.VipUtils;

final class ApolloGameUtil$15
  implements Runnable
{
  ApolloGameUtil$15(Context paramContext, int paramInt, Intent paramIntent, String paramString, Bitmap paramBitmap, alfo paramalfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof ApolloGameActivity)))
    {
      VipUtils.a(null, "cmshow", "Apollo", "pressSendToDesktopButton", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Int) });
      ((ApolloGameActivity)this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Alfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.15
 * JD-Core Version:    0.7.0.1
 */