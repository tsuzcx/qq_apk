import android.graphics.Bitmap;
import com.tencent.component.network.utils.thread.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import java.util.List;

public final class amvc
  extends AsyncTask
{
  public amvc(boolean paramBoolean1, List paramList, boolean paramBoolean2) {}
  
  protected Bitmap a(Void... paramVarArgs)
  {
    paramVarArgs = VideoFilterTools.a();
    try
    {
      paramVarArgs = paramVarArgs.a();
      Object localObject = paramVarArgs;
      Void[] arrayOfVoid;
      if (paramVarArgs != null)
      {
        localObject = paramVarArgs;
        arrayOfVoid = paramVarArgs;
      }
      GPUBitmapImageRender localGPUBitmapImageRender;
      Bitmap localBitmap;
      label114:
      return localObject;
    }
    catch (Exception paramVarArgs)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          localObject = paramVarArgs;
          arrayOfVoid = paramVarArgs;
          localGPUBitmapImageRender = new GPUBitmapImageRender();
          localObject = paramVarArgs;
          arrayOfVoid = paramVarArgs;
          localGPUBitmapImageRender.b(paramVarArgs.getWidth(), paramVarArgs.getHeight());
          localObject = paramVarArgs;
          arrayOfVoid = paramVarArgs;
          localBitmap = localGPUBitmapImageRender.a(paramVarArgs, this.jdField_a_of_type_JavaUtilList, this.b);
          if (localBitmap != null) {
            paramVarArgs = localBitmap;
          }
          localObject = paramVarArgs;
          arrayOfVoid = paramVarArgs;
          localGPUBitmapImageRender.a();
          return paramVarArgs;
        }
        localObject = paramVarArgs;
        arrayOfVoid = paramVarArgs;
        paramVarArgs = paramVarArgs.copy(paramVarArgs.getConfig(), true);
        return paramVarArgs;
      }
      catch (Error localError2)
      {
        for (;;)
        {
          paramVarArgs = (Void[])localObject;
        }
      }
      catch (Exception paramVarArgs)
      {
        break label114;
      }
      paramVarArgs = paramVarArgs;
      arrayOfVoid = null;
      localObject = arrayOfVoid;
      if (QLog.isColorLevel())
      {
        QLog.d("QCombo", 1, "applyFiltersForEditPic excep!", paramVarArgs);
        return arrayOfVoid;
      }
    }
    catch (Error localError1)
    {
      paramVarArgs = null;
      localObject = paramVarArgs;
      if (QLog.isColorLevel())
      {
        QLog.d("QCombo", 1, "applyFiltersForEditPic error!", localError1);
        return paramVarArgs;
      }
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    EditVideoPartManager localEditVideoPartManager = VideoFilterTools.a().a();
    if (localEditVideoPartManager != null)
    {
      localEditVideoPartManager.a(paramBitmap, true);
      localEditVideoPartManager.v();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amvc
 * JD-Core Version:    0.7.0.1
 */