package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.view.View;
import com.tencent.mobileqq.activity.qqsettingme.api.IQVipMedalViewApi;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.widget.QVipMedalView;

public class QVipMedalViewApiImpl
  implements IQVipMedalViewApi
{
  public void setData(View paramView, MedalList paramMedalList)
  {
    ((QVipMedalView)paramView).setData(paramMedalList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.QVipMedalViewApiImpl
 * JD-Core Version:    0.7.0.1
 */