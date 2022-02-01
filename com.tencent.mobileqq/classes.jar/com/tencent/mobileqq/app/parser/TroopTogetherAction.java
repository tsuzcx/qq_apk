package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class TroopTogetherAction
  extends JumpAction
{
  public TroopTogetherAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void c()
  {
    Object localObject1 = ((BaseActivity)this.b).getChatFragment();
    if ((localObject1 != null) && (((ChatFragment)localObject1).k() != null))
    {
      localObject1 = ((ChatFragment)localObject1).k();
      if ((localObject1 != null) && ((localObject1 instanceof TroopChatPie)))
      {
        localObject1 = (TroopChatPie)localObject1;
        Object localObject2 = (TogetherControlHelper)((TroopChatPie)localObject1).q(43);
        if (localObject2 != null) {
          ((TogetherControlHelper)localObject2).a(2);
        }
        localObject2 = new HashMap();
        if ((((TroopChatPie)localObject1).ah != null) && (!TextUtils.isEmpty(((TroopChatPie)localObject1).ah.b))) {
          ((HashMap)localObject2).put("qq_group_num", ((TroopChatPie)localObject1).ah.b);
        }
        if ((this.a != null) && (!TextUtils.isEmpty(this.a.getCurrentAccountUin()))) {
          ((HashMap)localObject2).put("A8", this.a.getCurrentAccountUin());
        }
        ClockReportUtil.a("click#aio_graybar", (HashMap)localObject2);
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      c();
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("TroopOneWayAction", 1, localStringBuilder.toString());
      h_("TroopOneWayAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TroopTogetherAction
 * JD-Core Version:    0.7.0.1
 */