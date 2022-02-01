package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class LinkedHashTreeMap<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> NATURAL_ORDER = new LinkedHashTreeMap.1();
  Comparator<? super K> comparator;
  private LinkedHashTreeMap<K, V>.EntrySet entrySet;
  final LinkedHashTreeMap.Node<K, V> header;
  private LinkedHashTreeMap<K, V>.KeySet keySet;
  int modCount = 0;
  int size = 0;
  LinkedHashTreeMap.Node<K, V>[] table;
  int threshold;
  
  public LinkedHashTreeMap()
  {
    this(NATURAL_ORDER);
  }
  
  public LinkedHashTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator == null) {
      paramComparator = NATURAL_ORDER;
    }
    this.comparator = paramComparator;
    this.header = new LinkedHashTreeMap.Node();
    this.table = new LinkedHashTreeMap.Node[16];
    paramComparator = this.table;
    this.threshold = (paramComparator.length / 2 + paramComparator.length / 4);
  }
  
  private void doubleCapacity()
  {
    this.table = doubleCapacity(this.table);
    LinkedHashTreeMap.Node[] arrayOfNode = this.table;
    this.threshold = (arrayOfNode.length / 2 + arrayOfNode.length / 4);
  }
  
  static <K, V> LinkedHashTreeMap.Node<K, V>[] doubleCapacity(LinkedHashTreeMap.Node<K, V>[] paramArrayOfNode)
  {
    int m = paramArrayOfNode.length;
    LinkedHashTreeMap.Node[] arrayOfNode = new LinkedHashTreeMap.Node[m * 2];
    LinkedHashTreeMap.AvlIterator localAvlIterator = new LinkedHashTreeMap.AvlIterator();
    LinkedHashTreeMap.AvlBuilder localAvlBuilder1 = new LinkedHashTreeMap.AvlBuilder();
    LinkedHashTreeMap.AvlBuilder localAvlBuilder2 = new LinkedHashTreeMap.AvlBuilder();
    int i = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfNode[i];
      if (localObject != null)
      {
        localAvlIterator.reset((LinkedHashTreeMap.Node)localObject);
        int k = 0;
        int j = 0;
        for (;;)
        {
          localNode = localAvlIterator.next();
          if (localNode == null) {
            break;
          }
          if ((localNode.hash & m) == 0) {
            k += 1;
          } else {
            j += 1;
          }
        }
        localAvlBuilder1.reset(k);
        localAvlBuilder2.reset(j);
        localAvlIterator.reset((LinkedHashTreeMap.Node)localObject);
        for (;;)
        {
          localObject = localAvlIterator.next();
          if (localObject == null) {
            break;
          }
          if ((((LinkedHashTreeMap.Node)localObject).hash & m) == 0) {
            localAvlBuilder1.add((LinkedHashTreeMap.Node)localObject);
          } else {
            localAvlBuilder2.add((LinkedHashTreeMap.Node)localObject);
          }
        }
        LinkedHashTreeMap.Node localNode = null;
        if (k > 0) {
          localObject = localAvlBuilder1.root();
        } else {
          localObject = null;
        }
        arrayOfNode[i] = localObject;
        localObject = localNode;
        if (j > 0) {
          localObject = localAvlBuilder2.root();
        }
        arrayOfNode[(i + m)] = localObject;
      }
      i += 1;
    }
    return arrayOfNode;
  }
  
  private boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private void rebalance(LinkedHashTreeMap.Node<K, V> paramNode, boolean paramBoolean)
  {
    while (paramNode != null)
    {
      LinkedHashTreeMap.Node localNode1 = paramNode.left;
      LinkedHashTreeMap.Node localNode2 = paramNode.right;
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
      LinkedHashTreeMap.Node localNode3;
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
  
  private void replaceInParent(LinkedHashTreeMap.Node<K, V> paramNode1, LinkedHashTreeMap.Node<K, V> paramNode2)
  {
    LinkedHashTreeMap.Node localNode = paramNode1.parent;
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
    int i = paramNode1.hash;
    paramNode1 = this.table;
    paramNode1[(i & paramNode1.length - 1)] = paramNode2;
  }
  
  private void rotateLeft(LinkedHashTreeMap.Node<K, V> paramNode)
  {
    LinkedHashTreeMap.Node localNode1 = paramNode.left;
    LinkedHashTreeMap.Node localNode2 = paramNode.right;
    LinkedHashTreeMap.Node localNode3 = localNode2.left;
    LinkedHashTreeMap.Node localNode4 = localNode2.right;
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
  
  private void rotateRight(LinkedHashTreeMap.Node<K, V> paramNode)
  {
    LinkedHashTreeMap.Node localNode1 = paramNode.left;
    LinkedHashTreeMap.Node localNode2 = paramNode.right;
    LinkedHashTreeMap.Node localNode3 = localNode1.left;
    LinkedHashTreeMap.Node localNode4 = localNode1.right;
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
  
  private static int secondaryHash(int paramInt)
  {
    paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private Object writeReplace()
  {
    return new LinkedHashMap(this);
  }
  
  public void clear()
  {
    Arrays.fill(this.table, null);
    this.size = 0;
    this.modCount += 1;
    LinkedHashTreeMap.Node localNode2 = this.header;
    LinkedHashTreeMap.Node localNode1;
    for (Object localObject = localNode2.next; localObject != localNode2; localObject = localNode1)
    {
      localNode1 = ((LinkedHashTreeMap.Node)localObject).next;
      ((LinkedHashTreeMap.Node)localObject).prev = null;
      ((LinkedHashTreeMap.Node)localObject).next = null;
    }
    localNode2.prev = localNode2;
    localNode2.next = localNode2;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return findByObject(paramObject) != null;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    LinkedHashTreeMap.EntrySet localEntrySet = this.entrySet;
    if (localEntrySet != null) {
      return localEntrySet;
    }
    localEntrySet = new LinkedHashTreeMap.EntrySet(this);
    this.entrySet = localEntrySet;
    return localEntrySet;
  }
  
  LinkedHashTreeMap.Node<K, V> find(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.comparator;
    LinkedHashTreeMap.Node[] arrayOfNode = this.table;
    int j = secondaryHash(paramK.hashCode());
    int k = arrayOfNode.length - 1 & j;
    Object localObject = arrayOfNode[k];
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
          i = localComparable.compareTo(((LinkedHashTreeMap.Node)localObject).key);
        } else {
          i = localComparator.compare(paramK, ((LinkedHashTreeMap.Node)localObject).key);
        }
        if (i == 0) {
          return localObject;
        }
        if (i < 0) {
          localNode = ((LinkedHashTreeMap.Node)localObject).left;
        } else {
          localNode = ((LinkedHashTreeMap.Node)localObject).right;
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
    LinkedHashTreeMap.Node localNode = this.header;
    if (localObject == null)
    {
      if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramK.getClass().getName());
        ((StringBuilder)localObject).append(" is not Comparable");
        throw new ClassCastException(((StringBuilder)localObject).toString());
      }
      paramK = new LinkedHashTreeMap.Node((LinkedHashTreeMap.Node)localObject, paramK, j, localNode, localNode.prev);
      arrayOfNode[k] = paramK;
    }
    else
    {
      paramK = new LinkedHashTreeMap.Node((LinkedHashTreeMap.Node)localObject, paramK, j, localNode, localNode.prev);
      if (i < 0) {
        ((LinkedHashTreeMap.Node)localObject).left = paramK;
      } else {
        ((LinkedHashTreeMap.Node)localObject).right = paramK;
      }
      rebalance((LinkedHashTreeMap.Node)localObject, true);
    }
    i = this.size;
    this.size = (i + 1);
    if (i > this.threshold) {
      doubleCapacity();
    }
    this.modCount += 1;
    return paramK;
  }
  
  LinkedHashTreeMap.Node<K, V> findByEntry(Map.Entry<?, ?> paramEntry)
  {
    LinkedHashTreeMap.Node localNode = findByObject(paramEntry.getKey());
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
  
  LinkedHashTreeMap.Node<K, V> findByObject(Object paramObject)
  {
    LinkedHashTreeMap.Node localNode = null;
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
    LinkedHashTreeMap.KeySet localKeySet = this.keySet;
    if (localKeySet != null) {
      return localKeySet;
    }
    localKeySet = new LinkedHashTreeMap.KeySet(this);
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
  
  void removeInternal(LinkedHashTreeMap.Node<K, V> paramNode, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramNode.prev.next = paramNode.next;
      paramNode.next.prev = paramNode.prev;
      paramNode.prev = null;
      paramNode.next = null;
    }
    LinkedHashTreeMap.Node localNode1 = paramNode.left;
    LinkedHashTreeMap.Node localNode2 = paramNode.right;
    LinkedHashTreeMap.Node localNode3 = paramNode.parent;
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
  
  LinkedHashTreeMap.Node<K, V> removeInternalByKey(Object paramObject)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.LinkedHashTreeMap
 * JD-Core Version:    0.7.0.1
 */