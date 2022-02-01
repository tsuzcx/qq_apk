import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5.1;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5.2;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class bdpd
  implements View.OnClickListener
{
  long a;
  
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick start ........");
    }
    if (SystemClock.uptimeMillis() - this.a < 1000L) {}
    label284:
    label1449:
    label1643:
    label1778:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a = SystemClock.uptimeMillis();
      View localView = paramView.findViewById(2131378101);
      if (localView != null)
      {
        Object localObject1 = localView.getTag(2131378101);
        if ((localObject1 != null) && (StructMsgForGeneralShare.class.isInstance(localObject1)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject1;
          localObject1 = paramView.getTag();
          Object localObject3;
          Context localContext;
          ChatFragment localChatFragment;
          if (localObject1 != null) {
            if ((localObject1 instanceof ahtm))
            {
              localObject3 = (ahtm)localObject1;
              localContext = paramView.getContext();
              localChatFragment = ((FragmentActivity)localContext).getChatFragment();
              if (localChatFragment == null) {
                break label253;
              }
              localObject1 = localChatFragment.a();
            }
          }
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                if (localObject1 == null) {
                  break label1778;
                }
                if (!"micro_app".equals(localStructMsgForGeneralShare.mMsg_A_ActionData)) {
                  break label284;
                }
                try
                {
                  localObject3 = new JSONObject(localStructMsgForGeneralShare.mMsgActionData);
                  localObject1 = ((JSONObject)localObject3).optString("appId");
                  localObject3 = ((JSONObject)localObject3).optString("entryPath");
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break;
                  }
                  MiniAppLauncher.launchMiniApp(localContext, (String)localObject1, localStructMsgForGeneralShare, (String)localObject3);
                }
                catch (Throwable localThrowable)
                {
                  localThrowable.printStackTrace();
                }
              }
              break;
              if (paramView.getTag(2131378098) == null) {
                break;
              }
              do
              {
                localObject3 = null;
                break;
              } while (paramView.getTag(2131378098) != null);
              break;
              label253:
              localObject2 = BaseApplicationImpl.getApplication().getRuntime();
              if ((localObject2 != null) && ((localObject2 instanceof QQAppInterface)))
              {
                localObject2 = (QQAppInterface)localObject2;
                continue;
                AbsShareMsg.doReport((QQAppInterface)localObject2, localStructMsgForGeneralShare);
                apeg.a((QQAppInterface)localObject2, 0, 4, localStructMsgForGeneralShare.message);
                if ((localStructMsgForGeneralShare != null) && (localStructMsgForGeneralShare.message != null) && ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
                try
                {
                  Object localObject4 = new JSONObject();
                  ((JSONObject)localObject4).put("puin", localStructMsgForGeneralShare.message.frienduin);
                  ((JSONObject)localObject4).put("type", localStructMsgForGeneralShare.index_type);
                  ((JSONObject)localObject4).put("index", localStructMsgForGeneralShare.index);
                  ((JSONObject)localObject4).put("name", localStructMsgForGeneralShare.index_name);
                  ((JSONObject)localObject4).put("net", String.valueOf(nnr.a()));
                  ((JSONObject)localObject4).put("mobile_imei", bhlo.a());
                  ((JSONObject)localObject4).put("obj", "");
                  ((JSONObject)localObject4).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject4).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  txt.a((AppInterface)localObject2, localStructMsgForGeneralShare.message.selfuin, ((JSONObject)localObject4).toString(), "" + localStructMsgForGeneralShare.msgId);
                  Object localObject5 = (oek)((QQAppInterface)localObject2).getManager(88);
                  localObject4 = (ofe)((QQAppInterface)localObject2).a(88);
                  if ((localStructMsgForGeneralShare.message != null) && (localObject5 != null) && (localObject4 != null) && (((oek)localObject5).a(localStructMsgForGeneralShare.message.senderuin)))
                  {
                    localObject5 = localStructMsgForGeneralShare.message;
                    if (TextUtils.isEmpty(localStructMsgForGeneralShare.index))
                    {
                      i = 0;
                      ((ofe)localObject4).a(false, (MessageRecord)localObject5, i, localStructMsgForGeneralShare.mMsgUrl);
                    }
                  }
                  else
                  {
                    if (localStructMsgForGeneralShare.msgId > 0L)
                    {
                      bdll.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForGeneralShare.msgId), "");
                      ThreadManager.getSubThreadHandler().postDelayed(new StructMsgForGeneralShare.5.1(this, localStructMsgForGeneralShare, (QQAppInterface)localObject2), 0L);
                    }
                    if (QLog.isDevelopLevel()) {
                      QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick middle ........");
                    }
                    if ((localObject3 != null) && (((ahtm)localObject3).a != null)) {
                      noe.a((QQAppInterface)localObject2, "", "click", localStructMsgForGeneralShare.mSourceAppid, localStructMsgForGeneralShare.mMsgServiceID, noe.a(((ahtm)localObject3).a.jdField_a_of_type_Int));
                    }
                    if (localStructMsgForGeneralShare.uinType != 0) {
                      break label1643;
                    }
                    i = 0;
                    localObject4 = localStructMsgForGeneralShare.mMsgUrl;
                    if (TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgUrl)) {
                      break label1771;
                    }
                    j = localStructMsgForGeneralShare.mMsgUrl.indexOf("article_id=");
                    if (j <= 0) {
                      break label1771;
                    }
                    localObject5 = localStructMsgForGeneralShare.mMsgUrl.substring("article_id=".length() + j);
                    j = ((String)localObject5).indexOf("&");
                    if (j < 0) {
                      break label1771;
                    }
                    localObject4 = ((String)localObject5).substring(0, j);
                    bdll.b((QQAppInterface)localObject2, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStructMsgForGeneralShare.mMsgServiceID + "", "", "", "");
                    if (localStructMsgForGeneralShare.uinType != 1008) {
                      break label1678;
                    }
                    j = 2;
                    bdll.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004B5C", "0X8004B5C", j, 0, "", String.valueOf(i), (String)localObject4, localStructMsgForGeneralShare.source_puin);
                    bdll.b(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, 0, "1", ForwardUtils.b(localStructMsgForGeneralShare.uinType), localStructMsgForGeneralShare.mContentTitle, String.valueOf(localStructMsgForGeneralShare.mSourceAppid));
                    if (QLog.isColorLevel()) {
                      QLog.d(StructMsgForGeneralShare.access$000(), 2, new Object[] { "图文分享内容点击=", "0X800A630", ", mContentTitle=" + localStructMsgForGeneralShare.mContentTitle, ", uinType=", ForwardUtils.b(localStructMsgForGeneralShare.uinType) });
                    }
                    if ((localView instanceof ViewGroup))
                    {
                      localObject4 = ((ViewGroup)localView).getChildAt(0);
                      if ((localObject4 != null) && ((localObject4 instanceof TextViewWrapLayout)))
                      {
                        localObject4 = ((View)localObject4).getTag(StructMsgForGeneralShare.access$200());
                        if ((localObject4 != null) && ((localObject4 instanceof bdre))) {
                          bdll.b((QQAppInterface)localObject2, "dc00898", "", "", "0X8007C38", "0X8007C38", 0, 0, ((bdre)localObject4).o + "", "", "", "");
                        }
                      }
                    }
                    if ((localObject3 != null) && (localStructMsgForGeneralShare.hasFlag(16)))
                    {
                      if (QLog.isDevelopLevel()) {
                        QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg click report.........");
                      }
                      ThreadManager.post(new StructMsgForGeneralShare.5.2(this, (ahtm)localObject3, (QQAppInterface)localObject2), 2, null, false);
                    }
                    if ((localStructMsgForGeneralShare != null) && (localObject3 != null) && (((ahtm)localObject3).a != null) && ((((ahtm)localObject3).a.jdField_a_of_type_Int == 1025) || (((ahtm)localObject3).a.jdField_a_of_type_Int == 0)) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (nmd.b(((ahtm)localObject3).a.jdField_a_of_type_JavaLangString)) && ((localStructMsgForGeneralShare.mMsgServiceID != 92) || (localStructMsgForGeneralShare.message == null))) {}
                  }
                  try
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d(StructMsgForGeneralShare.access$000(), 2, String.format("click qidian bulk msg, taskId: %d", new Object[] { Integer.valueOf(Integer.parseInt(localStructMsgForGeneralShare.mQidianBulkTaskId)) }));
                    }
                    if (!localStructMsgForGeneralShare.mQidianBulkTaskId.equals("0"))
                    {
                      localObject4 = new JSONObject();
                      ((JSONObject)localObject4).put("action", "click");
                      ((JSONObject)localObject4).put("fromUin", localStructMsgForGeneralShare.message.frienduin);
                      ((JSONObject)localObject4).put("toUin", ((QQAppInterface)localObject2).getCurrentAccountUin());
                      ((JSONObject)localObject4).put("taskID", localStructMsgForGeneralShare.mQidianBulkTaskId);
                      ((JSONObject)localObject4).put("clickURL", localStructMsgForGeneralShare.mMsgUrl);
                      ((JSONObject)localObject4).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
                      ((bkib)((QQAppInterface)localObject2).a(85)).a(((JSONObject)localObject4).toString(), localStructMsgForGeneralShare.message.frienduin, "", 10009, 0);
                    }
                  }
                  catch (Exception localException)
                  {
                    break label1449;
                  }
                  ((bkgt)((QQAppInterface)localObject2).getManager(165)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl, 0, "");
                  if ((localObject3 != null) && (tzq.a(((ahtm)localObject3).a)) && (localStructMsgForGeneralShare.message != null)) {
                    bdll.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.message.click", 0, 0, localStructMsgForGeneralShare.message.time + "", "", "", localStructMsgForGeneralShare.mMsgBrief);
                  }
                  if (localChatFragment != null)
                  {
                    localObject3 = localChatFragment.a();
                    if ((localObject3 instanceof ainh)) {
                      ((ainh)localObject3).a.b();
                    }
                  }
                  StructMsgForGeneralShare.onClickEvent((QQAppInterface)localObject2, localContext, localStructMsgForGeneralShare, paramView, new bdpi((QQAppInterface)localObject2, paramView, localStructMsgForGeneralShare));
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    int j;
                    localJSONException.printStackTrace();
                    continue;
                    int i = Integer.parseInt(localStructMsgForGeneralShare.index);
                    continue;
                    if (localStructMsgForGeneralShare.uinType == 1)
                    {
                      i = 1;
                    }
                    else if (localStructMsgForGeneralShare.uinType == 3000)
                    {
                      i = 2;
                    }
                    else
                    {
                      i = 3;
                      continue;
                      j = 1;
                      continue;
                      if ((localStructMsgForGeneralShare != null) && (localObject3 != null) && (((ahtm)localObject3).a != null) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (((ahtm)localObject3).a.jdField_a_of_type_Int == 1024)) {
                        ((bkgt)((QQAppInterface)localObject2).getManager(165)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl, 1, "");
                      }
                    }
                  }
                }
              }
            }
            Object localObject2 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpd
 * JD-Core Version:    0.7.0.1
 */