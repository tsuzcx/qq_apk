package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils
{
  private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";
  
  public static int getAttr(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt1, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static boolean getBoolean(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, boolean paramBoolean)
  {
    return paramTypedArray.getBoolean(paramInt1, paramTypedArray.getBoolean(paramInt2, paramBoolean));
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    Drawable localDrawable2 = paramTypedArray.getDrawable(paramInt1);
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = paramTypedArray.getDrawable(paramInt2);
    }
    return localDrawable1;
  }
  
  public static int getInt(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, int paramInt3)
  {
    return paramTypedArray.getInt(paramInt1, paramTypedArray.getInt(paramInt2, paramInt3));
  }
  
  public static boolean getNamedBoolean(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt, boolean paramBoolean)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramBoolean;
    }
    return paramTypedArray.getBoolean(paramInt, paramBoolean);
  }
  
  @ColorInt
  public static int getNamedColor(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt1, @ColorInt int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getColor(paramInt1, paramInt2);
  }
  
  @Nullable
  public static ColorStateList getNamedColorStateList(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme, @NonNull String paramString, @StyleableRes int paramInt)
  {
    if (hasAttribute(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt, paramXmlPullParser);
      if (paramXmlPullParser.type == 2) {
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + paramInt + ": " + paramXmlPullParser);
      }
      if ((paramXmlPullParser.type >= 28) && (paramXmlPullParser.type <= 31)) {
        return getNamedColorStateListFromInt(paramXmlPullParser);
      }
      return ColorStateListInflaterCompat.inflate(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt, 0), paramTheme);
    }
    return null;
  }
  
  @NonNull
  private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue paramTypedValue)
  {
    return ColorStateList.valueOf(paramTypedValue.data);
  }
  
  public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme, @NonNull String paramString, @StyleableRes int paramInt1, @ColorInt int paramInt2)
  {
    if (hasAttribute(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt1, paramXmlPullParser);
      if ((paramXmlPullParser.type >= 28) && (paramXmlPullParser.type <= 31)) {
        paramTypedArray = ComplexColorCompat.from(paramXmlPullParser.data);
      }
      do
      {
        return paramTypedArray;
        paramXmlPullParser = ComplexColorCompat.inflate(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt1, 0), paramTheme);
        paramTypedArray = paramXmlPullParser;
      } while (paramXmlPullParser != null);
    }
    return ComplexColorCompat.from(paramInt2);
  }
  
  public static float getNamedFloat(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt, float paramFloat)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramFloat;
    }
    return paramTypedArray.getFloat(paramInt, paramFloat);
  }
  
  public static int getNamedInt(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt1, int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getInt(paramInt1, paramInt2);
  }
  
  @AnyRes
  public static int getNamedResourceId(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt1, @AnyRes int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getResourceId(paramInt1, paramInt2);
  }
  
  @Nullable
  public static String getNamedString(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.getString(paramInt);
  }
  
  @AnyRes
  public static int getResourceId(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, @AnyRes int paramInt3)
  {
    return paramTypedArray.getResourceId(paramInt1, paramTypedArray.getResourceId(paramInt2, paramInt3));
  }
  
  @Nullable
  public static String getString(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    String str2 = paramTypedArray.getString(paramInt1);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramTypedArray.getString(paramInt2);
    }
    return str1;
  }
  
  @Nullable
  public static CharSequence getText(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    CharSequence localCharSequence2 = paramTypedArray.getText(paramInt1);
    CharSequence localCharSequence1 = localCharSequence2;
    if (localCharSequence2 == null) {
      localCharSequence1 = paramTypedArray.getText(paramInt2);
    }
    return localCharSequence1;
  }
  
  @Nullable
  public static CharSequence[] getTextArray(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    CharSequence[] arrayOfCharSequence2 = paramTypedArray.getTextArray(paramInt1);
    CharSequence[] arrayOfCharSequence1 = arrayOfCharSequence2;
    if (arrayOfCharSequence2 == null) {
      arrayOfCharSequence1 = paramTypedArray.getTextArray(paramInt2);
    }
    return arrayOfCharSequence1;
  }
  
  public static boolean hasAttribute(@NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString)
  {
    return paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null;
  }
  
  @NonNull
  public static TypedArray obtainAttributes(@NonNull Resources paramResources, @Nullable Resources.Theme paramTheme, @NonNull AttributeSet paramAttributeSet, @NonNull int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
  
  @Nullable
  public static TypedValue peekNamedValue(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, int paramInt)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.peekValue(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.content.res.TypedArrayUtils
 * JD-Core Version:    0.7.0.1
 */