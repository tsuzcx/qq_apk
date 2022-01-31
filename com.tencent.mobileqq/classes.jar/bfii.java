import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bfii
  implements avri<avom, avww>
{
  public void a(avom paramavom, avww paramavww)
  {
    bfim localbfim;
    int i;
    if (((paramavom instanceof bfim)) && ((paramavww instanceof avym)))
    {
      localbfim = (bfim)paramavom;
      paramavww = (avym)paramavww;
      paramavom = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((paramavom != null) && (paramavom.getStatus() == 2)) {
        paramavom.restartDownload();
      }
      paramavww.b().setImageDrawable(paramavom);
      paramavww.a().setText(bfim.b);
      if (localbfim.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (paramavom = String.valueOf(i);; paramavom = "10+")
    {
      ((TextView)paramavww.a().findViewById(2131299469)).setText(String.format("%s条与\"", new Object[] { paramavom }));
      paramavom = (TextView)paramavww.a().findViewById(2131299463);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        paramavom.setTextColor(Color.parseColor("#004080"));
      }
      paramavom.setText(localbfim.b());
      ((TextView)paramavww.a().findViewById(2131299470)).setText("\"相关收藏");
      paramavww.a().setVisibility(8);
      paramavww.a().setOnClickListener(new bfij(this, localbfim));
      return;
      i = localbfim.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfii
 * JD-Core Version:    0.7.0.1
 */