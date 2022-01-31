package com.tencent.biz.pubaccount.readinjoy;

import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lat;
import law;
import lay;
import laz;
import lba;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ReadInJoyNaviController
{
  public static int b;
  public static int c;
  public static int d = 7;
  public int a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected ReadInJoyObserver a;
  private ReadInJoyNavigationGridview jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview;
  private boolean jdField_a_of_type_Boolean = true;
  public final int e = ViewUtils.a(5.0F);
  
  public ReadInJoyNaviController(ViewGroup paramViewGroup, ReadInJoyNavigationGridview paramReadInJoyNavigationGridview, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lay(this);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview = paramReadInJoyNavigationGridview;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview.setChannelButtonListener(new lba(this));
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    a();
  }
  
  public static ChannelCoverInfo a()
  {
    ChannelCoverInfo localChannelCoverInfo = new ChannelCoverInfo();
    localChannelCoverInfo.mChannelType = 0;
    if (ReadInJoyHelper.g())
    {
      localChannelCoverInfo.mChannelCoverId = 56;
      localChannelCoverInfo.mChannelCoverName = "视频";
      return localChannelCoverInfo;
    }
    localChannelCoverInfo.mChannelCoverId = 0;
    localChannelCoverInfo.mChannelCoverName = "推荐";
    return localChannelCoverInfo;
  }
  
  public static String a(int paramInt, ChannelCoverInfo paramChannelCoverInfo)
  {
    JSONObject localJSONObject = ReadInJoyUtils.b();
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localJSONObject.toString();
      if (paramChannelCoverInfo != null) {
        for (;;)
        {
          try
          {
            localJSONObject.put("channel_id", paramChannelCoverInfo.mChannelCoverId);
            if (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelJumpUrl)) {
              break label89;
            }
            paramInt = 1;
            localJSONObject.put("content_type", paramInt);
            localJSONObject.put("channel_index", c);
          }
          catch (Exception paramChannelCoverInfo)
          {
            paramChannelCoverInfo.printStackTrace();
          }
          break;
          label89:
          paramInt = 2;
        }
      }
      localJSONObject.put("channel_id", -1);
      localJSONObject.put("content_type", -1);
      localJSONObject.put("channel_index", -1);
    }
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        if (!localChannelCoverInfo.isExternalExposure) {
          localArrayList.add(localChannelCoverInfo);
        }
      }
    }
    QLog.d("ReadInJoyNaviController", 2, "filtered channel list size: " + localArrayList.size());
    return localArrayList;
  }
  
  public static void a(int paramInt, String paramString)
  {
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      PublicAccountReportUtils.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", paramString, false);
      return;
      str = "0X8008B81";
      continue;
      str = "0X8008B83";
    }
  }
  
  private void a(long paramLong)
  {
    ReadInJoyUtils.b().postDelayed(new laz(this), paramLong);
  }
  
  public void a()
  {
    try
    {
      ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(162);
      List localList = localReadInJoyLogicManager.a().a(0);
      if ((localList == null) || (localList.size() == 0))
      {
        localReadInJoyLogicManager.a().b(0);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNaviController", 2, "No channel Cache info.");
        }
      }
      for (;;)
      {
        localReadInJoyLogicManager.a().a(0);
        return;
        a(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview.a() <= 0)
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNaviController", 2, "No channel info.");
      }
    }
    do
    {
      return;
      b = paramInt;
    } while (this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("mReadInJoyNavigation") != null);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 48;
    localLayoutParams.topMargin = this.jdField_a_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview.a().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = ((ChannelCoverInfo)localIterator.next()).clone();
      if (localChannelCoverInfo != null) {
        if (paramInt != localChannelCoverInfo.mChannelCoverId) {
          break label174;
        }
      }
      label174:
      for (boolean bool = true;; bool = false)
      {
        localChannelCoverInfo.isSelected = bool;
        if (paramInt == localChannelCoverInfo.mChannelCoverId) {
          c = i;
        }
        localArrayList.add(localChannelCoverInfo);
        i += 1;
        break;
      }
    }
    a(localArrayList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview, localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview.setTag("mReadInJoyNavigation");
    ReadInJoyUtils.b().postDelayed(new lat(this), 0L);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    }
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    Iterator localIterator;
    int i;
    if (a()) {
      if (paramChannelCoverInfo != null)
      {
        localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview.a().iterator();
        i = 0;
      }
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
        if ((localChannelCoverInfo != null) && (localChannelCoverInfo.mChannelCoverId == paramChannelCoverInfo.mChannelCoverId)) {
          c = i;
        }
      }
      else
      {
        ReadInJoyUtils.b().postDelayed(new law(this, paramChannelCoverInfo), 0L);
        return;
      }
      i += 1;
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNaviController", 2, "setAdapterData.");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview.setNaviBarAdapterDataSet(a(paramList));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("mReadInJoyNavigation") != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview.a();
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController
 * JD-Core Version:    0.7.0.1
 */