package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.adapter.GamePKResultRankAdapter;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.QrCodeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class AVGamePKPosterView
  extends RelativeLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GamePKResultRankAdapter jdField_a_of_type_ComTencentAvgameAdapterGamePKResultRankAdapter = null;
  private UserInfoHandler jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler;
  private AVGameSplitNumberView jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView;
  private IGamePosterView jdField_a_of_type_ComTencentAvgameUiIGamePosterView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView f;
  private ImageView g;
  
  public AVGamePKPosterView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AVGamePKPosterView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AVGamePKPosterView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private HashMap<String, String> a(UserInfoHandler paramUserInfoHandler, List<SurvivalPkResultInfo.Pair<Integer, Long>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(String.valueOf(((SurvivalPkResultInfo.Pair)paramList.next()).second));
    }
    return paramUserInfoHandler.a(localArrayList);
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView != null) && (this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.a(paramInt);
    }
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = QrCodeUtil.a(paramString, 98, -16777216, 0, Bitmap.Config.ARGB_8888);
    } while ((paramString == null) || (paramString.isRecycled()));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
    return true;
  }
  
  public String a()
  {
    String str = UUID.randomUUID().toString() + ".png";
    return AppConstants.SDCARD_FILE_SAVE_TMP_PATH + File.separator + str;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558761, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373405));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373421));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373417));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373414));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373415));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131373413));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373412));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373399));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373401));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373410));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131373411));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView = ((AVGameSplitNumberView)findViewById(2131373420));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373419));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373400));
    this.f = ((ImageView)findViewById(2131373408));
    this.g = ((ImageView)findViewById(2131373423));
  }
  
  public void a(int paramInt)
  {
    Bitmap localBitmap = AVGameUtils.a("avgame_pk_result_win2@2x.png");
    if (localBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    localBitmap = AVGameUtils.a("avgame_pk_result_win1@2x.png");
    if (localBitmap != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    localBitmap = AVGameUtils.a("avgame_pk_result_footing@2x.png");
    if (localBitmap != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    b(1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("/" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.g.setVisibility(0);
    Bitmap localBitmap = AVGameUtils.a("avgame_pk_result_fail_spider@2x.png");
    if (localBitmap != null) {
      this.g.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    localBitmap = AVGameUtils.a("avgame_pk_result_fail2@2x.png");
    if (localBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    localBitmap = AVGameUtils.a("avgame_pk_result_fail1@2x.png");
    if (localBitmap != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    localBitmap = AVGameUtils.a("avgame_pk_result_footing2@2x.png");
    if (localBitmap != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    b(paramInt1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("/" + paramInt2);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = 74;
    localLayoutParams.rightMargin = 74;
    this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    if (paramString != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
    }
    paramString = AVGameUtils.a("avgame_room_bg@2x.png");
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new BitmapDrawable(paramString));
    }
    paramString = AVGameUtils.a("avgame_pk_poster_logo@2x.png");
    if (paramString != null) {
      this.f.setBackgroundDrawable(new BitmapDrawable(paramString));
    }
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = paramUserInfoHandler;
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setDimension(98, 134);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setNumDrawable(this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.a("avgame_pk_result_num%d@2x.png"));
  }
  
  public void a(String paramString)
  {
    UiThreadUtil.a(new AVGamePKPosterView.1(this, paramString));
  }
  
  public boolean a(String paramString)
  {
    return b(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvgameAdapterGamePKResultRankAdapter != null) {
      this.jdField_a_of_type_ComTencentAvgameAdapterGamePKResultRankAdapter.a(a(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler, this.jdField_a_of_type_ComTencentAvgameAdapterGamePKResultRankAdapter.a()));
    }
  }
  
  public void setPresenter(IGamePosterView paramIGamePosterView)
  {
    this.jdField_a_of_type_ComTencentAvgameUiIGamePosterView = paramIGamePosterView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePKPosterView
 * JD-Core Version:    0.7.0.1
 */