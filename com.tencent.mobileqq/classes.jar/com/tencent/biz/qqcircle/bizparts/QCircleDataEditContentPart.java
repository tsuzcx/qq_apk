package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.person.QCircleTroopAddPopupWindow;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleCheckBindGroupRequest;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.viewmodels.QCircleDataEditViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleTagListView;
import com.tencent.biz.qqcircle.widgets.QCircleTroopTagListView;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qzone.LbsDataV2.GpsInfo;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StTagMedalInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;
import qqcircle.QQCircleProfile.StProfileBizData;

public class QCircleDataEditContentPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private ImageView a;
  private TextView c;
  private CommentEditText d;
  private RelativeLayout e;
  private RelativeLayout f;
  private ImageView g;
  private QCircleTagListView h;
  private QCircleTroopTagListView i;
  private FeedCloudMeta.StUser j;
  private QQCircleFeedBase.StMainPageBusiRspData k;
  private List<Long> l;
  private QCircleDataEditViewModel m;
  private QCircleTroopAddPopupWindow n;
  
  private void a(List<Long> paramList)
  {
    VSNetworkHelper.getInstance().sendRequest(g(), new QCircleCheckBindGroupRequest(paramList), new QCircleDataEditContentPart.6(this, paramList));
  }
  
  private void i()
  {
    this.a.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    l();
    n();
  }
  
  private void l()
  {
    this.d.addTextChangedListener(new QCircleDataEditContentPart.1(this));
  }
  
  private void m()
  {
    this.m = ((QCircleDataEditViewModel)a(QCircleDataEditViewModel.class));
    this.m.a.observe(j(), new QCircleDataEditContentPart.2(this));
  }
  
  private void n()
  {
    this.i.a(new QCircleDataEditContentPart.3(this));
  }
  
  private void o()
  {
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_bundle_common_init_bean")))
    {
      QCircleInitBean localQCircleInitBean = (QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localQCircleInitBean != null)
      {
        this.j = localQCircleInitBean.getUser();
        this.k = new QQCircleFeedBase.StMainPageBusiRspData();
        QQCircleProfile.StProfileBizData localStProfileBizData = new QQCircleProfile.StProfileBizData();
        this.l = new ArrayList();
        try
        {
          this.k.mergeFrom(localQCircleInitBean.getBusiInfoData());
          localStProfileBizData.mergeFrom(this.k.profileBusiData.get().toByteArray());
          if (localStProfileBizData.bindGroupStatus.get() == 1)
          {
            this.l.addAll(localStProfileBizData.groupIDList.get());
            this.f.setVisibility(0);
          }
          else
          {
            this.f.setVisibility(8);
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
    if (this.j != null) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.j.id.get()).setActionType(11).setSubActionType(25).setThrActionType(1).setPageId(f()));
    }
  }
  
  private List<FeedCloudMeta.StTagInfo> p()
  {
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_bundle_common_init_bean")))
    {
      QCircleInitBean localQCircleInitBean = (QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localQCircleInitBean != null)
      {
        QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
        try
        {
          localStMainPageBusiRspData.mergeFrom(localQCircleInitBean.getBusiInfoData());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        return localStMainPageBusiRspData.recomTagList.get();
      }
    }
    return new ArrayList();
  }
  
  private void q()
  {
    FeedCloudMeta.StUser localStUser = this.j;
    if (localStUser != null) {
      this.d.setText(localStUser.desc.get());
    }
  }
  
  private void r()
  {
    if (this.k != null)
    {
      this.h.a(this.j);
      this.h.a(this.k);
    }
  }
  
  private void s()
  {
    List localList = this.l;
    if (localList != null) {
      this.i.a(localList);
    }
  }
  
  private boolean t()
  {
    if (!u())
    {
      c().finish();
      return false;
    }
    QCircleDataEditContentPart.4 local4 = new QCircleDataEditContentPart.4(this);
    QCircleCustomDialog.a(c(), null, HardCodeUtil.a(2131895826), 2131887648, 2131892267, local4, local4).show();
    return true;
  }
  
  private boolean u()
  {
    Object localObject = this.j;
    if ((localObject != null) && (this.k != null))
    {
      if (!TextUtils.equals(((FeedCloudMeta.StUser)localObject).desc.get(), this.d.getText().toString())) {
        return true;
      }
      localObject = p();
      if (((List)localObject).size() != this.k.recomTagList.get().size()) {
        return true;
      }
      int i1 = 0;
      while (i1 < ((List)localObject).size())
      {
        if (!TextUtils.equals(((FeedCloudMeta.StTagInfo)((List)localObject).get(i1)).tagName.get(), ((FeedCloudMeta.StTagInfo)this.k.recomTagList.get(i1)).tagName.get())) {
          return true;
        }
        i1 += 1;
      }
      return false;
    }
    QLog.e("QCircleDataEditContentP", 1, "checkIsModify  mUser == null || mMainPageBusiRspData == null");
    return false;
  }
  
  private void v()
  {
    if (this.m != null)
    {
      if (this.d == null) {
        return;
      }
      Object localObject1 = null;
      Object localObject2 = this.k;
      if (localObject2 != null) {
        localObject1 = ((QQCircleFeedBase.StMainPageBusiRspData)localObject2).recomTagList.get();
      }
      if (!HostNetworkUtils.isNetworkAvailable())
      {
        QLog.e("QCircleDataEditContentP", 1, "finishOperation() isNotNetworkAvailable");
        QCircleToastUtil.a(-1L, QCircleToast.c, HardCodeUtil.a(2131895805), 1);
        return;
      }
      this.m.a(this.d.getText().toString(), (List)localObject1, this.l);
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        int i1 = 0;
        while (i1 < ((List)localObject1).size())
        {
          localObject3 = (FeedCloudMeta.StTagInfo)((List)localObject1).get(i1);
          if (i1 != 0) {
            ((StringBuilder)localObject2).append("|");
          }
          ((StringBuilder)localObject2).append(((FeedCloudMeta.StTagInfo)localObject3).tagName.get());
          i1 += 1;
        }
      }
      Object localObject3 = new QCircleLpReportDc05504.DataBuilder().setToUin(this.j.id.get()).setActionType(11).setSubActionType(25).setThrActionType(3);
      if (u()) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject3).setExt1((String)localObject1).setExt6(((StringBuilder)localObject2).toString()).setPageId(f()));
    }
  }
  
  private void w()
  {
    Bundle localBundle = new Bundle();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = this.k;
    if (localObject2 != null)
    {
      localObject2 = ((QQCircleFeedBase.StMainPageBusiRspData)localObject2).recomTagList.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        FeedCloudMeta.StTagInfo localStTagInfo = (FeedCloudMeta.StTagInfo)((Iterator)localObject2).next();
        ((ArrayList)localObject1).add(localStTagInfo.tagId.get());
        localArrayList1.add(localStTagInfo.tagName.get());
        localArrayList2.add(String.valueOf(localStTagInfo.medal.rank.get()));
      }
    }
    localBundle.putStringArrayList("key_selected_label_id", (ArrayList)localObject1);
    localBundle.putStringArrayList("key_selected_label_name", localArrayList1);
    localBundle.putStringArrayList("key_selected_label_rank", localArrayList2);
    localObject1 = QCircleGpsHelper.a().e();
    if (localObject1 != null) {
      localObject1 = new LbsDataV2.GpsInfo((int)((FeedCloudMeta.StGPSV2)localObject1).lat.get(), (int)((FeedCloudMeta.StGPSV2)localObject1).lon.get(), (int)((FeedCloudMeta.StGPSV2)localObject1).alt.get(), (int)((FeedCloudMeta.StGPSV2)localObject1).eType.get(), 0);
    } else {
      localObject1 = new LbsDataV2.GpsInfo();
    }
    localBundle.putParcelable("key_gps_info", (Parcelable)localObject1);
    localObject1 = new Intent();
    ((Intent)localObject1).putExtras(localBundle);
    QCircleLauncher.a(c(), QCircleConfigHelper.r(), (Intent)localObject1, 2333);
  }
  
  private void x()
  {
    this.n = new QCircleTroopAddPopupWindow(c());
    this.n.b(c().getString(2131895763));
    this.n.a(new QCircleDataEditContentPart.5(this));
    this.n.show();
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.j.id.get()).setActionType(11).setSubActionType(25).setThrActionType(4));
  }
  
  public String a()
  {
    return "QCircleDataEditContentP";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2333) && (paramInt2 == -1))
    {
      ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("key_selected_label_id");
      ArrayList localArrayList2 = paramIntent.getStringArrayListExtra("key_selected_label_name");
      paramIntent = paramIntent.getStringArrayListExtra("key_selected_label_rank");
      if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList1.size() == localArrayList2.size()) && (localArrayList1.size() == paramIntent.size()))
      {
        ArrayList localArrayList3 = new ArrayList();
        paramInt1 = 0;
        while (paramInt1 < localArrayList1.size())
        {
          FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
          localStTagInfo.tagId.set((String)localArrayList1.get(paramInt1));
          localStTagInfo.tagName.set((String)localArrayList2.get(paramInt1));
          localStTagInfo.medal.setHasFlag(true);
          if (!TextUtils.isEmpty((CharSequence)paramIntent.get(paramInt1))) {
            localStTagInfo.medal.rank.set(Integer.parseInt((String)paramIntent.get(paramInt1)));
          }
          localStTagInfo.medal.tagName.set((String)localArrayList2.get(paramInt1));
          localArrayList3.add(localStTagInfo);
          paramInt1 += 1;
        }
        if (this.k == null) {
          this.k = new QQCircleFeedBase.StMainPageBusiRspData();
        }
        this.k.recomTagList.get().clear();
        this.k.recomTagList.get().addAll(localArrayList3);
        r();
      }
    }
  }
  
  public void a(View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131436275));
    this.c = ((TextView)paramView.findViewById(2131448459));
    this.d = ((CommentEditText)paramView.findViewById(2131432618));
    this.e = ((RelativeLayout)paramView.findViewById(2131445035));
    this.f = ((RelativeLayout)paramView.findViewById(2131445065));
    this.g = ((ImageView)paramView.findViewById(2131436630));
    this.g = ((ImageView)paramView.findViewById(2131436630));
    this.h = new QCircleTagListView();
    this.h.a(paramView);
    this.h.a(d());
    this.i = new QCircleTroopTagListView();
    this.i.a(paramView, 1);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.a);
    }
    i();
    m();
    o();
    q();
    r();
    s();
  }
  
  public boolean ah_()
  {
    if (t()) {
      return true;
    }
    return super.ah_();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131436275) {
      t();
    } else if (i1 == 2131448459) {
      v();
    } else if (i1 == 2131445035) {
      w();
    } else if (i1 == 2131436630) {
      x();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDataEditContentPart
 * JD-Core Version:    0.7.0.1
 */