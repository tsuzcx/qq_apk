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
      if (this.e.length < paramString.length) {}
      for (this.f = 1;; this.f = 0)
      {
        if (this.f == 0) {
          this.e = paramString;
        }
        this.i.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.j));
        this.i.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.k));
        this.d = InfoSynthesizer.d.getDeltaTime();
        if (this.d != ManagerDataStore.NULLNUM) {
          this.c = true;
        }
        LogTool.d("mDeltaTime = " + this.d + " mIsAuthorized = " + this.c);
        this.a = false;
        this.h = Common.genVoiceId(InfoSynthesizer.c.getGuid());
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  /* Error */
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 73	java/lang/String
    //   6: dup
    //   7: aload_1
    //   8: ldc 161
    //   10: invokespecial 164	java/lang/String:<init>	([BLjava/lang/String;)V
    //   13: astore 5
    //   15: new 166	org/json/JSONObject
    //   18: dup
    //   19: aload 5
    //   21: invokespecial 167	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 168	org/json/JSONObject:toString	()Ljava/lang/String;
    //   31: invokestatic 138	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   34: aload 5
    //   36: ldc 170
    //   38: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   41: ifeq +35 -> 76
    //   44: aload 5
    //   46: ldc 170
    //   48: invokevirtual 178	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   51: istore_3
    //   52: iload_3
    //   53: ifeq +59 -> 112
    //   56: iload_3
    //   57: ireturn
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 179	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   63: sipush -203
    //   66: ireturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 180	org/json/JSONException:printStackTrace	()V
    //   72: sipush -202
    //   75: ireturn
    //   76: sipush -203
    //   79: ireturn
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 180	org/json/JSONException:printStackTrace	()V
    //   85: new 114	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 182
    //   91: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload 5
    //   96: invokevirtual 168	org/json/JSONObject:toString	()Ljava/lang/String;
    //   99: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 138	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   108: sipush -203
    //   111: ireturn
    //   112: iload_2
    //   113: iconst_1
    //   114: if_icmpne +55 -> 169
    //   117: aload_0
    //   118: aload 5
    //   120: invokespecial 185	com/qq/wx/voice/synthesizer/InnerHttp:a	(Lorg/json/JSONObject;)Z
    //   123: ifne +7 -> 130
    //   126: sipush -205
    //   129: ireturn
    //   130: aload_0
    //   131: iconst_1
    //   132: putfield 39	com/qq/wx/voice/synthesizer/InnerHttp:c	Z
    //   135: new 114	java/lang/StringBuilder
    //   138: dup
    //   139: ldc 116
    //   141: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 46	com/qq/wx/voice/synthesizer/InnerHttp:d	J
    //   148: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   151: ldc 124
    //   153: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 39	com/qq/wx/voice/synthesizer/InnerHttp:c	Z
    //   160: invokevirtual 130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   163: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 138	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   169: iload 4
    //   171: istore_3
    //   172: iload_2
    //   173: bipush 11
    //   175: if_icmpne -119 -> 56
    //   178: iconst_0
    //   179: istore_2
    //   180: iload_2
    //   181: aload_1
    //   182: arraylength
    //   183: if_icmplt +42 -> 225
    //   186: iconst_m1
    //   187: istore_3
    //   188: iload_3
    //   189: iconst_m1
    //   190: if_icmpeq +12 -> 202
    //   193: aload_1
    //   194: arraylength
    //   195: iload_3
    //   196: isub
    //   197: iconst_1
    //   198: isub
    //   199: ifgt +41 -> 240
    //   202: new 114	java/lang/StringBuilder
    //   205: dup
    //   206: ldc 187
    //   208: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: iload_3
    //   212: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 138	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   221: sipush -203
    //   224: ireturn
    //   225: iload_2
    //   226: istore_3
    //   227: aload_1
    //   228: iload_2
    //   229: baload
    //   230: ifeq -42 -> 188
    //   233: iload_2
    //   234: iconst_1
    //   235: iadd
    //   236: istore_2
    //   237: goto -57 -> 180
    //   240: aload_1
    //   241: arraylength
    //   242: iload_3
    //   243: isub
    //   244: iconst_1
    //   245: isub
    //   246: newarray byte
    //   248: astore 6
    //   250: aload_1
    //   251: iload_3
    //   252: iconst_1
    //   253: iadd
    //   254: aload 6
    //   256: iconst_0
    //   257: aload 6
    //   259: arraylength
    //   260: invokestatic 196	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   263: aload_0
    //   264: aload 5
    //   266: aload 6
    //   268: invokespecial 199	com/qq/wx/voice/synthesizer/InnerHttp:a	(Lorg/json/JSONObject;[B)Z
    //   271: ifne +7 -> 278
    //   274: sipush -206
    //   277: ireturn
    //   278: new 201	com/qq/wx/voice/synthesizer/SpeechSynthesizerResult
    //   281: dup
    //   282: invokespecial 202	com/qq/wx/voice/synthesizer/SpeechSynthesizerResult:<init>	()V
    //   285: astore_1
    //   286: aload 6
    //   288: arraylength
    //   289: istore_2
    //   290: aload_1
    //   291: iload_2
    //   292: newarray byte
    //   294: putfield 205	com/qq/wx/voice/synthesizer/SpeechSynthesizerResult:speech	[B
    //   297: aload 6
    //   299: iconst_0
    //   300: aload_1
    //   301: getfield 205	com/qq/wx/voice/synthesizer/SpeechSynthesizerResult:speech	[B
    //   304: iconst_0
    //   305: iload_2
    //   306: invokestatic 196	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   309: iload 4
    //   311: istore_3
    //   312: aload_0
    //   313: getfield 35	com/qq/wx/voice/synthesizer/InnerHttp:a	Z
    //   316: ifne -260 -> 56
    //   319: getstatic 208	com/qq/wx/voice/synthesizer/InfoSynthesizer:b	Lcom/qq/wx/voice/synthesizer/SpeechSynthesizerCallback;
    //   322: aload_1
    //   323: invokevirtual 213	com/qq/wx/voice/synthesizer/SpeechSynthesizerCallback:a	(Lcom/qq/wx/voice/synthesizer/SpeechSynthesizerResult;)V
    //   326: iconst_0
    //   327: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	InnerHttp
    //   0	328	1	paramArrayOfByte	byte[]
    //   0	328	2	paramInt	int
    //   51	261	3	i1	int
    //   1	309	4	i2	int
    //   13	252	5	localObject	Object
    //   248	50	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	15	58	java/io/UnsupportedEncodingException
    //   15	34	67	org/json/JSONException
    //   34	52	80	org/json/JSONException
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://" + InfoSynthesizer.Domain + InfoSynthesizer.Uri + "?");
    if (paramInt == 1)
    {
      localStringBuilder.append("cmd=").append(paramInt);
      localStringBuilder.append("&appid=").append(InfoSynthesizer.a);
    }
    if (paramInt == 11)
    {
      localStringBuilder.append("version=1.0");
      localStringBuilder.append("&cmd=").append(paramInt);
      localStringBuilder.append("&appid=").append(InfoSynthesizer.a);
      localStringBuilder.append("&tts_id=").append(this.h);
      localStringBuilder.append("&os=").append(InfoSynthesizer.c.getOs());
      localStringBuilder.append("&sdk_src=0");
      localStringBuilder.append("&osver=").append(InfoSynthesizer.c.getOsver());
      localStringBuilder.append("&net=").append(InfoSynthesizer.c.getNetTypeNum());
      localStringBuilder.append("&sdk_ver=1.17");
      localStringBuilder.append("&encrypt_aes_mode=CBC");
    }
    return localStringBuilder.toString();
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool = false;
    try
    {
      if (paramJSONObject.has("timestamp"))
      {
        long l1 = paramJSONObject.getLong("timestamp");
        this.d = (System.currentTimeMillis() / 1000L - l1);
        InfoSynthesizer.d.setDeltaTime(this.d);
        bool = true;
      }
      return bool;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      LogTool.d("json = " + paramJSONObject.toString());
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
        LogTool.d("TTS response para length = " + i1);
        LogTool.d("TTS response real length = " + paramArrayOfByte.length);
        int i2 = paramArrayOfByte.length;
        if (i1 != i2) {}
      }
      else
      {
        return true;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      LogTool.d("json = " + paramJSONObject.toString());
    }
    return false;
  }
  
  private byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramString = new HttpPost(paramString);
      paramString.setEntity(new ByteArrayEntity(paramArrayOfByte));
      paramArrayOfByte = this.i.execute(paramString);
      paramString = localObject;
      if (paramArrayOfByte.getStatusLine().getStatusCode() == 200) {
        paramString = EntityUtils.toByteArray(paramArrayOfByte.getEntity());
      }
      return paramString;
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
      ((StringBuilder)localObject).append("appid=").append(InfoSynthesizer.a);
      ((StringBuilder)localObject).append("&timestamp=").append(System.currentTimeMillis() / 1000L - this.d);
      ((StringBuilder)localObject).append("&device_info=").append(InfoSynthesizer.c.getDeviceInfo());
      ((StringBuilder)localObject).append("&guid=").append(InfoSynthesizer.c.getGuid());
      ((StringBuilder)localObject).append("&android_signature=").append(InfoSynthesizer.c.getAndroid_signature());
      ((StringBuilder)localObject).append("&android_package_name=").append(InfoSynthesizer.c.getAndroid_package_name());
      ((StringBuilder)localObject).append("&tts_format=").append(InfoSynthesizer.h);
      ((StringBuilder)localObject).append("&text_length=").append(this.e.length);
      ((StringBuilder)localObject).append("&offset=0");
      ((StringBuilder)localObject).append("&comp=").append(this.f);
      ((StringBuilder)localObject).append("&volume=").append(InfoSynthesizer.i);
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
    int i1 = 0;
    for (;;)
    {
      int i2 = i1;
      if (!this.a)
      {
        i2 = i1;
        if (this.m < this.l) {
          if (this.n < this.l) {
            break label47;
          }
        }
      }
      for (i2 = i1;; i2 = 0)
      {
        if (i2 != 0) {
          b(i2);
        }
        return;
        label47:
        Object localObject;
        if (!this.c)
        {
          this.g = 1;
          str = a(1);
          localObject = new byte[0];
          this.m += 1;
        }
        for (;;)
        {
          LogTool.d(str);
          LogTool.d("post data length = " + localObject.length + " post times = " + this.n);
          localObject = a(str, (byte[])localObject);
          if (localObject != null) {
            break label185;
          }
          i1 = -201;
          localObject = InfoSynthesizer.c.getNetType();
          InfoSynthesizer.e.add(false, (String)localObject);
          break;
          this.g = 11;
          str = a(11);
          localObject = b();
          this.n += 1;
        }
        label185:
        if (this.b)
        {
          InfoSynthesizer.e.clear();
          this.b = false;
        }
        String str = InfoSynthesizer.c.getNetType();
        InfoSynthesizer.e.add(true, str);
        i2 = a((byte[])localObject, this.g);
        if (i2 != 0) {
          break label248;
        }
        if (this.g != 11) {
          break label290;
        }
      }
      label248:
      i1 = i2;
      if (this.g == 11)
      {
        i1 = i2;
        if (i2 == 20105)
        {
          this.c = false;
          this.d = ManagerDataStore.NULLNUM;
          this.n = 0;
          i1 = i2;
          continue;
          label290:
          i1 = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.synthesizer.InnerHttp
 * JD-Core Version:    0.7.0.1
 */