import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.widget.RoundedImageView;
import java.util.List;

public class auxe
  extends RecyclerView.Adapter<auxg>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private auxh jdField_a_of_type_Auxh;
  private List<auxi> jdField_a_of_type_JavaUtilList;
  
  public auxe(List<auxi> paramList, Context paramContext, auxh paramauxh)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Auxh = paramauxh;
  }
  
  public auxg a(ViewGroup paramViewGroup, int paramInt)
  {
    return new auxg(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561019, paramViewGroup, false));
  }
  
  public void a(auxg paramauxg, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) || (((auxi)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    while ((paramauxg == null) || (paramauxg.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView == null)) {
      return;
    }
    paramauxg.jdField_a_of_type_Boolean = ((auxi)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
    paramauxg.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((auxi)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    if (paramauxg.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramInt;
      paramauxg.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(actn.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramauxg.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(actn.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (this.jdField_a_of_type_Auxh != null) {
        this.jdField_a_of_type_Auxh.a((auxi)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    for (;;)
    {
      a(paramauxg.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, paramauxg.jdField_a_of_type_Boolean);
      paramauxg.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new auxf(this, paramInt));
      return;
      paramauxg.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(actn.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramauxg.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(actn.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = actn.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = actn.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(actn.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = actn.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.width = actn.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.setMargins(actn.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxe
 * JD-Core Version:    0.7.0.1
 */