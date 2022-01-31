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

public class arji
  extends ahbj
{
  int a;
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramahbe = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof arjj))) {
        break label179;
      }
      paramahbe = (arjj)paramahbe;
      label35:
      paramInt = paramViewGroup.getMeasuredHeight() - this.a;
      if (paramInt >= 0) {
        break label347;
      }
      paramInt = (int)(this.a * 1.5F);
    }
    label81:
    label347:
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
          paramahbe.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839117);
          if ((paramahbe.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramahbe.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramahbe.jdField_a_of_type_AndroidWidgetTextView.setText(2131633355);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramahbe = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131495179, null);
        paramahbe = new arjj();
        paramahbe.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131303232));
        paramahbe.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302061));
        paramahbe.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312607));
        paramView.setTag(paramahbe);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131166995) + paramOnClickListener.getDimensionPixelSize(2131166997) + paramOnClickListener.getDimensionPixelSize(2131166996));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramahbe.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramahbe.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramahbe.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844205);
      paramahbe.jdField_a_of_type_AndroidWidgetTextView.setText(2131633354);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arji
 * JD-Core Version:    0.7.0.1
 */