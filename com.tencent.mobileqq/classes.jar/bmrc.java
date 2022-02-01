import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDownloadRspItem;
import cooperation.weiyun.sdk.download.DownloadType;
import java.util.Iterator;
import java.util.List;

class bmrc
  implements bmsc<WeiyunPB.DiskFileBatchDownloadMsgRsp>
{
  bmrc(bmrb parambmrb, bmse parambmse, bmsw parambmsw, DownloadType paramDownloadType) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskFileBatchDownloadMsgRsp paramDiskFileBatchDownloadMsgRsp)
  {
    this.jdField_a_of_type_Bmsw.a(this.jdField_a_of_type_Bmse, false, paramInt, paramString);
  }
  
  public void a(WeiyunPB.DiskFileBatchDownloadMsgRsp paramDiskFileBatchDownloadMsgRsp)
  {
    Object localObject;
    if ((paramDiskFileBatchDownloadMsgRsp != null) && (paramDiskFileBatchDownloadMsgRsp.file_list != null))
    {
      localObject = paramDiskFileBatchDownloadMsgRsp.file_list.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramDiskFileBatchDownloadMsgRsp = (WeiyunPB.DiskFileDownloadRspItem)((Iterator)localObject).next();
      } while ((paramDiskFileBatchDownloadMsgRsp == null) || (!TextUtils.equals(paramDiskFileBatchDownloadMsgRsp.file_id.get(), this.jdField_a_of_type_Bmse.jdField_a_of_type_JavaLangString)));
    }
    for (;;)
    {
      if (paramDiskFileBatchDownloadMsgRsp == null)
      {
        this.jdField_a_of_type_Bmsw.a(this.jdField_a_of_type_Bmse, false, 1828004, anvx.a(2131714435));
        return;
      }
      localObject = paramDiskFileBatchDownloadMsgRsp.cookie_name.get();
      String str = paramDiskFileBatchDownloadMsgRsp.cookie_value.get();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {}
      for (localObject = "";; localObject = (String)localObject + '=' + str)
      {
        this.jdField_a_of_type_Bmse.a(paramDiskFileBatchDownloadMsgRsp.server_name.get(), paramDiskFileBatchDownloadMsgRsp.server_port.get(), (String)localObject, paramDiskFileBatchDownloadMsgRsp.download_url.get(), paramDiskFileBatchDownloadMsgRsp.video_url.get(), "0");
        if (this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadType == DownloadType.FILE_ORDINARY) {
          this.jdField_a_of_type_Bmse.jdField_a_of_type_Bmsg.c = bmsh.a(this.jdField_a_of_type_Bmse.jdField_a_of_type_Bmsg.c);
        }
        this.jdField_a_of_type_Bmsw.a(this.jdField_a_of_type_Bmse, true, 0, null);
        return;
      }
      paramDiskFileBatchDownloadMsgRsp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrc
 * JD-Core Version:    0.7.0.1
 */