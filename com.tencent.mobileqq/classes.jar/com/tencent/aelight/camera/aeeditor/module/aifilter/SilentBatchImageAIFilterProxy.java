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
  private List<String> c;
  private List<AEEditorImageInfo> d;
  
  public SilentBatchImageAIFilterProxy(@NonNull List<String> paramList, @NonNull List<AEEditorImageInfo> paramList1)
  {
    if (paramList.size() > 3)
    {
      this.c = paramList.subList(0, 3);
      this.d = paramList1.subList(0, 3);
    }
    else
    {
      this.c = new LinkedList(paramList);
      this.d = new LinkedList(paramList1);
    }
    this.jdField_a_of_type_Int = this.c.size();
  }
  
  private SingleImageAIFilterResult b(AIFilterResponse paramAIFilterResponse)
  {
    SingleImageAIFilterResult localSingleImageAIFilterResult = new SingleImageAIFilterResult();
    ArrayList localArrayList = new ArrayList();
    if (paramAIFilterResponse == null)
    {
      localSingleImageAIFilterResult.jdField_a_of_type_Boolean = true;
      AEQLog.a("SilentBatchImageAIFilterProxy", "[buildImageResult] exception");
      paramAIFilterResponse = localArrayList;
    }
    else
    {
      paramAIFilterResponse = paramAIFilterResponse.jdField_a_of_type_JavaUtilList;
    }
    localSingleImageAIFilterResult.jdField_a_of_type_JavaUtilList = paramAIFilterResponse;
    return localSingleImageAIFilterResult;
  }
  
  protected AIFilterResult a(List<AIFilterResponse> paramList)
  {
    BatchImageAIFilterResult localBatchImageAIFilterResult = new BatchImageAIFilterResult();
    int j = 0;
    int k = 0;
    if ((paramList != null) && (paramList.size() != 0)) {
      if (paramList.size() != this.b.size())
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
      while (i < this.jdField_a_of_type_Int)
      {
        paramList = b(null);
        paramList.jdField_a_of_type_Boolean = true;
        localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(paramList);
        i += 1;
      }
      localBatchImageAIFilterResult.jdField_a_of_type_Boolean = true;
      return localBatchImageAIFilterResult;
    }
    while (j < this.jdField_a_of_type_Int)
    {
      Object localObject = (AIFilterResponse)paramList.get(j);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.b.get(j));
      localObject = b((AIFilterResponse)localObject);
      localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(localObject);
      j += 1;
    }
    return localBatchImageAIFilterResult;
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    ThreadManager.getSubThreadHandler().post(new SilentBatchImageAIFilterProxy.1(this, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SilentBatchImageAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */