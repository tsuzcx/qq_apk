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
  protected int a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected GameItem a;
  protected GameGridItemView.GameGridClickListener a;
  protected boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
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
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameItem = paramGameItem;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    float f;
    if (paramGameItem.a >= 100000000L)
    {
      f = new BigDecimal((float)paramGameItem.a / 1.0E+008F).setScale(1, 1).floatValue();
      paramGameItem = new StringBuilder();
      paramGameItem.append(f);
      paramGameItem.append(getContext().getResources().getString(2131690432));
      paramGameItem = paramGameItem.toString();
    }
    else if (paramGameItem.a >= 100000L)
    {
      f = new BigDecimal((float)paramGameItem.a / 10000.0F).setScale(1, 1).floatValue();
      paramGameItem = new StringBuilder();
      paramGameItem.append(f);
      paramGameItem.append(getContext().getResources().getString(2131690431));
      paramGameItem = paramGameItem.toString();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramGameItem.a);
      localStringBuilder.append("");
      paramGameItem = localStringBuilder.toString();
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131690293), new Object[] { paramGameItem }));
    if (paramURLDrawable1 != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramURLDrawable1);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
    if (paramURLDrawable2 != null) {
      setBackgroundDrawable(paramURLDrawable2);
    } else {
      setBackgroundDrawable(null);
    }
    setTag(Integer.valueOf(paramInt2));
    this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(paramInt2));
    if (paramInt2 == paramInt1)
    {
      setAlpha(1.0F);
      paramGameItem = AVGameUtil.a("avgame_game_select@2x.png");
      if (paramGameItem != null) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(paramGameItem));
      }
    }
    else
    {
      setAlpha(0.6F);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
    }
  }
  
  public void a(GameGridItemView.GameGridClickListener paramGameGridClickListener)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameGridItemView$GameGridClickListener = paramGameGridClickListener;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372844));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367441);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377133);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (((localObject instanceof Integer)) && (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameGridItemView$GameGridClickListener != null))
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
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameGridItemView$GameGridClickListener.b(i);
      }
      else if (paramView.getId() == 2131367441)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameGridItemView$GameGridClickListener.a(i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameGridItemView
 * JD-Core Version:    0.7.0.1
 */