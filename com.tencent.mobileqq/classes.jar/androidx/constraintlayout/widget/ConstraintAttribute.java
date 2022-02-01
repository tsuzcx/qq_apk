package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute
{
  private static final String TAG = "TransitionLayout";
  boolean mBooleanValue;
  private int mColorValue;
  private float mFloatValue;
  private int mIntegerValue;
  String mName;
  private String mStringValue;
  private ConstraintAttribute.AttributeType mType;
  
  public ConstraintAttribute(ConstraintAttribute paramConstraintAttribute, Object paramObject)
  {
    this.mName = paramConstraintAttribute.mName;
    this.mType = paramConstraintAttribute.mType;
    setValue(paramObject);
  }
  
  public ConstraintAttribute(String paramString, ConstraintAttribute.AttributeType paramAttributeType)
  {
    this.mName = paramString;
    this.mType = paramAttributeType;
  }
  
  public ConstraintAttribute(String paramString, ConstraintAttribute.AttributeType paramAttributeType, Object paramObject)
  {
    this.mName = paramString;
    this.mType = paramAttributeType;
    setValue(paramObject);
  }
  
  private static int clamp(int paramInt)
  {
    paramInt = (paramInt & (paramInt >> 31 ^ 0xFFFFFFFF)) - 255;
    return (paramInt & paramInt >> 31) + 255;
  }
  
  public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> paramHashMap, View paramView)
  {
    HashMap localHashMap = new HashMap();
    Class localClass = paramView.getClass();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ConstraintAttribute localConstraintAttribute = (ConstraintAttribute)paramHashMap.get(str);
      try
      {
        if (str.equals("BackgroundColor"))
        {
          localHashMap.put(str, new ConstraintAttribute(localConstraintAttribute, Integer.valueOf(((ColorDrawable)paramView.getBackground()).getColor())));
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getMap");
          localStringBuilder.append(str);
          localHashMap.put(str, new ConstraintAttribute(localConstraintAttribute, localClass.getMethod(localStringBuilder.toString(), new Class[0]).invoke(paramView, new Object[0])));
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    return localHashMap;
  }
  
  public static void parse(Context paramContext, XmlPullParser paramXmlPullParser, HashMap<String, ConstraintAttribute> paramHashMap)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.CustomAttribute);
    int j = localTypedArray.getIndexCount();
    Object localObject3 = null;
    paramXmlPullParser = (XmlPullParser)localObject3;
    Object localObject4 = paramXmlPullParser;
    int i = 0;
    Object localObject5 = paramXmlPullParser;
    while (i < j)
    {
      int k = localTypedArray.getIndex(i);
      Object localObject1;
      Object localObject2;
      if (k == R.styleable.CustomAttribute_attributeName)
      {
        localObject3 = localTypedArray.getString(k);
        paramXmlPullParser = (XmlPullParser)localObject3;
        localObject1 = localObject5;
        localObject2 = localObject4;
        if (localObject3 != null)
        {
          paramXmlPullParser = (XmlPullParser)localObject3;
          localObject1 = localObject5;
          localObject2 = localObject4;
          if (((String)localObject3).length() > 0)
          {
            paramXmlPullParser = new StringBuilder();
            paramXmlPullParser.append(Character.toUpperCase(((String)localObject3).charAt(0)));
            paramXmlPullParser.append(((String)localObject3).substring(1));
            paramXmlPullParser = paramXmlPullParser.toString();
            localObject1 = localObject5;
            localObject2 = localObject4;
          }
        }
      }
      else if (k == R.styleable.CustomAttribute_customBoolean)
      {
        localObject1 = Boolean.valueOf(localTypedArray.getBoolean(k, false));
        localObject2 = ConstraintAttribute.AttributeType.BOOLEAN_TYPE;
        paramXmlPullParser = (XmlPullParser)localObject3;
      }
      else
      {
        if (k == R.styleable.CustomAttribute_customColorValue)
        {
          paramXmlPullParser = ConstraintAttribute.AttributeType.COLOR_TYPE;
          localObject1 = Integer.valueOf(localTypedArray.getColor(k, 0));
        }
        for (;;)
        {
          localObject2 = paramXmlPullParser;
          paramXmlPullParser = (XmlPullParser)localObject3;
          break;
          if (k == R.styleable.CustomAttribute_customColorDrawableValue)
          {
            paramXmlPullParser = ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE;
            localObject1 = Integer.valueOf(localTypedArray.getColor(k, 0));
          }
          else if (k == R.styleable.CustomAttribute_customPixelDimension)
          {
            paramXmlPullParser = ConstraintAttribute.AttributeType.DIMENSION_TYPE;
            localObject1 = Float.valueOf(TypedValue.applyDimension(1, localTypedArray.getDimension(k, 0.0F), paramContext.getResources().getDisplayMetrics()));
          }
          else if (k == R.styleable.CustomAttribute_customDimension)
          {
            paramXmlPullParser = ConstraintAttribute.AttributeType.DIMENSION_TYPE;
            localObject1 = Float.valueOf(localTypedArray.getDimension(k, 0.0F));
          }
          else if (k == R.styleable.CustomAttribute_customFloatValue)
          {
            paramXmlPullParser = ConstraintAttribute.AttributeType.FLOAT_TYPE;
            localObject1 = Float.valueOf(localTypedArray.getFloat(k, (0.0F / 0.0F)));
          }
          else if (k == R.styleable.CustomAttribute_customIntegerValue)
          {
            paramXmlPullParser = ConstraintAttribute.AttributeType.INT_TYPE;
            localObject1 = Integer.valueOf(localTypedArray.getInteger(k, -1));
          }
          else
          {
            paramXmlPullParser = (XmlPullParser)localObject3;
            localObject1 = localObject5;
            localObject2 = localObject4;
            if (k != R.styleable.CustomAttribute_customStringValue) {
              break;
            }
            paramXmlPullParser = ConstraintAttribute.AttributeType.STRING_TYPE;
            localObject1 = localTypedArray.getString(k);
          }
        }
      }
      i += 1;
      localObject3 = paramXmlPullParser;
      localObject5 = localObject1;
      localObject4 = localObject2;
    }
    if ((localObject3 != null) && (localObject5 != null)) {
      paramHashMap.put(localObject3, new ConstraintAttribute((String)localObject3, (ConstraintAttribute.AttributeType)localObject4, localObject5));
    }
    localTypedArray.recycle();
  }
  
  public static void setAttributes(View paramView, HashMap<String, ConstraintAttribute> paramHashMap)
  {
    Class localClass = paramView.getClass();
    Iterator localIterator = paramHashMap.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        Object localObject3 = (ConstraintAttribute)paramHashMap.get(localObject1);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("set");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
        try
        {
          switch (ConstraintAttribute.1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[localObject3.mType.ordinal()])
          {
          case 7: 
            localClass.getMethod((String)localObject2, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(((ConstraintAttribute)localObject3).mFloatValue) });
            break;
          case 6: 
            localClass.getMethod((String)localObject2, new Class[] { Boolean.TYPE }).invoke(paramView, new Object[] { Boolean.valueOf(((ConstraintAttribute)localObject3).mBooleanValue) });
            break;
          case 5: 
            localClass.getMethod((String)localObject2, new Class[] { CharSequence.class }).invoke(paramView, new Object[] { ((ConstraintAttribute)localObject3).mStringValue });
            break;
          case 4: 
            localClass.getMethod((String)localObject2, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(((ConstraintAttribute)localObject3).mFloatValue) });
            break;
          case 3: 
            localClass.getMethod((String)localObject2, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf(((ConstraintAttribute)localObject3).mIntegerValue) });
            break;
          case 2: 
            Method localMethod = localClass.getMethod((String)localObject2, new Class[] { Drawable.class });
            ColorDrawable localColorDrawable = new ColorDrawable();
            localColorDrawable.setColor(((ConstraintAttribute)localObject3).mColorValue);
            localMethod.invoke(paramView, new Object[] { localColorDrawable });
            break;
          case 1: 
            localClass.getMethod((String)localObject2, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf(((ConstraintAttribute)localObject3).mColorValue) });
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" Custom Attribute \"");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("\" not found on ");
          ((StringBuilder)localObject3).append(localClass.getName());
          Log.e("TransitionLayout", ((StringBuilder)localObject3).toString());
          localInvocationTargetException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" Custom Attribute \"");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("\" not found on ");
          ((StringBuilder)localObject3).append(localClass.getName());
          Log.e("TransitionLayout", ((StringBuilder)localObject3).toString());
          localIllegalAccessException.printStackTrace();
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.e("TransitionLayout", localNoSuchMethodException.getMessage());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" Custom Attribute \"");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("\" not found on ");
          localStringBuilder.append(localClass.getName());
          Log.e("TransitionLayout", localStringBuilder.toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localClass.getName());
          ((StringBuilder)localObject1).append(" must have a method ");
          ((StringBuilder)localObject1).append(localIllegalAccessException);
          Log.e("TransitionLayout", ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public boolean diff(ConstraintAttribute paramConstraintAttribute)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool2 = false;
    boolean bool1 = bool7;
    if (paramConstraintAttribute != null)
    {
      if (this.mType != paramConstraintAttribute.mType) {
        return false;
      }
      switch (ConstraintAttribute.1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()])
      {
      default: 
        return false;
      case 7: 
        bool1 = bool2;
        if (this.mFloatValue == paramConstraintAttribute.mFloatValue) {
          bool1 = true;
        }
        return bool1;
      case 6: 
        bool1 = bool3;
        if (this.mBooleanValue == paramConstraintAttribute.mBooleanValue) {
          bool1 = true;
        }
        return bool1;
      case 5: 
        bool1 = bool4;
        if (this.mIntegerValue == paramConstraintAttribute.mIntegerValue) {
          bool1 = true;
        }
        return bool1;
      case 4: 
        bool1 = bool5;
        if (this.mFloatValue == paramConstraintAttribute.mFloatValue) {
          bool1 = true;
        }
        return bool1;
      case 3: 
        bool1 = bool6;
        if (this.mIntegerValue == paramConstraintAttribute.mIntegerValue) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool7;
      if (this.mColorValue == paramConstraintAttribute.mColorValue) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ConstraintAttribute.AttributeType getType()
  {
    return this.mType;
  }
  
  public float getValueToInterpolate()
  {
    switch (ConstraintAttribute.1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()])
    {
    default: 
      return (0.0F / 0.0F);
    case 7: 
      return this.mFloatValue;
    case 6: 
      if (this.mBooleanValue) {
        return 0.0F;
      }
      return 1.0F;
    case 5: 
      throw new RuntimeException("Cannot interpolate String");
    case 4: 
      return this.mFloatValue;
    case 3: 
      return this.mIntegerValue;
    }
    throw new RuntimeException("Color does not have a single color to interpolate");
  }
  
  public void getValuesToInterpolate(float[] paramArrayOfFloat)
  {
    switch (ConstraintAttribute.1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()])
    {
    default: 
      return;
    case 7: 
      paramArrayOfFloat[0] = this.mFloatValue;
      return;
    case 6: 
      if (this.mBooleanValue) {
        f1 = 0.0F;
      } else {
        f1 = 1.0F;
      }
      paramArrayOfFloat[0] = f1;
      return;
    case 5: 
      throw new RuntimeException("Color does not have a single color to interpolate");
    case 4: 
      paramArrayOfFloat[0] = this.mFloatValue;
      return;
    case 3: 
      paramArrayOfFloat[0] = this.mIntegerValue;
      return;
    }
    int i = this.mColorValue;
    float f1 = (float)Math.pow((i >> 16 & 0xFF) / 255.0F, 2.2D);
    float f2 = (float)Math.pow((i >> 8 & 0xFF) / 255.0F, 2.2D);
    float f3 = (float)Math.pow((i & 0xFF) / 255.0F, 2.2D);
    paramArrayOfFloat[0] = f1;
    paramArrayOfFloat[1] = f2;
    paramArrayOfFloat[2] = f3;
    paramArrayOfFloat[3] = ((i >> 24 & 0xFF) / 255.0F);
  }
  
  public int noOfInterpValues()
  {
    int i = ConstraintAttribute.1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
    if ((i != 1) && (i != 2)) {
      return 1;
    }
    return 4;
  }
  
  public void setColorValue(int paramInt)
  {
    this.mColorValue = paramInt;
  }
  
  public void setFloatValue(float paramFloat)
  {
    this.mFloatValue = paramFloat;
  }
  
  public void setIntValue(int paramInt)
  {
    this.mIntegerValue = paramInt;
  }
  
  public void setInterpolatedValue(View paramView, float[] paramArrayOfFloat)
  {
    Object localObject2 = paramView.getClass();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("set");
    ((StringBuilder)localObject1).append(this.mName);
    localObject1 = ((StringBuilder)localObject1).toString();
    boolean bool;
    try
    {
      i = ConstraintAttribute.1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
      bool = true;
      switch (i)
      {
      case 7: 
        ((Class)localObject2).getMethod((String)localObject1, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(paramArrayOfFloat[0]) });
        return;
      }
    }
    catch (InvocationTargetException paramView)
    {
      int i;
      paramView.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramArrayOfFloat)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cannot access method ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("on View \"");
      ((StringBuilder)localObject2).append(Debug.getName(paramView));
      ((StringBuilder)localObject2).append("\"");
      Log.e("TransitionLayout", ((StringBuilder)localObject2).toString());
      paramArrayOfFloat.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramArrayOfFloat)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("no method ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("on View \"");
      ((StringBuilder)localObject2).append(Debug.getName(paramView));
      ((StringBuilder)localObject2).append("\"");
      Log.e("TransitionLayout", ((StringBuilder)localObject2).toString());
      paramArrayOfFloat.printStackTrace();
      return;
    }
    localObject2 = ((Class)localObject2).getMethod((String)localObject1, new Class[] { Boolean.TYPE });
    if (paramArrayOfFloat[0] > 0.5F) {
      break label168;
    }
    for (;;)
    {
      label168:
      ((Method)localObject2).invoke(paramView, new Object[] { Boolean.valueOf(bool) });
      return;
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("unable to interpolate strings ");
      paramArrayOfFloat.append(this.mName);
      throw new RuntimeException(paramArrayOfFloat.toString());
      ((Class)localObject2).getMethod((String)localObject1, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(paramArrayOfFloat[0]) });
      return;
      ((Class)localObject2).getMethod((String)localObject1, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf((int)paramArrayOfFloat[0]) });
      return;
      localObject2 = ((Class)localObject2).getMethod((String)localObject1, new Class[] { Drawable.class });
      i = clamp((int)((float)Math.pow(paramArrayOfFloat[0], 0.4545454545454545D) * 255.0F));
      int j = clamp((int)((float)Math.pow(paramArrayOfFloat[1], 0.4545454545454545D) * 255.0F));
      int k = clamp((int)((float)Math.pow(paramArrayOfFloat[2], 0.4545454545454545D) * 255.0F));
      int m = clamp((int)(paramArrayOfFloat[3] * 255.0F));
      paramArrayOfFloat = new ColorDrawable();
      paramArrayOfFloat.setColor(i << 16 | m << 24 | j << 8 | k);
      ((Method)localObject2).invoke(paramView, new Object[] { paramArrayOfFloat });
      return;
      localObject2 = ((Class)localObject2).getMethod((String)localObject1, new Class[] { Integer.TYPE });
      i = clamp((int)((float)Math.pow(paramArrayOfFloat[0], 0.4545454545454545D) * 255.0F));
      j = clamp((int)((float)Math.pow(paramArrayOfFloat[1], 0.4545454545454545D) * 255.0F));
      k = clamp((int)((float)Math.pow(paramArrayOfFloat[2], 0.4545454545454545D) * 255.0F));
      ((Method)localObject2).invoke(paramView, new Object[] { Integer.valueOf(i << 16 | clamp((int)(paramArrayOfFloat[3] * 255.0F)) << 24 | j << 8 | k) });
      return;
      return;
      bool = false;
    }
  }
  
  public void setStringValue(String paramString)
  {
    this.mStringValue = paramString;
  }
  
  public void setValue(Object paramObject)
  {
    switch (ConstraintAttribute.1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()])
    {
    default: 
      return;
    case 7: 
      this.mFloatValue = ((Float)paramObject).floatValue();
      return;
    case 6: 
      this.mBooleanValue = ((Boolean)paramObject).booleanValue();
      return;
    case 5: 
      this.mStringValue = ((String)paramObject);
      return;
    case 4: 
      this.mFloatValue = ((Float)paramObject).floatValue();
      return;
    case 3: 
      this.mIntegerValue = ((Integer)paramObject).intValue();
      return;
    }
    this.mColorValue = ((Integer)paramObject).intValue();
  }
  
  public void setValue(float[] paramArrayOfFloat)
  {
    int i = ConstraintAttribute.1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
    boolean bool = false;
    switch (i)
    {
    default: 
      return;
    case 7: 
      this.mFloatValue = paramArrayOfFloat[0];
      return;
    case 6: 
      if (paramArrayOfFloat[0] > 0.5D) {
        bool = true;
      }
      this.mBooleanValue = bool;
      return;
    case 5: 
      throw new RuntimeException("Color does not have a single color to interpolate");
    case 4: 
      this.mFloatValue = paramArrayOfFloat[0];
      return;
    case 3: 
      this.mIntegerValue = ((int)paramArrayOfFloat[0]);
      return;
    }
    this.mColorValue = Color.HSVToColor(paramArrayOfFloat);
    i = this.mColorValue;
    this.mColorValue = (clamp((int)(paramArrayOfFloat[3] * 255.0F)) << 24 | i & 0xFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintAttribute
 * JD-Core Version:    0.7.0.1
 */