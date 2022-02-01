package com.tencent.biz.pubaccount.NativeAd.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;

public class NativeAdDislikeHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public NativeAdDislikeHelper(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, ArrayList<DislikeInfo> paramArrayList)
  {
    if ((paramAdvertisementInfo == null) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
      Object localObject = new NativeAdDislikeHelper.1(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.registerWatchDisMissActionListener((ActionSheet.WatchDismissActions)localObject);
      localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
      ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new NativeAdDislikeHelper.2(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new NativeAdDislikeHelper.3(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(paramArrayList);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
        {
          if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()) && ((this.jdField_a_of_type_AndroidAppActivity instanceof Activity)))
          {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnShowListener(new NativeAdDislikeHelper.4(this));
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdDislikeHelper
 * JD-Core Version:    0.7.0.1
 */