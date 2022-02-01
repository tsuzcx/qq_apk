package com.tencent.biz.qqcircle.bizparts.danmaku.entity;

import java.util.Comparator;
import java.util.List;

public class DanmuSortedLinkedList
  extends SortedLinkedList<AbsDanmaku>
{
  private SortedLinkedList.Node<AbsDanmaku> d = null;
  
  public DanmuSortedLinkedList(Comparator<AbsDanmaku> paramComparator)
  {
    super(paramComparator);
  }
  
  public List<AbsDanmaku> a(AbsDanmaku paramAbsDanmaku, List<AbsDanmaku> paramList)
  {
    for (SortedLinkedList.Node localNode = this.a.b; (localNode != this.a) && ((this.b.compare(localNode.a, paramAbsDanmaku) <= 0) || ((localNode.a != null) && (((AbsDanmaku)localNode.a).aj))); localNode = localNode.b)
    {
      paramList.add(localNode.a);
      this.c -= 1;
    }
    this.a.b = localNode;
    localNode.c = this.a;
    return paramList;
  }
  
  public boolean a(AbsDanmaku paramAbsDanmaku)
  {
    SortedLinkedList.Node localNode2 = this.a.c;
    SortedLinkedList.Node localNode1;
    if (paramAbsDanmaku.aj)
    {
      localNode1 = this.d;
      if (localNode1 != null) {}
    }
    else
    {
      while ((localNode2 != this.a) && ((this.b.compare(localNode2.a, paramAbsDanmaku) > 0) || (((AbsDanmaku)localNode2.a).aj))) {
        localNode2 = localNode2.c;
      }
      localNode1 = localNode2;
      if (localNode2.b.a != null)
      {
        localNode1 = localNode2;
        if (((AbsDanmaku)localNode2.b.a).aj) {
          localNode1 = localNode2.b;
        }
      }
    }
    paramAbsDanmaku = new SortedLinkedList.Node(paramAbsDanmaku, localNode1.b, localNode1);
    if ((paramAbsDanmaku.a != null) && (!((AbsDanmaku)paramAbsDanmaku.a).aj)) {
      this.d = paramAbsDanmaku;
    }
    localNode1.b.c = paramAbsDanmaku;
    localNode1.b = paramAbsDanmaku;
    this.c += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.entity.DanmuSortedLinkedList
 * JD-Core Version:    0.7.0.1
 */