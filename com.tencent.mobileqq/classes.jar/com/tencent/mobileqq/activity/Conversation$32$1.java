package com.tencent.mobileqq.activity;

import aawj;
import alww;
import android.os.SystemClock;
import bbkj;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import thv;

public class Conversation$32$1
  implements Runnable
{
  public Conversation$32$1(aawj paramaawj, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aawj.a.e(true);
    if (this.jdField_a_of_type_Aawj.a.g)
    {
      Conversation.a(this.jdField_a_of_type_Aawj.a, 800L);
      Object localObject;
      label108:
      alww localalww;
      if (this.jdField_a_of_type_Aawj.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Aawj.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Aawj.a.jdField_a_of_type_Thv != null)
        {
          localObject = this.jdField_a_of_type_Aawj.a.jdField_a_of_type_Thv;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((thv)localObject).a(i);
        }
        if (this.jdField_a_of_type_Aawj.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Aawj.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localalww = (alww)((Iterator)localObject).next();
        } while (localalww == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localalww.a(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.jdField_a_of_type_Aawj.a.c > 0L) {
      bbkj.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Aawj.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.32.1
 * JD-Core Version:    0.7.0.1
 */