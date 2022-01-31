import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class ayrk
  implements ayqp<ayns, aywc>
{
  public void a(ayns paramayns, aywc paramaywc)
  {
    ayxq localayxq = (ayxq)paramaywc;
    aynb localaynb;
    Object localObject;
    if ((paramayns instanceof aynb))
    {
      localaynb = (aynb)paramayns;
      localObject = localaynb.a();
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
      if (((aynb)paramayns).b())
      {
        String str = localaynb.b();
        if (!TextUtils.isEmpty(str))
        {
          str = ayvm.a(localayxq.a(), 10.0F * ayvm.a(localayxq.a(), alud.a(2131714042)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localayxq.a().setText((CharSequence)localObject);
          if (!localaynb.a()) {
            break label312;
          }
          paramaywc.b().setText(localaynb.c());
          paramaywc.b().setVisibility(0);
          paramaywc.b().setTag(2131379972, Integer.valueOf(-1));
          if ((paramayns instanceof aynt))
          {
            paramayns = (aynt)paramayns;
            paramaywc.b().setOnClickListener(new ayrl(this, paramayns));
          }
          paramayns = paramaywc.a().getTag(2131379972);
          if (!(paramayns instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)paramayns).intValue();; i = -1)
      {
        if (i > 0) {
          localayxq.a(true);
        }
        while (i != 0)
        {
          return;
          localayxq.a().setText((CharSequence)localObject);
          break;
          localayxq.a().setText((CharSequence)localObject);
          break;
          paramaywc.b().setVisibility(8);
          break label203;
        }
        localayxq.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrk
 * JD-Core Version:    0.7.0.1
 */