package com.tencent.common.danmaku.tool;

final class SortedLinkedList$Node<T>
{
  public final T a;
  public Node<T> b;
  public Node<T> c;
  
  public SortedLinkedList$Node()
  {
    this.a = null;
    this.b = this;
    this.c = this;
  }
  
  public SortedLinkedList$Node(T paramT, Node<T> paramNode1, Node<T> paramNode2)
  {
    this.a = paramT;
    this.b = paramNode1;
    this.c = paramNode2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.tool.SortedLinkedList.Node
 * JD-Core Version:    0.7.0.1
 */