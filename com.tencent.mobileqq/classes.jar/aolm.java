import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.MovGroupMemResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import java.nio.ByteBuffer;

public class aolm
  extends aolh
{
  public aolm(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, MovGroupMemResp paramMovGroupMemResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    String str = paramToServiceMsg.getString("uin");
    byte b1 = paramToServiceMsg.getByte("group_id");
    byte b2 = paramToServiceMsg.getByte("away_group_id");
    if (paramMovGroupMemResp.result == 0)
    {
      ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(str, b1);
      a(9, true, new Object[] { str, Byte.valueOf(b1), Byte.valueOf(b2) });
      return;
    }
    a(9, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, SetGroupResp paramSetGroupResp)
  {
    boolean bool;
    int i;
    if (paramSetGroupResp.result == 0)
    {
      bool = true;
      i = paramToServiceMsg.extraData.getInt("set_type", -1);
      if (i == paramSetGroupResp.reqtype) {
        break label675;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleSetGroupResp | unmatched reqtype, local = " + i + ", remote = " + paramSetGroupResp.reqtype);
      }
      bool = false;
    }
    label675:
    for (;;)
    {
      Object localObject1 = ByteBuffer.wrap(paramSetGroupResp.vecBody);
      anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2;
      switch (i)
      {
      default: 
        return;
        bool = false;
        break;
      case 0: 
        localObject2 = new AddGroupResp();
        if (bool)
        {
          ((AddGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject2).cGroupId = ((ByteBuffer)localObject1).get();
          ((AddGroupResp)localObject2).cSortId = ((ByteBuffer)localObject1).get();
          localObject1 = localanvk.a(((AddGroupResp)localObject2).cGroupId + "");
          if (localObject1 == null) {
            break label299;
          }
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
        for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = (ToServiceMsg)localObject1)
        {
          localanvk.a(paramToServiceMsg);
          a(18, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (AddGroupResp)localObject2));
          return;
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
      case 1: 
        localObject2 = new RenameGroupResp();
        if (bool)
        {
          ((RenameGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((RenameGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          i = ((ByteBuffer)localObject1).get();
          ((RenameGroupResp)localObject2).cLen = ((ByteBuffer)localObject1).get();
          paramToServiceMsg = new byte[((RenameGroupResp)localObject2).cLen];
          ((ByteBuffer)localObject1).get(paramToServiceMsg, 0, ((RenameGroupResp)localObject2).cLen);
          ((RenameGroupResp)localObject2).sGroupName = new String(paramToServiceMsg);
          paramToServiceMsg = localanvk.a(String.valueOf(i));
          if (paramToServiceMsg == null) {
            break label489;
          }
        }
        for (paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName;; paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName)
        {
          localanvk.a(paramToServiceMsg);
          a(19, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (RenameGroupResp)localObject2));
          return;
          paramToServiceMsg = new Groups();
          paramToServiceMsg.group_id = ((int)((RenameGroupResp)localObject2).dwSequence);
        }
      case 2: 
        paramToServiceMsg = new DelGroupResp();
        if (bool)
        {
          paramToServiceMsg.dwToUin = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.dwSequence = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.cGroupid = ((ByteBuffer)localObject1).get();
        }
        paramSetGroupResp = new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, paramToServiceMsg);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.handleDelGroupResp(paramToServiceMsg, bool, paramSetGroupResp);
        return;
      case 3: 
        label299:
        label489:
        localObject2 = new ReSortGroupResp();
        if (bool)
        {
          ((ReSortGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((ReSortGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          localanvk.a(paramToServiceMsg.extraData.getByteArray("group_id_list"), paramToServiceMsg.extraData.getByteArray("sort_id_list"));
        }
        a(22, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (ReSortGroupResp)localObject2));
        return;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if ("friendlist.MovGroupMemReq".equals(localObject))
    {
      i = paramToServiceMsg.extraData.getByte("move_fri_type");
      if (i == 0) {
        if (paramObject != null) {
          a(paramToServiceMsg, (MovGroupMemResp)paramObject);
        }
      }
    }
    while (!"friendlist.SetGroupReq".equals(localObject))
    {
      int i;
      do
      {
        return;
        a(9, false, null);
        return;
      } while ((i != 1) || (paramObject == null));
      paramToServiceMsg = (MovGroupMemResp)paramObject;
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onSetGroupCmd :").append(paramToServiceMsg.extraData.getInt("set_type", -1000)).append(", ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramObject == null) {
        break label183;
      }
    }
    for (;;)
    {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, bool);
      if (!paramFromServiceMsg.isSuccess()) {
        break label189;
      }
      paramFromServiceMsg = (SetGroupResp)paramObject;
      if (paramFromServiceMsg == null) {
        break;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
      label183:
      bool = false;
    }
    label189:
    switch (paramToServiceMsg.extraData.getInt("set_type", -1))
    {
    default: 
      return;
    case 0: 
      a(18, false, null);
      return;
    case 1: 
      a(19, false, null);
      return;
    case 2: 
      a(21, false, null);
      return;
    }
    a(22, false, null);
  }
  
  public boolean a(String paramString)
  {
    return ("friendlist.MovGroupMemReq".equals(paramString)) || ("friendlist.SetGroupReq".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolm
 * JD-Core Version:    0.7.0.1
 */