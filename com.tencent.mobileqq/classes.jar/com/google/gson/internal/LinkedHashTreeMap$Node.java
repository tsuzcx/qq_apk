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
    boolean bool3 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Map.Entry)paramObject;
      Object localObject = this.key;
      if (localObject == null)
      {
        bool1 = bool2;
        if (paramObject.getKey() != null) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (!localObject.equals(paramObject.getKey())) {
          return bool1;
        }
      }
      localObject = this.value;
      if (localObject == null)
      {
        bool1 = bool2;
        if (paramObject.getValue() != null) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (!localObject.equals(paramObject.getValue())) {
          return bool1;
        }
      }
      bool1 = true;
    }
    return bool1;
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
    Object localObject = this.key;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.value;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.key);
    localStringBuilder.append("=");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.LinkedHashTreeMap.Node
 * JD-Core Version:    0.7.0.1
 */