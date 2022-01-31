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

public class amnm
  extends ahny
{
  int a;
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramahnt = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof amnn))) {
        break label179;
      }
      paramahnt = (amnn)paramahnt;
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
          paramahnt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839144);
          if ((paramahnt.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramahnt.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramahnt.jdField_a_of_type_AndroidWidgetTextView.setText(2131698695);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramahnt = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131560699, null);
        paramahnt = new amnn();
        paramahnt.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368899));
        paramahnt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
        paramahnt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378431));
        paramView.setTag(paramahnt);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131297958) + paramOnClickListener.getDimensionPixelSize(2131297960) + paramOnClickListener.getDimensionPixelSize(2131297959) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramahnt.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramahnt.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramahnt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramahnt.jdField_a_of_type_AndroidWidgetTextView.setText(2131698694);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amnm
 * JD-Core Version:    0.7.0.1
 */