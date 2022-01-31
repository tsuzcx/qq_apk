import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class aygv<T extends View>
{
  protected int a;
  public long a;
  
  public aygv(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static aygv a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("BaseSearchEntryModel", 2, "createSearchEntryModel, modelType = " + paramInt1 + ", tabType = " + paramInt2);
      }
      return null;
    case 0: 
      return new ayhe(paramInt2);
    case 1: 
      return new ayhk(paramInt2, paramBoolean);
    case 3: 
      return new aygw(paramInt2, paramBoolean);
    }
    return new ayii(paramInt2);
  }
  
  public abstract T a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void a() {}
  
  public void a(aypb paramaypb) {}
  
  public void b() {}
  
  public void b(aypb paramaypb) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygv
 * JD-Core Version:    0.7.0.1
 */