package com.google.gson.internal;

import java.util.Map.Entry;

final class LinkedHashTreeMap$Node<K, V>
  implements Map.Entry<K, V>
{
  final int hash;
  int height;
  final K key;
  Node<K, V> left;
  Node<K, V> next;
  Node<K, V> parent;
  Node<K, V> prev;
  Node<K, V> right;
  V value;
  
  LinkedHashTreeMap$Node()
  {
    this.key = null;
    this.hash = -1;
    this.prev = this;
    this.next = this;
  }
  
  LinkedHashTreeMap$Node(Node<K, V> paramNode1, K paramK, int paramInt, Node<K, V> paramNode2, Node<K, V> paramNode3)
  {
    this.parent = paramNode1;
    this.key = paramK;
    this.hash = paramInt;
    this.height = 1;
    this.next = paramNode2;
    this.prev = paramNode3;
    paramNode3.next = this;
    paramNode2.prev = this;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      if (this.key != null) {
        break label56;
      }
      bool1 = bool2;
      if (paramObject.getKey() == null)
      {
        if (this.value != null) {
          break label77;
        }
        bool1 = bool2;
        if (paramObject.getValue() != null) {}
      }
    }
    for (;;)
    {
      bool1 = true;
      label56:
      label77:
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!this.key.equals(paramObject.getKey()));
        break;
        bool1 = bool2;
      } while (!this.value.equals(paramObject.getValue()));
    }
  }
  
  public Node<K, V> first()
  {
    Object localObject1 = this.left;
    Object localObject2 = this;
    while (localObject1 != null)
    {
      Node localNode = ((Node)localObject1).left;
      localObject2 = localObject1;
      localObject1 = localNode;
    }
    return localObject2;
  }
  
  public K getKey()
  {
    return this.key;
  }
  
  public V getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.key == null)
    {
      i = 0;
      if (this.value != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.key.hashCode();
      break;
      label33:
      j = this.value.hashCode();
    }
  }
  
  public Node<K, V> last()
  {
    Object localObject1 = this.right;
    Object localObject2 = this;
    while (localObject1 != null)
    {
      Node localNode = ((Node)localObject1).right;
      localObject2 = localObject1;
      localObject1 = localNode;
    }
    return localObject2;
  }
  
  public V setValue(V paramV)
  {
    Object localObject = this.value;
    this.value = paramV;
    return localObject;
  }
  
  public String toString()
  {
    return this.key + "=" + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal.LinkedHashTreeMap.Node
 * JD-Core Version:    0.7.0.1
 */