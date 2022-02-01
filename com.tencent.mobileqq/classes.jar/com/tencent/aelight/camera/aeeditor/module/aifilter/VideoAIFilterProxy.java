package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import android.util.Log;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResponse;>;
import mqq.os.MqqHandler;

public class VideoAIFilterProxy
  extends AIFilterProxyBase
{
  private static final String a = "VideoAIFilterProxy";
  protected TAVCutVideoSession a;
  protected final int b = 250;
  
  public VideoAIFilterProxy(TAVCutVideoSession paramTAVCutVideoSession)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = paramTAVCutVideoSession;
  }
  
  protected AIFilterResult a(List<AIFilterResponse> paramList)
  {
    VideoAIFilterResult localVideoAIFilterResult = new VideoAIFilterResult();
    if (a(this.jdField_a_of_type_JavaUtilList)) {
      try
      {
        localVideoAIFilterResult.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData = PhotoAIFilter.preprocessImages(this.jdField_a_of_type_JavaUtilList);
      }
      catch (Exception localException)
      {
        AEQLog.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(localException));
      }
    }
    localVideoAIFilterResult.jdField_a_of_type_ArrayOfFloat = AEEditorAIFilterManager.a(localVideoAIFilterResult.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
    localVideoAIFilterResult.jdField_a_of_type_JavaUtilHashMap = AEEditorAIFilterManager.a(localVideoAIFilterResult.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
    Object localObject2 = new ArrayList();
    Object localObject4;
    Object localObject1;
    if ((paramList != null) && (paramList.size() != 0))
    {
      localObject3 = a(paramList);
      localObject4 = paramList.iterator();
      do
      {
        paramList = (List<AIFilterResponse>)localObject2;
        localObject1 = localObject3;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        paramList = (AIFilterResponse)((Iterator)localObject4).next();
      } while (!paramList.jdField_a_of_type_JavaLangString.equals(localObject3));
      paramList = paramList.jdField_a_of_type_JavaUtilList;
      localObject1 = localObject3;
    }
    else
    {
      localObject1 = NewEnhanceCategories.COMMON.serverLabel;
      paramList = (List<AIFilterResponse>)localObject2;
    }
    localObject2 = jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sceneLabel: ");
    ((StringBuilder)localObject3).append((String)localObject1);
    AEQLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (YoutuResultItem)((Iterator)localObject2).next();
      localObject4 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("label: ");
      localStringBuilder.append(((YoutuResultItem)localObject3).Label);
      localStringBuilder.append(", confidence: ");
      localStringBuilder.append(((YoutuResultItem)localObject3).Confidence);
      AEQLog.b((String)localObject4, localStringBuilder.toString());
    }
    localVideoAIFilterResult.jdField_a_of_type_JavaLangString = ((String)localObject1);
    localVideoAIFilterResult.jdField_a_of_type_JavaUtilList = paramList;
    localVideoAIFilterResult.b = b(localVideoAIFilterResult.jdField_a_of_type_JavaLangString);
    return localVideoAIFilterResult;
  }
  
  protected List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if ((localTAVCutVideoSession != null) && (localTAVCutVideoSession.getDuration() != null))
    {
      long l1 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L;
      int i = 3000;
      if (l1 > 30000L) {
        i = 6000;
      }
      int j = 0;
      while ((j <= l1 / i) && (j < 10))
      {
        long l2 = j * i;
        if (l2 < l1) {
          localArrayList.add(Long.valueOf(l2));
        }
        j += 1;
      }
    }
    return localArrayList;
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    List localList = a();
    ThreadManager.getSubThreadHandler().post(new VideoAIFilterProxy.1(this, localList, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.VideoAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */