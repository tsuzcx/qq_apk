package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEPhotoAIResult;
import java.util.HashMap;
import java.util.Map;
import org.light.bean.Texture;
import org.light.callback.ExternalRenderCallback;

class VideoFilterViewPager$2$1
  implements ExternalRenderCallback
{
  VideoFilterViewPager$2$1(VideoFilterViewPager.2 param2) {}
  
  public void onRender(Texture paramTexture1, String paramString1, String paramString2, Texture paramTexture2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRender: external render params：");
    localStringBuilder.append(paramTexture1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramTexture2);
    AEQLog.a("VideoFilterViewPager", localStringBuilder.toString());
    if (VideoFilterViewPager.d(this.a.this$0) != null)
    {
      paramString1 = new AEAdjust();
      paramString1.apply();
      paramString2 = VideoFilterViewPager.d(this.a.this$0).b();
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        paramString1.setAdjustParams((HashMap)paramString2);
        paramString2 = new Frame();
        paramString2.setSizedTexture(paramTexture1.id, paramTexture1.width, paramTexture1.height);
        paramTexture1 = paramString1.render(paramString2);
        paramTexture2.id = paramTexture1.getTextureId();
        paramTexture2.width = paramTexture1.width;
        paramTexture2.height = paramTexture1.height;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.2.1
 * JD-Core Version:    0.7.0.1
 */