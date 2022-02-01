package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class DataProviderTest2$1
  implements IDataProvider.ICallBack
{
  DataProviderTest2$1(DataProviderTest2 paramDataProviderTest2) {}
  
  public void a()
  {
    DataProviderTest2.a(this.a, this.a.a.a(DataProviderTest2.a(this.a), 5));
    List localList = DataProviderTest2.a(this.a).a;
    if ((DataProviderTest2.a(this.a) == null) && (localList.size() > 0)) {
      DataProviderTest2.a(this.a, ((IDataProvider.GroupInfo)localList.get(0)).a);
    }
    label193:
    for (;;)
    {
      DataProviderTest2.a(this.a).a(DataProviderTest2.a(this.a), "");
      SLog.d("Q.qqstory.player.data.SimpleDataProvider", "current group:%s", new Object[] { DataProviderTest2.a(this.a) });
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label193;
        }
        if (((IDataProvider.GroupInfo)localList.get(i)).a.equals(DataProviderTest2.a(this.a)))
        {
          i -= 1;
          if (i < 0) {
            break;
          }
          DataProviderTest2.a(this.a, ((IDataProvider.GroupInfo)localList.get(i)).a);
          break;
        }
        i += 1;
      }
    }
  }
  
  public void a(IDataProvider.GroupId paramGroupId, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.DataProviderTest2.1
 * JD-Core Version:    0.7.0.1
 */