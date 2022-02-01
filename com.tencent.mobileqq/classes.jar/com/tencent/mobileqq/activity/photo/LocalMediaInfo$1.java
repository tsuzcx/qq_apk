package com.tencent.mobileqq.activity.photo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LocalMediaInfo$1
  implements Parcelable.Creator<LocalMediaInfo>
{
  public LocalMediaInfo createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo._id = paramParcel.readLong();
    localLocalMediaInfo.path = paramParcel.readString();
    localLocalMediaInfo.fileSize = paramParcel.readLong();
    localLocalMediaInfo.addedDate = paramParcel.readLong();
    localLocalMediaInfo.modifiedDate = paramParcel.readLong();
    localLocalMediaInfo.orientation = paramParcel.readInt();
    localLocalMediaInfo.rotation = paramParcel.readInt();
    localLocalMediaInfo.mDuration = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      localLocalMediaInfo.mChecked = bool1;
      localLocalMediaInfo.selectStatus = paramParcel.readInt();
      localLocalMediaInfo.thumbWidth = paramParcel.readInt();
      localLocalMediaInfo.thumbHeight = paramParcel.readInt();
      localLocalMediaInfo.thumbnailPath = paramParcel.readString();
      localLocalMediaInfo.index = paramParcel.readInt();
      localLocalMediaInfo.position = Integer.valueOf(paramParcel.readInt());
      localLocalMediaInfo.mMimeType = paramParcel.readString();
      localLocalMediaInfo.mMediaType = paramParcel.readInt();
      localLocalMediaInfo.mediaWidth = paramParcel.readInt();
      localLocalMediaInfo.mediaHeight = paramParcel.readInt();
      localLocalMediaInfo.mediaBitrate = paramParcel.readLong();
      localLocalMediaInfo.mediaOriginWidth = paramParcel.readInt();
      localLocalMediaInfo.mediaOriginHeight = paramParcel.readInt();
      localLocalMediaInfo.mediaOriginSize = paramParcel.readLong();
      localLocalMediaInfo.mediaOriginBitrate = paramParcel.readLong();
      if (paramParcel.readByte() != 1) {
        break label438;
      }
      bool1 = true;
      label247:
      localLocalMediaInfo.isSystemMeidaStore = bool1;
      if (paramParcel.readByte() != 1) {
        break label443;
      }
      bool1 = true;
      label263:
      localLocalMediaInfo.isRegionThumbUseNewDecoder = bool1;
      localLocalMediaInfo.longitude = paramParcel.readInt();
      localLocalMediaInfo.latitude = paramParcel.readInt();
      localLocalMediaInfo.panoramaPhotoType = paramParcel.readInt();
      localLocalMediaInfo.mCloudPhotoOwnerUin = paramParcel.readLong();
      localLocalMediaInfo.mCloudPhotoOwnerAlbumId = paramParcel.readString();
      localLocalMediaInfo.mCloudPhotoId = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label448;
      }
    }
    label438:
    label443:
    label448:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localLocalMediaInfo.isVideoReady = bool1;
      localLocalMediaInfo.materialID = paramParcel.readString();
      localLocalMediaInfo.materialName = paramParcel.readString();
      localLocalMediaInfo.filterID = paramParcel.readString();
      localLocalMediaInfo.scheme = paramParcel.readString();
      localLocalMediaInfo.showCircleTakeSame = paramParcel.readInt();
      localLocalMediaInfo.missionID = paramParcel.readString();
      localLocalMediaInfo.mTransferPosList = paramParcel.readArrayList(Long.class.getClassLoader());
      localLocalMediaInfo.aiTextLabel = paramParcel.readArrayList(String.class.getClassLoader());
      localLocalMediaInfo.thumbnailProgress = paramParcel.readFloat();
      return localLocalMediaInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label247;
      bool1 = false;
      break label263;
    }
  }
  
  public LocalMediaInfo[] newArray(int paramInt)
  {
    return new LocalMediaInfo[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.LocalMediaInfo.1
 * JD-Core Version:    0.7.0.1
 */