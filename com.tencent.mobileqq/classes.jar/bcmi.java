import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class bcmi
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, nac paramnac)
  {
    if (paramLong <= 0L) {
      return;
    }
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.3.5,3,4555");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.luin.set(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    mzy.a(paramQQAppInterface, paramnac, localGetPublicAccountDetailInfoRequest.toByteArray(), "PubAccountSvc.get_detail_info", localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, nac paramnac, Bundle paramBundle)
  {
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    localFollowRequest.luin.set(paramLong);
    localFollowRequest.ext.set("0");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    mzy.a(paramQQAppInterface, paramnac, localFollowRequest.toByteArray(), "PubAccountSvc.follow", localBundle);
    nrt.a(paramQQAppInterface, "" + paramLong, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmi
 * JD-Core Version:    0.7.0.1
 */