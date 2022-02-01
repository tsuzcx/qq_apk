package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class LinkedTreeMap<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> NATURAL_ORDER = new LinkedTreeMap.1();
  Comparator<? super K> comparator;
  private LinkedTreeMap<K, V>.EntrySet entrySet;
  final LinkedTreeMap.Node<K, V> header = new LinkedTreeMap.Node();
  private LinkedTreeMap<K, V>.KeySet keySet;
  int modCount = 0;
  LinkedTreeMap.Node<K, V> root;
  int size = 0;
  
  public LinkedTreeMap()
  {
    this(NATURAL_ORDER);
  }
  
  public LinkedTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator == null) {
      paramComparator = NATURAL_ORDER;
    }
    this.comparator = paramComparator;
  }
  
  private boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private void rebalance(LinkedTreeMap.Node<K, V> paramNode, boolean paramBoolean)
  {
    while (paramNode != null)
    {
      LinkedTreeMap.Node localNode1 = paramNode.left;
      LinkedTreeMap.Node localNode2 = paramNode.right;
      int m = 0;
      int k = 0;
      int i;
      if (localNode1 != null) {
        i = localNode1.height;
      } else {
        i = 0;
      }
      int j;
      if (localNode2 != null) {
        j = localNode2.height;
      } else {
        j = 0;
      }
      int n = i - j;
      LinkedTreeMap.Node localNode3;
      if (n == -2)
      {
        localNode1 = localNode2.left;
        localNode3 = localNode2.right;
        if (localNode3 != null) {
          i = localNode3.height;
        } else {
          i = 0;
        }
        j = k;
        if (localNode1 != null) {
          j = localNode1.height;
        }
        i = j - i;
        if ((i != -1) && ((i != 0) || (paramBoolean)))
        {
          rotateRight(localNode2);
          rotateLeft(paramNode);
        }
        else
        {
          rotateLeft(paramNode);
        }
        if (!paramBoolean) {}
      }
      else if (n == 2)
      {
        localNode2 = localNode1.left;
        localNode3 = localNode1.right;
        if (localNode3 != null) {
          i = localNode3.height;
        } else {
          i = 0;
        }
        j = m;
        if (localNode2 != null) {
          j = localNode2.height;
        }
        i = j - i;
        if ((i != 1) && ((i != 0) || (paramBoolean)))
        {
          rotateLeft(localNode1);
          rotateRight(paramNode);
        }
        else
        {
          rotateRight(paramNode);
        }
        if (!paramBoolean) {}
      }
      else if (n == 0)
      {
        paramNode.height = (i + 1);
        if (!paramBoolean) {}
      }
      else
      {
        paramNode.height = (Math.max(i, j) + 1);
        if (!paramBoolean) {
          return;
        }
      }
      paramNode = paramNode.parent;
    }
  }
  
  private void replaceInParent(LinkedTreeMap.Node<K, V> paramNode1, LinkedTreeMap.Node<K, V> paramNode2)
  {
    LinkedTreeMap.Node localNode = paramNode1.parent;
    paramNode1.parent = null;
    if (paramNode2 != null) {
      paramNode2.parent = localNode;
    }
    if (localNode != null)
    {
      if (localNode.left == paramNode1)
      {
        localNode.left = paramNode2;
        return;
      }
      localNode.right = paramNode2;
      return;
    }
    this.root = paramNode2;
  }
  
  private void rotateLeft(LinkedTreeMap.Node<K, V> paramNode)
  {
    LinkedTreeMap.Node localNode1 = paramNode.left;
    LinkedTreeMap.Node localNode2 = paramNode.right;
    LinkedTreeMap.Node localNode3 = localNode2.left;
    LinkedTreeMap.Node localNode4 = localNode2.right;
    paramNode.right = localNode3;
    if (localNode3 != null) {
      localNode3.parent = paramNode;
    }
    replaceInParent(paramNode, localNode2);
    localNode2.left = paramNode;
    paramNode.parent = localNode2;
    int k = 0;
    if (localNode1 != null) {
      i = localNode1.height;
    } else {
      i = 0;
    }
    if (localNode3 != null) {
      j = localNode3.height;
    } else {
      j = 0;
    }
    paramNode.height = (Math.max(i, j) + 1);
    int j = paramNode.height;
    int i = k;
    if (localNode4 != null) {
      i = localNode4.height;
    }
    localNode2.height = (Math.max(j, i) + 1);
  }
  
  private void rotateRight(LinkedTreeMap.Node<K, V> paramNode)
  {
    LinkedTreeMap.Node localNode1 = paramNode.left;
    LinkedTreeMap.Node localNode2 = paramNode.right;
    LinkedTreeMap.Node localNode3 = localNode1.left;
    LinkedTreeMap.Node localNode4 = localNode1.right;
    paramNode.left = localNode4;
    if (localNode4 != null) {
      localNode4.parent = paramNode;
    }
    replaceInParent(paramNode, localNode1);
    localNode1.right = paramNode;
    paramNode.parent = localNode1;
    int k = 0;
    if (localNode2 != null) {
      i = localNode2.height;
    } else {
      i = 0;
    }
    if (localNode4 != null) {
      j = localNode4.height;
    } else {
      j = 0;
    }
    paramNode.height = (Math.max(i, j) + 1);
    int j = paramNode.height;
    int i = k;
    if (localNode3 != null) {
      i = localNode3.height;
    }
    localNode1.height = (Math.max(j, i) + 1);
  }
  
  private Object writeReplace()
  {
    return new LinkedHashMap(this);
  }
  
  public void clear()
  {
    this.root = null;
    this.size = 0;
    this.modCount += 1;
    LinkedTreeMap.Node localNode = this.header;
    localNode.prev = localNode;
    localNode.next = localNode;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return findByObject(paramObject) != null;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    LinkedTreeMap.EntrySet localEntrySet = this.entrySet;
    if (localEntrySet != null) {
      return localEntrySet;
    }
    localEntrySet = new LinkedTreeMap.EntrySet(this);
    this.entrySet = localEntrySet;
    return localEntrySet;
  }
  
  LinkedTreeMap.Node<K, V> find(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.comparator;
    Object localObject = this.root;
    if (localObject != null)
    {
      Comparable localComparable;
      if (localComparator == NATURAL_ORDER) {
        localComparable = (Comparable)paramK;
      } else {
        localComparable = null;
      }
      for (;;)
      {
        if (localComparable != null) {
          i = localComparable.compareTo(((LinkedTreeMap.Node)localObject).key);
        } else {
          i = localComparator.compare(paramK, ((LinkedTreeMap.Node)localObject).key);
        }
        if (i == 0) {
          return localObject;
        }
        if (i < 0) {
          localNode = ((LinkedTreeMap.Node)localObject).left;
        } else {
          localNode = ((LinkedTreeMap.Node)localObject).right;
        }
        if (localNode == null) {
          break;
        }
        localObject = localNode;
      }
    }
    int i = 0;
    if (!paramBoolean) {
      return null;
    }
    LinkedTreeMap.Node localNode = this.header;
    if (localObject == null)
    {
      if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramK.getClass().getName());
        ((StringBuilder)localObject).append(" is not Comparable");
        throw new ClassCastException(((StringBuilder)localObject).toString());
      }
      paramK = new LinkedTreeMap.Node((LinkedTreeMap.Node)localObject, paramK, localNode, localNode.prev);
      this.root = paramK;
    }
    else
    {
      paramK = new LinkedTreeMap.Node((LinkedTreeMap.Node)localObject, paramK, localNode, localNode.prev);
      if (i < 0) {
        ((LinkedTreeMap.Node)localObject).left = paramK;
      } else {
        ((LinkedTreeMap.Node)localObject).right = paramK;
      }
      rebalance((LinkedTreeMap.Node)localObject, true);
    }
    this.size += 1;
    this.modCount += 1;
    return paramK;
  }
  
  LinkedTreeMap.Node<K, V> findByEntry(Map.Entry<?, ?> paramEntry)
  {
    LinkedTreeMap.Node localNode = findByObject(paramEntry.getKey());
    int i;
    if ((localNode != null) && (equal(localNode.value, paramEntry.getValue()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return localNode;
    }
    return null;
  }
  
  LinkedTreeMap.Node<K, V> findByObject(Object paramObject)
  {
    LinkedTreeMap.Node localNode = null;
    if (paramObject != null) {}
    try
    {
      localNode = find(paramObject, false);
      return localNode;
    }
    catch (ClassCastException paramObject) {}
    return null;
  }
  
  public V get(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      return paramObject.value;
    }
    return null;
  }
  
  public Set<K> keySet()
  {
    LinkedTreeMap.KeySet localKeySet = this.keySet;
    if (localKeySet != null) {
      return localKeySet;
    }
    localKeySet = new LinkedTreeMap.KeySet(this);
    this.keySet = localKeySet;
    return localKeySet;
  }
  
  public V put(K paramK, V paramV)
  {
    if (paramK != null)
    {
      paramK = find(paramK, true);
      Object localObject = paramK.value;
      paramK.value = paramV;
      return localObject;
    }
    throw new NullPointerException("key == null");
  }
  
  public V remove(Object paramObject)
  {
    paramObject = removeInternalByKey(paramObject);
    if (paramObject != null) {
      return paramObject.value;
    }
    return null;
  }
  
  void removeInternal(LinkedTreeMap.Node<K, V> paramNode, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramNode.prev.next = paramNode.next;
      paramNode.next.prev = paramNode.prev;
    }
    LinkedTreeMap.Node localNode1 = paramNode.left;
    LinkedTreeMap.Node localNode2 = paramNode.right;
    LinkedTreeMap.Node localNode3 = paramNode.parent;
    int j = 0;
    if ((localNode1 != null) && (localNode2 != null))
    {
      if (localNode1.height > localNode2.height) {
        localNode1 = localNode1.last();
      } else {
        localNode1 = localNode2.first();
      }
      removeInternal(localNode1, false);
      localNode2 = paramNode.left;
      int i;
      if (localNode2 != null)
      {
        i = localNode2.height;
        localNode1.left = localNode2;
        localNode2.parent = localNode1;
        paramNode.left = null;
      }
      else
      {
        i = 0;
      }
      localNode2 = paramNode.right;
      if (localNode2 != null)
      {
        j = localNode2.height;
        localNode1.right = localNode2;
        localNode2.parent = localNode1;
        paramNode.right = null;
      }
      localNode1.height = (Math.max(i, j) + 1);
      replaceInParent(paramNode, localNode1);
      return;
    }
    if (localNode1 != null)
    {
      replaceInParent(paramNode, localNode1);
      paramNode.left = null;
    }
    else if (localNode2 != null)
    {
      replaceInParent(paramNode, localNode2);
      paramNode.right = null;
    }
    else
    {
      replaceInParent(paramNode, null);
    }
    rebalance(localNode3, false);
    this.size -= 1;
    this.modCount += 1;
  }
  
  LinkedTreeMap.Node<K, V> removeInternalByKey(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      removeInternal(paramObject, true);
    }
    return paramObject;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap
 * JD-Core Version:    0.7.0.1
 */