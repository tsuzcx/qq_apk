import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement.1;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public abstract class bdnu
  implements View.OnClickListener, bdod
{
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String L;
  public String M;
  public String N;
  public String O;
  public String P;
  public String Q;
  public String R;
  public String S;
  public String T;
  public String U;
  public String V;
  public String W;
  public String X;
  public String Y;
  public String Z = "";
  public int a;
  public long a;
  public AbsStructMsg a;
  public String a;
  public WeakReference<aftk> a;
  public String aa;
  public String ab;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = -1L;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n = -1;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public bdnu()
  {
    this.jdField_a_of_type_Int = 18;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString;
    if (!bkyp.a(paramString)) {
      str = "https://" + paramString;
    }
    try
    {
      paramString = new URL(str).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return "";
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public abstract View a(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String a();
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Int & paramInt) == 0) {
      this.jdField_b_of_type_Int |= paramInt;
    }
  }
  
  public void a(AbsShareMsg paramAbsShareMsg) {}
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_a_of_type_Int = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_a_of_type_Int);
  }
  
  public abstract void a(XmlSerializer paramXmlSerializer);
  
  public boolean a(int paramInt)
  {
    return (this.jdField_b_of_type_Int & paramInt) == paramInt;
  }
  
  public abstract boolean a(bdpl parambdpl);
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 1000L) {}
    Object localObject1;
    bdnu localbdnu;
    Object localObject4;
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
          localObject1 = paramView.getTag();
        } while (!getClass().isInstance(localObject1));
        localbdnu = (bdnu)localObject1;
        localObject4 = paramView.getContext();
      } while ((!SplashActivity.class.isInstance(localObject4)) && (!ChatActivity.class.isInstance(localObject4)));
      localObject1 = (FragmentActivity)localObject4;
    } while (((FragmentActivity)localObject1).getChatFragment() == null);
    QQAppInterface localQQAppInterface = ((FragmentActivity)localObject1).getChatFragment().a();
    if ((localbdnu.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(localbdnu.aa))) {
      bdla.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localbdnu.ab, "mp_msg_msgpic_click", "aio_morpic_click", Integer.parseInt(this.aa), 0, "", "", Long.toString(localbdnu.jdField_a_of_type_Long), "");
    }
    pwb.a().a(localbdnu.ab, localbdnu);
    if ((!(((FragmentActivity)localObject1).getChatFragment().a() instanceof aido)) || (!TextUtils.isEmpty(localbdnu.aa))) {}
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(this.aa);
        localObject3 = "";
        localObject1 = localObject3;
        if (localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
        {
          localObject1 = localObject3;
          if (localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)
          {
            localObject1 = localObject3;
            if (localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.mExJsonObject != null) {
              localObject1 = localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
            }
          }
        }
        localObject3 = localbdnu.ab;
        long l1 = localbdnu.jdField_a_of_type_Long;
        apau.a(localQQAppInterface, (String)localObject3, 0, 4, i1 + l1, (String)localObject1);
        nzg.a.a(localbdnu, (String)localObject1);
        if ("2747277822".equals(localbdnu.ab)) {
          ((VasExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(3, localbdnu.jdField_a_of_type_Long + "", localbdnu.jdField_b_of_type_JavaLangString);
        }
        if (localbdnu.jdField_a_of_type_Long > 0L) {
          ThreadManager.getSubThreadHandler().postDelayed(new AbsStructMsgElement.1(this, localbdnu, localQQAppInterface), 0L);
        }
      }
      catch (NumberFormatException localClassCastException)
      {
        try
        {
          localObject1 = AIOUtils.getMessage(paramView);
          if ((localObject1 == null) || (localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (!"1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
        }
        catch (ClassCastException localClassCastException)
        {
          try
          {
            Object localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("puin", ((ChatMessage)localObject1).frienduin);
            ((JSONObject)localObject3).put("type", localbdnu.l);
            ((JSONObject)localObject3).put("index", localbdnu.j);
            ((JSONObject)localObject3).put("name", localbdnu.k);
            ((JSONObject)localObject3).put("net", String.valueOf(HttpUtil.getNetWorkType()));
            ((JSONObject)localObject3).put("mobile_imei", DeviceInfoUtil.getIMEI());
            ((JSONObject)localObject3).put("obj", "");
            ((JSONObject)localObject3).put("gdt_cli_data", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick"));
            ((JSONObject)localObject3).put("view_id", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_view_id"));
            usf.a(localQQAppInterface, ((ChatMessage)localObject1).selfuin, ((JSONObject)localObject3).toString(), "" + localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
            localObject3 = new bdob(localQQAppInterface, paramView, (MessageRecord)localObject1);
            localObject5 = ((FragmentActivity)localObject4).getChatFragment();
            Object localObject6;
            if (localObject5 != null)
            {
              localObject5 = ((ChatFragment)localObject5).a();
              if ((localObject5 instanceof aido))
              {
                localObject6 = (aido)localObject5;
                ((aido)localObject6).h += 1;
                if ("web".equals(localbdnu.c))
                {
                  localObject5 = (aido)localObject5;
                  ((aido)localObject5).j += 1;
                }
              }
            }
            if (localObject1 != null) {
              localbdnu.jdField_b_of_type_JavaLangString = onq.a(((ChatMessage)localObject1).frienduin, localbdnu.jdField_b_of_type_JavaLangString, localQQAppInterface);
            }
            bool = ((onq)localQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(this, (Activity)localObject4);
            if (!bool)
            {
              if (localbdnu.jdField_a_of_type_Long > 0L) {
                if ((localObject1 != null) && ("1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg"))))
                {
                  bool = ((bdob)localObject3).a(localbdnu.c, localbdnu.jdField_b_of_type_JavaLangString, localbdnu.d, localbdnu.e, localbdnu.jdField_a_of_type_Long, new Object[] { Boolean.valueOf(true) });
                  if ((localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null)) {}
                }
              }
              try
              {
                if (localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 92)
                {
                  i1 = Integer.parseInt(localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mQidianBulkTaskId);
                  localObject3 = localbdnu.jdField_b_of_type_JavaLangString;
                  if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, String.format("click qidian bulk message, taskId: %d, actionUrl: %s", new Object[] { Integer.valueOf(i1), localObject3 }));
                  }
                  if (i1 != 0)
                  {
                    localObject4 = new JSONObject();
                    ((JSONObject)localObject4).put("action", "click");
                    ((JSONObject)localObject4).put("fromUin", localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin);
                    ((JSONObject)localObject4).put("toUin", localQQAppInterface.getCurrentAccountUin());
                    ((JSONObject)localObject4).put("taskID", localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mQidianBulkTaskId);
                    ((JSONObject)localObject4).put("clickURL", localObject3);
                    ((JSONObject)localObject4).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
                    ((bjyi)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(((JSONObject)localObject4).toString(), localbdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "", 10009, 0);
                  }
                }
              }
              catch (Exception localException2)
              {
                int i2;
                continue;
              }
              if (bjxa.a(localbdnu.e, localbdnu.d, localbdnu.jdField_b_of_type_JavaLangString))
              {
                localObject5 = (bjxa)localQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
                localObject4 = "";
                localObject3 = localObject4;
                if ((localbdnu instanceof bdoz))
                {
                  localObject6 = ((bdoz)localbdnu).a;
                  localObject3 = localObject4;
                  if (localObject6 != null)
                  {
                    localObject6 = ((List)localObject6).iterator();
                    localObject3 = localObject4;
                    if (((Iterator)localObject6).hasNext())
                    {
                      localObject3 = (bdnu)((Iterator)localObject6).next();
                      if (!(localObject3 instanceof bdsv)) {
                        continue;
                      }
                      localObject3 = ((bdsv)localObject3).ai;
                    }
                  }
                }
                ((bjxa)localObject5).a(localbdnu.c, localbdnu.e, localbdnu.d, localbdnu.jdField_b_of_type_JavaLangString, 2, (String)localObject3);
              }
              i1 = 0;
              if (bool) {
                i1 = 1;
              }
              i2 = -1;
              try
              {
                int i3 = Integer.parseInt(localbdnu.aa);
                i2 = i3;
              }
              catch (Exception localException1)
              {
                continue;
              }
              bdla.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localbdnu.ab, "0X80055C7", "0X80055C7", i2, i1, "" + localbdnu.jdField_a_of_type_Long, localbdnu.Z, "", localbdnu.jdField_b_of_type_JavaLangString);
              localObject3 = new StringBuilder().append("MSGID=").append(Long.toString(localbdnu.jdField_a_of_type_Long)).append(";TEPLATEID=").append(localbdnu.Z).append(";ARTICALID=").append("").append(";REFERRER=").append(a(localbdnu.jdField_b_of_type_JavaLangString));
              bdla.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localbdnu.ab, "0X8005D49", "0X8005D49", i2, i1, ((StringBuilder)localObject3).toString(), "", "", "");
              if (localObject1 == null) {
                break;
              }
              localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject4 = new JSONObject();
              }
              try
              {
                if (TextUtils.isEmpty(localbdnu.ab)) {
                  continue;
                }
                ((JSONObject)localObject4).put("puin", localbdnu.ab);
                ((JSONObject)localObject4).put("index", Long.toString(i2));
                ((JSONObject)localObject4).put("gdt_cli_data", localObject3);
              }
              catch (JSONException localJSONException2)
              {
                Object localObject2;
                localJSONException2.printStackTrace();
                continue;
                if ((((String)localObject4).equals("1")) || (!((String)localObject5).equals("1"))) {
                  continue;
                }
                continue;
              }
              new ArrayList().add(String.valueOf(localbdnu.jdField_a_of_type_Long));
              localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_singleAd");
              localObject4 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_mulAd");
              localObject5 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_followAd");
              if (((String)localObject3).equals("1"))
              {
                localObject3 = (onq)localQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
                localObject4 = (ook)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
                if ((localObject1 == null) || (localObject3 == null) || (localObject4 == null) || (!((onq)localObject3).a(((ChatMessage)localObject1).senderuin))) {
                  break;
                }
                ((ook)localObject4).a(false, (MessageRecord)localObject1, i2, localbdnu.jdField_b_of_type_JavaLangString);
                break;
                localNumberFormatException = localNumberFormatException;
                i1 = -1;
                continue;
                localClassCastException = localClassCastException;
                localObject2 = null;
              }
            }
          }
          catch (JSONException localJSONException1)
          {
            Object localObject5;
            localJSONException1.printStackTrace();
            continue;
            boolean bool = localJSONException1.a(localbdnu.c, localbdnu.jdField_b_of_type_JavaLangString, localbdnu.d, localbdnu.e, localbdnu.jdField_a_of_type_Long, new Object[0]);
            continue;
            bool = localJSONException1.a(localbdnu.c, localbdnu.jdField_b_of_type_JavaLangString, localbdnu.d, localbdnu.e);
            continue;
            ((JSONObject)localObject4).put("puin", localObject2.frienduin);
            continue;
            continue;
          }
        }
      }
      int i1 = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnu
 * JD-Core Version:    0.7.0.1
 */