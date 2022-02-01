package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemTempMsgBoxData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import java.util.List;

public class TempMsgBoxAIOHelper
  implements ILifeCycleHelper
{
  public static String a = "TempMsgBoxAIOHelper";
  private Activity b;
  private QQAppInterface c;
  
  public TempMsgBoxAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie.d;
    this.b = paramBaseChatPie.f;
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.b.getIntent();
    int i = paramInt;
    if (localObject != null)
    {
      i = paramInt;
      if (((Intent)localObject).getBooleanExtra("enter_from_temp_msg_box", false))
      {
        localObject = ((ITempMsgBoxManager)this.c.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
        IConversationFacade localIConversationFacade = (IConversationFacade)this.c.getRuntimeService(IConversationFacade.class, "");
        i = paramInt;
        if (localIConversationFacade != null) {
          i = RecentItemTempMsgBoxData.a(this.c, (List)localObject, localIConversationFacade);
        }
      }
    }
    return i;
  }
  
  @NonNull
  public String getTag()
  {
    return a;
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TempMsgBoxAIOHelper
 * JD-Core Version:    0.7.0.1
 */