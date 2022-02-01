package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import mqq.app.AppRuntime;

public class TogetherWatchTroopTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private final String a;
  private QQAppInterface b;
  private BaseSessionInfo c;
  private TipsManager d;
  private Context e;
  private View f;
  private float g;
  
  public TogetherWatchTroopTipsBar(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TogetherWatchTroopTipsBar.");
    localStringBuilder.append(paramBaseSessionInfo.a);
    localStringBuilder.append(".");
    localStringBuilder.append(paramBaseSessionInfo.b);
    this.a = localStringBuilder.toString();
    this.b = paramQQAppInterface;
    this.c = paramBaseSessionInfo;
    this.d = paramTipsManager;
    this.e = paramContext;
    this.g = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void d()
  {
    if (this.f == null)
    {
      this.f = ((LayoutInflater)this.e.getSystemService("layout_inflater")).inflate(2131624152, null);
      this.f.setId(2131447677);
      Object localObject = this.f;
      float f1 = this.g;
      ((View)localObject).setPadding(0, (int)(f1 * 2.0F), 0, (int)(f1 * 2.0F));
      this.f.setClickable(true);
      this.f.setOnClickListener(this);
      localObject = (ThemeImageView)this.f.findViewById(2131435229);
      localObject = (TextView)this.f.findViewById(2131448810);
      ImageView localImageView = (ImageView)this.f.findViewById(2131435228);
      if (!ThemeUtil.isNowThemeIsNight(this.b, false, null))
      {
        this.f.setBackgroundResource(2130839657);
      }
      else
      {
        this.f.setBackgroundColor(2130839651);
        ((TextView)localObject).setTextColor(-1);
        localImageView.setImageDrawable(this.e.getResources().getDrawable(2130839650));
      }
      ((TextView)localObject).setText(HardCodeUtil.a(2131912311));
    }
  }
  
  public int a()
  {
    return 67;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.f;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 1000) && (this.c.a == 1))
    {
      paramVarArgs = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).e(this.c.b);
      if ((paramVarArgs != null) && (paramVarArgs.isTroopOwner(this.b.getCurrentUin())))
      {
        paramVarArgs = TogetherControlManager.a(this.b).a(this.c.b);
        if (paramVarArgs != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.a, 2, new Object[] { "troop ", paramVarArgs.b, " newNum=", Integer.valueOf(paramVarArgs.d), " unreadNum=", Integer.valueOf(paramVarArgs.c) });
          }
          d();
          this.d.a(this, new Object[0]);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "Admin but Not message");
        }
      }
    }
  }
  
  public int b()
  {
    return 24;
  }
  
  public int[] c()
  {
    return new int[2];
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.e, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://qvideo.qq.com/qq/together-signing/index.html");
    this.e.startActivity((Intent)localObject);
    this.d.c();
    TogetherControlManager.a(this.b).b(this.c.b);
    localObject = this.b;
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_AIO", "", "video_tab", "clk_whitebar", 0, 1, ((QQAppInterface)localObject).getCurrentUin(), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar
 * JD-Core Version:    0.7.0.1
 */