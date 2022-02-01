package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotifyAndRecommendView$8$3
  implements Runnable
{
  TroopNotifyAndRecommendView$8$3(TroopNotifyAndRecommendView.8 param8, String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (String str1 = this.jdField_a_of_type_JavaLangString; !this.jdField_a_of_type_Boolean; str1 = GroupSystemMsgController.a().b())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719023);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext, 1, (CharSequence)localObject, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.a());
      SystemMsgUtils.a(GroupSystemMsgController.a().a(str1), this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.d);
      localObject = GroupSystemMsgController.a().a(str1);
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg_type.get() == 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
        TroopNotifyAndRecommendView.j(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692705);
    if (this.jdField_b_of_type_Int == 1)
    {
      localObject = GroupSystemMsgController.a().a(str1);
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.group_msg_type.get() == 82)) {
        localObject = this.jdField_c_of_type_JavaLangString;
      }
    }
    do
    {
      for (;;)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext, 2, (CharSequence)localObject, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.a());
        l = GroupSystemMsgController.a().a();
        SystemMsgUtils.a(GroupSystemMsgController.a().a(str1), this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
        localObject = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
        ThreadManager.postImmediately(new TroopNotifyAndRecommendView.8.3.1(this, GroupSystemMsgController.a().a(str1), l), null, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
        TroopNotifyAndRecommendView.j(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
        TroopNotifyAndRecommendView.h(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692699);
        continue;
        if (this.jdField_b_of_type_Int == 2)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692704);
        }
        else
        {
          if (this.jdField_b_of_type_Int != 0) {
            break;
          }
          structmsg.StructMsg localStructMsg = GroupSystemMsgController.a().a(str1);
          localObject = str2;
          if (localStructMsg != null)
          {
            localObject = str2;
            if (localStructMsg.msg.group_msg_type.get() == 82) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692704);
            }
          }
        }
      }
      localObject = str2;
    } while (this.jdField_b_of_type_Int != 3);
    long l = GroupSystemMsgController.a().a();
    Object localObject = GroupSystemMsgController.a().a();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692701), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.a());
    if (((String)localObject).equals(AppConstants.TROOP_SYSTEM_MSG_UIN))
    {
      ((TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a(l, (String)localObject, 0, false);
      TroopNotifyAndRecommendView.k(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b((String)localObject, 0, l, false);
    TroopNotifyAndRecommendView.l(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.3
 * JD-Core Version:    0.7.0.1
 */