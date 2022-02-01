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
  private static final String jdField_a_of_type_JavaLangString = "BatchImageAIFilterProxy";
  private AIFilterResult jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterResult;
  private int b;
  private List<String> c;
  private List<AEEditorImageInfo> d;
  
  public BatchImageAIFilterProxy(List<String> paramList, List<AEEditorImageInfo> paramList1, int paramInt, AIFilterResult paramAIFilterResult)
  {
    this.c = paramList;
    this.d = paramList1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterResult = paramAIFilterResult;
    this.jdField_a_of_type_Int = (paramList.size() - 1);
  }
  
  protected AIFilterResult a(List<AIFilterResponse> paramList)
  {
    BatchImageAIFilterResult localBatchImageAIFilterResult = new BatchImageAIFilterResult();
    int j = 0;
    int k = 0;
    if ((paramList != null) && (paramList.size() != 0)) {
      if (paramList.size() != this.jdField_b_of_type_JavaUtilList.size())
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, "batch image responseList size not match image size");
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
      while (i < this.jdField_a_of_type_Int)
      {
        paramList = a(null);
        paramList.jdField_a_of_type_Boolean = true;
        localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(paramList);
        i += 1;
      }
      localBatchImageAIFilterResult.jdField_a_of_type_Boolean = true;
    }
    else
    {
      while (j < this.jdField_a_of_type_Int)
      {
        Object localObject = (AIFilterResponse)paramList.get(j);
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(j));
        localObject = a((AIFilterResponse)localObject);
        localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(localObject);
        j += 1;
      }
    }
    localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, (SingleImageAIFilterResult)this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterResult);
    return localBatchImageAIFilterResult;
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    localArrayList.remove(this.jdField_b_of_type_Int);
    ThreadManager.getSubThreadHandler().post(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */