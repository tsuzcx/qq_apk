public class annz
  implements anny
{
  public void a(amwl paramamwl, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, amwm paramamwm)
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
      paramamwl.reqInsertBlacklistPB(paramBoolean, paramObject);
      return;
    case 8024: 
      if (paramObject != null) {}
      for (paramArrayOfObject = ((bcqv)paramObject).a;; paramArrayOfObject = null)
      {
        paramamwl.onSubAccountThirdQQUnreadMsgNum(paramBoolean, paramArrayOfObject, (bcqv)paramObject);
        return;
      }
    case 8016: 
      paramamwl.msgRevokeRsp(paramBoolean, paramArrayOfObject);
      return;
    case 8018: 
      paramamwl.reqBlessDirtyTextCheck(paramBoolean, paramArrayOfObject);
      return;
    case 8019: 
      paramamwl.reqBlessMsg(paramBoolean, paramArrayOfObject);
      return;
    case 8020: 
      paramamwl.newMessageAdded(paramObject);
      return;
    case 8022: 
      paramamwl.msgStartSendingUI(paramArrayOfObject);
      return;
    case 8023: 
      paramamwl.onBoxMsgUnreadNumRefresh();
      return;
    case 8030: 
      paramamwl.addFriendByContact(paramBoolean, paramArrayOfObject);
      return;
    }
    paramamwl.onMsgForwardWXResult(((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annz
 * JD-Core Version:    0.7.0.1
 */