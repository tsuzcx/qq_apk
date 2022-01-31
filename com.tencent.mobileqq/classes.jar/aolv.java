import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aolv
{
  private int jdField_a_of_type_Int = 0;
  public aogn a;
  private aolv jdField_a_of_type_Aolv;
  private int jdField_b_of_type_Int = 0;
  private aolv jdField_b_of_type_Aolv;
  private int c;
  private int d;
  private int e;
  
  public aolv(aogn paramaogn)
  {
    this.jdField_a_of_type_Aogn = paramaogn;
    this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297146);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aolv a()
  {
    return this.jdField_a_of_type_Aolv;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(aolv paramaolv)
  {
    this.jdField_a_of_type_Aolv = paramaolv;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public aolv b()
  {
    return this.jdField_b_of_type_Aolv;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(aolv paramaolv)
  {
    this.jdField_b_of_type_Aolv = paramaolv;
  }
  
  public int c()
  {
    if (this.d != 0)
    {
      if (this.e != 0) {
        return this.d + this.e;
      }
      this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297146);
      return this.d + this.e;
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int d()
  {
    if (this.c != 0) {
      return this.c;
    }
    if ((this.jdField_a_of_type_Aogn != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aogn.a)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = aolw.a(this.jdField_a_of_type_Aogn.a, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_Aogn.a;
      }
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297151);
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setDither(true);
      ((TextPaint)localObject2).setTextSize(i);
      this.c = ((int)((TextPaint)localObject2).measureText((String)localObject1) + (BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297150) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297149) * 2 + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297146) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297147)));
    }
    for (;;)
    {
      return this.c;
      QLog.e("TAG horserace", 2, " GET WIDTH WITH NULL INFO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aolv
 * JD-Core Version:    0.7.0.1
 */