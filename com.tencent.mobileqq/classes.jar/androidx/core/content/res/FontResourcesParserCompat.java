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
import androidx.core.provider.FontRequest;
import c;
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
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    return readFamilies(paramXmlPullParser, paramResources);
  }
  
  public static List<List<byte[]>> readCerts(Resources paramResources, @ArrayRes int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    for (;;)
    {
      try
      {
        if (localTypedArray.length() == 0)
        {
          paramResources = Collections.emptyList();
          return paramResources;
        }
        ArrayList localArrayList = new ArrayList();
        if (getType(localTypedArray, 0) == 1)
        {
          paramInt = i;
          if (paramInt < localTypedArray.length())
          {
            i = localTypedArray.getResourceId(paramInt, 0);
            if (i == 0) {
              break label121;
            }
            localArrayList.add(toByteArrayList(paramResources.getStringArray(i)));
            break label121;
          }
        }
        else
        {
          localArrayList.add(toByteArrayList(paramResources.getStringArray(paramInt)));
        }
        return localArrayList;
      }
      finally
      {
        localTypedArray.recycle();
      }
      label121:
      paramInt += 1;
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
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), c.b);
    String str1 = ((TypedArray)localObject).getString(c.d);
    String str2 = ((TypedArray)localObject).getString(c.h);
    String str3 = ((TypedArray)localObject).getString(c.i);
    int i = ((TypedArray)localObject).getResourceId(c.e, 0);
    int j = ((TypedArray)localObject).getInteger(c.f, 1);
    int k = ((TypedArray)localObject).getInteger(c.g, 500);
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
    boolean bool = true;
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), c.c);
    int k;
    label53:
    label63:
    label77:
    int j;
    label91:
    String str1;
    if (paramResources.hasValue(c.r))
    {
      i = c.r;
      k = paramResources.getInt(i, 400);
      if (!paramResources.hasValue(c.p)) {
        break label162;
      }
      i = c.p;
      if (1 != paramResources.getInt(i, 0)) {
        break label169;
      }
      if (!paramResources.hasValue(c.s)) {
        break label175;
      }
      i = c.s;
      if (!paramResources.hasValue(c.q)) {
        break label182;
      }
      j = c.q;
      str1 = paramResources.getString(j);
      j = paramResources.getInt(i, 0);
      if (!paramResources.hasValue(c.o)) {
        break label189;
      }
    }
    int m;
    String str2;
    label162:
    label169:
    label175:
    label182:
    label189:
    for (int i = c.o;; i = c.j)
    {
      m = paramResources.getResourceId(i, 0);
      str2 = paramResources.getString(i);
      paramResources.recycle();
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      i = c.k;
      break;
      i = c.l;
      break label53;
      bool = false;
      break label63;
      i = c.m;
      break label77;
      j = c.n;
      break label91;
    }
    return new FontResourcesParserCompat.FontFileResourceEntry(str2, k, bool, str1, j, m);
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    while (i > 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 2: 
        i += 1;
        break;
      case 3: 
        i -= 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.content.res.FontResourcesParserCompat
 * JD-Core Version:    0.7.0.1
 */