import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.AbsListView.LayoutParams;

public class aqvb
  extends alhd
{
  int a;
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramalgy = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof aqvc))) {
        break label179;
      }
      paramalgy = (aqvc)paramalgy;
      label35:
      paramInt = paramViewGroup.getMeasuredHeight() - this.a;
      if (paramInt >= 0) {
        break label348;
      }
      paramInt = (int)(this.a * 1.5F);
    }
    label81:
    label348:
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
          if (paramInt != 16) {
            break label294;
          }
          paramalgy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839470);
          if ((paramalgy.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramalgy.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramalgy.jdField_a_of_type_AndroidWidgetTextView.setText(2131698359);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramalgy = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561069, null);
        paramalgy = new aqvc();
        paramalgy.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369788));
        paramalgy.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
        paramalgy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380283));
        paramView.setTag(paramalgy);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298140) + paramOnClickListener.getDimensionPixelSize(2131298142) + paramOnClickListener.getDimensionPixelSize(2131298141) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramalgy.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramalgy.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramalgy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramalgy.jdField_a_of_type_AndroidWidgetTextView.setText(2131698358);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvb
 * JD-Core Version:    0.7.0.1
 */