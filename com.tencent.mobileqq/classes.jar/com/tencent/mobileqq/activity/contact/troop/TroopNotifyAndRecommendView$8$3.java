package com.tencent.mobileqq.activity.contact.troop;

import ajfn;
import ajgp;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import bdzy;
import bdzz;
import bisl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopNotifyAndRecommendView$8$3
  implements Runnable
{
  public TroopNotifyAndRecommendView$8$3(ajgp paramajgp, String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (String str1 = this.jdField_a_of_type_JavaLangString; !this.jdField_a_of_type_Boolean; str1 = bdzy.a().b())
    {
      if (this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Bisl != null) {
        this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Bisl.dismiss();
      }
      localObject = this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718500);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
      QQToast.a(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext, 1, (CharSequence)localObject, 0).b(this.jdField_a_of_type_Ajgp.a.a());
      bdzz.a(bdzy.a().a(str1), this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.d);
      localObject = bdzy.a().a(str1);
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg_type.get() == 2))
      {
        this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
        TroopNotifyAndRecommendView.j(this.jdField_a_of_type_Ajgp.a);
      }
      return;
    }
    if (this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Bisl.dismiss();
    }
    String str2 = this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692568);
    if (this.jdField_b_of_type_Int == 1)
    {
      localObject = bdzy.a().a(str1);
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.group_msg_type.get() == 82)) {
        localObject = this.jdField_c_of_type_JavaLangString;
      }
    }
    do
    {
      for (;;)
      {
        QQToast.a(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext, 2, (CharSequence)localObject, 0).b(this.jdField_a_of_type_Ajgp.a.a());
        l = bdzy.a().a();
        bdzz.a(bdzy.a().a(str1), this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
        localObject = (ajfn)this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
        ThreadManager.postImmediately(new TroopNotifyAndRecommendView.8.3.1(this, bdzy.a().a(str1), l), null, false);
        this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
        TroopNotifyAndRecommendView.j(this.jdField_a_of_type_Ajgp.a);
        TroopNotifyAndRecommendView.h(this.jdField_a_of_type_Ajgp.a);
        return;
        localObject = this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692562);
        continue;
        if (this.jdField_b_of_type_Int == 2)
        {
          localObject = this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692567);
        }
        else
        {
          if (this.jdField_b_of_type_Int != 0) {
            break;
          }
          structmsg.StructMsg localStructMsg = bdzy.a().a(str1);
          localObject = str2;
          if (localStructMsg != null)
          {
            localObject = str2;
            if (localStructMsg.msg.group_msg_type.get() == 82) {
              localObject = this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692567);
            }
          }
        }
      }
      localObject = str2;
    } while (this.jdField_b_of_type_Int != 3);
    long l = bdzy.a().a();
    Object localObject = bdzy.a().a();
    QQToast.a(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692564), 0).b(this.jdField_a_of_type_Ajgp.a.a());
    if (((String)localObject).equals(AppConstants.TROOP_SYSTEM_MSG_UIN))
    {
      ((ajfn)this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a(l, (String)localObject, 0, false);
      TroopNotifyAndRecommendView.k(this.jdField_a_of_type_Ajgp.a);
      return;
    }
    this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq((String)localObject, 0, l, false);
    TroopNotifyAndRecommendView.l(this.jdField_a_of_type_Ajgp.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.3
 * JD-Core Version:    0.7.0.1
 */