package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.viewmodels.QCirclePrivateMessageSettingViewModel;
import com.tencent.biz.qqcircle.widgets.DispatchActionMoveScrollView;
import com.tencent.biz.qqcircle.widgets.pick.IphonePickerView;
import com.tencent.biz.qqcircle.widgets.pick.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import qqcircle.QQCirclePrivateMsgShow.StFuelCostRange;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

public class QCirclePrivateMessageSettingContentPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private ImageView a;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private TextView g;
  private QCirclePrivateMessageSettingViewModel h;
  private QQCirclePrivateMsgShow.StPMSettingData i;
  private QQCirclePrivateMsgShow.StFuelCostRange j;
  private QQCirclePrivateMsgShow.StGetPMSettingRsp k;
  private ImageView l;
  private IphonePickerView.PickerViewAdapter m = new QCirclePrivateMessageSettingContentPart.5(this);
  
  private void a(long paramLong, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131895632);
    }
    paramString = new StringBuilder();
    paramString.append("handleError() return error！ retCode : ");
    paramString.append(paramLong);
    paramString.append(" , errMsg : ");
    paramString.append(str);
    QLog.e("QCirclePrivateMessageSettingContentPart", 1, paramString.toString());
    QCircleToastUtil.a(paramLong, QCircleToast.c, str, 1);
  }
  
  private void a(Context paramContext)
  {
    paramContext = ActionSheet.b(paramContext);
    Object localObject1 = (DispatchActionMoveScrollView)paramContext.findViewById(2131427560);
    ((DispatchActionMoveScrollView)localObject1).a = true;
    ((DispatchActionMoveScrollView)localObject1).setBackgroundResource(17170445);
    localObject1 = (IphonePickerView)LayoutInflater.from(g()).inflate(2131626945, null);
    ((IphonePickerView)localObject1).a(this.m);
    if (this.j != null)
    {
      Object localObject2 = this.i;
      if (localObject2 != null)
      {
        ((IphonePickerView)localObject1).setSelection(0, ((QQCirclePrivateMsgShow.StPMSettingData)localObject2).fuelCost.get() - this.j.min.get());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fuelUseNumSelect() setSelection  row : ");
        ((StringBuilder)localObject2).append(this.i.fuelCost.get() - this.j.min.get());
        ((StringBuilder)localObject2).append(" , fuelCost : ");
        ((StringBuilder)localObject2).append(this.i.fuelCost.get());
        QLog.i("QCirclePrivateMessageSettingContentPart", 1, ((StringBuilder)localObject2).toString());
      }
    }
    ((IphonePickerView)localObject1).setPickListener(new QCirclePrivateMessageSettingContentPart.3(this, (IphonePickerView)localObject1, paramContext));
    paramContext.a(new QCirclePrivateMessageSettingContentPart.4(this));
    paramContext.a((View)localObject1, null);
    paramContext.show();
  }
  
  private void a(ImageView paramImageView)
  {
    this.a.setImageDrawable(null);
    this.c.setImageDrawable(null);
    this.d.setImageDrawable(null);
    this.e.setImageDrawable(null);
    this.f.setImageDrawable(null);
    if (paramImageView != null) {
      paramImageView.setImageDrawable(g().getResources().getDrawable(2130845061));
    }
  }
  
  private void a(ImageView paramImageView, int paramInt, String paramString)
  {
    a(paramImageView);
    paramImageView = this.i;
    if (paramImageView != null) {
      paramImageView.privilgetype.set(paramInt);
    }
    a(paramString);
  }
  
  private void a(String paramString)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(String.valueOf(QCircleCommonUtil.getCurrentAccountLongUin())).setActionType(11).setSubActionType(39).setThrActionType(1).setExt1(paramString).setPageId(f()));
  }
  
  private void a(QQCirclePrivateMsgShow.StGetPMSettingRsp paramStGetPMSettingRsp)
  {
    this.k = paramStGetPMSettingRsp;
    try
    {
      this.i = ((QQCirclePrivateMsgShow.StPMSettingData)new QQCirclePrivateMsgShow.StPMSettingData().mergeFrom(((QQCirclePrivateMsgShow.StPMSettingData)paramStGetPMSettingRsp.setting.get()).toByteArray()));
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    this.j = ((QQCirclePrivateMsgShow.StFuelCostRange)paramStGetPMSettingRsp.fuelCostRange.get());
    paramStGetPMSettingRsp = this.i;
    if (paramStGetPMSettingRsp == null) {
      return;
    }
    int n = paramStGetPMSettingRsp.privilgetype.get();
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 4)
          {
            if (n != 5) {
              a(null);
            } else {
              a(this.f);
            }
          }
          else {
            a(this.a);
          }
        }
        else {
          a(this.c);
        }
      }
      else {
        a(this.e);
      }
    }
    else {
      a(this.d);
    }
    this.g.setText(String.valueOf(this.i.fuelCost.get()));
  }
  
  private void b(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131436562));
    this.c = ((ImageView)paramView.findViewById(2131436565));
    this.d = ((ImageView)paramView.findViewById(2131436564));
    this.e = ((ImageView)paramView.findViewById(2131436563));
    this.f = ((ImageView)paramView.findViewById(2131436385));
    this.g = ((TextView)paramView.findViewById(2131448483));
    this.l = ((ImageView)paramView.findViewById(2131436618));
    this.l.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.l);
    }
    paramView.findViewById(2131445020).setOnClickListener(this);
    paramView.findViewById(2131445023).setOnClickListener(this);
    paramView.findViewById(2131445022).setOnClickListener(this);
    paramView.findViewById(2131445021).setOnClickListener(this);
    paramView.findViewById(2131444955).setOnClickListener(this);
    paramView.findViewById(2131444953).setOnClickListener(this);
  }
  
  private void i()
  {
    this.h = ((QCirclePrivateMessageSettingViewModel)a(QCirclePrivateMessageSettingViewModel.class));
    this.h.a.observe(j(), new QCirclePrivateMessageSettingContentPart.1(this));
    this.h.b.observe(j(), new QCirclePrivateMessageSettingContentPart.2(this));
    this.h.a(HostDataTransUtils.getAccount());
  }
  
  private void l()
  {
    QQCirclePrivateMsgShow.StPMSettingData localStPMSettingData = this.i;
    if ((localStPMSettingData != null) && (this.k != null) && (localStPMSettingData.privilgetype.get() == this.k.setting.privilgetype.get()) && (this.i.fuelCost.get() == this.k.setting.fuelCost.get())) {
      return;
    }
    this.h.a(this.i);
  }
  
  public String a()
  {
    return "QCirclePrivateMessageSettingContentPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
    i();
  }
  
  public boolean ah_()
  {
    l();
    if (c() != null) {
      c().finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n == 2131436618) {
      ah_();
    } else if (n == 2131445020) {
      a(this.a, 4, "1");
    } else if (n == 2131445023) {
      a(this.c, 3, "2");
    } else if (n == 2131445022) {
      a(this.d, 1, "3");
    } else if (n == 2131445021) {
      a(this.e, 2, "4");
    } else if (n == 2131444953) {
      a(this.f, 5, "5");
    } else if (n == 2131444955) {
      a(g());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivateMessageSettingContentPart
 * JD-Core Version:    0.7.0.1
 */