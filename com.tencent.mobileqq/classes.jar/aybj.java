import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;

class aybj
  extends AsyncTask<Void, Bitmap, Bitmap>
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public aybj(aybi paramaybi, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  private Bitmap a(File paramFile)
  {
    Bitmap localBitmap1 = null;
    Bitmap localBitmap2 = null;
    if (paramFile.exists()) {
      localBitmap2 = localBitmap1;
    }
    try
    {
      localBitmap1 = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath());
      localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        localBitmap2 = localBitmap1;
        paramFile.delete();
        localBitmap2 = localBitmap1;
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError paramFile) {}
    return localBitmap2;
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    Object localObject1 = null;
    paramVarArgs = null;
    boolean bool2 = true;
    Object localObject2 = aybi.a();
    if (localObject2 != null)
    {
      localObject1 = new File((File)localObject2, this.jdField_a_of_type_JavaLangString);
      boolean bool1 = bool2;
      if (!((File)localObject1).exists())
      {
        if (!TextUtils.isEmpty(this.b))
        {
          localObject2 = a(new File((File)localObject2, this.b));
          if (localObject2 != null) {
            publishProgress(new Bitmap[] { localObject2 });
          }
        }
        bool1 = bool2;
        if (this.c != null)
        {
          if ((aybi.a(this.jdField_a_of_type_Aybi) > 3L) && (Math.abs(SystemClock.uptimeMillis() - aybi.a(this.jdField_a_of_type_Aybi)) > 60000L)) {
            aybi.a(this.jdField_a_of_type_Aybi, 0L);
          }
          bool1 = bool2;
          if (aybi.a(this.jdField_a_of_type_Aybi) < 3L) {
            bool1 = aybi.a(this.jdField_a_of_type_Aybi, this.c, (File)localObject1);
          }
        }
      }
      if (bool1) {
        paramVarArgs = a((File)localObject1);
      }
      if ((!bool1) || (paramVarArgs == null)) {
        break label253;
      }
      aybi.a(this.jdField_a_of_type_Aybi, 0L);
      localObject1 = paramVarArgs;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.img", 2, "decodeBitmap finish with " + localObject1 + ", " + aybi.a(this.jdField_a_of_type_Aybi));
      }
      return localObject1;
      label253:
      localObject1 = paramVarArgs;
      if (!TextUtils.isEmpty(this.c))
      {
        localObject1 = paramVarArgs;
        if (aybi.b(this.jdField_a_of_type_Aybi) == 3L)
        {
          aybi.a(this.jdField_a_of_type_Aybi, SystemClock.uptimeMillis());
          localObject1 = paramVarArgs;
        }
      }
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      BaseApplicationImpl.sImageCache.put(aybi.a(this.jdField_a_of_type_Aybi) + this.jdField_a_of_type_JavaLangString, paramBitmap, (byte)0);
    }
    aybi.a(this.jdField_a_of_type_Aybi).remove(this.jdField_a_of_type_JavaLangString);
    if (aybi.a(this.jdField_a_of_type_Aybi) != null) {
      aybi.a(this.jdField_a_of_type_Aybi).a(this.jdField_a_of_type_JavaLangString, this.c, paramBitmap, 1);
    }
  }
  
  protected void a(Bitmap... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    BaseApplicationImpl.sImageCache.put(aybi.a(this.jdField_a_of_type_Aybi) + this.b, paramVarArgs, (byte)0);
    if (aybi.a(this.jdField_a_of_type_Aybi) != null) {
      aybi.a(this.jdField_a_of_type_Aybi).a(this.jdField_a_of_type_JavaLangString, this.c, paramVarArgs, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybj
 * JD-Core Version:    0.7.0.1
 */