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

public class asfn
  extends ahnw
{
  int a;
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramahnr = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof asfo))) {
        break label179;
      }
      paramahnr = (asfo)paramahnr;
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
          paramahnr.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130839144);
          if ((paramahnr.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramahnr.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).start();
          }
          paramahnr.jdField_a_of_type_AndroidWidgetTextView.setText(2131699115);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramahnr = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131560753, null);
        paramahnr = new asfo();
        paramahnr.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368899));
        paramahnr.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131367679));
        paramahnr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378436));
        paramView.setTag(paramahnr);
        this.a = (paramOnClickListener.getDimensionPixelSize(2131298087) + paramOnClickListener.getDimensionPixelSize(2131298089) + paramOnClickListener.getDimensionPixelSize(2131298088));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramahnr.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramahnr.jdField_a_of_type_ComTencentWidgetThemeImageView.getDrawable()).stop();
      }
      paramObject = baxi.a(paramContext.getResources(), 2130844283);
      if (paramObject != null)
      {
        paramahnr.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageBitmap(paramObject);
        paramahnr.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bfwr.b);
      }
      for (;;)
      {
        paramahnr.jdField_a_of_type_AndroidWidgetTextView.setText(2131699114);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfn
 * JD-Core Version:    0.7.0.1
 */