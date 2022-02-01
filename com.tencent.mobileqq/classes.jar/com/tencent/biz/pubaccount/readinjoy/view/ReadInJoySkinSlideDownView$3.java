package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.IButtonHandle;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class ReadInJoySkinSlideDownView$3
  implements SceneBuilder.IButtonHandle
{
  ReadInJoySkinSlideDownView$3(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView, View.OnClickListener paramOnClickListener1, String paramString1, int paramInt, String paramString2, Context paramContext, View.OnClickListener paramOnClickListener2) {}
  
  public void a(ILayer paramILayer, ISprite paramISprite, String paramString)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RefreshData localRefreshData = ReadInJoyRefreshManager.b(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView), 0);
    if (paramString.equals("close"))
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
      for (;;)
      {
        try
        {
          paramILayer.e();
          paramILayer.a("skin_id", this.jdField_a_of_type_JavaLangString);
          paramILayer.a("channel_id", this.jdField_a_of_type_Int);
          if ((localRefreshData == null) || (!localRefreshData.isAD)) {
            continue;
          }
          paramILayer.a("ad_page", i);
        }
        catch (JSONException paramISprite)
        {
          paramISprite.printStackTrace();
          continue;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(localQQAppInterface, "", "0X800969E", "0X800969E", 0, 0, this.jdField_a_of_type_JavaLangString, "" + RIJAppSetting.a(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), paramILayer.a(), false);
        return;
        i = 0;
      }
    }
    if (paramString.equals("open_sound"))
    {
      paramILayer = paramILayer.a(HardCodeUtil.a(2131713037));
      if (paramILayer != null) {
        paramILayer.c(0.0F);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a = new MediaPlayer();
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.setDataSource(this.jdField_b_of_type_JavaLangString + "/audio.mp3");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.prepare();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.start();
          paramILayer = new RIJTransMergeKanDianReport.ReportR5Builder();
          try
          {
            paramILayer.e();
            paramILayer.a("skin_id", this.jdField_a_of_type_JavaLangString);
            paramILayer.a("channel_id", this.jdField_a_of_type_Int);
            if ((localRefreshData == null) || (!localRefreshData.isAD)) {
              break label480;
            }
            i = 1;
            paramILayer.a("ad_page", i);
          }
          catch (JSONException paramISprite)
          {
            paramISprite.printStackTrace();
            continue;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(localQQAppInterface, "", "0X800969D", "0X800969D", 0, 0, this.jdField_a_of_type_JavaLangString, "" + RIJAppSetting.a(), String.valueOf(ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView)), paramILayer.a(), false);
          return;
        }
        catch (Exception paramILayer)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramILayer));
          continue;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.isPlaying()) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView.a.start();
        }
        catch (Exception paramILayer) {}
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramILayer));
          continue;
          label480:
          i = 0;
        }
      }
    }
    paramILayer = JumpParser.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    if (paramILayer != null)
    {
      paramILayer.a();
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView).onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
    }
    for (;;)
    {
      ReadInJoySkinSlideDownView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView, this.jdField_a_of_type_Int, paramString, ((BaseNode)paramISprite).e_());
      return;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramILayer = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramILayer.putExtra("url", paramString);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramILayer);
        this.jdField_b_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinSlideDownView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinSlideDownView.3
 * JD-Core Version:    0.7.0.1
 */