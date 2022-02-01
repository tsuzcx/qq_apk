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
  private View a;
  private TextView b;
  private TextView c;
  private URLDrawable d;
  private String e;
  
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
    float f = ViewUtils.dip2px(255.0F);
    f = GameRoomViewLayoutParamsDef.v / f;
    this.a = View.inflate(getContext(), 2131624293, null);
    Object localObject = new FrameLayout.LayoutParams((int)(ViewUtils.dip2px(205.0F) * f), GameRoomViewLayoutParamsDef.v);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.a, (ViewGroup.LayoutParams)localObject);
    int i = (int)(ViewUtils.dip2px(33.0F) * f);
    this.a.setPadding(i, 0, i, 0);
    this.b = ((TextView)findViewById(2131439121));
    localObject = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(ViewUtils.dip2px(26.0F) * f));
    ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(((ViewGroup.MarginLayoutParams)localObject).height * 5.384615F));
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(ViewUtils.dip2px(106.0F) * f));
    this.c = ((TextView)findViewById(2131431757));
  }
  
  public void a(GameItem paramGameItem)
  {
    if (paramGameItem != null)
    {
      if (!TextUtils.isEmpty(paramGameItem.s)) {
        this.b.setBackgroundDrawable(URLDrawable.getDrawable(paramGameItem.s, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a));
      } else if (paramGameItem.b != null) {
        this.b.setText(paramGameItem.b);
      }
      Object localObject = this.e;
      if ((localObject != null) && (((String)localObject).equals(paramGameItem.d)))
      {
        localObject = this.d;
        if (localObject != null)
        {
          this.a.setBackgroundDrawable((Drawable)localObject);
          break label174;
        }
      }
      localObject = AVGameUtil.c("avgame_list_card_bg@3x.png");
      if (localObject != null) {
        localObject = new BitmapDrawable((Bitmap)localObject);
      } else {
        localObject = URLDrawableHelperConstants.a;
      }
      if (!TextUtils.isEmpty(paramGameItem.d))
      {
        this.d = URLDrawable.getDrawable(paramGameItem.d, (Drawable)localObject, (Drawable)localObject);
        this.a.setBackgroundDrawable(this.d);
      }
      else
      {
        this.a.setBackgroundDrawable((Drawable)localObject);
      }
      this.e = paramGameItem.d;
      label174:
      if (!TextUtils.isEmpty(paramGameItem.c)) {
        this.c.setText(paramGameItem.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameCardView
 * JD-Core Version:    0.7.0.1
 */