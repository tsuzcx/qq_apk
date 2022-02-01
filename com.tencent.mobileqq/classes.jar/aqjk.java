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

public class aqjk
  extends alcd
{
  int a;
  
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramalby = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof aqjl))) {
        break label179;
      }
      paramalby = (aqjl)paramalby;
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
          paramalby.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839406);
          if ((paramalby.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramalby.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramalby.jdField_a_of_type_AndroidWidgetTextView.setText(2131697832);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramalby = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561098, null);
        paramalby = new aqjl();
        paramalby.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369536));
        paramalby.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368138));
        paramalby.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380031));
        paramView.setTag(paramalby);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298060) + paramOnClickListener.getDimensionPixelSize(2131298062) + paramOnClickListener.getDimensionPixelSize(2131298061) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramalby.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramalby.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramalby.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramalby.jdField_a_of_type_AndroidWidgetTextView.setText(2131697831);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjk
 * JD-Core Version:    0.7.0.1
 */