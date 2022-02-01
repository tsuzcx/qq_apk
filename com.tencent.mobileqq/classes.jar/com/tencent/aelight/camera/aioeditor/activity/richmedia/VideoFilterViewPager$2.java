package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.opengl.GLES20;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class VideoFilterViewPager$2
  implements Runnable
{
  VideoFilterViewPager$2(VideoFilterViewPager paramVideoFilterViewPager, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    VideoFilterViewPager.a(this.this$0, arrayOfInt[0]);
    VideoFilterViewPager.a(this.this$0, new AEFilterManager());
    VideoFilterViewPager.c(this.this$0).supportMultiThreads(true);
    VideoFilterViewPager.c(this.this$0).initInGL(this.a, this.b);
    VideoFilterViewPager.c(this.this$0).defineFiltersAndOrder(new int[] { 300, 100 });
    VideoFilterViewPager.c(this.this$0).setFilterInSmooth(true);
    VideoFilterViewPager.c(this.this$0).setSyncMode(true);
    VideoFilterViewPager.c(this.this$0).updateMaterialGL(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
    VideoFilterViewPager.c(this.this$0).setExternalRenderCallback(new VideoFilterViewPager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.2
 * JD-Core Version:    0.7.0.1
 */