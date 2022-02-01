package com.tencent.mobileqq.activity.qwallet;

import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IToPayManager
  extends QRouteApi
{
  public static final String KEY_RECOMMEND = "recommend";
  public static final String KEY_TIPS = "tips";
  
  public abstract HashMap<String, Object> getTopayList(IToPayManager.TopayListener paramTopayListener, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void removeObserver(AppRuntime paramAppRuntime);
  
  public abstract void topay(BaseActivity paramBaseActivity, ArrayList<ResultRecord> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.IToPayManager
 * JD-Core Version:    0.7.0.1
 */