package com.qq.wx.voice.recognizer;

import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.util.ManagerDataStore;
import com.qq.wx.voice.util.ManagerDeviceInfo;
import com.qq.wx.voice.util.ManagerInfoRecord;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InnerHttp
  implements Runnable
{
  public static long mDeltaTime = ManagerDataStore.NULLNUM;
  public static boolean mIsAuthorized = false;
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private byte[] d = null;
  private int e = 0;
  private int f = 1;
  private String g = null;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private DefaultHttpClient n = new DefaultHttpClient();
  private int o = 3000;
  private int p = 3000;
  private int q = 2;
  private int r = 0;
  private int s = 0;
  
  private int a(String paramString, int paramInt)
  {
    int i1 = -203;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramInt != 1) {
        break label129;
      }
    }
    catch (JSONException paramString)
    {
      try
      {
        if (paramString.has("ret"))
        {
          i1 = paramString.getInt("ret");
          if (i1 == 0) {
            break label77;
          }
        }
        return i1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        LogTool.d("json = " + paramString.toString());
        return -203;
      }
      paramString = paramString;
      paramString.printStackTrace();
      return -202;
    }
    label77:
    if (!a(paramString)) {
      return -205;
    }
    mIsAuthorized = true;
    LogTool.d("mDeltaTime = " + mDeltaTime + " mIsAuthorized = " + mIsAuthorized);
    label129:
    if (paramInt == 6)
    {
      if (!b(paramString)) {
        return -206;
      }
      if (((InfoHttp.f == 0) && (this.j == 1)) || (InfoHttp.f == 1))
      {
        paramString = c(paramString);
        if (paramString == null) {
          return -206;
        }
        if (!this.b)
        {
          if (InfoRecognizer.g) {
            paramString.voiceRecordPCMData = InfoRecognizer.l.toByteArray();
          }
          if (InfoRecognizer.g) {
            paramString.voiceSpeexData = InfoRecognizer.m.toByteArray();
          }
          paramString.startTime = ((this.l / 32.0D - InfoRecorder.f) / 1000.0D);
          if (this.j == 1) {
            paramString.stopTime = ((this.m / 32.0D - InfoRecorder.c) / 1000.0D);
          }
          if (this.k == 1) {
            paramString.isAllEnd = true;
          }
          InfoRecognizer.b.a(paramString);
        }
      }
    }
    return 0;
  }
  
  /* Error */
  private String a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 204	org/apache/http/client/methods/HttpPost
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 205	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: new 207	org/apache/http/entity/ByteArrayEntity
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 210	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   18: invokevirtual 214	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   21: aload_0
    //   22: getfield 79	com/qq/wx/voice/recognizer/InnerHttp:n	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   25: aload_1
    //   26: invokevirtual 218	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 224 1 0
    //   36: invokeinterface 230 1 0
    //   41: sipush 200
    //   44: if_icmpne +37 -> 81
    //   47: new 232	java/lang/String
    //   50: dup
    //   51: aload_1
    //   52: invokeinterface 236 1 0
    //   57: invokestatic 241	org/apache/http/util/EntityUtils:toByteArray	(Lorg/apache/http/HttpEntity;)[B
    //   60: ldc 243
    //   62: invokespecial 246	java/lang/String:<init>	([BLjava/lang/String;)V
    //   65: astore_1
    //   66: aload_1
    //   67: invokestatic 128	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   70: aload_1
    //   71: areturn
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   79: aload_1
    //   80: areturn
    //   81: aconst_null
    //   82: areturn
    //   83: astore_2
    //   84: goto -9 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	InnerHttp
    //   0	87	1	paramString	String
    //   0	87	2	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	66	72	java/lang/Exception
    //   66	70	83	java/lang/Exception
  }
  
  private void a(byte[] paramArrayOfByte, String paramString)
  {
    if (this.b) {
      return;
    }
    InfoRecognizer.b.a(paramArrayOfByte, paramString);
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    boolean bool = false;
    try
    {
      if (paramJSONObject.has("timestamp"))
      {
        long l1 = paramJSONObject.getLong("timestamp");
        mDeltaTime = System.currentTimeMillis() / 1000L - l1;
        InfoRecognizer.d.setDeltaTime(mDeltaTime);
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
  
  private boolean b(JSONObject paramJSONObject)
  {
    try
    {
      if ((paramJSONObject.has("voice_id")) && (!paramJSONObject.getString("voice_id").equals(this.g))) {
        return false;
      }
      if ((this.j == 0) && (paramJSONObject.has("ack_offset")))
      {
        int i1 = paramJSONObject.getInt("ack_offset");
        if (i1 <= this.h)
        {
          LogTool.d("seq = " + this.h + " len = " + this.e + " ack_offset = " + i1);
          return false;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      LogTool.d("json = " + paramJSONObject.toString());
      return false;
    }
    return true;
  }
  
  private VoiceRecognizerResult c(JSONObject paramJSONObject)
  {
    int i1 = 0;
    boolean bool;
    if (this.j == 1) {
      bool = true;
    }
    for (;;)
    {
      VoiceRecognizerResult localVoiceRecognizerResult = new VoiceRecognizerResult(bool);
      try
      {
        localVoiceRecognizerResult.httpRes = paramJSONObject.toString().getBytes("UTF-8");
        if (InfoRecognizer.p)
        {
          localVoiceRecognizerResult.type = 1;
          return localVoiceRecognizerResult;
          bool = false;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        try
        {
          if (!paramJSONObject.has("res")) {
            return null;
          }
          Object localObject = paramJSONObject.getJSONObject("res");
          if (!((JSONObject)localObject).has("sentences")) {
            return null;
          }
          localObject = ((JSONObject)localObject).getJSONArray("sentences");
          int i2 = ((JSONArray)localObject).length();
          if (i2 > 0)
          {
            localVoiceRecognizerResult.words = new ArrayList();
            for (;;)
            {
              if (i1 >= i2)
              {
                if (localVoiceRecognizerResult.words.isEmpty()) {
                  break;
                }
                localVoiceRecognizerResult.text = ((VoiceRecognizerResult.Word)localVoiceRecognizerResult.words.get(0)).text;
                break;
              }
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
              if (localJSONObject != null)
              {
                VoiceRecognizerResult.Word localWord = new VoiceRecognizerResult.Word();
                localWord.text = localJSONObject.getString("text");
                if (localJSONObject.has("semantic")) {
                  localWord.semanticJsonObject = localJSONObject.getJSONObject("semantic");
                }
                localVoiceRecognizerResult.words.add(localWord);
              }
              i1 += 1;
            }
          }
          return localJSONException;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          LogTool.d("json = " + paramJSONObject.toString());
          return null;
        }
      }
    }
  }
  
  private String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!InfoRecognizer.n) {
      localStringBuilder.append("http://" + InfoSender.Domain + InfoSender.Uri + "?");
    }
    if (paramInt == 1)
    {
      localStringBuilder.append("cmd=").append(paramInt);
      localStringBuilder.append("&appid=").append(InfoRecognizer.a);
    }
    if (paramInt == 6)
    {
      localStringBuilder.append("version=2.0");
      localStringBuilder.append("&cmd=").append(paramInt);
      localStringBuilder.append("&appid=").append(InfoRecognizer.a);
      localStringBuilder.append("&voice_id=").append(this.g);
      localStringBuilder.append("&os=").append(InfoRecognizer.c.getOs());
      localStringBuilder.append("&sdk_src=0");
      localStringBuilder.append("&osver=").append(InfoRecognizer.c.getOsver());
      localStringBuilder.append("&net=").append(InfoRecognizer.c.getNetTypeNum());
      localStringBuilder.append("&sdk_ver=1.17");
      localStringBuilder.append("&voice_end=").append(this.j);
      localStringBuilder.append("&encrypt_aes_mode=CBC");
      if (InfoRecognizer.o != null) {
        localStringBuilder.append(InfoRecognizer.o);
      }
    }
    return localStringBuilder.toString();
  }
  
  private void d(int paramInt)
  {
    if (this.b) {
      return;
    }
    InfoRecognizer.b.b(paramInt);
  }
  
  private byte[] f()
  {
    int i2 = 6;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject1 = new StringBuilder();
      Object localObject2 = ((StringBuilder)localObject1).append("&appid=").append(InfoRecognizer.a).append("&timestamp=").append(System.currentTimeMillis() / 1000L - mDeltaTime).append("&seq=").append(this.h).append("&len=").append(this.e).append("&samples_per_sec=").append(InfoRecorder.a).append("&bits_per_sample=16&result_type=").append(InfoHttp.c).append("&max_result_count=").append(InfoHttp.b).append("&end=").append(String.valueOf(this.j)).append("&device_info=").append(InfoRecognizer.c.getDeviceInfo()).append("&guid=").append(InfoRecognizer.c.getGuid()).append("&android_signature=").append(InfoRecognizer.c.getAndroid_signature()).append("&android_package_name=").append(InfoRecognizer.c.getAndroid_package_name()).append("&vr_domain=").append(InfoHttp.e).append("&cont_res=").append(InfoHttp.f).append("&language_type=0&voice_file_type=");
      if (InfoRecognizer.k)
      {
        i1 = 6;
        localObject2 = ((StringBuilder)localObject2).append(i1).append("&voice_encode_type=");
        if (!InfoRecognizer.k) {
          break label420;
        }
      }
      label420:
      for (int i1 = i2;; i1 = 1)
      {
        ((StringBuilder)localObject2).append(i1);
        if ((InfoHttp.c & 0x4) > 0) {
          ((StringBuilder)localObject1).append("&semantic_category=").append(InfoHttp.d);
        }
        if ((InfoRecognizer.e.isNeedUpdate()) && (this.j == 1) && (InfoHttp.g))
        {
          ((StringBuilder)localObject1).append(InfoRecognizer.e.getRecordStr());
          this.c = true;
        }
        LogTool.d(((StringBuilder)localObject1).toString());
        localByteArrayOutputStream.write(((StringBuilder)localObject1).toString().getBytes());
        localByteArrayOutputStream.write(0);
        localByteArrayOutputStream.write(this.d);
        localByteArrayOutputStream.flush();
        localObject1 = new ByteArrayOutputStream();
        ((ByteArrayOutputStream)localObject1).write(InfoHttp.a);
        ((ByteArrayOutputStream)localObject1).write(Common.AES(localByteArrayOutputStream.toByteArray()));
        ((ByteArrayOutputStream)localObject1).flush();
        localObject2 = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).close();
        localByteArrayOutputStream.close();
        return localObject2;
        i1 = 1;
        break;
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      d(-204);
    }
  }
  
  protected final void a()
  {
    this.n.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.o));
    this.n.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.p));
    long l1 = InfoRecognizer.d.getDeltaTime();
    mDeltaTime = l1;
    if (l1 != ManagerDataStore.NULLNUM) {
      mIsAuthorized = true;
    }
    LogTool.d("mDeltaTime = " + mDeltaTime + " mIsAuthorized = " + mIsAuthorized);
    this.a = false;
    this.b = false;
    this.c = false;
    this.g = Common.genVoiceId(InfoRecognizer.c.getGuid());
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
  }
  
  protected final void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  protected final void a(byte[] paramArrayOfByte)
  {
    int i1;
    do
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = InfoRecognizer.c.getNetType();
          InfoRecognizer.e.add(false, paramArrayOfByte);
          if ((this.f == 1) && (this.r >= this.q))
          {
            d(-201);
            return;
          }
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
        if ((this.f == 6) && (this.s >= this.q))
        {
          d(-201);
          return;
        }
        e();
        return;
      }
      if (this.c)
      {
        InfoRecognizer.e.clear();
        this.c = false;
      }
      String str = InfoRecognizer.c.getNetType();
      InfoRecognizer.e.add(true, str);
      i1 = a(paramArrayOfByte, this.f);
      if (i1 != 0) {
        break;
      }
      if (this.f == 1)
      {
        e();
        return;
      }
    } while (this.f != 6);
    this.a = false;
    return;
    if ((this.f == 6) && (i1 == 20105))
    {
      mIsAuthorized = false;
      mDeltaTime = ManagerDataStore.NULLNUM;
      this.s = 0;
      e();
      return;
    }
    if ((this.f == 1) && (this.r >= this.q))
    {
      d(i1);
      return;
    }
    if ((this.f == 6) && (this.s >= this.q))
    {
      d(i1);
      return;
    }
    e();
  }
  
  protected final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.d = paramArrayOfByte;
    this.e = paramInt1;
    this.h = this.i;
    this.i = (this.h + paramInt1);
    this.j = paramInt2;
    this.a = true;
    this.r = 0;
    this.s = 0;
  }
  
  protected final void b()
  {
    this.b = true;
  }
  
  protected final void b(int paramInt)
  {
    this.m = paramInt;
  }
  
  protected final void c()
  {
    this.k = 1;
  }
  
  protected final boolean d()
  {
    return this.a;
  }
  
  protected final void e()
  {
    if (!mIsAuthorized)
    {
      this.f = 1;
      str = c(1);
      this.r += 1;
      a(new byte[0], str);
      return;
    }
    this.f = 6;
    String str = c(6);
    byte[] arrayOfByte = f();
    this.s += 1;
    a(arrayOfByte, str);
  }
  
  public void run()
  {
    int i1 = 0;
    for (;;)
    {
      int i2 = i1;
      if (!this.b)
      {
        i2 = i1;
        if (this.r < this.q)
        {
          if (this.s < this.q) {
            break label47;
          }
          i2 = i1;
        }
      }
      for (;;)
      {
        if (i2 != 0)
        {
          d(i2);
          return;
          label47:
          Object localObject;
          if (!mIsAuthorized)
          {
            this.f = 1;
            str = c(1);
            localObject = new byte[0];
            this.r += 1;
          }
          for (;;)
          {
            LogTool.d(str);
            LogTool.d("post data length = " + localObject.length + " seq = " + this.h + " isEnd = " + this.j + " post times = " + this.s);
            localObject = a(str, (byte[])localObject);
            if (localObject != null) {
              break label210;
            }
            i1 = -201;
            localObject = InfoRecognizer.c.getNetType();
            InfoRecognizer.e.add(false, (String)localObject);
            break;
            this.f = 6;
            str = c(6);
            localObject = f();
            this.s += 1;
          }
          label210:
          if (this.c)
          {
            InfoRecognizer.e.clear();
            this.c = false;
          }
          String str = InfoRecognizer.c.getNetType();
          InfoRecognizer.e.add(true, str);
          i2 = a((String)localObject, this.f);
          if (i2 == 0)
          {
            if (this.f != 6) {
              break label319;
            }
            i2 = 0;
          }
          else
          {
            i1 = i2;
            if (this.f != 6) {
              break;
            }
            i1 = i2;
            if (i2 != 20105) {
              break;
            }
            mIsAuthorized = false;
            mDeltaTime = ManagerDataStore.NULLNUM;
            this.s = 0;
            i1 = i2;
            break;
          }
        }
      }
      this.a = false;
      return;
      label319:
      i1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.InnerHttp
 * JD-Core Version:    0.7.0.1
 */