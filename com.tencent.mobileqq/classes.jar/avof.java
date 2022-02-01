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

public class avof
  extends akll
{
  int a;
  
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramaklg = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof avog))) {
        break label179;
      }
      paramaklg = (avog)paramaklg;
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
          paramaklg.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130839449);
          if ((paramaklg.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramaklg.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).start();
          }
          paramaklg.jdField_a_of_type_AndroidWidgetTextView.setText(2131698325);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramaklg = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561071, null);
        paramaklg = new avog();
        paramaklg.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369619));
        paramaklg.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131368236));
        paramaklg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379944));
        paramView.setTag(paramaklg);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298270) + paramOnClickListener.getDimensionPixelSize(2131298272) + paramOnClickListener.getDimensionPixelSize(2131298271));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramaklg.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramaklg.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).stop();
      }
      paramObject = bfpx.a(paramContext.getResources(), 2130845003);
      if (paramObject != null)
      {
        paramaklg.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageBitmap(paramObject);
        paramaklg.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bjuk.b);
      }
      for (;;)
      {
        paramaklg.jdField_a_of_type_AndroidWidgetTextView.setText(2131698324);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avof
 * JD-Core Version:    0.7.0.1
 */