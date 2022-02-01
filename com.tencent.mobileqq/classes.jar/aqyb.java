import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqyb
  extends aqwt<aqyc>
{
  private static volatile aqyc a;
  
  public static aqyc a()
  {
    try
    {
      if (a == null) {
        a = (aqyc)aqxe.a().a(672);
      }
      aqyc localaqyc = a;
      return localaqyc;
    }
    finally {}
  }
  
  public DisplayMetrics a()
  {
    return BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
  }
  
  @NonNull
  public aqyc a(int paramInt)
  {
    return b();
  }
  
  @Nullable
  public aqyc a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0))
    {
      paramArrayOfaqxa = b();
      return paramArrayOfaqxa;
    }
    String str = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("AIOPicThumbSizeProcessor", 2, "onParsed, content:" + str);
    }
    aqyc localaqyc = new aqyc();
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject(str);
        localaqyc.jdField_a_of_type_Boolean = localJSONObject.optBoolean("useNewConfig", true);
        paramArrayOfaqxa = localaqyc;
        if (!localaqyc.jdField_a_of_type_Boolean) {
          break;
        }
        localaqyc.jdField_b_of_type_Double = localJSONObject.optDouble("minRatio", 0.0D);
        localaqyc.jdField_a_of_type_Double = localJSONObject.optDouble("maxRatio", 0.0D);
        localaqyc.jdField_a_of_type_Int = localJSONObject.optInt("textOtherSpace", 128);
        localaqyc.jdField_b_of_type_Int = localJSONObject.optInt("picSizeLimit", 650);
        if ((localaqyc.jdField_a_of_type_Double > 0.0D) && (localaqyc.jdField_b_of_type_Double > 0.0D) && (localaqyc.jdField_a_of_type_Int > 0))
        {
          paramArrayOfaqxa = a();
          int i = (int)(Math.min(paramArrayOfaqxa.widthPixels, paramArrayOfaqxa.heightPixels) / paramArrayOfaqxa.density - localaqyc.jdField_a_of_type_Int);
          localaqyc.d = ((int)(i * localaqyc.jdField_b_of_type_Double));
          localaqyc.c = ((int)(i * localaqyc.jdField_a_of_type_Double));
          localaqyc.f = localJSONObject.optInt("aioImageMinSizeUnderLimit", 45);
          localaqyc.e = localJSONObject.optInt("aioImageMaxSizeUnderLimit", 135);
          localaqyc.h = localJSONObject.optInt("aioImageDynamicMinSize", 45);
          localaqyc.g = localJSONObject.optInt("aioImageDynamicMaxSize", 135);
          return localaqyc;
        }
      }
      catch (Exception paramArrayOfaqxa)
      {
        QLog.d("AIOPicThumbSizeProcessor", 1, "onParsed error, content:" + str);
        return b();
      }
      localaqyc.d = localJSONObject.optInt("aioImageMinSize", 45);
      localaqyc.c = localJSONObject.optInt("aioImageMaxSize", 135);
    }
  }
  
  public void a(aqyc paramaqyc)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicThumbSizeProcessor", 2, "onUpdate");
      }
      a = (aqyc)aqxe.a().a(672);
      return;
    }
    finally {}
  }
  
  public aqyc b()
  {
    aqyc localaqyc = new aqyc();
    localaqyc.jdField_b_of_type_Int = 650;
    localaqyc.d = 45;
    localaqyc.c = 135;
    localaqyc.f = 45;
    localaqyc.e = 135;
    localaqyc.h = 45;
    localaqyc.g = 135;
    return localaqyc;
  }
  
  public Class<aqyc> clazz()
  {
    return aqyc.class;
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
 * Qualified Name:     aqyb
 * JD-Core Version:    0.7.0.1
 */