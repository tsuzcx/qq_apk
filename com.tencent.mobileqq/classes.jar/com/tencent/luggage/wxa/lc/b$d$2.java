package com.tencent.luggage.wxa.lc;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ih.c;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.mm.msgsubscription.ui.a.a.a;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$dealWithCgiResult$1$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "onSampleShow", "", "templateId", "", "check", "", "index", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$d$2
  implements a.a.a
{
  public void a(@NotNull String paramString, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateId");
    Iterator localIterator = ((Iterable)this.a.b.c()).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (TextUtils.equals((CharSequence)((d)localObject).c(), (CharSequence)paramString))
      {
        paramString = (String)localObject;
        break label74;
      }
    }
    paramString = null;
    label74:
    if ((d)paramString != null)
    {
      paramString = this.a.e;
      localObject = (Integer)this.a.e.get(Integer.valueOf(paramInt));
      int i;
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      } else {
        i = 0;
      }
      paramString.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.b.d.2
 * JD-Core Version:    0.7.0.1
 */