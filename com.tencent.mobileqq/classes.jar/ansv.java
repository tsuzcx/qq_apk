import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;

public class ansv
{
  public static final Set<String> a;
  public static final String[] a;
  public static final String[] b;
  public static final String[] c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "tvImage.png", "tvMast.png", "tvDecorate.png", "tvScreen.png", "snow1.png", "snow2.png", "snow3.png", "snow4.png", "snow5.png" };
    b = new String[] { "aio_back_video.mp4", "BgVideoLoopPara.json" };
    c = new String[] { "tvImage.png", "tvMast.png", "tvDecorate.png", "tvScreen.png", "snow1.png", "snow2.png", "snow3.png", "snow4.png", "snow5.png", "coverVertical.png", "coverVerticalSmall.png", "coverHorizontal.png" };
    jdField_a_of_type_JavaUtilSet = new HashSet(1);
    jdField_a_of_type_JavaUtilSet.add("matchAndAIOPageForNewVersion");
  }
  
  /* Error */
  public static AnimationDrawable a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 70	android/graphics/drawable/AnimationDrawable
    //   9: dup
    //   10: invokespecial 72	android/graphics/drawable/AnimationDrawable:<init>	()V
    //   13: astore_0
    //   14: iconst_0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore_2
    //   18: iload_3
    //   19: istore_1
    //   20: ldc 24
    //   22: invokestatic 75	ansv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 81	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +15 -> 47
    //   35: iload_3
    //   36: istore_1
    //   37: aload_0
    //   38: aload 4
    //   40: bipush 50
    //   42: invokevirtual 85	android/graphics/drawable/AnimationDrawable:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   45: iconst_1
    //   46: istore_2
    //   47: iload_2
    //   48: istore_1
    //   49: ldc 26
    //   51: invokestatic 75	ansv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokestatic 81	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   57: astore 4
    //   59: iload_2
    //   60: istore_3
    //   61: aload 4
    //   63: ifnull +17 -> 80
    //   66: iload_2
    //   67: istore_1
    //   68: aload_0
    //   69: aload 4
    //   71: bipush 50
    //   73: invokevirtual 85	android/graphics/drawable/AnimationDrawable:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   76: iload_2
    //   77: iconst_1
    //   78: iadd
    //   79: istore_3
    //   80: iload_3
    //   81: istore_1
    //   82: ldc 28
    //   84: invokestatic 75	ansv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   87: invokestatic 81	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   90: astore 4
    //   92: iload_3
    //   93: istore_2
    //   94: aload 4
    //   96: ifnull +17 -> 113
    //   99: iload_3
    //   100: istore_1
    //   101: aload_0
    //   102: aload 4
    //   104: bipush 50
    //   106: invokevirtual 85	android/graphics/drawable/AnimationDrawable:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   109: iload_3
    //   110: iconst_1
    //   111: iadd
    //   112: istore_2
    //   113: iload_2
    //   114: istore_1
    //   115: ldc 30
    //   117: invokestatic 75	ansv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokestatic 81	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   123: astore 4
    //   125: aload 4
    //   127: ifnull +97 -> 224
    //   130: iload_2
    //   131: istore_1
    //   132: aload_0
    //   133: aload 4
    //   135: bipush 50
    //   137: invokevirtual 85	android/graphics/drawable/AnimationDrawable:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   140: iload_2
    //   141: iconst_1
    //   142: iadd
    //   143: istore_1
    //   144: ldc 32
    //   146: invokestatic 75	ansv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokestatic 81	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   152: astore 4
    //   154: iload_1
    //   155: istore_2
    //   156: aload 4
    //   158: ifnull +15 -> 173
    //   161: aload_0
    //   162: aload 4
    //   164: bipush 50
    //   166: invokevirtual 85	android/graphics/drawable/AnimationDrawable:addFrame	(Landroid/graphics/drawable/Drawable;I)V
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_2
    //   173: iload_2
    //   174: istore_1
    //   175: iload_1
    //   176: ifne +5 -> 181
    //   179: aconst_null
    //   180: astore_0
    //   181: aload_0
    //   182: areturn
    //   183: astore_0
    //   184: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +28 -> 215
    //   190: ldc 93
    //   192: iconst_2
    //   193: new 95	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   200: ldc 98
    //   202: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aconst_null
    //   216: astore_0
    //   217: goto -42 -> 175
    //   220: astore_0
    //   221: goto -37 -> 184
    //   224: iload_2
    //   225: istore_1
    //   226: goto -82 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramContext	android.content.Context
    //   19	207	1	i	int
    //   17	208	2	j	int
    //   15	97	3	k	int
    //   28	135	4	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   20	30	183	java/lang/OutOfMemoryError
    //   37	45	183	java/lang/OutOfMemoryError
    //   49	59	183	java/lang/OutOfMemoryError
    //   68	76	183	java/lang/OutOfMemoryError
    //   82	92	183	java/lang/OutOfMemoryError
    //   101	109	183	java/lang/OutOfMemoryError
    //   115	125	183	java/lang/OutOfMemoryError
    //   132	140	183	java/lang/OutOfMemoryError
    //   144	154	220	java/lang/OutOfMemoryError
    //   161	169	220	java/lang/OutOfMemoryError
  }
  
  public static String a()
  {
    return "matchAndAIOPageForNewVersion";
  }
  
  public static String a(int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "coverVertical.png";
    }
    for (;;)
    {
      return a(str);
      if (paramInt == 2) {
        str = "coverVerticalSmall.png";
      } else {
        str = "coverHorizontal.png";
      }
    }
  }
  
  public static String a(String paramString)
  {
    return String.format("%s/%s", new Object[] { c(), paramString });
  }
  
  public static void a()
  {
    a(c);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "delBgPicFiles ");
    }
  }
  
  public static void a(AnimationDrawable paramAnimationDrawable)
  {
    if (paramAnimationDrawable != null)
    {
      paramAnimationDrawable.stop();
      int i = 0;
      while (i < paramAnimationDrawable.getNumberOfFrames())
      {
        Drawable localDrawable = paramAnimationDrawable.getFrame(i);
        if ((localDrawable instanceof BitmapDrawable)) {
          ((BitmapDrawable)localDrawable).getBitmap().recycle();
        }
        localDrawable.setCallback(null);
        i += 1;
      }
      paramAnimationDrawable.setCallback(null);
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    try
    {
      localObject = a(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("ExtendFriendResourceDownloaderLimitChat", 2, "getLimitChatResourceFilePath empty" + paramString);
        return;
      }
      localObject = Drawable.createFromPath((String)localObject);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Drawable localDrawable;
      for (;;)
      {
        Object localObject;
        if (QLog.isColorLevel()) {
          QLog.e("ExtendFriendResourceDownloaderLimitChat", 2, "onCreateView create bgDrawable fail " + localOutOfMemoryError + " " + paramString);
        }
        localDrawable = null;
      }
      paramView.setBackgroundDrawable(localDrawable);
      return;
    }
    if (localObject != null) {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramView.setBackground((Drawable)localObject);
        return;
      }
    }
    QLog.e("ExtendFriendResourceDownloaderLimitChat", 2, "onCreateView create bgDrawable fail " + paramString);
  }
  
  public static void a(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    baig.t(BaseApplicationImpl.getApplication().getBaseContext(), str, paramString);
    if (QLog.isColorLevel())
    {
      if (paramString != null) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "setBgPicResMd5 " + paramString);
      }
    }
    else {
      return;
    }
    QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "setBgPicResMd5 null");
  }
  
  private static void a(String[] paramArrayOfString)
  {
    paramArrayOfString = a(paramArrayOfString);
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(paramArrayOfString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public static boolean a()
  {
    return a(c);
  }
  
  public static boolean a(anoh paramanoh)
  {
    boolean bool = false;
    if ((paramanoh != null) && (paramanoh.a != null))
    {
      String str = a();
      paramanoh = (anoi)paramanoh.a.get(str);
      if (paramanoh != null)
      {
        paramanoh = paramanoh.c;
        str = b();
        if (TextUtils.isEmpty(str))
        {
          bool = true;
          if ((!TextUtils.isEmpty(paramanoh)) && (!paramanoh.equalsIgnoreCase(str))) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if ((bool) && (paramanoh != null)) {
        a(paramanoh);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "checkBgPicMd5 " + bool);
      }
      return bool;
      continue;
      bool = false;
      break;
      paramanoh = null;
    }
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    return antz.a(a(paramArrayOfString));
  }
  
  public static String[] a(String[] paramArrayOfString)
  {
    Object localObject = null;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      String[] arrayOfString = new String[j];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfString;
        if (i >= j) {
          break;
        }
        arrayOfString[i] = a(paramArrayOfString[i]);
        i += 1;
      }
    }
    return localObject;
  }
  
  public static String b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = baig.s(BaseApplicationImpl.getApplication().getBaseContext(), str);
    if (QLog.isColorLevel())
    {
      if (str != null) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "getBgPicResMd5 " + str);
      }
    }
    else {
      return str;
    }
    QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "getBgPicResMd5 null");
    return str;
  }
  
  public static String c()
  {
    return String.format("%s/matchChat", new Object[] { anok.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ansv
 * JD-Core Version:    0.7.0.1
 */