import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class azgh
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private axra jdField_a_of_type_Axra;
  public axrb a;
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
    wsv.b("Q.qqstory.publish.upload.PicToVideoConverter", "preparing.");
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    wsv.b("Q.qqstory.publish.upload.PicToVideoConverter", "bitmap's width = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + ", height = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    axqz localaxqz = new axqz(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), 532480, 1, false, 0);
    localaxqz.d = 25;
    this.jdField_a_of_type_Axrb = new axrb();
    this.jdField_a_of_type_Axrb.a(localaxqz);
    this.jdField_a_of_type_Axra = new axra();
    this.jdField_a_of_type_Axra.a(localaxqz, this.jdField_a_of_type_Axrb.a());
    this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  private void b()
  {
    wsv.b("Q.qqstory.publish.upload.PicToVideoConverter", "releasing.");
    if (this.jdField_a_of_type_Axra != null)
    {
      this.jdField_a_of_type_Axra.a();
      this.jdField_a_of_type_Axra = null;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalStateException("convert image to video failed. because input path or target path is null!");
    }
    wsv.d("Q.qqstory.publish.upload.PicToVideoConverter", "input file path is %s. output file path is %s.", new Object[] { paramString1, paramString2 });
    if (!xmx.c(paramString1))
    {
      wsv.e("Q.qqstory.publish.upload.PicToVideoConverter", "input file does not exists or is empty.");
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
              this.jdField_a_of_type_Axrb.a();
              this.jdField_a_of_type_Axra.a(3553, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null, a(i));
              i += 1;
              continue;
              paramString2 = paramString2;
              System.gc();
              try
              {
                Thread.sleep(1000L);
                this.jdField_a_of_type_AndroidGraphicsBitmap = bdda.a(paramString1, 540, 960);
                if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
                  this.jdField_a_of_type_AndroidGraphicsBitmap = bdda.a(paramString1, 360, 640);
                }
                if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
                  break;
                }
                wsv.e("Q.qqstory.publish.upload.PicToVideoConverter", "decode bitmap <%s> error:%s", new Object[] { paramString1, paramString2 });
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
        this.jdField_a_of_type_Axrb.b();
        b();
        i = 0;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          long l;
          wsv.b("Q.qqstory.publish.upload.PicToVideoConverter", "convert picture to video error. %s.", paramString1);
          int i = 942013;
          this.jdField_a_of_type_Axrb.c();
          b();
        }
      }
      finally
      {
        b();
      }
      wsv.d("Q.qqstory.publish.upload.PicToVideoConverter", "convert image to video done. cost time %d. errorCode is %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgh
 * JD-Core Version:    0.7.0.1
 */