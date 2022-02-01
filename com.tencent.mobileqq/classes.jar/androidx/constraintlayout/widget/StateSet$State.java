package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class StateSet$State
{
  int mConstraintID = -1;
  int mId;
  boolean mIsLayout;
  ArrayList<StateSet.Variant> mVariants = new ArrayList();
  
  public StateSet$State(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    int i = 0;
    this.mIsLayout = false;
    paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.State);
    int j = paramXmlPullParser.getIndexCount();
    while (i < j)
    {
      int k = paramXmlPullParser.getIndex(i);
      if (k == R.styleable.State_android_id)
      {
        this.mId = paramXmlPullParser.getResourceId(k, this.mId);
      }
      else if (k == R.styleable.State_constraints)
      {
        this.mConstraintID = paramXmlPullParser.getResourceId(k, this.mConstraintID);
        String str = paramContext.getResources().getResourceTypeName(this.mConstraintID);
        paramContext.getResources().getResourceName(this.mConstraintID);
        if ("layout".equals(str)) {
          this.mIsLayout = true;
        }
      }
      i += 1;
    }
    paramXmlPullParser.recycle();
  }
  
  void add(StateSet.Variant paramVariant)
  {
    this.mVariants.add(paramVariant);
  }
  
  public int findMatch(float paramFloat1, float paramFloat2)
  {
    int i = 0;
    while (i < this.mVariants.size())
    {
      if (((StateSet.Variant)this.mVariants.get(i)).match(paramFloat1, paramFloat2)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.StateSet.State
 * JD-Core Version:    0.7.0.1
 */