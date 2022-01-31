import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class ayrf
  implements ayqp<ayns, aywc>
{
  private ayrj jdField_a_of_type_Ayrj;
  private bdbb jdField_a_of_type_Bdbb;
  boolean jdField_a_of_type_Boolean;
  
  public ayrf(bdbb parambdbb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bdbb = parambdbb;
    this.jdField_a_of_type_Ayrj = new ayrj(parambdbb, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(ayns paramayns, aywc paramaywc)
  {
    aynt localaynt = (aynt)paramayns;
    ayxo localayxo = (ayxo)paramaywc;
    int i = localaynt.a();
    LinearLayout localLinearLayout = localayxo.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localaynt.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          aynu localaynu = (aynu)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(paramaywc.a().getContext()).inflate(2131562608, null);
            paramayns = new ayvz(localView);
            localView.setTag(2131379971, localaynu);
            localView.setTag(2131379976, paramayns);
            localView.setTag(2131379972, Integer.valueOf(i));
            localView.setTag(2131379970, Integer.valueOf(localList.size()));
            localView.setTag(2131379973, this.jdField_a_of_type_Ayrj);
            ayvp.a(localaynu, k, i);
            m = localaynu.a();
            n = localaynu.b();
            if (!(localaynu instanceof aynv)) {
              break label334;
            }
          }
          label334:
          for (int j = ((aynv)localaynu).r;; j = 0)
          {
            ayvp.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Ayrj.a() != null) {
              this.jdField_a_of_type_Ayrj.a().a((ayns)localList.get(i), paramayns);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(paramaywc.a().getContext()).inflate(2131562607, null);
            paramayns = new ayxt(localView);
            break label142;
          }
        }
      }
    }
    paramayns = localaynt.a();
    if ((paramayns == null) || (paramayns.isEmpty()))
    {
      if (paramaywc.b() != null) {
        paramaywc.b().setVisibility(8);
      }
      localayxo.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localayxo.jdField_a_of_type_AndroidViewView.setTag(2131379972, Integer.valueOf(-1));
      localayxo.jdField_a_of_type_AndroidWidgetTextView.setText(localaynt.b());
      localayxo.b.setText(alud.a(2131714040));
      localayxo.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845620);
      localayxo.jdField_a_of_type_AndroidViewView.setOnClickListener(new ayrg(this, localaynt));
      return;
    }
    localayxo.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrf
 * JD-Core Version:    0.7.0.1
 */