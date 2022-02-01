package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.util.Pair;
import com.tencent.luggage.wxa.qz.af;
import java.util.Iterator;
import java.util.List;
import java.util.List<+Landroid.util.Pair<Ljava.lang.String;Ljava.lang.String;>;>;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"serviceScope", "", "categories", "", "Landroid/util/Pair;", "luggage-standalone-open-runtime-sdk_release"}, k=2, mv={1, 1, 16})
public final class d
{
  private static final String b(List<? extends Pair<String, String>> paramList)
  {
    Object localObject2 = "";
    if (paramList == null) {
      return "";
    }
    Object localObject1 = localObject2;
    if (af.c(""))
    {
      localObject1 = localObject2;
      if (!af.a(paramList))
      {
        localObject1 = new StringBuilder();
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramList = (Pair)((Iterator)localObject2).next();
          if (af.c((String)paramList.second)) {
            paramList = paramList.first;
          } else {
            paramList = paramList.second;
          }
          paramList = (String)paramList;
          if (!af.c(paramList))
          {
            ((StringBuilder)localObject1).append("、");
            ((StringBuilder)localObject1).append(paramList);
          }
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "sb.toString()");
        paramList = (List<? extends Pair<String, String>>)localObject1;
        if (!af.c((String)localObject1))
        {
          paramList = (CharSequence)localObject1;
          paramList = new Regex("、").replaceFirst(paramList, "");
        }
        localObject1 = paramList;
      }
    }
    paramList = af.b((String)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "Util.nullAsNil(ret)");
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.d
 * JD-Core Version:    0.7.0.1
 */