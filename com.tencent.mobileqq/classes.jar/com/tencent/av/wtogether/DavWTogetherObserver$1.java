package com.tencent.av.wtogether;

import android.app.Activity;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;
import lbz;
import lfe;
import mwz;
import mxd;
import myx;
import nad;

public class DavWTogetherObserver$1
  implements Runnable
{
  public DavWTogetherObserver$1(mwz parammwz, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    mwz.a(this.this$0).e(0L, this.jdField_a_of_type_Int);
    AVActivity localAVActivity = mwz.a(this.this$0).a();
    if ((!this.jdField_a_of_type_Boolean) && (this.b) && (!localAVActivity.isFinishing()) && (nad.b()))
    {
      Object localObject = lbz.a().a();
      localObject = ((mxd)this.this$0.a.a(15)).b((lfe)localObject);
      if (((myx)localObject).jdField_a_of_type_Boolean) {
        break label103;
      }
      ((myx)localObject).jdField_a_of_type_Boolean = true;
      nad.a(localAVActivity, localAVActivity.getString(2131695739));
    }
    label103:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("WTogether", 2, "showNetTip, have shown. 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.DavWTogetherObserver.1
 * JD-Core Version:    0.7.0.1
 */