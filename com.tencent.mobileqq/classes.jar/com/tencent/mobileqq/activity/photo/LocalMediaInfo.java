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
  public int rotation = 0;
  public String scheme = "";
  public int selectStatus;
  public int showCircleTakeSame = 0;
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
      int i = arrayOfString.length;
      if ((i > 6) && (!arrayOfString[6].equals("useNewDecoder"))) {
        localLocalMediaInfo.index = Integer.parseInt(arrayOfString[6]);
      }
      if (paramURL.endsWith("useNewDecoder")) {
        localLocalMediaInfo.isRegionThumbUseNewDecoder = true;
      }
      return localLocalMediaInfo;
    }
    catch (Exception paramURL)
    {
      label105:
      break label105;
    }
    return null;
  }
  
  public int compareTo(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = -1;
    if (paramLocalMediaInfo == null) {
      return -1;
    }
    long l1 = paramLocalMediaInfo.modifiedDate;
    long l2 = this.modifiedDate;
    if (l1 > l2) {
      return 1;
    }
    if (l1 == l2) {
      i = 0;
    }
    return i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalMediaInfo{_id=");
    localStringBuilder.append(this._id);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.path);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(", addedDate=");
    localStringBuilder.append(this.addedDate);
    localStringBuilder.append(", modifiedDate=");
    localStringBuilder.append(this.modifiedDate);
    localStringBuilder.append(", orientation=");
    localStringBuilder.append(this.orientation);
    localStringBuilder.append(", mDuration=");
    localStringBuilder.append(this.mDuration);
    localStringBuilder.append(", mChecked=");
    localStringBuilder.append(this.mChecked);
    localStringBuilder.append(", selectStatus=");
    localStringBuilder.append(this.selectStatus);
    localStringBuilder.append(", rotation=");
    localStringBuilder.append(this.rotation);
    localStringBuilder.append(", thumbWidth=");
    localStringBuilder.append(this.thumbWidth);
    localStringBuilder.append(", thumbHeight=");
    localStringBuilder.append(this.thumbHeight);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.index);
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.position);
    localStringBuilder.append(", mMimeType='");
    localStringBuilder.append(this.mMimeType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mediaWidth=");
    localStringBuilder.append(this.mediaWidth);
    localStringBuilder.append(", mediaHeight=");
    localStringBuilder.append(this.mediaHeight);
    localStringBuilder.append(", mediaBitrate=");
    localStringBuilder.append(this.mediaBitrate);
    localStringBuilder.append(", isSystemMeidaStore=");
    localStringBuilder.append(this.isSystemMeidaStore);
    localStringBuilder.append(", isRegionThumbUseNewDecoder=");
    localStringBuilder.append(this.isRegionThumbUseNewDecoder);
    localStringBuilder.append(", panoramaPhotoType=");
    localStringBuilder.append(this.panoramaPhotoType);
    localStringBuilder.append(", mediaType=");
    localStringBuilder.append(this.mMediaType);
    localStringBuilder.append(", isVideoReady=");
    localStringBuilder.append(this.isVideoReady);
    localStringBuilder.append(", videoInfo=");
    localStringBuilder.append(this.materialID);
    localStringBuilder.append(", materialName=");
    localStringBuilder.append(this.materialName);
    localStringBuilder.append(", filterID=");
    localStringBuilder.append(this.filterID);
    localStringBuilder.append(", scheme=");
    localStringBuilder.append(this.scheme);
    localStringBuilder.append(", showCircleTakeSame=");
    localStringBuilder.append(this.showCircleTakeSame);
    localStringBuilder.append(", missionID=");
    localStringBuilder.append(this.missionID);
    localStringBuilder.append(", thumbnailProgress=");
    localStringBuilder.append(this.thumbnailProgress);
    localStringBuilder.append(", mediaOriginWidth=");
    localStringBuilder.append(this.mediaOriginWidth);
    localStringBuilder.append(", mediaOriginHeight=");
    localStringBuilder.append(this.mediaOriginHeight);
    localStringBuilder.append(", mediaOriginSize=");
    localStringBuilder.append(this.mediaOriginSize);
    localStringBuilder.append(", mediaOriginBitrate=");
    localStringBuilder.append(this.mediaOriginBitrate);
    localStringBuilder.append(", mOriginPath=");
    localStringBuilder.append(this.mOriginPath);
    localStringBuilder.append(", mKuolieId=");
    localStringBuilder.append(this.mKuolieId);
    localStringBuilder.append(", mKuolieCenterX=");
    localStringBuilder.append(this.mKuolieCenterX);
    localStringBuilder.append(", mKuolieCenterY=");
    localStringBuilder.append(this.mKuolieCenterY);
    localStringBuilder.append(", mKuolieRotate=");
    localStringBuilder.append(this.mKuolieRotate);
    localStringBuilder.append(", mKuolieWidthScale=");
    localStringBuilder.append(this.mKuolieWidthScale);
    localStringBuilder.append(", mKuolieHeightScale=");
    localStringBuilder.append(this.mKuolieHeightScale);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this._id);
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.fileSize);
    paramParcel.writeLong(this.addedDate);
    paramParcel.writeLong(this.modifiedDate);
    paramParcel.writeInt(this.orientation);
    paramParcel.writeInt(this.rotation);
    paramParcel.writeLong(this.mDuration);
    paramParcel.writeByte((byte)this.mChecked);
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
    paramParcel.writeByte((byte)this.isSystemMeidaStore);
    paramParcel.writeByte((byte)this.isRegionThumbUseNewDecoder);
    paramParcel.writeInt(this.longitude);
    paramParcel.writeInt(this.latitude);
    paramParcel.writeInt(this.panoramaPhotoType);
    paramParcel.writeLong(this.mCloudPhotoOwnerUin);
    paramParcel.writeString(this.mCloudPhotoOwnerAlbumId);
    paramParcel.writeString(this.mCloudPhotoId);
    paramParcel.writeByte((byte)this.isVideoReady);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */