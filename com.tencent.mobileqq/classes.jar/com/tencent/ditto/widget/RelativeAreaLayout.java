package com.tencent.ditto.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.view.View.MeasureSpec;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.Map;

public class RelativeAreaLayout
  extends DittoAreaGroup
{
  private boolean mAllowBrokenMeasureSpecs = false;
  private boolean mDirtyHierarchy;
  private final RelativeAreaLayout.DependencyGraph mGraph = new RelativeAreaLayout.DependencyGraph(null);
  private int mGravity = 8388659;
  private boolean mMeasureVerticalWithPaddingMargin = false;
  private int mOrientation = 1;
  private DittoArea[] mSortedHorizontalChildren;
  private DittoArea[] mSortedVerticalChildren;
  
  public RelativeAreaLayout(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    setOrientation(paramLayoutAttrSet.orientation);
    queryCompatibilityModes(paramDittoHost.getContext());
  }
  
  private void applyHorizontalSizeRules(LayoutAttrSet paramLayoutAttrSet, int paramInt, Map<String, Object> paramMap)
  {
    paramLayoutAttrSet.left = -2147483648;
    paramLayoutAttrSet.right = -2147483648;
    LayoutAttrSet localLayoutAttrSet = getRelatedViewParams(paramMap, "toLeftOf");
    if (localLayoutAttrSet != null) {
      paramLayoutAttrSet.right = (localLayoutAttrSet.left - (localLayoutAttrSet.leftMargin + paramLayoutAttrSet.rightMargin));
    } else if ((paramLayoutAttrSet.alignWithParentIfMissing) && (paramMap.get("toLeftOf") != null) && (paramInt >= 0)) {
      paramLayoutAttrSet.right = (paramInt - this.paddingRight - paramLayoutAttrSet.rightMargin);
    }
    localLayoutAttrSet = getRelatedViewParams(paramMap, "toRightOf");
    if (localLayoutAttrSet != null) {
      paramLayoutAttrSet.left = (localLayoutAttrSet.right + (localLayoutAttrSet.rightMargin + paramLayoutAttrSet.leftMargin));
    } else if ((paramLayoutAttrSet.alignWithParentIfMissing) && (paramMap.get("toRightOf") != null)) {
      paramLayoutAttrSet.left = (this.paddingLeft + paramLayoutAttrSet.leftMargin);
    }
    localLayoutAttrSet = getRelatedViewParams(paramMap, "alignLeft");
    if (localLayoutAttrSet != null) {
      localLayoutAttrSet.left += paramLayoutAttrSet.leftMargin;
    } else if ((paramLayoutAttrSet.alignWithParentIfMissing) && (paramMap.get("alignLeft") != null)) {
      paramLayoutAttrSet.left = (this.paddingLeft + paramLayoutAttrSet.leftMargin);
    }
    localLayoutAttrSet = getRelatedViewParams(paramMap, "alignRight");
    if (localLayoutAttrSet != null) {
      localLayoutAttrSet.right -= paramLayoutAttrSet.rightMargin;
    } else if ((paramLayoutAttrSet.alignWithParentIfMissing) && (paramMap.get("alignRight") != null) && (paramInt >= 0)) {
      paramLayoutAttrSet.right = (paramInt - this.paddingRight - paramLayoutAttrSet.rightMargin);
    }
    if ((paramMap.get("alignParentLeft") != null) && (((Boolean)paramMap.get("alignParentLeft")).booleanValue())) {
      paramLayoutAttrSet.left = (this.paddingLeft + paramLayoutAttrSet.leftMargin);
    }
    if ((paramMap.get("alignParentRight") != null) && (((Boolean)paramMap.get("alignParentRight")).booleanValue()) && (paramInt >= 0)) {
      paramLayoutAttrSet.right = (paramInt - this.paddingRight - paramLayoutAttrSet.rightMargin);
    }
  }
  
  private void applyVerticalSizeRules(LayoutAttrSet paramLayoutAttrSet, int paramInt)
  {
    Map localMap = paramLayoutAttrSet.mAttrs;
    paramLayoutAttrSet.top = -2147483648;
    paramLayoutAttrSet.bottom = -2147483648;
    LayoutAttrSet localLayoutAttrSet = getRelatedViewParams(localMap, "above");
    if (localLayoutAttrSet != null) {
      paramLayoutAttrSet.bottom = (localLayoutAttrSet.top - (localLayoutAttrSet.topMargin + paramLayoutAttrSet.bottomMargin));
    } else if ((paramLayoutAttrSet.alignWithParentIfMissing) && (localMap.get("above") != null) && (paramInt >= 0)) {
      paramLayoutAttrSet.bottom = (paramInt - this.paddingBottom - paramLayoutAttrSet.bottomMargin);
    }
    localLayoutAttrSet = getRelatedViewParams(localMap, "below");
    if (localLayoutAttrSet != null) {
      paramLayoutAttrSet.top = (localLayoutAttrSet.bottom + (localLayoutAttrSet.bottomMargin + paramLayoutAttrSet.topMargin));
    } else if ((paramLayoutAttrSet.alignWithParentIfMissing) && (localMap.get("below") != null)) {
      paramLayoutAttrSet.top = (this.paddingTop + paramLayoutAttrSet.topMargin);
    }
    localLayoutAttrSet = getRelatedViewParams(localMap, "alignTop");
    if (localLayoutAttrSet != null) {
      localLayoutAttrSet.top += paramLayoutAttrSet.topMargin;
    } else if ((paramLayoutAttrSet.alignWithParentIfMissing) && (localMap.get("alignTop") != null)) {
      paramLayoutAttrSet.top = (this.paddingTop + paramLayoutAttrSet.topMargin);
    }
    localLayoutAttrSet = getRelatedViewParams(localMap, "alignBottom");
    if (localLayoutAttrSet != null) {
      localLayoutAttrSet.bottom -= paramLayoutAttrSet.bottomMargin;
    } else if ((paramLayoutAttrSet.alignWithParentIfMissing) && (localMap.get("alignBottom") != null) && (paramInt >= 0)) {
      paramLayoutAttrSet.bottom = (paramInt - this.paddingBottom - paramLayoutAttrSet.bottomMargin);
    }
    if ((localMap.get("alignParentTop") != null) && (((Boolean)localMap.get("alignParentTop")).booleanValue())) {
      paramLayoutAttrSet.top = (this.paddingTop + paramLayoutAttrSet.topMargin);
    }
    if ((localMap.get("alignParentBottom") != null) && (((Boolean)localMap.get("alignParentBottom")).booleanValue()) && (paramInt >= 0)) {
      paramLayoutAttrSet.bottom = (paramInt - this.paddingBottom - paramLayoutAttrSet.bottomMargin);
    }
  }
  
  private static void centerHorizontal(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt)
  {
    int i = paramDittoArea.getMeasuredWidth();
    paramInt = (paramInt - i) / 2;
    paramLayoutAttrSet.left = paramInt;
    paramLayoutAttrSet.right = (paramInt + i);
  }
  
  private static void centerVertical(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt)
  {
    int i = paramDittoArea.getMeasuredHeight();
    paramInt = (paramInt - i) / 2;
    paramLayoutAttrSet.top = paramInt;
    paramLayoutAttrSet.bottom = (paramInt + i);
  }
  
  private int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = 1073741824;
    if ((paramInt8 < 0) && (!this.mAllowBrokenMeasureSpecs))
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
      paramInt1 = i;
      paramInt2 = paramInt4;
    }
    else if (paramInt3 >= 0)
    {
      paramInt1 = paramInt3;
      if (paramInt4 >= 0) {
        paramInt1 = Math.min(paramInt4, paramInt3);
      }
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    else if (paramInt3 == -1)
    {
      paramInt1 = i;
      paramInt2 = paramInt4;
    }
    else if ((paramInt3 == -2) && (paramInt4 >= 0))
    {
      paramInt1 = -2147483648;
      paramInt2 = paramInt4;
    }
    else
    {
      paramInt2 = 0;
      paramInt1 = 0;
    }
    return View.MeasureSpec.makeMeasureSpec(paramInt2, paramInt1);
  }
  
  private DittoArea getRelatedView(Map<String, Object> paramMap, String paramString)
  {
    paramMap = (String)paramMap.get(paramString);
    if (paramMap != null)
    {
      paramMap = (RelativeAreaLayout.DependencyGraph.Node)RelativeAreaLayout.DependencyGraph.access$100(this.mGraph).get(paramMap);
      if (paramMap == null) {
        return null;
      }
      for (paramMap = paramMap.area; paramMap.getVisibility() == 8; paramMap = paramMap.area)
      {
        paramMap = paramMap.getLayoutAttr().mAttrs;
        paramMap = (RelativeAreaLayout.DependencyGraph.Node)RelativeAreaLayout.DependencyGraph.access$100(this.mGraph).get(paramMap.get(paramString));
        if (paramMap == null) {
          return null;
        }
      }
      return paramMap;
    }
    return null;
  }
  
  private LayoutAttrSet getRelatedViewParams(Map<String, Object> paramMap, String paramString)
  {
    paramMap = getRelatedView(paramMap, paramString);
    if ((paramMap != null) && (paramMap.getLayoutAttr() != null)) {
      return paramMap.getLayoutAttr();
    }
    return null;
  }
  
  private void measureChild(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt1, int paramInt2)
  {
    paramDittoArea.measure(getChildMeasureSpec(paramLayoutAttrSet.left, paramLayoutAttrSet.right, paramLayoutAttrSet.width, paramLayoutAttrSet.leftMargin, paramLayoutAttrSet.rightMargin, this.paddingLeft, this.paddingRight, paramInt1), getChildMeasureSpec(paramLayoutAttrSet.top, paramLayoutAttrSet.bottom, paramLayoutAttrSet.height, paramLayoutAttrSet.topMargin, paramLayoutAttrSet.bottomMargin, this.paddingTop, this.paddingBottom, paramInt2));
  }
  
  private void measureChildHorizontal(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt1, int paramInt2)
  {
    int i = getChildMeasureSpec(paramLayoutAttrSet.left, paramLayoutAttrSet.right, paramLayoutAttrSet.width, paramLayoutAttrSet.leftMargin, paramLayoutAttrSet.rightMargin, this.paddingLeft, this.paddingRight, paramInt1);
    if (this.mMeasureVerticalWithPaddingMargin) {
      paramInt1 = Math.max(0, paramInt2 - this.paddingTop - this.paddingBottom - paramLayoutAttrSet.topMargin - paramLayoutAttrSet.bottomMargin);
    } else {
      paramInt1 = paramInt2;
    }
    if ((paramInt2 < 0) && (!this.mAllowBrokenMeasureSpecs))
    {
      if (paramLayoutAttrSet.height >= 0) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramLayoutAttrSet.height, 1073741824);
      } else {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
    }
    else if (paramLayoutAttrSet.height == -1) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    } else {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648);
    }
    paramDittoArea.measure(i, paramInt1);
  }
  
  private boolean positionChildHorizontal(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt, boolean paramBoolean)
  {
    Map localMap = paramLayoutAttrSet.mAttrs;
    if ((paramLayoutAttrSet.left == -2147483648) && (paramLayoutAttrSet.right != -2147483648))
    {
      paramLayoutAttrSet.left = (paramLayoutAttrSet.right - paramDittoArea.getMeasuredWidth());
    }
    else if ((paramLayoutAttrSet.left != -2147483648) && (paramLayoutAttrSet.right == -2147483648))
    {
      paramLayoutAttrSet.right = (paramLayoutAttrSet.left + paramDittoArea.getMeasuredWidth());
    }
    else if ((paramLayoutAttrSet.left == -2147483648) && (paramLayoutAttrSet.right == -2147483648))
    {
      if (((localMap.get("centerInParent") != null) && (((Boolean)localMap.get("centerInParent")).booleanValue())) || ((localMap.get("centerHorizontal") != null) && (((Boolean)localMap.get("centerHorizontal")).booleanValue())))
      {
        if (!paramBoolean)
        {
          centerHorizontal(paramDittoArea, paramLayoutAttrSet, paramInt);
          return true;
        }
        paramLayoutAttrSet.left = (this.paddingLeft + paramLayoutAttrSet.leftMargin);
        paramLayoutAttrSet.right = (paramLayoutAttrSet.left + paramDittoArea.getMeasuredWidth());
        return true;
      }
      paramLayoutAttrSet.left = (this.paddingLeft + paramLayoutAttrSet.leftMargin);
      paramLayoutAttrSet.right = (paramLayoutAttrSet.left + paramDittoArea.getMeasuredWidth());
    }
    return (localMap.get("alignParentRight") != null) && (((Boolean)localMap.get("alignParentRight")).booleanValue());
  }
  
  private boolean positionChildVertical(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt, boolean paramBoolean)
  {
    Map localMap = paramLayoutAttrSet.mAttrs;
    if ((paramLayoutAttrSet.top == -2147483648) && (paramLayoutAttrSet.bottom != -2147483648))
    {
      paramLayoutAttrSet.top = (paramLayoutAttrSet.bottom - paramDittoArea.getMeasuredHeight());
    }
    else if ((paramLayoutAttrSet.top != -2147483648) && (paramLayoutAttrSet.bottom == -2147483648))
    {
      paramLayoutAttrSet.bottom = (paramLayoutAttrSet.top + paramDittoArea.getMeasuredHeight());
    }
    else if ((paramLayoutAttrSet.top == -2147483648) && (paramLayoutAttrSet.bottom == -2147483648))
    {
      if (((localMap.get("centerInParent") != null) && (((Boolean)localMap.get("centerInParent")).booleanValue())) || ((localMap.get("centerVertical") != null) && (((Boolean)localMap.get("centerVertical")).booleanValue())))
      {
        if (!paramBoolean)
        {
          centerVertical(paramDittoArea, paramLayoutAttrSet, paramInt);
          return true;
        }
        paramLayoutAttrSet.top = (this.paddingTop + paramLayoutAttrSet.topMargin);
        paramLayoutAttrSet.bottom = (paramLayoutAttrSet.top + paramDittoArea.getMeasuredHeight());
        return true;
      }
      paramLayoutAttrSet.top = (this.paddingTop + paramLayoutAttrSet.topMargin);
      paramLayoutAttrSet.bottom = (paramLayoutAttrSet.top + paramDittoArea.getMeasuredHeight());
    }
    return (localMap.get("alignParentBottom") != null) && (((Boolean)localMap.get("alignParentBottom")).booleanValue());
  }
  
  private void queryCompatibilityModes(Context paramContext)
  {
    int i = paramContext.getApplicationInfo().targetSdkVersion;
    boolean bool2 = true;
    boolean bool1;
    if (i <= 17) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mAllowBrokenMeasureSpecs = bool1;
    if (i >= 18) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.mMeasureVerticalWithPaddingMargin = bool1;
  }
  
  private void sortChildren()
  {
    int j = getChildCount();
    Object localObject = this.mSortedVerticalChildren;
    if ((localObject == null) || (localObject.length != j)) {
      this.mSortedVerticalChildren = new DittoArea[j];
    }
    localObject = this.mSortedHorizontalChildren;
    if ((localObject == null) || (localObject.length != j)) {
      this.mSortedHorizontalChildren = new DittoArea[j];
    }
    localObject = this.mGraph;
    ((RelativeAreaLayout.DependencyGraph)localObject).clear();
    int i = 0;
    while (i < j)
    {
      ((RelativeAreaLayout.DependencyGraph)localObject).add(getChildAt(i));
      i += 1;
    }
    ((RelativeAreaLayout.DependencyGraph)localObject).getSortedViews(this.mSortedVerticalChildren, LayoutAttrDefine.RULES_VERTICAL);
    ((RelativeAreaLayout.DependencyGraph)localObject).getSortedViews(this.mSortedHorizontalChildren, LayoutAttrDefine.RULES_HORIZONTAL);
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getSuggestedMinimumHeight()
  {
    if (this.mBackground == null) {
      return 0;
    }
    return Math.max(0, this.mBackground.getMinimumHeight());
  }
  
  public int getSuggestedMinimumWidth()
  {
    if (this.mBackground == null) {
      return 0;
    }
    return Math.max(0, this.mBackground.getMinimumWidth());
  }
  
  public void onLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      DittoArea localDittoArea = getChildAt(i);
      if (localDittoArea.getVisibility() != 8)
      {
        LayoutAttrSet localLayoutAttrSet = localDittoArea.getLayoutAttr();
        localDittoArea.layout(localLayoutAttrSet.left, localLayoutAttrSet.top, localLayoutAttrSet.right, localLayoutAttrSet.bottom);
      }
      i += 1;
    }
    super.onLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    sortChildren();
    int n = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if (n == 0) {
      k = -1;
    }
    if (i1 == 0) {
      m = -1;
    }
    int i;
    if (n == 1073741824) {
      i = k;
    } else {
      i = 0;
    }
    if (i1 == 1073741824) {
      j = m;
    } else {
      j = 0;
    }
    boolean bool1;
    if (n != 1073741824) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (i1 != 1073741824) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Object localObject1 = this.mSortedHorizontalChildren;
    int i3 = localObject1.length;
    n = 0;
    Object localObject2;
    Object localObject3;
    for (int i2 = 0; n < i3; i2 = i1)
    {
      localObject2 = localObject1[n];
      i1 = i2;
      if (((DittoArea)localObject2).getVisibility() != 8)
      {
        localObject3 = ((DittoArea)localObject2).getLayoutAttr();
        applyHorizontalSizeRules((LayoutAttrSet)localObject3, k, ((LayoutAttrSet)localObject3).mAttrs);
        measureChildHorizontal((DittoArea)localObject2, (LayoutAttrSet)localObject3, k, m);
        i1 = i2;
        if (positionChildHorizontal((DittoArea)localObject2, (LayoutAttrSet)localObject3, k, bool1)) {
          i1 = 1;
        }
      }
      n += 1;
    }
    localObject1 = this.mSortedVerticalChildren;
    int i7 = localObject1.length;
    int i8 = getContext().getApplicationInfo().targetSdkVersion;
    n = j;
    int j = 0;
    i3 = 0;
    while (i3 < i7)
    {
      localObject2 = localObject1[i3];
      int i5 = i;
      int i6 = n;
      int i4 = j;
      if (((DittoArea)localObject2).getVisibility() != 8)
      {
        localObject3 = ((DittoArea)localObject2).getLayoutAttr();
        applyVerticalSizeRules((LayoutAttrSet)localObject3, m);
        measureChild((DittoArea)localObject2, (LayoutAttrSet)localObject3, k, m);
        i1 = j;
        if (positionChildVertical((DittoArea)localObject2, (LayoutAttrSet)localObject3, m, bool2)) {
          i1 = 1;
        }
        j = i;
        if (bool1) {
          if (i8 < 19) {
            j = Math.max(i, ((LayoutAttrSet)localObject3).right);
          } else {
            j = Math.max(i, ((LayoutAttrSet)localObject3).right + ((LayoutAttrSet)localObject3).rightMargin);
          }
        }
        i5 = j;
        i6 = n;
        i4 = i1;
        if (bool2)
        {
          if (i8 < 19) {
            i = Math.max(n, ((LayoutAttrSet)localObject3).bottom);
          } else {
            i = Math.max(n, ((LayoutAttrSet)localObject3).bottom + ((LayoutAttrSet)localObject3).bottomMargin);
          }
          i4 = i1;
          i6 = i;
          i5 = j;
        }
      }
      i3 += 1;
      i = i5;
      n = i6;
      j = i4;
    }
    k = i;
    if (bool1)
    {
      k = i + this.paddingRight;
      i = k;
      if (getLayoutAttr() != null)
      {
        i = k;
        if (getLayoutAttr().width >= 0) {
          i = Math.max(k, getLayoutAttr().width);
        }
      }
      i = resolveSize(Math.max(i, getSuggestedMinimumWidth()), paramInt1);
      k = i;
      if (i2 != 0)
      {
        paramInt1 = 0;
        for (;;)
        {
          k = i;
          if (paramInt1 >= i7) {
            break;
          }
          localObject1 = getChildAt(paramInt1);
          if (((DittoArea)localObject1).getVisibility() != 8)
          {
            localObject2 = ((DittoArea)localObject1).getLayoutAttr();
            localObject3 = ((LayoutAttrSet)localObject2).mAttrs;
            if (((((Map)localObject3).get("centerInParent") != null) && (((Boolean)((Map)localObject3).get("centerInParent")).booleanValue())) || ((((Map)localObject3).get("centerHorizontal") != null) && (((Boolean)((Map)localObject3).get("centerHorizontal")).booleanValue())))
            {
              centerHorizontal((DittoArea)localObject1, (LayoutAttrSet)localObject2, i);
            }
            else if ((((Map)localObject3).get("alignParentRight") != null) && (((Boolean)((Map)localObject3).get("alignParentRight")).booleanValue()))
            {
              k = ((DittoArea)localObject1).getMeasuredWidth();
              ((LayoutAttrSet)localObject2).left = (i - this.paddingRight - k);
              ((LayoutAttrSet)localObject2).right = (((LayoutAttrSet)localObject2).left + k);
            }
          }
          paramInt1 += 1;
        }
      }
    }
    paramInt1 = n;
    if (bool2)
    {
      i = n + this.paddingBottom;
      paramInt1 = i;
      if (getLayoutAttr() != null)
      {
        paramInt1 = i;
        if (getLayoutAttr().height >= 0) {
          paramInt1 = Math.max(i, getLayoutAttr().height);
        }
      }
      i = resolveSize(Math.max(paramInt1, getSuggestedMinimumHeight()), paramInt2);
      paramInt1 = i;
      if (j != 0)
      {
        paramInt2 = 0;
        for (;;)
        {
          paramInt1 = i;
          if (paramInt2 >= i7) {
            break;
          }
          localObject1 = getChildAt(paramInt2);
          if (((DittoArea)localObject1).getVisibility() != 8)
          {
            localObject2 = ((DittoArea)localObject1).getLayoutAttr();
            localObject3 = ((LayoutAttrSet)localObject2).mAttrs;
            if (((((Map)localObject3).get("centerInParent") != null) && (((Boolean)((Map)localObject3).get("centerInParent")).booleanValue())) || ((((Map)localObject3).get("centerVertical") != null) && (((Boolean)((Map)localObject3).get("centerVertical")).booleanValue())))
            {
              centerVertical((DittoArea)localObject1, (LayoutAttrSet)localObject2, i);
            }
            else if ((((Map)localObject3).get("alignParentBottom") != null) && (((Boolean)((Map)localObject3).get("alignParentBottom")).booleanValue()))
            {
              paramInt1 = ((DittoArea)localObject1).getMeasuredHeight();
              ((LayoutAttrSet)localObject2).top = (i - this.paddingBottom - paramInt1);
              ((LayoutAttrSet)localObject2).bottom = (((LayoutAttrSet)localObject2).top + paramInt1);
            }
          }
          paramInt2 += 1;
        }
      }
    }
    setMeasuredDimension(k, paramInt1);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.mDirtyHierarchy = true;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.widget.RelativeAreaLayout
 * JD-Core Version:    0.7.0.1
 */