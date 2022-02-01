import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class bbfd<T extends View>
{
  protected int a;
  public long a;
  public boolean a;
  
  public bbfd(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bbfd a(int paramInt1, int paramInt2, boolean paramBoolean)
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
      return new bbfm(paramInt2);
    case 1: 
    case 7: 
      return new bbge(paramInt1, paramInt2, paramBoolean);
    case 3: 
      return new bbfe(paramInt2, paramBoolean);
    }
    return new bbhg(paramInt2);
  }
  
  public abstract T a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void a() {}
  
  public void a(bbof parambbof) {}
  
  public void b() {}
  
  public void b(bbof parambbof) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfd
 * JD-Core Version:    0.7.0.1
 */