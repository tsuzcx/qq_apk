package com.tencent.ditto.widget;

import android.support.v4.util.ArrayMap;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class RelativeAreaLayout$DependencyGraph
{
  private Map<String, RelativeAreaLayout.DependencyGraph.Node> mKeyNodes = new ArrayMap();
  private ArrayList<RelativeAreaLayout.DependencyGraph.Node> mNodes = new ArrayList();
  private ArrayDeque<RelativeAreaLayout.DependencyGraph.Node> mRoots = new ArrayDeque();
  
  private ArrayDeque<RelativeAreaLayout.DependencyGraph.Node> findRoots(String[] paramArrayOfString)
  {
    Object localObject = this.mKeyNodes;
    ArrayList localArrayList = this.mNodes;
    int k = localArrayList.size();
    int i = 0;
    RelativeAreaLayout.DependencyGraph.Node localNode1;
    while (i < k)
    {
      localNode1 = (RelativeAreaLayout.DependencyGraph.Node)localArrayList.get(i);
      localNode1.dependents.clear();
      localNode1.dependencies.clear();
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      localNode1 = (RelativeAreaLayout.DependencyGraph.Node)localArrayList.get(i);
      Map localMap = localNode1.area.getLayoutAttr().mAttrs;
      int m = paramArrayOfString.length;
      int j = 0;
      if (j < m)
      {
        String str = (String)localMap.get(paramArrayOfString[j]);
        RelativeAreaLayout.DependencyGraph.Node localNode2;
        if (str != null)
        {
          localNode2 = (RelativeAreaLayout.DependencyGraph.Node)((Map)localObject).get(str);
          if ((localNode2 != null) && (localNode2 != localNode1)) {
            break label162;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label162:
          localNode2.dependents.put(localNode1, this);
          localNode1.dependencies.put(str, localNode2);
        }
      }
      i += 1;
    }
    paramArrayOfString = this.mRoots;
    paramArrayOfString.clear();
    i = 0;
    while (i < k)
    {
      localObject = (RelativeAreaLayout.DependencyGraph.Node)localArrayList.get(i);
      if (((RelativeAreaLayout.DependencyGraph.Node)localObject).dependencies.size() == 0) {
        paramArrayOfString.addLast(localObject);
      }
      i += 1;
    }
    return paramArrayOfString;
  }
  
  void add(DittoArea paramDittoArea)
  {
    String str = paramDittoArea.getId();
    paramDittoArea = RelativeAreaLayout.DependencyGraph.Node.acquire(paramDittoArea);
    if ((str != null) && (!str.equals(""))) {
      this.mKeyNodes.put(str, paramDittoArea);
    }
    this.mNodes.add(paramDittoArea);
  }
  
  void clear()
  {
    ArrayList localArrayList = this.mNodes;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((RelativeAreaLayout.DependencyGraph.Node)localArrayList.get(i)).release();
      i += 1;
    }
    localArrayList.clear();
    this.mKeyNodes.clear();
    this.mRoots.clear();
  }
  
  void getSortedViews(DittoArea[] paramArrayOfDittoArea, String... paramVarArgs)
  {
    paramVarArgs = findRoots(paramVarArgs);
    int i = 0;
    for (;;)
    {
      Object localObject1 = (RelativeAreaLayout.DependencyGraph.Node)paramVarArgs.pollLast();
      if (localObject1 == null) {
        break;
      }
      Object localObject2 = ((RelativeAreaLayout.DependencyGraph.Node)localObject1).area;
      String str = ((DittoArea)localObject2).getId();
      paramArrayOfDittoArea[i] = localObject2;
      localObject1 = ((RelativeAreaLayout.DependencyGraph.Node)localObject1).dependents.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RelativeAreaLayout.DependencyGraph.Node)((Iterator)localObject1).next();
        Map localMap = ((RelativeAreaLayout.DependencyGraph.Node)localObject2).dependencies;
        localMap.remove(str);
        if (localMap.size() == 0) {
          paramVarArgs.add(localObject2);
        }
      }
      i += 1;
    }
    if (i < paramArrayOfDittoArea.length) {
      throw new IllegalStateException("Circular dependencies cannot exist in RelativeLayout");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.widget.RelativeAreaLayout.DependencyGraph
 * JD-Core Version:    0.7.0.1
 */