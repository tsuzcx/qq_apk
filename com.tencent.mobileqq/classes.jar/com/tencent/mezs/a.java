package com.tencent.mezs;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqpsdk.secsrv.MQPSigCheckService.ISigCheckResultListener;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

public class a
  implements MQPSigCheckService.ISigCheckResultListener
{
  private static boolean jdField_a_of_type_Boolean = true;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean b = false;
  private boolean c = false;
  
  public a(QQAppInterface paramQQAppInterface)
  {
    this.a = null;
    this.a = paramQQAppInterface;
  }
  
  private void a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("SecResEntry", -1);
    if ((i == -1) || ((i ^ 0x12) != paramInt1))
    {
      localEditor.putInt("SecResEntry", paramInt1 ^ 0x12);
      localEditor.putLong("SecStampEntry", System.currentTimeMillis() ^ 0x12);
      localEditor.putInt("SecCacheTime", paramInt2);
      localEditor.commit();
    }
  }
  
  /* Error */
  private void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_1
    //   9: ldc 93
    //   11: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_2
    //   15: aload_1
    //   16: ldc 101
    //   18: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_3
    //   22: aload_1
    //   23: ldc 103
    //   25: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 5
    //   30: aload_1
    //   31: ldc 105
    //   33: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_1
    //   39: ldc 107
    //   41: invokevirtual 99	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_1
    //   45: goto +73 -> 118
    //   48: astore 6
    //   50: aload_2
    //   51: astore_1
    //   52: aload 4
    //   54: astore_2
    //   55: goto +50 -> 105
    //   58: astore 6
    //   60: aconst_null
    //   61: astore 4
    //   63: aload_2
    //   64: astore_1
    //   65: aload 4
    //   67: astore_2
    //   68: goto +37 -> 105
    //   71: astore 6
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_2
    //   76: astore 4
    //   78: goto +19 -> 97
    //   81: astore 6
    //   83: goto +7 -> 90
    //   86: astore 6
    //   88: aconst_null
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_2
    //   95: astore 4
    //   97: aload_1
    //   98: astore_2
    //   99: aload_1
    //   100: astore 5
    //   102: aload 4
    //   104: astore_1
    //   105: aload 6
    //   107: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   110: aload_2
    //   111: astore 4
    //   113: aload_1
    //   114: astore_2
    //   115: aload 7
    //   117: astore_1
    //   118: aload_2
    //   119: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne +111 -> 233
    //   125: aload_3
    //   126: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +4 -> 133
    //   132: return
    //   133: getstatic 122	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   136: astore 6
    //   138: new 124	android/content/Intent
    //   141: dup
    //   142: invokespecial 125	android/content/Intent:<init>	()V
    //   145: astore 7
    //   147: aload 7
    //   149: ldc 127
    //   151: bipush 9
    //   153: invokevirtual 131	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   156: pop
    //   157: new 133	android/os/Bundle
    //   160: dup
    //   161: invokespecial 134	android/os/Bundle:<init>	()V
    //   164: astore 8
    //   166: aload 8
    //   168: ldc 136
    //   170: aload_2
    //   171: invokevirtual 140	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload 8
    //   176: ldc 142
    //   178: aload_3
    //   179: invokevirtual 140	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 8
    //   184: ldc 144
    //   186: aload 5
    //   188: invokevirtual 140	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 8
    //   193: ldc 146
    //   195: aload 4
    //   197: invokevirtual 140	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 8
    //   202: ldc 148
    //   204: aload_1
    //   205: invokevirtual 140	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 7
    //   210: aload 8
    //   212: invokevirtual 152	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   215: pop
    //   216: aload 7
    //   218: ldc 153
    //   220: invokevirtual 157	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   223: pop
    //   224: aload 6
    //   226: aload 7
    //   228: ldc 159
    //   230: invokestatic 164	com/tencent/mobileqq/app/utils/RouteUtils:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V
    //   233: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	a
    //   0	234	1	paramJSONObject	JSONObject
    //   14	157	2	localObject1	Object
    //   21	158	3	str	String
    //   36	160	4	localObject2	Object
    //   28	159	5	localObject3	Object
    //   48	1	6	localException1	Exception
    //   58	1	6	localException2	Exception
    //   71	1	6	localException3	Exception
    //   81	1	6	localException4	Exception
    //   86	20	6	localException5	Exception
    //   136	89	6	localBaseActivity	com.tencent.mobileqq.app.BaseActivity
    //   6	221	7	localIntent	android.content.Intent
    //   164	47	8	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   38	45	48	java/lang/Exception
    //   30	38	58	java/lang/Exception
    //   22	30	71	java/lang/Exception
    //   15	22	81	java/lang/Exception
    //   8	15	86	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = null;
    JSONObject localJSONObject1 = null;
    int k = -1;
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      j = localJSONObject2.getInt("sig_check_result");
      paramString = localJSONObject1;
      try
      {
        localJSONObject1 = localJSONObject2.getJSONObject("dialog_config");
        paramString = localJSONObject1;
        i = localJSONObject2.getInt("cache_time");
        paramString = localJSONObject1;
      }
      catch (Exception localException1)
      {
        i = j;
      }
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      i = -1;
      paramString = localObject;
    }
    int j = i;
    int i = k;
    k = 1;
    if ((j != 0) && (j != 1)) {
      if (j != 2)
      {
        if (j == 3) {}
      }
      else {
        a(paramString);
      }
    }
    if (j == 0) {
      j = k;
    } else {
      j = 0;
    }
    a(j, i);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.c = paramBoolean;
    if (this.c) {
      new a.1(this).start();
    } else {
      a();
    }
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mezs.a
 * JD-Core Version:    0.7.0.1
 */