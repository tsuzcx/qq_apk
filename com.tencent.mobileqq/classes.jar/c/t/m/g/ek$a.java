package c.t.m.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;

final class ek$a
  extends Handler
{
  private int a = 0;
  private boolean b = true;
  
  ek$a(ek paramek, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void a()
  {
    removeCallbacksAndMessages(null);
    this.b = true;
    this.a = 0;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject3;
    int i;
    long l1;
    boolean bool3;
    int j;
    boolean bool1;
    boolean bool2;
    Object localObject4;
    synchronized (ek.a(this.c))
    {
      if (ek.b(this.c) == null) {
        return;
      }
      localObject1 = ek.b(this.c);
      localObject3 = ek.c(this.c);
      i = ((TencentLocationRequest)localObject3).getRequestLevel();
      l1 = ((TencentLocationRequest)localObject3).getInterval();
      bool3 = ((TencentLocationRequest)localObject3).getExtras().getBoolean("daemon");
      j = paramMessage.what;
      if (j != 555)
      {
        bool1 = true;
        bool2 = false;
        if (j != 7999) {
          if (j != 3998) {
            if (j != 3999) {
              if (j != 11998) {
                if (j != 11999) {
                  switch (j)
                  {
                  default: 
                    return;
                  case 4999: 
                    removeMessages(4998);
                    if (ek.c(this.c).getExtras().getBoolean("daemon"))
                    {
                      ek.a(this.c, true);
                      return;
                    }
                    new StringBuilder("respCallback:").append(System.currentTimeMillis() - ek.f());
                    ??? = (Pair)paramMessage.obj;
                    localObject3 = ((Pair)???).first.toString();
                    ??? = (ep.a)((Pair)???).second;
                    localObject4 = (ev)((ep.a)???).a;
                    ek.a(this.c, (ev)localObject4);
                    localObject4 = ((ep.a)???).b;
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      ??? = new fi.a();
      ((fi.a)???).a = ((String)localObject3);
      ((fi.a)???).c = i;
      ??? = ((fi.a)???).a();
      ((fi)???).getExtra().putString("resp_json", (String)localObject3);
      fi.a((fi)???);
      fi.a((fi)???, ek.w(this.c), false);
      TencentExtraKeys.setRawQuery((TencentLocation)???, (String)localObject4);
      ((fi)???).getExtra().putLong("req_cost", paramMessage.arg1);
      if (TencentExtraKeys.COMPHTTPIO) {
        ((fi)???).getExtra().putLong("urlC_cost", paramMessage.arg2);
      }
      this.b = false;
      if ((((fi)???).getVerifyKey() == null) || (((fi)???).getVerifyKey().equalsIgnoreCase("0")) || (localObject4 != null)) {}
      label541:
      label752:
      label1918:
      long l2;
      label816:
      label1238:
      label2532:
      return;
    }
    catch (JSONException paramMessage)
    {
      try
      {
        paramMessage = new JSONObject((String)localObject4);
        paramMessage.remove("attribute");
        paramMessage.remove("access_token");
        paramMessage.remove("app_label");
        paramMessage.remove("detectgps");
        paramMessage.remove("control");
        paramMessage.remove("app_name");
        paramMessage.remove("version");
        paramMessage.remove("address");
        paramMessage.remove("source");
        paramMessage.remove("bearing");
        paramMessage.remove("pstat");
        ((fi)???).getExtra().putString("wifi_data", paramMessage.toString());
      }
      catch (Exception paramMessage)
      {
        try
        {
          ((fi)???).getExtra().putString("motion", ek.x(this.c).e());
          ((fi)???).getExtra().putAll(ek.c(this.c).getExtras());
          if ((((fi)???).getAccuracy() == 20.0D) && (ek.y(this.c))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          fi.a((fi)???, ek.w(this.c), bool1);
          ((TencentLocationListener)localObject1).onLocationChanged((TencentLocation)???, 0, (String)ek.e().get(0));
          ek.a(this.c, true);
          if (!ek.j(this.c))
          {
            ((fi)???).c = null;
            ((fi)???).getExtra().putString("wifi_data", "");
            ek.a(this.c, 0, (fi)???);
            new StringBuilder("respCallback:").append(System.currentTimeMillis() - ek.f());
          }
          if (!ek.t(this.c)) {}
        }
        catch (Exception paramMessage)
        {
          try
          {
            try
            {
              paramMessage = ((fi)???).getExtra();
              if (paramMessage != null)
              {
                i = paramMessage.getInt("icontrol", -1);
                ek.s(this.c).c.edit().putInt("control", i).apply();
              }
            }
            catch (Exception paramMessage)
            {
              new StringBuilder("sp:").append(paramMessage);
            }
            ek.z(this.c);
            ek.b(this.c, (fi)???);
            if (!ek.A(this.c))
            {
              cz.a().b();
              ek.B(this.c);
            }
            ek.v(this.c).a(ek.s(this.c).a(false));
            return;
            if (ek.l(this.c)) {
              ek.a(this.c, 2, fi.a);
            }
            return;
            ek.a(this.c, false);
            if (!ek.j(this.c))
            {
              ek.a(this.c, 1, fi.a);
              return;
              ??? = (Pair)paramMessage.obj;
              paramMessage = ((Pair)???).first.toString();
              ??? = (ep.a)((Pair)???).second;
              localObject3 = (ev)((ep.a)???).a;
              localObject4 = ((ep.a)???).b;
              this.a = 0;
            }
          }
          catch (Error paramMessage)
          {
            try
            {
              ??? = new fi.a();
              ((fi.a)???).a = paramMessage;
              ((fi.a)???).c = i;
              ??? = ((fi.a)???).a();
              ((fi)???).getExtra().putString("resp_json", paramMessage);
              fi.a((fi)???);
              if ((((fi)???).getAccuracy() != 20.0D) || (!ek.y(this.c))) {
                bool1 = false;
              }
              fi.a((fi)???, ek.w(this.c), bool1);
              TencentExtraKeys.setRawQuery((TencentLocation)???, (String)localObject4);
              if (((ev)localObject3).d != null) {
                i = ((ev)localObject3).d.c;
              } else {
                i = 0;
              }
              ((fi)???).getExtra().putInt("sat_num", i);
              if ((((fi)???).getVerifyKey() != null) && (!((fi)???).getVerifyKey().equalsIgnoreCase("0"))) {
                if (localObject4 != null) {
                  try
                  {
                    paramMessage = new JSONObject((String)localObject4);
                    paramMessage.remove("attribute");
                    paramMessage.remove("access_token");
                    paramMessage.remove("app_label");
                    paramMessage.remove("detectgps");
                    paramMessage.remove("control");
                    paramMessage.remove("app_name");
                    paramMessage.remove("version");
                    paramMessage.remove("address");
                    paramMessage.remove("source");
                    paramMessage.remove("bearing");
                    paramMessage.remove("pstat");
                    paramMessage.put("motion", ek.x(this.c).e());
                    ((fi)???).getExtra().putString("wifi_data", paramMessage.toString());
                  }
                  catch (Exception paramMessage)
                  {
                    paramMessage.printStackTrace();
                  }
                }
              }
            }
            catch (JSONException paramMessage)
            {
              try
              {
                ((fi)???).getExtra().putString("motion", ek.x(this.c).e());
                ((fi)???).getExtra().putAll(ek.c(this.c).getExtras());
                ek.b(this.c, (fi)???);
                ((TencentLocationListener)localObject1).onLocationChanged((TencentLocation)???, 0, (String)ek.e().get(0));
                return;
                for (;;)
                {
                  if (ek.l(this.c)) {
                    ek.a(this.c, 2, fi.a);
                  }
                  return;
                  this.a += 1;
                  if (this.a == 3)
                  {
                    ((TencentLocationListener)localObject1).onLocationChanged(fi.a, 5, (String)ek.e().get(5));
                    this.a = 0;
                    return;
                    if ((ek.d(this.c) != null) && (((TencentLocationRequest)localObject3).getInterval() > 0L) && (ek.e(this.c) != null) && (ek.e(this.c).equalsIgnoreCase("start")))
                    {
                      paramMessage = this.c;
                      ek.a(paramMessage, ek.d(paramMessage));
                      paramMessage = new StringBuilder("time_callback");
                      paramMessage.append(ek.d(this.c).getLatitude());
                      paramMessage.append(",");
                      paramMessage.append(ek.d(this.c).getLongitude());
                      ((TencentLocationListener)localObject1).onLocationChanged(ek.d(this.c), ek.f(this.c), (String)ek.e().get(ek.f(this.c)));
                      if ((ek.g(this.c)) && (ek.h(this.c) != null)) {
                        ek.h(this.c).onDistanceChanged(ek.d(this.c), fp.a(ek.i(this.c) / 1000.0D, 2), ek.f(this.c), (String)ek.e().get(ek.f(this.c)));
                      }
                    }
                    if ((l1 > 0L) && (!bool3)) {
                      sendEmptyMessageDelayed(11999, l1);
                    }
                    bool1 = ek.j(this.c);
                    ek.k(this.c).d = bool1;
                    if ((bool1) && (l1 > 5000L))
                    {
                      sendEmptyMessageDelayed(3999, l1 - 1500L);
                      return;
                      if (ek.d(this.c) != null)
                      {
                        paramMessage = this.c;
                        ek.a(paramMessage, ek.d(paramMessage));
                        ((TencentLocationListener)localObject1).onLocationChanged(ek.d(this.c), ek.f(this.c), (String)ek.e().get(ek.f(this.c)));
                        if ((ek.g(this.c)) && (ek.h(this.c) != null))
                        {
                          ek.h(this.c).onDistanceChanged(ek.d(this.c), fp.a(ek.i(this.c) / 1000.0D, 2), ek.f(this.c), (String)ek.e().get(ek.f(this.c)));
                          return;
                          break label1948;
                          ??? = ek.q(this.c);
                          paramMessage = ((ev)???).a(i, ek.r(this.c), ek.s(this.c), true, false, false);
                          if ((true ^ fp.a(paramMessage))) {
                            return;
                          }
                          localObject1 = ek.v(this.c);
                          i = ek.p(this.c);
                          l1 = SystemClock.elapsedRealtime();
                        }
                      }
                    }
                  }
                  try
                  {
                    localObject3 = co.c(paramMessage.getBytes("GBK"));
                    ??? = new ep.a(3, (byte[])localObject3, ep.a((byte[])localObject3, i), ???);
                    ((ep.a)???).b = paramMessage;
                    bool1 = bool2;
                    if (ep.a.a((ep.a)???) != null)
                    {
                      ((ep)localObject1).a.clear();
                      bool1 = ((ep)localObject1).a.offer(???);
                    }
                    if (bool1) {
                      ((ep)localObject1).h = l1;
                    }
                  }
                  catch (UnsupportedEncodingException paramMessage)
                  {
                    label1948:
                    break label1918;
                  }
                  sendEmptyMessageDelayed(3998, ek.c(this.c).getCheckInterval());
                  return;
                  if (ek.l(this.c)) {
                    return;
                  }
                  new StringBuilder("preCallback:").append(System.currentTimeMillis() - ek.f());
                  if (bool3)
                  {
                    ??? = new StringBuilder("the daemonLocation,so we delay long time upload:");
                    ((StringBuilder)???).append(ek.m(this.c));
                    ((StringBuilder)???).append(",");
                    ((StringBuilder)???).append(System.currentTimeMillis());
                    ((StringBuilder)???).append(",");
                    ((StringBuilder)???).append(ek.n(this.c));
                    if (System.currentTimeMillis() - ek.n(this.c) >= ek.m(this.c)) {
                      ek.a(this.c, System.currentTimeMillis());
                    }
                  }
                  else
                  {
                    bool1 = ek.j(this.c);
                    ek.k(this.c).d = bool1;
                    if ((bool1) && (l1 > 5000L))
                    {
                      l2 = System.currentTimeMillis();
                      if (l2 - ek.o(this.c) >= l1 - 1500L) {
                        ek.b(this.c, l2);
                      } else {
                        return;
                      }
                    }
                  }
                  if (paramMessage.obj != null) {
                    new StringBuilder("wifi error.").append(paramMessage.obj.toString());
                  }
                  j = ek.p(this.c);
                  paramMessage = ek.q(this.c);
                  ??? = ek.r(this.c);
                  localObject4 = ek.s(this.c);
                  if ((this.b) && (!bool3)) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  }
                  ??? = paramMessage.a(i, (String)???, (ea)localObject4, bool1, ek.t(this.c), bool3);
                  if ((fp.a((String)???) ^ true))
                  {
                    bool1 = ek.j(this.c);
                    paramMessage = new StringBuilder("handleMessage: gpsValid : ");
                    paramMessage.append(bool1);
                    paramMessage.append(",bad json : ");
                    paramMessage.append((String)???);
                    if (!bool1) {
                      ek.a(this.c, 2, fi.a);
                    }
                    return;
                  }
                  if ((!bool3) && (TencentExtraKeys.isRequestRawData((TencentLocationRequest)localObject3)))
                  {
                    paramMessage = new fi.a();
                    paramMessage.b = null;
                    paramMessage.c = i;
                    paramMessage = paramMessage.a();
                    TencentExtraKeys.setRawData(paramMessage, ((String)???).getBytes());
                    ek.a(this.c, paramMessage);
                    ((TencentLocationListener)localObject1).onLocationChanged(paramMessage, 0, (String)ek.e().get(0));
                    return;
                  }
                  new StringBuilder("postCallback:").append(System.currentTimeMillis() - ek.f());
                  localObject3 = ek.u(this.c);
                  if (localObject3 != null)
                  {
                    if ((((ev)localObject3).b()) && (paramMessage.b()) && (paramMessage.b.a(((ev)localObject3).b)))
                    {
                      i = 2;
                      break label2532;
                    }
                    localObject1 = paramMessage;
                    if ((!((ev)localObject3).b()) && (!((ev)localObject1).b()) && (((ev)localObject3).a()) && (((ev)localObject1).a()) && (((ev)localObject1).c.c().equalsIgnoreCase(((ev)localObject3).c.c())))
                    {
                      i = 1;
                      break label2532;
                    }
                  }
                  i = 0;
                  if ((ek.f(this.c) == 0) && (ek.d(this.c) != null) && ((i == 1) || ((i >= 2) && (ek.d(this.c).getAccuracy() < 80.0F))))
                  {
                    paramMessage = this.c;
                    ek.a(paramMessage, 0, ek.d(paramMessage));
                    return;
                  }
                  localObject1 = ek.v(this.c);
                  try
                  {
                    localObject3 = co.c(((String)???).getBytes("GBK"));
                    paramMessage = new ep.a(1, (byte[])localObject3, ep.a((byte[])localObject3, j), paramMessage);
                    paramMessage.b = ((String)???);
                    paramMessage.d = j;
                    if (ep.a.a(paramMessage) != null) {
                      ((ep)localObject1).a.offer(paramMessage);
                    }
                    return;
                  }
                  catch (UnsupportedEncodingException paramMessage) {}
                  ek.C(this.c);
                  sendEmptyMessage(3999);
                  return;
                  paramMessage = finally;
                  throw paramMessage;
                  paramMessage = paramMessage;
                  break label816;
                  paramMessage = paramMessage;
                  break;
                  paramMessage = paramMessage;
                  break label541;
                  paramMessage = paramMessage;
                  break label752;
                  paramMessage = paramMessage;
                }
              }
              catch (Exception paramMessage)
              {
                break label1238;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ek.a
 * JD-Core Version:    0.7.0.1
 */