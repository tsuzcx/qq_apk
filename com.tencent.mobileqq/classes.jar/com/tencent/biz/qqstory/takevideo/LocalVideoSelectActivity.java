package com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.OnRangeValueChangeListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;

public class LocalVideoSelectActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, ScrollFrameSelectBar.OnRangeValueChangeListener
{
  public int a;
  public long a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
  private ScrollFrameSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public long b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private boolean c;
  public int d;
  private boolean d;
  private int e;
  private int f;
  private int g = 0;
  private int h = -1;
  private int i = -1;
  
  public LocalVideoSelectActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void a()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363668));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363666));
    this.jdField_d_of_type_Boolean = LiuHaiUtils.a(this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
  }
  
  private void b()
  {
    finish();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    if ((this.h < 0) || (this.i < 0))
    {
      this.h = paramInt1;
      this.i = paramInt2;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)Math.floor((paramInt2 - paramInt1) / 1000.0F);
    paramInt2 = (int)Math.ceil(paramInt1 / 10.0F);
    String str;
    if (this.jdField_c_of_type_Boolean) {
      str = String.format(HardCodeUtil.a(2131706376), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    } else {
      str = String.format(HardCodeUtil.a(2131706377), new Object[] { Integer.valueOf(paramInt1) });
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    b();
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  protected boolean doOnCreate(@android.support.annotation.Nullable android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 162	com/tencent/util/LiuHaiUtils:a	(Landroid/app/Activity;)V
    //   4: aload_0
    //   5: invokevirtual 166	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getWindow	()Landroid/view/Window;
    //   8: sipush 1024
    //   11: invokevirtual 172	android/view/Window:addFlags	(I)V
    //   14: invokestatic 175	com/tencent/util/LiuHaiUtils:c	()Z
    //   17: ifeq +7 -> 24
    //   20: aload_0
    //   21: invokestatic 177	com/tencent/util/LiuHaiUtils:b	(Landroid/app/Activity;)V
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 180	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:mNeedStatusTrans	Z
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 183	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:mActNeedImmersive	Z
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 186	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:isClearCoverLayer	Z
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 188	com/tencent/biz/qqstory/storyHome/QQStoryBaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   44: pop
    //   45: aload_0
    //   46: aload_0
    //   47: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   50: ldc 194
    //   52: iconst_0
    //   53: invokevirtual 200	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   56: putfield 202	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_b_of_type_Boolean	Z
    //   59: aload_0
    //   60: aload_0
    //   61: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   64: ldc 204
    //   66: iconst_0
    //   67: invokevirtual 208	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   70: putfield 35	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:g	I
    //   73: aload_0
    //   74: aload_0
    //   75: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   78: ldc 210
    //   80: iconst_0
    //   81: invokevirtual 208	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   84: putfield 212	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_b_of_type_Int	I
    //   87: aload_0
    //   88: aload_0
    //   89: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   92: ldc 214
    //   94: iconst_0
    //   95: invokevirtual 208	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   98: putfield 216	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_c_of_type_Int	I
    //   101: aload_0
    //   102: aload_0
    //   103: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   106: ldc 218
    //   108: iconst_0
    //   109: invokevirtual 208	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   112: putfield 220	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_Int	I
    //   115: aload_0
    //   116: aload_0
    //   117: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   120: ldc 222
    //   122: iconst_0
    //   123: invokevirtual 208	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   126: putfield 224	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_d_of_type_Int	I
    //   129: aload_0
    //   130: aload_0
    //   131: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   134: ldc 226
    //   136: invokevirtual 230	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   139: putfield 232	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   142: aload_0
    //   143: aload_0
    //   144: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   147: ldc 234
    //   149: lconst_0
    //   150: invokevirtual 238	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   153: putfield 240	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_Long	J
    //   156: aload_0
    //   157: aload_0
    //   158: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   161: ldc 242
    //   163: lconst_0
    //   164: invokevirtual 238	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   167: putfield 244	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_b_of_type_Long	J
    //   170: aload_0
    //   171: ldc 245
    //   173: invokevirtual 248	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:setContentViewC	(I)V
    //   176: ldc 250
    //   178: ldc 252
    //   180: invokestatic 257	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_0
    //   184: invokespecial 259	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:a	()V
    //   187: aload_0
    //   188: aload_0
    //   189: ldc_w 260
    //   192: invokevirtual 67	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   195: checkcast 262	android/widget/ImageView
    //   198: putfield 50	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   201: aload_0
    //   202: aload_0
    //   203: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   206: ldc_w 264
    //   209: invokevirtual 268	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   212: checkcast 270	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   215: putfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   218: aload_0
    //   219: aload_0
    //   220: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   223: getfield 273	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   226: putfield 62	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   229: new 275	android/media/MediaMetadataRetriever
    //   232: dup
    //   233: invokespecial 276	android/media/MediaMetadataRetriever:<init>	()V
    //   236: astore_1
    //   237: aload_1
    //   238: aload_0
    //   239: getfield 62	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   242: invokevirtual 280	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   249: aload_1
    //   250: bipush 19
    //   252: invokevirtual 283	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   255: invokestatic 287	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   258: putfield 290	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   261: aload_0
    //   262: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   265: aload_1
    //   266: bipush 18
    //   268: invokevirtual 283	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   271: invokestatic 287	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   274: putfield 293	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   277: aload_0
    //   278: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   281: aload_1
    //   282: bipush 24
    //   284: invokevirtual 283	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   287: invokestatic 287	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   290: putfield 296	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   293: goto +18 -> 311
    //   296: astore_2
    //   297: goto +467 -> 764
    //   300: astore_2
    //   301: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +7 -> 311
    //   307: aload_2
    //   308: invokevirtual 304	java/lang/Exception:printStackTrace	()V
    //   311: aload_1
    //   312: invokevirtual 307	android/media/MediaMetadataRetriever:release	()V
    //   315: aload_0
    //   316: aload_0
    //   317: ldc_w 308
    //   320: invokevirtual 67	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   323: checkcast 69	android/widget/LinearLayout
    //   326: putfield 310	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   329: aload_0
    //   330: aload_0
    //   331: ldc_w 311
    //   334: invokevirtual 67	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   337: checkcast 313	android/widget/Button
    //   340: putfield 315	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   343: aload_0
    //   344: aload_0
    //   345: ldc_w 316
    //   348: invokevirtual 67	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   351: checkcast 128	android/widget/TextView
    //   354: putfield 126	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   357: aload_0
    //   358: aload_0
    //   359: ldc_w 317
    //   362: invokevirtual 67	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   365: checkcast 319	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar
    //   368: putfield 56	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   371: aload_0
    //   372: getfield 56	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   375: sipush 2000
    //   378: invokevirtual 322	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:setMinDuration	(I)V
    //   381: aload_0
    //   382: getfield 43	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_d_of_type_Boolean	Z
    //   385: ifeq +27 -> 412
    //   388: aload_0
    //   389: getfield 56	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   392: invokevirtual 326	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   395: checkcast 328	android/widget/LinearLayout$LayoutParams
    //   398: astore_1
    //   399: aload_1
    //   400: iconst_0
    //   401: putfield 331	android/widget/LinearLayout$LayoutParams:bottomMargin	I
    //   404: aload_0
    //   405: getfield 56	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   408: aload_1
    //   409: invokevirtual 335	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   412: aload_0
    //   413: aload_0
    //   414: ldc_w 336
    //   417: invokevirtual 67	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   420: checkcast 338	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView
    //   423: putfield 53	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   426: aload_0
    //   427: getfield 315	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   430: aload_0
    //   431: invokevirtual 342	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   434: aload_0
    //   435: getfield 310	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   438: aload_0
    //   439: invokevirtual 343	android/widget/LinearLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   442: aload_0
    //   443: getfield 56	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   446: aload_0
    //   447: invokevirtual 347	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:setOnRangeValueChangeListener	(Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar$OnRangeValueChangeListener;)V
    //   450: aload_0
    //   451: getfield 56	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   454: new 349	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$1
    //   457: dup
    //   458: aload_0
    //   459: invokespecial 352	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$1:<init>	(Lcom/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity;)V
    //   462: invokevirtual 356	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:post	(Ljava/lang/Runnable;)Z
    //   465: pop
    //   466: aload_0
    //   467: getfield 53	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   470: aload_0
    //   471: getfield 62	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   474: invokevirtual 359	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:setVideoPath	(Ljava/lang/String;)V
    //   477: aload_0
    //   478: getfield 43	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_d_of_type_Boolean	Z
    //   481: ifeq +99 -> 580
    //   484: aload_0
    //   485: ldc_w 360
    //   488: invokevirtual 67	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   491: checkcast 74	android/widget/RelativeLayout
    //   494: astore_1
    //   495: aload_1
    //   496: invokevirtual 364	android/widget/RelativeLayout:getParent	()Landroid/view/ViewParent;
    //   499: checkcast 366	android/view/ViewGroup
    //   502: aload_1
    //   503: invokevirtual 370	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   506: aload_1
    //   507: invokevirtual 371	android/widget/RelativeLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   510: astore_2
    //   511: new 373	android/widget/RelativeLayout$LayoutParams
    //   514: dup
    //   515: aload_2
    //   516: getfield 378	android/view/ViewGroup$LayoutParams:width	I
    //   519: aload_2
    //   520: getfield 381	android/view/ViewGroup$LayoutParams:height	I
    //   523: invokespecial 383	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   526: astore_2
    //   527: aload_2
    //   528: ldc_w 384
    //   531: invokestatic 389	com/tencent/mobileqq/utils/ViewUtils:a	(F)I
    //   534: putfield 392	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   537: aload_2
    //   538: ldc_w 393
    //   541: invokestatic 389	com/tencent/mobileqq/utils/ViewUtils:a	(F)I
    //   544: putfield 396	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   547: aload_2
    //   548: ldc_w 393
    //   551: invokestatic 389	com/tencent/mobileqq/utils/ViewUtils:a	(F)I
    //   554: putfield 399	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   557: aload_2
    //   558: bipush 10
    //   560: iconst_m1
    //   561: invokevirtual 402	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   564: aload_2
    //   565: bipush 12
    //   567: iconst_0
    //   568: invokevirtual 402	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   571: aload_0
    //   572: getfield 76	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   575: aload_1
    //   576: aload_2
    //   577: invokevirtual 406	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   580: aload_0
    //   581: invokevirtual 192	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   584: ldc_w 408
    //   587: invokevirtual 230	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   590: astore_1
    //   591: ldc_w 410
    //   594: aload_1
    //   595: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifne +48 -> 646
    //   601: ldc_w 416
    //   604: aload_1
    //   605: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   608: ifne +38 -> 646
    //   611: aload_0
    //   612: aload_0
    //   613: getfield 53	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   616: aload_0
    //   617: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   620: getfield 296	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   623: aload_0
    //   624: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   627: getfield 293	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   630: aload_0
    //   631: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   634: getfield 290	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   637: invokevirtual 419	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:a	(III)Z
    //   640: putfield 84	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_Boolean	Z
    //   643: goto +11 -> 654
    //   646: aload_0
    //   647: getfield 53	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   650: iconst_1
    //   651: invokevirtual 423	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:setCenterInside	(Z)V
    //   654: aload_0
    //   655: getfield 50	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   658: getstatic 429	android/widget/ImageView$ScaleType:FIT_CENTER	Landroid/widget/ImageView$ScaleType;
    //   661: invokevirtual 433	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   664: aload_0
    //   665: aload_0
    //   666: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   669: getfield 290	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   672: aload_0
    //   673: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   676: getfield 293	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   679: invokestatic 437	java/lang/Math:min	(II)I
    //   682: putfield 47	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:e	I
    //   685: aload_0
    //   686: aload_0
    //   687: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   690: getfield 290	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   693: aload_0
    //   694: getfield 59	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   697: getfield 293	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   700: invokestatic 440	java/lang/Math:max	(II)I
    //   703: putfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:f	I
    //   706: aload_0
    //   707: getfield 56	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   710: aload_0
    //   711: getfield 53	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   714: invokevirtual 444	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:setLocalVideoView	(Lcom/tencent/biz/qqstory/playvideo/player/TrimTextureVideoView;)V
    //   717: aload_0
    //   718: getfield 53	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   721: new 446	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$2
    //   724: dup
    //   725: aload_0
    //   726: invokespecial 447	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$2:<init>	(Lcom/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity;)V
    //   729: invokevirtual 451	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:setOnPreparedListener	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnPreparedListener;)V
    //   732: aload_0
    //   733: getfield 53	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   736: new 453	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$3
    //   739: dup
    //   740: aload_0
    //   741: invokespecial 454	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$3:<init>	(Lcom/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity;)V
    //   744: invokevirtual 458	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:setOnErrorListener	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnErrorListener;)V
    //   747: ldc_w 460
    //   750: ldc_w 462
    //   753: iconst_0
    //   754: iconst_0
    //   755: iconst_0
    //   756: anewarray 119	java/lang/String
    //   759: invokestatic 467	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   762: iconst_0
    //   763: ireturn
    //   764: aload_1
    //   765: invokevirtual 307	android/media/MediaMetadataRetriever:release	()V
    //   768: aload_2
    //   769: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	this	LocalVideoSelectActivity
    //   0	770	1	paramBundle	android.os.Bundle
    //   296	1	2	localObject1	Object
    //   300	8	2	localException	java.lang.Exception
    //   510	259	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   237	293	296	finally
    //   301	311	296	finally
    //   237	293	300	java/lang/Exception
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.e();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    TrimTextureVideoView localTrimTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
    if ((localTrimTextureVideoView != null) && (!localTrimTextureVideoView.isPlaying())) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(false);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    TrimTextureVideoView localTrimTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
    if (localTrimTextureVideoView != null) {
      localTrimTextureVideoView.b();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (((paramInt1 == 10002) || (paramInt1 == 10012) || (paramInt1 == 10013)) && (paramInt2 == -1))
    {
      SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult from edit video activity, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    SLog.b("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
        int j = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b();
        int k = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
        int m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.c();
        int n = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a();
        int i1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.b();
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("start_time", j);
        ((Intent)localObject).putExtra("end_time", k);
        ((Intent)localObject).putExtra("video_index", this.g);
        ((Intent)localObject).putExtra("start_index", n);
        ((Intent)localObject).putExtra("end_index", i1);
        ((Intent)localObject).putExtra("scroll_x", m);
        setResult(-1, (Intent)localObject);
        m = this.jdField_d_of_type_Int;
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append("-");
        localStringBuilder.append(k);
        StoryReportor.a("pic_choose", "done_cutVideo", m, 0, new String[] { localObject, localStringBuilder.toString() });
        finish();
      }
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetLinearLayout) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity
 * JD-Core Version:    0.7.0.1
 */