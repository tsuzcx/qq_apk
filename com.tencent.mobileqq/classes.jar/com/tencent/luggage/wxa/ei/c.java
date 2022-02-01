package com.tencent.luggage.wxa.ei;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.util.PresentationActivityHelper;
import com.tencent.luggage.util.PresentationActivityHelper.a;
import com.tencent.luggage.wxa.ih.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/presenter/WxaSubscribeMsgSettingPagePresenter;", "Lcom/tencent/luggage/setting/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "changed", "", "subscribeMsgSettingData", "Lcom/tencent/luggage/setting/entity/SubscribeMsgSettingData;", "dispatchLoadDataResult", "", "l", "Lcom/tencent/luggage/setting/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "getCheckBoxState", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "loadData", "bizUsername", "", "appId", "onActivityCreated", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeSwitchChanged", "on", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends a
{
  public static final c.a a = new c.a(null);
  private Activity b;
  private com.tencent.luggage.wxa.eh.c c;
  private boolean d;
  
  private final void a(b.a parama, com.tencent.luggage.wxa.eh.c paramc)
  {
    if (paramc == null)
    {
      parama.a();
      return;
    }
    parama.a(paramc);
  }
  
  public void a(@NotNull d paramd, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull b.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "bizUsername");
    Intrinsics.checkParameterIsNotNull(paramString2, "appId");
    Intrinsics.checkParameterIsNotNull(parama, "l");
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("activity");
    }
    this.c = ((com.tencent.luggage.wxa.eh.c)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    localObject = this.c;
    if (localObject == null)
    {
      com.tencent.luggage.wxa.ej.a.a.a(paramString1, paramString2, (Function1)new c.b(this, parama));
      return;
    }
    a(parama, (com.tencent.luggage.wxa.eh.c)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = true;
    com.tencent.luggage.wxa.eh.c localc = this.c;
    if (localc != null) {
      localc.a(paramBoolean);
    }
  }
  
  public boolean a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "item");
    return paramd.g() == 1;
  }
  
  public void f(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    super.f(paramActivity);
    this.b = paramActivity;
  }
  
  public void g(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if ((this.d) && (this.c != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_biz_data", (Parcelable)this.c);
      if ((paramActivity instanceof LuggageActivityHelper.ILuggageActivityHelper))
      {
        PresentationActivityHelper.a locala = PresentationActivityHelper.Companion;
        paramActivity = paramActivity.getIntent();
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "activity.getIntent()");
        locala.a(-1, paramActivity, localIntent);
        return;
      }
      paramActivity.setResult(-1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ei.c
 * JD-Core Version:    0.7.0.1
 */