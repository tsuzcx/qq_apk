import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody.Item;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

class ardq
  extends alpa
{
  ardq(ardp paramardp) {}
  
  protected void i(boolean paramBoolean, Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    ardp.a(this.a, true);
    if ((paramObject == null) || (!paramBoolean)) {}
    Object localObject;
    int i;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopFileSearchEngine<QFile>", 4, "data = " + paramObject + ", isSuccess = " + paramBoolean);
        }
        QLog.i("TroopFileSearchEngine<QFile>", 1, "error, can not handle search response, return a empty list.");
        ardp.a(this.a, false, localArrayList);
        return;
        paramObject = (byte[])paramObject;
        localObject = new cmd0x383.RspBody();
        try
        {
          paramObject = (cmd0x383.RspBody)((cmd0x383.RspBody)localObject).mergeFrom(paramObject);
          if (paramObject != null) {
            continue;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("TroopFileSearchEngine<QFile>", 4, "bigRsp is null !!!");
        }
        catch (InvalidProtocolBufferMicroException paramObject) {}
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("TroopFileSearchEngine<QFile>", 4, QLog.getStackTraceString(paramObject));
        continue;
      }
      catch (Exception paramObject)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("TroopFileSearchEngine<QFile>", 4, QLog.getStackTraceString(paramObject));
        continue;
        i = paramObject.int32_ret_code.get();
        if (i < 0)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("TroopFileSearchEngine<QFile>", 4, String.format("onRspTroopFileSearch - retCode: %d", new Object[] { Integer.valueOf(i) }));
          continue;
        }
        paramObject = (cmd0x383.ApplyFileSearchRspBody)paramObject.msg_file_search_rsp_body.get();
        if (paramObject == null)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("TroopFileSearchEngine<QFile>", 4, "rsp = " + paramObject);
          continue;
        }
        localObject = paramObject.bytes_key_word.get().toStringUtf8();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(ardp.a(this.a))))
        {
          QLog.i("TroopFileSearchEngine<QFile>", 1, "keyword is update, current result is old");
          return;
        }
        ardp.b(this.a, paramObject.bytes_sync_cookie.get().toStringUtf8());
        localObject = this.a;
        if (paramObject.uint32_is_end.get() != 1) {
          break;
        }
      }
      paramBoolean = true;
      ardp.b((ardp)localObject, paramBoolean);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRspTroopFileSearch cookie = " + ardp.b(this.a));
        ((StringBuilder)localObject).append(", isEnd = " + ardp.c(this.a));
        ((StringBuilder)localObject).append(", keyWord = " + paramObject.bytes_key_word.get().toStringUtf8());
        ((StringBuilder)localObject).append(", totalCount = " + paramObject.uint32_total_match_count.get());
        QLog.d("TroopFileSearchEngine<QFile>", 4, ((StringBuilder)localObject).toString());
      }
      paramObject = paramObject.item_list.get();
      if ((paramObject != null) && (paramObject.size() != 0)) {
        break label747;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileSearchEngine<QFile>", 4, "filelist is empty--------");
      }
    }
    for (;;)
    {
      if (i < paramObject.size())
      {
        localObject = new bbvu(ardp.a(this.a), (cmd0x383.ApplyFileSearchRspBody.Item)paramObject.get(i));
        bcmu localbcmu;
        bbsa localbbsa;
        if (((bbvu)localObject).jdField_a_of_type_Bbsa != null)
        {
          localbcmu = bcmu.a(ardp.a(this.a), ((bbvu)localObject).jdField_a_of_type_Long);
          localbbsa = localbcmu.a(((bbvu)localObject).jdField_a_of_type_Bbsa.b);
          if (localbbsa == null) {
            break label717;
          }
        }
        label717:
        for (((bbvu)localObject).jdField_a_of_type_Bbsa.a = localbbsa.a;; ((bbvu)localObject).jdField_a_of_type_Bbsa.a = UUID.randomUUID())
        {
          localbcmu.a(((bbvu)localObject).jdField_a_of_type_Bbsa.b, ((bbvu)localObject).jdField_a_of_type_Bbsa);
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileSearchEngine<QFile>", 4, "fileList[" + i + "]: " + ((bbvu)localObject).toString());
          }
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      ardp.a(this.a, true, localArrayList);
      return;
      paramBoolean = false;
      break;
      label747:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardq
 * JD-Core Version:    0.7.0.1
 */