package com.squareup.wire.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.AbstractMutableList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/internal/MutableOnWriteList;", "T", "Lkotlin/collections/AbstractMutableList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lcom/squareup/wire/internal/Serializable;", "immutableList", "", "(Ljava/util/List;)V", "mutableList", "getMutableList$wire_runtime", "()Ljava/util/List;", "setMutableList$wire_runtime", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "writeReplace", "", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class MutableOnWriteList<T>
  extends AbstractMutableList<T>
  implements Serializable, RandomAccess
{
  private final List<T> immutableList;
  @NotNull
  private List<? extends T> mutableList;
  
  public MutableOnWriteList(@NotNull List<? extends T> paramList)
  {
    this.immutableList = paramList;
    this.mutableList = this.immutableList;
  }
  
  private final Object writeReplace()
  {
    return new ArrayList((Collection)this.mutableList);
  }
  
  public void add(int paramInt, T paramT)
  {
    List localList1 = this.mutableList;
    List localList2 = this.immutableList;
    if (localList1 == localList2) {
      this.mutableList = ((List)new ArrayList((Collection)localList2));
    }
    localList1 = this.mutableList;
    if (localList1 != null)
    {
      ((ArrayList)localList1).add(paramInt, paramT);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<T>");
  }
  
  public T get(int paramInt)
  {
    return this.mutableList.get(paramInt);
  }
  
  @NotNull
  public final List<T> getMutableList$wire_runtime()
  {
    return this.mutableList;
  }
  
  public int getSize()
  {
    return this.mutableList.size();
  }
  
  public T removeAt(int paramInt)
  {
    List localList1 = this.mutableList;
    List localList2 = this.immutableList;
    if (localList1 == localList2) {
      this.mutableList = ((List)new ArrayList((Collection)localList2));
    }
    localList1 = this.mutableList;
    if (localList1 != null) {
      return ((ArrayList)localList1).remove(paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<T>");
  }
  
  public T set(int paramInt, T paramT)
  {
    List localList1 = this.mutableList;
    List localList2 = this.immutableList;
    if (localList1 == localList2) {
      this.mutableList = ((List)new ArrayList((Collection)localList2));
    }
    localList1 = this.mutableList;
    if (localList1 != null) {
      return ((ArrayList)localList1).set(paramInt, paramT);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<T>");
  }
  
  public final void setMutableList$wire_runtime(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.mutableList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal.MutableOnWriteList
 * JD-Core Version:    0.7.0.1
 */