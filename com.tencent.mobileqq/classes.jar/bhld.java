import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class bhld
  implements InvocationHandler
{
  private boolean jdField_a_of_type_Boolean;
  
  public bhld(bhky parambhky) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QMLog.e("TXLivePlayerJSAdapter", "InnerITXSnapshotListenerImpl invoke:" + paramMethod.getName());
    if (Object.class.equals(paramMethod.getDeclaringClass())) {
      try
      {
        paramObject = paramMethod.invoke(this, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        paramObject.printStackTrace();
        return null;
      }
    }
    if (("onSnapshot".equals(paramMethod.getName())) && (paramArrayOfObject.length == 1))
    {
      paramObject = (Bitmap)paramArrayOfObject[0];
      if (bhky.a(this.jdField_a_of_type_Bhky) != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label181;
        }
        if (paramObject == null) {
          break label165;
        }
        int i = paramObject.getWidth();
        int j = paramObject.getHeight();
        paramMethod = new Matrix();
        paramMethod.setScale(0.5F, 0.5F);
        paramMethod = Bitmap.createBitmap(paramObject, 0, 0, i, j, paramMethod, false);
        bhky.a(this.jdField_a_of_type_Bhky).a(paramMethod);
        bhky.a(this.jdField_a_of_type_Bhky, paramObject);
      }
    }
    for (;;)
    {
      return null;
      label165:
      bhky.a(this.jdField_a_of_type_Bhky).a(paramObject);
      continue;
      label181:
      bhky.a(this.jdField_a_of_type_Bhky).a(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhld
 * JD-Core Version:    0.7.0.1
 */