import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare.1.1;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import mqq.os.MqqHandler;

public final class awux
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.findViewById(2131310787);
    if (localObject2 == null) {}
    for (;;)
    {
      return;
      Object localObject1 = ((View)localObject2).getTag(2131310787);
      if ((localObject1 != null) && ((localObject1 instanceof StructMsgForAudioShare)))
      {
        localObject1 = (StructMsgForAudioShare)localObject1;
        paramView = paramView.getTag();
        if ((paramView != null) && ((paramView instanceof adqx)))
        {
          paramView = (adqx)paramView;
          localObject2 = ((View)localObject2).getContext();
        }
      }
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(((StructMsgForAudioShare)localObject1).currentAccountUin);
        if (((StructMsgForAudioShare)localObject1).msgId > 0L)
        {
          awqx.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", ((StructMsgForAudioShare)localObject1).uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(((StructMsgForAudioShare)localObject1).msgId), "");
          ThreadManager.getSubThreadHandler().postDelayed(new StructMsgForAudioShare.1.1(this, (StructMsgForAudioShare)localObject1, localQQAppInterface), 0L);
          AbsShareMsg.doReport(localQQAppInterface, (AbsShareMsg)localObject1);
          if (localQQAppInterface == null) {
            continue;
          }
          mpw.a(localQQAppInterface, "", "click", ((StructMsgForAudioShare)localObject1).mSourceAppid, ((StructMsgForAudioShare)localObject1).mMsgServiceID, mpw.a(paramView.a.a));
          MediaPlayerManager.a(localQQAppInterface).a(true);
        }
      }
      catch (AccountNotMatchException paramView)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("StructMsg", 4, paramView.getStackTrace().toString());
          }
        }
      }
    }
    awqx.b(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, ((StructMsgForAudioShare)localObject1).mMsgServiceID + "", "", "", "");
    awqx.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
    awqx.b(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, 0, "2", ForwardUtils.b(((StructMsgForAudioShare)localObject1).uinType), ((StructMsgForAudioShare)localObject1).mContentTitle, "");
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, new Object[] { "音乐分享内容点击=", "0X800A630", ", mContentTitle=" + ((StructMsgForAudioShare)localObject1).mContentTitle, ", uinType=", ForwardUtils.b(((StructMsgForAudioShare)localObject1).uinType) });
    }
    StructMsgForAudioShare.onClickEvent((Context)localObject2, (StructMsgForAudioShare)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awux
 * JD-Core Version:    0.7.0.1
 */