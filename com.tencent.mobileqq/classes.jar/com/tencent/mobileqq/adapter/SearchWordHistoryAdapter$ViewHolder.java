package com.tencent.mobileqq.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.HuichuanConfigManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

class SearchWordHistoryAdapter$ViewHolder
  implements View.OnClickListener
{
  public View a;
  public View b;
  public ImageView c;
  public TextView d;
  public PressEffectImageView e;
  public int f;
  
  SearchWordHistoryAdapter$ViewHolder(SearchWordHistoryAdapter paramSearchWordHistoryAdapter) {}
  
  public void onClick(View paramView)
  {
    String str1 = this.g.a(this.f);
    if (paramView == this.e)
    {
      if (this.g.b != null) {
        this.g.b.a(this.f);
      }
      this.g.a();
    }
    else if (paramView == this.a)
    {
      Object localObject1 = ((IReadInJoySearchJumpUrlConfProcessor)QRoute.api(IReadInJoySearchJumpUrlConfProcessor.class)).getConfig();
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = ((IReadInJoySearchJumpUrlConfBean)localObject1).c();
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
      }
      if (!TextUtils.isEmpty(HuichuanConfigManager.a().b())) {
        localObject2 = HuichuanConfigManager.a().b();
      }
      localObject1 = ((String)localObject2).replace("$KEYWORD$", URLEncoder.encode(str1));
      if ((this.g.f != 25) && (this.g.f != 10)) {
        localObject1 = ((String)localObject1).replace("$FROM$", UniteSearchReportController.a(this.g.f));
      } else {
        localObject1 = ((String)localObject1).replace("$FROM$", "kandian_history");
      }
      localObject2 = localObject1;
      if (SearchUtils.f((String)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(URLEncoder.encode(UniteSearchActivity.i));
        localObject2 = ((String)localObject1).replace("$SEARCHID$", ((StringBuilder)localObject2).toString());
      }
      SearchUtils.a(this.g.c, this.g.a, (String)localObject2);
      this.g.b.a(str1);
      localObject1 = new ReportModelDC02528().module("search_his").action("clk_search_his").ver2(UniteSearchReportController.a(this.g.f)).ver4(str1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("{experiment_id:");
      ((StringBuilder)localObject2).append(UniteSearchReportController.b);
      ((StringBuilder)localObject2).append("}");
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()));
      localObject1 = new UniteSearchHandler(this.g.c);
      localObject2 = this.g.c;
      String str2 = UniteSearchReportController.a(this.g.f);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{experiment_id:");
      localStringBuilder.append(UniteSearchReportController.b);
      localStringBuilder.append("}");
      ((UniteSearchHandler)localObject1).b((QQAppInterface)localObject2, "clk_search_his", "search_his", str2, "", str1, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SearchWordHistoryAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */