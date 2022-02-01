package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.manager.QCircleTagFollowManager;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView.ItemPreClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;

public class QCircleFollowTagView
  extends TextView
  implements View.OnClickListener
{
  private static final String b = "QCircleFollowTagView";
  protected boolean a = false;
  private FeedCloudMeta.StTagInfo c = new FeedCloudMeta.StTagInfo();
  private BaseWidgetView.ItemPreClickListener d;
  private QCircleFollowTagView.FollowChangeListener e;
  private boolean f;
  private boolean g;
  private boolean h;
  private int i = 2130845321;
  private int j = 2130845322;
  private QCircleFollowTagView.FollowReportListener k;
  private int l = QCircleConfigHelper.a("qqcircle", "qqcircle_back_follow_enable", Integer.valueOf(1)).intValue();
  
  public QCircleFollowTagView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleFollowTagView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleFollowTagView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_tag_follow_state");
    localIntent.putExtra("tagId", paramString);
    localIntent.putExtra("followstate", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  private void d()
  {
    QCircleCustomDialog.a(getContext(), getContext().getResources().getString(2131895940), null, 2131887648, 2131887629, new QCircleFollowTagView.2(this), new QCircleFollowTagView.3(this)).show();
  }
  
  protected void a()
  {
    setOnClickListener(this);
    c();
  }
  
  public void a(int paramInt)
  {
    FeedCloudMeta.StTagInfo localStTagInfo = this.c;
    if (localStTagInfo != null) {
      localStTagInfo.followState.set(paramInt);
    }
    if (QCirclePluginUtil.c(paramInt))
    {
      c();
      return;
    }
    b();
  }
  
  protected void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void b()
  {
    setVisibility(0);
    setBackgroundResource(this.i);
    setTextColor(getResources().getColor(2131165564));
    FeedCloudMeta.StTagInfo localStTagInfo = this.c;
    if ((localStTagInfo != null) && (localStTagInfo.followState.get() == 2) && (this.l == 1))
    {
      setText(2131895890);
      return;
    }
    setText(2131895727);
  }
  
  protected void c()
  {
    setVisibility(0);
    setBackgroundResource(this.j);
    setTextColor(getResources().getColor(2131165580));
    FeedCloudMeta.StTagInfo localStTagInfo = this.c;
    if ((localStTagInfo != null) && (localStTagInfo.followState.get() == 3) && (this.l == 1))
    {
      setText(2131895740);
      return;
    }
    setText(2131895739);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    if (!FastClickUtils.a("QCircleFollowTagViewClick"))
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        QCircleFollowTagView.FollowReportListener localFollowReportListener = this.k;
        if (localFollowReportListener != null) {
          localFollowReportListener.a(((FeedCloudMeta.StTagInfo)localObject).followState.get());
        }
        localObject = this.d;
        if (localObject != null) {
          ((BaseWidgetView.ItemPreClickListener)localObject).a();
        }
        if (!QCirclePluginUtil.c(this.c.followState.get())) {
          a(true);
        }
        if ((QCirclePluginUtil.c(this.c.followState.get())) && (!this.f)) {
          d();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setFollowStateChangeListener(QCircleFollowTagView.FollowChangeListener paramFollowChangeListener)
  {
    this.e = paramFollowChangeListener;
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setFollowedDrawable(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setFollowedShowToast(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setItemPreClickListener(BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    this.d = paramItemPreClickListener;
  }
  
  public void setItemReportListener(QCircleFollowTagView.FollowReportListener paramFollowReportListener)
  {
    this.k = paramFollowReportListener;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setTagInfo(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    this.c.tagId.set(paramStTagInfo.tagId.get());
    this.c.tagName.set(paramStTagInfo.tagName.get());
    if (QCircleTagFollowManager.a().a(this.c.tagId.get()))
    {
      bool = QCircleTagFollowManager.a().b(paramStTagInfo.tagId.get());
      this.c.followState.set(QCirclePluginUtil.a(bool));
      a(QCirclePluginUtil.a(bool));
      return;
    }
    this.c.followState.set(paramStTagInfo.followState.get());
    QCircleTagFollowManager localQCircleTagFollowManager = QCircleTagFollowManager.a();
    String str = paramStTagInfo.tagId.get();
    int m = paramStTagInfo.followState.get();
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    localQCircleTagFollowManager.a(str, bool);
    a(this.c.followState.get());
  }
  
  public void setUnFollowDrawable(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowTagView
 * JD-Core Version:    0.7.0.1
 */