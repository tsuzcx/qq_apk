package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.beans.QCircleAggregationBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;

public class QCircleAggregationSchemeParser
  extends QCircleBaseSchemeParser
{
  private void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    if ((paramContext != null) && (paramQCircleSchemeBean != null))
    {
      if (paramQCircleSchemeBean.getAttrs() == null) {
        return;
      }
      HashMap localHashMap = paramQCircleSchemeBean.getAttrs();
      QCircleAggregationBean localQCircleAggregationBean = new QCircleAggregationBean();
      a(paramQCircleSchemeBean, localQCircleAggregationBean);
      a(localQCircleAggregationBean, localHashMap);
      localQCircleAggregationBean.setTroopUin((String)localHashMap.get("key_troop_uin"));
      QCircleLauncher.a(paramContext, localQCircleAggregationBean);
    }
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    b(paramContext, paramQCircleSchemeBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleAggregationSchemeParser
 * JD-Core Version:    0.7.0.1
 */