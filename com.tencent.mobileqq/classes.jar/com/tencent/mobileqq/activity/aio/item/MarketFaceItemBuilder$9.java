package com.tencent.mobileqq.activity.aio.item;

import adje;
import adjt;
import android.content.Context;
import android.content.Intent;
import anla;
import arnz;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.Serializable;
import java.util.List;

public class MarketFaceItemBuilder$9
  implements Runnable
{
  public MarketFaceItemBuilder$9(adje paramadje, String paramString, adjt paramadjt) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.b, H5MagicPlayerActivity.class);
    localIntent.putExtra("clickTime", System.currentTimeMillis());
    localIntent.putExtra("autoPlay", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("senderUin", this.jdField_a_of_type_Adjt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
    localIntent.putExtra("selfUin", this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("sessionInfo", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localIntent.putExtra("emoticon", this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a);
    Object localObject = (arnz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    EmoticonPackage localEmoticonPackage = ((arnz)localObject).a(this.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.epId);
    if (localEmoticonPackage != null)
    {
      localObject = ((arnz)localObject).a(localEmoticonPackage.childEpId);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        localIntent.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
      }
    }
    this.this$0.b.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */