package com.tencent.aelight.camera.aioeditor.capture.data;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.component.network.utils.thread.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class CaptureComboFilter$1
  extends AsyncTask<Void, Void, Bitmap>
{
  CaptureComboFilter$1(boolean paramBoolean1, boolean paramBoolean2, List paramList, boolean paramBoolean3) {}
  
  protected Bitmap a(Void... paramVarArgs)
  {
    paramVarArgs = VideoFilterTools.a();
    Bitmap localBitmap = null;
    Object localObject;
    try
    {
      paramVarArgs = paramVarArgs.j();
      localObject = paramVarArgs;
      if (paramVarArgs == null) {
        break label193;
      }
      localObject = paramVarArgs;
      try
      {
        if (paramVarArgs.isRecycled()) {
          break label193;
        }
        if (!this.a)
        {
          if (this.b)
          {
            if (EditVideoPartManager.ag == null) {
              break label195;
            }
            localObject = new GPUBitmapImageRender();
            ((GPUBitmapImageRender)localObject).a(EditVideoPartManager.ag.a, paramVarArgs.getWidth(), paramVarArgs.getHeight());
            localBitmap = ((GPUBitmapImageRender)localObject).a(paramVarArgs, this.c, EditVideoPartManager.ag);
            break label195;
          }
          localObject = new GPUBitmapImageRender();
          ((GPUBitmapImageRender)localObject).b(paramVarArgs.getWidth(), paramVarArgs.getHeight());
          localBitmap = ((GPUBitmapImageRender)localObject).a(paramVarArgs, this.c, this.d);
          ((GPUBitmapImageRender)localObject).a();
          break label195;
        }
        localObject = paramVarArgs.copy(paramVarArgs.getConfig(), true);
        return localObject;
      }
      catch (Error localError1) {}catch (Exception localException1) {}
      localObject = paramVarArgs;
    }
    catch (Error localError2)
    {
      paramVarArgs = null;
      localObject = paramVarArgs;
      if (!QLog.isColorLevel()) {
        break label193;
      }
      QLog.d("QCombo", 1, "applyFiltersForEditPic error!", localError2);
      return paramVarArgs;
    }
    catch (Exception localException2)
    {
      paramVarArgs = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("QCombo", 1, "applyFiltersForEditPic excep!", localException2);
      localObject = paramVarArgs;
    }
    label193:
    label195:
    do
    {
      return localObject;
      localObject = paramVarArgs;
    } while (localException2 == null);
    return localException2;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    EditVideoPartManager localEditVideoPartManager = VideoFilterTools.a().i();
    if ((localEditVideoPartManager != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      localEditVideoPartManager.a(paramBitmap, true);
      localEditVideoPartManager.G();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboFilter.1
 * JD-Core Version:    0.7.0.1
 */