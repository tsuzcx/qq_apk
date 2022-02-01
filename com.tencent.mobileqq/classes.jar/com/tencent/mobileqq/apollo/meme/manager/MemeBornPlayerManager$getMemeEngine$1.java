package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"findFrom", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "list", "", "Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer;", "invoke"}, k=3, mv={1, 1, 16})
final class MemeBornPlayerManager$getMemeEngine$1
  extends Lambda
  implements Function1<List<? extends MemeBornPlayer>, ICMShowEngine>
{
  public static final 1 INSTANCE = new 1();
  
  MemeBornPlayerManager$getMemeEngine$1()
  {
    super(1);
  }
  
  @Nullable
  public final ICMShowEngine invoke(@NotNull List<MemeBornPlayer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    Iterator localIterator = ((Iterable)paramList).iterator();
    do
    {
      do
      {
        boolean bool = localIterator.hasNext();
        paramList = null;
        if (!bool) {
          break;
        }
        SpriteScriptManager localSpriteScriptManager = ((MemeBornPlayer)localIterator.next()).b();
        if (localSpriteScriptManager != null) {
          paramList = localSpriteScriptManager.getSpriteContext();
        }
      } while (paramList == null);
      paramList = ((SpriteContext)paramList).n();
    } while (paramList == null);
    return paramList;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager.getMemeEngine.1
 * JD-Core Version:    0.7.0.1
 */