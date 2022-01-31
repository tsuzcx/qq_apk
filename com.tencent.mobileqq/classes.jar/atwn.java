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

public class atwn
  extends ajff
{
  int a;
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramajfa = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof atwo))) {
        break label179;
      }
      paramajfa = (atwo)paramajfa;
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
          paramajfa.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130839228);
          if ((paramajfa.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramajfa.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).start();
          }
          paramajfa.jdField_a_of_type_AndroidWidgetTextView.setText(2131699461);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramajfa = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131560933, null);
        paramajfa = new atwo();
        paramajfa.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369129));
        paramajfa.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131367808));
        paramajfa.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379049));
        paramView.setTag(paramajfa);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298110) + paramOnClickListener.getDimensionPixelSize(2131298112) + paramOnClickListener.getDimensionPixelSize(2131298111));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramajfa.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramajfa.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).stop();
      }
      paramObject = bcwc.a(paramContext.getResources(), 2130844632);
      if (paramObject != null)
      {
        paramajfa.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageBitmap(paramObject);
        paramajfa.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bhxo.b);
      }
      for (;;)
      {
        paramajfa.jdField_a_of_type_AndroidWidgetTextView.setText(2131699460);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atwn
 * JD-Core Version:    0.7.0.1
 */