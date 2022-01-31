import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class axlb
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private avzb jdField_a_of_type_Avzb;
  public avzc a;
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
    ved.b("Q.qqstory.publish.upload.PicToVideoConverter", "preparing.");
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    ved.b("Q.qqstory.publish.upload.PicToVideoConverter", "bitmap's width = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + ", height = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    avza localavza = new avza(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), 532480, 1, false, 0);
    localavza.d = 25;
    this.jdField_a_of_type_Avzc = new avzc();
    this.jdField_a_of_type_Avzc.a(localavza);
    this.jdField_a_of_type_Avzb = new avzb();
    this.jdField_a_of_type_Avzb.a(localavza, this.jdField_a_of_type_Avzc.a());
    this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  private void b()
  {
    ved.b("Q.qqstory.publish.upload.PicToVideoConverter", "releasing.");
    if (this.jdField_a_of_type_Avzb != null)
    {
      this.jdField_a_of_type_Avzb.a();
      this.jdField_a_of_type_Avzb = null;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalStateException("convert image to video failed. because input path or target path is null!");
    }
    ved.d("Q.qqstory.publish.upload.PicToVideoConverter", "input file path is %s. output file path is %s.", new Object[] { paramString1, paramString2 });
    if (!vyf.c(paramString1))
    {
      ved.e("Q.qqstory.publish.upload.PicToVideoConverter", "input file does not exists or is empty.");
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
              this.jdField_a_of_type_Avzc.a();
              this.jdField_a_of_type_Avzb.a(3553, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null, a(i));
              i += 1;
              continue;
              paramString2 = paramString2;
              System.gc();
              try
              {
                Thread.sleep(1000L);
                this.jdField_a_of_type_AndroidGraphicsBitmap = bbef.a(paramString1, 540, 960);
                if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
                  this.jdField_a_of_type_AndroidGraphicsBitmap = bbef.a(paramString1, 360, 640);
                }
                if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
                  break;
                }
                ved.e("Q.qqstory.publish.upload.PicToVideoConverter", "decode bitmap <%s> error:%s", new Object[] { paramString1, paramString2 });
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
        this.jdField_a_of_type_Avzc.b();
        b();
        i = 0;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          long l;
          ved.b("Q.qqstory.publish.upload.PicToVideoConverter", "convert picture to video error. %s.", paramString1);
          int i = 942013;
          this.jdField_a_of_type_Avzc.c();
          b();
        }
      }
      finally
      {
        b();
      }
      ved.d("Q.qqstory.publish.upload.PicToVideoConverter", "convert image to video done. cost time %d. errorCode is %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axlb
 * JD-Core Version:    0.7.0.1
 */