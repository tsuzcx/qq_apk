import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqjc
{
  private int jdField_a_of_type_Int = 0;
  public aqda a;
  private aqjc jdField_a_of_type_Aqjc;
  private int jdField_b_of_type_Int = 0;
  private aqjc jdField_b_of_type_Aqjc;
  private int c;
  private int d;
  private int e;
  
  public aqjc(aqda paramaqda)
  {
    this.jdField_a_of_type_Aqda = paramaqda;
    this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297163);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aqjc a()
  {
    return this.jdField_a_of_type_Aqjc;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(aqjc paramaqjc)
  {
    this.jdField_a_of_type_Aqjc = paramaqjc;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public aqjc b()
  {
    return this.jdField_b_of_type_Aqjc;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(aqjc paramaqjc)
  {
    this.jdField_b_of_type_Aqjc = paramaqjc;
  }
  
  public int c()
  {
    if (this.d != 0)
    {
      if (this.e != 0) {
        return this.d + this.e;
      }
      this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297163);
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
    if ((this.jdField_a_of_type_Aqda != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqda.a)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = aqjd.a(this.jdField_a_of_type_Aqda.a, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_Aqda.a;
      }
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297168);
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setDither(true);
      ((TextPaint)localObject2).setTextSize(i);
      this.c = ((int)((TextPaint)localObject2).measureText((String)localObject1) + (BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297167) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297166) * 2 + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297163) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297164)));
    }
    for (;;)
    {
      return this.c;
      QLog.e("TAG horserace", 2, " GET WIDTH WITH NULL INFO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjc
 * JD-Core Version:    0.7.0.1
 */