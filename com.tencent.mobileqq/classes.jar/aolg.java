import AvatarInfo.QQHeadInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.bean.QQHeadDetails;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.ReqBody;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.ReqUsrInfo;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.RspBody;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.RspHeadInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aolg
  extends aolh
{
  public aolg(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  public static oidb_0xedb.ReqBody a(ArrayList<QQHeadDetails> paramArrayList)
  {
    if (paramArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (QQHeadDetails)paramArrayList.next();
        long l = Long.parseLong(((QQHeadDetails)localObject).jdField_a_of_type_JavaLangString);
        int i = (int)((QQHeadDetails)localObject).jdField_a_of_type_Long;
        localObject = new oidb_0xedb.ReqUsrInfo();
        ((oidb_0xedb.ReqUsrInfo)localObject).dstUin.set(l);
        ((oidb_0xedb.ReqUsrInfo)localObject).timestamp.set(i);
        localArrayList.add(localObject);
      }
      if (!localArrayList.isEmpty())
      {
        paramArrayList = new oidb_0xedb.ReqBody();
        paramArrayList.dstUsrType.set(3);
        paramArrayList.dstUsrInfos.addAll(localArrayList);
        return paramArrayList;
      }
    }
    return null;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = paramToServiceMsg.extraData.getParcelableArrayList("key_request_list");
    paramToServiceMsg = localArrayList2;
    Object localObject1 = localArrayList1;
    boolean bool1 = bool2;
    if (paramFromServiceMsg != null)
    {
      paramToServiceMsg = localArrayList2;
      localObject1 = localArrayList1;
      bool1 = bool2;
      if (paramFromServiceMsg.isSuccess())
      {
        paramToServiceMsg = localArrayList2;
        localObject1 = localArrayList1;
        bool1 = bool2;
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label388;
        }
        i = 1;
        if (i == 0) {
          break label524;
        }
        paramFromServiceMsg = new oidb_0xedb.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = new HashMap();
        if (!paramFromServiceMsg.dstHeadInfos.has()) {
          break;
        }
        paramToServiceMsg = paramFromServiceMsg.dstHeadInfos.get().iterator();
        if (!paramToServiceMsg.hasNext()) {
          break;
        }
        paramFromServiceMsg = (oidb_0xedb.RspHeadInfo)paramToServiceMsg.next();
        byte b1 = (byte)paramFromServiceMsg.faceType.get();
        byte b2 = (byte)paramFromServiceMsg.faceFlag.get();
        localObject1 = new QQHeadInfo();
        ((QQHeadInfo)localObject1).uin = paramFromServiceMsg.dstUin.get();
        ((QQHeadInfo)localObject1).dwTimestamp = paramFromServiceMsg.timestamp.get();
        ((QQHeadInfo)localObject1).cHeadType = b1;
        ((QQHeadInfo)localObject1).dstUsrType = 116;
        ((QQHeadInfo)localObject1).dwFaceFlgas = b2;
        ((QQHeadInfo)localObject1).downLoadUrl = paramFromServiceMsg.url.get();
        paramObject.put(String.valueOf(((QQHeadInfo)localObject1).uin), localObject1);
        continue;
        if (!QLog.isColorLevel()) {
          break label368;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("ApolloHeadReceiver", 1, "handleGetApolloHead fail.", paramToServiceMsg);
        bool1 = bool2;
        localObject1 = localArrayList1;
        paramToServiceMsg = localArrayList2;
      }
      QLog.d("ApolloHeadReceiver", 2, String.format("handleGetApolloHead success=%s noChangeSize=%s changeSize=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(((ArrayList)localObject1).size()), Integer.valueOf(paramToServiceMsg.size()) }));
      label368:
      if (this.a != null) {
        this.a.handleGetQQHead_Apollo(bool1, (ArrayList)localObject1, paramToServiceMsg);
      }
      return;
      label388:
      int i = 0;
    }
    paramToServiceMsg = new ArrayList();
    paramFromServiceMsg = new ArrayList();
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (QQHeadDetails)((Iterator)localObject1).next();
      if (!paramObject.containsKey(((QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString))
      {
        paramToServiceMsg.add(localObject2);
      }
      else
      {
        QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramObject.get(((QQHeadDetails)localObject2).jdField_a_of_type_JavaLangString);
        localQQHeadInfo.headLevel = ((QQHeadDetails)localObject2).jdField_a_of_type_Byte;
        localQQHeadInfo.sizeType = ((QQHeadDetails)localObject2).b;
        localQQHeadInfo.idType = 200;
        paramFromServiceMsg.add(localQQHeadInfo);
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = paramToServiceMsg;
      paramToServiceMsg = paramFromServiceMsg;
      break;
      label524:
      paramFromServiceMsg = localArrayList2;
      paramToServiceMsg = localArrayList1;
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0xedb".equals(paramFromServiceMsg.getServiceCmd())) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public boolean a(String paramString)
  {
    return "OidbSvc.0xedb".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolg
 * JD-Core Version:    0.7.0.1
 */