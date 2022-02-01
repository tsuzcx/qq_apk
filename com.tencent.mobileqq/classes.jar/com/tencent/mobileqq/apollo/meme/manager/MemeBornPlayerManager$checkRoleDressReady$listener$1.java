package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/meme/manager/MemeBornPlayerManager$checkRoleDressReady$listener$1", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "needDownloadUinList", "", "", "getNeedDownloadUinList", "()Ljava/util/List;", "onDownLoadFinish", "", "success", "", "uin", "roleId", "", "dressIds", "", "actionId", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeBornPlayerManager$checkRoleDressReady$listener$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  @NotNull
  private final List<String> c = (List)new ArrayList();
  
  MemeBornPlayerManager$checkRoleDressReady$listener$1(MemeBornPlayerManager.ActionItem paramActionItem, String paramString) {}
  
  @NotNull
  public final List<String> a()
  {
    return this.c;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2)
  {
    paramArrayOfInt = new StringBuilder();
    paramArrayOfInt.append("checkRoleDressReady onDownloadFinish ");
    paramArrayOfInt.append(this.a.c().h());
    paramArrayOfInt.append(", ");
    paramArrayOfInt.append(paramBoolean);
    paramArrayOfInt.append(", ");
    paramArrayOfInt.append(paramString);
    QLog.i("[cmshow][MemePlayer]MemeBornPlayerManager", 1, paramArrayOfInt.toString());
    if (paramBoolean)
    {
      if (CollectionsKt.contains((Iterable)this.c, paramString))
      {
        paramArrayOfInt = (Collection)this.c;
        if (paramArrayOfInt != null) {
          TypeIntrinsics.asMutableCollection(paramArrayOfInt).remove(paramString);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
      }
      if ((this.c.isEmpty()) && (MemeBornPlayerManager.a(MemeBornPlayerManager.a).containsKey(this.b)))
      {
        paramString = new StringBuilder();
        paramString.append("checkRoleDressReady resume record ");
        paramString.append(this.a.c().h());
        QLog.i("[cmshow][MemePlayer]MemeBornPlayerManager", 1, paramString.toString());
        paramString = MemeBornPlayerManager.a;
        paramArrayOfInt = MemeBornPlayerManager.a(MemeBornPlayerManager.a).remove(this.b);
        if (paramArrayOfInt == null) {
          Intrinsics.throwNpe();
        }
        MemeBornPlayerManager.a(paramString, (MemeBornPlayerManager.ActionItem)paramArrayOfInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager.checkRoleDressReady.listener.1
 * JD-Core Version:    0.7.0.1
 */