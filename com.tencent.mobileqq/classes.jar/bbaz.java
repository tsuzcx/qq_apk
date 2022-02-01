import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class bbaz
  extends bbbc
{
  private List<PhoneContact> a;
  
  public bbaz(FaceDecoder paramFaceDecoder, bbbg parambbbg, List<PhoneContact> paramList)
  {
    super(paramFaceDecoder, parambbbg);
    this.a = paramList;
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    boolean bool = true;
    super.b(parambayt, parambbhb);
    int i;
    int j;
    if (parambbhb.c() != null)
    {
      parambayt = (baxl)parambayt;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != parambayt.a.contactID) {
          break label197;
        }
        parambbhb.c().setText(amtj.a(2131701660));
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
      if (!TextUtils.isEmpty(parambayt.c()))
      {
        parambbhb.c().setText(parambayt.c());
        j = 1;
      }
      parambayt = parambbhb.c();
      if (j != 0)
      {
        i = 0;
        parambayt.setVisibility(i);
        parambayt = parambbhb.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        parambayt.setClickable(bool);
        if (parambbhb.a() != null) {
          parambbhb.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(bayt parambayt, bbhb parambbhb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaz
 * JD-Core Version:    0.7.0.1
 */