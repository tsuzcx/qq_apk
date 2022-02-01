package com.tencent.common.danmaku.tool;

import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.data.BaseDanmaku;
import java.util.Comparator;
import java.util.List;

public class SortedLinkedList<T>
{
  private final SortedLinkedList.Node<T> a;
  private final Comparator<T> b;
  private final SortedLinkedList.TimeComparator c;
  private int d = 0;
  
  public SortedLinkedList(Comparator<T> paramComparator, SortedLinkedList.TimeComparator<T> paramTimeComparator)
  {
    this.c = paramTimeComparator;
    this.a = new SortedLinkedList.Node();
    this.b = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, SortedLinkedList.Node<T> paramNode)
  {
    if ((DanmakuDependImp.a().b().a()) && ((paramList == null) || (paramList.isEmpty())) && (!b()) && ((paramNode.a instanceof BaseDanmaku))) {
      Math.abs(((BaseDanmaku)paramNode.a).x() - paramLong);
    }
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    SortedLinkedList.Node localNode1 = this.a.b;
    int j;
    for (int i = 0; (i < paramInt) && (localNode1 != this.a) && (this.c.a(localNode1.a, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localNode1.a);
        j = i + 1;
      }
      this.d -= 1;
      localNode1 = localNode1.b;
    }
    a(paramLong, paramList, localNode1);
    SortedLinkedList.Node localNode2 = this.a;
    localNode2.b = localNode1;
    localNode1.c = localNode2;
    return paramList;
  }
  
  public void a()
  {
    SortedLinkedList.Node localNode = this.a;
    localNode.b = localNode;
    localNode.c = localNode;
    this.d = 0;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (SortedLinkedList.Node localNode = this.a.c; (localNode != this.a) && (this.b.compare(localNode.a, paramT) > 0); localNode = localNode.c) {}
    if (paramT.equals(localNode.a)) {
      return false;
    }
    paramT = new SortedLinkedList.Node(paramT, localNode.b, localNode);
    localNode.b.c = paramT;
    localNode.b = paramT;
    this.d += 1;
    return true;
  }
  
  public boolean b()
  {
    return this.a.b == this.a;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (SortedLinkedList.Node localNode = this.a.b; (localNode != this.a) && (this.b.compare(localNode.a, paramT) < 0); localNode = localNode.b) {}
    if (paramT.equals(localNode.a)) {
      return false;
    }
    paramT = new SortedLinkedList.Node(paramT, localNode, localNode.c);
    localNode.c.b = paramT;
    localNode.c = paramT;
    this.d += 1;
    return true;
  }
  
  public T c()
  {
    return this.a.b.a;
  }
  
  public T d()
  {
    SortedLinkedList.Node localNode = this.a.c;
    if (localNode != this.a) {
      return localNode.a;
    }
    return null;
  }
  
  public int e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.tool.SortedLinkedList
 * JD-Core Version:    0.7.0.1
 */