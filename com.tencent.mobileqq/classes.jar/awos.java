import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.widget.RoundedImageView;
import java.util.List;

public class awos
  extends RecyclerView.Adapter<awou>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private awov jdField_a_of_type_Awov;
  private List<awow> jdField_a_of_type_JavaUtilList;
  
  public awos(List<awow> paramList, Context paramContext, awov paramawov)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Awov = paramawov;
  }
  
  public awou a(ViewGroup paramViewGroup, int paramInt)
  {
    return new awou(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561204, paramViewGroup, false));
  }
  
  public void a(awou paramawou, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) || (((awow)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    while ((paramawou == null) || (paramawou.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView == null)) {
      return;
    }
    paramawou.jdField_a_of_type_Boolean = ((awow)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
    paramawou.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((awow)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    if (paramawou.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramInt;
      paramawou.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(aekt.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramawou.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(aekt.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (this.jdField_a_of_type_Awov != null) {
        this.jdField_a_of_type_Awov.a((awow)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    for (;;)
    {
      a(paramawou.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, paramawou.jdField_a_of_type_Boolean);
      paramawou.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new awot(this, paramInt));
      return;
      paramawou.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(aekt.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramawou.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(aekt.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = aekt.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = aekt.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(aekt.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = aekt.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.width = aekt.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.setMargins(aekt.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
 * Qualified Name:     awos
 * JD-Core Version:    0.7.0.1
 */