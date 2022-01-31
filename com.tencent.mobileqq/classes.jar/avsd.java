import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class avsd
  implements avri<avol, avwv>
{
  public void a(avol paramavol, avwv paramavwv)
  {
    avyj localavyj = (avyj)paramavwv;
    avnu localavnu;
    Object localObject;
    if ((paramavol instanceof avnu))
    {
      localavnu = (avnu)paramavol;
      localObject = localavnu.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label342;
      }
      localObject = "";
    }
    label203:
    label337:
    label342:
    for (;;)
    {
      if (((avnu)paramavol).b())
      {
        String str = localavnu.b();
        if (!TextUtils.isEmpty(str))
        {
          str = avwf.a(localavyj.a(), 10.0F * avwf.a(localavyj.a(), ajjy.a(2131647860)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localavyj.a().setText((CharSequence)localObject);
          if (!localavnu.a()) {
            break label312;
          }
          paramavwv.b().setText(localavnu.c());
          paramavwv.b().setVisibility(0);
          paramavwv.b().setTag(2131313374, Integer.valueOf(-1));
          if ((paramavol instanceof avom))
          {
            paramavol = (avom)paramavol;
            paramavwv.b().setOnClickListener(new avse(this, paramavol));
          }
          paramavol = paramavwv.a().getTag(2131313374);
          if (!(paramavol instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)paramavol).intValue();; i = -1)
      {
        if (i > 0) {
          localavyj.a(true);
        }
        while (i != 0)
        {
          return;
          localavyj.a().setText((CharSequence)localObject);
          break;
          localavyj.a().setText((CharSequence)localObject);
          break;
          paramavwv.b().setVisibility(8);
          break label203;
        }
        localavyj.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsd
 * JD-Core Version:    0.7.0.1
 */