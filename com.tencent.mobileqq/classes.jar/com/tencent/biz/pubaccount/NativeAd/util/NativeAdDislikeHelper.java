package com.tencent.biz.pubaccount.NativeAd.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;

public class NativeAdDislikeHelper
{
  private ActionSheet a;
  private Activity b;
  private AppInterface c;
  
  public NativeAdDislikeHelper(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.b = paramActivity;
    this.c = paramAppInterface;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, ArrayList<DislikeInfo> paramArrayList)
  {
    if ((paramAdvertisementInfo != null) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      this.a = ((ActionSheet)ActionSheetHelper.b(this.b, null));
      Object localObject = new NativeAdDislikeHelper.1(this);
      this.a.registerWatchDisMissActionListener((ActionSheet.WatchDismissActions)localObject);
      localObject = new ReadInJoyDisLikeDialogViewForAd(this.b);
      ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new NativeAdDislikeHelper.2(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new NativeAdDislikeHelper.3(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(paramArrayList);
      this.a.setActionContentView((View)localObject, null);
      try
      {
        if (!this.a.isShowing())
        {
          if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()) && ((this.b instanceof Activity)))
          {
            this.a.getWindow().setFlags(8, 8);
            this.a.getWindow().getDecorView().setSystemUiVisibility(this.b.getWindow().getDecorView().getSystemUiVisibility());
            this.a.setOnShowListener(new NativeAdDislikeHelper.4(this));
          }
          this.a.show();
          return;
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdDislikeHelper
 * JD-Core Version:    0.7.0.1
 */