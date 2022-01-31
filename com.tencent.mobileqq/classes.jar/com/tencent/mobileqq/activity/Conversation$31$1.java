package com.tencent.mobileqq.activity;

import acrv;
import android.os.SystemClock;
import ansg;
import bdnm;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import vaw;

public class Conversation$31$1
  implements Runnable
{
  public Conversation$31$1(acrv paramacrv, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acrv.a.d(true);
    if (this.jdField_a_of_type_Acrv.a.g)
    {
      Conversation.a(this.jdField_a_of_type_Acrv.a, 800L);
      Object localObject;
      label108:
      ansg localansg;
      if (this.jdField_a_of_type_Acrv.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Acrv.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Acrv.a.jdField_a_of_type_Vaw != null)
        {
          localObject = this.jdField_a_of_type_Acrv.a.jdField_a_of_type_Vaw;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((vaw)localObject).a(i);
        }
        if (this.jdField_a_of_type_Acrv.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Acrv.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localansg = (ansg)((Iterator)localObject).next();
        } while (localansg == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localansg.c(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.jdField_a_of_type_Acrv.a.c > 0L) {
      bdnm.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Acrv.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.31.1
 * JD-Core Version:    0.7.0.1
 */