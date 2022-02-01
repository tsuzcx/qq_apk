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
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
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
    try
    {
      paramString = new JSONObject(paramString);
      int i1 = -203;
      try
      {
        if (paramString.has("ret"))
        {
          i1 = paramString.getInt("ret");
          if (i1 != 0) {
            return i1;
          }
          if (paramInt == 1)
          {
            if (!a(paramString)) {
              return -205;
            }
            mIsAuthorized = true;
            StringBuilder localStringBuilder1 = new StringBuilder("mDeltaTime = ");
            localStringBuilder1.append(mDeltaTime);
            localStringBuilder1.append(" mIsAuthorized = ");
            localStringBuilder1.append(mIsAuthorized);
            LogTool.d(localStringBuilder1.toString());
          }
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
                double d1 = this.l;
                Double.isNaN(d1);
                d1 /= 32.0D;
                double d2 = InfoRecorder.f;
                Double.isNaN(d2);
                paramString.startTime = ((d1 - d2) / 1000.0D);
                if (this.j == 1)
                {
                  d1 = this.m;
                  Double.isNaN(d1);
                  d1 /= 32.0D;
                  d2 = InfoRecorder.c;
                  Double.isNaN(d2);
                  paramString.stopTime = ((d1 - d2) / 1000.0D);
                }
                if (this.k == 1) {
                  paramString.isAllEnd = true;
                }
                InfoRecognizer.b.a(paramString);
              }
            }
          }
          i1 = 0;
        }
        return i1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        StringBuilder localStringBuilder2 = new StringBuilder("json = ");
        localStringBuilder2.append(paramString.toString());
        LogTool.d(localStringBuilder2.toString());
        return -203;
      }
      return -202;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private String a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramString = new HttpPost(paramString);
      paramString.setEntity(new ByteArrayEntity(paramArrayOfByte));
      paramString = this.n.execute(paramString);
      if (paramString.getStatusLine().getStatusCode() == 200)
      {
        paramString = new String(EntityUtils.toByteArray(paramString.getEntity()), "UTF-8");
        try
        {
          LogTool.d(paramString);
          return paramString;
        }
        catch (Exception paramArrayOfByte) {}
      }
      else
      {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramString = localObject;
      paramArrayOfByte.printStackTrace();
    }
    return paramString;
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
    try
    {
      if (paramJSONObject.has("timestamp"))
      {
        long l1 = paramJSONObject.getLong("timestamp");
        mDeltaTime = System.currentTimeMillis() / 1000L - l1;
        InfoRecognizer.d.setDeltaTime(mDeltaTime);
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
          StringBuilder localStringBuilder1 = new StringBuilder("seq = ");
          localStringBuilder1.append(this.h);
          localStringBuilder1.append(" len = ");
          localStringBuilder1.append(this.e);
          localStringBuilder1.append(" ack_offset = ");
          localStringBuilder1.append(i1);
          LogTool.d(localStringBuilder1.toString());
          return false;
        }
      }
      return true;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      StringBuilder localStringBuilder2 = new StringBuilder("json = ");
      localStringBuilder2.append(paramJSONObject.toString());
      LogTool.d(localStringBuilder2.toString());
    }
    return false;
  }
  
  private VoiceRecognizerResult c(JSONObject paramJSONObject)
  {
    boolean bool;
    if (this.j == 1) {
      bool = true;
    } else {
      bool = false;
    }
    VoiceRecognizerResult localVoiceRecognizerResult = new VoiceRecognizerResult(bool);
    try
    {
      localVoiceRecognizerResult.httpRes = paramJSONObject.toString().getBytes("UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    if (InfoRecognizer.p)
    {
      localVoiceRecognizerResult.type = 1;
      return localVoiceRecognizerResult;
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
        int i1 = 0;
        for (;;)
        {
          if (i1 >= i2)
          {
            if (localVoiceRecognizerResult.words.isEmpty()) {
              break;
            }
            localVoiceRecognizerResult.text = ((VoiceRecognizerResult.Word)localVoiceRecognizerResult.words.get(0)).text;
            return localVoiceRecognizerResult;
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
      return localVoiceRecognizerResult;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("json = ");
      localStringBuilder.append(paramJSONObject.toString());
      LogTool.d(localStringBuilder.toString());
    }
    return null;
  }
  
  private String c(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (!InfoRecognizer.n)
    {
      StringBuilder localStringBuilder2 = new StringBuilder("http://");
      localStringBuilder2.append(InfoSender.Domain);
      localStringBuilder2.append(InfoSender.Uri);
      localStringBuilder2.append("?");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (paramInt == 1)
    {
      localStringBuilder1.append("cmd=");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append("&appid=");
      localStringBuilder1.append(InfoRecognizer.a);
    }
    if (paramInt == 6)
    {
      localStringBuilder1.append("version=2.0");
      localStringBuilder1.append("&cmd=");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append("&appid=");
      localStringBuilder1.append(InfoRecognizer.a);
      localStringBuilder1.append("&voice_id=");
      localStringBuilder1.append(this.g);
      localStringBuilder1.append("&os=");
      localStringBuilder1.append(InfoRecognizer.c.getOs());
      localStringBuilder1.append("&sdk_src=0");
      localStringBuilder1.append("&osver=");
      localStringBuilder1.append(InfoRecognizer.c.getOsver());
      localStringBuilder1.append("&net=");
      localStringBuilder1.append(InfoRecognizer.c.getNetTypeNum());
      localStringBuilder1.append("&sdk_ver=1.17");
      localStringBuilder1.append("&voice_end=");
      localStringBuilder1.append(this.j);
      localStringBuilder1.append("&encrypt_aes_mode=CBC");
      if (InfoRecognizer.o != null) {
        localStringBuilder1.append(InfoRecognizer.o);
      }
    }
    return localStringBuilder1.toString();
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
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("&appid=");
        ((StringBuilder)localObject).append(InfoRecognizer.a);
        ((StringBuilder)localObject).append("&timestamp=");
        ((StringBuilder)localObject).append(System.currentTimeMillis() / 1000L - mDeltaTime);
        ((StringBuilder)localObject).append("&seq=");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append("&len=");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append("&samples_per_sec=");
        ((StringBuilder)localObject).append(InfoRecorder.a);
        ((StringBuilder)localObject).append("&bits_per_sample=16&result_type=");
        ((StringBuilder)localObject).append(InfoHttp.c);
        ((StringBuilder)localObject).append("&max_result_count=");
        ((StringBuilder)localObject).append(InfoHttp.b);
        ((StringBuilder)localObject).append("&end=");
        ((StringBuilder)localObject).append(String.valueOf(this.j));
        ((StringBuilder)localObject).append("&device_info=");
        ((StringBuilder)localObject).append(InfoRecognizer.c.getDeviceInfo());
        ((StringBuilder)localObject).append("&guid=");
        ((StringBuilder)localObject).append(InfoRecognizer.c.getGuid());
        ((StringBuilder)localObject).append("&android_signature=");
        ((StringBuilder)localObject).append(InfoRecognizer.c.getAndroid_signature());
        ((StringBuilder)localObject).append("&android_package_name=");
        ((StringBuilder)localObject).append(InfoRecognizer.c.getAndroid_package_name());
        ((StringBuilder)localObject).append("&vr_domain=");
        ((StringBuilder)localObject).append(InfoHttp.e);
        ((StringBuilder)localObject).append("&cont_res=");
        ((StringBuilder)localObject).append(InfoHttp.f);
        ((StringBuilder)localObject).append("&language_type=0&voice_file_type=");
        boolean bool = InfoRecognizer.k;
        int i2 = 6;
        if (bool)
        {
          i1 = 6;
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append("&voice_encode_type=");
          if (!InfoRecognizer.k) {
            break label539;
          }
          i1 = i2;
          ((StringBuilder)localObject).append(i1);
          if ((InfoHttp.c & 0x4) > 0)
          {
            ((StringBuilder)localObject).append("&semantic_category=");
            ((StringBuilder)localObject).append(InfoHttp.d);
          }
          if ((InfoRecognizer.e.isNeedUpdate()) && (this.j == 1) && (InfoHttp.g))
          {
            ((StringBuilder)localObject).append(InfoRecognizer.e.getRecordStr());
            this.c = true;
          }
          LogTool.d(((StringBuilder)localObject).toString());
          localByteArrayOutputStream.write(((StringBuilder)localObject).toString().getBytes());
          localByteArrayOutputStream.write(0);
          localByteArrayOutputStream.write(this.d);
          localByteArrayOutputStream.flush();
          localObject = new ByteArrayOutputStream();
          ((ByteArrayOutputStream)localObject).write(InfoHttp.a);
          ((ByteArrayOutputStream)localObject).write(Common.AES(localByteArrayOutputStream.toByteArray()));
          ((ByteArrayOutputStream)localObject).flush();
          byte[] arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
          ((ByteArrayOutputStream)localObject).close();
          localByteArrayOutputStream.close();
          return arrayOfByte;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        d(-204);
        return null;
      }
      int i1 = 1;
      continue;
      label539:
      i1 = 1;
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
    StringBuilder localStringBuilder = new StringBuilder("mDeltaTime = ");
    localStringBuilder.append(mDeltaTime);
    localStringBuilder.append(" mIsAuthorized = ");
    localStringBuilder.append(mIsAuthorized);
    LogTool.d(localStringBuilder.toString());
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
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = InfoRecognizer.c.getNetType();
      InfoRecognizer.e.add(false, paramArrayOfByte);
      if ((this.f == 1) && (this.r >= this.q))
      {
        d(-201);
        return;
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
    int i1 = a(paramArrayOfByte, this.f);
    if (i1 == 0)
    {
      i1 = this.f;
      if (i1 == 1)
      {
        e();
        return;
      }
      if (i1 == 6) {
        this.a = false;
      }
      return;
    }
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
    int i2;
    for (;;)
    {
      i2 = i1;
      if (this.b) {
        break label344;
      }
      int i3 = this.r;
      int i4 = this.q;
      i2 = i1;
      if (i3 >= i4) {
        break label344;
      }
      if (this.s >= i4)
      {
        i2 = i1;
        break label344;
      }
      Object localObject;
      if (!mIsAuthorized)
      {
        this.f = 1;
        str = c(1);
        localObject = new byte[0];
        this.r += 1;
      }
      else
      {
        this.f = 6;
        str = c(6);
        localObject = f();
        this.s += 1;
      }
      LogTool.d(str);
      StringBuilder localStringBuilder = new StringBuilder("post data length = ");
      localStringBuilder.append(localObject.length);
      localStringBuilder.append(" seq = ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(" isEnd = ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" post times = ");
      localStringBuilder.append(this.s);
      LogTool.d(localStringBuilder.toString());
      String str = a(str, (byte[])localObject);
      if (str == null)
      {
        i1 = -201;
        str = InfoRecognizer.c.getNetType();
        InfoRecognizer.e.add(false, str);
      }
      else
      {
        if (this.c)
        {
          InfoRecognizer.e.clear();
          this.c = false;
        }
        localObject = InfoRecognizer.c.getNetType();
        InfoRecognizer.e.add(true, (String)localObject);
        i2 = a(str, this.f);
        if (i2 == 0)
        {
          if (this.f != 6) {
            break;
          }
          i2 = 0;
          break label344;
        }
        i1 = i2;
        if (this.f == 6)
        {
          i1 = i2;
          if (i2 == 20105)
          {
            mIsAuthorized = false;
            mDeltaTime = ManagerDataStore.NULLNUM;
            this.s = 0;
            i1 = i2;
          }
        }
      }
    }
    label344:
    if (i2 != 0)
    {
      d(i2);
      return;
    }
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.InnerHttp
 * JD-Core Version:    0.7.0.1
 */