package com.qq.wx.voice.synthesizer;

import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.util.ManagerDataStore;
import com.qq.wx.voice.util.ManagerDeviceInfo;
import com.qq.wx.voice.util.ManagerInfoRecord;
import java.io.ByteArrayOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class InnerHttp
  implements Runnable
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private long d = ManagerDataStore.NULLNUM;
  private byte[] e = null;
  private int f = 0;
  private int g = 1;
  private String h = "";
  private DefaultHttpClient i = new DefaultHttpClient();
  private int j = 3000;
  private int k = 3000;
  private int l = 2;
  private int m = 0;
  private int n = 0;
  
  InnerHttp(String paramString)
  {
    paramString = paramString.getBytes();
    this.f = 0;
    this.e = paramString;
    try
    {
      this.e = Common.compress(paramString);
      if (this.e.length < paramString.length) {
        this.f = 1;
      } else {
        this.f = 0;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (this.f == 0) {
      this.e = paramString;
    }
    this.i.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.j));
    this.i.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.k));
    this.d = InfoSynthesizer.d.getDeltaTime();
    if (this.d != ManagerDataStore.NULLNUM) {
      this.c = true;
    }
    paramString = new StringBuilder("mDeltaTime = ");
    paramString.append(this.d);
    paramString.append(" mIsAuthorized = ");
    paramString.append(this.c);
    LogTool.d(paramString.toString());
    this.a = false;
    this.h = Common.genVoiceId(InfoSynthesizer.c.getGuid());
  }
  
  /* Error */
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: new 73	java/lang/String
    //   3: dup
    //   4: aload_1
    //   5: ldc 161
    //   7: invokespecial 164	java/lang/String:<init>	([BLjava/lang/String;)V
    //   10: astore 4
    //   12: new 166	org/json/JSONObject
    //   15: dup
    //   16: aload 4
    //   18: invokespecial 167	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 168	org/json/JSONObject:toString	()Ljava/lang/String;
    //   28: invokestatic 141	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   31: aload 4
    //   33: ldc 170
    //   35: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   38: ifeq +250 -> 288
    //   41: aload 4
    //   43: ldc 170
    //   45: invokevirtual 178	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   48: istore_3
    //   49: iload_3
    //   50: ifeq +5 -> 55
    //   53: iload_3
    //   54: ireturn
    //   55: iload_2
    //   56: iconst_1
    //   57: if_icmpne +68 -> 125
    //   60: aload_0
    //   61: aload 4
    //   63: invokespecial 181	com/qq/wx/voice/synthesizer/InnerHttp:a	(Lorg/json/JSONObject;)Z
    //   66: ifne +7 -> 73
    //   69: sipush -205
    //   72: ireturn
    //   73: aload_0
    //   74: iconst_1
    //   75: putfield 39	com/qq/wx/voice/synthesizer/InnerHttp:c	Z
    //   78: new 117	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 119
    //   84: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: astore 5
    //   89: aload 5
    //   91: aload_0
    //   92: getfield 46	com/qq/wx/voice/synthesizer/InnerHttp:d	J
    //   95: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 5
    //   101: ldc 127
    //   103: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 5
    //   109: aload_0
    //   110: getfield 39	com/qq/wx/voice/synthesizer/InnerHttp:c	Z
    //   113: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 5
    //   119: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 141	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   125: iload_2
    //   126: bipush 11
    //   128: if_icmpne +158 -> 286
    //   131: iconst_0
    //   132: istore_2
    //   133: iload_2
    //   134: aload_1
    //   135: arraylength
    //   136: if_icmplt +8 -> 144
    //   139: iconst_m1
    //   140: istore_2
    //   141: goto +9 -> 150
    //   144: aload_1
    //   145: iload_2
    //   146: baload
    //   147: ifne +132 -> 279
    //   150: iload_2
    //   151: iconst_m1
    //   152: if_icmpeq +100 -> 252
    //   155: aload_1
    //   156: arraylength
    //   157: iload_2
    //   158: isub
    //   159: iconst_1
    //   160: isub
    //   161: ifgt +6 -> 167
    //   164: goto +88 -> 252
    //   167: aload_1
    //   168: arraylength
    //   169: iload_2
    //   170: isub
    //   171: iconst_1
    //   172: isub
    //   173: newarray byte
    //   175: astore 5
    //   177: aload_1
    //   178: iload_2
    //   179: iconst_1
    //   180: iadd
    //   181: aload 5
    //   183: iconst_0
    //   184: aload 5
    //   186: arraylength
    //   187: invokestatic 187	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   190: aload_0
    //   191: aload 4
    //   193: aload 5
    //   195: invokespecial 190	com/qq/wx/voice/synthesizer/InnerHttp:a	(Lorg/json/JSONObject;[B)Z
    //   198: ifne +7 -> 205
    //   201: sipush -206
    //   204: ireturn
    //   205: new 192	com/qq/wx/voice/synthesizer/SpeechSynthesizerResult
    //   208: dup
    //   209: invokespecial 193	com/qq/wx/voice/synthesizer/SpeechSynthesizerResult:<init>	()V
    //   212: astore_1
    //   213: aload 5
    //   215: arraylength
    //   216: istore_2
    //   217: aload_1
    //   218: iload_2
    //   219: newarray byte
    //   221: putfield 196	com/qq/wx/voice/synthesizer/SpeechSynthesizerResult:speech	[B
    //   224: aload 5
    //   226: iconst_0
    //   227: aload_1
    //   228: getfield 196	com/qq/wx/voice/synthesizer/SpeechSynthesizerResult:speech	[B
    //   231: iconst_0
    //   232: iload_2
    //   233: invokestatic 187	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   236: aload_0
    //   237: getfield 35	com/qq/wx/voice/synthesizer/InnerHttp:a	Z
    //   240: ifne +46 -> 286
    //   243: getstatic 199	com/qq/wx/voice/synthesizer/InfoSynthesizer:b	Lcom/qq/wx/voice/synthesizer/SpeechSynthesizerCallback;
    //   246: aload_1
    //   247: invokevirtual 204	com/qq/wx/voice/synthesizer/SpeechSynthesizerCallback:a	(Lcom/qq/wx/voice/synthesizer/SpeechSynthesizerResult;)V
    //   250: iconst_0
    //   251: ireturn
    //   252: new 117	java/lang/StringBuilder
    //   255: dup
    //   256: ldc 206
    //   258: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: astore_1
    //   262: aload_1
    //   263: iload_2
    //   264: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_1
    //   269: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 141	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   275: sipush -203
    //   278: ireturn
    //   279: iload_2
    //   280: iconst_1
    //   281: iadd
    //   282: istore_2
    //   283: goto -150 -> 133
    //   286: iconst_0
    //   287: ireturn
    //   288: sipush -203
    //   291: ireturn
    //   292: astore_1
    //   293: aload_1
    //   294: invokevirtual 210	org/json/JSONException:printStackTrace	()V
    //   297: new 117	java/lang/StringBuilder
    //   300: dup
    //   301: ldc 212
    //   303: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: astore_1
    //   307: aload_1
    //   308: aload 4
    //   310: invokevirtual 168	org/json/JSONObject:toString	()Ljava/lang/String;
    //   313: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_1
    //   318: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 141	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   324: sipush -203
    //   327: ireturn
    //   328: astore_1
    //   329: aload_1
    //   330: invokevirtual 210	org/json/JSONException:printStackTrace	()V
    //   333: sipush -202
    //   336: ireturn
    //   337: astore_1
    //   338: aload_1
    //   339: invokevirtual 213	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   342: sipush -203
    //   345: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	InnerHttp
    //   0	346	1	paramArrayOfByte	byte[]
    //   0	346	2	paramInt	int
    //   48	6	3	i1	int
    //   10	299	4	localObject1	Object
    //   87	138	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	49	292	org/json/JSONException
    //   12	31	328	org/json/JSONException
    //   0	12	337	java/io/UnsupportedEncodingException
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("http://");
    localStringBuilder2.append(InfoSynthesizer.Domain);
    localStringBuilder2.append(InfoSynthesizer.Uri);
    localStringBuilder2.append("?");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (paramInt == 1)
    {
      localStringBuilder1.append("cmd=");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append("&appid=");
      localStringBuilder1.append(InfoSynthesizer.a);
    }
    if (paramInt == 11)
    {
      localStringBuilder1.append("version=1.0");
      localStringBuilder1.append("&cmd=");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append("&appid=");
      localStringBuilder1.append(InfoSynthesizer.a);
      localStringBuilder1.append("&tts_id=");
      localStringBuilder1.append(this.h);
      localStringBuilder1.append("&os=");
      localStringBuilder1.append(InfoSynthesizer.c.getOs());
      localStringBuilder1.append("&sdk_src=0");
      localStringBuilder1.append("&osver=");
      localStringBuilder1.append(InfoSynthesizer.c.getOsver());
      localStringBuilder1.append("&net=");
      localStringBuilder1.append(InfoSynthesizer.c.getNetTypeNum());
      localStringBuilder1.append("&sdk_ver=1.17");
      localStringBuilder1.append("&encrypt_aes_mode=CBC");
    }
    return localStringBuilder1.toString();
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("timestamp"))
      {
        long l1 = paramJSONObject.getLong("timestamp");
        this.d = (System.currentTimeMillis() / 1000L - l1);
        InfoSynthesizer.d.setDeltaTime(this.d);
        return true;
      }
      return false;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("json = ");
      localStringBuilder.append(paramJSONObject.toString());
      LogTool.d(localStringBuilder.toString());
    }
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject, byte[] paramArrayOfByte)
  {
    try
    {
      if ((paramJSONObject.has("tts_id")) && (!paramJSONObject.getString("tts_id").equals(this.h))) {
        return false;
      }
      if (paramJSONObject.has("length"))
      {
        int i1 = paramJSONObject.getInt("length");
        StringBuilder localStringBuilder = new StringBuilder("TTS response para length = ");
        localStringBuilder.append(i1);
        LogTool.d(localStringBuilder.toString());
        localStringBuilder = new StringBuilder("TTS response real length = ");
        localStringBuilder.append(paramArrayOfByte.length);
        LogTool.d(localStringBuilder.toString());
        int i2 = paramArrayOfByte.length;
        if (i1 != i2) {
          return false;
        }
      }
      return true;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = new StringBuilder("json = ");
      paramArrayOfByte.append(paramJSONObject.toString());
      LogTool.d(paramArrayOfByte.toString());
    }
    return false;
  }
  
  private byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramString = new HttpPost(paramString);
      paramString.setEntity(new ByteArrayEntity(paramArrayOfByte));
      paramString = this.i.execute(paramString);
      if (paramString.getStatusLine().getStatusCode() == 200)
      {
        paramString = EntityUtils.toByteArray(paramString.getEntity());
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    if (this.a) {
      return;
    }
    InfoSynthesizer.b.a(paramInt);
  }
  
  private byte[] b()
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("appid=");
      ((StringBuilder)localObject).append(InfoSynthesizer.a);
      ((StringBuilder)localObject).append("&timestamp=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() / 1000L - this.d);
      ((StringBuilder)localObject).append("&device_info=");
      ((StringBuilder)localObject).append(InfoSynthesizer.c.getDeviceInfo());
      ((StringBuilder)localObject).append("&guid=");
      ((StringBuilder)localObject).append(InfoSynthesizer.c.getGuid());
      ((StringBuilder)localObject).append("&android_signature=");
      ((StringBuilder)localObject).append(InfoSynthesizer.c.getAndroid_signature());
      ((StringBuilder)localObject).append("&android_package_name=");
      ((StringBuilder)localObject).append(InfoSynthesizer.c.getAndroid_package_name());
      ((StringBuilder)localObject).append("&tts_format=");
      ((StringBuilder)localObject).append(InfoSynthesizer.h);
      ((StringBuilder)localObject).append("&text_length=");
      ((StringBuilder)localObject).append(this.e.length);
      ((StringBuilder)localObject).append("&offset=0");
      ((StringBuilder)localObject).append("&comp=");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("&volume=");
      ((StringBuilder)localObject).append(InfoSynthesizer.i);
      if ((InfoSynthesizer.e.isNeedUpdate()) && (InfoSynthesizer.j))
      {
        ((StringBuilder)localObject).append(InfoSynthesizer.e.getRecordStr());
        this.b = true;
      }
      LogTool.d(((StringBuilder)localObject).toString());
      localByteArrayOutputStream.write(((StringBuilder)localObject).toString().getBytes());
      localByteArrayOutputStream.write(0);
      localByteArrayOutputStream.write(this.e);
      localByteArrayOutputStream.flush();
      localObject = new ByteArrayOutputStream();
      ((ByteArrayOutputStream)localObject).write(InfoSynthesizer.g);
      ((ByteArrayOutputStream)localObject).write(Common.AES(localByteArrayOutputStream.toByteArray()));
      ((ByteArrayOutputStream)localObject).flush();
      byte[] arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      ((ByteArrayOutputStream)localObject).close();
      localByteArrayOutputStream.close();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      b(-204);
    }
    return null;
  }
  
  protected final void a()
  {
    this.a = true;
  }
  
  public void run()
  {
    int i2 = 0;
    int i1 = 0;
    for (;;)
    {
      if (this.a) {
        break label305;
      }
      int i3 = this.m;
      int i4 = this.l;
      if ((i3 >= i4) || (this.n >= i4)) {
        break label305;
      }
      Object localObject2;
      if (!this.c)
      {
        this.g = 1;
        localObject1 = a(1);
        localObject2 = new byte[0];
        this.m += 1;
      }
      else
      {
        this.g = 11;
        localObject1 = a(11);
        localObject2 = b();
        this.n += 1;
      }
      LogTool.d((String)localObject1);
      StringBuilder localStringBuilder = new StringBuilder("post data length = ");
      localStringBuilder.append(localObject2.length);
      localStringBuilder.append(" post times = ");
      localStringBuilder.append(this.n);
      LogTool.d(localStringBuilder.toString());
      Object localObject1 = a((String)localObject1, (byte[])localObject2);
      if (localObject1 == null)
      {
        i1 = -201;
        localObject1 = InfoSynthesizer.c.getNetType();
        InfoSynthesizer.e.add(false, (String)localObject1);
      }
      else
      {
        if (this.b)
        {
          InfoSynthesizer.e.clear();
          this.b = false;
        }
        localObject2 = InfoSynthesizer.c.getNetType();
        InfoSynthesizer.e.add(true, (String)localObject2);
        i3 = a((byte[])localObject1, this.g);
        if (i3 == 0)
        {
          if (this.g != 11) {
            break;
          }
          i1 = i2;
          break label305;
        }
        i1 = i3;
        if (this.g == 11)
        {
          i1 = i3;
          if (i3 == 20105)
          {
            this.c = false;
            this.d = ManagerDataStore.NULLNUM;
            this.n = 0;
            i1 = i3;
          }
        }
      }
    }
    label305:
    if (i1 != 0) {
      b(i1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.synthesizer.InnerHttp
 * JD-Core Version:    0.7.0.1
 */