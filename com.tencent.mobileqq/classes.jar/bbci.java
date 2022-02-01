import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class bbci
  implements bbbn<bayr, bbha>
{
  public void a(bayr parambayr, bbha parambbha)
  {
    bbio localbbio = (bbio)parambbha;
    baya localbaya;
    Object localObject;
    if ((parambayr instanceof baya))
    {
      localbaya = (baya)parambayr;
      localObject = localbaya.a();
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
      if (((baya)parambayr).b())
      {
        String str = localbaya.b();
        if (!TextUtils.isEmpty(str))
        {
          str = bbgk.a(localbbio.a(), 10.0F * bbgk.a(localbbio.a(), amtj.a(2131712762)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localbbio.a().setText((CharSequence)localObject);
          if (!localbaya.a()) {
            break label312;
          }
          parambbha.b().setText(localbaya.c());
          parambbha.b().setVisibility(0);
          parambbha.b().setTag(2131380832, Integer.valueOf(-1));
          if ((parambayr instanceof bays))
          {
            parambayr = (bays)parambayr;
            parambbha.b().setOnClickListener(new bbcj(this, parambayr));
          }
          parambayr = parambbha.a().getTag(2131380832);
          if (!(parambayr instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)parambayr).intValue();; i = -1)
      {
        if (i > 0) {
          localbbio.a(true);
        }
        while (i != 0)
        {
          return;
          localbbio.a().setText((CharSequence)localObject);
          break;
          localbbio.a().setText((CharSequence)localObject);
          break;
          parambbha.b().setVisibility(8);
          break label203;
        }
        localbbio.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbci
 * JD-Core Version:    0.7.0.1
 */