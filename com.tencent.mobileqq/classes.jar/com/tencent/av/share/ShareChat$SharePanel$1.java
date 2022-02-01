package com.tencent.av.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class ShareChat$SharePanel$1
  implements Runnable
{
  ShareChat$SharePanel$1(ShareChat.SharePanel paramSharePanel, QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Intent paramIntent, Context paramContext, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceBitmap(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, (byte)3, false, false);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("face", localBitmap);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception localException)
    {
      label48:
      break label48;
    }
    this.this$0.a(5, this.jdField_a_of_type_Int, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.1
 * JD-Core Version:    0.7.0.1
 */