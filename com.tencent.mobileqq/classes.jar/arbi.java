import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbi
  extends arac<arbj>
{
  private static volatile arbj a;
  
  public static arbj a()
  {
    try
    {
      if (a == null) {
        a = (arbj)aran.a().a(672);
      }
      arbj localarbj = a;
      return localarbj;
    }
    finally {}
  }
  
  public DisplayMetrics a()
  {
    return BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
  }
  
  @NonNull
  public arbj a(int paramInt)
  {
    return b();
  }
  
  @Nullable
  public arbj a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0))
    {
      paramArrayOfaraj = b();
      return paramArrayOfaraj;
    }
    String str = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("AIOPicThumbSizeProcessor", 2, "onParsed, content:" + str);
    }
    arbj localarbj = new arbj();
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject(str);
        localarbj.jdField_a_of_type_Boolean = localJSONObject.optBoolean("useNewConfig", true);
        localarbj.jdField_b_of_type_Boolean = localJSONObject.optBoolean("reportExpose", false);
        paramArrayOfaraj = localarbj;
        if (!localarbj.jdField_a_of_type_Boolean) {
          break;
        }
        localarbj.jdField_b_of_type_Double = localJSONObject.optDouble("minRatio", 0.0D);
        localarbj.jdField_a_of_type_Double = localJSONObject.optDouble("maxRatio", 0.0D);
        localarbj.jdField_a_of_type_Int = localJSONObject.optInt("textOtherSpace", 128);
        if ((localarbj.jdField_a_of_type_Double > 0.0D) && (localarbj.jdField_b_of_type_Double > 0.0D) && (localarbj.jdField_a_of_type_Int > 0))
        {
          paramArrayOfaraj = a();
          int i = (int)(Math.min(paramArrayOfaraj.widthPixels, paramArrayOfaraj.heightPixels) / paramArrayOfaraj.density - localarbj.jdField_a_of_type_Int);
          localarbj.c = ((int)(i * localarbj.jdField_b_of_type_Double));
          localarbj.jdField_b_of_type_Int = ((int)(i * localarbj.jdField_a_of_type_Double));
          localarbj.e = localJSONObject.optInt("aioImageDynamicMinSize", 45);
          localarbj.d = localJSONObject.optInt("aioImageDynamicMaxSize", 135);
          return localarbj;
        }
      }
      catch (Exception paramArrayOfaraj)
      {
        QLog.d("AIOPicThumbSizeProcessor", 1, "onParsed error, content:" + str);
        return b();
      }
      localarbj.c = localJSONObject.optInt("aioImageMinSize", 45);
      localarbj.jdField_b_of_type_Int = localJSONObject.optInt("aioImageMaxSize", 135);
    }
  }
  
  public void a(arbj paramarbj)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicThumbSizeProcessor", 2, "onUpdate");
      }
      a = (arbj)aran.a().a(672);
      return;
    }
    finally {}
  }
  
  public arbj b()
  {
    arbj localarbj = new arbj();
    localarbj.c = 45;
    localarbj.jdField_b_of_type_Int = 135;
    localarbj.e = 45;
    localarbj.d = 135;
    return localarbj;
  }
  
  public Class<arbj> clazz()
  {
    return arbj.class;
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
 * Qualified Name:     arbi
 * JD-Core Version:    0.7.0.1
 */