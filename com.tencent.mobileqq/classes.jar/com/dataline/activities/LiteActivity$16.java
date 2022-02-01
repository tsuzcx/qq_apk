package com.dataline.activities;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.List;

class LiteActivity$16
  extends AsyncTask<Integer, Integer, String>
{
  LiteActivity$16(LiteActivity paramLiteActivity, ArrayList paramArrayList) {}
  
  DataLineMsgRecord a(DataLineHandler paramDataLineHandler, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == 0) {
      switch (FileManagerUtil.a(paramString))
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msgtype = DataLineHandler.a(i);
      localDataLineMsgRecord.sessionid = paramDataLineHandler.a(0, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a).longValue();
      localDataLineMsgRecord.path = paramString;
      localDataLineMsgRecord.thumbPath = null;
      localDataLineMsgRecord.groupId = paramInt2;
      localDataLineMsgRecord.groupSize = paramInt3;
      localDataLineMsgRecord.groupIndex = paramInt4;
      return localDataLineMsgRecord;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  protected String a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    a(this.jdField_a_of_type_JavaUtilArrayList, i);
    return null;
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(false);
  }
  
  void a(List<String> paramList, int paramInt)
  {
    if (paramList == null) {}
    DataLineHandler localDataLineHandler;
    int j;
    int i;
    Object localObject1;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      j = paramList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localObject1 = (String)paramList.get(i);
        localObject1 = a(localDataLineHandler, LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (String)localObject1), paramInt, 0, 0, 0);
        if (localObject1 != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject1, false);
        }
        i += 1;
      }
    }
    label129:
    Object localObject2;
    if ((j > 3) && (j < 50))
    {
      localObject1 = new ArrayList();
      int k = localDataLineHandler.a();
      i = 0;
      if (i < j)
      {
        localObject2 = (String)paramList.get(i);
        localObject2 = a(localDataLineHandler, LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (String)localObject2), paramInt, k, j, i);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        if (!DataLineMsgSet.isSingle(paramInt, k)) {
          break label442;
        }
        if (localObject2 != null)
        {
          ((DataLineMsgRecord)localObject2).groupId = 0;
          ((DataLineMsgRecord)localObject2).groupIndex = 0;
          ((DataLineMsgRecord)localObject2).groupSize = 0;
        }
        if (((ArrayList)localObject1).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject1, false);
        }
        localObject1 = new ArrayList();
      }
    }
    label282:
    label439:
    label442:
    for (;;)
    {
      i += 1;
      break label129;
      if (((ArrayList)localObject1).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject1, false);
      return;
      localObject1 = new ArrayList();
      j = localDataLineHandler.a();
      i = 0;
      if (i < 50)
      {
        localObject2 = (String)paramList.get(i);
        localObject2 = a(localDataLineHandler, LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (String)localObject2), paramInt, j, 50, i);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        if (!DataLineMsgSet.isSingle(paramInt, j)) {
          break label439;
        }
        if (localObject2 != null)
        {
          ((DataLineMsgRecord)localObject2).groupId = 0;
          ((DataLineMsgRecord)localObject2).groupIndex = 0;
          ((DataLineMsgRecord)localObject2).groupSize = 0;
        }
        if (((ArrayList)localObject1).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject1, false);
        }
        localObject1 = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label282;
        if (((ArrayList)localObject1).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject1, false);
        }
        i = 0;
        while (i < 50)
        {
          paramList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.16
 * JD-Core Version:    0.7.0.1
 */