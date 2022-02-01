package com.tencent.mobileqq.activity.photo;

import akeu;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bmiw;
import bmkc;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class LocalMediaInfo
  implements Parcelable, Serializable, Comparable<LocalMediaInfo>
{
  public static final Parcelable.Creator<LocalMediaInfo> CREATOR = new akeu();
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
  public ArrayList<String> aiTextLabel;
  public Bundle bundle;
  public String fakeVid;
  public long fileSize;
  public String filterID = "";
  public int index;
  public boolean isMakeVideo;
  public boolean isRecord;
  public boolean isRegionThumbUseNewDecoder;
  public boolean isSyncToWeishi;
  public boolean isSystemMeidaStore = true;
  public boolean isVideoReady = true;
  public int latitude;
  public int listViewPosition = -1;
  public int longitude;
  public String mAlbumName;
  public String mAudioPath;
  public boolean mChecked;
  public String mCloudPhotoId = "";
  public String mCloudPhotoOwnerAlbumId = "";
  public long mCloudPhotoOwnerUin;
  public long mDuration;
  public boolean mHasAudioTrack;
  public boolean mIsUploadOrigin;
  public int mMediaType;
  public String mMimeType;
  public int mSampleRate = 1;
  public long mStartTime;
  public int mTextId = -1;
  public String mTextStr;
  public long mTotalDuration;
  public String mTransId;
  public ArrayList<Long> mTransferPosList;
  public int mVideoType;
  public String materialID = "";
  public String materialName = "";
  public int mediaHeight;
  public int mediaOriginHeight;
  public long mediaOriginSize;
  public int mediaOriginWidth;
  public int mediaWidth;
  public String missionID;
  public long modifiedDate;
  public boolean needProcess;
  public int orientation;
  public int panoramaPhotoType;
  public String path;
  public Integer position = Integer.valueOf(-1);
  public int redBagType;
  public int rotation;
  public String scheme = "";
  public int selectStatus;
  public int specialVideoType;
  public int thumbHeight;
  public Rect thumbRect;
  public int thumbSize;
  public int thumbWidth;
  public String thumbnailPath;
  public float thumbnailProgress = 0.5F;
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
    if (!bmiw.a().b()) {}
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
    if ((this.panoramaPhotoType != 0) || (!bmiw.a().b())) {}
    while ((this.mediaWidth == 0) || (this.mediaHeight == 0)) {
      return;
    }
    if ((this.mediaHeight >= 1000) && (this.mediaWidth / this.mediaHeight == 2.0F))
    {
      if (bmkc.a().a(this.path))
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
    return "LocalMediaInfo{_id=" + this._id + ", path='" + this.path + '\'' + ", fileSize=" + this.fileSize + ", addedDate=" + this.addedDate + ", modifiedDate=" + this.modifiedDate + ", orientation=" + this.orientation + ", mDuration=" + this.mDuration + ", mChecked=" + this.mChecked + ", selectStatus=" + this.selectStatus + ", rotation=" + this.rotation + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", index=" + this.index + ", position=" + this.position + ", mMimeType='" + this.mMimeType + '\'' + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ", isSystemMeidaStore=" + this.isSystemMeidaStore + ", isRegionThumbUseNewDecoder=" + this.isRegionThumbUseNewDecoder + ", panoramaPhotoType=" + this.panoramaPhotoType + ", mediaType=" + this.mMediaType + ", isVideoReady=" + this.isVideoReady + ", videoInfo=" + this.materialID + ", materialName=" + this.materialName + ", filterID=" + this.filterID + ", scheme=" + this.scheme + ", missionID=" + this.missionID + ", thumbnailProgress=" + this.thumbnailProgress + ", mediaOriginWidth=" + this.mediaOriginWidth + ", mediaOriginHeight=" + this.mediaOriginHeight + ", mediaOriginSize=" + this.mediaOriginSize + '}';
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
      paramParcel.writeString(this.thumbnailPath);
      paramParcel.writeInt(this.index);
      paramParcel.writeInt(this.position.intValue());
      paramParcel.writeString(this.mMimeType);
      paramParcel.writeInt(this.mMediaType);
      paramParcel.writeInt(this.mediaWidth);
      paramParcel.writeInt(this.mediaHeight);
      paramParcel.writeInt(this.mediaOriginWidth);
      paramParcel.writeInt(this.mediaOriginHeight);
      paramParcel.writeLong(this.mediaOriginSize);
      if (!this.isSystemMeidaStore) {
        break label351;
      }
      paramInt = 1;
      label197:
      paramParcel.writeByte((byte)paramInt);
      if (!this.isRegionThumbUseNewDecoder) {
        break label356;
      }
      paramInt = 1;
      label212:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.longitude);
      paramParcel.writeInt(this.latitude);
      paramParcel.writeInt(this.panoramaPhotoType);
      paramParcel.writeLong(this.mCloudPhotoOwnerUin);
      paramParcel.writeString(this.mCloudPhotoOwnerAlbumId);
      paramParcel.writeString(this.mCloudPhotoId);
      if (!this.isVideoReady) {
        break label361;
      }
    }
    label351:
    label356:
    label361:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.materialID);
      paramParcel.writeString(this.materialName);
      paramParcel.writeString(this.filterID);
      paramParcel.writeString(this.scheme);
      paramParcel.writeString(this.missionID);
      paramParcel.writeList(this.mTransferPosList);
      paramParcel.writeList(this.aiTextLabel);
      paramParcel.writeFloat(this.thumbnailProgress);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label197;
      paramInt = 0;
      break label212;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */