package com.tencent.mobileqq.activity.contact.troop;

import ails;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import bcsz;
import bcta;
import bhht;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopNotifyAndRecommendView$9$3
  implements Runnable
{
  public TroopNotifyAndRecommendView$9$3(ails paramails, String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    long l2 = bcsz.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Ails.a.jdField_a_of_type_Bhht != null) {
          this.jdField_a_of_type_Ails.a.jdField_a_of_type_Bhht.dismiss();
        }
        Object localObject1 = this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718115);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          localObject1 = this.jdField_b_of_type_JavaLangString;
        }
        QQToast.a(this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext, 1, (CharSequence)localObject1, 0).b(this.jdField_a_of_type_Ails.a.a());
        bcta.a(bcsz.a().a(Long.valueOf(l1)), this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.d);
        localObject1 = bcsz.a().a(Long.valueOf(l1));
        if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg_type.get() == 2))
        {
          this.jdField_a_of_type_Ails.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
          TroopNotifyAndRecommendView.j(this.jdField_a_of_type_Ails.a);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l1 = l2;
      }
      if (this.jdField_a_of_type_Ails.a.jdField_a_of_type_Bhht != null) {
        this.jdField_a_of_type_Ails.a.jdField_a_of_type_Bhht.dismiss();
      }
      String str = this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692466);
      if (this.jdField_b_of_type_Int == 1)
      {
        localObject2 = bcsz.a().a(Long.valueOf(l1));
        if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 82)) {
          localObject2 = this.jdField_c_of_type_JavaLangString;
        }
      }
      do
      {
        for (;;)
        {
          QQToast.a(this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext, 2, (CharSequence)localObject2, 0).b(this.jdField_a_of_type_Ails.a.a());
          l2 = bcsz.a().a();
          bcta.a(bcsz.a().a(Long.valueOf(l1)), this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
          ThreadManager.postImmediately(new TroopNotifyAndRecommendView.9.3.1(this, bcsz.a().a(Long.valueOf(l1)), l2), null, false);
          this.jdField_a_of_type_Ails.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
          TroopNotifyAndRecommendView.j(this.jdField_a_of_type_Ails.a);
          TroopNotifyAndRecommendView.h(this.jdField_a_of_type_Ails.a);
          return;
          localObject2 = this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692460);
          continue;
          if (this.jdField_b_of_type_Int == 2)
          {
            localObject2 = this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692465);
          }
          else
          {
            if (this.jdField_b_of_type_Int != 0) {
              break;
            }
            structmsg.StructMsg localStructMsg = bcsz.a().a(Long.valueOf(l1));
            localObject2 = str;
            if (localStructMsg != null)
            {
              localObject2 = str;
              if (localStructMsg.msg.group_msg_type.get() == 82) {
                localObject2 = this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692465);
              }
            }
          }
        }
        localObject2 = str;
      } while (this.jdField_b_of_type_Int != 3);
      l1 = bcsz.a().a();
      Object localObject2 = bcsz.a().a();
      this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq((String)localObject2, 0, l1, false);
      QQToast.a(this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692462), 0).b(this.jdField_a_of_type_Ails.a.a());
      if (((String)localObject2).equals(AppConstants.TROOP_SYSTEM_MSG_UIN))
      {
        TroopNotifyAndRecommendView.k(this.jdField_a_of_type_Ails.a);
        return;
      }
      TroopNotifyAndRecommendView.l(this.jdField_a_of_type_Ails.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.3
 * JD-Core Version:    0.7.0.1
 */