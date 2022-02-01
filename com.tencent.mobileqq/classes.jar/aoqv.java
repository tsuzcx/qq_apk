import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;

public class aoqv
{
  QQAppInterface a;
  
  public aoqv(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a() {}
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriends = ((anyw)this.a.getManager(51)).e(paramFriends.uin);
    if (paramFriends != null)
    {
      amsx localamsx = (amsx)this.a.getManager(153);
      ApolloBaseInfo localApolloBaseInfo = localamsx.b(paramFriends.uin);
      if ((localApolloBaseInfo.apolloStatus != paramFriendInfo.cApolloFlag) || (localApolloBaseInfo.apolloServerTS != paramFriendInfo.uApolloTimestamp) || (localApolloBaseInfo.apolloSignValidTS != paramFriendInfo.uApolloSignTime))
      {
        localApolloBaseInfo.apolloStatus = paramFriendInfo.cApolloFlag;
        localApolloBaseInfo.apolloServerTS = paramFriendInfo.uApolloTimestamp;
        localApolloBaseInfo.apolloSignValidTS = paramFriendInfo.uApolloSignTime;
        localApolloBaseInfo.apolloSignStr = "";
        localamsx.a(localApolloBaseInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, "handleGetFriendDetailInfo, update apollo info uin=" + paramFriends.uin + "apollo status: " + paramFriendInfo.cApolloFlag + ", apollo svr TS: " + paramFriendInfo.uApolloTimestamp + ", sign TS: " + paramFriendInfo.uApolloSignTime);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqv
 * JD-Core Version:    0.7.0.1
 */