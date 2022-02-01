package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/RIJXTabConfigHandler$Companion;", "", "()V", "RED_DOT_DEFAULT_EXPIRED_TIME_IN_MIN", "", "SP_DEFAULT_TAB_ID", "", "SP_RED_DOT_EXPIRE_TIME_IN_MIN", "SP_TAB_INFO_JSON", "SP_X_TAB_MODE_SWITCH_KEY", "TAG", "instance", "Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/RIJXTabConfigHandler;", "getInstance", "()Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/RIJXTabConfigHandler;", "setInstance", "(Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/RIJXTabConfigHandler;)V", "get", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabConfigHandler$Companion
{
  private final void a(RIJXTabConfigHandler paramRIJXTabConfigHandler)
  {
    RIJXTabConfigHandler.a(paramRIJXTabConfigHandler);
  }
  
  private final RIJXTabConfigHandler b()
  {
    if (RIJXTabConfigHandler.a() != null)
    {
      localObject = RIJXTabConfigHandler.a();
      if (localObject == null) {
        break label53;
      }
    }
    label53:
    for (Object localObject = RIJXTabConfigHandler.a((RIJXTabConfigHandler)localObject);; localObject = null)
    {
      if (!TextUtils.equals((CharSequence)localObject, (CharSequence)ReadInJoyHelper.a())) {
        RIJXTabConfigHandler.a.a(new RIJXTabConfigHandler(null));
      }
      return RIJXTabConfigHandler.a();
    }
  }
  
  @JvmStatic
  @NotNull
  public final RIJXTabConfigHandler a()
  {
    try
    {
      RIJXTabConfigHandler localRIJXTabConfigHandler1 = ((Companion)this).b();
      if (localRIJXTabConfigHandler1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler");
      }
    }
    finally {}
    return localRIJXTabConfigHandler2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler.Companion
 * JD-Core Version:    0.7.0.1
 */