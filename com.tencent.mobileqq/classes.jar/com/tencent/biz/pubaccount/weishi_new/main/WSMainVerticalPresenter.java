package com.tencent.biz.pubaccount.weishi_new.main;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSFragmentAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import java.util.List;

public class WSMainVerticalPresenter
  extends WSAbsMainPresenter
{
  private stSimpleMetaFeed mIntentFeed;
  private String mIntentFeedId;
  protected String mPersonId;
  
  public WSMainVerticalPresenter(WSMainContract.View paramView)
  {
    super(paramView);
  }
  
  protected List<QBaseFragment> createFragments()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getView();
    if (localObject != null)
    {
      localObject = WSVerticalPageFragment.a(((WSMainContract.View)localObject).o());
      ((WSVerticalPageFragment)localObject).a(this);
      localArrayList.add(localObject);
      localArrayList.add(WSRightContainerFragment.b());
    }
    return localArrayList;
  }
  
  @Nullable
  public stSimpleMetaFeed getIntentFeed()
  {
    return this.mIntentFeed;
  }
  
  @NonNull
  public String getIntentFeedId()
  {
    if (!TextUtils.isEmpty(this.mIntentFeedId)) {
      return this.mIntentFeedId;
    }
    stSimpleMetaFeed localstSimpleMetaFeed = this.mIntentFeed;
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.id != null)) {
      return this.mIntentFeed.id;
    }
    return "";
  }
  
  public void handleIntent(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.mPersonId = paramBundle.getString("person_id");
    this.mIntentFeedId = paramBundle.getString("key_feed_id");
    paramBundle = (List)paramBundle.getSerializable("key_feed_list");
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      this.mIntentFeed = ((stSimpleMetaFeed)paramBundle.get(0));
    }
  }
  
  public void onRightLeftPageSelected(int paramInt)
  {
    WSMainContract.View localView = getView();
    if (localView != null)
    {
      Object localObject = localView.u();
      if (localObject == null) {
        return;
      }
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localView.f(bool);
      WSRightContainerFragment localWSRightContainerFragment = (WSRightContainerFragment)((WSFragmentAdapter)localObject).a(1);
      if (paramInt == 0)
      {
        localWSRightContainerFragment.a();
      }
      else
      {
        localWSRightContainerFragment.a(localView.q());
        if (!localView.q())
        {
          localObject = (WSVerticalPageFragment)((WSFragmentAdapter)localObject).a(0);
          reportAvatarClick((WSVerticalPageFragment)localObject, ((WSVerticalPageFragment)localObject).F());
        }
      }
      localView.e(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainVerticalPresenter
 * JD-Core Version:    0.7.0.1
 */