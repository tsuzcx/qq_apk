package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Calendar;

class NewerGuidePlugin$DatePickerAdapter
  implements IphonePickerView.PickerViewAdapter
{
  private int b;
  
  public NewerGuidePlugin$DatePickerAdapter(NewerGuidePlugin paramNewerGuidePlugin, int paramInt)
  {
    if (paramInt < 1897)
    {
      paramNewerGuidePlugin = Calendar.getInstance();
      paramNewerGuidePlugin.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      this.b = paramNewerGuidePlugin.get(1);
      return;
    }
    this.b = paramInt;
  }
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 0;
        }
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(1, NewerGuidePlugin.e(this.a) + 1897);
        localCalendar.set(2, NewerGuidePlugin.f(this.a));
        localCalendar.set(5, 1);
        return localCalendar.getActualMaximum(5);
      }
      return 12;
    }
    return this.b - 1897 + 1;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return "";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt2 + 1);
        localStringBuilder.append(HardCodeUtil.a(2131905281));
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2 + 1);
      localStringBuilder.append(HardCodeUtil.a(2131905287));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2 + 1897);
    localStringBuilder.append(HardCodeUtil.a(2131905286));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.DatePickerAdapter
 * JD-Core Version:    0.7.0.1
 */