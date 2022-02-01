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
  private static String a = "avgame_click_btn_normal@2x.png";
  private static String b = "avgame_click_btn_select@2x.png";
  private static String c = "avgame_click_btn_succ@2x.png";
  private static String d = "avgame_click_btn_fail@2x.png";
  private static String e = "avgame_click_btn_press@2x.png";
  private TextView f;
  private OverlappingImgLayout g;
  private FrameLayout h;
  private QuestionOptionItemConfig i = null;
  private boolean j = false;
  
  public QuestionOptionItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QuestionOptionItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void setBackground(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.h.setBackground(new BitmapDrawable(paramBitmap));
      return;
    }
    this.h.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
  
  public void a()
  {
    this.f = ((TextView)findViewById(2131439683));
    Object localObject = this.i;
    if (localObject == null)
    {
      this.i = new QuestionOptionItemConfig(14.0F, Color.parseColor("#9A7030"), Color.parseColor("#FFF5E6"), 14, Color.parseColor("#FFFFFF"), 14, Color.parseColor("#FFFFFF"));
    }
    else
    {
      if ((!this.j) && (((QuestionOptionItemConfig)localObject).a() > 0.0F)) {
        this.f.setTextSize(this.i.a());
      }
      if ((!this.j) && (this.i.b() != 0)) {
        this.f.setTextColor(this.i.b());
      }
    }
    this.g = ((OverlappingImgLayout)findViewById(2131439684));
    localObject = (UserInfoHandler)((AppInterface)IGameEngine.K()).getBusinessHandler(HandlerFactory.b);
    this.g.a(14, 14, (UserInfoHandler)localObject);
    this.h = ((FrameLayout)findViewById(2131439682));
  }
  
  public void a(QuestionOptionInfo paramQuestionOptionInfo)
  {
    setSelectBg(false);
    if (paramQuestionOptionInfo == null)
    {
      this.f.setText("");
      return;
    }
    this.f.setText(paramQuestionOptionInfo.a());
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFaceAndResult getSuccTextSize=");
      localStringBuilder.append(this.i.e());
      localStringBuilder.append(" getSuccTextColor=");
      localStringBuilder.append(this.i.e());
      localStringBuilder.append(" getFailTextSize=");
      localStringBuilder.append(this.i.f());
      localStringBuilder.append(" getFailTextColor=");
      localStringBuilder.append(this.i.g());
      QLog.d("QuestionOptionItemView", 2, localStringBuilder.toString());
    }
    this.j = paramBoolean2;
    this.g.a(paramString);
    if (paramBoolean1)
    {
      paramString = AVGameUtil.c(c);
      if (paramString != null) {
        setBackground(paramString);
      } else {
        setBackgroundColor(getResources().getColor(2131165643));
      }
      this.f.setTextSize(this.i.d());
      this.f.setTextColor(this.i.e());
      return;
    }
    paramString = AVGameUtil.c(d);
    if (paramString != null) {
      setBackground(paramString);
    } else {
      setBackgroundColor(getResources().getColor(2131166157));
    }
    this.f.setTextSize(this.i.f());
    this.f.setTextColor(this.i.g());
  }
  
  public void b()
  {
    setSelectBg(false);
    this.g.a();
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.h.setBackground(paramDrawable);
      return;
    }
    this.h.setBackgroundDrawable(paramDrawable);
  }
  
  public void setConfig(QuestionOptionItemConfig paramQuestionOptionItemConfig)
  {
    this.i = paramQuestionOptionItemConfig;
    if ((!this.j) && (this.i.a() > 0.0F)) {
      this.f.setTextSize(this.i.a());
    }
    if ((!this.j) && (this.i.b() != 0)) {
      this.f.setTextColor(this.i.b());
    }
    this.j = false;
  }
  
  public void setSelectBg(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = AVGameUtil.c(b);
      if (localObject != null) {
        setBackground((Bitmap)localObject);
      } else {
        setBackgroundColor(getResources().getColor(2131165604));
      }
      if (this.i.c() != 0) {
        this.f.setTextColor(this.i.c());
      }
    }
    else
    {
      localObject = AVGameUtil.c(a);
      if (localObject != null) {
        localObject = new BitmapDrawable((Bitmap)localObject);
      } else {
        localObject = new ColorDrawable(getContext().getResources().getColor(2131168464));
      }
      setSelector((Drawable)localObject);
      if (this.i.b() != 0) {
        this.f.setTextColor(this.i.b());
      }
    }
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Object localObject = AVGameUtil.c(e);
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