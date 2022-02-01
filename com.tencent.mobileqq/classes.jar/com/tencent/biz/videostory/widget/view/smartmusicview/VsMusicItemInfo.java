package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import anzj;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import org.json.JSONObject;

public class VsMusicItemInfo
  extends MusicItemInfo
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public String c = anzj.a(2131715648);
  
  public VsMusicItemInfo()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public VsMusicItemInfo(META.StMusic paramStMusic)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    if (paramStMusic == null) {
      return;
    }
    a(paramStMusic);
  }
  
  public VsMusicItemInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.mType = 5;
    this.mMusicName = paramJSONObject.optString("title");
    this.mSingername = paramJSONObject.optString("desc");
    this.mItemId = paramJSONObject.optInt("id");
    this.mAlbumUrl = paramJSONObject.optString("image_url");
    this.mSongMid = paramJSONObject.optString("mid");
    this.mMusicName = paramJSONObject.optString("strSongName");
    this.mHasCopyright = true;
    this.jdField_a_of_type_Int = 2;
    this.mUrl = paramJSONObject.optString("strPlayUrl");
    this.musicDuration = (paramJSONObject.optInt("iPlayTime") * 1000);
  }
  
  public void a(META.StMusic paramStMusic)
  {
    boolean bool = true;
    this.mSongMid = paramStMusic.strSongMid.get();
    this.mType = 5;
    this.mUrl = paramStMusic.strPlayUrl.get();
    if (paramStMusic.copyright.get() == 1) {}
    for (;;)
    {
      this.mHasCopyright = bool;
      this.mSingername = paramStMusic.strSingerName.get();
      this.mMusicName = paramStMusic.strSongName.get();
      this.mAlbumUrl = paramStMusic.strAlbumPic.get();
      this.b = paramStMusic.strLyric.get();
      this.musicStart = ((int)paramStMusic.iStartPos.get());
      this.musicEnd = 0;
      this.jdField_a_of_type_JavaLangString = paramStMusic.strFormat.get();
      this.mItemId = ((int)paramStMusic.uiSongId.get());
      this.musicDuration = (paramStMusic.iPlayTime.get() * 1000);
      this.fileSize = paramStMusic.iSize.get();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo
 * JD-Core Version:    0.7.0.1
 */