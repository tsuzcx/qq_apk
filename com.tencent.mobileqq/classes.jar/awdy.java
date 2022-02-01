import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class awdy
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  
  public awdy(View paramView, Context paramContext, GridLayoutManager paramGridLayoutManager, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380038));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131369431));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blfw.c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369299));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376790));
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165771));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131165773));
      paramBoolean = true;
    }
    while ((paramGridLayoutManager != null) && (paramGridLayoutManager.getWidth() > 0))
    {
      paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.height = (paramGridLayoutManager.getWidth() / 3);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      if (QLog.isColorLevel()) {
        QLog.i("leba_sort_LebaTableMgrAdpter", 2, "plugin height =" + paramView.height + ",isNight" + paramBoolean);
      }
      return;
      paramBoolean = false;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165770));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131165772));
    }
    QLog.i("leba_sort_LebaTableMgrAdpter", 1, "plugin getWidth error ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdy
 * JD-Core Version:    0.7.0.1
 */