import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class birq
  implements aymg<ayjk, ayru>
{
  public void a(ayjk paramayjk, ayru paramayru)
  {
    biru localbiru;
    int i;
    if (((paramayjk instanceof biru)) && ((paramayru instanceof aytk)))
    {
      localbiru = (biru)paramayjk;
      paramayru = (aytk)paramayru;
      paramayjk = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((paramayjk != null) && (paramayjk.getStatus() == 2)) {
        paramayjk.restartDownload();
      }
      paramayru.b().setImageDrawable(paramayjk);
      paramayru.a().setText(biru.b);
      if (localbiru.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (paramayjk = String.valueOf(i);; paramayjk = "10+")
    {
      ((TextView)paramayru.a().findViewById(2131365121)).setText(String.format("%s条与\"", new Object[] { paramayjk }));
      paramayjk = (TextView)paramayru.a().findViewById(2131365115);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        paramayjk.setTextColor(Color.parseColor("#004080"));
      }
      paramayjk.setText(localbiru.b());
      ((TextView)paramayru.a().findViewById(2131365122)).setText("\"相关收藏");
      paramayru.a().setVisibility(8);
      paramayru.a().setOnClickListener(new birr(this, localbiru));
      return;
      i = localbiru.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birq
 * JD-Core Version:    0.7.0.1
 */