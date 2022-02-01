import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class begx
  extends ClickableSpan
{
  public String a;
  
  public begx(begp parambegp, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (bhkx.a) {
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
        begp.a((String)localObject);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      boolean bool2 = bhoa.d.matcher((CharSequence)localObject).find();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = bhoa.c.matcher((CharSequence)localObject).find();
      }
      if (bool1)
      {
        if (behd.f.matcher((CharSequence)localObject).find())
        {
          this.jdField_a_of_type_Begp.a(paramView.getContext(), (String)localObject, 2, begp.a(this.jdField_a_of_type_Begp));
          begp.a("1", null);
          return;
        }
        this.jdField_a_of_type_Begp.a(paramView, (String)localObject);
        begp.a("0", null);
        return;
      }
      if (behd.a.matcher((CharSequence)localObject).find())
      {
        this.jdField_a_of_type_Begp.a(paramView.getContext(), (String)localObject, 3, begp.a(this.jdField_a_of_type_Begp));
        begp.a("2", null);
        return;
      }
      Matcher localMatcher = behd.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        this.jdField_a_of_type_Begp.a(paramView.getContext(), (String)localObject, 0, begp.a(this.jdField_a_of_type_Begp));
        begp.a("1", null);
        return;
      }
    } while (!behd.e.matcher((CharSequence)localObject).find());
    this.jdField_a_of_type_Begp.a(paramView.getContext(), (String)localObject, 1, begp.a(this.jdField_a_of_type_Begp));
    begp.a("2", null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begx
 * JD-Core Version:    0.7.0.1
 */