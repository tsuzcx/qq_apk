package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentRptData;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.HerfData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RptData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.TextData;

public final class CreateCommentResult
{
  public int a;
  public long a;
  public String a;
  public List<BaseCommentData.CommentRptData> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public String d;
  
  @Nullable
  private static BaseCommentData.CommentRptData a(oidb_0xd1e.RptData paramRptData)
  {
    if (paramRptData.text_data.has())
    {
      paramRptData = (oidb_0xd1e.TextData)paramRptData.text_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.jdField_a_of_type_Int = 0;
        localCommentRptData.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.content, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private static void a(oidb_0xd1e.RptData paramRptData, List<BaseCommentData.CommentRptData> paramList)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (RIJPBFieldUtils.a(paramRptData.data_type, 0))
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        paramList.add(localObject1);
      }
      return;
      localObject1 = a(paramRptData);
      continue;
      localObject1 = b(paramRptData);
    }
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData b(oidb_0xd1e.RptData paramRptData)
  {
    if (paramRptData.herf_data.has())
    {
      paramRptData = (oidb_0xd1e.HerfData)paramRptData.herf_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.jdField_a_of_type_Int = 3;
        localCommentRptData.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.b = RIJPBFieldUtils.a(paramRptData.url, "");
        localCommentRptData.c = RIJPBFieldUtils.a(paramRptData.topic_id, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  public void a(Collection<oidb_0xd1e.RptData> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (;;)
    {
      return;
      this.a = new ArrayList(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        oidb_0xd1e.RptData localRptData = (oidb_0xd1e.RptData)paramCollection.next();
        if (localRptData != null) {
          a(localRptData, this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.CreateCommentResult
 * JD-Core Version:    0.7.0.1
 */