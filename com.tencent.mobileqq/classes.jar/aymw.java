import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class aymw
  implements aymg<ayjj, ayrt>
{
  private ayna jdField_a_of_type_Ayna;
  private bcws jdField_a_of_type_Bcws;
  boolean jdField_a_of_type_Boolean;
  
  public aymw(bcws parambcws, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bcws = parambcws;
    this.jdField_a_of_type_Ayna = new ayna(parambcws, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    ayjk localayjk = (ayjk)paramayjj;
    aytf localaytf = (aytf)paramayrt;
    int i = localayjk.a();
    LinearLayout localLinearLayout = localaytf.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localayjk.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          ayjl localayjl = (ayjl)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(paramayrt.a().getContext()).inflate(2131562590, null);
            paramayjj = new ayrq(localView);
            localView.setTag(2131379913, localayjl);
            localView.setTag(2131379918, paramayjj);
            localView.setTag(2131379914, Integer.valueOf(i));
            localView.setTag(2131379912, Integer.valueOf(localList.size()));
            localView.setTag(2131379915, this.jdField_a_of_type_Ayna);
            ayrg.a(localayjl, k, i);
            m = localayjl.a();
            n = localayjl.b();
            if (!(localayjl instanceof ayjm)) {
              break label334;
            }
          }
          label334:
          for (int j = ((ayjm)localayjl).r;; j = 0)
          {
            ayrg.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Ayna.a() != null) {
              this.jdField_a_of_type_Ayna.a().a((ayjj)localList.get(i), paramayjj);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(paramayrt.a().getContext()).inflate(2131562589, null);
            paramayjj = new aytk(localView);
            break label142;
          }
        }
      }
    }
    paramayjj = localayjk.a();
    if ((paramayjj == null) || (paramayjj.isEmpty()))
    {
      if (paramayrt.b() != null) {
        paramayrt.b().setVisibility(8);
      }
      localaytf.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localaytf.jdField_a_of_type_AndroidViewView.setTag(2131379914, Integer.valueOf(-1));
      localaytf.jdField_a_of_type_AndroidWidgetTextView.setText(localayjk.b());
      localaytf.b.setText(alpo.a(2131714028));
      localaytf.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845548);
      localaytf.jdField_a_of_type_AndroidViewView.setOnClickListener(new aymx(this, localayjk));
      return;
    }
    localaytf.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymw
 * JD-Core Version:    0.7.0.1
 */