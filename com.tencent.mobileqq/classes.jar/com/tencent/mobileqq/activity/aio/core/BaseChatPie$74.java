package com.tencent.mobileqq.activity.aio.core;

import amrh;
import amtj;
import android.text.TextUtils;
import avsq;
import bhht;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$74
  extends amrh
{
  BaseChatPie$74(BaseChatPie paramBaseChatPie) {}
  
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
      } while ((BaseChatPie.access$1600(this.this$0) == null) || (paramObject == null) || (this.this$0.input == null));
      localObject = this.this$0.input.getText().toString();
      paramObject = (EmoticonResp)paramObject;
      BaseChatPie.access$1600(this.this$0).handleCloudEmotionForKeywordResp(paramBoolean, paramInt, paramObject, (String)localObject);
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
        paramObject = amtj.a(2131700134);
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
      paramObject = amtj.a(2131700119);
      i = -404;
    }
    label240:
    ((avsq)this.this$0.app.getManager(14)).a(String.valueOf(((EmoticonResp)localObject).epId), ((EmoticonResp)localObject).emoticonId, new BaseChatPie.74.1(this, paramInt, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.74
 * JD-Core Version:    0.7.0.1
 */