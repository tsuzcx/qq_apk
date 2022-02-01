package com.tencent.avgame.gamelobby.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class OverlappingImgLayout
  extends LinearLayout
{
  DecodeTaskCompletionListener a = new OverlappingImgLayout.1(this);
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private String[] e = null;
  private List<ImageView> f = new ArrayList();
  private IFaceDecoder g;
  private boolean h = true;
  private int i = 1;
  
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
  
  private Bitmap a(String paramString)
  {
    Object localObject = this.g;
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
    if (!this.g.isPausing()) {
      this.g.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private Bitmap a(String paramString, int paramInt)
  {
    if (paramInt != 1) {
      return null;
    }
    return a(paramString);
  }
  
  private void a()
  {
    removeAllViews();
    if (this.f.size() == 0) {
      return;
    }
    int j = 0;
    int k = 0;
    while (j < this.f.size())
    {
      ImageView localImageView = (ImageView)this.f.get(j);
      int m = (int)DisplayUtils.a(getContext(), 1.0F);
      localImageView.setPadding(m, m, m, m);
      if (!b()) {
        localImageView.setBackgroundResource(2130837713);
      } else {
        localImageView.setBackgroundResource(2130837714);
      }
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.c, this.b);
      localLayoutParams.setMargins(k * -1, 0, 0, 0);
      localImageView.setLayoutParams(localLayoutParams);
      addView(localImageView);
      k = this.d;
      j += 1;
    }
  }
  
  private String[] a(List<Long> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      String[] arrayOfString = new String[paramList.size()];
      int j = 0;
      while (j < paramList.size())
      {
        arrayOfString[j] = ((Long)paramList.get(j)).toString();
        j += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  private boolean b()
  {
    boolean bool2 = this.h;
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
    this.f.clear();
    Object localObject = this.e;
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return;
      }
      int j = 0;
      while (j < this.e.length)
      {
        if (j >= 3) {
          return;
        }
        if (this.h) {
          localObject = new ThemeImageView(getContext());
        } else {
          localObject = new ImageView(getContext());
        }
        ((ImageView)localObject).setImageBitmap(a(this.e[j], paramInt));
        this.f.add(localObject);
        j += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, IFaceDecoder paramIFaceDecoder)
  {
    this.b = ((int)DisplayUtils.a(getContext(), paramInt1));
    this.c = ((int)DisplayUtils.a(getContext(), paramInt2));
    this.d = paramInt3;
    setOrientation(0);
    this.g = paramIFaceDecoder;
    if (paramIFaceDecoder != null) {
      paramIFaceDecoder.setDecodeTaskCompletionListener(this.a);
    }
    this.i = 1;
    a(paramArrayOfString);
  }
  
  public void a(int paramInt1, int paramInt2, List<Long> paramList, IFaceDecoder paramIFaceDecoder)
  {
    a(paramInt1, paramInt2, a(paramList), paramIFaceDecoder);
  }
  
  public void a(int paramInt1, int paramInt2, String[] paramArrayOfString, IFaceDecoder paramIFaceDecoder)
  {
    a(paramInt1, paramInt2, (int)DisplayUtils.a(getContext(), 4.0F), paramArrayOfString, paramIFaceDecoder);
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.e = paramArrayOfString;
    setImgs(this.i);
    a();
  }
  
  public void setNeedNightMode(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.view.OverlappingImgLayout
 * JD-Core Version:    0.7.0.1
 */