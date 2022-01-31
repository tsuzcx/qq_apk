package com.tencent.av.video.effect.process;

import android.opengl.GLES20;
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

public class EffectProcessor
{
  public static final int PROCESS_ERR_FAIL = 1;
  private static final String TAG = "EffectProcessor";
  private int[] lowlightinfo = new int[2];
  private Beauty20Render mBeauty20Render;
  private Beauty25Render mBeauty25Render;
  private BeautyRender mBeautyRender;
  private int mDataLoaderTextureId = -1;
  private DenoiseRender mDenoiseRender;
  private FilterRender mFilterRender;
  private LowLightRender mLowLightRender;
  private OffscreenGLContext mOffscreenGLContext = new OffscreenGLContext();
  private int mPicTextureId = -1;
  private ProcessCallback mProcessCallback;
  private BeautyRender mTempBeautyRender;
  private TextureDataLoader mTextureDataLoader;
  
  public EffectProcessor()
  {
    this.mOffscreenGLContext.post(new Runnable()
    {
      public void run()
      {
        EffectProcessor.access$002(EffectProcessor.this, new TextureDataLoader());
      }
    });
  }
  
  public void destroy()
  {
    this.mOffscreenGLContext.post(new Runnable()
    {
      public void run()
      {
        if (EffectProcessor.this.mTextureDataLoader != null)
        {
          EffectProcessor.this.mTextureDataLoader.destroy();
          EffectProcessor.access$002(EffectProcessor.this, null);
        }
        if (EffectProcessor.this.mLowLightRender != null)
        {
          EffectProcessor.this.mLowLightRender.destroy();
          EffectProcessor.access$202(EffectProcessor.this, null);
        }
        if (EffectProcessor.this.mBeautyRender != null)
        {
          EffectProcessor.this.mBeautyRender.destroy();
          EffectProcessor.access$302(EffectProcessor.this, null);
        }
        if (EffectProcessor.this.mFilterRender != null)
        {
          EffectProcessor.this.mFilterRender.destroy();
          EffectProcessor.access$402(EffectProcessor.this, null);
        }
        if (EffectProcessor.this.mBeauty20Render != null)
        {
          EffectProcessor.this.mBeauty20Render.destroy();
          EffectProcessor.access$502(EffectProcessor.this, null);
        }
        if (EffectProcessor.this.mBeauty25Render != null)
        {
          EffectProcessor.this.mBeauty25Render.destroy();
          EffectProcessor.access$602(EffectProcessor.this, null);
        }
        if (EffectProcessor.this.mDenoiseRender != null)
        {
          EffectProcessor.this.mDenoiseRender.destroy();
          EffectProcessor.access$702(EffectProcessor.this, null);
        }
        if (EffectProcessor.this.mTempBeautyRender != null)
        {
          EffectProcessor.this.mTempBeautyRender.destroy();
          EffectProcessor.access$102(EffectProcessor.this, null);
        }
        EffectProcessor.access$902(EffectProcessor.this, null);
        if (EffectProcessor.this.mDataLoaderTextureId != -1)
        {
          GLES20.glDeleteTextures(1, new int[] { EffectProcessor.this.mDataLoaderTextureId }, 0);
          EffectProcessor.access$1002(EffectProcessor.this, -1);
        }
        if (EffectProcessor.this.mOffscreenGLContext != null)
        {
          EffectProcessor.this.mOffscreenGLContext.destroy();
          EffectProcessor.access$1102(EffectProcessor.this, null);
        }
      }
    });
  }
  
  public void process(final EffectFrame paramEffectFrame)
  {
    if (this.mOffscreenGLContext == null) {
      if (this.mProcessCallback != null)
      {
        this.mProcessCallback.onComplete(paramEffectFrame);
        this.mProcessCallback.onError(paramEffectFrame, 1, "no opengl context!");
      }
    }
    do
    {
      return;
      if ((paramEffectFrame != null) && (paramEffectFrame.frameData != null) && (paramEffectFrame.frameData.length != 0) && (paramEffectFrame.frameWidth != 0) && (paramEffectFrame.frameHeight != 0) && (paramEffectFrame.frameFormat != null)) {
        break;
      }
    } while (this.mProcessCallback == null);
    this.mProcessCallback.onComplete(paramEffectFrame);
    this.mProcessCallback.onError(paramEffectFrame, 1, "invalid input frame!");
    return;
    this.mOffscreenGLContext.post(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          try
          {
            Log.d("EffectProcessor", "process data size = " + paramEffectFrame.frameData.length + " | width = " + paramEffectFrame.frameWidth + " | height = " + paramEffectFrame.frameHeight + " | format = " + paramEffectFrame.frameFormat + " | LowLightRender = " + EffectProcessor.this.mLowLightRender + " | BeautyRender = " + EffectProcessor.this.mBeautyRender + " | FilterRender = " + EffectProcessor.this.mFilterRender + " | Beauty20Render = " + EffectProcessor.this.mBeauty20Render + " | Beauty25Render = " + EffectProcessor.this.mBeauty25Render + " | DenoiseRender = " + EffectProcessor.this.mDenoiseRender);
            localObject2 = new EffectFrame();
            ((EffectFrame)localObject2).frameData = paramEffectFrame.frameData;
            ((EffectFrame)localObject2).frameWidth = paramEffectFrame.frameWidth;
            ((EffectFrame)localObject2).frameHeight = paramEffectFrame.frameHeight;
            ((EffectFrame)localObject2).frameFormat = paramEffectFrame.frameFormat;
            if ((EffectProcessor.this.mFilterRender == null) || (EffectProcessor.this.mFilterRender.getFilterType() != 3)) {
              break label925;
            }
            i = 1;
            if (EffectProcessor.this.mFilterRender == null) {
              break label930;
            }
            if (EffectProcessor.this.mFilterRender.getFilterType() == 1) {
              continue;
            }
            if (EffectProcessor.this.mFilterRender.getFilterType() != 2) {
              break label930;
            }
          }
          catch (Exception localException)
          {
            Object localObject2;
            Object localObject1;
            EffectFrame localEffectFrame;
            if (EffectProcessor.this.mProcessCallback == null) {
              break label924;
            }
            EffectProcessor.this.mProcessCallback.onComplete(paramEffectFrame);
            EffectProcessor.this.mProcessCallback.onError(paramEffectFrame, 1, localException.getMessage());
            return;
            boolean bool = false;
            continue;
            j = 1;
            continue;
          }
          EffectProcessor.access$802(EffectProcessor.this, LowLightUtils.DetectLowLight(((EffectFrame)localObject2).frameData, 20, ((EffectFrame)localObject2).frameWidth, ((EffectFrame)localObject2).frameHeight, 60, 1.0F));
          localObject1 = localObject2;
          if (EffectProcessor.this.mBeauty20Render != null)
          {
            localObject1 = localObject2;
            if (i == 0) {
              localObject1 = EffectProcessor.this.mBeauty20Render.processData((EffectFrame)localObject2);
            }
          }
          localObject2 = localObject1;
          if (EffectProcessor.this.mBeauty25Render != null)
          {
            localObject2 = localObject1;
            if (i == 0) {
              localObject2 = EffectProcessor.this.mBeauty25Render.processData((EffectFrame)localObject1);
            }
          }
          if ((EffectProcessor.this.mLowLightRender == null) && (EffectProcessor.this.mBeautyRender == null) && (EffectProcessor.this.mFilterRender == null) && (EffectProcessor.this.mDenoiseRender == null))
          {
            if (EffectProcessor.this.mProcessCallback != null) {
              EffectProcessor.this.mProcessCallback.onComplete((EffectFrame)localObject2);
            }
          }
          else
          {
            localObject1 = EffectProcessor.this.mTextureDataLoader.loadDataToTexture(((EffectFrame)localObject2).frameData, ((EffectFrame)localObject2).frameFormat, ((EffectFrame)localObject2).frameWidth, ((EffectFrame)localObject2).frameHeight, EffectProcessor.this.mDataLoaderTextureId);
            EffectProcessor.access$1002(EffectProcessor.this, ((EffectTexture)localObject1).getTextureId());
            localObject2 = localObject1;
            if (EffectProcessor.this.mDenoiseRender != null)
            {
              localObject2 = localObject1;
              if (EffectProcessor.this.lowlightinfo[0] == 1) {
                localObject2 = EffectProcessor.this.mDenoiseRender.process(((EffectTexture)localObject1).getTextureId(), ((EffectTexture)localObject1).getFbo(), ((EffectTexture)localObject1).getWidth(), ((EffectTexture)localObject1).getHeight());
              }
            }
            localObject1 = localObject2;
            if (EffectProcessor.this.mLowLightRender != null)
            {
              localObject1 = localObject2;
              if (EffectProcessor.this.lowlightinfo[0] == 1) {
                localObject1 = EffectProcessor.this.mLowLightRender.process(((EffectTexture)localObject2).getTextureId(), ((EffectTexture)localObject2).getFbo(), ((EffectTexture)localObject2).getWidth(), ((EffectTexture)localObject2).getHeight());
              }
            }
            localObject2 = localObject1;
            if (EffectProcessor.this.mBeautyRender != null)
            {
              localObject2 = localObject1;
              if (i == 0)
              {
                localObject2 = EffectProcessor.this.mBeautyRender;
                if (j != 0) {
                  continue;
                }
                bool = true;
                ((BeautyRender)localObject2).setNeedSkinColor(bool);
                localObject2 = EffectProcessor.this.mBeautyRender.process(((EffectTexture)localObject1).getTextureId(), ((EffectTexture)localObject1).getFbo(), ((EffectTexture)localObject1).getWidth(), ((EffectTexture)localObject1).getHeight());
              }
            }
            localObject1 = localObject2;
            if (EffectProcessor.this.mFilterRender != null) {
              localObject1 = EffectProcessor.this.mFilterRender.process(((EffectTexture)localObject2).getTextureId(), ((EffectTexture)localObject2).getFbo(), ((EffectTexture)localObject2).getWidth(), ((EffectTexture)localObject2).getHeight());
            }
            localObject2 = new byte[((EffectTexture)localObject1).getWidth() * ((EffectTexture)localObject1).getHeight() * 4];
            CommonUtils.saveTextureToRgbaBuffer(((EffectTexture)localObject1).getFbo(), ((EffectTexture)localObject1).getWidth(), ((EffectTexture)localObject1).getHeight(), (byte[])localObject2);
            localEffectFrame = new EffectFrame();
            localEffectFrame.frameData = ((byte[])localObject2);
            localEffectFrame.frameWidth = ((EffectTexture)localObject1).getWidth();
            localEffectFrame.frameHeight = ((EffectTexture)localObject1).getHeight();
            localEffectFrame.frameFormat = ColorFormat.RGBA;
            if (EffectProcessor.this.mProcessCallback != null)
            {
              EffectProcessor.this.mProcessCallback.onComplete(localEffectFrame);
              return;
            }
          }
          label924:
          return;
          label925:
          int i = 0;
          continue;
          label930:
          int j = 0;
        }
      }
    });
  }
  
  public void setBeauty20Render(Beauty20Render paramBeauty20Render)
  {
    this.mBeauty20Render = paramBeauty20Render;
    this.mBeauty25Render = null;
    this.mTempBeautyRender = this.mBeautyRender;
    this.mOffscreenGLContext.post(new Runnable()
    {
      public void run()
      {
        if (EffectProcessor.this.mTempBeautyRender != null)
        {
          EffectProcessor.this.mTempBeautyRender.destroy();
          EffectProcessor.access$102(EffectProcessor.this, null);
        }
      }
    });
    this.mBeautyRender = null;
  }
  
  public void setBeauty25Render(Beauty25Render paramBeauty25Render)
  {
    this.mBeauty25Render = paramBeauty25Render;
    this.mBeauty20Render = null;
    this.mTempBeautyRender = this.mBeautyRender;
    this.mOffscreenGLContext.post(new Runnable()
    {
      public void run()
      {
        if (EffectProcessor.this.mTempBeautyRender != null)
        {
          EffectProcessor.this.mTempBeautyRender.destroy();
          EffectProcessor.access$102(EffectProcessor.this, null);
        }
      }
    });
    this.mBeautyRender = null;
  }
  
  public void setBeautyRender(BeautyRender paramBeautyRender)
  {
    this.mBeautyRender = paramBeautyRender;
    this.mBeauty20Render = null;
    this.mBeauty25Render = null;
  }
  
  public void setDenoiseRender(DenoiseRender paramDenoiseRender)
  {
    this.mDenoiseRender = paramDenoiseRender;
  }
  
  public void setFilterRender(FilterRender paramFilterRender)
  {
    this.mFilterRender = paramFilterRender;
  }
  
  public void setLowLightRender(LowLightRender paramLowLightRender)
  {
    this.mLowLightRender = paramLowLightRender;
  }
  
  public void setProcessCallback(ProcessCallback paramProcessCallback)
  {
    this.mProcessCallback = paramProcessCallback;
  }
  
  public static abstract interface ProcessCallback
  {
    public abstract void onComplete(EffectFrame paramEffectFrame);
    
    public abstract void onError(EffectFrame paramEffectFrame, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.process.EffectProcessor
 * JD-Core Version:    0.7.0.1
 */