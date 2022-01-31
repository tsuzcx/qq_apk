import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.OfflineFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aqwr
  implements bkgc<WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp>
{
  aqwr(aqwl paramaqwl, int paramInt) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp paramCrossBidProxyOfflineFileGetListMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryOfflineFileList onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
    }
    aqwl.a(this.jdField_a_of_type_Aqwl).a().a(false, 32, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp paramCrossBidProxyOfflineFileGetListMsgRsp)
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2)) {}
    for (int i = paramCrossBidProxyOfflineFileGetListMsgRsp.rpt_msg_recv_offline_file.size() + 0;; i = 0)
    {
      int j;
      if (this.jdField_a_of_type_Int != 1)
      {
        j = i;
        if (this.jdField_a_of_type_Int != 2) {}
      }
      else
      {
        j = i + paramCrossBidProxyOfflineFileGetListMsgRsp.rpt_msg_send_offline_file.size();
      }
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryOfflineFileList onSucceed, num[" + j + "]");
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator;
      WeiyunPB.OfflineFileInfo localOfflineFileInfo;
      OfflineFileInfo localOfflineFileInfo1;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2))
      {
        localIterator = paramCrossBidProxyOfflineFileGetListMsgRsp.rpt_msg_recv_offline_file.get().iterator();
        while (localIterator.hasNext())
        {
          localOfflineFileInfo = (WeiyunPB.OfflineFileInfo)localIterator.next();
          localOfflineFileInfo1 = new OfflineFileInfo();
          localOfflineFileInfo1.jdField_a_of_type_Boolean = false;
          localOfflineFileInfo1.jdField_a_of_type_Int = localOfflineFileInfo.uint32_danger_evel.get();
          localOfflineFileInfo1.jdField_b_of_type_Long = localOfflineFileInfo.uint64_file_size.get();
          localOfflineFileInfo1.c = (ayvc.a() * 1000L + localOfflineFileInfo.uint32_life_time.get() * 1000L);
          localOfflineFileInfo1.d = (localOfflineFileInfo.uint32_upload_time.get() * 1000L);
          localOfflineFileInfo1.jdField_b_of_type_JavaLangString = localOfflineFileInfo.str_file_name.get();
          localOfflineFileInfo1.jdField_a_of_type_JavaLangString = new String(localOfflineFileInfo.bytes_uuid.get().toByteArray());
          localOfflineFileInfo1.jdField_a_of_type_Long = localOfflineFileInfo.uint64_uin.get();
          localArrayList.add(localOfflineFileInfo1);
          if (QLog.isColorLevel()) {
            QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "OfflineFileInfo[" + localOfflineFileInfo1.toString() + "]");
          }
        }
      }
      if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
      {
        localIterator = paramCrossBidProxyOfflineFileGetListMsgRsp.rpt_msg_send_offline_file.get().iterator();
        while (localIterator.hasNext())
        {
          localOfflineFileInfo = (WeiyunPB.OfflineFileInfo)localIterator.next();
          localOfflineFileInfo1 = new OfflineFileInfo();
          localOfflineFileInfo1.jdField_a_of_type_Boolean = true;
          localOfflineFileInfo1.jdField_a_of_type_Int = localOfflineFileInfo.uint32_danger_evel.get();
          localOfflineFileInfo1.jdField_b_of_type_Long = localOfflineFileInfo.uint64_file_size.get();
          localOfflineFileInfo1.c = (ayvc.a() * 1000L + localOfflineFileInfo.uint32_life_time.get() * 1000L);
          localOfflineFileInfo1.d = (localOfflineFileInfo.uint32_upload_time.get() * 1000L);
          localOfflineFileInfo1.jdField_b_of_type_JavaLangString = localOfflineFileInfo.str_file_name.get();
          localOfflineFileInfo1.jdField_a_of_type_JavaLangString = new String(localOfflineFileInfo.bytes_uuid.get().toByteArray());
          localOfflineFileInfo1.jdField_a_of_type_Long = localOfflineFileInfo.uint64_uin.get();
          localArrayList.add(localOfflineFileInfo1);
          if (QLog.isColorLevel()) {
            QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "OfflineFileInfo[" + localOfflineFileInfo1.toString() + "]");
          }
        }
      }
      boolean bool;
      if (this.jdField_a_of_type_Int == 0) {
        if (paramCrossBidProxyOfflineFileGetListMsgRsp.uint32_recv_list_end.get() == 1) {
          bool = true;
        }
      }
      for (;;)
      {
        aqwl.a(this.jdField_a_of_type_Aqwl).a().a(true, 32, new Object[] { Boolean.valueOf(bool), localArrayList });
        return;
        bool = false;
        continue;
        if (this.jdField_a_of_type_Int == 1)
        {
          if (paramCrossBidProxyOfflineFileGetListMsgRsp.uint32_send_list_end.get() == 1) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else if ((paramCrossBidProxyOfflineFileGetListMsgRsp.uint32_recv_list_end.get() == 1) && (paramCrossBidProxyOfflineFileGetListMsgRsp.uint32_send_list_end.get() == 1)) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwr
 * JD-Core Version:    0.7.0.1
 */