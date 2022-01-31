import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class awrw
  implements awrb<awoe, awwo>
{
  public void a(awoe paramawoe, awwo paramawwo)
  {
    awyc localawyc = (awyc)paramawwo;
    awnn localawnn;
    Object localObject;
    if ((paramawoe instanceof awnn))
    {
      localawnn = (awnn)paramawoe;
      localObject = localawnn.a();
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
      if (((awnn)paramawoe).b())
      {
        String str = localawnn.b();
        if (!TextUtils.isEmpty(str))
        {
          str = awvy.a(localawyc.a(), 10.0F * awvy.a(localawyc.a(), ajyc.a(2131713647)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localawyc.a().setText((CharSequence)localObject);
          if (!localawnn.a()) {
            break label312;
          }
          paramawwo.b().setText(localawnn.c());
          paramawwo.b().setVisibility(0);
          paramawwo.b().setTag(2131379209, Integer.valueOf(-1));
          if ((paramawoe instanceof awof))
          {
            paramawoe = (awof)paramawoe;
            paramawwo.b().setOnClickListener(new awrx(this, paramawoe));
          }
          paramawoe = paramawwo.a().getTag(2131379209);
          if (!(paramawoe instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)paramawoe).intValue();; i = -1)
      {
        if (i > 0) {
          localawyc.a(true);
        }
        while (i != 0)
        {
          return;
          localawyc.a().setText((CharSequence)localObject);
          break;
          localawyc.a().setText((CharSequence)localObject);
          break;
          paramawwo.b().setVisibility(8);
          break label203;
        }
        localawyc.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrw
 * JD-Core Version:    0.7.0.1
 */