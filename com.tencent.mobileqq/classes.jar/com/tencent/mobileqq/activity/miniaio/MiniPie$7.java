package com.tencent.mobileqq.activity.miniaio;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.widget.XEditTextEx;

class MiniPie$7
  implements EmoticonCallback
{
  MiniPie$7(MiniPie paramMiniPie) {}
  
  public void delete()
  {
    if (this.a.a.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.a.a.getText();
        int i = this.a.a.getSelectionStart();
        int j = android.text.TextUtils.getOffsetBefore(this.a.a.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void emoticonMall() {}
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    int i;
    int j;
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo;
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
      do
      {
        return;
      } while (!(paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo));
      localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = localSystemAndEmojiEmoticonInfo.emotionType;
      m = localSystemAndEmojiEmoticonInfo.code;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(m);; paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(m))
    {
      this.a.a.getEditableText().replace(i, j, paramEmoticonInfo);
      this.a.a.requestFocus();
      localSystemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      QQSysAndEmojiResMgr.getInstance().getResImpl(k).reportEmoClick(m, 2);
      return;
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.7
 * JD-Core Version:    0.7.0.1
 */