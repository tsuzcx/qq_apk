package com.tencent.mobileqq.activity.history;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryEmotionBaseFragment$EmoticonDetailJsonDownloader
  extends EmotionJsonDownloadListener
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EmoBatchAddedCallback jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedCallback;
  private PicEmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
  
  public void a(QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, EmoBatchAddedCallback paramEmoBatchAddedCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramPicEmoticonInfo;
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedCallback = paramEmoBatchAddedCallback;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 2, "onJsonComplete:" + paramEmoticonPackage.epId + " ,currEpid:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
    }
    if (paramInt == 0)
    {
      if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedCallback.a(-1);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedCallback);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedCallback.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader
 * JD-Core Version:    0.7.0.1
 */