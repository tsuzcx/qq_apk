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

public class awig
  extends alcd
{
  int a;
  
  public View a(int paramInt, Object paramObject, alby paramalby, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aled paramaled)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramalby = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof awih))) {
        break label179;
      }
      paramalby = (awih)paramalby;
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
          paramalby.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130839406);
          if ((paramalby.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramalby.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).start();
          }
          paramalby.jdField_a_of_type_AndroidWidgetTextView.setText(2131698059);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramalby = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561160, null);
        paramalby = new awih();
        paramalby.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369536));
        paramalby.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131368138));
        paramalby.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380031));
        paramView.setTag(paramalby);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298192) + paramOnClickListener.getDimensionPixelSize(2131298194) + paramOnClickListener.getDimensionPixelSize(2131298193));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramalby.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramalby.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).stop();
      }
      paramObject = bggl.a(paramContext.getResources(), 2130845101);
      if (paramObject != null)
      {
        paramalby.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageBitmap(paramObject);
        paramalby.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bkpg.b);
      }
      for (;;)
      {
        paramalby.jdField_a_of_type_AndroidWidgetTextView.setText(2131698058);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awig
 * JD-Core Version:    0.7.0.1
 */