import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.Comment;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListResp;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class avck
  extends nab
{
  avck(avcj paramavcj, avch paramavch) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = false;
    QLog.i("CommentsDataSource", 1, "errorCode:" + paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        QLog.i("CommentsDataSource", 1, "err_msg:" + paramBundle.err_msg.get());
        if (!paramBundle.busi_buf.has())
        {
          QLog.i("CommentsDataSource", 1, "rspBody.busi_buf is null");
          this.jdField_a_of_type_Avch.a();
          return;
        }
        paramArrayOfByte = new NowNearbyVideoCommentProto.GetCommentListResp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        if (paramArrayOfByte.result.get() != 0L)
        {
          QLog.i("CommentsDataSource", 1, "error code :" + paramArrayOfByte.result.get());
          this.jdField_a_of_type_Avch.a();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.i("CommentsDataSource", 1, "merge data error " + paramArrayOfByte);
        this.jdField_a_of_type_Avch.a();
        return;
      }
      paramBundle = new Comments();
      paramBundle.jdField_a_of_type_Long = paramArrayOfByte.total_num.get();
      QLog.i("CommentsDataSource", 1, "all comments count is: " + paramBundle.jdField_a_of_type_Long);
      if (paramArrayOfByte.end_flag.get() == 1L) {
        bool = true;
      }
      paramBundle.jdField_a_of_type_Boolean = bool;
      paramBundle.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (paramArrayOfByte.lists.has())
      {
        Iterator localIterator = paramArrayOfByte.lists.get().iterator();
        while (localIterator.hasNext())
        {
          NowNearbyVideoCommentProto.Comment localComment = (NowNearbyVideoCommentProto.Comment)localIterator.next();
          Comments.Comment localComment1 = new Comments.Comment();
          localComment1.jdField_a_of_type_Long = localComment.comment_id.get();
          localComment1.jdField_b_of_type_Long = localComment.create_time.get();
          localComment1.jdField_a_of_type_Int = localComment.type.get();
          if (localComment.publish_info.has())
          {
            localComment1.jdField_c_of_type_Long = localComment.publish_info.uid.get();
            localComment1.jdField_b_of_type_JavaLangString = localComment.publish_info.anchor_name.get().toStringUtf8();
            localComment1.jdField_c_of_type_JavaLangString = localComment.publish_info.head_img_url.get().toStringUtf8();
            localComment1.jdField_b_of_type_Int = localComment.publish_info.user_type.get();
            localComment1.jdField_d_of_type_Long = localComment.publish_info.now_id.get();
            if (localComment.reply_info.has())
            {
              localComment1.jdField_e_of_type_Long = localComment.reply_info.uid.get();
              localComment1.jdField_d_of_type_JavaLangString = localComment.reply_info.anchor_name.get().toStringUtf8();
              localComment1.jdField_e_of_type_JavaLangString = localComment.reply_info.head_img_url.get().toStringUtf8();
              localComment1.jdField_c_of_type_Int = localComment.reply_info.user_type.get();
              localComment1.f = localComment.reply_info.now_id.get();
            }
          }
          if ((localComment.content.has()) && (localComment.content.msgs.has())) {
            localComment1.jdField_a_of_type_JavaLangString = ((NowNearbyVideoCommentProto.CommentMsg)localComment.content.msgs.get(0)).msg.get().toStringUtf8();
          }
          if (!avcj.a(this.jdField_a_of_type_Avcj).contains(Long.valueOf(localComment.comment_id.get()))) {
            avcj.a(this.jdField_a_of_type_Avcj).add(Long.valueOf(localComment.comment_id.get()));
          }
          if (localComment1.jdField_a_of_type_Int == 2) {
            paramBundle.b.add(localComment1);
          }
          paramBundle.jdField_a_of_type_JavaUtilList.add(localComment1);
        }
      }
      QLog.i("CommentsDataSource", 1, "total:" + paramArrayOfByte.total_num.get() + ", ret:" + paramArrayOfByte.result.get());
      this.jdField_a_of_type_Avch.a(paramBundle);
      return;
    }
    QLog.i("CommentsDataSource", 1, "getComments failed");
    this.jdField_a_of_type_Avch.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avck
 * JD-Core Version:    0.7.0.1
 */