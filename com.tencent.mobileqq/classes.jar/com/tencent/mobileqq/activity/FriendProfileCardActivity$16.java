package com.tencent.mobileqq.activity;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class FriendProfileCardActivity$16
  implements Handler.Callback
{
  FriendProfileCardActivity$16(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    boolean bool = false;
    Object localObject1;
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof Card))
      {
        localObject1 = (Card)paramMessage.obj;
        String str = ((Card)localObject1).uin;
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "MSG_SWITCH_TO_FRIEND, uin = " + (String)localObject1 + ", obj: " + paramMessage.obj + "");
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        this.a.a(localObject2, (String)localObject1);
      }
      label273:
      label318:
      label365:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                int i;
                do
                {
                  return true;
                  if (!(paramMessage.obj instanceof String)) {
                    break label596;
                  }
                  localObject1 = (String)paramMessage.obj;
                  break;
                  if (paramMessage.what != 5) {
                    break label318;
                  }
                  if (paramMessage.arg1 == 1) {}
                  for (bool = true;; bool = false)
                  {
                    i = paramMessage.arg2;
                    if (!(paramMessage.obj instanceof Card)) {
                      break;
                    }
                    localObject1 = (Card)paramMessage.obj;
                    this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.profilecard.FrdProfileCard", 2, "UI_MSG_UPDATE_CARD: isNegRet = " + bool + " msgSource = " + i);
                    }
                    this.a.a((Card)localObject1, bool);
                    if (i != 1) {
                      break label273;
                    }
                    this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("updateCardByDbEnd", false);
                    return true;
                  }
                } while ((i != 7) && (i != 8) && (paramMessage.arg2 != 12) && (paramMessage.arg2 != 11));
                this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("updateCardBySSOEnd", false);
                return true;
                if (paramMessage.what != 4) {
                  break label365;
                }
                if (paramMessage.arg1 == 1) {
                  bool = true;
                }
              } while (!(paramMessage.obj instanceof ContactCard));
              paramMessage = (ContactCard)paramMessage.obj;
              this.a.a(paramMessage, bool);
              return true;
              if (paramMessage.what != 10) {
                break label473;
              }
            } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null);
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
            }
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Boolean = true;
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
            this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
            return true;
          } while (paramMessage.what != 14);
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null) {
            break label539;
          }
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.getChildView("map_key_like");
          if ((paramMessage instanceof VoteView))
          {
            ((VoteView)paramMessage).a(true);
            return true;
          }
        } while (!(paramMessage instanceof VoteViewV2));
        ((VoteViewV2)paramMessage).a(true);
        return true;
      } while (paramMessage.arg1 <= 0);
      label473:
      localObject1 = this.a.b.obtainMessage();
      label539:
      ((Message)localObject1).what = paramMessage.what;
      ((Message)localObject1).arg1 = (paramMessage.arg1 - 1);
      this.a.b.sendMessageDelayed((Message)localObject1, 1000L);
      return true;
      label596:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.16
 * JD-Core Version:    0.7.0.1
 */