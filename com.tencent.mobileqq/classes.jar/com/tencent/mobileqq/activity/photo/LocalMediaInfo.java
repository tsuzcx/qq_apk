package com.tencent.mobileqq.activity.photo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cooperation.qzone.util.PanoramaUtil;
import cooperation.qzone.util.XMPCoreUtil;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import xbx;

public class LocalMediaInfo
  implements Parcelable, Serializable, Comparable
{
  public static final Parcelable.Creator CREATOR = new xbx();
  public static final int PHOTO_LAST_SELECTED = 3;
  public static final int PHOTO_SELECTED = 1;
  public static final int PHOTO_UNSELECTED = 2;
  public static int REDBAG_TYPE_GET = 1;
  public static final String SVR_PANORAMA_BALL = "2";
  public static final String SVR_PANORAMA_CYLINDER = "1";
  public static final String SVR_PANORAMA_NORMAL = "0";
  public static final int TYPE_PANORAMA_BALL = 2;
  public static final int TYPE_PANORAMA_CYLINDER = 1;
  public static final String TYPE_PANORAMA_NAME = "panorama_type";
  public static final int TYPE_PANORAMA_NORMAL = 3;
  public long _id;
  public long addedDate;
  public Bundle bundle;
  public String fakeVid;
  public long fileSize;
  public int index;
  public boolean isMakeVideo;
  public boolean isRecord;
  public boolean isRegionThumbUseNewDecoder;
  public boolean isSystemMeidaStore = true;
  public int latitude;
  public int listViewPosition = -1;
  public int longitude;
  public boolean mChecked;
  public String mCloudPhotoId = "";
  public String mCloudPhotoOwnerAlbumId = "";
  public long mCloudPhotoOwnerUin;
  public long mDuration;
  public boolean mIsUploadOrigin;
  public String mMimeType;
  public long mStartTime;
  public long mTotalDuration;
  public ArrayList mTransferPosList;
  public int mVideoType;
  public int mediaHeight;
  public int mediaWidth;
  public long modifiedDate;
  public boolean needProcess;
  public int orientation;
  public int panoramaPhotoType;
  public String path;
  public Integer position = Integer.valueOf(-1);
  public int redBagType;
  public int rotation;
  public int selectStatus;
  public int specialVideoType;
  public int thumbHeight;
  public int thumbSize;
  public int thumbWidth;
  public String thumbnailPath;
  public long visableTime;
  
  public static String getUrl(LocalMediaInfo paramLocalMediaInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocalMediaInfo.path);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.thumbWidth);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.thumbHeight);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.modifiedDate);
    localStringBuilder.append("|");
    localStringBuilder.append(0);
    localStringBuilder.append("|");
    localStringBuilder.append("201403010");
    if (paramLocalMediaInfo.isRegionThumbUseNewDecoder)
    {
      localStringBuilder.append("|");
      localStringBuilder.append("useNewDecoder");
    }
    return localStringBuilder.toString();
  }
  
  public static LocalMediaInfo parseUrl(URL paramURL)
  {
    try
    {
      paramURL = paramURL.getFile();
      String[] arrayOfString = paramURL.split("\\|");
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = arrayOfString[0];
      localLocalMediaInfo.thumbWidth = Integer.parseInt(arrayOfString[1]);
      localLocalMediaInfo.thumbHeight = Integer.parseInt(arrayOfString[2]);
      localLocalMediaInfo.modifiedDate = Long.parseLong(arrayOfString[3]);
      if ((arrayOfString.length > 6) && (!arrayOfString[6].equals("useNewDecoder"))) {
        localLocalMediaInfo.index = Integer.parseInt(arrayOfString[6]);
      }
      if (paramURL.endsWith("useNewDecoder")) {
        localLocalMediaInfo.isRegionThumbUseNewDecoder = true;
      }
      return localLocalMediaInfo;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public int compareTo(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {}
    do
    {
      return -1;
      if (paramLocalMediaInfo.modifiedDate > this.modifiedDate) {
        return 1;
      }
    } while (paramLocalMediaInfo.modifiedDate != this.modifiedDate);
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isPanoramaPhoto()
  {
    if (!PanoramaUtil.a().b()) {}
    do
    {
      return false;
      if ((this.panoramaPhotoType == 1) || (this.panoramaPhotoType == 2)) {
        return true;
      }
    } while (this.panoramaPhotoType != 3);
    return false;
  }
  
  public void setPanoramaType()
  {
    if ((this.panoramaPhotoType != 0) || (!PanoramaUtil.a().b())) {}
    while ((this.mediaWidth == 0) || (this.mediaHeight == 0)) {
      return;
    }
    if ((this.mediaHeight >= 1000) && (this.mediaWidth / this.mediaHeight == 2.0F))
    {
      if (XMPCoreUtil.a().a(this.path))
      {
        this.panoramaPhotoType = 2;
        return;
      }
      this.panoramaPhotoType = 3;
      return;
    }
    if ((this.mediaHeight >= 512) && (this.mediaWidth / this.mediaHeight >= 4.0F))
    {
      this.panoramaPhotoType = 1;
      return;
    }
    this.panoramaPhotoType = 3;
  }
  
  public String toString()
  {
    return "LocalMediaInfo{_id=" + this._id + ", path='" + this.path + '\'' + ", fileSize=" + this.fileSize + ", addedDate=" + this.addedDate + ", modifiedDate=" + this.modifiedDate + ", orientation=" + this.orientation + ", mDuration=" + this.mDuration + ", mChecked=" + this.mChecked + ", selectStatus=" + this.selectStatus + ", rotation=" + this.rotation + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", index=" + this.index + ", position=" + this.position + ", mMimeType='" + this.mMimeType + '\'' + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ", isSystemMeidaStore=" + this.isSystemMeidaStore + ", isRegionThumbUseNewDecoder=" + this.isRegionThumbUseNewDecoder + ", panoramaPhotoType=" + this.panoramaPhotoType + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this._id);
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeLong(this.addedDate);
    paramParcel.writeLong(this.modifiedDate);
    paramParcel.writeInt(this.orientation);
    paramParcel.writeInt(this.rotation);
    paramParcel.writeLong(this.mDuration);
    if (this.mChecked)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.selectStatus);
      paramParcel.writeInt(this.thumbWidth);
      paramParcel.writeInt(this.thumbHeight);
      paramParcel.writeInt(this.index);
      paramParcel.writeInt(this.position.intValue());
      paramParcel.writeString(this.mMimeType);
      paramParcel.writeInt(this.mediaWidth);
      paramParcel.writeInt(this.mediaHeight);
      if (!this.isSystemMeidaStore) {
        break label240;
      }
      paramInt = 1;
      label157:
      paramParcel.writeByte((byte)paramInt);
      if (!this.isRegionThumbUseNewDecoder) {
        break label245;
      }
    }
    label240:
    label245:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.longitude);
      paramParcel.writeInt(this.latitude);
      paramParcel.writeInt(this.panoramaPhotoType);
      paramParcel.writeLong(this.mCloudPhotoOwnerUin);
      paramParcel.writeString(this.mCloudPhotoOwnerAlbumId);
      paramParcel.writeString(this.mCloudPhotoId);
      paramParcel.writeList(this.mTransferPosList);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label157;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */