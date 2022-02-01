import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class awkv
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  
  public awkv(View paramView, Context paramContext, GridLayoutManager paramGridLayoutManager)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379958));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131369247));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blqj.c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369109));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376761));
    if (ThemeUtil.isNowThemeIsNight(null, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165752));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131165754));
    }
    for (boolean bool = true; (paramGridLayoutManager != null) && (paramGridLayoutManager.getWidth() > 0); bool = false)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = (paramGridLayoutManager.getWidth() / 3);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      if (QLog.isColorLevel()) {
        QLog.i("leba_sort_LebaTableMgrAdpter", 2, "plugin height =" + paramView.height + ",isNight" + bool);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165751));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131165753));
    }
    QLog.i("leba_sort_LebaTableMgrAdpter", 1, "plugin getWidth error ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkv
 * JD-Core Version:    0.7.0.1
 */