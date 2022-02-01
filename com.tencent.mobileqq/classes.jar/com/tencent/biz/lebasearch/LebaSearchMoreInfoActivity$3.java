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
      this.a.a = paramObject.getBoolean("isOpen");
      this.a.c = paramObject.getString("name");
      if (this.a.c != null)
      {
        paramObject = this.a;
        paramObject.b = paramObject.getString(2131696040, new Object[] { paramObject.c });
      }
      LebaSearchMoreInfoActivity.a(this.a);
      return;
    }
    paramBoolean = paramObject.getBoolean("result");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {
      paramObject = this.a.getString(2131696034);
    } else {
      paramObject = this.a.getString(2131696033);
    }
    localStringBuilder.append(paramObject);
    localStringBuilder.append(this.a.getString(2131696032));
    localStringBuilder.append(this.a.c);
    if (paramBoolean) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    QQToast.a(this.a, paramInt, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
    paramObject = this.a;
    paramInt = i;
    if (paramBoolean) {
      paramInt = -1;
    }
    paramObject.setResult(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity.3
 * JD-Core Version:    0.7.0.1
 */