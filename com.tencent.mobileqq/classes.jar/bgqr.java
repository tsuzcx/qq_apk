import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bgqr
  implements awrd<awoh, awwr>
{
  public void a(awoh paramawoh, awwr paramawwr)
  {
    bgqv localbgqv;
    int i;
    if (((paramawoh instanceof bgqv)) && ((paramawwr instanceof awyh)))
    {
      localbgqv = (bgqv)paramawoh;
      paramawwr = (awyh)paramawwr;
      paramawoh = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((paramawoh != null) && (paramawoh.getStatus() == 2)) {
        paramawoh.restartDownload();
      }
      paramawwr.b().setImageDrawable(paramawoh);
      paramawwr.a().setText(bgqv.b);
      if (localbgqv.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (paramawoh = String.valueOf(i);; paramawoh = "10+")
    {
      ((TextView)paramawwr.a().findViewById(2131365036)).setText(String.format("%s条与\"", new Object[] { paramawoh }));
      paramawoh = (TextView)paramawwr.a().findViewById(2131365030);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        paramawoh.setTextColor(Color.parseColor("#004080"));
      }
      paramawoh.setText(localbgqv.b());
      ((TextView)paramawwr.a().findViewById(2131365037)).setText("\"相关收藏");
      paramawwr.a().setVisibility(8);
      paramawwr.a().setOnClickListener(new bgqs(this, localbgqv));
      return;
      i = localbgqv.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqr
 * JD-Core Version:    0.7.0.1
 */