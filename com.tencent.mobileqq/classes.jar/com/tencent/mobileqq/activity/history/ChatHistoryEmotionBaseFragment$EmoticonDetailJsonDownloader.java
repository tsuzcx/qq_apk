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
  IEmoBatchAddedCallback a;
  private IPicEmoticonInfo b;
  private QQAppInterface c;
  
  public void a(QQAppInterface paramQQAppInterface, IPicEmoticonInfo paramIPicEmoticonInfo, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    this.c = paramQQAppInterface;
    this.b = paramIPicEmoticonInfo;
    this.a = paramIEmoBatchAddedCallback;
  }
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onJsonComplete:");
      paramBundle.append(paramEmoticonPackage.epId);
      paramBundle.append(" ,currEpid:");
      paramBundle.append(this.b.getEmoticon().epId);
      QLog.d("EmoBatchAdded", 2, paramBundle.toString());
    }
    if (paramInt == 0)
    {
      if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.b.getEmoticon().epId))
      {
        this.a.a(-1);
        return;
      }
      this.c.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      MarketFaceItemBuilder.a(this.c, paramEmoticonPackage, this.b, this.a);
      return;
    }
    this.a.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader
 * JD-Core Version:    0.7.0.1
 */