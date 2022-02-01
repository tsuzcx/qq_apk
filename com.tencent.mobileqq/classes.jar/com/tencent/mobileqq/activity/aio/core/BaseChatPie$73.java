package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import antv;
import anvx;
import awyr;
import bisl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$73
  extends antv
{
  BaseChatPie$73(BaseChatPie paramBaseChatPie) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((BaseChatPie.access$1500(this.this$0) == null) || (paramObject == null) || (this.this$0.input == null));
      localObject = this.this$0.input.getText().toString();
      paramObject = (EmoticonResp)paramObject;
      BaseChatPie.access$1500(this.this$0).handleCloudEmotionForKeywordResp(paramBoolean, paramInt, paramObject, (String)localObject);
      return;
      if ((this.this$0.mAuthEmoticonDialog != null) && (this.this$0.mAuthEmoticonDialog.isShowing())) {
        this.this$0.mAuthEmoticonDialog.dismiss();
      }
    } while (paramObject == null);
    Object localObject = (EmoticonResp)paramObject;
    int i;
    if (paramBoolean)
    {
      i = ((EmoticonResp)localObject).delEpId;
      if ((((EmoticonResp)localObject).keySeq == null) || (((EmoticonResp)localObject).keySeq.equals(""))) {
        paramObject = anvx.a(2131700485);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((EmoticonResp)localObject).emoticonId)) {
        break label240;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.this$0.tag, 2, "auth type emoticon id is null");
      return;
      paramObject = ((EmoticonResp)localObject).keySeq;
      continue;
      paramObject = anvx.a(2131700470);
      i = -404;
    }
    label240:
    ((awyr)this.this$0.app.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(((EmoticonResp)localObject).epId), ((EmoticonResp)localObject).emoticonId, new BaseChatPie.73.1(this, paramInt, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.73
 * JD-Core Version:    0.7.0.1
 */