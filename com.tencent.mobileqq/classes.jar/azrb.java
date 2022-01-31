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
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class azrb
  implements View.OnClickListener
{
  long a;
  
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick start ........");
    }
    if (SystemClock.uptimeMillis() - this.a < 1000L) {}
    label1538:
    label1673:
    for (;;)
    {
      return;
      this.a = SystemClock.uptimeMillis();
      View localView = paramView.findViewById(2131377085);
      if (localView != null)
      {
        Object localObject1 = localView.getTag(2131377085);
        if ((localObject1 != null) && (StructMsgForGeneralShare.class.isInstance(localObject1)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject1;
          localObject1 = paramView.getTag();
          Object localObject2;
          Context localContext;
          ChatFragment localChatFragment;
          if (localObject1 != null) {
            if ((localObject1 instanceof afyi))
            {
              localObject2 = (afyi)localObject1;
              localContext = paramView.getContext();
              localChatFragment = ((FragmentActivity)localContext).getChatFragment();
              if (localChatFragment == null) {
                break label235;
              }
              localObject1 = localChatFragment.a();
            }
          }
          for (;;)
          {
            for (;;)
            {
              if (localObject1 == null) {
                break label1673;
              }
              if (!"micro_app".equals(localStructMsgForGeneralShare.mMsg_A_ActionData)) {
                break label266;
              }
              try
              {
                localObject1 = new JSONObject(localStructMsgForGeneralShare.mMsgActionData);
                paramView = ((JSONObject)localObject1).optString("appId");
                localObject1 = ((JSONObject)localObject1).optString("entryPath");
                if (TextUtils.isEmpty(paramView)) {
                  break;
                }
                MiniAppLauncher.launchMiniApp(localContext, paramView, localStructMsgForGeneralShare, (String)localObject1);
                return;
              }
              catch (Throwable paramView)
              {
                paramView.printStackTrace();
                return;
              }
            }
            if (paramView.getTag(2131377082) == null) {
              break;
            }
            do
            {
              localObject2 = null;
              break;
            } while (paramView.getTag(2131377082) != null);
            return;
            label235:
            localObject1 = BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
            {
              localObject1 = (QQAppInterface)localObject1;
              continue;
              label266:
              AbsShareMsg.doReport((QQAppInterface)localObject1, localStructMsgForGeneralShare);
              amnk.a((QQAppInterface)localObject1, 0, 4, localStructMsgForGeneralShare.message);
              if ((localStructMsgForGeneralShare != null) && (localStructMsgForGeneralShare.message != null) && ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
              try
              {
                Object localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("puin", localStructMsgForGeneralShare.message.frienduin);
                ((JSONObject)localObject3).put("type", localStructMsgForGeneralShare.index_type);
                ((JSONObject)localObject3).put("index", localStructMsgForGeneralShare.index);
                ((JSONObject)localObject3).put("name", localStructMsgForGeneralShare.index_name);
                ((JSONObject)localObject3).put("net", String.valueOf(ndd.a()));
                ((JSONObject)localObject3).put("mobile_imei", bdcb.a());
                ((JSONObject)localObject3).put("obj", "");
                ((JSONObject)localObject3).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                ((JSONObject)localObject3).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                swj.a((AppInterface)localObject1, localStructMsgForGeneralShare.message.selfuin, ((JSONObject)localObject3).toString(), "" + localStructMsgForGeneralShare.msgId);
                Object localObject4 = (ntw)((QQAppInterface)localObject1).getManager(88);
                localObject3 = (nup)((QQAppInterface)localObject1).a(88);
                if ((localStructMsgForGeneralShare.message != null) && (localObject4 != null) && (localObject3 != null) && (((ntw)localObject4).a(localStructMsgForGeneralShare.message.senderuin)))
                {
                  localObject4 = localStructMsgForGeneralShare.message;
                  if (TextUtils.isEmpty(localStructMsgForGeneralShare.index))
                  {
                    i = 0;
                    ((nup)localObject3).a(false, (MessageRecord)localObject4, i, localStructMsgForGeneralShare.mMsgUrl);
                  }
                }
                else
                {
                  if (localStructMsgForGeneralShare.msgId > 0L)
                  {
                    azmj.b((QQAppInterface)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForGeneralShare.msgId), "");
                    ThreadManager.getSubThreadHandler().postDelayed(new StructMsgForGeneralShare.5.1(this, localStructMsgForGeneralShare, (QQAppInterface)localObject1), 0L);
                  }
                  if (QLog.isDevelopLevel()) {
                    QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick middle ........");
                  }
                  if ((localObject2 != null) && (((afyi)localObject2).a != null)) {
                    ndq.a((QQAppInterface)localObject1, "", "click", localStructMsgForGeneralShare.mSourceAppid, localStructMsgForGeneralShare.mMsgServiceID, ndq.a(((afyi)localObject2).a.jdField_a_of_type_Int));
                  }
                  if (localStructMsgForGeneralShare.uinType != 0) {
                    break label1538;
                  }
                  i = 0;
                  localObject3 = localStructMsgForGeneralShare.mMsgUrl;
                  if (TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgUrl)) {
                    break label1666;
                  }
                  j = localStructMsgForGeneralShare.mMsgUrl.indexOf("article_id=");
                  if (j <= 0) {
                    break label1666;
                  }
                  localObject4 = localStructMsgForGeneralShare.mMsgUrl.substring("article_id=".length() + j);
                  j = ((String)localObject4).indexOf("&");
                  if (j < 0) {
                    break label1666;
                  }
                  localObject3 = ((String)localObject4).substring(0, j);
                  azmj.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStructMsgForGeneralShare.mMsgServiceID + "", "", "", "");
                  if (localStructMsgForGeneralShare.uinType != 1008) {
                    break label1573;
                  }
                  j = 2;
                  azmj.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8004B5C", "0X8004B5C", j, 0, "", String.valueOf(i), (String)localObject3, localStructMsgForGeneralShare.source_puin);
                  azmj.b(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, 0, "1", ForwardUtils.b(localStructMsgForGeneralShare.uinType), localStructMsgForGeneralShare.mContentTitle, "");
                  if (QLog.isColorLevel()) {
                    QLog.d(StructMsgForGeneralShare.access$000(), 2, new Object[] { "图文分享内容点击=", "0X800A630", ", mContentTitle=" + localStructMsgForGeneralShare.mContentTitle, ", uinType=", ForwardUtils.b(localStructMsgForGeneralShare.uinType) });
                  }
                  if ((localView instanceof ViewGroup))
                  {
                    localObject3 = ((ViewGroup)localView).getChildAt(0);
                    if ((localObject3 != null) && ((localObject3 instanceof TextViewWrapLayout)))
                    {
                      localObject3 = ((View)localObject3).getTag(StructMsgForGeneralShare.access$200());
                      if ((localObject3 != null) && ((localObject3 instanceof aztc))) {
                        azmj.b((QQAppInterface)localObject1, "dc00898", "", "", "0X8007C38", "0X8007C38", 0, 0, ((aztc)localObject3).k + "", "", "", "");
                      }
                    }
                  }
                  if ((localObject2 != null) && (localStructMsgForGeneralShare.hasFlag(16)))
                  {
                    if (QLog.isDevelopLevel()) {
                      QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg click report.........");
                    }
                    ThreadManager.post(new StructMsgForGeneralShare.5.2(this, (afyi)localObject2, (QQAppInterface)localObject1), 2, null, false);
                  }
                  if ((localStructMsgForGeneralShare != null) && (localObject2 != null) && (((afyi)localObject2).a != null) && ((((afyi)localObject2).a.jdField_a_of_type_Int == 1025) || (((afyi)localObject2).a.jdField_a_of_type_Int == 0)) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (nbp.b(((afyi)localObject2).a.jdField_a_of_type_JavaLangString)) && ((localStructMsgForGeneralShare.mMsgServiceID != 92) || (localStructMsgForGeneralShare.message == null))) {}
                }
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(StructMsgForGeneralShare.access$000(), 2, String.format("click qidian bulk msg, taskId: %d", new Object[] { Integer.valueOf(Integer.parseInt(localStructMsgForGeneralShare.mQidianBulkTaskId)) }));
                  }
                  if (!localStructMsgForGeneralShare.mQidianBulkTaskId.equals("0"))
                  {
                    localObject2 = new JSONObject();
                    ((JSONObject)localObject2).put("action", "click");
                    ((JSONObject)localObject2).put("fromUin", localStructMsgForGeneralShare.message.frienduin);
                    ((JSONObject)localObject2).put("toUin", ((QQAppInterface)localObject1).getCurrentAccountUin());
                    ((JSONObject)localObject2).put("taskID", localStructMsgForGeneralShare.mQidianBulkTaskId);
                    ((JSONObject)localObject2).put("clickURL", localStructMsgForGeneralShare.mMsgUrl);
                    ((JSONObject)localObject2).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
                    ((bfvi)((QQAppInterface)localObject1).a(85)).a(((JSONObject)localObject2).toString(), localStructMsgForGeneralShare.message.frienduin, "", 10009, 0);
                  }
                }
                catch (Exception localException)
                {
                  label1425:
                  break label1425;
                }
                ((bfua)((QQAppInterface)localObject1).getManager(165)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl, 0, "");
                if (localChatFragment != null)
                {
                  localObject2 = localChatFragment.a();
                  if ((localObject2 instanceof agot)) {
                    ((agot)localObject2).a.b();
                  }
                }
                StructMsgForGeneralShare.onClickEvent((QQAppInterface)localObject1, localContext, localStructMsgForGeneralShare, paramView, new azrg((QQAppInterface)localObject1, paramView, localStructMsgForGeneralShare));
                return;
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
                    label1573:
                    j = 1;
                    continue;
                    if ((localStructMsgForGeneralShare != null) && (localObject2 != null) && (((afyi)localObject2).a != null) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (((afyi)localObject2).a.jdField_a_of_type_Int == 1024)) {
                      ((bfua)((QQAppInterface)localObject1).getManager(165)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl, 1, "");
                    }
                  }
                }
              }
            }
            localObject1 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrb
 * JD-Core Version:    0.7.0.1
 */