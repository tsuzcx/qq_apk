package com.tencent.aelight.camera.ae.biz.circle.part;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.aelight.camera.ae.biz.circle.adapter.RecomAutoTemplateAdapter.RecomAutoTemplateData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class AECircleRecomAutoTemplatePart$6
  implements Runnable
{
  AECircleRecomAutoTemplatePart$6(AECircleRecomAutoTemplatePart paramAECircleRecomAutoTemplatePart, List paramList) {}
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (RecomAutoTemplateAdapter.RecomAutoTemplateData)((Iterator)localObject1).next();
      RecomAutoTemplateAdapter.RecomAutoTemplateData localRecomAutoTemplateData = new RecomAutoTemplateAdapter.RecomAutoTemplateData();
      localRecomAutoTemplateData.f = ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject2).f;
      localRecomAutoTemplateData.c = ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject2).c;
      localRecomAutoTemplateData.b = ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject2).b;
      localObject2 = AECircleRecomAutoTemplatePart.a(this.this$0, ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject2).a);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
      {
        localRecomAutoTemplateData.d = ((ArrayList)localObject2);
        localRecomAutoTemplateData.e = MediaStore.Images.Thumbnails.getThumbnail(this.this$0.h().getContentResolver(), ((LocalMediaInfo)((ArrayList)localObject2).get(0))._id, 1, null);
        localArrayList.add(localRecomAutoTemplateData);
      }
      else
      {
        AEQLog.b("AECircleRecomAutoTemplatePart", "initRecomAutoTemplateData pic size = 0");
      }
    }
    if (localArrayList.size() == 0)
    {
      AEQLog.b("AECircleRecomAutoTemplatePart", "initRecomAutoTemplateData data size = 0");
      ThreadManager.getUIHandler().post(new AECircleRecomAutoTemplatePart.6.1(this));
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("initRecomAutoTemplateData data size = ");
    ((StringBuilder)localObject1).append(localArrayList.size());
    AEQLog.b("AECircleRecomAutoTemplatePart", ((StringBuilder)localObject1).toString());
    ThreadManager.getUIHandler().post(new AECircleRecomAutoTemplatePart.6.2(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart.6
 * JD-Core Version:    0.7.0.1
 */