package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper;

import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout.Params;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RelativeLayoutHelper
{
  private static final int VALUE_NOT_SET = -2147483648;
  private Map<String, RelativeLayoutHelper.Node> keyNodes;
  private RelativeLayout parent;
  private List<ViewBase> subViews;
  
  private static void centerHorizontal(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt)
  {
    int j = paramViewBase.getComMeasuredWidth();
    int i = j;
    if (j > paramInt) {
      i = paramInt;
    }
    paramInt = (paramInt - i) / 2;
    paramParams.mLeft = paramInt;
    paramParams.mRight = (paramInt + i);
  }
  
  private static void centerVertical(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt, boolean paramBoolean)
  {
    int j = paramViewBase.getComMeasuredHeight();
    int i = paramInt;
    if (paramBoolean)
    {
      i = paramInt;
      if (j > paramInt) {
        i = j;
      }
    }
    paramInt = (i - j) / 2;
    paramParams.mTop = paramInt;
    paramParams.mBottom = (paramInt + j);
  }
  
  private List<RelativeLayoutHelper.Node> findRoots(List<ViewBase> paramList, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      Object localObject1 = (ViewBase)paramList.get(i);
      localObject1 = (RelativeLayoutHelper.Node)this.keyNodes.get(((ViewBase)localObject1).getName());
      String[] arrayOfString = ((RelativeLayout.Params)((RelativeLayoutHelper.Node)localObject1).view.getComLayoutParams()).getRule();
      int m = paramArrayOfInt.length;
      int j = 0;
      while (j < m)
      {
        Object localObject2 = arrayOfString[paramArrayOfInt[j]];
        if (localObject2 != null)
        {
          localObject2 = (RelativeLayoutHelper.Node)this.keyNodes.get(localObject2);
          if ((localObject2 != null) && (localObject2 != localObject1))
          {
            ((RelativeLayoutHelper.Node)localObject2).lastItem.add(localObject1);
            ((RelativeLayoutHelper.Node)localObject1).thisRuleNode.add(localObject2);
          }
        }
        j += 1;
      }
      i += 1;
    }
    paramList = this.keyNodes.entrySet().iterator();
    while (paramList.hasNext())
    {
      paramArrayOfInt = (RelativeLayoutHelper.Node)((Map.Entry)paramList.next()).getValue();
      if (paramArrayOfInt.thisRuleNode.isEmpty()) {
        localArrayList.add(paramArrayOfInt);
      }
    }
    return localArrayList;
  }
  
  private int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int j;
    if (paramInt8 < 0) {
      j = 1;
    } else {
      j = 0;
    }
    int i = 1073741824;
    if (j != 0)
    {
      if ((paramInt1 != -2147483648) && (paramInt2 != -2147483648))
      {
        paramInt3 = Math.max(0, paramInt2 - paramInt1);
      }
      else if (paramInt3 < 0)
      {
        paramInt3 = 0;
        i = 0;
      }
      return View.MeasureSpec.makeMeasureSpec(paramInt3, i);
    }
    if (paramInt1 == -2147483648) {
      paramInt4 += paramInt6;
    } else {
      paramInt4 = paramInt1;
    }
    if (paramInt2 == -2147483648) {
      paramInt5 = paramInt8 - paramInt7 - paramInt5;
    } else {
      paramInt5 = paramInt2;
    }
    paramInt4 = paramInt5 - paramInt4;
    if ((paramInt1 != -2147483648) && (paramInt2 != -2147483648))
    {
      paramInt2 = i;
      if (j != 0) {
        paramInt2 = 0;
      }
      paramInt1 = Math.max(0, paramInt4);
    }
    else if (paramInt3 >= 0)
    {
      paramInt2 = i;
      paramInt1 = paramInt3;
      if (paramInt4 >= 0)
      {
        paramInt1 = Math.min(paramInt4, paramInt3);
        paramInt2 = i;
      }
    }
    else if (paramInt3 == -1)
    {
      paramInt2 = i;
      if (j != 0) {
        paramInt2 = 0;
      }
      paramInt1 = Math.max(0, paramInt4);
    }
    else
    {
      paramInt1 = 0;
      paramInt2 = 0;
    }
    return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
  }
  
  private static Map<String, RelativeLayoutHelper.Node> getNodes(List<ViewBase> paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size());
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    ViewBase localViewBase;
    RelativeLayoutHelper.Node localNode;
    while (paramList.hasNext())
    {
      localViewBase = (ViewBase)paramList.next();
      if (TextUtils.isEmpty(localViewBase.getName()))
      {
        ((List)localObject).add(localViewBase);
      }
      else
      {
        localNode = new RelativeLayoutHelper.Node();
        localNode.view = localViewBase;
        localHashMap.put(localViewBase.getName(), localNode);
      }
    }
    int i = 10000;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localViewBase = (ViewBase)((Iterator)localObject).next();
      localNode = new RelativeLayoutHelper.Node();
      localNode.view = localViewBase;
      for (paramList = String.valueOf(i); localHashMap.containsKey(paramList); paramList = String.valueOf(i)) {
        i += 1;
      }
      localViewBase.setName(paramList);
      localHashMap.put(localViewBase.getName(), localNode);
    }
    return localHashMap;
  }
  
  private RelativeLayout.Params getRelatedViewParams(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString[paramInt] == null) {
      return null;
    }
    paramArrayOfString = (RelativeLayoutHelper.Node)this.keyNodes.get(paramArrayOfString[paramInt]);
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.view.isGone()) {
        return null;
      }
      return (RelativeLayout.Params)paramArrayOfString.view.getComLayoutParams();
    }
    return null;
  }
  
  public static boolean hasVerticleCenterRule(RelativeLayout.Params paramParams)
  {
    paramParams = paramParams.getRule();
    return (paramParams[10] != null) || (paramParams[8] != null);
  }
  
  private void initCheck()
  {
    RelativeLayout localRelativeLayout = this.parent;
    if ((localRelativeLayout != null) && (this.subViews != null))
    {
      if ((localRelativeLayout.getSubViews() != this.subViews) || (this.parent.getSubViews().size() != this.subViews.size())) {
        this.subViews = this.parent.getSubViews();
      }
      this.keyNodes = getNodes(this.subViews);
      return;
    }
    throw new IllegalArgumentException("subViews 为 null");
  }
  
  private static void removeNode(List<RelativeLayoutHelper.Node> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      RelativeLayoutHelper.Node localNode = (RelativeLayoutHelper.Node)localIterator.next();
      if (localNode.view.getName().equals(paramString))
      {
        paramString = localNode;
        break label47;
      }
    }
    paramString = null;
    label47:
    paramList.remove(paramString);
  }
  
  public void applyHorizontalSizeRules(RelativeLayout.Params paramParams, int paramInt)
  {
    String[] arrayOfString = paramParams.getRule();
    paramParams.mLeft = -2147483648;
    paramParams.mRight = -2147483648;
    RelativeLayout.Params localParams = getRelatedViewParams(arrayOfString, 2);
    if (localParams != null) {
      paramParams.mRight = (localParams.mLeft - (localParams.mLayoutMarginLeft + paramParams.mLayoutMarginRight));
    }
    localParams = getRelatedViewParams(arrayOfString, 3);
    if (localParams != null) {
      paramParams.mLeft = (localParams.mRight + (localParams.mLayoutMarginRight + paramParams.mLayoutMarginLeft));
    }
    if (arrayOfString[4] != null) {
      paramParams.mLeft = (this.parent.getComPaddingLeft() + paramParams.mLayoutMarginLeft);
    }
    if ((arrayOfString[5] != null) && (paramInt >= 0)) {
      paramParams.mRight = (paramInt - this.parent.getComPaddingRight() - paramParams.mLayoutMarginRight);
    }
  }
  
  public void applyVerticalSizeRules(RelativeLayout.Params paramParams, int paramInt)
  {
    String[] arrayOfString = paramParams.getRule();
    paramParams.mTop = -2147483648;
    paramParams.mBottom = -2147483648;
    RelativeLayout.Params localParams = getRelatedViewParams(arrayOfString, 0);
    if (localParams != null) {
      paramParams.mBottom = (localParams.mTop - (localParams.mLayoutMarginTop + paramParams.mLayoutMarginBottom));
    } else if ((paramParams.alignWithParent) && (arrayOfString[0] != null) && (paramInt >= 0)) {
      paramParams.mBottom = (paramInt - this.parent.getComPaddingBottom() - paramParams.mLayoutMarginBottom);
    }
    localParams = getRelatedViewParams(arrayOfString, 1);
    if (localParams != null) {
      paramParams.mTop = (localParams.mBottom + (localParams.mLayoutMarginBottom + paramParams.mLayoutMarginTop));
    } else if ((paramParams.alignWithParent) && (arrayOfString[1] != null)) {
      paramParams.mTop = (this.parent.getComPaddingTop() + paramParams.mLayoutMarginTop);
    }
    if (arrayOfString[6] != null) {
      paramParams.mTop = (this.parent.getComPaddingTop() + paramParams.mLayoutMarginTop);
    }
    if ((arrayOfString[7] != null) && (paramInt >= 0)) {
      paramParams.mBottom = (paramInt - this.parent.getComPaddingBottom() - paramParams.mLayoutMarginBottom);
    }
  }
  
  public List<ViewBase> getHorizontalSortedView()
  {
    List localList = getSortedViews(RelativeLayout.Params.RULES_HORIZONTAL);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.getComLayoutParams().mLayoutWidth == -1) {
        localArrayList.add(localViewBase);
      }
    }
    localList.removeAll(localArrayList);
    localList.addAll(localArrayList);
    return localList;
  }
  
  public RelativeLayout getParent()
  {
    return this.parent;
  }
  
  public List<ViewBase> getSortedViews(int[] paramArrayOfInt)
  {
    initCheck();
    ArrayList localArrayList = new ArrayList(this.subViews.size());
    paramArrayOfInt = findRoots(this.subViews, paramArrayOfInt);
    int i = 0;
    while (i < paramArrayOfInt.size())
    {
      Object localObject1 = (RelativeLayoutHelper.Node)paramArrayOfInt.get(i);
      Object localObject2 = ((RelativeLayoutHelper.Node)localObject1).view;
      String str = ((ViewBase)localObject2).getName();
      localArrayList.add(localObject2);
      localObject1 = ((RelativeLayoutHelper.Node)localObject1).lastItem;
      int k = ((List)localObject1).size();
      int j = 0;
      while (j < k)
      {
        localObject2 = (RelativeLayoutHelper.Node)((List)localObject1).get(j);
        List localList = ((RelativeLayoutHelper.Node)localObject2).thisRuleNode;
        removeNode(localList, str);
        if (localList.size() == 0) {
          paramArrayOfInt.add(localObject2);
        }
        j += 1;
      }
      i += 1;
    }
    paramArrayOfInt.size();
    this.subViews.size();
    return localArrayList;
  }
  
  public List<ViewBase> getVerticalSortedView()
  {
    List localList = getSortedViews(RelativeLayout.Params.RULES_VERTICAL);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.getComLayoutParams().mLayoutHeight == -1) {
        localArrayList.add(localViewBase);
      }
    }
    localList.removeAll(localArrayList);
    localList.addAll(localArrayList);
    return localList;
  }
  
  public void measureChild(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt1, int paramInt2)
  {
    paramViewBase.measureComponent(getChildMeasureSpec(paramParams.mLeft, paramParams.mRight, paramParams.mLayoutWidth, paramParams.mLayoutMarginLeft, paramParams.mLayoutMarginRight, this.parent.getComPaddingLeft(), this.parent.getComPaddingRight(), paramInt1), getChildMeasureSpec(paramParams.mTop, paramParams.mBottom, paramParams.mLayoutHeight, paramParams.mLayoutMarginTop, paramParams.mLayoutMarginBottom, this.parent.getComPaddingTop(), this.parent.getComPaddingBottom(), paramInt2));
  }
  
  public void measureChildHorizontal(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt1, int paramInt2)
  {
    int i = paramParams.mLayoutWidth;
    i = getChildMeasureSpec(paramParams.mLeft, paramParams.mRight, i, paramParams.mLayoutMarginLeft, paramParams.mLayoutMarginRight, this.parent.getComPaddingLeft(), this.parent.getComPaddingRight(), paramInt1);
    paramInt1 = 1073741824;
    if (paramInt2 < 0)
    {
      if (paramParams.mLayoutHeight >= 0) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramParams.mLayoutHeight, 1073741824);
      } else {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
    }
    else
    {
      paramInt2 = Math.max(0, paramInt2 - this.parent.getComPaddingTop() - this.parent.getComPaddingBottom() - paramParams.mLayoutMarginTop - paramParams.mLayoutMarginBottom);
      if (paramParams.mLayoutHeight != -1) {
        paramInt1 = -2147483648;
      }
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, paramInt1);
    }
    paramViewBase.measureComponent(i, paramInt1);
  }
  
  public void positionChildHorizontal(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString = paramParams.getRule();
    if ((paramParams.mLeft == -2147483648) && (paramParams.mRight != -2147483648))
    {
      paramParams.mLeft = (paramParams.mRight - paramViewBase.getComMeasuredWidth());
      paramInt = this.parent.getComPaddingLeft() + paramParams.mLayoutMarginLeft;
      if (paramParams.mLeft < paramInt) {
        paramParams.mLeft = paramInt;
      }
    }
    else if ((paramParams.mLeft != -2147483648) && (paramParams.mRight == -2147483648))
    {
      paramParams.mRight = (paramParams.mLeft + paramViewBase.getComMeasuredWidth());
      if (paramInt > 0)
      {
        paramInt = paramInt - this.parent.getComPaddingRight() - paramParams.mLayoutMarginRight;
        if (paramParams.mRight > paramInt) {
          paramParams.mRight = paramInt;
        }
      }
    }
    else if ((paramParams.mLeft == -2147483648) && (paramParams.mRight == -2147483648))
    {
      if ((arrayOfString[10] == null) && (arrayOfString[9] == null))
      {
        paramParams.mLeft = (this.parent.getComPaddingLeft() + paramParams.mLayoutMarginLeft);
        paramParams.mRight = (paramParams.mLeft + paramViewBase.getComMeasuredWidth());
        return;
      }
      if (!paramBoolean)
      {
        centerHorizontal(paramViewBase, paramParams, paramInt);
        return;
      }
      paramParams.mLeft = (this.parent.getComPaddingLeft() + paramParams.mLayoutMarginLeft);
      paramParams.mRight = (paramParams.mLeft + paramViewBase.getComMeasuredWidth());
    }
  }
  
  public boolean positionChildVertical(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString = paramParams.getRule();
    if ((paramParams.mTop == -2147483648) && (paramParams.mBottom != -2147483648))
    {
      paramParams.mTop = (paramParams.mBottom - paramViewBase.getComMeasuredHeight());
    }
    else if ((paramParams.mTop != -2147483648) && (paramParams.mBottom == -2147483648))
    {
      paramParams.mBottom = (paramParams.mTop + paramViewBase.getComMeasuredHeight());
    }
    else if ((paramParams.mTop == -2147483648) && (paramParams.mBottom == -2147483648))
    {
      if (hasVerticleCenterRule(paramParams))
      {
        if ((paramBoolean) && (paramInt <= 0))
        {
          paramParams.mTop = (this.parent.getComPaddingTop() + paramParams.mLayoutMarginTop);
          paramParams.mBottom = (paramParams.mTop + paramViewBase.getComMeasuredHeight());
          return true;
        }
        centerVertical(paramViewBase, paramParams, paramInt, paramBoolean);
        return true;
      }
      paramParams.mTop = (this.parent.getComPaddingTop() + paramParams.mLayoutMarginTop);
      paramParams.mBottom = (paramParams.mTop + paramViewBase.getComMeasuredHeight());
    }
    return arrayOfString[7] != null;
  }
  
  public void setParent(RelativeLayout paramRelativeLayout)
  {
    this.parent = paramRelativeLayout;
    this.subViews = paramRelativeLayout.getSubViews();
    this.keyNodes = getNodes(this.subViews);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.RelativeLayoutHelper
 * JD-Core Version:    0.7.0.1
 */