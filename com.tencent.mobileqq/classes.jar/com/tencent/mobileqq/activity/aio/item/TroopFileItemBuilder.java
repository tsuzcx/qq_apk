package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.filemanager.aioitem.TroopFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.troop.TroopFileProxyActivity;
import java.util.HashMap;

public class TroopFileItemBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, ContextMenuBuilder2
{
  public static LruCache<String, Drawable> a;
  public static HashMap<String, Long> a;
  static int c;
  static int d;
  public static int e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public View.OnClickListener a;
  protected View a;
  private TroopFileBubblePauseHandler a;
  public Handler b;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131296404);
    c = (int)(localDisplayMetrics.widthPixels - DisplayUtils.a(localBaseApplication, 40.0F) * 2.0F - BaseChatItemLayout.t - BaseChatItemLayout.u - i * 2 - DisplayUtils.a(localBaseApplication, 10.0F));
    if (c > 640) {
      c = 640;
    }
    d = c * 9 / 16;
    f = false;
    g = false;
    h = false;
    jdField_e_of_type_Int = 100;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static Drawable a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return new BitmapDrawableWithMargin(BaseApplicationImpl.getApplication().getResources(), null, paramInt2, paramInt3, -921103);
    }
    Object localObject;
    if (paramInt1 == 1) {
      localObject = URLDrawableHelper.getLoadingDrawable();
    }
    for (;;)
    {
      if ((localObject instanceof SkinnableBitmapDrawable))
      {
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
        return new BitmapDrawableWithMargin(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        if (paramInt1 == 2) {
          localObject = URLDrawableHelper.getFailedDrawable();
        }
      }
      else
      {
        if ((localObject instanceof BitmapDrawable))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          return new BitmapDrawableWithMargin(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        }
        return null;
      }
      localObject = null;
    }
  }
  
  /* Error */
  public static Drawable a(Context paramContext, TroopFileStatusInfo paramTroopFileStatusInfo, MessageForTroopFile paramMessageForTroopFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 138	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:d	Ljava/lang/String;
    //   4: astore 8
    //   6: aload_1
    //   7: getfield 140	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:a	Ljava/lang/String;
    //   10: ifnull +80 -> 90
    //   13: aload_1
    //   14: getfield 140	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:a	Ljava/lang/String;
    //   17: astore_2
    //   18: aload_2
    //   19: invokestatic 145	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_0
    //   24: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: astore 10
    //   29: aload 10
    //   31: invokevirtual 54	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   34: getfield 148	android/util/DisplayMetrics:densityDpi	I
    //   37: istore 6
    //   39: ldc 149
    //   41: iload 6
    //   43: i2f
    //   44: ldc 150
    //   46: fdiv
    //   47: fmul
    //   48: fstore_3
    //   49: aload_2
    //   50: ifnull +742 -> 792
    //   53: aload_2
    //   54: invokevirtual 156	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   57: ldc 158
    //   59: invokestatic 164	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   62: ifeq +730 -> 792
    //   65: getstatic 36	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   68: aload 8
    //   70: invokevirtual 168	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 170	android/graphics/drawable/Drawable
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: instanceof 172
    //   85: ifeq +11 -> 96
    //   88: aload_0
    //   89: areturn
    //   90: aload 8
    //   92: astore_2
    //   93: goto -75 -> 18
    //   96: aload_1
    //   97: getfield 140	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:a	Ljava/lang/String;
    //   100: ifnull +692 -> 792
    //   103: new 174	java/io/File
    //   106: dup
    //   107: aload_1
    //   108: getfield 140	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:a	Ljava/lang/String;
    //   111: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore_1
    //   115: aload_1
    //   116: iconst_0
    //   117: invokestatic 183	com/tencent/image/NativeGifImage:getImageSize	(Ljava/io/File;Z)Landroid/graphics/Rect;
    //   120: astore_0
    //   121: aload_0
    //   122: getfield 188	android/graphics/Rect:right	I
    //   125: aload_0
    //   126: getfield 191	android/graphics/Rect:bottom	I
    //   129: invokestatic 194	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(II)[I
    //   132: astore_2
    //   133: aload_0
    //   134: aload_2
    //   135: iconst_0
    //   136: iaload
    //   137: iload 6
    //   139: sipush 160
    //   142: idiv
    //   143: idiv
    //   144: putfield 188	android/graphics/Rect:right	I
    //   147: aload_0
    //   148: aload_2
    //   149: iconst_1
    //   150: iaload
    //   151: iload 6
    //   153: sipush 160
    //   156: idiv
    //   157: idiv
    //   158: putfield 191	android/graphics/Rect:bottom	I
    //   161: aload_1
    //   162: iconst_0
    //   163: iconst_0
    //   164: aload_0
    //   165: invokevirtual 198	android/graphics/Rect:width	()I
    //   168: aload_0
    //   169: invokevirtual 201	android/graphics/Rect:height	()I
    //   172: ldc 149
    //   174: invokestatic 207	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +388 -> 567
    //   182: new 172	com/tencent/image/GifDrawable
    //   185: dup
    //   186: aload_1
    //   187: aload 10
    //   189: invokespecial 210	com/tencent/image/GifDrawable:<init>	(Lcom/tencent/image/AbstractGifImage;Landroid/content/res/Resources;)V
    //   192: astore_0
    //   193: getstatic 36	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   196: aload 8
    //   198: aload_0
    //   199: invokevirtual 214	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   202: pop
    //   203: aload_0
    //   204: areturn
    //   205: astore_0
    //   206: ldc 149
    //   208: fstore_3
    //   209: aload_0
    //   210: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   213: new 174	java/io/File
    //   216: dup
    //   217: aload 8
    //   219: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore_2
    //   223: getstatic 36	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   226: aload 8
    //   228: invokevirtual 168	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 170	android/graphics/drawable/Drawable
    //   234: astore_1
    //   235: aload_1
    //   236: astore_0
    //   237: aload_1
    //   238: ifnonnull -150 -> 88
    //   241: aload_1
    //   242: astore_0
    //   243: aload_2
    //   244: invokevirtual 221	java/io/File:exists	()Z
    //   247: ifeq -159 -> 88
    //   250: new 223	android/graphics/BitmapFactory$Options
    //   253: dup
    //   254: invokespecial 224	android/graphics/BitmapFactory$Options:<init>	()V
    //   257: astore_0
    //   258: aload_0
    //   259: iconst_1
    //   260: putfield 227	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   263: aload_2
    //   264: invokevirtual 230	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   267: aload_0
    //   268: invokestatic 235	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   271: pop
    //   272: aload_0
    //   273: getfield 238	android/graphics/BitmapFactory$Options:outWidth	I
    //   276: istore 5
    //   278: aload_0
    //   279: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   282: istore 4
    //   284: aload_2
    //   285: invokevirtual 230	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   288: invokestatic 245	com/tencent/mobileqq/transfile/URLDrawableHelper:getExifRotation	(Ljava/lang/String;)I
    //   291: istore 7
    //   293: iload 7
    //   295: bipush 90
    //   297: if_icmpeq +11 -> 308
    //   300: iload 7
    //   302: sipush 270
    //   305: if_icmpne +15 -> 320
    //   308: aload_0
    //   309: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   312: istore 5
    //   314: aload_0
    //   315: getfield 238	android/graphics/BitmapFactory$Options:outWidth	I
    //   318: istore 4
    //   320: iload 5
    //   322: iload 4
    //   324: invokestatic 194	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(II)[I
    //   327: astore_0
    //   328: aload_0
    //   329: iconst_0
    //   330: iaload
    //   331: istore 4
    //   333: aload_0
    //   334: iconst_1
    //   335: iaload
    //   336: istore 5
    //   338: new 247	java/io/BufferedInputStream
    //   341: dup
    //   342: new 249	java/io/FileInputStream
    //   345: dup
    //   346: aload_2
    //   347: invokespecial 252	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   350: invokespecial 255	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   353: astore_1
    //   354: aload_1
    //   355: astore_0
    //   356: aload_1
    //   357: invokestatic 261	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   360: astore_2
    //   361: aload_1
    //   362: astore_0
    //   363: aload_2
    //   364: iload 6
    //   366: invokevirtual 266	android/graphics/Bitmap:setDensity	(I)V
    //   369: aload_1
    //   370: astore_0
    //   371: aload_2
    //   372: invokevirtual 269	android/graphics/Bitmap:getWidth	()I
    //   375: iload 4
    //   377: if_icmpne +14 -> 391
    //   380: aload_1
    //   381: astore_0
    //   382: aload_2
    //   383: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
    //   386: iload 5
    //   388: if_icmpeq +401 -> 789
    //   391: aload_1
    //   392: astore_0
    //   393: aload_2
    //   394: invokevirtual 269	android/graphics/Bitmap:getWidth	()I
    //   397: ifeq +392 -> 789
    //   400: aload_1
    //   401: astore_0
    //   402: aload_2
    //   403: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
    //   406: ifeq +383 -> 789
    //   409: aload_1
    //   410: astore_0
    //   411: new 274	android/graphics/Matrix
    //   414: dup
    //   415: invokespecial 275	android/graphics/Matrix:<init>	()V
    //   418: astore 9
    //   420: aload_1
    //   421: astore_0
    //   422: aload 9
    //   424: iload 4
    //   426: i2f
    //   427: aload_2
    //   428: invokevirtual 269	android/graphics/Bitmap:getWidth	()I
    //   431: i2f
    //   432: fdiv
    //   433: iload 5
    //   435: i2f
    //   436: aload_2
    //   437: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
    //   440: i2f
    //   441: fdiv
    //   442: invokevirtual 279	android/graphics/Matrix:setScale	(FF)V
    //   445: aload_1
    //   446: astore_0
    //   447: aload_2
    //   448: iconst_0
    //   449: iconst_0
    //   450: aload_2
    //   451: invokevirtual 269	android/graphics/Bitmap:getWidth	()I
    //   454: aload_2
    //   455: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
    //   458: aload 9
    //   460: iconst_0
    //   461: invokestatic 283	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   464: astore 9
    //   466: aload_1
    //   467: astore_0
    //   468: aload 9
    //   470: iload 6
    //   472: invokevirtual 266	android/graphics/Bitmap:setDensity	(I)V
    //   475: aload_1
    //   476: astore_0
    //   477: aload_2
    //   478: invokevirtual 286	android/graphics/Bitmap:recycle	()V
    //   481: aload 9
    //   483: astore_2
    //   484: aload_1
    //   485: astore_0
    //   486: new 127	android/graphics/drawable/BitmapDrawable
    //   489: dup
    //   490: aload 10
    //   492: aload_2
    //   493: fload_3
    //   494: iload 4
    //   496: iload 5
    //   498: invokestatic 289	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   501: invokespecial 292	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   504: astore 9
    //   506: aload_1
    //   507: astore_0
    //   508: aload_2
    //   509: invokevirtual 286	android/graphics/Bitmap:recycle	()V
    //   512: aload_1
    //   513: astore_0
    //   514: getstatic 36	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   517: aload 8
    //   519: aload 9
    //   521: invokevirtual 214	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: pop
    //   525: aload 9
    //   527: astore_0
    //   528: aload_1
    //   529: ifnull -441 -> 88
    //   532: aload_1
    //   533: invokevirtual 295	java/io/BufferedInputStream:close	()V
    //   536: aload 9
    //   538: areturn
    //   539: astore_1
    //   540: aload_1
    //   541: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   544: aload 9
    //   546: astore_0
    //   547: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq -462 -> 88
    //   553: ldc_w 302
    //   556: iconst_2
    //   557: ldc_w 304
    //   560: aload_1
    //   561: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: aload 9
    //   566: areturn
    //   567: iconst_1
    //   568: aload_0
    //   569: invokevirtual 198	android/graphics/Rect:width	()I
    //   572: aload_0
    //   573: invokevirtual 201	android/graphics/Rect:height	()I
    //   576: invokestatic 309	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   579: astore_0
    //   580: aload_0
    //   581: areturn
    //   582: astore_0
    //   583: aconst_null
    //   584: astore_1
    //   585: iconst_1
    //   586: iload 4
    //   588: iload 5
    //   590: invokestatic 309	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   593: astore_2
    //   594: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +14 -> 611
    //   600: ldc_w 302
    //   603: iconst_2
    //   604: ldc_w 311
    //   607: aload_0
    //   608: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   611: aload_2
    //   612: astore_0
    //   613: aload_1
    //   614: ifnull -526 -> 88
    //   617: aload_1
    //   618: invokevirtual 295	java/io/BufferedInputStream:close	()V
    //   621: aload_2
    //   622: areturn
    //   623: astore_1
    //   624: aload_1
    //   625: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   628: aload_2
    //   629: astore_0
    //   630: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq -545 -> 88
    //   636: ldc_w 302
    //   639: iconst_2
    //   640: ldc_w 304
    //   643: aload_1
    //   644: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   647: aload_2
    //   648: areturn
    //   649: astore_2
    //   650: aconst_null
    //   651: astore_1
    //   652: aload_1
    //   653: astore_0
    //   654: iconst_1
    //   655: iload 4
    //   657: iload 5
    //   659: invokestatic 309	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   662: astore 8
    //   664: aload_1
    //   665: astore_0
    //   666: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +16 -> 685
    //   672: aload_1
    //   673: astore_0
    //   674: ldc_w 302
    //   677: iconst_2
    //   678: ldc_w 313
    //   681: aload_2
    //   682: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   685: aload 8
    //   687: astore_0
    //   688: aload_1
    //   689: ifnull -601 -> 88
    //   692: aload_1
    //   693: invokevirtual 295	java/io/BufferedInputStream:close	()V
    //   696: aload 8
    //   698: areturn
    //   699: astore_1
    //   700: aload_1
    //   701: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   704: aload 8
    //   706: astore_0
    //   707: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq -622 -> 88
    //   713: ldc_w 302
    //   716: iconst_2
    //   717: ldc_w 304
    //   720: aload_1
    //   721: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   724: aload 8
    //   726: areturn
    //   727: astore_1
    //   728: aconst_null
    //   729: astore_0
    //   730: aload_0
    //   731: ifnull +7 -> 738
    //   734: aload_0
    //   735: invokevirtual 295	java/io/BufferedInputStream:close	()V
    //   738: aload_1
    //   739: athrow
    //   740: astore_0
    //   741: aload_0
    //   742: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   745: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq -10 -> 738
    //   751: ldc_w 302
    //   754: iconst_2
    //   755: ldc_w 304
    //   758: aload_0
    //   759: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   762: goto -24 -> 738
    //   765: astore_1
    //   766: goto -36 -> 730
    //   769: astore_2
    //   770: aload_1
    //   771: astore_0
    //   772: aload_2
    //   773: astore_1
    //   774: goto -44 -> 730
    //   777: astore_2
    //   778: goto -126 -> 652
    //   781: astore_0
    //   782: goto -197 -> 585
    //   785: astore_0
    //   786: goto -577 -> 209
    //   789: goto -305 -> 484
    //   792: goto -579 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	795	0	paramContext	Context
    //   0	795	1	paramTroopFileStatusInfo	TroopFileStatusInfo
    //   0	795	2	paramMessageForTroopFile	MessageForTroopFile
    //   48	446	3	f1	float
    //   282	374	4	i	int
    //   276	382	5	j	int
    //   37	434	6	k	int
    //   291	15	7	m	int
    //   4	721	8	localObject1	Object
    //   418	147	9	localObject2	Object
    //   27	464	10	localResources	Resources
    // Exception table:
    //   from	to	target	type
    //   161	178	205	java/lang/Exception
    //   182	203	205	java/lang/Exception
    //   567	580	205	java/lang/Exception
    //   532	536	539	java/lang/Exception
    //   338	354	582	java/lang/OutOfMemoryError
    //   617	621	623	java/lang/Exception
    //   338	354	649	java/lang/Exception
    //   692	696	699	java/lang/Exception
    //   338	354	727	finally
    //   734	738	740	java/lang/Exception
    //   356	361	765	finally
    //   363	369	765	finally
    //   371	380	765	finally
    //   382	391	765	finally
    //   393	400	765	finally
    //   402	409	765	finally
    //   411	420	765	finally
    //   422	445	765	finally
    //   447	466	765	finally
    //   468	475	765	finally
    //   477	481	765	finally
    //   486	506	765	finally
    //   508	512	765	finally
    //   514	525	765	finally
    //   654	664	765	finally
    //   666	672	765	finally
    //   674	685	765	finally
    //   585	611	769	finally
    //   356	361	777	java/lang/Exception
    //   363	369	777	java/lang/Exception
    //   371	380	777	java/lang/Exception
    //   382	391	777	java/lang/Exception
    //   393	400	777	java/lang/Exception
    //   402	409	777	java/lang/Exception
    //   411	420	777	java/lang/Exception
    //   422	445	777	java/lang/Exception
    //   447	466	777	java/lang/Exception
    //   468	475	777	java/lang/Exception
    //   477	481	777	java/lang/Exception
    //   486	506	777	java/lang/Exception
    //   508	512	777	java/lang/Exception
    //   514	525	777	java/lang/Exception
    //   356	361	781	java/lang/OutOfMemoryError
    //   363	369	781	java/lang/OutOfMemoryError
    //   371	380	781	java/lang/OutOfMemoryError
    //   382	391	781	java/lang/OutOfMemoryError
    //   393	400	781	java/lang/OutOfMemoryError
    //   402	409	781	java/lang/OutOfMemoryError
    //   411	420	781	java/lang/OutOfMemoryError
    //   422	445	781	java/lang/OutOfMemoryError
    //   447	466	781	java/lang/OutOfMemoryError
    //   468	475	781	java/lang/OutOfMemoryError
    //   477	481	781	java/lang/OutOfMemoryError
    //   486	506	781	java/lang/OutOfMemoryError
    //   508	512	781	java/lang/OutOfMemoryError
    //   514	525	781	java/lang/OutOfMemoryError
    //   115	161	785	java/lang/Exception
  }
  
  public static int[] a(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if (paramInt1 <= 383)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt2 <= 383) {}
    }
    else
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt1 != 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt2 != 0) {
          if (paramInt1 <= paramInt2) {
            break label105;
          }
        }
      }
    }
    int[] arrayOfInt;
    label105:
    for (float f1 = 383 / paramInt1;; f1 = 383 / paramInt2)
    {
      j = (int)(paramInt1 * f1);
      i = (int)(f1 * paramInt2);
      arrayOfInt = new int[2];
      if ((j != 0) && (i != 0)) {
        break;
      }
      arrayOfInt[0] = c;
      arrayOfInt[1] = (c * 9 / 16);
      return arrayOfInt;
    }
    if ((j < d) || (i < d)) {
      if (j < i)
      {
        f1 = d / j;
        j = d;
        i = (int)(f1 * i + 0.5F);
        paramInt1 = i;
        paramInt2 = j;
        if (i > c)
        {
          paramInt1 = c;
          paramInt2 = j;
        }
      }
    }
    for (;;)
    {
      arrayOfInt[0] = paramInt2;
      arrayOfInt[1] = paramInt1;
      return arrayOfInt;
      paramInt2 = (int)(d / i * j + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > c) {
        paramInt1 = c;
      }
      i = d;
      paramInt2 = paramInt1;
      paramInt1 = i;
      continue;
      if ((j < c) && (i < c))
      {
        paramInt2 = j;
        paramInt1 = i;
      }
      else
      {
        if (j > i)
        {
          f1 = c / j;
          label284:
          if (j <= i) {
            break label402;
          }
        }
        label402:
        for (float f2 = d / i;; f2 = d / j)
        {
          f1 = Math.max(f1, f2);
          paramInt1 = (int)(j * f1 + 0.5F);
          i = (int)(f1 * i + 0.5F);
          paramInt2 = paramInt1;
          if (paramInt1 < d) {
            paramInt2 = d;
          }
          paramInt1 = paramInt2;
          if (paramInt2 > c) {
            paramInt1 = c;
          }
          paramInt2 = i;
          if (i < d) {
            paramInt2 = d;
          }
          if (paramInt2 <= c) {
            break label414;
          }
          i = c;
          paramInt2 = paramInt1;
          paramInt1 = i;
          break;
          f1 = c / i;
          break label284;
        }
        label414:
        i = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
    }
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    return FileManagerUtil.a(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    return ((paramChatMessage.width == 0) || (paramChatMessage.height != 0)) || (FileManagerUtil.a(paramChatMessage.fileName) == 2);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    boolean bool1 = b(paramChatMessage);
    boolean bool2 = c(paramChatMessage);
    if (bool1) {}
    while (bool2) {
      return paramView;
    }
    paramView = a(paramView, paramChatMessage);
    paramViewGroup = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemTroopFileBubblePauseHandler.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    TroopFileItemBuilder.Holder localHolder = (TroopFileItemBuilder.Holder)paramViewGroup.getTag();
    if (localHolder.jdField_c_of_type_AndroidViewView != null) {
      localHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (localHolder.jdField_d_of_type_AndroidViewView != null) {
      localHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (localHolder.jdField_a_of_type_AndroidViewView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localHolder.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = BaseChatItemLayout.z;
      localLayoutParams.height = -2;
      localHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      a(localHolder, paramViewGroup, paramChatMessage);
      if (jdField_e_of_type_Boolean) {}
      try
      {
        localHolder.jdField_b_of_type_JavaLangStringBuilder.append(localHolder.jdField_a_of_type_AndroidWidgetTextView.getText()).append(" ");
        localHolder.jdField_b_of_type_JavaLangStringBuilder.append(localHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
        localHolder.jdField_b_of_type_JavaLangStringBuilder.append(localHolder.jdField_c_of_type_AndroidWidgetTextView.getText());
        localHolder.jdField_b_of_type_JavaLangStringBuilder.append("按钮");
        paramViewGroup.setContentDescription(localHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
        return paramViewGroup;
      }
      catch (Exception paramChatMessage) {}
      QLog.w("TroopFileItemBuilder", 1, "set LayoutParams, but holder.mContent is null!");
    }
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (TroopFileItemBuilder.Holder)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    }
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopFileItemBuilder.Holder(this);
  }
  
  protected MessageForTroopFile a(View paramView)
  {
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if (paramView.a.isMultiMsg) {
      return (MessageForTroopFile)FileManagerUtil.a(paramView.a);
    }
    return (MessageForTroopFile)paramView.a;
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return paramQQCustomMenu;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131715174);
    }
    return HardCodeUtil.a(2131715178);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(View paramView)
  {
    super.a(paramView);
    a((View)paramView.getParent(), true);
  }
  
  void a(View paramView, boolean paramBoolean)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    paramView = a(paramView);
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramView;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, paramView.frienduin + "", "", "", "");
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo.b == 12) {
      TroopFileError.a(localActivity, String.format(localActivity.getString(2131697311), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.g) }), 1);
    }
    do
    {
      return;
      switch (localTroopFileStatusInfo.b)
      {
      case 4: 
      case 5: 
      default: 
        return;
      }
    } while (!paramBoolean);
    localIntent.putExtra(TroopFileProxyActivity.a, paramView.frienduin);
    TroopFileProxyActivity.b(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return;
    localIntent.putExtra(TroopFileProxyActivity.a, paramView.frienduin);
    TroopFileProxyActivity.b(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return;
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).longValue();
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, l, localTroopFileStatusInfo, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  public void a(TroopFileItemBuilder.Holder paramHolder, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    if (paramHolder.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130842802);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167374));
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(2131697202);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364634);
      this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296404);
      DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramViewGroup.addView(paramHolder.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramChatMessage.isSend())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      paramViewGroup.addRule(7, 2131364634);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296404) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    paramViewGroup.addRule(5, 2131364634);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296404) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    boolean bool1 = b(paramChatMessage);
    boolean bool2 = c(paramChatMessage);
    if ((!bool1) && (!bool2) && (paramViewHolder.jdField_a_of_type_AndroidViewView != null))
    {
      if (paramChatMessage.isSend()) {
        paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850414);
      }
    }
    else {
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850238);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = a(paramView);
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label43;
      }
      a(localQQCustomMenu, paramView, null);
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      label43:
      b(localQQCustomMenu, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return paramQQCustomMenu;
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = AIOUtils.a(paramView);
      if (localObject == null)
      {
        QLog.w("TroopFileItemBuilder", 1, "item click holder tag is null");
      }
      else if (!TroopFileItemBuilder.Holder.class.isInstance(localObject))
      {
        QLog.e("TroopFileItemBuilder", 1, "item click holder tag class[" + localObject.getClass().getName() + "] is not Holder");
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", 0, 0, "4", "", "", "");
        localObject = (TroopFileItemBuilder.Holder)localObject;
        localObject = a(paramView);
        if ((!b((ChatMessage)localObject)) && (!c((ChatMessage)localObject)) && ((!((MessageForTroopFile)localObject).isMultiMsg) || (FileManagerUtil.a((ChatMessage)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))))
        {
          a(paramView, false);
          AIOUtils.o = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */