package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

public class TransitionInflater
{
  private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS = new ArrayMap();
  private static final Class<?>[] CONSTRUCTOR_SIGNATURE = { Context.class, AttributeSet.class };
  private final Context mContext;
  
  private TransitionInflater(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Object createCustom(AttributeSet paramAttributeSet, Class<?> paramClass, String paramString)
  {
    String str = paramAttributeSet.getAttributeValue(null, "class");
    if (str != null) {
      try
      {
        synchronized (CONSTRUCTORS)
        {
          Constructor localConstructor = (Constructor)CONSTRUCTORS.get(str);
          paramString = localConstructor;
          if (localConstructor == null)
          {
            Class localClass = Class.forName(str, false, this.mContext.getClassLoader()).asSubclass(paramClass);
            paramString = localConstructor;
            if (localClass != null)
            {
              paramString = localClass.getConstructor(CONSTRUCTOR_SIGNATURE);
              paramString.setAccessible(true);
              CONSTRUCTORS.put(str, paramString);
            }
          }
          paramAttributeSet = paramString.newInstance(new Object[] { this.mContext, paramAttributeSet });
          return paramAttributeSet;
        }
        paramAttributeSet = new StringBuilder();
      }
      catch (Exception paramAttributeSet)
      {
        paramString = new StringBuilder();
        paramString.append("Could not instantiate ");
        paramString.append(paramClass);
        paramString.append(" class ");
        paramString.append(str);
        throw new InflateException(paramString.toString(), paramAttributeSet);
      }
    }
    paramAttributeSet.append(paramString);
    paramAttributeSet.append(" tag must have a 'class' attribute");
    throw new InflateException(paramAttributeSet.toString());
  }
  
  private Transition createTransitionFromXml(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
  {
    int i = paramXmlPullParser.getDepth();
    TransitionSet localTransitionSet;
    if ((paramTransition instanceof TransitionSet)) {
      localTransitionSet = (TransitionSet)paramTransition;
    } else {
      localTransitionSet = null;
    }
    Object localObject2 = null;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label639;
      }
      if (j == 2)
      {
        Object localObject1 = paramXmlPullParser.getName();
        if ("fade".equals(localObject1))
        {
          localObject1 = new Fade(this.mContext, paramAttributeSet);
        }
        else if ("changeBounds".equals(localObject1))
        {
          localObject1 = new ChangeBounds(this.mContext, paramAttributeSet);
        }
        else if ("slide".equals(localObject1))
        {
          localObject1 = new Slide(this.mContext, paramAttributeSet);
        }
        else if ("explode".equals(localObject1))
        {
          localObject1 = new Explode(this.mContext, paramAttributeSet);
        }
        else if ("changeImageTransform".equals(localObject1))
        {
          localObject1 = new ChangeImageTransform(this.mContext, paramAttributeSet);
        }
        else if ("changeTransform".equals(localObject1))
        {
          localObject1 = new ChangeTransform(this.mContext, paramAttributeSet);
        }
        else if ("changeClipBounds".equals(localObject1))
        {
          localObject1 = new ChangeClipBounds(this.mContext, paramAttributeSet);
        }
        else if ("autoTransition".equals(localObject1))
        {
          localObject1 = new AutoTransition(this.mContext, paramAttributeSet);
        }
        else if ("changeScroll".equals(localObject1))
        {
          localObject1 = new ChangeScroll(this.mContext, paramAttributeSet);
        }
        else if ("transitionSet".equals(localObject1))
        {
          localObject1 = new TransitionSet(this.mContext, paramAttributeSet);
        }
        else if ("transition".equals(localObject1))
        {
          localObject1 = (Transition)createCustom(paramAttributeSet, Transition.class, "transition");
        }
        else if ("targets".equals(localObject1))
        {
          getTargetIds(paramXmlPullParser, paramAttributeSet, paramTransition);
          localObject1 = localObject2;
        }
        else if ("arcMotion".equals(localObject1))
        {
          if (paramTransition != null)
          {
            paramTransition.setPathMotion(new ArcMotion(this.mContext, paramAttributeSet));
            localObject1 = localObject2;
          }
          else
          {
            throw new RuntimeException("Invalid use of arcMotion element");
          }
        }
        else if ("pathMotion".equals(localObject1))
        {
          if (paramTransition != null)
          {
            paramTransition.setPathMotion((PathMotion)createCustom(paramAttributeSet, PathMotion.class, "pathMotion"));
            localObject1 = localObject2;
          }
          else
          {
            throw new RuntimeException("Invalid use of pathMotion element");
          }
        }
        else
        {
          if (!"patternPathMotion".equals(localObject1)) {
            break label601;
          }
          if (paramTransition == null) {
            break label591;
          }
          paramTransition.setPathMotion(new PatternPathMotion(this.mContext, paramAttributeSet));
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          if (!paramXmlPullParser.isEmptyElementTag()) {
            createTransitionFromXml(paramXmlPullParser, paramAttributeSet, (Transition)localObject1);
          }
          if (localTransitionSet != null)
          {
            localTransitionSet.addTransition((Transition)localObject1);
            break;
          }
          if (paramTransition != null) {
            break label581;
          }
          localObject2 = localObject1;
        }
      }
    }
    label581:
    throw new InflateException("Could not add transition to another transition.");
    label591:
    throw new RuntimeException("Invalid use of patternPathMotion element");
    label601:
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("Unknown scene name: ");
    paramAttributeSet.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramAttributeSet.toString());
    label639:
    return localObject2;
  }
  
  private TransitionManager createTransitionManagerFromXml(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, ViewGroup paramViewGroup)
  {
    int i = paramXmlPullParser.getDepth();
    TransitionManager localTransitionManager = null;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label146;
      }
      if (j == 2)
      {
        String str = paramXmlPullParser.getName();
        if (str.equals("transitionManager"))
        {
          localTransitionManager = new TransitionManager();
        }
        else
        {
          if ((!str.equals("transition")) || (localTransitionManager == null)) {
            break;
          }
          loadTransition(paramAttributeSet, paramXmlPullParser, paramViewGroup, localTransitionManager);
        }
      }
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("Unknown scene name: ");
    paramAttributeSet.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramAttributeSet.toString());
    label146:
    return localTransitionManager;
  }
  
  public static TransitionInflater from(Context paramContext)
  {
    return new TransitionInflater(paramContext);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void getTargetIds(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
  {
    int i = paramXmlPullParser.getDepth();
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        return;
      }
      if (j == 2) {
        if (paramXmlPullParser.getName().equals("target"))
        {
          TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION_TARGET);
          j = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "targetId", 1, 0);
          Object localObject;
          String str;
          if (j != 0)
          {
            paramTransition.addTarget(j);
          }
          else
          {
            j = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "excludeId", 2, 0);
            if (j != 0)
            {
              paramTransition.excludeTarget(j, true);
            }
            else
            {
              localObject = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "targetName", 4);
              if (localObject != null)
              {
                paramTransition.addTarget((String)localObject);
              }
              else
              {
                localObject = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "excludeName", 5);
                if (localObject != null)
                {
                  paramTransition.excludeTarget((String)localObject, true);
                }
                else
                {
                  str = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "excludeClass", 3);
                  if (str != null) {
                    localObject = str;
                  }
                }
              }
            }
          }
          try
          {
            paramTransition.excludeTarget(Class.forName(str), true);
            break label258;
            localObject = str;
            str = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "targetClass", 0);
            if (str != null)
            {
              localObject = str;
              paramTransition.addTarget(Class.forName(str));
            }
            label258:
            localTypedArray.recycle();
          }
          catch (ClassNotFoundException paramXmlPullParser)
          {
            localTypedArray.recycle();
            paramAttributeSet = new StringBuilder();
            paramAttributeSet.append("Could not create ");
            paramAttributeSet.append((String)localObject);
            throw new RuntimeException(paramAttributeSet.toString(), paramXmlPullParser);
          }
        }
      }
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("Unknown scene name: ");
    paramAttributeSet.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramAttributeSet.toString());
  }
  
  @SuppressLint({"RestrictedApi"})
  private void loadTransition(AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser, ViewGroup paramViewGroup, TransitionManager paramTransitionManager)
  {
    TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION_MANAGER);
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "transition", 2, -1);
    int j = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "fromScene", 0, -1);
    Object localObject = null;
    if (j < 0) {
      paramAttributeSet = null;
    } else {
      paramAttributeSet = Scene.getSceneForLayout(paramViewGroup, j, this.mContext);
    }
    j = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "toScene", 1, -1);
    if (j < 0) {
      paramXmlPullParser = localObject;
    } else {
      paramXmlPullParser = Scene.getSceneForLayout(paramViewGroup, j, this.mContext);
    }
    if (i >= 0)
    {
      paramViewGroup = inflateTransition(i);
      if (paramViewGroup != null) {
        if (paramXmlPullParser != null)
        {
          if (paramAttributeSet == null) {
            paramTransitionManager.setTransition(paramXmlPullParser, paramViewGroup);
          } else {
            paramTransitionManager.setTransition(paramAttributeSet, paramXmlPullParser, paramViewGroup);
          }
        }
        else
        {
          paramAttributeSet = new StringBuilder();
          paramAttributeSet.append("No toScene for transition ID ");
          paramAttributeSet.append(i);
          throw new RuntimeException(paramAttributeSet.toString());
        }
      }
    }
    localTypedArray.recycle();
  }
  
  /* Error */
  public Transition inflateTransition(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	androidx/transition/TransitionInflater:mContext	Landroid/content/Context;
    //   4: invokevirtual 357	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: iload_1
    //   8: invokevirtual 363	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   11: astore_2
    //   12: aload_0
    //   13: aload_2
    //   14: aload_2
    //   15: invokestatic 369	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   18: aconst_null
    //   19: invokespecial 225	androidx/transition/TransitionInflater:createTransitionFromXml	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroidx/transition/Transition;)Landroidx/transition/Transition;
    //   22: astore_3
    //   23: aload_2
    //   24: invokeinterface 374 1 0
    //   29: aload_3
    //   30: areturn
    //   31: astore_3
    //   32: goto +72 -> 104
    //   35: astore_3
    //   36: new 82	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   43: astore 4
    //   45: aload 4
    //   47: aload_2
    //   48: invokeinterface 377 1 0
    //   53: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: ldc_w 379
    //   62: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 4
    //   68: aload_3
    //   69: invokevirtual 382	java/io/IOException:getMessage	()Ljava/lang/String;
    //   72: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: new 96	android/view/InflateException
    //   79: dup
    //   80: aload 4
    //   82: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aload_3
    //   86: invokespecial 103	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore_3
    //   91: new 96	android/view/InflateException
    //   94: dup
    //   95: aload_3
    //   96: invokevirtual 383	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   99: aload_3
    //   100: invokespecial 103	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: athrow
    //   104: aload_2
    //   105: invokeinterface 374 1 0
    //   110: aload_3
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	TransitionInflater
    //   0	112	1	paramInt	int
    //   11	94	2	localXmlResourceParser	android.content.res.XmlResourceParser
    //   22	8	3	localTransition	Transition
    //   31	1	3	localObject	Object
    //   35	51	3	localIOException	java.io.IOException
    //   90	21	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   43	38	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	23	31	finally
    //   36	90	31	finally
    //   91	104	31	finally
    //   12	23	35	java/io/IOException
    //   12	23	90	org/xmlpull/v1/XmlPullParserException
  }
  
  /* Error */
  public TransitionManager inflateTransitionManager(int paramInt, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	androidx/transition/TransitionInflater:mContext	Landroid/content/Context;
    //   4: invokevirtual 357	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: iload_1
    //   8: invokevirtual 363	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_3
    //   14: aload_3
    //   15: invokestatic 369	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   18: aload_2
    //   19: invokespecial 387	androidx/transition/TransitionInflater:createTransitionManagerFromXml	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/ViewGroup;)Landroidx/transition/TransitionManager;
    //   22: astore_2
    //   23: aload_3
    //   24: invokeinterface 374 1 0
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: goto +92 -> 124
    //   35: astore_2
    //   36: new 82	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   43: astore 4
    //   45: aload 4
    //   47: aload_3
    //   48: invokeinterface 377 1 0
    //   53: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: ldc_w 379
    //   62: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 4
    //   68: aload_2
    //   69: invokevirtual 382	java/io/IOException:getMessage	()Ljava/lang/String;
    //   72: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: new 96	android/view/InflateException
    //   79: dup
    //   80: aload 4
    //   82: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 108	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   88: astore 4
    //   90: aload 4
    //   92: aload_2
    //   93: invokevirtual 391	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   96: pop
    //   97: aload 4
    //   99: athrow
    //   100: astore_2
    //   101: new 96	android/view/InflateException
    //   104: dup
    //   105: aload_2
    //   106: invokevirtual 383	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   109: invokespecial 108	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   112: astore 4
    //   114: aload 4
    //   116: aload_2
    //   117: invokevirtual 391	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   120: pop
    //   121: aload 4
    //   123: athrow
    //   124: aload_3
    //   125: invokeinterface 374 1 0
    //   130: aload_2
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	TransitionInflater
    //   0	132	1	paramInt	int
    //   0	132	2	paramViewGroup	ViewGroup
    //   11	114	3	localXmlResourceParser	android.content.res.XmlResourceParser
    //   43	79	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	23	31	finally
    //   36	100	31	finally
    //   101	124	31	finally
    //   12	23	35	java/io/IOException
    //   12	23	100	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.TransitionInflater
 * JD-Core Version:    0.7.0.1
 */