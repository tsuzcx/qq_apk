package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat
{
  @AnyRes
  public static final int ID_NULL = 0;
  private static final String TAG = "ResourcesCompat";
  
  @ColorInt
  public static int getColor(@NonNull Resources paramResources, @ColorRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColor(paramInt, paramTheme);
    }
    return paramResources.getColor(paramInt);
  }
  
  @Nullable
  public static ColorStateList getColorStateList(@NonNull Resources paramResources, @ColorRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColorStateList(paramInt, paramTheme);
    }
    return paramResources.getColorStateList(paramInt);
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull Resources paramResources, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawable(paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
  
  @Nullable
  public static Drawable getDrawableForDensity(@NonNull Resources paramResources, @DrawableRes int paramInt1, int paramInt2, @Nullable Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
    }
    if (Build.VERSION.SDK_INT >= 15) {
      return paramResources.getDrawableForDensity(paramInt1, paramInt2);
    }
    return paramResources.getDrawable(paramInt1);
  }
  
  public static float getFloat(@NonNull Resources paramResources, @DimenRes int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    paramResources.getValue(paramInt, localTypedValue, true);
    if (localTypedValue.type == 4) {
      return localTypedValue.getFloat();
    }
    paramResources = new StringBuilder();
    paramResources.append("Resource ID #0x");
    paramResources.append(Integer.toHexString(paramInt));
    paramResources.append(" type #0x");
    paramResources.append(Integer.toHexString(localTypedValue.type));
    paramResources.append(" is not valid");
    throw new Resources.NotFoundException(paramResources.toString());
  }
  
  @Nullable
  public static Typeface getFont(@NonNull Context paramContext, @FontRes int paramInt)
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return loadFont(paramContext, paramInt, new TypedValue(), 0, null, null, false);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Typeface getFont(@NonNull Context paramContext, @FontRes int paramInt1, TypedValue paramTypedValue, int paramInt2, @Nullable ResourcesCompat.FontCallback paramFontCallback)
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return loadFont(paramContext, paramInt1, paramTypedValue, paramInt2, paramFontCallback, null, true);
  }
  
  public static void getFont(@NonNull Context paramContext, @FontRes int paramInt, @NonNull ResourcesCompat.FontCallback paramFontCallback, @Nullable Handler paramHandler)
  {
    Preconditions.checkNotNull(paramFontCallback);
    if (paramContext.isRestricted())
    {
      paramFontCallback.callbackFailAsync(-4, paramHandler);
      return;
    }
    loadFont(paramContext, paramInt, new TypedValue(), 0, paramFontCallback, paramHandler, false);
  }
  
  private static Typeface loadFont(@NonNull Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, @Nullable ResourcesCompat.FontCallback paramFontCallback, @Nullable Handler paramHandler, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    paramContext = loadFont(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, paramFontCallback, paramHandler, paramBoolean);
    if (paramContext == null)
    {
      if (paramFontCallback != null) {
        return paramContext;
      }
      paramContext = new StringBuilder();
      paramContext.append("Font resource ID #0x");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(" could not be retrieved.");
      throw new Resources.NotFoundException(paramContext.toString());
    }
    return paramContext;
  }
  
  private static Typeface loadFont(@NonNull Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, @Nullable ResourcesCompat.FontCallback paramFontCallback, @Nullable Handler paramHandler, boolean paramBoolean)
  {
    if (paramTypedValue.string != null)
    {
      paramTypedValue = paramTypedValue.string.toString();
      if (!paramTypedValue.startsWith("res/"))
      {
        if (paramFontCallback != null) {
          paramFontCallback.callbackFailAsync(-3, paramHandler);
        }
        return null;
      }
      Object localObject = TypefaceCompat.findFromCache(paramResources, paramInt1, paramInt2);
      if (localObject != null)
      {
        if (paramFontCallback != null) {
          paramFontCallback.callbackSuccessAsync((Typeface)localObject, paramHandler);
        }
        return localObject;
      }
      try
      {
        if (paramTypedValue.toLowerCase().endsWith(".xml"))
        {
          localObject = FontResourcesParserCompat.parse(paramResources.getXml(paramInt1), paramResources);
          if (localObject == null)
          {
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (paramFontCallback == null) {
              break label333;
            }
            paramFontCallback.callbackFailAsync(-3, paramHandler);
            return null;
          }
          return TypefaceCompat.createFromResourcesFamilyXml(paramContext, (FontResourcesParserCompat.FamilyResourceEntry)localObject, paramResources, paramInt1, paramInt2, paramFontCallback, paramHandler, paramBoolean);
        }
        paramContext = TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramTypedValue, paramInt2);
        if (paramFontCallback != null)
        {
          if (paramContext != null)
          {
            paramFontCallback.callbackSuccessAsync(paramContext, paramHandler);
            return paramContext;
          }
          paramFontCallback.callbackFailAsync(-3, paramHandler);
        }
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramResources = new StringBuilder();
        paramResources.append("Failed to read xml resource ");
        paramResources.append(paramTypedValue);
        Log.e("ResourcesCompat", paramResources.toString(), paramContext);
      }
      catch (XmlPullParserException paramContext)
      {
        paramResources = new StringBuilder();
        paramResources.append("Failed to parse xml resource ");
        paramResources.append(paramTypedValue);
        Log.e("ResourcesCompat", paramResources.toString(), paramContext);
      }
      if (paramFontCallback != null) {
        paramFontCallback.callbackFailAsync(-3, paramHandler);
      }
      return null;
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append("Resource \"");
      paramContext.append(paramResources.getResourceName(paramInt1));
      paramContext.append("\" (");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(") is not a Font: ");
      paramContext.append(paramTypedValue);
      throw new Resources.NotFoundException(paramContext.toString());
    }
    label333:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.res.ResourcesCompat
 * JD-Core Version:    0.7.0.1
 */