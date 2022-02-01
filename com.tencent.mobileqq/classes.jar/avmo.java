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
import com.tencent.mobileqq.qipc.QIPCClientHelper;

public class avmo
  extends avmn
{
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  TextView b;
  TextView c;
  TextView d;
  
  public avmo(View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131364545));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379965));
    this.b = ((TextView)paramView.findViewById(2131380131));
    this.c = ((TextView)paramView.findViewById(2131379945));
    this.d = ((TextView)paramView.findViewById(2131380175));
  }
  
  public void a(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo == null) {
      QLog.e(GameSessionView.a, 0, "[updateSession] info is null.");
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840588);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840588);
    try
    {
      if (paramGameCenterSessionInfo.a() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramGameCenterSessionInfo.a(), (URLDrawable.URLDrawableOptions)localObject));
      }
      for (;;)
      {
        if (paramGameCenterSessionInfo.a() != 0) {
          break label285;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramGameCenterSessionInfo.f() + "好友新消息");
        localObject = "[" + paramGameCenterSessionInfo.b() + "位好友请求] " + paramGameCenterSessionInfo.h() + ": " + paramGameCenterSessionInfo.i();
        this.c.setText(new begp((CharSequence)localObject, 3, 16));
        if (GameSessionView.a()) {
          break;
        }
        this.d.setVisibility(4);
        this.b.setText(avlf.a(paramGameCenterSessionInfo.a() * 1000L));
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
        this.d.setVisibility(0);
        this.d.setText("1");
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "action_set_clean_req_time", null);
        continue;
        label285:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramGameCenterSessionInfo.h());
        String str = "[" + paramGameCenterSessionInfo.f() + "] " + paramGameCenterSessionInfo.i();
        this.c.setText(new begp(str, 3, 16, -1));
        if (paramGameCenterSessionInfo.c() == 0)
        {
          this.d.setVisibility(4);
        }
        else
        {
          this.d.setVisibility(0);
          this.d.setText(avlf.a(paramGameCenterSessionInfo.c()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmo
 * JD-Core Version:    0.7.0.1
 */