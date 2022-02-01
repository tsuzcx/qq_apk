import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class bchr
  extends bchu
{
  private List<PhoneContact> a;
  
  public bchr(FaceDecoder paramFaceDecoder, bchy parambchy, List<PhoneContact> paramList)
  {
    super(paramFaceDecoder, parambchy);
    this.a = paramList;
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    boolean bool = true;
    super.b(parambcfj, parambcnt);
    int i;
    int j;
    if (parambcnt.c() != null)
    {
      parambcfj = (bceb)parambcfj;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != parambcfj.a.contactID) {
          break label197;
        }
        parambcnt.c().setText(anvx.a(2131702011));
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
      if (!TextUtils.isEmpty(parambcfj.c()))
      {
        parambcnt.c().setText(parambcfj.c());
        j = 1;
      }
      parambcfj = parambcnt.c();
      if (j != 0)
      {
        i = 0;
        parambcfj.setVisibility(i);
        parambcfj = parambcnt.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        parambcfj.setClickable(bool);
        if (parambcnt.a() != null) {
          parambcnt.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(bcfj parambcfj, bcnt parambcnt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchr
 * JD-Core Version:    0.7.0.1
 */