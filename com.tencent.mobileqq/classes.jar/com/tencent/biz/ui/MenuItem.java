package com.tencent.biz.ui;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;

public class MenuItem
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  String jdField_a_of_type_JavaLangString;
  private List<MenuItem> jdField_a_of_type_JavaUtilList = null;
  String b;
  String c;
  String d;
  private String e;
  private String f;
  
  public MenuItem(String paramString1, String paramString2, Drawable paramDrawable, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.e = paramString2;
    this.f = paramString1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public MenuItem a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return null;
    }
    return (MenuItem)localList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<MenuItem> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(MenuItem paramMenuItem)
  {
    if (paramMenuItem == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
  }
  
  public void a(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo.logo_url.has()) {
      this.jdField_a_of_type_JavaLangString = paramButtonInfo.logo_url.get();
    }
    if (paramButtonInfo.texture_url.has()) {
      this.d = paramButtonInfo.texture_url.get();
    }
    if (paramButtonInfo.bg_colors.has())
    {
      paramButtonInfo = paramButtonInfo.bg_colors.get().split("\\|");
      if (paramButtonInfo.length > 0) {
        this.b = paramButtonInfo[0];
      }
      if (paramButtonInfo.length > 1) {
        this.c = paramButtonInfo[1];
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList != null;
  }
  
  public int b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public String b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.MenuItem
 * JD-Core Version:    0.7.0.1
 */