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

public class asfl
  extends ahny
{
  int a;
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramahnt = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof asfm))) {
        break label179;
      }
      paramahnt = (asfm)paramahnt;
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
          paramahnt.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130839144);
          if ((paramahnt.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramahnt.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).start();
          }
          paramahnt.jdField_a_of_type_AndroidWidgetTextView.setText(2131699105);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramahnt = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131560754, null);
        paramahnt = new asfm();
        paramahnt.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368899));
        paramahnt.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131367679));
        paramahnt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378431));
        paramView.setTag(paramahnt);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298087) + paramOnClickListener.getDimensionPixelSize(2131298089) + paramOnClickListener.getDimensionPixelSize(2131298088));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramahnt.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramahnt.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).stop();
      }
      paramObject = bawu.a(paramContext.getResources(), 2130844282);
      if (paramObject != null)
      {
        paramahnt.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageBitmap(paramObject);
        paramahnt.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bfwa.b);
      }
      for (;;)
      {
        paramahnt.jdField_a_of_type_AndroidWidgetTextView.setText(2131699104);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfl
 * JD-Core Version:    0.7.0.1
 */