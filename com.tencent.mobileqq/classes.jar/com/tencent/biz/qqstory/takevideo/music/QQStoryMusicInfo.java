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
  public static final QQStoryMusicInfo a;
  public static final QQStoryMusicInfo b;
  public static final QQStoryMusicInfo c;
  int a;
  public String a;
  public int b;
  public String b;
  public int c;
  String c;
  public int d;
  public String d;
  public int e;
  String e;
  public int f;
  String f;
  public String g = null;
  
  static
  {
    jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = new QQStoryMusicInfo(0, HardCodeUtil.a(2131710889));
    jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = new QQStoryMusicInfo(1, HardCodeUtil.a(2131710886));
    jdField_c_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = new QQStoryMusicInfo(2, "QQ音乐曲库");
  }
  
  public QQStoryMusicInfo()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
  }
  
  public QQStoryMusicInfo(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public QQStoryMusicInfo(qqstory_struct.MusicConfigInfo paramMusicConfigInfo)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = paramMusicConfigInfo.title.get().toStringUtf8();
    this.jdField_d_of_type_JavaLangString = paramMusicConfigInfo.audio_url.get().toStringUtf8();
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramMusicConfigInfo.id.get());
  }
  
  public QQStoryMusicInfo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_b_of_type_JavaLangString = paramString.optString("title");
      this.jdField_d_of_type_JavaLangString = paramString.optString("audio_url");
      if (paramString.has("type")) {
        this.jdField_b_of_type_Int = paramString.optInt("type");
      } else {
        this.jdField_b_of_type_Int = 2;
      }
      this.jdField_a_of_type_JavaLangString = paramString.optString("id");
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
      int j = localJSONArray.length();
      paramContext = new ArrayList(j);
      int i = 0;
      for (;;)
      {
        localContext = paramContext;
        if (i >= j) {
          return localContext;
        }
        try
        {
          paramContext.add(new QQStoryMusicInfo(localJSONArray.optString(i)));
          i += 1;
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
      int j = paramArrayList.size();
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(((QQStoryMusicInfo)paramArrayList.get(i)).a());
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
    }
    else
    {
      paramArrayList = null;
    }
    if (TextUtils.isEmpty(paramArrayList))
    {
      SharePreferenceUtils.a(paramContext, "qqstory_savedMusicList");
      return;
    }
    SharePreferenceUtils.a(paramContext, "qqstory_savedMusicList", paramArrayList);
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("audio_url", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("type", 3);
      localJSONObject.put("id", this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_JavaLangString = paramQQStoryMusicInfo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramQQStoryMusicInfo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramQQStoryMusicInfo.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramQQStoryMusicInfo.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_JavaLangString = paramQQStoryMusicInfo.jdField_e_of_type_JavaLangString;
    this.jdField_f_of_type_JavaLangString = paramQQStoryMusicInfo.jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramQQStoryMusicInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramQQStoryMusicInfo.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramQQStoryMusicInfo.jdField_c_of_type_Int;
    this.g = paramQQStoryMusicInfo.g;
    this.jdField_d_of_type_Int = paramQQStoryMusicInfo.jdField_d_of_type_Int;
    this.jdField_e_of_type_Int = paramQQStoryMusicInfo.jdField_e_of_type_Int;
    this.jdField_f_of_type_Int = paramQQStoryMusicInfo.jdField_f_of_type_Int;
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
    if ((((QQStoryMusicInfo)localObject).jdField_b_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0)) {
      return true;
    }
    if ((((QQStoryMusicInfo)localObject).jdField_b_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1)) {
      return true;
    }
    if (((QQStoryMusicInfo)localObject).jdField_b_of_type_Int == this.jdField_b_of_type_Int)
    {
      String str = ((QQStoryMusicInfo)localObject).jdField_b_of_type_JavaLangString;
      if ((str != null) && (str.equals(this.jdField_b_of_type_JavaLangString)))
      {
        localObject = ((QQStoryMusicInfo)localObject).jdField_d_of_type_JavaLangString;
        if ((localObject != null) && (((String)localObject).equals(this.jdField_d_of_type_JavaLangString))) {
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