public class aoqs
  implements aoqr
{
  public void a(anyz paramanyz, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, anza paramanza)
  {
    switch (paramInt)
    {
    case 8021: 
    case 8025: 
    case 8026: 
    case 8027: 
    case 8028: 
    case 8029: 
    default: 
      return;
    case 8017: 
      paramanyz.reqInsertBlacklistPB(paramBoolean, paramObject);
      return;
    case 8024: 
      if (paramObject != null) {}
      for (paramArrayOfObject = ((bdxu)paramObject).a;; paramArrayOfObject = null)
      {
        paramanyz.onSubAccountThirdQQUnreadMsgNum(paramBoolean, paramArrayOfObject, (bdxu)paramObject);
        return;
      }
    case 8016: 
      paramanyz.msgRevokeRsp(paramBoolean, paramArrayOfObject);
      return;
    case 8018: 
      paramanyz.reqBlessDirtyTextCheck(paramBoolean, paramArrayOfObject);
      return;
    case 8019: 
      paramanyz.reqBlessMsg(paramBoolean, paramArrayOfObject);
      return;
    case 8020: 
      paramanyz.newMessageAdded(paramObject);
      return;
    case 8022: 
      paramanyz.msgStartSendingUI(paramArrayOfObject);
      return;
    case 8023: 
      paramanyz.onBoxMsgUnreadNumRefresh();
      return;
    case 8030: 
      paramanyz.addFriendByContact(paramBoolean, paramArrayOfObject);
      return;
    }
    paramanyz.onMsgForwardWXResult(((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqs
 * JD-Core Version:    0.7.0.1
 */