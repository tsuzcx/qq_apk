package com.tencent.mobileqq.activity.contact.connections;

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
  private int jdField_a_of_type_Int = 0;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new OverlappingImgLayout.1(this);
  private List<ImageView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private int b = 0;
  private int c = 0;
  private int d = 1;
  
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
    if (paramInt != 1) {
      return null;
    }
    return a(paramString);
  }
  
  private void a()
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
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
      localLayoutParams.setMargins(j * -1, 0, 0, 0);
      localImageView.setLayoutParams(localLayoutParams);
      addView(localImageView);
      j = this.c;
      i += 1;
    }
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
        if (i >= 3) {
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(getContext(), paramInt1));
    this.b = ((int)DisplayUtils.a(getContext(), paramInt2));
    this.c = paramInt3;
    setOrientation(0);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    if (paramIFaceDecoder != null) {
      paramIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    }
    this.d = 1;
    a(paramArrayOfString);
  }
  
  public void a(int paramInt1, int paramInt2, String[] paramArrayOfString, IFaceDecoder paramIFaceDecoder)
  {
    a(paramInt1, paramInt2, (int)DisplayUtils.a(getContext(), 4.0F), paramArrayOfString, paramIFaceDecoder);
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    a(this.d);
    a();
  }
  
  public void setNeedNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout
 * JD-Core Version:    0.7.0.1
 */