package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R.styleable;
import androidx.core.provider.FontRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FontResourcesParserCompat
{
  private static final int DEFAULT_TIMEOUT_MILLIS = 500;
  public static final int FETCH_STRATEGY_ASYNC = 1;
  public static final int FETCH_STRATEGY_BLOCKING = 0;
  public static final int INFINITE_TIMEOUT_VALUE = -1;
  private static final int ITALIC = 1;
  private static final int NORMAL_WEIGHT = 400;
  
  private static int getType(TypedArray paramTypedArray, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramTypedArray.getType(paramInt);
    }
    TypedValue localTypedValue = new TypedValue();
    paramTypedArray.getValue(paramInt, localTypedValue);
    return localTypedValue.type;
  }
  
  @Nullable
  public static FontResourcesParserCompat.FamilyResourceEntry parse(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return readFamilies(paramXmlPullParser, paramResources);
    }
    paramXmlPullParser = new XmlPullParserException("No start tag found");
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
  
  public static List<List<byte[]>> readCerts(Resources paramResources, @ArrayRes int paramInt)
  {
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    localTypedArray = paramResources.obtainTypedArray(paramInt);
    try
    {
      if (localTypedArray.length() == 0)
      {
        paramResources = Collections.emptyList();
        localTypedArray.recycle();
        return paramResources;
      }
      localArrayList = new ArrayList();
      if (getType(localTypedArray, 0) != 1) {
        break label89;
      }
      paramInt = 0;
    }
    finally
    {
      for (;;)
      {
        ArrayList localArrayList;
        int i;
        label89:
        localTypedArray.recycle();
        for (;;)
        {
          throw paramResources;
        }
        paramInt += 1;
      }
    }
    if (paramInt < localTypedArray.length())
    {
      i = localTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        localArrayList.add(toByteArrayList(paramResources.getStringArray(i)));
        break label125;
        localArrayList.add(toByteArrayList(paramResources.getStringArray(paramInt)));
      }
    }
    else
    {
      localTypedArray.recycle();
      return localArrayList;
    }
  }
  
  @Nullable
  private static FontResourcesParserCompat.FamilyResourceEntry readFamilies(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family")) {
      return readFamily(paramXmlPullParser, paramResources);
    }
    skip(paramXmlPullParser);
    return null;
  }
  
  @Nullable
  private static FontResourcesParserCompat.FamilyResourceEntry readFamily(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamily);
    String str1 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderAuthority);
    String str2 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderPackage);
    String str3 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderQuery);
    int i = ((TypedArray)localObject).getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
    int j = ((TypedArray)localObject).getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
    int k = ((TypedArray)localObject).getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      return new FontResourcesParserCompat.ProviderResourceEntry(new FontRequest(str1, str2, str3, readCerts(paramResources, i)), j, k);
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(readFont(paramXmlPullParser, paramResources));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return new FontResourcesParserCompat.FontFamilyFilesResourceEntry((FontResourcesParserCompat.FontFileResourceEntry[])((List)localObject).toArray(new FontResourcesParserCompat.FontFileResourceEntry[((List)localObject).size()]));
  }
  
  private static FontResourcesParserCompat.FontFileResourceEntry readFont(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamilyFont);
    int i;
    if (paramResources.hasValue(R.styleable.FontFamilyFont_fontWeight)) {
      i = R.styleable.FontFamilyFont_fontWeight;
    } else {
      i = R.styleable.FontFamilyFont_android_fontWeight;
    }
    int k = paramResources.getInt(i, 400);
    if (paramResources.hasValue(R.styleable.FontFamilyFont_fontStyle)) {
      i = R.styleable.FontFamilyFont_fontStyle;
    } else {
      i = R.styleable.FontFamilyFont_android_fontStyle;
    }
    boolean bool;
    if (1 == paramResources.getInt(i, 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramResources.hasValue(R.styleable.FontFamilyFont_ttcIndex)) {
      i = R.styleable.FontFamilyFont_ttcIndex;
    } else {
      i = R.styleable.FontFamilyFont_android_ttcIndex;
    }
    if (paramResources.hasValue(R.styleable.FontFamilyFont_fontVariationSettings)) {
      j = R.styleable.FontFamilyFont_fontVariationSettings;
    } else {
      j = R.styleable.FontFamilyFont_android_fontVariationSettings;
    }
    String str1 = paramResources.getString(j);
    int j = paramResources.getInt(i, 0);
    if (paramResources.hasValue(R.styleable.FontFamilyFont_font)) {
      i = R.styleable.FontFamilyFont_font;
    } else {
      i = R.styleable.FontFamilyFont_android_font;
    }
    int m = paramResources.getResourceId(i, 0);
    String str2 = paramResources.getString(i);
    paramResources.recycle();
    while (paramXmlPullParser.next() != 3) {
      skip(paramXmlPullParser);
    }
    return new FontResourcesParserCompat.FontFileResourceEntry(str2, k, bool, str1, j, m);
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    while (i > 0)
    {
      int j = paramXmlPullParser.next();
      if (j != 2)
      {
        if (j == 3) {
          i -= 1;
        }
      }
      else {
        i += 1;
      }
    }
  }
  
  private static List<byte[]> toByteArrayList(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.decode(paramArrayOfString[i], 0));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.res.FontResourcesParserCompat
 * JD-Core Version:    0.7.0.1
 */