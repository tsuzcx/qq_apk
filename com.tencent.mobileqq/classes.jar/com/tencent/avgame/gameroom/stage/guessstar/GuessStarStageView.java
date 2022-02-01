package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.UiUtils;

public class GuessStarStageView
  extends BaseGuessStarStageView
{
  private ImageView v;
  
  public GuessStarStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessStarStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessStarStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void c()
  {
    LayoutInflater.from(getContext()).inflate(2131624290, this, true);
    this.h = ((ImageView)findViewById(2131431441));
    this.v = ((ImageView)findViewById(2131433098));
    this.g = ((LinearLayout)findViewById(2131447779));
    this.e = ((TextView)findViewById(2131447762));
    this.f = ((TextView)findViewById(2131447764));
    this.i = findViewById(2131434340);
    this.j = ((AVGameText)findViewById(2131448302));
    this.k = ((AVGameText)findViewById(2131448303));
    this.l = findViewById(2131437420);
    this.i.setVisibility(8);
    this.f.setTextSize(0, UiUtils.b());
    this.g.getLayoutParams().width = UiUtils.a();
    this.g.setVisibility(8);
    this.c = new GuessStarStagePresenter(this);
    super.c();
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.f.setTextColor(Color.parseColor(paramFontStyleConfig.i));
    this.e.setTextColor(Color.parseColor(paramFontStyleConfig.j));
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    super.setSpecialMode(paramBoolean);
    if (this.n == null) {
      return;
    }
    if (this.p)
    {
      this.n.setVisibility(0);
      this.v.setVisibility(0);
      this.h.setVisibility(8);
      this.h = this.v;
      return;
    }
    this.n.setVisibility(8);
    this.h.setVisibility(0);
    this.v.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView
 * JD-Core Version:    0.7.0.1
 */