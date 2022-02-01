package com.dataline.core;

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

class DirectForwarder$1
  extends AsyncTask<Integer, Integer, String>
{
  DirectForwarder$1(DirectForwarder paramDirectForwarder, ArrayList paramArrayList, int paramInt) {}
  
  DataLineMsgRecord a(DataLineHandler paramDataLineHandler, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == 0)
    {
      paramInt1 = FileManagerUtil.c(paramString);
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          i = 0;
        } else {
          i = 2;
        }
      }
      else {
        i = 3;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.b(i);
    localDataLineMsgRecord.sessionid = paramDataLineHandler.a(0, this.b).longValue();
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.thumbPath = null;
    localDataLineMsgRecord.groupId = paramInt2;
    localDataLineMsgRecord.groupSize = paramInt3;
    localDataLineMsgRecord.groupIndex = paramInt4;
    return localDataLineMsgRecord;
  }
  
  protected String a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    a(this.a, i);
    return null;
  }
  
  void a(List<String> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.c.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    for (;;)
    {
      int j = paramList.size();
      if (j <= 3)
      {
        i = 0;
        while (i < j)
        {
          localObject1 = a(localDataLineHandler, (String)paramList.get(i), paramInt, 0, 0, 0);
          if (localObject1 != null) {
            localDataLineHandler.a((DataLineMsgRecord)localObject1, false);
          }
          i += 1;
        }
      }
      DataLineMsgRecord localDataLineMsgRecord;
      Object localObject2;
      if ((j > 3) && (j < 50))
      {
        localObject1 = new ArrayList();
        int k = localDataLineHandler.g();
        i = 0;
        while (i < j)
        {
          localDataLineMsgRecord = a(localDataLineHandler, (String)paramList.get(i), paramInt, k, j, i);
          if (localDataLineMsgRecord != null) {
            ((ArrayList)localObject1).add(localDataLineMsgRecord);
          }
          localObject2 = localObject1;
          if (DataLineMsgSet.isSingle(paramInt, k))
          {
            if (localDataLineMsgRecord != null)
            {
              localDataLineMsgRecord.groupId = 0;
              localDataLineMsgRecord.groupIndex = 0;
              localDataLineMsgRecord.groupSize = 0;
            }
            if (((ArrayList)localObject1).size() > 0) {
              localDataLineHandler.a((ArrayList)localObject1, false);
            }
            localObject2 = new ArrayList();
          }
          i += 1;
          localObject1 = localObject2;
        }
        if (((ArrayList)localObject1).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject1, false);
        }
        return;
      }
      Object localObject1 = new ArrayList();
      j = localDataLineHandler.g();
      int i = 0;
      while (i < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (String)paramList.get(i), paramInt, j, 50, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject1).add(localDataLineMsgRecord);
        }
        localObject2 = localObject1;
        if (DataLineMsgSet.isSingle(paramInt, j))
        {
          if (localDataLineMsgRecord != null)
          {
            localDataLineMsgRecord.groupId = 0;
            localDataLineMsgRecord.groupIndex = 0;
            localDataLineMsgRecord.groupSize = 0;
          }
          if (((ArrayList)localObject1).size() > 0) {
            localDataLineHandler.a((ArrayList)localObject1, false);
          }
          localObject2 = new ArrayList();
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (((ArrayList)localObject1).size() > 0) {
        localDataLineHandler.a((ArrayList)localObject1, false);
      }
      i = 0;
      while (i < 50)
      {
        paramList.remove(0);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.core.DirectForwarder.1
 * JD-Core Version:    0.7.0.1
 */