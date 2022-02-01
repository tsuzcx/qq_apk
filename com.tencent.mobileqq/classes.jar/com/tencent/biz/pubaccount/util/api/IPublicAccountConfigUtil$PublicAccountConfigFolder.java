package com.tencent.biz.pubaccount.util.api;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;

public class IPublicAccountConfigUtil$PublicAccountConfigFolder
{
  public int a;
  public Drawable a;
  public String a;
  public String b = "";
  public String c = "";
  
  public IPublicAccountConfigUtil$PublicAccountConfigFolder()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  public IPublicAccountConfigUtil$PublicAccountConfigFolder(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramContext.getString(paramInt2);
    this.b = "";
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(paramInt3);
      label66:
      this.c = a(paramInt1);
      return;
    }
    catch (Exception paramAppInterface)
    {
      break label66;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "";
        }
        return String.valueOf(AppConstants.KANDIAN_MERGE_UIN);
      }
      return String.valueOf(AppConstants.NEW_KANDIAN_UIN);
    }
    return String.valueOf(7210);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder
 * JD-Core Version:    0.7.0.1
 */