package com.tencent.ditto.shell;

import android.text.TextUtils;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.DittoResourcesUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class LayoutAttrSet
{
  public static final int VALUE_NOT_SET = -2147483648;
  static Map<String, Integer> attrValueCache = new ConcurrentHashMap();
  static long count = 0L;
  static long parseIntegerTotal = 0L;
  public String above;
  public String alignBottom;
  public String alignLeft;
  public boolean alignParentBottom;
  public boolean alignParentLeft;
  public boolean alignParentRight;
  public boolean alignParentTop;
  public String alignRight;
  public String alignTop;
  public boolean alignWithParentIfMissing;
  public String below;
  public int bg_color = 0;
  public int bottom;
  public int bottomLeftRadius;
  public int bottomMargin;
  public int bottomPadding;
  public int bottomRightRadius;
  public int bottomShadowSize;
  public boolean centerHorizontal;
  public boolean centerInParent;
  public boolean centerVertical;
  public String gradientDirection;
  public int gradientEndColor;
  public int gradientStartColor;
  public int gravity = 3;
  public int height = -2;
  public String id;
  public int layout_gravity = 3;
  public int left;
  public int leftMargin;
  public int leftPadding;
  public int leftShadowSize;
  public Map<String, Object> mAttrs = new ConcurrentHashMap();
  public int orientation = 1;
  public int pressedAlpha;
  public int right;
  public int rightMargin;
  public int rightPadding;
  public int rightShadowSize;
  public int shadowResourceId;
  public String toLeftOf;
  public String toRightOf;
  public int top;
  public int topLeftRadius;
  public int topMargin;
  public int topPadding;
  public int topRightRadius;
  public int topShadowSize;
  public int weight = 0;
  public int width = -2;
  
  public static LayoutAttrSet createFrom(JSONObject paramJSONObject)
  {
    return createFrom(paramJSONObject, null);
  }
  
  public static LayoutAttrSet createFrom(JSONObject paramJSONObject, LayoutAttrSet.ValueIndicator paramValueIndicator)
  {
    localLayoutAttrSet = new LayoutAttrSet();
    if (paramJSONObject == null) {
      return localLayoutAttrSet;
    }
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localIterator.next());
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = paramJSONObject.get((String)localObject1);
        boolean bool = false;
        if (paramValueIndicator != null) {
          bool = paramValueIndicator.onJsonField((String)localObject1, paramJSONObject.get((String)localObject1));
        }
        if (!bool) {
          localLayoutAttrSet.addLayoutAttr((String)localObject1, localObject2);
        }
      }
      return localLayoutAttrSet;
    }
    catch (Exception paramJSONObject)
    {
      DittoLog.e("DITTO_UI", "parse file err:", paramJSONObject);
    }
  }
  
  private Integer isDpOrPxValue(String paramString, float paramFloat, int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    if ((paramArrayOfChar[paramInt2] == 'd') && (paramArrayOfChar[(paramInt2 + 1)] == 'p'))
    {
      paramArrayOfChar = attrValueCache;
      float f1 = DittoUIEngine.g().getDensity();
      float f2 = paramInt1;
      paramArrayOfChar.put(paramString, Integer.valueOf((int)(f1 * paramFloat * f2)));
      return Integer.valueOf((int)(DittoUIEngine.g().getDensity() * paramFloat * f2));
    }
    if ((paramArrayOfChar[paramInt2] == 'p') && (paramArrayOfChar[(paramInt2 + 1)] == 'x'))
    {
      paramArrayOfChar = attrValueCache;
      paramInt1 = (int)paramFloat * paramInt1;
      paramArrayOfChar.put(paramString, Integer.valueOf(paramInt1));
      return Integer.valueOf(paramInt1);
    }
    return null;
  }
  
  private int parseColor(String paramString)
  {
    try
    {
      int i = DittoResourcesUtil.parseColor(paramString);
      return i;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the text ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" can't be parsed as color string");
      DittoLog.e("DITTO_UI", localStringBuilder.toString(), localThrowable);
    }
    return 0;
  }
  
  private void parseContentB(String paramString, Object paramObject)
  {
    if ("shadow_size".equals(paramString))
    {
      parseShadowSize(paramObject.toString());
      return;
    }
    if ("bg_color".equals(paramString))
    {
      this.bg_color = parseColor(paramObject.toString());
      return;
    }
    if ("centerVertical".equals(paramString))
    {
      this.centerVertical = ((Boolean)paramObject).booleanValue();
      return;
    }
    if ("centerHorizontal".equals(paramString))
    {
      this.centerHorizontal = ((Boolean)paramObject).booleanValue();
      return;
    }
    if ("centerInParent".equals(paramString))
    {
      this.centerInParent = ((Boolean)paramObject).booleanValue();
      return;
    }
    if ("alignParentLeft".equals(paramString))
    {
      this.alignParentLeft = ((Boolean)paramObject).booleanValue();
      return;
    }
    if ("alignParentBottom".equals(paramString))
    {
      this.alignParentBottom = ((Boolean)paramObject).booleanValue();
      return;
    }
    if ("alignParentRight".equals(paramString))
    {
      this.alignParentRight = ((Boolean)paramObject).booleanValue();
      return;
    }
    if ("alignParentTop".equals(paramString))
    {
      this.alignParentTop = ((Boolean)paramObject).booleanValue();
      return;
    }
    parseContentC(paramString, paramObject);
  }
  
  private void parseContentC(String paramString, Object paramObject)
  {
    if ("alignWithParentIfMissing".equals(paramString))
    {
      this.alignWithParentIfMissing = ((Boolean)paramObject).booleanValue();
      return;
    }
    if ("alignTop".equals(paramString))
    {
      this.alignTop = paramObject.toString();
      return;
    }
    if ("alignBottom".equals(paramString))
    {
      this.alignBottom = paramObject.toString();
      return;
    }
    if ("alignLeft".equals(paramString))
    {
      this.alignLeft = paramObject.toString();
      return;
    }
    if ("alignRight".equals(paramString))
    {
      this.alignRight = paramObject.toString();
      return;
    }
    if ("above".equals(paramString))
    {
      this.above = paramObject.toString();
      return;
    }
    if ("below".equals(paramString))
    {
      this.below = paramObject.toString();
      return;
    }
    if ("toLeftOf".equals(paramString))
    {
      this.toLeftOf = paramObject.toString();
      return;
    }
    if ("toRightOf".equals(paramString))
    {
      this.toRightOf = paramObject.toString();
      return;
    }
    parseContentD(paramString, paramObject);
  }
  
  private void parseContentD(String paramString, Object paramObject)
  {
    if ("margin_left".equals(paramString))
    {
      this.leftMargin = parseInteger(paramObject.toString());
      return;
    }
    if ("margin_right".equals(paramString))
    {
      this.rightMargin = parseInteger(paramObject.toString());
      return;
    }
    if ("margin_top".equals(paramString))
    {
      this.topMargin = parseInteger(paramObject.toString());
      return;
    }
    if ("margin_bottom".equals(paramString))
    {
      this.bottomMargin = parseInteger(paramObject.toString());
      return;
    }
    if ("padding_left".equals(paramString))
    {
      this.leftPadding = parseInteger(paramObject.toString());
      return;
    }
    if ("padding_right".equals(paramString))
    {
      this.rightPadding = parseInteger(paramObject.toString());
      return;
    }
    if ("padding_top".equals(paramString))
    {
      this.topPadding = parseInteger(paramObject.toString());
      return;
    }
    if ("padding_bottom".equals(paramString))
    {
      this.bottomPadding = parseInteger(paramObject.toString());
      return;
    }
    if ("shadow_id".equals(paramString))
    {
      this.shadowResourceId = DittoUIEngine.g().getResourceId(paramObject.toString());
      return;
    }
    parseContentE(paramString, paramObject);
  }
  
  private void parseContentE(String paramString, Object paramObject)
  {
    if ("border_radii4".equals(paramString))
    {
      parseRadii4(paramObject.toString());
      return;
    }
    if ("bgGradientDir".equals(paramString))
    {
      this.gradientDirection = paramObject.toString();
      return;
    }
    if ("bgGradientStartColor".equals(paramString))
    {
      this.gradientStartColor = parseColor(paramObject.toString());
      return;
    }
    if ("bgGradientEndColor".equals(paramString))
    {
      this.gradientEndColor = parseColor(paramObject.toString());
      return;
    }
    if ("pressedAlpha".equals(paramString))
    {
      this.pressedAlpha = parseInteger(paramObject.toString());
      return;
    }
    if ("weight".equals(paramString)) {
      this.weight = ((Integer)paramObject).intValue();
    }
  }
  
  private Integer parseIntegerNormal(String paramString)
  {
    int i = paramString.hashCode();
    if (i != 48)
    {
      if (i != 1443)
      {
        if (i != 343327108)
        {
          if ((i == 1386124388) && (paramString.equals("match_parent")))
          {
            i = 1;
            break label97;
          }
        }
        else if (paramString.equals("wrap_content"))
        {
          i = 0;
          break label97;
        }
      }
      else if (paramString.equals("-0"))
      {
        i = 3;
        break label97;
      }
    }
    else if (paramString.equals("0"))
    {
      i = 2;
      break label97;
    }
    i = -1;
    label97:
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i != 2) && (i != 3)) {
          return null;
        }
        return Integer.valueOf(0);
      }
      return Integer.valueOf(-1);
    }
    return Integer.valueOf(-2);
  }
  
  public void addLayoutAttr(String paramString, Object paramObject)
  {
    parseContent(paramString, paramObject);
    this.mAttrs.put(paramString, paramObject);
  }
  
  public LayoutAttrSet clone()
  {
    try
    {
      LayoutAttrSet localLayoutAttrSet = new LayoutAttrSet();
      localLayoutAttrSet.mAttrs.putAll(this.mAttrs);
      localLayoutAttrSet.id = this.id;
      localLayoutAttrSet.width = this.width;
      localLayoutAttrSet.height = this.height;
      localLayoutAttrSet.orientation = this.orientation;
      localLayoutAttrSet.layout_gravity = this.layout_gravity;
      localLayoutAttrSet.leftMargin = this.leftMargin;
      localLayoutAttrSet.topMargin = this.topMargin;
      localLayoutAttrSet.rightMargin = this.rightMargin;
      localLayoutAttrSet.bottomMargin = this.bottomMargin;
      localLayoutAttrSet.leftPadding = this.leftPadding;
      localLayoutAttrSet.topPadding = this.topPadding;
      localLayoutAttrSet.rightPadding = this.rightPadding;
      localLayoutAttrSet.bottomPadding = this.bottomPadding;
      localLayoutAttrSet.bg_color = this.bg_color;
      localLayoutAttrSet.centerVertical = this.centerVertical;
      localLayoutAttrSet.centerHorizontal = this.centerHorizontal;
      localLayoutAttrSet.centerInParent = this.centerInParent;
      localLayoutAttrSet.alignParentLeft = this.alignParentLeft;
      localLayoutAttrSet.alignParentBottom = this.alignParentBottom;
      localLayoutAttrSet.alignParentRight = this.alignParentRight;
      localLayoutAttrSet.alignParentTop = this.alignParentTop;
      localLayoutAttrSet.alignWithParentIfMissing = this.alignWithParentIfMissing;
      localLayoutAttrSet.alignTop = this.alignTop;
      localLayoutAttrSet.alignBottom = this.alignBottom;
      localLayoutAttrSet.alignLeft = this.alignLeft;
      localLayoutAttrSet.alignRight = this.alignRight;
      localLayoutAttrSet.above = this.above;
      localLayoutAttrSet.below = this.below;
      localLayoutAttrSet.toLeftOf = this.toLeftOf;
      localLayoutAttrSet.toRightOf = this.toRightOf;
      localLayoutAttrSet.topLeftRadius = this.topLeftRadius;
      localLayoutAttrSet.bottomLeftRadius = this.bottomLeftRadius;
      localLayoutAttrSet.topRightRadius = this.topRightRadius;
      localLayoutAttrSet.bottomRightRadius = this.bottomRightRadius;
      localLayoutAttrSet.gradientDirection = this.gradientDirection;
      localLayoutAttrSet.gradientStartColor = this.gradientStartColor;
      localLayoutAttrSet.gradientEndColor = this.gradientEndColor;
      localLayoutAttrSet.pressedAlpha = this.pressedAlpha;
      return localLayoutAttrSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public float getAttr(String paramString, float paramFloat)
  {
    try
    {
      float f = ((Number)this.mAttrs.get(paramString)).floatValue();
      return f;
    }
    catch (Exception paramString) {}
    return paramFloat;
  }
  
  public int getAttr(String paramString, int paramInt)
  {
    try
    {
      int i = ((Integer)this.mAttrs.get(paramString)).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public long getAttr(String paramString, long paramLong)
  {
    try
    {
      long l = ((Long)this.mAttrs.get(paramString)).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return paramLong;
  }
  
  public String getAttr(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)this.mAttrs.get(paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      label16:
      break label16;
    }
    return paramString2;
  }
  
  public boolean getAttr(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = ((Boolean)this.mAttrs.get(paramString)).booleanValue();
      return bool;
    }
    catch (Exception paramString) {}
    return paramBoolean;
  }
  
  public <T> T getAttrWithDefault(String paramString, T paramT)
  {
    try
    {
      paramString = this.mAttrs.get(paramString);
      if (paramString != null)
      {
        boolean bool = paramT.getClass().isInstance(paramString);
        if (bool) {
          return paramString;
        }
      }
      return paramT;
    }
    catch (Exception paramString)
    {
      label32:
      break label32;
    }
    return null;
  }
  
  public int[] getIntArrayAttr(String paramString)
  {
    int j;
    int[] arrayOfInt;
    int i;
    if ((this.mAttrs.containsKey(paramString)) && ((this.mAttrs.get(paramString) instanceof JSONArray)))
    {
      paramString = (JSONArray)this.mAttrs.get(paramString);
      j = paramString.length();
      arrayOfInt = new int[j];
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label83;
      }
      try
      {
        arrayOfInt[i] = paramString.optInt(i);
        i += 1;
      }
      catch (Exception paramString)
      {
        label79:
        break label79;
      }
    }
    return new int[0];
    label83:
    return arrayOfInt;
    return new int[0];
  }
  
  public int getPostFixedAttr(String paramString, int paramInt)
  {
    try
    {
      paramString = this.mAttrs.get(paramString);
      int i = paramInt;
      if (paramString != null) {
        i = parseInteger((String)paramString);
      }
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public int getResourceId(String paramString)
  {
    return DittoUIEngine.g().getResourceId(getAttr(paramString, ""));
  }
  
  public boolean hasAttr(String paramString)
  {
    return this.mAttrs.containsKey(paramString);
  }
  
  protected void parseContent(String paramString, Object paramObject)
  {
    try
    {
      if ("id".equals(paramString))
      {
        this.id = paramObject.toString();
        return;
      }
      if ("width".equals(paramString))
      {
        this.width = parseInteger(paramObject.toString());
        return;
      }
      if ("height".equals(paramString))
      {
        this.height = parseInteger(paramObject.toString());
        return;
      }
      if ("orientation".equals(paramString))
      {
        this.orientation = LayoutAttrDefine.Orientation.parse(paramObject.toString());
        return;
      }
      if ("layout_gravity".equals(paramString))
      {
        this.layout_gravity = LayoutAttrDefine.Gravity.parse(paramObject.toString());
        return;
      }
      if ("gravity".equals(paramString))
      {
        this.gravity = LayoutAttrDefine.Gravity.parse(paramObject.toString());
        return;
      }
      if ("margin".equals(paramString))
      {
        parseMargin(paramObject.toString());
        return;
      }
      if ("padding".equals(paramString))
      {
        parsePadding(paramObject.toString());
        return;
      }
      parseContentB(paramString, paramObject);
      return;
    }
    catch (Exception localException)
    {
      DittoLog.e("DITTO_UI", String.format("parse attr err: %s : %s", new Object[] { paramString, paramObject.toString() }), localException);
    }
  }
  
  public int parseInteger(String paramString)
  {
    if (attrValueCache.containsKey(paramString)) {
      return ((Integer)attrValueCache.get(paramString)).intValue();
    }
    Object localObject = parseIntegerNormal(paramString);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    paramString = paramString.replaceAll(" ", "");
    localObject = paramString.toCharArray();
    int j = 0;
    float f = 0.0F;
    int m = 1;
    int k = 0;
    int i = 10;
    while (j < localObject.length)
    {
      if ((localObject[j] >= '0') && (localObject[j] <= '9'))
      {
        if (k != 0)
        {
          f += Integer.parseInt(Character.valueOf(localObject[j]).toString()) / i;
          i *= 10;
        }
        else
        {
          f = f * 10.0F + Integer.parseInt(Character.valueOf(localObject[j]).toString());
        }
      }
      else if (localObject[j] == '.')
      {
        k = 1;
      }
      else if (localObject[j] == '-')
      {
        m = -1;
      }
      else
      {
        Integer localInteger = isDpOrPxValue(paramString, f, m, (char[])localObject, j);
        if (localInteger != null) {
          return localInteger.intValue();
        }
      }
      j += 1;
    }
    localObject = attrValueCache;
    i = (int)f * m;
    ((Map)localObject).put(paramString, Integer.valueOf(i));
    return i;
  }
  
  public void parseMargin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length < 4) {
          return;
        }
        int[] arrayOfInt = new int[4];
        int i = 0;
        while (i < arrayOfInt.length)
        {
          arrayOfInt[i] = parseInteger(paramString[i].trim());
          i += 1;
        }
        this.leftMargin = arrayOfInt[0];
        this.topMargin = arrayOfInt[1];
        this.rightMargin = arrayOfInt[2];
        this.bottomMargin = arrayOfInt[3];
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void parsePadding(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length < 4) {
          return;
        }
        int[] arrayOfInt = new int[4];
        int i = 0;
        while (i < arrayOfInt.length)
        {
          arrayOfInt[i] = parseInteger(paramString[i].trim());
          i += 1;
        }
        this.leftPadding = arrayOfInt[0];
        this.topPadding = arrayOfInt[1];
        this.rightPadding = arrayOfInt[2];
        this.bottomPadding = arrayOfInt[3];
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void parseRadii4(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length < 4) {
          return;
        }
        int[] arrayOfInt = new int[4];
        int i = 0;
        while (i < arrayOfInt.length)
        {
          arrayOfInt[i] = parseInteger(paramString[i].trim());
          i += 1;
        }
        this.topLeftRadius = arrayOfInt[0];
        this.topRightRadius = arrayOfInt[1];
        this.bottomRightRadius = arrayOfInt[2];
        this.bottomLeftRadius = arrayOfInt[3];
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void parseShadowSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      String[] arrayOfString = paramString.split(",");
      if (arrayOfString == null) {
        return;
      }
      if (arrayOfString.length == 1)
      {
        i = parseInteger(paramString.trim());
        this.bottomShadowSize = i;
        this.topShadowSize = i;
        this.rightShadowSize = i;
        this.leftShadowSize = i;
        return;
      }
      if (arrayOfString.length < 4) {
        return;
      }
      paramString = new int[4];
      int i = 0;
      while (i < paramString.length)
      {
        paramString[i] = parseInteger(arrayOfString[i].trim());
        i += 1;
      }
      this.leftShadowSize = paramString[0];
      this.topShadowSize = paramString[1];
      this.rightShadowSize = paramString[2];
      this.bottomShadowSize = paramString[3];
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void setBottomMargin(int paramInt)
  {
    this.bottomMargin = paramInt;
  }
  
  public void setBottomPadding(int paramInt)
  {
    this.bottomPadding = paramInt;
  }
  
  public void setLeftMargin(int paramInt)
  {
    this.leftMargin = paramInt;
  }
  
  public void setLeftPadding(int paramInt)
  {
    this.leftPadding = paramInt;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.leftMargin = paramInt1;
    this.topMargin = paramInt2;
    this.rightMargin = paramInt3;
    this.bottomMargin = paramInt4;
  }
  
  public void setRightMargin(int paramInt)
  {
    this.rightMargin = paramInt;
  }
  
  public void setRightPadding(int paramInt)
  {
    this.rightPadding = paramInt;
  }
  
  public void setTopMargin(int paramInt)
  {
    this.topMargin = paramInt;
  }
  
  public void setTopPadding(int paramInt)
  {
    this.topPadding = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.shell.LayoutAttrSet
 * JD-Core Version:    0.7.0.1
 */