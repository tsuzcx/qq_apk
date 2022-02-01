package com.tencent.luggage.wxa.kr;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.on.n;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 414;
  public static final String NAME = "searchContacts";
  private List<String[]> a;
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString.replaceAll("\\D", "");
    paramString = str;
    if (str.startsWith("86")) {
      paramString = str.substring(2);
    }
    return paramString;
  }
  
  /* Error */
  public static List<String[]> a(Context paramContext)
  {
    // Byte code:
    //   0: new 45	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 46	java/util/LinkedList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 52	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore_3
    //   13: aload_0
    //   14: ldc 54
    //   16: invokestatic 59	com/tencent/luggage/util/j:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   19: ifne +12 -> 31
    //   22: ldc 61
    //   24: ldc 63
    //   26: invokestatic 69	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_2
    //   30: areturn
    //   31: aload_3
    //   32: getstatic 75	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: ldc 77
    //   40: invokevirtual 83	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_0
    //   44: goto +46 -> 90
    //   47: astore_0
    //   48: ldc 61
    //   50: aload_0
    //   51: ldc 24
    //   53: iconst_0
    //   54: anewarray 85	java/lang/Object
    //   57: invokestatic 88	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: ldc 61
    //   62: ldc 90
    //   64: iconst_1
    //   65: anewarray 85	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_0
    //   71: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 97	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_3
    //   79: getstatic 75	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: invokevirtual 83	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore_0
    //   90: aload_0
    //   91: ifnonnull +12 -> 103
    //   94: ldc 61
    //   96: ldc 99
    //   98: invokestatic 69	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_2
    //   102: areturn
    //   103: aload_0
    //   104: invokeinterface 105 1 0
    //   109: ifle +104 -> 213
    //   112: aload_0
    //   113: invokeinterface 109 1 0
    //   118: ifeq +95 -> 213
    //   121: aload_0
    //   122: aload_0
    //   123: ldc 111
    //   125: invokeinterface 115 2 0
    //   130: invokeinterface 118 2 0
    //   135: astore_3
    //   136: aload_2
    //   137: iconst_4
    //   138: anewarray 26	java/lang/String
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: aload_0
    //   145: ldc 120
    //   147: invokeinterface 115 2 0
    //   152: invokeinterface 118 2 0
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload_3
    //   161: aastore
    //   162: dup
    //   163: iconst_2
    //   164: aload_0
    //   165: aload_0
    //   166: ldc 122
    //   168: invokeinterface 115 2 0
    //   173: invokeinterface 118 2 0
    //   178: aastore
    //   179: dup
    //   180: iconst_3
    //   181: aload_0
    //   182: aload_0
    //   183: ldc 124
    //   185: invokeinterface 115 2 0
    //   190: invokeinterface 118 2 0
    //   195: aastore
    //   196: invokeinterface 130 2 0
    //   201: pop
    //   202: aload_0
    //   203: invokeinterface 133 1 0
    //   208: istore_1
    //   209: iload_1
    //   210: ifne -89 -> 121
    //   213: aload_0
    //   214: invokeinterface 136 1 0
    //   219: aload_2
    //   220: areturn
    //   221: astore_2
    //   222: goto +37 -> 259
    //   225: astore_3
    //   226: ldc 61
    //   228: aload_3
    //   229: ldc 24
    //   231: iconst_0
    //   232: anewarray 85	java/lang/Object
    //   235: invokestatic 88	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: ldc 61
    //   240: ldc 138
    //   242: iconst_1
    //   243: anewarray 85	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload_3
    //   249: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   252: aastore
    //   253: invokestatic 97	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: goto -43 -> 213
    //   259: aload_0
    //   260: invokeinterface 136 1 0
    //   265: goto +5 -> 270
    //   268: aload_2
    //   269: athrow
    //   270: goto -2 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramContext	Context
    //   208	2	1	bool	boolean
    //   7	213	2	localLinkedList	java.util.LinkedList
    //   221	48	2	localObject1	Object
    //   12	149	3	localObject2	Object
    //   225	24	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   31	44	47	java/lang/Exception
    //   103	121	221	finally
    //   121	209	221	finally
    //   226	256	221	finally
    //   103	121	225	java/lang/Exception
    //   121	209	225	java/lang/Exception
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = af.c(paramString1);
    boolean bool1 = false;
    if ((!bool2) && (!af.c(paramString2)))
    {
      int m = paramString1.length();
      int i = paramString2.length();
      if (m < 8)
      {
        o.e("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", new Object[] { Integer.valueOf(paramString1.length()) });
        return false;
      }
      if (m > i)
      {
        o.e("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
        return false;
      }
      int j = 0;
      int k;
      for (i = 0;; i = k)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = i;
        if (paramString1.charAt(j) != paramString2.charAt(j))
        {
          i += 1;
          k = i;
          if (i > 3)
          {
            k = i;
            break;
          }
        }
        j += 1;
      }
      if (k <= 3) {
        bool1 = true;
      }
      return bool1;
    }
    o.b("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
    return false;
  }
  
  private boolean b(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    n.b(paramc.getAppId(), new e.1(this, paramc, paramJSONObject, paramInt));
    paramJSONObject = paramc.getContext();
    if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity)))
    {
      boolean bool = j.a((Activity)paramJSONObject, "android.permission.READ_CONTACTS", 48, "", "");
      if (bool) {
        n.a(paramc.getAppId());
      }
      return bool;
    }
    paramc.a(paramInt, b("fail"));
    return false;
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiSearchContacts", "data is null, err");
      paramc.a(paramInt, b("fail:invalid data"));
      return;
    }
    o.d("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
    o.e("MicroMsg.JsApiSearchContacts", "data:%s", new Object[] { paramJSONObject });
    Object localObject1 = paramc.getContext();
    if ((localObject1 != null) && ((localObject1 instanceof Activity)))
    {
      if (!b(paramc, paramJSONObject, paramInt))
      {
        o.d("MicroMsg.JsApiSearchContacts", "check permission");
        return;
      }
      paramJSONObject = paramJSONObject.optString("phoneNumber");
      if (paramJSONObject.length() < 8)
      {
        o.b("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
        paramJSONObject = new HashMap();
        paramJSONObject.put("result", "");
        paramc.a(paramInt, a("ok", paramJSONObject));
        return;
      }
      if (this.a == null) {
        this.a = a((Context)localObject1);
      }
      if (this.a == null)
      {
        o.b("MicroMsg.JsApiSearchContacts", "addressList is null, err");
        paramc.a(paramInt, b("fail"));
        return;
      }
      localObject1 = new JSONArray();
      Object localObject2 = this.a;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject2 = this.a.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (String[])((Iterator)localObject2).next();
          String str = a(localObject3[2]);
          localObject3 = af.a(localObject3[1], "");
          if ((!af.c(str)) && (a(paramJSONObject, str))) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("phoneNumber", str);
              localJSONObject.put("name", localObject3);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (JSONException localJSONException)
            {
              o.a("MicroMsg.JsApiSearchContacts", localJSONException, "", new Object[0]);
            }
          }
        }
      }
      o.e("MicroMsg.JsApiSearchContacts", "resultArray:%s", new Object[] { ((JSONArray)localObject1).toString() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("result", ((JSONArray)localObject1).toString());
      paramc.a(paramInt, a("ok", paramJSONObject));
      return;
    }
    o.b("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", new Object[] { paramc.getAppId() });
    paramc.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.e
 * JD-Core Version:    0.7.0.1
 */