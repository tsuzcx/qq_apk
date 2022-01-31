import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bgqa
  implements awrb<awof, awwp>
{
  public void a(awof paramawof, awwp paramawwp)
  {
    bgqe localbgqe;
    int i;
    if (((paramawof instanceof bgqe)) && ((paramawwp instanceof awyf)))
    {
      localbgqe = (bgqe)paramawof;
      paramawwp = (awyf)paramawwp;
      paramawof = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((paramawof != null) && (paramawof.getStatus() == 2)) {
        paramawof.restartDownload();
      }
      paramawwp.b().setImageDrawable(paramawof);
      paramawwp.a().setText(bgqe.b);
      if (localbgqe.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (paramawof = String.valueOf(i);; paramawof = "10+")
    {
      ((TextView)paramawwp.a().findViewById(2131365037)).setText(String.format("%s条与\"", new Object[] { paramawof }));
      paramawof = (TextView)paramawwp.a().findViewById(2131365031);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        paramawof.setTextColor(Color.parseColor("#004080"));
      }
      paramawof.setText(localbgqe.b());
      ((TextView)paramawwp.a().findViewById(2131365038)).setText("\"相关收藏");
      paramawwp.a().setVisibility(8);
      paramawwp.a().setOnClickListener(new bgqb(this, localbgqe));
      return;
      i = localbgqe.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqa
 * JD-Core Version:    0.7.0.1
 */