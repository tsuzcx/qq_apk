package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.ui.ScreenShareAskArkBottomUpDialog;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class ScreenShareAskAction
  extends JumpAction
{
  private Activity jdField_a_of_type_AndroidAppActivity = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ScreenShareAskAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    Object localObject = paramBaseActivity.getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = ((ChatFragment)localObject).a();
      if (((BaseChatPie)localObject).a != null)
      {
        FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((BaseChatPie)localObject).a.a);
        paramBaseActivity = new ScreenShareAskArkBottomUpDialog(paramBaseActivity, ((BaseChatPie)localObject).a.d, localFaceDrawable, new ScreenShareAskAction.2(this, paramBaseActivity, (BaseChatPie)localObject, paramString));
        paramBaseActivity.a(new ScreenShareAskAction.3(this, paramString));
        paramBaseActivity.show();
        ReportController.b(null, "dc00898", "", "", "0X800B8A5", "0X800B8A5", 0, 0, paramString, "", "", "");
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      new Handler(Looper.getMainLooper()).post(new ScreenShareAskAction.1(this));
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ScreenShareAskAction", 1, localStringBuilder.toString());
      b_("ScreenShareAskAction");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ScreenShareAskAction
 * JD-Core Version:    0.7.0.1
 */