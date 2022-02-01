package com.tencent.mobileqq.activity.qwallet;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchReply;

class RedPacketKuaKuaFragment$4$1$1
  implements BusinessObserver
{
  RedPacketKuaKuaFragment$4$1$1(RedPacketKuaKuaFragment.4.1 param1, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a.b()) {
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "getActivity() == null || getActivity().isFinishing()");
      }
    }
    Object localObject;
    long l;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketKuaKuaFragment", 2, "onReceive:type:" + paramInt + ",isSuccess:" + paramBoolean + ",bundle:" + paramBundle + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if ((paramBundle == null) || (paramBundle.length <= 0) || (!paramBoolean)) {
            break label516;
          }
          localObject = new kua_kua_hb_srv.TopicMatchReply();
          ((kua_kua_hb_srv.TopicMatchReply)localObject).mergeFrom(paramBundle);
          l = ((kua_kua_hb_srv.TopicMatchReply)localObject).retCode.get();
          if (l == 1L)
          {
            RedPacketKuaKuaFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a, ((kua_kua_hb_srv.TopicMatchReply)localObject).matchToken.get());
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a.b();
            ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.pass", 0, 0, RedPacketKuaKuaFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a).mQQWalletRedPacketMsg.elem.title, "", "", "");
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          paramBundle.printStackTrace();
          QLog.e("RedPacketKuaKuaFragment", 1, "onReceive fail exception:" + paramBundle.getMessage());
          return;
        }
        if (l != 99L) {
          break;
        }
        RedPacketKuaKuaFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a, ((kua_kua_hb_srv.TopicMatchReply)localObject).refuseInterval.get());
        RedPacketKuaKuaFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a, NetConnInfoCenter.getServerTime());
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a.a(HardCodeUtil.a(2131705987));
      } while (RedPacketKuaKuaFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a) <= 0L);
      paramBundle = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a.getActivity().findViewById(2131368971);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a.getResources().getDrawable(2130843687);
      paramBundle.setBackgroundDrawable((Drawable)localObject);
      paramBundle.setVisibility(0);
      ((Animatable)localObject).start();
      ThreadManager.getUIHandler().postDelayed(new RedPacketKuaKuaFragment.4.1.1.1(this, (Drawable)localObject, paramBundle), RedPacketKuaKuaFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a) * 1000L);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a.a(HardCodeUtil.a(2131705989));
    } while (!QLog.isColorLevel());
    QLog.e("RedPacketKuaKuaFragment", 2, "onReceive fail,retCode:" + l + "retMsg:" + ((kua_kua_hb_srv.TopicMatchReply)localObject).retMsg.get());
    return;
    label516:
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKuaKuaFragment$4$1.a.a.a(HardCodeUtil.a(2131705996));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment.4.1.1
 * JD-Core Version:    0.7.0.1
 */