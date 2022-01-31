import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentNoFilterResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class athb
  extends mxl
{
  athb(atgz paramatgz, atgy paramatgy, Comments.Comment paramComment) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("CommentsDataSource", 1, "errorCode:" + paramInt);
    paramBundle = "";
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      oidb_0xada.RspBody localRspBody = new oidb_0xada.RspBody();
      for (;;)
      {
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.i("CommentsDataSource", 2, "err_msg:   " + localRspBody.err_msg.get());
          }
          if (!localRspBody.busi_buf.has())
          {
            QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
            this.jdField_a_of_type_Atgy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1, "");
            return;
          }
          localAddCommentNoFilterResp = new NowNearbyVideoCommentProto.AddCommentNoFilterResp();
          localAddCommentNoFilterResp.mergeFrom(localRspBody.busi_buf.get().toByteArray());
          if (!localAddCommentNoFilterResp.wording.has()) {
            continue;
          }
          paramArrayOfByte = localAddCommentNoFilterResp.wording.get().toStringUtf8();
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          NowNearbyVideoCommentProto.AddCommentNoFilterResp localAddCommentNoFilterResp;
          paramArrayOfByte = paramBundle;
          continue;
          paramArrayOfByte = "";
          continue;
        }
        try
        {
          QLog.d("CommentsDataSource", 1, "id: " + localAddCommentNoFilterResp.comment_id.get() + ",ret:" + localAddCommentNoFilterResp.result.get() + ", tip=" + paramArrayOfByte);
          if (localAddCommentNoFilterResp.result.get() == 0L) {
            continue;
          }
          QLog.i("CommentsDataSource", 1, "error code :" + localAddCommentNoFilterResp.result.get());
          this.jdField_a_of_type_Atgy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, (int)localAddCommentNoFilterResp.result.get(), paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramBundle) {}
      }
      QLog.i("CommentsDataSource", 1, "merge publish resp data error");
      this.jdField_a_of_type_Atgy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1, paramArrayOfByte);
      return;
      if (localAddCommentNoFilterResp.comment_id.get() > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment.a = localAddCommentNoFilterResp.comment_id.get();
        this.jdField_a_of_type_Atgy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment);
        atgz.a(this.jdField_a_of_type_Atgz).add(Long.valueOf(localAddCommentNoFilterResp.comment_id.get()));
        paramBundle = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramBundle != null) {
          ((atvq)paramBundle.getManager(263)).e(atgz.a(this.jdField_a_of_type_Atgz).a);
        }
      }
    }
    else
    {
      QLog.i("CommentsDataSource", 1, "publishComment failed");
      this.jdField_a_of_type_Atgy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment, -1, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     athb
 * JD-Core Version:    0.7.0.1
 */