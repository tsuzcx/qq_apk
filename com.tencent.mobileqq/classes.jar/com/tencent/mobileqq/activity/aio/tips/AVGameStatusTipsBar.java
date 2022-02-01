package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.api.impl.AvGameManagerImpl;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameRoomListFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AVGameStatusTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private final String a;
  private final int b = 3;
  private QQAppInterface c;
  private BaseSessionInfo d;
  private TipsManager e;
  private Activity f;
  private List<RoomInfo> g;
  private View h;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  private TextView l;
  private int m;
  private int n;
  private boolean o;
  private String p;
  
  public AVGameStatusTipsBar(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager, Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVGameStatusTipsBar.");
    localStringBuilder.append(paramBaseSessionInfo.a);
    localStringBuilder.append(".");
    localStringBuilder.append(paramBaseSessionInfo.b);
    this.a = localStringBuilder.toString();
    this.c = paramQQAppInterface;
    this.d = paramBaseSessionInfo;
    this.e = paramTipsManager;
    this.f = paramActivity;
    this.o = false;
  }
  
  private List<Player> a(List<RoomInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      RoomInfo localRoomInfo = (RoomInfo)paramList.get(i1);
      int i2 = 3 - localArrayList.size();
      if (localRoomInfo.players.size() >= i2)
      {
        localArrayList.addAll(localRoomInfo.getPlayers().subList(0, i2));
        return localArrayList;
      }
      localArrayList.addAll(localRoomInfo.players);
      i1 += 1;
    }
    return localArrayList;
  }
  
  private void a(LinearLayout paramLinearLayout, List<Player> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramLinearLayout.removeAllViews();
      int i1 = 0;
      while ((i1 < paramList.size()) && (i1 < 3))
      {
        Object localObject1 = (Player)paramList.get(i1);
        Object localObject2 = ImageUtil.m();
        localObject1 = FaceDrawable.getFaceDrawableFrom(this.c, 1, ((Player)localObject1).uin, 3, (Drawable)localObject2, (Drawable)localObject2, 4);
        localObject2 = new ThemeImageView(this.f);
        int i2 = this.m;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i2, i2);
        if (i1 == 0) {
          i2 = 0;
        } else {
          i2 = this.n;
        }
        localLayoutParams.leftMargin = i2;
        ((ThemeImageView)localObject2).setLayoutParams(localLayoutParams);
        ((ThemeImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ThemeImageView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        paramLinearLayout.addView((View)localObject2);
        i1 += 1;
      }
    }
  }
  
  private void a(String paramString)
  {
    Object localObject1 = (IAvGameManager)this.c.getRuntimeService(IAvGameManager.class, "");
    if (localObject1 != null)
    {
      Object localObject2 = this.g;
      if (localObject2 != null)
      {
        if (((List)localObject2).size() == 0) {
          return;
        }
        boolean bool = ((IAvGameManager)localObject1).isAvGameRoomExist();
        int i2 = 2;
        int i1;
        if (bool) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        if (this.g.size() == 1) {
          i2 = 1;
        }
        localObject1 = this.p;
        if (localObject1 == null) {
          localObject1 = "";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(i2);
        ReportController.b(null, "dc00898", "", "", paramString, paramString, i1, 0, ((StringBuilder)localObject2).toString(), "", this.d.b, (String)localObject1);
      }
    }
  }
  
  private void b(List<RoomInfo> paramList, int paramInt)
  {
    Object localObject1 = this.p;
    String str;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      str = this.p;
    } else {
      str = this.f.getString(2131887419);
    }
    Object localObject2 = this.f.getString(2131887420);
    localObject1 = localObject2;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (paramList.size() > 0) {
        if (paramList.size() > 1)
        {
          if (paramInt <= paramList.size()) {
            paramInt = paramList.size();
          }
          localObject1 = String.format(this.f.getString(2131887422), new Object[] { Integer.valueOf(paramInt) });
        }
        else
        {
          localObject1 = (RoomInfo)paramList.get(0);
          localObject1 = String.format(this.f.getString(2131887421), new Object[] { Integer.valueOf(((RoomInfo)localObject1).players.size()) });
        }
      }
    }
    localObject2 = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(str);
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = (LinearLayout)this.h.findViewById(2131429192);
    if (paramList != null) {
      paramList = a(paramList);
    } else {
      paramList = null;
    }
    a((LinearLayout)localObject1, paramList);
    if (!ThemeUtil.isNowThemeIsNight(this.c, false, null))
    {
      this.h.setBackgroundResource(2130839657);
      this.l.setTextColor(-16777216);
      this.k.setImageDrawable(this.f.getResources().getDrawable(2130839647));
      return;
    }
    this.h.setBackgroundColor(-14737633);
    this.l.setTextColor(-1);
    this.k.setImageDrawable(this.f.getResources().getDrawable(2130839648));
  }
  
  private void e()
  {
    if (this.h != null) {
      return;
    }
    this.m = this.f.getResources().getDimensionPixelSize(2131296924);
    this.n = this.f.getResources().getDimensionPixelSize(2131296923);
    this.h = ((LayoutInflater)this.f.getSystemService("layout_inflater")).inflate(2131624271, null);
    this.h.setClickable(true);
    this.h.setOnClickListener(this);
    this.i = ((ImageView)this.h.findViewById(2131429194));
    this.i.setOnClickListener(new AVGameStatusTipsBar.1(this));
    this.j = ((ImageView)this.h.findViewById(2131429193));
    this.j.setOnClickListener(new AVGameStatusTipsBar.2(this));
    this.l = ((TextView)this.h.findViewById(2131429195));
    this.k = ((ImageView)this.h.findViewById(2131429191));
    TroopInfo localTroopInfo = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).e(this.d.b);
    if ((localTroopInfo != null) && (localTroopInfo.isAdmin()))
    {
      this.k.setVisibility(8);
      this.i.setVisibility(0);
      this.j.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.l.getLayoutParams()).addRule(0, 2131429194);
      this.p = this.f.getString(2131887419);
      return;
    }
    this.p = f();
  }
  
  private String f()
  {
    ArrayList localArrayList = AvGameConfigUtil.a().d();
    if ((localArrayList != null) && (localArrayList.size() != 0)) {
      return (String)localArrayList.get(new Random().nextInt(localArrayList.size()));
    }
    return null;
  }
  
  private void g()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (RoomInfo)this.g.get(0);
      IAvGameManager localIAvGameManager = (IAvGameManager)this.c.getRuntimeService(IAvGameManager.class, "");
      if (localIAvGameManager != null) {
        localIAvGameManager.joinAvGameRoom(this.f, 3, String.valueOf(((RoomInfo)localObject).id), this.d.b);
      }
    }
    else
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("troop_uin", this.d.b);
      QPublicFragmentActivity.start(this.f, (Intent)localObject, AVGameRoomListFragment.class);
    }
  }
  
  private void h()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.f, 230);
    localQQCustomDialog.setMessage(this.f.getString(2131887417)).setPositiveButton(this.f.getString(2131887426), new AVGameStatusTipsBar.4(this)).setNegativeButton(this.f.getString(2131887312), new AVGameStatusTipsBar.3(this));
    localQQCustomDialog.show();
  }
  
  public int a()
  {
    return 61;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.h;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(List<RoomInfo> paramList, int paramInt)
  {
    if (this.h == null) {
      e();
    }
    this.g = paramList;
    b(paramList, paramInt);
    paramList = this.e.a();
    boolean bool = false;
    if (paramList != this) {
      bool = this.e.a(this, new Object[0]);
    }
    if ((bool) && (!this.o))
    {
      AvGameManagerImpl.asyncPreloadAVGameProcess(this.c);
      this.o = true;
    }
    if (bool) {
      a("0X800B354");
    }
  }
  
  public int b()
  {
    return 2002;
  }
  
  public int[] c()
  {
    return new int[2];
  }
  
  public void d()
  {
    if (this.e.a() == this) {
      this.e.c();
    }
  }
  
  public void onClick(View paramView)
  {
    g();
    a("0X800B01A");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */