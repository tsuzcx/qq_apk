package com.tencent.mobileqq.activity.selectable;

import aeqo;
import ajxs;
import alaz;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ChatSelCurPageForLSSHelper$1
  implements Runnable
{
  public ChatSelCurPageForLSSHelper$1(ajxs paramajxs) {}
  
  public void run()
  {
    int i = ajxs.a(this.this$0).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    int j = ajxs.a(this.this$0).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    List localList;
    if (j >= i)
    {
      j -= i;
      localList = ajxs.a(this.this$0).jdField_a_of_type_Aeqo.a();
      if (j < localList.size()) {
        break label115;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ChatSelCurPageForLSSHelper", 2, "selectMsgForLongScreenShot but firstPosition = " + j + "; list.size = " + localList.size());
      }
    }
    label115:
    int k;
    Object localObject2;
    do
    {
      do
      {
        return;
        j = 0;
        break;
        k = ajxs.a(this.this$0).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() - i;
        i = k;
        if (k >= localList.size()) {
          i = localList.size() - 1;
        }
        k = i;
        if (ajxs.a(this.this$0).c != null)
        {
          Object localObject3 = ajxs.a(this.this$0).c.findViewById(2131366994);
          localObject1 = ajxs.a(this.this$0).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(ajxs.a(this.this$0).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1);
          k = i;
          if (localObject3 != null)
          {
            k = i;
            if (localObject1 != null)
            {
              localObject2 = new int[2];
              ((View)localObject3).getLocationOnScreen((int[])localObject2);
              localObject3 = new int[2];
              ((View)localObject1).getLocationOnScreen((int[])localObject3);
              k = i;
              if (localObject3[1] >= localObject2[1])
              {
                i -= 1;
                k = i;
                if (QLog.isColorLevel())
                {
                  QLog.d("ChatSelCurPageForLSSHelper", 2, "lastPosition--, lastViewLocation[1] = " + localObject3[1] + "; inputViewY = " + localObject2[1]);
                  k = i;
                }
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ChatSelCurPageForLSSHelper", 2, "selectMsgForLongScreenShot: firstPosition = " + j + "; lastPosition = " + k + "; list.size = " + localList.size());
        }
      } while ((j < 0) || (k < j));
      Object localObject1 = (ChatMessage)localList.get(j);
      localObject2 = (AIOLongShotHelper)ajxs.a(this.this$0).a(15);
      ((AIOLongShotHelper)localObject2).a((ChatMessage)localObject1);
      ajxs.a(this.this$0).j(true);
      alaz.a(ajxs.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
    } while (k <= j);
    ((AIOLongShotHelper)localObject2).a((ChatMessage)localList.get(k), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatSelCurPageForLSSHelper.1
 * JD-Core Version:    0.7.0.1
 */