package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.portal.BaseAnimHolder;
import com.tencent.mobileqq.portal.ImageSwitchAnim;
import com.tencent.mobileqq.portal.ImageSwitchAnimView;
import com.tencent.mobileqq.portal.SaQianView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;

public class SpringNomalPendantHolder
  extends ConversationActivePendantHolderBase
{
  public int a;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  BaseAnimHolder jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  ImageSwitchAnim jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
  ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = null;
  public SaQianView a;
  int jdField_b_of_type_Int;
  BaseAnimHolder jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  BaseAnimHolder jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  private int o = 0;
  
  public SpringNomalPendantHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView = new SaQianView(paramView.getContext(), 0, 0, paramView);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
    if (QLog.isColorLevel()) {
      QLog.d("SpringNomalPendantHolder", 2, "SpringNomalPendantHolder mContext = " + this.jdField_a_of_type_AndroidContentContext + ",parentView.getContext() = " + paramView.getContext());
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = new ImageSwitchAnimView(paramView.getContext());
  }
  
  public RectF a(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder != null)
    {
      float f = this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j - f, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k - f + this.g, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l + f, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.m + f + this.g);
      if (QLog.isColorLevel()) {
        QLog.d("SpringNomalPendantHolder", 2, "getCloseBtnTouchRect debug click event, span = " + f + ", closeBtnHolder.x = " + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j + ", closeBtnHolder.y = " + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k + ", closeBtnHolder.width = " + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l + ", closeBtnHolder.height = " + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.m + ", offsetY = " + this.g + ", listViewScrollY = " + paramInt + ", closeBtnTouchRect = " + this.jdField_a_of_type_AndroidGraphicsRectF);
      }
      return this.jdField_a_of_type_AndroidGraphicsRectF;
    }
    return null;
  }
  
  public void a()
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.07F), new SpringNomalPendantHolder.1(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.b();
  }
  
  public void a(int paramInt)
  {
    float f1 = 1.0F * paramInt / this.jdField_c_of_type_Int;
    float f2 = this.jdField_b_of_type_Int - this.jdField_c_of_type_Int;
    this.k = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.m = ((int)(f1 * f2) + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.d = paramInt;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.k = (this.m + paramInt + this.o);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView != null)
    {
      paramInt = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298322);
      this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramInt + this.j + this.l / 2, this.k);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.d = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
    paramInt2 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298327);
    this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298326));
    paramInt3 = this.l / 2;
    paramInt4 = paramInt2 / 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845565);
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramInt3 + paramInt1 - paramInt4, 0, paramInt2, this.jdField_b_of_type_Int, paramView);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpringNomalPendantHolder", 2, "updatePendantLogo ,pendantLogoBitmap = " + paramBitmap + ",switchAnim = " + this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.b(paramBitmap);
    }
  }
  
  /* Error */
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 65
    //   8: iconst_2
    //   9: new 67	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   16: ldc 239
    //   18: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc 241
    //   27: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_2
    //   31: invokevirtual 244	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   44: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   47: ldc 249
    //   49: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   52: f2i
    //   53: istore 8
    //   55: aload_0
    //   56: getfield 250	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   59: ifnonnull +40 -> 99
    //   62: aload_0
    //   63: new 252	android/graphics/drawable/BitmapDrawable
    //   66: dup
    //   67: aload_0
    //   68: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   71: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   74: aload_0
    //   75: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   78: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   81: ldc 253
    //   83: invokestatic 259	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   86: getstatic 265	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   89: iconst_1
    //   90: invokevirtual 271	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   93: invokespecial 274	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   96: putfield 250	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   99: aload_0
    //   100: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   103: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   106: ldc_w 275
    //   109: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   112: f2i
    //   113: istore 9
    //   115: aload_0
    //   116: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   119: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   122: ldc_w 276
    //   125: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   128: f2i
    //   129: istore 11
    //   131: aload_0
    //   132: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   135: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   138: ldc_w 277
    //   141: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   144: f2i
    //   145: istore 10
    //   147: invokestatic 281	com/tencent/mobileqq/utils/ViewUtils:a	()I
    //   150: iload 9
    //   152: isub
    //   153: iload 11
    //   155: isub
    //   156: istore 11
    //   158: aload_0
    //   159: iload 10
    //   161: putfield 179	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_c_of_type_Int	I
    //   164: aload_1
    //   165: astore 12
    //   167: aload_1
    //   168: ifnonnull +32 -> 200
    //   171: aload_0
    //   172: getfield 32	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_Int	I
    //   175: iconst_1
    //   176: if_icmpne +567 -> 743
    //   179: aload_0
    //   180: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   183: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   186: ldc_w 282
    //   189: invokestatic 259	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   192: astore 12
    //   194: aload 12
    //   196: astore_1
    //   197: aload_1
    //   198: astore 12
    //   200: aload_0
    //   201: getfield 32	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_Int	I
    //   204: iconst_1
    //   205: if_icmpne +572 -> 777
    //   208: aload_0
    //   209: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   212: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   215: ldc_w 283
    //   218: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   221: fstore 6
    //   223: aload 12
    //   225: invokevirtual 284	android/graphics/Bitmap:getHeight	()I
    //   228: i2f
    //   229: fload 6
    //   231: fmul
    //   232: aload 12
    //   234: invokevirtual 285	android/graphics/Bitmap:getWidth	()I
    //   237: i2f
    //   238: fdiv
    //   239: fstore 5
    //   241: iload 8
    //   243: i2f
    //   244: fstore 4
    //   246: aload_0
    //   247: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   250: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   253: ldc_w 286
    //   256: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   259: fstore 7
    //   261: aload_0
    //   262: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   265: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   268: ldc_w 287
    //   271: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   274: fstore_3
    //   275: fload 4
    //   277: fload 5
    //   279: fsub
    //   280: fload 7
    //   282: fsub
    //   283: fstore 7
    //   285: fload_3
    //   286: fstore 4
    //   288: fload 7
    //   290: fstore_3
    //   291: aload_0
    //   292: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   295: ifnonnull +99 -> 394
    //   298: aload_0
    //   299: new 188	com/tencent/mobileqq/portal/ImageSwitchAnim
    //   302: dup
    //   303: aload_0
    //   304: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   307: iload 9
    //   309: iload 8
    //   311: iload 11
    //   313: iload 10
    //   315: fload 4
    //   317: f2i
    //   318: fload_3
    //   319: f2i
    //   320: fload 6
    //   322: f2i
    //   323: fload 5
    //   325: f2i
    //   326: invokespecial 290	com/tencent/mobileqq/portal/ImageSwitchAnim:<init>	(Landroid/content/Context;IIIIIIII)V
    //   329: putfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   332: aload_0
    //   333: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   336: aload_0
    //   337: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   340: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   343: ldc_w 291
    //   346: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   349: f2i
    //   350: putfield 294	com/tencent/mobileqq/portal/ImageSwitchAnim:i	I
    //   353: aload_0
    //   354: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   357: aload_0
    //   358: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   361: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   364: ldc_w 295
    //   367: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   370: f2i
    //   371: putfield 296	com/tencent/mobileqq/portal/ImageSwitchAnim:j	I
    //   374: aload_0
    //   375: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   378: aload_0
    //   379: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   382: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   385: ldc_w 297
    //   388: invokestatic 259	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   391: invokevirtual 299	com/tencent/mobileqq/portal/ImageSwitchAnim:c	(Landroid/graphics/Bitmap;)V
    //   394: aload_0
    //   395: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   398: fload 4
    //   400: f2i
    //   401: putfield 302	com/tencent/mobileqq/portal/ImageSwitchAnim:e	I
    //   404: aload_0
    //   405: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   408: fload_3
    //   409: f2i
    //   410: putfield 305	com/tencent/mobileqq/portal/ImageSwitchAnim:f	I
    //   413: aload_0
    //   414: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   417: fload 6
    //   419: f2i
    //   420: putfield 306	com/tencent/mobileqq/portal/ImageSwitchAnim:g	I
    //   423: aload_0
    //   424: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   427: fload 5
    //   429: f2i
    //   430: putfield 309	com/tencent/mobileqq/portal/ImageSwitchAnim:h	I
    //   433: aload_0
    //   434: getfield 32	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_Int	I
    //   437: iconst_1
    //   438: if_icmpne +411 -> 849
    //   441: aload_0
    //   442: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   445: aload_0
    //   446: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   449: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   452: ldc_w 310
    //   455: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   458: f2i
    //   459: putfield 311	com/tencent/mobileqq/portal/ImageSwitchAnim:k	I
    //   462: aload_0
    //   463: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   466: aload_0
    //   467: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   470: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   473: ldc_w 312
    //   476: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   479: f2i
    //   480: putfield 313	com/tencent/mobileqq/portal/ImageSwitchAnim:l	I
    //   483: aload_0
    //   484: getfield 32	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_Int	I
    //   487: iconst_3
    //   488: if_icmpne +393 -> 881
    //   491: aload_0
    //   492: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   495: aload 12
    //   497: invokevirtual 315	com/tencent/mobileqq/portal/ImageSwitchAnim:a	(Landroid/graphics/Bitmap;)V
    //   500: aload_0
    //   501: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   504: invokevirtual 317	com/tencent/mobileqq/portal/ImageSwitchAnim:a	()V
    //   507: aload_0
    //   508: iload 11
    //   510: iload 10
    //   512: iload 9
    //   514: iload 8
    //   516: aload_0
    //   517: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   520: invokevirtual 318	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:a	(IIIILandroid/view/View;)V
    //   523: aload_0
    //   524: aconst_null
    //   525: putfield 192	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   528: iload_2
    //   529: ifeq +364 -> 893
    //   532: aload_0
    //   533: new 101	com/tencent/mobileqq/portal/BaseAnimHolder
    //   536: dup
    //   537: invokespecial 216	com/tencent/mobileqq/portal/BaseAnimHolder:<init>	()V
    //   540: putfield 99	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   543: aload_0
    //   544: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   547: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   550: ldc_w 319
    //   553: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   556: f2i
    //   557: istore 8
    //   559: aload_0
    //   560: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   563: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   566: ldc_w 320
    //   569: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   572: f2i
    //   573: istore 9
    //   575: aload_0
    //   576: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   579: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   582: ldc_w 321
    //   585: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   588: f2i
    //   589: istore 11
    //   591: aload_0
    //   592: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   595: invokevirtual 51	android/view/View:getWidth	()I
    //   598: iload 11
    //   600: isub
    //   601: iload 8
    //   603: isub
    //   604: istore 10
    //   606: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq +68 -> 677
    //   612: ldc 65
    //   614: iconst_2
    //   615: new 67	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   622: ldc_w 323
    //   625: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: aload_0
    //   629: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   632: invokevirtual 51	android/view/View:getWidth	()I
    //   635: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   638: ldc_w 325
    //   641: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: iload 11
    //   646: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   649: ldc_w 327
    //   652: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: iload 8
    //   657: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   660: ldc_w 329
    //   663: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 10
    //   668: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   671: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_0
    //   678: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   681: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   684: ldc_w 330
    //   687: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   690: f2i
    //   691: istore 11
    //   693: aload_0
    //   694: getfield 99	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   697: aload_0
    //   698: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   701: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   704: ldc_w 331
    //   707: invokevirtual 223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   710: putfield 226	com/tencent/mobileqq/portal/BaseAnimHolder:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   713: aload_0
    //   714: getfield 99	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   717: iload 10
    //   719: iload 11
    //   721: iload 8
    //   723: iload 9
    //   725: aload_0
    //   726: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   729: invokevirtual 227	com/tencent/mobileqq/portal/BaseAnimHolder:a	(IIIILandroid/view/View;)V
    //   732: aload_0
    //   733: invokevirtual 333	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:d	()V
    //   736: return
    //   737: astore_1
    //   738: aload_1
    //   739: invokevirtual 336	java/lang/OutOfMemoryError:printStackTrace	()V
    //   742: return
    //   743: aload_0
    //   744: getfield 77	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   747: invokevirtual 199	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   750: ldc_w 337
    //   753: invokestatic 259	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   756: astore 12
    //   758: aload 12
    //   760: astore_1
    //   761: goto -564 -> 197
    //   764: astore 12
    //   766: aload 12
    //   768: invokevirtual 336	java/lang/OutOfMemoryError:printStackTrace	()V
    //   771: aload_1
    //   772: astore 12
    //   774: goto -574 -> 200
    //   777: aload_0
    //   778: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   781: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   784: ldc_w 338
    //   787: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   790: fstore_3
    //   791: iload 8
    //   793: i2f
    //   794: fstore 5
    //   796: aload_0
    //   797: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   800: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   803: ldc_w 339
    //   806: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   809: fstore 6
    //   811: iload 9
    //   813: i2f
    //   814: fload_3
    //   815: fsub
    //   816: fconst_2
    //   817: fdiv
    //   818: fstore 4
    //   820: fload 5
    //   822: fload_3
    //   823: fsub
    //   824: fload 6
    //   826: fsub
    //   827: fstore 7
    //   829: fload_3
    //   830: fstore 5
    //   832: fload_3
    //   833: fstore 6
    //   835: fload 7
    //   837: fstore_3
    //   838: goto -547 -> 291
    //   841: astore_1
    //   842: aload_1
    //   843: invokevirtual 336	java/lang/OutOfMemoryError:printStackTrace	()V
    //   846: goto -452 -> 394
    //   849: aload_0
    //   850: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   853: aload_0
    //   854: getfield 247	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   857: invokevirtual 248	android/view/View:getResources	()Landroid/content/res/Resources;
    //   860: ldc_w 340
    //   863: invokevirtual 206	android/content/res/Resources:getDimension	(I)F
    //   866: f2i
    //   867: putfield 311	com/tencent/mobileqq/portal/ImageSwitchAnim:k	I
    //   870: aload_0
    //   871: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   874: iconst_0
    //   875: putfield 313	com/tencent/mobileqq/portal/ImageSwitchAnim:l	I
    //   878: goto -395 -> 483
    //   881: aload_0
    //   882: getfield 186	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim	Lcom/tencent/mobileqq/portal/ImageSwitchAnim;
    //   885: aload 12
    //   887: invokevirtual 234	com/tencent/mobileqq/portal/ImageSwitchAnim:b	(Landroid/graphics/Bitmap;)V
    //   890: goto -383 -> 507
    //   893: aload_0
    //   894: aconst_null
    //   895: putfield 99	com/tencent/mobileqq/activity/springfestival/entry/ui/SpringNomalPendantHolder:jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder	Lcom/tencent/mobileqq/portal/BaseAnimHolder;
    //   898: goto -166 -> 732
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	this	SpringNomalPendantHolder
    //   0	901	1	paramBitmap	Bitmap
    //   0	901	2	paramBoolean	boolean
    //   274	564	3	f1	float
    //   244	575	4	f2	float
    //   239	592	5	f3	float
    //   221	613	6	f4	float
    //   259	577	7	f5	float
    //   53	739	8	i	int
    //   113	699	9	j	int
    //   145	573	10	k	int
    //   129	591	11	m	int
    //   165	594	12	localBitmap1	Bitmap
    //   764	3	12	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   772	114	12	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   40	99	737	java/lang/OutOfMemoryError
    //   171	194	764	java/lang/OutOfMemoryError
    //   743	758	764	java/lang/OutOfMemoryError
    //   374	394	841	java/lang/OutOfMemoryError
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool2 = false;
    boolean bool3 = super.b();
    d();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.g);
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.n != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.n = this.n;
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    super.c(paramCanvas);
    if (this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.a(paramCanvas);; bool1 = false)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.n != 0))
      {
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.n = this.n;
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramCanvas);
      paramCanvas.restore();
      if ((this.jdField_a_of_type_Boolean) || (bool3) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.b = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.a = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringNomalPendantHolder
 * JD-Core Version:    0.7.0.1
 */