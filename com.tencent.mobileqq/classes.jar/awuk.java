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

public class awuk
  extends alhd
{
  int a;
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramalgy = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof awul))) {
        break label179;
      }
      paramalgy = (awul)paramalgy;
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
          paramalgy.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130839470);
          if ((paramalgy.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramalgy.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).start();
          }
          paramalgy.jdField_a_of_type_AndroidWidgetTextView.setText(2131698621);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramalgy = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561132, null);
        paramalgy = new awul();
        paramalgy.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369788));
        paramalgy.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131368381));
        paramalgy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380283));
        paramView.setTag(paramalgy);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298273) + paramOnClickListener.getDimensionPixelSize(2131298275) + paramOnClickListener.getDimensionPixelSize(2131298274));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramalgy.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramalgy.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).stop();
      }
      paramObject = bgyo.a(paramContext.getResources(), 2130845077);
      if (paramObject != null)
      {
        paramalgy.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageBitmap(paramObject);
        paramalgy.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blfw.b);
      }
      for (;;)
      {
        paramalgy.jdField_a_of_type_AndroidWidgetTextView.setText(2131698620);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuk
 * JD-Core Version:    0.7.0.1
 */