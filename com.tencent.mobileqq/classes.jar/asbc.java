import android.content.SharedPreferences;
import android.text.TextUtils;
import appoint.define.appoint_define.RichText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asbc
{
  public static final Pattern a = Pattern.compile("\\{\\{(.\\d+):(.\\d?)\\}\\}", 2);
  
  public static begp a(appoint_define.RichText paramRichText)
  {
    return a(paramRichText, 16);
  }
  
  public static begp a(appoint_define.RichText paramRichText, int paramInt)
  {
    return a(avgo.a(paramRichText), paramInt);
  }
  
  public static begp a(String paramString, int paramInt)
  {
    return new begp(paramString, 5, paramInt);
  }
  
  public static String a(String paramString)
  {
    if (paramString == null)
    {
      paramString = "";
      return paramString;
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        int i;
        try
        {
          localObject5 = new JSONObject(paramString);
          localObject3 = ((JSONObject)localObject5).optString("content");
          localObject4 = localObject3;
        }
        catch (JSONException localJSONException1)
        {
          Object localObject5;
          Object localObject1;
          String str;
          localObject4 = paramString;
        }
        try
        {
          if (((JSONObject)localObject5).has("audio_list"))
          {
            localObject1 = localObject3;
            localObject4 = localObject3;
            if (((JSONObject)localObject5).optJSONArray("audio_list").length() > 0)
            {
              localObject4 = localObject3;
              localObject1 = (String)localObject3 + anzj.a(2131705831);
            }
            localObject3 = a.matcher((CharSequence)localObject1);
            paramString = (String)localObject1;
            if (!((Matcher)localObject3).find()) {
              break;
            }
            paramString = ((Matcher)localObject3).group(1);
            localObject1 = ((String)localObject1).replace(((Matcher)localObject3).group(0), paramString);
            continue;
          }
          localObject4 = localObject3;
          if (((JSONObject)localObject5).has("video_list"))
          {
            localObject1 = localObject3;
            localObject4 = localObject3;
            if (((JSONObject)localObject5).optJSONArray("video_list").length() > 0)
            {
              localObject4 = localObject3;
              localObject1 = (String)localObject3 + anzj.a(2131705832);
            }
          }
          else
          {
            localObject4 = localObject3;
            if (((JSONObject)localObject5).has("pic_list"))
            {
              localObject1 = localObject3;
              localObject4 = localObject3;
              if (((JSONObject)localObject5).optJSONArray("pic_list").length() > 0)
              {
                localObject4 = localObject3;
                localObject1 = (String)localObject3 + anzj.a(2131705830);
              }
            }
            else
            {
              localObject1 = localObject3;
              localObject4 = localObject3;
              if (((JSONObject)localObject5).has("post_array"))
              {
                localObject4 = localObject3;
                localObject5 = ((JSONObject)localObject5).optJSONArray("post_array");
                i = 0;
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          label406:
          Object localObject2;
          break label406;
          i += 1;
          localObject3 = localJSONException2;
        }
      }
      localObject1 = localObject3;
      localObject4 = localObject3;
      if (i < ((JSONArray)localObject5).length())
      {
        localObject4 = localObject3;
        str = ((JSONArray)localObject5).optJSONObject(i).optString("type");
        localObject4 = localObject3;
        if (TextUtils.isEmpty(str))
        {
          localObject1 = localObject3;
          break label450;
        }
        localObject4 = localObject3;
        if (str.equals("qqmusic"))
        {
          localObject4 = localObject3;
          localObject1 = (String)localObject3 + anzj.a(2131705828);
          break label450;
        }
        localObject4 = localObject3;
        localObject1 = localObject3;
        if (!str.equals("audio")) {
          break label450;
        }
        localObject4 = localObject3;
        localObject1 = (String)localObject3 + anzj.a(2131705829);
        break label450;
        localObject2 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.e("Q..msgbox.util", 2, "getTribeJsonContent content:" + paramString);
          localObject2 = localObject4;
        }
      }
    }
  }
  
  public static boolean a()
  {
    return "0".equals(BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).getString("nearby_settings_greetings_receive", "0"));
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    return ((!a()) || (paramInt1 != 1001) || (a(paramInt2, paramString))) && (!paramBoolean);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (paramInt == -2053) && (!paramString.equals(String.valueOf(1822701914L + antf.g))) && (!paramString.equals("1822701914"));
  }
  
  public static boolean a(QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface)
  {
    MessageRecord localMessageRecord = null;
    if (paramMessage.msgtype == -2011) {
      localMessageRecord = paramQQAppInterface.a(1001).a(antf.I, 1001, paramMessage.uniseq);
    }
    return a(paramMessage.istroop, paramMessage.msgtype, a(localMessageRecord), paramMessage.senderuin);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.structingMsg == null) || (localMessageForStructing.structingMsg.mMsgServiceID != 98)) {}
    }
    for (int i = 1;; i = 0) {
      return (i != 0) || (paramMessageRecord.msgtype == -2070);
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    do
    {
      return str1;
      str1 = paramString;
    } while (paramString.indexOf("/") == -1);
    int i = 0;
    String str1 = paramString;
    for (;;)
    {
      try
      {
        if (i >= begd.a.length) {
          break label277;
        }
        str1 = paramString;
        str2 = paramString;
        if (paramString.indexOf('\024' + begd.a[i]) == -1) {
          break label268;
        }
        str1 = paramString;
        str2 = paramString.replace('\024' + begd.a[i], "\024" + (char)i);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString = new StringBuilder().append("TextUtils:");
        if (str1.length() <= 200) {
          break label258;
        }
        i = 200;
        QLog.e("Q..msgbox.util", 2, str1.substring(0, i));
        str2 = str1;
      }
      str1 = paramString;
      String str2 = paramString;
      if (i < begd.a.length)
      {
        str2 = paramString;
        str1 = paramString;
        if (paramString.indexOf(begd.a[i]) != -1)
        {
          str1 = paramString;
          str2 = paramString.replace(begd.a[i], "\024" + (char)i);
        }
        i += 1;
        paramString = str2;
      }
      else
      {
        return str2;
        label258:
        i = str1.length() - 1;
        continue;
        label268:
        i += 1;
        paramString = str2;
        break;
        label277:
        i = 0;
      }
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.istroop, paramMessageRecord.msgtype, a(paramMessageRecord), paramMessageRecord.senderuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbc
 * JD-Core Version:    0.7.0.1
 */