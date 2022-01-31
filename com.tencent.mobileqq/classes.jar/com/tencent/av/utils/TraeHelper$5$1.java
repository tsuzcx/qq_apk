package com.tencent.av.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import kvq;
import lqb;
import mhr;
import miu;
import mjd;
import mpq;
import mqq.util.WeakReference;

class TraeHelper$5$1
  implements Runnable
{
  TraeHelper$5$1(TraeHelper.5 param5) {}
  
  public void run()
  {
    Object localObject;
    kvq localkvq;
    try
    {
      if (this.a.this$0.a == null) {
        return;
      }
      localObject = this.a.jdField_a_of_type_AndroidWidgetButton.getResources();
      localkvq = this.a.this$0.a.a();
      if ((localkvq.d == 2) || ((localkvq.d == 4) && (localkvq.I) && (mpq.a(this.a.jdField_a_of_type_AndroidContentContext))) || (this.a.this$0.a.m()) || (this.a.this$0.a.l())) {
        break label564;
      }
      if (!miu.b(this.a.this$0)) {
        break label392;
      }
    }
    catch (Exception localException)
    {
      String str1;
      QLog.e("TraeSessionHelper", 1, "onUpdateButtonHandFree ui task fail.", localException);
      return;
    }
    int i = 8;
    str1 = ((Resources)localObject).getString(2131630065);
    if ((miu.a(this.a.this$0)) && (mhr.a())) {
      if ("DEVICE_BLUETOOTHHEADSET".equals(localkvq.p))
      {
        str1 = ((Resources)localObject).getString(2131630063);
        lqb.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 3012);
        i = 5;
      }
    }
    label198:
    int j;
    label392:
    String str2;
    for (;;)
    {
      localObject = miu.a(this.a.this$0, this.a.jdField_a_of_type_AndroidContentContext.getResources(), i, miu.c(this.a.this$0));
      this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawables(null, (Drawable)localObject, null, null);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(str1);
      if (this.a.this$0.c != null)
      {
        localObject = (mjd)this.a.this$0.c.get();
        if (localObject != null) {
          ((mjd)localObject).a(localkvq.N, this.a.this$0.b);
        }
      }
      QLog.w("TraeSessionHelper", 1, "onUpdateButtonHandFree, btnText[" + str1 + "], deviceName[" + localkvq.p + "], mCurrentAudioLevel[" + this.a.this$0.b + "]");
      return;
      j = 0;
      break;
      if ("DEVICE_WIREDHEADSET".equals(localkvq.p))
      {
        str2 = ((Resources)localObject).getString(2131630066);
        i = 6;
      }
      else if ("DEVICE_EARPHONE".equals(localkvq.p))
      {
        str2 = ((Resources)localObject).getString(2131630064);
        i = 7;
      }
      else if ("DEVICE_SPEAKERPHONE".equals(localkvq.p))
      {
        str2 = ((Resources)localObject).getString(2131630065);
        i = 8;
        continue;
        lqb.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 3012);
        if (this.a.this$0.b == 1)
        {
          if (j == 0) {
            break label569;
          }
          i = 3;
        }
      }
    }
    for (;;)
    {
      str2 = ((Resources)localObject).getString(2131630065);
      break label198;
      int k = this.a.this$0.b;
      if (k == 2) {
        if (j != 0)
        {
          i = 4;
        }
        else
        {
          i = 2;
          continue;
          i = 8;
          break label198;
          label564:
          j = 1;
          break;
          label569:
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.5.1
 * JD-Core Version:    0.7.0.1
 */