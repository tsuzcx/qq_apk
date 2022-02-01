package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "PHONE_ITEMS", "", "TAG", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "addPhone", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getPhoneNumbers", "", "process", "phoneItems", "oldPhoneItems", "removePhone", "delPhoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savePhoneNumbers", "selectPhone", "updatePhoneItem", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class s
{
  public static final s a = new s();
  private static final w b = w.b();
  
  @NotNull
  public final List<r> a()
  {
    Object localObject1 = b.getString("PhoneItemsManager#PhoneItems", "{}");
    Object localObject2;
    try
    {
      localObject1 = new JSONArray((String)localObject1);
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.PhoneItemsManager", "e:%s", new Object[] { localException });
      localObject2 = null;
    }
    ArrayList localArrayList = new ArrayList();
    if (localObject2 != null)
    {
      int j = localObject2.length();
      int i = 0;
      while (i < j)
      {
        Object localObject3 = r.a;
        String str = localObject2.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(str, "jsonArray.getString(i)");
        localObject3 = ((r.a)localObject3).a(str);
        if (localObject3 != null) {
          localArrayList.add(localObject3);
        }
        i += 1;
      }
    }
    o.e("MicroMsg.PhoneItemsManager", "get %s", new Object[] { String.valueOf(localObject2) });
    return (List)localArrayList;
  }
  
  @Nullable
  public final List<r> a(@Nullable List<r> paramList1, @Nullable List<r> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 != null)
      {
        Iterator localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          r localr1 = (r)localIterator.next();
          if (localr1.j())
          {
            localIterator = paramList1.iterator();
            while (localIterator.hasNext())
            {
              r localr2 = (r)localIterator.next();
              if (Intrinsics.areEqual(localr1.b(), localr2.b()))
              {
                localr2.b(true);
                i = 1;
                break label105;
              }
            }
          }
        }
      }
      int i = 0;
      label105:
      if ((i == 0) && (paramList1.size() >= 1)) {
        ((r)paramList1.get(0)).b(true);
      }
      o.f("MicroMsg.PhoneItemsManager", "init oldphoneItems:%s", new Object[] { paramList2 });
      o.f("MicroMsg.PhoneItemsManager", "init phoneItems:%s", new Object[] { paramList1 });
      return paramList1;
    }
    return null;
  }
  
  public final void a(@Nullable r paramr)
  {
    List localList = a();
    if (paramr != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((r)localIterator.next()).b(false);
      }
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        r localr = (r)localIterator.next();
        if (Intrinsics.areEqual(paramr.b(), localr.b())) {
          localr.b(true);
        }
      }
    }
    a(localList);
    o.f("MicroMsg.PhoneItemsManager", "uninit phoneItems:%s", new Object[] { localList });
  }
  
  public final void a(@Nullable ArrayList<r> paramArrayList)
  {
    if (paramArrayList == null) {}
    try
    {
      o.c("MicroMsg.PhoneItemsManager", "delPhoneItems is null");
      return;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          throw paramArrayList;
        }
        int i = 0;
      }
    }
    localObject = a();
    if (localObject != null)
    {
      localObject = (ArrayList)localObject;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((ArrayList)localObject).remove((r)paramArrayList.next());
      }
      paramArrayList = ((ArrayList)localObject).iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
      } while (!((r)paramArrayList.next()).j());
      i = 1;
      if ((i == 0) && (((ArrayList)localObject).size() >= 1)) {
        ((r)((ArrayList)localObject).get(0)).b(true);
      }
      o.f("MicroMsg.PhoneItemsManager", "remove phoneItems:%s", new Object[] { localObject });
      a((List)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem>");
  }
  
  public final void a(@Nullable List<r> paramList)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(((r)paramList.next()).a());
      }
      paramList = b;
      if (paramList != null) {
        paramList.putString("PhoneItemsManager#PhoneItems", localJSONArray.toString());
      }
      paramList = b;
      if (paramList != null) {
        paramList.commit();
      }
    }
  }
  
  public final void b(@NotNull r paramr)
  {
    Intrinsics.checkParameterIsNotNull(paramr, "phoneItem");
    Object localObject = a();
    if (localObject != null)
    {
      localObject = (ArrayList)localObject;
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext()) {
        ((r)localIterator.next()).b(false);
      }
      if (((ArrayList)localObject).contains(paramr)) {
        ((ArrayList)localObject).set(((ArrayList)localObject).indexOf(paramr), paramr);
      } else {
        ((ArrayList)localObject).add(paramr);
      }
      a((List)localObject);
      return;
    }
    paramr = new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem>");
    for (;;)
    {
      throw paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.s
 * JD-Core Version:    0.7.0.1
 */