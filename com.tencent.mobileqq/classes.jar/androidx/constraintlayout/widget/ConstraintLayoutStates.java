package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintLayoutStates
{
  private static final boolean DEBUG = false;
  public static final String TAG = "ConstraintLayoutStates";
  private final ConstraintLayout mConstraintLayout;
  private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray();
  private ConstraintsChangedListener mConstraintsChangedListener = null;
  int mCurrentConstraintNumber = -1;
  int mCurrentStateId = -1;
  ConstraintSet mDefaultConstraintSet;
  private SparseArray<ConstraintLayoutStates.State> mStateList = new SparseArray();
  
  ConstraintLayoutStates(Context paramContext, ConstraintLayout paramConstraintLayout, int paramInt)
  {
    this.mConstraintLayout = paramConstraintLayout;
    load(paramContext, paramInt);
  }
  
  private void load(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    Object localObject1 = null;
    try
    {
      paramInt = localXmlResourceParser.getEventType();
    }
    catch (IOException paramContext)
    {
      Object localObject3;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
    localObject3 = localXmlResourceParser.getName();
    paramInt = -1;
    switch (((String)localObject3).hashCode())
    {
    case 1901439077: 
      if (((String)localObject3).equals("Variant")) {
        paramInt = 3;
      }
      break;
    case 1657696882: 
      if (((String)localObject3).equals("layoutDescription")) {
        paramInt = 0;
      }
      break;
    case 1382829617: 
      if (((String)localObject3).equals("StateSet")) {
        paramInt = 1;
      }
      break;
    case 80204913: 
      if (((String)localObject3).equals("State")) {
        paramInt = 2;
      }
      break;
    case -1349929691: 
      if (((String)localObject3).equals("ConstraintSet")) {
        paramInt = 4;
      }
      break;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (paramInt != 0)
      {
        localObject2 = localObject1;
        if (paramInt != 1) {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("unknown tag ");
                ((StringBuilder)localObject2).append((String)localObject3);
                Log.v("ConstraintLayoutStates", ((StringBuilder)localObject2).toString());
                localObject2 = localObject1;
              }
              else
              {
                parseConstraintSet(paramContext, localXmlResourceParser);
                localObject2 = localObject1;
              }
            }
            else
            {
              localObject3 = new ConstraintLayoutStates.Variant(paramContext, localXmlResourceParser);
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject1.add((ConstraintLayoutStates.Variant)localObject3);
                localObject2 = localObject1;
              }
            }
          }
          else
          {
            localObject2 = new ConstraintLayoutStates.State(paramContext, localXmlResourceParser);
            this.mStateList.put(((ConstraintLayoutStates.State)localObject2).mId, localObject2);
            break label316;
            label305:
            localXmlResourceParser.getName();
          }
        }
      }
      for (localObject2 = localObject1;; localObject2 = localObject1)
      {
        label316:
        paramInt = localXmlResourceParser.next();
        localObject1 = localObject2;
        while (paramInt == 1) {
          return;
        }
        if (paramInt == 0) {
          break label305;
        }
        if (paramInt == 2) {
          break;
        }
      }
    }
  }
  
  private void parseConstraintSet(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    ConstraintSet localConstraintSet = new ConstraintSet();
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    while (i < j)
    {
      if ("id".equals(paramXmlPullParser.getAttributeName(i)))
      {
        String str1 = paramXmlPullParser.getAttributeValue(i);
        if (str1.contains("/"))
        {
          String str2 = str1.substring(str1.indexOf('/') + 1);
          i = paramContext.getResources().getIdentifier(str2, "id", paramContext.getPackageName());
        }
        else
        {
          i = -1;
        }
        j = i;
        if (i == -1) {
          if ((str1 != null) && (str1.length() > 1))
          {
            j = Integer.parseInt(str1.substring(1));
          }
          else
          {
            Log.e("ConstraintLayoutStates", "error in parsing id");
            j = i;
          }
        }
        localConstraintSet.load(paramContext, paramXmlPullParser);
        this.mConstraintSetMap.put(j, localConstraintSet);
        return;
      }
      i += 1;
    }
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
    Object localObject = (ConstraintLayoutStates.State)localObject;
    if ((this.mCurrentConstraintNumber != -1) && (((ConstraintLayoutStates.Variant)((ConstraintLayoutStates.State)localObject).mVariants.get(this.mCurrentConstraintNumber)).match(paramFloat1, paramFloat2))) {
      return false;
    }
    return this.mCurrentConstraintNumber != ((ConstraintLayoutStates.State)localObject).findMatch(paramFloat1, paramFloat2);
  }
  
  public void setOnConstraintsChanged(ConstraintsChangedListener paramConstraintsChangedListener)
  {
    this.mConstraintsChangedListener = paramConstraintsChangedListener;
  }
  
  public void updateConstraints(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = this.mCurrentStateId;
    Object localObject1;
    Object localObject2;
    if (i == paramInt)
    {
      if (paramInt == -1) {
        localObject1 = (ConstraintLayoutStates.State)this.mStateList.valueAt(0);
      } else {
        localObject1 = (ConstraintLayoutStates.State)this.mStateList.get(i);
      }
      if ((this.mCurrentConstraintNumber != -1) && (((ConstraintLayoutStates.Variant)((ConstraintLayoutStates.State)localObject1).mVariants.get(this.mCurrentConstraintNumber)).match(paramFloat1, paramFloat2))) {
        return;
      }
      i = ((ConstraintLayoutStates.State)localObject1).findMatch(paramFloat1, paramFloat2);
      if (this.mCurrentConstraintNumber == i) {
        return;
      }
      if (i == -1) {
        localObject2 = this.mDefaultConstraintSet;
      } else {
        localObject2 = ((ConstraintLayoutStates.Variant)((ConstraintLayoutStates.State)localObject1).mVariants.get(i)).mConstraintSet;
      }
      if (i == -1) {
        paramInt = ((ConstraintLayoutStates.State)localObject1).mConstraintID;
      } else {
        paramInt = ((ConstraintLayoutStates.Variant)((ConstraintLayoutStates.State)localObject1).mVariants.get(i)).mConstraintID;
      }
      if (localObject2 == null) {
        return;
      }
      this.mCurrentConstraintNumber = i;
      localObject1 = this.mConstraintsChangedListener;
      if (localObject1 != null) {
        ((ConstraintsChangedListener)localObject1).preLayoutChange(-1, paramInt);
      }
      ((ConstraintSet)localObject2).applyTo(this.mConstraintLayout);
      localObject1 = this.mConstraintsChangedListener;
      if (localObject1 != null) {
        ((ConstraintsChangedListener)localObject1).postLayoutChange(-1, paramInt);
      }
    }
    else
    {
      this.mCurrentStateId = paramInt;
      localObject2 = (ConstraintLayoutStates.State)this.mStateList.get(this.mCurrentStateId);
      int j = ((ConstraintLayoutStates.State)localObject2).findMatch(paramFloat1, paramFloat2);
      if (j == -1) {
        localObject1 = ((ConstraintLayoutStates.State)localObject2).mConstraintSet;
      } else {
        localObject1 = ((ConstraintLayoutStates.Variant)((ConstraintLayoutStates.State)localObject2).mVariants.get(j)).mConstraintSet;
      }
      if (j == -1) {
        i = ((ConstraintLayoutStates.State)localObject2).mConstraintID;
      } else {
        i = ((ConstraintLayoutStates.Variant)((ConstraintLayoutStates.State)localObject2).mVariants.get(j)).mConstraintID;
      }
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("NO Constraint set found ! id=");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", dim =");
        ((StringBuilder)localObject1).append(paramFloat1);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(paramFloat2);
        Log.v("ConstraintLayoutStates", ((StringBuilder)localObject1).toString());
        return;
      }
      this.mCurrentConstraintNumber = j;
      localObject2 = this.mConstraintsChangedListener;
      if (localObject2 != null) {
        ((ConstraintsChangedListener)localObject2).preLayoutChange(paramInt, i);
      }
      ((ConstraintSet)localObject1).applyTo(this.mConstraintLayout);
      localObject1 = this.mConstraintsChangedListener;
      if (localObject1 != null) {
        ((ConstraintsChangedListener)localObject1).postLayoutChange(paramInt, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayoutStates
 * JD-Core Version:    0.7.0.1
 */