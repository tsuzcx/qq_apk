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
  private Activity H = null;
  private QQAppInterface I;
  
  public ScreenShareAskAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.I = paramQQAppInterface;
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    Object localObject = paramBaseActivity.getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).k() != null))
    {
      localObject = ((ChatFragment)localObject).k();
      if (((BaseChatPie)localObject).ah != null)
      {
        FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.I, 1, ((BaseChatPie)localObject).ah.b);
        paramBaseActivity = new ScreenShareAskArkBottomUpDialog(paramBaseActivity, ((BaseChatPie)localObject).ah.e, localFaceDrawable, new ScreenShareAskAction.2(this, paramBaseActivity, (BaseChatPie)localObject, paramString));
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
      h_("ScreenShareAskAction");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ScreenShareAskAction
 * JD-Core Version:    0.7.0.1
 */