import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class bajl
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, mxj parammxj)
  {
    if (paramLong <= 0L) {
      return;
    }
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.3.0,3,4480");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.luin.set(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    mxf.a(paramQQAppInterface, parammxj, localGetPublicAccountDetailInfoRequest.toByteArray(), "PubAccountSvc.get_detail_info", localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, mxj parammxj, Bundle paramBundle)
  {
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    localFollowRequest.luin.set(paramLong);
    localFollowRequest.ext.set("0");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    mxf.a(paramQQAppInterface, parammxj, localFollowRequest.toByteArray(), "PubAccountSvc.follow", localBundle);
    nol.a(paramQQAppInterface, "" + paramLong, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bajl
 * JD-Core Version:    0.7.0.1
 */