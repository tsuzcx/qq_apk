package com.tencent.mobileqq.activity.aio.item;

import afvg;
import afvr;
import afvu;
import android.app.Activity;
import apxv;
import aufn;
import azqs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class MarketFaceItemBuilder$7$1
  implements Runnable
{
  public MarketFaceItemBuilder$7$1(afvr paramafvr) {}
  
  public void run()
  {
    Object localObject = (aufn)this.a.jdField_a_of_type_Afvg.a.getManager(14);
    if (this.a.jdField_a_of_type_Afvu.a != null) {
      ((aufn)localObject).a(this.a.jdField_a_of_type_Afvu.a.a.epId);
    }
    if (this.a.jdField_a_of_type_Afvu.a != null) {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_Afvg.b, this.a.jdField_a_of_type_Afvg.a.getAccount(), 12, String.valueOf(this.a.jdField_a_of_type_Afvu.a.a.epId), false, false);
    }
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_Afvg.a;
    if (this.a.jdField_a_of_type_Afvu.a == null) {}
    for (localObject = "";; localObject = this.a.jdField_a_of_type_Afvu.a.a.epId)
    {
      azqs.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007188", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1
 * JD-Core Version:    0.7.0.1
 */