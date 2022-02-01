package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXMusicVideoObject
  implements WXMediaMessage.IMediaObject
{
  private static final int HD_ALBUM_FILE_LENGTH = 10485760;
  private static final int LYRIC_LENGTH_LIMIT = 32768;
  private static final int STRING_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.WXMusicVideoObject";
  private static final int URL_LENGTH_LIMIT = 10240;
  public String albumName;
  public int duration;
  public String hdAlbumThumbFilePath;
  public String identification;
  public long issueDate;
  public String musicDataUrl;
  public String musicGenre;
  public String musicUrl;
  public String singerName;
  public String songLyric;
  
  private int getFileSize(String paramString)
  {
    return b.a(paramString);
  }
  
  public boolean checkArgs()
  {
    String str;
    if ((!b.b(this.musicUrl)) && (this.musicUrl.length() <= 10240)) {
      if ((!b.b(this.musicDataUrl)) && (this.musicDataUrl.length() <= 10240)) {
        if ((!b.b(this.singerName)) && (this.singerName.length() <= 1024)) {
          if ((!b.b(this.songLyric)) && (this.songLyric.length() > 32768)) {
            str = "songLyric.length exceeds the limit";
          }
        }
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXMusicVideoObject", str);
      return false;
      if ((!b.b(this.hdAlbumThumbFilePath)) && (this.hdAlbumThumbFilePath.length() > 1024))
      {
        str = "hdAlbumThumbFilePath.length exceeds the limit";
      }
      else if ((!b.b(this.hdAlbumThumbFilePath)) && (getFileSize(this.hdAlbumThumbFilePath) > 10485760))
      {
        str = "hdAlbumThumbFilePath file length exceeds the limit";
      }
      else if ((!b.b(this.musicGenre)) && (this.musicGenre.length() > 1024))
      {
        str = "musicGenre.length exceeds the limit";
      }
      else if ((!b.b(this.identification)) && (this.identification.length() > 1024))
      {
        str = "identification.length exceeds the limit";
      }
      else
      {
        return true;
        str = "singerName.length exceeds the limit";
        continue;
        str = "musicDataUrl.length exceeds the limit";
        continue;
        str = "musicUrl.length exceeds the limit";
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxmusicvideoobject_musicUrl", this.musicUrl);
    paramBundle.putString("_wxmusicvideoobject_musicDataUrl", this.musicDataUrl);
    paramBundle.putString("_wxmusicvideoobject_singerName", this.singerName);
    paramBundle.putString("_wxmusicvideoobject_songLyric", this.songLyric);
    paramBundle.putString("_wxmusicvideoobject_hdAlbumThumbFilePath", this.hdAlbumThumbFilePath);
    paramBundle.putString("_wxmusicvideoobject_albumName", this.albumName);
    paramBundle.putString("_wxmusicvideoobject_musicGenre", this.musicGenre);
    paramBundle.putLong("_wxmusicvideoobject_issueDate", this.issueDate);
    paramBundle.putString("_wxmusicvideoobject_identification", this.identification);
    paramBundle.putInt("_wxmusicvideoobject_duration", this.duration);
  }
  
  public int type()
  {
    return 76;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.musicUrl = paramBundle.getString("_wxmusicvideoobject_musicUrl");
    this.musicDataUrl = paramBundle.getString("_wxmusicvideoobject_musicDataUrl");
    this.singerName = paramBundle.getString("_wxmusicvideoobject_singerName");
    this.songLyric = paramBundle.getString("_wxmusicvideoobject_songLyric");
    this.hdAlbumThumbFilePath = paramBundle.getString("_wxmusicvideoobject_hdAlbumThumbFilePath");
    this.albumName = paramBundle.getString("_wxmusicvideoobject_albumName");
    this.musicGenre = paramBundle.getString("_wxmusicvideoobject_musicGenre");
    this.issueDate = paramBundle.getLong("_wxmusicvideoobject_issueDate", 0L);
    this.identification = paramBundle.getString("_wxmusicvideoobject_identification");
    this.duration = paramBundle.getInt("_wxmusicvideoobject_duration", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject
 * JD-Core Version:    0.7.0.1
 */