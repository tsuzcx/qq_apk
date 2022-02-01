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
  protected BatchHandlerListPuller a;
  private MyStorys jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
  private GetMyStoryDesFromVidListStep.ReceiveDataListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryDesFromVidListStep$ReceiveDataListener;
  protected GetMyStoryVideoListStep.Result a;
  protected Step.ErrorCallBack a;
  protected Step.FinishCallBack a;
  
  public GetMyStoryDesFromVidListStep(GetMyStoryDesFromVidListStep.ReceiveDataListener paramReceiveDataListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryDesFromVidListStep$ReceiveDataListener = paramReceiveDataListener;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = new MyStorys();
  }
  
  public Object a()
  {
    return null;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    SLog.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result;
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack;
      if (localObject != null)
      {
        ((Step.FinishCallBack)localObject).a(a());
        return;
      }
      SLog.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    localObject = new ArrayList(((GetMyStoryVideoListStep.Result)localObject).a);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = BatchHandlerListPuller.a((List)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a(new GetMyStoryDesFromVidListStep.1(this, (ArrayList)localObject));
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.b();
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack = paramFinishCallBack;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof GetMyStoryVideoListStep.Result))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result = ((GetMyStoryVideoListStep.Result)paramObject);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    GetMyStoryVideoListStep.Result localResult = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result;
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramObject.append(bool1);
    AssertUtils.fail(paramObject.toString(), new Object[0]);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryDesFromVidListStep
 * JD-Core Version:    0.7.0.1
 */