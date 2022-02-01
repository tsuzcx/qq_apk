package com.tencent.biz.subscribe.comment;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;

class SubscribeCommentInputPopupWindow$3
  implements EmoticonCallback
{
  SubscribeCommentInputPopupWindow$3(SubscribeCommentInputPopupWindow paramSubscribeCommentInputPopupWindow) {}
  
  public void delete()
  {
    if (this.a.b.getSelectionStart() == 0) {
      return;
    }
    try
    {
      Editable localEditable = this.a.b.getText();
      int i = this.a.b.getSelectionStart();
      int j = android.text.TextUtils.getOffsetBefore(this.a.b.getText(), i);
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
      i = this.a.b.getSelectionStart();
      j = this.a.b.getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        this.a.b.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
      }
    }
    else if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
    {
      SystemAndEmojiEmoticonInfo localSystemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = this.a.b.getSelectionStart();
      j = this.a.b.getSelectionEnd();
      int k = localSystemAndEmojiEmoticonInfo.emotionType;
      int m = localSystemAndEmojiEmoticonInfo.code;
      if ((i >= 0) && (j >= 0) && (j >= i))
      {
        if ((k == 2) && (m == -1)) {
          return;
        }
        if (k == 1) {
          paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(m);
        } else {
          paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.getEmojiString(m);
        }
        this.a.b.getEditableText().replace(i, j, paramEmoticonInfo);
        this.a.b.requestFocus();
      }
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        localSystemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      }
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */