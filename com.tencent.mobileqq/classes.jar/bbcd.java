import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bbcd
  implements bbbn<bayr, bbha>
{
  private bbch jdField_a_of_type_Bbch;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  boolean jdField_a_of_type_Boolean;
  
  public bbcd(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bbch = new bbch(paramFaceDecoder, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(bayr parambayr, bbha parambbha)
  {
    bays localbays = (bays)parambayr;
    bbim localbbim = (bbim)parambbha;
    int i = localbays.a();
    LinearLayout localLinearLayout = localbbim.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localbays.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          bayt localbayt = (bayt)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(parambbha.a().getContext()).inflate(2131562759, null);
            parambayr = new bbgx(localView);
            localView.setTag(2131380831, localbayt);
            localView.setTag(2131380836, parambayr);
            localView.setTag(2131380832, Integer.valueOf(i));
            localView.setTag(2131380830, Integer.valueOf(localList.size()));
            localView.setTag(2131380833, this.jdField_a_of_type_Bbch);
            bbgn.a(localbayt, k, i);
            m = localbayt.a();
            n = localbayt.b();
            if (!(localbayt instanceof bayu)) {
              break label334;
            }
          }
          label334:
          for (int j = ((bayu)localbayt).u;; j = 0)
          {
            bbgn.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Bbch.a() != null) {
              this.jdField_a_of_type_Bbch.a().a((bayr)localList.get(i), parambayr);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(parambbha.a().getContext()).inflate(2131562758, null);
            parambayr = new bbir(localView);
            break label142;
          }
        }
      }
    }
    parambayr = localbays.a();
    if ((parambayr == null) || (parambayr.isEmpty()))
    {
      if (parambbha.b() != null) {
        parambbha.b().setVisibility(8);
      }
      localbbim.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localbbim.jdField_a_of_type_AndroidViewView.setTag(2131380832, Integer.valueOf(-1));
      localbbim.jdField_a_of_type_AndroidWidgetTextView.setText(localbays.b());
      localbbim.b.setText(amtj.a(2131712760));
      localbbim.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845934);
      localbbim.jdField_a_of_type_AndroidViewView.setOnClickListener(new bbce(this, localbays));
      return;
    }
    localbbim.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcd
 * JD-Core Version:    0.7.0.1
 */