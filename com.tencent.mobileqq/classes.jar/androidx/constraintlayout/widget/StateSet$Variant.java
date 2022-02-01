package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;

class StateSet$Variant
{
  int mConstraintID = -1;
  int mId;
  boolean mIsLayout;
  float mMaxHeight = (0.0F / 0.0F);
  float mMaxWidth = (0.0F / 0.0F);
  float mMinHeight = (0.0F / 0.0F);
  float mMinWidth = (0.0F / 0.0F);
  
  public StateSet$Variant(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    int i = 0;
    this.mIsLayout = false;
    paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.Variant);
    int j = paramXmlPullParser.getIndexCount();
    while (i < j)
    {
      int k = paramXmlPullParser.getIndex(i);
      if (k == R.styleable.Variant_constraints)
      {
        this.mConstraintID = paramXmlPullParser.getResourceId(k, this.mConstraintID);
        String str = paramContext.getResources().getResourceTypeName(this.mConstraintID);
        paramContext.getResources().getResourceName(this.mConstraintID);
        if ("layout".equals(str)) {
          this.mIsLayout = true;
        }
      }
      else if (k == R.styleable.Variant_region_heightLessThan)
      {
        this.mMaxHeight = paramXmlPullParser.getDimension(k, this.mMaxHeight);
      }
      else if (k == R.styleable.Variant_region_heightMoreThan)
      {
        this.mMinHeight = paramXmlPullParser.getDimension(k, this.mMinHeight);
      }
      else if (k == R.styleable.Variant_region_widthLessThan)
      {
        this.mMaxWidth = paramXmlPullParser.getDimension(k, this.mMaxWidth);
      }
      else if (k == R.styleable.Variant_region_widthMoreThan)
      {
        this.mMinWidth = paramXmlPullParser.getDimension(k, this.mMinWidth);
      }
      else
      {
        Log.v("ConstraintLayoutStates", "Unknown tag");
      }
      i += 1;
    }
    paramXmlPullParser.recycle();
  }
  
  boolean match(float paramFloat1, float paramFloat2)
  {
    if ((!Float.isNaN(this.mMinWidth)) && (paramFloat1 < this.mMinWidth)) {
      return false;
    }
    if ((!Float.isNaN(this.mMinHeight)) && (paramFloat2 < this.mMinHeight)) {
      return false;
    }
    if ((!Float.isNaN(this.mMaxWidth)) && (paramFloat1 > this.mMaxWidth)) {
      return false;
    }
    return (Float.isNaN(this.mMaxHeight)) || (paramFloat2 <= this.mMaxHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.StateSet.Variant
 * JD-Core Version:    0.7.0.1
 */