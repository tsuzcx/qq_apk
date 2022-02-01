package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleTextUtils;
import com.tencent.biz.qqcircle.widgets.span.CustomTypeFaceSpan;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleDitto.StBackCardDP;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StCardDetail;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StFlipCard;
import qqcircle.QQCircleDitto.StFrontCardDP;

public class QCircleFatePersonView
  extends QCircleBaseWidgetView
  implements SimpleEventReceiver
{
  private AnimatorSet A;
  private ImageView B;
  private LinearLayout C;
  private View.OnClickListener D = new QCircleFatePersonView.8(this);
  private TextView a;
  private ImageView b;
  private QCircleAvatarView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private QCircleFollowView h;
  private QCircleAvatarView i;
  private TextView j;
  private TextView k;
  private QCircleAsyncTextView l;
  private View m;
  private View n;
  private RoundCornerImageView o;
  private TextView p;
  private ArrayList<TextView> q = null;
  private FeedCloudMeta.StUser r;
  private RoundCornerImageView s;
  private Drawable t;
  private Drawable u;
  private TextView v;
  private SquareImageView w;
  private QQCircleBase.StUserBusiData x;
  private FeedCloudMeta.StFeed y;
  private AnimatorSet z;
  
  public QCircleFatePersonView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    this.m = findViewById(2131436924);
    this.m.getLayoutParams().height = ((int)((ImmersiveUtils.b() - ImmersiveUtils.a(10.0F)) * 0.74F));
    this.c = ((QCircleAvatarView)findViewById(2131433837));
    this.p = ((TextView)findViewById(2131433841));
    this.o = ((RoundCornerImageView)findViewById(2131433839));
    this.o.setCorner(ImmersiveUtils.a(12.0F));
    int i1 = ImmersiveUtils.b();
    int i2 = ImmersiveUtils.a(24.0F);
    Option localOption = new Option().setTargetView(this.o).setRequestHeight((int)((ImmersiveUtils.b() - ImmersiveUtils.a(10.0F)) * 0.74F)).setRequestWidth(i1 - i2).setUrl("https://sola.gtimg.cn/aoi/sola/20200825185657_q0QZfMvpuG.png").setLoadingDrawable(getResources().getDrawable(2130853309)).setPredecode(true);
    QCircleFeedPicLoader.g().loadImage(localOption, null);
    this.d = ((TextView)findViewById(2131433843));
    this.d.setMaxWidth(ImmersiveUtils.b() - ImmersiveUtils.a(80.0F));
    this.f = ((TextView)findViewById(2131433842));
    this.h = ((QCircleFollowView)findViewById(2131433838));
    this.g = ((TextView)findViewById(2131433840));
    this.k = ((TextView)findViewById(2131433844));
    this.h.setFollowStateChangeListener(new QCircleFatePersonView.2(this));
  }
  
  private void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    paramSpannableString.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(2131167085)), paramInt1, paramInt2, 17);
  }
  
  private void a(QQCircleBase.StUserBusiData paramStUserBusiData)
  {
    String str = QCirclePluginUtil.d(paramStUserBusiData.fansNum.get());
    paramStUserBusiData = QCirclePluginUtil.d(paramStUserBusiData.fuelValue.get());
    SpannableString localSpannableString = new SpannableString(String.format("%s 燃值 / %s 粉丝", new Object[] { paramStUserBusiData, str }));
    localSpannableString.setSpan(new CustomTypeFaceSpan(RFWTypefaceUtil.a(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"), ImmersiveUtils.a(14.0F)), 0, paramStUserBusiData.length(), 33);
    localSpannableString.setSpan(new CustomTypeFaceSpan(RFWTypefaceUtil.a(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"), ImmersiveUtils.a(14.0F)), localSpannableString.toString().indexOf("/ "), localSpannableString.toString().indexOf("/ ") + 2 + str.length(), 33);
    a(localSpannableString, localSpannableString.toString().indexOf("/"), localSpannableString.toString().indexOf("/") + 1);
    this.k.setText(localSpannableString);
  }
  
  private void a(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    int i2 = 0;
    if (localLayoutParams != null)
    {
      localLayoutParams = getLayoutParams();
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = -2;
      }
      localLayoutParams.height = i1;
    }
    int i1 = i2;
    if (paramBoolean) {
      i1 = 8;
    }
    setVisibility(i1);
  }
  
  private boolean a(QQCircleDitto.StFrontCardDP paramStFrontCardDP, QQCircleBase.StUserBusiData paramStUserBusiData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList = new ArrayList();
    int i1 = paramStFrontCardDP.recomUser.sex.get();
    boolean bool = false;
    Object localObject;
    if (i1 > 0)
    {
      TextView localTextView = this.k;
      if (paramStFrontCardDP.recomUser.sex.get() == 1) {
        localObject = this.t;
      } else {
        localObject = this.u;
      }
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      i2 = 1;
    }
    else
    {
      this.k.setCompoundDrawables(null, null, null, null);
      i2 = 0;
    }
    paramStFrontCardDP = QCircleTextUtils.a(paramStFrontCardDP.recomUser.location.get());
    i1 = i2;
    if (paramStFrontCardDP.length() > 0)
    {
      i1 = i2 + 1;
      localArrayList.add(Integer.valueOf(localStringBuilder.length()));
      localStringBuilder.append("/");
      localStringBuilder.append(paramStFrontCardDP);
    }
    int i2 = i1;
    if (paramStUserBusiData.schoolInfos.size() > 0)
    {
      i2 = i1 + 1;
      localArrayList.add(Integer.valueOf(localStringBuilder.length()));
      localStringBuilder.append("/");
      localStringBuilder.append(((QQCircleBase.UserCircleInfo)paramStUserBusiData.schoolInfos.get(0)).name);
    }
    i1 = i2;
    if (paramStUserBusiData.companyInfos.size() > 0)
    {
      i1 = i2 + 1;
      localArrayList.add(Integer.valueOf(localStringBuilder.length()));
      localStringBuilder.append("/");
      localStringBuilder.append(QCircleTextUtils.a(((QQCircleBase.UserCircleInfo)paramStUserBusiData.companyInfos.get(0)).name.get()));
    }
    if (i1 >= 2) {
      bool = true;
    }
    if (bool)
    {
      paramStFrontCardDP = new SpannableString(localStringBuilder.toString());
      paramStUserBusiData = localArrayList.iterator();
      while (paramStUserBusiData.hasNext())
      {
        localObject = (Integer)paramStUserBusiData.next();
        a(paramStFrontCardDP, ((Integer)localObject).intValue(), ((Integer)localObject).intValue() + 1);
      }
      this.k.setText(paramStFrontCardDP);
      return bool;
    }
    this.k.setCompoundDrawables(null, null, null, null);
    return bool;
  }
  
  private void b()
  {
    this.n = findViewById(2131436879);
    this.C = ((LinearLayout)findViewById(2131437541));
    this.n.setRotationY(90.0F);
    this.n.getLayoutParams().height = ((int)((ImmersiveUtils.b() - ImmersiveUtils.a(10.0F)) * 0.74F));
    this.i = ((QCircleAvatarView)findViewById(2131429225));
    this.j = ((TextView)findViewById(2131429232));
    this.e = ((TextView)findViewById(2131429233));
    this.w = ((SquareImageView)findViewById(2131436266));
    this.l = ((QCircleAsyncTextView)findViewById(2131429231));
    this.v = ((TextView)findViewById(2131429226));
    this.s = ((RoundCornerImageView)findViewById(2131429227));
  }
  
  private void c()
  {
    this.z = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.m, View.ROTATION_Y, new float[] { 0.0F, -91.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.m, "scaleX", new float[] { 1.0F, 0.8F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.m, "scaleY", new float[] { 1.0F, 0.8F });
    localObjectAnimator2.setDuration(0L);
    localObjectAnimator3.setDuration(0L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.n, "scaleX", new float[] { 1.0F, 0.8F });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.n, "scaleY", new float[] { 1.0F, 0.8F });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.h, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator6.setDuration(160L);
    localObjectAnimator4.setDuration(160L);
    localObjectAnimator5.setDuration(160L);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.n, "scaleX", new float[] { 0.8F, 1.0F });
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.n, "scaleY", new float[] { 0.8F, 1.0F });
    localObjectAnimator8.setDuration(160L);
    localObjectAnimator7.setDuration(160L);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.n, View.ROTATION_Y, new float[] { 89.0F, 8.0F, -4.0F, 0.0F }).setDuration(480L);
    this.A = new AnimatorSet();
    this.A.playTogether(new Animator[] { localObjectAnimator9, localObjectAnimator7, localObjectAnimator8 });
    localObjectAnimator1.addUpdateListener(new QCircleFatePersonView.5(this));
    localObjectAnimator1.addListener(new QCircleFatePersonView.6(this));
    this.A.addListener(new QCircleFatePersonView.7(this));
    this.z.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5, localObjectAnimator6 });
    this.z.setDuration(240L);
    this.z.start();
  }
  
  private void setAuthIcon(int paramInt)
  {
    Object localObject = this.w;
    if (localObject == null) {
      return;
    }
    if (paramInt == 0)
    {
      ((SquareImageView)localObject).setVisibility(8);
      return;
    }
    if (paramInt == 2) {
      localObject = QCircleConfigHelper.z();
    } else {
      localObject = QCircleConfigHelper.y();
    }
    QCircleFeedPicLoader.g().loadImage(new Option().setUrl((String)localObject).setTargetView(this.w), null);
    this.w.setVisibility(0);
  }
  
  private void setBackCardData(QQCircleDitto.StBackCardDP paramStBackCardDP)
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      QCircleAvatarView localQCircleAvatarView = this.i;
      if (localQCircleAvatarView != null)
      {
        localQCircleAvatarView.setUser((FeedCloudMeta.StUser)((FeedCloudMeta.StUser)localObject).get());
        this.i.setOnClickListener(this.D);
      }
      localObject = this.j;
      if (localObject != null)
      {
        ((TextView)localObject).setText(this.r.nick.get());
        this.j.setOnClickListener(this.D);
      }
    }
    localObject = this.x;
    if (localObject != null) {
      setAuthIcon(((QQCircleBase.StUserBusiData)localObject).certification.get());
    }
    localObject = this.l;
    if (localObject != null) {
      ((QCircleAsyncTextView)localObject).setText(paramStBackCardDP.recomFeed.content.get());
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((TextView)localObject).setOnClickListener(this.D);
      this.e.setText(QCircleTextUtils.a(paramStBackCardDP.recomFeed.createTime.get() * 1000L));
    }
    if ((this.v != null) && (paramStBackCardDP.buttons.size() > 0))
    {
      this.v.setVisibility(0);
      this.v.setText(((QQCircleDitto.StButton)paramStBackCardDP.buttons.get(0)).name.get());
      this.v.setOnClickListener(new QCircleFatePersonView.3(this, paramStBackCardDP));
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((View)localObject).setEnabled(false);
      this.n.setOnClickListener(new QCircleFatePersonView.4(this, paramStBackCardDP));
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((RoundCornerImageView)localObject).setCorner(ImmersiveUtils.a(12.0F));
      int i1 = ImmersiveUtils.b() - ImmersiveUtils.a(24.0F);
      localObject = new Option().setTargetView(this.s);
      double d1 = i1;
      Double.isNaN(d1);
      paramStBackCardDP = ((Option)localObject).setRequestHeight((int)(d1 * 0.74D)).setRequestWidth(i1).setUrl(paramStBackCardDP.recomFeed.cover.picUrl.get()).setLoadingDrawable(getResources().getDrawable(2130853309)).setPredecode(true);
      QCircleFeedPicLoader.g().loadImage(paramStBackCardDP, null);
    }
  }
  
  private void setFrontCardData(QQCircleDitto.StFrontCardDP paramStFrontCardDP)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((QCircleAvatarView)localObject).setUser((FeedCloudMeta.StUser)paramStFrontCardDP.recomUser.get());
      this.c.setOnClickListener(this.D);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((TextView)localObject).setText(paramStFrontCardDP.recomUser.nick.get());
      this.d.setOnClickListener(this.D);
    }
    if (this.p != null)
    {
      if (paramStFrontCardDP.matchReson.size() > 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramStFrontCardDP.matchReson.get(0));
        ((StringBuilder)localObject).append((String)paramStFrontCardDP.matchReson.get(1));
        localObject = ((StringBuilder)localObject).toString();
        SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
        localSpannableString.setSpan(new CustomTypeFaceSpan(RFWTypefaceUtil.a(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"), ImmersiveUtils.a(12.0F)), ((String)paramStFrontCardDP.matchReson.get(0)).length(), ((String)localObject).length(), 33);
        this.p.setText(localSpannableString);
      }
      this.p.setOnClickListener(this.D);
    }
    if (this.k != null)
    {
      if ((this.x.fansNum.get() > 10L) && (this.x.fuelValue.get() > 10L)) {
        a(this.x);
      } else if (!a(paramStFrontCardDP, this.x)) {
        this.k.setText(paramStFrontCardDP.recomCommReson.get());
      }
      this.k.setOnClickListener(this.D);
    }
    localObject = this.C;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener(this.D);
    }
    if (this.f != null) {
      if (paramStFrontCardDP.recomReason.size() > 0)
      {
        this.f.setText(QCircleTextUtils.a((String)paramStFrontCardDP.recomReason.get(0), 7));
        this.f.setVisibility(0);
      }
      else
      {
        this.f.setVisibility(8);
      }
    }
    if (this.g != null) {
      if (paramStFrontCardDP.recomReason.size() > 1)
      {
        this.g.setText(QCircleTextUtils.a((String)paramStFrontCardDP.recomReason.get(1), 7));
        this.g.setVisibility(0);
      }
      else
      {
        this.g.setVisibility(8);
      }
    }
    if (this.h != null)
    {
      if (paramStFrontCardDP.buttons.size() > 0)
      {
        this.h.setUserData((FeedCloudMeta.StUser)paramStFrontCardDP.recomUser.get());
        this.h.setText(((QQCircleDitto.StButton)paramStFrontCardDP.buttons.get(0)).name.get());
        this.h.setVisibility(0);
        return;
      }
      this.h.setVisibility(8);
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    if ((getData() instanceof FeedBlockData)) {}
    for (;;)
    {
      try
      {
        Object localObject = (FeedBlockData)getData();
        paramObject = new QQCircleDitto.StCircleDittoDataNew();
        QQCircleDitto.StFrontCardDP localStFrontCardDP = new QQCircleDitto.StFrontCardDP();
        QQCircleDitto.StBackCardDP localStBackCardDP = new QQCircleDitto.StBackCardDP();
        boolean bool = ((FeedBlockData)localObject).a("DITTO_FEED_DESTINED_PERSON") instanceof QQCircleDitto.StCircleDittoDataNew;
        if ((bool) && ((((FeedBlockData)localObject).a("DITTO_FEED_DESTINED_PERSON_FRONT") instanceof QQCircleDitto.StFrontCardDP)) && ((((FeedBlockData)localObject).a("DITTO_FEED_DESTINED_PERSON_BACK") instanceof QQCircleDitto.StBackCardDP)))
        {
          paramObject = ((QQCircleDitto.StCircleDittoDataNew)((FeedBlockData)localObject).a("DITTO_FEED_DESTINED_PERSON")).flipCard;
          localStFrontCardDP = (QQCircleDitto.StFrontCardDP)((FeedBlockData)localObject).a("DITTO_FEED_DESTINED_PERSON_FRONT");
          localStBackCardDP = (QQCircleDitto.StBackCardDP)((FeedBlockData)localObject).a("DITTO_FEED_DESTINED_PERSON_BACK");
          QLog.d("QCircleFatePersonView", 1, "get data from blockData");
        }
        else
        {
          paramObject = ((QQCircleDitto.StCircleDittoDataNew)paramObject.mergeFrom(((FeedBlockData)localObject).b().dittoFeed.dittoDataNew.get().toByteArray())).flipCard;
          localStFrontCardDP.mergeFrom(((QQCircleDitto.StFrontCardDP)paramObject.cardDetail.frontCardDP.get()).toByteArray());
          localStBackCardDP.mergeFrom(((QQCircleDitto.StBackCardDP)paramObject.cardDetail.backCardDP.get()).toByteArray());
          QLog.d("QCircleFatePersonView", 1, "get data from merge");
        }
        if (this.a != null) {
          this.a.setText(paramObject.cardName.get());
        }
        this.r = localStFrontCardDP.recomUser;
        this.x = QCirclePluginUtil.a(localStFrontCardDP.recomUser);
        this.y = ((FeedBlockData)localObject).b();
        localObject = this.b;
        if (!paramObject.opMask.get().contains(Integer.valueOf(5))) {
          break label381;
        }
        paramInt = 0;
        ((ImageView)localObject).setVisibility(paramInt);
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.y).setToUin(this.r.id.get()).setActionType(101).setSubActionType(1).setIndex(0).setPageId(getPageId())));
        setFrontCardData(localStFrontCardDP);
        setBackCardData(localStBackCardDP);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramObject.printStackTrace();
      }
      return;
      label381:
      paramInt = 8;
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131626799;
  }
  
  protected String getLogTag()
  {
    return "QCircleFatePersonView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AnimatorSet localAnimatorSet = this.z;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning()))
    {
      this.z.cancel();
      this.z.removeAllListeners();
    }
    localAnimatorSet = this.A;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.cancel();
      this.A.removeAllListeners();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)findViewById(2131448313));
    this.b = ((ImageView)findViewById(2131436412));
    this.B = ((ImageView)findViewById(2131430326));
    a();
    b();
    this.t = getResources().getDrawable(2130845253);
    this.t.setBounds(0, 0, ImmersiveUtils.a(12.0F), ImmersiveUtils.a(12.0F));
    this.u = getResources().getDrawable(2130845252);
    this.u.setBounds(0, 0, ImmersiveUtils.a(12.0F), ImmersiveUtils.a(12.0F));
    this.b.setOnClickListener(new QCircleFatePersonView.1(this));
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)) && (paramSimpleBaseEvent.mHashCode != getContext().hashCode()))
    {
      Object localObject = this.r;
      if (localObject != null)
      {
        localObject = ((FeedCloudMeta.StUser)localObject).id.get();
        paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
        if (((String)localObject).equals(paramSimpleBaseEvent.mUserId))
        {
          int i1 = paramSimpleBaseEvent.mFollowStatus;
          this.r.followState.set(i1);
          a(QCirclePluginUtil.c(i1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView
 * JD-Core Version:    0.7.0.1
 */