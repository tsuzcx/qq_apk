package com.tencent.biz.qqcircle.bizparts;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleTagPageHeaderBlock;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.manager.QCircleTagFollowManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCircleTagPageViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.BlockMerger.ShareData;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class QCircleTagPageBodyPart
  extends QCircleBaseBlockPart
{
  private QCircleTagPageViewModel b;
  private QCircleTagPageHeaderBlock e;
  private QCircleInsFeedAdapter f;
  private QCircleInitBean g;
  private int h = 0;
  private int i;
  private QCircleStatusView j;
  private View k;
  
  public QCircleTagPageBodyPart(List<MultiViewBlock> paramList, int paramInt1, int paramInt2)
  {
    super(2131431490, paramList, paramInt1, paramInt2);
    this.e = ((QCircleTagPageHeaderBlock)paramList.get(0));
    this.f = ((QCircleInsFeedAdapter)paramList.get(1));
    this.f.a(true);
    this.f.b(true);
  }
  
  private void a(int paramInt)
  {
    this.h += paramInt;
    int m = (int)(this.h * 1.0F / this.i * 255.0F);
    if (m > 255)
    {
      paramInt = 255;
    }
    else
    {
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
    }
    Message localMessage = new Message();
    localMessage.what = paramInt;
    c("tag_page_action_title_bar_animation", localMessage);
  }
  
  private void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.f.setInteractor(m());
    this.f.setOnLoadDataDelegate(new QCircleTagPageBodyPart.1(this));
    this.f.a(paramQCircleExtraTypeInfo);
    this.f.a(0);
  }
  
  private void a(UIStateData<FeedCloudMeta.StTagInfo> paramUIStateData)
  {
    if (paramUIStateData != null)
    {
      int m = paramUIStateData.c();
      boolean bool = true;
      if (m != 0)
      {
        if (m != 1)
        {
          if ((m != 2) && (m != 3)) {
            return;
          }
          if (paramUIStateData.e() != null)
          {
            QCircleTagFollowManager localQCircleTagFollowManager = QCircleTagFollowManager.a();
            String str = ((FeedCloudMeta.StTagInfo)paramUIStateData.e()).tagId.get();
            if (((FeedCloudMeta.StTagInfo)paramUIStateData.e()).followState.get() != 1) {
              bool = false;
            }
            localQCircleTagFollowManager.a(str, bool);
          }
          a((FeedCloudMeta.StTagInfo)paramUIStateData.e());
          c("tab_rsp", paramUIStateData.e());
        }
      }
      else {
        QLog.e("QCircleTagPageBodyPart", 1, "handleTagHeaderRsp() return empty data");
      }
    }
  }
  
  private void a(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    if (this.f != null)
    {
      if (paramUIStateData.i())
      {
        this.f.addAll((List)paramUIStateData.e());
      }
      else
      {
        this.f.setDatas((ArrayList)paramUIStateData.e());
        this.f.e();
      }
      this.f.getLoadInfo().a(paramBoolean);
    }
  }
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (this.e != null)
    {
      paramStTagInfo = new BlockMerger.ShareData(paramStTagInfo);
      this.e.setShareData("share_key_tag_page_header_data", paramStTagInfo);
    }
  }
  
  private void b(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if (be_() != null)
    {
      if (be_().getRecyclerView() == null) {
        return;
      }
      be_().setExtraTypeInfo(paramQCircleExtraTypeInfo);
      be_().setEnableRefresh(true);
      be_().setEnableLoadMore(true);
      be_().getRecyclerView().addOnScrollListener(new QCircleTagPageBodyPart.4(this));
      this.j = ((QCircleStatusView)be_().getStatusInterface());
    }
  }
  
  private void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    boolean bool = paramUIStateData.h();
    int i1 = paramUIStateData.c();
    int n = 0;
    if (i1 != 0)
    {
      m = n;
      if (i1 == 1) {
        break label82;
      }
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 != 4)
        {
          m = n;
          break label82;
        }
        c(paramUIStateData);
      }
      else
      {
        a(paramUIStateData, bool);
      }
    }
    else
    {
      b(paramUIStateData, bool);
    }
    int m = 1;
    label82:
    if (m != 0)
    {
      paramUIStateData = this.f;
      if (paramUIStateData != null) {
        paramUIStateData.notifyLoadingComplete(true, bool);
      }
    }
  }
  
  private void b(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return empty data");
    if (paramUIStateData.i())
    {
      paramUIStateData = this.f;
      if ((paramUIStateData != null) && (paramUIStateData.getItemCount() > 0))
      {
        this.f.getLoadInfo().a(paramBoolean);
        return;
      }
    }
    paramUIStateData = this.j;
    if (paramUIStateData != null) {
      paramUIStateData.c(null);
    }
  }
  
  private void c(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    String str;
    if (paramUIStateData.f() == null) {
      str = HardCodeUtil.a(2131895632);
    } else {
      str = paramUIStateData.f();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleTagFeedsRsp() return error！errMsg:");
    ((StringBuilder)localObject).append(str);
    QLog.e("QCircleTagPageBodyPart", 1, ((StringBuilder)localObject).toString());
    localObject = this.f;
    if ((localObject != null) && (((QCircleInsFeedAdapter)localObject).getItemCount() > 0))
    {
      QCircleToastUtil.a(paramUIStateData.g(), QCircleToast.c, str, 1);
      return;
    }
    paramUIStateData = this.j;
    if (paramUIStateData != null) {
      paramUIStateData.c(str);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    if (PreLoader.exists("2005"))
    {
      QLog.i("QCircleTagPageBodyPart", 1, "runPreload");
      PreLoader.addListener("2005", new QCircleTagPageBodyPart.5(this));
      return;
    }
    this.b.a(o(), p(), false, paramBoolean);
  }
  
  private void l()
  {
    this.b = ((QCircleTagPageViewModel)a(QCircleTagPageViewModel.class));
    this.b.b.observe(bd_(), new QCircleTagPageBodyPart.2(this));
    this.b.a.observe(bd_(), new QCircleTagPageBodyPart.3(this));
  }
  
  private QCircleInteractor m()
  {
    return new QCircleTagPageBodyPart.6(this);
  }
  
  private void n()
  {
    this.h = 0;
    a(0);
  }
  
  private String o()
  {
    QCircleInitBean localQCircleInitBean = this.g;
    if ((localQCircleInitBean != null) && (localQCircleInitBean.getTagInfo() != null) && (!TextUtils.isEmpty(this.g.getTagInfo().tagId.get()))) {
      return this.g.getTagInfo().tagId.get();
    }
    return "";
  }
  
  private String p()
  {
    QCircleInitBean localQCircleInitBean = this.g;
    if ((localQCircleInitBean != null) && (localQCircleInitBean.getTagInfo() != null) && (!TextUtils.isEmpty(this.g.getTagInfo().tagName.get()))) {
      return this.g.getTagInfo().tagName.get();
    }
    return "";
  }
  
  public String a()
  {
    return "QCircleTagPageBodyPart";
  }
  
  public void a(View paramView)
  {
    this.k = paramView;
    this.i = ViewUtils.a(116.0F);
    l();
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.pageType = 7;
    a(localQCircleExtraTypeInfo);
    super.a(paramView);
    b(localQCircleExtraTypeInfo);
    paramView = this.g;
    if ((paramView != null) && (paramView.getTagInfo() != null)) {
      a(this.g.getTagInfo());
    }
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    this.g = paramQCircleInitBean;
  }
  
  public boolean ah_()
  {
    return super.ah_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagPageBodyPart
 * JD-Core Version:    0.7.0.1
 */