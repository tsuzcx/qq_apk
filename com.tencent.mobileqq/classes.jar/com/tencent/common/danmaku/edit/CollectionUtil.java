package com.tencent.common.danmaku.edit;

import android.text.Editable;
import com.tencent.common.danmaku.edit.bean.RichSpan;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/CollectionUtil;", "", "()V", "sortArrayByStartPosition", "Ljava/util/ArrayList;", "Lcom/tencent/common/danmaku/edit/bean/RichSpan;", "spansList", "", "text", "Landroid/text/Editable;", "([Lcom/tencent/common/danmaku/edit/bean/RichSpan;Landroid/text/Editable;)Ljava/util/ArrayList;", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public final class CollectionUtil
{
  public static final CollectionUtil a = new CollectionUtil();
  
  @NotNull
  public final ArrayList<RichSpan> a(@NotNull RichSpan[] paramArrayOfRichSpan, @NotNull Editable paramEditable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfRichSpan, "spansList");
    Intrinsics.checkParameterIsNotNull(paramEditable, "text");
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfRichSpan.length > 1) {
      ArraysKt.sortWith(paramArrayOfRichSpan, (Comparator)new CollectionUtil.sortArrayByStartPosition..inlined.sortBy.1(paramEditable));
    }
    int j = paramArrayOfRichSpan.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfRichSpan[i]);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.CollectionUtil
 * JD-Core Version:    0.7.0.1
 */