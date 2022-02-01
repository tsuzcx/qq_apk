package com.qq.ac.sdk.c;

import android.util.SparseArray;
import com.qq.ac.sdk.b.c;
import com.qq.ac.sdk.b.d;
import com.qq.ac.sdk.bean.BaseResponse;
import com.qq.ac.sdk.listener.AcChapterListListener;
import com.qq.ac.sdk.listener.AcMultiPictureListListener;
import com.qq.ac.sdk.listener.AcPictureListListener;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends b
{
  public a()
  {
    super(0);
  }
  
  private static JSONArray a(List<String> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put((String)paramList.next());
    }
    return localJSONArray;
  }
  
  public final void a(AcChapterListListener paramAcChapterListListener)
  {
    SparseArray localSparseArray = this.a;
    int i = this.b + 1;
    this.b = i;
    localSparseArray.put(i, new com.qq.ac.sdk.b.b(paramAcChapterListListener));
  }
  
  public final void a(AcMultiPictureListListener paramAcMultiPictureListListener)
  {
    SparseArray localSparseArray = this.a;
    int i = this.b + 1;
    this.b = i;
    localSparseArray.put(i, new c(paramAcMultiPictureListListener));
  }
  
  public final void a(AcPictureListListener paramAcPictureListListener)
  {
    SparseArray localSparseArray = this.a;
    int i = this.b + 1;
    this.b = i;
    localSparseArray.put(i, new d(paramAcPictureListListener));
  }
  
  public final void a(String paramString)
  {
    JSONObject localJSONObject = a(101);
    try
    {
      localJSONObject.put("comic_id", Integer.valueOf(paramString));
      label17:
      a(localJSONObject.toString(), 101);
      return;
    }
    catch (JSONException paramString)
    {
      break label17;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = a(103);
    try
    {
      localJSONObject.put("comic_id", Integer.valueOf(paramString1));
      localJSONObject.put("chapter_id", Integer.valueOf(paramString2));
      label28:
      a(localJSONObject.toString(), 103);
      return;
    }
    catch (JSONException paramString1)
    {
      break label28;
    }
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    JSONObject localJSONObject = a(104);
    try
    {
      localJSONObject.put("comic_id", Integer.valueOf(paramString));
      localJSONObject.put("chapter_ids", a(paramList));
      label28:
      a(localJSONObject.toString(), 104);
      com.qq.ac.sdk.d.a.a(paramString, paramList);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label28;
    }
  }
  
  public final BaseResponse b(String paramString)
  {
    JSONObject localJSONObject = a(101);
    try
    {
      localJSONObject.put("comic_id", Integer.valueOf(paramString));
      label17:
      return a(localJSONObject.toString(), 101, new com.qq.ac.sdk.b.b(null));
    }
    catch (JSONException paramString)
    {
      break label17;
    }
  }
  
  public final BaseResponse b(String paramString, List<String> paramList)
  {
    Object localObject = a(104);
    try
    {
      ((JSONObject)localObject).put("comic_id", Integer.valueOf(paramString));
      ((JSONObject)localObject).put("chapter_ids", a(paramList));
      label28:
      localObject = ((JSONObject)localObject).toString();
      com.qq.ac.sdk.d.a.a(paramString, paramList);
      return a((String)localObject, 104, new c(null));
    }
    catch (JSONException localJSONException)
    {
      break label28;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = a(102);
    try
    {
      localJSONObject.put("comic_id", Integer.valueOf(paramString1));
      localJSONObject.put("chapter_id", Integer.valueOf(paramString2));
      label28:
      a(localJSONObject.toString(), 102);
      com.qq.ac.sdk.d.a.a(paramString1, paramString2);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label28;
    }
  }
  
  public final BaseResponse c(String paramString1, String paramString2)
  {
    Object localObject = a(102);
    try
    {
      ((JSONObject)localObject).put("comic_id", Integer.valueOf(paramString1));
      ((JSONObject)localObject).put("chapter_id", Integer.valueOf(paramString2));
      label28:
      localObject = ((JSONObject)localObject).toString();
      com.qq.ac.sdk.d.a.a(paramString1, paramString2);
      return a((String)localObject, 102, new d(null));
    }
    catch (JSONException localJSONException)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.ac.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */