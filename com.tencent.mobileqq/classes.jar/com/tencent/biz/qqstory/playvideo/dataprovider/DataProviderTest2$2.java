package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class DataProviderTest2$2
  implements IDataProvider.ICallBack
{
  DataProviderTest2$2(DataProviderTest2 paramDataProviderTest2) {}
  
  public void a()
  {
    Object localObject = this.a;
    DataProviderTest2.a((DataProviderTest2)localObject, ((DataProviderTest2)localObject).a.a(DataProviderTest2.a(this.a), 5));
    localObject = DataProviderTest2.b(this.a).c;
    if ((DataProviderTest2.a(this.a) == null) && (((List)localObject).size() > 0))
    {
      DataProviderTest2.a(this.a, ((IDataProvider.GroupInfo)((List)localObject).get(0)).b);
    }
    else
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        if (((IDataProvider.GroupInfo)((List)localObject).get(i)).b.equals(DataProviderTest2.a(this.a)))
        {
          int j = ((List)localObject).size();
          i += 1;
          if (j <= i) {
            break;
          }
          DataProviderTest2.a(this.a, ((IDataProvider.GroupInfo)((List)localObject).get(i)).b);
          break;
        }
        i += 1;
      }
    }
    SLog.d("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { DataProviderTest2.a(this.a) });
    DataProviderTest2.c(this.a).a(DataProviderTest2.a(this.a), "");
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.DataProviderTest2.2
 * JD-Core Version:    0.7.0.1
 */