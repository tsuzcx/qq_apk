import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class asnt
{
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  
  public asnt(View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131364287));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(aepi.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378812));
    this.b = ((TextView)paramView.findViewById(2131378902));
    this.c = ((TextView)paramView.findViewById(2131379038));
    this.d = ((TextView)paramView.findViewById(2131378885));
    this.e = ((TextView)paramView.findViewById(2131379075));
  }
  
  public void a(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo == null) {
      QLog.e(GameSessionView.a, 0, "[updateSession] info is null.");
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839372);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839372);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramGameCenterSessionInfo.f(), (URLDrawable.URLDrawableOptions)localObject));
      this.jdField_a_of_type_AndroidWidgetTextView.setText("来自" + paramGameCenterSessionInfo.e());
      this.b.setText(paramGameCenterSessionInfo.g());
      if (paramGameCenterSessionInfo.a() == 0)
      {
        localObject = "[" + paramGameCenterSessionInfo.b() + "位好友请求]来自" + paramGameCenterSessionInfo.e();
        this.d.setText(new bamp((CharSequence)localObject, 3, 16));
        this.e.setVisibility(4);
        this.c.setText(asmw.a(paramGameCenterSessionInfo.a() * 1000L));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(GameSessionView.a, 1, "[updateSession] " + localException);
        continue;
        this.d.setText(new bamp(paramGameCenterSessionInfo.h(), 3, 16, -1));
        if (paramGameCenterSessionInfo.c() == 0)
        {
          this.e.setVisibility(4);
        }
        else
        {
          this.e.setVisibility(0);
          this.e.setText(asmw.a(paramGameCenterSessionInfo.c()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnt
 * JD-Core Version:    0.7.0.1
 */