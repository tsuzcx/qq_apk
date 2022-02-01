package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import org.json.JSONObject;
import qqcircle.QQCircleSmartMatchMusic.AlbumInfo;
import qqcircle.QQCircleSmartMatchMusic.ConfInfo;
import qqcircle.QQCircleSmartMatchMusic.LyricInfo;
import qqcircle.QQCircleSmartMatchMusic.MusicInfo;
import qqcircle.QQCircleSmartMatchMusic.SingerInfo;
import qqcircle.QQCircleSmartMatchMusic.SongInfo;

public class VsMusicItemInfo
  extends MusicItemInfo
{
  public String a;
  public String b;
  public int c = 1;
  public boolean d = true;
  public String e = HardCodeUtil.a(2131913789);
  
  public VsMusicItemInfo() {}
  
  public VsMusicItemInfo(JSONObject paramJSONObject)
  {
    this.mType = 5;
    this.mMusicName = paramJSONObject.optString("title");
    this.mSingername = paramJSONObject.optString("desc");
    this.mItemId = paramJSONObject.optInt("id");
    this.mAlbumUrl = paramJSONObject.optString("image_url");
    this.mSongMid = paramJSONObject.optString("mid");
    this.mMusicName = paramJSONObject.optString("strSongName");
    this.mHasCopyright = true;
    this.c = 2;
    this.mUrl = paramJSONObject.optString("strPlayUrl");
    this.musicDuration = (paramJSONObject.optInt("iPlayTime") * 1000);
  }
  
  public VsMusicItemInfo(QQCircleSmartMatchMusic.MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {
      return;
    }
    a(paramMusicInfo);
  }
  
  public void a(META.StMusic paramStMusic)
  {
    this.mSongMid = paramStMusic.strSongMid.get();
    this.mType = 5;
    this.mUrl = paramStMusic.strPlayUrl.get();
    int i = paramStMusic.copyright.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.mHasCopyright = bool;
    this.mSingername = paramStMusic.strSingerName.get();
    this.mMusicName = paramStMusic.strSongName.get();
    this.mAlbumUrl = paramStMusic.strAlbumPic.get();
    this.b = paramStMusic.strLyric.get();
    this.musicStart = ((int)paramStMusic.iStartPos.get());
    this.musicEnd = 0;
    this.a = paramStMusic.strFormat.get();
    this.mItemId = ((int)paramStMusic.uiSongId.get());
    this.musicDuration = (paramStMusic.iPlayTime.get() * 1000);
    this.fileSize = paramStMusic.iSize.get();
  }
  
  public void a(QQCircleSmartMatchMusic.MusicInfo paramMusicInfo)
  {
    this.mSongMid = paramMusicInfo.songInfo.MID.get();
    this.mType = 5;
    this.mUrl = paramMusicInfo.songInfo.PlayUrl.get();
    int i = paramMusicInfo.songInfo.Copyright.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.mHasCopyright = bool;
    this.mSingername = paramMusicInfo.singerInfo.name.get();
    this.mMusicName = paramMusicInfo.songInfo.name.get();
    this.mAlbumUrl = paramMusicInfo.albumInfo.picURL.get();
    this.b = paramMusicInfo.lyricInfo.strLyric.get();
    this.musicStart = paramMusicInfo.confInfo.startPos.get();
    this.musicEnd = 0;
    this.a = paramMusicInfo.lyricInfo.strFormat.get();
    this.mItemId = ((int)paramMusicInfo.lyricInfo.uiSongId.get());
    this.musicDuration = (paramMusicInfo.songInfo.IPlayTime.get() * 1000);
    this.fileSize = paramMusicInfo.songInfo.ISize.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo
 * JD-Core Version:    0.7.0.1
 */