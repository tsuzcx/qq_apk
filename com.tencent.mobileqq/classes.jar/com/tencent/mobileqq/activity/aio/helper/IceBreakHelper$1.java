package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.mobileqq.relationx.icebreaking.IIceBreakHotPicCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class IceBreakHelper$1
  implements IIceBreakHotPicCallback
{
  IceBreakHelper$1(IceBreakHelper paramIceBreakHelper) {}
  
  public void a(boolean paramBoolean, List<IStickerRecEmoticon> paramList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetIceBreakHotPic, success: ").append(paramBoolean).append(" hotPiceList size: ");
    int i;
    if (paramList == null)
    {
      i = 0;
      QLog.i("IceBreak.HotPic", 1, i);
      if (paramBoolean) {
        break label62;
      }
    }
    label62:
    while (this.a.a == null)
    {
      return;
      i = paramList.size();
      break;
    }
    this.a.a.a(paramList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.1
 * JD-Core Version:    0.7.0.1
 */