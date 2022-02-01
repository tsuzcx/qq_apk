package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.RestrictTo;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimationUtilsCompat
{
  private static Interpolator createInterpolatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
  {
    int i = paramXmlPullParser.getDepth();
    paramResources = null;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        return paramResources;
      }
      if (j == 2)
      {
        paramResources = Xml.asAttributeSet(paramXmlPullParser);
        paramTheme = paramXmlPullParser.getName();
        if (!paramTheme.equals("linearInterpolator")) {
          break;
        }
        paramResources = new LinearInterpolator();
      }
    }
    if (paramTheme.equals("accelerateInterpolator")) {
      paramResources = new AccelerateInterpolator(paramContext, paramResources);
    }
    for (;;)
    {
      break;
      if (paramTheme.equals("decelerateInterpolator"))
      {
        paramResources = new DecelerateInterpolator(paramContext, paramResources);
      }
      else
      {
        if (paramTheme.equals("accelerateDecelerateInterpolator"))
        {
          paramResources = new AccelerateDecelerateInterpolator();
          break;
        }
        if (paramTheme.equals("cycleInterpolator"))
        {
          paramResources = new CycleInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("anticipateInterpolator"))
        {
          paramResources = new AnticipateInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("overshootInterpolator"))
        {
          paramResources = new OvershootInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("anticipateOvershootInterpolator"))
        {
          paramResources = new AnticipateOvershootInterpolator(paramContext, paramResources);
        }
        else
        {
          if (paramTheme.equals("bounceInterpolator"))
          {
            paramResources = new BounceInterpolator();
            break;
          }
          if (!paramTheme.equals("pathInterpolator")) {
            break label277;
          }
          paramResources = new PathInterpolatorCompat(paramContext, paramResources, paramXmlPullParser);
        }
      }
    }
    label277:
    paramContext = new StringBuilder();
    paramContext.append("Unknown interpolator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
    return paramResources;
  }
  
  /* Error */
  public static Interpolator loadInterpolator(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: getstatic 123	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +9 -> 14
    //   8: aload_0
    //   9: iload_1
    //   10: invokestatic 127	android/view/animation/AnimationUtils:loadInterpolator	(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
    //   13: areturn
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: aconst_null
    //   20: astore_2
    //   21: iload_1
    //   22: ldc 128
    //   24: if_icmpne +11 -> 35
    //   27: new 130	androidx/interpolator/view/animation/FastOutLinearInInterpolator
    //   30: dup
    //   31: invokespecial 131	androidx/interpolator/view/animation/FastOutLinearInInterpolator:<init>	()V
    //   34: areturn
    //   35: iload_1
    //   36: ldc 132
    //   38: if_icmpne +11 -> 49
    //   41: new 134	androidx/interpolator/view/animation/FastOutSlowInInterpolator
    //   44: dup
    //   45: invokespecial 135	androidx/interpolator/view/animation/FastOutSlowInInterpolator:<init>	()V
    //   48: areturn
    //   49: iload_1
    //   50: ldc 136
    //   52: if_icmpne +11 -> 63
    //   55: new 138	androidx/interpolator/view/animation/LinearOutSlowInInterpolator
    //   58: dup
    //   59: invokespecial 139	androidx/interpolator/view/animation/LinearOutSlowInInterpolator:<init>	()V
    //   62: areturn
    //   63: aload_0
    //   64: invokevirtual 145	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   67: iload_1
    //   68: invokevirtual 151	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   71: astore 5
    //   73: aload 5
    //   75: astore_2
    //   76: aload 5
    //   78: astore_3
    //   79: aload 5
    //   81: astore 4
    //   83: aload_0
    //   84: aload_0
    //   85: invokevirtual 145	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   88: aload_0
    //   89: invokevirtual 155	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   92: aload 5
    //   94: invokestatic 157	androidx/vectordrawable/graphics/drawable/AnimationUtilsCompat:createInterpolatorFromXml	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Interpolator;
    //   97: astore_0
    //   98: aload 5
    //   100: ifnull +10 -> 110
    //   103: aload 5
    //   105: invokeinterface 162 1 0
    //   110: aload_0
    //   111: areturn
    //   112: aload_3
    //   113: astore_2
    //   114: new 96	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   121: astore 4
    //   123: aload_3
    //   124: astore_2
    //   125: aload 4
    //   127: ldc 164
    //   129: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_3
    //   134: astore_2
    //   135: aload 4
    //   137: iload_1
    //   138: invokestatic 170	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   141: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_3
    //   146: astore_2
    //   147: new 172	android/content/res/Resources$NotFoundException
    //   150: dup
    //   151: aload 4
    //   153: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokespecial 173	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   159: astore 4
    //   161: aload_3
    //   162: astore_2
    //   163: aload 4
    //   165: aload_0
    //   166: invokevirtual 177	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   169: pop
    //   170: aload_3
    //   171: astore_2
    //   172: aload 4
    //   174: athrow
    //   175: aload 4
    //   177: astore_2
    //   178: new 96	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   185: astore_3
    //   186: aload 4
    //   188: astore_2
    //   189: aload_3
    //   190: ldc 164
    //   192: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: astore_2
    //   199: aload_3
    //   200: iload_1
    //   201: invokestatic 170	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   204: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 4
    //   210: astore_2
    //   211: new 172	android/content/res/Resources$NotFoundException
    //   214: dup
    //   215: aload_3
    //   216: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 173	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   222: astore_3
    //   223: aload 4
    //   225: astore_2
    //   226: aload_3
    //   227: aload_0
    //   228: invokevirtual 177	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   231: pop
    //   232: aload 4
    //   234: astore_2
    //   235: aload_3
    //   236: athrow
    //   237: aload_2
    //   238: ifnull +9 -> 247
    //   241: aload_2
    //   242: invokeinterface 162 1 0
    //   247: aload_0
    //   248: athrow
    //   249: astore_0
    //   250: goto -13 -> 237
    //   253: astore_0
    //   254: goto -142 -> 112
    //   257: astore_0
    //   258: goto -83 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramContext	Context
    //   0	261	1	paramInt	int
    //   20	222	2	localObject1	Object
    //   15	221	3	localObject2	Object
    //   17	216	4	localObject3	Object
    //   71	33	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   27	35	249	finally
    //   41	49	249	finally
    //   55	63	249	finally
    //   63	73	249	finally
    //   83	98	249	finally
    //   114	123	249	finally
    //   125	133	249	finally
    //   135	145	249	finally
    //   147	161	249	finally
    //   163	170	249	finally
    //   172	175	249	finally
    //   178	186	249	finally
    //   189	196	249	finally
    //   199	208	249	finally
    //   211	223	249	finally
    //   226	232	249	finally
    //   235	237	249	finally
    //   27	35	253	java/io/IOException
    //   41	49	253	java/io/IOException
    //   55	63	253	java/io/IOException
    //   63	73	253	java/io/IOException
    //   83	98	253	java/io/IOException
    //   27	35	257	org/xmlpull/v1/XmlPullParserException
    //   41	49	257	org/xmlpull/v1/XmlPullParserException
    //   55	63	257	org/xmlpull/v1/XmlPullParserException
    //   63	73	257	org/xmlpull/v1/XmlPullParserException
    //   83	98	257	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat
 * JD-Core Version:    0.7.0.1
 */