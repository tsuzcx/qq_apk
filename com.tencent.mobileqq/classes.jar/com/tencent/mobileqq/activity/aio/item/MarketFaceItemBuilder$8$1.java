package com.tencent.mobileqq.activity.aio.item;

import adje;
import adjr;
import adjt;
import android.app.Activity;
import anla;
import arnz;
import awqx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class MarketFaceItemBuilder$8$1
  implements Runnable
{
  public MarketFaceItemBuilder$8$1(adjr paramadjr) {}
  
  public void run()
  {
    Object localObject = (arnz)this.a.jdField_a_of_type_Adje.a.getManager(14);
    if (this.a.jdField_a_of_type_Adjt.a != null) {
      ((arnz)localObject).a(this.a.jdField_a_of_type_Adjt.a.a.epId);
    }
    if (this.a.jdField_a_of_type_Adjt.a != null) {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_Adje.b, this.a.jdField_a_of_type_Adje.a.getAccount(), 12, String.valueOf(this.a.jdField_a_of_type_Adjt.a.a.epId), false, false);
    }
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_Adje.a;
    if (this.a.jdField_a_of_type_Adjt.a == null) {}
    for (localObject = "";; localObject = this.a.jdField_a_of_type_Adjt.a.a.epId)
    {
      awqx.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007188", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.8.1
 * JD-Core Version:    0.7.0.1
 */