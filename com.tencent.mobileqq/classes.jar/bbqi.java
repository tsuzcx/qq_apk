import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bbqi
  implements bbps<bbmw, bbvf>
{
  private aobu jdField_a_of_type_Aobu;
  private bbqm jdField_a_of_type_Bbqm;
  boolean jdField_a_of_type_Boolean;
  
  public bbqi(aobu paramaobu, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aobu = paramaobu;
    this.jdField_a_of_type_Bbqm = new bbqm(paramaobu, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    bbmx localbbmx = (bbmx)parambbmw;
    bbwr localbbwr = (bbwr)parambbvf;
    int i = localbbmx.a();
    LinearLayout localLinearLayout = localbbwr.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localbbmx.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          bbmy localbbmy = (bbmy)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(parambbvf.a().getContext()).inflate(2131562846, null);
            parambbmw = new bbvc(localView);
            localView.setTag(2131380929, localbbmy);
            localView.setTag(2131380935, parambbmw);
            localView.setTag(2131380930, Integer.valueOf(i));
            localView.setTag(2131380928, Integer.valueOf(localList.size()));
            localView.setTag(2131380931, this.jdField_a_of_type_Bbqm);
            bbus.a(localbbmy, k, i);
            m = localbbmy.a();
            n = localbbmy.b();
            if (!(localbbmy instanceof bbmz)) {
              break label334;
            }
          }
          label334:
          for (int j = ((bbmz)localbbmy).s;; j = 0)
          {
            bbus.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Bbqm.a() != null) {
              this.jdField_a_of_type_Bbqm.a().a((bbmw)localList.get(i), parambbmw);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(parambbvf.a().getContext()).inflate(2131562845, null);
            parambbmw = new bbww(localView);
            break label142;
          }
        }
      }
    }
    parambbmw = localbbmx.a();
    if ((parambbmw == null) || (parambbmw.isEmpty()))
    {
      if (parambbvf.b() != null) {
        parambbvf.b().setVisibility(8);
      }
      localbbwr.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localbbwr.jdField_a_of_type_AndroidViewView.setTag(2131380930, Integer.valueOf(-1));
      localbbwr.jdField_a_of_type_AndroidWidgetTextView.setText(localbbmx.b());
      localbbwr.b.setText(anni.a(2131712419));
      localbbwr.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846027);
      localbbwr.jdField_a_of_type_AndroidViewView.setOnClickListener(new bbqj(this, localbbmx));
      return;
    }
    localbbwr.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqi
 * JD-Core Version:    0.7.0.1
 */