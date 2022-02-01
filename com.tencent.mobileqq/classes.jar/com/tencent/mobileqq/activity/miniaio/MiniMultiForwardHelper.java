package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class MiniMultiForwardHelper
  implements ILifeCycleHelper
{
  public boolean a = false;
  private QQAppInterface b;
  private Context c;
  private MiniPie d;
  private SessionInfo e;
  
  public MiniMultiForwardHelper(MiniPie paramMiniPie)
  {
    this.b = paramMiniPie.d;
    this.c = paramMiniPie.b;
    this.d = paramMiniPie;
    this.e = paramMiniPie.c;
  }
  
  public String getTag()
  {
    return "MiniMultiForwardHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 11, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RESUME onMoveToState：=");
    localStringBuilder.append(paramInt);
    QLog.i("MiniMultiForwardHelper", 2, localStringBuilder.toString());
    if (paramInt != 7)
    {
      if (paramInt != 11) {
        return;
      }
      BaseChatItemLayout.ad = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RESUME mPreCheckBoxVisibleStat：=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("  BaseChatItemLayout.CheckBoxVisible :");
      localStringBuilder.append(BaseChatItemLayout.ad);
      QLog.i("MiniMultiForwardHelper", 2, localStringBuilder.toString());
      return;
    }
    this.a = BaseChatItemLayout.ad;
    BaseChatItemLayout.ad = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("RESUME mPreCheckBoxVisibleStat：=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("  BaseChatItemLayout.CheckBoxVisible :");
    localStringBuilder.append(BaseChatItemLayout.ad);
    QLog.i("MiniMultiForwardHelper", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardHelper
 * JD-Core Version:    0.7.0.1
 */