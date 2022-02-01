package com.tencent.biz.videostory.widget.view;

import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.pubaccount.weishi_new.api.IWSMinePanel;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetMineWSPersonalRequest;
import com.tencent.biz.videostory.adapter.MineWSAdapter;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MineWSPanel
  implements IEventReceiver
{
  private QBaseActivity a;
  private ProfileWeishiComponent b;
  private LinearLayout c;
  private View d;
  private TextView e;
  private TextView f;
  private RecyclerView g;
  private MineWSAdapter h;
  private ImageView i;
  private View j;
  private boolean k;
  private String l;
  private String m;
  private GetMineWSPersonalRequest n;
  private MineWSPanel.ProcessClickListener o;
  
  public MineWSPanel(ProfileWeishiComponent paramProfileWeishiComponent)
  {
    this.b = paramProfileWeishiComponent;
    this.a = paramProfileWeishiComponent.getActivity();
    this.h = new MineWSAdapter(this.a);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isProfileCardActivity(this.a);
    if ((this.b != null) && (bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWeiShiPanelState isShow:");
      localStringBuilder.append(paramBoolean);
      QLog.i("MineWSPanel", 2, localStringBuilder.toString());
      this.b.initOrRefreshWeiShiPanel(paramBoolean);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.i("MineWSPanel", 2, "response is null");
      return;
    }
    ThreadManager.excute(new MineWSPanel.3(this, paramArrayOfByte), 32, null, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    int i1;
    if (this.k) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    VSReporter.a("weishi_share_prof", "entry_clk", i1, 0, new String[0]);
    boolean bool = WeishiGuideUtils.a(this.a);
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportWeiShiProfileClick(this.k, this.l, bool, paramBoolean);
    if (!bool)
    {
      VSReporter.a("weishi_share_prof", "dl_clk", 0, 0, new String[0]);
      QQToast.makeText(this.a, HardCodeUtil.a(2131904650), 0).show();
      ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).downloadWeishiWithDialog(this.a, this.k);
    }
    else if ((this.k) && (paramBoolean))
    {
      g();
      VSReporter.a("weishi_share_prof", "clk_ws", 1, 0, new String[0]);
    }
    else
    {
      f();
      VSReporter.a("weishi_share_prof", "clk_ws", 2, 0, new String[0]);
    }
    MineWSPanel.ProcessClickListener localProcessClickListener = this.o;
    if (localProcessClickListener != null) {
      localProcessClickListener.processClickEvent();
    }
  }
  
  private void f()
  {
    boolean bool = TextUtils.isEmpty(this.m);
    Object localObject = "weishi://profile?person_id=";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("weishi://profile?person_id=");
      ((StringBuilder)localObject).append(this.m);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder;
    if (this.k)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&logsour=2020020031");
      localObject = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&logsour=2020020029");
      localObject = localStringBuilder.toString();
    }
    ((IWSManager)QRoute.api(IWSManager.class)).openWeishi(this.a, "biz_src_jc_gxl", (String)localObject);
  }
  
  private void g()
  {
    ((IWSManager)QRoute.api(IWSManager.class)).openWeishi(this.a, "biz_src_jc_gxl", "weishi://camera?logsour=2020020030");
  }
  
  public ImageView a()
  {
    return this.i;
  }
  
  public void a(WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp, boolean paramBoolean)
  {
    if (paramstGetPersonalPageRsp == null)
    {
      QLog.i("MineWSPanel", 2, "rsp is null");
      return;
    }
    int i2 = paramstGetPersonalPageRsp.feed_num.get();
    this.m = paramstGetPersonalPageRsp.personid.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MineWSPanel.java][setData] feedNum:");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(", isFromDb:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("MineWSPanel", 2, ((StringBuilder)localObject).toString());
    if (i2 > 0)
    {
      if (!paramBoolean)
      {
        int i1;
        if (this.k) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        VSReporter.a("weishi_share_prof", "entry_exp", i1, 0, new String[0]);
      }
      a(true);
      localObject = this.f;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i2);
        localStringBuilder.append(HardCodeUtil.a(2131904651));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    else
    {
      a(false);
      localObject = this.f;
      if (localObject != null) {
        ((TextView)localObject).setText("");
      }
    }
    if (this.g != null)
    {
      paramstGetPersonalPageRsp = paramstGetPersonalPageRsp.feeds.get();
      if ((paramstGetPersonalPageRsp != null) && (paramstGetPersonalPageRsp.size() != 0))
      {
        this.g.setVisibility(0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setData(),mIsCurrentUser=");
        ((StringBuilder)localObject).append(this.k);
        QLog.i("MineWSPanel", 2, ((StringBuilder)localObject).toString());
        this.h.a(paramstGetPersonalPageRsp, this.k);
        return;
      }
      this.g.setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    this.j = paramView;
    this.c = ((LinearLayout)paramView.findViewById(2131438382));
    this.d = paramView.findViewById(2131435219);
    this.e = ((TextView)paramView.findViewById(2131438383));
    this.f = ((TextView)paramView.findViewById(2131438384));
    this.g = ((RecyclerView)paramView.findViewById(2131450276));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.a);
    localLinearLayoutManager.setOrientation(0);
    this.g.setLayoutManager(localLinearLayoutManager);
    localLinearLayoutManager.setRecycleChildrenOnDetach(true);
    this.g.setHasFixedSize(true);
    this.g.setAdapter(this.h);
    this.i = ((ImageView)paramView.findViewById(2131438853));
    this.c.setOnClickListener(new MineWSPanel.1(this));
    this.h.a(new MineWSPanel.2(this));
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileCardExposure(this.k, this.l);
    paramView = new StringBuilder();
    paramView.append("[MineWSPanel.java][initUI] mIsCurrentUser:");
    paramView.append(this.k);
    paramView.append(", mUin:");
    paramView.append(this.l);
    QLog.i("MineWSPanel", 2, paramView.toString());
  }
  
  public void a(MineWSPanel.ProcessClickListener paramProcessClickListener)
  {
    this.o = paramProcessClickListener;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.k = paramBoolean;
    this.l = paramString;
  }
  
  public TextView b()
  {
    return this.e;
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestWeiShiFeedListDataFromServer mUin=");
    localStringBuilder.append(this.l);
    QLog.i("MineWSPanel", 2, localStringBuilder.toString());
    if (!NetworkUtil.a(this.a.getAppRuntime().getApplication().getApplicationContext())) {
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.l);
    localStringBuilder.append("");
    this.n = new GetMineWSPersonalRequest(localStringBuilder.toString(), 1);
    VSNetworkHelper.getInstance().sendRequest(this.a, this.n, new MineWSPanel.PersonalResponseListener(this));
  }
  
  public void d()
  {
    if (this.d == null)
    {
      QLog.i("MineWSPanel", 2, "mMineWeiShiIcon is null");
      return;
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.d.setBackgroundResource(2130852419);
      return;
    }
    this.d.setBackgroundResource(2130847437);
  }
  
  public void e()
  {
    ThreadManager.excute(new MineWSPanel.4(this), 32, null, true);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel
 * JD-Core Version:    0.7.0.1
 */