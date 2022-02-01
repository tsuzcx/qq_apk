import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.ReqBody;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.RspBody;

public class beux
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private List<oidb_0xea3.BackMsg> jdField_a_of_type_JavaUtilList;
  private long jdField_b_of_type_Long;
  private List<Long> jdField_b_of_type_JavaUtilList;
  
  private void a(oidb_0xea3.RspBody paramRspBody)
  {
    QLog.i("Oidb0xea3Sender", 2, "handleTroopImportantMsg_suc troopUin:" + this.jdField_a_of_type_Long);
    bety localbety = (bety)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(171);
    if (localbety == null) {
      return;
    }
    if (paramRspBody.back_group_msg.has()) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramRspBody.back_group_msg.get());
    }
    localbety.notifyUI(4, true, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList });
    b();
  }
  
  private void b()
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(Long.valueOf(((oidb_0xea3.BackMsg)((Iterator)localObject2).next()).addition_seq.get()));
        }
      }
      localObject2 = new StringBuilder().append("msgSeqs:").append(((ArrayList)localObject1).toString()).append(" mRspUnchangeSeqs:");
      if (this.jdField_b_of_type_JavaUtilList != null) {
        break label116;
      }
    }
    label116:
    for (Object localObject1 = "[]";; localObject1 = this.jdField_b_of_type_JavaUtilList.toString())
    {
      QLog.i("Oidb0xea3Sender", 2, (String)localObject1);
      return;
    }
  }
  
  private void b(oidb_0xea3.RspBody paramRspBody)
  {
    QLog.i("Oidb0xea3Sender", 2, "handleTroopImportantMsg_tryNex troopUin:" + this.jdField_a_of_type_Long + ",retryCount" + this.jdField_a_of_type_Int);
    if (paramRspBody.back_group_msg.has())
    {
      paramRspBody = paramRspBody.back_group_msg.get().iterator();
      while (paramRspBody.hasNext())
      {
        oidb_0xea3.BackMsg localBackMsg = (oidb_0xea3.BackMsg)paramRspBody.next();
        if ((localBackMsg.msg.has()) && (localBackMsg.addition_seq.has()))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(localBackMsg.addition_seq.get()));
          this.jdField_a_of_type_JavaUtilList.add(localBackMsg);
        }
      }
    }
    a();
  }
  
  public void a()
  {
    bety localbety = (bety)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(171);
    if (localbety == null) {
      return;
    }
    QLog.i("Oidb0xea3Sender", 2, "getTroopImportantMsgInternal troopUin:" + this.jdField_a_of_type_Long + ",msgSeqs: " + this.jdField_a_of_type_JavaUtilArrayList.toString() + ",retryCount" + this.jdField_a_of_type_Int);
    Object localObject = new oidb_0xea3.ReqBody();
    ((oidb_0xea3.ReqBody)localObject).group_code.set(this.jdField_a_of_type_Long);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ((oidb_0xea3.ReqBody)localObject).msg_seq.add(localLong);
    }
    localObject = localbety.makeOIDBPkg("OidbSvcTcp.0xea3", 3747, 1, ((oidb_0xea3.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).extraData.putLong("sendSeq", this.jdField_b_of_type_Long);
    localbety.sendPbReq((ToServiceMsg)localObject);
  }
  
  public boolean a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((bety)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(171) == null) {
      return true;
    }
    oidb_0xea3.RspBody localRspBody = new oidb_0xea3.RspBody();
    int i = bety.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (i == 0)
    {
      if ((this.jdField_b_of_type_JavaUtilList == null) && (localRspBody.return_unchange_seq.has())) {
        this.jdField_b_of_type_JavaUtilList = localRspBody.return_unchange_seq.get();
      }
      a(localRspBody);
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((i >= 1900) && (i <= 2900))
      {
        QLog.e("Oidb0xea3Sender", 2, "handleTroopImportantMsg troopUin:" + this.jdField_a_of_type_Long + ",result: " + i);
        if ((this.jdField_b_of_type_JavaUtilList == null) && (localRspBody.return_unchange_seq.has())) {
          this.jdField_b_of_type_JavaUtilList = localRspBody.return_unchange_seq.get();
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int >= 3)
        {
          a(localRspBody);
          bool = true;
        }
        else
        {
          b(localRspBody);
          bool = false;
        }
      }
      else
      {
        QLog.e("Oidb0xea3Sender", 2, "handleTroopImportantMsg troopUin:" + this.jdField_a_of_type_Long + ",result: " + i);
        a(localRspBody);
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beux
 * JD-Core Version:    0.7.0.1
 */