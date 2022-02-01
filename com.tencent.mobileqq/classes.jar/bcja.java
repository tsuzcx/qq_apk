import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class bcja
  implements bcif<bcfh, bcns>
{
  public void a(bcfh parambcfh, bcns parambcns)
  {
    bcpg localbcpg = (bcpg)parambcns;
    bceq localbceq;
    Object localObject;
    if ((parambcfh instanceof bceq))
    {
      localbceq = (bceq)parambcfh;
      localObject = localbceq.a();
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
      if (((bceq)parambcfh).b())
      {
        String str = localbceq.b();
        if (!TextUtils.isEmpty(str))
        {
          str = bcnc.a(localbcpg.a(), 10.0F * bcnc.a(localbcpg.a(), anvx.a(2131713109)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localbcpg.a().setText((CharSequence)localObject);
          if (!localbceq.a()) {
            break label312;
          }
          parambcns.b().setText(localbceq.c());
          parambcns.b().setVisibility(0);
          parambcns.b().setTag(2131381184, Integer.valueOf(-1));
          if ((parambcfh instanceof bcfi))
          {
            parambcfh = (bcfi)parambcfh;
            parambcns.b().setOnClickListener(new bcjb(this, parambcfh));
          }
          parambcfh = parambcns.a().getTag(2131381184);
          if (!(parambcfh instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)parambcfh).intValue();; i = -1)
      {
        if (i > 0) {
          localbcpg.a(true);
        }
        while (i != 0)
        {
          return;
          localbcpg.a().setText((CharSequence)localObject);
          break;
          localbcpg.a().setText((CharSequence)localObject);
          break;
          parambcns.b().setVisibility(8);
          break label203;
        }
        localbcpg.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcja
 * JD-Core Version:    0.7.0.1
 */