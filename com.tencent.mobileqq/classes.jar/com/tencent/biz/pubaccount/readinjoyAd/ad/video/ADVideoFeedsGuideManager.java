package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoFeedsGuideManager;
import com.tencent.mobileqq.kandian.base.view.widget.ICircleCountDownView;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ADVideoFeedsGuideManager
  implements Handler.Callback, IADVideoFeedsGuideManager
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ADVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
  private ArrayList<ProgressStateListener> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public ADVideoFeedsGuideManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private int a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.a != null))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
    }
    try
    {
      paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
      boolean bool = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
      if (bool) {
        return 3;
      }
      return 2;
    }
    catch (JSONException paramVideoInfo) {}
    return 0;
    return 2;
  }
  
  private boolean b(VideoPlayParam paramVideoPlayParam)
  {
    return (paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a != null);
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
    if ((localObject != null) && (((ADVideoItemHolder)localObject).f != null))
    {
      Resources localResources = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.f.getResources();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null))
      {
        String str;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a.l))) {
          str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a.l;
        } else {
          str = "";
        }
        i = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
        if ((i != 0) && (i != 1))
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                localObject = str;
              } else {
                localObject = localResources.getText(2131717920).toString();
              }
            }
            else {
              localObject = localResources.getText(2131717918).toString();
            }
          }
          else
          {
            localObject = str;
            if (TextUtils.isEmpty(str)) {
              localObject = localResources.getText(2131717917).toString();
            }
          }
        }
        else
        {
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = localResources.getText(2131717969).toString();
          }
        }
      }
      else
      {
        localObject = localResources.getText(2131717969).toString();
      }
      int i = 2130843209;
      if (localResources.getText(2131717917).toString().equals(localObject)) {
        i = 2130843208;
      } else if (localResources.getText(2131717918).toString().equals(localObject)) {
        i = 2130843211;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.f.setText((CharSequence)localObject);
      int j = AIOUtils.b(12.0F, localResources);
      localObject = localResources.getDrawable(i);
      ((Drawable)localObject).setBounds(0, 0, j, j);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.f.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
  }
  
  public ADVideoItemHolder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(ProgressStateListener paramProgressStateListener)
  {
    if ((paramProgressStateListener != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramProgressStateListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramProgressStateListener);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    ADVideoItemHolder localADVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
    if (localADVideoItemHolder != null)
    {
      localADVideoItemHolder.d.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramVideoItemHolder instanceof ADVideoItemHolder))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder = ((ADVideoItemHolder)paramVideoItemHolder);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder = null;
  }
  
  public boolean a()
  {
    if (!this.b)
    {
      ADVideoItemHolder localADVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
      if ((localADVideoItemHolder != null) && (localADVideoItemHolder.d != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.getVisibility() == 0))
      {
        if (this.c)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a("continue_pause", false);
          this.c = false;
          return true;
        }
        g();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      }
    }
    this.c = false;
    return false;
  }
  
  public boolean a(VideoPlayParam paramVideoPlayParam)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.b = true;
    b();
  }
  
  public void d()
  {
    this.b = false;
    a();
  }
  
  public void e()
  {
    ADVideoItemHolder localADVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
    if ((localADVideoItemHolder != null) && (localADVideoItemHolder.d != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    ADVideoItemHolder localADVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
    if ((localADVideoItemHolder != null) && (localADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != 3)) {
      this.c = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    paramMessage = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
    if ((paramMessage != null) && (paramMessage.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetICircleCountDownView != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetICircleCountDownView.a(20))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a("continue_pause", false);
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_Boolean = true;
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext()) {
            ((ProgressStateListener)paramMessage.next()).a();
          }
        }
        this.jdField_a_of_type_Boolean = false;
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager
 * JD-Core Version:    0.7.0.1
 */