package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.ArrayList;
import odz;

public class GetMyStoryDesFromVidListStep
  implements Step
{
  protected BatchHandlerListPuller a;
  private MyStorys jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
  private GetMyStoryDesFromVidListStep.ReceiveDataListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryDesFromVidListStep$ReceiveDataListener;
  public GetMyStoryVideoListStep.Result a;
  protected Step.ErrorCallBack a;
  public Step.FinishCallBack a;
  
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result == null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
        return;
      }
      SLog.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result.a);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = BatchHandlerListPuller.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a(new odz(this, localArrayList));
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
    boolean bool2 = true;
    if ((paramObject instanceof GetMyStoryVideoListStep.Result))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result = ((GetMyStoryVideoListStep.Result)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result == null)
    {
      bool1 = true;
      SLog.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetMyStoryVideoListStep$Result != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AssertUtils.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryDesFromVidListStep
 * JD-Core Version:    0.7.0.1
 */