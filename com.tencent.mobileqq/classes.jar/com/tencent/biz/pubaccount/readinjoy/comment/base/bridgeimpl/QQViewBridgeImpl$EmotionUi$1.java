package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;

class QQViewBridgeImpl$EmotionUi$1
  implements EmoticonCallback
{
  QQViewBridgeImpl$EmotionUi$1(QQViewBridgeImpl.EmotionUi paramEmotionUi) {}
  
  public void delete()
  {
    if (QQViewBridgeImpl.a(this.a.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = QQViewBridgeImpl.a(this.a.a).getText();
        int i = QQViewBridgeImpl.a(this.a.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(QQViewBridgeImpl.a(this.a.a).getText(), i);
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
    ReadInJoyBaseDeliverActivity.a(this.a.a.a(), paramEmoticonInfo, QQViewBridgeImpl.a(this.a.a));
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQViewBridgeImpl.EmotionUi.1
 * JD-Core Version:    0.7.0.1
 */