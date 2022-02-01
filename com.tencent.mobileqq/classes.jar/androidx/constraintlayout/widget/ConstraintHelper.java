package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper
  extends View
{
  protected int mCount;
  protected Helper mHelperWidget;
  protected int[] mIds = new int[32];
  private HashMap<Integer, String> mMap = new HashMap();
  protected String mReferenceIds;
  protected boolean mUseViewMeasure = false;
  private View[] mViews = null;
  protected Context myContext;
  
  public ConstraintHelper(Context paramContext)
  {
    super(paramContext);
    this.myContext = paramContext;
    init(null);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.myContext = paramContext;
    init(paramAttributeSet);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.myContext = paramContext;
    init(paramAttributeSet);
  }
  
  private void addID(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (this.myContext == null) {
        return;
      }
      paramString = paramString.trim();
      if ((getParent() instanceof ConstraintLayout)) {
        localObject = (ConstraintLayout)getParent();
      }
      int i = findId(paramString);
      if (i != 0)
      {
        this.mMap.put(Integer.valueOf(i), paramString);
        addRscID(i);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find id of \"");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\"");
      Log.w("ConstraintHelper", ((StringBuilder)localObject).toString());
    }
  }
  
  private void addRscID(int paramInt)
  {
    if (paramInt == getId()) {
      return;
    }
    int i = this.mCount;
    int[] arrayOfInt = this.mIds;
    if (i + 1 > arrayOfInt.length) {
      this.mIds = Arrays.copyOf(arrayOfInt, arrayOfInt.length * 2);
    }
    arrayOfInt = this.mIds;
    i = this.mCount;
    arrayOfInt[i] = paramInt;
    this.mCount = (i + 1);
  }
  
  private int[] convertReferenceString(View paramView, String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    paramView.getContext();
    paramString = new int[arrayOfString.length];
    int i = 0;
    int k;
    for (int j = 0; i < arrayOfString.length; j = k)
    {
      int m = findId(arrayOfString[i].trim());
      k = j;
      if (m != 0)
      {
        paramString[j] = m;
        k = j + 1;
      }
      i += 1;
    }
    paramView = paramString;
    if (j != arrayOfString.length) {
      paramView = Arrays.copyOf(paramString, j);
    }
    return paramView;
  }
  
  private int findId(ConstraintLayout paramConstraintLayout, String paramString)
  {
    if (paramString != null)
    {
      if (paramConstraintLayout == null) {
        return 0;
      }
      Resources localResources = this.myContext.getResources();
      if (localResources == null) {
        return 0;
      }
      int j = paramConstraintLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramConstraintLayout.getChildAt(i);
        Object localObject;
        if (localView.getId() != -1) {
          localObject = null;
        }
        try
        {
          String str = localResources.getResourceEntryName(localView.getId());
          localObject = str;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          label75:
          break label75;
        }
        if (paramString.equals(localObject)) {
          return localView.getId();
        }
        i += 1;
      }
    }
    else
    {
      return 0;
    }
  }
  
  private int findId(String paramString)
  {
    ConstraintLayout localConstraintLayout;
    if ((getParent() instanceof ConstraintLayout)) {
      localConstraintLayout = (ConstraintLayout)getParent();
    } else {
      localConstraintLayout = null;
    }
    boolean bool = isInEditMode();
    int i = 0;
    int j = i;
    if (bool)
    {
      j = i;
      if (localConstraintLayout != null)
      {
        Object localObject = localConstraintLayout.getDesignInformation(0, paramString);
        j = i;
        if ((localObject instanceof Integer)) {
          j = ((Integer)localObject).intValue();
        }
      }
    }
    i = j;
    if (j == 0)
    {
      i = j;
      if (localConstraintLayout != null) {
        i = findId(localConstraintLayout, paramString);
      }
    }
    j = i;
    if (i == 0) {}
    try
    {
      j = R.id.class.getField(paramString).getInt(null);
      i = j;
      if (j == 0) {
        i = this.myContext.getResources().getIdentifier(paramString, "id", this.myContext.getPackageName());
      }
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        j = i;
      }
    }
  }
  
  public void addView(View paramView)
  {
    if (paramView == this) {
      return;
    }
    if (paramView.getId() == -1)
    {
      Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
      return;
    }
    if (paramView.getParent() == null)
    {
      Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
      return;
    }
    this.mReferenceIds = null;
    addRscID(paramView.getId());
    requestLayout();
  }
  
  protected void applyLayoutFeatures()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ConstraintLayout))) {
      applyLayoutFeatures((ConstraintLayout)localViewParent);
    }
  }
  
  protected void applyLayoutFeatures(ConstraintLayout paramConstraintLayout)
  {
    int j = getVisibility();
    float f;
    if (Build.VERSION.SDK_INT >= 21) {
      f = getElevation();
    } else {
      f = 0.0F;
    }
    int i = 0;
    while (i < this.mCount)
    {
      View localView = paramConstraintLayout.getViewById(this.mIds[i]);
      if (localView != null)
      {
        localView.setVisibility(j);
        if ((f > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
          localView.setTranslationZ(localView.getTranslationZ() + f);
        }
      }
      i += 1;
    }
  }
  
  public int[] getReferencedIds()
  {
    return Arrays.copyOf(this.mIds, this.mCount);
  }
  
  protected View[] getViews(ConstraintLayout paramConstraintLayout)
  {
    View[] arrayOfView = this.mViews;
    if ((arrayOfView == null) || (arrayOfView.length != this.mCount)) {
      this.mViews = new View[this.mCount];
    }
    int i = 0;
    while (i < this.mCount)
    {
      int j = this.mIds[i];
      this.mViews[i] = paramConstraintLayout.getViewById(j);
      i += 1;
    }
    return this.mViews;
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids)
        {
          this.mReferenceIds = paramAttributeSet.getString(k);
          setIds(this.mReferenceIds);
        }
        i += 1;
      }
    }
  }
  
  public void loadParameters(ConstraintSet.Constraint paramConstraint, HelperWidget paramHelperWidget, ConstraintLayout.LayoutParams paramLayoutParams, SparseArray<ConstraintWidget> paramSparseArray)
  {
    if (paramConstraint.layout.mReferenceIds != null) {
      setReferencedIds(paramConstraint.layout.mReferenceIds);
    } else if ((paramConstraint.layout.mReferenceIdString != null) && (paramConstraint.layout.mReferenceIdString.length() > 0)) {
      paramConstraint.layout.mReferenceIds = convertReferenceString(this, paramConstraint.layout.mReferenceIdString);
    }
    paramHelperWidget.removeAllIds();
    if (paramConstraint.layout.mReferenceIds != null)
    {
      int i = 0;
      while (i < paramConstraint.layout.mReferenceIds.length)
      {
        paramLayoutParams = (ConstraintWidget)paramSparseArray.get(paramConstraint.layout.mReferenceIds[i]);
        if (paramLayoutParams != null) {
          paramHelperWidget.add(paramLayoutParams);
        }
        i += 1;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = this.mReferenceIds;
    if (str != null) {
      setIds(str);
    }
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mUseViewMeasure)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  public void removeView(View paramView)
  {
    int j = paramView.getId();
    if (j == -1) {
      return;
    }
    this.mReferenceIds = null;
    int i = 0;
    while (i < this.mCount)
    {
      if (this.mIds[i] == j)
      {
        for (;;)
        {
          j = this.mCount;
          if (i >= j - 1) {
            break;
          }
          paramView = this.mIds;
          j = i + 1;
          paramView[i] = paramView[j];
          i = j;
        }
        this.mIds[(j - 1)] = 0;
        this.mCount = (j - 1);
        break;
      }
      i += 1;
    }
    requestLayout();
  }
  
  public void resolveRtl(ConstraintWidget paramConstraintWidget, boolean paramBoolean) {}
  
  protected void setIds(String paramString)
  {
    this.mReferenceIds = paramString;
    if (paramString == null) {
      return;
    }
    int i = 0;
    this.mCount = 0;
    for (;;)
    {
      int j = paramString.indexOf(',', i);
      if (j == -1)
      {
        addID(paramString.substring(i));
        return;
      }
      addID(paramString.substring(i, j));
      i = j + 1;
    }
  }
  
  public void setReferencedIds(int[] paramArrayOfInt)
  {
    this.mReferenceIds = null;
    int i = 0;
    this.mCount = 0;
    while (i < paramArrayOfInt.length)
    {
      addRscID(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public void updatePostConstraints(ConstraintLayout paramConstraintLayout) {}
  
  public void updatePostLayout(ConstraintLayout paramConstraintLayout) {}
  
  public void updatePostMeasure(ConstraintLayout paramConstraintLayout) {}
  
  public void updatePreDraw(ConstraintLayout paramConstraintLayout) {}
  
  public void updatePreLayout(ConstraintWidgetContainer paramConstraintWidgetContainer, Helper paramHelper, SparseArray<ConstraintWidget> paramSparseArray)
  {
    paramHelper.removeAllIds();
    int i = 0;
    while (i < this.mCount)
    {
      paramHelper.add((ConstraintWidget)paramSparseArray.get(this.mIds[i]));
      i += 1;
    }
  }
  
  public void updatePreLayout(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode()) {
      setIds(this.mReferenceIds);
    }
    Object localObject = this.mHelperWidget;
    if (localObject == null) {
      return;
    }
    ((Helper)localObject).removeAllIds();
    int i = 0;
    while (i < this.mCount)
    {
      int j = this.mIds[i];
      View localView = paramConstraintLayout.getViewById(j);
      localObject = localView;
      if (localView == null)
      {
        String str = (String)this.mMap.get(Integer.valueOf(j));
        j = findId(paramConstraintLayout, str);
        localObject = localView;
        if (j != 0)
        {
          this.mIds[i] = j;
          this.mMap.put(Integer.valueOf(j), str);
          localObject = paramConstraintLayout.getViewById(j);
        }
      }
      if (localObject != null) {
        this.mHelperWidget.add(paramConstraintLayout.getViewWidget((View)localObject));
      }
      i += 1;
    }
    this.mHelperWidget.updateConstraints(paramConstraintLayout.mLayoutWidget);
  }
  
  public void validateParams()
  {
    if (this.mHelperWidget == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((localLayoutParams instanceof ConstraintLayout.LayoutParams)) {
      ((ConstraintLayout.LayoutParams)localLayoutParams).widget = ((ConstraintWidget)this.mHelperWidget);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintHelper
 * JD-Core Version:    0.7.0.1
 */