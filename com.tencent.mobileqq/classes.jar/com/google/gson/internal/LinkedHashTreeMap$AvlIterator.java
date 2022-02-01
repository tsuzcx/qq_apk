package com.google.gson.internal;

class LinkedHashTreeMap$AvlIterator<K, V>
{
  private LinkedHashTreeMap.Node<K, V> stackTop;
  
  public LinkedHashTreeMap.Node<K, V> next()
  {
    LinkedHashTreeMap.Node localNode2 = this.stackTop;
    if (localNode2 == null) {
      return null;
    }
    Object localObject1 = localNode2.parent;
    localNode2.parent = null;
    Object localObject2;
    for (LinkedHashTreeMap.Node localNode1 = localNode2.right;; localNode1 = ((LinkedHashTreeMap.Node)localObject1).left)
    {
      localObject2 = localObject1;
      localObject1 = localNode1;
      if (localObject1 == null) {
        break;
      }
      ((LinkedHashTreeMap.Node)localObject1).parent = localObject2;
    }
    this.stackTop = localObject2;
    return localNode2;
  }
  
  void reset(LinkedHashTreeMap.Node<K, V> paramNode)
  {
    LinkedHashTreeMap.Node<K, V> localNode = null;
    while (paramNode != null)
    {
      paramNode.parent = localNode;
      LinkedHashTreeMap.Node localNode1 = paramNode.left;
      localNode = paramNode;
      paramNode = localNode1;
    }
    this.stackTop = localNode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.LinkedHashTreeMap.AvlIterator
 * JD-Core Version:    0.7.0.1
 */