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
  public int b;
  public int c;
  public int d;
  public String e;
  public long f;
  public long g;
  private TrimTextureVideoView h;
  private ScrollFrameSelectBar i;
  private String j;
  private Button k;
  private TextView l;
  private LinearLayout m;
  private LocalMediaInfo n;
  private int o;
  private int p;
  private ImageView q;
  private boolean r;
  private boolean s;
  private int t = 0;
  private int u = -1;
  private int v = -1;
  private boolean w = false;
  private RelativeLayout x;
  private LinearLayout y;
  private boolean z = false;
  
  private void a()
  {
    this.z = false;
    this.y = ((LinearLayout)findViewById(2131429581));
    this.x = ((RelativeLayout)findViewById(2131429579));
    this.z = LiuHaiUtils.a(this.y, this.x, 0);
  }
  
  private void b()
  {
    finish();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    if ((this.u < 0) || (this.v < 0))
    {
      this.u = paramInt1;
      this.v = paramInt2;
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
    if (this.w) {
      str = String.format(HardCodeUtil.a(2131904235), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    } else {
      str = String.format(HardCodeUtil.a(2131904236), new Object[] { Integer.valueOf(paramInt1) });
    }
    this.l.setText(str);
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
    //   1: invokestatic 179	com/tencent/util/LiuHaiUtils:f	(Landroid/app/Activity;)V
    //   4: aload_0
    //   5: invokevirtual 183	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getWindow	()Landroid/view/Window;
    //   8: sipush 1024
    //   11: invokevirtual 189	android/view/Window:addFlags	(I)V
    //   14: invokestatic 192	com/tencent/util/LiuHaiUtils:c	()Z
    //   17: ifeq +7 -> 24
    //   20: aload_0
    //   21: invokestatic 194	com/tencent/util/LiuHaiUtils:g	(Landroid/app/Activity;)V
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 197	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:mNeedStatusTrans	Z
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 200	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:mActNeedImmersive	Z
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 203	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:isClearCoverLayer	Z
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 205	com/tencent/biz/qqstory/storyHome/QQStoryBaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   44: pop
    //   45: aload_0
    //   46: aload_0
    //   47: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   50: ldc 211
    //   52: iconst_0
    //   53: invokevirtual 217	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   56: putfield 219	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:s	Z
    //   59: aload_0
    //   60: aload_0
    //   61: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   64: ldc 221
    //   66: iconst_0
    //   67: invokevirtual 225	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   70: putfield 52	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:t	I
    //   73: aload_0
    //   74: aload_0
    //   75: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   78: ldc 227
    //   80: iconst_0
    //   81: invokevirtual 225	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   84: putfield 229	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:b	I
    //   87: aload_0
    //   88: aload_0
    //   89: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   92: ldc 231
    //   94: iconst_0
    //   95: invokevirtual 225	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   98: putfield 233	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:c	I
    //   101: aload_0
    //   102: aload_0
    //   103: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   106: ldc 235
    //   108: iconst_0
    //   109: invokevirtual 225	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   112: putfield 237	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:a	I
    //   115: aload_0
    //   116: aload_0
    //   117: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   120: ldc 239
    //   122: iconst_0
    //   123: invokevirtual 225	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   126: putfield 241	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:d	I
    //   129: aload_0
    //   130: aload_0
    //   131: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   134: ldc 243
    //   136: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   139: putfield 249	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:e	Ljava/lang/String;
    //   142: aload_0
    //   143: aload_0
    //   144: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   147: ldc 251
    //   149: lconst_0
    //   150: invokevirtual 255	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   153: putfield 257	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:f	J
    //   156: aload_0
    //   157: aload_0
    //   158: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   161: ldc_w 259
    //   164: lconst_0
    //   165: invokevirtual 255	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   168: putfield 261	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:g	J
    //   171: aload_0
    //   172: ldc_w 262
    //   175: invokevirtual 265	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:setContentViewC	(I)V
    //   178: ldc_w 267
    //   181: ldc_w 269
    //   184: invokestatic 274	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: invokespecial 276	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:a	()V
    //   191: aload_0
    //   192: aload_0
    //   193: ldc_w 277
    //   196: invokevirtual 69	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   199: checkcast 279	android/widget/ImageView
    //   202: putfield 103	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:q	Landroid/widget/ImageView;
    //   205: aload_0
    //   206: aload_0
    //   207: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   210: ldc_w 281
    //   213: invokevirtual 285	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   216: checkcast 287	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   219: putfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   227: getfield 290	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   230: putfield 64	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:j	Ljava/lang/String;
    //   233: new 292	android/media/MediaMetadataRetriever
    //   236: dup
    //   237: invokespecial 293	android/media/MediaMetadataRetriever:<init>	()V
    //   240: astore_1
    //   241: aload_1
    //   242: aload_0
    //   243: getfield 64	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:j	Ljava/lang/String;
    //   246: invokevirtual 297	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   249: aload_0
    //   250: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   253: aload_1
    //   254: bipush 19
    //   256: invokevirtual 300	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   259: invokestatic 304	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   262: putfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   265: aload_0
    //   266: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   269: aload_1
    //   270: bipush 18
    //   272: invokevirtual 300	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   275: invokestatic 304	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   278: putfield 310	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   281: aload_0
    //   282: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   285: aload_1
    //   286: bipush 24
    //   288: invokevirtual 300	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   291: invokestatic 304	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   294: putfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   297: goto +18 -> 315
    //   300: astore_2
    //   301: goto +467 -> 768
    //   304: astore_2
    //   305: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +7 -> 315
    //   311: aload_2
    //   312: invokevirtual 321	java/lang/Exception:printStackTrace	()V
    //   315: aload_1
    //   316: invokevirtual 324	android/media/MediaMetadataRetriever:release	()V
    //   319: aload_0
    //   320: aload_0
    //   321: ldc_w 325
    //   324: invokevirtual 69	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   327: checkcast 71	android/widget/LinearLayout
    //   330: putfield 327	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:m	Landroid/widget/LinearLayout;
    //   333: aload_0
    //   334: aload_0
    //   335: ldc_w 328
    //   338: invokevirtual 69	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   341: checkcast 330	android/widget/Button
    //   344: putfield 332	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:k	Landroid/widget/Button;
    //   347: aload_0
    //   348: aload_0
    //   349: ldc_w 333
    //   352: invokevirtual 69	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   355: checkcast 145	android/widget/TextView
    //   358: putfield 143	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:l	Landroid/widget/TextView;
    //   361: aload_0
    //   362: aload_0
    //   363: ldc_w 334
    //   366: invokevirtual 69	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   369: checkcast 336	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar
    //   372: putfield 100	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:i	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   375: aload_0
    //   376: getfield 100	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:i	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   379: sipush 2000
    //   382: invokevirtual 339	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:setMinDuration	(I)V
    //   385: aload_0
    //   386: getfield 60	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:z	Z
    //   389: ifeq +27 -> 416
    //   392: aload_0
    //   393: getfield 100	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:i	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   396: invokevirtual 343	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   399: checkcast 345	android/widget/LinearLayout$LayoutParams
    //   402: astore_1
    //   403: aload_1
    //   404: iconst_0
    //   405: putfield 348	android/widget/LinearLayout$LayoutParams:bottomMargin	I
    //   408: aload_0
    //   409: getfield 100	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:i	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   412: aload_1
    //   413: invokevirtual 352	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   416: aload_0
    //   417: aload_0
    //   418: ldc_w 353
    //   421: invokevirtual 69	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   424: checkcast 355	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView
    //   427: putfield 106	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:h	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   430: aload_0
    //   431: getfield 332	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:k	Landroid/widget/Button;
    //   434: aload_0
    //   435: invokevirtual 359	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   438: aload_0
    //   439: getfield 327	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:m	Landroid/widget/LinearLayout;
    //   442: aload_0
    //   443: invokevirtual 360	android/widget/LinearLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   446: aload_0
    //   447: getfield 100	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:i	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   450: aload_0
    //   451: invokevirtual 364	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:setOnRangeValueChangeListener	(Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar$OnRangeValueChangeListener;)V
    //   454: aload_0
    //   455: getfield 100	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:i	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   458: new 366	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$1
    //   461: dup
    //   462: aload_0
    //   463: invokespecial 369	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$1:<init>	(Lcom/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity;)V
    //   466: invokevirtual 373	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:post	(Ljava/lang/Runnable;)Z
    //   469: pop
    //   470: aload_0
    //   471: getfield 106	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:h	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   474: aload_0
    //   475: getfield 64	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:j	Ljava/lang/String;
    //   478: invokevirtual 376	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:setVideoPath	(Ljava/lang/String;)V
    //   481: aload_0
    //   482: getfield 60	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:z	Z
    //   485: ifeq +99 -> 584
    //   488: aload_0
    //   489: ldc_w 377
    //   492: invokevirtual 69	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:findViewById	(I)Landroid/view/View;
    //   495: checkcast 76	android/widget/RelativeLayout
    //   498: astore_1
    //   499: aload_1
    //   500: invokevirtual 381	android/widget/RelativeLayout:getParent	()Landroid/view/ViewParent;
    //   503: checkcast 383	android/view/ViewGroup
    //   506: aload_1
    //   507: invokevirtual 387	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   510: aload_1
    //   511: invokevirtual 388	android/widget/RelativeLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   514: astore_2
    //   515: new 390	android/widget/RelativeLayout$LayoutParams
    //   518: dup
    //   519: aload_2
    //   520: getfield 395	android/view/ViewGroup$LayoutParams:width	I
    //   523: aload_2
    //   524: getfield 398	android/view/ViewGroup$LayoutParams:height	I
    //   527: invokespecial 400	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   530: astore_2
    //   531: aload_2
    //   532: ldc_w 401
    //   535: invokestatic 407	com/tencent/mobileqq/utils/ViewUtils:dip2px	(F)I
    //   538: putfield 410	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   541: aload_2
    //   542: ldc_w 411
    //   545: invokestatic 407	com/tencent/mobileqq/utils/ViewUtils:dip2px	(F)I
    //   548: putfield 414	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   551: aload_2
    //   552: ldc_w 411
    //   555: invokestatic 407	com/tencent/mobileqq/utils/ViewUtils:dip2px	(F)I
    //   558: putfield 417	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   561: aload_2
    //   562: bipush 10
    //   564: iconst_m1
    //   565: invokevirtual 420	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   568: aload_2
    //   569: bipush 12
    //   571: iconst_0
    //   572: invokevirtual 420	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   575: aload_0
    //   576: getfield 78	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:x	Landroid/widget/RelativeLayout;
    //   579: aload_1
    //   580: aload_2
    //   581: invokevirtual 424	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   584: aload_0
    //   585: invokevirtual 209	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getIntent	()Landroid/content/Intent;
    //   588: ldc_w 426
    //   591: invokevirtual 247	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   594: astore_1
    //   595: ldc_w 428
    //   598: aload_1
    //   599: invokevirtual 432	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   602: ifne +48 -> 650
    //   605: ldc_w 434
    //   608: aload_1
    //   609: invokevirtual 432	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   612: ifne +38 -> 650
    //   615: aload_0
    //   616: aload_0
    //   617: getfield 106	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:h	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   620: aload_0
    //   621: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   624: getfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   627: aload_0
    //   628: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   631: getfield 310	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   634: aload_0
    //   635: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   638: getfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   641: invokevirtual 437	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:a	(III)Z
    //   644: putfield 97	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:r	Z
    //   647: goto +11 -> 658
    //   650: aload_0
    //   651: getfield 106	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:h	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   654: iconst_1
    //   655: invokevirtual 441	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:setCenterInside	(Z)V
    //   658: aload_0
    //   659: getfield 103	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:q	Landroid/widget/ImageView;
    //   662: getstatic 447	android/widget/ImageView$ScaleType:FIT_CENTER	Landroid/widget/ImageView$ScaleType;
    //   665: invokevirtual 451	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   668: aload_0
    //   669: aload_0
    //   670: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   673: getfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   676: aload_0
    //   677: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   680: getfield 310	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   683: invokestatic 455	java/lang/Math:min	(II)I
    //   686: putfield 92	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:o	I
    //   689: aload_0
    //   690: aload_0
    //   691: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   694: getfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   697: aload_0
    //   698: getfield 86	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:n	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   701: getfield 310	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   704: invokestatic 458	java/lang/Math:max	(II)I
    //   707: putfield 94	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:p	I
    //   710: aload_0
    //   711: getfield 100	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:i	Lcom/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar;
    //   714: aload_0
    //   715: getfield 106	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:h	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   718: invokevirtual 462	com/tencent/biz/qqstory/takevideo/view/widget/frameSelectBar/ScrollFrameSelectBar:setLocalVideoView	(Lcom/tencent/biz/qqstory/playvideo/player/TrimTextureVideoView;)V
    //   721: aload_0
    //   722: getfield 106	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:h	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   725: new 464	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$2
    //   728: dup
    //   729: aload_0
    //   730: invokespecial 465	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$2:<init>	(Lcom/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity;)V
    //   733: invokevirtual 469	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:setOnPreparedListener	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnPreparedListener;)V
    //   736: aload_0
    //   737: getfield 106	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:h	Lcom/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView;
    //   740: new 471	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$3
    //   743: dup
    //   744: aload_0
    //   745: invokespecial 472	com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity$3:<init>	(Lcom/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity;)V
    //   748: invokevirtual 476	com/tencent/biz/qqstory/boundaries/extension/widgets/TrimTextureVideoView:setOnErrorListener	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/wrapper/IMediaPlayer$OnErrorListener;)V
    //   751: ldc_w 478
    //   754: ldc_w 480
    //   757: iconst_0
    //   758: iconst_0
    //   759: iconst_0
    //   760: anewarray 136	java/lang/String
    //   763: invokestatic 485	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   766: iconst_0
    //   767: ireturn
    //   768: aload_1
    //   769: invokevirtual 324	android/media/MediaMetadataRetriever:release	()V
    //   772: aload_2
    //   773: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	774	0	this	LocalVideoSelectActivity
    //   0	774	1	paramBundle	android.os.Bundle
    //   300	1	2	localObject1	Object
    //   304	8	2	localException	java.lang.Exception
    //   514	259	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   241	297	300	finally
    //   305	315	300	finally
    //   241	297	304	java/lang/Exception
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.i.e();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    TrimTextureVideoView localTrimTextureVideoView = this.h;
    if ((localTrimTextureVideoView != null) && (!localTrimTextureVideoView.isPlaying())) {
      this.h.a(false);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    TrimTextureVideoView localTrimTextureVideoView = this.h;
    if (localTrimTextureVideoView != null) {
      localTrimTextureVideoView.c();
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
    if (paramView == this.k)
    {
      if (this.s)
      {
        this.h.b();
        int i1 = this.h.getStartTime();
        int i2 = this.h.getEndTime();
        int i3 = this.i.getRangeScrollX();
        int i4 = this.i.getStartIndex();
        int i5 = this.i.getEndIndex();
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("start_time", i1);
        ((Intent)localObject).putExtra("end_time", i2);
        ((Intent)localObject).putExtra("video_index", this.t);
        ((Intent)localObject).putExtra("start_index", i4);
        ((Intent)localObject).putExtra("end_index", i5);
        ((Intent)localObject).putExtra("scroll_x", i3);
        setResult(-1, (Intent)localObject);
        i3 = this.d;
        localObject = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i1);
        localStringBuilder.append("-");
        localStringBuilder.append(i2);
        StoryReportor.a("pic_choose", "done_cutVideo", i3, 0, new String[] { localObject, localStringBuilder.toString() });
        finish();
      }
    }
    else if (paramView == this.m) {
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