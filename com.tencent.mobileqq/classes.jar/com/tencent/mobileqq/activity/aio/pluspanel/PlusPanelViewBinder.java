package com.tencent.mobileqq.activity.aio.pluspanel;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PanelAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PlusPanelViewBinder
  extends BaseViewBinder
{
  private void b(ArrayList<PluginData> paramArrayList, PanelAdapter paramPanelAdapter, EmoticonPagerRadioGroup paramEmoticonPagerRadioGroup)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramArrayList, paramPanelAdapter, paramEmoticonPagerRadioGroup);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new PlusPanelViewBinder.3(this, paramArrayList, paramPanelAdapter, paramEmoticonPagerRadioGroup));
  }
  
  public void a(LifecycleOwner paramLifecycleOwner, PlusPanelViewModel paramPlusPanelViewModel, PanelAdapter paramPanelAdapter, EmoticonPagerRadioGroup paramEmoticonPagerRadioGroup)
  {
    paramPlusPanelViewModel.a().observe(paramLifecycleOwner, new PlusPanelViewBinder.1(this, paramPanelAdapter, paramEmoticonPagerRadioGroup));
    paramPlusPanelViewModel.b().observe(paramLifecycleOwner, new PlusPanelViewBinder.2(this, paramPanelAdapter));
    paramPlusPanelViewModel.a(paramLifecycleOwner);
  }
  
  void a(ArrayList<PluginData> paramArrayList, PanelAdapter paramPanelAdapter, EmoticonPagerRadioGroup paramEmoticonPagerRadioGroup)
  {
    paramPanelAdapter.a(paramArrayList);
    int j = paramPanelAdapter.getCount();
    int i = 0;
    if (j > 1)
    {
      try
      {
        paramEmoticonPagerRadioGroup.synButton(paramPanelAdapter.getCount());
      }
      catch (Exception paramArrayList)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e=");
        localStringBuilder.append(paramArrayList);
        QLog.d("PlusPanel", 2, localStringBuilder.toString());
      }
      paramEmoticonPagerRadioGroup.setVisibility(0);
    }
    else
    {
      paramEmoticonPagerRadioGroup.setVisibility(4);
    }
    paramPanelAdapter.notifyDataSetChanged();
    j = paramPanelAdapter.getCount();
    while (i < j)
    {
      paramPanelAdapter.a(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */