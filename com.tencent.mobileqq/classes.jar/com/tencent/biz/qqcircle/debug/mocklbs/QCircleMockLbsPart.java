package com.tencent.biz.qqcircle.debug.mocklbs;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsInfo;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsRsp;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.requests.QCircleGetRainbowKVConfRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.Random;
import qqcircle.QQCircleConfig.GetRainbowKVConfRsp;

public class QCircleMockLbsPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private static final Random a = new Random();
  private ImageView c;
  private RadioGroup d;
  private MockLbsRsp e;
  private MockLbsInfo f = QCirclePluginGlobalInfo.j();
  
  private RadioButton a(String paramString, boolean paramBoolean)
  {
    RadioButton localRadioButton = new RadioButton(g());
    localRadioButton.setText(paramString);
    localRadioButton.setChecked(paramBoolean);
    localRadioButton.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167084));
    localRadioButton.setPadding(30, 0, 0, 0);
    return localRadioButton;
  }
  
  private MockLbsInfo a(int paramInt)
  {
    if (!m()) {
      return null;
    }
    int i = 0;
    while (i < this.e.administrative_district.size())
    {
      if (paramInt == ((MockLbsInfo)this.e.administrative_district.get(i)).resId) {
        return (MockLbsInfo)this.e.administrative_district.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private void a(ArrayList<MockLbsInfo> paramArrayList)
  {
    this.d.removeAllViews();
    int i = 0;
    while (i < paramArrayList.size())
    {
      MockLbsInfo localMockLbsInfo = (MockLbsInfo)paramArrayList.get(i);
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject = this.f;
      if (localObject != null) {
        bool = ((MockLbsInfo)localObject).district.equals(localMockLbsInfo.district);
      }
      localMockLbsInfo.resId = a.nextInt();
      localObject = a(localMockLbsInfo.district, bool);
      ((RadioButton)localObject).setId(localMockLbsInfo.resId);
      ((RadioButton)localObject).setTag(localMockLbsInfo);
      this.d.addView((View)localObject, new RadioGroup.LayoutParams(-1, -2));
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean, QQCircleConfig.GetRainbowKVConfRsp paramGetRainbowKVConfRsp)
  {
    if (paramBoolean) {
      if (paramGetRainbowKVConfRsp.data.get() == null) {
        return;
      }
    }
    try
    {
      this.e = ((MockLbsRsp)new Gson().fromJson(paramGetRainbowKVConfRsp.data.get(), MockLbsRsp.class));
      if (!m()) {
        break label97;
      }
      a(this.e.administrative_district);
      return;
    }
    catch (Exception localException)
    {
      label60:
      StringBuilder localStringBuilder;
      break label60;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetRainbowKVConfRsp json exception!： json is:");
    localStringBuilder.append(paramGetRainbowKVConfRsp.data.get());
    QLog.i("QCircleMockLbsPart", 1, localStringBuilder.toString());
    label97:
  }
  
  private void i()
  {
    this.d.setOnCheckedChangeListener(new QCircleMockLbsPart.1(this));
  }
  
  private void l()
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetRainbowKVConfRequest("4aa831c0-51c9-4dc9-9ab2-1e99ec9031f0", "trpc.feedcloud.commgateway.CommGateway.TEST", "district_latitude_longitude.json"), new QCircleMockLbsPart.2(this));
  }
  
  private boolean m()
  {
    MockLbsRsp localMockLbsRsp = this.e;
    return (localMockLbsRsp != null) && (localMockLbsRsp.administrative_district != null) && (this.e.administrative_district.size() > 0);
  }
  
  private void n()
  {
    if ((!j().onBackEvent()) && (c() != null)) {
      c().finish();
    }
  }
  
  public String a()
  {
    return "QCircleMockLbsPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.c = ((ImageView)paramView.findViewById(2131436618));
    this.c.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.c);
    }
    this.d = ((RadioGroup)paramView.findViewById(2131444763));
    i();
    l();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436618) {
      n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.debug.mocklbs.QCircleMockLbsPart
 * JD-Core Version:    0.7.0.1
 */