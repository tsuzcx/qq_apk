package com.tencent.biz.qqstory.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wiq;
import wuw;
import yuk;

public class PublishVideoEntry
  extends Entity
  implements wiq
{
  public static final String ENTRY_KEY_BACKGROUND_VOLUME = "backgroundVolume";
  public static final String ENTRY_KEY_IS_MIX_ORIGINAL = "isMixOriginal";
  public static final String ENTRY_KEY_ORIGINAL_RECORD_VOLUME = "originalRecordVolume";
  public static final String ENTRY_KEY_SUBTITLE = "subtitleData";
  public static int VIDEO_PROCESS_STATE_COMPOSITE_FAILED = -1;
  public static int VIDEO_PROCESS_STATE_COMPOSITE_SUC = 1;
  public static int VIDEO_PROCESS_STATE_UPLOAD_SUC = 2;
  public String atDoodlePath;
  public String atJsonData;
  public int backgroundMusicDuration;
  public int backgroundMusicOffset;
  public String backgroundMusicPath;
  public int businessId;
  public long createTime;
  public String doodlePath;
  public String doodleRawPath;
  @notColumn
  private JSONObject extraJson;
  public String extraJsonString;
  @unique
  public String fakeVid;
  @Deprecated
  public int fragmentGroupId;
  public String fragments;
  public String gpsFilterDescription;
  public boolean hasFragments;
  @notColumn
  public int hwBitrateMode = -1;
  public boolean hwEncodeRecordVideo;
  @notColumn
  public boolean isCancel;
  @notColumn
  public boolean isEdited;
  public boolean isLocalPublish;
  @notColumn
  public boolean isMixOriginal;
  public boolean isMuteRecordVoice;
  @notColumn
  public boolean isNeedHighProfile;
  public boolean isPicture;
  public String localCreateCity;
  public String mAudioFilePath;
  public String mIFrameVideoPath;
  public String mLocalDate;
  public String mLocalRawPicPath;
  public String mLocalRawVideoDir;
  public byte[] mMosaicMask;
  public int mMosaicSize;
  @notColumn
  public String manualSavedPath;
  public String mbgmAudioFilePath;
  public String miniThumbPath;
  public String mosaicPath;
  public String multiFragmentGroupId;
  public String name;
  public int publishFrom;
  public int publishState;
  public byte[] readerConfBytes;
  public int recordFrames;
  public double recordTime;
  @notColumn
  public int redBagType;
  public int saveMode;
  @notColumn
  public int specialVideoType;
  public byte[] spreadGroupBytes;
  public byte[] tagInfoBytes;
  public String thumbPath;
  public long timeZoneOffset;
  @notColumn
  public boolean useSrcFile;
  public String videoAddress;
  public String videoCreateAddress;
  public long videoCreateTime;
  public String videoDoodleDescription;
  public long videoDuration;
  public int videoHeight;
  public String videoLabel;
  public int videoLatitude;
  public String videoLocationDescription;
  public int videoLongitude;
  public int videoMaxrate;
  public int videoMinrate;
  public boolean videoNeedRotate;
  public int videoProcessState;
  public int videoRangeEnd;
  public int videoRangeStart;
  public String videoUploadGroupTempDir;
  public String videoUploadTempDir;
  public int videoWidth;
  
  @NonNull
  private JSONObject getExtraJson()
  {
    try
    {
      if (this.extraJson == null) {
        if (this.extraJsonString == null) {
          break label40;
        }
      }
      label40:
      for (this.extraJson = new JSONObject(this.extraJsonString);; this.extraJson = new JSONObject())
      {
        JSONObject localJSONObject = this.extraJson;
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        yuk.c("PublishVideoEntry", "getExtraJson error", localJSONException);
        this.extraJson = new JSONObject();
      }
    }
    finally {}
  }
  
  public static String getGroupIdNoArgs()
  {
    return "multiFragmentGroupId=?";
  }
  
  public static String getVidSelectionNoArgs()
  {
    return "fakeVid=?";
  }
  
  public void copy(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (PublishVideoEntry)paramObject;
    this.fakeVid = paramObject.fakeVid;
    this.createTime = paramObject.createTime;
    this.mLocalDate = paramObject.mLocalDate;
    this.timeZoneOffset = paramObject.timeZoneOffset;
    this.businessId = paramObject.businessId;
    this.name = paramObject.name;
    this.mLocalRawVideoDir = paramObject.mLocalRawVideoDir;
    this.mLocalRawPicPath = paramObject.mLocalRawPicPath;
    this.mMosaicMask = paramObject.mMosaicMask;
    this.mMosaicSize = paramObject.mMosaicSize;
    this.backgroundMusicPath = paramObject.backgroundMusicPath;
    this.backgroundMusicOffset = paramObject.backgroundMusicOffset;
    this.backgroundMusicDuration = paramObject.backgroundMusicDuration;
    this.isMuteRecordVoice = paramObject.isMuteRecordVoice;
    this.recordTime = paramObject.recordTime;
    this.recordFrames = paramObject.recordFrames;
    this.saveMode = paramObject.saveMode;
    this.isPicture = paramObject.isPicture;
    this.isLocalPublish = paramObject.isLocalPublish;
    this.publishFrom = paramObject.publishFrom;
    this.videoCreateTime = paramObject.videoCreateTime;
    this.fragmentGroupId = paramObject.fragmentGroupId;
    this.multiFragmentGroupId = paramObject.multiFragmentGroupId;
    this.hasFragments = paramObject.hasFragments;
    this.fragments = paramObject.fragments;
    this.videoRangeStart = paramObject.videoRangeStart;
    this.videoRangeEnd = paramObject.videoRangeEnd;
    this.videoCreateAddress = paramObject.videoCreateAddress;
    this.tagInfoBytes = paramObject.tagInfoBytes;
    this.videoUploadTempDir = paramObject.videoUploadTempDir;
    this.videoUploadGroupTempDir = paramObject.videoUploadGroupTempDir;
    this.publishState = paramObject.publishState;
    this.thumbPath = paramObject.thumbPath;
    this.doodlePath = paramObject.doodlePath;
    this.doodleRawPath = paramObject.doodleRawPath;
    this.videoLabel = paramObject.videoLabel;
    this.videoDoodleDescription = paramObject.videoDoodleDescription;
    this.videoLocationDescription = paramObject.videoLocationDescription;
    this.gpsFilterDescription = paramObject.gpsFilterDescription;
    this.videoAddress = paramObject.videoAddress;
    this.videoWidth = paramObject.videoWidth;
    this.videoHeight = paramObject.videoHeight;
    this.videoDuration = paramObject.videoDuration;
    this.videoMaxrate = paramObject.videoMaxrate;
    this.videoMinrate = paramObject.videoMinrate;
    this.atDoodlePath = paramObject.atDoodlePath;
    this.atJsonData = paramObject.atJsonData;
    this.localCreateCity = paramObject.localCreateCity;
    this.videoLatitude = paramObject.videoLatitude;
    this.videoLongitude = paramObject.videoLongitude;
    this.videoNeedRotate = paramObject.videoNeedRotate;
    this.hwEncodeRecordVideo = paramObject.hwEncodeRecordVideo;
    this.mAudioFilePath = paramObject.mAudioFilePath;
    this.mIFrameVideoPath = paramObject.mIFrameVideoPath;
    this.mosaicPath = paramObject.mosaicPath;
    this.readerConfBytes = paramObject.readerConfBytes;
    this.spreadGroupBytes = paramObject.spreadGroupBytes;
    this.videoProcessState = paramObject.videoProcessState;
    this.extraJsonString = paramObject.extraJsonString;
    this.extraJson = paramObject.extraJson;
    this.manualSavedPath = paramObject.manualSavedPath;
    this.isEdited = paramObject.isEdited;
    this.isNeedHighProfile = paramObject.isNeedHighProfile;
    this.hwBitrateMode = paramObject.hwBitrateMode;
    this.mbgmAudioFilePath = paramObject.mbgmAudioFilePath;
  }
  
  public boolean getBooleanExtra(String paramString, boolean paramBoolean)
  {
    return getExtraJson().optBoolean(paramString, paramBoolean);
  }
  
  public int getIntExtra(String paramString, int paramInt)
  {
    return getExtraJson().optInt(paramString, paramInt);
  }
  
  public JSONArray getJSONArrayExtra(String paramString)
  {
    return getExtraJson().optJSONArray(paramString);
  }
  
  public JSONObject getJSONExtra(String paramString)
  {
    return getExtraJson().optJSONObject(paramString);
  }
  
  @Nullable
  public wuw getLinkInfo()
  {
    Object localObject = getStringExtra("link", null);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = (wuw)JsonORM.a(new JSONObject((String)localObject), wuw.class);
      return localObject;
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      yuk.c("PublishVideoEntry", "getLinkInfo error", localJsonParseException);
      return null;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        yuk.c("PublishVideoEntry", "getLinkInfo error", localJSONException);
      }
    }
  }
  
  public long getLongExtra(String paramString, long paramLong)
  {
    return getExtraJson().optLong(paramString, paramLong);
  }
  
  public String getStringExtra(String paramString1, String paramString2)
  {
    return getExtraJson().optString(paramString1, paramString2);
  }
  
  public void postRead()
  {
    super.postRead();
    this.isNeedHighProfile = getBooleanExtra("isNeedHighProfile", false);
    this.hwBitrateMode = getIntExtra("hwBitrateMode", -1);
  }
  
  public void prewrite()
  {
    super.prewrite();
    putExtra("isNeedHighProfile", Boolean.valueOf(this.isNeedHighProfile));
    putExtra("hwBitrateMode", Integer.valueOf(this.hwBitrateMode));
  }
  
  public boolean putExtra(String paramString, Object paramObject)
  {
    try
    {
      JSONObject localJSONObject = getExtraJson();
      localJSONObject.put(paramString, paramObject);
      this.extraJsonString = localJSONObject.toString();
      return true;
    }
    catch (JSONException paramString)
    {
      yuk.c("PublishVideoEntry", "putStringExtra error", paramString);
    }
    return false;
  }
  
  public void setGameLinkInfo(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("type", Integer.valueOf(2));
      localJSONObject.putOpt("parseState", Integer.valueOf(2));
      localJSONObject.putOpt("game", new JSONObject(paramString));
      putExtra("link", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      yuk.c("PublishVideoEntry", "setGameLinkInfo error", paramString);
    }
  }
  
  public void setLinkInfo(@NonNull wuw paramwuw)
  {
    try
    {
      putExtra("link", JsonORM.a(paramwuw));
      return;
    }
    catch (JsonORM.JsonParseException paramwuw)
    {
      yuk.c("PublishVideoEntry", "setLinkInfo error", paramwuw);
    }
  }
  
  public String toString()
  {
    return "PublishVideoEntry{fakeVid='" + this.fakeVid + '\'' + ", createTime=" + this.createTime + ", mLocalDate='" + this.mLocalDate + '\'' + ", fragmentGroupId=" + this.fragmentGroupId + ", multiFragmentGroupId='" + this.multiFragmentGroupId + '\'' + ", timeZoneOffset=" + this.timeZoneOffset + ", mLocalRawVideoDir='" + this.mLocalRawVideoDir + '\'' + ", mLocalRawPicPath='" + this.mLocalRawPicPath + '\'' + ", mMosaicSize=" + this.mMosaicSize + ", backgroundMusicPath='" + this.backgroundMusicPath + '\'' + ", backgroundMusicOffset=" + this.backgroundMusicOffset + ", backgroundMusicDuration=" + this.backgroundMusicDuration + ", isMuteRecordVoice=" + this.isMuteRecordVoice + ", recordTime=" + this.recordTime + ", recordFrames=" + this.recordFrames + ", saveMode=" + this.saveMode + ", isPicture=" + this.isPicture + ", isLocalPublish=" + this.isLocalPublish + ", publishFrom=" + this.publishFrom + ", videoCreateTime=" + this.videoCreateTime + ", hasFragments=" + this.hasFragments + ", fragments='" + this.fragments + '\'' + ", videoRangeStart=" + this.videoRangeStart + ", videoRangeEnd=" + this.videoRangeEnd + ", videoUploadTempDir='" + this.videoUploadTempDir + '\'' + ", videoUploadGroupTempDir='" + this.videoUploadGroupTempDir + '\'' + ", publishState=" + this.publishState + ", thumbPath='" + this.thumbPath + '\'' + ", doodlePath='" + this.doodlePath + '\'' + ", doodleRawPath='" + this.doodleRawPath + '\'' + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoDuration=" + this.videoDuration + ", videoMaxrate=" + this.videoMaxrate + ", videoMinrate=" + this.videoMinrate + ", videoNeedRotate=" + this.videoNeedRotate + ", hwEncodeRecordVideo=" + this.hwEncodeRecordVideo + ", mAudioFilePath='" + this.mAudioFilePath + '\'' + ", mIFrameVideoPath='" + this.mIFrameVideoPath + '\'' + ", mosaicPath='" + this.mosaicPath + '\'' + ", videoProcessState=" + this.videoProcessState + ", extraJsonString=" + this.extraJsonString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.PublishVideoEntry
 * JD-Core Version:    0.7.0.1
 */