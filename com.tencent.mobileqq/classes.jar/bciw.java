import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton.3.2;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bciw
  implements View.OnClickListener
{
  bciw(bcit parambcit) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a.jdField_c_of_type_Long < 1000L) {}
    label136:
    label986:
    label989:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && (bcit.class.isInstance(localObject1)))
      {
        Object localObject2 = ((ViewGroup)paramView.getParent().getParent()).getTag(2131377871);
        if ((localObject2 != null) && (StructMsgForGeneralShare.class.isInstance(localObject2)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject2;
          bcit localbcit = (bcit)localObject1;
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
                  break label989;
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
                  ((JSONObject)localObject2).put("type", localbcit.l);
                  ((JSONObject)localObject2).put("index", localbcit.j);
                  ((JSONObject)localObject2).put("name", localbcit.k);
                  ((JSONObject)localObject2).put("net", String.valueOf(HttpUtil.getNetWorkType()));
                  ((JSONObject)localObject2).put("mobile_imei", DeviceInfoUtil.getIMEI());
                  ((JSONObject)localObject2).put("obj", "");
                  ((JSONObject)localObject2).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject2).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  uei.a((AppInterface)localObject1, localStructMsgForGeneralShare.message.selfuin, ((JSONObject)localObject2).toString(), "" + localStructMsgForGeneralShare.msgId);
                  localObject2 = new bchd((QQAppInterface)localObject1, paramView, localStructMsgForGeneralShare.message);
                  bool = ((ofx)((QQAppInterface)localObject1).getManager(88)).a(this.a, (Activity)localContext);
                  if (!bool) {
                    if (localbcit.b()) {
                      if (localbcit.a())
                      {
                        bcef.b((QQAppInterface)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "0X80061FE", "0X80061FE", 0, 1, 0, "", "", "", "");
                        bcef.b(null, "P_CliOper", "Vip_pay_mywallet", ((QQAppInterface)localObject1).getAccount(), "wallet", "publicpaymsg.btn.click", 1, 0, localStructMsgForGeneralShare.uin, "", String.valueOf(localStructMsgForGeneralShare.msgId), "");
                        if (TextUtils.isEmpty(this.a.e)) {
                          localObject2 = this.a.d;
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
                      localObject2 = new JSONObject((String)localObject2);
                      VACDReportUtil.a("orderId=" + ((JSONObject)localObject2).optString("orderId"), "qqwallet", "publicpaymsg.pay.click", null, null, 0, null);
                      ajvc localajvc = (ajvc)((QQAppInterface)localObject1).getManager(135);
                      localajvc.a = localContext;
                      localajvc.a(localStructMsgForGeneralShare.message.frienduin, (JSONObject)localObject2, new bcix(this, localStructMsgForGeneralShare, localContext));
                      if ((bool) && (localStructMsgForGeneralShare.message.istroop == 1008)) {
                        ocw.b((QQAppInterface)localObject1, localStructMsgForGeneralShare.uin);
                      }
                      localObject2 = (bily)((QQAppInterface)localObject1).getManager(165);
                      if (bily.a(localbcit.e, localbcit.d, localbcit.b)) {
                        ((bily)localObject2).a(localbcit.jdField_c_of_type_JavaLangString, localbcit.e, localbcit.d, localbcit.b, 2, "");
                      }
                      if ((localStructMsgForGeneralShare.message != null) && (bily.a((QQAppInterface)localObject1, localStructMsgForGeneralShare.message))) {
                        ((bily)localObject2).a(localbcit.d);
                      }
                      if (localStructMsgForGeneralShare.msgId <= 0L) {
                        break;
                      }
                      ThreadManager.getSubThreadHandler().postDelayed(new StructMsgItemButton.3.2(this, localbcit, localStructMsgForGeneralShare, (QQAppInterface)localObject1, bool), 0L);
                      break;
                      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
                      if (!(localObject1 instanceof QQAppInterface)) {
                        break label986;
                      }
                      localObject1 = (QQAppInterface)localObject1;
                      break label136;
                      localJSONException = localJSONException;
                      localJSONException.printStackTrace();
                      continue;
                      String str = this.a.e;
                      continue;
                    }
                    catch (Exception localException)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("StructMsgItemButton", 2, "pay error:" + localException.getMessage());
                      continue;
                    }
                    paramView.setClickable(false);
                    paramView.setOnClickListener(null);
                    paramView.setOnTouchListener(null);
                    paramView.setOnLongClickListener(null);
                    continue;
                    if (localStructMsgForGeneralShare.message != null)
                    {
                      localbcit.b = ofx.a(localStructMsgForGeneralShare.message.frienduin, localbcit.b, (QQAppInterface)localObject1);
                      if ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                        bool = localException.a(localbcit.jdField_c_of_type_JavaLangString, localbcit.b, localbcit.d, localbcit.e, localbcit.a, new Object[] { Boolean.valueOf(true) });
                      } else {
                        bool = localException.a(localbcit.jdField_c_of_type_JavaLangString, localbcit.b, localbcit.d, localbcit.e, localStructMsgForGeneralShare.msgId, new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciw
 * JD-Core Version:    0.7.0.1
 */