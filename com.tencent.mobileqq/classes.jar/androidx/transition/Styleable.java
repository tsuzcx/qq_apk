package androidx.transition;

import android.annotation.SuppressLint;
import androidx.annotation.StyleableRes;

@SuppressLint({"InlinedApi"})
class Styleable
{
  @StyleableRes
  static final int[] ARC_MOTION = { 16843901, 16843902, 16843903 };
  @StyleableRes
  static final int[] CHANGE_BOUNDS;
  @StyleableRes
  static final int[] CHANGE_TRANSFORM;
  @StyleableRes
  static final int[] FADE;
  @StyleableRes
  static final int[] PATTERN_PATH_MOTION = { 16843978 };
  @StyleableRes
  static final int[] SLIDE;
  @StyleableRes
  static final int[] TRANSITION;
  @StyleableRes
  static final int[] TRANSITION_MANAGER;
  @StyleableRes
  static final int[] TRANSITION_SET;
  @StyleableRes
  static final int[] TRANSITION_TARGET = { 16842799, 16843740, 16843841, 16843842, 16843853, 16843854 };
  @StyleableRes
  static final int[] VISIBILITY_TRANSITION;
  
  static
  {
    TRANSITION_MANAGER = new int[] { 16843741, 16843742, 16843743 };
    TRANSITION = new int[] { 16843073, 16843160, 16843746, 16843855 };
    CHANGE_BOUNDS = new int[] { 16843983 };
    VISIBILITY_TRANSITION = new int[] { 16843900 };
    FADE = new int[] { 16843745 };
    CHANGE_TRANSFORM = new int[] { 16843964, 16843965 };
    SLIDE = new int[] { 16843824 };
    TRANSITION_SET = new int[] { 16843744 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Styleable
 * JD-Core Version:    0.7.0.1
 */