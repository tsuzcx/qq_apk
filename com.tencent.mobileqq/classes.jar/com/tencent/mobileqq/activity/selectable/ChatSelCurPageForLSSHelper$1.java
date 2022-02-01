package com.tencent.mobileqq.activity.selectable;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatSelCurPageForLSSHelper$1
  implements Runnable
{
  ChatSelCurPageForLSSHelper$1(ChatSelCurPageForLSSHelper paramChatSelCurPageForLSSHelper) {}
  
  public void run()
  {
    int i = ChatSelCurPageForLSSHelper.a(this.this$0).U.getHeaderViewsCount();
    int j = ChatSelCurPageForLSSHelper.a(this.this$0).U.getFirstVisiblePosition();
    if (j >= i) {
      j -= i;
    } else {
      j = 0;
    }
    List localList = ChatSelCurPageForLSSHelper.a(this.this$0).V.a();
    Object localObject1;
    if (j >= localList.size())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("selectMsgForLongScreenShot but firstPosition = ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("; list.size = ");
        ((StringBuilder)localObject1).append(localList.size());
        QLog.e("ChatSelCurPageForLSSHelper", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    int k = ChatSelCurPageForLSSHelper.a(this.this$0).U.getLastVisiblePosition() - i;
    i = k;
    if (k >= localList.size()) {
      i = localList.size() - 1;
    }
    k = i;
    Object localObject2;
    if (ChatSelCurPageForLSSHelper.a(this.this$0).aZ != null)
    {
      Object localObject3 = ChatSelCurPageForLSSHelper.a(this.this$0).aZ.findViewById(2131433906);
      localObject2 = ChatSelCurPageForLSSHelper.a(this.this$0).U.getChildAt(ChatSelCurPageForLSSHelper.a(this.this$0).U.getChildCount() - 1);
      k = i;
      if (localObject3 != null)
      {
        k = i;
        if (localObject2 != null)
        {
          localObject1 = new int[2];
          ((View)localObject3).getLocationOnScreen((int[])localObject1);
          localObject3 = new int[2];
          ((View)localObject2).getLocationOnScreen((int[])localObject3);
          k = i;
          if (localObject3[1] >= localObject1[1])
          {
            i -= 1;
            k = i;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("lastPosition--, lastViewLocation[1] = ");
              ((StringBuilder)localObject2).append(localObject3[1]);
              ((StringBuilder)localObject2).append("; inputViewY = ");
              ((StringBuilder)localObject2).append(localObject1[1]);
              QLog.d("ChatSelCurPageForLSSHelper", 2, ((StringBuilder)localObject2).toString());
              k = i;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("selectMsgForLongScreenShot: firstPosition = ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("; lastPosition = ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append("; list.size = ");
      ((StringBuilder)localObject1).append(localList.size());
      QLog.d("ChatSelCurPageForLSSHelper", 2, ((StringBuilder)localObject1).toString());
    }
    if ((j >= 0) && (k >= j))
    {
      localObject1 = (ChatMessage)localList.get(j);
      localObject2 = (AIOLongShotHelper)ChatSelCurPageForLSSHelper.a(this.this$0).q(15);
      ((AIOLongShotHelper)localObject2).b((ChatMessage)localObject1);
      ChatSelCurPageForLSSHelper.a(this.this$0).i(true);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(ChatSelCurPageForLSSHelper.a(this.this$0).d, "select_more_msg", true);
      if (k > j) {
        ((AIOLongShotHelper)localObject2).a((ChatMessage)localList.get(k), null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatSelCurPageForLSSHelper.1
 * JD-Core Version:    0.7.0.1
 */