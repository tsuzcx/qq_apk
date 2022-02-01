package com.tencent.biz.lebasearch;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.widget.QQToast;

class LebaSearchMoreInfoActivity$3
  implements BusinessObserver
{
  LebaSearchMoreInfoActivity$3(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (Bundle)paramObject;
    int i = 0;
    if (paramInt != 17)
    {
      if (paramInt != 18) {
        return;
      }
      this.a.g = paramObject.getBoolean("isOpen");
      this.a.h = paramObject.getString("name");
      if (this.a.h != null)
      {
        paramObject = this.a;
        paramObject.e = paramObject.getString(2131893802, new Object[] { paramObject.h });
      }
      LebaSearchMoreInfoActivity.a(this.a);
      return;
    }
    paramBoolean = paramObject.getBoolean("result");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {
      paramObject = this.a.getString(2131893796);
    } else {
      paramObject = this.a.getString(2131893795);
    }
    localStringBuilder.append(paramObject);
    localStringBuilder.append(this.a.getString(2131893794));
    localStringBuilder.append(this.a.h);
    if (paramBoolean) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    QQToast.makeText(this.a, paramInt, localStringBuilder.toString(), 1).show(this.a.getTitleBarHeight());
    paramObject = this.a;
    paramInt = i;
    if (paramBoolean) {
      paramInt = -1;
    }
    paramObject.setResult(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity.3
 * JD-Core Version:    0.7.0.1
 */