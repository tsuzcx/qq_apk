package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;

class TogetherControlHelper$1
  extends TogetherObserver
{
  TogetherControlHelper$1(TogetherControlHelper paramTogetherControlHelper) {}
  
  protected void a(boolean paramBoolean, TogetherSession paramTogetherSession, int paramInt, String paramString)
  {
    if (!TogetherControlHelper.a(this.a).ah.b.equals(paramTogetherSession.n))
    {
      super.a(paramBoolean, paramTogetherSession, paramInt, paramString);
      return;
    }
    int i = 0;
    if (paramBoolean)
    {
      TogetherControlHelper.b(this.a).setTogetherSession(paramTogetherSession);
      if (paramTogetherSession.p == 3)
      {
        this.a.c();
      }
      else
      {
        paramInt = paramTogetherSession.q;
        if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
          break label95;
        }
      }
      paramBoolean = false;
      break label97;
      label95:
      paramBoolean = true;
      label97:
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(paramTogetherSession.l), " session.userState=", Integer.valueOf(paramTogetherSession.q), " needPanel=", Boolean.valueOf(paramBoolean) });
      }
      if (paramBoolean)
      {
        paramInt = i;
        if (TogetherUtils.a(TogetherControlHelper.a(this.a).d, paramTogetherSession))
        {
          paramInt = i;
          if (!TogetherWatchFloatingUtil.a(paramTogetherSession.l, paramTogetherSession.n, paramTogetherSession.m))
          {
            paramInt = i;
            if (!this.a.j()) {
              paramInt = 1;
            }
          }
        }
        if (paramInt == 0) {
          this.a.c();
        } else {
          TogetherControlHelper.c(this.a);
        }
      }
      TogetherControlHelper.d(this.a);
      TogetherControlHelper.a(this.a, paramTogetherSession);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState false, ", Integer.valueOf(paramInt), " ", paramString });
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 2)
    {
      if (((paramObject instanceof TroopUnreadMsgInfo)) && (TogetherControlHelper.a(this.a).ah.b.equals(((TroopUnreadMsgInfo)paramObject).b)) && (TogetherControlHelper.e(this.a) != null)) {
        TogetherControlHelper.e(this.a).a(1000, new Object[0]);
      }
    }
    else {
      super.onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.1
 * JD-Core Version:    0.7.0.1
 */