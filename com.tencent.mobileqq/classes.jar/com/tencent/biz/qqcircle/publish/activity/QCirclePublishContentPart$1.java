package com.tencent.biz.qqcircle.publish.activity;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;

class QCirclePublishContentPart$1
  implements EmoticonCallback
{
  QCirclePublishContentPart$1(QCirclePublishContentPart paramQCirclePublishContentPart) {}
  
  public void delete()
  {
    if (this.a.f.getSelectionStart() == 0) {
      return;
    }
    try
    {
      Editable localEditable = this.a.f.getText();
      int i = this.a.f.getSelectionStart();
      int j = TextUtils.getOffsetBefore(this.a.f.getText(), i);
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
      i = this.a.f.getSelectionStart();
      j = this.a.f.getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        this.a.f.getEditableText().replace(i, j, HostEmotionUtil.getFaceString(((SystemEmoticonInfo)paramEmoticonInfo).code));
      }
    }
    else if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
    {
      paramEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = this.a.f.getSelectionStart();
      j = this.a.f.getSelectionEnd();
      int k = paramEmoticonInfo.emotionType;
      int m = paramEmoticonInfo.code;
      if ((i >= 0) && (j >= 0) && (j >= i))
      {
        if ((k == 2) && (m == -1)) {
          return;
        }
        String str = HostEmotionUtil.getEmoString(k, m);
        this.a.f.getEditableText().replace(i, j, str);
        this.a.f.requestFocus();
      }
      HostEmotionUtil.addToCommonUse(paramEmoticonInfo);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.1
 * JD-Core Version:    0.7.0.1
 */