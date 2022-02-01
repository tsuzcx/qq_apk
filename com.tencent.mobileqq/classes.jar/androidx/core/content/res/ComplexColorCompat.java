package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ComplexColorCompat
{
  private static final String LOG_TAG = "ComplexColorCompat";
  private int mColor;
  private final ColorStateList mColorStateList;
  private final Shader mShader;
  
  private ComplexColorCompat(Shader paramShader, ColorStateList paramColorStateList, @ColorInt int paramInt)
  {
    this.mShader = paramShader;
    this.mColorStateList = paramColorStateList;
    this.mColor = paramInt;
  }
  
  @NonNull
  private static ComplexColorCompat createFromXml(@NonNull Resources paramResources, @ColorRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
    do
    {
      paramInt = localXmlResourceParser.next();
    } while ((paramInt != 2) && (paramInt != 1));
    if (paramInt == 2)
    {
      String str = localXmlResourceParser.getName();
      paramInt = -1;
      int i = str.hashCode();
      if (i != 89650992)
      {
        if ((i == 1191572447) && (str.equals("selector"))) {
          paramInt = 0;
        }
      }
      else if (str.equals("gradient")) {
        paramInt = 1;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          return from(GradientColorInflaterCompat.createFromXmlInner(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
        }
        paramResources = new StringBuilder();
        paramResources.append(localXmlResourceParser.getPositionDescription());
        paramResources.append(": unsupported complex color tag ");
        paramResources.append(str);
        throw new XmlPullParserException(paramResources.toString());
      }
      return from(ColorStateListInflaterCompat.createFromXmlInner(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
    }
    paramResources = new XmlPullParserException("No start tag found");
    for (;;)
    {
      throw paramResources;
    }
  }
  
  static ComplexColorCompat from(@ColorInt int paramInt)
  {
    return new ComplexColorCompat(null, null, paramInt);
  }
  
  static ComplexColorCompat from(@NonNull ColorStateList paramColorStateList)
  {
    return new ComplexColorCompat(null, paramColorStateList, paramColorStateList.getDefaultColor());
  }
  
  static ComplexColorCompat from(@NonNull Shader paramShader)
  {
    return new ComplexColorCompat(paramShader, null, 0);
  }
  
  @Nullable
  public static ComplexColorCompat inflate(@NonNull Resources paramResources, @ColorRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    try
    {
      paramResources = createFromXml(paramResources, paramInt, paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", paramResources);
    }
    return null;
  }
  
  @ColorInt
  public int getColor()
  {
    return this.mColor;
  }
  
  @Nullable
  public Shader getShader()
  {
    return this.mShader;
  }
  
  public boolean isGradient()
  {
    return this.mShader != null;
  }
  
  public boolean isStateful()
  {
    if (this.mShader == null)
    {
      ColorStateList localColorStateList = this.mColorStateList;
      if ((localColorStateList != null) && (localColorStateList.isStateful())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onStateChanged(int[] paramArrayOfInt)
  {
    if (isStateful())
    {
      ColorStateList localColorStateList = this.mColorStateList;
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if (i != this.mColor)
      {
        this.mColor = i;
        return true;
      }
    }
    return false;
  }
  
  public void setColor(@ColorInt int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public boolean willDraw()
  {
    return (isGradient()) || (this.mColor != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.res.ComplexColorCompat
 * JD-Core Version:    0.7.0.1
 */