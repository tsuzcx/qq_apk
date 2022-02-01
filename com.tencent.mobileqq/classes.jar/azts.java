import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class azts
  extends RecyclerView.Adapter<aztu>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private aztv jdField_a_of_type_Aztv;
  private List<aztw> jdField_a_of_type_JavaUtilList;
  
  public azts(List<aztw> paramList, Context paramContext, aztv paramaztv)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Aztv = paramaztv;
  }
  
  public aztu a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aztu(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561432, paramViewGroup, false));
  }
  
  public void a(aztu paramaztu, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) || (((aztw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    while ((paramaztu == null) || (paramaztu.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView == null))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaztu, paramInt, getItemId(paramInt));
      return;
    }
    paramaztu.jdField_a_of_type_Boolean = ((aztw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
    paramaztu.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((aztw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    if (paramaztu.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramInt;
      paramaztu.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramaztu.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (this.jdField_a_of_type_Aztv != null) {
        this.jdField_a_of_type_Aztv.a((aztw)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    for (;;)
    {
      a(paramaztu.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, paramaztu.jdField_a_of_type_Boolean);
      paramaztu.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new aztt(this, paramInt));
      break;
      paramaztu.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramaztu.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.width = AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.setMargins(AIOUtils.dp2px(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
 * Qualified Name:     azts
 * JD-Core Version:    0.7.0.1
 */