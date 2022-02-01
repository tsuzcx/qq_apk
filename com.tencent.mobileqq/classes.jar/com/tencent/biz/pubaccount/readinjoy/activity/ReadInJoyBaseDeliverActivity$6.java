package com.tencent.biz.pubaccount.readinjoy.activity;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

class ReadInJoyBaseDeliverActivity$6
  implements EmoticonCallback
{
  ReadInJoyBaseDeliverActivity$6(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
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
        int j = TextUtils.getOffsetBefore(this.a.a.getText(), i);
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
    if ((paramEmoticonInfo instanceof PicEmoticonInfo))
    {
      paramEmoticonInfo = (PicEmoticonInfo)paramEmoticonInfo;
      if ((this.a instanceof ReadInJoyDeliverUGCActivity)) {
        ((ReadInJoyDeliverUGCActivity)this.a).a(paramEmoticonInfo);
      }
      return;
    }
    ReadInJoyBaseDeliverActivity.a(this.a.app, paramEmoticonInfo, this.a.a);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.6
 * JD-Core Version:    0.7.0.1
 */