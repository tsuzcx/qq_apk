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

class axxa
  extends AsyncTask<Void, Bitmap, Bitmap>
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public axxa(axwz paramaxwz, String paramString1, String paramString2, String paramString3)
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
    Object localObject2 = axwz.a();
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
          if ((axwz.a(this.jdField_a_of_type_Axwz) > 3L) && (Math.abs(SystemClock.uptimeMillis() - axwz.a(this.jdField_a_of_type_Axwz)) > 60000L)) {
            axwz.a(this.jdField_a_of_type_Axwz, 0L);
          }
          bool1 = bool2;
          if (axwz.a(this.jdField_a_of_type_Axwz) < 3L) {
            bool1 = axwz.a(this.jdField_a_of_type_Axwz, this.c, (File)localObject1);
          }
        }
      }
      if (bool1) {
        paramVarArgs = a((File)localObject1);
      }
      if ((!bool1) || (paramVarArgs == null)) {
        break label253;
      }
      axwz.a(this.jdField_a_of_type_Axwz, 0L);
      localObject1 = paramVarArgs;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.img", 2, "decodeBitmap finish with " + localObject1 + ", " + axwz.a(this.jdField_a_of_type_Axwz));
      }
      return localObject1;
      label253:
      localObject1 = paramVarArgs;
      if (!TextUtils.isEmpty(this.c))
      {
        localObject1 = paramVarArgs;
        if (axwz.b(this.jdField_a_of_type_Axwz) == 3L)
        {
          axwz.a(this.jdField_a_of_type_Axwz, SystemClock.uptimeMillis());
          localObject1 = paramVarArgs;
        }
      }
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      BaseApplicationImpl.sImageCache.put(axwz.a(this.jdField_a_of_type_Axwz) + this.jdField_a_of_type_JavaLangString, paramBitmap, (byte)0);
    }
    axwz.a(this.jdField_a_of_type_Axwz).remove(this.jdField_a_of_type_JavaLangString);
    if (axwz.a(this.jdField_a_of_type_Axwz) != null) {
      axwz.a(this.jdField_a_of_type_Axwz).a(this.jdField_a_of_type_JavaLangString, this.c, paramBitmap, 1);
    }
  }
  
  protected void a(Bitmap... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    BaseApplicationImpl.sImageCache.put(axwz.a(this.jdField_a_of_type_Axwz) + this.b, paramVarArgs, (byte)0);
    if (axwz.a(this.jdField_a_of_type_Axwz) != null) {
      axwz.a(this.jdField_a_of_type_Axwz).a(this.jdField_a_of_type_JavaLangString, this.c, paramVarArgs, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxa
 * JD-Core Version:    0.7.0.1
 */