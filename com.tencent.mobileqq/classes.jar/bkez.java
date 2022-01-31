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

final class bkez
  implements bkgz
{
  public void a(bkge parambkge, DownloadType paramDownloadType, bkgw parambkgw)
  {
    boolean bool = true;
    Object localObject2 = new WeiyunPB.DiskSimpleFileItem();
    ((WeiyunPB.DiskSimpleFileItem)localObject2).file_id.set(parambkge.a);
    if (parambkge.e != null) {
      ((WeiyunPB.DiskSimpleFileItem)localObject2).pdir_key.set(bkia.a(parambkge.e));
    }
    ((WeiyunPB.DiskSimpleFileItem)localObject2).filename.set(parambkge.b);
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
      if ((!TextUtils.isEmpty(parambkge.d)) && (TextUtils.isDigitsOnly(parambkge.d))) {
        ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).file_owner.set(Long.parseLong(parambkge.d));
      }
      bkgd.a((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2, new bkfa(this, parambkge, parambkgw, paramDownloadType));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkez
 * JD-Core Version:    0.7.0.1
 */