package com.tencent.mobileqq.activity.aio.item;

import adug;
import adur;
import aduu;
import android.app.Activity;
import aobk;
import askd;
import axqw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class MarketFaceItemBuilder$7$1
  implements Runnable
{
  public MarketFaceItemBuilder$7$1(adur paramadur) {}
  
  public void run()
  {
    Object localObject = (askd)this.a.jdField_a_of_type_Adug.a.getManager(14);
    if (this.a.jdField_a_of_type_Aduu.a != null) {
      ((askd)localObject).a(this.a.jdField_a_of_type_Aduu.a.a.epId);
    }
    if (this.a.jdField_a_of_type_Aduu.a != null) {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_Adug.b, this.a.jdField_a_of_type_Adug.a.getAccount(), 12, String.valueOf(this.a.jdField_a_of_type_Aduu.a.a.epId), false, false);
    }
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_Adug.a;
    if (this.a.jdField_a_of_type_Aduu.a == null) {}
    for (localObject = "";; localObject = this.a.jdField_a_of_type_Aduu.a.a.epId)
    {
      axqw.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007188", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1
 * JD-Core Version:    0.7.0.1
 */