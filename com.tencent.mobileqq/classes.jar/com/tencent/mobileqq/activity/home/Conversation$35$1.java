package com.tencent.mobileqq.activity.home;

import ajxq;
import android.os.SystemClock;
import aqcq;
import bhhy;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import woo;

public class Conversation$35$1
  implements Runnable
{
  public Conversation$35$1(ajxq paramajxq, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ajxq.a.d(true);
    if (this.jdField_a_of_type_Ajxq.a.g)
    {
      Conversation.a(this.jdField_a_of_type_Ajxq.a, 800L);
      Object localObject;
      label108:
      aqcq localaqcq;
      if (this.jdField_a_of_type_Ajxq.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Ajxq.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Ajxq.a.jdField_a_of_type_Woo != null)
        {
          localObject = this.jdField_a_of_type_Ajxq.a.jdField_a_of_type_Woo;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((woo)localObject).a(i);
        }
        if (this.jdField_a_of_type_Ajxq.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Ajxq.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localaqcq = (aqcq)((Iterator)localObject).next();
        } while (localaqcq == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localaqcq.c(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.jdField_a_of_type_Ajxq.a.c > 0L) {
      bhhy.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Ajxq.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.35.1
 * JD-Core Version:    0.7.0.1
 */