package com.tencent.aelight.camera.aeeditor.module.aifilter;

import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.tav.coremedia.CMTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SilentVideoAIFilterProxy
  extends VideoAIFilterProxy
{
  protected VideoAIFilterResult d = new VideoAIFilterResult();
  AEEditorAIFilterManager.AIFilterObserver e = new SilentVideoAIFilterProxy.1(this);
  private AEEditorAIFilterManager.SilentResultCallBack h;
  
  public SilentVideoAIFilterProxy(TAVCutVideoSession paramTAVCutVideoSession, AEEditorAIFilterManager.SilentResultCallBack paramSilentResultCallBack)
  {
    super(paramTAVCutVideoSession);
    a(this.e);
    this.h = paramSilentResultCallBack;
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
        String str = b(paramList);
        paramList = paramList.iterator();
        do
        {
          localObject = localArrayList;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (AIFilterResponse)paramList.next();
        } while (!((AIFilterResponse)localObject).a.equals(str));
        localObject = ((AIFilterResponse)localObject).b;
      }
    }
    localVideoAIFilterResult.c = ((List)localObject);
    return localVideoAIFilterResult;
  }
  
  public AEEditorAIFilterManager.AIFilterObserver c()
  {
    return this.e;
  }
  
  public VideoAIFilterResult f()
  {
    return this.d;
  }
  
  protected List<Long> g()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.g != null) && (this.g.getDuration() != null))
    {
      long l1 = this.g.getDuration().getTimeUs() / 1000L;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SilentVideoAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */