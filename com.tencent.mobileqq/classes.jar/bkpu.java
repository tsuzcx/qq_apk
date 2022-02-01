import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.text.QQText;
import mqq.app.AppRuntime;

public class bkpu
  extends bayu
{
  private static ForegroundColorSpan jdField_a_of_type_AndroidTextStyleForegroundColorSpan = new ForegroundColorSpan(bbgk.b());
  public int a;
  public long a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_JavaLangCharSequence == null) && (this.jdField_b_of_type_JavaLangString != null))
    {
      QQText localQQText = new QQText(this.jdField_b_of_type_JavaLangString, 3, 20);
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_c_of_type_Int > this.jdField_b_of_type_Int)) {
        localQQText.setSpan(jdField_a_of_type_AndroidTextStyleForegroundColorSpan, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, 33);
      }
      this.jdField_a_of_type_JavaLangCharSequence = localQQText;
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
    bkox.a(localBaseActivity, localBaseActivity.getAppRuntime().getAccount(), this.jdField_a_of_type_Long);
    bbgk.a(this.jdField_a_of_type_JavaLangString, 60, 0, paramView);
    if ((localBaseActivity instanceof UniteSearchActivity)) {
      bbgk.a("all_result", "clk_collect", new String[] { "" + this.jdField_a_of_type_JavaLangString });
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return null;
  }
  
  public String b()
  {
    if (this.jdField_c_of_type_Long == 0L) {
      return null;
    }
    return "" + this.jdField_c_of_type_Long;
  }
  
  public int c()
  {
    switch (this.e)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 4;
    }
    return 101;
  }
  
  public CharSequence c()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      if (this.jdField_a_of_type_Int == 1) {
        localSpannableStringBuilder.append("来自: ").append(this.jdField_c_of_type_JavaLangString).setSpan(jdField_a_of_type_AndroidTextStyleForegroundColorSpan, this.jdField_b_of_type_Int + 4, this.jdField_c_of_type_Int + 4, 33);
      }
    }
    else {
      return localSpannableStringBuilder;
    }
    return localSpannableStringBuilder.append("来自: ").append(bbgk.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 30));
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpu
 * JD-Core Version:    0.7.0.1
 */