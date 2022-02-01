package com.tencent.avgame.gameroom.stage.guesspicture;

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

public class GuessPictureStageView
  extends BaseGuessPictureStageView
{
  ImageView F;
  
  public GuessPictureStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessPictureStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessPictureStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void c()
  {
    LayoutInflater.from(getContext()).inflate(2131624288, this, true);
    this.e = ((TextView)findViewById(2131448813));
    this.f = ((TextView)findViewById(2131448811));
    this.g = ((AVGameText)findViewById(2131448302));
    this.h = ((AVGameText)findViewById(2131448303));
    this.i = findViewById(2131437420);
    this.k = ((ImageView)findViewById(2131436460));
    this.l = ((ImageView)findViewById(2131431441));
    this.F = ((ImageView)findViewById(2131433098));
    this.m = findViewById(2131437582);
    this.j = ((ImageView)findViewById(2131446682));
    this.j.setOnClickListener(new GuessPictureStageView.1(this));
    this.n = findViewById(2131434340);
    this.e.setTextSize(0, UiUtils.b());
    this.m.getLayoutParams().width = UiUtils.a();
    this.d = new GuessPictureStagePresenter(this);
    this.l.setVisibility(4);
    this.m.setVisibility(4);
    this.j.setVisibility(4);
    this.n.setVisibility(8);
    super.c();
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.e.setTextColor(Color.parseColor(paramFontStyleConfig.i));
    this.f.setTextColor(Color.parseColor(paramFontStyleConfig.j));
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    super.setSpecialMode(paramBoolean);
    if (this.r == null) {
      return;
    }
    if (this.t)
    {
      this.r.setVisibility(0);
      this.F.setVisibility(0);
      this.l.setVisibility(8);
      this.l = this.F;
      return;
    }
    this.r.setVisibility(8);
    this.l.setVisibility(0);
    this.F.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView
 * JD-Core Version:    0.7.0.1
 */