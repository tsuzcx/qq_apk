package com.tencent.avgame.gameroom.stage.guessaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.UiUtils;

public class GuessActionStageView
  extends BaseGuessActionStageView
{
  public GuessActionStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessActionStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessActionStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131624283, this, true);
    this.g = ((ImageView)findViewById(2131431441));
    this.f = ((LinearLayout)findViewById(2131447779));
    this.c = ((TextView)findViewById(2131447762));
    this.i = ((AVGameText)findViewById(2131448302));
    this.j = ((AVGameText)findViewById(2131448303));
    this.d = ((TextView)findViewById(2131447764));
    this.e = ((ImageView)findViewById(2131446682));
    this.k = findViewById(2131437420);
    this.h = findViewById(2131434340);
    this.e.setOnClickListener(new GuessActionStageView.1(this));
    this.d.setTextSize(0, UiUtils.b());
    this.f.getLayoutParams().width = UiUtils.a();
    this.a = new GuessActionStagePresenter(this);
    this.g.setVisibility(4);
    this.f.setVisibility(4);
    this.e.setVisibility(4);
    this.h.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView
 * JD-Core Version:    0.7.0.1
 */