import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class blki
  implements bbps<bbmx, bbvg>
{
  public void a(bbmx parambbmx, bbvg parambbvg)
  {
    blkm localblkm;
    int i;
    if (((parambbmx instanceof blkm)) && ((parambbvg instanceof bbww)))
    {
      localblkm = (blkm)parambbmx;
      parambbvg = (bbww)parambbvg;
      parambbmx = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((parambbmx != null) && (parambbmx.getStatus() == 2)) {
        parambbmx.restartDownload();
      }
      parambbvg.b().setImageDrawable(parambbmx);
      parambbvg.a().setText(blkm.b);
      if (localblkm.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (parambbmx = String.valueOf(i);; parambbmx = "10+")
    {
      ((TextView)parambbvg.a().findViewById(2131365363)).setText(String.format("%s条与\"", new Object[] { parambbmx }));
      parambbmx = (TextView)parambbvg.a().findViewById(2131365357);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        parambbmx.setTextColor(Color.parseColor("#004080"));
      }
      parambbmx.setText(localblkm.b());
      ((TextView)parambbvg.a().findViewById(2131365364)).setText("\"相关收藏");
      parambbvg.a().setVisibility(8);
      parambbvg.a().setOnClickListener(new blkj(this, localblkm));
      return;
      i = localblkm.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blki
 * JD-Core Version:    0.7.0.1
 */