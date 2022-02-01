package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VidListPlayPageLoader
  extends IGroupPageLoader.BaseGroupPageLoader
{
  private VidListPlayInfo a;
  private IDataProvider.GroupId b;
  
  public VidListPlayPageLoader(VidListPlayInfo paramVidListPlayInfo)
  {
    this.a = paramVidListPlayInfo;
    this.b = new IDataProvider.GroupId("vidList");
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    ArrayList localArrayList = new ArrayList();
    IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(this.b);
    localArrayList.add(localGroupInfo);
    localGroupInfo.c = this.a.mVidList;
    int i = this.a.mVideoFeedIdList.size();
    paramInt = 0;
    while (paramInt < this.a.mVidList.size())
    {
      if (paramInt < i) {
        localObject = this.a.mVideoFeedIdList.get(paramInt);
      } else {
        localObject = this.a.mVideoFeedIdList.get(i - 1);
      }
      Object localObject = (String)localObject;
      localGroupInfo.d.put(this.a.mVidList.get(paramInt), localObject);
      paramInt += 1;
    }
    paramCallBack.b(new ErrorMessage(), localArrayList, true);
  }
  
  public void b() {}
  
  public IDataProvider.StartInfo c()
  {
    return new IDataProvider.StartInfo(this.b, this.a.mStartVid, this.a.mStartVideoFeedId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.VidListPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */