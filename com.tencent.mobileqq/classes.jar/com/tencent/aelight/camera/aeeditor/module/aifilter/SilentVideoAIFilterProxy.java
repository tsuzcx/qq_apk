package com.tencent.aelight.camera.aeeditor.module.aifilter;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SilentVideoAIFilterProxy
  extends VideoAIFilterProxy
{
  public SilentVideoAIFilterProxy(TAVCutVideoSession paramTAVCutVideoSession)
  {
    super(paramTAVCutVideoSession);
  }
  
  protected AIFilterResult a(List<AIFilterResponse> paramList)
  {
    VideoAIFilterResult localVideoAIFilterResult = new VideoAIFilterResult();
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    if (paramList != null)
    {
      localObject = localArrayList;
      if (paramList.size() > 0)
      {
        String str = a(paramList);
        paramList = paramList.iterator();
        do
        {
          localObject = localArrayList;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (AIFilterResponse)paramList.next();
        } while (!((AIFilterResponse)localObject).jdField_a_of_type_JavaLangString.equals(str));
        localObject = ((AIFilterResponse)localObject).jdField_a_of_type_JavaUtilList;
      }
    }
    localVideoAIFilterResult.jdField_a_of_type_JavaUtilList = ((List)localObject);
    return localVideoAIFilterResult;
  }
  
  protected List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.a != null) && (this.a.getDuration() != null))
    {
      long l1 = this.a.getDuration().getTimeUs() / 1000L;
      int i = 3000;
      if (l1 > 30000L) {
        i = 6000;
      }
      int j = 0;
      while ((j <= l1 / i) && (j < 3))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SilentVideoAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */