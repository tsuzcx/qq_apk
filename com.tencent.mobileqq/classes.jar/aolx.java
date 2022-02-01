import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;

public class aolx
{
  QQAppInterface a;
  
  public aolx(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a() {}
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriends = ((anvk)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramFriends.uin);
    if (paramFriends != null)
    {
      amme localamme = (amme)this.a.getManager(QQManagerFactory.APOLLO_MANAGER);
      ApolloBaseInfo localApolloBaseInfo = localamme.b(paramFriends.uin);
      if ((localApolloBaseInfo.apolloStatus != paramFriendInfo.cApolloFlag) || (localApolloBaseInfo.apolloServerTS != paramFriendInfo.uApolloTimestamp) || (localApolloBaseInfo.apolloSignValidTS != paramFriendInfo.uApolloSignTime))
      {
        localApolloBaseInfo.apolloStatus = paramFriendInfo.cApolloFlag;
        localApolloBaseInfo.apolloServerTS = paramFriendInfo.uApolloTimestamp;
        localApolloBaseInfo.apolloSignValidTS = paramFriendInfo.uApolloSignTime;
        localApolloBaseInfo.apolloSignStr = "";
        localamme.a(localApolloBaseInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, "handleGetFriendDetailInfo, update apollo info uin=" + paramFriends.uin + "apollo status: " + paramFriendInfo.cApolloFlag + ", apollo svr TS: " + paramFriendInfo.uApolloTimestamp + ", sign TS: " + paramFriendInfo.uApolloSignTime);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolx
 * JD-Core Version:    0.7.0.1
 */