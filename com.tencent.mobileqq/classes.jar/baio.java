import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class baio
  extends ClickableSpan
{
  public String a;
  
  public baio(baig parambaig, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (bdbk.a) {
      if (QLog.isColorLevel()) {
        QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag();
      if ((localObject instanceof String)) {
        baig.a((String)localObject);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      boolean bool2 = bdeo.d.matcher((CharSequence)localObject).find();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = bdeo.c.matcher((CharSequence)localObject).find();
      }
      if (bool1)
      {
        if (baiu.f.matcher((CharSequence)localObject).find())
        {
          this.jdField_a_of_type_Baig.a(paramView.getContext(), (String)localObject, 2, baig.a(this.jdField_a_of_type_Baig));
          baig.a("1", null);
          return;
        }
        this.jdField_a_of_type_Baig.a(paramView, (String)localObject);
        baig.a("0", null);
        return;
      }
      if (baiu.a.matcher((CharSequence)localObject).find())
      {
        this.jdField_a_of_type_Baig.a(paramView.getContext(), (String)localObject, 3, baig.a(this.jdField_a_of_type_Baig));
        baig.a("2", null);
        return;
      }
      Matcher localMatcher = baiu.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        this.jdField_a_of_type_Baig.a(paramView.getContext(), (String)localObject, 0, baig.a(this.jdField_a_of_type_Baig));
        baig.a("1", null);
        return;
      }
    } while (!baiu.e.matcher((CharSequence)localObject).find());
    this.jdField_a_of_type_Baig.a(paramView.getContext(), (String)localObject, 1, baig.a(this.jdField_a_of_type_Baig));
    baig.a("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baio
 * JD-Core Version:    0.7.0.1
 */