import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class asvu
{
  private int jdField_a_of_type_Int = 0;
  public asnt a;
  private asvu jdField_a_of_type_Asvu;
  private int jdField_b_of_type_Int = 0;
  private asvu jdField_b_of_type_Asvu;
  private int c;
  private int d;
  private int e;
  
  public asvu(asnt paramasnt)
  {
    this.jdField_a_of_type_Asnt = paramasnt;
    this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297287);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public asvu a()
  {
    return this.jdField_a_of_type_Asvu;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(asvu paramasvu)
  {
    this.jdField_a_of_type_Asvu = paramasvu;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public asvu b()
  {
    return this.jdField_b_of_type_Asvu;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(asvu paramasvu)
  {
    this.jdField_b_of_type_Asvu = paramasvu;
  }
  
  public int c()
  {
    if (this.d != 0)
    {
      if (this.e != 0) {
        return this.d + this.e;
      }
      this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297287);
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
    if ((this.jdField_a_of_type_Asnt != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Asnt.a)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = asvv.a(this.jdField_a_of_type_Asnt.a, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_Asnt.a;
      }
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297292);
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setDither(true);
      ((TextPaint)localObject2).setTextSize(i);
      this.c = ((int)((TextPaint)localObject2).measureText((String)localObject1) + (BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297291) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297290) * 2 + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297287) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297288)));
    }
    for (;;)
    {
      return this.c;
      QLog.e("TAG horserace", 2, " GET WIDTH WITH NULL INFO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvu
 * JD-Core Version:    0.7.0.1
 */