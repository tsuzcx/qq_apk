package com.tencent.mobileqq.activity.aio.tips;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamInfo;

public class GameMakeTeamTipBar
  implements View.OnClickListener, TipsBarTask
{
  protected BaseChatPie a;
  private View b;
  private String c;
  private QQBlurView d;
  private TextView e;
  private TextView f;
  private boolean g = false;
  private RoundImageView h;
  private RoundImageView i;
  private RoundImageView j;
  private RoundImageView k;
  private FrameLayout l;
  private TextView m;
  private GameMakeTeamTipBar.TeamInfoWrapper n;
  private RelativeLayout o;
  private long p;
  
  public GameMakeTeamTipBar(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a(GameMakeTeamTipBar.TeamInfoWrapper paramTeamInfoWrapper)
  {
    GameMakeTeamTipBar.TeamInfoWrapper localTeamInfoWrapper = this.n;
    if (localTeamInfoWrapper == null)
    {
      b(paramTeamInfoWrapper);
      return;
    }
    if (!QQGamePubAIOHelper.b(localTeamInfoWrapper.a).equals(QQGamePubAIOHelper.b(paramTeamInfoWrapper.a)))
    {
      a(2);
      b(paramTeamInfoWrapper);
      return;
    }
    paramTeamInfoWrapper.c = this.n.c;
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (this.a.f != BaseActivity.sTopActivity) {
      return;
    }
    paramImageView.setVisibility(0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramImageView.getContext().getResources().getDrawable(2130841158);
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private boolean a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    if ((this.n != null) && (paramTeamInfo.msg_seq.get().equals(this.n.a.msg_seq.get())) && (paramTeamInfo.status.get() == this.n.a.status.get()) && (paramTeamInfo.main_text.get().equals(this.n.a.main_text.get())) && (paramTeamInfo.sub_text.get().equals(this.n.a.sub_text.get())) && (paramTeamInfo.jump_url.get().equals(this.n.a.jump_url.get())) && (paramTeamInfo.icons.get().size() == this.n.a.icons.get().size()))
    {
      int i1 = 0;
      while (i1 < paramTeamInfo.icons.get().size())
      {
        String str = (String)paramTeamInfo.icons.get().get(i1);
        if ((str != null) && (!str.equals(this.n.a.icons.get().get(i1)))) {
          return true;
        }
        i1 += 1;
      }
      return false;
    }
    return true;
  }
  
  private void b(GameMakeTeamTipBar.TeamInfoWrapper paramTeamInfoWrapper)
  {
    for (;;)
    {
      try
      {
        paramTeamInfoWrapper.c = System.currentTimeMillis();
        HashMap localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(4), "8");
        localHashMap.put(Integer.valueOf(2), paramTeamInfoWrapper.a.team_id.get());
        localObject = paramTeamInfoWrapper.a.subscribe_id.get();
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = paramTeamInfoWrapper.a.subscribe_id.get();
        }
        localHashMap.put(Integer.valueOf(6), localObject);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("groupid", paramTeamInfoWrapper.b.b);
        localJSONObject.put("battletype", paramTeamInfoWrapper.a.sub_text.get().replace("|", "-"));
        if (TextUtils.isEmpty(paramTeamInfoWrapper.a.subscribe_id.get()))
        {
          localObject = "1";
          localJSONObject.put("roomtype", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramTeamInfoWrapper.a.icons.size());
          ((StringBuilder)localObject).append("");
          localJSONObject.put("roomnum", ((StringBuilder)localObject).toString());
          localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
          GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207623", paramTeamInfoWrapper.a.appid.get(), "100601", "1", "145", localHashMap);
          return;
        }
      }
      catch (Throwable paramTeamInfoWrapper)
      {
        QLog.e("GameMakeTeamTipBar", 1, paramTeamInfoWrapper, new Object[0]);
        return;
      }
      Object localObject = "2";
    }
  }
  
  private GradientDrawable h()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setGradientType(0);
    localGradientDrawable.setShape(1);
    int i1 = Color.parseColor("#FFD5B8");
    int i2 = Color.parseColor("#FDA05D");
    if (Build.VERSION.SDK_INT >= 16)
    {
      localGradientDrawable.setColors(new int[] { i1, i2 });
      localGradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
      return localGradientDrawable;
    }
    localGradientDrawable.setColor(Color.parseColor("#FDA05D"));
    return localGradientDrawable;
  }
  
  @TargetApi(19)
  private void i()
  {
    this.d = ((QQBlurView)this.b.findViewById(2131439803));
    if (this.g) {
      return;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      ((QQBlurView)localObject).a(this.a.aZ);
      localObject = this.d;
      ((QQBlurView)localObject).b((View)localObject);
      this.d.b(0);
      this.d.a(8.0F);
      this.d.a(4);
      this.d.d();
      this.d.a();
      this.g = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.d)));
        QLog.d("GameMakeTeamTipBar", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void j()
  {
    i();
    Object localObject = this.b.findViewById(2131439721);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      ((View)localObject).setBackgroundColor(this.b.getResources().getColor(2131167964));
      ((View)localObject).setVisibility(0);
      this.d.setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showBlurView() gone called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.d)));
        QLog.d("GameMakeTeamTipBar", 2, ((StringBuilder)localObject).toString());
      }
      this.d = null;
      return;
    }
    ((View)localObject).setVisibility(8);
    this.d.setVisibility(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() visibility called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.d)));
      QLog.d("GameMakeTeamTipBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void k()
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(4), "20");
        localHashMap.put(Integer.valueOf(2), this.n.a.team_id.get());
        Object localObject = this.n.a.subscribe_id.get();
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = this.n.a.subscribe_id.get();
        }
        localHashMap.put(Integer.valueOf(6), localObject);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("groupid", this.n.b.b);
        localJSONObject.put("battletype", this.n.a.sub_text.get().replace("|", "-"));
        if (TextUtils.isEmpty(this.n.a.subscribe_id.get()))
        {
          localObject = "1";
          localJSONObject.put("roomtype", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.n.a.icons.size());
          ((StringBuilder)localObject).append("");
          localJSONObject.put("roomnum", ((StringBuilder)localObject).toString());
          localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
          GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207624", this.n.a.appid.get(), "100601", "1", "145", localHashMap);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameMakeTeamTipBar", 1, localThrowable, new Object[0]);
        return;
      }
      String str = "2";
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.b == null)
    {
      this.b = LayoutInflater.from(this.a.aX()).inflate(2131624921, null);
      this.b.setOnClickListener(this);
    }
    d();
    return this.b;
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.n == null) {
          return;
        }
        long l1 = (System.currentTimeMillis() - this.n.c) / 1000L;
        HashMap localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(4), "18");
        localHashMap.put(Integer.valueOf(2), this.n.a.team_id.get());
        Object localObject = this.n.a.subscribe_id.get();
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = this.n.a.subscribe_id.get();
        }
        localHashMap.put(Integer.valueOf(6), localObject);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("groupid", this.n.b.b);
        localJSONObject.put("battletype", this.n.a.sub_text.get().replace("|", "-"));
        if (TextUtils.isEmpty(this.n.a.subscribe_id.get()))
        {
          localObject = "1";
          localJSONObject.put("roomtype", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.n.a.icons.size());
          ((StringBuilder)localObject).append("");
          localJSONObject.put("roomnum", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("");
          localJSONObject.put("disapres", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append("");
          localJSONObject.put("existtime", ((StringBuilder)localObject).toString());
          localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
          GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207698", this.n.a.appid.get(), "100601", "1", "145", localHashMap);
          this.n = null;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameMakeTeamTipBar", 1, localThrowable, new Object[0]);
        return;
      }
      String str = "2";
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000)
    {
      paramVarArgs = this.d;
      if (paramVarArgs != null)
      {
        paramVarArgs.a();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("resumeBlurView called mBlurBgView = ");
          paramVarArgs.append(Integer.toHexString(System.identityHashCode(this.d)));
          QLog.d("GameMakeTeamTipBar", 2, paramVarArgs.toString());
        }
      }
    }
    else if (paramInt == 1003)
    {
      paramVarArgs = this.d;
      if (paramVarArgs != null)
      {
        paramVarArgs.b();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("pauseBlurView called mBlurBgView = ");
          paramVarArgs.append(Integer.toHexString(System.identityHashCode(this.d)));
          QLog.d("GameMakeTeamTipBar", 2, paramVarArgs.toString());
        }
      }
    }
    else if (paramInt == 1004)
    {
      f();
    }
  }
  
  public void a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo, SessionInfo paramSessionInfo)
  {
    try
    {
      if (!a(paramTeamInfo)) {
        return;
      }
      this.e.setText(paramTeamInfo.main_text.get());
      this.f.setText(paramTeamInfo.sub_text.get());
      this.c = paramTeamInfo.jump_url.get();
      this.o.setVisibility(8);
      this.i.setVisibility(8);
      this.l.setVisibility(8);
      Object localObject = paramTeamInfo.icons.get();
      int i1 = ((List)localObject).size();
      if ((i1 > 0) && (!TextUtils.isEmpty((CharSequence)((List)localObject).get(0))))
      {
        this.o.setVisibility(0);
        a((String)((List)localObject).get(0), this.h);
      }
      if ((i1 > 1) && (!TextUtils.isEmpty((CharSequence)((List)localObject).get(1)))) {
        a((String)((List)localObject).get(1), this.i);
      }
      if ((i1 > 2) && (!TextUtils.isEmpty((CharSequence)((List)localObject).get(2))))
      {
        a((String)((List)localObject).get(2), this.j);
        this.l.setVisibility(0);
        if (i1 > 3)
        {
          this.k.setVisibility(0);
          this.m.setVisibility(0);
          localObject = this.m;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("+");
          localStringBuilder.append(i1 - 2);
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
        else
        {
          this.k.setVisibility(4);
          this.m.setVisibility(4);
        }
      }
      paramTeamInfo = new GameMakeTeamTipBar.TeamInfoWrapper(paramTeamInfo, paramSessionInfo);
      a(paramTeamInfo);
      this.n = paramTeamInfo;
      return;
    }
    catch (Throwable paramTeamInfo)
    {
      throw new Exception(paramTeamInfo);
    }
  }
  
  public int b()
  {
    return 30;
  }
  
  public int[] c()
  {
    return new int[0];
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initView..view:");
      localStringBuilder.append(this.b);
      QLog.i("GameMakeTeamTipBar", 1, localStringBuilder.toString());
    }
    this.b.setBackgroundResource(2130837937);
    j();
    this.e = ((TextView)this.b.findViewById(2131447683));
    this.f = ((TextView)this.b.findViewById(2131447682));
    this.b.findViewById(2131447681).setOnClickListener(this);
    this.h = ((RoundImageView)this.b.findViewById(2131444890));
    this.i = ((RoundImageView)this.b.findViewById(2131444891));
    this.j = ((RoundImageView)this.b.findViewById(2131444892));
    this.k = ((RoundImageView)this.b.findViewById(2131444893));
    this.l = ((FrameLayout)this.b.findViewById(2131433303));
    this.m = ((TextView)this.b.findViewById(2131448800));
    this.o = ((RelativeLayout)this.b.findViewById(2131444981));
    this.o.setBackgroundDrawable(h());
    this.n = null;
  }
  
  public void e()
  {
    this.n = null;
  }
  
  protected void f()
  {
    this.n = null;
    if (this.g)
    {
      this.d = ((QQBlurView)this.b.findViewById(2131439803));
      this.g = false;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("destroyBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.d)));
        QLog.d("GameMakeTeamTipBar", 2, ((StringBuilder)localObject).toString());
      }
      this.d = null;
    }
  }
  
  public GameMakeTeamTipBar.TeamInfoWrapper g()
  {
    return this.n;
  }
  
  public void onClick(View paramView)
  {
    if (Math.abs(System.currentTimeMillis() - this.p) >= 500L)
    {
      this.p = System.currentTimeMillis();
      if (!StringUtil.isEmpty(this.c))
      {
        Intent localIntent = new Intent(this.a.aX(), QQBrowserActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
        localIntent.putExtra("url", this.c);
        this.a.aX().startActivity(localIntent);
        k();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GameMakeTeamTipBar
 * JD-Core Version:    0.7.0.1
 */