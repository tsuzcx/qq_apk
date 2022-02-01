package com.squareup.wire.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/internal/ImmutableList;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lcom/squareup/wire/internal/Serializable;", "list", "", "(Ljava/util/List;)V", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "toArray", "", "", "()[Ljava/lang/Object;", "writeReplace", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ImmutableList<T>
  extends AbstractList<T>
  implements Serializable, RandomAccess
{
  private final ArrayList<T> list;
  
  public ImmutableList(@NotNull List<? extends T> paramList)
  {
    this.list = new ArrayList((Collection)paramList);
  }
  
  private final Object writeReplace()
  {
    List localList = Collections.unmodifiableList((List)this.list);
    Intrinsics.checkExpressionValueIsNotNull(localList, "Collections.unmodifiableList(this)");
    return localList;
  }
  
  public T get(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public int getSize()
  {
    return this.list.size();
  }
  
  @NotNull
  public Object[] toArray()
  {
    Object[] arrayOfObject = ((Collection)this.list).toArray(new Object[0]);
    if (arrayOfObject != null) {
      return arrayOfObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal.ImmutableList
 * JD-Core Version:    0.7.0.1
 */