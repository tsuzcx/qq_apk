package com.tencent.mobileqq.apollo.store;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.ShortcutCreateListener;

class ApolloGameActivity$14
  implements DialogInterface.OnClickListener
{
  ApolloGameActivity$14(ApolloGameActivity paramApolloGameActivity, Intent paramIntent, String paramString, Bitmap paramBitmap, ApolloGameUtil.ShortcutCreateListener paramShortcutCreateListener, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, new ApolloGameActivity.14.1(this));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.14
 * JD-Core Version:    0.7.0.1
 */