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
import com.tencent.mobileqq.app.QQAppInterface;
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

public abstract class bcgw
  implements View.OnClickListener, bchf
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
  public WeakReference<afce> a;
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
  
  public bcgw()
  {
    this.jdField_a_of_type_Int = 18;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString;
    if (!bjnd.a(paramString)) {
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
  
  public abstract boolean a(bcin parambcin);
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 1000L) {}
    Object localObject1;
    bcgw localbcgw;
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
        localbcgw = (bcgw)localObject1;
        localObject4 = paramView.getContext();
      } while ((!SplashActivity.class.isInstance(localObject4)) && (!ChatActivity.class.isInstance(localObject4)));
      localObject1 = (FragmentActivity)localObject4;
    } while (((FragmentActivity)localObject1).getChatFragment() == null);
    QQAppInterface localQQAppInterface = ((FragmentActivity)localObject1).getChatFragment().a();
    if ((localbcgw.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(localbcgw.aa))) {
      bcef.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localbcgw.ab, "mp_msg_msgpic_click", "aio_morpic_click", Integer.parseInt(this.aa), 0, "", "", Long.toString(localbcgw.jdField_a_of_type_Long), "");
    }
    ple.a().a(localbcgw.ab, localbcgw);
    if ((!(((FragmentActivity)localObject1).getChatFragment().a() instanceof ahiu)) || (!TextUtils.isEmpty(localbcgw.aa))) {}
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(this.aa);
        localObject3 = "";
        localObject1 = localObject3;
        if (localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
        {
          localObject1 = localObject3;
          if (localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)
          {
            localObject1 = localObject3;
            if (localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.mExJsonObject != null) {
              localObject1 = localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
            }
          }
        }
        localObject3 = localbcgw.ab;
        long l1 = localbcgw.jdField_a_of_type_Long;
        anxs.a(localQQAppInterface, (String)localObject3, 0, 4, i1 + l1, (String)localObject1);
        nsf.a.a(localbcgw, (String)localObject1);
        if ("2747277822".equals(localbcgw.ab)) {
          ((VasExtensionHandler)localQQAppInterface.getBusinessHandler(71)).a(3, localbcgw.jdField_a_of_type_Long + "", localbcgw.jdField_b_of_type_JavaLangString);
        }
        if (localbcgw.jdField_a_of_type_Long > 0L) {
          ThreadManager.getSubThreadHandler().postDelayed(new AbsStructMsgElement.1(this, localbcgw, localQQAppInterface), 0L);
        }
      }
      catch (NumberFormatException localClassCastException)
      {
        try
        {
          localObject1 = AIOUtils.getMessage(paramView);
          if ((localObject1 == null) || (localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (!"1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
        }
        catch (ClassCastException localClassCastException)
        {
          try
          {
            Object localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("puin", ((ChatMessage)localObject1).frienduin);
            ((JSONObject)localObject3).put("type", localbcgw.l);
            ((JSONObject)localObject3).put("index", localbcgw.j);
            ((JSONObject)localObject3).put("name", localbcgw.k);
            ((JSONObject)localObject3).put("net", String.valueOf(HttpUtil.getNetWorkType()));
            ((JSONObject)localObject3).put("mobile_imei", DeviceInfoUtil.getIMEI());
            ((JSONObject)localObject3).put("obj", "");
            ((JSONObject)localObject3).put("gdt_cli_data", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick"));
            ((JSONObject)localObject3).put("view_id", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_view_id"));
            uei.a(localQQAppInterface, ((ChatMessage)localObject1).selfuin, ((JSONObject)localObject3).toString(), "" + localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
            localObject3 = new bchd(localQQAppInterface, paramView, (MessageRecord)localObject1);
            localObject5 = ((FragmentActivity)localObject4).getChatFragment();
            Object localObject6;
            if (localObject5 != null)
            {
              localObject5 = ((ChatFragment)localObject5).a();
              if ((localObject5 instanceof ahiu))
              {
                localObject6 = (ahiu)localObject5;
                ((ahiu)localObject6).h += 1;
                if ("web".equals(localbcgw.c))
                {
                  localObject5 = (ahiu)localObject5;
                  ((ahiu)localObject5).j += 1;
                }
              }
            }
            if (localObject1 != null) {
              localbcgw.jdField_b_of_type_JavaLangString = ofx.a(((ChatMessage)localObject1).frienduin, localbcgw.jdField_b_of_type_JavaLangString, localQQAppInterface);
            }
            bool = ((ofx)localQQAppInterface.getManager(88)).a(this, (Activity)localObject4);
            if (!bool)
            {
              if (localbcgw.jdField_a_of_type_Long > 0L) {
                if ((localObject1 != null) && ("1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg"))))
                {
                  bool = ((bchd)localObject3).a(localbcgw.c, localbcgw.jdField_b_of_type_JavaLangString, localbcgw.d, localbcgw.e, localbcgw.jdField_a_of_type_Long, new Object[] { Boolean.valueOf(true) });
                  if ((localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null)) {}
                }
              }
              try
              {
                if (localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 92)
                {
                  i1 = Integer.parseInt(localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mQidianBulkTaskId);
                  localObject3 = localbcgw.jdField_b_of_type_JavaLangString;
                  if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, String.format("click qidian bulk message, taskId: %d, actionUrl: %s", new Object[] { Integer.valueOf(i1), localObject3 }));
                  }
                  if (i1 != 0)
                  {
                    localObject4 = new JSONObject();
                    ((JSONObject)localObject4).put("action", "click");
                    ((JSONObject)localObject4).put("fromUin", localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin);
                    ((JSONObject)localObject4).put("toUin", localQQAppInterface.getCurrentAccountUin());
                    ((JSONObject)localObject4).put("taskID", localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mQidianBulkTaskId);
                    ((JSONObject)localObject4).put("clickURL", localObject3);
                    ((JSONObject)localObject4).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
                    ((bing)localQQAppInterface.getBusinessHandler(85)).a(((JSONObject)localObject4).toString(), localbcgw.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "", 10009, 0);
                  }
                }
              }
              catch (Exception localException2)
              {
                int i2;
                continue;
              }
              if (bily.a(localbcgw.e, localbcgw.d, localbcgw.jdField_b_of_type_JavaLangString))
              {
                localObject5 = (bily)localQQAppInterface.getManager(165);
                localObject4 = "";
                localObject3 = localObject4;
                if ((localbcgw instanceof bcib))
                {
                  localObject6 = ((bcib)localbcgw).a;
                  localObject3 = localObject4;
                  if (localObject6 != null)
                  {
                    localObject6 = ((List)localObject6).iterator();
                    localObject3 = localObject4;
                    if (((Iterator)localObject6).hasNext())
                    {
                      localObject3 = (bcgw)((Iterator)localObject6).next();
                      if (!(localObject3 instanceof bclv)) {
                        continue;
                      }
                      localObject3 = ((bclv)localObject3).ai;
                    }
                  }
                }
                ((bily)localObject5).a(localbcgw.c, localbcgw.e, localbcgw.d, localbcgw.jdField_b_of_type_JavaLangString, 2, (String)localObject3);
              }
              i1 = 0;
              if (bool) {
                i1 = 1;
              }
              i2 = -1;
              try
              {
                int i3 = Integer.parseInt(localbcgw.aa);
                i2 = i3;
              }
              catch (Exception localException1)
              {
                continue;
              }
              bcef.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localbcgw.ab, "0X80055C7", "0X80055C7", i2, i1, "" + localbcgw.jdField_a_of_type_Long, localbcgw.Z, "", localbcgw.jdField_b_of_type_JavaLangString);
              localObject3 = new StringBuilder().append("MSGID=").append(Long.toString(localbcgw.jdField_a_of_type_Long)).append(";TEPLATEID=").append(localbcgw.Z).append(";ARTICALID=").append("").append(";REFERRER=").append(a(localbcgw.jdField_b_of_type_JavaLangString));
              bcef.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localbcgw.ab, "0X8005D49", "0X8005D49", i2, i1, ((StringBuilder)localObject3).toString(), "", "", "");
              if (localObject1 == null) {
                break;
              }
              localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject4 = new JSONObject();
              }
              try
              {
                if (TextUtils.isEmpty(localbcgw.ab)) {
                  continue;
                }
                ((JSONObject)localObject4).put("puin", localbcgw.ab);
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
              new ArrayList().add(String.valueOf(localbcgw.jdField_a_of_type_Long));
              localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_singleAd");
              localObject4 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_mulAd");
              localObject5 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_followAd");
              if (((String)localObject3).equals("1"))
              {
                localObject3 = (ofx)localQQAppInterface.getManager(88);
                localObject4 = (ogr)localQQAppInterface.getBusinessHandler(88);
                if ((localObject1 == null) || (localObject3 == null) || (localObject4 == null) || (!((ofx)localObject3).a(((ChatMessage)localObject1).senderuin))) {
                  break;
                }
                ((ogr)localObject4).a(false, (MessageRecord)localObject1, i2, localbcgw.jdField_b_of_type_JavaLangString);
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
            boolean bool = localJSONException1.a(localbcgw.c, localbcgw.jdField_b_of_type_JavaLangString, localbcgw.d, localbcgw.e, localbcgw.jdField_a_of_type_Long, new Object[0]);
            continue;
            bool = localJSONException1.a(localbcgw.c, localbcgw.jdField_b_of_type_JavaLangString, localbcgw.d, localbcgw.e);
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
 * Qualified Name:     bcgw
 * JD-Core Version:    0.7.0.1
 */