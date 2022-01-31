package com.tencent.mobileqq.activity;

import aawn;
import alwx;
import android.os.SystemClock;
import bbjv;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import thy;

public class Conversation$32$1
  implements Runnable
{
  public Conversation$32$1(aawn paramaawn, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aawn.a.e(true);
    if (this.jdField_a_of_type_Aawn.a.g)
    {
      Conversation.a(this.jdField_a_of_type_Aawn.a, 800L);
      Object localObject;
      label108:
      alwx localalwx;
      if (this.jdField_a_of_type_Aawn.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Aawn.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Aawn.a.jdField_a_of_type_Thy != null)
        {
          localObject = this.jdField_a_of_type_Aawn.a.jdField_a_of_type_Thy;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((thy)localObject).a(i);
        }
        if (this.jdField_a_of_type_Aawn.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Aawn.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localalwx = (alwx)((Iterator)localObject).next();
        } while (localalwx == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localalwx.a(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.jdField_a_of_type_Aawn.a.c > 0L) {
      bbjv.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Aawn.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.32.1
 * JD-Core Version:    0.7.0.1
 */