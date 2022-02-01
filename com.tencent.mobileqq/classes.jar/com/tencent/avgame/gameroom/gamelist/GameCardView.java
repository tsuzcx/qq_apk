package com.tencent.avgame.gameroom.gamelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;

public class GameCardView
  extends FrameLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  private TextView b;
  
  public GameCardView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GameCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public GameCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    float f = ViewUtils.a(255.0F);
    f = GameRoomViewLayoutParamsDef.v / f;
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131558676, null);
    Object localObject = new FrameLayout.LayoutParams((int)(ViewUtils.a(205.0F) * f), GameRoomViewLayoutParamsDef.v);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    int i = (int)(ViewUtils.a(33.0F) * f);
    this.jdField_a_of_type_AndroidViewView.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371697));
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(ViewUtils.a(26.0F) * f));
    ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(((ViewGroup.MarginLayoutParams)localObject).height * 5.384615F));
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(ViewUtils.a(106.0F) * f));
    this.b = ((TextView)findViewById(2131365536));
  }
  
  public void a(GameItem paramGameItem)
  {
    if (paramGameItem != null)
    {
      if (!TextUtils.isEmpty(paramGameItem.m)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(URLDrawable.getDrawable(paramGameItem.m, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a));
      } else if (paramGameItem.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramGameItem.jdField_a_of_type_JavaLangString);
      }
      Object localObject = this.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equals(paramGameItem.c)))
      {
        localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
        if (localObject != null)
        {
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          break label174;
        }
      }
      localObject = AVGameUtil.a("avgame_list_card_bg@3x.png");
      if (localObject != null) {
        localObject = new BitmapDrawable((Bitmap)localObject);
      } else {
        localObject = URLDrawableHelperConstants.a;
      }
      if (!TextUtils.isEmpty(paramGameItem.c))
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramGameItem.c, (Drawable)localObject, (Drawable)localObject);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      }
      this.jdField_a_of_type_JavaLangString = paramGameItem.c;
      label174:
      if (!TextUtils.isEmpty(paramGameItem.b)) {
        this.b.setText(paramGameItem.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameCardView
 * JD-Core Version:    0.7.0.1
 */