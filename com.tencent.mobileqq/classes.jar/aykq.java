import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aykq
  extends ClickableSpan
{
  public String a;
  
  public aykq(ayki paramayki, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (bbcc.a) {
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
        ayki.a((String)localObject);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      boolean bool2 = bbff.d.matcher((CharSequence)localObject).find();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = bbff.c.matcher((CharSequence)localObject).find();
      }
      if (bool1)
      {
        if (aykw.f.matcher((CharSequence)localObject).find())
        {
          this.jdField_a_of_type_Ayki.a(paramView.getContext(), (String)localObject, 2, ayki.a(this.jdField_a_of_type_Ayki));
          ayki.a("1", null);
          return;
        }
        this.jdField_a_of_type_Ayki.a(paramView, (String)localObject);
        ayki.a("0", null);
        return;
      }
      if (aykw.a.matcher((CharSequence)localObject).find())
      {
        this.jdField_a_of_type_Ayki.a(paramView.getContext(), (String)localObject, 3, ayki.a(this.jdField_a_of_type_Ayki));
        ayki.a("2", null);
        return;
      }
      Matcher localMatcher = aykw.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        this.jdField_a_of_type_Ayki.a(paramView.getContext(), (String)localObject, 0, ayki.a(this.jdField_a_of_type_Ayki));
        ayki.a("1", null);
        return;
      }
    } while (!aykw.e.matcher((CharSequence)localObject).find());
    this.jdField_a_of_type_Ayki.a(paramView.getContext(), (String)localObject, 1, ayki.a(this.jdField_a_of_type_Ayki));
    ayki.a("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykq
 * JD-Core Version:    0.7.0.1
 */