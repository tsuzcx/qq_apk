import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;

public class bkld
  extends bklc<bkkm, bkkm>
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public final String a;
  private boolean jdField_a_of_type_Boolean;
  
  public bkld(String paramString)
  {
    this(true, paramString);
  }
  
  public bkld(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    this(paramBoolean, paramString);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public bkld(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public bkld(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int i = vzo.a(BaseApplication.getContext());
    int j = vzo.d(BaseApplication.getContext()) * 720 / i;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    return vxy.b(paramBitmap, 720, i, false, false);
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
  
  protected void a(JobContext paramJobContext, bkkm parambkkm)
  {
    int i = 0;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    paramJobContext = (JobContext)localObject;
    if (localObject == null) {
      paramJobContext = bklf.a(parambkkm.jdField_a_of_type_Int, parambkkm.jdField_b_of_type_JavaLangString, ".jpg");
    }
    int j = bbdr.b(parambkkm.jdField_a_of_type_Bkks.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Boolean) && (parambkkm.jdField_a_of_type_Boolean)) {
      veg.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    label527:
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = parambkkm.jdField_a_of_type_Bkks.jdField_a_of_type_AndroidGraphicsBitmap;
        Bitmap localBitmap2 = parambkkm.jdField_a_of_type_Bkks.jdField_b_of_type_AndroidGraphicsBitmap;
        if ((parambkkm.jdField_a_of_type_Int == 2) || (parambkkm.jdField_a_of_type_Int == 5) || (parambkkm.jdField_a_of_type_Int == 6)) {
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
        localObject = a(vxy.c((Bitmap)localObject, localBitmap2), this.jdField_a_of_type_AndroidGraphicsBitmap);
        if (localObject == null) {
          continue;
        }
        bool = vxy.a((Bitmap)localObject, paramJobContext);
      }
      catch (Throwable paramJobContext)
      {
        veg.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext + paramJobContext.getStackTrace());
        paramJobContext = null;
        bool = false;
        continue;
      }
      if ((i == 0) && (!bool))
      {
        veg.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, ajyc.a(2131706552)));
        return;
        paramJobContext = null;
        bool = false;
        continue;
        if (parambkkm.jdField_a_of_type_Bkks.jdField_a_of_type_Int > 0)
        {
          veg.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
          localObject = a(parambkkm.jdField_a_of_type_Bkks.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap);
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            bool = vxy.a((Bitmap)localObject, paramJobContext);
          }
          else
          {
            if (localObject == null) {
              veg.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is null");
            }
            for (;;)
            {
              paramJobContext = null;
              bool = false;
              break;
              if (((Bitmap)localObject).isRecycled()) {
                veg.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is recycled");
              }
            }
          }
        }
        else if (parambkkm.jdField_a_of_type_Bkks.jdField_a_of_type_Boolean)
        {
          bool = vxy.a(parambkkm.jdField_a_of_type_Bkks.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
        }
        else if ((j != 0) && (j % 90 == 0))
        {
          veg.b("Q.qqstory.publish.edit.MergePicSegment", "save rotate bitmap");
          bool = vxy.a(parambkkm.jdField_a_of_type_Bkks.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
        }
        else
        {
          veg.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
          paramJobContext = parambkkm.jdField_a_of_type_Bkks.jdField_a_of_type_JavaLangString;
          vem.b("0X80075C9");
          parambkkm.jdField_a_of_type_Bkks.c = true;
          bool = false;
          i = 1;
        }
      }
      else
      {
        parambkkm.jdField_a_of_type_Bkks.jdField_b_of_type_JavaLangString = paramJobContext;
        parambkkm.jdField_a_of_type_Bkks.jdField_b_of_type_Boolean = bool;
        super.notifyResult(parambkkm);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkld
 * JD-Core Version:    0.7.0.1
 */