package com.tencent.luggage.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.rt.i;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaPreviewImageUI$Companion;", "", "()V", "KEY_CURRENT_INDEX", "", "KEY_URLS", "NETWORK_CACHE_DIR", "Lcom/tencent/mm/vfs/VFSFile;", "getNETWORK_CACHE_DIR", "()Lcom/tencent/mm/vfs/VFSFile;", "TAG", "show", "", "context", "Landroid/content/Context;", "urls", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "currentIndex", "", "callback", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultCallback;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaPreviewImageUI$a
{
  private final i a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a.d());
    ((StringBuilder)localObject).append("wxacache/");
    localObject = new i(((StringBuilder)localObject).toString());
    ((i)localObject).u();
    return localObject;
  }
  
  public final void a(@Nullable Context paramContext, @NotNull ArrayList<String> paramArrayList, int paramInt, @NotNull LuggageActivityHelper.ActivityResultCallback paramActivityResultCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "urls");
    Intrinsics.checkParameterIsNotNull(paramActivityResultCallback, "callback");
    if (((Collection)paramArrayList).isEmpty()) {
      return;
    }
    Intent localIntent = new Intent(paramContext, WxaPreviewImageUI.class);
    localIntent.putStringArrayListExtra("KEY_URLS", paramArrayList);
    localIntent.putExtra("KEY_CURRENT_INDEX", paramInt);
    LuggageActivityHelper.FOR(paramContext).startActivityForResult(localIntent, paramActivityResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.a
 * JD-Core Version:    0.7.0.1
 */