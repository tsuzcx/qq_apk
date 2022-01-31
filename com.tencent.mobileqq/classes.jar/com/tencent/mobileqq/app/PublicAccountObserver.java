package com.tencent.mobileqq.app;

import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import zrc;
import zrd;

public class PublicAccountObserver
  implements BusinessObserver
{
  public void a(int paramInt) {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, PaConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public void c(boolean paramBoolean, int paramInt) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (100 == paramInt)
    {
      paramObject = (zrd)paramObject;
      a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean);
    }
    do
    {
      return;
      if (101 == paramInt)
      {
        if ((paramObject instanceof zrc))
        {
          paramObject = (zrc)paramObject;
          b(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          c(paramBoolean, ((Integer)paramObject).intValue());
          return;
        }
        a(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (102 == paramInt)
      {
        if ((paramObject instanceof zrc))
        {
          paramObject = (zrc)paramObject;
          a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
          return;
        }
        b(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (103 == paramInt)
      {
        t_();
        return;
      }
      if (104 == paramInt)
      {
        a(paramBoolean);
        return;
      }
      if (105 == paramInt)
      {
        a(((Integer)paramObject).intValue());
        return;
      }
      if (106 == paramInt)
      {
        a(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      if (109 == paramInt)
      {
        a(paramBoolean, (PaConfigAttr.PaConfigInfo)paramObject);
        return;
      }
      if (108 == paramInt)
      {
        b(paramBoolean, ((Integer)paramObject).intValue());
        return;
      }
    } while (110 != paramInt);
    a(paramBoolean, (ArrayList)paramObject);
  }
  
  public void t_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */