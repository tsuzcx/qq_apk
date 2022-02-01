package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.utils.FileUtils;

class ChatHistory$ChatHistoryAdapter$8
  implements QueryCallback<IPicEmoticonInfo>
{
  ChatHistory$ChatHistoryAdapter$8(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord) {}
  
  public void a(IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    if (paramIPicEmoticonInfo != null)
    {
      this.a.setTag(paramIPicEmoticonInfo);
      String str = EmotionPanelConstans.pngFramePath.replace("[epId]", paramIPicEmoticonInfo.getEmoticon().epId);
      Object localObject;
      if ((this.b.mobileparam != null) && (this.b.mobileparam.length > 0)) {
        localObject = new String(this.b.mobileparam);
      } else {
        localObject = "";
      }
      int i = PngFrameUtil.b((String)localObject);
      if ((FileUtils.fileExists(str)) && (i == 1)) {
        i = 3;
      } else if (paramIPicEmoticonInfo.isBigImageExists()) {
        i = 2;
      } else if (paramIPicEmoticonInfo.isAioPreviewExists()) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramIPicEmoticonInfo.isSound())
      {
        this.a.setVisibility(0);
        localObject = this.e.f.getResources().getDrawable(2130849016);
        this.a.setImageDrawable((Drawable)localObject);
      }
      else if (i == 1)
      {
        this.a.setVisibility(0);
        localObject = this.e.f.getResources().getDrawable(2130837995);
        this.a.setImageDrawable((Drawable)localObject);
      }
      this.c.setMinimumHeight((int)(this.e.f.v * 100.0F));
      this.c.setMinimumWidth((int)(this.e.f.v * 100.0F));
      this.e.a(this.c, i, paramIPicEmoticonInfo, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.8
 * JD-Core Version:    0.7.0.1
 */