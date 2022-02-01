package com.tencent.av.wtogether.view;

import android.os.Handler;
import com.tencent.av.wtogether.observer.WatchTogetherObserver;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import java.util.ArrayList;
import java.util.List;

class GroupFileSearchDialog$7
  extends WatchTogetherObserver
{
  GroupFileSearchDialog$7(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.a;
    paramString.jdField_a_of_type_Int -= 1;
    if (this.a.c) {
      paramString = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    } else {
      paramString = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public void a(String arg1, String paramString2, int paramInt1, int paramInt2, List<TroopFileSearchItemData> paramList)
  {
    paramString2 = this.a;
    int i = paramString2.jdField_a_of_type_Int;
    boolean bool = true;
    paramString2.jdField_a_of_type_Int = (i - 1);
    paramString2 = this.a;
    paramString2.jdField_b_of_type_JavaLangString = ???;
    paramString2.jdField_b_of_type_Int = paramInt2;
    paramInt2 = 0;
    if (paramInt1 != 1) {
      bool = false;
    }
    paramString2.f = bool;
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      if (this.a.jdField_b_of_type_JavaUtilList != null) {
        this.a.jdField_b_of_type_JavaUtilList.clear();
      } else {
        this.a.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      paramInt1 = paramInt2;
      while (paramInt1 < paramList.size()) {
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          this.a.jdField_b_of_type_JavaUtilList.add(paramList.get(paramInt1));
          paramInt1 += 1;
        }
      }
      ??? = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(???);
      return;
    }
    for (;;)
    {
      throw paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.7
 * JD-Core Version:    0.7.0.1
 */