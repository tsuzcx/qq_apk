package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R.styleable;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
final class GradientColorInflaterCompat
{
  private static final int TILE_MODE_CLAMP = 0;
  private static final int TILE_MODE_MIRROR = 2;
  private static final int TILE_MODE_REPEAT = 1;
  
  private static GradientColorInflaterCompat.ColorStops checkColors(@Nullable GradientColorInflaterCompat.ColorStops paramColorStops, @ColorInt int paramInt1, @ColorInt int paramInt2, boolean paramBoolean, @ColorInt int paramInt3)
  {
    if (paramColorStops != null) {
      return paramColorStops;
    }
    if (paramBoolean) {
      return new GradientColorInflaterCompat.ColorStops(paramInt1, paramInt3, paramInt2);
    }
    return new GradientColorInflaterCompat.ColorStops(paramInt1, paramInt2);
  }
  
  static Shader createFromXml(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme)
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    return createFromXmlInner(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
  }
  
  static Shader createFromXmlInner(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    Object localObject = paramXmlPullParser.getName();
    if (!((String)localObject).equals("gradient")) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid gradient color tag " + (String)localObject);
    }
    localObject = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.d);
    float f1 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "startX", R.styleable.B, 0.0F);
    float f2 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "startY", R.styleable.C, 0.0F);
    float f3 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "endX", R.styleable.D, 0.0F);
    float f4 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "endY", R.styleable.E, 0.0F);
    float f5 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "centerX", R.styleable.w, 0.0F);
    float f6 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "centerY", R.styleable.x, 0.0F);
    int i = TypedArrayUtils.getNamedInt((TypedArray)localObject, paramXmlPullParser, "type", R.styleable.v, 0);
    int j = TypedArrayUtils.getNamedColor((TypedArray)localObject, paramXmlPullParser, "startColor", R.styleable.t, 0);
    boolean bool = TypedArrayUtils.hasAttribute(paramXmlPullParser, "centerColor");
    int k = TypedArrayUtils.getNamedColor((TypedArray)localObject, paramXmlPullParser, "centerColor", R.styleable.A, 0);
    int m = TypedArrayUtils.getNamedColor((TypedArray)localObject, paramXmlPullParser, "endColor", R.styleable.u, 0);
    int n = TypedArrayUtils.getNamedInt((TypedArray)localObject, paramXmlPullParser, "tileMode", R.styleable.z, 0);
    float f7 = TypedArrayUtils.getNamedFloat((TypedArray)localObject, paramXmlPullParser, "gradientRadius", R.styleable.y, 0.0F);
    ((TypedArray)localObject).recycle();
    paramResources = checkColors(inflateChildElements(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme), j, m, bool, k);
    switch (i)
    {
    default: 
      return new LinearGradient(f1, f2, f3, f4, paramResources.mColors, paramResources.mOffsets, parseTileMode(n));
    case 1: 
      if (f7 <= 0.0F) {
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
      }
      return new RadialGradient(f5, f6, f7, paramResources.mColors, paramResources.mOffsets, parseTileMode(n));
    }
    return new SweepGradient(f5, f6, paramResources.mColors, paramResources.mOffsets);
  }
  
  private static GradientColorInflaterCompat.ColorStops inflateChildElements(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    int i = paramXmlPullParser.getDepth() + 1;
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList(20);
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.e);
        boolean bool1 = localTypedArray.hasValue(R.styleable.F);
        boolean bool2 = localTypedArray.hasValue(R.styleable.G);
        if ((!bool1) || (!bool2)) {
          throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
        }
        j = localTypedArray.getColor(R.styleable.F, 0);
        float f = localTypedArray.getFloat(R.styleable.G, 0.0F);
        localTypedArray.recycle();
        localArrayList2.add(Integer.valueOf(j));
        localArrayList1.add(Float.valueOf(f));
      }
    }
    if (localArrayList2.size() > 0) {
      return new GradientColorInflaterCompat.ColorStops(localArrayList2, localArrayList1);
    }
    return null;
  }
  
  private static Shader.TileMode parseTileMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Shader.TileMode.CLAMP;
    case 1: 
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.MIRROR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.content.res.GradientColorInflaterCompat
 * JD-Core Version:    0.7.0.1
 */