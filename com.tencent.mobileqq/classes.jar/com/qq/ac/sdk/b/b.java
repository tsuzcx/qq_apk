package com.qq.ac.sdk.b;

import com.qq.ac.sdk.bean.AcChapter;
import com.qq.ac.sdk.bean.AcChapterListResponse;
import com.qq.ac.sdk.listener.AcChapterListListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends a<AcChapterListResponse>
{
  private AcChapterListListener b;
  
  public b(AcChapterListListener paramAcChapterListListener)
  {
    this.b = paramAcChapterListListener;
  }
  
  private static AcChapterListResponse a(String paramString)
  {
    AcChapterListResponse localAcChapterListResponse = new AcChapterListResponse();
    Object localObject = new ArrayList();
    localAcChapterListResponse.setData((List)localObject);
    long l = System.currentTimeMillis();
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      int j = 0;
      int k = paramString.optInt("ret", 0);
      if (k != 2)
      {
        localAcChapterListResponse.setStatusCode(k);
        return localAcChapterListResponse;
      }
      paramString = paramString.getJSONArray("data");
      if ((paramString != null) && (paramString.length() > 0)) {
        for (;;)
        {
          i = k;
          if (j >= paramString.length()) {
            break;
          }
          JSONObject localJSONObject = (JSONObject)paramString.get(j);
          AcChapter localAcChapter = new AcChapter();
          localAcChapter.setChapterId(localJSONObject.getInt("chapter_id"));
          localAcChapter.setTitle(localJSONObject.getString("title"));
          localAcChapter.setSeqNo(localJSONObject.optInt("seq_no"));
          localAcChapter.setPayState(localJSONObject.optInt("pay_state"));
          localAcChapter.setCreateTime(localJSONObject.optInt("create_time"));
          localAcChapter.setModifyTime(localJSONObject.optInt("modify_time"));
          localAcChapter.setPicCount(localJSONObject.optInt("pic_count"));
          ((List)localObject).add(localAcChapter);
          j += 1;
        }
      }
      i = -60004;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      i = -60005;
    }
    localAcChapterListResponse.setStatusCode(i);
    paramString = a;
    localObject = new StringBuilder("onConver time = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - Long.valueOf(l).longValue());
    com.qq.ac.sdk.g.b.a(paramString, ((StringBuilder)localObject).toString());
    return localAcChapterListResponse;
  }
  
  public final void onFailure(int paramInt)
  {
    AcChapterListListener localAcChapterListListener = this.b;
    if (localAcChapterListListener != null) {
      localAcChapterListListener.onFailure(paramInt);
    }
  }
  
  public final void onResponse(String paramString)
  {
    AcChapterListListener localAcChapterListListener = this.b;
    if (localAcChapterListListener != null) {
      localAcChapterListListener.onResponse(a(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */