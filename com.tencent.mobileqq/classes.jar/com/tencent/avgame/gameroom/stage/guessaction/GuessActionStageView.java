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
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558767, this, true);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365404));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379716));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379699));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131380233));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131380234));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379701));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378775));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370577);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368017);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new GuessActionStageView.1(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.b());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().width = UiUtils.a();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessActionStagePresenter(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView
 * JD-Core Version:    0.7.0.1
 */