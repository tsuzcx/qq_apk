package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager.LightReplyEmotionClickListener;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qqfav.QfavBuilder;
import cooperation.troop.TroopFileProxyActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import vgk;
import vgm;
import vgn;
import vgo;
import vgp;
import vgr;
import vgs;

public class TroopFileItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, LightReplyMenuManager.LightReplyEmotionClickListener
{
  public static LruCache a;
  public static HashMap a;
  static int b;
  static int jdField_c_of_type_Int;
  public static int d;
  public View.OnClickListener a;
  protected LightReplyMenuManager a;
  public Handler b;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    int i = localBaseApplication.getResources().getDimensionPixelSize(2131558619);
    jdField_b_of_type_Int = (int)(localDisplayMetrics.widthPixels - DisplayUtils.a(localBaseApplication, 40.0F) * 2.0F - BaseChatItemLayout.s - BaseChatItemLayout.t - i * 2 - DisplayUtils.a(localBaseApplication, 10.0F));
    if (jdField_b_of_type_Int > 640) {
      jdField_b_of_type_Int = 640;
    }
    jdField_c_of_type_Int = jdField_b_of_type_Int * 9 / 16;
    jdField_d_of_type_Int = 100;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public TroopFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vgm(this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager = LightReplyMenuManager.a();
  }
  
  public static Drawable a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return new BitmapDrawableWithMargin(BaseApplicationImpl.getApplication().getResources(), null, paramInt2, paramInt3, -921103);
    }
    Object localObject;
    if (paramInt1 == 1) {
      localObject = URLDrawableHelper.b();
    }
    for (;;)
    {
      if ((localObject instanceof SkinnableBitmapDrawable))
      {
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
        return new BitmapDrawableWithMargin(BaseApplicationImpl.getApplication().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        if (paramInt1 == 2) {
          localObject = URLDrawableHelper.a();
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
    //   1: getfield 155	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:d	Ljava/lang/String;
    //   4: astore 8
    //   6: aload_1
    //   7: getfield 157	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: ifnull +80 -> 90
    //   13: aload_1
    //   14: getfield 157	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: astore_2
    //   18: aload_2
    //   19: invokestatic 162	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_0
    //   24: invokevirtual 41	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: astore 10
    //   29: aload 10
    //   31: invokevirtual 47	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   34: getfield 165	android/util/DisplayMetrics:densityDpi	I
    //   37: istore 6
    //   39: ldc 166
    //   41: iload 6
    //   43: i2f
    //   44: ldc 167
    //   46: fdiv
    //   47: fmul
    //   48: fstore_3
    //   49: aload_2
    //   50: ifnull +742 -> 792
    //   53: aload_2
    //   54: invokevirtual 173	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   57: ldc 175
    //   59: invokestatic 181	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   62: ifeq +730 -> 792
    //   65: getstatic 29	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   68: aload 8
    //   70: invokevirtual 185	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 187	android/graphics/drawable/Drawable
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull +18 -> 96
    //   81: aload_0
    //   82: instanceof 189
    //   85: ifeq +11 -> 96
    //   88: aload_0
    //   89: areturn
    //   90: aload 8
    //   92: astore_2
    //   93: goto -75 -> 18
    //   96: aload_1
    //   97: getfield 157	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   100: ifnull +692 -> 792
    //   103: new 191	java/io/File
    //   106: dup
    //   107: aload_1
    //   108: getfield 157	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore_1
    //   115: aload_1
    //   116: iconst_0
    //   117: invokestatic 200	com/tencent/image/NativeGifImage:getImageSize	(Ljava/io/File;Z)Landroid/graphics/Rect;
    //   120: astore_0
    //   121: aload_0
    //   122: getfield 205	android/graphics/Rect:right	I
    //   125: aload_0
    //   126: getfield 208	android/graphics/Rect:bottom	I
    //   129: invokestatic 211	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(II)[I
    //   132: astore_2
    //   133: aload_0
    //   134: aload_2
    //   135: iconst_0
    //   136: iaload
    //   137: iload 6
    //   139: sipush 160
    //   142: idiv
    //   143: idiv
    //   144: putfield 205	android/graphics/Rect:right	I
    //   147: aload_0
    //   148: aload_2
    //   149: iconst_1
    //   150: iaload
    //   151: iload 6
    //   153: sipush 160
    //   156: idiv
    //   157: idiv
    //   158: putfield 208	android/graphics/Rect:bottom	I
    //   161: aload_1
    //   162: iconst_0
    //   163: iconst_0
    //   164: aload_0
    //   165: invokevirtual 215	android/graphics/Rect:width	()I
    //   168: aload_0
    //   169: invokevirtual 218	android/graphics/Rect:height	()I
    //   172: ldc 166
    //   174: invokestatic 224	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +388 -> 567
    //   182: new 189	com/tencent/image/GifDrawable
    //   185: dup
    //   186: aload_1
    //   187: aload 10
    //   189: invokespecial 227	com/tencent/image/GifDrawable:<init>	(Lcom/tencent/image/AbstractGifImage;Landroid/content/res/Resources;)V
    //   192: astore_0
    //   193: getstatic 29	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   196: aload 8
    //   198: aload_0
    //   199: invokevirtual 231	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   202: pop
    //   203: aload_0
    //   204: areturn
    //   205: astore_0
    //   206: ldc 166
    //   208: fstore_3
    //   209: aload_0
    //   210: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   213: new 191	java/io/File
    //   216: dup
    //   217: aload 8
    //   219: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore_2
    //   223: getstatic 29	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   226: aload 8
    //   228: invokevirtual 185	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 187	android/graphics/drawable/Drawable
    //   234: astore_1
    //   235: aload_1
    //   236: astore_0
    //   237: aload_1
    //   238: ifnonnull -150 -> 88
    //   241: aload_1
    //   242: astore_0
    //   243: aload_2
    //   244: invokevirtual 238	java/io/File:exists	()Z
    //   247: ifeq -159 -> 88
    //   250: new 240	android/graphics/BitmapFactory$Options
    //   253: dup
    //   254: invokespecial 241	android/graphics/BitmapFactory$Options:<init>	()V
    //   257: astore_0
    //   258: aload_0
    //   259: iconst_1
    //   260: putfield 244	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   263: aload_2
    //   264: invokevirtual 247	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   267: aload_0
    //   268: invokestatic 252	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   271: pop
    //   272: aload_0
    //   273: getfield 255	android/graphics/BitmapFactory$Options:outWidth	I
    //   276: istore 5
    //   278: aload_0
    //   279: getfield 258	android/graphics/BitmapFactory$Options:outHeight	I
    //   282: istore 4
    //   284: aload_2
    //   285: invokevirtual 247	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   288: invokestatic 261	com/tencent/mobileqq/transfile/URLDrawableHelper:a	(Ljava/lang/String;)I
    //   291: istore 7
    //   293: iload 7
    //   295: bipush 90
    //   297: if_icmpeq +11 -> 308
    //   300: iload 7
    //   302: sipush 270
    //   305: if_icmpne +15 -> 320
    //   308: aload_0
    //   309: getfield 258	android/graphics/BitmapFactory$Options:outHeight	I
    //   312: istore 5
    //   314: aload_0
    //   315: getfield 255	android/graphics/BitmapFactory$Options:outWidth	I
    //   318: istore 4
    //   320: iload 5
    //   322: iload 4
    //   324: invokestatic 211	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(II)[I
    //   327: astore_0
    //   328: aload_0
    //   329: iconst_0
    //   330: iaload
    //   331: istore 4
    //   333: aload_0
    //   334: iconst_1
    //   335: iaload
    //   336: istore 5
    //   338: new 263	java/io/BufferedInputStream
    //   341: dup
    //   342: new 265	java/io/FileInputStream
    //   345: dup
    //   346: aload_2
    //   347: invokespecial 268	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   350: invokespecial 271	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   353: astore_1
    //   354: aload_1
    //   355: astore_0
    //   356: aload_1
    //   357: invokestatic 277	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   360: astore_2
    //   361: aload_1
    //   362: astore_0
    //   363: aload_2
    //   364: iload 6
    //   366: invokevirtual 282	android/graphics/Bitmap:setDensity	(I)V
    //   369: aload_1
    //   370: astore_0
    //   371: aload_2
    //   372: invokevirtual 285	android/graphics/Bitmap:getWidth	()I
    //   375: iload 4
    //   377: if_icmpne +14 -> 391
    //   380: aload_1
    //   381: astore_0
    //   382: aload_2
    //   383: invokevirtual 288	android/graphics/Bitmap:getHeight	()I
    //   386: iload 5
    //   388: if_icmpeq +401 -> 789
    //   391: aload_1
    //   392: astore_0
    //   393: aload_2
    //   394: invokevirtual 285	android/graphics/Bitmap:getWidth	()I
    //   397: ifeq +392 -> 789
    //   400: aload_1
    //   401: astore_0
    //   402: aload_2
    //   403: invokevirtual 288	android/graphics/Bitmap:getHeight	()I
    //   406: ifeq +383 -> 789
    //   409: aload_1
    //   410: astore_0
    //   411: new 290	android/graphics/Matrix
    //   414: dup
    //   415: invokespecial 291	android/graphics/Matrix:<init>	()V
    //   418: astore 9
    //   420: aload_1
    //   421: astore_0
    //   422: aload 9
    //   424: iload 4
    //   426: i2f
    //   427: aload_2
    //   428: invokevirtual 285	android/graphics/Bitmap:getWidth	()I
    //   431: i2f
    //   432: fdiv
    //   433: iload 5
    //   435: i2f
    //   436: aload_2
    //   437: invokevirtual 288	android/graphics/Bitmap:getHeight	()I
    //   440: i2f
    //   441: fdiv
    //   442: invokevirtual 295	android/graphics/Matrix:setScale	(FF)V
    //   445: aload_1
    //   446: astore_0
    //   447: aload_2
    //   448: iconst_0
    //   449: iconst_0
    //   450: aload_2
    //   451: invokevirtual 285	android/graphics/Bitmap:getWidth	()I
    //   454: aload_2
    //   455: invokevirtual 288	android/graphics/Bitmap:getHeight	()I
    //   458: aload 9
    //   460: iconst_0
    //   461: invokestatic 299	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   464: astore 9
    //   466: aload_1
    //   467: astore_0
    //   468: aload 9
    //   470: iload 6
    //   472: invokevirtual 282	android/graphics/Bitmap:setDensity	(I)V
    //   475: aload_1
    //   476: astore_0
    //   477: aload_2
    //   478: invokevirtual 302	android/graphics/Bitmap:recycle	()V
    //   481: aload 9
    //   483: astore_2
    //   484: aload_1
    //   485: astore_0
    //   486: new 144	android/graphics/drawable/BitmapDrawable
    //   489: dup
    //   490: aload 10
    //   492: aload_2
    //   493: fload_3
    //   494: iload 4
    //   496: iload 5
    //   498: invokestatic 305	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   501: invokespecial 308	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   504: astore 9
    //   506: aload_1
    //   507: astore_0
    //   508: aload_2
    //   509: invokevirtual 302	android/graphics/Bitmap:recycle	()V
    //   512: aload_1
    //   513: astore_0
    //   514: getstatic 29	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   517: aload 8
    //   519: aload 9
    //   521: invokevirtual 231	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: pop
    //   525: aload 9
    //   527: astore_0
    //   528: aload_1
    //   529: ifnull -441 -> 88
    //   532: aload_1
    //   533: invokevirtual 311	java/io/BufferedInputStream:close	()V
    //   536: aload 9
    //   538: areturn
    //   539: astore_1
    //   540: aload_1
    //   541: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   544: aload 9
    //   546: astore_0
    //   547: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq -462 -> 88
    //   553: ldc_w 318
    //   556: iconst_2
    //   557: ldc_w 320
    //   560: aload_1
    //   561: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: aload 9
    //   566: areturn
    //   567: iconst_1
    //   568: aload_0
    //   569: invokevirtual 215	android/graphics/Rect:width	()I
    //   572: aload_0
    //   573: invokevirtual 218	android/graphics/Rect:height	()I
    //   576: invokestatic 326	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   579: astore_0
    //   580: aload_0
    //   581: areturn
    //   582: astore_0
    //   583: aconst_null
    //   584: astore_1
    //   585: iconst_1
    //   586: iload 4
    //   588: iload 5
    //   590: invokestatic 326	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   593: astore_2
    //   594: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +14 -> 611
    //   600: ldc_w 318
    //   603: iconst_2
    //   604: ldc_w 328
    //   607: aload_0
    //   608: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   611: aload_2
    //   612: astore_0
    //   613: aload_1
    //   614: ifnull -526 -> 88
    //   617: aload_1
    //   618: invokevirtual 311	java/io/BufferedInputStream:close	()V
    //   621: aload_2
    //   622: areturn
    //   623: astore_1
    //   624: aload_1
    //   625: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   628: aload_2
    //   629: astore_0
    //   630: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq -545 -> 88
    //   636: ldc_w 318
    //   639: iconst_2
    //   640: ldc_w 320
    //   643: aload_1
    //   644: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   659: invokestatic 326	com/tencent/mobileqq/activity/aio/item/TroopFileItemBuilder:a	(III)Landroid/graphics/drawable/Drawable;
    //   662: astore 8
    //   664: aload_1
    //   665: astore_0
    //   666: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +16 -> 685
    //   672: aload_1
    //   673: astore_0
    //   674: ldc_w 318
    //   677: iconst_2
    //   678: ldc_w 330
    //   681: aload_2
    //   682: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   685: aload 8
    //   687: astore_0
    //   688: aload_1
    //   689: ifnull -601 -> 88
    //   692: aload_1
    //   693: invokevirtual 311	java/io/BufferedInputStream:close	()V
    //   696: aload 8
    //   698: areturn
    //   699: astore_1
    //   700: aload_1
    //   701: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   704: aload 8
    //   706: astore_0
    //   707: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq -622 -> 88
    //   713: ldc_w 318
    //   716: iconst_2
    //   717: ldc_w 320
    //   720: aload_1
    //   721: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   724: aload 8
    //   726: areturn
    //   727: astore_1
    //   728: aconst_null
    //   729: astore_0
    //   730: aload_0
    //   731: ifnull +7 -> 738
    //   734: aload_0
    //   735: invokevirtual 311	java/io/BufferedInputStream:close	()V
    //   738: aload_1
    //   739: athrow
    //   740: astore_0
    //   741: aload_0
    //   742: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   745: invokestatic 316	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq -10 -> 738
    //   751: ldc_w 318
    //   754: iconst_2
    //   755: ldc_w 320
    //   758: aload_0
    //   759: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   48	446	3	f	float
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
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Context paramContext, TroopFileStatusInfo paramTroopFileStatusInfo, MessageForTroopFile paramMessageForTroopFile)
  {
    String str = paramTroopFileStatusInfo.d;
    File localFile = new File(str);
    if (jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str) != null) {
      return (Drawable)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
    }
    ThreadManager.post(new vgk(paramContext, paramTroopFileStatusInfo, paramMessageForTroopFile, str, paramQQAppInterface), 8, null, true);
    paramQQAppInterface = new BitmapFactory.Options();
    paramQQAppInterface.inJustDecodeBounds = true;
    ImageUtil.a(localFile.getAbsolutePath(), paramQQAppInterface);
    int j = paramQQAppInterface.outWidth;
    int i = paramQQAppInterface.outHeight;
    int k = URLDrawableHelper.a(localFile.getAbsolutePath());
    if ((k == 90) || (k == 270))
    {
      j = paramQQAppInterface.outHeight;
      i = paramQQAppInterface.outWidth;
    }
    paramQQAppInterface = a(j, i);
    return a(1, paramQQAppInterface[0], paramQQAppInterface[1]);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, TroopFileStatusInfo paramTroopFileStatusInfo, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getBoolean("tim_convert_teamwork_show_aio_menu", false);
      this.jdField_c_of_type_Boolean = false;
    }
    if ((this.jdField_d_of_type_Boolean) && (TeamWorkUtils.a(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString, paramTroopFileStatusInfo.g)))
    {
      int j = 1;
      i = j;
      if (paramBoolean)
      {
        if (TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString)) {
          break label200;
        }
        paramTroopFileStatusInfo = new File(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
        i = j;
        if (paramTroopFileStatusInfo == null)
        {
          i = j;
          if (paramTroopFileStatusInfo.exists()) {}
        }
      }
    }
    label200:
    for (int i = 0;; i = 0)
    {
      if (i != 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        paramQQCustomMenu.a(2131375378, this.jdField_a_of_type_AndroidContentContext.getString(2131439108), 2130838318);
      }
      return;
    }
  }
  
  public static final boolean a(MessageForTroopFile paramMessageForTroopFile)
  {
    paramMessageForTroopFile = FileUtil.a(paramMessageForTroopFile.fileName);
    if (!TextUtils.isEmpty(paramMessageForTroopFile))
    {
      paramMessageForTroopFile = paramMessageForTroopFile.toLowerCase();
      if ((".gif".equals(paramMessageForTroopFile)) || ("apng".equals(paramMessageForTroopFile))) {
        return true;
      }
    }
    return false;
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
      arrayOfInt[0] = jdField_b_of_type_Int;
      arrayOfInt[1] = (jdField_b_of_type_Int * 9 / 16);
      return arrayOfInt;
    }
    if ((j < jdField_c_of_type_Int) || (i < jdField_c_of_type_Int)) {
      if (j < i)
      {
        f1 = jdField_c_of_type_Int / j;
        j = jdField_c_of_type_Int;
        i = (int)(f1 * i + 0.5F);
        paramInt1 = i;
        paramInt2 = j;
        if (i > jdField_b_of_type_Int)
        {
          paramInt1 = jdField_b_of_type_Int;
          paramInt2 = j;
        }
      }
    }
    for (;;)
    {
      arrayOfInt[0] = paramInt2;
      arrayOfInt[1] = paramInt1;
      return arrayOfInt;
      paramInt2 = (int)(jdField_c_of_type_Int / i * j + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > jdField_b_of_type_Int) {
        paramInt1 = jdField_b_of_type_Int;
      }
      i = jdField_c_of_type_Int;
      paramInt2 = paramInt1;
      paramInt1 = i;
      continue;
      if ((j < jdField_b_of_type_Int) && (i < jdField_b_of_type_Int))
      {
        paramInt2 = j;
        paramInt1 = i;
      }
      else
      {
        if (j > i)
        {
          f1 = jdField_b_of_type_Int / j;
          label284:
          if (j <= i) {
            break label402;
          }
        }
        label402:
        for (float f2 = jdField_c_of_type_Int / i;; f2 = jdField_c_of_type_Int / j)
        {
          f1 = Math.max(f1, f2);
          paramInt1 = (int)(j * f1 + 0.5F);
          i = (int)(f1 * i + 0.5F);
          paramInt2 = paramInt1;
          if (paramInt1 < jdField_c_of_type_Int) {
            paramInt2 = jdField_c_of_type_Int;
          }
          paramInt1 = paramInt2;
          if (paramInt2 > jdField_b_of_type_Int) {
            paramInt1 = jdField_b_of_type_Int;
          }
          paramInt2 = i;
          if (i < jdField_c_of_type_Int) {
            paramInt2 = jdField_c_of_type_Int;
          }
          if (paramInt2 <= jdField_b_of_type_Int) {
            break label414;
          }
          i = jdField_b_of_type_Int;
          paramInt2 = paramInt1;
          paramInt1 = i;
          break;
          f1 = jdField_b_of_type_Int / i;
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
    return (FileManagerUtil.a(paramChatMessage.fileName) == 0) && (paramChatMessage.fileSize < 10485760L);
  }
  
  public static boolean d(ChatMessage paramChatMessage)
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
    boolean bool2 = d(paramChatMessage);
    if (bool1) {}
    while (bool2) {
      return paramView;
    }
    return a(paramView, paramChatMessage);
  }
  
  public View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    vgs localvgs = (vgs)paramViewGroup.getTag();
    localvgs.jdField_b_of_type_AndroidViewView.setVisibility(0);
    localvgs.jdField_c_of_type_AndroidViewView.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = localvgs.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localvgs.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    a(localvgs, paramViewGroup, paramChatMessage);
    a(localvgs.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, localvgs);
    localvgs.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.jdField_d_of_type_Int;
    if (jdField_b_of_type_Boolean) {}
    try
    {
      localvgs.jdField_b_of_type_JavaLangStringBuilder.append(localvgs.jdField_a_of_type_AndroidWidgetTextView.getText()).append(" ");
      localvgs.jdField_b_of_type_JavaLangStringBuilder.append(localvgs.jdField_b_of_type_AndroidWidgetTextView.getText());
      localvgs.jdField_b_of_type_JavaLangStringBuilder.append(localvgs.jdField_c_of_type_AndroidWidgetTextView.getText());
      localvgs.jdField_b_of_type_JavaLangStringBuilder.append("按钮");
      paramViewGroup.setContentDescription(localvgs.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramViewGroup;
    }
    catch (Exception paramChatMessage) {}
    return paramViewGroup;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (vgs)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968748, null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131361962));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131361963));
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131361964));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramChatMessage.findViewById(2131361960));
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramChatMessage.findViewById(2131361965));
      paramViewHolder.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramChatMessage.findViewById(2131363543));
      paramViewHolder.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramChatMessage.findViewById(2131363544));
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramChatMessage.findViewById(2131363541);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131363542);
      paramViewHolder.jdField_c_of_type_AndroidViewView.setMinimumWidth(jdField_c_of_type_Int);
      paramViewHolder.jdField_c_of_type_AndroidViewView.setMinimumHeight(jdField_c_of_type_Int);
      paramViewHolder.jdField_d_of_type_AndroidViewView = paramChatMessage.findViewById(2131368302);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramChatMessage.findViewById(2131368303));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
      paramViewHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131368304));
      paramViewHolder.jdField_e_of_type_AndroidViewView = paramChatMessage.findViewById(2131363545);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131363546));
      paramViewHolder.f = ((TextView)paramChatMessage.findViewById(2131363547));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle = ((ProgressCircle)paramChatMessage.findViewById(2131363549));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.jdField_a_of_type_Boolean = false;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.jdField_c_of_type_Int = 3;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.jdField_b_of_type_Boolean = true;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.jdField_a_of_type_Int = -1;
      ((RelativeLayout.LayoutParams)paramViewHolder.jdField_d_of_type_AndroidViewView.getLayoutParams()).addRule(12);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramChatMessage.findViewById(2131363548));
      paramView = new AIOSendMask(2130706432, this.jdField_a_of_type_Float * 12.0F);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(paramView);
    }
    if (paramViewHolder.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131361956)) {
      return this;
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vgs(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出文件";
    }
    return "发来文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject3 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
    if (localObject3 == null) {}
    Object localObject2;
    Object localObject1;
    label1283:
    do
    {
      TroopFileItemOperation localTroopFileItemOperation;
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          localObject2 = (MessageForTroopFile)paramChatMessage;
                          localObject1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject2);
                        } while (localObject1 == null);
                        i = NetworkUtil.a((Activity)paramContext);
                        localTroopFileItemOperation = new TroopFileItemOperation(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramContext);
                        switch (paramInt)
                        {
                        default: 
                          super.a(paramInt, paramContext, paramChatMessage);
                          return;
                        case 2131375365: 
                          if (i == 0)
                          {
                            TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131429782));
                            return;
                          }
                          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", paramChatMessage.frienduin, "", "");
                        }
                      } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 8);
                      ((TroopFileTransferManager)localObject3).f(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                      return;
                      if (i == 0)
                      {
                        TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131429782));
                        return;
                      }
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", paramChatMessage.frienduin, "", "");
                    } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 0) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 1));
                    ((TroopFileTransferManager)localObject3).c(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                    return;
                  } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 9);
                  localTroopFileItemOperation.b(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                  return;
                } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 2);
                localTroopFileItemOperation.a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                return;
              } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 8) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 9) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 10));
              ((TroopFileTransferManager)localObject3).f(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
              a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long, (Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
              return;
              if (i == 0)
              {
                TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131429782));
                return;
              }
            } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 1) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 0) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 2) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 3));
            ((TroopFileTransferManager)localObject3).c(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
            a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long, (Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID, paramChatMessage);
            return;
            if (i == 0)
            {
              TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131429782));
              return;
            }
            paramContext = new Bundle();
            paramContext.putInt("forward_type", 0);
            localObject2 = FileManagerUtil.a((TroopFileStatusInfo)localObject1);
            ((FileManagerEntity)localObject2).status = 2;
            ((FileManagerEntity)localObject2).nOpType = 24;
            localObject3 = new ForwardFileInfo();
            ((ForwardFileInfo)localObject3).b(((FileManagerEntity)localObject2).nSessionId);
            ((ForwardFileInfo)localObject3).b(10006);
            if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).getFilePath())) {
              ((ForwardFileInfo)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
            }
            ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).g);
            ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long);
            ((ForwardFileInfo)localObject3).a(Long.parseLong(paramChatMessage.frienduin));
            if (((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
              ((ForwardFileInfo)localObject3).e(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
            }
            ((ForwardFileInfo)localObject3).d(1);
            ((ForwardFileInfo)localObject3).a(1);
            paramContext.putParcelable("fileinfo", (Parcelable)localObject3);
            paramContext.putBoolean("not_forward", true);
            paramChatMessage = new Intent();
            paramChatMessage.putExtras(paramContext);
            paramChatMessage.putExtra("forward_text", ((TroopFileStatusInfo)localObject1).g);
            paramChatMessage.putExtra("forward_from_troop_file", true);
            paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
            paramChatMessage.putExtra("forward _key_nojump", true);
            ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            return;
            TroopFileUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            return;
            FileManagerUtil.a((Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
            return;
          } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 3);
          localTroopFileItemOperation.a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
          return;
        } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 10);
        localTroopFileItemOperation.b(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", paramChatMessage.frienduin, "", "");
      } while ((localObject1 != null) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 7));
      localTroopFileItemOperation.a(((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString, ((TroopFileStatusInfo)localObject1).g, ((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long, ((TroopFileStatusInfo)localObject1).jdField_e_of_type_Int);
      return;
      TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = FileManagerUtil.a((TroopFileStatusInfo)localObject1);
      localObject1 = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long).a(paramContext.strTroopFilePath);
      if (localObject1 != null)
      {
        paramContext.lastTime = ((TroopFileInfo)localObject1).jdField_c_of_type_Int;
        paramContext.selfUin = String.valueOf(((TroopFileInfo)localObject1).jdField_b_of_type_Long);
      }
      new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage, false);
      return;
      super.c(paramChatMessage);
      return;
      localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject1 = "2";
      paramContext = (Context)localObject1;
      if (localObject2 != null)
      {
        if ((((TroopInfo)localObject2).troopowneruin != null) && (((TroopInfo)localObject2).troopowneruin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          paramContext = "1";
        }
      }
      else
      {
        if (!c(paramChatMessage)) {
          break label1283;
        }
        localObject1 = "1";
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", paramContext, (String)localObject1);
        a(paramChatMessage);
        return;
        paramContext = (Context)localObject1;
        if (((TroopInfo)localObject2).Administrator == null) {
          break;
        }
        paramContext = (Context)localObject1;
        if (!((TroopInfo)localObject2).Administrator.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break;
        }
        paramContext = "2";
        break;
        if (d(paramChatMessage)) {
          localObject1 = "2";
        } else {
          localObject1 = "3";
        }
      }
    } while (localObject1 == null);
    paramContext = new TeamWorkFileImportInfo();
    paramContext.jdField_c_of_type_JavaLangString = ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString;
    paramContext.jdField_b_of_type_JavaLangString = ((TroopFileStatusInfo)localObject1).g;
    paramContext.jdField_e_of_type_Int = FileManagerUtil.a(((TroopFileStatusInfo)localObject1).g);
    paramContext.jdField_b_of_type_Boolean = true;
    paramContext.jdField_c_of_type_Int = 1;
    paramContext.jdField_c_of_type_Long = ((MessageForTroopFile)localObject2).fileSize;
    paramContext.d = ((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString;
    paramContext.jdField_b_of_type_Int = ((TroopFileStatusInfo)localObject1).jdField_e_of_type_Int;
    paramContext.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    paramContext.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 12) {
      paramContext.jdField_a_of_type_Boolean = true;
    }
    paramContext.jdField_a_of_type_Int = 1;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    TeamWorkConvertUtils.a(paramContext, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.jdField_c_of_type_Int);
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2, LightReplyEmojs paramLightReplyEmojs)
  {
    Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ChatFragment)localObject).a())
    {
      if (localObject != null) {
        ((BaseChatPie)localObject).a(this.jdField_a_of_type_AndroidContentContext, paramInt1, paramString, paramLong, paramInt2, paramLightReplyEmojs);
      }
      return;
    }
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new vgn(this, paramLong, paramUUID, paramActivity);
    DialogUtil.b(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131429765), this.jdField_a_of_type_AndroidContentContext.getString(2131429807), 2131429732, 2131429733, paramUUID, paramUUID).show();
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new vgo(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    DialogUtil.b(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131429764), this.jdField_a_of_type_AndroidContentContext.getString(2131429808), 2131429730, 2131429731, paramUUID, paramUUID).show();
  }
  
  public void a(Context paramContext, View paramView, MessageForTroopFile paramMessageForTroopFile)
  {
    ThreadManager.post(new vgr(this, paramContext, paramView, paramMessageForTroopFile), 8, null, true);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    b((View)paramView.getParent(), true);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        if (paramMotionEvent.getAction() != 0) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager == null);
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.e();
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a = new WeakReference(paramView);
      paramView.setAlpha(0.5F);
      return;
    } while (paramMotionEvent.getAction() != 3);
    paramView.setAlpha(1.0F);
  }
  
  public void a(View paramView, boolean paramBoolean) {}
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ChatMessage paramChatMessage, vgs paramvgs)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    localMessageForTroopFile.doParse();
    if (!localMessageForTroopFile.bReported)
    {
      localMessageForTroopFile.bReported = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_appear_AIO", 0, 0, "", paramChatMessage.frienduin, "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileItemBuilder", 4, "Build TroopFileItem");
      }
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileItemBuilder", 4, "get fileStatusInfo fail ");
      }
      return;
    }
    paramvgs.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    paramvgs.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
    paramvgs.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopFileStatusInfo.g);
    boolean bool2 = false;
    int m = 0;
    int n = 0;
    int i1 = 0;
    Object localObject = "";
    boolean bool1;
    int k;
    int j;
    int i;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      bool1 = bool2;
      k = m;
      j = n;
      i = i1;
      label244:
      if (k != 0)
      {
        paramvgs.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(j);
        paramvgs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if (i == 0) {
          break label961;
        }
        paramvgs.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramvgs.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramvgs.jdField_b_of_type_AndroidWidgetTextView.setText(FileUtil.a(localTroopFileStatusInfo.jdField_b_of_type_Long));
        paramBaseChatItemLayout.setFailedIconVisable(bool1, this);
        paramBaseChatItemLayout = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
        if (localTroopFileStatusInfo.jdField_b_of_type_JavaLangString != null) {
          break label999;
        }
        FileManagerUtil.a(paramvgs.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.g);
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID == null) {
          break label973;
        }
        paramBaseChatItemLayout.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 128);
      }
      label266:
      label288:
      break;
    }
    while (FontSettingManager.a() > 17.0F)
    {
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramvgs.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramvgs.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label1063;
      }
      paramvgs.jdField_b_of_type_AndroidWidgetTextView.setGravity(5);
      paramBaseChatItemLayout.addRule(3, 2131361962);
      paramBaseChatItemLayout.addRule(2, 2131361964);
      paramBaseChatItemLayout.addRule(7, 2131361962);
      return;
      k = 1;
      j = 0;
      localObject = "上传中";
      i = 1;
      bool1 = bool2;
      break label244;
      String str = "未下载";
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (localMessageForTroopFile.msgtype != -2017) {
        break label244;
      }
      if (localMessageForTroopFile.extraflag != 32772)
      {
        localObject = str;
        i = i1;
        j = n;
        k = m;
        bool1 = bool2;
        if (localMessageForTroopFile.extraflag != 32768) {
          break label244;
        }
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!localMessageForTroopFile.isSendFromLocal()) {
        break label244;
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!TextUtils.isEmpty(localMessageForTroopFile.FromUin)) {
        break label244;
      }
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      if (!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString)) {
        break label244;
      }
      e(paramChatMessage);
      localObject = str;
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label244;
      localObject = "未下载";
      e(paramChatMessage);
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label244;
      localObject = "上传中";
      i = 1;
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.jdField_c_of_type_Long, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break label244;
      localObject = "下载中";
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.jdField_c_of_type_Long, localTroopFileStatusInfo.jdField_b_of_type_Long);
      i = i1;
      bool1 = bool2;
      break label244;
      i = 1;
      localObject = "已暂停";
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.jdField_c_of_type_Long, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break label244;
      i = 1;
      localObject = "已暂停";
      k = 1;
      j = TroopFileUtils.a(localTroopFileStatusInfo.jdField_c_of_type_Long, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break label244;
      localObject = "已上传";
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label244;
      localObject = "已下载";
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label244;
      localObject = "失败";
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break label244;
      localObject = "失败";
      bool1 = true;
      i = i1;
      j = n;
      k = m;
      break label244;
      localObject = "已取消";
      i = i1;
      j = n;
      k = m;
      bool1 = bool2;
      break label244;
      localObject = "转发中";
      i = 1;
      j = n;
      k = m;
      bool1 = bool2;
      break label244;
      paramvgs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label266;
      label961:
      paramvgs.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label288;
      label973:
      paramBaseChatItemLayout.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_e_of_type_Int, 128);
      continue;
      label999:
      if ((TextUtils.isEmpty(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)) || (!FileUtils.a(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)))
      {
        FileManagerUtil.a(paramvgs.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.g);
      }
      else
      {
        FileManagerUtil.a(paramvgs.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.g);
        paramvgs.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString);
      }
    }
    label1063:
    paramvgs.jdField_b_of_type_AndroidWidgetTextView.setGravity(3);
    paramBaseChatItemLayout.addRule(3, -1);
    paramBaseChatItemLayout.addRule(2, -1);
    paramBaseChatItemLayout.addRule(12);
    paramBaseChatItemLayout.addRule(5, 2131361962);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    boolean bool1 = b(paramChatMessage);
    boolean bool2 = d(paramChatMessage);
    if ((!bool1) && (!bool2))
    {
      if (paramChatMessage.isSend()) {
        paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845661);
      }
    }
    else {
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845497);
  }
  
  public void a(vgs paramvgs, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    if (paramvgs.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramvgs.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130840623);
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492968));
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setText(2131430830);
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131361877);
      localLayoutParams.addRule(5, 2131361877);
      localLayoutParams.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558619) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.addView(paramvgs.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    if (paramChatMessage.isSend())
    {
      paramvgs.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    paramvgs.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    paramView = (MessageForTroopFile)localChatMessage;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (localTroopFileStatusInfo == null)
    {
      localQQCustomMenu.a(2131375376, this.jdField_a_of_type_AndroidContentContext.getString(2131429758), 2130838306);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
      return localQQCustomMenu.a();
    }
    Boolean localBoolean = Boolean.valueOf(false);
    paramView = localBoolean;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      paramView = localBoolean;
    case 4: 
    case 5: 
    case 12: 
      if (paramView.booleanValue()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131375366, this.jdField_a_of_type_AndroidContentContext.getString(2131429749), 2130838311);
      localQQCustomMenu.a(2131375370, this.jdField_a_of_type_AndroidContentContext.getString(2131429752));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131375368, this.jdField_a_of_type_AndroidContentContext.getString(2131429756), 2130838313);
      localQQCustomMenu.a(2131375370, this.jdField_a_of_type_AndroidContentContext.getString(2131429752), 2130838297);
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131375374, this.jdField_a_of_type_AndroidContentContext.getString(2131429756), 2130838319);
      localQQCustomMenu.a(2131375370, this.jdField_a_of_type_AndroidContentContext.getString(2131429752), 2130838297);
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131375365, this.jdField_a_of_type_AndroidContentContext.getString(2131429749), 2130838311);
      localQQCustomMenu.a(2131375371, this.jdField_a_of_type_AndroidContentContext.getString(2131429753), 2130838309);
      a(localChatMessage, localQQCustomMenu);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131375377, this.jdField_a_of_type_AndroidContentContext.getString(2131429759), 2130838308);
      }
      if ((localChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localChatMessage))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localChatMessage);
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131375372, this.jdField_a_of_type_AndroidContentContext.getString(2131429754));
      }
      localQQCustomMenu.a(2131375346, this.jdField_a_of_type_AndroidContentContext.getString(2131433744), 2130838316);
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131375367, this.jdField_a_of_type_AndroidContentContext.getString(2131429750), 2130838306);
      localQQCustomMenu.a(2131375369, this.jdField_a_of_type_AndroidContentContext.getString(2131429751), 2130838297);
      localQQCustomMenu.a(2131375371, this.jdField_a_of_type_AndroidContentContext.getString(2131429753), 2130838309);
      a(localChatMessage, localQQCustomMenu);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131375377, this.jdField_a_of_type_AndroidContentContext.getString(2131429759), 2130838308);
      }
      if ((localChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localChatMessage))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localChatMessage);
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131375372, this.jdField_a_of_type_AndroidContentContext.getString(2131429754));
      }
      localQQCustomMenu.a(2131375346, this.jdField_a_of_type_AndroidContentContext.getString(2131433744), 2130838316);
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131375375, this.jdField_a_of_type_AndroidContentContext.getString(2131429757), 2130838313);
      localQQCustomMenu.a(2131375369, this.jdField_a_of_type_AndroidContentContext.getString(2131429751), 2130838297);
      a(localChatMessage, localQQCustomMenu);
      if ((localChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localChatMessage))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localChatMessage);
      }
      localQQCustomMenu.a(2131375346, this.jdField_a_of_type_AndroidContentContext.getString(2131433744), 2130838316);
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131375371, this.jdField_a_of_type_AndroidContentContext.getString(2131429753), 2130838309);
      a(localQQCustomMenu, localTroopFileStatusInfo, false);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131375377, this.jdField_a_of_type_AndroidContentContext.getString(2131429759), 2130838308);
      }
      if ((localChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localChatMessage))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localChatMessage);
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131375372, this.jdField_a_of_type_AndroidContentContext.getString(2131429754));
      }
      if (AIOUtils.a(2) == 1) {
        localQQCustomMenu.a(2131375363, this.jdField_a_of_type_AndroidContentContext.getString(2131427571));
      }
      a(localChatMessage, localQQCustomMenu);
      localQQCustomMenu.a(2131375346, this.jdField_a_of_type_AndroidContentContext.getString(2131433744), 2130838316);
      paramView = Boolean.valueOf(true);
      break;
      if (!FileUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(localChatMessage.frienduin)).b();
        paramView = localBoolean;
        break;
      }
      if ((!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (FileUtils.e(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) {
        localQQCustomMenu.a(2131375373, this.jdField_a_of_type_AndroidContentContext.getString(2131429755));
      }
      localQQCustomMenu.a(2131375371, this.jdField_a_of_type_AndroidContentContext.getString(2131429753), 2130838309);
      a(localChatMessage, localQQCustomMenu);
      a(localQQCustomMenu, localTroopFileStatusInfo, false);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131375377, this.jdField_a_of_type_AndroidContentContext.getString(2131429759), 2130838308);
      }
      if ((localChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localChatMessage))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localChatMessage);
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131375372, this.jdField_a_of_type_AndroidContentContext.getString(2131429754));
      }
      if (AIOUtils.a(2) == 1) {
        localQQCustomMenu.a(2131375363, this.jdField_a_of_type_AndroidContentContext.getString(2131427571));
      }
      localQQCustomMenu.a(2131375346, this.jdField_a_of_type_AndroidContentContext.getString(2131433744), 2130838316);
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131375376, this.jdField_a_of_type_AndroidContentContext.getString(2131429758), 2130838306);
      localQQCustomMenu.a(2131375371, this.jdField_a_of_type_AndroidContentContext.getString(2131429753), 2130838309);
      a(localChatMessage, localQQCustomMenu);
      a(localQQCustomMenu, localTroopFileStatusInfo, false);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131375377, this.jdField_a_of_type_AndroidContentContext.getString(2131429759), 2130838308);
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131375372, this.jdField_a_of_type_AndroidContentContext.getString(2131429754));
      }
      if ((localChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localChatMessage))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localChatMessage);
      }
      localQQCustomMenu.a(2131375346, this.jdField_a_of_type_AndroidContentContext.getString(2131433744), 2130838316);
      paramView = localBoolean;
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
    }
  }
  
  void b(View paramView, boolean paramBoolean)
  {
    Context localContext = paramView.getContext();
    Activity localActivity = (Activity)localContext;
    Intent localIntent = new Intent();
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)localChatMessage;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, localChatMessage.frienduin + "", "", "", "");
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo.jdField_b_of_type_Int == 12)
    {
      TroopFileError.a(localActivity, String.format(localActivity.getString(2131429799), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.g) }), 1);
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(localChatMessage.frienduin));
    boolean bool = c(localChatMessage);
    if (localTroopFileStatusInfo.jdField_b_of_type_Boolean)
    {
      if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131430281, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        return;
      }
      if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID == null) {
        break label414;
      }
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      if (localItem != null)
      {
        localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 383);
        localItem.ThumbnailDownloading_Middle_Fail = false;
        localItem.ThumbnailFileTimeMS_Middle = 0L;
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(localItem.getInfo(Long.parseLong(localChatMessage.frienduin)));
      }
    }
    while (!bool) {
      switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 0: 
      case 3: 
        if ((!paramBoolean) && (bool)) {
          break label490;
        }
        localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, localChatMessage.frienduin);
        TroopFileProxyActivity.b(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return;
        label414:
        localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_e_of_type_Int, 383);
      }
    }
    if (!bool)
    {
      localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, localChatMessage.frienduin);
      TroopFileProxyActivity.b(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    a(localContext, paramView.findViewById(2131363543), localMessageForTroopFile);
    return;
    label490:
    a(localContext, paramView.findViewById(2131363543), localMessageForTroopFile);
    return;
    if (!bool)
    {
      new TroopFileItemOperation(Long.valueOf(localMessageForTroopFile.frienduin).longValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localActivity).a(localTroopFileStatusInfo, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime, 3);
      return;
    }
    a(localContext, paramView.findViewById(2131363543), localMessageForTroopFile);
  }
  
  public void e(ChatMessage paramChatMessage)
  {
    ThreadManager.post(new vgp(this, paramChatMessage), 8, null, true);
  }
  
  public void f(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      return;
      localObject = AIOUtils.a(paramView);
      if (localObject == null)
      {
        QLog.w("TroopFileItemBuilder", 1, "item click holder tag is null");
        return;
      }
      if (!vgs.class.isInstance(localObject))
      {
        QLog.e("TroopFileItemBuilder", 1, "item click holder tag class[" + localObject.getClass().getName() + "] is not Holder");
        return;
      }
      localObject = (MessageForTroopFile)((vgs)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while ((b((ChatMessage)localObject)) || (d((ChatMessage)localObject)));
    b(paramView, false);
    AIOUtils.m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */