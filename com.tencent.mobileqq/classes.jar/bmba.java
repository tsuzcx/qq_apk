import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bmba
  implements bcif<bcfi, bcnt>
{
  public void a(bcfi parambcfi, bcnt parambcnt)
  {
    bmbe localbmbe;
    int i;
    if (((parambcfi instanceof bmbe)) && ((parambcnt instanceof bcpj)))
    {
      localbmbe = (bmbe)parambcfi;
      parambcnt = (bcpj)parambcnt;
      parambcfi = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((parambcfi != null) && (parambcfi.getStatus() == 2)) {
        parambcfi.restartDownload();
      }
      parambcnt.b().setImageDrawable(parambcfi);
      parambcnt.a().setText(bmbe.b);
      if (localbmbe.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (parambcfi = String.valueOf(i);; parambcfi = "10+")
    {
      ((TextView)parambcnt.a().findViewById(2131365532)).setText(String.format("%s条与\"", new Object[] { parambcfi }));
      parambcfi = (TextView)parambcnt.a().findViewById(2131365526);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        parambcfi.setTextColor(Color.parseColor("#004080"));
      }
      parambcfi.setText(localbmbe.b());
      ((TextView)parambcnt.a().findViewById(2131365533)).setText("\"相关收藏");
      parambcnt.a().setVisibility(8);
      parambcnt.a().setOnClickListener(new bmbb(this, localbmbe));
      return;
      i = localbmbe.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmba
 * JD-Core Version:    0.7.0.1
 */