import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;

public class bpfa
  extends bpez<bpel, bpel>
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public final String a;
  private boolean jdField_a_of_type_Boolean;
  
  public bpfa(String paramString)
  {
    this(true, paramString);
  }
  
  public bpfa(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    this(paramBoolean, paramString);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public bpfa(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public bpfa(boolean paramBoolean, String paramString)
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
    return zdr.b(paramBitmap, 720, i, false, false);
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
  
  protected void a(JobContext paramJobContext, bpel parambpel)
  {
    int i = 0;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    paramJobContext = (JobContext)localObject;
    if (localObject == null) {
      paramJobContext = bpfc.a(parambpel.jdField_a_of_type_Int, parambpel.jdField_b_of_type_JavaLangString, ".jpg");
    }
    int j = bheg.b(parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Boolean) && (parambpel.jdField_a_of_type_Boolean)) {
      ykq.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    label527:
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_AndroidGraphicsBitmap;
        Bitmap localBitmap2 = parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_AndroidGraphicsBitmap;
        if ((parambpel.jdField_a_of_type_Int == 2) || (parambpel.jdField_a_of_type_Int == 5) || (parambpel.jdField_a_of_type_Int == 6)) {
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
        localObject = a(zdr.c((Bitmap)localObject, localBitmap2), this.jdField_a_of_type_AndroidGraphicsBitmap);
        if (localObject == null) {
          continue;
        }
        bool = zdr.a((Bitmap)localObject, paramJobContext);
      }
      catch (Throwable paramJobContext)
      {
        ykq.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext + paramJobContext.getStackTrace());
        paramJobContext = null;
        bool = false;
        continue;
      }
      if ((i == 0) && (!bool))
      {
        ykq.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, anvx.a(2131706026)));
        return;
        paramJobContext = null;
        bool = false;
        continue;
        if (parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_Int > 0)
        {
          ykq.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
          localObject = a(parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap);
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            bool = zdr.a((Bitmap)localObject, paramJobContext);
          }
          else
          {
            if (localObject == null) {
              ykq.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is null");
            }
            for (;;)
            {
              paramJobContext = null;
              bool = false;
              break;
              if (((Bitmap)localObject).isRecycled()) {
                ykq.e("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is recycled");
              }
            }
          }
        }
        else if (parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_Boolean)
        {
          bool = zdr.a(parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
        }
        else if ((j != 0) && (j % 90 == 0))
        {
          ykq.b("Q.qqstory.publish.edit.MergePicSegment", "save rotate bitmap");
          bool = zdr.a(parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
        }
        else
        {
          ykq.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
          paramJobContext = parambpel.jdField_a_of_type_Bpeq.jdField_a_of_type_JavaLangString;
          ykw.b("0X80075C9");
          parambpel.jdField_a_of_type_Bpeq.c = true;
          bool = false;
          i = 1;
        }
      }
      else
      {
        parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_JavaLangString = paramJobContext;
        parambpel.jdField_a_of_type_Bpeq.jdField_b_of_type_Boolean = bool;
        super.notifyResult(parambpel);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfa
 * JD-Core Version:    0.7.0.1
 */