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
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
    f = GameRoomViewLayoutParamsDef.k / f;
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131558777, null);
    Object localObject = new FrameLayout.LayoutParams((int)(ViewUtils.a(205.0F) * f), GameRoomViewLayoutParamsDef.k);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    int i = (int)(ViewUtils.a(33.0F) * f);
    this.jdField_a_of_type_AndroidViewView.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372115));
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(ViewUtils.a(26.0F) * f));
    ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(5.384615F * ((ViewGroup.MarginLayoutParams)localObject).height));
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(f * ViewUtils.a(106.0F)));
    this.b = ((TextView)findViewById(2131365699));
  }
  
  public void a(GameItem paramGameItem)
  {
    if (paramGameItem != null)
    {
      if (TextUtils.isEmpty(paramGameItem.m)) {
        break label95;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(URLDrawable.getDrawable(paramGameItem.m, URLDrawableHelper.TRANSPARENT, URLDrawableHelper.TRANSPARENT));
    }
    while ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramGameItem.c)) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      if (!TextUtils.isEmpty(paramGameItem.b)) {
        this.b.setText(paramGameItem.b);
      }
      return;
      label95:
      if (paramGameItem.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramGameItem.jdField_a_of_type_JavaLangString);
      }
    }
    Object localObject = AVGameUtils.a("avgame_list_card_bg@3x.png");
    if (localObject != null)
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      label135:
      if (TextUtils.isEmpty(paramGameItem.c)) {
        break label187;
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramGameItem.c, (Drawable)localObject, (Drawable)localObject);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramGameItem.c;
      break;
      localObject = URLDrawableHelper.TRANSPARENT;
      break label135;
      label187:
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameCardView
 * JD-Core Version:    0.7.0.1
 */