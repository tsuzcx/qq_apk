package com.tencent.live2.b;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.impl.a.d;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;

public class a
{
  private int a;
  private String b;
  private int c = 1;
  private String d;
  private String e;
  private String f;
  private String g;
  private int h = 0;
  private boolean i;
  private a.d j = a.d.a;
  
  public static a b(String paramString)
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
        locala = new a();
        String[] arrayOfString = paramString.split("[?&]");
        if (paramString.startsWith("trtc://"))
        {
          locala.j = a.d.b;
          m = paramString.lastIndexOf("/");
          k = paramString.indexOf("?");
          if ((m != -1) && (k != -1))
          {
            m += 1;
            if (k > m)
            {
              locala.b = paramString.substring(m, k);
              locala.i = false;
              locala.c = 1;
            }
          }
        }
        else
        {
          locala.i = true;
          locala.j = a.d.a;
        }
        int i1 = arrayOfString.length;
        n = 0;
        if (n < i1)
        {
          paramString = arrayOfString[n];
          if (paramString.contains("="))
          {
            paramString = paramString.split("[=]");
            k = paramString.length;
            m = 2;
            if (k == 2)
            {
              localObject = paramString[0];
              paramString = paramString[1];
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString)))
              {
                boolean bool = ((String)localObject).equalsIgnoreCase("sdkappid");
                if (!bool) {}
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        a locala;
        int n;
        Object localObject;
        paramString.printStackTrace();
        TXCLog.i("V2-TRTCPlayURLParam", "parseTRTCURL: catch exception.", new Object[] { paramString });
        return null;
      }
      try
      {
        locala.a = Integer.parseInt(paramString);
      }
      catch (Exception localException)
      {
        continue;
        k = -1;
        if (k == 0) {
          break label668;
        }
        if (k == 1) {
          break label673;
        }
        if (k == 2) {
          continue;
        }
        m = 0;
        continue;
        m = 1;
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse push url sdkappid fail. exception occurred.[value:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      TXCLog.e("V2-TRTCPlayURLParam", ((StringBuilder)localObject).toString());
      continue;
      if (((String)localObject).equalsIgnoreCase("roomid"))
      {
        locala.b = paramString;
        locala.i = true;
      }
      else if (((String)localObject).equalsIgnoreCase("strroomid"))
      {
        locala.b = paramString;
        locala.i = false;
      }
      else if (((String)localObject).equalsIgnoreCase("userid"))
      {
        if (locala.j == a.d.a)
        {
          locala.g = paramString;
          locala.d = "";
        }
        else
        {
          locala.d = paramString;
          locala.g = "27eb683b73944771ce62fbddab2849a4";
        }
      }
      else if (((String)localObject).equalsIgnoreCase("usersig"))
      {
        locala.e = paramString;
      }
      else if (((String)localObject).equalsIgnoreCase("appscene"))
      {
        if (paramString.equalsIgnoreCase("live")) {
          locala.c = 1;
        } else if (paramString.equalsIgnoreCase("videocall")) {
          locala.c = 0;
        } else if (paramString.equalsIgnoreCase("audiocall")) {
          locala.c = 2;
        } else if (paramString.equalsIgnoreCase("voicechatroom")) {
          locala.c = 3;
        } else {
          locala.c = 0;
        }
      }
      else if (((String)localObject).equalsIgnoreCase("privatemapkey"))
      {
        locala.f = paramString;
      }
      else if (((String)localObject).equalsIgnoreCase("streamtype"))
      {
        k = paramString.hashCode();
        if (k != 96964)
        {
          if (k != 3343801)
          {
            if ((k != 109548807) || (!paramString.equals("small"))) {
              break label652;
            }
            k = 1;
            break label654;
          }
          if (!paramString.equals("main")) {
            break label652;
          }
          k = 0;
          break label654;
        }
        if (!paramString.equals("aux")) {
          break label652;
        }
        k = 2;
        break label654;
        locala.h = m;
      }
      else if (((String)localObject).equalsIgnoreCase("int32streamid"))
      {
        locala.i = "true".equalsIgnoreCase(paramString);
      }
      n += 1;
    }
    return locala;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public a.d d()
  {
    return this.j;
  }
  
  public boolean e()
  {
    return this.j == a.d.b;
  }
  
  public int f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    return (i()) || (h());
  }
  
  public boolean h()
  {
    return (this.j == a.d.b) && (this.a != 0) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e));
  }
  
  public boolean i()
  {
    return (this.j == a.d.a) && (!TextUtils.isEmpty(this.g));
  }
  
  public TRTCCloudDef.TRTCParams j()
  {
    if ((!h()) && (!i()))
    {
      TXCLog.e("V2-TRTCPlayURLParam", "generate trtc param fail. not trtc protocol.");
      return null;
    }
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams();
    localTRTCParams.sdkAppId = this.a;
    localTRTCParams.userId = this.d;
    localTRTCParams.userSig = this.e;
    localTRTCParams.role = 21;
    if (this.i) {}
    try
    {
      localTRTCParams.roomId = Integer.parseInt(this.b);
    }
    catch (Exception localException)
    {
      label82:
      label110:
      break label82;
    }
    TXCLog.e("V2-TRTCPlayURLParam", "get enter room fail. can't parse num room id.");
    localTRTCParams.roomId = 0;
    break label110;
    localTRTCParams.roomId = 0;
    localTRTCParams.strRoomId = this.b;
    if (!TextUtils.isEmpty(this.f)) {
      localTRTCParams.privateMapKey = this.f;
    }
    return localTRTCParams;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[sdkAppId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][roomId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][isNumRoomId:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("][scene:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("][userId:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("][remoteUserId:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("][streamType:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("][protocolType:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.a
 * JD-Core Version:    0.7.0.1
 */