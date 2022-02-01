package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Key
{
  static final String ALPHA = "alpha";
  static final String CUSTOM = "CUSTOM";
  static final String ELEVATION = "elevation";
  static final String PIVOT_X = "transformPivotX";
  static final String PIVOT_Y = "transformPivotY";
  static final String PROGRESS = "progress";
  static final String ROTATION = "rotation";
  static final String ROTATION_X = "rotationX";
  static final String ROTATION_Y = "rotationY";
  static final String SCALE_X = "scaleX";
  static final String SCALE_Y = "scaleY";
  static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
  static final String TRANSLATION_X = "translationX";
  static final String TRANSLATION_Y = "translationY";
  static final String TRANSLATION_Z = "translationZ";
  public static int UNSET = -1;
  static final String WAVE_OFFSET = "waveOffset";
  static final String WAVE_PERIOD = "wavePeriod";
  static final String WAVE_VARIES_BY = "waveVariesBy";
  HashMap<String, ConstraintAttribute> mCustomConstraints;
  int mFramePosition;
  int mTargetId;
  String mTargetString;
  protected int mType;
  
  public Key()
  {
    int i = UNSET;
    this.mFramePosition = i;
    this.mTargetId = i;
    this.mTargetString = null;
  }
  
  public abstract void addValues(HashMap<String, SplineSet> paramHashMap);
  
  abstract void getAttributeNames(HashSet<String> paramHashSet);
  
  abstract void load(Context paramContext, AttributeSet paramAttributeSet);
  
  boolean matches(String paramString)
  {
    String str = this.mTargetString;
    if ((str != null) && (paramString != null)) {
      return paramString.matches(str);
    }
    return false;
  }
  
  public void setInterpolation(HashMap<String, Integer> paramHashMap) {}
  
  public abstract void setValue(String paramString, Object paramObject);
  
  boolean toBoolean(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue();
    }
    return Boolean.parseBoolean(paramObject.toString());
  }
  
  float toFloat(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).floatValue();
    }
    return Float.parseFloat(paramObject.toString());
  }
  
  int toInt(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    return Integer.parseInt(paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.Key
 * JD-Core Version:    0.7.0.1
 */