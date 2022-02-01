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
      QQToast.makeText(AIOUpComingMsgHelper.d(this.a).aX(), 2, 2131917762, 0).show();
      return;
    }
    QQToast.makeText(AIOUpComingMsgHelper.d(this.a).aX(), 0, 2131917761, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper.5
 * JD-Core Version:    0.7.0.1
 */