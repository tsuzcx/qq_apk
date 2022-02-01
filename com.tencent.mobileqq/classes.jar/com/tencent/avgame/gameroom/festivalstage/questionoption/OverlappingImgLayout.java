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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class OverlappingImgLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 0;
  private UserInfoHandler jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new OverlappingImgLayout.1(this);
  private List<ImageView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 1;
  
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
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OverlappingImgLayout", 2, "mFaceDecoder null");
      }
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString, 0, (byte)4);
      localObject = localBitmap;
    } while (localBitmap != null);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private Bitmap a(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return a(paramString);
    }
    return b(paramString);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfJavaLangString.length == 0)) {
      return;
    }
    int i = 0;
    label27:
    if ((i < this.jdField_a_of_type_ArrayOfJavaLangString.length) && (i < 2)) {
      if (!this.jdField_a_of_type_Boolean) {
        break label93;
      }
    }
    label93:
    for (Object localObject = new ThemeImageView(getContext());; localObject = new ImageView(getContext()))
    {
      ((ImageView)localObject).setImageBitmap(a(this.jdField_a_of_type_ArrayOfJavaLangString[i], paramInt));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      i += 1;
      break label27;
      break;
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
      return false;
    }
    return true;
  }
  
  private Bitmap b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OverlappingImgLayout", 2, "mUserInfoHandler null");
      }
      return null;
    }
    QLog.d("OverlappingImgLayout", 2, "getFaceBitmapByUserInfoHandler 1");
    return this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.a(paramString, (byte)4, true, false);
  }
  
  private void b()
  {
    removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    int i = 0;
    int j = 0;
    label21:
    ImageView localImageView;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localImageView = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = (int)DisplayUtils.a(getContext(), 1.0F);
      localImageView.setPadding(k, k, k, k);
      if (a()) {
        break label135;
      }
      localImageView.setBackgroundResource(2130837601);
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
      localLayoutParams.setMargins(j * -1, 0, 0, 0);
      localImageView.setLayoutParams(localLayoutParams);
      addView(localImageView);
      j = this.c;
      i += 1;
      break label21;
      break;
      label135:
      localImageView.setBackgroundResource(2130837602);
    }
  }
  
  public void a()
  {
    removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt1, int paramInt2, UserInfoHandler paramUserInfoHandler)
  {
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(getContext(), paramInt1));
    this.b = ((int)DisplayUtils.a(getContext(), paramInt2));
    this.d = ((int)DisplayUtils.a(getContext(), 9.0F));
    setGravity(5);
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = paramUserInfoHandler;
    this.e = 2;
    a(null);
  }
  
  public void a(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OverlappingImgLayout", 2, "addUin: " + paramString);
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new ThemeImageView(getContext());
      ((ImageView)localObject).setImageBitmap(a(paramString, 2));
      int j = (int)DisplayUtils.a(getContext(), 1.0F);
      ((ImageView)localObject).setPadding(j, j, j, j);
      if (a()) {
        break label248;
      }
      ((ImageView)localObject).setBackgroundResource(2130837601);
    }
    for (;;)
    {
      paramString = new RelativeLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
      paramString.setMargins(0, 0, 0, 0);
      ((ImageView)localObject).setLayoutParams(paramString);
      addView((View)localObject);
      ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramString = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
        paramString.bringToFront();
        paramString.animate().translationX(-this.d).setDuration(200L).start();
        i += 1;
      }
      localObject = new ImageView(getContext());
      break;
      label248:
      ((ImageView)localObject).setBackgroundResource(2130837602);
    }
    this.jdField_a_of_type_JavaUtilList.add(localObject);
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    a(this.e);
    b();
  }
  
  public void setNeedNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.OverlappingImgLayout
 * JD-Core Version:    0.7.0.1
 */