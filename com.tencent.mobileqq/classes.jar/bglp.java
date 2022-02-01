import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;

class bglp
  extends ajoe<bgkm>
{
  bglp(bglm parambglm, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ajoo a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new bglv(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131377592));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131377593));
    paramContext.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131377596));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377597));
    return paramContext;
  }
  
  protected void a(ajoo paramajoo, bgkm parambgkm, int paramInt)
  {
    bglm.a(this.a, paramajoo, parambgkm, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglp
 * JD-Core Version:    0.7.0.1
 */