import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_like.FeedsUnLikeRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class ayhp
  implements aydt
{
  ayhp(ayhj paramayhj, VideoData paramVideoData) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.i("PlayOperationViewModel", 2, "err_msg:   " + paramBundle.err_msg.get() + " isLiked=" + ayhj.a(this.jdField_a_of_type_Ayhj));
        }
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new ilive_feeds_like.FeedsUnLikeRsp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          this.jdField_a_of_type_Ayhj.f(false);
          this.jdField_a_of_type_Ayhj.d(paramArrayOfByte.total.get());
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_b_of_type_Int = ayhj.a(this.jdField_a_of_type_Ayhj);
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_b_of_type_Boolean = false;
          ayhj.b(this.jdField_a_of_type_Ayhj, false);
          ((ayrf)this.jdField_a_of_type_Ayhj.a.getManager(263)).b(ayhj.a(this.jdField_a_of_type_Ayhj), paramArrayOfByte.total.get());
          if (QLog.isColorLevel()) {
            QLog.i("PlayOperationViewModel", 2, "total:   " + paramArrayOfByte.total.get() + ",ret:     " + paramArrayOfByte.ret.get());
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.w("PlayOperationViewModel", 1, "err_msg:   " + paramBundle.err_msg.get() + " isLiked=" + ayhj.a(this.jdField_a_of_type_Ayhj) + "  e:" + paramArrayOfByte);
        return;
      }
    }
    QLog.w("PlayOperationViewModel", 1, "errorCode:   " + paramInt + " isLiked=" + ayhj.a(this.jdField_a_of_type_Ayhj));
    ayhj.b(this.jdField_a_of_type_Ayhj, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhp
 * JD-Core Version:    0.7.0.1
 */