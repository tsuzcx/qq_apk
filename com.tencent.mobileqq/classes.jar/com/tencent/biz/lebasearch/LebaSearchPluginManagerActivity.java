package com.tencent.biz.lebasearch;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Iterator;
import java.util.List;
import kpu;

public class LebaSearchPluginManagerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static double a;
  static int jdField_a_of_type_Int = 110;
  static double jdField_b_of_type_Double = 0.4D;
  byte jdField_a_of_type_Byte;
  public float a;
  long jdField_a_of_type_Long = -1L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new kpu(this);
  public View a;
  protected Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  protected TextView a;
  public AccountDetailBounceScrollView a;
  public LebaViewItem a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  List jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean = true;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private boolean jdField_b_of_type_Boolean;
  public ImageView c;
  protected TextView c;
  
  static
  {
    jdField_a_of_type_Double = 0.5D;
  }
  
  public LebaSearchPluginManagerActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = null;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc 68
    //   4: invokevirtual 72	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   7: putfield 74	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   10: aload_0
    //   11: aload_0
    //   12: ldc 75
    //   14: invokevirtual 72	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   17: putfield 77	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   20: aload_0
    //   21: getfield 77	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   24: invokevirtual 83	android/view/View:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   27: new 85	kpo
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 86	kpo:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   35: invokevirtual 92	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   38: aload_0
    //   39: getfield 74	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   42: new 94	kpp
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 95	kpp:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   50: invokevirtual 99	android/view/View:addOnLayoutChangeListener	(Landroid/view/View$OnLayoutChangeListener;)V
    //   53: aload_0
    //   54: aload_0
    //   55: ldc 100
    //   57: invokespecial 101	com/tencent/mobileqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   60: checkcast 103	android/widget/LinearLayout
    //   63: putfield 105	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   66: aload_0
    //   67: getfield 77	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   70: invokevirtual 109	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   73: checkcast 111	android/widget/RelativeLayout$LayoutParams
    //   76: aload_0
    //   77: getfield 50	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_Int	I
    //   80: i2d
    //   81: getstatic 34	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Double	D
    //   84: dmul
    //   85: d2i
    //   86: putfield 114	android/widget/RelativeLayout$LayoutParams:height	I
    //   89: aload_0
    //   90: getfield 105	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   93: aload_0
    //   94: getfield 50	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_Int	I
    //   97: aload_0
    //   98: invokevirtual 118	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:getTitleBarHeight	()I
    //   101: isub
    //   102: i2f
    //   103: ldc 119
    //   105: aload_0
    //   106: getfield 121	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Float	F
    //   109: fmul
    //   110: fsub
    //   111: f2i
    //   112: invokevirtual 125	android/widget/LinearLayout:setMinimumHeight	(I)V
    //   115: aload_0
    //   116: aload_0
    //   117: ldc 126
    //   119: invokevirtual 72	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   122: checkcast 128	android/widget/Button
    //   125: putfield 130	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   128: aload_0
    //   129: getfield 130	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   132: aload_0
    //   133: invokevirtual 134	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   136: aload_0
    //   137: aload_0
    //   138: ldc 135
    //   140: invokevirtual 72	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   143: checkcast 137	android/widget/TextView
    //   146: putfield 139	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   149: aload_0
    //   150: aload_0
    //   151: ldc 140
    //   153: invokevirtual 72	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   156: checkcast 142	android/widget/ImageView
    //   159: putfield 144	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   162: aload_0
    //   163: aload_0
    //   164: ldc 145
    //   166: invokespecial 101	com/tencent/mobileqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   169: checkcast 142	android/widget/ImageView
    //   172: putfield 147	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   175: aload_0
    //   176: getfield 147	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   179: ldc 148
    //   181: invokevirtual 151	android/widget/ImageView:setBackgroundResource	(I)V
    //   184: aload_0
    //   185: aload_0
    //   186: ldc 152
    //   188: invokespecial 101	com/tencent/mobileqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   191: checkcast 142	android/widget/ImageView
    //   194: putfield 154	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   197: aload_0
    //   198: aload_0
    //   199: ldc 155
    //   201: invokevirtual 72	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   204: checkcast 137	android/widget/TextView
    //   207: putfield 157	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   210: aload_0
    //   211: aload_0
    //   212: ldc 158
    //   214: invokevirtual 72	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   217: checkcast 137	android/widget/TextView
    //   220: putfield 160	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   223: aload_0
    //   224: getfield 160	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   227: aload_0
    //   228: ldc 161
    //   230: invokevirtual 165	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:getString	(I)Ljava/lang/String;
    //   233: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   236: aload_0
    //   237: getfield 160	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   240: aload_0
    //   241: invokevirtual 170	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   244: aload_0
    //   245: aload_0
    //   246: ldc 171
    //   248: invokespecial 101	com/tencent/mobileqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   251: checkcast 173	com/tencent/biz/pubaccount/AccountDetailBounceScrollView
    //   254: putfield 175	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView	Lcom/tencent/biz/pubaccount/AccountDetailBounceScrollView;
    //   257: aload_0
    //   258: getfield 54	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Boolean	Z
    //   261: ifne +63 -> 324
    //   264: aload_0
    //   265: getfield 144	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   268: invokevirtual 176	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   271: checkcast 111	android/widget/RelativeLayout$LayoutParams
    //   274: astore_2
    //   275: aload_0
    //   276: getfield 147	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   279: invokevirtual 176	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   282: checkcast 111	android/widget/RelativeLayout$LayoutParams
    //   285: astore_3
    //   286: aload_2
    //   287: ifnull +37 -> 324
    //   290: aload_3
    //   291: ifnull +33 -> 324
    //   294: ldc 177
    //   296: aload_0
    //   297: invokevirtual 181	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:getResources	()Landroid/content/res/Resources;
    //   300: invokestatic 186	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   303: istore_1
    //   304: aload_2
    //   305: aload_2
    //   306: getfield 189	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   309: iload_1
    //   310: iadd
    //   311: putfield 189	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   314: aload_3
    //   315: aload_3
    //   316: getfield 189	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   319: iload_1
    //   320: iadd
    //   321: putfield 189	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   324: aload_0
    //   325: getfield 175	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView	Lcom/tencent/biz/pubaccount/AccountDetailBounceScrollView;
    //   328: new 191	kpq
    //   331: dup
    //   332: aload_0
    //   333: invokespecial 192	kpq:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   336: invokevirtual 196	com/tencent/biz/pubaccount/AccountDetailBounceScrollView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   339: aload_0
    //   340: getfield 175	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView	Lcom/tencent/biz/pubaccount/AccountDetailBounceScrollView;
    //   343: new 198	kps
    //   346: dup
    //   347: aload_0
    //   348: invokespecial 199	kps:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   351: invokevirtual 203	com/tencent/biz/pubaccount/AccountDetailBounceScrollView:setOnScrollChangedListener	(Lcom/tencent/mobileqq/widget/BounceScrollView$OnScrollChangedListener;)V
    //   354: aload_0
    //   355: getfield 52	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem	Lcom/tencent/mobileqq/config/struct/LebaViewItem;
    //   358: getfield 208	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   361: astore_3
    //   362: aload_3
    //   363: getfield 214	com/tencent/mobileqq/data/ResourcePluginInfo:strNewPluginDesc	Ljava/lang/String;
    //   366: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   369: ifne +14 -> 383
    //   372: aload_0
    //   373: getfield 139	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   376: aload_3
    //   377: getfield 214	com/tencent/mobileqq/data/ResourcePluginInfo:strNewPluginDesc	Ljava/lang/String;
    //   380: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   383: aload_0
    //   384: getfield 222	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   387: ifnonnull +177 -> 564
    //   390: aconst_null
    //   391: astore_2
    //   392: aload_3
    //   393: getfield 225	com/tencent/mobileqq/data/ResourcePluginInfo:strNewPluginURL	Ljava/lang/String;
    //   396: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifne +222 -> 621
    //   402: aload_3
    //   403: getfield 225	com/tencent/mobileqq/data/ResourcePluginInfo:strNewPluginURL	Ljava/lang/String;
    //   406: bipush 110
    //   408: bipush 110
    //   410: aload_2
    //   411: aload_2
    //   412: iconst_0
    //   413: invokestatic 231	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   416: astore 4
    //   418: aload 4
    //   420: invokevirtual 234	com/tencent/image/URLDrawable:getStatus	()I
    //   423: iconst_1
    //   424: if_icmpne +159 -> 583
    //   427: aload 4
    //   429: invokestatic 239	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   432: astore 4
    //   434: aload 4
    //   436: bipush 110
    //   438: bipush 110
    //   440: invokestatic 242	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   443: astore 5
    //   445: aload_0
    //   446: getfield 144	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   449: aload 5
    //   451: invokevirtual 246	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   454: aload 4
    //   456: invokevirtual 251	android/graphics/Bitmap:recycle	()V
    //   459: aload_0
    //   460: getfield 157	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   463: aload_3
    //   464: getfield 254	com/tencent/mobileqq/data/ResourcePluginInfo:strResName	Ljava/lang/String;
    //   467: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   470: aload_0
    //   471: ldc 255
    //   473: invokevirtual 72	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   476: astore_2
    //   477: aload_0
    //   478: getfield 54	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Boolean	Z
    //   481: ifne +13 -> 494
    //   484: aload_2
    //   485: ldc_w 257
    //   488: invokestatic 263	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   491: invokevirtual 266	android/view/View:setBackgroundColor	(I)V
    //   494: aload_3
    //   495: getfield 269	com/tencent/mobileqq/data/ResourcePluginInfo:pluginBg	Ljava/lang/String;
    //   498: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   501: ifne +58 -> 559
    //   504: new 271	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 274
    //   514: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_3
    //   518: getfield 269	com/tencent/mobileqq/data/ResourcePluginInfo:pluginBg	Ljava/lang/String;
    //   521: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 263	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   530: istore_1
    //   531: aload_0
    //   532: getfield 77	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   535: iload_1
    //   536: invokevirtual 266	android/view/View:setBackgroundColor	(I)V
    //   539: aload_0
    //   540: getfield 175	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView	Lcom/tencent/biz/pubaccount/AccountDetailBounceScrollView;
    //   543: iload_1
    //   544: invokevirtual 283	com/tencent/biz/pubaccount/AccountDetailBounceScrollView:setBackgroundColor	(I)V
    //   547: aload_0
    //   548: getfield 54	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Boolean	Z
    //   551: ifne +8 -> 559
    //   554: aload_2
    //   555: iload_1
    //   556: invokevirtual 266	android/view/View:setBackgroundColor	(I)V
    //   559: aload_0
    //   560: invokespecial 285	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:b	()V
    //   563: return
    //   564: new 287	android/graphics/drawable/BitmapDrawable
    //   567: dup
    //   568: aload_0
    //   569: invokevirtual 181	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:getResources	()Landroid/content/res/Resources;
    //   572: aload_0
    //   573: getfield 222	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   576: invokespecial 290	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   579: astore_2
    //   580: goto -188 -> 392
    //   583: aload 4
    //   585: new 292	kpt
    //   588: dup
    //   589: aload_0
    //   590: invokespecial 293	kpt:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   593: invokevirtual 297	com/tencent/image/URLDrawable:setURLDrawableListener	(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V
    //   596: aload_0
    //   597: getfield 144	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   600: aload 4
    //   602: invokevirtual 301	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   605: goto -146 -> 459
    //   608: astore 4
    //   610: aload_0
    //   611: getfield 144	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   614: aload_2
    //   615: invokevirtual 301	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   618: goto -159 -> 459
    //   621: aload_0
    //   622: getfield 144	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   625: aload_2
    //   626: invokevirtual 301	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   629: goto -170 -> 459
    //   632: astore_2
    //   633: goto -74 -> 559
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	this	LebaSearchPluginManagerActivity
    //   303	253	1	i	int
    //   274	352	2	localObject1	Object
    //   632	1	2	localException1	java.lang.Exception
    //   285	233	3	localObject2	Object
    //   416	185	4	localObject3	Object
    //   608	1	4	localException2	java.lang.Exception
    //   443	7	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   402	459	608	java/lang/Exception
    //   583	605	608	java/lang/Exception
    //   504	559	632	java/lang/Exception
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.createPluginSetDialogForMain(this.app, this, 1, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName, null, this.jdField_a_of_type_AndroidOsHandler);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.createPluginSetDialogForMain(this.app, this, 2, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.pluginSetTips, this.jdField_a_of_type_AndroidOsHandler);
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing());
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean a()
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.jdField_b_of_type_Int = (getResources().getDisplayMetrics().heightPixels - i);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", 0L);
    if ((this.app != null) && (this.app.q)) {}
    for (this.jdField_a_of_type_JavaUtilList = LebaGridShowManager.a().c(this.app);; this.jdField_a_of_type_JavaUtilList = LebaShowListManager.a().a())
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
        if ((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == this.jdField_a_of_type_Long)) {
          this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
        break;
      }
      return false;
    }
    this.jdField_a_of_type_Byte = this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_Byte;
    try
    {
      localObject = BitmapFactory.decodeResource(getResources(), 2130840388);
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c((Bitmap)localObject, 110, 110);
      ((Bitmap)localObject).recycle();
      label226:
      if ((Build.BRAND.startsWith("samsung")) || (Build.BRAND.startsWith("Coolpad"))) {}
      for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
      {
        this.jdField_b_of_type_Boolean = Build.BOARD.equals("mx");
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label226;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_Byte == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838510);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131430537);
      if (this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_Byte == this.jdField_a_of_type_Byte) {
        break label75;
      }
    }
    label75:
    for (int i = -1;; i = 0)
    {
      setResult(i);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838497);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131430536);
      break;
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    jdField_a_of_type_Double = this.jdField_a_of_type_AndroidViewView.getHeight() / this.jdField_b_of_type_Int;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height = ((int)(this.jdField_b_of_type_Int * jdField_a_of_type_Double));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(this.jdField_b_of_type_Int - getTitleBarHeight() - this.jdField_a_of_type_Float * 56.0F));
    paramInt = (int)(this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() - this.jdField_b_of_type_Int * (1.0D - jdField_a_of_type_Double) + this.jdField_a_of_type_Float * 56.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setMaxOverScrollY(paramInt);
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY());
      c(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY());
    }
    this.jdField_b_of_type_AndroidViewView.postInvalidate();
  }
  
  @TargetApi(11)
  private void c(int paramInt)
  {
    int j;
    if (paramInt >= 0)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label53;
      }
      j = 460;
    }
    for (int i = 443;; i = (int)(0.29D * this.jdField_b_of_type_Int))
    {
      paramInt = this.jdField_a_of_type_AndroidViewView.getHeight() - paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        break label88;
      }
      if (paramInt > i) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label53:
      j = (int)(0.39D * this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    return;
    label88:
    if ((paramInt <= j) && (paramInt >= i))
    {
      float f;
      if (paramInt - i <= 0.01D * this.jdField_b_of_type_Int) {
        f = 0.05F;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(f);
        return;
        if (paramInt - i <= 0.02D * this.jdField_b_of_type_Int) {
          f = 0.15F;
        } else if (paramInt - i <= 0.03D * this.jdField_b_of_type_Int) {
          f = 0.25F;
        } else if (paramInt - i <= 0.04D * this.jdField_b_of_type_Int) {
          f = 0.35F;
        } else if (paramInt - i <= 0.05D * this.jdField_b_of_type_Int) {
          f = 0.45F;
        } else if (paramInt - i <= 0.06D * this.jdField_b_of_type_Int) {
          f = 0.55F;
        } else if (paramInt - i <= 0.07000000000000001D * this.jdField_b_of_type_Int) {
          f = 0.65F;
        } else if (paramInt - i <= this.jdField_b_of_type_Int * 0.08D) {
          f = 0.75F;
        } else if (paramInt - i <= this.jdField_b_of_type_Int * 0.08D) {
          f = 0.85F;
        } else {
          f = 0.95F;
        }
      }
    }
    if (paramInt < i)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height = ((int)(this.jdField_b_of_type_Int * jdField_a_of_type_Double));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(this.jdField_b_of_type_Int - getTitleBarHeight() - 56.0F * this.jdField_a_of_type_Float));
    i = this.jdField_a_of_type_AndroidViewView.getHeight() - paramInt;
    localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    double d1 = jdField_a_of_type_Double;
    double d2 = (jdField_b_of_type_Double * d1 - 0.05D) / (d1 - 0.3D);
    double d3 = (i - this.jdField_b_of_type_Int * 0.3D) / ((d1 - 0.3D) * this.jdField_b_of_type_Int);
    if (i <= this.jdField_b_of_type_Int * 0.3D)
    {
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(30.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(30.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.jdField_b_of_type_Int * 0.1D * 0.5D - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
      localLayoutParams.height = ((int)(32.0F * this.jdField_a_of_type_Float));
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - 1.0F * this.jdField_a_of_type_Float));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      return;
      if (i >= d1 * this.jdField_b_of_type_Int)
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)(jdField_a_of_type_Int * this.jdField_a_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * jdField_b_of_type_Double - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + 10.0F * this.jdField_a_of_type_Float));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - 5.0F * this.jdField_a_of_type_Float));
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)((30.0D + (jdField_a_of_type_Int - 30) * d3) * this.jdField_a_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)((i - this.jdField_b_of_type_Int * 0.3D) * d2 + this.jdField_b_of_type_Int * 0.1D * 0.5D - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + (1.0D + 9.0D * d3) * this.jdField_a_of_type_Float));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - (1.0D + 9.0D * d3) * this.jdField_a_of_type_Float / 2.0D));
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2130969391);
    LebaShowListManager.jdField_a_of_type_Int |= 0x1;
    if (!a())
    {
      finish();
      return false;
    }
    a();
    if (this.jdField_a_of_type_Long == 886L) {
      ReportController.b(this.app, "dc00899", "Grp_nearby", "", "dyn_set", "visit_nearby_intro", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366364: 
      if (this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_Byte != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        return;
      }
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity
 * JD-Core Version:    0.7.0.1
 */