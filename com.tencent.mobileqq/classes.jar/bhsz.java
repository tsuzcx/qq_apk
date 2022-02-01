import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.mobileqq.vas.troopnick.TroopNickFontAdapter.1;
import com.tencent.mobileqq.vas.troopnick.TroopNickFontAdapter.2;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class bhsz
  extends bhqi
{
  public static Map<String, Typeface> a;
  private static int b;
  public TextView a;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public bhsz(TextView paramTextView, bhpm parambhpm, AppRuntime paramAppRuntime, int paramInt)
  {
    super(parambhpm, paramAppRuntime, paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public static Typeface a(int paramInt1, int paramInt2)
  {
    return (Typeface)jdField_a_of_type_JavaUtilMap.get(a(paramInt1, paramInt2));
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    return paramInt1 + "_" + paramInt2;
  }
  
  private boolean a(Typeface paramTypeface)
  {
    if (paramTypeface == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.post(new TroopNickFontAdapter.2(this, paramTypeface));
    return true;
  }
  
  public void b()
  {
    if (AppUtil.isMainProcess()) {}
    for (ga localga = a(this.jdField_a_of_type_Bhpo.a(), this.jdField_a_of_type_Int);; localga = gf.a().a(this.jdField_a_of_type_Bhpo.a(), this.jdField_a_of_type_Int))
    {
      if (localga != null)
      {
        b(localga.jdField_a_of_type_Int, localga.b);
        c();
        if (QLog.isColorLevel()) {
          QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_load," + b);
        }
      }
      return;
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    ThreadManagerV2.executeOnFileThread(new TroopNickFontAdapter.1(this, paramInt1, paramInt2));
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    bhpm localbhpm = new bhpm(localAppRuntime, paramInt1);
    localbhpm.a(new bhsz(this.jdField_a_of_type_AndroidWidgetTextView, localbhpm, localAppRuntime, paramInt2));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_load_start," + b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsz
 * JD-Core Version:    0.7.0.1
 */