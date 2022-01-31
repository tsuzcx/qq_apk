package com.tencent.mobileqq.activity;

import aamx;
import alij;
import android.os.SystemClock;
import baio;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import svc;

public class Conversation$33$1
  implements Runnable
{
  public Conversation$33$1(aamx paramaamx, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aamx.a.e(true);
    if (this.jdField_a_of_type_Aamx.a.g)
    {
      Conversation.a(this.jdField_a_of_type_Aamx.a, 800L);
      Object localObject;
      label108:
      alij localalij;
      if (this.jdField_a_of_type_Aamx.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Aamx.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Aamx.a.jdField_a_of_type_Svc != null)
        {
          localObject = this.jdField_a_of_type_Aamx.a.jdField_a_of_type_Svc;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((svc)localObject).a(i);
        }
        if (this.jdField_a_of_type_Aamx.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Aamx.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localalij = (alij)((Iterator)localObject).next();
        } while (localalij == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localalij.a(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.jdField_a_of_type_Aamx.a.c > 0L) {
      baio.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Aamx.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.33.1
 * JD-Core Version:    0.7.0.1
 */