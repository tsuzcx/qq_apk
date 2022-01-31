import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskSimpleFileItem;
import cooperation.weiyun.sdk.api.WeiyunApi;
import cooperation.weiyun.sdk.download.DownloadFile;
import cooperation.weiyun.sdk.download.DownloadType;
import cooperation.weiyun.sdk.download.WyDownloader.DownloadServerInfoCallback;
import cooperation.weiyun.sdk.download.WyDownloader.IFetchListener;
import cooperation.weiyun.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public final class amqt
  implements WyDownloader.IFetchListener
{
  public void a(DownloadFile paramDownloadFile, DownloadType paramDownloadType, WyDownloader.DownloadServerInfoCallback paramDownloadServerInfoCallback)
  {
    boolean bool = true;
    Object localObject2 = new WeiyunPB.DiskSimpleFileItem();
    ((WeiyunPB.DiskSimpleFileItem)localObject2).file_id.set(paramDownloadFile.a);
    if (paramDownloadFile.e != null) {
      ((WeiyunPB.DiskSimpleFileItem)localObject2).pdir_key.set(StringUtils.a(paramDownloadFile.e));
    }
    ((WeiyunPB.DiskSimpleFileItem)localObject2).filename.set(paramDownloadFile.b);
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
      if ((!TextUtils.isEmpty(paramDownloadFile.d)) && (TextUtils.isDigitsOnly(paramDownloadFile.d))) {
        ((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2).file_owner.set(Long.parseLong(paramDownloadFile.d));
      }
      WeiyunApi.a((WeiyunPB.DiskFileBatchDownloadMsgReq)localObject2, new amqu(this, paramDownloadFile, paramDownloadServerInfoCallback, paramDownloadType));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqt
 * JD-Core Version:    0.7.0.1
 */