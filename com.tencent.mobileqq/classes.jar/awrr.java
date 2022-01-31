import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class awrr
  implements awrb<awoe, awwo>
{
  private awrv jdField_a_of_type_Awrv;
  private baxk jdField_a_of_type_Baxk;
  boolean jdField_a_of_type_Boolean;
  
  public awrr(baxk parambaxk, boolean paramBoolean)
  {
    this.jdField_a_of_type_Baxk = parambaxk;
    this.jdField_a_of_type_Awrv = new awrv(parambaxk, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(awoe paramawoe, awwo paramawwo)
  {
    awof localawof = (awof)paramawoe;
    awya localawya = (awya)paramawwo;
    int i = localawof.a();
    LinearLayout localLinearLayout = localawya.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localawof.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          awog localawog = (awog)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(paramawwo.a().getContext()).inflate(2131562387, null);
            paramawoe = new awwl(localView);
            localView.setTag(2131379208, localawog);
            localView.setTag(2131379213, paramawoe);
            localView.setTag(2131379209, Integer.valueOf(i));
            localView.setTag(2131379207, Integer.valueOf(localList.size()));
            localView.setTag(2131379210, this.jdField_a_of_type_Awrv);
            awwb.a(localawog, k, i);
            m = localawog.a();
            n = localawog.b();
            if (!(localawog instanceof awoh)) {
              break label334;
            }
          }
          label334:
          for (int j = ((awoh)localawog).r;; j = 0)
          {
            awwb.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Awrv.a() != null) {
              this.jdField_a_of_type_Awrv.a().a((awoe)localList.get(i), paramawoe);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(paramawwo.a().getContext()).inflate(2131562386, null);
            paramawoe = new awyf(localView);
            break label142;
          }
        }
      }
    }
    paramawoe = localawof.a();
    if ((paramawoe == null) || (paramawoe.isEmpty()))
    {
      if (paramawwo.b() != null) {
        paramawwo.b().setVisibility(8);
      }
      localawya.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localawya.jdField_a_of_type_AndroidViewView.setTag(2131379209, Integer.valueOf(-1));
      localawya.jdField_a_of_type_AndroidWidgetTextView.setText(localawof.b());
      localawya.b.setText(ajyc.a(2131713645));
      localawya.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845182);
      localawya.jdField_a_of_type_AndroidViewView.setOnClickListener(new awrs(this, localawof));
      return;
    }
    localawya.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrr
 * JD-Core Version:    0.7.0.1
 */