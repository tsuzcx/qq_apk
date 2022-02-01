package com.tencent.biz.pubaccount.weishi_new.view;

import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;

public class WeiShiNoticeView
  extends LinearLayout
{
  ArrayList<RoundImageView> a = new ArrayList();
  private Context b;
  private TextView c;
  private RoundImageView d;
  private RoundImageView e;
  private RoundImageView f;
  private int g;
  private LinearLayout h;
  private ImageView i;
  
  public WeiShiNoticeView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
  }
  
  public WeiShiNoticeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.a.size() > paramInt)
    {
      RoundImageView localRoundImageView = (RoundImageView)this.a.get(paramInt);
      if (!TextUtils.isEmpty(paramString))
      {
        Drawable localDrawable = this.b.getResources().getDrawable(2130848156);
        WSPicLoader localWSPicLoader = WSPicLoader.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("avatar");
        localStringBuilder.append(paramInt);
        localWSPicLoader.a(localRoundImageView, paramString, localDrawable, localDrawable, localStringBuilder.toString());
      }
      else
      {
        localRoundImageView.setImageResource(2130848156);
      }
      localRoundImageView.setVisibility(0);
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Drawable localDrawable = this.b.getResources().getDrawable(2130842687);
      WSPicLoader.a().a(this.i, paramString, localDrawable, localDrawable, "banner");
      return;
    }
    this.i.setImageResource(2130842687);
  }
  
  private void b()
  {
    this.d = ((RoundImageView)findViewById(2131429010));
    this.d.setBorderColor(Color.parseColor("#c1c1c1"));
    this.d.setBorderWidth(1);
    this.e = ((RoundImageView)findViewById(2131429011));
    this.e.setBorderColor(Color.parseColor("#c1c1c1"));
    this.e.setBorderWidth(1);
    this.f = ((RoundImageView)findViewById(2131429012));
    this.f.setBorderColor(Color.parseColor("#c1c1c1"));
    this.f.setBorderWidth(1);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.a.add(this.d);
    this.a.add(this.e);
    this.a.add(this.f);
    this.h = ((LinearLayout)findViewById(2131439453));
    this.i = ((ImageView)findViewById(2131439446));
    ViewGroup.LayoutParams localLayoutParams = this.i.getLayoutParams();
    int j = ScreenUtil.SCREEN_WIDTH * 120 / 750;
    if (j > 0)
    {
      localLayoutParams.height = j;
      this.i.setLayoutParams(localLayoutParams);
    }
    this.c = ((TextView)findViewById(2131448458));
  }
  
  public void a()
  {
    setVisibility(8);
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, String paramString)
  {
    if (paramstNotificationRsp == null)
    {
      a();
      return;
    }
    this.g = paramstNotificationRsp.type;
    int j = 0;
    setVisibility(0);
    WSReportDc00898.a(6, this.g, paramstNotificationRsp.cid);
    WSGridBeaconReport.a("gzh_exposure", this.g, 0, paramstNotificationRsp.cid, paramstNotificationRsp.trace_id, paramString);
    if (this.g == 6)
    {
      a(paramstNotificationRsp.imgurl);
      this.i.setVisibility(0);
      this.h.setVisibility(8);
      return;
    }
    this.i.setVisibility(8);
    this.h.setVisibility(0);
    if (!TextUtils.isEmpty(paramstNotificationRsp.text))
    {
      this.c.setTextColor(-16777216);
      this.c.setText(paramstNotificationRsp.text);
    }
    paramstNotificationRsp = paramstNotificationRsp.persons;
    while (j < paramstNotificationRsp.size())
    {
      paramString = (stSimpleMetaPerson)paramstNotificationRsp.get(j);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.avatar))) {
        a(j, paramString.avatar);
      }
      j += 1;
    }
    paramstNotificationRsp = new StringBuilder();
    paramstNotificationRsp.append("mAvatar1 :");
    paramstNotificationRsp.append(this.d.getVisibility());
    WSLog.a("813", paramstNotificationRsp.toString());
    paramstNotificationRsp = new StringBuilder();
    paramstNotificationRsp.append("mAvatar2 :");
    paramstNotificationRsp.append(this.e.getVisibility());
    WSLog.a("813", paramstNotificationRsp.toString());
    paramstNotificationRsp = new StringBuilder();
    paramstNotificationRsp.append("mAvatar3 :");
    paramstNotificationRsp.append(this.f.getVisibility());
    WSLog.a("813", paramstNotificationRsp.toString());
  }
  
  public int getType()
  {
    return this.g;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView
 * JD-Core Version:    0.7.0.1
 */