import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class atfg
{
  private int jdField_a_of_type_Int = 0;
  public asxk a;
  private atfg jdField_a_of_type_Atfg;
  private int jdField_b_of_type_Int = 0;
  private atfg jdField_b_of_type_Atfg;
  private int c;
  private int d;
  private int e;
  
  public atfg(asxk paramasxk)
  {
    this.jdField_a_of_type_Asxk = paramasxk;
    this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297231);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public atfg a()
  {
    return this.jdField_a_of_type_Atfg;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(atfg paramatfg)
  {
    this.jdField_a_of_type_Atfg = paramatfg;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public atfg b()
  {
    return this.jdField_b_of_type_Atfg;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(atfg paramatfg)
  {
    this.jdField_b_of_type_Atfg = paramatfg;
  }
  
  public int c()
  {
    if (this.d != 0)
    {
      if (this.e != 0) {
        return this.d + this.e;
      }
      this.e = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297231);
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
    if ((this.jdField_a_of_type_Asxk != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Asxk.a)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = atfh.a(this.jdField_a_of_type_Asxk.a, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_Asxk.a;
      }
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297236);
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setDither(true);
      ((TextPaint)localObject2).setTextSize(i);
      this.c = ((int)((TextPaint)localObject2).measureText((String)localObject1) + (BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297235) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297234) * 2 + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297231) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297232)));
    }
    for (;;)
    {
      return this.c;
      QLog.e("TAG horserace", 2, " GET WIDTH WITH NULL INFO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfg
 * JD-Core Version:    0.7.0.1
 */