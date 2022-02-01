package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class QuestionOptionItemView
  extends FrameLayout
{
  private static String jdField_a_of_type_JavaLangString = "avgame_click_btn_normal@2x.png";
  private static String b = "avgame_click_btn_select@2x.png";
  private static String c = "avgame_click_btn_succ@2x.png";
  private static String d = "avgame_click_btn_fail@2x.png";
  private static String e = "avgame_click_btn_press@2x.png";
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionOverlappingImgLayout;
  private QuestionOptionItemConfig jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QuestionOptionItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QuestionOptionItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackground(new BitmapDrawable(paramBitmap));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372196));
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig = new QuestionOptionItemConfig(14.0F, Color.parseColor("#9A7030"), Color.parseColor("#FFF5E6"), 14, Color.parseColor("#FFFFFF"), 14, Color.parseColor("#FFFFFF"));
    }
    else
    {
      if ((!this.jdField_a_of_type_Boolean) && (((QuestionOptionItemConfig)localObject).a() > 0.0F)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a());
      }
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a() != 0)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a());
      }
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionOverlappingImgLayout = ((OverlappingImgLayout)findViewById(2131372197));
    localObject = (UserInfoHandler)((AppInterface)IGameEngine.a()).getBusinessHandler(HandlerFactory.b);
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionOverlappingImgLayout.a(14, 14, (UserInfoHandler)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131372195));
  }
  
  public void a(QuestionOptionInfo paramQuestionOptionInfo)
  {
    setSelectBg(false);
    if (paramQuestionOptionInfo == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQuestionOptionInfo.a());
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFaceAndResult getSuccTextSize=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.d());
      localStringBuilder.append(" getSuccTextColor=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.d());
      localStringBuilder.append(" getFailTextSize=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.e());
      localStringBuilder.append(" getFailTextColor=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.f());
      QLog.d("QuestionOptionItemView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionOverlappingImgLayout.a(paramString);
    if (paramBoolean1)
    {
      paramString = AVGameUtil.a(c);
      if (paramString != null) {
        a(paramString);
      } else {
        setBackgroundColor(getResources().getColor(2131165370));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.c());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.d());
      return;
    }
    paramString = AVGameUtil.a(d);
    if (paramString != null) {
      a(paramString);
    } else {
      setBackgroundColor(getResources().getColor(2131165694));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.e());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.f());
  }
  
  public void b()
  {
    setSelectBg(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionOverlappingImgLayout.a();
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackground(paramDrawable);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setConfig(QuestionOptionItemConfig paramQuestionOptionItemConfig)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig = paramQuestionOptionItemConfig;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a() > 0.0F)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a());
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a() != 0)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a());
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setSelectBg(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = AVGameUtil.a(b);
      if (localObject != null) {
        a((Bitmap)localObject);
      } else {
        setBackgroundColor(getResources().getColor(2131165358));
      }
      if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.b() != 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.b());
      }
    }
    else
    {
      localObject = AVGameUtil.a(jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        localObject = new BitmapDrawable((Bitmap)localObject);
      } else {
        localObject = new ColorDrawable(getContext().getResources().getColor(2131167394));
      }
      setSelector((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a() != 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionItemConfig.a());
      }
    }
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Object localObject = AVGameUtil.a(e);
    if (localObject != null)
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
      localStateListDrawable.addState(new int[0], paramDrawable);
      setBackground(localStateListDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionItemView
 * JD-Core Version:    0.7.0.1
 */