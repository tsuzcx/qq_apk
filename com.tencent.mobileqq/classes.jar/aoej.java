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

public class aoej
  extends ajff
{
  int a;
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramajfa = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof aoek))) {
        break label179;
      }
      paramajfa = (aoek)paramajfa;
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
          paramajfa.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839228);
          if ((paramajfa.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramajfa.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramajfa.jdField_a_of_type_AndroidWidgetTextView.setText(2131699002);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramajfa = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131560874, null);
        paramajfa = new aoek();
        paramajfa.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369129));
        paramajfa.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367808));
        paramajfa.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379049));
        paramView.setTag(paramajfa);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131297979) + paramOnClickListener.getDimensionPixelSize(2131297981) + paramOnClickListener.getDimensionPixelSize(2131297980) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramajfa.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramajfa.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramajfa.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramajfa.jdField_a_of_type_AndroidWidgetTextView.setText(2131699001);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoej
 * JD-Core Version:    0.7.0.1
 */