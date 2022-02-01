package com.tencent.biz.pubaccount.weishi_new.main;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import java.util.List;

public class WSMainHomePresenter
  extends WSAbsMainPresenter
{
  public WSMainHomePresenter(WSMainContract.View paramView)
  {
    super(paramView);
    getView().f(false);
  }
  
  protected List<QBaseFragment> createFragments()
  {
    ArrayList localArrayList = new ArrayList();
    WSMainContract.View localView = getView();
    if (localView != null)
    {
      localArrayList.add(WSHomeFragment.a(localView.o(), this));
      if (WSExpABTestManager.a().f()) {
        localArrayList.add(WSRightContainerFragment.b());
      }
    }
    return localArrayList;
  }
  
  public void handleIntent(Bundle paramBundle) {}
  
  public void onRightLeftPageSelected(int paramInt)
  {
    WSMainContract.View localView = getView();
    if (localView != null)
    {
      Object localObject = localView.u();
      if (localObject == null) {
        return;
      }
      WSRightContainerFragment localWSRightContainerFragment = (WSRightContainerFragment)((WSFragmentAdapter)localObject).a(1);
      localObject = ((WSHomeFragment)((WSFragmentAdapter)localObject).a(0)).q();
      if (localObject != null)
      {
        if (((List)localObject).size() <= 0) {
          return;
        }
        localObject = (WSVerticalPageFragment)((List)localObject).get(1);
        if (paramInt == 0)
        {
          ((WSVerticalPageFragment)localObject).A();
          localWSRightContainerFragment.a();
        }
        else
        {
          ((WSVerticalPageFragment)localObject).B();
          localWSRightContainerFragment.a(localView.q());
          if (!localView.q()) {
            reportAvatarClick((WSVerticalPageFragment)localObject, ((WSVerticalPageFragment)localObject).F());
          }
        }
        localView.e(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainHomePresenter
 * JD-Core Version:    0.7.0.1
 */