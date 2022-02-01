import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class auup
  extends auun
{
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  TextView b;
  TextView c;
  
  public auup(View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131364501));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(afur.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379686));
    this.b = ((TextView)paramView.findViewById(2131379947));
    this.c = ((TextView)paramView.findViewById(2131379767));
  }
  
  public void a(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo == null) {
      QLog.e(GameSessionView.a, 0, "[updateSession] info is null.");
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840578);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840578);
    try
    {
      if (paramGameCenterSessionInfo.a() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramGameCenterSessionInfo.a(), (URLDrawable.URLDrawableOptions)localObject));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#80333333"));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("来自" + paramGameCenterSessionInfo.f());
        if (paramGameCenterSessionInfo.a() != 0) {
          break;
        }
        localObject = "[" + paramGameCenterSessionInfo.b() + "位好友请求]来自" + paramGameCenterSessionInfo.f();
        this.c.setText(new bdnt((CharSequence)localObject, 3, 16));
        this.b.setTextColor(Color.parseColor("#80333333"));
        this.b.setText(autf.a(paramGameCenterSessionInfo.a() * 1000L));
        return;
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramGameCenterSessionInfo.g(), (URLDrawable.URLDrawableOptions)localObject));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(GameSessionView.a, 1, "[updateSession] " + localException);
        continue;
        String str = paramGameCenterSessionInfo.i();
        this.c.setText(new bdnt(str, 3, 16, -1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auup
 * JD-Core Version:    0.7.0.1
 */