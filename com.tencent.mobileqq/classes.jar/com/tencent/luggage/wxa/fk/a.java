package com.tencent.luggage.wxa.fk;

import com.tencent.luggage.wxa.en.b;
import com.tencent.luggage.wxa.en.b.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import com.tencent.xweb.p.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/runtime/WxaAppProcessSharedPreloader;", "Lcom/tencent/luggage/standalone_ext/boost/RuntimePreloader;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "()V", "TAG", "", "done", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  extends b<com.tencent.luggage.wxa.standalone_open_runtime.service.a, e>
{
  public static final a a = new a();
  
  private a()
  {
    super((b.a)a.1.a, (b.a)a.2.a);
  }
  
  protected void c()
  {
    super.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("done(), webview type:");
    localStringBuilder.append(WebView.getCurWebType());
    o.d("Luggage.WxaAppProcessSharedPreloader", localStringBuilder.toString());
    if (!WebView.isXWalk()) {
      p.a((p.a)new a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fk.a
 * JD-Core Version:    0.7.0.1
 */