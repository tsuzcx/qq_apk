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

public class apry
  extends akll
{
  int a;
  
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramaklg = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof aprz))) {
        break label179;
      }
      paramaklg = (aprz)paramaklg;
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
          paramaklg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839449);
          if ((paramaklg.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramaklg.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
          }
          paramaklg.jdField_a_of_type_AndroidWidgetTextView.setText(2131698073);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramaklg = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561008, null);
        paramaklg = new aprz();
        paramaklg.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369619));
        paramaklg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368236));
        paramaklg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379944));
        paramView.setTag(paramaklg);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298137) + paramOnClickListener.getDimensionPixelSize(2131298139) + paramOnClickListener.getDimensionPixelSize(2131298138) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramaklg.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramaklg.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      }
      paramaklg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramaklg.jdField_a_of_type_AndroidWidgetTextView.setText(2131698072);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apry
 * JD-Core Version:    0.7.0.1
 */