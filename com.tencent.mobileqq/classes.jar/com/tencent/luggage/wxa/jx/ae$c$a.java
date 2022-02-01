package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.lw;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.sj.g;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader$load$runnable$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ae$c$a
  implements g
{
  ae$c$a(Function1 paramFunction11, Function1 paramFunction12, Function1 paramFunction13, Function0 paramFunction0) {}
  
  @NotNull
  public String a()
  {
    return "Luggage.FULL.JsApiBatchGetContact.Loader";
  }
  
  public void run()
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = new LinkedList();
    for (;;)
    {
      try
      {
        Object localObject3 = new HashSet((Collection)ae.c.a(this.a));
        Object localObject1 = u.a().a(ae.c.a(this.a), new String[] { "appId", "appInfo", "syncVersion", "syncTimeSecond" });
        if (localObject1 != null)
        {
          Object localObject4 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject1 = (s)((Iterator)localObject4).next();
            Object localObject5 = (CharSequence)((s)localObject1).n;
            if (localObject5 == null) {
              break label570;
            }
            if (((CharSequence)localObject5).length() == 0)
            {
              break label570;
              if (i != 0) {
                continue;
              }
              ((HashSet)localObject3).remove(((s)localObject1).d);
              localLinkedList.add(localObject1);
              if (af.b(((s)localObject1).t) <= ae.c.b(this.a)) {
                continue;
              }
              localObject5 = new lw();
              ((lw)localObject5).c = ((s)localObject1).d;
              localObject1 = ((s)localObject1).u;
              if (localObject1 != null)
              {
                Charset localCharset = Charsets.UTF_8;
                if (localObject1 != null)
                {
                  localObject1 = ((String)localObject1).getBytes(localCharset);
                  Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
                  if (localObject1 != null) {
                    continue;
                  }
                }
                else
                {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
              }
              localObject1 = new byte[0];
              ((lw)localObject5).b = new b((byte[])localObject1);
              ((LinkedList)localObject2).add(localObject5);
            }
          }
          else
          {
            localObject1 = ((Iterable)localObject3).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = (String)((Iterator)localObject1).next();
              localObject4 = new lw();
              ((lw)localObject4).c = ((String)localObject3);
              ((lw)localObject4).b = new b(new byte[0]);
              ((LinkedList)localObject2).add(localObject4);
              continue;
            }
            if (localLinkedList.size() == ae.c.a(this.a).size()) {
              this.c.invoke(localLinkedList);
            }
            if (!((Collection)localObject2).isEmpty())
            {
              ae.c();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Loader(");
              ((StringBuilder)localObject1).append(ae.c.c(this.a));
              ((StringBuilder)localObject1).append(").waitForBatchCgiUpdate requestList.size:");
              ((StringBuilder)localObject1).append(((LinkedList)localObject2).size());
              o.d("Luggage.FULL.JsApiBatchGetContact", ((StringBuilder)localObject1).toString());
              localObject1 = this.a;
              ae.c.a((ae.c)localObject1, ae.c.d((ae.c)localObject1), (List)localObject2, (Function1)new ae.c.a.a(this), this.b);
              return;
            }
            this.e.invoke();
          }
        }
        else
        {
          this.b.invoke("get contact fail");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ae.c();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Loader(");
        ((StringBuilder)localObject2).append(this.a.hashCode());
        ((StringBuilder)localObject2).append(").run(), make callback array e=");
        ((StringBuilder)localObject2).append(localJSONException);
        o.b("Luggage.FULL.JsApiBatchGetContact", ((StringBuilder)localObject2).toString());
        this.b.invoke("get contact json error");
        return;
      }
      int i = 0;
      continue;
      label570:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.c.a
 * JD-Core Version:    0.7.0.1
 */