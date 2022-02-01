package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
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
  extends LinearLayout
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
  
  private void a()
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
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
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
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfJavaLangString.length == 0)) {
      return;
    }
    int i = 0;
    label27:
    if ((i < this.jdField_a_of_type_ArrayOfJavaLangString.length) && (i < 3)) {
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
  
  private String[] a(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((Long)paramList.get(i)).toString();
      i += 1;
    }
    return arrayOfString;
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
    return this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.a(paramString, (byte)3);
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
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    a(this.d);
    a();
  }
  
  public void setNeedNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout
 * JD-Core Version:    0.7.0.1
 */