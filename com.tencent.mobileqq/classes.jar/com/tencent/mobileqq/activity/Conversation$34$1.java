package com.tencent.mobileqq.activity;

import aeig;
import android.os.SystemClock;
import aqgb;
import bhsq;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import wyd;

public class Conversation$34$1
  implements Runnable
{
  public Conversation$34$1(aeig paramaeig, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aeig.a.d(true);
    if (this.jdField_a_of_type_Aeig.a.g)
    {
      Conversation.a(this.jdField_a_of_type_Aeig.a, 800L);
      Object localObject;
      label108:
      aqgb localaqgb;
      if (this.jdField_a_of_type_Aeig.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Aeig.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Aeig.a.jdField_a_of_type_Wyd != null)
        {
          localObject = this.jdField_a_of_type_Aeig.a.jdField_a_of_type_Wyd;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((wyd)localObject).a(i);
        }
        if (this.jdField_a_of_type_Aeig.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Aeig.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localaqgb = (aqgb)((Iterator)localObject).next();
        } while (localaqgb == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localaqgb.c(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.jdField_a_of_type_Aeig.a.c > 0L) {
      bhsq.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Aeig.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.34.1
 * JD-Core Version:    0.7.0.1
 */