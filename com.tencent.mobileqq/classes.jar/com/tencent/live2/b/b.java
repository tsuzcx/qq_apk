package com.tencent.live2.b;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.impl.a.d;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private int a;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  private boolean n = true;
  private boolean o;
  private a.d p = a.d.a;
  
  public static b a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((!paramString.startsWith("trtc://")) && (!paramString.startsWith("room://"))) {
      return null;
    }
    for (;;)
    {
      try
      {
        localb = new b();
        String[] arrayOfString = paramString.split("[?&]");
        if (paramString.startsWith("trtc://"))
        {
          localb.p = a.d.b;
          i2 = paramString.lastIndexOf("/");
          i1 = paramString.indexOf("?");
          if ((i2 != -1) && (i1 != -1))
          {
            i2 += 1;
            if (i1 > i2)
            {
              localb.e = paramString.substring(i2, i1);
              localb.i = localb.e;
              localb.o = false;
              localb.b = 1;
            }
          }
        }
        else
        {
          localb.p = a.d.a;
        }
        int i2 = arrayOfString.length;
        i1 = 0;
        if (i1 < i2)
        {
          paramString = arrayOfString[i1];
          if (paramString.contains("="))
          {
            paramString = paramString.split("[=]");
            if (paramString.length == 2)
            {
              localObject = paramString[0];
              paramString = paramString[1];
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString)))
              {
                bool = ((String)localObject).equalsIgnoreCase("sdkappid");
                if (!bool) {}
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        b localb;
        int i1;
        Object localObject;
        paramString.printStackTrace();
        TXCLog.i("V2-TRTCPushURLParam", "parseTRTCURL: catch exception.", new Object[] { paramString });
        return null;
      }
      try
      {
        localb.a = Integer.parseInt(paramString);
      }
      catch (Exception localException1)
      {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse push url sdkappid fail. exception occurred.[value:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      TXCLog.e("V2-TRTCPushURLParam", ((StringBuilder)localObject).toString());
      continue;
      if (((String)localObject).equalsIgnoreCase("roomid"))
      {
        localb.e = paramString;
        localb.o = true;
      }
      else if (((String)localObject).equalsIgnoreCase("strroomid"))
      {
        localb.e = paramString;
        localb.o = false;
      }
      else if (((String)localObject).equalsIgnoreCase("userid"))
      {
        localb.f = paramString;
      }
      else if (((String)localObject).equalsIgnoreCase("usersig"))
      {
        localb.g = paramString;
      }
      else if (((String)localObject).equalsIgnoreCase("cloudenv"))
      {
        if (paramString.equalsIgnoreCase("pro")) {
          localb.c = 0;
        } else if (paramString.equalsIgnoreCase("dev")) {
          localb.c = 1;
        } else if (paramString.equalsIgnoreCase("uat")) {
          localb.c = 2;
        } else if (paramString.equalsIgnoreCase("ccc")) {
          localb.c = 3;
        }
      }
      else
      {
        bool = ((String)localObject).equalsIgnoreCase("encsmall");
        if (!bool) {}
      }
      try
      {
        if (Integer.parseInt(paramString) != 1) {
          break label1065;
        }
        bool = true;
      }
      catch (Exception localException2)
      {
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
      }
      localb.k = bool;
      continue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse push url enable small fail. exception occurred.[value:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      TXCLog.e("V2-TRTCPushURLParam", ((StringBuilder)localObject).toString());
      continue;
      bool = ((String)localObject).equalsIgnoreCase("enableblackstream");
      if (bool) {}
      try
      {
        if (Integer.parseInt(paramString) != 1) {
          break label1071;
        }
        bool = true;
        localb.l = bool;
      }
      catch (Exception localException3)
      {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse push url enable black fail. exception occurred.[value:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      TXCLog.e("V2-TRTCPushURLParam", ((StringBuilder)localObject).toString());
      continue;
      if (((String)localObject).equalsIgnoreCase("appscene"))
      {
        if (paramString.equalsIgnoreCase("live")) {
          localb.b = 1;
        } else if (paramString.equalsIgnoreCase("videocall")) {
          localb.b = 0;
        } else if (paramString.equalsIgnoreCase("audiocall")) {
          localb.b = 2;
        } else if (paramString.equalsIgnoreCase("voicechatroom")) {
          localb.b = 3;
        } else {
          localb.b = 0;
        }
      }
      else
      {
        bool = ((String)localObject).equalsIgnoreCase("recvmode");
        if (!bool) {}
      }
      try
      {
        int i3 = Integer.parseInt(paramString);
        if (i3 == 1)
        {
          localb.n = true;
          localb.m = true;
        }
        else if (i3 == 2)
        {
          localb.n = true;
          localb.m = false;
        }
        else if (i3 == 3)
        {
          localb.n = false;
          localb.m = true;
        }
        else if (i3 == 4)
        {
          localb.n = false;
          localb.m = false;
        }
        else
        {
          localb.n = true;
          localb.m = true;
        }
      }
      catch (Exception localException4)
      {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse push url recv mode fail. exception occurred.[value:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      TXCLog.e("V2-TRTCPushURLParam", ((StringBuilder)localObject).toString());
      continue;
      if (((String)localObject).equalsIgnoreCase("streamid"))
      {
        localb.i = paramString;
      }
      else if (((String)localObject).equalsIgnoreCase("userdefinerecordid"))
      {
        localb.j = paramString;
      }
      else if (((String)localObject).equalsIgnoreCase("privatemapkey"))
      {
        localb.h = paramString;
      }
      else
      {
        bool = ((String)localObject).equalsIgnoreCase("pureaudiomode");
        if (!bool) {}
      }
      try
      {
        localb.d = Integer.parseInt(paramString);
      }
      catch (Exception localException5)
      {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse push url pure audio mode fail. exception occurred.[value:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      TXCLog.e("V2-TRTCPushURLParam", ((StringBuilder)localObject).toString());
      continue;
      if (((String)localObject).equalsIgnoreCase("int32streamid")) {
        localb.o = "true".equalsIgnoreCase(paramString);
      }
      i1 += 1;
    }
    return localb;
  }
  
  public boolean a()
  {
    return (this.a > 0) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g));
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public boolean c()
  {
    return this.l;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.e;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return this.p == a.d.b;
  }
  
  public boolean i()
  {
    return this.p == a.d.a;
  }
  
  public a.d j()
  {
    return this.p;
  }
  
  public boolean k()
  {
    return this.n;
  }
  
  public boolean l()
  {
    return this.m;
  }
  
  public TRTCCloudDef.TRTCParams m()
  {
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams();
    localTRTCParams.sdkAppId = this.a;
    localTRTCParams.userId = this.f;
    localTRTCParams.userSig = this.g;
    localTRTCParams.role = 20;
    if (this.o) {}
    try
    {
      localTRTCParams.roomId = Integer.parseInt(this.e);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1;
          JSONObject localJSONObject2;
          if ((this.d == 1) || (this.d == 2))
          {
            localJSONObject2.put("pure_audio_push_mod", this.d);
            localJSONObject1.put("Str_uc_params", localJSONObject2);
            localTRTCParams.businessInfo = localJSONObject1.toString();
          }
          return localTRTCParams;
        }
        catch (JSONException localJSONException) {}
        localException = localException;
      }
    }
    TXCLog.e("V2-TRTCPushURLParam", "get enter room fail. can't parse num room id.");
    localTRTCParams.roomId = 0;
    break label87;
    localTRTCParams.roomId = 0;
    localTRTCParams.strRoomId = this.e;
    label87:
    if (!TextUtils.isEmpty(this.h)) {
      localTRTCParams.privateMapKey = this.h;
    }
    if (!TextUtils.isEmpty(this.j)) {
      localTRTCParams.userDefineRecordId = this.j;
    }
    if (!TextUtils.isEmpty(this.i)) {
      localTRTCParams.streamId = this.i;
    }
    localJSONObject1 = new JSONObject();
    localJSONObject2 = new JSONObject();
    return localTRTCParams;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[env:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("][sdkAppId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][roomId:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("][isNumRoomId:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("][scene:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][userId:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("][streamId:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("][recordId:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("][pureAudioMode:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("][autoRecvAudio:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("][autoRecvViedo:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("][protocolType:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.b
 * JD-Core Version:    0.7.0.1
 */