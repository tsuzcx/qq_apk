package com.tencent.mobileqq.activity.history;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryEmotionBaseFragment$EmoticonDetailJsonDownloader
  extends EmotionJsonDownloadListener
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IEmoBatchAddedCallback jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedCallback;
  private IPicEmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
  
  public void a(QQAppInterface paramQQAppInterface, IPicEmoticonInfo paramIPicEmoticonInfo, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = paramIPicEmoticonInfo;
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedCallback = paramIEmoBatchAddedCallback;
  }
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onJsonComplete:");
      paramBundle.append(paramEmoticonPackage.epId);
      paramBundle.append(" ,currEpid:");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
      QLog.d("EmoBatchAdded", 2, paramBundle.toString());
    }
    if (paramInt == 0)
    {
      if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedCallback.a(-1);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedCallback);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedCallback.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader
 * JD-Core Version:    0.7.0.1
 */