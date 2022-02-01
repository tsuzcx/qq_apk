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

public class auxz
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  
  public auxz(View paramView, Context paramContext, GridLayoutManager paramGridLayoutManager, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379724));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131369264));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bjuk.c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369136));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376531));
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165762));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131165764));
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165761));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131165763));
    }
    QLog.i("leba_sort_LebaTableMgrAdpter", 1, "plugin getWidth error ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxz
 * JD-Core Version:    0.7.0.1
 */