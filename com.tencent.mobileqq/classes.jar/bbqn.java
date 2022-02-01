import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class bbqn
  implements bbps<bbmw, bbvf>
{
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    bbwt localbbwt = (bbwt)parambbvf;
    bbmf localbbmf;
    Object localObject;
    if ((parambbmw instanceof bbmf))
    {
      localbbmf = (bbmf)parambbmw;
      localObject = localbbmf.a();
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
      if (((bbmf)parambbmw).b())
      {
        String str = localbbmf.b();
        if (!TextUtils.isEmpty(str))
        {
          str = bbup.a(localbbwt.a(), 10.0F * bbup.a(localbbwt.a(), anni.a(2131712421)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localbbwt.a().setText((CharSequence)localObject);
          if (!localbbmf.a()) {
            break label312;
          }
          parambbvf.b().setText(localbbmf.c());
          parambbvf.b().setVisibility(0);
          parambbvf.b().setTag(2131380930, Integer.valueOf(-1));
          if ((parambbmw instanceof bbmx))
          {
            parambbmw = (bbmx)parambbmw;
            parambbvf.b().setOnClickListener(new bbqo(this, parambbmw));
          }
          parambbmw = parambbvf.a().getTag(2131380930);
          if (!(parambbmw instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)parambbmw).intValue();; i = -1)
      {
        if (i > 0) {
          localbbwt.a(true);
        }
        while (i != 0)
        {
          return;
          localbbwt.a().setText((CharSequence)localObject);
          break;
          localbbwt.a().setText((CharSequence)localObject);
          break;
          parambbvf.b().setVisibility(8);
          break label203;
        }
        localbbwt.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqn
 * JD-Core Version:    0.7.0.1
 */