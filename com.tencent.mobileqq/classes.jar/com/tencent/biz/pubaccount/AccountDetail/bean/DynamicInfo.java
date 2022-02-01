package com.tencent.biz.pubaccount.accountdetail.bean;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicInfo
{
  public String a;
  public String b;
  public String c;
  public MsgAttr d;
  public PictureAttr e;
  public VideoAttr f;
  public boolean g;
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("title")) {
      this.a = paramJSONObject.getString("title");
    }
    if (paramJSONObject.has("video")) {
      this.b = paramJSONObject.getString("video");
    }
    if (paramJSONObject.has("picture")) {
      this.c = paramJSONObject.getString("picture");
    }
    if (paramJSONObject.has("picture_attr")) {
      c(paramJSONObject.getJSONObject("picture_attr"));
    }
    if (paramJSONObject.has("video_attr")) {
      d(paramJSONObject.getJSONObject("video_attr"));
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    this.d = null;
    if (paramJSONObject != null)
    {
      this.d = new MsgAttr();
      if (paramJSONObject.has("articleid")) {
        this.d.a = paramJSONObject.getLong("articleid");
      }
      if (paramJSONObject.has("id")) {
        this.d.b = paramJSONObject.getLong("id");
      }
      if (paramJSONObject.has("jumpurl")) {
        this.d.c = paramJSONObject.getString("jumpurl");
      }
      if (paramJSONObject.has("msgtype")) {
        this.d.d = paramJSONObject.getInt("msgtype");
      }
      if (paramJSONObject.has("tasktype")) {
        this.d.e = paramJSONObject.getInt("tasktype");
      }
      if (paramJSONObject.has("time")) {
        this.d.f = paramJSONObject.getLong("time");
      }
      if (paramJSONObject.has("uniqueid")) {
        this.d.g = paramJSONObject.getLong("uniqueid");
      }
      if (paramJSONObject.has("rowkey")) {
        this.d.h = paramJSONObject.getString("rowkey");
      }
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.e = null;
    if (paramJSONObject != null)
    {
      this.e = new PictureAttr();
      if (paramJSONObject.has("cover")) {
        this.e.a = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("cover_orig")) {
        this.e.c = paramJSONObject.getString("cover_orig");
      }
      if (paramJSONObject.has("large")) {
        this.e.b = paramJSONObject.getInt("large");
      }
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    this.f = null;
    if (paramJSONObject != null)
    {
      this.f = new VideoAttr();
      if (paramJSONObject.has("busitype")) {
        this.f.a = paramJSONObject.getInt("busitype");
      }
      if (paramJSONObject.has("cover")) {
        this.f.b = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("cover_orig")) {
        this.f.i = paramJSONObject.getString("cover_orig");
      }
      if (paramJSONObject.has("fulltime")) {
        this.f.d = paramJSONObject.getInt("fulltime");
      }
      if (paramJSONObject.has("h5url")) {
        this.f.c = paramJSONObject.getString("h5url");
      }
      if (paramJSONObject.has("preheight")) {
        this.f.e = paramJSONObject.getInt("preheight");
      }
      if (paramJSONObject.has("prewidth")) {
        this.f.f = paramJSONObject.getInt("prewidth");
      }
      if (paramJSONObject.has("vid")) {
        this.f.g = paramJSONObject.getString("vid");
      }
      if (paramJSONObject.has("large")) {
        this.f.h = paramJSONObject.getInt("large");
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          localObject = paramString.getJSONObject("msg");
          if (((JSONObject)localObject).has("item"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("item");
            if (localObject == null)
            {
              i = 0;
              break label199;
            }
            int i = ((JSONArray)localObject).length();
            break label199;
            if (j < i)
            {
              JSONArray localJSONArray = ((JSONArray)localObject).getJSONArray(j);
              if (localJSONArray == null)
              {
                k = 0;
                break label204;
              }
              int k = localJSONArray.length();
              break label204;
              if (m >= k) {
                break label210;
              }
              a(localJSONArray.getJSONObject(m));
              m += 1;
              continue;
            }
          }
        }
        if (paramString.has("msg_attr"))
        {
          b(paramString.getJSONObject("msg_attr"));
          return;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("DynamicInfo Exception:");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.d("DynamicInfo", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
      label199:
      int j = 0;
      continue;
      label204:
      int m = 0;
      continue;
      label210:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo
 * JD-Core Version:    0.7.0.1
 */