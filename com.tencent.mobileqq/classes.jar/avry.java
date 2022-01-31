import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class avry
  implements avri<avol, avwv>
{
  private avsc jdField_a_of_type_Avsc;
  private azwg jdField_a_of_type_Azwg;
  boolean jdField_a_of_type_Boolean;
  
  public avry(azwg paramazwg, boolean paramBoolean)
  {
    this.jdField_a_of_type_Azwg = paramazwg;
    this.jdField_a_of_type_Avsc = new avsc(paramazwg, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(avol paramavol, avwv paramavwv)
  {
    avom localavom = (avom)paramavol;
    avyh localavyh = (avyh)paramavwv;
    int i = localavom.a();
    LinearLayout localLinearLayout = localavyh.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localavom.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          avon localavon = (avon)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(paramavwv.a().getContext()).inflate(2131496787, null);
            paramavol = new avws(localView);
            localView.setTag(2131313373, localavon);
            localView.setTag(2131313378, paramavol);
            localView.setTag(2131313374, Integer.valueOf(i));
            localView.setTag(2131313372, Integer.valueOf(localList.size()));
            localView.setTag(2131313375, this.jdField_a_of_type_Avsc);
            avwi.a(localavon, k, i);
            m = localavon.a();
            n = localavon.b();
            if (!(localavon instanceof avoo)) {
              break label334;
            }
          }
          label334:
          for (int j = ((avoo)localavon).r;; j = 0)
          {
            avwi.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Avsc.a() != null) {
              this.jdField_a_of_type_Avsc.a().a((avol)localList.get(i), paramavol);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(paramavwv.a().getContext()).inflate(2131496786, null);
            paramavol = new avym(localView);
            break label142;
          }
        }
      }
    }
    paramavol = localavom.a();
    if ((paramavol == null) || (paramavol.isEmpty()))
    {
      if (paramavwv.b() != null) {
        paramavwv.b().setVisibility(8);
      }
      localavyh.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localavyh.jdField_a_of_type_AndroidViewView.setTag(2131313374, Integer.valueOf(-1));
      localavyh.jdField_a_of_type_AndroidWidgetTextView.setText(localavom.b());
      localavyh.b.setText(ajjy.a(2131647858));
      localavyh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845098);
      localavyh.jdField_a_of_type_AndroidViewView.setOnClickListener(new avrz(this, localavom));
      return;
    }
    localavyh.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avry
 * JD-Core Version:    0.7.0.1
 */