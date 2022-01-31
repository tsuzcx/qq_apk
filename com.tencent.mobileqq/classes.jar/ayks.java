import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ayks
  extends ClickableSpan
{
  public String a;
  
  public ayks(aykk paramaykk, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (bbcq.a) {
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
        aykk.a((String)localObject);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      boolean bool2 = bbft.d.matcher((CharSequence)localObject).find();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = bbft.c.matcher((CharSequence)localObject).find();
      }
      if (bool1)
      {
        if (ayky.f.matcher((CharSequence)localObject).find())
        {
          this.jdField_a_of_type_Aykk.a(paramView.getContext(), (String)localObject, 2, aykk.a(this.jdField_a_of_type_Aykk));
          aykk.a("1", null);
          return;
        }
        this.jdField_a_of_type_Aykk.a(paramView, (String)localObject);
        aykk.a("0", null);
        return;
      }
      if (ayky.a.matcher((CharSequence)localObject).find())
      {
        this.jdField_a_of_type_Aykk.a(paramView.getContext(), (String)localObject, 3, aykk.a(this.jdField_a_of_type_Aykk));
        aykk.a("2", null);
        return;
      }
      Matcher localMatcher = ayky.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        this.jdField_a_of_type_Aykk.a(paramView.getContext(), (String)localObject, 0, aykk.a(this.jdField_a_of_type_Aykk));
        aykk.a("1", null);
        return;
      }
    } while (!ayky.e.matcher((CharSequence)localObject).find());
    this.jdField_a_of_type_Aykk.a(paramView.getContext(), (String)localObject, 1, aykk.a(this.jdField_a_of_type_Aykk));
    aykk.a("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayks
 * JD-Core Version:    0.7.0.1
 */