package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ContextThemeWrapper;

public final class DrawableDecoderCompat
{
  private static volatile boolean a = true;
  
  public static Drawable a(Context paramContext, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    return a(paramContext, paramContext, paramInt, paramTheme);
  }
  
  public static Drawable a(Context paramContext1, Context paramContext2, @DrawableRes int paramInt)
  {
    return a(paramContext1, paramContext2, paramInt, null);
  }
  
  /* Error */
  private static Drawable a(Context paramContext1, Context paramContext2, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: getstatic 29	com/bumptech/glide/load/resource/drawable/DrawableDecoderCompat:a	Z
    //   3: ifeq +44 -> 47
    //   6: aload_1
    //   7: iload_2
    //   8: aload_3
    //   9: invokestatic 32	com/bumptech/glide/load/resource/drawable/DrawableDecoderCompat:b	(Landroid/content/Context;ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;
    //   12: astore 4
    //   14: aload 4
    //   16: areturn
    //   17: goto +30 -> 47
    //   20: astore_3
    //   21: aload_0
    //   22: invokevirtual 38	android/content/Context:getPackageName	()Ljava/lang/String;
    //   25: aload_1
    //   26: invokevirtual 38	android/content/Context:getPackageName	()Ljava/lang/String;
    //   29: invokevirtual 44	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +9 -> 41
    //   35: aload_1
    //   36: iload_2
    //   37: invokestatic 50	android/support/v4/content/ContextCompat:getDrawable	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   40: areturn
    //   41: aload_3
    //   42: athrow
    //   43: iconst_0
    //   44: putstatic 29	com/bumptech/glide/load/resource/drawable/DrawableDecoderCompat:a	Z
    //   47: aload_3
    //   48: ifnull +6 -> 54
    //   51: goto +8 -> 59
    //   54: aload_1
    //   55: invokevirtual 54	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   58: astore_3
    //   59: aload_1
    //   60: iload_2
    //   61: aload_3
    //   62: invokestatic 57	com/bumptech/glide/load/resource/drawable/DrawableDecoderCompat:c	(Landroid/content/Context;ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;
    //   65: areturn
    //   66: astore_0
    //   67: goto -24 -> 43
    //   70: astore_0
    //   71: goto -54 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramContext1	Context
    //   0	74	1	paramContext2	Context
    //   0	74	2	paramInt	int
    //   0	74	3	paramTheme	Resources.Theme
    //   12	3	4	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   0	14	20	java/lang/IllegalStateException
    //   0	14	66	java/lang/NoClassDefFoundError
    //   0	14	70	android/content/res/Resources$NotFoundException
  }
  
  private static Drawable b(Context paramContext, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    Object localObject = paramContext;
    if (paramTheme != null) {
      localObject = new ContextThemeWrapper(paramContext, paramTheme);
    }
    return AppCompatResources.getDrawable((Context)localObject, paramInt);
  }
  
  private static Drawable c(Context paramContext, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    return ResourcesCompat.getDrawable(paramContext.getResources(), paramInt, paramTheme);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat
 * JD-Core Version:    0.7.0.1
 */