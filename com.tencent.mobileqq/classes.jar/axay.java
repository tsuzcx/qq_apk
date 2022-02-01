import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;

public class axay
  extends alnt
{
  int a;
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramalno = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof axaz))) {
        break label179;
      }
      paramalno = (axaz)paramalno;
      label35:
      paramInt = paramViewGroup.getMeasuredHeight() - this.a;
      if (paramInt >= 0) {
        break label382;
      }
      paramInt = (int)(this.a * 1.5F);
    }
    label81:
    label382:
    for (;;)
    {
      if ((paramView.getLayoutParams() instanceof AbsListView.LayoutParams))
      {
        paramViewGroup = (AbsListView.LayoutParams)paramView.getLayoutParams();
        paramViewGroup.width = -1;
        paramViewGroup.height = paramInt;
        paramView.setLayoutParams(paramViewGroup);
        if ((paramObject instanceof Integer))
        {
          paramInt = ((Integer)paramObject).intValue();
          if (paramInt != 20) {
            break label292;
          }
          paramalno.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130839414);
          if ((paramalno.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramalno.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).start();
          }
          paramalno.jdField_a_of_type_AndroidWidgetTextView.setText(2131698160);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramalno = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561197, null);
        paramalno = new axaz();
        paramalno.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369629));
        paramalno.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131368212));
        paramalno.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380216));
        paramView.setTag(paramalno);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298205) + paramOnClickListener.getDimensionPixelSize(2131298207) + paramOnClickListener.getDimensionPixelSize(2131298206));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramalno.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramalno.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).stop();
      }
      paramObject = bhgm.a(paramContext.getResources(), 2130845116);
      if (paramObject != null)
      {
        paramalno.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageBitmap(paramObject);
        paramalno.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blqj.b);
      }
      for (;;)
      {
        paramalno.jdField_a_of_type_AndroidWidgetTextView.setText(2131698159);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axay
 * JD-Core Version:    0.7.0.1
 */