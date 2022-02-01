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
import mqq.app.AppRuntime;

public class TroopFileItemBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, ContextMenuBuilder2
{
  static int jdField_a_of_type_Int;
  public static LruCache<String, Drawable> a;
  public static HashMap<String, Long> a;
  static int d;
  public static int e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public View.OnClickListener a;
  protected View a;
  private TroopFileBubblePauseHandler jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemTroopFileBubblePauseHandler;
  public Handler b;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131296383);
    jdField_a_of_type_Int = (int)(localDisplayMetrics.widthPixels - DisplayUtils.a(localBaseApplication, 40.0F) * 2.0F - BaseChatItemLayout.t - BaseChatItemLayout.u - i * 2 - DisplayUtils.a(localBaseApplication, 10.0F));
    if (jdField_a_of_type_Int > 640) {
      jdField_a_of_type_Int = 640;
    }
    d = jdField_a_of_type_Int * 9 / 16;
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
    } else if (paramInt1 == 2) {
      localObject = URLDrawableHelper.getFailedDrawable();
    } else {
      localObject = null;
    }
    if ((localObject instanceof SkinnableBitmapDrawable))
    {
      localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
      return new BitmapDrawableWithMargin(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
    }
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      return new BitmapDrawableWithMargin(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
    }
    return null;
  }
  
  /* Error */
  public static Drawable a(Context paramContext, TroopFileStatusInfo paramTroopFileStatusInfo, MessageForTroopFile paramMessageForTroopFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 137	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:d	Ljava/lang/String;
    //   4: astore 9
    //   6: aload_1
    //   7: getfield 139	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:a	Ljava/lang/String;
    //   10: ifnull +11 -> 21
    //   13: aload_1
    //   14: getfield 139	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:a	Ljava/lang/String;
    //   17: astore_2
    //   18: goto +6 -> 24
    //   21: aload 9
    //   23: astore_2
    //   24: aload_2
    //   25: invokestatic 144	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_2
    //   29: aload_0
    //   30: invokevirtual 47	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   33: astore 11
    //   35: aload 11
    //   37: invokevirtual 53	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   40: getfield 147	android/util/DisplayMetrics:densityDpi	I
    //   43: istore 7
    //   45: iload 7
    //   47: i2f
    //   48: ldc 148
    //   50: fdiv
    //   51: ldc 149
    //   53: fmul
    //   54: fstore_3
    //   55: fload_3
    //   56: fstore 4
    //   58: aload_2
    //   59: ifnull +185 -> 244
    //   62: fload_3
    //   63: fstore 4
    //   65: aload_2
    //   66: invokevirtual 155	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   69: ldc 157
    //   71: invokestatic 163	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   74: ifeq +170 -> 244
    //   77: getstatic 35	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   80: aload 9
    //   82: invokevirtual 167	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: checkcast 169	android/graphics/drawable/Drawable
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +12 -> 102
    //   93: aload_0
    //   94: instanceof 171
    //   97: ifeq +5 -> 102
    //   100: aload_0
    //   101: areturn
    //   102: fload_3
    //   103: fstore 4
    //   105: aload_1
    //   106: getfield 139	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:a	Ljava/lang/String;
    //   109: ifnull +135 -> 244
    //   112: new 173	java/io/File
    //   115: dup
    //   116: aload_1
    //   117: getfield 139	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:a	Ljava/lang/String;
    //   120: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore_1
    //   124: aload_1
    //   125: iconst_0
    //   126: invokestatic 182	com/tencent/image/NativeGifImage:getImageSize	(Ljava/io/File;Z)Landroid/graphics/Rect;
    //   129: astore_0
    //   130: aload_0
    //   131: getfield 187	android/graphics/Rect:right	I
    //   134: aload_0
    //   135: getfield 190	android/graphics/Rect:bottom	I
    //   138: invokestatic 193	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(II)[I
    //   141: astore_2
    //   142: aload_0
    //   143: aload_2
    //   144: iconst_0
    //   145: iaload
    //   146: iload 7
    //   148: sipush 160
    //   151: idiv
    //   152: idiv
    //   153: putfield 187	android/graphics/Rect:right	I
    //   156: aload_0
    //   157: aload_2
    //   158: iconst_1
    //   159: iaload
    //   160: iload 7
    //   162: sipush 160
    //   165: idiv
    //   166: idiv
    //   167: putfield 190	android/graphics/Rect:bottom	I
    //   170: aload_1
    //   171: iconst_0
    //   172: iconst_0
    //   173: aload_0
    //   174: invokevirtual 197	android/graphics/Rect:width	()I
    //   177: aload_0
    //   178: invokevirtual 200	android/graphics/Rect:height	()I
    //   181: ldc 149
    //   183: invokestatic 206	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +26 -> 214
    //   191: new 171	com/tencent/image/GifDrawable
    //   194: dup
    //   195: aload_1
    //   196: aload 11
    //   198: invokespecial 209	com/tencent/image/GifDrawable:<init>	(Lcom/tencent/image/AbstractGifImage;Landroid/content/res/Resources;)V
    //   201: astore_0
    //   202: getstatic 35	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   205: aload 9
    //   207: aload_0
    //   208: invokevirtual 213	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: pop
    //   212: aload_0
    //   213: areturn
    //   214: iconst_1
    //   215: aload_0
    //   216: invokevirtual 197	android/graphics/Rect:width	()I
    //   219: aload_0
    //   220: invokevirtual 200	android/graphics/Rect:height	()I
    //   223: invokestatic 215	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   226: astore_0
    //   227: aload_0
    //   228: areturn
    //   229: astore_0
    //   230: ldc 149
    //   232: fstore_3
    //   233: goto +4 -> 237
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   241: fload_3
    //   242: fstore 4
    //   244: new 173	java/io/File
    //   247: dup
    //   248: aload 9
    //   250: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   253: astore 12
    //   255: getstatic 35	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   258: aload 9
    //   260: invokevirtual 167	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: checkcast 169	android/graphics/drawable/Drawable
    //   266: astore_1
    //   267: aload_1
    //   268: astore_0
    //   269: aload_1
    //   270: ifnonnull +498 -> 768
    //   273: aload_1
    //   274: astore_0
    //   275: aload 12
    //   277: invokevirtual 222	java/io/File:exists	()Z
    //   280: ifeq +488 -> 768
    //   283: new 224	android/graphics/BitmapFactory$Options
    //   286: dup
    //   287: invokespecial 225	android/graphics/BitmapFactory$Options:<init>	()V
    //   290: astore_0
    //   291: aload_0
    //   292: iconst_1
    //   293: putfield 228	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   296: aload 12
    //   298: invokevirtual 231	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   301: aload_0
    //   302: invokestatic 236	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   305: pop
    //   306: aload_0
    //   307: getfield 239	android/graphics/BitmapFactory$Options:outWidth	I
    //   310: istore 5
    //   312: aload_0
    //   313: getfield 242	android/graphics/BitmapFactory$Options:outHeight	I
    //   316: istore 6
    //   318: aload 12
    //   320: invokevirtual 231	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   323: invokestatic 246	com/tencent/mobileqq/transfile/URLDrawableHelper:getExifRotation	(Ljava/lang/String;)I
    //   326: istore 8
    //   328: iload 8
    //   330: bipush 90
    //   332: if_icmpeq +11 -> 343
    //   335: iload 8
    //   337: sipush 270
    //   340: if_icmpne +15 -> 355
    //   343: aload_0
    //   344: getfield 242	android/graphics/BitmapFactory$Options:outHeight	I
    //   347: istore 5
    //   349: aload_0
    //   350: getfield 239	android/graphics/BitmapFactory$Options:outWidth	I
    //   353: istore 6
    //   355: iload 5
    //   357: iload 6
    //   359: invokestatic 193	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(II)[I
    //   362: astore_0
    //   363: aload_0
    //   364: iconst_0
    //   365: iaload
    //   366: istore 5
    //   368: aload_0
    //   369: iconst_1
    //   370: iaload
    //   371: istore 6
    //   373: aconst_null
    //   374: astore_2
    //   375: aconst_null
    //   376: astore 10
    //   378: aconst_null
    //   379: astore_0
    //   380: new 248	java/io/BufferedInputStream
    //   383: dup
    //   384: new 250	java/io/FileInputStream
    //   387: dup
    //   388: aload 12
    //   390: invokespecial 253	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   393: invokespecial 256	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   396: astore_1
    //   397: aload_1
    //   398: invokestatic 262	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   401: astore_2
    //   402: aload_2
    //   403: iload 7
    //   405: invokevirtual 267	android/graphics/Bitmap:setDensity	(I)V
    //   408: aload_2
    //   409: invokevirtual 270	android/graphics/Bitmap:getWidth	()I
    //   412: iload 5
    //   414: if_icmpne +14 -> 428
    //   417: aload_2
    //   418: astore_0
    //   419: aload_2
    //   420: invokevirtual 273	android/graphics/Bitmap:getHeight	()I
    //   423: iload 6
    //   425: if_icmpeq +78 -> 503
    //   428: aload_2
    //   429: astore_0
    //   430: aload_2
    //   431: invokevirtual 270	android/graphics/Bitmap:getWidth	()I
    //   434: ifeq +69 -> 503
    //   437: aload_2
    //   438: astore_0
    //   439: aload_2
    //   440: invokevirtual 273	android/graphics/Bitmap:getHeight	()I
    //   443: ifeq +60 -> 503
    //   446: new 275	android/graphics/Matrix
    //   449: dup
    //   450: invokespecial 276	android/graphics/Matrix:<init>	()V
    //   453: astore_0
    //   454: aload_0
    //   455: iload 5
    //   457: i2f
    //   458: aload_2
    //   459: invokevirtual 270	android/graphics/Bitmap:getWidth	()I
    //   462: i2f
    //   463: fdiv
    //   464: iload 6
    //   466: i2f
    //   467: aload_2
    //   468: invokevirtual 273	android/graphics/Bitmap:getHeight	()I
    //   471: i2f
    //   472: fdiv
    //   473: invokevirtual 280	android/graphics/Matrix:setScale	(FF)V
    //   476: aload_2
    //   477: iconst_0
    //   478: iconst_0
    //   479: aload_2
    //   480: invokevirtual 270	android/graphics/Bitmap:getWidth	()I
    //   483: aload_2
    //   484: invokevirtual 273	android/graphics/Bitmap:getHeight	()I
    //   487: aload_0
    //   488: iconst_0
    //   489: invokestatic 284	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   492: astore_0
    //   493: aload_0
    //   494: iload 7
    //   496: invokevirtual 267	android/graphics/Bitmap:setDensity	(I)V
    //   499: aload_2
    //   500: invokevirtual 287	android/graphics/Bitmap:recycle	()V
    //   503: new 126	android/graphics/drawable/BitmapDrawable
    //   506: dup
    //   507: aload 11
    //   509: aload_0
    //   510: fload 4
    //   512: iload 5
    //   514: iload 6
    //   516: invokestatic 290	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   519: invokespecial 293	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   522: astore_2
    //   523: aload_0
    //   524: invokevirtual 287	android/graphics/Bitmap:recycle	()V
    //   527: getstatic 35	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   530: aload 9
    //   532: aload_2
    //   533: invokevirtual 213	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: aload_1
    //   538: invokevirtual 296	java/io/BufferedInputStream:close	()V
    //   541: goto +25 -> 566
    //   544: astore_0
    //   545: aload_0
    //   546: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   549: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq +14 -> 566
    //   555: ldc_w 303
    //   558: iconst_2
    //   559: ldc_w 305
    //   562: aload_0
    //   563: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   566: aload_2
    //   567: areturn
    //   568: astore_0
    //   569: goto +164 -> 733
    //   572: astore 9
    //   574: goto +22 -> 596
    //   577: astore 9
    //   579: goto +93 -> 672
    //   582: astore_1
    //   583: aload_0
    //   584: astore_2
    //   585: aload_1
    //   586: astore_0
    //   587: aload_2
    //   588: astore_1
    //   589: goto +144 -> 733
    //   592: astore 9
    //   594: aload_2
    //   595: astore_1
    //   596: aload_1
    //   597: astore_0
    //   598: iconst_1
    //   599: iload 5
    //   601: iload 6
    //   603: invokestatic 215	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   606: astore_2
    //   607: aload_1
    //   608: astore_0
    //   609: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   612: ifeq +17 -> 629
    //   615: aload_1
    //   616: astore_0
    //   617: ldc_w 303
    //   620: iconst_2
    //   621: ldc_w 310
    //   624: aload 9
    //   626: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   629: aload_2
    //   630: astore_0
    //   631: aload_1
    //   632: ifnull +136 -> 768
    //   635: aload_1
    //   636: invokevirtual 296	java/io/BufferedInputStream:close	()V
    //   639: aload_2
    //   640: areturn
    //   641: astore_1
    //   642: aload_1
    //   643: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   646: aload_2
    //   647: astore_0
    //   648: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   651: ifeq +117 -> 768
    //   654: ldc_w 303
    //   657: iconst_2
    //   658: ldc_w 305
    //   661: aload_1
    //   662: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   665: aload_2
    //   666: areturn
    //   667: astore 9
    //   669: aload 10
    //   671: astore_1
    //   672: aload_1
    //   673: astore_0
    //   674: iconst_1
    //   675: iload 5
    //   677: iload 6
    //   679: invokestatic 215	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   682: astore_2
    //   683: aload_1
    //   684: astore_0
    //   685: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +17 -> 705
    //   691: aload_1
    //   692: astore_0
    //   693: ldc_w 303
    //   696: iconst_2
    //   697: ldc_w 312
    //   700: aload 9
    //   702: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   705: aload_2
    //   706: astore_0
    //   707: aload_1
    //   708: ifnull +60 -> 768
    //   711: aload_1
    //   712: invokevirtual 296	java/io/BufferedInputStream:close	()V
    //   715: aload_2
    //   716: areturn
    //   717: astore_1
    //   718: aload_1
    //   719: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   722: aload_2
    //   723: astore_0
    //   724: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   727: ifeq +41 -> 768
    //   730: goto -76 -> 654
    //   733: aload_1
    //   734: ifnull +32 -> 766
    //   737: aload_1
    //   738: invokevirtual 296	java/io/BufferedInputStream:close	()V
    //   741: goto +25 -> 766
    //   744: astore_1
    //   745: aload_1
    //   746: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   749: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +14 -> 766
    //   755: ldc_w 303
    //   758: iconst_2
    //   759: ldc_w 305
    //   762: aload_1
    //   763: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   766: aload_0
    //   767: athrow
    //   768: aload_0
    //   769: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	paramContext	Context
    //   0	770	1	paramTroopFileStatusInfo	TroopFileStatusInfo
    //   0	770	2	paramMessageForTroopFile	MessageForTroopFile
    //   54	188	3	f1	float
    //   56	455	4	f2	float
    //   310	366	5	i	int
    //   316	362	6	j	int
    //   43	452	7	k	int
    //   326	15	8	m	int
    //   4	527	9	str	String
    //   572	1	9	localException1	Exception
    //   577	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   592	33	9	localException2	Exception
    //   667	34	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   376	294	10	localObject	Object
    //   33	475	11	localResources	Resources
    //   253	136	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   170	187	229	java/lang/Exception
    //   191	212	229	java/lang/Exception
    //   214	227	229	java/lang/Exception
    //   124	170	236	java/lang/Exception
    //   537	541	544	java/lang/Exception
    //   397	417	568	finally
    //   419	428	568	finally
    //   430	437	568	finally
    //   439	503	568	finally
    //   503	537	568	finally
    //   397	417	572	java/lang/Exception
    //   419	428	572	java/lang/Exception
    //   430	437	572	java/lang/Exception
    //   439	503	572	java/lang/Exception
    //   503	537	572	java/lang/Exception
    //   397	417	577	java/lang/OutOfMemoryError
    //   419	428	577	java/lang/OutOfMemoryError
    //   430	437	577	java/lang/OutOfMemoryError
    //   439	503	577	java/lang/OutOfMemoryError
    //   503	537	577	java/lang/OutOfMemoryError
    //   380	397	582	finally
    //   598	607	582	finally
    //   609	615	582	finally
    //   617	629	582	finally
    //   674	683	582	finally
    //   685	691	582	finally
    //   693	705	582	finally
    //   380	397	592	java/lang/Exception
    //   635	639	641	java/lang/Exception
    //   380	397	667	java/lang/OutOfMemoryError
    //   711	715	717	java/lang/Exception
    //   737	741	744	java/lang/Exception
  }
  
  public static int[] a(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    float f1;
    float f2;
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
        if (paramInt2 != 0)
        {
          if (paramInt1 > paramInt2)
          {
            f1 = 383;
            f2 = paramInt1;
          }
          else
          {
            f1 = 383;
            f2 = paramInt2;
          }
          f1 /= f2;
          j = (int)(paramInt1 * f1);
          i = (int)(paramInt2 * f1);
        }
      }
    }
    int[] arrayOfInt = new int[2];
    if ((j != 0) && (i != 0))
    {
      paramInt1 = d;
      if ((j >= paramInt1) && (i >= paramInt1))
      {
        paramInt1 = jdField_a_of_type_Int;
        if ((j < paramInt1) && (i < paramInt1))
        {
          paramInt2 = j;
          paramInt1 = i;
        }
        else
        {
          if (j > i)
          {
            f1 = jdField_a_of_type_Int;
            f2 = j;
          }
          else
          {
            f1 = jdField_a_of_type_Int;
            f2 = i;
          }
          float f3 = f1 / f2;
          if (j > i)
          {
            f1 = d;
            f2 = i;
          }
          else
          {
            f1 = d;
            f2 = j;
          }
          f1 = Math.max(f3, f1 / f2);
          j = (int)(j * f1 + 0.5F);
          paramInt2 = (int)(i * f1 + 0.5F);
          i = d;
          paramInt1 = j;
          if (j < i) {
            paramInt1 = i;
          }
          j = jdField_a_of_type_Int;
          i = paramInt1;
          if (paramInt1 > j) {
            i = j;
          }
          paramInt1 = d;
          j = paramInt2;
          if (paramInt2 < paramInt1) {
            j = paramInt1;
          }
          int k = jdField_a_of_type_Int;
          paramInt2 = i;
          paramInt1 = j;
          if (j > k)
          {
            paramInt1 = k;
            paramInt2 = i;
          }
        }
      }
      else if (j < i)
      {
        paramInt2 = d;
        f1 = paramInt2 / j;
        i = (int)(i * f1 + 0.5F);
        j = jdField_a_of_type_Int;
        paramInt1 = i;
        if (i > j) {
          paramInt1 = j;
        }
      }
      else
      {
        f1 = d / i;
        paramInt1 = (int)(j * f1 + 0.5F);
        i = jdField_a_of_type_Int;
        paramInt2 = paramInt1;
        if (paramInt1 > i) {
          paramInt2 = i;
        }
        paramInt1 = d;
      }
      arrayOfInt[0] = paramInt2;
      arrayOfInt[1] = paramInt1;
      return arrayOfInt;
    }
    paramInt1 = jdField_a_of_type_Int;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = (paramInt1 * 9 / 16);
    return arrayOfInt;
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    return FileManagerUtil.a(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    if (paramChatMessage.width != 0) {
      int i = paramChatMessage.height;
    }
    return FileManagerUtil.a(paramChatMessage.fileName) == 2;
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
    if (bool1) {
      return paramView;
    }
    if (bool2) {
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
    else
    {
      QLog.w("TroopFileItemBuilder", 1, "set LayoutParams, but holder.mContent is null!");
    }
    a(localHolder, paramViewGroup, paramChatMessage);
    if (jdField_e_of_type_Boolean) {}
    try
    {
      paramChatMessage = localHolder.jdField_b_of_type_JavaLangStringBuilder;
      paramChatMessage.append(localHolder.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramChatMessage.append(" ");
      localHolder.jdField_b_of_type_JavaLangStringBuilder.append(localHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
      localHolder.jdField_b_of_type_JavaLangStringBuilder.append(localHolder.jdField_c_of_type_AndroidWidgetTextView.getText());
      localHolder.jdField_b_of_type_JavaLangStringBuilder.append("按钮");
      paramViewGroup.setContentDescription(localHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramViewGroup;
    }
    catch (Exception paramChatMessage) {}
    return paramViewGroup;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (TroopFileItemBuilder.Holder)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    }
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
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
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131715097);
    }
    return HardCodeUtil.a(2131715101);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(View paramView)
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView.frienduin);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, localStringBuilder.toString(), "", "", "");
    localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (((TroopFileStatusInfo)localObject).b == 12)
    {
      TroopFileError.a(localActivity, String.format(localActivity.getString(2131697330), new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject).g) }), 1);
      return;
    }
    switch (((TroopFileStatusInfo)localObject).b)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).longValue();
      QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, l, (TroopFileStatusInfo)localObject, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime, 3, 3, null, false, false);
      return;
    case 1: 
    case 2: 
      localIntent.putExtra(TroopFileProxyActivity.a, paramView.frienduin);
      TroopFileProxyActivity.b(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    if (paramBoolean)
    {
      localIntent.putExtra(TroopFileProxyActivity.a, paramView.frienduin);
      TroopFileProxyActivity.b(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public void a(TroopFileItemBuilder.Holder paramHolder, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    if (paramHolder.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130842702);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(2131697221);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364521);
      this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296383);
      DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramViewGroup.addView(paramHolder.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramChatMessage.isSend())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      paramViewGroup.addRule(7, 2131364521);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296383) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    paramViewGroup.addRule(5, 2131364521);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296383) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    boolean bool1 = b(paramChatMessage);
    boolean bool2 = c(paramChatMessage);
    if ((!bool1) && (!bool2) && (paramViewHolder.jdField_a_of_type_AndroidViewView != null))
    {
      if (paramChatMessage.isSend())
      {
        paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850341);
        return;
      }
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850165);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = a(paramView);
    if (paramView != null) {
      if (paramView.isMultiMsg) {
        a(localQQCustomMenu, paramView, null);
      } else {
        b(localQQCustomMenu, paramView, null);
      }
    }
    return localQQCustomMenu.a();
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
    if (paramView.getId() == 2131364521)
    {
      Object localObject = AIOUtils.a(paramView);
      if (localObject == null)
      {
        QLog.w("TroopFileItemBuilder", 1, "item click holder tag is null");
      }
      else if (!TroopFileItemBuilder.Holder.class.isInstance(localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("item click holder tag class[");
        localStringBuilder.append(localObject.getClass().getName());
        localStringBuilder.append("] is not Holder");
        QLog.e("TroopFileItemBuilder", 1, localStringBuilder.toString());
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
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */