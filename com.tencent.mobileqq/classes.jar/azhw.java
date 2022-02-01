import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class azhw
  extends RecyclerView.Adapter<azhy>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private azhz jdField_a_of_type_Azhz;
  private List<azia> jdField_a_of_type_JavaUtilList;
  
  public azhw(List<azia> paramList, Context paramContext, azhz paramazhz)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Azhz = paramazhz;
  }
  
  public azhy a(ViewGroup paramViewGroup, int paramInt)
  {
    return new azhy(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561445, paramViewGroup, false));
  }
  
  public void a(azhy paramazhy, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) || (((azia)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    while ((paramazhy == null) || (paramazhy.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView == null))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramazhy, paramInt, getItemId(paramInt));
      return;
    }
    paramazhy.jdField_a_of_type_Boolean = ((azia)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
    paramazhy.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((azia)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    if (paramazhy.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramInt;
      paramazhy.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(afur.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramazhy.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(afur.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (this.jdField_a_of_type_Azhz != null) {
        this.jdField_a_of_type_Azhz.a((azia)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    for (;;)
    {
      a(paramazhy.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, paramazhy.jdField_a_of_type_Boolean);
      paramazhy.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new azhx(this, paramInt));
      break;
      paramazhy.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(afur.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramazhy.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(afur.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = afur.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = afur.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(afur.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = afur.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.width = afur.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.setMargins(afur.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
 * Qualified Name:     azhw
 * JD-Core Version:    0.7.0.1
 */