import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bmll
  implements bcil<bcfq, bcnz>
{
  public void a(bcfq parambcfq, bcnz parambcnz)
  {
    bmlp localbmlp;
    int i;
    if (((parambcfq instanceof bmlp)) && ((parambcnz instanceof bcpp)))
    {
      localbmlp = (bmlp)parambcfq;
      parambcnz = (bcpp)parambcnz;
      parambcfq = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((parambcfq != null) && (parambcfq.getStatus() == 2)) {
        parambcfq.restartDownload();
      }
      parambcnz.b().setImageDrawable(parambcfq);
      parambcnz.a().setText(bmlp.b);
      if (localbmlp.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (parambcfq = String.valueOf(i);; parambcfq = "10+")
    {
      ((TextView)parambcnz.a().findViewById(2131365407)).setText(String.format("%s条与\"", new Object[] { parambcfq }));
      parambcfq = (TextView)parambcnz.a().findViewById(2131365401);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        parambcfq.setTextColor(Color.parseColor("#004080"));
      }
      parambcfq.setText(localbmlp.b());
      ((TextView)parambcnz.a().findViewById(2131365408)).setText("\"相关收藏");
      parambcnz.a().setVisibility(8);
      parambcnz.a().setOnClickListener(new bmlm(this, localbmlp));
      return;
      i = localbmlp.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmll
 * JD-Core Version:    0.7.0.1
 */