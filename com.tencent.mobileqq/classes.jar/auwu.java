import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.jubao.JubaoMsgData;
import com.tencent.mobileqq.mini.sdk.JsonORM;
import com.tencent.mobileqq.mini.sdk.JsonORM.JsonParseException;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class auwu
  extends WebViewPlugin
{
  private String a;
  private String b;
  private final String c = "0x800A851";
  private String d = amtj.a(2131705021);
  
  public auwu()
  {
    this.mPluginNameSpace = "jubao";
  }
  
  public static String a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", paramInt);
      localJSONObject.put("uuid", paramString);
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static String a(ArrayList<ChatMessage> paramArrayList)
  {
    Object localObject2 = "";
    int j = 0;
    int i = j;
    Object localObject1 = localObject2;
    if (paramArrayList != null)
    {
      i = j;
      localObject1 = localObject2;
      if (paramArrayList.size() > 0)
      {
        i = paramArrayList.size();
        localObject1 = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject2 = JubaoMsgData.transfer((ChatMessage)paramArrayList.next());
          try
          {
            ((JSONArray)localObject1).put(((JubaoMsgData)localObject2).toJson());
          }
          catch (JsonORM.JsonParseException localJsonParseException)
          {
            localJsonParseException.printStackTrace();
          }
        }
        localObject1 = ((JSONArray)localObject1).toString();
      }
    }
    paramArrayList = new JSONObject();
    try
    {
      paramArrayList.put("msgcount", i);
      paramArrayList.put("msgs", localObject1);
      return paramArrayList.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (TextUtils.isEmpty(paramVarArgs)) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs);
        localObject1 = localJSONObject.optString("chatuin", "");
        localObject2 = localJSONObject.optString("groupcode", "");
        j = localJSONObject.optInt("chattype", 0);
        k = localJSONObject.optInt("topicid", 0);
        str = localJSONObject.optString("uinname", "");
        Object localObject3 = localJSONObject.optString("msgs");
        paramVarArgs = (String[])localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramVarArgs = aabc.c((String)localObject1, aabc.b(1));
        }
        if (TextUtils.isEmpty(str)) {
          break label437;
        }
        str = new String(Base64.decode(str, 0));
        if (QLog.isColorLevel()) {
          QLog.i("NewReportPlugin", 2, String.format("jumpChatMsg [%s, %s, %s, %s, %s]", new Object[] { paramVarArgs, Integer.valueOf(j), localObject2, Integer.valueOf(k), str }));
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label440;
        }
        JubaoMsgData[] arrayOfJubaoMsgData = (JubaoMsgData[])JsonORM.parseFrom(new JSONArray((String)localObject3), JubaoMsgData.class);
        localObject3 = new ArrayList();
        int m = arrayOfJubaoMsgData.length;
        int i = 0;
        localObject1 = localObject3;
        if (i < m)
        {
          ((ArrayList)localObject3).add(arrayOfJubaoMsgData[i]);
          i += 1;
          continue;
        }
        this.a = localJSONObject.optString("callback", "");
        if (j == 1) {
          break label446;
        }
        if (j != 3000) {
          break label434;
        }
      }
      catch (JSONException paramVarArgs)
      {
        int j;
        int k;
        QLog.e("jubaoApiPlugin", 1, paramVarArgs, new Object[0]);
        return;
        localObject2 = new Intent(this.mRuntime.a(), ChatActivity.class);
        ((Intent)localObject2).putExtra("uin", paramVarArgs);
        ((Intent)localObject2).putExtra("uintype", j);
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        if ((j != 1033) && (j != 1034)) {
          break label421;
        }
        ((Intent)localObject2).putExtra("key_confessor_nick", str);
        ((Intent)localObject2).putExtra("key_confess_topicid", k);
        if (localObject1 == null) {
          continue;
        }
        ((Intent)localObject2).putExtra("msgs", (Serializable)localObject1);
        ((Intent)localObject2).putExtra("entrance", 9);
        startActivityForResult((Intent)localObject2, (byte)0);
        return;
      }
      catch (JsonORM.JsonParseException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
      if (TextUtils.isEmpty(paramVarArgs))
      {
        QLog.d("jubaoApiPlugin", 1, "jumpChatMsg openChatUin is null");
        return;
      }
      label421:
      ((Intent)localObject2).putExtra("uinname", str);
      continue;
      label434:
      continue;
      label437:
      continue;
      label440:
      Object localObject1 = null;
      continue;
      label446:
      paramVarArgs = (String[])localObject2;
    }
  }
  
  private void b(String... paramVarArgs)
  {
    if (!NetworkUtil.isNetworkAvailable(this.mRuntime.a()))
    {
      paramVarArgs = a(5, "");
      callJs(this.b, new String[] { paramVarArgs });
      return;
    }
    paramVarArgs = paramVarArgs[0];
    if (TextUtils.isEmpty(paramVarArgs))
    {
      paramVarArgs = a(0, "");
      callJs(this.b, new String[] { paramVarArgs });
      QLog.d("jubaoApiPlugin", 1, "doUploadChatMsg js args is empty ");
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramVarArgs);
        paramVarArgs = ((JSONObject)localObject).optString("chatuin", "");
        str = ((JSONObject)localObject).optString("groupcode", "");
        j = ((JSONObject)localObject).optInt("chattype", 0);
        if (!TextUtils.isEmpty(paramVarArgs))
        {
          paramVarArgs = aabc.c(paramVarArgs, aabc.b(1));
          JubaoMsgData[] arrayOfJubaoMsgData = (JubaoMsgData[])JsonORM.parseFrom(new JSONArray(((JSONObject)localObject).optString("msgs")), JubaoMsgData.class);
          localArrayList = new ArrayList();
          int k = arrayOfJubaoMsgData.length;
          int i = 0;
          if (i < k)
          {
            localArrayList.add(arrayOfJubaoMsgData[i]);
            i += 1;
          }
          else
          {
            this.b = ((JSONObject)localObject).optString("callback", "");
            if ((localArrayList == null) || (localArrayList.size() == 0))
            {
              QLog.e("jubaoApiPlugin", 2, "ipc upload  to msgServer msg size = 0 ");
              paramVarArgs = a(1, "");
              callJs(this.b, new String[] { paramVarArgs });
              return;
            }
          }
        }
      }
      catch (JSONException paramVarArgs)
      {
        int j;
        ArrayList localArrayList;
        str = a(2, "");
        callJs(this.b, new String[] { str });
        QLog.e("jubaoApiPlugin", 1, paramVarArgs, new Object[0]);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("jubaoApiPlugin", 2, "ipc upload  msg size = " + localArrayList.size());
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("jubao_chat_uin", paramVarArgs);
        ((Bundle)localObject).putString("jubao_group_code", str);
        ((Bundle)localObject).putInt("jubao_chat_type", j);
        ((Bundle)localObject).putSerializable("jubao_msg_list", localArrayList);
        QIPCClientHelper.getInstance().callServer("JubaoIPCServer", "", (Bundle)localObject, new auwv(this));
        bcef.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 2, 0, "", "", "", "");
        return;
      }
      catch (JsonORM.JsonParseException paramVarArgs)
      {
        String str = a(2, "");
        callJs(this.b, new String[] { str });
        QLog.e("jubaoApiPlugin", 1, paramVarArgs, new Object[0]);
        return;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.e("jubaoApiPlugin", 2, "receiver msgServer resp  isSucesss =  " + paramBoolean);
    int j = 1;
    int i = 0;
    bcef.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 3, 0, "", "", "", "");
    String str;
    if (paramInt == 0)
    {
      str = "";
      if ((!paramBoolean) || (paramBundle == null)) {
        break label226;
      }
      str = paramBundle.getString("jubao_uuid");
      paramInt = paramBundle.getInt("jubao_result_code", 0);
      i = 0;
      paramBundle = str;
    }
    for (;;)
    {
      str = a(paramInt, paramBundle);
      callJs(this.b, new String[] { str });
      QLog.d("jubaoApiPlugin", 1, "upload resp uuid = " + paramBundle + ",result = " + paramInt);
      j = i;
      i = paramInt;
      bcef.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 2, 0, "" + j, "" + i, "", "");
      return;
      label226:
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt("jubao_result_code", 1);
        i = 1;
        paramBundle = str;
      }
      else
      {
        paramInt = 0;
        i = 1;
        paramBundle = str;
      }
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if ((paramString != null) && (this.b != null) && (paramString.equals(this.b))) {
      bcef.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 4, 0, "", "", "", "");
    }
    super.callJs(paramString, paramVarArgs);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    QLog.d("jubaoApiPlugin", 1, "handleJsRequest methodName= " + paramString3);
    if ("jubao".equals(paramString2))
    {
      if ("selectMsgs".equalsIgnoreCase(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          paramJsBridgeListener = (InputMethodManager)this.mRuntime.a().getSystemService("input_method");
          if (paramJsBridgeListener != null) {
            paramJsBridgeListener.hideSoftInputFromWindow(this.mRuntime.a().getWindow().getDecorView().getWindowToken(), 0);
          }
          a(paramVarArgs);
          bcef.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 0, 0, "" + 0, "", "", "");
        }
        return true;
      }
      if ("uploadMsgs".equalsIgnoreCase(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label248;
        }
        b(new String[] { paramVarArgs[0] });
      }
    }
    label248:
    for (int i = 0;; i = 1)
    {
      bcef.b(null, "dc00898", "", "", "0x800A851", "0x800A851", 1, 0, "" + i, "", "", "");
      return true;
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    QLog.d("jubaoApiPlugin", 1, "onActivityResult ");
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 0)
    {
      if (paramInt != -1) {
        break label81;
      }
      paramIntent = paramIntent.getStringExtra("msgs");
      if (QLog.isDevelopLevel()) {
        QLog.d("jubaoApiPlugin", 4, "onActivityResult msgs= " + paramIntent);
      }
      callJs(this.a, new String[] { paramIntent });
    }
    label81:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("jubaoApiPlugin", 2, "onActivityResult user cancel select msg = ");
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    QLog.e("jubaoApiPlugin", 1, "startActivityForResult ");
    super.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwu
 * JD-Core Version:    0.7.0.1
 */