import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apuy
  extends aptq<apuz>
{
  private static volatile apuz a;
  
  public static apuz a()
  {
    try
    {
      if (a == null) {
        a = (apuz)apub.a().a(672);
      }
      apuz localapuz = a;
      return localapuz;
    }
    finally {}
  }
  
  public DisplayMetrics a()
  {
    return BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
  }
  
  @NonNull
  public apuz a(int paramInt)
  {
    return b();
  }
  
  @Nullable
  public apuz a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0))
    {
      paramArrayOfaptx = b();
      return paramArrayOfaptx;
    }
    String str = paramArrayOfaptx[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("AIOPicThumbSizeProcessor", 2, "onParsed, content:" + str);
    }
    apuz localapuz = new apuz();
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject(str);
        localapuz.jdField_a_of_type_Boolean = localJSONObject.optBoolean("useNewConfig", true);
        localapuz.jdField_b_of_type_Boolean = localJSONObject.optBoolean("reportExpose", false);
        paramArrayOfaptx = localapuz;
        if (!localapuz.jdField_a_of_type_Boolean) {
          break;
        }
        localapuz.jdField_b_of_type_Double = localJSONObject.optDouble("minRatio", 0.0D);
        localapuz.jdField_a_of_type_Double = localJSONObject.optDouble("maxRatio", 0.0D);
        localapuz.jdField_a_of_type_Int = localJSONObject.optInt("textOtherSpace", 128);
        if ((localapuz.jdField_a_of_type_Double > 0.0D) && (localapuz.jdField_b_of_type_Double > 0.0D) && (localapuz.jdField_a_of_type_Int > 0))
        {
          paramArrayOfaptx = a();
          int i = (int)(Math.min(paramArrayOfaptx.widthPixels, paramArrayOfaptx.heightPixels) / paramArrayOfaptx.density - localapuz.jdField_a_of_type_Int);
          localapuz.c = ((int)(i * localapuz.jdField_b_of_type_Double));
          localapuz.jdField_b_of_type_Int = ((int)(i * localapuz.jdField_a_of_type_Double));
          localapuz.e = localJSONObject.optInt("aioImageDynamicMinSize", 45);
          localapuz.d = localJSONObject.optInt("aioImageDynamicMaxSize", 135);
          return localapuz;
        }
      }
      catch (Exception paramArrayOfaptx)
      {
        QLog.d("AIOPicThumbSizeProcessor", 1, "onParsed error, content:" + str);
        return b();
      }
      localapuz.c = localJSONObject.optInt("aioImageMinSize", 45);
      localapuz.jdField_b_of_type_Int = localJSONObject.optInt("aioImageMaxSize", 135);
    }
  }
  
  public void a(apuz paramapuz)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicThumbSizeProcessor", 2, "onUpdate");
      }
      a = (apuz)apub.a().a(672);
      return;
    }
    finally {}
  }
  
  public apuz b()
  {
    apuz localapuz = new apuz();
    localapuz.c = 45;
    localapuz.jdField_b_of_type_Int = 135;
    localapuz.e = 45;
    localapuz.d = 135;
    return localapuz;
  }
  
  public Class<apuz> clazz()
  {
    return apuz.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPicThumbSizeProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 672;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apuy
 * JD-Core Version:    0.7.0.1
 */