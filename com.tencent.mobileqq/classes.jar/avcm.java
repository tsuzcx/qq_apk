import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.DelCommentResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class avcm
  extends nab
{
  avcm(avcj paramavcj, avcg paramavcg, Comments.Comment paramComment) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("CommentsDataSource", 1, "errorCode:" + paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        QLog.i("CommentsDataSource", 1, "err_msg:" + paramBundle.err_msg.get());
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new NowNearbyVideoCommentProto.DelCommentResp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.i("CommentsDataSource", 1, "ret:" + paramArrayOfByte.result.get());
          }
          this.jdField_a_of_type_Avcg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, (int)paramArrayOfByte.result.get());
          paramArrayOfByte = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramArrayOfByte == null) {
            return;
          }
          ((avrb)paramArrayOfByte.getManager(263)).a(avcj.a(this.jdField_a_of_type_Avcj).a, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment.a);
          return;
        }
        QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
        this.jdField_a_of_type_Avcg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("CommentsDataSource", 1, "merge delete resp data error");
        this.jdField_a_of_type_Avcg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
        return;
      }
    }
    else
    {
      this.jdField_a_of_type_Avcg.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avcm
 * JD-Core Version:    0.7.0.1
 */