package com.tencent.aelight.camera.struct.editor;

import NS_QQ_STORY_META.META.StMusic;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

public class FlowMusic
  extends Entity
  implements Comparable<FlowMusic>
{
  public static final int SOURCE_CUSTOM_ADD = 0;
  public static final int SOURCE_QQ_MUSIC_AUTO = 1;
  public int albumId;
  public String albumMid;
  public String albumName;
  public String albumUrl;
  public int duration = -1;
  public String path = null;
  @notColumn
  public int playable;
  public int singerId;
  public String singerMid;
  public String singerName;
  @notColumn
  public long size = -1L;
  @unique
  public int songId;
  public String songMid;
  public String songName;
  public int songPlayTime;
  public int sourceType;
  public long storeTimeStamp;
  public int tryBegin = -1;
  public int tryEnd = -1;
  @notColumn
  public String url = null;
  public int userOwnRule;
  
  public FlowMusic()
  {
    this.sourceType = 0;
    this.playable = 1;
    this.storeTimeStamp = -1L;
  }
  
  public FlowMusic(META.StMusic paramStMusic)
  {
    int i = 0;
    this.sourceType = 0;
    this.playable = 1;
    this.storeTimeStamp = -1L;
    this.albumId = ((int)paramStMusic.uiAlbumId.get());
    this.albumMid = paramStMusic.strAlbumMid.get();
    this.albumName = paramStMusic.strAlbumName.get();
    this.albumUrl = paramStMusic.strAlbumPic.get();
    this.singerId = ((int)paramStMusic.uiSingerId.get());
    this.singerMid = paramStMusic.strSingerMid.get();
    this.singerName = paramStMusic.strSingerName.get();
    this.songId = ((int)paramStMusic.uiSongId.get());
    this.songMid = paramStMusic.strSongMid.get();
    this.songName = paramStMusic.strSongName.get();
    this.songPlayTime = paramStMusic.iPlayTime.get();
    if (paramStMusic.iTrySize.get() > 0) {
      i = 1;
    }
    this.userOwnRule = i;
    this.url = paramStMusic.strPlayUrl.get();
    this.size = paramStMusic.iSize.get();
    this.playable = paramStMusic.copyright.get();
    this.storeTimeStamp = System.currentTimeMillis();
  }
  
  public FlowMusic(MusicItemInfo paramMusicItemInfo)
  {
    this.sourceType = 0;
    this.playable = 1;
    this.storeTimeStamp = -1L;
    this.songId = paramMusicItemInfo.mItemId;
    this.singerName = paramMusicItemInfo.mSingername;
    this.songName = paramMusicItemInfo.mMusicName;
    this.url = paramMusicItemInfo.mUrl;
    this.tryBegin = paramMusicItemInfo.musicStart;
    this.tryEnd = paramMusicItemInfo.musicEnd;
    this.songMid = paramMusicItemInfo.mSongMid;
    this.duration = paramMusicItemInfo.musicDuration;
    this.storeTimeStamp = System.currentTimeMillis();
    this.albumUrl = paramMusicItemInfo.mAlbumUrl;
  }
  
  public int compareTo(FlowMusic paramFlowMusic)
  {
    if (paramFlowMusic == null) {
      return 1;
    }
    if (this != paramFlowMusic)
    {
      if (this.songId == paramFlowMusic.songId) {
        return 0;
      }
      int i = this.sourceType;
      int j = paramFlowMusic.sourceType;
      if (i != j) {
        return i - j;
      }
      long l = paramFlowMusic.storeTimeStamp - this.storeTimeStamp;
      if (l > 0L) {
        return 1;
      }
      if (l < 0L) {
        return -1;
      }
    }
    return 0;
  }
  
  public void copyFrom(FlowMusic paramFlowMusic)
  {
    this.albumId = paramFlowMusic.albumId;
    this.albumMid = paramFlowMusic.albumMid;
    this.albumName = paramFlowMusic.albumName;
    this.albumUrl = paramFlowMusic.albumUrl;
    this.singerId = paramFlowMusic.singerId;
    this.singerMid = paramFlowMusic.singerMid;
    this.singerName = paramFlowMusic.singerName;
    this.songId = paramFlowMusic.songId;
    this.songMid = paramFlowMusic.songMid;
    this.songName = paramFlowMusic.songName;
    this.songPlayTime = paramFlowMusic.songPlayTime;
    this.userOwnRule = paramFlowMusic.userOwnRule;
    this.tryBegin = paramFlowMusic.tryBegin;
    this.tryEnd = paramFlowMusic.tryEnd;
    this.duration = paramFlowMusic.duration;
    this.path = paramFlowMusic.path;
    this.url = paramFlowMusic.url;
    this.size = paramFlowMusic.size;
    this.sourceType = paramFlowMusic.sourceType;
    this.playable = paramFlowMusic.playable;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FlowMusic)paramObject;
      return this.songId == paramObject.songId;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.songId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlowMusic{url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", songMid='");
    localStringBuilder.append(this.songMid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", songName='");
    localStringBuilder.append(this.songName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", playable=");
    localStringBuilder.append(this.playable);
    localStringBuilder.append(", albumId=");
    localStringBuilder.append(this.albumId);
    localStringBuilder.append(", albumMid='");
    localStringBuilder.append(this.albumMid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", albumName='");
    localStringBuilder.append(this.albumName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", albumUrl='");
    localStringBuilder.append(this.albumUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", singerId=");
    localStringBuilder.append(this.singerId);
    localStringBuilder.append(", singerMid='");
    localStringBuilder.append(this.singerMid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", singerName='");
    localStringBuilder.append(this.singerName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", songId=");
    localStringBuilder.append(this.songId);
    localStringBuilder.append(", songPlayTime=");
    localStringBuilder.append(this.songPlayTime);
    localStringBuilder.append(", userOwnRule=");
    localStringBuilder.append(this.userOwnRule);
    localStringBuilder.append(", tryBegin=");
    localStringBuilder.append(this.tryBegin);
    localStringBuilder.append(", tryEnd=");
    localStringBuilder.append(this.tryEnd);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.path);
    localStringBuilder.append('\'');
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", sourceType=");
    localStringBuilder.append(this.sourceType);
    localStringBuilder.append(", storeTimeStamp=");
    localStringBuilder.append(this.storeTimeStamp);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.editor.FlowMusic
 * JD-Core Version:    0.7.0.1
 */