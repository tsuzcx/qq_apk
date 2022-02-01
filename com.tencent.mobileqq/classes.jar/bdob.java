import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bdob
  extends ClickableSpan
{
  public String a;
  
  public bdob(bdnt parambdnt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (bgkw.a) {
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
        bdnt.a((String)localObject);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      boolean bool2 = bgny.d.matcher((CharSequence)localObject).find();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = bgny.c.matcher((CharSequence)localObject).find();
      }
      if (bool1)
      {
        if (bdoh.f.matcher((CharSequence)localObject).find())
        {
          this.jdField_a_of_type_Bdnt.a(paramView.getContext(), (String)localObject, 2, bdnt.a(this.jdField_a_of_type_Bdnt));
          bdnt.a("1", null);
          return;
        }
        this.jdField_a_of_type_Bdnt.a(paramView, (String)localObject);
        bdnt.a("0", null);
        return;
      }
      if (bdoh.a.matcher((CharSequence)localObject).find())
      {
        this.jdField_a_of_type_Bdnt.a(paramView.getContext(), (String)localObject, 3, bdnt.a(this.jdField_a_of_type_Bdnt));
        bdnt.a("2", null);
        return;
      }
      Matcher localMatcher = bdoh.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        this.jdField_a_of_type_Bdnt.a(paramView.getContext(), (String)localObject, 0, bdnt.a(this.jdField_a_of_type_Bdnt));
        bdnt.a("1", null);
        return;
      }
    } while (!bdoh.e.matcher((CharSequence)localObject).find());
    this.jdField_a_of_type_Bdnt.a(paramView.getContext(), (String)localObject, 1, bdnt.a(this.jdField_a_of_type_Bdnt));
    bdnt.a("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdob
 * JD-Core Version:    0.7.0.1
 */