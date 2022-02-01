import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.20.1;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.20.2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

public class aybe
  implements axxd
{
  aybe(ayat paramayat) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.i("PlayOperationViewModel", 2, "err_msg:   " + paramBundle.err_msg.get() + "  isFollow:" + ayat.c(this.a));
        }
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new ilive_new_anchor_follow_interface.FollowActionRsp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.i("PlayOperationViewModel", 2, "ret:   " + paramArrayOfByte.ret.get() + ",msg:     " + paramArrayOfByte.msg.get() + "  isFollow:" + ayat.c(this.a));
          }
          if (paramArrayOfByte.ret.get() == 0)
          {
            ayat.c(this.a, true);
            if (ayat.d(this.a))
            {
              ThreadManager.getUIHandler().post(new PlayOperationViewModel.20.1(this));
              ayat.d(this.a, false);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean = true;
            new axxu().h("video").i("playpage_focus").b().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            ThreadManagerV2.excute(new PlayOperationViewModel.20.2(this, (axny)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
            ((axve)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(ayat.c(this.a)), String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long) });
            return;
          }
          if (!TextUtils.isEmpty(paramArrayOfByte.msg.get()))
          {
            QQToast.a(BaseApplication.getContext(), 1, paramArrayOfByte.msg.get(), 0).a();
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybe
 * JD-Core Version:    0.7.0.1
 */