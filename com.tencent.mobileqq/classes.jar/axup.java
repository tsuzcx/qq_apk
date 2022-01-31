import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement.1;
import com.tencent.qphone.base.util.QLog;
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

public abstract class axup
  implements View.OnClickListener, axuy
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
  public String P = "";
  public String Q;
  public String R;
  public int a;
  public long a;
  public AbsStructMsg a;
  public String a;
  public WeakReference<acxj> a;
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
  public String k;
  public String l;
  public String m;
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
  
  public axup()
  {
    this.jdField_a_of_type_Int = 15;
    this.jdField_j_of_type_Int = -1;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (!paramString.startsWith("https")) {
        str = "http://" + paramString;
      }
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
  
  public abstract boolean a(axwg paramaxwg);
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 1000L) {}
    Object localObject1;
    axup localaxup;
    Object localObject4;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
          localObject1 = paramView.getTag();
        } while (!getClass().isInstance(localObject1));
        localaxup = (axup)localObject1;
        localObject4 = paramView.getContext();
      } while ((!SplashActivity.class.isInstance(localObject4)) && (!ChatActivity.class.isInstance(localObject4)));
      localObject1 = (FragmentActivity)localObject4;
    } while (((FragmentActivity)localObject1).getChatFragment() == null);
    QQAppInterface localQQAppInterface = ((FragmentActivity)localObject1).getChatFragment().a();
    if ((localaxup.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(localaxup.Q))) {
      axqy.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localaxup.R, "mp_msg_msgpic_click", "aio_morpic_click", Integer.parseInt(this.Q), 0, "", "", Long.toString(localaxup.jdField_a_of_type_Long), "");
    }
    osx.a().a(localaxup.R, localaxup);
    if ((!(((FragmentActivity)localObject1).getChatFragment().a() instanceof aert)) || (!TextUtils.isEmpty(localaxup.Q))) {}
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(this.Q);
        localObject3 = "";
        localObject1 = localObject3;
        if (localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
        {
          localObject1 = localObject3;
          if (localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)
          {
            localObject1 = localObject3;
            if (localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.mExJsonObject != null) {
              localObject1 = localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
            }
          }
        }
        localObject3 = localaxup.R;
        long l1 = localaxup.jdField_a_of_type_Long;
        akwu.a(localQQAppInterface, (String)localObject3, 0, 4, i1 + l1, (String)localObject1);
        if ("2747277822".equals(localaxup.R)) {
          ((bbrd)localQQAppInterface.a(71)).a(3, localaxup.jdField_a_of_type_Long + "", localaxup.jdField_b_of_type_JavaLangString);
        }
        if (localaxup.jdField_a_of_type_Long > 0L) {
          ThreadManager.getSubThreadHandler().postDelayed(new AbsStructMsgElement.1(this, localaxup, localQQAppInterface), 0L);
        }
      }
      catch (NumberFormatException localClassCastException)
      {
        try
        {
          localObject1 = actj.a(paramView);
          if ((localObject1 == null) || (localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (!"1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
        }
        catch (ClassCastException localClassCastException)
        {
          try
          {
            Object localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("puin", ((ChatMessage)localObject1).frienduin);
            ((JSONObject)localObject3).put("type", localaxup.l);
            ((JSONObject)localObject3).put("index", localaxup.jdField_j_of_type_JavaLangString);
            ((JSONObject)localObject3).put("name", localaxup.k);
            ((JSONObject)localObject3).put("net", String.valueOf(naj.a()));
            ((JSONObject)localObject3).put("mobile_imei", bbdh.a());
            ((JSONObject)localObject3).put("obj", "");
            ((JSONObject)localObject3).put("gdt_cli_data", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick"));
            ((JSONObject)localObject3).put("view_id", ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_view_id"));
            sep.a(localQQAppInterface, ((ChatMessage)localObject1).selfuin, ((JSONObject)localObject3).toString(), "" + localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
            paramView = new axuw(localQQAppInterface, paramView, (MessageRecord)localObject1);
            localObject3 = ((FragmentActivity)localObject4).getChatFragment();
            Object localObject5;
            if (localObject3 != null)
            {
              localObject3 = ((ChatFragment)localObject3).a();
              if ((localObject3 instanceof aert))
              {
                localObject5 = (aert)localObject3;
                ((aert)localObject5).x += 1;
                if ("web".equals(localaxup.c))
                {
                  localObject3 = (aert)localObject3;
                  ((aert)localObject3).z += 1;
                }
              }
            }
            if (localObject1 != null) {
              localaxup.jdField_b_of_type_JavaLangString = nqn.a(((ChatMessage)localObject1).frienduin, localaxup.jdField_b_of_type_JavaLangString, localQQAppInterface);
            }
            bool = ((nqn)localQQAppInterface.getManager(88)).a(this, (Activity)localObject4);
            if (!bool)
            {
              if (localaxup.jdField_a_of_type_Long > 0L) {
                if ((localObject1 != null) && ("1".equals(((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg"))))
                {
                  bool = paramView.a(localaxup.c, localaxup.jdField_b_of_type_JavaLangString, localaxup.d, localaxup.e, localaxup.jdField_a_of_type_Long, new Object[] { Boolean.valueOf(true) });
                  if ((localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null)) {}
                }
              }
              try
              {
                if (localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 92)
                {
                  i1 = Integer.parseInt(localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mQidianBulkTaskId);
                  paramView = localaxup.jdField_b_of_type_JavaLangString;
                  if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, String.format("click qidian bulk message, taskId: %d, actionUrl: %s", new Object[] { Integer.valueOf(i1), paramView }));
                  }
                  if (i1 != 0)
                  {
                    localObject3 = new JSONObject();
                    ((JSONObject)localObject3).put("action", "click");
                    ((JSONObject)localObject3).put("fromUin", localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin);
                    ((JSONObject)localObject3).put("toUin", localQQAppInterface.getCurrentAccountUin());
                    ((JSONObject)localObject3).put("taskID", localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mQidianBulkTaskId);
                    ((JSONObject)localObject3).put("clickURL", paramView);
                    ((JSONObject)localObject3).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
                    ((bdvn)localQQAppInterface.a(85)).a(((JSONObject)localObject3).toString(), localaxup.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "", 10009, 0);
                  }
                }
              }
              catch (Exception paramView)
              {
                int i2;
                continue;
              }
              if (bduf.a(localaxup.e, localaxup.d, localaxup.jdField_b_of_type_JavaLangString))
              {
                localObject4 = (bduf)localQQAppInterface.getManager(165);
                localObject3 = "";
                paramView = (View)localObject3;
                if ((localaxup instanceof axvu))
                {
                  localObject5 = ((axvu)localaxup).a;
                  paramView = (View)localObject3;
                  if (localObject5 != null)
                  {
                    localObject5 = ((List)localObject5).iterator();
                    paramView = (View)localObject3;
                    if (((Iterator)localObject5).hasNext())
                    {
                      paramView = (axup)((Iterator)localObject5).next();
                      if (!(paramView instanceof axzj)) {
                        continue;
                      }
                      paramView = ((axzj)paramView).Y;
                    }
                  }
                }
                ((bduf)localObject4).a(localaxup.c, localaxup.e, localaxup.d, localaxup.jdField_b_of_type_JavaLangString, 2, paramView);
              }
              i1 = 0;
              if (bool) {
                i1 = 1;
              }
              i2 = -1;
              try
              {
                int i3 = Integer.parseInt(localaxup.Q);
                i2 = i3;
              }
              catch (Exception paramView)
              {
                continue;
              }
              axqy.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localaxup.R, "0X80055C7", "0X80055C7", i2, i1, "" + localaxup.jdField_a_of_type_Long, localaxup.P, "", localaxup.jdField_b_of_type_JavaLangString);
              paramView = new StringBuilder().append("MSGID=").append(Long.toString(localaxup.jdField_a_of_type_Long)).append(";TEPLATEID=").append(localaxup.P).append(";ARTICALID=").append("").append(";REFERRER=").append(a(localaxup.jdField_b_of_type_JavaLangString));
              axqy.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localaxup.R, "0X8005D49", "0X8005D49", i2, i1, paramView.toString(), "", "", "");
              if (localObject1 == null) {
                break;
              }
              paramView = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
              if (!TextUtils.isEmpty(paramView)) {
                localObject3 = new JSONObject();
              }
              try
              {
                if (TextUtils.isEmpty(localaxup.R)) {
                  continue;
                }
                ((JSONObject)localObject3).put("puin", localaxup.R);
                ((JSONObject)localObject3).put("index", Long.toString(i2));
                ((JSONObject)localObject3).put("gdt_cli_data", paramView);
              }
              catch (JSONException paramView)
              {
                Object localObject2;
                paramView.printStackTrace();
                continue;
                if ((localJSONException.equals("1")) || (!((String)localObject4).equals("1"))) {
                  continue;
                }
                continue;
              }
              new ArrayList().add(String.valueOf(localaxup.jdField_a_of_type_Long));
              paramView = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_singleAd");
              localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_mulAd");
              localObject4 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_followAd");
              if (paramView.equals("1"))
              {
                paramView = (nqn)localQQAppInterface.getManager(88);
                localObject3 = (nrf)localQQAppInterface.a(88);
                if ((localObject1 == null) || (paramView == null) || (localObject3 == null) || (!paramView.a(((ChatMessage)localObject1).senderuin))) {
                  break;
                }
                ((nrf)localObject3).a(false, (MessageRecord)localObject1, i2, localaxup.jdField_b_of_type_JavaLangString);
                return;
                localNumberFormatException = localNumberFormatException;
                i1 = -1;
                continue;
                localClassCastException = localClassCastException;
                localObject2 = null;
              }
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
            boolean bool = paramView.a(localaxup.c, localaxup.jdField_b_of_type_JavaLangString, localaxup.d, localaxup.e, localaxup.jdField_a_of_type_Long, new Object[0]);
            continue;
            bool = paramView.a(localaxup.c, localaxup.jdField_b_of_type_JavaLangString, localaxup.d, localaxup.e);
            continue;
            localJSONException.put("puin", localObject2.frienduin);
            continue;
            continue;
          }
        }
      }
      int i1 = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axup
 * JD-Core Version:    0.7.0.1
 */