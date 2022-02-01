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
    if (localLayoutAttrSet != null)
    {
      paramLayoutAttrSet.right = (localLayoutAttrSet.left - (localLayoutAttrSet.leftMargin + paramLayoutAttrSet.rightMargin));
      localLayoutAttrSet = getRelatedViewParams(paramMap, "toRightOf");
      if (localLayoutAttrSet == null) {
        break label269;
      }
      int i = localLayoutAttrSet.right;
      paramLayoutAttrSet.left = (localLayoutAttrSet.rightMargin + paramLayoutAttrSet.leftMargin + i);
      label84:
      localLayoutAttrSet = getRelatedViewParams(paramMap, "alignLeft");
      if (localLayoutAttrSet == null) {
        break label303;
      }
      localLayoutAttrSet.left += paramLayoutAttrSet.leftMargin;
      label112:
      localLayoutAttrSet = getRelatedViewParams(paramMap, "alignRight");
      if (localLayoutAttrSet == null) {
        break label337;
      }
    }
    for (localLayoutAttrSet.right -= paramLayoutAttrSet.rightMargin;; paramLayoutAttrSet.right = (paramInt - this.paddingRight - paramLayoutAttrSet.rightMargin)) {
      label269:
      label303:
      label337:
      do
      {
        if ((paramMap.get("alignParentLeft") != null) && (((Boolean)paramMap.get("alignParentLeft")).booleanValue())) {
          paramLayoutAttrSet.left = (this.paddingLeft + paramLayoutAttrSet.leftMargin);
        }
        if ((paramMap.get("alignParentRight") != null) && (((Boolean)paramMap.get("alignParentRight")).booleanValue()) && (paramInt >= 0)) {
          paramLayoutAttrSet.right = (paramInt - this.paddingRight - paramLayoutAttrSet.rightMargin);
        }
        return;
        if ((!paramLayoutAttrSet.alignWithParentIfMissing) || (paramMap.get("toLeftOf") == null) || (paramInt < 0)) {
          break;
        }
        paramLayoutAttrSet.right = (paramInt - this.paddingRight - paramLayoutAttrSet.rightMargin);
        break;
        if ((!paramLayoutAttrSet.alignWithParentIfMissing) || (paramMap.get("toRightOf") == null)) {
          break label84;
        }
        paramLayoutAttrSet.left = (this.paddingLeft + paramLayoutAttrSet.leftMargin);
        break label84;
        if ((!paramLayoutAttrSet.alignWithParentIfMissing) || (paramMap.get("alignLeft") == null)) {
          break label112;
        }
        paramLayoutAttrSet.left = (this.paddingLeft + paramLayoutAttrSet.leftMargin);
        break label112;
      } while ((!paramLayoutAttrSet.alignWithParentIfMissing) || (paramMap.get("alignRight") == null) || (paramInt < 0));
    }
  }
  
  private void applyVerticalSizeRules(LayoutAttrSet paramLayoutAttrSet, int paramInt)
  {
    Map localMap = paramLayoutAttrSet.mAttrs;
    paramLayoutAttrSet.top = -2147483648;
    paramLayoutAttrSet.bottom = -2147483648;
    LayoutAttrSet localLayoutAttrSet = getRelatedViewParams(localMap, "above");
    if (localLayoutAttrSet != null)
    {
      paramLayoutAttrSet.bottom = (localLayoutAttrSet.top - (localLayoutAttrSet.topMargin + paramLayoutAttrSet.bottomMargin));
      localLayoutAttrSet = getRelatedViewParams(localMap, "below");
      if (localLayoutAttrSet == null) {
        break label282;
      }
      int i = localLayoutAttrSet.bottom;
      paramLayoutAttrSet.top = (localLayoutAttrSet.bottomMargin + paramLayoutAttrSet.topMargin + i);
      label90:
      localLayoutAttrSet = getRelatedViewParams(localMap, "alignTop");
      if (localLayoutAttrSet == null) {
        break label317;
      }
      localLayoutAttrSet.top += paramLayoutAttrSet.topMargin;
      label119:
      localLayoutAttrSet = getRelatedViewParams(localMap, "alignBottom");
      if (localLayoutAttrSet == null) {
        break label352;
      }
    }
    for (localLayoutAttrSet.bottom -= paramLayoutAttrSet.bottomMargin;; paramLayoutAttrSet.bottom = (paramInt - this.paddingBottom - paramLayoutAttrSet.bottomMargin)) {
      label282:
      label317:
      label352:
      do
      {
        if ((localMap.get("alignParentTop") != null) && (((Boolean)localMap.get("alignParentTop")).booleanValue())) {
          paramLayoutAttrSet.top = (this.paddingTop + paramLayoutAttrSet.topMargin);
        }
        if ((localMap.get("alignParentBottom") != null) && (((Boolean)localMap.get("alignParentBottom")).booleanValue()) && (paramInt >= 0)) {
          paramLayoutAttrSet.bottom = (paramInt - this.paddingBottom - paramLayoutAttrSet.bottomMargin);
        }
        return;
        if ((!paramLayoutAttrSet.alignWithParentIfMissing) || (localMap.get("above") == null) || (paramInt < 0)) {
          break;
        }
        paramLayoutAttrSet.bottom = (paramInt - this.paddingBottom - paramLayoutAttrSet.bottomMargin);
        break;
        if ((!paramLayoutAttrSet.alignWithParentIfMissing) || (localMap.get("below") == null)) {
          break label90;
        }
        paramLayoutAttrSet.top = (this.paddingTop + paramLayoutAttrSet.topMargin);
        break label90;
        if ((!paramLayoutAttrSet.alignWithParentIfMissing) || (localMap.get("alignTop") == null)) {
          break label119;
        }
        paramLayoutAttrSet.top = (this.paddingTop + paramLayoutAttrSet.topMargin);
        break label119;
      } while ((!paramLayoutAttrSet.alignWithParentIfMissing) || (localMap.get("alignBottom") == null) || (paramInt < 0));
    }
  }
  
  private static void centerHorizontal(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt)
  {
    int i = paramDittoArea.getMeasuredWidth();
    paramInt = (paramInt - i) / 2;
    paramLayoutAttrSet.left = paramInt;
    paramLayoutAttrSet.right = (i + paramInt);
  }
  
  private static void centerVertical(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt)
  {
    int i = paramDittoArea.getMeasuredHeight();
    paramInt = (paramInt - i) / 2;
    paramLayoutAttrSet.top = paramInt;
    paramLayoutAttrSet.bottom = (i + paramInt);
  }
  
  private int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = 1073741824;
    int j = 0;
    int k = 0;
    if ((paramInt8 < 0) && (!this.mAllowBrokenMeasureSpecs))
    {
      if ((paramInt1 != -2147483648) && (paramInt2 != -2147483648))
      {
        paramInt3 = Math.max(0, paramInt2 - paramInt1);
        paramInt1 = 1073741824;
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
        if (paramInt3 >= 0)
        {
          paramInt1 = 1073741824;
        }
        else
        {
          paramInt3 = 0;
          paramInt1 = k;
        }
      }
    }
    if (paramInt1 == -2147483648) {}
    for (paramInt4 = paramInt6 + paramInt4;; paramInt4 = paramInt1)
    {
      if (paramInt2 == -2147483648) {}
      for (paramInt5 = paramInt8 - paramInt7 - paramInt5;; paramInt5 = paramInt2)
      {
        paramInt4 = paramInt5 - paramInt4;
        if ((paramInt1 != -2147483648) && (paramInt2 != -2147483648))
        {
          paramInt1 = paramInt4;
          paramInt2 = i;
        }
        for (;;)
        {
          return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
          if (paramInt3 >= 0)
          {
            if (paramInt4 >= 0)
            {
              paramInt1 = Math.min(paramInt4, paramInt3);
              paramInt2 = i;
            }
            else
            {
              paramInt1 = paramInt3;
              paramInt2 = i;
            }
          }
          else if (paramInt3 == -1)
          {
            paramInt1 = paramInt4;
            paramInt2 = i;
          }
          else if (paramInt3 == -2)
          {
            if (paramInt4 >= 0)
            {
              paramInt1 = paramInt4;
              paramInt2 = -2147483648;
            }
            else
            {
              paramInt2 = 0;
              paramInt1 = j;
            }
          }
          else
          {
            paramInt2 = 0;
            paramInt1 = j;
          }
        }
      }
    }
  }
  
  private DittoArea getRelatedView(Map<String, Object> paramMap, String paramString)
  {
    paramMap = (String)paramMap.get(paramString);
    if (paramMap != null)
    {
      paramMap = (RelativeAreaLayout.DependencyGraph.Node)RelativeAreaLayout.DependencyGraph.access$100(this.mGraph).get(paramMap);
      Object localObject;
      if (paramMap == null)
      {
        localObject = null;
        return localObject;
      }
      for (paramMap = paramMap.area;; paramMap = paramMap.area)
      {
        localObject = paramMap;
        if (paramMap.getVisibility() != 8) {
          break;
        }
        paramMap = paramMap.getLayoutAttr().mAttrs;
        paramMap = (RelativeAreaLayout.DependencyGraph.Node)RelativeAreaLayout.DependencyGraph.access$100(this.mGraph).get(paramMap.get(paramString));
        if (paramMap == null) {
          return null;
        }
      }
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
    if (this.mMeasureVerticalWithPaddingMargin) {}
    for (paramInt1 = Math.max(0, paramInt2 - this.paddingTop - this.paddingBottom - paramLayoutAttrSet.topMargin - paramLayoutAttrSet.bottomMargin);; paramInt1 = paramInt2)
    {
      if ((paramInt2 < 0) && (!this.mAllowBrokenMeasureSpecs)) {
        if (paramLayoutAttrSet.height >= 0) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(paramLayoutAttrSet.height, 1073741824);
        }
      }
      for (;;)
      {
        paramDittoArea.measure(i, paramInt1);
        return;
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        continue;
        if (paramLayoutAttrSet.width == -1) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        } else {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648);
        }
      }
    }
  }
  
  private boolean positionChildHorizontal(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt, boolean paramBoolean)
  {
    Map localMap = paramLayoutAttrSet.mAttrs;
    if ((paramLayoutAttrSet.left == -2147483648) && (paramLayoutAttrSet.right != -2147483648))
    {
      paramLayoutAttrSet.left = (paramLayoutAttrSet.right - paramDittoArea.getMeasuredWidth());
      if ((localMap.get("alignParentRight") == null) || (!((Boolean)localMap.get("alignParentRight")).booleanValue())) {
        break label255;
      }
    }
    label255:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      if ((paramLayoutAttrSet.left != -2147483648) && (paramLayoutAttrSet.right == -2147483648))
      {
        paramLayoutAttrSet.right = (paramLayoutAttrSet.left + paramDittoArea.getMeasuredWidth());
        break;
      }
      if ((paramLayoutAttrSet.left != -2147483648) || (paramLayoutAttrSet.right != -2147483648)) {
        break;
      }
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
      break;
    }
  }
  
  private boolean positionChildVertical(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet, int paramInt, boolean paramBoolean)
  {
    Map localMap = paramLayoutAttrSet.mAttrs;
    if ((paramLayoutAttrSet.top == -2147483648) && (paramLayoutAttrSet.bottom != -2147483648))
    {
      paramLayoutAttrSet.top = (paramLayoutAttrSet.bottom - paramDittoArea.getMeasuredHeight());
      if ((localMap.get("alignParentBottom") == null) || (!((Boolean)localMap.get("alignParentBottom")).booleanValue())) {
        break label255;
      }
    }
    label255:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      if ((paramLayoutAttrSet.top != -2147483648) && (paramLayoutAttrSet.bottom == -2147483648))
      {
        paramLayoutAttrSet.bottom = (paramLayoutAttrSet.top + paramDittoArea.getMeasuredHeight());
        break;
      }
      if ((paramLayoutAttrSet.top != -2147483648) || (paramLayoutAttrSet.bottom != -2147483648)) {
        break;
      }
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
      break;
    }
  }
  
  private void queryCompatibilityModes(Context paramContext)
  {
    boolean bool2 = true;
    int i = paramContext.getApplicationInfo().targetSdkVersion;
    if (i <= 17)
    {
      bool1 = true;
      this.mAllowBrokenMeasureSpecs = bool1;
      if (i < 18) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mMeasureVerticalWithPaddingMargin = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void sortChildren()
  {
    int j = getChildCount();
    if ((this.mSortedVerticalChildren == null) || (this.mSortedVerticalChildren.length != j)) {
      this.mSortedVerticalChildren = new DittoArea[j];
    }
    if ((this.mSortedHorizontalChildren == null) || (this.mSortedHorizontalChildren.length != j)) {
      this.mSortedHorizontalChildren = new DittoArea[j];
    }
    RelativeAreaLayout.DependencyGraph localDependencyGraph = this.mGraph;
    localDependencyGraph.clear();
    int i = 0;
    while (i < j)
    {
      localDependencyGraph.add(getChildAt(i));
      i += 1;
    }
    localDependencyGraph.getSortedViews(this.mSortedVerticalChildren, LayoutAttrDefine.RULES_VERTICAL);
    localDependencyGraph.getSortedViews(this.mSortedHorizontalChildren, LayoutAttrDefine.RULES_HORIZONTAL);
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
    int i = 0;
    int j = 0;
    int n = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if (n != 0) {}
    for (;;)
    {
      if (i1 != 0) {}
      for (;;)
      {
        if (n == 1073741824) {
          i = k;
        }
        if (i1 == 1073741824) {
          j = m;
        }
        boolean bool1;
        if (n != 1073741824)
        {
          bool1 = true;
          if (i1 == 1073741824) {
            break label202;
          }
        }
        int i2;
        int i3;
        Object localObject2;
        Object localObject3;
        label202:
        for (boolean bool2 = true;; bool2 = false)
        {
          localObject1 = this.mSortedHorizontalChildren;
          i2 = localObject1.length;
          i3 = 0;
          n = 0;
          while (n < i2)
          {
            localObject2 = localObject1[n];
            i1 = i3;
            if (((DittoArea)localObject2).getVisibility() != 8)
            {
              localObject3 = ((DittoArea)localObject2).getLayoutAttr();
              applyHorizontalSizeRules((LayoutAttrSet)localObject3, k, ((LayoutAttrSet)localObject3).mAttrs);
              measureChildHorizontal((DittoArea)localObject2, (LayoutAttrSet)localObject3, k, m);
              i1 = i3;
              if (positionChildHorizontal((DittoArea)localObject2, (LayoutAttrSet)localObject3, k, bool1)) {
                i1 = 1;
              }
            }
            n += 1;
            i3 = i1;
          }
          bool1 = false;
          break;
        }
        Object localObject1 = this.mSortedVerticalChildren;
        int i7 = localObject1.length;
        int i8 = getContext().getApplicationInfo().targetSdkVersion;
        i1 = 0;
        int i4 = 0;
        n = j;
        j = i1;
        if (i4 < i7)
        {
          localObject2 = localObject1[i4];
          int i5 = j;
          i2 = n;
          int i6 = i;
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
            if (bool1)
            {
              if (i8 >= 19) {
                break label419;
              }
              j = Math.max(i, ((LayoutAttrSet)localObject3).right);
            }
            label355:
            i5 = i1;
            i2 = n;
            i6 = j;
            if (bool2)
            {
              if (i8 >= 19) {
                break label439;
              }
              i2 = Math.max(n, ((LayoutAttrSet)localObject3).bottom);
              i6 = j;
              i5 = i1;
            }
          }
          for (;;)
          {
            i4 += 1;
            j = i5;
            n = i2;
            i = i6;
            break;
            label419:
            j = Math.max(i, ((LayoutAttrSet)localObject3).right + ((LayoutAttrSet)localObject3).rightMargin);
            break label355;
            label439:
            i2 = Math.max(n, ((LayoutAttrSet)localObject3).bottom + ((LayoutAttrSet)localObject3).bottomMargin);
            i5 = i1;
            i6 = j;
          }
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
          if (i3 != 0)
          {
            paramInt1 = 0;
            k = i;
            if (paramInt1 < i7)
            {
              localObject1 = getChildAt(paramInt1);
              if (((DittoArea)localObject1).getVisibility() != 8)
              {
                localObject2 = ((DittoArea)localObject1).getLayoutAttr();
                localObject3 = ((LayoutAttrSet)localObject2).mAttrs;
                if (((((Map)localObject3).get("centerInParent") == null) || (!((Boolean)((Map)localObject3).get("centerInParent")).booleanValue())) && ((((Map)localObject3).get("centerHorizontal") == null) || (!((Boolean)((Map)localObject3).get("centerHorizontal")).booleanValue()))) {
                  break label659;
                }
                centerHorizontal((DittoArea)localObject1, (LayoutAttrSet)localObject2, i);
              }
              for (;;)
              {
                paramInt1 += 1;
                break;
                label659:
                if ((((Map)localObject3).get("alignParentRight") != null) && (((Boolean)((Map)localObject3).get("alignParentRight")).booleanValue()))
                {
                  k = ((DittoArea)localObject1).getMeasuredWidth();
                  ((LayoutAttrSet)localObject2).left = (i - this.paddingRight - k);
                  ((LayoutAttrSet)localObject2).right = (k + ((LayoutAttrSet)localObject2).left);
                }
              }
            }
          }
        }
        paramInt1 = n;
        if (bool2)
        {
          i = this.paddingBottom + n;
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
            paramInt1 = i;
            if (paramInt2 < i7)
            {
              localObject1 = getChildAt(paramInt2);
              if (((DittoArea)localObject1).getVisibility() != 8)
              {
                localObject2 = ((DittoArea)localObject1).getLayoutAttr();
                localObject3 = ((LayoutAttrSet)localObject2).mAttrs;
                if (((((Map)localObject3).get("centerInParent") == null) || (!((Boolean)((Map)localObject3).get("centerInParent")).booleanValue())) && ((((Map)localObject3).get("centerVertical") == null) || (!((Boolean)((Map)localObject3).get("centerVertical")).booleanValue()))) {
                  break label912;
                }
                centerVertical((DittoArea)localObject1, (LayoutAttrSet)localObject2, i);
              }
              for (;;)
              {
                paramInt2 += 1;
                break;
                label912:
                if ((((Map)localObject3).get("alignParentBottom") != null) && (((Boolean)((Map)localObject3).get("alignParentBottom")).booleanValue()))
                {
                  paramInt1 = ((DittoArea)localObject1).getMeasuredHeight();
                  ((LayoutAttrSet)localObject2).top = (i - this.paddingBottom - paramInt1);
                  ((LayoutAttrSet)localObject2).bottom = (paramInt1 + ((LayoutAttrSet)localObject2).top);
                }
              }
            }
          }
        }
        setMeasuredDimension(k, paramInt1);
        return;
        m = -1;
      }
      k = -1;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ditto.widget.RelativeAreaLayout
 * JD-Core Version:    0.7.0.1
 */