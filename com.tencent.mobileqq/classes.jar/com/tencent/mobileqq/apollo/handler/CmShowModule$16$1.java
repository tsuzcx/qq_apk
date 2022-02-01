package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.task.OnAddOrDeleGameListener;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$16$1
  implements OnAddOrDeleGameListener
{
  CmShowModule$16$1(CmShowModule.16 param16) {}
  
  public void a(long paramLong, String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramLong == 0L) {}
    for (int i = 0;; i = 1)
    {
      localBundle.putInt("result", i);
      localBundle.putString("message", paramString);
      this.a.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.a.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.16.1
 * JD-Core Version:    0.7.0.1
 */