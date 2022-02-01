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
  private ImageView b;
  
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
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131558673, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365268));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366776));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379056));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379039));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379041));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367771);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379550));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379551));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370232);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.b());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().width = UiUtils.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessStarStagePresenter(this);
    super.b();
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.e));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.f));
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    super.setSpecialMode(paramBoolean);
    if (this.c == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      return;
    }
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView
 * JD-Core Version:    0.7.0.1
 */