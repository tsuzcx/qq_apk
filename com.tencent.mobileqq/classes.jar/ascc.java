import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import com.tencent.mobileqq.forward.ForwardQQStoryMsgOption.1;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class ascc
  extends asei
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ScrollView a;
  
  public ascc(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a(String paramString1, String paramString2, Context paramContext)
  {
    int i = 3;
    try
    {
      paramString2 = bdib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramString2);
      paramContext = "";
      str = "";
      for (;;)
      {
        try
        {
          j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
          if (j != 0) {
            break label242;
          }
          i = 1;
          if (paramString2 == null) {
            continue;
          }
          paramContext = paramString2.b("unionid");
          str = paramString2.b("storyid");
        }
        catch (Exception paramString1)
        {
          if (!QLog.isColorLevel()) {
            break label236;
          }
          QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramString1);
          return;
          j = -1;
          paramString2 = str;
          continue;
        }
        try
        {
          j = Integer.valueOf(paramString2.b("contentType")).intValue();
          paramString2 = str;
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
          paramString2 = str;
          j = -1;
        }
      }
      wxj.a("share", paramString1, i, j, new String[] { paramContext, paramString2, "", "" });
      if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardQQStoryMsgOption", 2, "reportClickEvent: opName=" + paramString1 + ", fromType=" + i + ", result=" + j + ", extra1=" + paramContext + ", extra2=" + paramString2);
        return;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        String str;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.qqstory.share", 2, "report exp:", paramString2);
          break label237;
          label236:
          return;
        }
        label237:
        paramString2 = null;
        continue;
        label242:
        if (j == 1) {
          i = 2;
        } else if (j != 3000) {
          i = -1;
        }
      }
    }
  }
  
  /* Error */
  protected boolean a(bdjz parambdjz)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 126	bdjz:getWindow	()Landroid/view/Window;
    //   4: bipush 19
    //   6: invokevirtual 132	android/view/Window:setSoftInputMode	(I)V
    //   9: aload_0
    //   10: getfield 135	ascc:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   13: ifnull +644 -> 657
    //   16: aload_0
    //   17: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   20: ldc 139
    //   22: invokestatic 144	bdaq:a	(Landroid/content/Context;F)I
    //   25: istore_2
    //   26: aload_0
    //   27: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   30: ldc 145
    //   32: invokestatic 144	bdaq:a	(Landroid/content/Context;F)I
    //   35: istore_3
    //   36: aload_0
    //   37: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   40: ldc 146
    //   42: invokestatic 144	bdaq:a	(Landroid/content/Context;F)I
    //   45: istore 4
    //   47: aload_0
    //   48: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   51: ldc 147
    //   53: invokestatic 144	bdaq:a	(Landroid/content/Context;F)I
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   62: ldc 148
    //   64: invokestatic 144	bdaq:a	(Landroid/content/Context;F)I
    //   67: istore 6
    //   69: ldc 150
    //   71: invokestatic 155	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   74: istore 7
    //   76: new 157	android/widget/LinearLayout
    //   79: dup
    //   80: aload_0
    //   81: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   84: invokespecial 160	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   87: astore 8
    //   89: aload 8
    //   91: iconst_1
    //   92: invokevirtual 163	android/widget/LinearLayout:setOrientation	(I)V
    //   95: new 165	android/widget/LinearLayout$LayoutParams
    //   98: dup
    //   99: bipush 254
    //   101: bipush 254
    //   103: invokespecial 168	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   106: astore 9
    //   108: aload 9
    //   110: iconst_1
    //   111: putfield 172	android/widget/LinearLayout$LayoutParams:gravity	I
    //   114: new 174	android/widget/RelativeLayout
    //   117: dup
    //   118: aload_0
    //   119: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   122: invokespecial 175	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   125: astore 10
    //   127: new 165	android/widget/LinearLayout$LayoutParams
    //   130: dup
    //   131: iload_3
    //   132: iload 4
    //   134: invokespecial 168	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   137: astore 11
    //   139: new 177	com/tencent/image/URLImageView
    //   142: dup
    //   143: aload_0
    //   144: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   147: invokespecial 178	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   150: astore 14
    //   152: aload 14
    //   154: getstatic 184	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   157: invokevirtual 188	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   160: new 190	android/widget/RelativeLayout$LayoutParams
    //   163: dup
    //   164: iconst_m1
    //   165: iconst_m1
    //   166: invokespecial 191	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   169: astore 12
    //   171: new 177	com/tencent/image/URLImageView
    //   174: dup
    //   175: aload_0
    //   176: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   179: invokespecial 178	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   182: astore 13
    //   184: aload 13
    //   186: getstatic 194	android/widget/ImageView$ScaleType:FIT_START	Landroid/widget/ImageView$ScaleType;
    //   189: invokevirtual 188	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   192: new 190	android/widget/RelativeLayout$LayoutParams
    //   195: dup
    //   196: iload 5
    //   198: iload 6
    //   200: invokespecial 191	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   203: astore 15
    //   205: aload 15
    //   207: bipush 9
    //   209: invokevirtual 197	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   212: aload 15
    //   214: bipush 10
    //   216: invokevirtual 197	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   219: aload 15
    //   221: iload_2
    //   222: putfield 200	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   225: aload 15
    //   227: aload_0
    //   228: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   231: ldc 201
    //   233: invokestatic 144	bdaq:a	(Landroid/content/Context;F)I
    //   236: putfield 204	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   239: new 206	android/widget/TextView
    //   242: dup
    //   243: aload_0
    //   244: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   247: invokespecial 207	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   250: astore 16
    //   252: aload 16
    //   254: ldc 208
    //   256: invokevirtual 211	android/widget/TextView:setTextColor	(I)V
    //   259: aload 16
    //   261: iconst_1
    //   262: ldc 139
    //   264: invokevirtual 215	android/widget/TextView:setTextSize	(IF)V
    //   267: new 165	android/widget/LinearLayout$LayoutParams
    //   270: dup
    //   271: bipush 254
    //   273: bipush 254
    //   275: invokespecial 168	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   278: astore 17
    //   280: aload 17
    //   282: aload_0
    //   283: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   286: ldc 216
    //   288: invokestatic 144	bdaq:a	(Landroid/content/Context;F)I
    //   291: putfield 217	android/widget/LinearLayout$LayoutParams:topMargin	I
    //   294: aload 17
    //   296: iconst_3
    //   297: putfield 172	android/widget/LinearLayout$LayoutParams:gravity	I
    //   300: aload 10
    //   302: aload 14
    //   304: aload 12
    //   306: invokevirtual 221	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   309: aload 10
    //   311: aload 13
    //   313: aload 15
    //   315: invokevirtual 221	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   318: aload 8
    //   320: aload 10
    //   322: aload 11
    //   324: invokevirtual 222	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   327: aload 8
    //   329: aload 16
    //   331: aload 17
    //   333: invokevirtual 222	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   336: aload_1
    //   337: aload 8
    //   339: aload 9
    //   341: invokevirtual 225	bdjz:addView	(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)Lbdjz;
    //   344: pop
    //   345: aload 16
    //   347: aload_0
    //   348: getfield 135	ascc:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   351: getfield 231	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   354: invokevirtual 235	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   357: ldc 26
    //   359: astore 12
    //   361: new 237	org/json/JSONObject
    //   364: dup
    //   365: aload_0
    //   366: getfield 135	ascc:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   369: getfield 240	com/tencent/mobileqq/structmsg/AbsShareMsg:mQQStoryExtra	Ljava/lang/String;
    //   372: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   375: astore 9
    //   377: aload 9
    //   379: ldc 245
    //   381: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: astore 8
    //   386: aload 9
    //   388: ldc 250
    //   390: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 9
    //   395: aload 8
    //   397: astore 10
    //   399: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +34 -> 436
    //   405: ldc 108
    //   407: iconst_2
    //   408: new 78	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   415: ldc 252
    //   417: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_0
    //   421: getfield 135	ascc:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   424: getfield 240	com/tencent/mobileqq/structmsg/AbsShareMsg:mQQStoryExtra	Ljava/lang/String;
    //   427: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: new 254	android/graphics/drawable/ColorDrawable
    //   439: dup
    //   440: iload 7
    //   442: invokespecial 256	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   445: astore 8
    //   447: aload 14
    //   449: aload 8
    //   451: invokevirtual 260	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   454: invokestatic 266	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   457: astore 11
    //   459: aload 11
    //   461: aload 8
    //   463: putfield 270	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   466: aload 11
    //   468: aload 8
    //   470: putfield 273	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   473: aload 11
    //   475: iload_3
    //   476: putfield 276	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   479: aload 11
    //   481: iload 4
    //   483: putfield 279	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   486: aload 10
    //   488: aload 11
    //   490: invokestatic 285	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   493: astore 8
    //   495: aload 8
    //   497: invokevirtual 288	com/tencent/image/URLDrawable:getStatus	()I
    //   500: iconst_2
    //   501: if_icmpne +8 -> 509
    //   504: aload 8
    //   506: invokevirtual 291	com/tencent/image/URLDrawable:restartDownload	()V
    //   509: aload 14
    //   511: aload 8
    //   513: invokevirtual 260	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   516: new 254	android/graphics/drawable/ColorDrawable
    //   519: dup
    //   520: ldc_w 293
    //   523: invokestatic 155	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   526: invokespecial 256	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   529: astore 8
    //   531: aload 13
    //   533: aload 8
    //   535: invokevirtual 260	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   538: invokestatic 266	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   541: astore 10
    //   543: aload 10
    //   545: aload 8
    //   547: putfield 270	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   550: aload 10
    //   552: aload 8
    //   554: putfield 273	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   557: aload 10
    //   559: iload 5
    //   561: putfield 276	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   564: aload 10
    //   566: iload 6
    //   568: putfield 279	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   571: aload 9
    //   573: aload 10
    //   575: invokestatic 285	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   578: astore 8
    //   580: aload 8
    //   582: invokevirtual 288	com/tencent/image/URLDrawable:getStatus	()I
    //   585: iconst_2
    //   586: if_icmpne +8 -> 594
    //   589: aload 8
    //   591: invokevirtual 291	com/tencent/image/URLDrawable:restartDownload	()V
    //   594: aload 13
    //   596: aload 8
    //   598: invokevirtual 260	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   601: aload_0
    //   602: aload_1
    //   603: invokevirtual 126	bdjz:getWindow	()Landroid/view/Window;
    //   606: invokevirtual 297	android/view/Window:getDecorView	()Landroid/view/View;
    //   609: ldc_w 298
    //   612: invokevirtual 304	android/view/View:findViewById	(I)Landroid/view/View;
    //   615: checkcast 306	android/widget/ScrollView
    //   618: putfield 308	ascc:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   621: aload_0
    //   622: getfield 308	ascc:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   625: ifnull +14 -> 639
    //   628: aload_0
    //   629: getfield 308	ascc:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   632: invokevirtual 312	android/widget/ScrollView:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   635: aload_0
    //   636: invokevirtual 318	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   639: aload_0
    //   640: ldc_w 320
    //   643: aload_0
    //   644: getfield 135	ascc:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   647: getfield 323	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgAction	Ljava/lang/String;
    //   650: aload_0
    //   651: getfield 138	ascc:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   654: invokevirtual 325	ascc:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   657: iconst_1
    //   658: ireturn
    //   659: astore 11
    //   661: ldc 26
    //   663: astore 8
    //   665: aload 12
    //   667: astore 9
    //   669: aload 8
    //   671: astore 10
    //   673: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   676: ifeq -277 -> 399
    //   679: ldc 108
    //   681: iconst_2
    //   682: ldc 252
    //   684: aload 11
    //   686: invokestatic 114	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   689: aload 12
    //   691: astore 9
    //   693: aload 8
    //   695: astore 10
    //   697: goto -298 -> 399
    //   700: astore 8
    //   702: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq -189 -> 516
    //   708: ldc 108
    //   710: iconst_2
    //   711: ldc 252
    //   713: aload 8
    //   715: invokestatic 114	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   718: goto -202 -> 516
    //   721: astore 8
    //   723: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   726: ifeq -125 -> 601
    //   729: ldc 108
    //   731: iconst_2
    //   732: ldc 252
    //   734: aload 8
    //   736: invokestatic 114	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   739: goto -138 -> 601
    //   742: astore_1
    //   743: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   746: ifeq -107 -> 639
    //   749: ldc 108
    //   751: iconst_2
    //   752: new 78	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   759: ldc 252
    //   761: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_1
    //   765: invokevirtual 326	java/lang/Exception:toString	()Ljava/lang/String;
    //   768: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 328	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: goto -138 -> 639
    //   780: astore 11
    //   782: goto -117 -> 665
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	785	0	this	ascc
    //   0	785	1	parambdjz	bdjz
    //   25	197	2	i	int
    //   35	441	3	j	int
    //   45	437	4	k	int
    //   56	504	5	m	int
    //   67	500	6	n	int
    //   74	367	7	i1	int
    //   87	607	8	localObject1	java.lang.Object
    //   700	14	8	localException1	Exception
    //   721	14	8	localException2	Exception
    //   106	586	9	localObject2	java.lang.Object
    //   125	571	10	localObject3	java.lang.Object
    //   137	352	11	localObject4	java.lang.Object
    //   659	26	11	localException3	Exception
    //   780	1	11	localException4	Exception
    //   169	521	12	localObject5	java.lang.Object
    //   182	413	13	localURLImageView1	com.tencent.image.URLImageView
    //   150	360	14	localURLImageView2	com.tencent.image.URLImageView
    //   203	111	15	localLayoutParams	android.widget.RelativeLayout.LayoutParams
    //   250	96	16	localTextView	android.widget.TextView
    //   278	54	17	localLayoutParams1	android.widget.LinearLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   361	386	659	java/lang/Exception
    //   436	509	700	java/lang/Exception
    //   509	516	700	java/lang/Exception
    //   516	594	721	java/lang/Exception
    //   594	601	721	java/lang/Exception
    //   601	639	742	java/lang/Exception
    //   386	395	780	java/lang/Exception
  }
  
  protected void d()
  {
    int i = c();
    String str = "";
    if (i != 0) {
      str = this.jdField_a_of_type_Bdjz.getInputValue();
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", str);
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      a("clk_send", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
    }
    super.d();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "removeLayoutListener:", localException);
    }
  }
  
  protected boolean h()
  {
    return false;
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {
      this.jdField_a_of_type_AndroidWidgetScrollView.post(new ForwardQQStoryMsgOption.1(this));
    }
  }
  
  protected void r()
  {
    super.r();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      a("cancel", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascc
 * JD-Core Version:    0.7.0.1
 */