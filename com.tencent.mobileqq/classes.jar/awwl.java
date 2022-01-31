import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton.3.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class awwl
  implements View.OnClickListener
{
  awwl(awwi paramawwi) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a.jdField_c_of_type_Long < 1000L) {}
    label129:
    label964:
    label967:
    for (;;)
    {
      return;
      this.a.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && (awwi.class.isInstance(localObject1)))
      {
        Object localObject2 = ((ViewGroup)paramView.getParent().getParent()).getTag(2131310787);
        if ((localObject2 != null) && (StructMsgForGeneralShare.class.isInstance(localObject2)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject2;
          awwi localawwi = (awwi)localObject1;
          Context localContext = paramView.getContext();
          if ((localContext instanceof FragmentActivity))
          {
            localObject1 = ((FragmentActivity)localContext).getChatFragment();
            if (localObject1 != null) {
              localObject1 = ((ChatFragment)localObject1).a();
            }
            for (;;)
            {
              for (;;)
              {
                if (localObject1 == null) {
                  break label967;
                }
                localObject2 = "0";
                if (localStructMsgForGeneralShare.message != null) {
                  localObject2 = localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg");
                }
                if ("1".equals(localObject2)) {}
                try
                {
                  localObject2 = new JSONObject();
                  ((JSONObject)localObject2).put("puin", localStructMsgForGeneralShare.message.frienduin);
                  ((JSONObject)localObject2).put("type", localawwi.l);
                  ((JSONObject)localObject2).put("index", localawwi.j);
                  ((JSONObject)localObject2).put("name", localawwi.k);
                  ((JSONObject)localObject2).put("net", String.valueOf(mpl.a()));
                  ((JSONObject)localObject2).put("mobile_imei", babp.a());
                  ((JSONObject)localObject2).put("obj", "");
                  ((JSONObject)localObject2).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject2).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  rsa.a((AppInterface)localObject1, localStructMsgForGeneralShare.message.selfuin, ((JSONObject)localObject2).toString(), "" + localStructMsgForGeneralShare.msgId);
                  localObject2 = new awus((QQAppInterface)localObject1, paramView, localStructMsgForGeneralShare.message);
                  bool = ((nfp)((QQAppInterface)localObject1).getManager(88)).a(this.a, (Activity)localContext);
                  if (!bool) {
                    if (localawwi.b()) {
                      if (localawwi.a())
                      {
                        awqx.b((QQAppInterface)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "0X80061FE", "0X80061FE", 0, 1, 0, "", "", "", "");
                        awqx.b(null, "P_CliOper", "Vip_pay_mywallet", ((QQAppInterface)localObject1).getAccount(), "wallet", "publicpaymsg.btn.click", 1, 0, localStructMsgForGeneralShare.uin, "", String.valueOf(localStructMsgForGeneralShare.msgId), "");
                        if (TextUtils.isEmpty(this.a.e)) {
                          paramView = this.a.d;
                        }
                      }
                    }
                  }
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    boolean bool;
                    try
                    {
                      paramView = new JSONObject(paramView);
                      VACDReportUtil.a("orderId=" + paramView.optString("orderId"), "qqwallet", "publicpaymsg.pay.click", null, null, 0, null);
                      localObject2 = (agkb)((QQAppInterface)localObject1).getManager(135);
                      ((agkb)localObject2).a = localContext;
                      ((agkb)localObject2).a(localStructMsgForGeneralShare.message.frienduin, paramView, new awwm(this, localStructMsgForGeneralShare, localContext));
                      if ((bool) && (localStructMsgForGeneralShare.message.istroop == 1008)) {
                        ncw.b((QQAppInterface)localObject1, localStructMsgForGeneralShare.uin);
                      }
                      paramView = (bcpn)((QQAppInterface)localObject1).getManager(165);
                      if (bcpn.a(localawwi.e, localawwi.d, localawwi.b)) {
                        paramView.a(localawwi.jdField_c_of_type_JavaLangString, localawwi.e, localawwi.d, localawwi.b, 2, "");
                      }
                      if ((localStructMsgForGeneralShare.message != null) && (bcpn.a((QQAppInterface)localObject1, localStructMsgForGeneralShare.message))) {
                        paramView.a(localawwi.d);
                      }
                      if (localStructMsgForGeneralShare.msgId <= 0L) {
                        break;
                      }
                      ThreadManager.getSubThreadHandler().postDelayed(new StructMsgItemButton.3.2(this, localawwi, localStructMsgForGeneralShare, (QQAppInterface)localObject1, bool), 0L);
                      return;
                      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
                      if (!(localObject1 instanceof QQAppInterface)) {
                        break label964;
                      }
                      localObject1 = (QQAppInterface)localObject1;
                      break label129;
                      localJSONException = localJSONException;
                      localJSONException.printStackTrace();
                      continue;
                      paramView = this.a.e;
                      continue;
                    }
                    catch (Exception paramView)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("StructMsgItemButton", 2, "pay error:" + paramView.getMessage());
                      continue;
                    }
                    paramView.setClickable(false);
                    paramView.setOnClickListener(null);
                    paramView.setOnTouchListener(null);
                    paramView.setOnLongClickListener(null);
                    continue;
                    if (localStructMsgForGeneralShare.message != null)
                    {
                      localawwi.b = nfp.a(localStructMsgForGeneralShare.message.frienduin, localawwi.b, (QQAppInterface)localObject1);
                      if ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                        bool = localJSONException.a(localawwi.jdField_c_of_type_JavaLangString, localawwi.b, localawwi.d, localawwi.e, localawwi.a, new Object[] { Boolean.valueOf(true) });
                      } else {
                        bool = localJSONException.a(localawwi.jdField_c_of_type_JavaLangString, localawwi.b, localawwi.d, localawwi.e, localStructMsgForGeneralShare.msgId, new Object[0]);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awwl
 * JD-Core Version:    0.7.0.1
 */