package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import java.util.List;
import mqq.os.MqqHandler;

public class MultiVideoAIFilterProxy
  extends VideoAIFilterProxy
{
  private static final String d = "MultiVideoAIFilterProxy";
  
  public MultiVideoAIFilterProxy(TAVCutVideoSession paramTAVCutVideoSession)
  {
    super(paramTAVCutVideoSession);
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    List localList = g();
    ThreadManager.getSubThreadHandler().post(new MultiVideoAIFilterProxy.1(this, localList, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.MultiVideoAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */