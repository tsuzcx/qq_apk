package com.tencent.featuretoggle.net;

import android.os.SystemClock;
import com.tencent.featuretoggle.Constants;
import com.tencent.featuretoggle.OnObtainToggleListener;
import com.tencent.featuretoggle.SpManager;
import com.tencent.featuretoggle.ToggleImpl;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.db.DBManager;
import com.tencent.featuretoggle.hltxkg.HalleyAgent;
import com.tencent.featuretoggle.hltxkg.HalleyInitParam;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpClient;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpRequest;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpResponse;
import com.tencent.featuretoggle.models.AccessSet;
import com.tencent.featuretoggle.models.QueryFeatureResp;
import com.tencent.featuretoggle.models.QueryProductSetReq;
import com.tencent.featuretoggle.models.QueryProductSetResp;
import com.tencent.featuretoggle.models.ReportFeatureTriggerEventReq;
import com.tencent.featuretoggle.strategy.ReportController;
import com.tencent.featuretoggle.utils.DeviceUtils;
import com.tencent.featuretoggle.utils.LogUtils;
import com.tencent.featuretoggle.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class HalleyRequestImpl
{
  private static volatile HalleyRequestImpl a;
  private boolean b = false;
  private boolean c = false;
  private IHttpClient d = null;
  
  private HalleyRequestImpl()
  {
    c();
  }
  
  private IHttpRequest a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    IHttpClient localIHttpClient = this.d;
    if (localIHttpClient == null) {
      return null;
    }
    paramString = localIHttpClient.createRequest(paramString, Utils.a(paramArrayOfByte));
    paramString.setHttpHeader("wupVersion", "3");
    paramString.setHttpHeader("sn", Utils.a());
    paramString.setHttpHeader("productNameEn", ToggleSetting.l());
    paramString.setHttpHeader("sdkVersion", ToggleSetting.r());
    paramString.setHttpHeader("sdkType", ToggleSetting.u());
    paramString.setHttpHeader("jceVersion", "1.1.0");
    paramString.setTimeout(20000);
    paramString.setHttpMethod(false);
    if (ToggleSetting.q()) {
      return paramString;
    }
    if (paramBoolean)
    {
      paramString.setHttpHeader("Host", "access.toggle.qq.com");
      return paramString;
    }
    paramString.setHttpHeader("Host", "event.toggle.qq.com");
    return paramString;
  }
  
  private IHttpResponse a(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      Object localObject3 = localObject1;
      if (i >= 3) {
        break;
      }
      long l;
      int j;
      Object localObject2;
      if (i != 0)
      {
        l = (i * 2 + 1) * 1000;
        j = i;
        localObject2 = localObject1;
      }
      try
      {
        Utils.a(l);
        i += 1;
        j = i;
        localObject2 = localObject1;
        localObject3 = Constants.c();
        j = i;
        localObject2 = localObject1;
        LogUtils.e("[Submit] report url is: %s\n", new Object[] { localObject3 });
        j = i;
        localObject2 = localObject1;
        localObject3 = a((String)localObject3, paramArrayOfByte, false);
        j = i;
        localObject2 = localObject1;
        localObject1 = this.d.execute((IHttpRequest)localObject3);
        j = i;
        localObject2 = localObject1;
        if (((IHttpResponse)localObject1).getErrorCode() != 0) {
          continue;
        }
        j = i;
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (((IHttpResponse)localObject1).getHttpStatus() != 200) {
          break;
        }
        j = i;
        localObject2 = localObject1;
        int k = new JSONObject(new String(((IHttpResponse)localObject1).getHttpBody())).optInt("nextTime");
        localObject3 = localObject1;
        if (k <= 0) {
          break;
        }
        j = i;
        localObject2 = localObject1;
        ToggleSetting.e(k * 1000);
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        i = j;
        localObject1 = localObject2;
      }
      if (!LogUtils.a(localThrowable))
      {
        localThrowable.printStackTrace();
        i = j;
        localObject1 = localObject2;
      }
    }
    return localThrowable;
  }
  
  /* Error */
  private QueryFeatureResp a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: iload_3
    //   5: iconst_3
    //   6: if_icmpge +370 -> 376
    //   9: iload_3
    //   10: ifeq +21 -> 31
    //   13: iload_3
    //   14: iconst_2
    //   15: imul
    //   16: sipush 1000
    //   19: imul
    //   20: i2l
    //   21: lstore 7
    //   23: iload_3
    //   24: istore 5
    //   26: lload 7
    //   28: invokestatic 97	com/tencent/featuretoggle/utils/Utils:a	(J)V
    //   31: iload_3
    //   32: iconst_1
    //   33: iadd
    //   34: istore 4
    //   36: iload 4
    //   38: istore 5
    //   40: invokestatic 154	com/tencent/featuretoggle/Constants:a	()Ljava/lang/String;
    //   43: astore 9
    //   45: iload 4
    //   47: istore 5
    //   49: ldc 156
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload 9
    //   59: aastore
    //   60: invokestatic 109	com/tencent/featuretoggle/utils/LogUtils:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: iload 4
    //   65: istore 5
    //   67: aload_0
    //   68: getfield 23	com/tencent/featuretoggle/net/HalleyRequestImpl:d	Lcom/tencent/featuretoggle/hltxkg/access/http/IHttpClient;
    //   71: aload_0
    //   72: aload 9
    //   74: aload_2
    //   75: iconst_1
    //   76: invokespecial 111	com/tencent/featuretoggle/net/HalleyRequestImpl:a	(Ljava/lang/String;[BZ)Lcom/tencent/featuretoggle/hltxkg/access/http/IHttpRequest;
    //   79: invokeinterface 115 2 0
    //   84: astore 9
    //   86: iload 4
    //   88: istore 5
    //   90: aload 9
    //   92: invokeinterface 121 1 0
    //   97: ifeq +9 -> 106
    //   100: iload 4
    //   102: istore_3
    //   103: goto -99 -> 4
    //   106: iload 4
    //   108: istore 5
    //   110: aload 9
    //   112: invokeinterface 124 1 0
    //   117: istore 6
    //   119: iload 6
    //   121: sipush 200
    //   124: if_icmpne +140 -> 264
    //   127: iload 4
    //   129: istore 5
    //   131: aload 9
    //   133: invokeinterface 132 1 0
    //   138: invokestatic 158	com/tencent/featuretoggle/utils/Utils:b	([B)[B
    //   141: ldc 160
    //   143: invokestatic 165	com/tencent/featuretoggle/net/ProtocolHelper:a	([BLjava/lang/Class;)Lcom/qq/taf/jce/JceStruct;
    //   146: checkcast 160	com/tencent/featuretoggle/models/QueryFeatureResp
    //   149: astore 9
    //   151: iload 4
    //   153: istore 5
    //   155: aload 9
    //   157: getfield 169	com/tencent/featuretoggle/models/QueryFeatureResp:code	I
    //   160: ldc 170
    //   162: if_icmpne +68 -> 230
    //   165: iload 4
    //   167: istore 5
    //   169: new 126	org/json/JSONObject
    //   172: dup
    //   173: aload 9
    //   175: getfield 174	com/tencent/featuretoggle/models/QueryFeatureResp:setName	Ljava/lang/String;
    //   178: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   181: ldc 176
    //   183: invokevirtual 180	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 9
    //   188: iload 4
    //   190: istore_3
    //   191: iload 4
    //   193: istore 5
    //   195: aload 9
    //   197: invokestatic 183	com/tencent/featuretoggle/utils/Utils:a	(Ljava/lang/String;)Z
    //   200: ifne -196 -> 4
    //   203: iload 4
    //   205: istore 5
    //   207: aload 9
    //   209: invokestatic 185	com/tencent/featuretoggle/ToggleSetting:c	(Ljava/lang/String;)V
    //   212: iload 4
    //   214: istore 5
    //   216: invokestatic 190	com/tencent/featuretoggle/SpManager:a	()Lcom/tencent/featuretoggle/SpManager;
    //   219: aload 9
    //   221: invokevirtual 192	com/tencent/featuretoggle/SpManager:b	(Ljava/lang/String;)V
    //   224: iload 4
    //   226: istore_3
    //   227: goto -223 -> 4
    //   230: iload 4
    //   232: istore 5
    //   234: aload 9
    //   236: getfield 194	com/tencent/featuretoggle/models/QueryFeatureResp:nextTime	I
    //   239: ifle +20 -> 259
    //   242: iload 4
    //   244: istore 5
    //   246: aload 9
    //   248: getfield 194	com/tencent/featuretoggle/models/QueryFeatureResp:nextTime	I
    //   251: sipush 1000
    //   254: imul
    //   255: i2l
    //   256: invokestatic 196	com/tencent/featuretoggle/ToggleSetting:d	(J)V
    //   259: aload_0
    //   260: monitorexit
    //   261: aload 9
    //   263: areturn
    //   264: iload 6
    //   266: sipush 404
    //   269: if_icmpne +21 -> 290
    //   272: iload 4
    //   274: istore_3
    //   275: iload 4
    //   277: istore 5
    //   279: aload_0
    //   280: aload_1
    //   281: invokespecial 197	com/tencent/featuretoggle/net/HalleyRequestImpl:a	(Ljava/lang/String;)Z
    //   284: ifne -280 -> 4
    //   287: goto +89 -> 376
    //   290: iload 6
    //   292: sipush 403
    //   295: if_icmpne +19 -> 314
    //   298: iload 4
    //   300: istore 5
    //   302: ldc 199
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 201	com/tencent/featuretoggle/utils/LogUtils:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: goto +65 -> 376
    //   314: iload 4
    //   316: istore_3
    //   317: iload 6
    //   319: sipush 500
    //   322: if_icmplt -318 -> 4
    //   325: iload 4
    //   327: istore 5
    //   329: ldc 203
    //   331: iconst_0
    //   332: anewarray 4	java/lang/Object
    //   335: invokestatic 201	com/tencent/featuretoggle/utils/LogUtils:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: iload 4
    //   340: istore_3
    //   341: goto -337 -> 4
    //   344: astore_1
    //   345: goto +27 -> 372
    //   348: astore 9
    //   350: iload 5
    //   352: istore_3
    //   353: aload 9
    //   355: invokestatic 149	com/tencent/featuretoggle/utils/LogUtils:a	(Ljava/lang/Throwable;)Z
    //   358: ifne -354 -> 4
    //   361: aload 9
    //   363: invokevirtual 152	java/lang/Throwable:printStackTrace	()V
    //   366: iload 5
    //   368: istore_3
    //   369: goto -365 -> 4
    //   372: aload_0
    //   373: monitorexit
    //   374: aload_1
    //   375: athrow
    //   376: aload_0
    //   377: monitorexit
    //   378: aconst_null
    //   379: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	HalleyRequestImpl
    //   0	380	1	paramString	String
    //   0	380	2	paramArrayOfByte	byte[]
    //   3	366	3	i	int
    //   34	305	4	j	int
    //   24	343	5	k	int
    //   117	206	6	m	int
    //   21	6	7	l	long
    //   43	219	9	localObject	Object
    //   348	14	9	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   26	31	344	finally
    //   40	45	344	finally
    //   49	63	344	finally
    //   67	86	344	finally
    //   90	100	344	finally
    //   110	119	344	finally
    //   131	151	344	finally
    //   155	165	344	finally
    //   169	188	344	finally
    //   195	203	344	finally
    //   207	212	344	finally
    //   216	224	344	finally
    //   234	242	344	finally
    //   246	259	344	finally
    //   279	287	344	finally
    //   302	311	344	finally
    //   329	338	344	finally
    //   353	366	344	finally
    //   26	31	348	java/lang/Throwable
    //   40	45	348	java/lang/Throwable
    //   49	63	348	java/lang/Throwable
    //   67	86	348	java/lang/Throwable
    //   90	100	348	java/lang/Throwable
    //   110	119	348	java/lang/Throwable
    //   131	151	348	java/lang/Throwable
    //   155	165	348	java/lang/Throwable
    //   169	188	348	java/lang/Throwable
    //   195	203	348	java/lang/Throwable
    //   207	212	348	java/lang/Throwable
    //   216	224	348	java/lang/Throwable
    //   234	242	348	java/lang/Throwable
    //   246	259	348	java/lang/Throwable
    //   279	287	348	java/lang/Throwable
    //   302	311	348	java/lang/Throwable
    //   329	338	348	java/lang/Throwable
  }
  
  public static HalleyRequestImpl a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new HalleyRequestImpl();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(int paramInt)
  {
    if ((paramInt == 2005) && (!ToggleSetting.C())) {
      return;
    }
    if (ToggleSetting.A() != 2) {
      ReportController.a().a(paramInt);
    }
  }
  
  private boolean a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < 3)
      {
        if (i != 0) {}
        try
        {
          LogUtils.b("[Submit] request config tryTime %d", new Object[] { Integer.valueOf(i) });
          Utils.a(i * 2 * 1000);
          int j = i + 1;
          paramString = ProtocolHelper.a(new QueryProductSetReq(ToggleSetting.k()));
          if (paramString == null)
          {
            LogUtils.d("[Submit] request config param is null", new Object[0]);
            i = j;
          }
          else
          {
            paramString = a(Constants.b(), paramString, true);
            paramString = this.d.execute(paramString);
            if (paramString.getErrorCode() != 0)
            {
              i = j;
            }
            else if (paramString.getHttpStatus() == 200)
            {
              paramString = (QueryProductSetResp)ProtocolHelper.a(Utils.b(paramString.getHttpBody()), QueryProductSetResp.class);
              i = j;
              if (paramString != null) {
                if (paramString.data == null)
                {
                  i = j;
                }
                else
                {
                  if (ToggleSetting.y().equals(paramString.data.setName)) {
                    break label240;
                  }
                  ToggleSetting.c(paramString.data.setName);
                  SpManager.a().b(paramString.data.setName);
                  return true;
                }
              }
            }
            else
            {
              LogUtils.b("[Submit] request config err code:%d", new Object[] { Integer.valueOf(paramString.getHttpStatus()) });
              i = j;
            }
          }
        }
        catch (Throwable paramString)
        {
          if (!LogUtils.a(paramString)) {
            paramString.printStackTrace();
          }
        }
      }
    }
    return false;
    label240:
    return true;
  }
  
  private void c()
  {
    HalleyInitParam localHalleyInitParam = new HalleyInitParam(ToggleSetting.j(), 3401, ToggleSetting.t(), ToggleSetting.n());
    HalleyAgent.init(localHalleyInitParam);
    this.d = HalleyAgent.getHttpClient(localHalleyInitParam);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b) {
      return;
    }
    int i = 1;
    this.b = true;
    Object localObject1 = DeviceUtils.a(ToggleSetting.j());
    if (localObject1 == null)
    {
      LogUtils.c("[Submit] current network is unavailable", new Object[0]);
      this.b = false;
      ToggleSetting.a(SystemClock.elapsedRealtime());
      if (paramBoolean) {
        a(2005);
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (!Utils.a(ToggleSetting.y())) {
          break label266;
        }
        bool = a((String)localObject1);
        if (bool)
        {
          Object localObject2 = ProtocolHelper.a(ProtocolHelper.a());
          if (localObject2 == null)
          {
            LogUtils.d("[Submit] request get toggle param is null", new Object[0]);
            return;
          }
          localObject1 = a((String)localObject1, (byte[])localObject2);
          if ((localObject1 != null) && (((QueryFeatureResp)localObject1).data != null))
          {
            CacheManager.a().a((QueryFeatureResp)localObject1);
            LogUtils.b("[Submit] get feature  Succeed!!!", new Object[0]);
          }
          else
          {
            LogUtils.b("[Submit] get feature  Fail!!!", new Object[0]);
            i = 0;
          }
          localObject1 = ToggleImpl.a().a.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (OnObtainToggleListener)((Iterator)localObject1).next();
            if (i != 0)
            {
              ((OnObtainToggleListener)localObject2).a();
              continue;
            }
            ((OnObtainToggleListener)localObject2).b();
            continue;
          }
        }
        ToggleSetting.a(SystemClock.elapsedRealtime());
      }
      catch (Throwable localThrowable)
      {
        if (!LogUtils.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
      }
      this.b = false;
      if (paramBoolean) {
        a(2005);
      }
      return;
      label266:
      boolean bool = true;
    }
  }
  
  public void b()
  {
    try
    {
      boolean bool = this.c;
      if (bool) {
        return;
      }
      this.c = true;
      if (DeviceUtils.a(ToggleSetting.j()) == null)
      {
        this.c = false;
        ToggleSetting.b(SystemClock.elapsedRealtime());
        a(2006);
        return;
      }
      try
      {
        ArrayList localArrayList = DBManager.a().b();
        if ((localArrayList != null) && (!localArrayList.isEmpty()))
        {
          Object localObject2 = ProtocolHelper.a(new ReportFeatureTriggerEventReq(localArrayList));
          if (localObject2 == null)
          {
            LogUtils.d("[Submit] report toggle event param is null", new Object[0]);
            return;
          }
          localObject2 = a((byte[])localObject2);
          if ((((IHttpResponse)localObject2).getErrorCode() == 0) && (((IHttpResponse)localObject2).getHttpStatus() == 200))
          {
            int i = DBManager.a().a(localArrayList);
            ToggleSetting.c(ToggleSetting.i() - i);
            LogUtils.e("[Submit] report feature event Succeed!!!", new Object[0]);
          }
          else
          {
            LogUtils.e("[Submit] report feature event Fail!!!", new Object[0]);
          }
        }
        ToggleSetting.b(SystemClock.elapsedRealtime());
      }
      catch (Throwable localThrowable)
      {
        if (!LogUtils.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
      }
      this.c = false;
      a(2006);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.net.HalleyRequestImpl
 * JD-Core Version:    0.7.0.1
 */