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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
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
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private Bitmap a(String paramString, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return b(paramString);
    }
    return a(paramString);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (i >= 2) {
          return;
        }
        if (this.jdField_a_of_type_Boolean) {
          localObject = new ThemeImageView(getContext());
        } else {
          localObject = new ImageView(getContext());
        }
        ((ImageView)localObject).setImageBitmap(a(this.jdField_a_of_type_ArrayOfJavaLangString[i], paramInt));
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        i += 1;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
      bool1 = true;
    }
    return bool1;
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
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = (int)DisplayUtils.a(getContext(), 1.0F);
      localImageView.setPadding(k, k, k, k);
      if (!a()) {
        localImageView.setBackgroundResource(2130837689);
      } else {
        localImageView.setBackgroundResource(2130837690);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
      localLayoutParams.setMargins(j * -1, 0, 0, 0);
      localImageView.setLayoutParams(localLayoutParams);
      addView(localImageView);
      j = this.c;
      i += 1;
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
      if (this.jdField_a_of_type_Boolean) {
        localObject = new ThemeImageView(getContext());
      } else {
        localObject = new ImageView(getContext());
      }
      ((ImageView)localObject).setImageBitmap(a(paramString, 2));
      int i = (int)DisplayUtils.a(getContext(), 1.0F);
      ((ImageView)localObject).setPadding(i, i, i, i);
      if (!a()) {
        ((ImageView)localObject).setBackgroundResource(2130837689);
      } else {
        ((ImageView)localObject).setBackgroundResource(2130837690);
      }
      paramString = new RelativeLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
      i = 0;
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
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.OverlappingImgLayout
 * JD-Core Version:    0.7.0.1
 */