package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BigTroopExpiredTipsBar
  implements View.OnClickListener, TipsBarTask
{
  public static String a = "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=%s&from=%s";
  private String b;
  private QQAppInterface c;
  private Context d;
  private TipsManager e;
  private SpannableString f;
  private int g;
  private int h;
  private boolean i;
  
  public BigTroopExpiredTipsBar(QQAppInterface paramQQAppInterface, Context paramContext, TipsManager paramTipsManager)
  {
    this.c = paramQQAppInterface;
    this.d = paramContext;
    this.e = paramTipsManager;
  }
  
  public int a()
  {
    return 25;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.d).inflate(2131624151, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131428134);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131428144);
    ((TextView)paramVarArgs.findViewById(2131428145)).setText(this.f);
    if (this.g == 0)
    {
      localImageView1.setImageResource(2130839660);
      paramVarArgs.setBackgroundResource(2130839657);
      localImageView2.setImageResource(2130852279);
    }
    else
    {
      localImageView1.setImageResource(2130845604);
      paramVarArgs.setBackgroundResource(2130849037);
      localImageView2.setImageResource(2130845761);
      localImageView2.setOnClickListener(this);
    }
    paramVarArgs.setOnClickListener(this);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    this.b = paramString;
    this.f = paramSpannableString;
    this.g = paramInt1;
    this.h = paramInt2;
    boolean bool;
    if ((paramInt2 != 3) && (paramInt2 != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    this.i = bool;
  }
  
  public int b()
  {
    return 23;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    Object localObject;
    QQAppInterface localQQAppInterface;
    if (j != 2131428133)
    {
      if (j == 2131428144)
      {
        localObject = (TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER);
        j = ((TroopManager)localObject).N(this.b);
        ((TroopManager)localObject).g(this.b, j + 1);
        this.e.c();
        if (this.i)
        {
          localQQAppInterface = this.c;
          if (this.h == 3) {
            localObject = "0X800A57A";
          } else {
            localObject = "0X800A57C";
          }
          ReportController.b(localQQAppInterface, "dc00898", "", "", "qq_vip", (String)localObject, 2, 0, "", "", "", "");
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigTroopExpiredTipsBar", 2, "click tips, jump");
      }
      if (!this.i)
      {
        localObject = new Intent(this.d, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", String.format(a, new Object[] { this.b, "group_aio_tip" }));
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        this.d.startActivity((Intent)localObject);
        ReportController.b(this.c, "dc00898", "", "", "qq_vip", "0X8009E34", this.h, 0, "", "", "", "");
      }
      else
      {
        TroopManager.LiangGroupHelper.a(this.d, this.b, "group_aio_tip");
        localQQAppInterface = this.c;
        if (this.h == 3) {
          localObject = "0X800A57A";
        } else {
          localObject = "0X800A57C";
        }
        ReportController.b(localQQAppInterface, "dc00898", "", "", "qq_vip", (String)localObject, 1, 0, "", "", "", "");
      }
      this.e.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredTipsBar
 * JD-Core Version:    0.7.0.1
 */