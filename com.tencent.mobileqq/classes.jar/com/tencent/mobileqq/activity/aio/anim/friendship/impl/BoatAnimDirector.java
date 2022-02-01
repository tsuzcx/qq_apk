package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.BaseDirector;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton.OnClickListener;

public class BoatAnimDirector
  extends BaseDirector
{
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  FriendShipWaveView jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView;
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = new BoatAnimDirector.3(this);
  String jdField_a_of_type_JavaLangString = "aio_ship_ship.png";
  boolean jdField_a_of_type_Boolean = false;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  String jdField_b_of_type_JavaLangString = "aio_ship_banner.png";
  boolean jdField_b_of_type_Boolean = false;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  String jdField_c_of_type_JavaLangString = "aio_ship_blink.png";
  Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  String jdField_d_of_type_JavaLangString = "aio_ship_close.png";
  Bitmap jdField_e_of_type_AndroidGraphicsBitmap;
  String jdField_e_of_type_JavaLangString = "aio_ship_star1.png";
  Bitmap jdField_f_of_type_AndroidGraphicsBitmap;
  String jdField_f_of_type_JavaLangString = "aio_ship_star2.png";
  Bitmap jdField_g_of_type_AndroidGraphicsBitmap;
  String jdField_g_of_type_JavaLangString = "aio_ship_star3.png";
  Bitmap jdField_h_of_type_AndroidGraphicsBitmap;
  String jdField_h_of_type_JavaLangString = "aio_ship_star4.png";
  Bitmap jdField_i_of_type_AndroidGraphicsBitmap;
  String jdField_i_of_type_JavaLangString = "aio_ship_wave1.png";
  Bitmap jdField_j_of_type_AndroidGraphicsBitmap;
  String jdField_j_of_type_JavaLangString = "aio_ship_wave2.png";
  Bitmap jdField_k_of_type_AndroidGraphicsBitmap;
  String jdField_k_of_type_JavaLangString = "aio_ship_wave3.png";
  Bitmap jdField_l_of_type_AndroidGraphicsBitmap;
  String jdField_l_of_type_JavaLangString = "aio_ship_wording.png";
  
  public BoatAnimDirector(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    FriendShipWaveView localFriendShipWaveView = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView;
    if (localFriendShipWaveView != null)
    {
      localFriendShipWaveView.a(paramInt1, paramInt2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsBitmap, this.jdField_e_of_type_AndroidGraphicsBitmap, this.jdField_f_of_type_AndroidGraphicsBitmap, this.jdField_g_of_type_AndroidGraphicsBitmap, this.jdField_h_of_type_AndroidGraphicsBitmap, this.jdField_i_of_type_AndroidGraphicsBitmap, this.jdField_j_of_type_AndroidGraphicsBitmap, this.jdField_k_of_type_AndroidGraphicsBitmap, this.jdField_l_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.a();
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a()
  {
    super.a();
    if (!this.jdField_b_of_type_Boolean)
    {
      FriendShipLayout localFriendShipLayout = a();
      if (localFriendShipLayout != null)
      {
        if (localFriendShipLayout.getChildCount() > 0) {
          localFriendShipLayout.removeAllViews();
        }
        a(0);
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView = new FriendShipWaveView(this.jdField_a_of_type_AndroidContentContext, null);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        localFriendShipLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        localFriendShipLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView);
        a(ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X8007777", "0X8007777", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.postDelayed(new BoatAnimDirector.2(this), 1000L);
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  public void a(com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.IDirector.OnDirectorPrepared paramOnDirectorPrepared)
  {
    // Byte code:
    //   0: invokestatic 206	com/tencent/mobileqq/mutualmark/oldlogic/HotReactiveHelper:b	()Ljava/lang/String;
    //   3: astore_2
    //   4: aload_2
    //   5: invokestatic 212	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   8: ifeq +611 -> 619
    //   11: new 214	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 216	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: iconst_1
    //   21: putfield 219	android/graphics/BitmapFactory$Options:inScaled	Z
    //   24: aload_3
    //   25: sipush 320
    //   28: putfield 222	android/graphics/BitmapFactory$Options:inDensity	I
    //   31: aload_3
    //   32: aload_0
    //   33: getfield 89	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   36: invokevirtual 228	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   39: invokevirtual 234	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   42: getfield 239	android/util/DisplayMetrics:densityDpi	I
    //   45: putfield 242	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   48: new 244	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: aload_2
    //   60: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 4
    //   66: aload_0
    //   67: getfield 32	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   70: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_0
    //   75: aload 4
    //   77: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: aload_3
    //   81: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   84: putfield 95	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   87: new 244	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   94: astore 4
    //   96: aload 4
    //   98: aload_2
    //   99: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 4
    //   105: aload_0
    //   106: getfield 36	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   109: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_0
    //   114: aload 4
    //   116: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: aload_3
    //   120: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   123: putfield 97	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   126: new 244	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   133: astore 4
    //   135: aload 4
    //   137: aload_2
    //   138: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 4
    //   144: aload_0
    //   145: getfield 40	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   148: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_0
    //   153: aload 4
    //   155: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: aload_3
    //   159: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   162: putfield 99	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   165: new 244	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   172: astore 4
    //   174: aload 4
    //   176: aload_2
    //   177: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: aload_0
    //   184: getfield 44	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   187: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_0
    //   192: aload 4
    //   194: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: aload_3
    //   198: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   201: putfield 101	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   204: new 244	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   211: astore 4
    //   213: aload 4
    //   215: aload_2
    //   216: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 4
    //   222: aload_0
    //   223: getfield 48	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   226: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_0
    //   231: aload 4
    //   233: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: aload_3
    //   237: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   240: putfield 103	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_e_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   243: new 244	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   250: astore 4
    //   252: aload 4
    //   254: aload_2
    //   255: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 4
    //   261: aload_0
    //   262: getfield 52	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   265: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: aload 4
    //   272: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: aload_3
    //   276: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   279: putfield 105	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_f_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   282: new 244	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   289: astore 4
    //   291: aload 4
    //   293: aload_2
    //   294: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 4
    //   300: aload_0
    //   301: getfield 56	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   304: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_0
    //   309: aload 4
    //   311: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: aload_3
    //   315: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   318: putfield 107	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_g_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   321: new 244	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   328: astore 4
    //   330: aload 4
    //   332: aload_2
    //   333: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 4
    //   339: aload_0
    //   340: getfield 60	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   343: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_0
    //   348: aload 4
    //   350: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: aload_3
    //   354: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   357: putfield 109	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_h_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   360: new 244	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   367: astore 4
    //   369: aload 4
    //   371: aload_2
    //   372: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 4
    //   378: aload_0
    //   379: getfield 64	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   382: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_0
    //   387: aload 4
    //   389: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: aload_3
    //   393: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   396: putfield 111	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_i_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   399: new 244	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   406: astore 4
    //   408: aload 4
    //   410: aload_2
    //   411: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 4
    //   417: aload_0
    //   418: getfield 68	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   421: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_0
    //   426: aload 4
    //   428: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: aload_3
    //   432: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   435: putfield 113	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_j_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   438: new 244	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   445: astore 4
    //   447: aload 4
    //   449: aload_2
    //   450: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 4
    //   456: aload_0
    //   457: getfield 72	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   460: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload_0
    //   465: aload 4
    //   467: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: aload_3
    //   471: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   474: putfield 115	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_k_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   477: new 244	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   484: astore 4
    //   486: aload 4
    //   488: aload_2
    //   489: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 4
    //   495: aload_0
    //   496: getfield 76	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   499: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload_0
    //   504: aload 4
    //   506: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: aload_3
    //   510: invokestatic 257	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   513: putfield 117	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_l_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   516: aload_0
    //   517: getfield 95	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   520: ifnull +46 -> 566
    //   523: aload_0
    //   524: getfield 97	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   527: ifnull +39 -> 566
    //   530: aload_0
    //   531: getfield 101	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   534: ifnull +32 -> 566
    //   537: aload_0
    //   538: getfield 111	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_i_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   541: ifnull +25 -> 566
    //   544: aload_0
    //   545: getfield 113	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_j_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   548: ifnull +18 -> 566
    //   551: aload_0
    //   552: getfield 115	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_k_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   555: ifnull +11 -> 566
    //   558: aload_0
    //   559: iconst_1
    //   560: putfield 78	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_Boolean	Z
    //   563: goto +61 -> 624
    //   566: invokestatic 263	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq +55 -> 624
    //   572: ldc_w 265
    //   575: iconst_2
    //   576: ldc_w 267
    //   579: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: goto +42 -> 624
    //   585: ldc_w 265
    //   588: iconst_2
    //   589: ldc_w 272
    //   592: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: goto +29 -> 624
    //   598: astore_2
    //   599: aload_0
    //   600: iconst_0
    //   601: putfield 78	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_Boolean	Z
    //   604: ldc_w 265
    //   607: iconst_4
    //   608: aload_2
    //   609: iconst_0
    //   610: anewarray 274	java/lang/Object
    //   613: invokestatic 277	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   616: goto +8 -> 624
    //   619: aload_0
    //   620: iconst_0
    //   621: putfield 78	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_Boolean	Z
    //   624: invokestatic 263	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   627: ifeq +39 -> 666
    //   630: new 244	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   637: astore_2
    //   638: aload_2
    //   639: ldc_w 279
    //   642: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload_2
    //   647: aload_0
    //   648: getfield 78	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_Boolean	Z
    //   651: invokevirtual 282	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: ldc_w 265
    //   658: iconst_2
    //   659: aload_2
    //   660: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: aload_0
    //   667: aload_1
    //   668: invokespecial 284	com/tencent/mobileqq/activity/aio/anim/friendship/impl/base/BaseDirector:a	(Lcom/tencent/mobileqq/activity/aio/anim/friendship/impl/base/IDirector$OnDirectorPrepared;)V
    //   671: aload_1
    //   672: aload_0
    //   673: getfield 78	com/tencent/mobileqq/activity/aio/anim/friendship/impl/BoatAnimDirector:jdField_a_of_type_Boolean	Z
    //   676: invokeinterface 289 2 0
    //   681: return
    //   682: astore_2
    //   683: goto -98 -> 585
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	this	BoatAnimDirector
    //   0	686	1	paramOnDirectorPrepared	com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.IDirector.OnDirectorPrepared
    //   3	486	2	str	String
    //   598	11	2	localException	java.lang.Exception
    //   637	23	2	localStringBuilder1	java.lang.StringBuilder
    //   682	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   18	492	3	localOptions	android.graphics.BitmapFactory.Options
    //   55	450	4	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	563	598	java/lang/Exception
    //   566	582	598	java/lang/Exception
    //   11	563	682	java/lang/OutOfMemoryError
    //   566	582	682	java/lang/OutOfMemoryError
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView;
    if (localObject != null)
    {
      ((FriendShipWaveView)localObject).i();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView;
      ((FriendShipWaveView)localObject).postDelayed(new BoatAnimDirector.1(this, (FriendShipWaveView)localObject), 300L);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    super.b();
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      a(4);
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      a(0);
    }
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector
 * JD-Core Version:    0.7.0.1
 */