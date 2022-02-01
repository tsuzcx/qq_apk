package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import mqq.os.MqqHandler;

class PicItemBuilder$2
  implements QueryCallback<EmoticonPackage>
{
  PicItemBuilder$2(PicItemBuilder paramPicItemBuilder, String paramString) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (this.b.f.a != 1008) && (this.b.f.a != 1000) && (this.b.f.a != 10004) && (this.b.f.a != 1001) && (this.b.f.a != 1002) && (this.b.f.a != 1003) && (this.b.f.a != 1004) && (this.b.f.a != 1005) && (this.b.f.a != 1006))
    {
      paramEmoticonPackage = this.b.d.getHandler(ChatActivity.class);
      if (paramEmoticonPackage != null) {
        paramEmoticonPackage.obtainMessage(22, this.a).sendToTarget();
      }
    }
    else
    {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.b.e, this.b.d.getAccount(), 8, this.a, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PicItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */