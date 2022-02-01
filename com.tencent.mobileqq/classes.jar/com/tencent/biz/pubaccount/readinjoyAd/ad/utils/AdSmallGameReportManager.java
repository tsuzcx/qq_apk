package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo.SmallMiniGameData;
import java.util.concurrent.CopyOnWriteArrayList;

public class AdSmallGameReportManager
{
  private CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList();
  
  public void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (paramIReadInJoyModel.a() == null) || (paramIReadInJoyModel.a().mSmallMiniGameInfo == null) || (paramIReadInJoyModel.a().mSmallMiniGameInfo.a == null)) {}
    String str;
    do
    {
      return;
      str = paramIReadInJoyModel.a().mSmallMiniGameInfo.b + "_" + ((SmallMiniGameInfo.SmallMiniGameData)paramIReadInJoyModel.a().mSmallMiniGameInfo.a.get(paramInt1)).a;
    } while (this.a.contains(str));
    this.a.add(str);
    NativeAdUtils.a(paramContext, paramIReadInJoyModel.a(), paramIReadInJoyModel.g(), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdSmallGameReportManager
 * JD-Core Version:    0.7.0.1
 */