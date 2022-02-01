import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;

public class aoqa
{
  amsx jdField_a_of_type_Amsx;
  ArrayList<ApolloBaseInfo> jdField_a_of_type_JavaUtilArrayList;
  
  public aoqa(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt);
    this.jdField_a_of_type_Amsx = ((amsx)paramQQAppInterface.getManager(153));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, "saveInBatch size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    this.jdField_a_of_type_Amsx.b(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    ApolloBaseInfo localApolloBaseInfo = this.jdField_a_of_type_Amsx.b(paramFriends.uin);
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
 * Qualified Name:     aoqa
 * JD-Core Version:    0.7.0.1
 */