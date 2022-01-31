package com.tencent.mobileqq.activity;

import acng;
import android.os.SystemClock;
import annx;
import bdjd;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import uwn;

public class Conversation$31$1
  implements Runnable
{
  public Conversation$31$1(acng paramacng, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acng.a.d(true);
    if (this.jdField_a_of_type_Acng.a.g)
    {
      Conversation.a(this.jdField_a_of_type_Acng.a, 800L);
      Object localObject;
      label108:
      annx localannx;
      if (this.jdField_a_of_type_Acng.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Acng.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Acng.a.jdField_a_of_type_Uwn != null)
        {
          localObject = this.jdField_a_of_type_Acng.a.jdField_a_of_type_Uwn;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((uwn)localObject).a(i);
        }
        if (this.jdField_a_of_type_Acng.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Acng.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localannx = (annx)((Iterator)localObject).next();
        } while (localannx == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localannx.c(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.jdField_a_of_type_Acng.a.c > 0L) {
      bdjd.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Acng.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.31.1
 * JD-Core Version:    0.7.0.1
 */