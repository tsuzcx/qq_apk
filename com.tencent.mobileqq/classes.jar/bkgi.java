import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.vip.qqbanner.QbossADBannerCountDownManager.1;
import cooperation.vip.qqbanner.QbossADBannerCountDownManager.2;
import java.util.Timer;
import java.util.TimerTask;

public class bkgi
  extends ajir
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bkgh jdField_a_of_type_Bkgh;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private TextView b;
  private TextView c;
  
  private Drawable a(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(bdoo.b(20.0F));
    localGradientDrawable.setColor(a(paramString));
    return localGradientDrawable;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_Bkgh == null) {
      return "";
    }
    if (this.jdField_a_of_type_Bkgh.d != 1) {
      return this.jdField_a_of_type_Bkgh.h;
    }
    return a(this.jdField_a_of_type_Bkgh.e, this.jdField_a_of_type_Bkgh.f);
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    String str1;
    String str2;
    if (paramInt1 > 99)
    {
      str1 = "99";
      if (paramInt2 <= 59) {
        break label106;
      }
      str2 = "59";
    }
    for (;;)
    {
      return str1 + ":" + str2;
      if ((paramInt1 >= 10) && (paramInt1 <= 99))
      {
        str1 = String.valueOf(paramInt1);
        break;
      }
      if ((paramInt1 >= 0) && (paramInt1 < 10))
      {
        str1 = "0" + String.valueOf(paramInt1);
        break;
      }
      str1 = "00";
      break;
      label106:
      if ((paramInt2 >= 10) && (paramInt2 <= 59)) {
        str2 = String.valueOf(paramInt2);
      } else if ((paramInt2 >= 0) && (paramInt2 < 10)) {
        str2 = "0" + String.valueOf(paramInt2);
      } else {
        str2 = "00";
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.c.setText(paramString);
  }
  
  private void i()
  {
    j();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimerTask = new QbossADBannerCountDownManager.2(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 1000L);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_JavaUtilTimerTask = null;
  }
  
  protected int a()
  {
    return 2131561735;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378879));
    this.b = ((TextView)localView.findViewById(2131378992));
    this.c = ((TextView)localView.findViewById(2131378676));
    return localView;
  }
  
  protected void a(ajin paramajin)
  {
    super.a(paramajin);
    ThreadManagerV2.getUIHandlerV2().post(new QbossADBannerCountDownManager.1(this, paramajin));
  }
  
  public void e()
  {
    super.e();
    j();
  }
  
  public void f()
  {
    super.f();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgi
 * JD-Core Version:    0.7.0.1
 */