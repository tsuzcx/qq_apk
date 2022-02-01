package com.tencent.gdtad.basics.motivevideo.title;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.report.GdtMvMiniAppReportHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;

public class GdtMvTitleHelper
  implements View.OnClickListener
{
  protected int a;
  protected View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ImageView a;
  private GdtMvTitleHelper.MvTitleListener jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper$MvTitleListener;
  private IGdtMvTitleFactory jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory;
  protected boolean a;
  protected int b = 0;
  
  public GdtMvTitleHelper()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private static int a(GdtAd paramGdtAd)
  {
    paramGdtAd = a(paramGdtAd, 104804);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRewardVideoCloseBtnAppearSecFromExp = ");
    localStringBuilder.append(paramGdtAd);
    QLog.i("GdtMvTitleHelper", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramGdtAd)) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt(paramGdtAd);
      return i;
    }
    catch (Exception paramGdtAd)
    {
      QLog.i("GdtMvTitleHelper", 1, "getRewardVideoCloseBtnAppearSecFromExp error", paramGdtAd);
    }
    return 0;
  }
  
  private static String a(GdtAd paramGdtAd, int paramInt)
  {
    if (paramGdtAd != null) {
      try
      {
        paramGdtAd = paramGdtAd.getExpMap();
        int i = 0;
        while (i < paramGdtAd.size())
        {
          if (((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).key.get() == paramInt)
          {
            paramGdtAd = ((qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramGdtAd.get(i)).value.get();
            return paramGdtAd;
          }
          i += 1;
        }
        StringBuilder localStringBuilder;
        return "";
      }
      catch (Throwable paramGdtAd)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("exp_map error");
        localStringBuilder.append(paramGdtAd);
        QLog.e("GdtMvTitleHelper", 1, localStringBuilder.toString());
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory = new GdtMvCircleTitleFactory();
    } else if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory = new GdtMvOldTitleFactory();
    } else {
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory = new GdtMvNewTitleFactory();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initView countDownStyle =");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory.toString());
    QLog.i("GdtMvTitleHelper", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory.a(paramViewGroup, this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    IGdtMvTitleFactory localIGdtMvTitleFactory = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory;
    if ((localIGdtMvTitleFactory instanceof GdtMvCircleTitleFactory)) {
      ((GdtMvCircleTitleFactory)localIGdtMvTitleFactory).a(paramLong1, paramLong2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    IGdtMvTitleFactory localIGdtMvTitleFactory = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory;
    if (localIGdtMvTitleFactory == null)
    {
      QLog.i("GdtMvTitleHelper", 1, "updateCountDown factory is null");
      return;
    }
    localIGdtMvTitleFactory.a(paramLong1, paramLong2, paramLong3);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramLong >= this.b))
    {
      QLog.i("GdtMvTitleHelper", 4, "set close button visible");
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    label135:
    try
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup == null)
      {
        QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen bar == null");
        return;
      }
      if (!paramBoolean)
      {
        QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen !isPortait");
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      LiuHaiUtils.a(paramActivity);
      if (!LiuHaiUtils.b()) {
        break label135;
      }
      localLayoutParams.topMargin = LiuHaiUtils.b(paramActivity);
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      paramActivity = new StringBuilder();
      paramActivity.append("fitSpecialScreen addHeight = ");
      paramActivity.append(localLayoutParams.topMargin);
      QLog.i("GdtMvTitleHelper", 1, paramActivity.toString());
      return;
    }
    catch (Exception paramActivity)
    {
      label101:
      break label101;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("initView countDownStyle =");
    paramActivity.append(this.jdField_a_of_type_Int);
    QLog.i("GdtMvTitleHelper", 1, paramActivity.toString());
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    IGdtMvTitleFactory localIGdtMvTitleFactory = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleIGdtMvTitleFactory;
    if (localIGdtMvTitleFactory == null)
    {
      QLog.i("GdtMvTitleHelper", 1, "refreshVoiceIconDrawableInner factory is null");
      return;
    }
    localIGdtMvTitleFactory.a(paramContext, paramBoolean);
  }
  
  public void a(View paramView, GdtMvTitleHelper.MvTitleListener paramMvTitleListener, GdtMotiveVideoModel paramGdtMotiveVideoModel, GdtMvMiniAppReportHelper paramGdtMvMiniAppReportHelper)
  {
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.a() != null) && (paramGdtMotiveVideoModel.a().exp_info.has()) && (paramGdtMotiveVideoModel.a().exp_info.video_countdown_style.has())) {
      this.jdField_a_of_type_Int = paramGdtMotiveVideoModel.a().exp_info.video_countdown_style.get();
    }
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.a() != null)) {
      this.jdField_a_of_type_Boolean = paramGdtMotiveVideoModel.a().isMvCircleButtonStyle();
    }
    if (paramGdtMotiveVideoModel != null) {
      this.b = a(paramGdtMotiveVideoModel.a());
    }
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper$MvTitleListener = paramMvTitleListener;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367584));
    paramView = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramView == null)
    {
      QLog.i("GdtMvTitleHelper", 1, "bar == null");
      return;
    }
    a(paramView);
    if (paramGdtMvMiniAppReportHelper != null)
    {
      paramGdtMvMiniAppReportHelper.a(this.jdField_a_of_type_AndroidWidgetImageView);
      paramGdtMvMiniAppReportHelper.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public boolean a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    GdtMvTitleHelper.MvTitleListener localMvTitleListener;
    if ((i != 2131367795) && (i != 2131367787) && (i != 2131364644))
    {
      if ((i == 2131367797) || (i == 2131367789) || (i == 2131364646))
      {
        localMvTitleListener = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper$MvTitleListener;
        if (localMvTitleListener != null) {
          localMvTitleListener.a(true);
        }
      }
    }
    else
    {
      localMvTitleListener = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoTitleGdtMvTitleHelper$MvTitleListener;
      if (localMvTitleListener != null) {
        localMvTitleListener.b(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvTitleHelper
 * JD-Core Version:    0.7.0.1
 */