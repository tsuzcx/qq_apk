import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class azkq
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private axvj jdField_a_of_type_Axvj;
  public axvk a;
  private String jdField_a_of_type_JavaLangString;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  private static long a(int paramInt)
  {
    return paramInt * 1000000000L / 25L;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap.getWidth() % 2 == 1)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawARGB(0, 0, 0, 0);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    }
    return localBitmap;
  }
  
  private void a()
  {
    wxe.b("Q.qqstory.publish.upload.PicToVideoConverter", "preparing.");
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    wxe.b("Q.qqstory.publish.upload.PicToVideoConverter", "bitmap's width = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + ", height = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    axvi localaxvi = new axvi(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), 532480, 1, false, 0);
    localaxvi.d = 25;
    this.jdField_a_of_type_Axvk = new axvk();
    this.jdField_a_of_type_Axvk.a(localaxvi);
    this.jdField_a_of_type_Axvj = new axvj();
    this.jdField_a_of_type_Axvj.a(localaxvi, this.jdField_a_of_type_Axvk.a());
    this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  private void b()
  {
    wxe.b("Q.qqstory.publish.upload.PicToVideoConverter", "releasing.");
    if (this.jdField_a_of_type_Axvj != null)
    {
      this.jdField_a_of_type_Axvj.a();
      this.jdField_a_of_type_Axvj = null;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalStateException("convert image to video failed. because input path or target path is null!");
    }
    wxe.d("Q.qqstory.publish.upload.PicToVideoConverter", "input file path is %s. output file path is %s.", new Object[] { paramString1, paramString2 });
    if (!xrg.c(paramString1))
    {
      wxe.e("Q.qqstory.publish.upload.PicToVideoConverter", "input file does not exists or is empty.");
      return 940007;
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(paramString1);
      l = System.currentTimeMillis();
    }
    catch (OutOfMemoryError paramString2)
    {
      try
      {
        for (;;)
        {
          a();
          i = 0;
          for (;;)
          {
            if (i < 75)
            {
              this.jdField_a_of_type_Axvk.a();
              this.jdField_a_of_type_Axvj.a(3553, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null, a(i));
              i += 1;
              continue;
              paramString2 = paramString2;
              System.gc();
              try
              {
                Thread.sleep(1000L);
                this.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a(paramString1, 540, 960);
                if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
                  this.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a(paramString1, 360, 640);
                }
                if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
                  break;
                }
                wxe.e("Q.qqstory.publish.upload.PicToVideoConverter", "decode bitmap <%s> error:%s", new Object[] { paramString1, paramString2 });
                return 942014;
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
          }
        }
        this.jdField_a_of_type_Axvk.b();
        b();
        i = 0;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          long l;
          wxe.b("Q.qqstory.publish.upload.PicToVideoConverter", "convert picture to video error. %s.", paramString1);
          int i = 942013;
          this.jdField_a_of_type_Axvk.c();
          b();
        }
      }
      finally
      {
        b();
      }
      wxe.d("Q.qqstory.publish.upload.PicToVideoConverter", "convert image to video done. cost time %d. errorCode is %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkq
 * JD-Core Version:    0.7.0.1
 */