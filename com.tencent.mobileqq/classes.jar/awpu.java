import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentNoFilterReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.DelCommentReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListNoFilterReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;

public class awpu
  implements awpq
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  
  public awpu(VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.4.8");
      paramReqBody.original_id.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public int a()
  {
    try
    {
      int i = Integer.parseInt("8.4.8".replace(".", ""));
      return i;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CommentsDataSource", 2, "getVersionInt exp:" + localException.toString());
      }
    }
    return 0;
  }
  
  public void a(int paramInt, awps paramawps)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (!a(localReqBody))
    {
      QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
      paramawps.a();
    }
    NowNearbyVideoCommentProto.GetCommentListNoFilterReq localGetCommentListNoFilterReq = new NowNearbyVideoCommentProto.GetCommentListNoFilterReq();
    localGetCommentListNoFilterReq.count.set(20L);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString)) {
      localGetCommentListNoFilterReq.feed_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
    }
    localGetCommentListNoFilterReq.feed_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j);
    localGetCommentListNoFilterReq.page.set(paramInt);
    localGetCommentListNoFilterReq.filter.set(0L);
    localReqBody.cmd.set(857);
    localReqBody.subcmd.set(8);
    localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetCommentListNoFilterReq.toByteArray()));
    nmb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new awpv(this, paramawps), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
  }
  
  public void a(Comments.Comment paramComment, awpr paramawpr)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody))
    {
      localReqBody.cmd.set(857);
      localReqBody.subcmd.set(3);
      NowNearbyVideoCommentProto.DelCommentReq localDelCommentReq = new NowNearbyVideoCommentProto.DelCommentReq();
      localDelCommentReq.feed_id.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString.getBytes()));
      localDelCommentReq.comment_id.set(paramComment.jdField_a_of_type_Long);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localDelCommentReq.toByteArray()));
      nmb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new awpx(this, paramawpr, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
      return;
    }
    paramawpr.a(paramComment, -1);
  }
  
  public void a(Comments.Comment paramComment, awpt paramawpt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (!a(localReqBody))
    {
      QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
      paramawpt.a(paramComment, -1, "");
      return;
    }
    NowNearbyVideoCommentProto.AddCommentNoFilterReq localAddCommentNoFilterReq = new NowNearbyVideoCommentProto.AddCommentNoFilterReq();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j == 6) {
      localAddCommentNoFilterReq.feed_type.set(6L);
    }
    for (;;)
    {
      localAddCommentNoFilterReq.feed_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      Object localObject = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject).uid.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_c_of_type_Long);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).user_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Int);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).now_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.d);
      localAddCommentNoFilterReq.video_recorder.set((MessageMicro)localObject);
      if ((paramComment.e > 0L) || (paramComment.f > 0L))
      {
        localObject = new NowNearbyVideoCommentProto.UserInfo();
        ((NowNearbyVideoCommentProto.UserInfo)localObject).uid.set(paramComment.e);
        ((NowNearbyVideoCommentProto.UserInfo)localObject).user_type.set(paramComment.jdField_c_of_type_Int);
        ((NowNearbyVideoCommentProto.UserInfo)localObject).now_id.set(paramComment.f);
        localAddCommentNoFilterReq.reply_user.set((MessageMicro)localObject);
      }
      localObject = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject).uid.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Long);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).now_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_h_of_type_Long);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).user_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_h_of_type_Int);
      localAddCommentNoFilterReq.video_owner.set((MessageMicro)localObject);
      localAddCommentNoFilterReq.is_aggregate_short_video.set(0);
      localObject = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject).uid.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).user_type.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_c_of_type_Int);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).now_id.set(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.b);
      localAddCommentNoFilterReq.video_anchor.set((MessageMicro)localObject);
      localObject = new NowNearbyVideoCommentProto.CommentMsgBody();
      NowNearbyVideoCommentProto.CommentMsg localCommentMsg = new NowNearbyVideoCommentProto.CommentMsg();
      localCommentMsg.msg.set(ByteStringMicro.copyFromUtf8(paramComment.jdField_a_of_type_JavaLangString));
      localCommentMsg.type.set(0);
      ((NowNearbyVideoCommentProto.CommentMsgBody)localObject).msgs.add(localCommentMsg);
      localAddCommentNoFilterReq.content.set((MessageMicro)localObject);
      localReqBody.cmd.set(857);
      localReqBody.subcmd.set(9);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localAddCommentNoFilterReq.toByteArray()));
      if (QLog.isColorLevel()) {
        QLog.i("CommentsDataSource", 2, "print bytes count =" + localAddCommentNoFilterReq.toByteArray().length);
      }
      int i = a();
      QLog.i("CommentsDataSource", 1, "publishComment, qqver=" + i);
      if (i > 0) {
        localReqBody.version_code.set(i);
      }
      nmb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new awpw(this, paramawpt, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j == 4) {
        localAddCommentNoFilterReq.feed_type.set(4L);
      } else {
        localAddCommentNoFilterReq.feed_type.set(3L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpu
 * JD-Core Version:    0.7.0.1
 */