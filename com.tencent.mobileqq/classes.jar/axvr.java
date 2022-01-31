import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare.1.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.io.File;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public final class axvr
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.findViewById(2131376585);
    if (localObject1 == null) {}
    do
    {
      return;
      paramView = ((View)localObject1).getTag(2131376585);
    } while (!(paramView instanceof StructMsgForImageShare));
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)paramView;
    Context localContext = ((View)localObject1).getContext();
    label392:
    Intent localIntent;
    try
    {
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(localStructMsgForImageShare.currentAccountUin);
      AbsShareMsg.doReport(paramView, localStructMsgForImageShare);
      if (localStructMsgForImageShare.msgId > 0L)
      {
        axqy.b(paramView, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForImageShare.msgId), "");
        ThreadManager.getSubThreadHandler().postDelayed(new StructMsgForImageShare.1.1(this, localStructMsgForImageShare, paramView), 0L);
      }
      if ((localStructMsgForImageShare.getFirstImageElement() != null) && (localStructMsgForImageShare.getFirstImageElement().a()))
      {
        axqy.b(null, "dc00898", "", "", "0X800A28", "0X800A28", 0, 0, "", "4", Long.toString(localStructMsgForImageShare.mSourceAppid), ForwardUtils.b(localStructMsgForImageShare.uinType));
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "大图点击=0X800A28, appid=" + localStructMsgForImageShare.mSourceAppid + ", fileType=4");
        }
      }
    }
    catch (AccountNotMatchException paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramView.getStackTrace().toString());
        }
      }
      if ((paramView.getStatus() != 0) || (paramView.isDownloadStarted())) {
        break label392;
      }
      paramView.startDownload();
      return;
      localIntent = new Intent(localContext, AIOGalleryActivity.class);
      localIntent.putExtra("curType", localStructMsgForImageShare.uinType);
      localIntent.putExtra("_id", localStructMsgForImageShare.uniseq);
      localIntent.putExtra("appid", localStructMsgForImageShare.mSourceAppid);
      localIntent.putExtra("image_share_by_server", ((axwv)localObject2).a());
      localIntent.putExtra("urlAtServer", ((axwv)localObject2).T);
      localIntent.putExtra("KEY_FILE_ID", ((axwv)localObject2).c);
      localIntent.putExtra("picMD5", ((axwv)localObject2).U);
      localIntent.putExtra("url", ((axwv)localObject2).S);
      localIntent.putExtra("friendUin", localStructMsgForImageShare.uin);
      localIntent.putExtra("KEY_MSG_VERSION_CODE", localStructMsgForImageShare.messageVersion);
      localIntent.putExtra("isSend", localStructMsgForImageShare.mIsSend);
      localIntent.putExtra("KEY_BUSI_TYPE", 1030);
      localIntent.putExtra("IS_FROMOTHER_TERMINAL_KEY", bbfh.c(localStructMsgForImageShare.mIsSend));
      localIntent.putExtra("uin", localStructMsgForImageShare.uin);
      if (localStructMsgForImageShare.mIsSend != 1) {
        break label1351;
      }
    }
    axqy.b(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStructMsgForImageShare.mMsgServiceID + "", "", "", "");
    axqy.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
    int i = 0;
    Object localObject2 = localStructMsgForImageShare.getFirstImageElement();
    if (localObject2 != null)
    {
      if ((!bbfh.b(localStructMsgForImageShare.mIsSend)) && (((axwv)localObject2).a != null))
      {
        paramView = advs.a(localContext, ((axwv)localObject2).a);
        if (paramView != null) {
          if (paramView.getStatus() == 2)
          {
            paramView.restartDownload();
            return;
          }
        }
      }
      paramView = localStructMsgForImageShare.currentAccountUin;
      localIntent.putExtra("KEY_TROOP_CODE", paramView);
      localIntent.putExtra("fileSize", ((axwv)localObject2).d);
      localIntent.putExtra("KEY_TIME", ((axwv)localObject2).e);
      localIntent.putExtra("KEY_SUB_VERSION", 5);
      localIntent.putExtra("KEY_FILE_SIZE_FLAG", 0);
      localIntent.putExtra("uniSeq", localStructMsgForImageShare.uniseq);
      localIntent.putExtra("KEY_THUMBNAL_BOUND", xpu.a((View)localObject1));
      localObject2 = ((axwv)localObject2).a;
      if (localObject2 != null)
      {
        localIntent.addFlags(603979776);
        paramView = ((MessageForPic)localObject2).selfuin;
        if (!((MessageForPic)localObject2).isMultiMsg) {
          break label1603;
        }
      }
    }
    label1603:
    for (;;)
    {
      try
      {
        localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        localObject1 = paramView;
        if ((localObject3 instanceof QQAppInterface)) {
          localObject1 = ((AppRuntime)localObject3).getAccount();
        }
        paramView = (View)localObject1;
      }
      catch (Exception localException)
      {
        Object localObject3;
        AIOImageData localAIOImageData;
        int j;
        label1351:
        continue;
        if ((!localObject2[7].equals("scrawl_link")) || (localObject2.length < 9)) {
          continue;
        }
        String str = localObject2[8];
        continue;
        if ((localStructMsgForImageShare.mMsgActionData == null) || (!localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare"))) {
          continue;
        }
        localAIOImageData.jdField_b_of_type_Int = 2;
        localAIOImageData.a = localStructMsgForImageShare.getBytes();
        if ((!bbfh.b(((MessageForPic)localObject2).issend)) || (TextUtils.isEmpty(((MessageForPic)localObject2).path)) || (!new File(((MessageForPic)localObject2).path).exists())) {
          continue;
        }
        localAIOImageData.jdField_b_of_type_JavaLangString = ((MessageForPic)localObject2).path;
        continue;
        if (localStructMsgForImageShare.mImageBizType != 2) {
          continue;
        }
        if ((!bbfh.b(((MessageForPic)localObject2).issend)) || (TextUtils.isEmpty(((MessageForPic)localObject2).path)) || (!TextUtils.isEmpty(((MessageForPic)localObject2).md5)) || (!new File(((MessageForPic)localObject2).path).exists())) {
          continue;
        }
        localAIOImageData.jdField_b_of_type_JavaLangString = ((MessageForPic)localObject2).path;
        localAIOImageData.jdField_b_of_type_Int = 4;
        continue;
        paramView.putBoolean("extra.FROM_AIO", true);
        paramView.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((Activity)localContext).getClass().getName());
        continue;
        str = "";
        continue;
      }
      localObject3 = new AIOImageProviderService(paramView, ((MessageForPic)localObject2).frienduin, ((MessageForPic)localObject2).istroop, (ChatMessage)localObject2);
      localAIOImageData = aehw.a((MessageForPic)localObject2);
      if (localStructMsgForImageShare.message != null)
      {
        localAIOImageData.g = localStructMsgForImageShare.message.time;
        localAIOImageData.i = localStructMsgForImageShare.message.shmsgseq;
      }
      if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
      {
        localAIOImageData.jdField_b_of_type_Int = 1;
        localAIOImageData.a = localStructMsgForImageShare.getBytes();
        localObject2 = aeht.a(localStructMsgForImageShare);
        localAIOImageData.d = aeht.a((String[])localObject2);
        if ((localObject2 != null) && (localObject2.length >= 8))
        {
          if (localObject2[7].equals("link"))
          {
            localObject1 = localObject2[4];
            bghx.a(null, paramView, localContext, "3009", "2", "40054", localObject2[0], new String[] { localObject2[2], localObject2[4], localObject1 });
          }
        }
        else
        {
          paramView = new Bundle();
          paramView.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(((AIOImageProviderService)localObject3).asBinder()));
          paramView.putParcelable("extra.EXTRA_CURRENT_IMAGE", localAIOImageData);
          paramView.putInt("forward_source_uin_type", localStructMsgForImageShare.uinType);
          if (((localContext instanceof SplashActivity)) || ((localContext instanceof ChatActivity)) || ((localContext instanceof ChatHistoryActivity)) || ((localContext instanceof PublicFragmentActivity)) || ((localContext instanceof ChatHistory)))
          {
            if (!(localContext instanceof MultiForwardActivity)) {
              continue;
            }
            localObject1 = ((BaseActivity)localContext).getAppInterface();
            if ((localObject1 instanceof QQAppInterface))
            {
              paramView.putBoolean("extra.FROM_AIO", true);
              paramView.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
              paramView.putString("uin", ((MultiForwardActivity)localContext).getChatFragment().a().a().a);
              localObject2 = paramView.getString("extra.GROUP_UIN");
              if ((localObject2 != null) && (((QQAppInterface)localObject1).b((String)localObject2) == 2)) {
                paramView.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
              }
            }
          }
          localIntent.putExtras(paramView);
          localContext.startActivity(localIntent);
          i = 1;
          j = 0;
          if (i != 0) {
            j = 1;
          }
          axqy.b(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X80055C7", "0X80055C7", 0, j, "" + localStructMsgForImageShare.msgId, "" + localStructMsgForImageShare.templateIDForPortal, "", localStructMsgForImageShare.mMsgUrl);
          paramView = new StringBuilder().append("MSGID=").append(Long.toString(localStructMsgForImageShare.msgId)).append(";TEPLATEID=").append(localStructMsgForImageShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(axup.a(localStructMsgForImageShare.mMsgUrl));
          axqy.b(null, "P_CliOper", "Pb_account_lifeservice", localStructMsgForImageShare.uin, "0X8005D49", "0X8005D49", 0, j, paramView.toString(), "", "", "");
          return;
          paramView = localStructMsgForImageShare.uin;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvr
 * JD-Core Version:    0.7.0.1
 */