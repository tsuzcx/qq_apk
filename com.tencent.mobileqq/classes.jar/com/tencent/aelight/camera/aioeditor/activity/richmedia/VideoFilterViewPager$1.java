package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.opengl.GLES20;
import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class VideoFilterViewPager$1
  implements Runnable
{
  VideoFilterViewPager$1(VideoFilterViewPager paramVideoFilterViewPager, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    VideoFilterViewPager.a(this.this$0, arrayOfInt[0]);
    VideoFilterViewPager.a(this.this$0, new AEFilterManager());
    VideoFilterViewPager.a(this.this$0).supportMultiThreads(true);
    VideoFilterViewPager.a(this.this$0).initInGL(this.a, this.b);
    VideoFilterViewPager.a(this.this$0).defineFiltersAndOrder(new int[] { 300, 100 });
    VideoFilterViewPager.a(this.this$0).setFilterInSmooth(true);
    VideoFilterViewPager.a(this.this$0).setSyncMode(true);
    VideoFilterViewPager.a(this.this$0).updateMaterialGL(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
    VideoFilterViewPager.a(this.this$0).setExternalRenderCallback(new VideoFilterViewPager.1.1(this));
    VideoFilterViewPager.a(this.this$0, new AEAdjust());
    VideoFilterViewPager.a(this.this$0).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.1
 * JD-Core Version:    0.7.0.1
 */