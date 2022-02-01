package com.tencent.avgame.gameroom.stage.guesstext;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.UiUtils;

public class GuessTextStageView
  extends BaseGuessTextStageView
{
  private ImageView y;
  
  public GuessTextStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessTextStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessTextStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void c()
  {
    LayoutInflater.from(getContext()).inflate(2131624291, this, true);
    this.d = ((TextView)findViewById(2131448813));
    this.e = ((TextView)findViewById(2131448811));
    this.f = ((ImageView)findViewById(2131431441));
    this.y = ((ImageView)findViewById(2131433098));
    this.g = findViewById(2131437582);
    this.d.setTextSize(0, UiUtils.b());
    this.r = ((TextView)findViewById(2131448507));
    this.r.setVisibility(4);
    this.s = ((ImageView)findViewById(2131448509));
    if (this.s != null) {
      this.s.setVisibility(8);
    }
    this.m = ((AVGameText)findViewById(2131448302));
    this.n = ((AVGameText)findViewById(2131448303));
    this.o = findViewById(2131437420);
    this.t = findViewById(2131434340);
    this.t.setVisibility(8);
    this.g.getLayoutParams().width = UiUtils.a();
    this.c = new GuessTextStagePresenter(this);
    this.f.setVisibility(4);
    this.g.setVisibility(4);
    super.c();
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
    if (this.i == null) {
      return;
    }
    if (this.k)
    {
      this.i.setVisibility(0);
      this.y.setVisibility(0);
      this.f.setVisibility(8);
      this.f = this.y;
      return;
    }
    this.i.setVisibility(8);
    this.f.setVisibility(0);
    this.y.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView
 * JD-Core Version:    0.7.0.1
 */