package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.ArrayList;
import java.util.List;

public class GetMyStoryDesFromVidListStep
  implements Step
{
  protected Step.FinishCallBack a;
  protected Step.ErrorCallBack b;
  protected GetMyStoryVideoListStep.Result c;
  protected BatchHandlerListPuller d;
  private MyStorys e;
  private GetMyStoryDesFromVidListStep.ReceiveDataListener f;
  
  public GetMyStoryDesFromVidListStep(GetMyStoryDesFromVidListStep.ReceiveDataListener paramReceiveDataListener)
  {
    this.f = paramReceiveDataListener;
    this.e = new MyStorys();
  }
  
  public Object a()
  {
    return null;
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.b = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.a = paramFinishCallBack;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof GetMyStoryVideoListStep.Result))
    {
      this.c = ((GetMyStoryVideoListStep.Result)paramObject);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    GetMyStoryVideoListStep.Result localResult = this.c;
    boolean bool2 = true;
    boolean bool1;
    if (localResult == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramObject.append(bool1);
    SLog.e("GetMyStoryDesFromVidListStep", paramObject.toString());
    paramObject = new StringBuilder();
    paramObject.append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.c == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramObject.append(bool1);
    AssertUtils.fail(paramObject.toString(), new Object[0]);
  }
  
  public void b()
  {
    SLog.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    Object localObject = this.c;
    if (localObject == null)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((Step.FinishCallBack)localObject).a(c());
        return;
      }
      SLog.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    localObject = new ArrayList(((GetMyStoryVideoListStep.Result)localObject).d);
    this.d = BatchHandlerListPuller.a((List)localObject);
    this.d.a("GetMyStoryDesFromVidListStep");
    this.d.a(new GetMyStoryDesFromVidListStep.1(this, (ArrayList)localObject));
    this.d.b();
  }
  
  public String c()
  {
    return getClass().getSimpleName();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryDesFromVidListStep
 * JD-Core Version:    0.7.0.1
 */