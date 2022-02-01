package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;

public class WebFastProteusAdInnerCreator
  extends WebFastBaseProteusAdCreator
{
  public int a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusInnerData)) {
      return FastWeqAdUtils.a((ProteusInnerData)paramBaseData);
    }
    return 20;
  }
  
  protected BaseItemViewHolder a(View paramView, BaseData paramBaseData)
  {
    return new WebFastProteusAdInnerCreator.ProteusItemHolder(this, paramView, paramBaseData, this.a);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = null;
    if (this.a != null) {
      localObject = (Context)this.a.get();
    }
    if ((!(localObject instanceof Activity)) || (((Activity)localObject).getWindow().getAttributes().softInputMode != 4)) {}
    do
    {
      return;
      localObject = (InputMethodManager)((Context)localObject).getSystemService("input_method");
    } while (localObject == null);
    ((InputMethodManager)localObject).hideSoftInputFromWindow(paramAbsListView.getWindowToken(), 2);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.s == 22);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusAdInnerCreator
 * JD-Core Version:    0.7.0.1
 */