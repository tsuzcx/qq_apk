package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class OverlappingImgLayout
  extends RelativeLayout
{
  DecodeTaskCompletionListener a = new OverlappingImgLayout.1(this);
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private String[] f = null;
  private List<ImageView> g = new ArrayList();
  private IFaceDecoder h;
  private UserInfoHandler i;
  private boolean j = true;
  private int k = 1;
  
  public OverlappingImgLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public OverlappingImgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OverlappingImgLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(String paramString, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return c(paramString);
    }
    return b(paramString);
  }
  
  private Bitmap b(String paramString)
  {
    Object localObject = this.h;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OverlappingImgLayout", 2, "mFaceDecoder null");
      }
      return null;
    }
    localObject = ((IFaceDecoder)localObject).getBitmapFromCache(1, paramString, 0, (byte)4);
    if (localObject != null) {
      return localObject;
    }
    if (!this.h.isPausing()) {
      this.h.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private void b()
  {
    removeAllViews();
    if (this.g.size() == 0) {
      return;
    }
    int m = 0;
    int n = 0;
    while (m < this.g.size())
    {
      ImageView localImageView = (ImageView)this.g.get(m);
      int i1 = (int)DisplayUtils.a(getContext(), 1.0F);
      localImageView.setPadding(i1, i1, i1, i1);
      if (!c()) {
        localImageView.setBackgroundResource(2130837713);
      } else {
        localImageView.setBackgroundResource(2130837714);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.c, this.b);
      localLayoutParams.setMargins(n * -1, 0, 0, 0);
      localImageView.setLayoutParams(localLayoutParams);
      addView(localImageView);
      n = this.d;
      m += 1;
    }
  }
  
  private Bitmap c(String paramString)
  {
    if (this.i == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OverlappingImgLayout", 2, "mUserInfoHandler null");
      }
      return null;
    }
    QLog.d("OverlappingImgLayout", 2, "getFaceBitmapByUserInfoHandler 1");
    return this.i.a(paramString, (byte)4, true, false);
  }
  
  private boolean c()
  {
    boolean bool2 = this.j;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void setImgs(int paramInt)
  {
    this.g.clear();
    Object localObject = this.f;
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return;
      }
      int m = 0;
      while (m < this.f.length)
      {
        if (m >= 2) {
          return;
        }
        if (this.j) {
          localObject = new ThemeImageView(getContext());
        } else {
          localObject = new ImageView(getContext());
        }
        ((ImageView)localObject).setImageBitmap(a(this.f[m], paramInt));
        this.g.add(localObject);
        m += 1;
      }
    }
  }
  
  public void a()
  {
    removeAllViews();
    this.g.clear();
  }
  
  public void a(int paramInt1, int paramInt2, UserInfoHandler paramUserInfoHandler)
  {
    this.b = ((int)DisplayUtils.a(getContext(), paramInt1));
    this.c = ((int)DisplayUtils.a(getContext(), paramInt2));
    this.e = ((int)DisplayUtils.a(getContext(), 9.0F));
    setGravity(5);
    this.i = paramUserInfoHandler;
    this.k = 2;
    a(null);
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addUin: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("OverlappingImgLayout", 2, ((StringBuilder)localObject).toString());
      }
      if (this.j) {
        localObject = new ThemeImageView(getContext());
      } else {
        localObject = new ImageView(getContext());
      }
      ((ImageView)localObject).setImageBitmap(a(paramString, 2));
      int m = (int)DisplayUtils.a(getContext(), 1.0F);
      ((ImageView)localObject).setPadding(m, m, m, m);
      if (!c()) {
        ((ImageView)localObject).setBackgroundResource(2130837713);
      } else {
        ((ImageView)localObject).setBackgroundResource(2130837714);
      }
      paramString = new RelativeLayout.LayoutParams(this.c, this.b);
      m = 0;
      paramString.setMargins(0, 0, 0, 0);
      ((ImageView)localObject).setLayoutParams(paramString);
      addView((View)localObject);
      ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
      while (m < this.g.size())
      {
        paramString = (ImageView)this.g.get(m);
        paramString.bringToFront();
        paramString.animate().translationX(-this.e).setDuration(200L).start();
        m += 1;
      }
      this.g.add(localObject);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
    setImgs(this.k);
    b();
  }
  
  public void setNeedNightMode(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.OverlappingImgLayout
 * JD-Core Version:    0.7.0.1
 */