import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class awhi<T extends View>
{
  protected int a;
  public long a;
  
  public awhi(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static awhi a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    case 2: 
    case 4: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("BaseSearchEntryModel", 2, "createSearchEntryModel, modelType = " + paramInt1 + ", tabType = " + paramInt2);
      }
      return null;
    case 0: 
      return new awhr(paramInt2);
    case 1: 
      return new awhx(paramInt2, paramBoolean);
    case 3: 
      return new awhj(paramInt2, paramBoolean);
    case 5: 
      return new awie(paramInt2, paramBoolean);
    }
    return new awiz(paramInt2);
  }
  
  public abstract T a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void a() {}
  
  public void a(awpp paramawpp) {}
  
  public void b() {}
  
  public void b(awpp paramawpp) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhi
 * JD-Core Version:    0.7.0.1
 */