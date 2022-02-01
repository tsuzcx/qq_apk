package com.tencent.biz.qqcircle.bizparts.danmaku.entity;

import java.util.Comparator;

public class SortedLinkedList<T>
{
  protected final SortedLinkedList.Node<T> a = new SortedLinkedList.Node();
  protected final Comparator<T> b;
  protected int c = 0;
  
  public SortedLinkedList(Comparator<T> paramComparator)
  {
    this.b = paramComparator;
  }
  
  public void a()
  {
    SortedLinkedList.Node localNode = this.a;
    localNode.b = localNode;
    localNode.c = localNode;
    this.c = 0;
  }
  
  public boolean a(T paramT)
  {
    for (SortedLinkedList.Node localNode = this.a.b; (localNode != this.a) && (this.b.compare(localNode.a, paramT) < 0); localNode = localNode.b) {}
    paramT = new SortedLinkedList.Node(paramT, localNode, localNode.c);
    localNode.c.b = paramT;
    localNode.c = paramT;
    this.c += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.entity.SortedLinkedList
 * JD-Core Version:    0.7.0.1
 */