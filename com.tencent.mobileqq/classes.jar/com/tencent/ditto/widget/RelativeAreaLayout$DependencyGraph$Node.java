package com.tencent.ditto.widget;

import android.support.v4.util.Pools.SynchronizedPool;
import com.tencent.ditto.area.DittoArea;
import java.util.HashMap;
import java.util.Map;

class RelativeAreaLayout$DependencyGraph$Node
{
  private static final int POOL_LIMIT = 100;
  private static final Pools.SynchronizedPool<Node> sPool = new Pools.SynchronizedPool(100);
  DittoArea area;
  final Map<String, Node> dependencies = new HashMap();
  final Map<Node, RelativeAreaLayout.DependencyGraph> dependents = new HashMap();
  
  static Node acquire(DittoArea paramDittoArea)
  {
    Node localNode2 = (Node)sPool.acquire();
    Node localNode1 = localNode2;
    if (localNode2 == null) {
      localNode1 = new Node();
    }
    localNode1.area = paramDittoArea;
    return localNode1;
  }
  
  void release()
  {
    this.area = null;
    this.dependents.clear();
    this.dependencies.clear();
    sPool.release(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.widget.RelativeAreaLayout.DependencyGraph.Node
 * JD-Core Version:    0.7.0.1
 */