package com.tencent.avgame.gameroom.stage.guesssong;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.UiUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class GuessSongStageView
  extends BaseGuessSongStageView
{
  private ImageView x;
  private ImageView y;
  
  public GuessSongStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessSongStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessSongStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.p == null)
    {
      AVGameLottieHelper.a(getContext(), "avgame_guess_song_playing/data.json", "avgame_guess_song_playing/images/", paramInt1, paramInt2, new GuessSongStageView.1(this));
      return;
    }
    e();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.f.setVisibility(4);
      this.g.setVisibility(8);
      setBackgroundDrawable(null);
      if ((this.p != null) && (this.p.isRunning())) {
        this.p.stop();
      }
      this.p = null;
      this.o.setVisibility(4);
      return;
    }
    this.f.setVisibility(0);
    this.g.setVisibility(8);
    if (this.o.getVisibility() != 0)
    {
      String str = this.c.a().a().s();
      if (!TextUtils.isEmpty(str)) {
        setBackgroundDrawable(URLDrawable.getDrawable(str));
      } else {
        setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
      }
      this.o.setVisibility(0);
      if (this.q)
      {
        a(140, 140);
        return;
      }
      d();
    }
  }
  
  protected void c()
  {
    LayoutInflater.from(getContext()).inflate(2131624289, this, true);
    this.d = ((TextView)findViewById(2131448813));
    this.e = ((TextView)findViewById(2131448811));
    this.g = findViewById(2131437582);
    this.h = ((AVGameText)findViewById(2131448302));
    this.i = ((AVGameText)findViewById(2131448303));
    this.j = findViewById(2131437420);
    this.f = ((ImageView)findViewById(2131431441));
    this.y = ((ImageView)findViewById(2131433098));
    this.k = findViewById(2131434340);
    this.k.setVisibility(8);
    this.d.setTextSize(0, UiUtils.b());
    this.g.getLayoutParams().width = UiUtils.a();
    this.c = new GuessSongStagePresenter(this);
    this.f.setVisibility(4);
    this.g.setVisibility(4);
    this.o = ((ImageView)findViewById(2131446158));
    this.o.setVisibility(4);
    this.x = ((ImageView)findViewById(2131446159));
    super.c();
  }
  
  protected void f()
  {
    Object localObject = GameEngine.a().s();
    if (!((EngineData)localObject).N())
    {
      super.f();
      return;
    }
    localObject = ((EngineData)localObject).f();
    if ((localObject != null) && (!TextUtils.isEmpty(((GameItem)localObject).u))) {
      localObject = ((GameItem)localObject).u;
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkLogo = ");
      localStringBuilder.append((String)localObject);
      QLog.d("GuessSongStageView", 2, localStringBuilder.toString());
    }
    if (localObject == null)
    {
      this.x.setImageDrawable(null);
      return;
    }
    localObject = URLDrawable.getDrawable((String)localObject);
    this.x.setImageDrawable((Drawable)localObject);
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.d.setTextColor(Color.parseColor(paramFontStyleConfig.i));
    this.e.setTextColor(Color.parseColor(paramFontStyleConfig.j));
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    super.setSpecialMode(paramBoolean);
    if (this.m == null) {
      return;
    }
    View localView = findViewById(2131446157);
    if (this.q)
    {
      this.m.setVisibility(0);
      int i = ViewUtils.dip2px(140.0F);
      ViewGroup.LayoutParams localLayoutParams = this.o.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams = this.x.getLayoutParams();
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      this.x.setVisibility(0);
      localView.setPadding(0, ViewUtils.dip2px(40.0F), 0, 0);
      this.y.setVisibility(0);
      this.f.setVisibility(8);
      this.f = this.y;
      return;
    }
    localView.setPadding(0, 0, 0, 0);
    this.m.setVisibility(8);
    this.f.setVisibility(0);
    this.y.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView
 * JD-Core Version:    0.7.0.1
 */