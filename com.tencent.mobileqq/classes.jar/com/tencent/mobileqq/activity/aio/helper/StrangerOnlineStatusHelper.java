package com.tencent.mobileqq.activity.aio.helper;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

public class StrangerOnlineStatusHelper
  extends OnlineStatusHelper
{
  public StrangerOnlineStatusHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void b()
  {
    if ((this.d) && ((this.c.a != 1025) || (!((StrangerQidianHelper)this.a.d().a(61)).a(true))) && (this.c.a == 1006))
    {
      Object localObject = ((IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.c.b);
      if (((localObject == null) || (OnlineStatusUtils.a(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) && (f().getVisibility() == 0))
      {
        localObject = this.a.c();
        if (((TipsManager)localObject).b() == 5)
        {
          FriendHotTipsBar.c(this.b, this.c.b);
          ((TipsManager)localObject).c();
        }
      }
    }
  }
  
  protected void d()
  {
    if (this.c.a == 1006) {
      this.d = true;
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "StrangerOnlineStatusHelper";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StrangerOnlineStatusHelper
 * JD-Core Version:    0.7.0.1
 */