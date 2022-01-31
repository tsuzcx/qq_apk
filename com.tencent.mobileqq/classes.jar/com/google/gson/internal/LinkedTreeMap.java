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
  private static final Comparator<Comparable> NATURAL_ORDER;
  Comparator<? super K> comparator;
  private LinkedTreeMap<K, V>.EntrySet entrySet;
  final LinkedTreeMap.Node<K, V> header = new LinkedTreeMap.Node();
  private LinkedTreeMap<K, V>.KeySet keySet;
  int modCount = 0;
  LinkedTreeMap.Node<K, V> root;
  int size = 0;
  
  static
  {
    if (!LinkedTreeMap.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      NATURAL_ORDER = new LinkedTreeMap.1();
      return;
    }
  }
  
  public LinkedTreeMap()
  {
    this(NATURAL_ORDER);
  }
  
  public LinkedTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null) {}
    for (;;)
    {
      this.comparator = paramComparator;
      return;
      paramComparator = NATURAL_ORDER;
    }
  }
  
  private boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private void rebalance(LinkedTreeMap.Node<K, V> paramNode, boolean paramBoolean)
  {
    LinkedTreeMap.Node localNode1;
    LinkedTreeMap.Node localNode2;
    int i;
    int j;
    label39:
    int k;
    LinkedTreeMap.Node localNode3;
    if (paramNode != null)
    {
      localNode1 = paramNode.left;
      localNode2 = paramNode.right;
      if (localNode1 == null) {
        break label117;
      }
      i = localNode1.height;
      if (localNode2 == null) {
        break label122;
      }
      j = localNode2.height;
      k = i - j;
      if (k != -2) {
        break label172;
      }
      localNode1 = localNode2.left;
      localNode3 = localNode2.right;
      if (localNode3 == null) {
        break label128;
      }
      i = localNode3.height;
      label77:
      if (localNode1 == null) {
        break label133;
      }
      j = localNode1.height;
      label89:
      i = j - i;
      if ((i != -1) && ((i != 0) || (paramBoolean))) {
        break label139;
      }
      rotateLeft(paramNode);
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label242;
      }
      label116:
      return;
      label117:
      i = 0;
      break;
      label122:
      j = 0;
      break label39;
      label128:
      i = 0;
      break label77;
      label133:
      j = 0;
      break label89;
      label139:
      assert (i == 1);
      rotateRight(localNode2);
      rotateLeft(paramNode);
    }
    label172:
    if (k == 2)
    {
      localNode2 = localNode1.left;
      localNode3 = localNode1.right;
      if (localNode3 != null)
      {
        i = localNode3.height;
        label203:
        if (localNode2 == null) {
          break label255;
        }
        j = localNode2.height;
        label215:
        i = j - i;
        if ((i != 1) && ((i != 0) || (paramBoolean))) {
          break label261;
        }
        rotateRight(paramNode);
        label238:
        if (paramBoolean) {
          break label292;
        }
      }
    }
    label242:
    label255:
    do
    {
      do
      {
        paramNode = paramNode.parent;
        break;
        i = 0;
        break label203;
        j = 0;
        break label215;
        assert (i == -1);
        rotateLeft(localNode1);
        rotateRight(paramNode);
        break label238;
        break label116;
        if (k != 0) {
          break label311;
        }
        paramNode.height = (i + 1);
      } while (!paramBoolean);
      return;
      assert ((k == -1) || (k == 1));
      paramNode.height = (Math.max(i, j) + 1);
    } while (paramBoolean);
    label261:
    label292:
    label311:
    return;
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
      assert (localNode.right == paramNode1);
      localNode.right = paramNode2;
      return;
    }
    this.root = paramNode2;
  }
  
  private void rotateLeft(LinkedTreeMap.Node<K, V> paramNode)
  {
    int k = 0;
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
    int i;
    if (localNode1 != null)
    {
      i = localNode1.height;
      if (localNode3 == null) {
        break label135;
      }
    }
    label135:
    for (int j = localNode3.height;; j = 0)
    {
      paramNode.height = (Math.max(i, j) + 1);
      j = paramNode.height;
      i = k;
      if (localNode4 != null) {
        i = localNode4.height;
      }
      localNode2.height = (Math.max(j, i) + 1);
      return;
      i = 0;
      break;
    }
  }
  
  private void rotateRight(LinkedTreeMap.Node<K, V> paramNode)
  {
    int k = 0;
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
    int i;
    if (localNode2 != null)
    {
      i = localNode2.height;
      if (localNode4 == null) {
        break label135;
      }
    }
    label135:
    for (int j = localNode4.height;; j = 0)
    {
      paramNode.height = (Math.max(i, j) + 1);
      j = paramNode.height;
      i = k;
      if (localNode3 != null) {
        i = localNode3.height;
      }
      localNode1.height = (Math.max(j, i) + 1);
      return;
      i = 0;
      break;
    }
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
    Object localObject3 = null;
    Comparator localComparator = this.comparator;
    Object localObject1 = this.root;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      Comparable localComparable;
      if (localComparator == NATURAL_ORDER)
      {
        localComparable = (Comparable)paramK;
        if (localComparable == null) {
          break label69;
        }
      }
      label60:
      label69:
      for (i = localComparable.compareTo(((LinkedTreeMap.Node)localObject1).key);; i = localComparator.compare(paramK, ((LinkedTreeMap.Node)localObject1).key))
      {
        if (i != 0) {
          break label86;
        }
        localObject2 = localObject1;
        return localObject2;
        localComparable = null;
        break;
      }
      label86:
      if (i < 0)
      {
        localObject2 = ((LinkedTreeMap.Node)localObject1).left;
        label97:
        if (localObject2 != null) {
          break label179;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject3;
      if (!paramBoolean) {
        break label60;
      }
      localObject2 = this.header;
      if (localObject1 == null)
      {
        if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable)))
        {
          throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
          localObject2 = ((LinkedTreeMap.Node)localObject1).right;
          break label97;
          label179:
          localObject1 = localObject2;
          break;
        }
        paramK = new LinkedTreeMap.Node((LinkedTreeMap.Node)localObject1, paramK, (LinkedTreeMap.Node)localObject2, ((LinkedTreeMap.Node)localObject2).prev);
        this.root = paramK;
        this.size += 1;
        this.modCount += 1;
        return paramK;
      }
      paramK = new LinkedTreeMap.Node((LinkedTreeMap.Node)localObject1, paramK, (LinkedTreeMap.Node)localObject2, ((LinkedTreeMap.Node)localObject2).prev);
      if (i < 0) {
        ((LinkedTreeMap.Node)localObject1).left = paramK;
      }
      for (;;)
      {
        rebalance((LinkedTreeMap.Node)localObject1, true);
        break;
        ((LinkedTreeMap.Node)localObject1).right = paramK;
      }
      i = 0;
    }
  }
  
  LinkedTreeMap.Node<K, V> findByEntry(Map.Entry<?, ?> paramEntry)
  {
    LinkedTreeMap.Node localNode = findByObject(paramEntry.getKey());
    if ((localNode != null) && (equal(localNode.value, paramEntry.getValue()))) {}
    for (int i = 1; i != 0; i = 0) {
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
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    paramK = find(paramK, true);
    Object localObject = paramK.value;
    paramK.value = paramV;
    return localObject;
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
    int j = 0;
    if (paramBoolean)
    {
      paramNode.prev.next = paramNode.next;
      paramNode.next.prev = paramNode.prev;
    }
    LinkedTreeMap.Node localNode1 = paramNode.left;
    LinkedTreeMap.Node localNode2 = paramNode.right;
    LinkedTreeMap.Node localNode3 = paramNode.parent;
    int i;
    if ((localNode1 != null) && (localNode2 != null)) {
      if (localNode1.height > localNode2.height)
      {
        localNode1 = localNode1.last();
        removeInternal(localNode1, false);
        localNode2 = paramNode.left;
        if (localNode2 == null) {
          break label262;
        }
        i = localNode2.height;
        localNode1.left = localNode2;
        localNode2.parent = localNode1;
        paramNode.left = null;
      }
    }
    for (;;)
    {
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
      localNode1 = localNode2.first();
      break;
      if (localNode1 != null)
      {
        replaceInParent(paramNode, localNode1);
        paramNode.left = null;
      }
      for (;;)
      {
        rebalance(localNode3, false);
        this.size -= 1;
        this.modCount += 1;
        return;
        if (localNode2 != null)
        {
          replaceInParent(paramNode, localNode2);
          paramNode.right = null;
        }
        else
        {
          replaceInParent(paramNode, null);
        }
      }
      label262:
      i = 0;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap
 * JD-Core Version:    0.7.0.1
 */