package com.tencent.avgame.gameroom.gamelist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.math.BigDecimal;
import mzj;
import nbs;
import nhs;

public class GameGridItemView
  extends RelativeLayout
  implements View.OnClickListener
{
  protected int a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected mzj a;
  protected nbs a;
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
  
  public void a(mzj parammzj, boolean paramBoolean, int paramInt1, int paramInt2, URLDrawable paramURLDrawable1, URLDrawable paramURLDrawable2)
  {
    this.jdField_a_of_type_Mzj = parammzj;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    float f;
    if (parammzj.a >= 100000000L)
    {
      f = new BigDecimal((float)parammzj.a / 1.0E+008F).setScale(1, 1).floatValue();
      parammzj = f + getContext().getResources().getString(2131690324);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131690240), new Object[] { parammzj }));
      if (paramURLDrawable1 == null) {
        break label291;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramURLDrawable1);
      label125:
      if (paramURLDrawable2 == null) {
        break label302;
      }
      setBackgroundDrawable(paramURLDrawable2);
    }
    for (;;)
    {
      setTag(Integer.valueOf(paramInt2));
      this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(paramInt2));
      if (paramInt2 != paramInt1) {
        break label310;
      }
      setAlpha(1.0F);
      parammzj = nhs.a("avgame_game_select@2x.png");
      if (parammzj != null) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(parammzj));
      }
      return;
      if (parammzj.a >= 100000L)
      {
        f = new BigDecimal((float)parammzj.a / 10000.0F).setScale(1, 1).floatValue();
        parammzj = f + getContext().getResources().getString(2131690323);
        break;
      }
      parammzj = parammzj.a + "";
      break;
      label291:
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      break label125;
      label302:
      setBackgroundDrawable(null);
    }
    label310:
    setAlpha(0.6F);
    this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
  }
  
  public void a(nbs paramnbs)
  {
    this.jdField_a_of_type_Nbs = paramnbs;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371647));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372781));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367353);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377260);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if (((localObject instanceof Integer)) && (this.jdField_a_of_type_Nbs != null))
    {
      i = ((Integer)localObject).intValue();
      if (!(paramView instanceof GameGridItemView)) {
        break label83;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameGridItemView", 2, "itemGridClick " + i);
      }
      this.jdField_a_of_type_Nbs.b(i);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131367353: 
        this.jdField_a_of_type_Nbs.a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameGridItemView
 * JD-Core Version:    0.7.0.1
 */