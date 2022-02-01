import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class bcjg
  implements bcil<bcfp, bcny>
{
  public void a(bcfp parambcfp, bcny parambcny)
  {
    bcpm localbcpm = (bcpm)parambcny;
    bcey localbcey;
    Object localObject;
    if ((parambcfp instanceof bcey))
    {
      localbcey = (bcey)parambcfp;
      localObject = localbcey.a();
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
      if (((bcey)parambcfp).b())
      {
        String str = localbcey.b();
        if (!TextUtils.isEmpty(str))
        {
          str = bcni.a(localbcpm.a(), 10.0F * bcni.a(localbcpm.a(), anzj.a(2131712530)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localbcpm.a().setText((CharSequence)localObject);
          if (!localbcey.a()) {
            break label312;
          }
          parambcny.b().setText(localbcey.c());
          parambcny.b().setVisibility(0);
          parambcny.b().setTag(2131381110, Integer.valueOf(-1));
          if ((parambcfp instanceof bcfq))
          {
            parambcfp = (bcfq)parambcfp;
            parambcny.b().setOnClickListener(new bcjh(this, parambcfp));
          }
          parambcfp = parambcny.a().getTag(2131381110);
          if (!(parambcfp instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)parambcfp).intValue();; i = -1)
      {
        if (i > 0) {
          localbcpm.a(true);
        }
        while (i != 0)
        {
          return;
          localbcpm.a().setText((CharSequence)localObject);
          break;
          localbcpm.a().setText((CharSequence)localObject);
          break;
          parambcny.b().setVisibility(8);
          break label203;
        }
        localbcpm.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjg
 * JD-Core Version:    0.7.0.1
 */