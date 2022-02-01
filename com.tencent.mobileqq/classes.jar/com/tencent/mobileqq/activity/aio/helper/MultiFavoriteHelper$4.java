package com.tencent.mobileqq.activity.aio.helper;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import java.util.ArrayList;
import java.util.List;

class MultiFavoriteHelper$4
  implements DialogInterface.OnClickListener
{
  MultiFavoriteHelper$4(MultiFavoriteHelper paramMultiFavoriteHelper, List paramList, BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    paramDialogInterface = MultiMsgUtil.a(MultiFavoriteHelper.b(this.c), (ArrayList)this.a);
    if (paramDialogInterface != null)
    {
      if (paramDialogInterface.size() == 0) {
        return;
      }
      MultiFavoriteHelper.a(this.c, paramDialogInterface);
      this.b.a(false, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper.4
 * JD-Core Version:    0.7.0.1
 */