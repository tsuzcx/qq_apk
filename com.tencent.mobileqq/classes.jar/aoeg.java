import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class aoeg
  implements anui
{
  public static final int TYPE_ACCOUNT_DETAIL_DYNAMIC_LIST = 107;
  public static final int TYPE_ACCOUNT_DETAIL_FUNCTION_FLAG = 109;
  public static final int TYPE_DOWN_PUBLIC_ACCOUNT = 103;
  public static final int TYPE_FOLLOW_PUBLIC_ACCOUNT = 101;
  public static final int TYPE_GET_GUIDE_FRIENDS = 110;
  public static final int TYPE_GET_HISTORY_MESSAGE = 105;
  public static final int TYPE_GET_PUBLIC_NOTIFICATION = 106;
  public static final int TYPE_GET_RECOMMEND_LIST = 104;
  public static final int TYPE_GET_SUBSCRIBE_STATUS = 111;
  public static final int TYPE_GET_USER_FOLLOW_LIST = 100;
  public static final int TYPE_SET_KANDIAN_SUBSCRIBE = 108;
  public static final int TYPE_SET_RECVMSG_STATUS = 112;
  public static final int TYPE_UNFOLLOW_PUBLIC_ACCOUNT = 102;
  
  public void onDownPublicAccount() {}
  
  public void onDynamicListGet(boolean paramBoolean, int paramInt) {}
  
  public void onFollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, int paramInt) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString) {}
  
  public void onGetGuideFriends(boolean paramBoolean, ArrayList<Long> paramArrayList) {}
  
  public void onGetHistoryMsgRet(int paramInt) {}
  
  public void onGetPublicAccountSubscribeStatus(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void onPublicAccountNotification(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onSetPublicAccountSubscribeStatus(boolean paramBoolean, int paramInt, long paramLong) {}
  
  public void onSetRecvMsgState(boolean paramBoolean, SetRecvMsgStateRsp paramSetRecvMsgStateRsp) {}
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (100 == paramInt)
    {
      paramObject = (aoei)paramObject;
      onUpdateUserFollowList(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean);
    }
    do
    {
      return;
      if (101 == paramInt)
      {
        if ((paramObject instanceof aoeh))
        {
          paramObject = (aoeh)paramObject;
          onFollowPublicAccount(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          onFollowPublicAccount(paramBoolean, ((Integer)paramObject).intValue());
          return;
        }
        onFollowPublicAccount(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (102 == paramInt)
      {
        if ((paramObject instanceof aoeh))
        {
          paramObject = (aoeh)paramObject;
          onUnfollowPublicAccount(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
          return;
        }
        onUnfollowPublicAccount(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (103 == paramInt)
      {
        onDownPublicAccount();
        return;
      }
      if (104 == paramInt)
      {
        onUpdateRecommendList(paramBoolean);
        return;
      }
      if (105 == paramInt)
      {
        onGetHistoryMsgRet(((Integer)paramObject).intValue());
        return;
      }
      if (106 == paramInt)
      {
        onPublicAccountNotification(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      if (109 == paramInt)
      {
        onUpdateFunctionFlag(paramBoolean, (oag)paramObject);
        return;
      }
      if (108 == paramInt)
      {
        paramObject = (HashMap)paramObject;
        onSetPublicAccountSubscribeStatus(paramBoolean, ((Integer)paramObject.get("seq")).intValue(), ((Long)paramObject.get("uin")).longValue());
        return;
      }
      if (110 == paramInt)
      {
        onGetGuideFriends(paramBoolean, (ArrayList)paramObject);
        return;
      }
      if (111 == paramInt)
      {
        paramObject = (HashMap)paramObject;
        long l = 0L;
        paramInt = 0;
        if (paramObject != null)
        {
          l = ((Long)paramObject.get("uin")).longValue();
          paramInt = ((Integer)paramObject.get("status")).intValue();
        }
        onGetPublicAccountSubscribeStatus(paramBoolean, l, paramInt);
        return;
      }
    } while ((112 != paramInt) || (!(paramObject instanceof SetRecvMsgStateRsp)));
    onSetRecvMsgState(paramBoolean, (SetRecvMsgStateRsp)paramObject);
  }
  
  public void onUpdateFunctionFlag(boolean paramBoolean, oag paramoag) {}
  
  public void onUpdateRecommendList(boolean paramBoolean) {}
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoeg
 * JD-Core Version:    0.7.0.1
 */