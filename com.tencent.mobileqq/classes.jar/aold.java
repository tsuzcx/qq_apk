import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;

public class aold
{
  amme jdField_a_of_type_Amme;
  ArrayList<ApolloBaseInfo> jdField_a_of_type_JavaUtilArrayList;
  
  public aold(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt);
    this.jdField_a_of_type_Amme = ((amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, "saveInBatch size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    this.jdField_a_of_type_Amme.b(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    ApolloBaseInfo localApolloBaseInfo = this.jdField_a_of_type_Amme.b(paramFriends.uin);
    if (localApolloBaseInfo != null) {
      if ((localApolloBaseInfo.apolloStatus != paramFriendInfo.cApolloFlag) || (localApolloBaseInfo.apolloServerTS != paramFriendInfo.uApolloTimestamp) || (localApolloBaseInfo.apolloSignValidTS != paramFriendInfo.uApolloSignTime) || (localApolloBaseInfo.cmshow3dFlag != paramFriendInfo.cCentiShow3DFlag))
      {
        localApolloBaseInfo.apolloStatus = paramFriendInfo.cApolloFlag;
        localApolloBaseInfo.apolloServerTS = paramFriendInfo.uApolloTimestamp;
        localApolloBaseInfo.apolloSignValidTS = paramFriendInfo.uApolloSignTime;
        localApolloBaseInfo.apolloSignStr = "";
        localApolloBaseInfo.cmshow3dFlag = paramFriendInfo.cCentiShow3DFlag;
        localApolloBaseInfo.apolloUpdateTime = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_JavaUtilArrayList.add(localApolloBaseInfo);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, "apolloBaseInfo return null uin: " + paramFriends.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aold
 * JD-Core Version:    0.7.0.1
 */