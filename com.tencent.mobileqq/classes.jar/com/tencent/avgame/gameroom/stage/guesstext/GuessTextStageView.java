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
  private ImageView c;
  
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
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131558674, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379929));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379927));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365268));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366776));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370328);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.b());
    this.e = ((TextView)findViewById(2131379711));
    this.e.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379713));
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379550));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379551));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131370232);
    this.d = findViewById(2131367771);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().width = UiUtils.a();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessTextStagePresenter(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    super.b();
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.e));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.f));
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    super.setSpecialMode(paramBoolean);
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView
 * JD-Core Version:    0.7.0.1
 */