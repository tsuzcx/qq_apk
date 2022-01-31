import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class awry
  implements awrd<awog, awwq>
{
  public void a(awog paramawog, awwq paramawwq)
  {
    awye localawye = (awye)paramawwq;
    awnp localawnp;
    Object localObject;
    if ((paramawog instanceof awnp))
    {
      localawnp = (awnp)paramawog;
      localObject = localawnp.a();
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
      if (((awnp)paramawog).b())
      {
        String str = localawnp.b();
        if (!TextUtils.isEmpty(str))
        {
          str = awwa.a(localawye.a(), 10.0F * awwa.a(localawye.a(), ajya.a(2131713658)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localawye.a().setText((CharSequence)localObject);
          if (!localawnp.a()) {
            break label312;
          }
          paramawwq.b().setText(localawnp.c());
          paramawwq.b().setVisibility(0);
          paramawwq.b().setTag(2131379214, Integer.valueOf(-1));
          if ((paramawog instanceof awoh))
          {
            paramawog = (awoh)paramawog;
            paramawwq.b().setOnClickListener(new awrz(this, paramawog));
          }
          paramawog = paramawwq.a().getTag(2131379214);
          if (!(paramawog instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)paramawog).intValue();; i = -1)
      {
        if (i > 0) {
          localawye.a(true);
        }
        while (i != 0)
        {
          return;
          localawye.a().setText((CharSequence)localObject);
          break;
          localawye.a().setText((CharSequence)localObject);
          break;
          paramawwq.b().setVisibility(8);
          break label203;
        }
        localawye.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awry
 * JD-Core Version:    0.7.0.1
 */