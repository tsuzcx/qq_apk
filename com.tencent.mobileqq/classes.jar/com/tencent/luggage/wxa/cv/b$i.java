package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.dw;
import com.tencent.luggage.wxa.qw.eh;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPISetAuthResponse;", "onTerminate"}, k=3, mv={1, 1, 16})
final class b$i<T>
  implements e.c<eh>
{
  b$i(dw paramdw) {}
  
  public final void a(@Nullable eh parameh)
  {
    b.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doSetJSAuth result:(");
    if (parameh != null)
    {
      aa localaa = parameh.a();
      if (localaa != null)
      {
        i = localaa.a;
        break label45;
      }
    }
    int i = -1;
    label45:
    localStringBuilder.append(i);
    localStringBuilder.append(", ");
    if (parameh != null)
    {
      parameh = parameh.a();
      if (parameh != null)
      {
        parameh = parameh.b;
        break label81;
      }
    }
    parameh = null;
    label81:
    localStringBuilder.append(parameh);
    localStringBuilder.append(") with api:");
    localStringBuilder.append(this.a.c);
    localStringBuilder.append(", url:");
    localStringBuilder.append(this.a.a);
    o.d("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.i
 * JD-Core Version:    0.7.0.1
 */