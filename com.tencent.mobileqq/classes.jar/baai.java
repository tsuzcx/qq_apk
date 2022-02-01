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

public class baai
  extends RecyclerView.Adapter<baak>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private baal jdField_a_of_type_Baal;
  private List<baam> jdField_a_of_type_JavaUtilList;
  
  public baai(List<baam> paramList, Context paramContext, baal parambaal)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Baal = parambaal;
  }
  
  public baak a(ViewGroup paramViewGroup, int paramInt)
  {
    return new baak(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561486, paramViewGroup, false));
  }
  
  public void a(baak parambaak, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) || (((baam)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    while ((parambaak == null) || (parambaak.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView == null))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parambaak, paramInt, getItemId(paramInt));
      return;
    }
    parambaak.jdField_a_of_type_Boolean = ((baam)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
    parambaak.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((baam)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    if (parambaak.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramInt;
      parambaak.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(agej.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      parambaak.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(agej.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (this.jdField_a_of_type_Baal != null) {
        this.jdField_a_of_type_Baal.a((baam)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    for (;;)
    {
      a(parambaak.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, parambaak.jdField_a_of_type_Boolean);
      parambaak.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new baaj(this, paramInt));
      break;
      parambaak.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(agej.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      parambaak.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(agej.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = agej.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = agej.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = agej.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.width = agej.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.setMargins(agej.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
 * Qualified Name:     baai
 * JD-Core Version:    0.7.0.1
 */