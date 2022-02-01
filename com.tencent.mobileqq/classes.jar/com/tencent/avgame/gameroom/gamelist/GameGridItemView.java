package com.tencent.avgame.gameroom.gamelist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.math.BigDecimal;

public class GameGridItemView
  extends RelativeLayout
  implements View.OnClickListener
{
  protected GameItem a;
  protected int b;
  protected boolean c;
  protected GameGridItemView.GameGridClickListener d;
  private TextView e;
  private TextView f;
  private View g;
  private View h;
  
  public GameGridItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GameGridItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GameGridItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(GameItem paramGameItem, boolean paramBoolean, int paramInt1, int paramInt2, URLDrawable paramURLDrawable1, URLDrawable paramURLDrawable2)
  {
    this.a = paramGameItem;
    this.b = paramInt2;
    this.c = paramBoolean;
    float f1;
    if (paramGameItem.o >= 100000000L)
    {
      f1 = new BigDecimal((float)paramGameItem.o / 1.0E+008F).setScale(1, 1).floatValue();
      paramGameItem = new StringBuilder();
      paramGameItem.append(f1);
      paramGameItem.append(getContext().getResources().getString(2131887343));
      paramGameItem = paramGameItem.toString();
    }
    else if (paramGameItem.o >= 100000L)
    {
      f1 = new BigDecimal((float)paramGameItem.o / 10000.0F).setScale(1, 1).floatValue();
      paramGameItem = new StringBuilder();
      paramGameItem.append(f1);
      paramGameItem.append(getContext().getResources().getString(2131887342));
      paramGameItem = paramGameItem.toString();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramGameItem.o);
      localStringBuilder.append("");
      paramGameItem = localStringBuilder.toString();
    }
    this.f.setText(String.format(getResources().getString(2131887204), new Object[] { paramGameItem }));
    if (paramURLDrawable1 != null) {
      this.e.setBackgroundDrawable(paramURLDrawable1);
    } else {
      this.e.setBackgroundDrawable(null);
    }
    if (paramURLDrawable2 != null) {
      setBackgroundDrawable(paramURLDrawable2);
    } else {
      setBackgroundDrawable(null);
    }
    setTag(Integer.valueOf(paramInt2));
    this.g.setTag(Integer.valueOf(paramInt2));
    if (paramInt2 == paramInt1)
    {
      setAlpha(1.0F);
      paramGameItem = AVGameUtil.c("avgame_game_select@2x.png");
      if (paramGameItem != null) {
        this.h.setBackgroundDrawable(new BitmapDrawable(paramGameItem));
      }
    }
    else
    {
      setAlpha(0.6F);
      this.h.setBackgroundDrawable(null);
    }
  }
  
  public void a(GameGridItemView.GameGridClickListener paramGameGridClickListener)
  {
    this.d = paramGameGridClickListener;
    this.e = ((TextView)findViewById(2131439121));
    this.f = ((TextView)findViewById(2131440397));
    this.g = findViewById(2131433944);
    this.h = findViewById(2131445509);
    this.g.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (((localObject instanceof Integer)) && (this.d != null))
    {
      int i = ((Integer)localObject).intValue();
      if ((paramView instanceof GameGridItemView))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("itemGridClick ");
          ((StringBuilder)localObject).append(i);
          QLog.i("GameGridItemView", 2, ((StringBuilder)localObject).toString());
        }
        this.d.b(i);
      }
      else if (paramView.getId() == 2131433944)
      {
        this.d.a(i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameGridItemView
 * JD-Core Version:    0.7.0.1
 */