import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class awrc
  extends VasWebviewJsPlugin
{
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new awrd(this);
  private beag jdField_a_of_type_Beag;
  bhuf jdField_a_of_type_Bhuf = null;
  public List<awsa> a;
  public AtomicInteger a;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  public AtomicInteger b;
  private final int c = 1;
  private final int d = 2;
  
  public awrc()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_Int = 0;
    this.mPluginNameSpace = "card";
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.closeWeb");
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      d();
      c();
      azqs.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "1", "", "", "");
      return;
    case 1: 
      e();
      c();
      azqs.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "2", "", "", "");
      return;
    }
    c();
    azqs.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "3", "", "", "");
  }
  
  private void b()
  {
    c();
    this.jdField_a_of_type_Bhuf = bhuf.c(this.mRuntime.a());
    this.jdField_a_of_type_Bhuf.c(this.mRuntime.a().getResources().getString(2131719760));
    this.jdField_a_of_type_Bhuf.c(this.mRuntime.a().getResources().getString(2131719771));
    this.jdField_a_of_type_Bhuf.c(this.mRuntime.a().getResources().getString(2131690648));
    this.jdField_a_of_type_Bhuf.a(new awre(this));
    this.jdField_a_of_type_Bhuf.setCanceledOnTouchOutside(true);
    try
    {
      this.jdField_a_of_type_Bhuf.show();
      azqs.b(null, "CliOper", "", "", "card_mall", "0X80066C9", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	awrc:jdField_a_of_type_Bhuf	Lbhuf;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 51	awrc:jdField_a_of_type_Bhuf	Lbhuf;
    //   11: invokevirtual 163	bhuf:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 51	awrc:jdField_a_of_type_Bhuf	Lbhuf;
    //   21: invokevirtual 166	bhuf:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 51	awrc:jdField_a_of_type_Bhuf	Lbhuf;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 51	awrc:jdField_a_of_type_Bhuf	Lbhuf;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 51	awrc:jdField_a_of_type_Bhuf	Lbhuf;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	awrc
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  private void d()
  {
    sendRemoteReq(apml.a("selectPhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  private void e()
  {
    sendRemoteReq(apml.a("takePhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return -1;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 0)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        return 0;
      }
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 0))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
      return -2;
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + 1;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      if (((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).g == awsa.jdField_a_of_type_JavaLangInteger) {
        return 0;
      }
      i += 1;
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
    String str;
    for (;;)
    {
      return;
      try
      {
        if (a() == 0)
        {
          localObject = (awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          str = ((awsa)localObject).jdField_d_of_type_JavaLangString;
          Long localLong = ((awsa)localObject).jdField_a_of_type_JavaLangLong;
          if (((awsa)localObject).jdField_b_of_type_Boolean)
          {
            ((awsa)localObject).jdField_b_of_type_Boolean = false;
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
            localObject = apml.a("card_download_wzry_template", str, this.mOnRemoteResp.key, new Bundle());
            ((Bundle)localObject).putLong("bgId", localLong.longValue());
            sendRemoteReq((Bundle)localObject, false, false);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    Object localObject = apml.a("card_download", str, this.mOnRemoteResp.key, new Bundle());
    ((Bundle)localObject).putLong("bgId", localException.longValue());
    sendRemoteReq((Bundle)localObject, false, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardWebviewPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("card"))) {
      return false;
    }
    Object localObject2;
    Object localObject1;
    long l1;
    String str;
    int j;
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      if (paramString1 == null) {
        return false;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardWebviewPlugin", 2, "Failed to parse json str,json=" + paramVarArgs[0]);
        }
        paramString1 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardWebviewPlugin", 2, "method:" + paramString3 + ", json:" + paramString1.toString());
      }
      paramJsBridgeListener = "callback";
      localObject2 = new JSONObject();
      paramVarArgs = new JSONObject();
      localObject1 = this.mRuntime.a().getApplicationContext();
      try
      {
        paramString2 = paramString1.optString("callback");
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("getInfo"))
        {
          paramJsBridgeListener = paramString2;
          sendRemoteReq(apml.a("card_getinfo", paramString2, this.mOnRemoteResp.key, new Bundle()), false, false);
        }
        else
        {
          paramJsBridgeListener = paramString2;
          if (paramString3.equals("setSummaryCard"))
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("DIYProfileTemplate.ProfileCardWebviewPlugin", 1, "setSummaryCard :" + paramString1);
            }
            paramJsBridgeListener = paramString2;
            paramString3 = apml.a("card_setSummaryCard", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString3.putInt("styleId", paramString1.getInt("styleId"));
            paramJsBridgeListener = paramString2;
            paramString3.putInt("bgId", paramString1.optInt("bgId", 0));
            paramJsBridgeListener = paramString2;
            paramString3.putLong("cardId", paramString1.optLong("cardId", 0L));
            paramJsBridgeListener = paramString2;
            paramString3.putString("extInfo", paramString1.optString("extInfo"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("renderInfo", paramString1.optString("renderInfo"));
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString3, false, false);
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        try
        {
          paramVarArgs.put("result", -1);
          paramVarArgs.put("message", "ProfileCardWebviewPlugin Exception");
          a(paramJsBridgeListener, paramVarArgs.toString());
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("download"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = paramString1.getString("image_url");
          paramJsBridgeListener = paramString2;
          localObject2 = paramString1.optString("dynamicZip");
          paramJsBridgeListener = paramString2;
          i = paramString1.optInt("id");
          paramJsBridgeListener = paramString2;
          if (awqu.a((Context)localObject1, i, "cardPreview.jpg"))
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("ProfileCardWebviewPlugin", 2, "handleJsRequest bg exists, dynamicZip = " + (String)localObject2);
            }
            paramJsBridgeListener = paramString2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("result", 0);
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("message", "local has");
              paramJsBridgeListener = paramString2;
              a(paramString2, paramVarArgs.toString());
              return true;
            }
            paramJsBridgeListener = paramString2;
            if (awqu.a((Context)localObject1, i, ".dynamic"))
            {
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("result", 0);
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("message", "local has");
              paramJsBridgeListener = paramString2;
              a(paramString2, paramVarArgs.toString());
              return true;
            }
          }
          paramJsBridgeListener = paramString2;
          if (!bdin.d(this.mRuntime.a().getApplicationContext()))
          {
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -2);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "no network");
            paramJsBridgeListener = paramString2;
            a(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          l1 = bddf.b();
          if (l1 < 102400)
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("ProfileCardWebviewPlugin", 2, "Insufficient SDCard space, reserved:" + 102400 + "|available:" + l1);
            }
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -3);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "Insufficient SDCard space.");
            paramJsBridgeListener = paramString2;
            a(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
          {
            paramJsBridgeListener = paramString2;
            if (((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g == awsa.jdField_d_of_type_JavaLangInteger)
            {
              paramJsBridgeListener = paramString2;
              if (((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3))
              {
                paramJsBridgeListener = paramString2;
                if (paramString1.getLong("id") == ((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangLong.longValue())
                {
                  paramJsBridgeListener = paramString2;
                  ((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = awsa.jdField_b_of_type_JavaLangInteger;
                  paramJsBridgeListener = paramString2;
                  ((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_d_of_type_JavaLangString = paramString2;
                  return true;
                }
              }
            }
          }
          paramJsBridgeListener = paramString2;
          paramString1 = new awsa();
          paramJsBridgeListener = paramString2;
          paramString1.jdField_a_of_type_JavaLangLong = Long.valueOf(i);
          paramJsBridgeListener = paramString2;
          paramString1.jdField_a_of_type_JavaLangString = paramString3;
          paramJsBridgeListener = paramString2;
          paramString1.jdField_b_of_type_JavaLangString = ((String)localObject2);
          paramJsBridgeListener = paramString2;
          paramString1.jdField_d_of_type_JavaLangString = paramString2;
          paramJsBridgeListener = paramString2;
          paramString1.e = Integer.valueOf(0);
          paramJsBridgeListener = paramString2;
          paramString1.g = awsa.jdField_a_of_type_JavaLangInteger;
          paramJsBridgeListener = paramString2;
          this.jdField_a_of_type_JavaUtilList.add(paramString1);
          paramJsBridgeListener = paramString2;
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
            break label3634;
          }
          paramJsBridgeListener = paramString2;
          a();
          break label3634;
        }
        paramJsBridgeListener = paramString2;
        if (!paramString3.equals("queryDownloadInfo")) {
          break label1739;
        }
      }
      paramJsBridgeListener = paramString2;
      paramString3 = paramString1.getString("image_url");
      paramJsBridgeListener = paramString2;
      str = paramString1.optString("dynamicZip");
      paramJsBridgeListener = paramString2;
      j = paramString1.optInt("id");
      paramJsBridgeListener = paramString2;
      if (!awqu.a((Context)localObject1, j, "cardPreview.jpg")) {
        break label1216;
      }
    }
    paramJsBridgeListener = paramString2;
    if (!TextUtils.isEmpty(str))
    {
      paramJsBridgeListener = paramString2;
      if (!awqu.a((Context)localObject1, j, ".dynamic")) {}
    }
    else
    {
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 3);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 100);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
    }
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("data", localObject2);
      paramJsBridgeListener = paramString2;
      a(paramString2, paramVarArgs.toString());
      break label3634;
      label1216:
      paramJsBridgeListener = paramString2;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0) {
        break;
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
    }
    paramJsBridgeListener = paramString2;
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    paramJsBridgeListener = paramString2;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramJsBridgeListener = paramString2;
      if (!((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3)) {
        break label3636;
      }
      paramJsBridgeListener = paramString2;
      if (j != ((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong.longValue()) {
        break label3636;
      }
      paramJsBridgeListener = paramString2;
      if (((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).g == awsa.jdField_d_of_type_JavaLangInteger) {
        break label3636;
      }
      paramJsBridgeListener = paramString2;
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = paramString2;
        QLog.i("ProfileCardWebviewPlugin", 2, "mIndex:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",id:" + ((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong + "status:" + ((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).g);
      }
      paramJsBridgeListener = paramString2;
      if (((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).g != awsa.jdField_a_of_type_JavaLangInteger)
      {
        paramJsBridgeListener = paramString2;
        if (((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).g != awsa.jdField_b_of_type_JavaLangInteger) {}
      }
      else
      {
        paramJsBridgeListener = paramString2;
        paramString1 = apml.a("card_query_download", paramString2, this.mOnRemoteResp.key, new Bundle());
        paramJsBridgeListener = paramString2;
        paramString1.putInt("bgId", j);
        paramJsBridgeListener = paramString2;
        sendRemoteReq(paramString1, false, false);
        return true;
      }
      paramJsBridgeListener = paramString2;
      if (((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).g != awsa.jdField_c_of_type_JavaLangInteger) {
        break label1712;
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", ((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).e);
    }
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", ((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).f);
      paramJsBridgeListener = paramString2;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
      break;
      label1712:
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 0);
    }
    label1739:
    paramJsBridgeListener = paramString2;
    label1974:
    label2748:
    int k;
    if (paramString3.equals("preview"))
    {
      paramJsBridgeListener = paramString2;
      paramString3 = new Intent(this.mRuntime.a(), VipProfileCardPreviewActivity.class);
      paramJsBridgeListener = paramString2;
      paramString3.putExtra("preview", paramString1.toString());
      paramJsBridgeListener = paramString2;
      super.startActivityForResult(paramString3, (byte)1);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("message", "ok");
      paramJsBridgeListener = paramString2;
      a(paramString2, paramVarArgs.toString());
    }
    else
    {
      paramJsBridgeListener = paramString2;
      if (paramString3.equals("getTime"))
      {
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("data", NetConnInfoCenter.getServerTimeMillis());
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("result", 0);
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("message", "");
        paramJsBridgeListener = paramString2;
        a(paramString2, paramVarArgs.toString());
      }
      else
      {
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("cancelDownload"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = paramString1.getString("image_url");
          paramJsBridgeListener = paramString2;
          l1 = paramString1.getLong("id");
          paramJsBridgeListener = paramString2;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == -1)
          {
            paramJsBridgeListener = paramString2;
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          }
          paramJsBridgeListener = paramString2;
          i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
          paramJsBridgeListener = paramString2;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            paramJsBridgeListener = paramString2;
            if (((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong.longValue() != l1) {
              break label3645;
            }
            paramJsBridgeListener = paramString2;
            if (!((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3)) {
              break label3645;
            }
            paramJsBridgeListener = paramString2;
            if (((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).g == awsa.jdField_d_of_type_JavaLangInteger) {
              break label3645;
            }
            paramJsBridgeListener = paramString2;
            paramString1 = apml.a("card_cancel_download", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString1.putLong("bgId", l1);
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString1, false, false);
            paramJsBridgeListener = paramString2;
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            paramJsBridgeListener = paramString2;
            ((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).g = awsa.jdField_d_of_type_JavaLangInteger;
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", 0);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "ok");
          }
          paramJsBridgeListener = paramString2;
          if (i == this.jdField_a_of_type_JavaUtilList.size())
          {
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -2);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "cancel download fail， bgId:" + l1);
          }
          paramJsBridgeListener = paramString2;
          a(paramString2, paramVarArgs.toString());
          paramJsBridgeListener = paramString2;
          paramString1 = new JSONObject();
          paramJsBridgeListener = paramString2;
          try
          {
            paramString1.put("result", -1);
            paramJsBridgeListener = paramString2;
            paramString1.put("message", "cancel download bgUrl:" + ((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
            paramJsBridgeListener = paramString2;
            a(((awsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_JavaLangString, paramString1.toString());
          }
          catch (JSONException paramString1)
          {
            paramJsBridgeListener = paramString2;
            paramString1.printStackTrace();
          }
        }
        else
        {
          paramJsBridgeListener = paramString2;
          if (paramString3.equals("report"))
          {
            paramJsBridgeListener = paramString2;
            paramString3 = apml.a("card_getVipInfo", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString3.putString("op_name", paramString1.getString("op_name"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext1", paramString1.getString("ext1"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext2", paramString1.getString("ext2"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext3", paramString1.getString("ext3"));
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString3, false, false);
          }
          else
          {
            paramJsBridgeListener = paramString2;
            if (paramString3.equals("openView"))
            {
              paramJsBridgeListener = paramString2;
              paramString1 = paramString1.getString("ADTAG");
              paramJsBridgeListener = paramString2;
              paramString3 = this.mRuntime.a();
              if (paramString3 != null)
              {
                paramJsBridgeListener = paramString2;
                localObject1 = new Intent(paramString3, QQBrowserActivity.class);
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("uin", this.mRuntime.a().getAccount());
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("isShowAd", false);
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("url", bdtg.a(paramString3, "card", paramString1));
                paramJsBridgeListener = paramString2;
                paramString3.startActivity((Intent)localObject1);
              }
            }
            else
            {
              paramJsBridgeListener = paramString2;
              if (paramString3.equals("clickPhotoWall"))
              {
                paramJsBridgeListener = paramString2;
                paramString1 = this.mRuntime.a(this.mRuntime.a());
                if (paramString1 != null)
                {
                  paramJsBridgeListener = paramString2;
                  if ((paramString1 instanceof belt))
                  {
                    paramJsBridgeListener = paramString2;
                    paramString1 = ((belt)paramString1).b();
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty(paramString1)) {
                      break label2748;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!paramString1.contains("entryId")) {
                      break label2748;
                    }
                    paramJsBridgeListener = paramString2;
                  }
                }
                for (this.jdField_a_of_type_Int = bhsz.a(bhsz.a(paramString1), "entryId", 2);; this.jdField_a_of_type_Int = 2)
                {
                  paramJsBridgeListener = paramString2;
                  paramString1 = this.mRuntime.a().getAccount();
                  paramJsBridgeListener = paramString2;
                  paramString3 = bjea.a();
                  paramJsBridgeListener = paramString2;
                  paramString3.jdField_a_of_type_JavaLangString = paramString1;
                  paramJsBridgeListener = paramString2;
                  bjdt.a(this.mRuntime.a(), paramString3, null, paramString1, getRequestCode((byte)2));
                  break;
                  paramJsBridgeListener = paramString2;
                }
              }
              paramJsBridgeListener = paramString2;
              if (paramString3.equals("uploadBackground"))
              {
                paramJsBridgeListener = paramString2;
                b();
                paramJsBridgeListener = paramString2;
                paramVarArgs.put("result", 0);
                paramJsBridgeListener = paramString2;
                paramVarArgs.put("message", "ok");
                paramJsBridgeListener = paramString2;
                a(paramString2, paramVarArgs.toString());
              }
              else
              {
                paramJsBridgeListener = paramString2;
                if (paramString3.equals("setGameHonour"))
                {
                  paramJsBridgeListener = paramString2;
                  paramString3 = apml.a("card_set_custom_honor", paramString2, this.mOnRemoteResp.key, new Bundle());
                  paramJsBridgeListener = paramString2;
                  paramString3.putString("honor_data", paramString1.toString());
                  paramJsBridgeListener = paramString2;
                  sendRemoteReq(paramString3, false, false);
                }
                else
                {
                  paramJsBridgeListener = paramString2;
                  if (paramString3.equals("downloadWzResource"))
                  {
                    paramJsBridgeListener = paramString2;
                    l1 = paramString1.optLong("id");
                    paramJsBridgeListener = paramString2;
                    localObject2 = paramString1.optString("bgUrl");
                    paramJsBridgeListener = paramString2;
                    paramString1.optString("dynamicZip");
                    paramJsBridgeListener = paramString2;
                    paramString3 = paramString1.optString("wzHeroUrl");
                    paramJsBridgeListener = paramString2;
                    if (!awsk.a(paramString1.optInt("styleId"))) {
                      break label3654;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!awsk.a((Context)localObject1, "cardWZ.zip")) {
                      break label3654;
                    }
                    i = 1;
                    label2971:
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label3660;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!awqu.a((Context)localObject1, l1, "wzJoinImage.png")) {
                      break label3660;
                    }
                    j = 1;
                    label2999:
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty(paramString3)) {
                      break label3666;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!awqu.a((Context)localObject1, l1, "wzMainImage.png")) {
                      break label3666;
                    }
                    k = 1;
                    label3027:
                    if ((i != 0) && (j != 0))
                    {
                      bool = true;
                      paramJsBridgeListener = paramString2;
                      if (!TextUtils.isEmpty(paramString3))
                      {
                        paramJsBridgeListener = paramString2;
                        bool = awqu.a((Context)localObject1, l1, "wzMainImage.png");
                      }
                      if (bool)
                      {
                        paramJsBridgeListener = paramString2;
                        paramVarArgs.put("result", 0);
                        paramJsBridgeListener = paramString2;
                        paramVarArgs.put("progress", 100);
                        paramJsBridgeListener = paramString2;
                        callJs(paramString2, new String[] { paramVarArgs.toString() });
                        return true;
                      }
                    }
                    paramJsBridgeListener = paramString2;
                    if (!bdin.d(this.mRuntime.a().getApplicationContext()))
                    {
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("result", -2);
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("message", "no network");
                      paramJsBridgeListener = paramString2;
                      a(paramString2, paramVarArgs.toString());
                      return true;
                    }
                    paramJsBridgeListener = paramString2;
                    long l2 = bddf.b();
                    if (l2 < 102400)
                    {
                      paramJsBridgeListener = paramString2;
                      if (QLog.isColorLevel())
                      {
                        paramJsBridgeListener = paramString2;
                        QLog.d("ProfileCardWebviewPlugin", 2, "Insufficient SDCard space, reserved:" + 102400 + "|available:" + l2);
                      }
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("result", -3);
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("message", "Insufficient SDCard space.");
                      paramJsBridgeListener = paramString2;
                      a(paramString2, paramVarArgs.toString());
                      return true;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
                    {
                      paramJsBridgeListener = paramString2;
                      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0)
                      {
                        paramJsBridgeListener = paramString2;
                        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < this.jdField_a_of_type_JavaUtilList.size())
                        {
                          paramJsBridgeListener = paramString2;
                          paramString1 = (awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
                          paramJsBridgeListener = paramString2;
                          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
                          {
                            paramJsBridgeListener = paramString2;
                            if (paramString1.g.equals(awsa.jdField_d_of_type_JavaLangInteger))
                            {
                              paramJsBridgeListener = paramString2;
                              if (paramString1.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject2))
                              {
                                paramJsBridgeListener = paramString2;
                                if (l1 == paramString1.jdField_a_of_type_JavaLangLong.longValue())
                                {
                                  paramJsBridgeListener = paramString2;
                                  paramString1.g = awsa.jdField_b_of_type_JavaLangInteger;
                                  paramJsBridgeListener = paramString2;
                                  paramString1.jdField_d_of_type_JavaLangString = paramString2;
                                  return true;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    paramJsBridgeListener = paramString2;
                    localObject1 = new awsa();
                    paramJsBridgeListener = paramString2;
                    ((awsa)localObject1).jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
                    paramJsBridgeListener = paramString2;
                    ((awsa)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
                    paramJsBridgeListener = paramString2;
                    ((awsa)localObject1).jdField_d_of_type_JavaLangString = paramString2;
                    if (k == 0) {
                      break label3672;
                    }
                    paramString1 = null;
                    label3472:
                    paramJsBridgeListener = paramString2;
                    ((awsa)localObject1).jdField_c_of_type_JavaLangString = paramString1;
                    if (i != 0) {
                      break label3678;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label3634:
    label3636:
    label3645:
    label3654:
    label3660:
    label3666:
    label3672:
    label3678:
    for (boolean bool = true;; bool = false)
    {
      paramJsBridgeListener = paramString2;
      ((awsa)localObject1).jdField_b_of_type_Boolean = bool;
      paramJsBridgeListener = paramString2;
      ((awsa)localObject1).jdField_a_of_type_Boolean = true;
      paramJsBridgeListener = paramString2;
      ((awsa)localObject1).e = Integer.valueOf(0);
      paramJsBridgeListener = paramString2;
      ((awsa)localObject1).g = awsa.jdField_a_of_type_JavaLangInteger;
      paramJsBridgeListener = paramString2;
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      paramJsBridgeListener = paramString2;
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)
      {
        paramJsBridgeListener = paramString2;
        a();
        break label3634;
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("setSwitchOfKingGlory"))
        {
          paramJsBridgeListener = paramString2;
          i = paramString1.optInt("status");
          paramJsBridgeListener = paramString2;
          paramString1 = new Bundle();
          paramJsBridgeListener = paramString2;
          paramString1.putInt("status", i);
          paramJsBridgeListener = paramString2;
          sendRemoteReq(apml.a("ipc_plateofking_switch", paramString2, this.mOnRemoteResp.key, paramString1), false, false);
        }
        else
        {
          return false;
        }
      }
      return true;
      i += 1;
      break;
      i += 1;
      break label1974;
      i = 0;
      break label2971;
      j = 0;
      break label2999;
      k = 0;
      break label3027;
      paramString1 = paramString3;
      break label3472;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, "ProfileCardWebviewPlugin onActivityResult,requestCode = " + paramByte + ", resultCode = " + paramInt + ", data = " + paramIntent);
    }
    if (paramInt != -1) {}
    while (paramIntent == null) {
      return;
    }
    if ((paramByte == 1) || (paramByte == 2)) {}
    try
    {
      if (this.jdField_a_of_type_Int != 0)
      {
        Object localObject2 = paramIntent.getStringExtra("uin");
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.mRuntime.a().getCurrentAccountUin();
        }
        localObject2 = new Intent(this.mRuntime.a(), FriendProfileCardActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", new ProfileActivity.AllInOne((String)localObject1, 0));
        this.mRuntime.a().startActivity((Intent)localObject2);
      }
      paramIntent.putExtra("closeSpecialLogic", true);
      this.mRuntime.a().setResult(-1, paramIntent);
      this.mRuntime.a().finish();
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Beag = new beag(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Beag.onDestroy();
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ProfileCardWebviewPlugin", 2, "unregister receiver exception:" + localException.toString());
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {
      for (;;)
      {
        Object localObject2;
        Object localObject1;
        String str2;
        String str1;
        Bundle localBundle;
        try
        {
          if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            break;
          }
          localObject2 = new JSONObject();
          localObject1 = new JSONObject();
          str2 = paramBundle.getString("cmd");
          str1 = paramBundle.getString("callbackid");
          localBundle = paramBundle.getBundle("response");
          if (str2 == null) {
            break;
          }
          if ("card_getinfo".equals(str2))
          {
            long l1 = localBundle.getLong("currentId");
            long l2 = localBundle.getLong("styleId");
            int j = localBundle.getInt("result");
            paramBundle = localBundle.getString("diy_url");
            i = 0;
            if ((l2 == awra.e) || (l2 == awra.a) || (l2 == awra.g)) {
              break label806;
            }
            ((JSONObject)localObject2).put("currentId", l1);
            ((JSONObject)localObject2).put("styleId", l2);
            ((JSONObject)localObject2).put("isPhotoWall", i);
            ((JSONObject)localObject2).put("url", paramBundle);
            ((JSONObject)localObject1).put("data", localObject2);
            ((JSONObject)localObject1).put("result", j);
            a(str1, ((JSONObject)localObject1).toString());
            return;
          }
          if ("card_setSummaryCard".equals(str2))
          {
            i = localBundle.getInt("result");
            paramBundle = localBundle.getString("message");
            ((JSONObject)localObject1).put("result", i);
            ((JSONObject)localObject1).put("message", paramBundle);
            a(str1, ((JSONObject)localObject1).toString());
            return;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        if ("card_getVipInfo".equals(str2))
        {
          azqs.b(null, "P_CliOper", "Vip_SummaryCard", "", paramBundle.getString("op_name"), paramBundle.getString("op_name"), 0, 0, paramBundle.getString("ext1"), paramBundle.getString("ext2"), paramBundle.getString("ext3"), localBundle.getString("vip_info"));
          ((JSONObject)localObject1).put("result", 0);
          ((JSONObject)localObject1).put("message", "ok");
          a(str1, ((JSONObject)localObject1).toString());
          return;
        }
        if (("selectPhoto".equals(str2)) || ("takePhoto".equals(str2))) {
          break;
        }
        if ("card_download_wzry_template".equals(str2))
        {
          i = localBundle.getInt("result");
          localObject2 = localBundle.getString("message");
          if (i != 0)
          {
            ((JSONObject)localObject1).put("result", -1);
            ((JSONObject)localObject1).put("message", localObject2);
            a(str1, ((JSONObject)localObject1).toString());
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            return;
          }
          localObject1 = apml.a("card_download", str1, this.mOnRemoteResp.key, new Bundle());
          ((Bundle)localObject1).putLong("bgId", paramBundle.getLong("bgId"));
          sendRemoteReq((Bundle)localObject1, false, false);
          return;
        }
        if ("card_download".equals(str2))
        {
          ((JSONObject)localObject1).put("result", localBundle.getInt("result"));
          ((JSONObject)localObject1).put("message", "onHttpEnd");
          if (((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != awsa.jdField_d_of_type_JavaLangInteger) {
            ((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = awsa.jdField_c_of_type_JavaLangInteger;
          }
          ((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).e = Integer.valueOf(100);
          a(str1, ((JSONObject)localObject1).toString());
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          a();
          return;
        }
        if (!"card_query_download".equals(str2)) {
          break;
        }
        ((JSONObject)localObject1).put("result", 0);
        ((JSONObject)localObject2).put("status", 2);
        int i = localBundle.getInt("progress");
        ((JSONObject)localObject2).put("progress", i);
        if (((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != awsa.jdField_c_of_type_JavaLangInteger) {
          ((awsa)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).e = Integer.valueOf(i);
        }
        ((JSONObject)localObject1).put("data", localObject2);
        a(str1, ((JSONObject)localObject1).toString());
        return;
        label806:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awrc
 * JD-Core Version:    0.7.0.1
 */