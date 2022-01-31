import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskSimpleFileItem;
import cooperation.weiyun.sdk.download.DownloadType;
import java.util.ArrayList;
import java.util.List;

final class bidd
  implements bifd
{
  public void a(biei parambiei, DownloadType paramDownloadType, bifa parambifa)
  {
    boolean bool = true;
    Object localObject2 = new WeiyunPB.DiskSimpleFileItem();
    ((WeiyunPB.DiskSimpleFileItem)localObject2).file_id.set(parambiei.a);
    if (parambiei.e != null) {
      ((WeiyunPB.DiskSimpleFileItem)localObject2).pdir_key.set(bige.a(parambiei.e));
    }
    ((WeiyunPB.DiskSimpleFileItem)localObject2).filename.set(parambiei.b);
    Object localObject1 = new ArrayList(1);
    ((List)localObject1).add(localObject2);
    localObject2 = new WeiyunPB.DiskFileBatchDownloadMsgReq();
    ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).file_list.set((List)localObject1);
    ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).download_type.set(paramDownloadType.ordinal());
    localObject1 = ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).need_thumb;
    if (paramDownloadType == DownloadType.FILE_THUMB) {}
    for (;;)
    {
      ((PBBoolField)localObject1).set(bool);
      if ((!TextUtils.isEmpty(parambiei.d)) && (TextUtils.isDigitsOnly(parambiei.d))) {
        ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).file_owner.set(Long.parseLong(parambiei.d));
      }
      bieh.a((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2, new bide(this, parambiei, parambifa, paramDownloadType));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidd
 * JD-Core Version:    0.7.0.1
 */