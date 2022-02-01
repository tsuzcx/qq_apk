package com.tencent.mobileqq.activity.aio.item;

import ahaw;
import ahbj;
import android.content.Context;
import android.content.Intent;
import awyr;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import java.io.Serializable;
import java.util.List;

public class MarketFaceItemBuilder$6
  implements Runnable
{
  public MarketFaceItemBuilder$6(ahaw paramahaw, String paramString, ahbj paramahbj) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.b, H5MagicPlayerActivity.class);
    localIntent.putExtra("clickTime", System.currentTimeMillis());
    localIntent.putExtra("autoPlay", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("senderUin", this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
    localIntent.putExtra("selfUin", this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("sessionInfo", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localIntent.putExtra("emoticon", this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
    Object localObject = (awyr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
    EmoticonPackage localEmoticonPackage = ((awyr)localObject).a(this.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
    if (localEmoticonPackage != null)
    {
      localObject = ((awyr)localObject).a(localEmoticonPackage.childEpId);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        localIntent.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
      }
    }
    this.this$0.b.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */