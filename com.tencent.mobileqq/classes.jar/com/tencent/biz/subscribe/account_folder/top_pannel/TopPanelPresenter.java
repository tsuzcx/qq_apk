package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.SubscribeGetRecommendUserListRequest;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class TopPanelPresenter
  implements TopPanelContract.Presenter
{
  private static String a = "TopPanelPresenter";
  private TopPanelContract.View b;
  private COMM.StCommonExt c;
  
  public TopPanelPresenter(TopPanelContract.View paramView)
  {
    this.b = paramView;
    this.b.setPresenter(this);
  }
  
  private List<RecommendInfoItem> a(CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramStGetRecommendUserListRsp.expType.get() == 0)
    {
      if (paramStGetRecommendUserListRsp.vecUser.has())
      {
        paramStGetRecommendUserListRsp = paramStGetRecommendUserListRsp.vecUser.get().iterator();
        while (paramStGetRecommendUserListRsp.hasNext()) {
          localArrayList.add(new RecommendInfoItem((CertifiedAccountMeta.StUser)paramStGetRecommendUserListRsp.next()));
        }
      }
    }
    else if ((paramStGetRecommendUserListRsp.expType.get() == 1) && (paramStGetRecommendUserListRsp.vecUserWithFeed.has()))
    {
      paramStGetRecommendUserListRsp = paramStGetRecommendUserListRsp.vecUserWithFeed.get().iterator();
      while (paramStGetRecommendUserListRsp.hasNext()) {
        localArrayList.add(new RecommendInfoItem((CertifiedAccountMeta.StFeed)paramStGetRecommendUserListRsp.next()));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = System.currentTimeMillis();
    localObject = new SubscribeGetRecommendUserListRequest((String)localObject, this.c, 100, 0);
    ((SubscribeGetRecommendUserListRequest)localObject).setEnableCache(false);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new TopPanelPresenter.1(this, l));
  }
  
  public void b()
  {
    TopPanelContract.View localView = this.b;
    if (localView != null)
    {
      localView.setPresenter(null);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelPresenter
 * JD-Core Version:    0.7.0.1
 */