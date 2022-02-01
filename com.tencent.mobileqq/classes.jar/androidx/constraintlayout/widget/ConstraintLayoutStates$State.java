package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class ConstraintLayoutStates$State
{
  int mConstraintID = -1;
  ConstraintSet mConstraintSet;
  int mId;
  ArrayList<ConstraintLayoutStates.Variant> mVariants = new ArrayList();
  
  public ConstraintLayoutStates$State(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.State);
    int j = paramXmlPullParser.getIndexCount();
    int i = 0;
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
        if ("layout".equals(str))
        {
          this.mConstraintSet = new ConstraintSet();
          this.mConstraintSet.clone(paramContext, this.mConstraintID);
        }
      }
      i += 1;
    }
    paramXmlPullParser.recycle();
  }
  
  void add(ConstraintLayoutStates.Variant paramVariant)
  {
    this.mVariants.add(paramVariant);
  }
  
  public int findMatch(float paramFloat1, float paramFloat2)
  {
    int i = 0;
    while (i < this.mVariants.size())
    {
      if (((ConstraintLayoutStates.Variant)this.mVariants.get(i)).match(paramFloat1, paramFloat2)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayoutStates.State
 * JD-Core Version:    0.7.0.1
 */