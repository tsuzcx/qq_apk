package com.tencent.mobileqq.activity.aio.item;

import afqr;
import afrc;
import afrf;
import android.app.Activity;
import aptm;
import aube;
import azmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class MarketFaceItemBuilder$7$1
  implements Runnable
{
  public MarketFaceItemBuilder$7$1(afrc paramafrc) {}
  
  public void run()
  {
    Object localObject = (aube)this.a.jdField_a_of_type_Afqr.a.getManager(14);
    if (this.a.jdField_a_of_type_Afrf.a != null) {
      ((aube)localObject).a(this.a.jdField_a_of_type_Afrf.a.a.epId);
    }
    if (this.a.jdField_a_of_type_Afrf.a != null) {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_Afqr.b, this.a.jdField_a_of_type_Afqr.a.getAccount(), 12, String.valueOf(this.a.jdField_a_of_type_Afrf.a.a.epId), false, false);
    }
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_Afqr.a;
    if (this.a.jdField_a_of_type_Afrf.a == null) {}
    for (localObject = "";; localObject = this.a.jdField_a_of_type_Afrf.a.a.epId)
    {
      azmj.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007188", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1
 * JD-Core Version:    0.7.0.1
 */