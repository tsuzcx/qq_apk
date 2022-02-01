import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aspc
{
  private int jdField_a_of_type_Int = 0;
  public ashw a;
  private aspc jdField_a_of_type_Aspc;
  private int jdField_b_of_type_Int = 0;
  private aspc jdField_b_of_type_Aspc;
  private int c;
  private int d;
  private int e;
  
  public aspc(ashw paramashw)
  {
    this.jdField_a_of_type_Ashw = paramashw;
    this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297219);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aspc a()
  {
    return this.jdField_a_of_type_Aspc;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(aspc paramaspc)
  {
    this.jdField_a_of_type_Aspc = paramaspc;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public aspc b()
  {
    return this.jdField_b_of_type_Aspc;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(aspc paramaspc)
  {
    this.jdField_b_of_type_Aspc = paramaspc;
  }
  
  public int c()
  {
    if (this.d != 0)
    {
      if (this.e != 0) {
        return this.d + this.e;
      }
      this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297219);
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
    if ((this.jdField_a_of_type_Ashw != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ashw.a)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = aspd.a(this.jdField_a_of_type_Ashw.a, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_Ashw.a;
      }
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297224);
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setDither(true);
      ((TextPaint)localObject2).setTextSize(i);
      this.c = ((int)((TextPaint)localObject2).measureText((String)localObject1) + (BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297223) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297222) * 2 + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297219) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297220)));
    }
    for (;;)
    {
      return this.c;
      QLog.e("TAG horserace", 2, " GET WIDTH WITH NULL INFO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspc
 * JD-Core Version:    0.7.0.1
 */