import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.widget.RoundedImageView;
import java.util.List;

public class auxg
  extends RecyclerView.Adapter<auxi>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private auxj jdField_a_of_type_Auxj;
  private List<auxk> jdField_a_of_type_JavaUtilList;
  
  public auxg(List<auxk> paramList, Context paramContext, auxj paramauxj)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Auxj = paramauxj;
  }
  
  public auxi a(ViewGroup paramViewGroup, int paramInt)
  {
    return new auxi(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561018, paramViewGroup, false));
  }
  
  public void a(auxi paramauxi, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) || (((auxk)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    while ((paramauxi == null) || (paramauxi.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView == null)) {
      return;
    }
    paramauxi.jdField_a_of_type_Boolean = ((auxk)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
    paramauxi.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((auxk)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    if (paramauxi.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramInt;
      paramauxi.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramauxi.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(actj.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (this.jdField_a_of_type_Auxj != null) {
        this.jdField_a_of_type_Auxj.a((auxk)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    for (;;)
    {
      a(paramauxi.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, paramauxi.jdField_a_of_type_Boolean);
      paramauxi.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new auxh(this, paramInt));
      return;
      paramauxi.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(actj.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramauxi.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(actj.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = actj.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = actj.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = actj.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.width = actj.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.setMargins(actj.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
 * Qualified Name:     auxg
 * JD-Core Version:    0.7.0.1
 */