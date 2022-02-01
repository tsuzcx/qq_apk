package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class GiftPkgSelectDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private ListView a;
  private GiftPkgSelectDialog.SelectAdatpter b;
  private List<GiftServiceBean> c = new ArrayList();
  private GiftPkgSelectDialog.GiftSelectListener d;
  private LinearLayout e;
  private LinearLayout f;
  private int g = -1;
  
  public GiftPkgSelectDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131952330);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131626262);
    this.a = ((ListView)findViewById(2131437787));
    this.e = ((LinearLayout)findViewById(2131437798));
    this.b = new GiftPkgSelectDialog.SelectAdatpter(this);
    this.a.setAdapter(this.b);
    this.a.setOnItemClickListener(new GiftPkgSelectDialog.1(this));
    this.e = ((LinearLayout)findViewById(2131437798));
    this.f = ((LinearLayout)findViewById(2131437801));
    this.f.setOnClickListener(this);
    ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.e, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).setGradientDrawable(this.a, ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, GiftPkgSelectDialog.GiftSelectListener paramGiftSelectListener, String paramString)
  {
    this.c = paramList;
    this.d = paramGiftSelectListener;
    this.b.notifyDataSetChanged();
    int i = 0;
    while (i < paramList.size())
    {
      paramGiftSelectListener = (GiftServiceBean)paramList.get(i);
      if ((!TextUtils.isEmpty(paramGiftSelectListener.t)) && (paramGiftSelectListener.t.equals(paramString)))
      {
        this.g = i;
        return;
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437801) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog
 * JD-Core Version:    0.7.0.1
 */