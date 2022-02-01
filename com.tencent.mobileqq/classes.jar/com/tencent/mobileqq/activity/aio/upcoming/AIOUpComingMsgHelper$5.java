package com.tencent.mobileqq.activity.aio.upcoming;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.widget.QQToast;

class AIOUpComingMsgHelper$5
  extends OnColorNoteCurdListener
{
  AIOUpComingMsgHelper$5(AIOUpComingMsgHelper paramAIOUpComingMsgHelper) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (paramBoolean)
    {
      QQToast.a(AIOUpComingMsgHelper.a(this.a).a(), 2, 2131720133, 0).a();
      return;
    }
    QQToast.a(AIOUpComingMsgHelper.a(this.a).a(), 0, 2131720132, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.5
 * JD-Core Version:    0.7.0.1
 */