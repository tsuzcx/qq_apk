import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;

public class bnpi
  extends bnph<bnot, bnot>
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public final String a;
  private boolean jdField_a_of_type_Boolean;
  
  public bnpi(String paramString)
  {
    this(true, paramString);
  }
  
  public bnpi(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    this(paramBoolean, paramString);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public bnpi(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public bnpi(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int i = UIUtils.getWindowScreenWidth(BaseApplication.getContext());
    int j = UIUtils.getWindowScreenHeight(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    return yoy.b(paramBitmap, 720, i, false, false);
  }
  
  private static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap2 == null) {}
    do
    {
      for (;;)
      {
        return paramBitmap1;
        try
        {
          Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
          localCanvas.drawBitmap(paramBitmap2, 20.0F, paramBitmap1.getHeight() - 20 - paramBitmap2.getHeight(), null);
          return localBitmap;
        }
        catch (OutOfMemoryError paramBitmap2)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("Q.qqstory.publish.edit.MergePicSegment", 2, paramBitmap2, new Object[0]);
            return paramBitmap1;
          }
        }
        catch (Exception paramBitmap2) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.qqstory.publish.edit.MergePicSegment", 2, paramBitmap2, new Object[0]);
    return paramBitmap1;
  }
  
  protected void a(JobContext paramJobContext, bnot parambnot)
  {
    int i = 0;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    paramJobContext = (JobContext)localObject;
    if (localObject == null) {
      paramJobContext = bnpk.a(parambnot.jdField_a_of_type_Int, parambnot.jdField_b_of_type_JavaLangString, ".jpg");
    }
    int j = bfvo.b(parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Boolean) && (parambnot.jdField_a_of_type_Boolean)) {
      xvv.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    label527:
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_AndroidGraphicsBitmap;
        Bitmap localBitmap2 = parambnot.jdField_a_of_type_Bnoy.jdField_b_of_type_AndroidGraphicsBitmap;
        if ((parambnot.jdField_a_of_type_Int == 2) || (parambnot.jdField_a_of_type_Int == 5) || (parambnot.jdField_a_of_type_Int == 6)) {
          break label527;
        }
        float f1 = ((Bitmap)localObject).getHeight() * 1.0F / ((Bitmap)localObject).getWidth();
        float f2 = localBitmap2.getHeight() * 1.0F / localBitmap2.getWidth();
        if (((((Bitmap)localObject).getWidth() <= ((Bitmap)localObject).getHeight()) || (localBitmap2.getWidth() >= localBitmap2.getHeight())) && (Math.abs(f1 - f2) <= 0.1D)) {
          break label527;
        }
        Bitmap localBitmap1 = a((Bitmap)localObject);
        if (localBitmap1 == null) {
          break label527;
        }
        localObject = localBitmap1;
        localObject = a(yoy.c((Bitmap)localObject, localBitmap2), this.jdField_a_of_type_AndroidGraphicsBitmap);
        if (localObject == null) {
          continue;
        }
        bool = yoy.a((Bitmap)localObject, paramJobContext);
      }
      catch (Throwable paramJobContext)
      {
        xvv.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext + paramJobContext.getStackTrace());
        paramJobContext = null;
        bool = false;
        continue;
      }
      if ((i == 0) && (!bool))
      {
        xvv.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, amtj.a(2131705675)));
        return;
        paramJobContext = null;
        bool = false;
        continue;
        if (parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_Int > 0)
        {
          xvv.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
          localObject = a(parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap);
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            bool = yoy.a((Bitmap)localObject, paramJobContext);
          }
          else
          {
            if (localObject == null) {
              xvv.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is null");
            }
            for (;;)
            {
              paramJobContext = null;
              bool = false;
              break;
              if (((Bitmap)localObject).isRecycled()) {
                xvv.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is recycled");
              }
            }
          }
        }
        else if (parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_Boolean)
        {
          bool = yoy.a(parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
        }
        else if ((j != 0) && (j % 90 == 0))
        {
          xvv.b("Q.qqstory.publish.edit.MergePicSegment", "save rotate bitmap");
          bool = yoy.a(parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
        }
        else
        {
          xvv.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
          paramJobContext = parambnot.jdField_a_of_type_Bnoy.jdField_a_of_type_JavaLangString;
          xwb.b("0X80075C9");
          parambnot.jdField_a_of_type_Bnoy.c = true;
          bool = false;
          i = 1;
        }
      }
      else
      {
        parambnot.jdField_a_of_type_Bnoy.jdField_b_of_type_JavaLangString = paramJobContext;
        parambnot.jdField_a_of_type_Bnoy.jdField_b_of_type_Boolean = bool;
        super.notifyResult(parambnot);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpi
 * JD-Core Version:    0.7.0.1
 */