package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.mobileqq.relationx.icebreaking.IIceBreakHotPicCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class IceBreakHelper$1
  implements IIceBreakHotPicCallback
{
  IceBreakHelper$1(IceBreakHelper paramIceBreakHelper) {}
  
  public void a()
  {
    JSONObject localJSONObject = IceBreakHelper.a(this.a);
    if (localJSONObject != null)
    {
      IceBreakHelper localIceBreakHelper = this.a;
      IceBreakHelper.a(localIceBreakHelper, IceBreakHelper.b(localIceBreakHelper, localJSONObject));
    }
  }
  
  public void a(boolean paramBoolean, List<IStickerRecEmoticon> paramList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetIceBreakHotPic, success: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" hotPiceList size: ");
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    localStringBuilder.append(i);
    QLog.i("IceBreak.HotPic", 1, localStringBuilder.toString());
    if (!paramBoolean) {
      return;
    }
    if (this.a.a != null)
    {
      IceBreakHelper.a(this.a, paramList);
      this.a.a.a(paramList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.1
 * JD-Core Version:    0.7.0.1
 */