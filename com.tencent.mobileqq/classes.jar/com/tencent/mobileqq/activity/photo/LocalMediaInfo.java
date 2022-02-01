package com.tencent.mobileqq.activity.photo;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class LocalMediaInfo
  implements Parcelable, Serializable, Comparable<LocalMediaInfo>
{
  public static final Parcelable.Creator<LocalMediaInfo> CREATOR = new LocalMediaInfo.1();
  public static final int PHOTO_LAST_SELECTED = 3;
  public static final int PHOTO_SELECTED = 1;
  public static final int PHOTO_UNSELECTED = 2;
  public static int REDBAG_TYPE_GET = 1;
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
  public boolean isRegionThumbUseNewDecoder = false;
  public boolean isSyncToWeishi;
  public boolean isSystemMeidaStore = true;
  public boolean isVideoReady = true;
  public int latitude = 0;
  public int listViewPosition = -1;
  public int longitude = 0;
  public String mAlbumName;
  public String mAudioPath;
  public boolean mChecked;
  public String mCloudPhotoId = "";
  public String mCloudPhotoOwnerAlbumId = "";
  public long mCloudPhotoOwnerUin = 0L;
  public long mDuration;
  public boolean mHasAudioTrack = false;
  public ArrayList<String> mHashTagList = new ArrayList();
  public boolean mIsUploadOrigin = false;
  public float mKuolieCenterX = 0.0F;
  public float mKuolieCenterY = 0.0F;
  public float mKuolieHeightScale = 0.0F;
  public String mKuolieId = "";
  public float mKuolieRotate = 0.0F;
  public float mKuolieWidthScale = 0.0F;
  public int mMediaType;
  public String mMimeType;
  public ArrayList<String> mOriginPath = null;
  public int mSampleRate = 1;
  public long mStartTime;
  public int mTextId = -1;
  public String mTextStr;
  public long mTotalDuration;
  public String mTransId;
  public ArrayList<Long> mTransferPosList = null;
  public int mVideoType;
  public String materialID = "";
  public String materialName = "";
  public long mediaBitrate;
  public int mediaHeight;
  public long mediaOriginBitrate;
  public int mediaOriginHeight;
  public long mediaOriginSize;
  public int mediaOriginWidth;
  public int mediaWidth;
  public String missionID;
  public long modifiedDate;
  public boolean needProcess;
  public int orientation;
  public int panoramaPhotoType = 0;
  public String path;
  public Integer position = Integer.valueOf(-1);
  public int redBagType;
  public int rotation = 0;
  public String scheme = "";
  public int selectStatus;
  public int showCircleTakeSame = 0;
  public int specialVideoType = 0;
  public int thumbHeight;
  public Rect thumbRect = null;
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
  
  public String toString()
  {
    return "LocalMediaInfo{_id=" + this._id + ", path='" + this.path + '\'' + ", fileSize=" + this.fileSize + ", addedDate=" + this.addedDate + ", modifiedDate=" + this.modifiedDate + ", orientation=" + this.orientation + ", mDuration=" + this.mDuration + ", mChecked=" + this.mChecked + ", selectStatus=" + this.selectStatus + ", rotation=" + this.rotation + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", index=" + this.index + ", position=" + this.position + ", mMimeType='" + this.mMimeType + '\'' + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ", mediaBitrate=" + this.mediaBitrate + ", isSystemMeidaStore=" + this.isSystemMeidaStore + ", isRegionThumbUseNewDecoder=" + this.isRegionThumbUseNewDecoder + ", panoramaPhotoType=" + this.panoramaPhotoType + ", mediaType=" + this.mMediaType + ", isVideoReady=" + this.isVideoReady + ", videoInfo=" + this.materialID + ", materialName=" + this.materialName + ", filterID=" + this.filterID + ", scheme=" + this.scheme + ", showCircleTakeSame=" + this.showCircleTakeSame + ", missionID=" + this.missionID + ", thumbnailProgress=" + this.thumbnailProgress + ", mediaOriginWidth=" + this.mediaOriginWidth + ", mediaOriginHeight=" + this.mediaOriginHeight + ", mediaOriginSize=" + this.mediaOriginSize + ", mediaOriginBitrate=" + this.mediaOriginBitrate + ", mOriginPath=" + this.mOriginPath + ", mKuolieId=" + this.mKuolieId + ", mKuolieCenterX=" + this.mKuolieCenterX + ", mKuolieCenterY=" + this.mKuolieCenterY + ", mKuolieRotate=" + this.mKuolieRotate + ", mKuolieWidthScale=" + this.mKuolieWidthScale + ", mKuolieHeightScale=" + this.mKuolieHeightScale + '}';
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
      paramParcel.writeLong(this.mediaBitrate);
      paramParcel.writeInt(this.mediaOriginWidth);
      paramParcel.writeInt(this.mediaOriginHeight);
      paramParcel.writeLong(this.mediaOriginSize);
      paramParcel.writeLong(this.mediaOriginBitrate);
      if (!this.isSystemMeidaStore) {
        break label439;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.isRegionThumbUseNewDecoder) {
        break label444;
      }
      paramInt = 1;
      label228:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.longitude);
      paramParcel.writeInt(this.latitude);
      paramParcel.writeInt(this.panoramaPhotoType);
      paramParcel.writeLong(this.mCloudPhotoOwnerUin);
      paramParcel.writeString(this.mCloudPhotoOwnerAlbumId);
      paramParcel.writeString(this.mCloudPhotoId);
      if (!this.isVideoReady) {
        break label449;
      }
    }
    label439:
    label444:
    label449:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.materialID);
      paramParcel.writeString(this.materialName);
      paramParcel.writeString(this.filterID);
      paramParcel.writeString(this.scheme);
      paramParcel.writeInt(this.showCircleTakeSame);
      paramParcel.writeString(this.missionID);
      paramParcel.writeList(this.mTransferPosList);
      paramParcel.writeList(this.aiTextLabel);
      paramParcel.writeFloat(this.thumbnailProgress);
      paramParcel.writeList(this.mOriginPath);
      paramParcel.writeString(this.mKuolieId);
      paramParcel.writeFloat(this.mKuolieCenterX);
      paramParcel.writeFloat(this.mKuolieCenterY);
      paramParcel.writeFloat(this.mKuolieRotate);
      paramParcel.writeFloat(this.mKuolieWidthScale);
      paramParcel.writeFloat(this.mKuolieHeightScale);
      paramParcel.writeList(this.mHashTagList);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label213;
      paramInt = 0;
      break label228;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */