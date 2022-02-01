package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class SingleImageAIFilterProxy
  extends AIFilterProxyBase
{
  private static final String a = "SingleImageAIFilterProxy";
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<AEEditorImageInfo> c;
  
  public SingleImageAIFilterProxy(String paramString, List<AEEditorImageInfo> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramList;
  }
  
  public AIFilterResult a(List<AIFilterResponse> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramList.size() > 1) {
        AEQLog.d(jdField_a_of_type_JavaLangString, "single image but responseList != 1");
      }
      paramList = (AIFilterResponse)paramList.get(0);
    }
    else
    {
      paramList = null;
    }
    return a(paramList);
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 1;
    ThreadManager.getSubThreadHandler().post(new SingleImageAIFilterProxy.1(this, localArrayList, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SingleImageAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */