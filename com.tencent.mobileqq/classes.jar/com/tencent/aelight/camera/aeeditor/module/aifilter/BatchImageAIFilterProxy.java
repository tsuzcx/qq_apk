package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class BatchImageAIFilterProxy
  extends AIFilterProxyBase
{
  private static final String d = "BatchImageAIFilterProxy";
  private List<String> e;
  private List<AEEditorImageInfo> f;
  private int g;
  private AIFilterResult h;
  
  public BatchImageAIFilterProxy(List<String> paramList, List<AEEditorImageInfo> paramList1, int paramInt, AIFilterResult paramAIFilterResult)
  {
    this.e = paramList;
    this.f = paramList1;
    this.g = paramInt;
    this.h = paramAIFilterResult;
    this.a = (paramList.size() - 1);
  }
  
  protected AIFilterResult a(List<AIFilterResponse> paramList)
  {
    BatchImageAIFilterResult localBatchImageAIFilterResult = new BatchImageAIFilterResult();
    int j = 0;
    int k = 0;
    if ((paramList != null) && (paramList.size() != 0)) {
      if (paramList.size() != this.c.size())
      {
        AEQLog.d(d, "batch image responseList size not match image size");
      }
      else
      {
        i = 0;
        break label66;
      }
    }
    int i = 1;
    label66:
    if (i != 0)
    {
      i = k;
      while (i < this.a)
      {
        paramList = a(null);
        paramList.a = true;
        localBatchImageAIFilterResult.b.add(paramList);
        i += 1;
      }
      localBatchImageAIFilterResult.a = true;
    }
    else
    {
      while (j < this.a)
      {
        Object localObject = (AIFilterResponse)paramList.get(j);
        this.b.clear();
        this.b.add(this.c.get(j));
        localObject = a((AIFilterResponse)localObject);
        localBatchImageAIFilterResult.b.add(localObject);
        j += 1;
      }
    }
    localBatchImageAIFilterResult.b.add(this.g, (SingleImageAIFilterResult)this.h);
    return localBatchImageAIFilterResult;
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    ArrayList localArrayList = new ArrayList(this.e);
    localArrayList.remove(this.g);
    ThreadManager.getSubThreadHandler().post(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */