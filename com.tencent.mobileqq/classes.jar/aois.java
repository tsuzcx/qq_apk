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

public class aois
  extends ajju
{
  int a;
  
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramajjp = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof aoit))) {
        break label179;
      }
      paramajjp = (aoit)paramajjp;
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
          paramajjp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839229);
          if ((paramajjp.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramajjp.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramajjp.jdField_a_of_type_AndroidWidgetTextView.setText(2131699014);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramajjp = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131560892, null);
        paramajjp = new aoit();
        paramajjp.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369147));
        paramajjp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367819));
        paramajjp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379107));
        paramView.setTag(paramajjp);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131297979) + paramOnClickListener.getDimensionPixelSize(2131297981) + paramOnClickListener.getDimensionPixelSize(2131297980) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramajjp.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramajjp.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramajjp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramajjp.jdField_a_of_type_AndroidWidgetTextView.setText(2131699013);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aois
 * JD-Core Version:    0.7.0.1
 */