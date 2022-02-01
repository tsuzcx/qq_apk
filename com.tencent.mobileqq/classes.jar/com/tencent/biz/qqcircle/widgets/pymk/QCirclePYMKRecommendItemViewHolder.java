package com.tencent.biz.qqcircle.widgets.pymk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter.QCircleRecommendItemBaseViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.richframework.widget.VerticalCenterImageSpan;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import com.tencent.biz.qqcircle.widgets.span.CustomTypeFaceSpan;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemInfo;
import qqcircle.QQCircleDitto.StPymkItemInfoBizData;

public class QCirclePYMKRecommendItemViewHolder
  extends QCircleRecommendBaseAdapter.QCircleRecommendItemBaseViewHolder
  implements View.OnClickListener
{
  public static final int h = ViewUtils.a(220.0F);
  public static final int i = ViewUtils.a(288.0F);
  public static final int j = ViewUtils.a(165.0F);
  private QCircleAvatarView k;
  private View l;
  private TextView m;
  private TextView n;
  private URLImageView o;
  private QCircleFollowView p;
  private ImageView q;
  private ImageView r;
  private TextView s;
  private LinearLayout t;
  private ImageView u;
  private TextView v;
  private View w;
  private final QCircleFollowView.FollowReportListener x = new QCirclePYMKRecommendItemViewHolder.4(this);
  
  public QCirclePYMKRecommendItemViewHolder(View paramView)
  {
    super(paramView);
    b(paramView);
    RoundCorneredRelativeLayout localRoundCorneredRelativeLayout = (RoundCorneredRelativeLayout)paramView.findViewById(2131441854);
    if (localRoundCorneredRelativeLayout != null)
    {
      float f = ViewUtils.a(10.0F);
      localRoundCorneredRelativeLayout.setRadius(f, f, f, f);
    }
    this.p.setNeedFakeSender(false);
    this.p.setDtParentEmId("em_xsj_pymk_card");
    a(paramView);
  }
  
  private QCircleLpReportDc05501.DataBuilder a(String paramString)
  {
    return QCirclePluginReportUtil.b(this.c).setToUin(paramString).setIndex(this.d).setContainerSeq(this.b).setPageId(this.f);
  }
  
  private void a(Context paramContext)
  {
    if (!(this.a instanceof QQCircleDitto.StItemInfo))
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[jumpPersonDetailPage] current data type not is StItemInfo.");
      return;
    }
    Object localObject1 = (QQCircleDitto.StItemInfo)this.a;
    Object localObject2 = ((QQCircleDitto.StItemInfo)localObject1).id.get();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[jumpPersonDetailPage] current user id not is empty.");
      return;
    }
    a(a((String)localObject2).setActionType(3).setSubActionType(2).setFeedType1(3).setFeedType2(1));
    localObject2 = new QCircleInitBean();
    ((QCircleInitBean)localObject2).setUin(((QQCircleDitto.StItemInfo)localObject1).id.get());
    localObject1 = a();
    if (localObject1 != null) {
      ((QCircleInitBean)localObject2).setFromReportBean(((QCircleReportBean)localObject1).clone());
    } else {
      QLog.e("QCirclePYMKRecommendItemViewHolder", 1, "[jumpPersonDetailPage] report bean is null, error: ", new NullPointerException());
    }
    QCircleLauncher.b(paramContext, (QCircleInitBean)localObject2);
  }
  
  private void a(Context paramContext, QQCircleDitto.StItemInfo paramStItemInfo)
  {
    QQCircleDitto.StPymkItemInfoBizData localStPymkItemInfoBizData = new QQCircleDitto.StPymkItemInfoBizData();
    try
    {
      localStPymkItemInfoBizData.mergeFrom(paramStItemInfo.bizData.get().toByteArray());
      QCircleLauncher.a(paramContext, localStPymkItemInfoBizData.newUserPageMoreButton.jumpUrl.get(), null, -1);
      a(a(paramStItemInfo.id.get()).setActionType(102).setSubActionType(2));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramContext)
    {
      QLog.e("QCirclePYMKRecommendItemViewHolder", 1, "[setData] error: ", paramContext);
    }
  }
  
  private void a(View paramView)
  {
    this.p.setItemReportListener(this.x);
    this.q.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.m.setOnClickListener(this);
    paramView.setOnClickListener(new QCirclePYMKRecommendItemViewHolder.1(this));
  }
  
  private void a(QCircleLpReportDc05501.DataBuilder paramDataBuilder)
  {
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramDataBuilder));
  }
  
  private void a(QQCircleDitto.StButton paramStButton, String paramString)
  {
    if (paramStButton == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, new Object[] { "[setFollowImgStatus] button should not be null, id: ", paramString });
      return;
    }
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    this.p.setFollowedDismiss(false);
    localStUser.id.set(paramString);
    localStUser.followState.set(QCirclePluginUtil.a(paramStButton.buttonValue.get()));
    this.p.setUserData(localStUser);
    this.p.setText(paramStButton.name.get());
    this.p.setOnClickListener(new QCirclePYMKRecommendItemViewHolder.3(this, paramStButton));
  }
  
  private void a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if (paramStItemInfo == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[handlerAllContentImage] info == null.");
      return;
    }
    paramStItemInfo = paramStItemInfo.images.get();
    if ((paramStItemInfo != null) && (!paramStItemInfo.isEmpty()))
    {
      if (this.o == null)
      {
        QLog.w("QCirclePYMKRecommendItemViewHolder", 1, "[handlerAllContentImage] container bg should not be null.");
        return;
      }
      paramStItemInfo = (FeedCloudMeta.StImage)paramStItemInfo.get(0);
      if (paramStItemInfo == null) {
        paramStItemInfo = null;
      } else {
        paramStItemInfo = paramStItemInfo.picUrl.get();
      }
      if (TextUtils.isEmpty(paramStItemInfo))
      {
        QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[handlerAllContentImage] image url not is empty.");
        return;
      }
      a(paramStItemInfo, QCircleDrawableCacheUtils.a(2130845208), this.o);
      return;
    }
    QLog.w("QCirclePYMKRecommendItemViewHolder", 1, "[handlerAllContentImage] image not is empty.");
  }
  
  private void a(QQCircleDitto.StItemInfo paramStItemInfo, QQCircleDitto.StPymkItemInfoBizData paramStPymkItemInfoBizData)
  {
    if (!TextUtils.isEmpty(paramStItemInfo.id.get()))
    {
      this.k.setUser((FeedCloudMeta.StUser)paramStPymkItemInfoBizData.recomUser.get());
      this.l.setVisibility(0);
    }
    else
    {
      this.l.setVisibility(8);
    }
    if ((this.r != null) && (paramStPymkItemInfoBizData.isNew.get()))
    {
      this.r.setVisibility(0);
      this.k.setIsAuth(0);
      return;
    }
    paramStPymkItemInfoBizData = this.r;
    if (paramStPymkItemInfoBizData != null) {
      paramStPymkItemInfoBizData.setVisibility(8);
    }
    this.k.setIsAuth(h(paramStItemInfo));
  }
  
  private void a(QQCircleDitto.StItemInfo paramStItemInfo, QQCircleDitto.StPymkItemInfoBizData paramStPymkItemInfoBizData, QQCircleBase.StUserBusiData paramStUserBusiData)
  {
    this.m.setText(paramStItemInfo.name.get());
    this.s.setVisibility(8);
    this.t.setVisibility(8);
    a(paramStItemInfo, paramStPymkItemInfoBizData);
    a(paramStPymkItemInfoBizData, paramStUserBusiData);
    g(paramStItemInfo);
    a((QQCircleDitto.StButton)paramStItemInfo.buttonInfo.get(), paramStItemInfo.id.get());
  }
  
  private void a(@NonNull QQCircleDitto.StPymkItemInfoBizData paramStPymkItemInfoBizData, @NonNull QQCircleBase.StUserBusiData paramStUserBusiData)
  {
    int i1;
    if ((paramStUserBusiData.feedNum.get() != 0) && (paramStUserBusiData.fansNum.get() != 0L))
    {
      String str2 = HardCodeUtil.a(2131895877);
      String str1 = HardCodeUtil.a(2131895878);
      paramStPymkItemInfoBizData = new SpannableStringBuilder();
      paramStPymkItemInfoBizData.append(str2);
      i1 = paramStPymkItemInfoBizData.length();
      str2 = QCirclePluginUtil.d(paramStUserBusiData.feedNum.get());
      paramStPymkItemInfoBizData.append(str2);
      paramStPymkItemInfoBizData.append("    ");
      paramStPymkItemInfoBizData.append(str1);
      int i2 = paramStPymkItemInfoBizData.length();
      paramStPymkItemInfoBizData.append(QCirclePluginUtil.d(paramStUserBusiData.fansNum.get()));
      paramStPymkItemInfoBizData.setSpan(new CustomTypeFaceSpan(RFWTypefaceUtil.a(QCircleApplication.APP, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"), ImmersiveUtils.a(12.0F)), i1, str2.length() + i1, 33);
      paramStUserBusiData = QCircleSkinHelper.getInstance().getDrawable(2130845436);
      paramStUserBusiData.setBounds(0, 0, ImmersiveUtils.a(2.0F), ImmersiveUtils.a(2.0F));
      paramStPymkItemInfoBizData.setSpan(new VerticalCenterImageSpan(paramStUserBusiData), str2.length() + i1 + 2, i1 + str2.length() + 3, 33);
      paramStPymkItemInfoBizData.setSpan(new CustomTypeFaceSpan(RFWTypefaceUtil.a(QCircleApplication.APP, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"), ImmersiveUtils.a(12.0F)), i2, paramStPymkItemInfoBizData.length(), 33);
      this.s.setText(paramStPymkItemInfoBizData);
      this.s.setVisibility(0);
      return;
    }
    if ((paramStPymkItemInfoBizData.recomUser.sex.has()) && (!TextUtils.isEmpty(paramStPymkItemInfoBizData.recomUser.location.get())))
    {
      this.t.setVisibility(0);
      paramStUserBusiData = this.u;
      if (paramStPymkItemInfoBizData.recomUser.sex.get() == 1) {
        i1 = 2130845253;
      } else {
        i1 = 2130845252;
      }
      paramStUserBusiData.setImageResource(i1);
      this.v.setText(paramStPymkItemInfoBizData.recomUser.location.get());
      return;
    }
    this.s.setVisibility(0);
    this.s.setText(paramStPymkItemInfoBizData.backupContent.get());
  }
  
  private boolean a(QQCircleDitto.StButton paramStButton)
  {
    return (!paramStButton.name.get().equals(this.p.getContext().getString(2131895727))) && (TextUtils.isEmpty(paramStButton.jumpUrl.get()));
  }
  
  private void b(View paramView)
  {
    this.o = ((URLImageView)paramView.findViewById(2131441853));
    this.w = paramView.findViewById(2131437477);
    this.l = paramView.findViewById(2131441850);
    this.k = ((QCircleAvatarView)paramView.findViewById(2131441849));
    this.m = ((TextView)paramView.findViewById(2131441858));
    this.n = ((TextView)paramView.findViewById(2131441855));
    this.p = ((QCircleFollowView)paramView.findViewById(2131441857));
    this.q = ((ImageView)paramView.findViewById(2131441851));
    this.r = ((ImageView)paramView.findViewById(2131436473));
    this.s = ((TextView)paramView.findViewById(2131448883));
    this.t = ((LinearLayout)paramView.findViewById(2131437557));
    this.u = ((ImageView)paramView.findViewById(2131436568));
    this.v = ((TextView)paramView.findViewById(2131448572));
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (!(this.a instanceof QQCircleDitto.StItemInfo))
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[reportRemoveItem] data type not is item info.");
      return;
    }
    String str = ((QQCircleDitto.StItemInfo)this.a).id.get();
    paramStFeed = String.valueOf(paramStFeed.createTime);
    a(a(str).setExt3(paramStFeed).setActionType(65).setSubActionType(1).setFeedType1(3).setFeedType2(1));
  }
  
  private void b(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    c(paramStItemInfo);
    if (TextUtils.isEmpty(paramStItemInfo.id.get()))
    {
      d(paramStItemInfo);
      return;
    }
    e();
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.e == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[closeItemAction] adapter should not be null.");
      return;
    }
    this.e.a(this.a, 1);
    int i1 = this.e.getItemCount();
    paramStFeed = paramStFeed.id.get();
    if (i1 <= 0)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, new Object[] { "[removeItemAndNotify] adapter delete success and count is empty, delete feed id: ", paramStFeed });
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramStFeed, 3));
      return;
    }
    QLog.d("QCirclePYMKRecommendItemViewHolder", 1, new Object[] { "[removeItemAndNotify] adapter delete success, delete feed id:", paramStFeed });
  }
  
  private void c(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if (paramStItemInfo == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[loadUrlToImageView] info should not be null.");
      return;
    }
    if (this.o == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[loadUrlToImageView] container background view should not be null.");
      return;
    }
    paramStItemInfo = paramStItemInfo.images.get();
    if ((paramStItemInfo != null) && (!paramStItemInfo.isEmpty()))
    {
      a(((FeedCloudMeta.StImage)paramStItemInfo.get(0)).picUrl.get(), QCircleDrawableCacheUtils.a(2130845228), this.o);
      return;
    }
    QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[loadUrlToImageView] current list size not is empty.");
  }
  
  private void d()
  {
    FeedCloudMeta.StFeed localStFeed = this.c;
    if (localStFeed == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[closeItemAction] feed should not be null.");
      return;
    }
    c(localStFeed);
    b(localStFeed);
  }
  
  private void d(@NonNull QQCircleDitto.StItemInfo paramStItemInfo)
  {
    this.o.getLayoutParams().height = ViewUtils.a(316.0F);
    this.o.getLayoutParams().width = ViewUtils.a(220.0F);
    this.q.setVisibility(8);
    this.o.setClickable(true);
    this.o.setOnClickListener(new QCirclePYMKRecommendItemViewHolder.2(this, paramStItemInfo));
    a(a(paramStItemInfo.id.get()).setActionType(102).setSubActionType(1));
  }
  
  private void e()
  {
    Object localObject = this.o;
    if (localObject == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[updateContainerBackground] container background should not be null.");
    }
    else
    {
      ((URLImageView)localObject).getLayoutParams().height = ViewUtils.a(165.0F);
      this.o.getLayoutParams().width = ViewUtils.a(220.0F);
      this.o.setClickable(false);
    }
    localObject = this.q;
    if (localObject == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[updateContainerBackground] close button should not be null.");
      return;
    }
    ((ImageView)localObject).setVisibility(0);
  }
  
  private void e(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if (paramStItemInfo == null) {
      return;
    }
    VideoReport.setElementId(this.itemView, "em_xsj_pymk_card");
    Object localObject = new QCircleDTParamBuilder().buildElementParams();
    ((Map)localObject).put("xsj_container_position", Integer.valueOf(this.b));
    ((Map)localObject).put("xsj_target_qq", paramStItemInfo.id.get());
    ((Map)localObject).put("xsj_parent_emid", "em_xsj_pymk_box");
    if (!TextUtils.isEmpty(paramStItemInfo.datongJsonData.get())) {
      ((Map)localObject).put("xsj_transfer_info", paramStItemInfo.datongJsonData.get());
    }
    VideoReport.setElementParams(this.itemView, (Map)localObject);
    paramStItemInfo = this.itemView;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("em_xsj_pymk_card_");
    ((StringBuilder)localObject).append(this.a.hashCode());
    VideoReport.setElementReuseIdentifier(paramStItemInfo, ((StringBuilder)localObject).toString());
  }
  
  private void f()
  {
    if (this.c == null) {
      localObject = null;
    } else {
      localObject = this.c.opMask2.get();
    }
    int i3 = 0;
    int i1;
    if ((localObject != null) && (((List)localObject).contains(Integer.valueOf(6)))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((this.c != null) && (!QCirclePluginUtil.b((FeedCloudMeta.StUser)this.c.poster.get()))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i1 != 0) && (i2 != 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = this.q;
    if (localObject == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[setShowCloseButton] close button should not be null.");
      return;
    }
    if (i1 != 0) {
      i1 = i3;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
  }
  
  private void f(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if (paramStItemInfo == null)
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, "[bindPersonInfo] info should not be null.");
      return;
    }
    QQCircleDitto.StPymkItemInfoBizData localStPymkItemInfoBizData = new QQCircleDitto.StPymkItemInfoBizData();
    try
    {
      localStPymkItemInfoBizData.mergeFrom(paramStItemInfo.bizData.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      QLog.e("QCirclePYMKRecommendItemViewHolder", 1, "[bindPersonInfo] error: ", localInvalidProtocolBufferMicroException1);
    }
    QQCircleBase.StUserBusiData localStUserBusiData = new QQCircleBase.StUserBusiData();
    try
    {
      localStUserBusiData.mergeFrom(localStPymkItemInfoBizData.recomUser.busiData.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      QLog.e("QCirclePYMKRecommendItemViewHolder", 1, "[bindPersonInfo] error: ", localInvalidProtocolBufferMicroException2);
    }
    a(paramStItemInfo, localStPymkItemInfoBizData, localStUserBusiData);
    paramStItemInfo = paramStItemInfo.id.get();
    if (TextUtils.isEmpty(paramStItemInfo))
    {
      QLog.d("QCirclePYMKRecommendItemViewHolder", 1, new Object[] { "[bindPersonInfo] user id: ", paramStItemInfo });
      return;
    }
    a(a(paramStItemInfo).setActionType(3).setSubActionType(1).setFeedType1(3).setFeedType2(1));
  }
  
  private void g()
  {
    View localView = this.w;
    if (localView == null) {
      return;
    }
    VideoReport.setElementId(localView, "em_xsj_user_info");
  }
  
  private void g(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if ((paramStItemInfo.des.get() != null) && (paramStItemInfo.des.size() > 0))
    {
      this.n.setText((CharSequence)paramStItemInfo.des.get().get(0));
      this.n.setVisibility(0);
      return;
    }
    this.n.setVisibility(4);
  }
  
  private int h(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if ((paramStItemInfo != null) && (paramStItemInfo.busiInfo.get() != null))
    {
      paramStItemInfo = QCirclePluginUtil.a(paramStItemInfo.busiInfo.get(), "user-certification");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUserVerified: ");
      localStringBuilder.append(paramStItemInfo);
      QLog.i("QCirclePYMKRecommendItemViewHolder", 1, localStringBuilder.toString());
      if (paramStItemInfo.equals(String.valueOf(1))) {
        return 1;
      }
      if (paramStItemInfo.equals(String.valueOf(2))) {
        return 2;
      }
    }
    return 0;
  }
  
  private void h()
  {
    URLImageView localURLImageView = this.o;
    if (localURLImageView == null) {
      return;
    }
    VideoReport.setElementId(localURLImageView, "em_xsj_front_cover");
  }
  
  private void i()
  {
    ImageView localImageView = this.q;
    if (localImageView == null) {
      return;
    }
    VideoReport.setElementId(localImageView, "em_xsj_close_button");
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2)
  {
    if (!(paramObject instanceof QQCircleDitto.StItemInfo))
    {
      QLog.w("QCirclePYMKRecommendItemViewHolder", 1, "[setData] data not is StItemInfo type.");
      return;
    }
    this.a = paramObject;
    this.b = paramInt1;
    f();
    this.p.setVisibility(0);
    paramObject = (QQCircleDitto.StItemInfo)this.a;
    f(paramObject);
    QLog.d("QCirclePYMKRecommendItemViewHolder", 4, new Object[] { "[setData] style:", Integer.valueOf(paramInt2) });
    if (paramInt2 == 50001) {
      a(paramObject);
    } else if (paramInt2 == 50002) {
      b(paramObject);
    }
    e(paramObject);
    h();
    i();
    g();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131441858) && (i1 != 2131441849))
    {
      if (i1 == 2131441851) {
        d();
      }
    }
    else {
      a(paramView.getContext());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendItemViewHolder
 * JD-Core Version:    0.7.0.1
 */