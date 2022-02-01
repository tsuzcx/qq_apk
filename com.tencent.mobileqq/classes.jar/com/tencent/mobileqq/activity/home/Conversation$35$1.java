package com.tencent.mobileqq.activity.home;

import ajcb;
import android.os.SystemClock;
import aozm;
import bfzg;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import vzt;

public class Conversation$35$1
  implements Runnable
{
  public Conversation$35$1(ajcb paramajcb, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ajcb.a.d(true);
    if (this.jdField_a_of_type_Ajcb.a.g)
    {
      Conversation.a(this.jdField_a_of_type_Ajcb.a, 800L);
      Object localObject;
      label108:
      aozm localaozm;
      if (this.jdField_a_of_type_Ajcb.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Ajcb.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Ajcb.a.jdField_a_of_type_Vzt != null)
        {
          localObject = this.jdField_a_of_type_Ajcb.a.jdField_a_of_type_Vzt;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((vzt)localObject).a(i);
        }
        if (this.jdField_a_of_type_Ajcb.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Ajcb.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localaozm = (aozm)((Iterator)localObject).next();
        } while (localaozm == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localaozm.c(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.jdField_a_of_type_Ajcb.a.c > 0L) {
      bfzg.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Ajcb.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.35.1
 * JD-Core Version:    0.7.0.1
 */