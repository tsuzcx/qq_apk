package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it1", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;", "it2", "compare"}, k=3, mv={1, 1, 16})
final class CMSBornPlayerManager$recordActionQueue$1<T>
  implements Comparator<CMSBornPlayerManager.ActionItem>
{
  public static final 1 a = new 1();
  
  public final int a(@NotNull CMSBornPlayerManager.ActionItem paramActionItem1, @NotNull CMSBornPlayerManager.ActionItem paramActionItem2)
  {
    Intrinsics.checkParameterIsNotNull(paramActionItem1, "it1");
    Intrinsics.checkParameterIsNotNull(paramActionItem2, "it2");
    if (paramActionItem1.a().b() > paramActionItem2.a().b()) {
      return 1;
    }
    if (paramActionItem1.a().b() < paramActionItem2.a().b()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.recordActionQueue.1
 * JD-Core Version:    0.7.0.1
 */