package com.tencent.falco.base.libapi.music;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicItem
  implements Serializable, Cloneable
{
  public static final int FLAG_ALL = 2;
  public static final int FLAG_GONE = -1;
  public static final int FLAG_ONLY_ACCOMPANY = 0;
  public static final int FLAG_ONLY_ORIGINAL = 1;
  private static final long serialVersionUID = 2726803027799034511L;
  public String accompanyUrl;
  public String callback;
  public String mId;
  public String originalUrl;
  public String singerName;
  public String songId;
  public String songLyric;
  public String songName;
  
  public static MusicItem parse(String paramString)
  {
    try
    {
      paramString = new JSONObject(URLDecoder.decode(paramString, "UTF-8"));
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    return parse(paramString);
  }
  
  public static MusicItem parse(String paramString1, String paramString2)
  {
    paramString1 = parse(paramString1);
    paramString1.callback = paramString2;
    return paramString1;
  }
  
  public static MusicItem parse(JSONObject paramJSONObject)
  {
    MusicItem localMusicItem = new MusicItem();
    if (paramJSONObject == null) {
      return localMusicItem;
    }
    try
    {
      if (paramJSONObject.has("singer_name")) {
        localMusicItem.singerName = paramJSONObject.getString("singer_name");
      }
      if (paramJSONObject.has("song_name")) {
        localMusicItem.songName = paramJSONObject.getString("song_name");
      }
      if (paramJSONObject.has("song_id")) {
        localMusicItem.songId = String.valueOf(paramJSONObject.getLong("song_id"));
      }
      if (paramJSONObject.has("mid")) {
        localMusicItem.mId = paramJSONObject.getString("mid");
      }
      if (paramJSONObject.has("play_url")) {
        localMusicItem.originalUrl = paramJSONObject.getString("play_url");
      }
      if (paramJSONObject.has("song_lyric")) {
        localMusicItem.songLyric = paramJSONObject.getString("song_lyric");
      }
      if (paramJSONObject.has("accompany_url"))
      {
        localMusicItem.accompanyUrl = paramJSONObject.getString("accompany_url");
        return localMusicItem;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localMusicItem;
  }
  
  public MusicItem clone()
  {
    try
    {
      MusicItem localMusicItem = (MusicItem)super.clone();
      return localMusicItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (MusicItem)paramObject;
    return (!TextUtils.isEmpty(paramObject.songId)) && (paramObject.songId.equals(this.songId));
  }
  
  public int getFactor()
  {
    if ((!TextUtils.isEmpty(this.originalUrl)) && (this.originalUrl.startsWith("http")))
    {
      if ((!TextUtils.isEmpty(this.accompanyUrl)) && (this.accompanyUrl.startsWith("http"))) {
        return 2;
      }
      return 1;
    }
    if ((!TextUtils.isEmpty(this.accompanyUrl)) && (this.accompanyUrl.startsWith("http"))) {}
    return 1;
  }
  
  public int getSingFlag()
  {
    if ((!TextUtils.isEmpty(this.originalUrl)) && (this.originalUrl.startsWith("http")))
    {
      if ((!TextUtils.isEmpty(this.accompanyUrl)) && (this.accompanyUrl.startsWith("http"))) {
        return 2;
      }
      return 1;
    }
    if ((!TextUtils.isEmpty(this.accompanyUrl)) && (this.accompanyUrl.startsWith("http"))) {
      return 0;
    }
    return -1;
  }
  
  public int hashCode()
  {
    return this.songId.hashCode();
  }
  
  public boolean isEmpty()
  {
    return TextUtils.isEmpty(this.songId);
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("singer_name", this.singerName);
      localJSONObject.put("song_id", this.songId);
      localJSONObject.put("song_name", this.songName);
      localJSONObject.put("mid ", this.mId);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.music.MusicItem
 * JD-Core Version:    0.7.0.1
 */