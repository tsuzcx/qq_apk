package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.richstatus.sign.AIOSignViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class SignatureHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private final BaseChatPie a;
  private final FriendListObserver b = new SignatureHelper.1(this);
  
  public SignatureHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    this.a.i().removeObserver(this.b);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Map)paramMessage.obj;
    int i = this.a.V.b((ChatMessage)paramMessage.get("chatMessage"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateZanInfo pos is:");
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.msg.delmsg", 2, ((StringBuilder)localObject).toString());
    }
    if (i < 0) {
      return;
    }
    Object localObject = this.a.U;
    int j = ((ChatXListView)localObject).getFirstVisiblePosition();
    int k = ((ChatXListView)localObject).getHeaderViewsCount();
    int m = ((ChatXListView)localObject).getLastVisiblePosition();
    int n = ((ChatXListView)localObject).getHeaderViewsCount();
    if ((i >= j - k) && (i <= m - n))
    {
      localObject = ((ChatXListView)localObject).getChildAt(i - ((ChatXListView)localObject).getFirstVisiblePosition());
      if ((localObject instanceof LinearLayout))
      {
        paramMessage = (RichStatus.SigZanInfo)paramMessage.get("sigZanInfo");
        if ((AIOUtils.b((View)localObject) instanceof RichStatItemBuilder.Holder))
        {
          localObject = (RichStatItemBuilder.Holder)AIOUtils.b((View)localObject);
          if ((paramMessage.a != null) && (paramMessage.a.equals(((RichStatItemBuilder.Holder)localObject).d.f)))
          {
            ((RichStatItemBuilder.Holder)localObject).d.h = paramMessage.c;
            ((RichStatItemBuilder.Holder)localObject).d.y = paramMessage.d;
            ((RichStatItemBuilder.Holder)localObject).d.t();
          }
        }
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if (this.a.bv().x() != 0) {
      return;
    }
    if (RichStatItemBuilder.e == 0L) {
      return;
    }
    if ((paramObject instanceof RichStatus.SigZanInfo)) {
      ThreadManager.post(new SignatureHelper.2(this, (RichStatus.SigZanInfo)paramObject), 5, null, false);
    }
  }
  
  private void b()
  {
    this.a.i().addObserver(this.b);
  }
  
  @NonNull
  public String getTag()
  {
    return "SignatureHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (267387138 == paramMessage.what) {
      a(paramMessage);
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 10)
      {
        if (paramInt != 15) {
          return;
        }
        a();
        return;
      }
      SignatureManager.a(this.a.i(), this.a.aE().b, null);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SignatureHelper
 * JD-Core Version:    0.7.0.1
 */