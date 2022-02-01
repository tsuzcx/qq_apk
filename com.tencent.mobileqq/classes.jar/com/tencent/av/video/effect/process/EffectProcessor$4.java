package com.tencent.av.video.effect.process;

import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.Beauty25Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.av.video.effect.utils.TextureDataLoader;

class EffectProcessor$4
  implements Runnable
{
  EffectProcessor$4(EffectProcessor paramEffectProcessor, EffectFrame paramEffectFrame) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Log.d("EffectProcessor", "process data size = " + this.val$inFrame.frameData.length + " | width = " + this.val$inFrame.frameWidth + " | height = " + this.val$inFrame.frameHeight + " | format = " + this.val$inFrame.frameFormat + " | LowLightRender = " + EffectProcessor.access$200(this.this$0) + " | BeautyRender = " + EffectProcessor.access$300(this.this$0) + " | FilterRender = " + EffectProcessor.access$400(this.this$0) + " | Beauty20Render = " + EffectProcessor.access$500(this.this$0) + " | Beauty25Render = " + EffectProcessor.access$600(this.this$0) + " | DenoiseRender = " + EffectProcessor.access$700(this.this$0));
        localObject1 = new EffectFrame();
        ((EffectFrame)localObject1).frameData = this.val$inFrame.frameData;
        ((EffectFrame)localObject1).frameWidth = this.val$inFrame.frameWidth;
        ((EffectFrame)localObject1).frameHeight = this.val$inFrame.frameHeight;
        ((EffectFrame)localObject1).frameFormat = this.val$inFrame.frameFormat;
        if ((EffectProcessor.access$400(this.this$0) == null) || (EffectProcessor.access$400(this.this$0).getFilterType() != 3)) {
          break label915;
        }
        i = 1;
        if (EffectProcessor.access$400(this.this$0) == null) {
          break label920;
        }
        if (EffectProcessor.access$400(this.this$0).getFilterType() == 1) {
          continue;
        }
        if (EffectProcessor.access$400(this.this$0).getFilterType() != 2) {
          break label920;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        EffectFrame localEffectFrame;
        if (EffectProcessor.access$900(this.this$0) == null) {
          break label914;
        }
        EffectProcessor.access$900(this.this$0).onComplete(this.val$inFrame);
        EffectProcessor.access$900(this.this$0).onError(this.val$inFrame, 1, localException.getMessage());
        return;
        boolean bool = false;
        continue;
        continue;
        continue;
        j = 1;
        continue;
      }
      EffectProcessor.access$802(this.this$0, LowLightUtils.DetectLowLight(((EffectFrame)localObject1).frameData, 20, ((EffectFrame)localObject1).frameWidth, ((EffectFrame)localObject1).frameHeight, 60, 1.0F));
      if ((EffectProcessor.access$500(this.this$0) != null) && (i == 0))
      {
        localObject1 = EffectProcessor.access$500(this.this$0).processData((EffectFrame)localObject1);
        if ((EffectProcessor.access$600(this.this$0) != null) && (i == 0))
        {
          localObject1 = EffectProcessor.access$600(this.this$0).processData((EffectFrame)localObject1);
          if ((EffectProcessor.access$200(this.this$0) == null) && (EffectProcessor.access$300(this.this$0) == null) && (EffectProcessor.access$400(this.this$0) == null) && (EffectProcessor.access$700(this.this$0) == null))
          {
            if (EffectProcessor.access$900(this.this$0) == null) {
              break label914;
            }
            EffectProcessor.access$900(this.this$0).onComplete((EffectFrame)localObject1);
            return;
          }
          localObject1 = EffectProcessor.access$000(this.this$0).loadDataToTexture(((EffectFrame)localObject1).frameData, ((EffectFrame)localObject1).frameFormat, ((EffectFrame)localObject1).frameWidth, ((EffectFrame)localObject1).frameHeight, EffectProcessor.access$1000(this.this$0));
          EffectProcessor.access$1002(this.this$0, ((EffectTexture)localObject1).getTextureId());
          localObject2 = localObject1;
          if (EffectProcessor.access$700(this.this$0) != null)
          {
            localObject2 = localObject1;
            if (EffectProcessor.access$800(this.this$0)[0] == 1) {
              localObject2 = EffectProcessor.access$700(this.this$0).process(((EffectTexture)localObject1).getTextureId(), ((EffectTexture)localObject1).getFbo(), ((EffectTexture)localObject1).getWidth(), ((EffectTexture)localObject1).getHeight());
            }
          }
          localObject1 = localObject2;
          if (EffectProcessor.access$200(this.this$0) != null)
          {
            localObject1 = localObject2;
            if (EffectProcessor.access$800(this.this$0)[0] == 1) {
              localObject1 = EffectProcessor.access$200(this.this$0).process(((EffectTexture)localObject2).getTextureId(), ((EffectTexture)localObject2).getFbo(), ((EffectTexture)localObject2).getWidth(), ((EffectTexture)localObject2).getHeight());
            }
          }
          localObject2 = localObject1;
          if (EffectProcessor.access$300(this.this$0) != null)
          {
            localObject2 = localObject1;
            if (i == 0)
            {
              localObject2 = EffectProcessor.access$300(this.this$0);
              if (j != 0) {
                continue;
              }
              bool = true;
              ((BeautyRender)localObject2).setNeedSkinColor(bool);
              localObject2 = EffectProcessor.access$300(this.this$0).process(((EffectTexture)localObject1).getTextureId(), ((EffectTexture)localObject1).getFbo(), ((EffectTexture)localObject1).getWidth(), ((EffectTexture)localObject1).getHeight());
            }
          }
          localObject1 = localObject2;
          if (EffectProcessor.access$400(this.this$0) != null) {
            localObject1 = EffectProcessor.access$400(this.this$0).process(((EffectTexture)localObject2).getTextureId(), ((EffectTexture)localObject2).getFbo(), ((EffectTexture)localObject2).getWidth(), ((EffectTexture)localObject2).getHeight());
          }
          localObject2 = new byte[((EffectTexture)localObject1).getWidth() * ((EffectTexture)localObject1).getHeight() * 4];
          CommonUtils.saveTextureToRgbaBuffer(((EffectTexture)localObject1).getFbo(), ((EffectTexture)localObject1).getWidth(), ((EffectTexture)localObject1).getHeight(), (byte[])localObject2);
          localEffectFrame = new EffectFrame();
          localEffectFrame.frameData = ((byte[])localObject2);
          localEffectFrame.frameWidth = ((EffectTexture)localObject1).getWidth();
          localEffectFrame.frameHeight = ((EffectTexture)localObject1).getHeight();
          localEffectFrame.frameFormat = ColorFormat.RGBA;
          if (EffectProcessor.access$900(this.this$0) == null) {
            break label914;
          }
          EffectProcessor.access$900(this.this$0).onComplete(localEffectFrame);
          return;
        }
      }
      label914:
      return;
      label915:
      int i = 0;
      continue;
      label920:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.process.EffectProcessor.4
 * JD-Core Version:    0.7.0.1
 */