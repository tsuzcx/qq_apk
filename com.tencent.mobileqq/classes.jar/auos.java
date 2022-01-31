import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract class auos
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g = 960;
  public static int h = 960;
  public static int i = 960;
  public static int j = 960;
  CompressInfo a;
  protected String a;
  protected int k;
  
  static
  {
    jdField_a_of_type_Int = 80;
    b = 70;
    c = 80;
    d = 960;
    e = 1920;
    jdField_f_of_type_Int = 960;
  }
  
  auos(CompressInfo paramCompressInfo)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.c))) {
      throw new IllegalArgumentException("info == null || TextUtils.isEmpty(info.srcPath)");
    }
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    int m = a(paramCompressInfo);
    this.k = m;
    if (m == -1) {
      throw new IllegalArgumentException("create PicQuality is Fail");
    }
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int m = 1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!bbdj.b(paramString1))) {
      aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
    }
    BitmapFactory.Options localOptions;
    do
    {
      return 0;
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = 2;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      try
      {
        Bitmap localBitmap3 = SafeBitmapFactory.decodeFile(paramString1, localOptions);
        Bitmap localBitmap1 = localBitmap3;
        if (localBitmap3 != null) {
          break;
        }
        aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " bm == null, maybe is broken");
        return 0;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
        aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " decodeFile OutOfMemoryError, sampleCnt:" + 1 + " oomKeepCompress:" + paramBoolean);
      }
    } while (!paramBoolean);
    localOptions.inSampleSize = 4;
    for (;;)
    {
      try
      {
        Bitmap localBitmap2 = SafeBitmapFactory.decodeFile(paramString1, localOptions);
        m = 2;
        paramBoolean = auoy.a(paramString2, localBitmap2, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
        if (localBitmap2 != null) {
          localBitmap2.recycle();
        }
        if (paramBoolean) {
          return m;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
        paramString1.printStackTrace();
        aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " oomKeepCompress decodeFile OutOfMemoryError, sampleCnt:" + 2);
        return 0;
      }
      m = 0;
    }
  }
  
  protected int a()
  {
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2) {
      m = 100;
    }
    for (;;)
    {
      aune.a(this.jdField_a_of_type_JavaLangString, "getCompressQuality", "compressQuality = " + m);
      return m;
      switch (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h)
      {
      case 2: 
      case 3: 
      default: 
        m = b;
        break;
      case 1: 
        m = jdField_a_of_type_Int;
        break;
      case 4: 
        m = c;
      }
    }
  }
  
  protected abstract int a(CompressInfo paramCompressInfo);
  
  final boolean a()
  {
    if (this.k == 2) {
      return c();
    }
    return d();
  }
  
  final int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h == 1) {
      return 20971520;
    }
    return 4194304;
  }
  
  final boolean b()
  {
    boolean bool2;
    if (!bbdj.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c))
    {
      aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " src file does not exist");
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " destPath is empty");
          return false;
        }
      }
      if ((bbdj.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Boolean))
      {
        aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " destPath exist. return true");
        return true;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int == 2) {}
        for (bool1 = auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_ComTencentMobileqqDataThumbWidthHeightDP);; bool1 = auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_ComTencentMobileqqDataThumbWidthHeightDP))
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
          aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " compressAIOThumbnail is failed");
          return bool1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          aune.b(this.jdField_a_of_type_JavaLangString, "startThumbnail()", localException.getMessage());
          boolean bool1 = false;
        }
      }
    }
  }
  
  final boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2) {
      if (auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) <= ayxc.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + ajyc.a(2131708165));
        aune.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", ajyc.a(2131708164));
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
    for (;;)
    {
      return true;
      aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", ajyc.a(2131708169));
      continue;
      int m = b();
      if (auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) > m)
      {
        aune.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " src file size > max, file size:" + auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c) + " max:" + m);
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " destPath is empty");
          return false;
        }
        if (bbdj.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " destPath exist. return true");
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.i = 0;
        int n = a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, true);
        if (n != 0)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
          ((CompressInfo)localObject1).i = (n + ((CompressInfo)localObject1).i);
          if (auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) > m)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.i >= 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 面积是原来的1/16，不能再小了fileSize:" + auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) + " max:" + m);
              aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 面积是原来的1/16，不能再小了fileSize:" + auoy.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) + " max:" + m);
              bbdj.d(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              return false;
            }
            Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString;
            localObject1 = (String)localObject2 + "_second";
            this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
            n = a((String)localObject2, (String)localObject1, false);
            bbdj.d((String)localObject2);
            if (n != 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
              ((CompressInfo)localObject2).i = (n + ((CompressInfo)localObject2).i);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
              if (auoy.a((String)localObject1) > m)
              {
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()" + ajyc.a(2131708170) + auoy.a((String)localObject1) + " max:" + m);
                aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", ajyc.a(2131708171) + auoy.a((String)localObject1) + " max:" + m);
                bbdj.d(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
                return false;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()" + ajyc.a(2131708168));
              aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", ajyc.a(2131708166));
              return false;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() sampleCompress failed");
          aune.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " sampleCompress failed");
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + ajyc.a(2131708172));
        aune.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", ajyc.a(2131708167));
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auos
 * JD-Core Version:    0.7.0.1
 */