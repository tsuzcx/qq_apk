package com.tencent.mobileqq.ar.arengine;

import android.graphics.RectF;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchDetail;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchRsp;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSkuItem;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.Rectangle;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;

public class ARMIGObjectClassifyResult
  extends ARCloudObjectClassifyBaseResult
  implements ARCloudObjectClassifyCommonInterface.ARMigObjectClassifyInterface
{
  public static final String a;
  public int a;
  public long a;
  public ARMIGObjectClassifyResult.JDSearchResult a;
  public ARMIGObjectClassifyResult.ObjectBox a;
  public ARMIGObjectClassifyResult.RetrievalClassInfo[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131700952);
  }
  
  public ARMIGObjectClassifyResult()
  {
    super(2, 0);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static ARMIGObjectClassifyResult.JDSearchResult a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    ARMIGObjectClassifyResult.JDSearchResult localJDSearchResult = new ARMIGObjectClassifyResult.JDSearchResult();
    boolean bool = paramJdSearchRsp.jd_search_errorcode.has();
    int j = -1;
    int i;
    if (bool) {
      i = paramJdSearchRsp.jd_search_errorcode.get();
    } else {
      i = -1;
    }
    localJDSearchResult.jdField_a_of_type_Int = i;
    Object localObject1;
    if (paramJdSearchRsp.jd_search_errormsg.has()) {
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
    } else {
      localObject1 = "";
    }
    localJDSearchResult.jdField_a_of_type_JavaLangString = ((String)localObject1);
    if (paramJdSearchRsp.jd_search_detail.has())
    {
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      } else {
        i = -1;
      }
      localJDSearchResult.jdField_b_of_type_Int = i;
      if (((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      } else {
        paramJdSearchRsp = "";
      }
      localJDSearchResult.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      } else {
        paramJdSearchRsp = "";
      }
      localJDSearchResult.d = paramJdSearchRsp;
      Object localObject2;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localJDSearchResult.jdField_a_of_type_AndroidGraphicsRectF;
        bool = paramJdSearchRsp.left.has();
        float f2 = 0.0F;
        if (bool) {
          f1 = paramJdSearchRsp.left.get();
        } else {
          f1 = 0.0F;
        }
        ((RectF)localObject2).left = f1;
        localObject2 = localJDSearchResult.jdField_a_of_type_AndroidGraphicsRectF;
        if (paramJdSearchRsp.top.has()) {
          f1 = paramJdSearchRsp.top.get();
        } else {
          f1 = 0.0F;
        }
        ((RectF)localObject2).top = f1;
        localObject2 = localJDSearchResult.jdField_a_of_type_AndroidGraphicsRectF;
        if (paramJdSearchRsp.right.has()) {
          f1 = paramJdSearchRsp.right.get();
        } else {
          f1 = 0.0F;
        }
        ((RectF)localObject2).right = f1;
        localObject2 = localJDSearchResult.jdField_a_of_type_AndroidGraphicsRectF;
        float f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        i = j;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          i = paramJdSearchRsp.is_user_rectangle.get();
        }
        localJDSearchResult.c = i;
      }
      if (((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      } else {
        paramJdSearchRsp = null;
      }
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem = new ARMIGObjectClassifyResult.JDSearchItem[paramJdSearchRsp.size()];
      }
      if ((paramJdSearchRsp != null) && (paramJdSearchRsp.size() > 0))
      {
        i = 0;
        localObject1 = paramJdSearchRsp.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (JDSearch.JdSkuItem)((Iterator)localObject1).next();
          localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i] = new ARMIGObjectClassifyResult.JDSearchItem();
          ARMIGObjectClassifyResult.JDSearchItem localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
          if (((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.jdField_a_of_type_JavaLangString = paramJdSearchRsp;
          localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
          if (((JDSearch.JdSkuItem)localObject2).image_url.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
          localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
          if (((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.c = paramJdSearchRsp;
          localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
          if (((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.d = paramJdSearchRsp;
          localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
          if (((JDSearch.JdSkuItem)localObject2).sku_price.has()) {
            paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_price.get();
          } else {
            paramJdSearchRsp = "";
          }
          localJDSearchItem.e = paramJdSearchRsp;
          i += 1;
        }
      }
    }
    return localJDSearchResult;
  }
  
  private ARMIGObjectClassifyResult.MIGObjectSearchResult a()
  {
    if (c())
    {
      ARMIGObjectClassifyResult.MIGObjectSearchResult localMIGObjectSearchResult = new ARMIGObjectClassifyResult.MIGObjectSearchResult();
      ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = a();
      if (localRetrievalItem == null) {
        return null;
      }
      ARMIGObjectClassifyResult.ObjectBox localObjectBox = this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox;
      if (localObjectBox != null) {
        localMIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF(localObjectBox.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.c, this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.d);
      } else {
        localMIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      boolean bool1 = localRetrievalItem.jdField_b_of_type_Boolean;
      boolean bool2 = false;
      if (bool1)
      {
        localMIGObjectSearchResult.jdField_a_of_type_JavaLangString = localRetrievalItem.jdField_a_of_type_JavaLangString;
        localMIGObjectSearchResult.jdField_a_of_type_Boolean = false;
        localMIGObjectSearchResult.jdField_a_of_type_Double = localRetrievalItem.jdField_a_of_type_Double;
        return localMIGObjectSearchResult;
      }
      localMIGObjectSearchResult.jdField_a_of_type_JavaLangString = localRetrievalItem.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
      if (localRetrievalItem.jdField_a_of_type_ArrayOfByte != null)
      {
        bool1 = bool2;
        if (localRetrievalItem.jdField_a_of_type_ArrayOfByte.length > 20) {
          bool1 = true;
        }
      }
      localMIGObjectSearchResult.jdField_a_of_type_Boolean = bool1;
      localMIGObjectSearchResult.jdField_a_of_type_Double = localRetrievalItem.jdField_a_of_type_Double;
      localMIGObjectSearchResult.jdField_a_of_type_ArrayOfByte = localRetrievalItem.jdField_a_of_type_ArrayOfByte;
      localMIGObjectSearchResult.jdField_b_of_type_JavaLangString = localRetrievalItem.d;
      localMIGObjectSearchResult.c = localRetrievalItem.e;
      localMIGObjectSearchResult.d = localRetrievalItem.f;
      localMIGObjectSearchResult.jdField_b_of_type_Boolean = localRetrievalItem.jdField_a_of_type_Boolean;
      return localMIGObjectSearchResult;
    }
    return null;
  }
  
  private ARMIGObjectClassifyResult.RetrievalItem a()
  {
    if (!c()) {
      return null;
    }
    Object localObject1 = null;
    int i = 0;
    ARMIGObjectClassifyResult.RetrievalClassInfo[] arrayOfRetrievalClassInfo;
    for (;;)
    {
      arrayOfRetrievalClassInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo;
      if (i >= arrayOfRetrievalClassInfo.length) {
        break;
      }
      int j = 0;
      while ((this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i].jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem != null) && (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i].jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem.length))
      {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i].jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem[j].jdField_a_of_type_Double >= localObject1.jdField_a_of_type_Double) {}
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i].jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem[i];
        }
        j += 1;
        localObject1 = localObject2;
      }
      i += 1;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (arrayOfRetrievalClassInfo.length == 1)
      {
        localObject2 = new ARMIGObjectClassifyResult.RetrievalItem();
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).jdField_b_of_type_Boolean = true;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].jdField_a_of_type_JavaLangString;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).jdField_a_of_type_Double = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].jdField_a_of_type_Double;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].jdField_a_of_type_JavaLangString;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).c = 0;
        ((ARMIGObjectClassifyResult.RetrievalItem)localObject2).g = "";
      }
    }
    return localObject2;
  }
  
  public int a()
  {
    if (!a()) {
      return -1;
    }
    if (c())
    {
      ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = a();
      if ((localRetrievalItem != null) && (localRetrievalItem.jdField_a_of_type_ArrayOfByte != null) && (localRetrievalItem.jdField_a_of_type_ArrayOfByte.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult a()
  {
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult localARMigObjectClassifyExternalRenderResult = new ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult();
    localARMigObjectClassifyExternalRenderResult.jdField_a_of_type_Boolean = true;
    localARMigObjectClassifyExternalRenderResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult;
    localARMigObjectClassifyExternalRenderResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$MIGObjectSearchResult = a();
    localARMigObjectClassifyExternalRenderResult.c = false;
    return localARMigObjectClassifyExternalRenderResult;
  }
  
  public String a()
  {
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = a();
    if (localRetrievalItem == null) {
      return "";
    }
    return localRetrievalItem.g;
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    if (paramARMIGObjectClassifyResult == null) {
      return false;
    }
    paramARMIGObjectClassifyResult = paramARMIGObjectClassifyResult.a();
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = a();
    if (paramARMIGObjectClassifyResult != null)
    {
      if (localRetrievalItem == null) {
        return false;
      }
      if (paramARMIGObjectClassifyResult.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localRetrievalItem.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public byte[] a()
  {
    ARMIGObjectClassifyResult.MIGObjectSearchResult localMIGObjectSearchResult = a();
    if ((localMIGObjectSearchResult != null) && (localMIGObjectSearchResult.jdField_a_of_type_Boolean)) {
      return localMIGObjectSearchResult.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      ARMIGObjectClassifyResult.JDSearchResult localJDSearchResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult;
      if ((localJDSearchResult != null) && (localJDSearchResult.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem.length > 0)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0))
    {
      ARMIGObjectClassifyResult.RetrievalClassInfo[] arrayOfRetrievalClassInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo;
      if ((arrayOfRetrievalClassInfo != null) && (arrayOfRetrievalClassInfo.length > 0) && (!arrayOfRetrievalClassInfo[0].jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d()
  {
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = a();
    boolean bool = false;
    if (localRetrievalItem == null) {
      return false;
    }
    if (localRetrievalItem.c == 1) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (c())
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n {migObjectClassifyResult:");
      localStringBuilder2.append(this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].toString());
      localStringBuilder2.append("} \n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (b())
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n {jdSearchResult:");
      localStringBuilder2.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.toString());
      localStringBuilder2.append("}\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult
 * JD-Core Version:    0.7.0.1
 */