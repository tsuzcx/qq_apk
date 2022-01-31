import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class awqn
  extends awqq
{
  private List<PhoneContact> a;
  
  public awqn(baxk parambaxk, awqu paramawqu, List<PhoneContact> paramList)
  {
    super(parambaxk, paramawqu);
    this.a = paramList;
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    boolean bool = true;
    super.b(paramawog, paramawwp);
    int i;
    int j;
    if (paramawwp.c() != null)
    {
      paramawog = (awmy)paramawog;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != paramawog.a.contactID) {
          break label197;
        }
        paramawwp.c().setText(ajyc.a(2131702516));
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
      if (!TextUtils.isEmpty(paramawog.c()))
      {
        paramawwp.c().setText(paramawog.c());
        j = 1;
      }
      paramawog = paramawwp.c();
      if (j != 0)
      {
        i = 0;
        paramawog.setVisibility(i);
        paramawog = paramawwp.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        paramawog.setClickable(bool);
        if (paramawwp.a() != null) {
          paramawwp.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(awog paramawog, awwp paramawwp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqn
 * JD-Core Version:    0.7.0.1
 */