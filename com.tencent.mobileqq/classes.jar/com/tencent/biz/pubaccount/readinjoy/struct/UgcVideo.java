package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.UgcVideoInfo;

public class UgcVideo
  extends Entity
  implements Parcelable, Serializable, Comparable<UgcVideo>
{
  public static final Parcelable.Creator<UgcVideo> CREATOR = new UgcVideo.1();
  public static int RETRY_TIME_LIMIT = 3;
  public static int STATUS_FAILED;
  public static int STATUS_FINISH;
  public static int STATUS_IDLE = 0;
  public static int STATUS_PAUSE;
  public static int STATUS_UPLOADING = 1;
  public static int SUBSTATUS_COMPRESS_VIDEO;
  public static int SUBSTATUS_IDLE_VIDEO;
  public static int SUBSTATUS_UPLOADING_VIDEO;
  public static int TYPE_NO_PUBLIC;
  public static int TYPE_PUBLIC;
  public static int TYPE_PUBLIC_AND_REMIND;
  public String address = "";
  public long bitrate = 0L;
  public String brief = "";
  public int businessType = 4;
  public byte[] byteArray;
  public boolean canUploadInMobileNet = false;
  public long columnId = 0L;
  public String compressPath = "";
  public int compressProgress = 0;
  public long compressTime = 0L;
  public int coverHeight = 0;
  public String coverPath = "";
  public int coverProgress = 0;
  public String coverUrl = "";
  public int coverWidth = 0;
  public int duration = 0;
  public String fileMd5 = "";
  public String filePath = "";
  public long fileSize = 0L;
  public int fromForReport;
  public int height = 0;
  public long insertTime = 0L;
  public long lastUploadSize = 0L;
  public long lastUploadSizeUpdateTime = 0L;
  private List<byte[]> multiTitleStruct = new ArrayList();
  public boolean pauseBySwitchNet = false;
  public int publicType = TYPE_PUBLIC;
  public boolean reprintDisable = false;
  public int retryTime = 0;
  public String rowkey = "";
  @unique
  public String seqId = "";
  public long startCompressTime = 0L;
  public long startUploadingTime = 0L;
  public long startUserWaitingTime = 0L;
  public int status = STATUS_IDLE;
  public String title = "";
  public String uploadSpeed = "0KB/S";
  public long uploadTotalCostTime = 0L;
  public int uploadType;
  public int uploadVideoStatus = SUBSTATUS_IDLE_VIDEO;
  public String url = "";
  public long userWaitingTotalCostTime = 0L;
  public int videoProgress = 0;
  public String videoUploadKey;
  public int width = 0;
  
  static
  {
    STATUS_FINISH = 2;
    STATUS_FAILED = 3;
    STATUS_PAUSE = 4;
    TYPE_PUBLIC_AND_REMIND = 1;
    TYPE_PUBLIC = 2;
    TYPE_NO_PUBLIC = 3;
    SUBSTATUS_IDLE_VIDEO = 0;
    SUBSTATUS_COMPRESS_VIDEO = 1;
    SUBSTATUS_UPLOADING_VIDEO = 2;
  }
  
  public UgcVideo() {}
  
  protected UgcVideo(Parcel paramParcel)
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
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.reprintDisable = bool;
    this.publicType = paramParcel.readByte();
    this.startCompressTime = paramParcel.readLong();
    this.fromForReport = paramParcel.readInt();
    this.uploadType = paramParcel.readInt();
    this.address = paramParcel.readString();
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
    if (paramUgcVideoInfo.uint32_reprint_disable.get() == 1) {}
    for (;;)
    {
      this.reprintDisable = bool;
      this.publicType = paramUgcVideoInfo.uint32_remind_friends.get();
      this.uploadType = paramUgcVideoInfo.uint32_upload_type.get();
      setMultiTitleStruct(biuMultiLevelToBiuCommentInfo(paramUgcVideoInfo.biu_multi_level));
      this.address = paramUgcVideoInfo.bytes_position.get().toStringUtf8();
      return;
      bool = false;
    }
  }
  
  private articlesummary.BiuMultiLevel biuCommentInfoToBiuMultiLevel(List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    articlesummary.BiuMultiLevel localBiuMultiLevel = new articlesummary.BiuMultiLevel();
    if (paramList == null) {
      return localBiuMultiLevel;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramList.get(i);
      articlesummary.BiuOneLevelItem localBiuOneLevelItem = new articlesummary.BiuOneLevelItem();
      PBBytesField localPBBytesField = localBiuOneLevelItem.bytes_biu_comments;
      if (localBiuCommentInfo.mBiuComment != null) {}
      for (Object localObject = localBiuCommentInfo.mBiuComment;; localObject = "")
      {
        localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
        localObject = convertJumpInfo(localBiuCommentInfo.jumpInfo);
        if (localObject != null) {
          localBiuOneLevelItem.msg_jump_info.set((MessageMicro)localObject);
        }
        localBiuOneLevelItem.op_type.set(localBiuCommentInfo.mOpType);
        localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.mUin.longValue());
        localArrayList.add(localBiuOneLevelItem);
        i -= 1;
        break;
      }
    }
    localBiuMultiLevel.rpt_biu_mutli_level.set(localArrayList);
    return localBiuMultiLevel;
  }
  
  private List<SocializeFeedsInfo.BiuCommentInfo> biuMultiLevelToBiuCommentInfo(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
    if (localIterator.hasNext())
    {
      articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)localIterator.next();
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
      if (localBiuOneLevelItem.bytes_biu_comments.get() != null) {}
      for (paramBiuMultiLevel = localBiuOneLevelItem.bytes_biu_comments.get().toStringUtf8();; paramBiuMultiLevel = "")
      {
        localBiuCommentInfo.mBiuComment = paramBiuMultiLevel;
        localBiuCommentInfo.jumpInfo = convertJumpInfo(localBiuOneLevelItem.msg_jump_info);
        localBiuCommentInfo.mOpType = localBiuOneLevelItem.op_type.get();
        localArrayList.add(localBiuCommentInfo);
        break;
      }
    }
    return localArrayList;
  }
  
  private SocializeFeedsInfo.JumpInfo convertJumpInfo(articlesummary.JumpInfo paramJumpInfo)
  {
    if (paramJumpInfo == null) {
      return null;
    }
    long l = paramJumpInfo.uint64_id.get();
    String str;
    if (paramJumpInfo.bytes_wording.get() != null)
    {
      str = paramJumpInfo.bytes_wording.get().toStringUtf8();
      if (paramJumpInfo.bytes_jump_url.get() == null) {
        break label76;
      }
    }
    label76:
    for (paramJumpInfo = paramJumpInfo.bytes_jump_url.get().toStringUtf8();; paramJumpInfo = "")
    {
      return new SocializeFeedsInfo.JumpInfo(l, str, paramJumpInfo);
      str = "";
      break;
    }
  }
  
  private articlesummary.JumpInfo convertJumpInfo(SocializeFeedsInfo.JumpInfo paramJumpInfo)
  {
    if (paramJumpInfo == null) {
      return null;
    }
    articlesummary.JumpInfo localJumpInfo = new articlesummary.JumpInfo();
    PBBytesField localPBBytesField = localJumpInfo.bytes_jump_url;
    if (paramJumpInfo.getJumpUrl() != null)
    {
      str = paramJumpInfo.getJumpUrl();
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localPBBytesField = localJumpInfo.bytes_wording;
      if (paramJumpInfo.getWording() == null) {
        break label87;
      }
    }
    label87:
    for (String str = paramJumpInfo.getWording();; str = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localJumpInfo.uint64_id.set(paramJumpInfo.getId());
      return localJumpInfo;
      str = "";
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
  
  public List<SocializeFeedsInfo.BiuCommentInfo> getMultiTitleStruct()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.multiTitleStruct.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(RIJSerializableKtxKt.a((byte[])localIterator.next()));
    }
    return localArrayList;
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
    oidb_0xe2a.UgcVideoInfo localUgcVideoInfo = new oidb_0xe2a.UgcVideoInfo();
    PBBytesField localPBBytesField = localUgcVideoInfo.bytes_title;
    label53:
    label80:
    label107:
    int i;
    if (this.title != null)
    {
      localObject = this.title;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPBBytesField = localUgcVideoInfo.bytes_url;
      if (this.url == null) {
        break label311;
      }
      localObject = this.url;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPBBytesField = localUgcVideoInfo.bytes_cover_url;
      if (this.coverUrl == null) {
        break label317;
      }
      localObject = this.coverUrl;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPBBytesField = localUgcVideoInfo.bytes_brief;
      if (this.brief == null) {
        break label323;
      }
      localObject = this.brief;
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
        break label329;
      }
      localObject = this.fileMd5;
      label211:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = localUgcVideoInfo.uint32_reprint_disable;
      if (!this.reprintDisable) {
        break label335;
      }
      i = 1;
      label234:
      ((PBUInt32Field)localObject).set(i);
      localUgcVideoInfo.uint32_remind_friends.set(this.publicType);
      localUgcVideoInfo.uint32_upload_type.set(this.uploadType);
      localUgcVideoInfo.biu_multi_level.set(biuCommentInfoToBiuMultiLevel(getMultiTitleStruct()));
      localPBBytesField = localUgcVideoInfo.bytes_position;
      if (this.address == null) {
        break label340;
      }
    }
    label311:
    label317:
    label323:
    label329:
    label335:
    label340:
    for (Object localObject = this.address;; localObject = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      return localUgcVideoInfo;
      localObject = "";
      break;
      localObject = "";
      break label53;
      localObject = "";
      break label80;
      localObject = "";
      break label107;
      localObject = "";
      break label211;
      i = 0;
      break label234;
    }
  }
  
  public void setMultiTitleStruct(List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if (!this.multiTitleStruct.isEmpty()) {
        this.multiTitleStruct.clear();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramList.next();
        this.multiTitleStruct.add(RIJSerializableKtxKt.a(localBiuCommentInfo));
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
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
    if (this.reprintDisable) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeByte((byte)this.publicType);
      paramParcel.writeLong(this.startCompressTime);
      paramParcel.writeInt(this.fromForReport);
      paramParcel.writeInt(this.uploadType);
      paramParcel.writeString(this.address);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo
 * JD-Core Version:    0.7.0.1
 */