package com.tencent.luggage.wxa.kr;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 226;
  public static final String NAME = "addPhoneContact";
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap.getByteCount() <= 819200) {
      return paramBitmap;
    }
    for (;;)
    {
      paramBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2, false);
      try
      {
        localBitmap.recycle();
        label35:
        if (paramBitmap != null)
        {
          if (paramBitmap.getByteCount() <= 819200) {
            return paramBitmap;
          }
          localBitmap = paramBitmap;
          continue;
        }
        return paramBitmap;
      }
      catch (Throwable localThrowable)
      {
        break label35;
      }
    }
  }
  
  private a.a a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("Country");
    localObject1 = paramJSONObject.optString(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("State");
    localObject2 = paramJSONObject.optString(((StringBuilder)localObject2).toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("City");
    localObject3 = paramJSONObject.optString(((StringBuilder)localObject3).toString());
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append("Street");
    localObject4 = paramJSONObject.optString(((StringBuilder)localObject4).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("PostalCode");
    return new a.a((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, paramJSONObject.optString(localStringBuilder.toString()));
  }
  
  private a a(JSONObject paramJSONObject)
  {
    a locala = new a();
    locala.b(paramJSONObject.optString("photoFilePath"));
    locala.a(paramJSONObject.optString("nickName"));
    locala.a(new a.b(paramJSONObject.optString("firstName"), paramJSONObject.optString("middleName"), paramJSONObject.optString("lastName")));
    locala.i(paramJSONObject.optString("remark"));
    locala.c(paramJSONObject.optString("mobilePhoneNumber"));
    locala.n(paramJSONObject.optString("weChatNumber"));
    locala.c(a(paramJSONObject, "address"));
    locala.k(paramJSONObject.optString("organization"));
    locala.h(paramJSONObject.optString("title"));
    locala.l(paramJSONObject.optString("workFaxNumber"));
    locala.f(paramJSONObject.optString("workPhoneNumber"));
    locala.e(paramJSONObject.optString("hostNumber"));
    locala.g(paramJSONObject.optString("email"));
    locala.j(paramJSONObject.optString("url"));
    locala.b(a(paramJSONObject, "workAddress"));
    locala.m(paramJSONObject.optString("homeFaxNumber"));
    locala.d(paramJSONObject.optString("homePhoneNumber"));
    locala.a(a(paramJSONObject, "homeAddress"));
    return locala;
  }
  
  private void a(Activity paramActivity, a parama, c paramc, int paramInt)
  {
    String str1 = paramActivity.getString(2131891472);
    String str2 = paramActivity.getString(2131891471);
    MMBottomSheet localMMBottomSheet = new MMBottomSheet(paramActivity, 1, false);
    localMMBottomSheet.setOnCreateMenuListener(new b.2(this, new String[] { str1, str2 }));
    localMMBottomSheet.setOnMenuSelectedListener(new b.3(this, parama, paramActivity, paramc, paramInt));
    localMMBottomSheet.tryShow();
  }
  
  private void a(Intent paramIntent, a parama, Activity paramActivity, c paramc)
  {
    paramIntent.setFlags(268435456);
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, parama, paramIntent);
    if (!af.c(parama.b())) {
      c(localArrayList, parama.b(), 1);
    }
    if (!af.c(parama.m())) {
      a(localArrayList, parama.m());
    }
    Object localObject;
    if ((!af.c(parama.o())) || (!af.c(parama.l())))
    {
      localObject = new ContentValues();
      ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/organization");
      if (!af.c(parama.o())) {
        ((ContentValues)localObject).put("data1", parama.o());
      }
      if (!af.c(parama.l())) {
        ((ContentValues)localObject).put("data4", parama.l());
      }
      ((ContentValues)localObject).put("data2", Integer.valueOf(1));
      localArrayList.add(localObject);
    }
    if (!af.c(parama.n())) {
      b(localArrayList, parama.n(), 1);
    }
    if (!af.c(parama.k())) {
      paramIntent.putExtra("email", parama.k());
    }
    if (!af.c(parama.g())) {
      a(localArrayList, parama.g(), 2);
    }
    if (!af.c(parama.h())) {
      a(localArrayList, parama.h(), 1);
    }
    if (!af.c(parama.j())) {
      a(localArrayList, parama.j(), 3);
    }
    if (!af.c(parama.i())) {
      a(localArrayList, parama.i(), 10);
    }
    if (!af.c(parama.q())) {
      a(localArrayList, parama.q(), 5);
    }
    if (!af.c(parama.p())) {
      a(localArrayList, parama.p(), 4);
    }
    a(localArrayList, parama.f(), 3);
    a(localArrayList, parama.e(), 2);
    a(localArrayList, parama.d(), 1);
    if (!af.c(parama.r())) {
      a(localArrayList, parama.r(), -1, paramActivity.getString(2131886912));
    }
    parama = paramc.getFileSystem().g(parama.c());
    if ((parama != null) && (parama.j())) {}
    try
    {
      paramActivity = MMBitmapFactory.a(parama.l());
      if (paramActivity != null)
      {
        paramActivity = a(paramActivity);
        if (paramActivity != null)
        {
          paramc = new ByteArrayOutputStream();
          paramActivity.compress(Bitmap.CompressFormat.JPEG, 100, paramc);
          localObject = paramc.toByteArray();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("mimetype", "vnd.android.cursor.item/photo");
          localContentValues.put("data15", (byte[])localObject);
          localArrayList.add(localContentValues);
          try
          {
            paramc.close();
          }
          catch (Throwable paramc)
          {
            com.tencent.luggage.wxa.qz.o.a("MicroMsg.JsApiAddPhoneContact", paramc, "processContactIntent, close avatar stream", new Object[0]);
          }
        }
      }
    }
    catch (OutOfMemoryError paramActivity)
    {
      label546:
      label563:
      break label546;
    }
    try
    {
      paramActivity.recycle();
    }
    catch (Throwable parama)
    {
      break label563;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiAddPhoneContact", "processContactIntent, put avatar bitmap oom, file=%s", new Object[] { parama });
    paramIntent.putParcelableArrayListExtra("data", localArrayList);
  }
  
  private void a(ArrayList<ContentValues> paramArrayList, a.a parama, int paramInt)
  {
    if ((parama != null) && (parama.b().length() > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data1", parama.b());
      localContentValues.put("data9", parama.a());
      localContentValues.put("data2", Integer.valueOf(paramInt));
      paramArrayList.add(localContentValues);
    }
  }
  
  private void a(ArrayList<ContentValues> paramArrayList, a parama, Intent paramIntent)
  {
    paramArrayList = parama.a().a();
    if (!af.c(paramArrayList))
    {
      paramIntent.putExtra("name", paramArrayList);
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiAddPhoneContact", "no contact user name");
  }
  
  private void a(ArrayList<ContentValues> paramArrayList, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", "vnd.android.cursor.item/note");
    localContentValues.put("data1", paramString);
    paramArrayList.add(localContentValues);
  }
  
  private void a(ArrayList<ContentValues> paramArrayList, String paramString, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
    localContentValues.put("data1", paramString);
    localContentValues.put("data2", Integer.valueOf(paramInt));
    paramArrayList.add(localContentValues);
  }
  
  private void a(ArrayList<ContentValues> paramArrayList, String paramString1, int paramInt, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", "vnd.android.cursor.item/im");
    localContentValues.put("data1", paramString1);
    localContentValues.put("data5", Integer.valueOf(paramInt));
    localContentValues.put("data6", paramString2);
    paramArrayList.add(localContentValues);
  }
  
  private static void b(Intent paramIntent)
  {
    try
    {
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("data");
      Object localObject2 = null;
      Iterator localIterator = localArrayList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (ContentValues)localIterator.next();
      } while (!((ContentValues)localObject1).containsKey("data15"));
      if (localObject1 != null) {
        localArrayList.remove(localObject1);
      }
      paramIntent.putParcelableArrayListExtra("data", localArrayList);
      return;
    }
    catch (Throwable paramIntent)
    {
      com.tencent.luggage.wxa.qz.o.a("MicroMsg.JsApiAddPhoneContact", paramIntent, "removeContactAvatarDataFromIntent", new Object[0]);
    }
  }
  
  private void b(ArrayList<ContentValues> paramArrayList, String paramString, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", "vnd.android.cursor.item/website");
    localContentValues.put("data1", paramString);
    localContentValues.put("data2", Integer.valueOf(paramInt));
    paramArrayList.add(localContentValues);
  }
  
  private void c(ArrayList<ContentValues> paramArrayList, String paramString, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", "vnd.android.cursor.item/nickname");
    localContentValues.put("data1", paramString);
    localContentValues.put("data2", Integer.valueOf(paramInt));
    paramArrayList.add(localContentValues);
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data is null"));
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiAddPhoneContact", "data is null");
      return;
    }
    if (af.c(paramJSONObject.optString("firstName")))
    {
      paramc.a(paramInt, b("fail:firstName is null"));
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiAddPhoneContact", "firstName is null");
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext != null) && ((localContext instanceof Activity)))
    {
      paramc.a(new b.1(this, localContext, a(paramJSONObject), paramc, paramInt));
      return;
    }
    paramc.a(paramInt, b("fail"));
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.b
 * JD-Core Version:    0.7.0.1
 */