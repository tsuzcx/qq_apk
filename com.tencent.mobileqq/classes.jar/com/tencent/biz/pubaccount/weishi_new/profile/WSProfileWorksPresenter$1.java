package com.tencent.biz.pubaccount.weishi_new.profile;

import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.List;

class WSProfileWorksPresenter$1
  implements IFetchDataRspListener<WSVerticalItemData>
{
  WSProfileWorksPresenter$1(WSProfileWorksPresenter paramWSProfileWorksPresenter) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.getView() == null) {
      return;
    }
    ((WSProfileWorksContract.View)this.a.getView()).u();
    ((WSProfileWorksContract.View)this.a.getView()).a(paramInt, paramString, paramBoolean1);
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    if (this.a.getView() == null) {
      return;
    }
    if ((paramObject instanceof Boolean)) {
      WSProfileWorksPresenter.a(this.a, ((Boolean)paramObject).booleanValue());
    }
    ((WSProfileWorksContract.View)this.a.getView()).u();
    ((WSProfileWorksContract.View)this.a.getView()).a(paramList, paramBoolean2, paramBoolean1, WSProfileWorksPresenter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileWorksPresenter.1
 * JD-Core Version:    0.7.0.1
 */