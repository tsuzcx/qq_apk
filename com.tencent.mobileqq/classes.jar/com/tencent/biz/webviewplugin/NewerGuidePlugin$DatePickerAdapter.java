package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Calendar;

class NewerGuidePlugin$DatePickerAdapter
  implements IphonePickerView.PickerViewAdapter
{
  private int jdField_a_of_type_Int;
  
  public NewerGuidePlugin$DatePickerAdapter(NewerGuidePlugin paramNewerGuidePlugin, int paramInt)
  {
    if (paramInt < 1897)
    {
      paramNewerGuidePlugin = Calendar.getInstance();
      paramNewerGuidePlugin.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      this.jdField_a_of_type_Int = paramNewerGuidePlugin.get(1);
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
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
        localCalendar.set(1, NewerGuidePlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin) + 1897);
        localCalendar.set(2, NewerGuidePlugin.c(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin));
        localCalendar.set(5, 1);
        return localCalendar.getActualMaximum(5);
      }
      return 12;
    }
    return this.jdField_a_of_type_Int - 1897 + 1;
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
        localStringBuilder.append(HardCodeUtil.a(2131707463));
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2 + 1);
      localStringBuilder.append(HardCodeUtil.a(2131707469));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2 + 1897);
    localStringBuilder.append(HardCodeUtil.a(2131707468));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.DatePickerAdapter
 * JD-Core Version:    0.7.0.1
 */