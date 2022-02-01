package com.tencent.luggage.wxa.pd;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p
{
  public static final p.b a(i parami, @Nullable m paramm, JSONObject paramJSONObject, p.a parama)
  {
    boolean bool2 = false;
    if ((parami != null) && (paramJSONObject != null))
    {
      p.a locala = parama;
      if (parama == null) {
        locala = new p.a();
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray(locala.a);
      if (localJSONArray == null) {
        return p.b.a;
      }
      paramJSONObject.remove(locala.a);
      int k = localJSONArray.length();
      int i = 0;
      int j = 0;
      while (i < k)
      {
        parama = localJSONArray.optJSONObject(i);
        if (parama != null)
        {
          String str = parama.optString(locala.b);
          if (!af.c(str))
          {
            int m = parama.optInt(locala.c, -1);
            if (m == -1) {}
            try
            {
              parama = parama.optString(locala.d, "");
              if (af.c(parama))
              {
                o.d("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                paramJSONObject.put(str, ByteBuffer.allocate(0));
              }
              else
              {
                paramJSONObject.put(str, ByteBuffer.wrap(Base64.decode(parama.getBytes(Charset.forName("UTF-8")), 2)));
              }
            }
            catch (JSONException parama)
            {
              o.c("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", new Object[] { parama.getMessage() });
            }
            parama = (k)parami.a(k.class);
            if (parama == null)
            {
              o.c("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
            }
            else
            {
              if (paramm == null) {
                parama = parama.a(m, false);
              } else {
                parama = paramm.a(str, parama, m);
              }
              if (parama == null)
              {
                o.c("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
              }
              else
              {
                parama.position(0);
                paramJSONObject.put(str, parama);
                m = parama.capacity();
                j += m;
              }
            }
          }
        }
        i += 1;
      }
      o.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", new Object[] { Integer.valueOf(j) });
      if (j > locala.e)
      {
        o.b("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(locala.e) });
        return p.b.b;
      }
      return p.b.a;
    }
    boolean bool1;
    if (parami == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramJSONObject == null) {
      bool2 = true;
    }
    o.b("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    return p.b.a;
  }
  
  public static final p.b a(i parami, Map paramMap, p.a parama)
  {
    boolean bool2 = false;
    label290:
    boolean bool1;
    if ((parami != null) && (paramMap != null))
    {
      p.a locala = parama;
      if (parama == null) {
        locala = new p.a();
      }
      parami = (k)parami.a(k.class);
      parama = new JSONArray();
      Iterator localIterator = paramMap.entrySet().iterator();
      int i = 0;
      int k = 0;
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (String)((Map.Entry)localObject1).getKey();
        Object localObject3 = ((Map.Entry)localObject1).getValue();
        if ((localObject3 != null) && ((localObject3 instanceof ByteBuffer)))
        {
          int j = i;
          try
          {
            localObject1 = new JSONObject();
            j = i;
            ((JSONObject)localObject1).put(locala.b, localObject2);
            if (parami != null)
            {
              j = i;
              int m = parami.r();
              if (m != -1)
              {
                j = i;
                localObject2 = (ByteBuffer)localObject3;
                if (localObject2 == null)
                {
                  j = i;
                  o.c("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
                  continue;
                }
                j = i;
                parami.a(m, (ByteBuffer)localObject2);
                j = i;
                ((JSONObject)localObject1).put(locala.c, m);
                j = i;
                i += ((ByteBuffer)localObject2).capacity();
                break label290;
              }
            }
            j = i;
            localObject2 = new String(Base64.encode(com.tencent.luggage.wxa.pc.c.a((ByteBuffer)localObject3), 2), StandardCharsets.UTF_8);
            j = i;
            ((JSONObject)localObject1).put(locala.d, localObject2);
            j = i;
            parama.put(localObject1);
            k = 1;
          }
          catch (JSONException localJSONException)
          {
            o.c("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", new Object[] { localJSONException.getMessage() });
            i = j;
          }
          localIterator.remove();
        }
      }
      if (parami != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      o.e("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
      if (i > locala.e)
      {
        o.b("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(locala.e) });
        return p.b.b;
      }
      if (k != 0) {
        paramMap.put(locala.a, parama);
      }
      return p.b.a;
    }
    if (parami == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramMap == null) {
      bool2 = true;
    }
    o.b("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    return p.b.a;
  }
  
  public static final p.b a(i parami, JSONObject paramJSONObject, p.a parama)
  {
    return a(parami, null, paramJSONObject, parama);
  }
  
  public static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return paramByteBuffer;
    }
    if (paramByteBuffer.isDirect()) {
      return paramByteBuffer;
    }
    if (!paramByteBuffer.hasArray()) {
      return paramByteBuffer;
    }
    return a(paramByteBuffer.array());
  }
  
  public static ByteBuffer a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte, 0, paramArrayOfByte.length);
    localByteBuffer.rewind();
    return localByteBuffer;
  }
  
  public static void a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convert native buffer parameter fail, event=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", error=native buffer exceed size limit");
    localHashMap.put("message", localStringBuilder.toString());
    localHashMap.put("stack", "");
    paramc.a("onError", new JSONObject(localHashMap).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.p
 * JD-Core Version:    0.7.0.1
 */