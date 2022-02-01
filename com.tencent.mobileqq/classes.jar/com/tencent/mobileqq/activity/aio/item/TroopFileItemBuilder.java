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
  public static boolean A = false;
  public static boolean B = false;
  public static int C = 100;
  public static HashMap<String, Long> D = new HashMap();
  static int w;
  static int x;
  public static LruCache<String, Drawable> y = new LruCache(20);
  public static boolean z;
  public View.OnClickListener E;
  protected View F;
  private TroopFileBubblePauseHandler G;
  public Handler a;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131296615);
    w = (int)(localDisplayMetrics.widthPixels - DisplayUtils.a(localBaseApplication, 40.0F) * 2.0F - BaseChatItemLayout.s - BaseChatItemLayout.t - i * 2 - DisplayUtils.a(localBaseApplication, 10.0F));
    if (w > 640) {
      w = 640;
    }
    x = w * 9 / 16;
    z = false;
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
    //   1: getfield 143	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:n	Ljava/lang/String;
    //   4: astore 9
    //   6: aload_1
    //   7: getfield 146	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:k	Ljava/lang/String;
    //   10: ifnull +11 -> 21
    //   13: aload_1
    //   14: getfield 146	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:k	Ljava/lang/String;
    //   17: astore_2
    //   18: goto +6 -> 24
    //   21: aload 9
    //   23: astore_2
    //   24: aload_2
    //   25: invokestatic 151	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_2
    //   29: aload_0
    //   30: invokevirtual 52	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   33: astore 11
    //   35: aload 11
    //   37: invokevirtual 58	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   40: getfield 154	android/util/DisplayMetrics:densityDpi	I
    //   43: istore 7
    //   45: invokestatic 158	com/tencent/mobileqq/transfile/URLDrawableHelper:getRoundCorner	()F
    //   48: iload 7
    //   50: i2f
    //   51: ldc 159
    //   53: fdiv
    //   54: fmul
    //   55: fstore_3
    //   56: fload_3
    //   57: fstore 4
    //   59: aload_2
    //   60: ifnull +190 -> 250
    //   63: fload_3
    //   64: fstore 4
    //   66: aload_2
    //   67: invokevirtual 165	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   70: ldc 167
    //   72: invokestatic 173	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   75: ifeq +175 -> 250
    //   78: getstatic 40	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:y	Landroid/support/v4/util/LruCache;
    //   81: aload 9
    //   83: invokevirtual 177	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 179	android/graphics/drawable/Drawable
    //   89: astore_0
    //   90: aload_0
    //   91: ifnull +12 -> 103
    //   94: aload_0
    //   95: instanceof 181
    //   98: ifeq +5 -> 103
    //   101: aload_0
    //   102: areturn
    //   103: fload_3
    //   104: fstore 4
    //   106: aload_1
    //   107: getfield 146	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:k	Ljava/lang/String;
    //   110: ifnull +140 -> 250
    //   113: new 183	java/io/File
    //   116: dup
    //   117: aload_1
    //   118: getfield 146	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:k	Ljava/lang/String;
    //   121: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore_1
    //   125: aload_1
    //   126: iconst_0
    //   127: invokestatic 192	com/tencent/image/NativeGifImage:getImageSize	(Ljava/io/File;Z)Landroid/graphics/Rect;
    //   130: astore_0
    //   131: aload_0
    //   132: getfield 197	android/graphics/Rect:right	I
    //   135: aload_0
    //   136: getfield 200	android/graphics/Rect:bottom	I
    //   139: invokestatic 203	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(II)[I
    //   142: astore_2
    //   143: aload_0
    //   144: aload_2
    //   145: iconst_0
    //   146: iaload
    //   147: iload 7
    //   149: sipush 160
    //   152: idiv
    //   153: idiv
    //   154: putfield 197	android/graphics/Rect:right	I
    //   157: aload_0
    //   158: aload_2
    //   159: iconst_1
    //   160: iaload
    //   161: iload 7
    //   163: sipush 160
    //   166: idiv
    //   167: idiv
    //   168: putfield 200	android/graphics/Rect:bottom	I
    //   171: invokestatic 158	com/tencent/mobileqq/transfile/URLDrawableHelper:getRoundCorner	()F
    //   174: fstore 4
    //   176: aload_1
    //   177: iconst_0
    //   178: iconst_0
    //   179: aload_0
    //   180: invokevirtual 207	android/graphics/Rect:width	()I
    //   183: aload_0
    //   184: invokevirtual 210	android/graphics/Rect:height	()I
    //   187: fload 4
    //   189: invokestatic 216	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +26 -> 220
    //   197: new 181	com/tencent/image/GifDrawable
    //   200: dup
    //   201: aload_1
    //   202: aload 11
    //   204: invokespecial 219	com/tencent/image/GifDrawable:<init>	(Lcom/tencent/image/AbstractGifImage;Landroid/content/res/Resources;)V
    //   207: astore_0
    //   208: getstatic 40	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:y	Landroid/support/v4/util/LruCache;
    //   211: aload 9
    //   213: aload_0
    //   214: invokevirtual 223	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: aload_0
    //   219: areturn
    //   220: iconst_1
    //   221: aload_0
    //   222: invokevirtual 207	android/graphics/Rect:width	()I
    //   225: aload_0
    //   226: invokevirtual 210	android/graphics/Rect:height	()I
    //   229: invokestatic 225	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   232: astore_0
    //   233: aload_0
    //   234: areturn
    //   235: astore_0
    //   236: fload 4
    //   238: fstore_3
    //   239: goto +4 -> 243
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   247: fload_3
    //   248: fstore 4
    //   250: new 183	java/io/File
    //   253: dup
    //   254: aload 9
    //   256: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   259: astore 12
    //   261: getstatic 40	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:y	Landroid/support/v4/util/LruCache;
    //   264: aload 9
    //   266: invokevirtual 177	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   269: checkcast 179	android/graphics/drawable/Drawable
    //   272: astore_1
    //   273: aload_1
    //   274: astore_0
    //   275: aload_1
    //   276: ifnonnull +498 -> 774
    //   279: aload_1
    //   280: astore_0
    //   281: aload 12
    //   283: invokevirtual 232	java/io/File:exists	()Z
    //   286: ifeq +488 -> 774
    //   289: new 234	android/graphics/BitmapFactory$Options
    //   292: dup
    //   293: invokespecial 235	android/graphics/BitmapFactory$Options:<init>	()V
    //   296: astore_0
    //   297: aload_0
    //   298: iconst_1
    //   299: putfield 238	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   302: aload 12
    //   304: invokevirtual 241	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   307: aload_0
    //   308: invokestatic 246	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   311: pop
    //   312: aload_0
    //   313: getfield 249	android/graphics/BitmapFactory$Options:outWidth	I
    //   316: istore 5
    //   318: aload_0
    //   319: getfield 252	android/graphics/BitmapFactory$Options:outHeight	I
    //   322: istore 6
    //   324: aload 12
    //   326: invokevirtual 241	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   329: invokestatic 256	com/tencent/mobileqq/transfile/URLDrawableHelper:getExifRotation	(Ljava/lang/String;)I
    //   332: istore 8
    //   334: iload 8
    //   336: bipush 90
    //   338: if_icmpeq +11 -> 349
    //   341: iload 8
    //   343: sipush 270
    //   346: if_icmpne +15 -> 361
    //   349: aload_0
    //   350: getfield 252	android/graphics/BitmapFactory$Options:outHeight	I
    //   353: istore 5
    //   355: aload_0
    //   356: getfield 249	android/graphics/BitmapFactory$Options:outWidth	I
    //   359: istore 6
    //   361: iload 5
    //   363: iload 6
    //   365: invokestatic 203	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(II)[I
    //   368: astore_0
    //   369: aload_0
    //   370: iconst_0
    //   371: iaload
    //   372: istore 5
    //   374: aload_0
    //   375: iconst_1
    //   376: iaload
    //   377: istore 6
    //   379: aconst_null
    //   380: astore_2
    //   381: aconst_null
    //   382: astore 10
    //   384: aconst_null
    //   385: astore_0
    //   386: new 258	java/io/BufferedInputStream
    //   389: dup
    //   390: new 260	java/io/FileInputStream
    //   393: dup
    //   394: aload 12
    //   396: invokespecial 263	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   399: invokespecial 266	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   402: astore_1
    //   403: aload_1
    //   404: invokestatic 272	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   407: astore_2
    //   408: aload_2
    //   409: iload 7
    //   411: invokevirtual 277	android/graphics/Bitmap:setDensity	(I)V
    //   414: aload_2
    //   415: invokevirtual 280	android/graphics/Bitmap:getWidth	()I
    //   418: iload 5
    //   420: if_icmpne +14 -> 434
    //   423: aload_2
    //   424: astore_0
    //   425: aload_2
    //   426: invokevirtual 283	android/graphics/Bitmap:getHeight	()I
    //   429: iload 6
    //   431: if_icmpeq +78 -> 509
    //   434: aload_2
    //   435: astore_0
    //   436: aload_2
    //   437: invokevirtual 280	android/graphics/Bitmap:getWidth	()I
    //   440: ifeq +69 -> 509
    //   443: aload_2
    //   444: astore_0
    //   445: aload_2
    //   446: invokevirtual 283	android/graphics/Bitmap:getHeight	()I
    //   449: ifeq +60 -> 509
    //   452: new 285	android/graphics/Matrix
    //   455: dup
    //   456: invokespecial 286	android/graphics/Matrix:<init>	()V
    //   459: astore_0
    //   460: aload_0
    //   461: iload 5
    //   463: i2f
    //   464: aload_2
    //   465: invokevirtual 280	android/graphics/Bitmap:getWidth	()I
    //   468: i2f
    //   469: fdiv
    //   470: iload 6
    //   472: i2f
    //   473: aload_2
    //   474: invokevirtual 283	android/graphics/Bitmap:getHeight	()I
    //   477: i2f
    //   478: fdiv
    //   479: invokevirtual 290	android/graphics/Matrix:setScale	(FF)V
    //   482: aload_2
    //   483: iconst_0
    //   484: iconst_0
    //   485: aload_2
    //   486: invokevirtual 280	android/graphics/Bitmap:getWidth	()I
    //   489: aload_2
    //   490: invokevirtual 283	android/graphics/Bitmap:getHeight	()I
    //   493: aload_0
    //   494: iconst_0
    //   495: invokestatic 294	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   498: astore_0
    //   499: aload_0
    //   500: iload 7
    //   502: invokevirtual 277	android/graphics/Bitmap:setDensity	(I)V
    //   505: aload_2
    //   506: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   509: new 131	android/graphics/drawable/BitmapDrawable
    //   512: dup
    //   513: aload 11
    //   515: aload_0
    //   516: fload 4
    //   518: iload 5
    //   520: iload 6
    //   522: invokestatic 301	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   525: invokespecial 304	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   528: astore_2
    //   529: aload_0
    //   530: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   533: getstatic 40	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:y	Landroid/support/v4/util/LruCache;
    //   536: aload 9
    //   538: aload_2
    //   539: invokevirtual 223	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   542: pop
    //   543: aload_1
    //   544: invokevirtual 307	java/io/BufferedInputStream:close	()V
    //   547: goto +25 -> 572
    //   550: astore_0
    //   551: aload_0
    //   552: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   555: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +14 -> 572
    //   561: ldc_w 314
    //   564: iconst_2
    //   565: ldc_w 316
    //   568: aload_0
    //   569: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   572: aload_2
    //   573: areturn
    //   574: astore_0
    //   575: goto +164 -> 739
    //   578: astore 9
    //   580: goto +22 -> 602
    //   583: astore 9
    //   585: goto +93 -> 678
    //   588: astore_1
    //   589: aload_0
    //   590: astore_2
    //   591: aload_1
    //   592: astore_0
    //   593: aload_2
    //   594: astore_1
    //   595: goto +144 -> 739
    //   598: astore 9
    //   600: aload_2
    //   601: astore_1
    //   602: aload_1
    //   603: astore_0
    //   604: iconst_1
    //   605: iload 5
    //   607: iload 6
    //   609: invokestatic 225	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   612: astore_2
    //   613: aload_1
    //   614: astore_0
    //   615: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +17 -> 635
    //   621: aload_1
    //   622: astore_0
    //   623: ldc_w 314
    //   626: iconst_2
    //   627: ldc_w 322
    //   630: aload 9
    //   632: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   635: aload_2
    //   636: astore_0
    //   637: aload_1
    //   638: ifnull +136 -> 774
    //   641: aload_1
    //   642: invokevirtual 307	java/io/BufferedInputStream:close	()V
    //   645: aload_2
    //   646: areturn
    //   647: astore_1
    //   648: aload_1
    //   649: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   652: aload_2
    //   653: astore_0
    //   654: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   657: ifeq +117 -> 774
    //   660: ldc_w 314
    //   663: iconst_2
    //   664: ldc_w 316
    //   667: aload_1
    //   668: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   671: aload_2
    //   672: areturn
    //   673: astore 9
    //   675: aload 10
    //   677: astore_1
    //   678: aload_1
    //   679: astore_0
    //   680: iconst_1
    //   681: iload 5
    //   683: iload 6
    //   685: invokestatic 225	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   688: astore_2
    //   689: aload_1
    //   690: astore_0
    //   691: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq +17 -> 711
    //   697: aload_1
    //   698: astore_0
    //   699: ldc_w 314
    //   702: iconst_2
    //   703: ldc_w 324
    //   706: aload 9
    //   708: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   711: aload_2
    //   712: astore_0
    //   713: aload_1
    //   714: ifnull +60 -> 774
    //   717: aload_1
    //   718: invokevirtual 307	java/io/BufferedInputStream:close	()V
    //   721: aload_2
    //   722: areturn
    //   723: astore_1
    //   724: aload_1
    //   725: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   728: aload_2
    //   729: astore_0
    //   730: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   733: ifeq +41 -> 774
    //   736: goto -76 -> 660
    //   739: aload_1
    //   740: ifnull +32 -> 772
    //   743: aload_1
    //   744: invokevirtual 307	java/io/BufferedInputStream:close	()V
    //   747: goto +25 -> 772
    //   750: astore_1
    //   751: aload_1
    //   752: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   755: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   758: ifeq +14 -> 772
    //   761: ldc_w 314
    //   764: iconst_2
    //   765: ldc_w 316
    //   768: aload_1
    //   769: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   772: aload_0
    //   773: athrow
    //   774: aload_0
    //   775: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	776	0	paramContext	Context
    //   0	776	1	paramTroopFileStatusInfo	TroopFileStatusInfo
    //   0	776	2	paramMessageForTroopFile	MessageForTroopFile
    //   55	193	3	f1	float
    //   57	460	4	f2	float
    //   316	366	5	i	int
    //   322	362	6	j	int
    //   43	458	7	k	int
    //   332	15	8	m	int
    //   4	533	9	str	String
    //   578	1	9	localException1	Exception
    //   583	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   598	33	9	localException2	Exception
    //   673	34	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   382	294	10	localObject	Object
    //   33	481	11	localResources	Resources
    //   259	136	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   176	193	235	java/lang/Exception
    //   197	218	235	java/lang/Exception
    //   220	233	235	java/lang/Exception
    //   125	176	242	java/lang/Exception
    //   543	547	550	java/lang/Exception
    //   403	423	574	finally
    //   425	434	574	finally
    //   436	443	574	finally
    //   445	509	574	finally
    //   509	543	574	finally
    //   403	423	578	java/lang/Exception
    //   425	434	578	java/lang/Exception
    //   436	443	578	java/lang/Exception
    //   445	509	578	java/lang/Exception
    //   509	543	578	java/lang/Exception
    //   403	423	583	java/lang/OutOfMemoryError
    //   425	434	583	java/lang/OutOfMemoryError
    //   436	443	583	java/lang/OutOfMemoryError
    //   445	509	583	java/lang/OutOfMemoryError
    //   509	543	583	java/lang/OutOfMemoryError
    //   386	403	588	finally
    //   604	613	588	finally
    //   615	621	588	finally
    //   623	635	588	finally
    //   680	689	588	finally
    //   691	697	588	finally
    //   699	711	588	finally
    //   386	403	598	java/lang/Exception
    //   641	645	647	java/lang/Exception
    //   386	403	673	java/lang/OutOfMemoryError
    //   717	721	723	java/lang/Exception
    //   743	747	750	java/lang/Exception
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
      paramInt1 = x;
      if ((j >= paramInt1) && (i >= paramInt1))
      {
        paramInt1 = w;
        if ((j < paramInt1) && (i < paramInt1))
        {
          paramInt2 = j;
          paramInt1 = i;
        }
        else
        {
          if (j > i)
          {
            f1 = w;
            f2 = j;
          }
          else
          {
            f1 = w;
            f2 = i;
          }
          float f3 = f1 / f2;
          if (j > i)
          {
            f1 = x;
            f2 = i;
          }
          else
          {
            f1 = x;
            f2 = j;
          }
          f1 = Math.max(f3, f1 / f2);
          j = (int)(j * f1 + 0.5F);
          paramInt2 = (int)(i * f1 + 0.5F);
          i = x;
          paramInt1 = j;
          if (j < i) {
            paramInt1 = i;
          }
          j = w;
          i = paramInt1;
          if (paramInt1 > j) {
            i = j;
          }
          paramInt1 = x;
          j = paramInt2;
          if (paramInt2 < paramInt1) {
            j = paramInt1;
          }
          int k = w;
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
        paramInt2 = x;
        f1 = paramInt2 / j;
        i = (int)(i * f1 + 0.5F);
        j = w;
        paramInt1 = i;
        if (i > j) {
          paramInt1 = j;
        }
      }
      else
      {
        f1 = x / i;
        paramInt1 = (int)(j * f1 + 0.5F);
        i = w;
        paramInt2 = paramInt1;
        if (paramInt1 > i) {
          paramInt2 = i;
        }
        paramInt1 = x;
      }
      arrayOfInt[0] = paramInt2;
      arrayOfInt[1] = paramInt1;
      return arrayOfInt;
    }
    paramInt1 = w;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = (paramInt1 * 9 / 16);
    return arrayOfInt;
  }
  
  public static boolean f(ChatMessage paramChatMessage)
  {
    return FileManagerUtil.c(((MessageForTroopFile)paramChatMessage).fileName) == 0;
  }
  
  public static boolean g(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    if (paramChatMessage.width != 0) {
      int i = paramChatMessage.height;
    }
    return FileManagerUtil.c(paramChatMessage.fileName) == 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    boolean bool1 = f(paramChatMessage);
    boolean bool2 = g(paramChatMessage);
    if (bool1) {
      return paramView;
    }
    if (bool2) {
      return paramView;
    }
    paramView = a(paramView, paramChatMessage);
    paramViewGroup = (BaseBubbleBuilder.ViewHolder)AIOUtils.b(paramView);
    this.G.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    TroopFileItemBuilder.Holder localHolder = (TroopFileItemBuilder.Holder)paramViewGroup.getTag();
    if (localHolder.d != null) {
      localHolder.d.setVisibility(0);
    }
    if (localHolder.f != null) {
      localHolder.f.setVisibility(8);
    }
    if (localHolder.h != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localHolder.h.getLayoutParams();
      localLayoutParams.width = BaseChatItemLayout.z;
      localLayoutParams.height = -2;
      localHolder.h.setLayoutParams(localLayoutParams);
    }
    else
    {
      QLog.w("TroopFileItemBuilder", 1, "set LayoutParams, but holder.mContent is null!");
    }
    a(localHolder, paramViewGroup, paramChatMessage);
    if (v) {}
    try
    {
      paramChatMessage = localHolder.r;
      paramChatMessage.append(localHolder.a.getText());
      paramChatMessage.append(" ");
      localHolder.r.append(localHolder.b.getText());
      localHolder.r.append(localHolder.c.getText());
      localHolder.r.append("按钮");
      paramViewGroup.setContentDescription(localHolder.r.toString());
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
      paramChatMessage = new RelativeLayout(this.e);
    }
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopFileItemBuilder.Holder(this);
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return paramQQCustomMenu;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  void a(View paramView, boolean paramBoolean)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    paramView = e(paramView);
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramView;
    Object localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView.frienduin);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, localStringBuilder.toString(), "", "", "");
    localObject = TroopFileUtils.a(this.d, localMessageForTroopFile);
    if (((TroopFileStatusInfo)localObject).e == 12)
    {
      TroopFileError.a(localActivity, String.format(localActivity.getString(2131895103), new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject).t) }), 1);
      return;
    }
    switch (((TroopFileStatusInfo)localObject).e)
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
      long l = Long.valueOf(this.f.b).longValue();
      QFileUtils.a(this.d, this.e, this.f, paramView, l, (TroopFileStatusInfo)localObject, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime, 3, 3, null, false, false);
      return;
    case 1: 
    case 2: 
      localIntent.putExtra(TroopFileProxyActivity.b, paramView.frienduin);
      TroopFileProxyActivity.b(localActivity, localIntent, this.d.getCurrentAccountUin());
      return;
    }
    if (paramBoolean)
    {
      localIntent.putExtra(TroopFileProxyActivity.b, paramView.frienduin);
      TroopFileProxyActivity.b(localActivity, localIntent, this.d.getCurrentAccountUin());
    }
  }
  
  public void a(TroopFileItemBuilder.Holder paramHolder, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    if (paramHolder.e == null)
    {
      paramHolder.e = new TextView(this.e);
      paramHolder.e.setBackgroundResource(2130843655);
      paramHolder.e.setTextSize(1, 12.0F);
      paramHolder.e.setTextColor(this.e.getResources().getColor(2131168464));
      paramHolder.e.setText(2131894994);
      paramHolder.e.setSingleLine();
      paramHolder.e.setGravity(16);
      paramHolder.e.setPadding(DisplayUtil.a(this.e, 5.0F), 0, DisplayUtil.a(this.e, 5.0F), 0);
      paramHolder.e.setOnClickListener(this.E);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131430578);
      this.e.getResources().getDimensionPixelSize(2131296615);
      DisplayUtil.a(this.e, 10.0F);
      paramViewGroup.addView(paramHolder.e, localLayoutParams);
    }
    paramHolder.e.setVisibility(0);
    if (paramChatMessage.isSend())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
      paramViewGroup.addRule(7, 2131430578);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.e.getResources().getDimensionPixelSize(2131296615) + DisplayUtil.a(this.e, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramHolder.e.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
    paramViewGroup.addRule(5, 2131430578);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.e.getResources().getDimensionPixelSize(2131296615) + DisplayUtil.a(this.e, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramHolder.e.setLayoutParams(paramViewGroup);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    boolean bool1 = f(paramChatMessage);
    boolean bool2 = g(paramChatMessage);
    if ((!bool1) && (!bool2) && (paramViewHolder.h != null))
    {
      if (paramChatMessage.isSend())
      {
        paramViewHolder.h.setBackgroundResource(2130852132);
        return;
      }
      paramViewHolder.h.setBackgroundResource(2130851950);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    this.F = paramView;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = e(paramView);
    if (paramView != null) {
      if (paramView.isMultiMsg) {
        a(localQQCustomMenu, paramView, null);
      } else {
        b(localQQCustomMenu, paramView, null);
      }
    }
    return localQQCustomMenu.d();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return paramQQCustomMenu;
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    a((View)paramView.getParent(), true);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    this.d.getMessageFacade().h(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131912585);
    }
    return HardCodeUtil.a(2131912589);
  }
  
  protected MessageForTroopFile e(View paramView)
  {
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.b(paramView);
    if (paramView.q.isMultiMsg) {
      return (MessageForTroopFile)FileManagerUtil.b(paramView.q);
    }
    return (MessageForTroopFile)paramView.q;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131430578)
    {
      Object localObject = AIOUtils.b(paramView);
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
        ReportController.b(this.d, "dc00898", "", "", "0X800A68A", "0X800A68A", 0, 0, "4", "", "", "");
        localObject = (TroopFileItemBuilder.Holder)localObject;
        localObject = e(paramView);
        if ((!f((ChatMessage)localObject)) && (!g((ChatMessage)localObject)) && ((!((MessageForTroopFile)localObject).isMultiMsg) || (FileManagerUtil.a((ChatMessage)localObject, this.d, this.e))))
        {
          a(paramView, false);
          AIOUtils.q = true;
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */