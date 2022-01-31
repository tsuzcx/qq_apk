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

public class amnl
  extends ahnw
{
  int a;
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramahnr = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof amnm))) {
        break label179;
      }
      paramahnr = (amnm)paramahnr;
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
          paramahnr.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839144);
          if ((paramahnr.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramahnr.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramahnr.jdField_a_of_type_AndroidWidgetTextView.setText(2131698705);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramahnr = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131560698, null);
        paramahnr = new amnm();
        paramahnr.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368899));
        paramahnr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
        paramahnr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378436));
        paramView.setTag(paramahnr);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131297958) + paramOnClickListener.getDimensionPixelSize(2131297960) + paramOnClickListener.getDimensionPixelSize(2131297959) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramahnr.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramahnr.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramahnr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramahnr.jdField_a_of_type_AndroidWidgetTextView.setText(2131698704);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amnl
 * JD-Core Version:    0.7.0.1
 */