package com.tencent.avgame.gameroom.stage.guesssong;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.UiUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class GuessSongStageView
  extends BaseGuessSongStageView
{
  private ImageView c;
  private ImageView d;
  
  public GuessSongStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessSongStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessSongStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      AVGameLottieHelper.a(getContext(), "avgame_guess_song_playing/data.json", "avgame_guess_song_playing/images/", paramInt1, paramInt2, new GuessSongStageView.1(this));
      return;
    }
    d();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      setBackgroundDrawable(null);
      if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isRunning())) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      String str = this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().b();
      if (!TextUtils.isEmpty(str)) {
        setBackgroundDrawable(URLDrawable.getDrawable(str));
      } else {
        setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        a(140, 140);
        return;
      }
      c();
    }
  }
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131558672, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379929));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379927));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370328);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379550));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379551));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370232);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365268));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366776));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367771);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.b());
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().width = UiUtils.a();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessSongStagePresenter(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377702));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377703));
    super.b();
  }
  
  protected void e()
  {
    Object localObject = GameEngine.a().a();
    if (!((EngineData)localObject).g())
    {
      super.e();
      return;
    }
    localObject = ((EngineData)localObject).a();
    if ((localObject != null) && (!TextUtils.isEmpty(((GameItem)localObject).o))) {
      localObject = ((GameItem)localObject).o;
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkLogo = ");
      localStringBuilder.append((String)localObject);
      QLog.d("GuessSongStageView", 2, localStringBuilder.toString());
    }
    if (localObject == null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    }
    localObject = URLDrawable.getDrawable((String)localObject);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
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
    if (this.jdField_d_of_type_AndroidViewView == null) {
      return;
    }
    View localView = findViewById(2131377701);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      int i = ViewUtils.a(140.0F);
      ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      localView.setPadding(0, ViewUtils.a(40.0F), 0, 0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_d_of_type_AndroidWidgetImageView;
      return;
    }
    localView.setPadding(0, 0, 0, 0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView
 * JD-Core Version:    0.7.0.1
 */