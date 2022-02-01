package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ApolloMainViewBinder
  extends ApolloViewBinder
  implements View.OnClickListener
{
  private OpenCallback a;
  private ImageView b;
  private Button c;
  private boolean d = false;
  private ImageView e;
  private TextView f;
  private TextView g;
  private int h = -1;
  
  public ApolloMainViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.l = 0;
    this.m = paramSessionInfo;
    this.q = 4;
  }
  
  public View a()
  {
    int i = this.k;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (this.r == null)
          {
            this.r = new ApolloPanelListView(this.i);
            this.r.setDivider(null);
            this.r.setVerticalScrollBarEnabled(true);
            this.r.setEdgeEffectEnabled(false);
            this.r.setSelector(2130853313);
          }
          return this.r;
        }
        return LayoutInflater.from(this.i).inflate(2131624173, null);
      }
      return LayoutInflater.from(this.i).inflate(2131624178, null);
    }
    if (this.r == null)
    {
      this.r = new ApolloPanelListView(this.i);
      this.r.setDivider(null);
      this.r.setVerticalScrollBarEnabled(true);
      this.r.setEdgeEffectEnabled(false);
      this.r.setSelector(2130853313);
    }
    return this.r;
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    int i = this.k;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (i == 0)
    {
      localArrayList1 = localArrayList2;
      if (this.o != null)
      {
        if (this.o.size() == 0) {
          return null;
        }
        i = c();
        localArrayList1 = localArrayList2;
        if (paramInt >= 0)
        {
          if (paramInt >= i) {
            return null;
          }
          localArrayList1 = localArrayList2;
          if (this.r != null)
          {
            paramInt = this.r.getFirstVisiblePosition() * this.q;
            i = this.r.getLastVisiblePosition();
            int j = this.q;
            localArrayList2 = new ArrayList();
            for (;;)
            {
              localArrayList1 = localArrayList2;
              if (paramInt >= this.o.size()) {
                break;
              }
              localArrayList1 = localArrayList2;
              if (paramInt > (i + 1) * j - 1) {
                break;
              }
              localArrayList2.add(this.o.get(paramInt));
              paramInt += 1;
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    URLImageView localURLImageView1 = (URLImageView)paramView.findViewById(2131428440);
    URLImageView localURLImageView2 = (URLImageView)paramView.findViewById(2131428469);
    this.c = ((Button)paramView.findViewById(2131428468));
    localURLImageView1.setVisibility(0);
    this.c.setVisibility(0);
    if (this.d) {
      this.c.setText(HardCodeUtil.a(2131898711));
    }
    Object localObject = new ColorDrawable();
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", (Drawable)localObject, (Drawable)localObject);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_buttom_man_v2.png", (Drawable)localObject, (Drawable)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView1.getLayoutParams();
    localLayoutParams.height = ((int)(XPanelContainer.a - paramView.getResources().getDisplayMetrics().density * 85.0F));
    localLayoutParams.width = (localLayoutParams.height * 602 / 366);
    localLayoutParams.bottomMargin = ((int)(paramView.getResources().getDisplayMetrics().density * 5.0F));
    localURLImageView1.setBackgroundDrawable(localURLDrawable);
    localURLImageView2.setBackgroundDrawable((Drawable)localObject);
    this.c.setOnClickListener(this);
    if ((this.j != null) && (this.m != null)) {
      VipUtils.a(this.j, "cmshow", "Apollo", "state_open_show", this.m.b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.m.a), 0, new String[0]);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.h != this.k)
    {
      this.h = this.k;
      paramInt = this.k;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 3) {
            return;
          }
          b(paramView);
          return;
        }
        a(paramView);
        return;
      }
      c(paramView);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.s != null) {
      this.s.a(paramBaseChatPie);
    }
  }
  
  public void b()
  {
    this.a = null;
    this.i = null;
    this.o = null;
    this.b = null;
    this.c = null;
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.g = ((TextView)paramView.findViewById(2131444197));
    Object localObject = this.g;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("panel is not jsonFail and panelView.class=");
        ((StringBuilder)localObject).append(paramView.getClass().getSimpleName());
        QLog.d("ApolloPanel", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ((TextView)localObject).setVisibility(0);
    this.g.setOnClickListener(this);
    this.b = ((ImageView)paramView.findViewById(2131436686));
    this.e = ((ImageView)paramView.findViewById(2131436684));
    this.f = ((TextView)paramView.findViewById(2131436685));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131428468)
    {
      if (i != 2131444197) {
        return;
      }
      localObject = this.a;
      if (localObject != null)
      {
        ((OpenCallback)localObject).e();
        this.b.setVisibility(0);
        this.e.setVisibility(4);
        this.f.setVisibility(4);
        paramView.setVisibility(4);
      }
    }
    else
    {
      if ((this.c != null) && (this.j != null) && (this.m != null))
      {
        i = ((ApolloManagerServiceImpl)this.j.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.j.getCurrentUin());
        if (HardCodeUtil.a(2131898711).equals(this.c.getText())) {
          localObject = "openshop";
        } else {
          localObject = "open";
        }
        ApolloDtReportUtil.a("panel", "new_user_v2", (String)localObject, new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.j)).b(ApolloDtReportUtil.a(this.m.a)).c(this.m.b).f(i).a());
      }
      localObject = this.a;
      if (localObject == null) {
        return;
      }
      ((OpenCallback)localObject).l();
      if (this.d)
      {
        this.a.d();
        return;
      }
      if (this.a != null)
      {
        paramView.setClickable(false);
        this.b = ((ImageView)((View)paramView.getParent()).findViewById(2131447459));
        this.b.setVisibility(0);
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloMainViewBinder
 * JD-Core Version:    0.7.0.1
 */