import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class azhu
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, mmn parammmn)
  {
    if (paramLong <= 0L) {
      return;
    }
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.2.6,3,4370");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.luin.set(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    mmj.a(paramQQAppInterface, parammmn, localGetPublicAccountDetailInfoRequest.toByteArray(), "PubAccountSvc.get_detail_info", localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, mmn parammmn, Bundle paramBundle)
  {
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    localFollowRequest.luin.set(paramLong);
    localFollowRequest.ext.set("0");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    mmj.a(paramQQAppInterface, parammmn, localFollowRequest.toByteArray(), "PubAccountSvc.follow", localBundle);
    ndn.a(paramQQAppInterface, "" + paramLong, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhu
 * JD-Core Version:    0.7.0.1
 */