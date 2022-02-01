package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.KanDianPrivateChatHelperProvider;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class KanDianPrivateChatPie
  extends BaseChatPie
  implements Handler.Callback
{
  private final MessageObserver bi = new KanDianPrivateChatPie.1(this);
  private final FriendListObserver bj = new KanDianPrivateChatPie.2(this);
  private final View.OnClickListener bk = new KanDianPrivateChatPie.3(this);
  private boolean bl = false;
  
  public KanDianPrivateChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a()
  {
    aX().runOnUiThread(new KanDianPrivateChatPie.4(this));
  }
  
  protected void E()
  {
    super.E();
    if (this.ah != null)
    {
      if (TextUtils.isEmpty(this.ah.b)) {
        return;
      }
      long l;
      try
      {
        l = Long.parseLong(this.ah.b);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[updateFriendNick] e = ");
        localStringBuilder.append(localNumberFormatException);
        QLog.e("KanDianPrivateChatPie", 1, localStringBuilder.toString());
        l = 0L;
      }
      if (l == 0L) {
        return;
      }
      ReadInJoyUserInfo localReadInJoyUserInfo = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(l, null);
      if (localReadInJoyUserInfo != null)
      {
        this.ah.e = localReadInJoyUserInfo.nick;
        return;
      }
      this.ah.e = " ";
    }
  }
  
  protected void au()
  {
    super.au();
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "addBusinessObservers");
    }
    this.d.addObserver(this.bi);
    this.d.addObserver(this.bj);
    this.q.setOnClickListener(this.bk);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bj);
    this.d.removeObserver(this.bi);
  }
  
  protected HelperProvider b()
  {
    return new KanDianPrivateChatHelperProvider(this.f);
  }
  
  protected boolean p()
  {
    return true;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof ChatMessage)) && (((MessageRecord)paramObject).istroop == 0) && (!this.bl)) {
      this.bl = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.KanDianPrivateChatPie
 * JD-Core Version:    0.7.0.1
 */