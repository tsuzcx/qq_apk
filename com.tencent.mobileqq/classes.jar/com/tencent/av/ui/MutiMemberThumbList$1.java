package com.tencent.av.ui;

import android.graphics.Bitmap;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kth;
import mjg;
import mqq.os.MqqHandler;

class MutiMemberThumbList$1
  implements Runnable
{
  MutiMemberThumbList$1(MutiMemberThumbList paramMutiMemberThumbList, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    int i;
    if (this.jdField_a_of_type_Int > MutiMemberThumbList.a(this.this$0).length)
    {
      bool = true;
      i = 0;
    }
    for (;;)
    {
      if ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < MutiMemberThumbList.a(this.this$0).length))
      {
        localObject = (kth)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((!bool) || (i != MutiMemberThumbList.a(this.this$0).length - 1)) {}
      }
      else
      {
        if (!MutiMemberThumbList.b(this.this$0)) {
          break label179;
        }
        QLog.d("MutiMemberThumbList", 1, "doDisplay quit by destroyed in UI_Thread");
        return;
        bool = false;
        break;
      }
      Bitmap localBitmap = MutiMemberThumbList.a(this.this$0).a(String.valueOf(((kth)localObject).a), String.valueOf(MutiMemberThumbList.a(this.this$0)), MutiMemberThumbList.a(this.this$0), true, true);
      Object localObject = localBitmap;
      if (MutiMemberThumbList.a(this.this$0)) {
        localObject = mjg.a(localBitmap, "#4C000000", true);
      }
      localArrayList.add(localObject);
      i += 1;
    }
    label179:
    ThreadManager.getUIHandler().post(new MutiMemberThumbList.1.1(this, bool, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MutiMemberThumbList.1
 * JD-Core Version:    0.7.0.1
 */