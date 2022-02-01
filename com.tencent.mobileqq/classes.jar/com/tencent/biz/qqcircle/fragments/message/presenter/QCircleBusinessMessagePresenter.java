package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StLeftTxtRightButtonInfo;
import qqcircle.QQCircleFeedBase.StLeftTxtRightPicInfo;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;
import qqcircle.QQCircleFeedBase.StNoticeButtonInfo;
import qqcircle.QQCircleFeedBase.StNoticePattonInfo;
import qqcircle.QQCircleFeedBase.StNoticePicInfo;
import qqcircle.QQCircleFeedBase.StNoticeTxtInfo;
import qqcircle.QQCircleFeedBase.StPlainTxtInfo;

public class QCircleBusinessMessagePresenter
  extends QCircleBaseMessagePresenter
{
  private ViewStub A;
  protected QCircleRoundImageView q;
  protected View r;
  protected View s;
  protected TextView t;
  protected View.OnClickListener u;
  protected QQCircleFeedBase.StNoticeTxtInfo v;
  protected QQCircleFeedBase.StNoticePicInfo w;
  protected QQCircleFeedBase.StNoticeButtonInfo x;
  protected int y;
  private ViewStub z;
  
  public QCircleBusinessMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  private void a(QQCircleFeedBase.StNoticeButtonInfo paramStNoticeButtonInfo)
  {
    this.x = paramStNoticeButtonInfo;
    if (!TextUtils.isEmpty(paramStNoticeButtonInfo.name.get()))
    {
      if (this.s == null)
      {
        localObject = this.A;
        if (localObject != null) {
          this.s = ((ViewStub)localObject).inflate();
        }
      }
      Object localObject = this.s;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        this.t = ((TextView)this.s.findViewById(2131448586));
        this.t.setVisibility(0);
        this.t.setText(paramStNoticeButtonInfo.name.get());
        this.t.setOnClickListener(new QCircleBusinessMessagePresenter.HandleSchemeClickListener(this, paramStNoticeButtonInfo.schemaUrl.get(), 2));
        VideoReport.setElementId(this.t, "em_xsj_join_button");
      }
    }
  }
  
  private void a(QQCircleFeedBase.StNoticePicInfo paramStNoticePicInfo)
  {
    this.w = paramStNoticePicInfo;
    if (!TextUtils.isEmpty(paramStNoticePicInfo.picInfo.picUrl.get()))
    {
      if (this.r == null)
      {
        localObject = this.z;
        if (localObject != null) {
          this.r = ((ViewStub)localObject).inflate();
        }
      }
      Object localObject = this.r;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        this.q = ((QCircleRoundImageView)this.r.findViewById(2131436373));
        this.r.setVisibility(0);
        this.q.setRoundRect(ViewUtils.a(4.0F));
        if ((this.q.getTag(2131441759) instanceof String)) {
          localObject = (String)this.q.getTag(2131441759);
        } else {
          localObject = "";
        }
        String str = paramStNoticePicInfo.picInfo.picUrl.get();
        this.q.setTag(2131441759, str);
        if (!((String)localObject).equals(str))
        {
          localObject = new Option().setUrl(str).setTargetView(this.q).setFromPreLoad(false).setPredecode(true).setRequestWidth(this.q.getWidth()).setRequestHeight(this.q.getHeight());
          QCircleFeedPicLoader.g().loadImage((Option)localObject, new QCircleBusinessMessagePresenter.1(this));
        }
        this.r.setOnClickListener(new QCircleBusinessMessagePresenter.HandleSchemeClickListener(this, paramStNoticePicInfo.schemaUrl.get(), 2));
        VideoReport.setElementId(this.r, "em_xsj_feed_thumbnail");
        paramStNoticePicInfo = new QCircleDTParamBuilder().buildElementParams();
        paramStNoticePicInfo.put("xsj_from_uin", this.d.operation.opUser.id.get());
        VideoReport.setElementParams(this.r, paramStNoticePicInfo);
      }
    }
  }
  
  private void a(QQCircleFeedBase.StNoticeTxtInfo paramStNoticeTxtInfo)
  {
    this.v = paramStNoticeTxtInfo;
    this.h.setMaxLines(2);
    this.h.setEllipsize(TextUtils.TruncateAt.END);
    a(paramStNoticeTxtInfo.content.get());
    b(paramStNoticeTxtInfo.subContent.get());
    c(paramStNoticeTxtInfo.summary.get());
    this.u = new QCircleBusinessMessagePresenter.HandleSchemeClickListener(this, this.v.schemaUrl.get(), 1);
    this.g.setOnClickListener(this.u);
    this.h.setOnClickListener(this.u);
    this.m.setOnClickListener(this.u);
    this.p.setOnClickListener(this.u);
  }
  
  private void h()
  {
    View[] arrayOfView = new View[5];
    Object localObject = this.h;
    int i = 0;
    arrayOfView[0] = localObject;
    arrayOfView[1] = this.m;
    arrayOfView[2] = this.p;
    arrayOfView[3] = this.r;
    arrayOfView[4] = this.s;
    int j = arrayOfView.length;
    while (i < j)
    {
      localObject = arrayOfView[i];
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      i += 1;
    }
  }
  
  protected void a(QCircleLpReportDc05504.DataBuilder paramDataBuilder)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void b(Context paramContext, View paramView)
  {
    this.z = ((ViewStub)paramView.findViewById(2131441909));
    this.A = ((ViewStub)paramView.findViewById(2131441910));
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    h();
    if (this.e != null)
    {
      this.y = this.e.pattonInfo.pattonType.get();
      paramInt = this.y;
      if (paramInt == 1)
      {
        a((QQCircleFeedBase.StNoticeTxtInfo)this.e.pattonInfo.plainTxt.txtInfo.get());
        return;
      }
      if (paramInt == 2)
      {
        a((QQCircleFeedBase.StNoticeTxtInfo)this.e.pattonInfo.leftTxtRightPic.txtInfo.get());
        a((QQCircleFeedBase.StNoticePicInfo)this.e.pattonInfo.leftTxtRightPic.picInfo.get());
        return;
      }
      if (paramInt == 3)
      {
        a((QQCircleFeedBase.StNoticeTxtInfo)this.e.pattonInfo.leftTxtRightButton.txtInfo.get());
        a((QQCircleFeedBase.StNoticeButtonInfo)this.e.pattonInfo.leftTxtRightButton.buttonInfo.get());
        return;
      }
      paramStNotice = new StringBuilder();
      paramStNotice.append("error patternType:");
      paramStNotice.append(this.y);
      QLog.d("QCircleDefaultMessagePresenter", 1, paramStNotice.toString());
    }
  }
  
  void c() {}
  
  public boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("openmessagelist"));
  }
  
  protected String f()
  {
    return "QCircleDefaultMessagePresenter";
  }
  
  protected boolean g()
  {
    Object localObject = this.v;
    if ((localObject == null) || (!d(((QQCircleFeedBase.StNoticeTxtInfo)localObject).schemaUrl.get())))
    {
      localObject = this.w;
      if ((localObject == null) || (!d(((QQCircleFeedBase.StNoticePicInfo)localObject).schemaUrl.get()))) {
        localObject = this.x;
      }
    }
    return (localObject != null) && (d(((QQCircleFeedBase.StNoticeButtonInfo)localObject).schemaUrl.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBusinessMessagePresenter
 * JD-Core Version:    0.7.0.1
 */