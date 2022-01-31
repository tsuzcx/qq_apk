import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class aynb
  implements aymg<ayjj, ayrt>
{
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    ayth localayth = (ayth)paramayrt;
    ayis localayis;
    Object localObject;
    if ((paramayjj instanceof ayis))
    {
      localayis = (ayis)paramayjj;
      localObject = localayis.a();
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
      if (((ayis)paramayjj).b())
      {
        String str = localayis.b();
        if (!TextUtils.isEmpty(str))
        {
          str = ayrd.a(localayth.a(), 10.0F * ayrd.a(localayth.a(), alpo.a(2131714030)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localayth.a().setText((CharSequence)localObject);
          if (!localayis.a()) {
            break label312;
          }
          paramayrt.b().setText(localayis.c());
          paramayrt.b().setVisibility(0);
          paramayrt.b().setTag(2131379914, Integer.valueOf(-1));
          if ((paramayjj instanceof ayjk))
          {
            paramayjj = (ayjk)paramayjj;
            paramayrt.b().setOnClickListener(new aync(this, paramayjj));
          }
          paramayjj = paramayrt.a().getTag(2131379914);
          if (!(paramayjj instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)paramayjj).intValue();; i = -1)
      {
        if (i > 0) {
          localayth.a(true);
        }
        while (i != 0)
        {
          return;
          localayth.a().setText((CharSequence)localObject);
          break;
          localayth.a().setText((CharSequence)localObject);
          break;
          paramayrt.b().setVisibility(8);
          break label203;
        }
        localayth.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynb
 * JD-Core Version:    0.7.0.1
 */