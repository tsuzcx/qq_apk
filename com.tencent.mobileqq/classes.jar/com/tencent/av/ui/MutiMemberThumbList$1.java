package com.tencent.av.ui;

import android.graphics.Bitmap;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MutiMemberThumbList$1
  implements Runnable
{
  MutiMemberThumbList$1(MutiMemberThumbList paramMutiMemberThumbList, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.a;
    int k = MutiMemberThumbList.a(this.this$0).length;
    int i = 0;
    boolean bool;
    if (j > k) {
      bool = true;
    } else {
      bool = false;
    }
    while ((i < this.b.size()) && (i < MutiMemberThumbList.a(this.this$0).length))
    {
      Object localObject = (VideoController.GAudioFriends)this.b.get(i);
      if ((bool) && (i == MutiMemberThumbList.a(this.this$0).length - 1)) {
        break;
      }
      Bitmap localBitmap = MutiMemberThumbList.d(this.this$0).a(String.valueOf(((VideoController.GAudioFriends)localObject).a), String.valueOf(MutiMemberThumbList.b(this.this$0)), MutiMemberThumbList.c(this.this$0), true, true);
      localObject = localBitmap;
      if (MutiMemberThumbList.e(this.this$0)) {
        localObject = UITools.a(localBitmap, "#4C000000", true);
      }
      localArrayList.add(localObject);
      i += 1;
    }
    if (MutiMemberThumbList.f(this.this$0))
    {
      QLog.d("MutiMemberThumbList", 1, "doDisplay quit by destroyed in UI_Thread");
      return;
    }
    ThreadManager.getUIHandler().post(new MutiMemberThumbList.1.1(this, bool, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MutiMemberThumbList.1
 * JD-Core Version:    0.7.0.1
 */