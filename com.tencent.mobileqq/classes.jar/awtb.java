import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.widget.RoundedImageView;
import java.util.List;

public class awtb
  extends RecyclerView.Adapter<awtd>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private awte jdField_a_of_type_Awte;
  private List<awtf> jdField_a_of_type_JavaUtilList;
  
  public awtb(List<awtf> paramList, Context paramContext, awte paramawte)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Awte = paramawte;
  }
  
  public awtd a(ViewGroup paramViewGroup, int paramInt)
  {
    return new awtd(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561222, paramViewGroup, false));
  }
  
  public void a(awtd paramawtd, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) || (((awtf)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    while ((paramawtd == null) || (paramawtd.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView == null)) {
      return;
    }
    paramawtd.jdField_a_of_type_Boolean = ((awtf)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
    paramawtd.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((awtf)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    if (paramawtd.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramInt;
      paramawtd.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramawtd.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (this.jdField_a_of_type_Awte != null) {
        this.jdField_a_of_type_Awte.a((awtf)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    for (;;)
    {
      a(paramawtd.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, paramawtd.jdField_a_of_type_Boolean);
      paramawtd.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new awtc(this, paramInt));
      return;
      paramawtd.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramawtd.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = aepi.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = aepi.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(aepi.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = aepi.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.width = aepi.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.setMargins(aepi.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awtb
 * JD-Core Version:    0.7.0.1
 */