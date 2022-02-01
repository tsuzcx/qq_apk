package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.iw;
import com.tencent.luggage.wxa.qw.ix;
import com.tencent.luggage.wxa.qw.ld;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/UpdateWxaUsageRecord;", "", "()V", "TAG", "", "URL", "addUsage", "", "username", "appId", "versionType", "", "visitSessionId", "visitScene", "toLogString", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaUsageRecordResponse;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class n
{
  public static final n a = new n();
  
  private final String a(@Nullable ix paramix)
  {
    if ((paramix != null) && (paramix.a != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{ErrCode=");
      localStringBuilder.append(paramix.a.a);
      localStringBuilder.append(", ErrMsg=");
      localStringBuilder.append(paramix.a.b);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    return "NULL";
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, @Nullable String paramString3, int paramInt2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      Object localObject = (CharSequence)i.a.e();
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        paramString3 = new StringBuilder();
        paramString3.append("addUsage while no user logged in. username=");
        paramString3.append(paramString1);
        paramString3.append(", appId=");
        paramString3.append(paramString2);
        paramString3.append(", versionType=");
        paramString3.append(paramInt1);
        paramString3.append(", visitSessionId=");
        paramString3.append(paramInt2);
        paramString3.append(", visitScene=");
        paramString3.append(paramInt2);
        o.c("WMPF.UpdateWxaUsageRecord", paramString3.toString());
        return;
      }
      localObject = new iw();
      ((iw)localObject).a = paramInt2;
      ((iw)localObject).b = 0;
      ((iw)localObject).c = paramInt1;
      ((iw)localObject).d = 2;
      ((iw)localObject).e = 1;
      ((iw)localObject).f = paramString1;
      ((iw)localObject).g = 0;
      ((iw)localObject).h = paramString3;
      ((b)e.a(b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord", paramString2, (a)localObject, ix.class).a((e.c)new n.a(paramString1, paramString2, paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.n
 * JD-Core Version:    0.7.0.1
 */