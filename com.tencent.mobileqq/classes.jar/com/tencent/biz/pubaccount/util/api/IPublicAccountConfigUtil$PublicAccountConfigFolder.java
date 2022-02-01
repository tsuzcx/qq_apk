package com.tencent.biz.pubaccount.util.api;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;

public class IPublicAccountConfigUtil$PublicAccountConfigFolder
{
  public int a = 0;
  public String b = "";
  public String c = "";
  public Drawable d = null;
  public String e = "";
  
  public IPublicAccountConfigUtil$PublicAccountConfigFolder() {}
  
  public IPublicAccountConfigUtil$PublicAccountConfigFolder(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramContext.getString(paramInt2);
    this.c = "";
    try
    {
      this.d = paramContext.getResources().getDrawable(paramInt3);
      label66:
      this.e = a(paramInt1);
      return;
    }
    catch (Exception paramAppInterface)
    {
      break label66;
    }
  }
  
  public int a()
  {
    return this.a;
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
    this.d = paramDrawable;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public Drawable c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder
 * JD-Core Version:    0.7.0.1
 */