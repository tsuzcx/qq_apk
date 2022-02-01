import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arro
{
  private int jdField_a_of_type_Int = 0;
  public arjn a;
  private arro jdField_a_of_type_Arro;
  private int jdField_b_of_type_Int = 0;
  private arro jdField_b_of_type_Arro;
  private int c;
  private int d;
  private int e;
  
  public arro(arjn paramarjn)
  {
    this.jdField_a_of_type_Arjn = paramarjn;
    this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297286);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public arro a()
  {
    return this.jdField_a_of_type_Arro;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(arro paramarro)
  {
    this.jdField_a_of_type_Arro = paramarro;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public arro b()
  {
    return this.jdField_b_of_type_Arro;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(arro paramarro)
  {
    this.jdField_b_of_type_Arro = paramarro;
  }
  
  public int c()
  {
    if (this.d != 0)
    {
      if (this.e != 0) {
        return this.d + this.e;
      }
      this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297286);
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
    if ((this.jdField_a_of_type_Arjn != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Arjn.a)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = arrp.a(this.jdField_a_of_type_Arjn.a, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_Arjn.a;
      }
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297291);
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setDither(true);
      ((TextPaint)localObject2).setTextSize(i);
      this.c = ((int)((TextPaint)localObject2).measureText((String)localObject1) + (BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297290) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297289) * 2 + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297286) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297287)));
    }
    for (;;)
    {
      return this.c;
      QLog.e("TAG horserace", 2, " GET WIDTH WITH NULL INFO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arro
 * JD-Core Version:    0.7.0.1
 */