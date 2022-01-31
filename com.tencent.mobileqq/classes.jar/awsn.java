import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Set;

public class awsn
  extends awqs
{
  public awsn(baxy parambaxy, awqw paramawqw, Set<String> paramSet)
  {
    super(parambaxy, paramawqw, paramSet);
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    boolean bool = true;
    super.b(paramawoi, paramawwr);
    if (paramawwr.c() != null)
    {
      paramawoi = (awne)paramawoi;
      if ((this.a == null) || (!this.a.contains(paramawoi.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramawoi.c()))
      {
        paramawwr.c().setText(paramawoi.c());
        i = 1;
      }
      paramawoi = paramawwr.c();
      int j;
      if (i != 0)
      {
        j = 0;
        paramawoi.setVisibility(j);
        paramawoi = paramawwr.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        paramawoi.setClickable(bool);
        if (paramawwr.a() != null) {
          paramawwr.a().setVisibility(8);
        }
        return;
        j = 8;
        break;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsn
 * JD-Core Version:    0.7.0.1
 */