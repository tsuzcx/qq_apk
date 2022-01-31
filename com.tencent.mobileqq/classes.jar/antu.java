import android.graphics.Bitmap;
import com.tencent.component.network.utils.thread.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import java.util.List;

public final class antu
  extends AsyncTask
{
  public antu(boolean paramBoolean1, List paramList, boolean paramBoolean2) {}
  
  protected Bitmap a(Void... paramVarArgs)
  {
    paramVarArgs = VideoFilterTools.a();
    try
    {
      paramVarArgs = paramVarArgs.a();
      Object localObject = paramVarArgs;
      Void[] arrayOfVoid1;
      Void[] arrayOfVoid2;
      if (paramVarArgs != null)
      {
        arrayOfVoid1 = paramVarArgs;
        arrayOfVoid2 = paramVarArgs;
        localObject = paramVarArgs;
      }
      GPUBitmapImageRender localGPUBitmapImageRender;
      label129:
      label152:
      return localObject;
    }
    catch (Exception paramVarArgs)
    {
      try
      {
        if (paramVarArgs.isRecycled()) {
          break label180;
        }
        arrayOfVoid1 = paramVarArgs;
        arrayOfVoid2 = paramVarArgs;
        if (!this.jdField_a_of_type_Boolean)
        {
          arrayOfVoid1 = paramVarArgs;
          arrayOfVoid2 = paramVarArgs;
          localGPUBitmapImageRender = new GPUBitmapImageRender();
          arrayOfVoid1 = paramVarArgs;
          arrayOfVoid2 = paramVarArgs;
          localGPUBitmapImageRender.b(paramVarArgs.getWidth(), paramVarArgs.getHeight());
          arrayOfVoid1 = paramVarArgs;
          arrayOfVoid2 = paramVarArgs;
          localObject = localGPUBitmapImageRender.a(paramVarArgs, this.jdField_a_of_type_JavaUtilList, this.b);
          if (localObject != null) {
            paramVarArgs = (Void[])localObject;
          }
          arrayOfVoid1 = paramVarArgs;
          arrayOfVoid2 = paramVarArgs;
          localGPUBitmapImageRender.a();
          return paramVarArgs;
        }
        arrayOfVoid1 = paramVarArgs;
        arrayOfVoid2 = paramVarArgs;
        paramVarArgs = paramVarArgs.copy(paramVarArgs.getConfig(), true);
        return paramVarArgs;
      }
      catch (Error paramVarArgs)
      {
        break label152;
      }
      catch (Exception paramVarArgs)
      {
        break label129;
      }
      paramVarArgs = paramVarArgs;
      arrayOfVoid2 = null;
      localObject = arrayOfVoid2;
      if (QLog.isColorLevel())
      {
        QLog.d("QCombo", 1, "applyFiltersForEditPic excep!", paramVarArgs);
        return arrayOfVoid2;
      }
    }
    catch (Error paramVarArgs)
    {
      arrayOfVoid1 = null;
      localObject = arrayOfVoid1;
      if (QLog.isColorLevel())
      {
        QLog.d("QCombo", 1, "applyFiltersForEditPic error!", paramVarArgs);
        return arrayOfVoid1;
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
 * Qualified Name:     antu
 * JD-Core Version:    0.7.0.1
 */