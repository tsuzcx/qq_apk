import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bcjb
  implements bcil<bcfp, bcny>
{
  private aoof jdField_a_of_type_Aoof;
  private bcjf jdField_a_of_type_Bcjf;
  boolean jdField_a_of_type_Boolean;
  
  public bcjb(aoof paramaoof, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_Bcjf = new bcjf(paramaoof, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(bcfp parambcfp, bcny parambcny)
  {
    bcfq localbcfq = (bcfq)parambcfp;
    bcpk localbcpk = (bcpk)parambcny;
    int i = localbcfq.a();
    LinearLayout localLinearLayout = localbcpk.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localbcfq.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          bcfr localbcfr = (bcfr)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(parambcny.a().getContext()).inflate(2131562880, null);
            parambcfp = new bcnv(localView);
            localView.setTag(2131381109, localbcfr);
            localView.setTag(2131381115, parambcfp);
            localView.setTag(2131381110, Integer.valueOf(i));
            localView.setTag(2131381108, Integer.valueOf(localList.size()));
            localView.setTag(2131381111, this.jdField_a_of_type_Bcjf);
            bcnl.a(localbcfr, k, i);
            m = localbcfr.a();
            n = localbcfr.b();
            if (!(localbcfr instanceof bcfs)) {
              break label334;
            }
          }
          label334:
          for (int j = ((bcfs)localbcfr).u;; j = 0)
          {
            bcnl.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Bcjf.a() != null) {
              this.jdField_a_of_type_Bcjf.a().a((bcfp)localList.get(i), parambcfp);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(parambcny.a().getContext()).inflate(2131562879, null);
            parambcfp = new bcpp(localView);
            break label142;
          }
        }
      }
    }
    parambcfp = localbcfq.a();
    if ((parambcfp == null) || (parambcfp.isEmpty()))
    {
      if (parambcny.b() != null) {
        parambcny.b().setVisibility(8);
      }
      localbcpk.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localbcpk.jdField_a_of_type_AndroidViewView.setTag(2131381110, Integer.valueOf(-1));
      localbcpk.jdField_a_of_type_AndroidWidgetTextView.setText(localbcfq.b());
      localbcpk.b.setText(anzj.a(2131712528));
      localbcpk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846042);
      localbcpk.jdField_a_of_type_AndroidViewView.setOnClickListener(new bcjc(this, localbcfq));
      return;
    }
    localbcpk.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjb
 * JD-Core Version:    0.7.0.1
 */