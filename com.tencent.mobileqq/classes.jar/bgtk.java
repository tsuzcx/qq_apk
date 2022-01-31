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

final class bgtk
  implements bgvk
{
  public void a(bgup parambgup, DownloadType paramDownloadType, bgvh parambgvh)
  {
    boolean bool = true;
    Object localObject2 = new WeiyunPB.DiskSimpleFileItem();
    ((WeiyunPB.DiskSimpleFileItem)localObject2).file_id.set(parambgup.a);
    if (parambgup.e != null) {
      ((WeiyunPB.DiskSimpleFileItem)localObject2).pdir_key.set(bgwl.a(parambgup.e));
    }
    ((WeiyunPB.DiskSimpleFileItem)localObject2).filename.set(parambgup.b);
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
      if ((!TextUtils.isEmpty(parambgup.d)) && (TextUtils.isDigitsOnly(parambgup.d))) {
        ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).file_owner.set(Long.parseLong(parambgup.d));
      }
      bguo.a((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2, new bgtl(this, parambgup, parambgvh, paramDownloadType));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtk
 * JD-Core Version:    0.7.0.1
 */