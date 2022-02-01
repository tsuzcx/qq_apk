package com.tencent.biz.qqcircle.widgets;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCircleFollowFakeInterceptor;
import com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCircleFollowFakeInterceptor.FakeFollowRsp;
import com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCircleFollowRspInterceptor;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.VerticalCenterImageSpan;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper.OnThemeUpdateListener;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

public class QCircleFollowView
  extends TextView
  implements View.OnClickListener, SimpleEventReceiver, Call.OnRspCallBack, QCircleSkinHelper.OnThemeUpdateListener
{
  protected FeedCloudMeta.StUser a;
  private Drawable b;
  private FeedCloudMeta.StFeed c;
  private QCircleFollowView.ItemPreClickListener d;
  private QCircleFollowView.FollowReportListener e;
  private QCircleFollowView.FollowChangeListener f;
  private boolean g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private String n;
  private boolean o;
  private boolean p;
  private String q;
  private int r;
  private int s;
  private String t;
  
  static {}
  
  public QCircleFollowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public QCircleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 61	android/widget/TextView:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 63	feedcloud/FeedCloudMeta$StUser
    //   11: dup
    //   12: invokespecial 65	feedcloud/FeedCloudMeta$StUser:<init>	()V
    //   15: putfield 67	com/tencent/biz/qqcircle/widgets/QCircleFollowView:a	Lfeedcloud/FeedCloudMeta$StUser;
    //   18: aload_0
    //   19: new 69	feedcloud/FeedCloudMeta$StFeed
    //   22: dup
    //   23: invokespecial 70	feedcloud/FeedCloudMeta$StFeed:<init>	()V
    //   26: putfield 72	com/tencent/biz/qqcircle/widgets/QCircleFollowView:c	Lfeedcloud/FeedCloudMeta$StFeed;
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 74	com/tencent/biz/qqcircle/widgets/QCircleFollowView:p	Z
    //   34: aload_0
    //   35: ldc 76
    //   37: ldc 78
    //   39: iconst_1
    //   40: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: invokestatic 89	com/tencent/qcircle/cooperation/config/QCircleConfigHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;
    //   46: invokevirtual 93	java/lang/Integer:intValue	()I
    //   49: putfield 95	com/tencent/biz/qqcircle/widgets/QCircleFollowView:r	I
    //   52: aload_0
    //   53: ldc 96
    //   55: putfield 98	com/tencent/biz/qqcircle/widgets/QCircleFollowView:s	I
    //   58: aconst_null
    //   59: astore 4
    //   61: aconst_null
    //   62: astore 5
    //   64: aload_1
    //   65: aload_2
    //   66: getstatic 104	com/tencent/mobileqq/biz/qcircle/R$styleable:cw	[I
    //   69: invokevirtual 110	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   72: astore_1
    //   73: aload_1
    //   74: astore 5
    //   76: aload_1
    //   77: astore 4
    //   79: aload_0
    //   80: aload_1
    //   81: getstatic 113	com/tencent/mobileqq/biz/qcircle/R$styleable:cz	I
    //   84: ldc 114
    //   86: invokevirtual 120	android/content/res/TypedArray:getResourceId	(II)I
    //   89: putfield 122	com/tencent/biz/qqcircle/widgets/QCircleFollowView:i	I
    //   92: aload_1
    //   93: astore 5
    //   95: aload_1
    //   96: astore 4
    //   98: aload_0
    //   99: aload_1
    //   100: getstatic 125	com/tencent/mobileqq/biz/qcircle/R$styleable:cC	I
    //   103: ldc 126
    //   105: invokevirtual 120	android/content/res/TypedArray:getResourceId	(II)I
    //   108: putfield 128	com/tencent/biz/qqcircle/widgets/QCircleFollowView:h	I
    //   111: aload_1
    //   112: astore 5
    //   114: aload_1
    //   115: astore 4
    //   117: aload_0
    //   118: aload_1
    //   119: getstatic 131	com/tencent/mobileqq/biz/qcircle/R$styleable:cx	I
    //   122: ldc 132
    //   124: invokevirtual 120	android/content/res/TypedArray:getResourceId	(II)I
    //   127: putfield 134	com/tencent/biz/qqcircle/widgets/QCircleFollowView:k	I
    //   130: aload_1
    //   131: astore 5
    //   133: aload_1
    //   134: astore 4
    //   136: aload_0
    //   137: aload_1
    //   138: getstatic 137	com/tencent/mobileqq/biz/qcircle/R$styleable:cy	I
    //   141: ldc 138
    //   143: invokevirtual 120	android/content/res/TypedArray:getResourceId	(II)I
    //   146: putfield 140	com/tencent/biz/qqcircle/widgets/QCircleFollowView:j	I
    //   149: aload_1
    //   150: astore 5
    //   152: aload_1
    //   153: astore 4
    //   155: aload_0
    //   156: aload_1
    //   157: getstatic 143	com/tencent/mobileqq/biz/qcircle/R$styleable:cA	I
    //   160: ldc 144
    //   162: invokevirtual 120	android/content/res/TypedArray:getResourceId	(II)I
    //   165: putfield 146	com/tencent/biz/qqcircle/widgets/QCircleFollowView:l	I
    //   168: aload_1
    //   169: astore 5
    //   171: aload_1
    //   172: astore 4
    //   174: aload_0
    //   175: aload_1
    //   176: getstatic 149	com/tencent/mobileqq/biz/qcircle/R$styleable:cD	I
    //   179: ldc 150
    //   181: invokevirtual 120	android/content/res/TypedArray:getResourceId	(II)I
    //   184: putfield 152	com/tencent/biz/qqcircle/widgets/QCircleFollowView:m	I
    //   187: aload_1
    //   188: astore 5
    //   190: aload_1
    //   191: astore 4
    //   193: aload_0
    //   194: aload_1
    //   195: getstatic 155	com/tencent/mobileqq/biz/qcircle/R$styleable:cB	I
    //   198: iconst_0
    //   199: invokevirtual 159	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   202: putfield 161	com/tencent/biz/qqcircle/widgets/QCircleFollowView:o	Z
    //   205: aload_1
    //   206: ifnull +31 -> 237
    //   209: goto +24 -> 233
    //   212: astore_1
    //   213: goto +29 -> 242
    //   216: astore_1
    //   217: aload 4
    //   219: astore 5
    //   221: aload_1
    //   222: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   225: aload 4
    //   227: ifnull +10 -> 237
    //   230: aload 4
    //   232: astore_1
    //   233: aload_1
    //   234: invokevirtual 167	android/content/res/TypedArray:recycle	()V
    //   237: aload_0
    //   238: invokevirtual 169	com/tencent/biz/qqcircle/widgets/QCircleFollowView:a	()V
    //   241: return
    //   242: aload 5
    //   244: ifnull +8 -> 252
    //   247: aload 5
    //   249: invokevirtual 167	android/content/res/TypedArray:recycle	()V
    //   252: aload_1
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	QCircleFollowView
    //   0	254	1	paramContext	Context
    //   0	254	2	paramAttributeSet	AttributeSet
    //   0	254	3	paramInt	int
    //   59	172	4	localContext1	Context
    //   62	186	5	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   64	73	212	finally
    //   79	92	212	finally
    //   98	111	212	finally
    //   117	130	212	finally
    //   136	149	212	finally
    //   155	168	212	finally
    //   174	187	212	finally
    //   193	205	212	finally
    //   221	225	212	finally
    //   64	73	216	java/lang/Exception
    //   79	92	216	java/lang/Exception
    //   98	111	216	java/lang/Exception
    //   117	130	216	java/lang/Exception
    //   136	149	216	java/lang/Exception
    //   155	168	216	java/lang/Exception
    //   174	187	216	java/lang/Exception
    //   193	205	216	java/lang/Exception
  }
  
  private void a(int paramInt, int[] paramArrayOfInt, ActionSheet paramActionSheet)
  {
    if (FastClickUtils.a("showUnFollowUserActionSheetClick")) {
      return;
    }
    paramInt = paramArrayOfInt[paramInt];
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          paramArrayOfInt = this.e;
          if (paramArrayOfInt != null) {
            paramArrayOfInt.a();
          }
          b(false);
        }
      }
      else {
        QCircleSpecialFollowManager.a().a(this.a, false);
      }
    }
    else {
      QCircleSpecialFollowManager.a().a(this.a, true);
    }
    paramActionSheet.dismiss();
  }
  
  private void c(int paramInt)
  {
    a(paramInt, true);
    if (this.a != null) {
      QCircleFollowManager.getInstance().setUinFollowed(this.a.id.get(), paramInt);
    }
  }
  
  private boolean e()
  {
    if ((QCirclePluginUtil.c(this.a)) && (this.a.blackState.get() == 2)) {
      return false;
    }
    if ((this.a.blackState.get() != 1) && (this.a.blackState.get() != 3))
    {
      if (this.a.blackState.get() == 2)
      {
        QCircleCustomDialog.a(getContext()).a(2131895729).b(2131895760, new QCircleFollowView.1(this)).show();
        return true;
      }
      return false;
    }
    QCircleToast.a(QCircleToast.b, 2131895728, 0);
    return true;
  }
  
  private void f()
  {
    setTextColor(QCircleSkinHelper.getInstance().getColor(this.l));
    FeedCloudMeta.StUser localStUser = this.a;
    if ((localStUser != null) && ((localStUser.blackState.get() == 1) || (this.a.blackState.get() == 3)))
    {
      setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.k));
      setTextColor(getResources().getColor(2131168476));
    }
    else if (!TextUtils.isEmpty(this.t))
    {
      setBackgroundDrawable(a(this.i, this.t));
    }
    else
    {
      setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.i));
    }
    localStUser = this.a;
    if ((localStUser != null) && (localStUser.followState.get() == 3) && (this.r == 1))
    {
      setText(HardCodeUtil.a(2131895740));
      return;
    }
    setText(HardCodeUtil.a(2131895739));
  }
  
  private void g()
  {
    if (h()) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(getContext());
    int[] arrayOfInt = new int[3];
    int[] tmp23_21 = arrayOfInt;
    tmp23_21[0] = -1;
    int[] tmp27_23 = tmp23_21;
    tmp27_23[1] = -1;
    int[] tmp31_27 = tmp27_23;
    tmp31_27[2] = -1;
    tmp31_27;
    boolean bool = this.o;
    int i1 = 1;
    if ((bool) && (QCirclePluginUtil.c(this.a)) && (this.a.blackState.get() == 0))
    {
      if (this.a.relationState.get() == 0)
      {
        localActionSheet.a(2131895906, 0);
        arrayOfInt[0] = 0;
        break label148;
      }
      if (this.a.relationState.get() == 1)
      {
        localActionSheet.a(2131895645, 0);
        arrayOfInt[0] = 1;
        break label148;
      }
    }
    else
    {
      localActionSheet.a(getContext().getResources().getString(2131895940));
    }
    i1 = 0;
    label148:
    localActionSheet.a(2131895941, 3);
    arrayOfInt[i1] = 2;
    localActionSheet.e(2131887648);
    localActionSheet.a(new QCircleFollowView.3(this, arrayOfInt, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private boolean h()
  {
    return (((getContext() instanceof Activity)) && (((Activity)getContext()).isFinishing())) || (((getContext() instanceof Activity)) && (((Activity)getContext()).isDestroyed()));
  }
  
  protected URLDrawable a(int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = getContext().getResources().getDrawable(paramInt);
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected void a()
  {
    setOnClickListener(this);
    b();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    FeedCloudMeta.StUser localStUser = this.a;
    if (localStUser != null) {
      localStUser.followState.set(paramInt);
    }
    if (this.s == paramInt)
    {
      QLog.d("QCircleFollowView", 1, "isSameUIState");
      return;
    }
    this.s = paramInt;
    b(paramInt);
    if (QCirclePluginUtil.c(paramInt))
    {
      a(paramBoolean);
      return;
    }
    b();
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!QCirclePluginUtil.b(paramStUser)))
    {
      if (QCircleFollowManager.getInstance().hasUin(paramStUser.id.get()))
      {
        boolean bool = QCircleFollowManager.getInstance().isUinFollowed(paramStUser.id.get());
        a(QCircleFollowManager.getInstance().getUinFollowed(paramStUser.id.get()).intValue());
        paramStUser = this.f;
        if (paramStUser != null) {
          paramStUser.onFollowStateChange(bool, this.a);
        }
      }
    }
    else {
      setVisibility(8);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    setVisibility(0);
    f();
    if (this.g)
    {
      if (paramBoolean)
      {
        d();
        return;
      }
      setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doFollow: isSuccess");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("    errMsg:");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    boolean bool = true;
    QLog.d("QCircleFollowView", 1, paramString);
    if ((paramObject2 instanceof QCircleFollowFakeInterceptor.FakeFollowRsp))
    {
      paramString = (QCircleFollowFakeInterceptor.FakeFollowRsp)paramObject2;
      if (paramBoolean) {
        a(paramString.c, true);
      } else {
        a(paramString.b, true);
      }
    }
    if (((paramObject2 instanceof FeedCloudWrite.StDoFollowRsp)) && ((paramObject1 instanceof QCircleDoFollowRequest)) && (paramBundle != null))
    {
      int i1 = paramBundle.getInt(QCircleFollowRspInterceptor.a);
      if ((paramBoolean) && (paramLong == 0L))
      {
        c(i1);
        if (this.a != null)
        {
          paramString = this.f;
          if (paramString != null)
          {
            if (i1 == 1) {
              paramBoolean = bool;
            } else {
              paramBoolean = false;
            }
            paramString.onFollowStateChange(paramBoolean, this.a);
          }
        }
      }
    }
  }
  
  protected void b()
  {
    setVisibility(0);
    setTextColor(QCircleSkinHelper.getInstance().getColor(this.m));
    FeedCloudMeta.StUser localStUser = this.a;
    if ((localStUser != null) && (localStUser.blackState.get() != 0))
    {
      setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.j));
      setTextColor(getResources().getColor(2131168476));
    }
    else if (!TextUtils.isEmpty(this.n))
    {
      setBackgroundDrawable(a(this.h, this.n));
    }
    else
    {
      setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(this.h));
    }
    localStUser = this.a;
    if ((localStUser != null) && (localStUser.followState.get() == 2) && (this.r == 1))
    {
      setText(HardCodeUtil.a(2131895890));
      return;
    }
    setText(HardCodeUtil.a(2131895727));
  }
  
  protected void b(int paramInt)
  {
    VideoReport.setElementId(this, "em_xsj_follow_button");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    if (paramInt == 1) {
      localMap.put("xsj_follow_status", "followed");
    } else if (paramInt == 2) {
      localMap.put("xsj_follow_status", "followback");
    } else if (paramInt == 3) {
      localMap.put("xsj_follow_status", "mutual");
    } else {
      localMap.put("xsj_follow_status", "follow");
    }
    if (!TextUtils.isEmpty(this.q)) {
      localMap.put("xsj_parent_emid", this.q);
    }
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((FeedCloudMeta.StUser)localObject).id.get();
    } else {
      localObject = "";
    }
    localMap.put("xsj_target_qq", localObject);
    VideoReport.setElementParams(this, localMap);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFollowView", 2, "follow");
    }
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      QLog.e("QCircleFollowView", 2, "follow user failed! user is null");
      return;
    }
    int i1 = ((FeedCloudMeta.StUser)localObject1).followState.get() ^ 0x1;
    localObject1 = null;
    if (!TextUtils.isEmpty(this.c.id.get()))
    {
      localObject1 = new FeedCloudCommon.StCommonExt();
      localObject2 = new FeedCloudCommon.Entry();
      ((FeedCloudCommon.Entry)localObject2).key.set("feedid");
      ((FeedCloudCommon.Entry)localObject2).value.set(this.c.id.get());
      ((FeedCloudCommon.StCommonExt)localObject1).mapInfo.get().add(localObject2);
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt(QCircleFollowRspInterceptor.a, i1);
    localObject1 = new QCircleDoFollowRequest(this.a, i1 & 0x1, (FeedCloudCommon.StCommonExt)localObject1);
    QCircleRequestSender.a().b().a(this.p ^ true).b(new QCircleFollowFakeInterceptor(this.p, new QCircleFollowFakeInterceptor.FakeFollowRsp(this.a.id.get(), this.a.followState.get(), i1))).a(new QCircleFollowRspInterceptor()).a((Bundle)localObject2).a(localObject1).a(this).a();
  }
  
  protected void c()
  {
    if ((this.o) && (QCirclePluginUtil.c(this.a)))
    {
      if (this.a.blackState.get() != 0) {
        return;
      }
      if (this.a.relationState.get() == 1)
      {
        setMovementMethod(LinkMovementMethod.getInstance());
        if (this.b == null) {
          this.b = QCircleApplication.APP.getResources().getDrawable(2130841173);
        }
        Object localObject = new Rect(0, 0, ImmersiveUtils.a(14.0F), ImmersiveUtils.a(14.0F));
        this.b.setBounds((Rect)localObject);
        localObject = new VerticalCenterImageSpan(this.b, 0);
        ((VerticalCenterImageSpan)localObject).a(0, ImmersiveUtils.a(2.0F));
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(" ");
        localSpannableStringBuilder.setSpan(localObject, 0, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append(getResources().getString(2131895916));
        setText(localSpannableStringBuilder);
        return;
      }
      a(false);
    }
  }
  
  protected void d()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillEnabled(false);
    startAnimation(localAlphaAnimation);
    RFThreadManager.getUIHandler().postDelayed(new QCircleFollowView.2(this), 500L);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    localArrayList.add(QCircleSpecialFollowUpdateEvent.class);
    return localArrayList;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    return this.c;
  }
  
  public FeedCloudMeta.StUser getUserData()
  {
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      SimpleEventBus.getInstance().registerReceiver(this);
    }
    FeedCloudMeta.StUser localStUser = this.a;
    if (localStUser != null)
    {
      QCircleFollowView.FollowReportListener localFollowReportListener = this.e;
      if (localFollowReportListener != null) {
        localFollowReportListener.a(localStUser.followState.get());
      }
    }
    a(this.a);
    QCircleSkinHelper.getInstance().registerOnThemeUpdateListener(this);
  }
  
  @QCircleFeedClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(u, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    QCircleSkinHelper.getInstance().unregisterOnThemeUpdateListener(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onThemeUpdate()
  {
    if (QCirclePluginUtil.c(this.s))
    {
      a(false);
      return;
    }
    f();
  }
  
  public void setDtParentEmId(String paramString)
  {
    this.q = paramString;
  }
  
  public void setFollowStateChangeListener(QCircleFollowView.FollowChangeListener paramFollowChangeListener)
  {
    this.f = paramFollowChangeListener;
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setFollowedDrawable(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setFollowedRemoteUrl(String paramString)
  {
    this.t = paramString;
  }
  
  public void setItemPreClickListener(QCircleFollowView.ItemPreClickListener paramItemPreClickListener)
  {
    this.d = paramItemPreClickListener;
  }
  
  public void setItemReportListener(QCircleFollowView.FollowReportListener paramFollowReportListener)
  {
    this.e = paramFollowReportListener;
  }
  
  public void setNeedFakeSender(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setUnFollowDrawable(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setUnFollowRemoteUrl(String paramString)
  {
    this.n = paramString;
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    setUserData(paramStUser, new FeedCloudMeta.StFeed());
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStUser != null)
    {
      this.a.id.set(paramStUser.id.get());
      this.a.nick.set(paramStUser.nick.get());
      this.a.blackState.set(paramStUser.blackState.get());
      this.a.relationState.set(paramStUser.relationState.get());
      if ((!TextUtils.isEmpty(paramStUser.id.get())) && (!QCirclePluginUtil.b(paramStUser)))
      {
        this.s = -2147483648;
        if (QCircleFollowManager.getInstance().hasUin(paramStUser.id.get())) {
          a(QCircleFollowManager.getInstance().getUinFollowed(paramStUser.id.get()).intValue());
        } else {
          a(paramStUser.followState.get());
        }
        c();
      }
      else
      {
        setVisibility(8);
      }
    }
    if (paramStFeed != null) {
      this.c = paramStFeed;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowView
 * JD-Core Version:    0.7.0.1
 */