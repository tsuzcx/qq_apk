import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import java.util.HashMap;
import java.util.Map;

public class asgd
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  public TextView a;
  private asfu jdField_a_of_type_Asfu;
  private bhpy jdField_a_of_type_Bhpy;
  private bhqd jdField_a_of_type_Bhqd = new asge(this);
  public URLImageView a;
  private FeedsItemData jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData;
  public GameCenterVideoViewController a;
  public CornerImageView a;
  public TextView b;
  private URLImageView b;
  public TextView c;
  public TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public asgd(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = ((GameCenterVideoViewController)paramView.findViewById(2131379720));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378985));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371469));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362918));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362919));
    this.c = ((TextView)paramView.findViewById(2131379932));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369122));
    this.e = ((TextView)paramView.findViewById(2131369123));
    this.g = ((TextView)paramView.findViewById(2131371470));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369127));
    this.f = ((TextView)paramView.findViewById(2131369128));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.m();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.o();
    this.h = ((TextView)paramView.findViewById(2131378902));
    this.i = ((TextView)paramView.findViewById(2131378804));
    this.d = ((TextView)paramView.findViewById(2131361931));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369138));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361900));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramView.getResources().getDrawable(2130840733);
    localURLDrawableOptions.mFailedDrawable = paramView.getResources().getDrawable(2130840733);
    paramView = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_arrow@2x.png", localURLDrawableOptions);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
  }
  
  /* Error */
  public void a(asfu paramasfu, FeedsItemData paramFeedsItemData, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: putfield 162	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
    //   5: aload_0
    //   6: aload_1
    //   7: putfield 156	asgd:jdField_a_of_type_Asfu	Lasfu;
    //   10: aload_0
    //   11: iload_3
    //   12: putfield 152	asgd:jdField_a_of_type_Int	I
    //   15: aload_0
    //   16: getfield 59	asgd:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   19: bipush 8
    //   21: invokevirtual 169	com/tencent/image/URLImageView:setVisibility	(I)V
    //   24: aload_0
    //   25: getfield 75	asgd:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   28: bipush 8
    //   30: invokevirtual 170	android/widget/LinearLayout:setVisibility	(I)V
    //   33: aload_0
    //   34: getfield 78	asgd:e	Landroid/widget/TextView;
    //   37: bipush 8
    //   39: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   42: aload_0
    //   43: getfield 84	asgd:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   46: bipush 8
    //   48: invokevirtual 169	com/tencent/image/URLImageView:setVisibility	(I)V
    //   51: aload_0
    //   52: getfield 87	asgd:f	Landroid/widget/TextView;
    //   55: bipush 8
    //   57: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   60: aload_0
    //   61: getfield 81	asgd:g	Landroid/widget/TextView;
    //   64: bipush 8
    //   66: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   69: aload_0
    //   70: getfield 64	asgd:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
    //   73: iconst_0
    //   74: invokevirtual 172	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setVisibility	(I)V
    //   77: aload_0
    //   78: getfield 67	asgd:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   81: iconst_0
    //   82: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   85: aload_0
    //   86: getfield 70	asgd:c	Landroid/widget/TextView;
    //   89: iconst_0
    //   90: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   93: aload_0
    //   94: getfield 176	asgd:itemView	Landroid/view/View;
    //   97: aload_0
    //   98: getfield 176	asgd:itemView	Landroid/view/View;
    //   101: invokevirtual 180	android/view/View:getContext	()Landroid/content/Context;
    //   104: ldc 181
    //   106: ldc 181
    //   108: ldc 181
    //   110: ldc 181
    //   112: invokestatic 186	asjc:a	(Landroid/content/Context;FFFF)Landroid/graphics/drawable/StateListDrawable;
    //   115: invokevirtual 189	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   118: aload_2
    //   119: getfield 195	com/tencent/mobileqq/gamecenter/data/FeedsItemData:rcmdReason	Ljava/lang/String;
    //   122: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +356 -> 481
    //   128: aload_0
    //   129: getfield 97	asgd:h	Landroid/widget/TextView;
    //   132: bipush 8
    //   134: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   137: aload_2
    //   138: getfield 204	com/tencent/mobileqq/gamecenter/data/FeedsItemData:label	Ljava/lang/String;
    //   141: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifeq +378 -> 522
    //   147: aload_2
    //   148: getfield 207	com/tencent/mobileqq/gamecenter/data/FeedsItemData:operateText	Ljava/lang/String;
    //   151: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +368 -> 522
    //   157: aload_0
    //   158: getfield 108	asgd:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   161: bipush 8
    //   163: invokevirtual 208	android/widget/RelativeLayout:setVisibility	(I)V
    //   166: aload_2
    //   167: getfield 211	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   170: iconst_3
    //   171: if_icmpne +515 -> 686
    //   174: aload_0
    //   175: getfield 49	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController	Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;
    //   178: bipush 8
    //   180: invokevirtual 212	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVisibility	(I)V
    //   183: aload_0
    //   184: getfield 78	asgd:e	Landroid/widget/TextView;
    //   187: iconst_0
    //   188: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   191: aload_0
    //   192: getfield 59	asgd:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   195: iconst_0
    //   196: invokevirtual 169	com/tencent/image/URLImageView:setVisibility	(I)V
    //   199: aload_0
    //   200: getfield 59	asgd:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   203: ldc 213
    //   205: invokevirtual 216	com/tencent/image/URLImageView:setBackgroundColor	(I)V
    //   208: aload_0
    //   209: getfield 59	asgd:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   212: aload_2
    //   213: getfield 219	com/tencent/mobileqq/gamecenter/data/FeedsItemData:coverImgUrl	Ljava/lang/String;
    //   216: invokevirtual 223	com/tencent/image/URLImageView:setImageURL	(Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 64	asgd:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
    //   223: iconst_4
    //   224: invokevirtual 172	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setVisibility	(I)V
    //   227: aload_0
    //   228: getfield 67	asgd:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   231: iconst_4
    //   232: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   235: aload_0
    //   236: getfield 70	asgd:c	Landroid/widget/TextView;
    //   239: iconst_4
    //   240: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   243: aload_0
    //   244: getfield 54	asgd:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   247: aload_2
    //   248: getfield 226	com/tencent/mobileqq/gamecenter/data/FeedsItemData:title	Ljava/lang/String;
    //   251: invokevirtual 230	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   254: aload_0
    //   255: getfield 67	asgd:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   258: aload_2
    //   259: getfield 233	com/tencent/mobileqq/gamecenter/data/FeedsItemData:authorName	Ljava/lang/String;
    //   262: invokevirtual 230	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   265: invokestatic 119	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   268: astore_1
    //   269: aload_1
    //   270: aload_0
    //   271: getfield 176	asgd:itemView	Landroid/view/View;
    //   274: invokevirtual 180	android/view/View:getContext	()Landroid/content/Context;
    //   277: invokevirtual 236	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   280: ldc 237
    //   282: invokevirtual 130	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   285: putfield 134	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   288: aload_1
    //   289: aload_0
    //   290: getfield 176	asgd:itemView	Landroid/view/View;
    //   293: invokevirtual 180	android/view/View:getContext	()Landroid/content/Context;
    //   296: invokevirtual 236	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   299: ldc 237
    //   301: invokevirtual 130	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   304: putfield 137	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   307: aload_0
    //   308: getfield 64	asgd:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
    //   311: aload_2
    //   312: getfield 240	com/tencent/mobileqq/gamecenter/data/FeedsItemData:authorIcon	Ljava/lang/String;
    //   315: aload_1
    //   316: invokestatic 144	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   319: invokevirtual 241	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   322: aload_0
    //   323: getfield 64	asgd:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
    //   326: ldc 242
    //   328: aload_0
    //   329: getfield 64	asgd:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
    //   332: invokevirtual 243	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:getResources	()Landroid/content/res/Resources;
    //   335: invokestatic 248	aekt:a	(FLandroid/content/res/Resources;)I
    //   338: i2f
    //   339: invokevirtual 252	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setRadius	(F)V
    //   342: aload_0
    //   343: getfield 64	asgd:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
    //   346: ldc 242
    //   348: aload_0
    //   349: getfield 64	asgd:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView	Lcom/tencent/mobileqq/profile/PersonalityLabel/CornerImageView;
    //   352: invokevirtual 243	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:getResources	()Landroid/content/res/Resources;
    //   355: invokestatic 248	aekt:a	(FLandroid/content/res/Resources;)I
    //   358: i2f
    //   359: invokevirtual 252	com/tencent/mobileqq/profile/PersonalityLabel/CornerImageView:setRadius	(F)V
    //   362: aload_0
    //   363: getfield 162	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
    //   366: getfield 255	com/tencent/mobileqq/gamecenter/data/FeedsItemData:viewersNum	I
    //   369: sipush 10000
    //   372: if_icmple +597 -> 969
    //   375: aload_0
    //   376: getfield 162	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
    //   379: getfield 211	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   382: iconst_1
    //   383: if_icmpne +527 -> 910
    //   386: new 257	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   393: ldc_w 260
    //   396: invokestatic 265	alpo:a	(I)Ljava/lang/String;
    //   399: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_0
    //   403: getfield 162	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
    //   406: getfield 272	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoViewers	I
    //   409: i2f
    //   410: ldc_w 273
    //   413: fdiv
    //   414: ldc_w 274
    //   417: fmul
    //   418: invokestatic 280	java/lang/Math:round	(F)I
    //   421: i2f
    //   422: ldc_w 274
    //   425: fdiv
    //   426: invokevirtual 283	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   429: ldc_w 284
    //   432: invokestatic 265	alpo:a	(I)Ljava/lang/String;
    //   435: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: astore_1
    //   442: aload_0
    //   443: getfield 70	asgd:c	Landroid/widget/TextView;
    //   446: aload_1
    //   447: invokevirtual 230	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   450: aload_0
    //   451: getfield 103	asgd:d	Landroid/widget/TextView;
    //   454: ldc_w 289
    //   457: iconst_m1
    //   458: invokestatic 292	asjc:a	(II)Landroid/content/res/ColorStateList;
    //   461: invokevirtual 296	android/widget/TextView:setTextColor	(Landroid/content/res/ColorStateList;)V
    //   464: aload_0
    //   465: getfield 176	asgd:itemView	Landroid/view/View;
    //   468: aload_0
    //   469: invokevirtual 300	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   472: aload_0
    //   473: getfield 103	asgd:d	Landroid/widget/TextView;
    //   476: aload_0
    //   477: invokevirtual 301	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   480: return
    //   481: aload_0
    //   482: getfield 97	asgd:h	Landroid/widget/TextView;
    //   485: new 257	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   492: aload_2
    //   493: getfield 195	com/tencent/mobileqq/gamecenter/data/FeedsItemData:rcmdReason	Ljava/lang/String;
    //   496: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc_w 303
    //   502: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 230	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   511: aload_0
    //   512: getfield 97	asgd:h	Landroid/widget/TextView;
    //   515: iconst_0
    //   516: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   519: goto -382 -> 137
    //   522: aload_0
    //   523: getfield 108	asgd:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   526: iconst_0
    //   527: invokevirtual 208	android/widget/RelativeLayout:setVisibility	(I)V
    //   530: aload_2
    //   531: getfield 207	com/tencent/mobileqq/gamecenter/data/FeedsItemData:operateText	Ljava/lang/String;
    //   534: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   537: ifeq +43 -> 580
    //   540: aload_0
    //   541: getfield 103	asgd:d	Landroid/widget/TextView;
    //   544: bipush 8
    //   546: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   549: aload_0
    //   550: getfield 113	asgd:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   553: bipush 8
    //   555: invokevirtual 304	android/widget/ImageView:setVisibility	(I)V
    //   558: aload_2
    //   559: getfield 204	com/tencent/mobileqq/gamecenter/data/FeedsItemData:label	Ljava/lang/String;
    //   562: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   565: ifeq +64 -> 629
    //   568: aload_0
    //   569: getfield 100	asgd:i	Landroid/widget/TextView;
    //   572: bipush 8
    //   574: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   577: goto -411 -> 166
    //   580: aload_0
    //   581: getfield 103	asgd:d	Landroid/widget/TextView;
    //   584: new 257	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   591: aload_2
    //   592: getfield 207	com/tencent/mobileqq/gamecenter/data/FeedsItemData:operateText	Ljava/lang/String;
    //   595: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: ldc_w 303
    //   601: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokevirtual 230	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   610: aload_0
    //   611: getfield 103	asgd:d	Landroid/widget/TextView;
    //   614: iconst_0
    //   615: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   618: aload_0
    //   619: getfield 113	asgd:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   622: iconst_0
    //   623: invokevirtual 304	android/widget/ImageView:setVisibility	(I)V
    //   626: goto -68 -> 558
    //   629: aload_0
    //   630: getfield 100	asgd:i	Landroid/widget/TextView;
    //   633: new 257	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   640: aload_2
    //   641: getfield 204	com/tencent/mobileqq/gamecenter/data/FeedsItemData:label	Ljava/lang/String;
    //   644: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: ldc_w 303
    //   650: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokevirtual 230	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   659: aload_0
    //   660: getfield 100	asgd:i	Landroid/widget/TextView;
    //   663: iconst_0
    //   664: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   667: goto -501 -> 166
    //   670: astore_1
    //   671: ldc_w 306
    //   674: iconst_1
    //   675: aload_1
    //   676: iconst_0
    //   677: anewarray 308	java/lang/Object
    //   680: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   683: goto -464 -> 219
    //   686: aload_0
    //   687: getfield 49	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController	Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;
    //   690: iconst_0
    //   691: invokevirtual 212	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVisibility	(I)V
    //   694: aload_2
    //   695: getfield 211	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   698: iconst_1
    //   699: if_icmpne +131 -> 830
    //   702: aload_0
    //   703: getfield 75	asgd:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   706: iconst_0
    //   707: invokevirtual 170	android/widget/LinearLayout:setVisibility	(I)V
    //   710: aload_0
    //   711: getfield 70	asgd:c	Landroid/widget/TextView;
    //   714: invokevirtual 317	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   717: checkcast 319	android/widget/RelativeLayout$LayoutParams
    //   720: astore_1
    //   721: aload_1
    //   722: ldc_w 320
    //   725: aload_0
    //   726: getfield 176	asgd:itemView	Landroid/view/View;
    //   729: invokevirtual 180	android/view/View:getContext	()Landroid/content/Context;
    //   732: invokevirtual 236	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   735: invokestatic 248	aekt:a	(FLandroid/content/res/Resources;)I
    //   738: putfield 323	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   741: aload_0
    //   742: getfield 70	asgd:c	Landroid/widget/TextView;
    //   745: aload_1
    //   746: invokevirtual 327	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   749: aload_0
    //   750: getfield 84	asgd:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   753: iconst_0
    //   754: invokevirtual 169	com/tencent/image/URLImageView:setVisibility	(I)V
    //   757: aload_0
    //   758: getfield 87	asgd:f	Landroid/widget/TextView;
    //   761: iconst_0
    //   762: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   765: aload_0
    //   766: getfield 87	asgd:f	Landroid/widget/TextView;
    //   769: aload_2
    //   770: getfield 330	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoSrcName	Ljava/lang/String;
    //   773: invokevirtual 230	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   776: aload_0
    //   777: getfield 84	asgd:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   780: aload_2
    //   781: getfield 333	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoSrcImg	Ljava/lang/String;
    //   784: invokevirtual 223	com/tencent/image/URLImageView:setImageURL	(Ljava/lang/String;)V
    //   787: aload_0
    //   788: getfield 49	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController	Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;
    //   791: new 335	asgg
    //   794: dup
    //   795: aload_0
    //   796: invokespecial 336	asgg:<init>	(Lasgd;)V
    //   799: invokevirtual 340	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setVideoStatusChangerListener	(Lasij;)V
    //   802: aload_0
    //   803: getfield 49	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController	Lcom/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController;
    //   806: aload_2
    //   807: iconst_2
    //   808: invokevirtual 344	com/tencent/mobileqq/gamecenter/media/GameCenterVideoViewController:setData	(Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;I)V
    //   811: goto -568 -> 243
    //   814: astore_1
    //   815: ldc_w 306
    //   818: iconst_1
    //   819: aload_1
    //   820: iconst_0
    //   821: anewarray 308	java/lang/Object
    //   824: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   827: goto -40 -> 787
    //   830: aload_0
    //   831: getfield 81	asgd:g	Landroid/widget/TextView;
    //   834: bipush 8
    //   836: invokevirtual 171	android/widget/TextView:setVisibility	(I)V
    //   839: aload_0
    //   840: getfield 81	asgd:g	Landroid/widget/TextView;
    //   843: aload_2
    //   844: getfield 347	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoDuration	I
    //   847: invokestatic 350	orc:a	(I)Ljava/lang/String;
    //   850: invokevirtual 230	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   853: aload_0
    //   854: getfield 70	asgd:c	Landroid/widget/TextView;
    //   857: invokevirtual 317	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   860: checkcast 319	android/widget/RelativeLayout$LayoutParams
    //   863: astore_1
    //   864: aload_1
    //   865: ldc 242
    //   867: aload_0
    //   868: getfield 176	asgd:itemView	Landroid/view/View;
    //   871: invokevirtual 180	android/view/View:getContext	()Landroid/content/Context;
    //   874: invokevirtual 236	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   877: invokestatic 248	aekt:a	(FLandroid/content/res/Resources;)I
    //   880: putfield 323	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   883: aload_0
    //   884: getfield 70	asgd:c	Landroid/widget/TextView;
    //   887: aload_1
    //   888: invokevirtual 327	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   891: goto -104 -> 787
    //   894: astore_1
    //   895: ldc_w 306
    //   898: iconst_1
    //   899: aload_1
    //   900: iconst_0
    //   901: anewarray 308	java/lang/Object
    //   904: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   907: goto -565 -> 342
    //   910: new 257	java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   917: ldc_w 351
    //   920: invokestatic 265	alpo:a	(I)Ljava/lang/String;
    //   923: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: aload_0
    //   927: getfield 162	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
    //   930: getfield 255	com/tencent/mobileqq/gamecenter/data/FeedsItemData:viewersNum	I
    //   933: i2f
    //   934: ldc_w 273
    //   937: fdiv
    //   938: ldc_w 274
    //   941: fmul
    //   942: invokestatic 280	java/lang/Math:round	(F)I
    //   945: i2f
    //   946: ldc_w 274
    //   949: fdiv
    //   950: invokevirtual 283	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   953: ldc_w 352
    //   956: invokestatic 265	alpo:a	(I)Ljava/lang/String;
    //   959: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: astore_1
    //   966: goto -524 -> 442
    //   969: aload_0
    //   970: getfield 162	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
    //   973: getfield 211	com/tencent/mobileqq/gamecenter/data/FeedsItemData:type	I
    //   976: iconst_1
    //   977: if_icmpne +45 -> 1022
    //   980: new 257	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   987: ldc_w 260
    //   990: invokestatic 265	alpo:a	(I)Ljava/lang/String;
    //   993: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: aload_0
    //   997: getfield 162	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
    //   1000: getfield 272	com/tencent/mobileqq/gamecenter/data/FeedsItemData:videoViewers	I
    //   1003: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1006: ldc_w 356
    //   1009: invokestatic 265	alpo:a	(I)Ljava/lang/String;
    //   1012: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: astore_1
    //   1019: goto -577 -> 442
    //   1022: new 257	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   1029: ldc_w 357
    //   1032: invokestatic 265	alpo:a	(I)Ljava/lang/String;
    //   1035: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_0
    //   1039: getfield 162	asgd:jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData	Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;
    //   1042: getfield 255	com/tencent/mobileqq/gamecenter/data/FeedsItemData:viewersNum	I
    //   1045: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1048: ldc_w 358
    //   1051: invokestatic 265	alpo:a	(I)Ljava/lang/String;
    //   1054: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: astore_1
    //   1061: goto -619 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1064	0	this	asgd
    //   0	1064	1	paramasfu	asfu
    //   0	1064	2	paramFeedsItemData	FeedsItemData
    //   0	1064	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   199	219	670	java/lang/Exception
    //   776	787	814	java/lang/Exception
    //   265	342	894	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    paramView = new HashMap();
    aact.a(paramView, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
    paramView.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.msgId);
    paramView.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.algorithmId);
    paramView.put(Integer.valueOf(44), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.type + "");
    aact.a(akro.a(), "769", "205022", this.jdField_a_of_type_Asfu.a().gameAppId, "76902", "1", "160", paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl.startsWith("mqqapi://miniapp/"))
    {
      MiniAppLauncher.startMiniApp(asfu.a(this.jdField_a_of_type_Asfu), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl, 2016, null);
      return;
    }
    paramView = new Intent(asfu.a(this.jdField_a_of_type_Asfu), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.jumpUrl);
    asfu.a(this.jdField_a_of_type_Asfu).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgd
 * JD-Core Version:    0.7.0.1
 */