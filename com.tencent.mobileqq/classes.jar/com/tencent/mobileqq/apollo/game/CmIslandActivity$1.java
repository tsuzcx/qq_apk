package com.tencent.mobileqq.apollo.game;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;

class CmIslandActivity$1
  implements DialogInterface.OnClickListener
{
  CmIslandActivity$1(CmIslandActivity paramCmIslandActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", ApolloConstant.y);
    this.a.startActivity(paramDialogInterface);
    CmIslandActivity.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmIslandActivity.1
 * JD-Core Version:    0.7.0.1
 */