package com.tencent.mobileqq.activity.aio.item;

import adue;
import adup;
import adus;
import android.app.Activity;
import aobp;
import askf;
import axqy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class MarketFaceItemBuilder$7$1
  implements Runnable
{
  public MarketFaceItemBuilder$7$1(adup paramadup) {}
  
  public void run()
  {
    Object localObject = (askf)this.a.jdField_a_of_type_Adue.a.getManager(14);
    if (this.a.jdField_a_of_type_Adus.a != null) {
      ((askf)localObject).a(this.a.jdField_a_of_type_Adus.a.a.epId);
    }
    if (this.a.jdField_a_of_type_Adus.a != null) {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_Adue.b, this.a.jdField_a_of_type_Adue.a.getAccount(), 12, String.valueOf(this.a.jdField_a_of_type_Adus.a.a.epId), false, false);
    }
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_Adue.a;
    if (this.a.jdField_a_of_type_Adus.a == null) {}
    for (localObject = "";; localObject = this.a.jdField_a_of_type_Adus.a.a.epId)
    {
      axqy.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007188", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1
 * JD-Core Version:    0.7.0.1
 */