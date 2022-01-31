package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import awbv;
import awdj;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import qnq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.UgcVideoInfo;

public class UgcVideo
  extends awbv
  implements Parcelable, Serializable, Comparable<UgcVideo>
{
  public static final Parcelable.Creator<UgcVideo> CREATOR = new qnq();
  public static int RETRY_TIME_LIMIT = 3;
  public static int STATUS_FAILED;
  public static int STATUS_FINISH;
  public static int STATUS_IDLE;
  public static int STATUS_PAUSE;
  public static int STATUS_UPLOADING = 1;
  public static int SUBSTATUS_COMPRESS_VIDEO;
  public static int SUBSTATUS_IDLE_VIDEO;
  public static int SUBSTATUS_UPLOADING_VIDEO;
  public long bitrate;
  public String brief = "";
  public int businessType = 4;
  public byte[] byteArray;
  public long columnId;
  public String compressPath = "";
  public int compressProgress;
  public long compressTime;
  public int coverHeight;
  public String coverPath = "";
  public int coverProgress;
  public String coverUrl = "";
  public int coverWidth;
  public int duration;
  public String fileMd5 = "";
  public String filePath = "";
  public long fileSize;
  public int fromForReport;
  public int height;
  public long insertTime;
  public boolean isRemindQQFriend;
  public long lastUploadSize;
  public long lastUploadSizeUpdateTime;
  private int progress;
  public boolean reprintDisable;
  public int retryTime;
  public String rowkey = "";
  @awdj
  public String seqId = "";
  public long startCompressTime;
  public long startUploadingTime;
  public long startUserWaitingTime;
  public int status = STATUS_IDLE;
  public String title = "";
  public String uploadSpeed = "0KB/S";
  public long uploadTotalCostTime;
  public int uploadVideoStatus = SUBSTATUS_IDLE_VIDEO;
  public String url = "";
  public long userWaitingTotalCostTime;
  public int videoProgress;
  public String videoUploadKey;
  public int width;
  
  static
  {
    STATUS_FINISH = 2;
    STATUS_FAILED = 3;
    STATUS_PAUSE = 4;
    SUBSTATUS_COMPRESS_VIDEO = 1;
    SUBSTATUS_UPLOADING_VIDEO = 2;
  }
  
  public UgcVideo() {}
  
  public UgcVideo(Parcel paramParcel)
  {
    this.seqId = paramParcel.readString();
    this.insertTime = paramParcel.readLong();
    this.filePath = paramParcel.readString();
    this.compressPath = paramParcel.readString();
    this.coverPath = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.rowkey = paramParcel.readString();
    this.businessType = paramParcel.readInt();
    this.compressProgress = paramParcel.readInt();
    this.coverProgress = paramParcel.readInt();
    this.videoProgress = paramParcel.readInt();
    this.videoUploadKey = paramParcel.readString();
    this.compressTime = paramParcel.readLong();
    this.startUploadingTime = paramParcel.readLong();
    this.startUserWaitingTime = paramParcel.readLong();
    this.uploadTotalCostTime = paramParcel.readLong();
    this.userWaitingTotalCostTime = paramParcel.readLong();
    this.bitrate = paramParcel.readLong();
    this.progress = paramParcel.readInt();
    this.uploadVideoStatus = paramParcel.readInt();
    this.lastUploadSize = paramParcel.readLong();
    this.lastUploadSizeUpdateTime = paramParcel.readLong();
    this.uploadSpeed = paramParcel.readString();
    this.retryTime = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.url = paramParcel.readString();
    this.coverUrl = paramParcel.readString();
    this.coverWidth = paramParcel.readInt();
    this.coverHeight = paramParcel.readInt();
    this.columnId = paramParcel.readLong();
    this.duration = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fileSize = paramParcel.readLong();
    this.fileMd5 = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.reprintDisable = bool1;
      if (paramParcel.readByte() == 0) {
        break label421;
      }
    }
    label421:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isRemindQQFriend = bool1;
      this.startCompressTime = paramParcel.readLong();
      this.fromForReport = paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public UgcVideo(oidb_0xe2a.UgcVideoInfo paramUgcVideoInfo)
  {
    this.title = paramUgcVideoInfo.bytes_title.get().toStringUtf8();
    this.url = paramUgcVideoInfo.bytes_url.get().toStringUtf8();
    this.coverUrl = paramUgcVideoInfo.bytes_cover_url.get().toStringUtf8();
    this.brief = paramUgcVideoInfo.bytes_brief.get().toStringUtf8();
    this.coverWidth = paramUgcVideoInfo.uint32_cover_width.get();
    this.coverHeight = paramUgcVideoInfo.uint32_cover_height.get();
    this.columnId = paramUgcVideoInfo.uint64_column_id.get();
    this.duration = paramUgcVideoInfo.uint32_duration.get();
    this.width = paramUgcVideoInfo.uint32_width.get();
    this.height = paramUgcVideoInfo.uint32_height.get();
    this.fileSize = paramUgcVideoInfo.uint64_file_size.get();
    this.fileMd5 = paramUgcVideoInfo.bytes_file_md5.get().toStringUtf8();
    if (paramUgcVideoInfo.uint32_reprint_disable.get() == 1)
    {
      bool1 = true;
      this.reprintDisable = bool1;
      if (paramUgcVideoInfo.uint32_remind_friends.get() != 1) {
        break label280;
      }
    }
    label280:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isRemindQQFriend = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public int compareTo(UgcVideo paramUgcVideo)
  {
    return (int)(paramUgcVideo.insertTime - this.insertTime);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof UgcVideo)) && (this.seqId.equals(((UgcVideo)paramObject).seqId));
  }
  
  public int getProgress()
  {
    return (this.compressProgress + this.coverProgress + this.videoProgress) / 3;
  }
  
  public int hashCode()
  {
    return this.seqId.hashCode();
  }
  
  public oidb_0xe2a.UgcVideoInfo parseUgcVideo()
  {
    int j = 1;
    oidb_0xe2a.UgcVideoInfo localUgcVideoInfo = new oidb_0xe2a.UgcVideoInfo();
    PBBytesField localPBBytesField = localUgcVideoInfo.bytes_title;
    Object localObject;
    if (this.title != null)
    {
      localObject = this.title;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPBBytesField = localUgcVideoInfo.bytes_url;
      if (this.url == null) {
        break label284;
      }
      localObject = this.url;
      label58:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPBBytesField = localUgcVideoInfo.bytes_cover_url;
      if (this.coverUrl == null) {
        break label290;
      }
      localObject = this.coverUrl;
      label86:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPBBytesField = localUgcVideoInfo.bytes_brief;
      if (this.brief == null) {
        break label296;
      }
      localObject = this.brief;
      label114:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localUgcVideoInfo.uint32_cover_width.set(this.coverWidth);
      localUgcVideoInfo.uint32_cover_height.set(this.coverHeight);
      localUgcVideoInfo.uint64_column_id.set(this.columnId);
      localUgcVideoInfo.uint32_duration.set(this.duration);
      localUgcVideoInfo.uint32_width.set(this.width);
      localUgcVideoInfo.uint32_height.set(this.height);
      localUgcVideoInfo.uint64_file_size.set(this.fileSize);
      localPBBytesField = localUgcVideoInfo.bytes_file_md5;
      if (this.fileMd5 == null) {
        break label302;
      }
      localObject = this.fileMd5;
      label226:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = localUgcVideoInfo.uint32_reprint_disable;
      if (!this.reprintDisable) {
        break label308;
      }
      i = 1;
      label250:
      ((PBUInt32Field)localObject).set(i);
      localObject = localUgcVideoInfo.uint32_remind_friends;
      if (!this.isRemindQQFriend) {
        break label313;
      }
    }
    label284:
    label290:
    label296:
    label302:
    label308:
    label313:
    for (int i = j;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      return localUgcVideoInfo;
      localObject = "";
      break;
      localObject = "";
      break label58;
      localObject = "";
      break label86;
      localObject = "";
      break label114;
      localObject = "";
      break label226;
      i = 0;
      break label250;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.seqId);
    paramParcel.writeLong(this.insertTime);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.compressPath);
    paramParcel.writeString(this.coverPath);
    paramParcel.writeInt(this.status);
    paramParcel.writeString(this.rowkey);
    paramParcel.writeInt(this.businessType);
    paramParcel.writeInt(this.compressProgress);
    paramParcel.writeInt(this.coverProgress);
    paramParcel.writeInt(this.videoProgress);
    paramParcel.writeString(this.videoUploadKey);
    paramParcel.writeLong(this.compressTime);
    paramParcel.writeLong(this.startUploadingTime);
    paramParcel.writeLong(this.startUserWaitingTime);
    paramParcel.writeLong(this.uploadTotalCostTime);
    paramParcel.writeLong(this.userWaitingTotalCostTime);
    paramParcel.writeLong(this.bitrate);
    paramParcel.writeInt(this.progress);
    paramParcel.writeInt(this.uploadVideoStatus);
    paramParcel.writeLong(this.lastUploadSize);
    paramParcel.writeLong(this.lastUploadSizeUpdateTime);
    paramParcel.writeString(this.uploadSpeed);
    paramParcel.writeInt(this.retryTime);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeInt(this.coverWidth);
    paramParcel.writeInt(this.coverHeight);
    paramParcel.writeLong(this.columnId);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeString(this.fileMd5);
    if (this.reprintDisable)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.isRemindQQFriend) {
        break label334;
      }
    }
    label334:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.startCompressTime);
      paramParcel.writeInt(this.fromForReport);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo
 * JD-Core Version:    0.7.0.1
 */