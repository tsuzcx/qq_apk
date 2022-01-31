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
    ArrayList localArrayList = new ArrayList();
    localAcChapterListResponse.setData(localArrayList);
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int j = paramString.optInt("ret", 0);
        if (j != 2)
        {
          localAcChapterListResponse.setStatusCode(j);
          return localAcChapterListResponse;
        }
        paramString = paramString.getJSONArray("data");
        if ((paramString == null) || (paramString.length() <= 0)) {
          continue;
        }
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          AcChapter localAcChapter = new AcChapter();
          localAcChapter.setChapterId(localJSONObject.getInt("chapter_id"));
          localAcChapter.setTitle(localJSONObject.getString("title"));
          localAcChapter.setSeqNo(localJSONObject.optInt("seq_no"));
          localAcChapter.setPayState(localJSONObject.optInt("pay_state"));
          localAcChapter.setCreateTime(localJSONObject.optInt("create_time"));
          localAcChapter.setModifyTime(localJSONObject.optInt("modify_time"));
          localAcChapter.setPicCount(localJSONObject.optInt("pic_count"));
          localArrayList.add(localAcChapter);
          i += 1;
          continue;
        }
        i = j;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        int i = -60005;
        continue;
      }
      localAcChapterListResponse.setStatusCode(i);
      com.qq.ac.sdk.g.b.a(a, "onConver time = " + (System.currentTimeMillis() - Long.valueOf(l).longValue()));
      return localAcChapterListResponse;
      i = -60004;
    }
  }
  
  public final void onFailure(int paramInt)
  {
    if (this.b != null) {
      this.b.onFailure(paramInt);
    }
  }
  
  public final void onResponse(String paramString)
  {
    if (this.b != null) {
      this.b.onResponse(a(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.ac.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */