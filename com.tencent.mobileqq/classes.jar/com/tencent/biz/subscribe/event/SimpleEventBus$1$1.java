package com.tencent.biz.subscribe.event;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import wpt;
import wpu;

public class SimpleEventBus$1$1
  implements Runnable
{
  public SimpleEventBus$1$1(wpu paramwpu, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    QLog.d("SimpleEventBus", 4, "onServerCall action" + this.jdField_a_of_type_JavaLangString);
    if (wpt.b.equals(this.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("feed_id", "");
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("feed_like_status", 0);
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("feed_like_num", 0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_Wpu.a.a(new PraisedUpdateEvents((String)localObject, i, j));
        }
      }
    }
    while (!wpt.c.equals(this.jdField_a_of_type_JavaLangString))
    {
      int i;
      int j;
      return;
    }
    Object localObject = new SubDraftChangeEvent();
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      ((SubDraftChangeEvent)localObject).setDraftID(this.jdField_a_of_type_AndroidOsBundle.getString("draftId", ""));
      ((SubDraftChangeEvent)localObject).setIsSave(this.jdField_a_of_type_AndroidOsBundle.getBoolean("save_draft", false));
    }
    this.jdField_a_of_type_Wpu.a.a((SimpleBaseEvent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.SimpleEventBus.1.1
 * JD-Core Version:    0.7.0.1
 */