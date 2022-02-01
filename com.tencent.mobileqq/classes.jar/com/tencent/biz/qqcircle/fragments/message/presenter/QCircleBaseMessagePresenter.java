package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleMessageNoticeRequest;
import com.tencent.biz.qqcircle.requests.QCircleUnReadPointRequest;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowImageView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import qqcircle.QQCircleFeedBase.MessageBoxRedPointInfo;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;
import qqcircle.QQCircleFeedBase.StNoticePattonInfo;
import qqcircle.QQCircleFeedBase.StUserCertificationLabel;

public abstract class QCircleBaseMessagePresenter
  implements ReportBean<QCircleReportBean>
{
  protected View a;
  protected View b;
  protected Context c;
  protected FeedCloudMeta.StNotice d;
  protected QQCircleFeedBase.StNoticeBusiData e;
  protected QCircleAvatarView f;
  protected TextView g;
  protected QCircleAsyncTextView h;
  protected TextView i;
  protected View.OnClickListener j;
  protected BlockPart k;
  protected int l;
  protected QCircleAsyncTextView m;
  protected ImageView n;
  protected LinearLayout o;
  protected QCircleAsyncTextView p;
  private QCircleReportBean q;
  private QCircleSpecialFollowImageView r;
  private ImageView s;
  private ImageView t;
  
  public QCircleBaseMessagePresenter(int paramInt)
  {
    this.l = paramInt;
  }
  
  private void a(ImageView paramImageView, FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.height = ViewUtils.a(paramStImage.height.get());
      localLayoutParams.width = ViewUtils.a(paramStImage.width.get());
      paramImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(FeedCloudMeta.StNotice paramStNotice, QQCircleFeedBase.StNoticeBusiData paramStNoticeBusiData)
  {
    VideoReport.setElementId(this.a, "em_xsj_msg");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_target_qq", paramStNotice.operation.opUser.id.get());
    localMap.put("xsj_msg_type", Integer.valueOf(paramStNotice.noticeType.get()));
    if (paramStNoticeBusiData != null)
    {
      localMap.put("xsj_if_red_dot", Boolean.valueOf(paramStNoticeBusiData.messageBoxRedPointInfo.needShow.get()));
      localMap.put("xsj_ui_module", Integer.valueOf(paramStNoticeBusiData.pattonInfo.pattonType.get()));
    }
    VideoReport.setElementParams(this.a, localMap);
    VideoReport.setElementId(this.h, "em_xsj_msg_content");
    VideoReport.setElementId(this.p, "em_xsj_quota_content");
    paramStNoticeBusiData = new QCircleDTParamBuilder().buildElementParams();
    paramStNoticeBusiData.put("xsj_quota_content", paramStNotice.summary.get());
    VideoReport.setElementParams(this.p, paramStNoticeBusiData);
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    this.g.setText(paramStNotice.operation.opUser.nick.get());
    Object localObject = (FeedCloudMeta.StUser)this.d.operation.opUser.get();
    if (localObject != null)
    {
      QCircleSpecialFollowImageView localQCircleSpecialFollowImageView = this.r;
      if (localQCircleSpecialFollowImageView != null) {
        localQCircleSpecialFollowImageView.setUser((FeedCloudMeta.StUser)localObject);
      }
    }
    a(paramStNotice.message.get());
    b(paramStNotice.subMessage.get());
    c(paramStNotice.summary.get());
    b(this.e);
    a(this.e);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stNotice Message:");
    ((StringBuilder)localObject).append(paramStNotice.message.get());
    ((StringBuilder)localObject).append(" unRead:");
    ((StringBuilder)localObject).append(a());
    QLog.d("QCircleBaseMessagePresenter", 1, ((StringBuilder)localObject).toString());
    this.i.setText(QCirclePluginUtil.a(paramStNotice.createTime.get() * 1000L));
  }
  
  private void g()
  {
    this.f.post(new QCircleBaseMessagePresenter.5(this));
  }
  
  protected void a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.c = paramContext;
    if (paramView != null)
    {
      this.a = paramView;
      this.f = ((QCircleAvatarView)paramView.findViewById(2131436271));
      this.g = ((TextView)paramView.findViewById(2131448603));
      this.h = ((QCircleAsyncTextView)paramView.findViewById(2131448585));
      this.i = ((TextView)paramView.findViewById(2131448588));
      this.b = paramView.findViewById(2131437497);
      this.r = ((QCircleSpecialFollowImageView)paramView.findViewById(2131436582));
      this.o = ((LinearLayout)paramView.findViewById(2131446529));
      this.m = ((QCircleAsyncTextView)paramView.findViewById(2131448766));
      this.n = ((ImageView)paramView.findViewById(2131436258));
      this.p = ((QCircleAsyncTextView)paramView.findViewById(2131448587));
      this.s = ((ImageView)paramView.findViewById(2131436266));
      this.t = ((ImageView)paramView.findViewById(2131436641));
      this.j = new QCircleBaseMessagePresenter.4(this);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.rightMargin = ImmersiveUtils.a(30.0F);
      this.b.setLayoutParams(localLayoutParams);
      this.f.setOnClickListener(this.j);
      g();
      b(paramContext, paramView);
    }
  }
  
  public void a(BlockPart paramBlockPart)
  {
    this.k = paramBlockPart;
  }
  
  protected void a(QCircleLpReportDc05504.DataBuilder paramDataBuilder) {}
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.q = QCircleReportBean.setReportBean(f(), paramQCircleReportBean);
  }
  
  protected void a(FeedCloudMeta.StNotice paramStNotice)
  {
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(17).setSubActionType(17).setThrActionType(1).setExt10(String.valueOf(0));
    String str;
    if (a()) {
      str = String.valueOf(1);
    } else {
      str = String.valueOf(0);
    }
    paramStNotice = localDataBuilder.setExt11(str).setMsgReportInfo(paramStNotice.busiReport.get().toByteArray()).setPageId(d().getPageId());
    a(paramStNotice);
    QCircleLpReportDc05504.report(paramStNotice);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((paramStNotice != null) && (paramStNotice.operation.get() != null))
    {
      this.d = paramStNotice;
      this.f.setUser((FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
      if (this.d.busiData.get() != null)
      {
        this.e = new QQCircleFeedBase.StNoticeBusiData();
        try
        {
          this.e.mergeFrom(this.d.busiData.get().toByteArray());
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getNoticeBusiData error");
          localStringBuilder.append(localException.getMessage());
          QLog.e("QCircleBaseMessagePresenter", 1, localStringBuilder.toString());
        }
      }
      b(this.d);
      b(paramStNotice, paramInt);
      c();
      a(this.d);
      a(paramStNotice, this.e);
      VideoReport.traverseExposure();
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.h.setVisibility(8);
      return;
    }
    this.h.setVisibility(0);
    this.h.setOnClickAtTextListener(new QCircleBaseMessagePresenter.2(this));
    this.h.setText(paramString);
  }
  
  protected void a(QQCircleFeedBase.StNoticeBusiData paramStNoticeBusiData)
  {
    ImageView localImageView = this.t;
    if (localImageView != null)
    {
      int i1;
      if (paramStNoticeBusiData.messageBoxRedPointInfo.needShow.get()) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
    }
  }
  
  protected boolean a()
  {
    QQCircleFeedBase.StNoticeBusiData localStNoticeBusiData = this.e;
    return (localStNoticeBusiData != null) && (localStNoticeBusiData.messageBoxRedPointInfo.needShow.get());
  }
  
  protected void b()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((QQCircleFeedBase.StNoticeBusiData)localObject).messageBoxRedPointInfo.needShow.get()))
    {
      localObject = new QCircleUnReadPointRequest(this.d.operation.opUser.id.get(), 9);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new QCircleBaseMessagePresenter.1(this, (QCircleBaseRequest)localObject));
      localObject = new QCircleMessageNoticeRequest(null, false);
      if (BaseRequest.isCacheExist((BaseRequest)localObject)) {
        BaseRequest.reMoveCache((BaseRequest)localObject);
      }
      this.e.messageBoxRedPointInfo.needShow.set(false);
      a(this.e);
      this.d.busiData.set(ByteStringMicro.copyFrom(this.e.toByteArray()));
    }
  }
  
  abstract void b(Context paramContext, View paramView);
  
  abstract void b(FeedCloudMeta.StNotice paramStNotice, int paramInt);
  
  protected void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.o.setVisibility(8);
      return;
    }
    this.o.setVisibility(0);
    this.m.setText(paramString.trim());
  }
  
  protected void b(QQCircleFeedBase.StNoticeBusiData paramStNoticeBusiData)
  {
    ImageView localImageView = this.s;
    if (localImageView == null) {
      return;
    }
    localImageView.setVisibility(8);
    if ((paramStNoticeBusiData != null) && (paramStNoticeBusiData.pattonInfo.userCertificationLabel.get() != null))
    {
      paramStNoticeBusiData = (QQCircleFeedBase.StUserCertificationLabel)paramStNoticeBusiData.pattonInfo.userCertificationLabel.get();
      if ((paramStNoticeBusiData != null) && (paramStNoticeBusiData.picInfo.get() != null))
      {
        this.s.setVisibility(0);
        a(this.s, (FeedCloudMeta.StImage)paramStNoticeBusiData.picInfo.get());
        paramStNoticeBusiData = new Option().setUrl(QCircleSkinHelper.getInstance().convertUrl(paramStNoticeBusiData.picInfo.picUrl.get())).setTargetView(this.s);
        QCircleFeedPicLoader.g().loadImage(paramStNoticeBusiData, new QCircleBaseMessagePresenter.3(this));
      }
    }
  }
  
  abstract void c();
  
  protected void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.p.setVisibility(8);
      return;
    }
    this.p.setVisibility(0);
    this.p.setText(paramString);
  }
  
  public QCircleReportBean d()
  {
    if (this.q == null) {
      return new QCircleReportBean();
    }
    return QCircleReportBean.getReportBean(f(), this.q);
  }
  
  protected int e()
  {
    String str;
    if (TextUtils.isEmpty(f())) {
      str = "";
    } else {
      str = f();
    }
    return QCircleReportBean.getPageId(str, this.q);
  }
  
  protected abstract String f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBaseMessagePresenter
 * JD-Core Version:    0.7.0.1
 */