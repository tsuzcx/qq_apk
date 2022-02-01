package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdiomWordChainBizImpl
  implements IWordChainBiz
{
  private List<String> a;
  
  public String a(List<String> paramList, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      String str = (String)paramList.remove(i);
      if ((!TextUtils.isEmpty(str)) && (str.length() == 4)) {
        return str;
      }
      i -= 1;
    }
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = new ArrayList();
        this.a.add(HardCodeUtil.a(2131705735));
        this.a.add(HardCodeUtil.a(2131705740));
        this.a.add(HardCodeUtil.a(2131705736));
        this.a.add(HardCodeUtil.a(2131705741));
        this.a.add(HardCodeUtil.a(2131705737));
        this.a.add(HardCodeUtil.a(2131705739));
        this.a.add(HardCodeUtil.a(2131705733));
        this.a.add(HardCodeUtil.a(2131705746));
        this.a.add(HardCodeUtil.a(2131705743));
        this.a.add(HardCodeUtil.a(2131705745));
        this.a.add(HardCodeUtil.a(2131705744));
      }
      i = new Random().nextInt(this.a.size());
      if (QLog.isColorLevel()) {
        QLog.i("IdiomWordChainBizImpl", 2, "getRandomIdiom get backIdiom:" + i + " backIdiomListSize:" + this.a.size());
      }
      return (String)this.a.get(i);
    }
    return "";
  }
  
  public void a(String paramString) {}
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() == 4) && (HbBusiUtils.a(paramString) >= 4);
  }
  
  public InputFilter[] a(int paramInt)
  {
    if ((SystemUtil.d()) || (SystemUtil.e())) {}
    for (int i = 1; (i == 0) && (paramInt > 0); i = 0) {
      return new InputFilter[] { new InputFilter.LengthFilter(paramInt) };
    }
    return new InputFilter[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.IdiomWordChainBizImpl
 * JD-Core Version:    0.7.0.1
 */