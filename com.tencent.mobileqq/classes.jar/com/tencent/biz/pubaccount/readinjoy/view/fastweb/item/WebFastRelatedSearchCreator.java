package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class WebFastRelatedSearchCreator
  implements ItemCreator, OnStateChangeListener
{
  public static boolean a = false;
  
  private static void b(String paramString1, String paramString2)
  {
    QLog.d("WebFastRelatedSearchCreator", 2, new Object[] { "actionName = ", paramString1, "\n", "r5 = ", paramString2 });
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
  
  public int a(BaseData paramBaseData)
  {
    return 18;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new WebFastRelatedSearchCreator.RelatedSearchViewHolder(LayoutInflater.from(paramContext).inflate(2131560305, paramViewGroup, false), paramBaseData, paramContext, null);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.s == 20;
  }
  
  public void b() {}
  
  public void c()
  {
    a = false;
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastRelatedSearchCreator
 * JD-Core Version:    0.7.0.1
 */