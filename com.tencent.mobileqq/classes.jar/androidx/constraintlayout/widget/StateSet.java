package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateSet
{
  private static final boolean DEBUG = false;
  public static final String TAG = "ConstraintLayoutStates";
  private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray();
  private ConstraintsChangedListener mConstraintsChangedListener = null;
  int mCurrentConstraintNumber = -1;
  int mCurrentStateId = -1;
  ConstraintSet mDefaultConstraintSet;
  int mDefaultState = -1;
  private SparseArray<StateSet.State> mStateList = new SparseArray();
  
  public StateSet(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    load(paramContext, paramXmlPullParser);
  }
  
  private void load(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    Object localObject1 = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.StateSet);
    int j = ((TypedArray)localObject1).getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = ((TypedArray)localObject1).getIndex(i);
      if (k == R.styleable.StateSet_defaultState) {
        this.mDefaultState = ((TypedArray)localObject1).getResourceId(k, this.mDefaultState);
      }
      i += 1;
    }
    localObject1 = null;
    for (;;)
    {
      try
      {
        i = paramXmlPullParser.getEventType();
        Object localObject2;
        Object localObject3;
        if (i != 1) {
          if (i != 0)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                localObject2 = localObject1;
                continue;
              }
              localObject2 = localObject1;
              if (!"StateSet".equals(paramXmlPullParser.getName())) {
                continue;
              }
              return;
            }
            localObject3 = paramXmlPullParser.getName();
            i = -1;
          }
        }
        switch (((String)localObject3).hashCode())
        {
        case 1901439077: 
          if (((String)localObject3).equals("Variant")) {
            i = 3;
          }
          break;
        case 1382829617: 
          if (((String)localObject3).equals("StateSet")) {
            i = 1;
          }
          break;
        case 1301459538: 
          if (((String)localObject3).equals("LayoutDescription")) {
            i = 0;
          }
          break;
        case 80204913: 
          if (((String)localObject3).equals("State")) {
            i = 2;
          }
          localObject2 = localObject1;
          if (i != 0)
          {
            localObject2 = localObject1;
            if (i != 1) {
              if (i != 2)
              {
                if (i != 3)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("unknown tag ");
                  ((StringBuilder)localObject2).append((String)localObject3);
                  Log.v("ConstraintLayoutStates", ((StringBuilder)localObject2).toString());
                  localObject2 = localObject1;
                }
                else
                {
                  localObject3 = new StateSet.Variant(paramContext, paramXmlPullParser);
                  localObject2 = localObject1;
                  if (localObject1 != null)
                  {
                    ((StateSet.State)localObject1).add((StateSet.Variant)localObject3);
                    localObject2 = localObject1;
                  }
                }
              }
              else
              {
                localObject2 = new StateSet.State(paramContext, paramXmlPullParser);
                this.mStateList.put(((StateSet.State)localObject2).mId, localObject2);
                continue;
                paramXmlPullParser.getName();
                localObject2 = localObject1;
              }
            }
          }
          i = paramXmlPullParser.next();
          localObject1 = localObject2;
          continue;
          return;
        }
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      catch (XmlPullParserException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public int convertToConstraintSet(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    StateSet.State localState = (StateSet.State)this.mStateList.get(paramInt2);
    if (localState == null) {
      return paramInt2;
    }
    if ((paramFloat1 != -1.0F) && (paramFloat2 != -1.0F))
    {
      localObject = null;
      Iterator localIterator = localState.mVariants.iterator();
      while (localIterator.hasNext())
      {
        StateSet.Variant localVariant = (StateSet.Variant)localIterator.next();
        if (localVariant.match(paramFloat1, paramFloat2))
        {
          if (paramInt1 == localVariant.mConstraintID) {
            return paramInt1;
          }
          localObject = localVariant;
        }
      }
      if (localObject != null) {
        return ((StateSet.Variant)localObject).mConstraintID;
      }
      return localState.mConstraintID;
    }
    if (localState.mConstraintID == paramInt1) {
      return paramInt1;
    }
    Object localObject = localState.mVariants.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt1 == ((StateSet.Variant)((Iterator)localObject).next()).mConstraintID) {
        return paramInt1;
      }
    }
    return localState.mConstraintID;
  }
  
  public boolean needsToChange(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = this.mCurrentStateId;
    if (i != paramInt) {
      return true;
    }
    if (paramInt == -1) {
      localObject = this.mStateList.valueAt(0);
    } else {
      localObject = this.mStateList.get(i);
    }
    Object localObject = (StateSet.State)localObject;
    if ((this.mCurrentConstraintNumber != -1) && (((StateSet.Variant)((StateSet.State)localObject).mVariants.get(this.mCurrentConstraintNumber)).match(paramFloat1, paramFloat2))) {
      return false;
    }
    return this.mCurrentConstraintNumber != ((StateSet.State)localObject).findMatch(paramFloat1, paramFloat2);
  }
  
  public void setOnConstraintsChanged(ConstraintsChangedListener paramConstraintsChangedListener)
  {
    this.mConstraintsChangedListener = paramConstraintsChangedListener;
  }
  
  public int stateGetConstraintID(int paramInt1, int paramInt2, int paramInt3)
  {
    return updateConstraints(-1, paramInt1, paramInt2, paramInt3);
  }
  
  public int updateConstraints(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (paramInt1 == paramInt2)
    {
      if (paramInt2 == -1) {
        localState = (StateSet.State)this.mStateList.valueAt(0);
      } else {
        localState = (StateSet.State)this.mStateList.get(this.mCurrentStateId);
      }
      if (localState == null) {
        return -1;
      }
      if ((this.mCurrentConstraintNumber != -1) && (((StateSet.Variant)localState.mVariants.get(paramInt1)).match(paramFloat1, paramFloat2))) {
        return paramInt1;
      }
      paramInt2 = localState.findMatch(paramFloat1, paramFloat2);
      if (paramInt1 == paramInt2) {
        return paramInt1;
      }
      if (paramInt2 == -1) {
        return localState.mConstraintID;
      }
      return ((StateSet.Variant)localState.mVariants.get(paramInt2)).mConstraintID;
    }
    StateSet.State localState = (StateSet.State)this.mStateList.get(paramInt2);
    if (localState == null) {
      return -1;
    }
    paramInt1 = localState.findMatch(paramFloat1, paramFloat2);
    if (paramInt1 == -1) {
      return localState.mConstraintID;
    }
    return ((StateSet.Variant)localState.mVariants.get(paramInt1)).mConstraintID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.StateSet
 * JD-Core Version:    0.7.0.1
 */