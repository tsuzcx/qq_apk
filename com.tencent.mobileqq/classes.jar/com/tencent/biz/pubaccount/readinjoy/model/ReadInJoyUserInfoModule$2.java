package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qho;

class ReadInJoyUserInfoModule$2
  implements Runnable
{
  ReadInJoyUserInfoModule$2(ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, List paramList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(str))
      {
        QLog.e("ReadInJoyUserInfoModule", 1, "uin is null or empty");
      }
      else if (ReadInJoyUserInfoModule.a(this.this$0).get(str) != null)
      {
        QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams return ahead of time, do not load db or network request, because the userInfo is loading.");
      }
      else
      {
        if (ReadInJoyUserInfoModule.a(this.this$0) != null)
        {
          localObject = ReadInJoyUserInfoModule.a(this.this$0).a(str);
          if (localObject != null)
          {
            QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams, hit cache, do not request again.");
            ReadInJoyUserInfoModule.a(this.this$0).a(str, (ReadInJoyUserInfo)localObject);
            continue;
          }
        }
        ReadInJoyUserInfoModule.a(this.this$0).put(str, Boolean.valueOf(true));
        Object localObject = ReadInJoyUserInfoModule.a(this.this$0).a(str);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          localArrayList.add(str);
        }
      }
    }
    if (localArrayList.size() > 0) {
      this.this$0.a(localArrayList, this.jdField_a_of_type_Int, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.2
 * JD-Core Version:    0.7.0.1
 */