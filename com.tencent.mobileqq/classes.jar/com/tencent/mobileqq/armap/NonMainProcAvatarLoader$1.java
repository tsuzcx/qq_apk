package com.tencent.mobileqq.armap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;

class NonMainProcAvatarLoader$1
  extends BroadcastReceiver
{
  NonMainProcAvatarLoader$1(NonMainProcAvatarLoader paramNonMainProcAvatarLoader) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
    {
      if (paramIntent.getIntExtra("faceType", -1) != this.a.jdField_a_of_type_Int) {
        return;
      }
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      paramIntent = paramIntent.getStringArrayListExtra("headPathList");
      if ((paramContext != null) && (paramIntent != null))
      {
        int j = paramContext.size();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onReceive, uinListSize:");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(" reqSize:");
          ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaUtilHashSet.size());
          QLog.d("NonMainAppHeadLoader", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = new ArrayList(this.a.jdField_a_of_type_JavaUtilHashSet.size());
        int i = 0;
        while (i < j)
        {
          String str = (String)paramContext.get(i);
          if (this.a.jdField_a_of_type_JavaUtilHashSet.contains(str))
          {
            this.a.jdField_a_of_type_JavaUtilHashSet.remove(str);
            ((ArrayList)localObject).add(str);
          }
          this.a.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(str, paramIntent.get(i));
          i += 1;
        }
        paramContext = Message.obtain();
        paramContext.obj = localObject;
        paramContext.what = 1001;
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.NonMainProcAvatarLoader.1
 * JD-Core Version:    0.7.0.1
 */