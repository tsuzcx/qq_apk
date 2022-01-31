package com.tencent.mobileqq.activity.contact.newfriend.connections;

import ahjn;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bcws;
import bcwt;
import bdcq;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class OverlappingImgLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private bcws jdField_a_of_type_Bcws;
  bcwt jdField_a_of_type_Bcwt = new ahjn(this);
  private List<ThemeImageView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private int c;
  
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
    if (this.jdField_a_of_type_Bcws == null)
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
      localBitmap = this.jdField_a_of_type_Bcws.a(1, paramString, 0, (byte)4);
      localObject = localBitmap;
    } while (localBitmap != null);
    if (!this.jdField_a_of_type_Bcws.a()) {
      this.jdField_a_of_type_Bcws.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  public static boolean a()
  {
    return ("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId));
  }
  
  public void a()
  {
    removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    int i = 0;
    int j = 0;
    label21:
    ThemeImageView localThemeImageView;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localThemeImageView = (ThemeImageView)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = (int)bdcq.a(getContext(), 1.0F);
      localThemeImageView.setPadding(k, k, k, k);
      if (a()) {
        break label134;
      }
      localThemeImageView.setBackgroundResource(2130837584);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.b, this.jdField_a_of_type_Int);
      localLayoutParams.setMargins(j * -1, 0, 0, 0);
      localThemeImageView.setLayoutParams(localLayoutParams);
      addView(localThemeImageView);
      j = this.c;
      i += 1;
      break label21;
      break;
      label134:
      localThemeImageView.setBackgroundResource(2130837585);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, bcws parambcws)
  {
    this.jdField_a_of_type_Int = ((int)bdcq.a(getContext(), paramInt1));
    this.b = ((int)bdcq.a(getContext(), paramInt2));
    this.c = paramInt3;
    setOrientation(0);
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Bcws = parambcws;
    if (parambcws != null) {
      parambcws.a(this.jdField_a_of_type_Bcwt);
    }
    setImgs();
    a();
  }
  
  public void a(int paramInt1, int paramInt2, String[] paramArrayOfString, bcws parambcws)
  {
    a(paramInt1, paramInt2, (int)bdcq.a(getContext(), 4.0F), paramArrayOfString, parambcws);
  }
  
  public void setImgs()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfJavaLangString.length == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (i < 3)
        {
          ThemeImageView localThemeImageView = new ThemeImageView(getContext());
          localThemeImageView.setImageBitmap(a(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
          this.jdField_a_of_type_JavaUtilList.add(localThemeImageView);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.connections.OverlappingImgLayout
 * JD-Core Version:    0.7.0.1
 */