import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class awqp
  extends awqs
{
  private List<PhoneContact> a;
  
  public awqp(baxy parambaxy, awqw paramawqw, List<PhoneContact> paramList)
  {
    super(parambaxy, paramawqw);
    this.a = paramList;
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    boolean bool = true;
    super.b(paramawoi, paramawwr);
    int i;
    int j;
    if (paramawwr.c() != null)
    {
      paramawoi = (awna)paramawoi;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != paramawoi.a.contactID) {
          break label197;
        }
        paramawwr.c().setText(ajya.a(2131702527));
        i = 1;
      }
    }
    label191:
    label197:
    for (;;)
    {
      break;
      j = 0;
      label101:
      if (!TextUtils.isEmpty(paramawoi.c()))
      {
        paramawwr.c().setText(paramawoi.c());
        j = 1;
      }
      paramawoi = paramawwr.c();
      if (j != 0)
      {
        i = 0;
        paramawoi.setVisibility(i);
        paramawoi = paramawwr.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        paramawoi.setClickable(bool);
        if (paramawwr.a() != null) {
          paramawwr.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(awoi paramawoi, awwr paramawwr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqp
 * JD-Core Version:    0.7.0.1
 */