package com.tencent.biz.pubaccount.weishi_new.instancestate;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/instancestate/WSInstanceStateManager;", "Lcom/tencent/biz/pubaccount/weishi_new/instancestate/IWSInstanceState;", "()V", "onSaveInstanceState", "", "outState", "Landroid/os/Bundle;", "onViewStateRestored", "savedInstanceState", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSInstanceStateManager
  implements IWSInstanceState
{
  public static final WSInstanceStateManager.Companion a = new WSInstanceStateManager.Companion(null);
  
  public void a(@Nullable Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onSaveInstanceState] outState = ");
    ((StringBuilder)localObject1).append(paramBundle);
    WSLog.e("WSInstanceStateManager", ((StringBuilder)localObject1).toString());
    if (paramBundle == null) {
      return;
    }
    localObject1 = WSInstanceStateConstants.a.a().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (IWSInstanceStateOperation)((Iterator)localObject1).next();
      String str = ((IWSInstanceStateOperation)localObject2).a();
      localObject2 = ((IWSInstanceStateOperation)localObject2).b();
      paramBundle.putString(str, (String)localObject2);
      WSSharePreferencesUtil.a(str, (String)localObject2);
    }
  }
  
  public void b(@Nullable Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onViewStateRestored] savedInstanceState = ");
    ((StringBuilder)localObject1).append(paramBundle);
    WSLog.e("WSInstanceStateManager", ((StringBuilder)localObject1).toString());
    Object localObject2;
    String str;
    Object localObject3;
    if (paramBundle == null)
    {
      paramBundle = ((Iterable)WSInstanceStateConstants.a.a()).iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (IWSInstanceStateOperation)paramBundle.next();
        localObject1 = ((IWSInstanceStateOperation)localObject2).a();
        str = ((IWSInstanceStateOperation)localObject2).b();
        if (TextUtils.isEmpty((CharSequence)str))
        {
          localObject3 = WSSharePreferencesUtil.b((String)localObject1, "");
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "spValue");
          ((IWSInstanceStateOperation)localObject2).a((String)localObject3);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[onViewStateRestored] key = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", value = ");
          ((StringBuilder)localObject2).append(str);
          WSLog.e("WSInstanceStateManager", ((StringBuilder)localObject2).toString());
        }
      }
      return;
    }
    localObject1 = ((Iterable)WSInstanceStateConstants.a.a()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (IWSInstanceStateOperation)((Iterator)localObject1).next();
      str = ((IWSInstanceStateOperation)localObject3).a();
      localObject2 = paramBundle.getString(str);
      CharSequence localCharSequence = (CharSequence)localObject2;
      int i;
      if ((localCharSequence != null) && (!StringsKt.isBlank(localCharSequence))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        ((IWSInstanceStateOperation)localObject3).a((String)localObject2);
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[onViewStateRestored] key = ");
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(", value = ");
      ((StringBuilder)localObject3).append((String)localObject2);
      WSLog.e("WSInstanceStateManager", ((StringBuilder)localObject3).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.instancestate.WSInstanceStateManager
 * JD-Core Version:    0.7.0.1
 */