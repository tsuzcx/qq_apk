import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class awrt
  implements awrd<awog, awwq>
{
  private awrx jdField_a_of_type_Awrx;
  private baxy jdField_a_of_type_Baxy;
  boolean jdField_a_of_type_Boolean;
  
  public awrt(baxy parambaxy, boolean paramBoolean)
  {
    this.jdField_a_of_type_Baxy = parambaxy;
    this.jdField_a_of_type_Awrx = new awrx(parambaxy, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(awog paramawog, awwq paramawwq)
  {
    awoh localawoh = (awoh)paramawog;
    awyc localawyc = (awyc)paramawwq;
    int i = localawoh.a();
    LinearLayout localLinearLayout = localawyc.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localawoh.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          awoi localawoi = (awoi)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(paramawwq.a().getContext()).inflate(2131562386, null);
            paramawog = new awwn(localView);
            localView.setTag(2131379213, localawoi);
            localView.setTag(2131379218, paramawog);
            localView.setTag(2131379214, Integer.valueOf(i));
            localView.setTag(2131379212, Integer.valueOf(localList.size()));
            localView.setTag(2131379215, this.jdField_a_of_type_Awrx);
            awwd.a(localawoi, k, i);
            m = localawoi.a();
            n = localawoi.b();
            if (!(localawoi instanceof awoj)) {
              break label334;
            }
          }
          label334:
          for (int j = ((awoj)localawoi).r;; j = 0)
          {
            awwd.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Awrx.a() != null) {
              this.jdField_a_of_type_Awrx.a().a((awog)localList.get(i), paramawog);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(paramawwq.a().getContext()).inflate(2131562385, null);
            paramawog = new awyh(localView);
            break label142;
          }
        }
      }
    }
    paramawog = localawoh.a();
    if ((paramawog == null) || (paramawog.isEmpty()))
    {
      if (paramawwq.b() != null) {
        paramawwq.b().setVisibility(8);
      }
      localawyc.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localawyc.jdField_a_of_type_AndroidViewView.setTag(2131379214, Integer.valueOf(-1));
      localawyc.jdField_a_of_type_AndroidWidgetTextView.setText(localawoh.b());
      localawyc.b.setText(ajya.a(2131713656));
      localawyc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845183);
      localawyc.jdField_a_of_type_AndroidViewView.setOnClickListener(new awru(this, localawoh));
      return;
    }
    localawyc.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrt
 * JD-Core Version:    0.7.0.1
 */