import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class bciv
  implements bcif<bcfh, bcns>
{
  private bciz jdField_a_of_type_Bciz;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  boolean jdField_a_of_type_Boolean;
  
  public bciv(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bciz = new bciz(paramFaceDecoder, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(bcfh parambcfh, bcns parambcns)
  {
    bcfi localbcfi = (bcfi)parambcfh;
    bcpe localbcpe = (bcpe)parambcns;
    int i = localbcfi.a();
    LinearLayout localLinearLayout = localbcpe.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localbcfi.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        if (i < k)
        {
          bcfj localbcfj = (bcfj)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(parambcns.a().getContext()).inflate(2131562830, null);
            parambcfh = new bcnp(localView);
            localView.setTag(2131381183, localbcfj);
            localView.setTag(2131381188, parambcfh);
            localView.setTag(2131381184, Integer.valueOf(i));
            localView.setTag(2131381182, Integer.valueOf(localList.size()));
            localView.setTag(2131381185, this.jdField_a_of_type_Bciz);
            bcnf.a(localbcfj, k, i);
            m = localbcfj.a();
            n = localbcfj.b();
            if (!(localbcfj instanceof bcfk)) {
              break label334;
            }
          }
          label334:
          for (int j = ((bcfk)localbcfj).u;; j = 0)
          {
            bcnf.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_Bciz.a() != null) {
              this.jdField_a_of_type_Bciz.a().a((bcfh)localList.get(i), parambcfh);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(parambcns.a().getContext()).inflate(2131562829, null);
            parambcfh = new bcpj(localView);
            break label142;
          }
        }
      }
    }
    parambcfh = localbcfi.a();
    if ((parambcfh == null) || (parambcfh.isEmpty()))
    {
      if (parambcns.b() != null) {
        parambcns.b().setVisibility(8);
      }
      localbcpe.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localbcpe.jdField_a_of_type_AndroidViewView.setTag(2131381184, Integer.valueOf(-1));
      localbcpe.jdField_a_of_type_AndroidWidgetTextView.setText(localbcfi.b());
      localbcpe.b.setText(anvx.a(2131713107));
      localbcpe.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846022);
      localbcpe.jdField_a_of_type_AndroidViewView.setOnClickListener(new bciw(this, localbcfi));
      return;
    }
    localbcpe.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciv
 * JD-Core Version:    0.7.0.1
 */