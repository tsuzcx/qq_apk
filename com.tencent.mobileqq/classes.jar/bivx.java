import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bivx
  implements ayqp<aynt, aywd>
{
  public void a(aynt paramaynt, aywd paramaywd)
  {
    biwb localbiwb;
    int i;
    if (((paramaynt instanceof biwb)) && ((paramaywd instanceof ayxt)))
    {
      localbiwb = (biwb)paramaynt;
      paramaywd = (ayxt)paramaywd;
      paramaynt = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((paramaynt != null) && (paramaynt.getStatus() == 2)) {
        paramaynt.restartDownload();
      }
      paramaywd.b().setImageDrawable(paramaynt);
      paramaywd.a().setText(biwb.b);
      if (localbiwb.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (paramaynt = String.valueOf(i);; paramaynt = "10+")
    {
      ((TextView)paramaywd.a().findViewById(2131365123)).setText(String.format("%s条与\"", new Object[] { paramaynt }));
      paramaynt = (TextView)paramaywd.a().findViewById(2131365117);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        paramaynt.setTextColor(Color.parseColor("#004080"));
      }
      paramaynt.setText(localbiwb.b());
      ((TextView)paramaywd.a().findViewById(2131365124)).setText("\"相关收藏");
      paramaywd.a().setVisibility(8);
      paramaywd.a().setOnClickListener(new bivy(this, localbiwb));
      return;
      i = localbiwb.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivx
 * JD-Core Version:    0.7.0.1
 */