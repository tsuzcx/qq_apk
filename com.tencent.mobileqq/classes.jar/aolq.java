import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aolq
{
  private int jdField_a_of_type_Int = 0;
  public aogi a;
  private aolq jdField_a_of_type_Aolq;
  private int jdField_b_of_type_Int = 0;
  private aolq jdField_b_of_type_Aolq;
  private int c;
  private int d;
  private int e;
  
  public aolq(aogi paramaogi)
  {
    this.jdField_a_of_type_Aogi = paramaogi;
    this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297146);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aolq a()
  {
    return this.jdField_a_of_type_Aolq;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(aolq paramaolq)
  {
    this.jdField_a_of_type_Aolq = paramaolq;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public aolq b()
  {
    return this.jdField_b_of_type_Aolq;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(aolq paramaolq)
  {
    this.jdField_b_of_type_Aolq = paramaolq;
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
    if ((this.jdField_a_of_type_Aogi != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aogi.a)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = aolr.a(this.jdField_a_of_type_Aogi.a, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_Aogi.a;
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
 * Qualified Name:     aolq
 * JD-Core Version:    0.7.0.1
 */