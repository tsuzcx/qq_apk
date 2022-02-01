package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQStoryMusicInfo
{
  public static final QQStoryMusicInfo a = new QQStoryMusicInfo(0, HardCodeUtil.a(2131908560));
  public static final QQStoryMusicInfo b = new QQStoryMusicInfo(1, HardCodeUtil.a(2131908557));
  public static final QQStoryMusicInfo c = new QQStoryMusicInfo(2, "QQ音乐曲库");
  public String d = null;
  public String e = null;
  String f = null;
  public String g = null;
  String h = null;
  String i = null;
  int j = 0;
  public int k = -1;
  public int l = 0;
  public String m = null;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  
  public QQStoryMusicInfo() {}
  
  public QQStoryMusicInfo(int paramInt, String paramString)
  {
    this.k = paramInt;
    this.e = paramString;
  }
  
  public QQStoryMusicInfo(qqstory_struct.MusicConfigInfo paramMusicConfigInfo)
  {
    this.e = paramMusicConfigInfo.title.get().toStringUtf8();
    this.g = paramMusicConfigInfo.audio_url.get().toStringUtf8();
    this.k = 3;
    this.d = String.valueOf(paramMusicConfigInfo.id.get());
  }
  
  public QQStoryMusicInfo(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.e = paramString.optString("title");
      this.g = paramString.optString("audio_url");
      if (paramString.has("type")) {
        this.k = paramString.optInt("type");
      } else {
        this.k = 2;
      }
      this.d = paramString.optString("id");
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MusicInfo", 2, QLog.getStackTraceString(paramString));
      }
    }
  }
  
  public static final ArrayList<QQStoryMusicInfo> a(Context paramContext)
  {
    paramContext = SharePreferenceUtils.a(paramContext, "qqstory_savedMusicList");
    Context localContext;
    try
    {
      JSONArray localJSONArray = new JSONArray(paramContext);
      int i2 = localJSONArray.length();
      paramContext = new ArrayList(i2);
      int i1 = 0;
      for (;;)
      {
        localContext = paramContext;
        if (i1 >= i2) {
          return localContext;
        }
        try
        {
          paramContext.add(new QQStoryMusicInfo(localJSONArray.optString(i1)));
          i1 += 1;
        }
        catch (JSONException localJSONException1) {}
      }
      localContext = paramContext;
    }
    catch (JSONException localJSONException2)
    {
      paramContext = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("MusicInfo", 2, QLog.getStackTraceString(localJSONException2));
      localContext = paramContext;
    }
    return localContext;
  }
  
  public static final void a(Context paramContext, ArrayList<QQStoryMusicInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      int i2 = paramArrayList.size();
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < i2)
      {
        localJSONArray.put(((QQStoryMusicInfo)paramArrayList.get(i1)).a());
        i1 += 1;
      }
      paramArrayList = localJSONArray.toString();
    }
    else
    {
      paramArrayList = null;
    }
    if (TextUtils.isEmpty(paramArrayList))
    {
      SharePreferenceUtils.b(paramContext, "qqstory_savedMusicList");
      return;
    }
    SharePreferenceUtils.a(paramContext, "qqstory_savedMusicList", paramArrayList);
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", this.e);
      localJSONObject.put("audio_url", this.g);
      localJSONObject.put("type", 3);
      localJSONObject.put("id", this.d);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MusicInfo", 2, QLog.getStackTraceString(localJSONException));
      }
    }
    return localJSONObject.toString();
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    this.d = paramQQStoryMusicInfo.d;
    this.e = paramQQStoryMusicInfo.e;
    this.f = paramQQStoryMusicInfo.f;
    this.g = paramQQStoryMusicInfo.g;
    this.h = paramQQStoryMusicInfo.h;
    this.i = paramQQStoryMusicInfo.i;
    this.j = paramQQStoryMusicInfo.j;
    this.k = paramQQStoryMusicInfo.k;
    this.l = paramQQStoryMusicInfo.l;
    this.m = paramQQStoryMusicInfo.m;
    this.n = paramQQStoryMusicInfo.n;
    this.o = paramQQStoryMusicInfo.o;
    this.p = paramQQStoryMusicInfo.p;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    Object localObject = (QQStoryMusicInfo)paramObject;
    if ((((QQStoryMusicInfo)localObject).k == 0) && (this.k == 0)) {
      return true;
    }
    if ((((QQStoryMusicInfo)localObject).k == 1) && (this.k == 1)) {
      return true;
    }
    if (((QQStoryMusicInfo)localObject).k == this.k)
    {
      String str = ((QQStoryMusicInfo)localObject).e;
      if ((str != null) && (str.equals(this.e)))
      {
        localObject = ((QQStoryMusicInfo)localObject).g;
        if ((localObject != null) && (((String)localObject).equals(this.g))) {
          return true;
        }
      }
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo
 * JD-Core Version:    0.7.0.1
 */