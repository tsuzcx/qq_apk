package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.ee.a;
import com.tencent.luggage.wxa.ee.a.b;
import com.tencent.luggage.wxa.qw.et;
import com.tencent.luggage.wxa.qw.jc;
import com.tencent.luggage.wxa.qw.jd;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.k;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$3$1$1$provider$1", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class j$c$1$a
  implements a
{
  j$c$1$a(j.c.1 param1) {}
  
  @Nullable
  public String a()
  {
    Object localObject = this.a.c.k;
    if (localObject != null)
    {
      localObject = ((jc)localObject).a;
      if (localObject != null)
      {
        localObject = (jd)((LinkedList)localObject).peekFirst();
        if (localObject != null) {
          return ((jd)localObject).b;
        }
      }
    }
    return null;
  }
  
  public void a(@NotNull a.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "callback");
    Object localObject = this.a.c.k;
    if (localObject != null)
    {
      localObject = ((jc)localObject).a;
      if (localObject != null)
      {
        localObject = (jd)((LinkedList)localObject).peekFirst();
        if (localObject != null)
        {
          localObject = ((jd)localObject).c;
          break label52;
        }
      }
    }
    localObject = null;
    label52:
    CharSequence localCharSequence = (CharSequence)localObject;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      AppBrandSimpleImageLoader.instance().load((AppBrandSimpleImageLoader.k)new j.c.1.a.1(paramb), (String)localObject, null);
      return;
    }
    paramb.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.j.c.1.a
 * JD-Core Version:    0.7.0.1
 */