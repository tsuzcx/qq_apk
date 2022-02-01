package com.tencent.liteav.network;

import android.os.Handler;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

class g$2
  extends Thread
{
  g$2(g paramg, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, g.a parama)
  {
    super(paramString1);
  }
  
  public void run()
  {
    String str2 = "message";
    Object localObject2 = "pull_addr";
    Object localObject1 = this.a;
    int m;
    if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
      m = Integer.valueOf(this.a).intValue();
    } else {
      m = 0;
    }
    int i = 5;
    if (!g.a(this.g, true, this.a, this.b, this.c))
    {
      j = (int)g.a(this.g);
      i = j;
      if (j <= 0)
      {
        i = 1;
        n = 1;
        break label96;
      }
    }
    int n = 2;
    label96:
    int i1 = i + n;
    Object localObject4 = "";
    int j = -1;
    Object localObject8;
    Object localObject7;
    int k;
    Object localObject6;
    if (i1 >= 1)
    {
      localObject8 = str2;
      localObject7 = localObject2;
      k = j;
      localObject6 = localObject4;
    }
    label2051:
    label2070:
    label2077:
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        localObject8 = str2;
        localObject7 = localObject2;
        k = j;
        localObject6 = localObject4;
        ((JSONObject)localObject1).put("bizid", m);
        localObject8 = str2;
        localObject7 = localObject2;
        k = j;
        localObject6 = localObject4;
        ((JSONObject)localObject1).put("stream_id", this.d);
        localObject8 = str2;
        localObject7 = localObject2;
        k = j;
        localObject6 = localObject4;
        ((JSONObject)localObject1).put("txSecret", this.c);
        localObject8 = str2;
        localObject7 = localObject2;
        k = j;
        localObject6 = localObject4;
        ((JSONObject)localObject1).put("txTime", this.b);
        localObject8 = str2;
        localObject7 = localObject2;
        k = j;
        localObject6 = localObject4;
        ((JSONObject)localObject1).put("type", 1);
        localObject8 = str2;
        localObject7 = localObject2;
        k = j;
        localObject6 = localObject4;
        Object localObject9 = ((JSONObject)localObject1).toString();
        if (i1 > n)
        {
          localObject1 = "https://livepull.myqcloud.com/getpulladdr";
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          localObject1 = (HttpsURLConnection)new URL((String)localObject1).openConnection();
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setDoOutput(true);
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setDoInput(true);
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setUseCaches(false);
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setConnectTimeout(5000);
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setReadTimeout(5000);
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setRequestMethod("POST");
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setRequestProperty("Charsert", "UTF-8");
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setRequestProperty("Content-Type", "text/plain;");
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((HttpsURLConnection)localObject1).setRequestProperty("Content-Length", String.valueOf(((String)localObject9).length()));
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          localObject10 = new StringBuilder();
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((StringBuilder)localObject10).append("getAccelerateStreamPlayUrl: sendHttpRequest[ ");
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((StringBuilder)localObject10).append((String)localObject9);
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((StringBuilder)localObject10).append("] retryIndex = ");
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((StringBuilder)localObject10).append(i1);
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          TXCLog.e("TXRTMPAccUrlFetcher", ((StringBuilder)localObject10).toString());
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          new DataOutputStream(((HttpsURLConnection)localObject1).getOutputStream()).write(((String)localObject9).getBytes());
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          localObject9 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject1).getInputStream()));
          localObject1 = "";
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          localObject10 = ((BufferedReader)localObject9).readLine();
          if (localObject10 != null)
          {
            localObject8 = str2;
            localObject7 = localObject2;
            k = j;
            localObject6 = localObject4;
            localObject11 = new StringBuilder();
            localObject8 = str2;
            localObject7 = localObject2;
            k = j;
            localObject6 = localObject4;
            ((StringBuilder)localObject11).append((String)localObject1);
            localObject8 = str2;
            localObject7 = localObject2;
            k = j;
            localObject6 = localObject4;
            ((StringBuilder)localObject11).append((String)localObject10);
            localObject8 = str2;
            localObject7 = localObject2;
            k = j;
            localObject6 = localObject4;
            localObject1 = ((StringBuilder)localObject11).toString();
            continue;
          }
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          localObject9 = new StringBuilder();
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((StringBuilder)localObject9).append("getAccelerateStreamPlayUrl: receive response, strResponse = ");
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          ((StringBuilder)localObject9).append((String)localObject1);
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          TXCLog.e("TXRTMPAccUrlFetcher", ((StringBuilder)localObject9).toString());
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          localObject9 = (JSONObject)new JSONTokener((String)localObject1).nextValue();
          i = j;
          localObject8 = str2;
          localObject7 = localObject2;
          k = j;
          localObject6 = localObject4;
          if (((JSONObject)localObject9).has("code"))
          {
            localObject8 = str2;
            localObject7 = localObject2;
            k = j;
            localObject6 = localObject4;
            i = ((JSONObject)localObject9).getInt("code");
          }
          localObject1 = localObject4;
          if (i != 0)
          {
            localObject1 = localObject4;
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject4;
            if (((JSONObject)localObject9).has(str2))
            {
              localObject8 = str2;
              localObject7 = localObject2;
              k = i;
              localObject6 = localObject4;
              localObject1 = ((JSONObject)localObject9).getString(str2);
            }
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            localObject4 = new StringBuilder();
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            ((StringBuilder)localObject4).append("getAccelerateStreamPlayUrl: errorCode = ");
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            ((StringBuilder)localObject4).append(i);
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            ((StringBuilder)localObject4).append(" errorMessage = ");
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            ((StringBuilder)localObject4).append((String)localObject1);
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            TXCLog.e("TXRTMPAccUrlFetcher", ((StringBuilder)localObject4).toString());
          }
          localObject8 = str2;
          localObject7 = localObject2;
          k = i;
          localObject6 = localObject1;
          if (((JSONObject)localObject9).has((String)localObject2))
          {
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            localObject10 = new Vector();
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            localObject11 = new Vector();
            localObject8 = str2;
            localObject7 = localObject2;
            k = i;
            localObject6 = localObject1;
            localObject9 = ((JSONObject)localObject9).getJSONArray((String)localObject2);
            if (localObject9 != null)
            {
              localObject8 = str2;
              localObject7 = localObject2;
              k = i;
              localObject6 = localObject1;
              if (((JSONArray)localObject9).length() != 0) {
                break label2046;
              }
              continue;
              localObject8 = str2;
              localObject7 = localObject2;
              k = i;
              localObject6 = localObject1;
              if (j >= ((JSONArray)localObject9).length()) {
                break label2077;
              }
              localObject8 = str2;
              localObject7 = localObject2;
              k = i;
              localObject6 = localObject1;
              localObject4 = (JSONObject)((JSONArray)localObject9).get(j);
              if (localObject4 == null) {
                break label2070;
              }
              localObject8 = str2;
              localObject7 = localObject2;
              k = i;
              localObject6 = localObject1;
              str3 = ((JSONObject)localObject4).getString("rtmp_url");
              localObject7 = str2;
            }
          }
        }
      }
      catch (Exception localException3)
      {
        Object localObject10;
        Object localObject11;
        String str3;
        Object localObject12;
        localObject2 = localObject8;
        localObject1 = localObject6;
        i = k;
        localObject5 = localObject7;
      }
      try
      {
        if (((JSONObject)localObject4).getInt("proto") != 1) {
          break label2051;
        }
        bool = true;
        localObject12 = new StringBuilder();
        localObject8 = localObject2;
        localObject6 = localObject7;
        localObject4 = localObject8;
        try
        {
          ((StringBuilder)localObject12).append("getAccelerateStreamPlayUrl: streamUrl = ");
          localObject6 = localObject7;
          localObject4 = localObject8;
          ((StringBuilder)localObject12).append(str3);
          localObject6 = localObject7;
          localObject4 = localObject8;
          ((StringBuilder)localObject12).append(" Q channel = ");
          localObject6 = localObject7;
          localObject4 = localObject8;
          ((StringBuilder)localObject12).append(bool);
          localObject6 = localObject7;
          localObject4 = localObject8;
          TXCLog.e("TXRTMPAccUrlFetcher", ((StringBuilder)localObject12).toString());
          localObject6 = localObject7;
          localObject4 = localObject8;
          localObject12 = TXCCommonUtil.getStreamIDByStreamUrl(str3);
          if (localObject12 == null) {
            break label2070;
          }
          localObject6 = localObject7;
          localObject4 = localObject8;
          if (!((String)localObject12).equalsIgnoreCase(this.d)) {
            break label2070;
          }
          if (bool)
          {
            localObject6 = localObject7;
            localObject4 = localObject8;
            ((Vector)localObject10).add(new e(str3, bool));
          }
          else
          {
            localObject6 = localObject7;
            localObject4 = localObject8;
            ((Vector)localObject11).add(new e(str3, bool));
          }
        }
        catch (Exception localException2)
        {
          localObject2 = localObject6;
          break label1898;
        }
        localObject6 = str2;
        localObject4 = localObject2;
        TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: no pull_addr");
        localObject6 = str2;
        localObject4 = localObject2;
        j = this.e;
        if (j == 1)
        {
          localObject6 = str2;
          localObject4 = localObject2;
        }
        try
        {
          if (((Vector)localObject11).size() <= 0) {
            continue;
          }
          g.b(this.g).post(new g.2.1(this, (Vector)localObject11));
          return;
        }
        catch (Exception localException6)
        {
          localObject6 = str2;
          localObject7 = localObject2;
        }
        j = this.e;
        if (j == 2)
        {
          j = i;
          localObject7 = localObject1;
          localObject6 = str2;
          localObject4 = localObject2;
        }
        try
        {
          if (((Vector)localObject10).size() <= 0) {
            break label1971;
          }
          g.b(this.g).post(new g.2.2(this, (Vector)localObject10));
          return;
        }
        catch (Exception localException5) {}
        localObject4 = ((Vector)localObject11).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          ((Vector)localObject10).add((e)((Iterator)localObject4).next());
          continue;
        }
        j = i;
        localObject7 = localObject1;
        localObject6 = str2;
        localObject4 = localObject2;
        if (((Vector)localObject10).size() <= 0) {
          break label1971;
        }
        g.b(this.g).post(new g.2.3(this, (Vector)localObject10));
        return;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          Object localObject3;
          String str1;
          localObject5 = localObject2;
          localObject2 = localObject7;
        }
      }
      Object localObject5 = localObject2;
      localObject6 = localException2;
      j = i;
      localObject7 = localObject1;
      break label1971;
      label1898:
      localObject7 = localObject5;
      localObject6 = localObject2;
      localObject5 = localException3;
      localObject2 = localObject7;
      localObject3 = localObject6;
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("getAccelerateStreamPlayUrl exception:");
      ((StringBuilder)localObject6).append(((Exception)localObject5).toString());
      TXCLog.e("TXRTMPAccUrlFetcher", ((StringBuilder)localObject6).toString());
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject7 = localObject1;
      j = i;
      try
      {
        label1971:
        sleep(1000L, 0);
      }
      catch (Exception localException1)
      {
        label1981:
        break label1981;
      }
      TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception sleep");
      i1 -= 1;
      localObject3 = localObject6;
      localObject2 = localObject5;
      localObject5 = localObject7;
      break;
      g.b(this.g).post(new g.2.4(this, j, (String)localObject5));
      return;
      str1 = "https://livepullipv6.myqcloud.com/getpulladdr";
      continue;
      label2046:
      j = 0;
      continue;
      boolean bool = false;
      continue;
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.g.2
 * JD-Core Version:    0.7.0.1
 */