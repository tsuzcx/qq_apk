import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bkps
  implements bbbn<bays, bbhb>
{
  public void a(bays parambays, bbhb parambbhb)
  {
    bkpw localbkpw;
    int i;
    if (((parambays instanceof bkpw)) && ((parambbhb instanceof bbir)))
    {
      localbkpw = (bkpw)parambays;
      parambbhb = (bbir)parambbhb;
      parambays = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((parambays != null) && (parambays.getStatus() == 2)) {
        parambays.restartDownload();
      }
      parambbhb.b().setImageDrawable(parambays);
      parambbhb.a().setText(bkpw.b);
      if (localbkpw.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (parambays = String.valueOf(i);; parambays = "10+")
    {
      ((TextView)parambbhb.a().findViewById(2131365439)).setText(String.format("%s条与\"", new Object[] { parambays }));
      parambays = (TextView)parambbhb.a().findViewById(2131365433);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        parambays.setTextColor(Color.parseColor("#004080"));
      }
      parambays.setText(localbkpw.b());
      ((TextView)parambbhb.a().findViewById(2131365440)).setText("\"相关收藏");
      parambbhb.a().setVisibility(8);
      parambbhb.a().setOnClickListener(new bkpt(this, localbkpw));
      return;
      i = localbkpw.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkps
 * JD-Core Version:    0.7.0.1
 */