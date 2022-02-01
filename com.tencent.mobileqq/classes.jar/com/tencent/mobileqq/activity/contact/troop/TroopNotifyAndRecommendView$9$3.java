package com.tencent.mobileqq.activity.contact.troop;

import ajfm;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import bdgn;
import bdgo;
import biau;
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
  public TroopNotifyAndRecommendView$9$3(ajfm paramajfm, String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    long l2 = bdgn.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    String str;
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Biau != null) {
          this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Biau.dismiss();
        }
        Object localObject1 = this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131717746);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          localObject1 = this.jdField_b_of_type_JavaLangString;
        }
        QQToast.a(this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_AndroidContentContext, 1, (CharSequence)localObject1, 0).b(this.jdField_a_of_type_Ajfm.a.a());
        bdgo.a(bdgn.a().a(Long.valueOf(l1)), this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.d);
        localObject1 = bdgn.a().a(Long.valueOf(l1));
        if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg_type.get() == 2))
        {
          this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
          TroopNotifyAndRecommendView.e(this.jdField_a_of_type_Ajfm.a);
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
      if (this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Biau != null) {
        this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Biau.dismiss();
      }
      str = this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692412);
      if (this.jdField_b_of_type_Int != 1) {
        break label463;
      }
    }
    Object localObject2 = bdgn.a().a(Long.valueOf(l1));
    if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 82)) {
      localObject2 = this.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_AndroidContentContext, 2, (CharSequence)localObject2, 0).b(this.jdField_a_of_type_Ajfm.a.a());
      l2 = bdgn.a().a();
      bdgo.a(bdgn.a().a(Long.valueOf(l1)), this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
      ThreadManager.postImmediately(new TroopNotifyAndRecommendView.9.3.1(this, bdgn.a().a(Long.valueOf(l1)), l2), null, false);
      this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
      TroopNotifyAndRecommendView.e(this.jdField_a_of_type_Ajfm.a);
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajfm.a);
      return;
      localObject2 = this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692406);
      continue;
      label463:
      if (this.jdField_b_of_type_Int == 2)
      {
        localObject2 = this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692411);
      }
      else
      {
        localObject2 = str;
        if (this.jdField_b_of_type_Int == 0)
        {
          structmsg.StructMsg localStructMsg = bdgn.a().a(Long.valueOf(l1));
          localObject2 = str;
          if (localStructMsg != null)
          {
            localObject2 = str;
            if (localStructMsg.msg.group_msg_type.get() == 82) {
              localObject2 = this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692411);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.3
 * JD-Core Version:    0.7.0.1
 */