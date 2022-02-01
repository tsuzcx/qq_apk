package com.tencent.mobileqq.activity.selectmember.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISelectMemberApi
  extends QRouteApi
{
  public abstract void startSelectMemberActivityForResult(Activity paramActivity, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.api.ISelectMemberApi
 * JD-Core Version:    0.7.0.1
 */