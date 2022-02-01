package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class SilentBatchImageAIFilterProxy
  extends AIFilterProxyBase
{
  AEEditorAIFilterManager.AIFilterObserver d = new SilentBatchImageAIFilterProxy.1(this);
  private List<String> e;
  private List<AEEditorImageInfo> f;
  private BatchImageAIFilterResult g = new BatchImageAIFilterResult();
  private AEEditorAIFilterManager.SilentResultCallBack h;
  
  public SilentBatchImageAIFilterProxy(@NonNull List<String> paramList, @NonNull List<AEEditorImageInfo> paramList1, AEEditorAIFilterManager.SilentResultCallBack paramSilentResultCallBack)
  {
    if (paramList.size() > 3)
    {
      this.e = paramList.subList(0, 3);
      this.f = paramList1.subList(0, 3);
    }
    else
    {
      this.e = new LinkedList(paramList);
      this.f = new LinkedList(paramList1);
    }
    this.h = paramSilentResultCallBack;
    this.a = this.e.size();
    a(this.d);
  }
  
  private SingleImageAIFilterResult b(AIFilterResponse paramAIFilterResponse)
  {
    SingleImageAIFilterResult localSingleImageAIFilterResult = new SingleImageAIFilterResult();
    ArrayList localArrayList = new ArrayList();
    if (paramAIFilterResponse == null)
    {
      localSingleImageAIFilterResult.a = true;
      AEQLog.a("SilentBatchImageAIFilterProxy", "[buildImageResult] exception");
      paramAIFilterResponse = localArrayList;
    }
    else
    {
      paramAIFilterResponse = paramAIFilterResponse.b;
    }
    localSingleImageAIFilterResult.c = paramAIFilterResponse;
    return localSingleImageAIFilterResult;
  }
  
  protected AIFilterResult a(List<AIFilterResponse> paramList)
  {
    BatchImageAIFilterResult localBatchImageAIFilterResult = new BatchImageAIFilterResult();
    int j = 0;
    int k = 0;
    if ((paramList != null) && (paramList.size() != 0)) {
      if (paramList.size() != this.c.size())
      {
        AEQLog.d("SilentBatchImageAIFilterProxy", "batch image responseList size not match image size");
      }
      else
      {
        i = 0;
        break label65;
      }
    }
    int i = 1;
    label65:
    if (i != 0)
    {
      i = k;
      while (i < this.a)
      {
        paramList = b(null);
        paramList.a = true;
        localBatchImageAIFilterResult.b.add(paramList);
        i += 1;
      }
      localBatchImageAIFilterResult.a = true;
      return localBatchImageAIFilterResult;
    }
    while (j < this.a)
    {
      Object localObject = (AIFilterResponse)paramList.get(j);
      this.b.clear();
      this.b.add(this.c.get(j));
      localObject = b((AIFilterResponse)localObject);
      localBatchImageAIFilterResult.b.add(localObject);
      j += 1;
    }
    return localBatchImageAIFilterResult;
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    ThreadManager.getSubThreadHandler().post(new SilentBatchImageAIFilterProxy.2(this, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return false;
  }
  
  public AEEditorAIFilterManager.AIFilterObserver c()
  {
    return this.d;
  }
  
  public BatchImageAIFilterResult f()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SilentBatchImageAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */