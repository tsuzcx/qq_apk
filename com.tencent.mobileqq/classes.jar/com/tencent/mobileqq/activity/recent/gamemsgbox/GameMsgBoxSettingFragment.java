package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class GameMsgBoxSettingFragment
  extends QIphoneTitleBarFragment
{
  private static final ArrayList<String> e = new ArrayList();
  private static final ArrayList<String> f = new ArrayList();
  private static int g = 33333;
  private Intent a;
  private AppRuntime b;
  private HashMap<String, GameBasicInfo> c = new HashMap();
  private HashMap<String, GameSwitchConfig> d = new HashMap();
  private int w;
  
  private int a(TextView paramTextView, GameSwitchConfig paramGameSwitchConfig)
  {
    int j = paramGameSwitchConfig.mSyncSwitch;
    int i = 0;
    if (j == 1)
    {
      paramTextView.setText(2131896931);
    }
    else if (paramGameSwitchConfig.mSyncSwitch == 0)
    {
      paramTextView.setText(2131896930);
      i = 1;
    }
    if (paramGameSwitchConfig.mBlockSwitch == 1)
    {
      i = 2;
      paramTextView.setText(2131896916);
    }
    return i;
  }
  
  private void a(LayoutInflater paramLayoutInflater, @androidx.annotation.Nullable ViewGroup paramViewGroup)
  {
    int i = 0;
    while (i < e.size())
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)paramLayoutInflater.inflate(2131624893, paramViewGroup, false);
      ((LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams()).topMargin = ViewUtils.dpToPx(8.0F);
      Object localObject = (GameBasicInfo)this.c.get(e.get(i));
      ((ImageView)localRelativeLayout.findViewById(2131433985)).setImageDrawable(URLDrawable.getDrawable(((GameBasicInfo)localObject).mIconUrl, null));
      ((TextView)localRelativeLayout.findViewById(2131434004)).setText(((GameBasicInfo)localObject).mName);
      localObject = (GameSwitchConfig)this.d.get(e.get(i));
      TextView localTextView = (TextView)localRelativeLayout.findViewById(2131434026);
      localTextView.setTag(e.get(i));
      this.w = a(localTextView, (GameSwitchConfig)localObject);
      localRelativeLayout.setOnClickListener(new -..Lambda.GameMsgBoxSettingFragment.bXUAmLUnvL6OL9XD6ejVZ5oFvCY(this, i));
      f.add(e.get(i));
      paramViewGroup.addView(localRelativeLayout);
      i += 1;
    }
  }
  
  private void b()
  {
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)this.b.getRuntimeService(IGameMsgManagerService.class, "");
    int i = 0;
    while (i < e.size())
    {
      GameBasicInfo localGameBasicInfo = localIGameMsgManagerService.findGameConfig((String)e.get(i));
      this.c.put(e.get(i), localGameBasicInfo);
      i += 1;
    }
  }
  
  private void c()
  {
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)this.b.getRuntimeService(IGameMsgManagerService.class, "");
    int i = 0;
    while (i < e.size())
    {
      GameSwitchConfig localGameSwitchConfig = localIGameMsgManagerService.findGameSwitchConfig((String)e.get(i));
      this.d.put(e.get(i), localGameSwitchConfig);
      i += 1;
    }
  }
  
  private void d()
  {
    ((RelativeLayout)this.t.findViewById(2131434033)).setOnClickListener(new -..Lambda.GameMsgBoxSettingFragment.FBtZ4QIf1OD3LPBysrkMKiKT_7s(this));
  }
  
  protected int a()
  {
    return 2131624892;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @android.support.annotation.Nullable ViewGroup paramViewGroup, @android.support.annotation.Nullable Bundle paramBundle)
  {
    a(getResources().getString(2131896922));
    d();
    a(paramLayoutInflater, (LinearLayout)this.t);
    this.h.setContentDescription(getString(2131887440));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @androidx.annotation.Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    paramInt1 = paramIntent.getIntExtra("pos", -2);
    paramInt2 = paramIntent.getIntExtra("new_option", -1);
    paramIntent = paramIntent.getStringExtra("appid");
    GameSwitchConfig localGameSwitchConfig = (GameSwitchConfig)this.d.get(paramIntent);
    if (paramInt2 != -1)
    {
      if (paramInt2 == paramInt1) {
        return;
      }
      if (paramInt2 == 0)
      {
        localGameSwitchConfig.mSyncSwitch = 1;
        localGameSwitchConfig.mBlockSwitch = 0;
      }
      else if (paramInt2 == 1)
      {
        localGameSwitchConfig.mSyncSwitch = 0;
        localGameSwitchConfig.mBlockSwitch = 0;
      }
      else if (paramInt2 == 2)
      {
        localGameSwitchConfig.mBlockSwitch = 1;
        localGameSwitchConfig.mSyncSwitch = 0;
      }
      a((TextView)this.t.findViewWithTag(paramIntent), localGameSwitchConfig);
      this.w = paramInt2;
      Object[] arrayOfObject = this.d.values().toArray();
      ArrayList localArrayList = new ArrayList();
      paramInt2 = arrayOfObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localArrayList.add((GameSwitchConfig)arrayOfObject[paramInt1]);
        paramInt1 += 1;
      }
      ((IGameMsgManagerService)this.b.getRuntimeService(IGameMsgManagerService.class, "")).saveOrUpdateGameSwitchConfigs(localArrayList);
      ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).setGameSwitch(this.a.getIntExtra("hashCode", 0), paramIntent, localGameSwitchConfig.mSyncSwitch, localGameSwitchConfig.mBlockSwitch);
    }
  }
  
  public void onCreate(@androidx.annotation.Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getQBaseActivity().getAppRuntime();
    this.a = getActivity().getIntent();
    paramBundle = ((IGameMsgBoxManager)this.b.getRuntimeService(IGameMsgBoxManager.class, "")).getGameMsgBoxSp();
    int i = 0;
    while (i < paramBundle.getInt("size", 0))
    {
      if (!f.contains(String.valueOf(paramBundle.getLong(String.valueOf(i), 0L)))) {
        e.add(String.valueOf(paramBundle.getLong(String.valueOf(i), 0L)));
      }
      i += 1;
    }
    b();
    c();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxSettingFragment
 * JD-Core Version:    0.7.0.1
 */