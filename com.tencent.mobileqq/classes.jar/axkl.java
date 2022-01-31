import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class axkl
  extends ClickableSpan
{
  public String a;
  
  public axkl(axkd paramaxkd, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (baay.a) {
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
        axkd.a((String)localObject);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      boolean bool2 = baea.d.matcher((CharSequence)localObject).find();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = baea.c.matcher((CharSequence)localObject).find();
      }
      if (bool1)
      {
        if (axkd.f.matcher((CharSequence)localObject).find())
        {
          this.jdField_a_of_type_Axkd.a(paramView.getContext(), (String)localObject, 2, axkd.a(this.jdField_a_of_type_Axkd));
          axkd.a("1", null);
          return;
        }
        this.jdField_a_of_type_Axkd.a(paramView, (String)localObject);
        axkd.a("0", null);
        return;
      }
      Matcher localMatcher = axkd.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        this.jdField_a_of_type_Axkd.a(paramView.getContext(), (String)localObject, 0, axkd.a(this.jdField_a_of_type_Axkd));
        axkd.a("1", null);
        return;
      }
    } while (!axkd.e.matcher((CharSequence)localObject).find());
    this.jdField_a_of_type_Axkd.a(paramView.getContext(), (String)localObject, 1, axkd.a(this.jdField_a_of_type_Axkd));
    axkd.a("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axkl
 * JD-Core Version:    0.7.0.1
 */