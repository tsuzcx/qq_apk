package com.tencent.mobileqq.ar.arengine;

import android.graphics.RectF;
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
  public int a;
  public long a;
  public ARMIGObjectClassifyResult.JDSearchResult a;
  public ARMIGObjectClassifyResult.ObjectBox a;
  public String a;
  public ARMIGObjectClassifyResult.RetrievalClassInfo[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d = "";
  
  public ARMIGObjectClassifyResult()
  {
    super(2, 0);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static ARMIGObjectClassifyResult.JDSearchResult a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    float f2 = 0.0F;
    ARMIGObjectClassifyResult.JDSearchResult localJDSearchResult = new ARMIGObjectClassifyResult.JDSearchResult();
    int i;
    Object localObject1;
    label57:
    label106:
    Object localObject2;
    label132:
    label158:
    float f1;
    label212:
    label243:
    ARMIGObjectClassifyResult.JDSearchItem localJDSearchItem;
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localJDSearchResult.jdField_a_of_type_Int = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label633;
      }
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
      localJDSearchResult.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (!paramJdSearchRsp.jd_search_detail.has()) {
        break label707;
      }
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (!((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        break label640;
      }
      i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      localJDSearchResult.jdField_b_of_type_Int = i;
      if (!((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        break label645;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      localJDSearchResult.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      if (!((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        break label651;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      localJDSearchResult.d = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localJDSearchResult.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.left.has()) {
          break label657;
        }
        f1 = paramJdSearchRsp.left.get();
        ((RectF)localObject2).left = f1;
        localObject2 = localJDSearchResult.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.top.has()) {
          break label662;
        }
        f1 = paramJdSearchRsp.top.get();
        ((RectF)localObject2).top = f1;
        localObject2 = localJDSearchResult.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.right.has()) {
          break label667;
        }
        f1 = paramJdSearchRsp.right.get();
        label274:
        ((RectF)localObject2).right = f1;
        localObject2 = localJDSearchResult.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = f2;
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
      if (!((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        break label672;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      label360:
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem = new ARMIGObjectClassifyResult.JDSearchItem[paramJdSearchRsp.size()];
      }
      if ((paramJdSearchRsp == null) || (paramJdSearchRsp.size() <= 0)) {
        break label707;
      }
      localObject1 = paramJdSearchRsp.iterator();
      i = 0;
      label410:
      if (!((Iterator)localObject1).hasNext()) {
        break label707;
      }
      localObject2 = (JDSearch.JdSkuItem)((Iterator)localObject1).next();
      localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i] = new ARMIGObjectClassifyResult.JDSearchItem();
      localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
      if (!((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
        break label677;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
      label475:
      localJDSearchItem.jdField_a_of_type_JavaLangString = paramJdSearchRsp;
      localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
      if (!((JDSearch.JdSkuItem)localObject2).image_url.has()) {
        break label683;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
      label510:
      localJDSearchItem.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
        break label689;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
      label545:
      localJDSearchItem.c = paramJdSearchRsp;
      localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
        break label695;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
      label580:
      localJDSearchItem.d = paramJdSearchRsp;
      localJDSearchItem = localJDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_price.has()) {
        break label701;
      }
    }
    label640:
    label645:
    label651:
    label657:
    label662:
    label667:
    label672:
    label677:
    label683:
    label689:
    label695:
    label701:
    for (paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_price.get();; paramJdSearchRsp = "")
    {
      localJDSearchItem.e = paramJdSearchRsp;
      i += 1;
      break label410;
      i = -1;
      break;
      label633:
      localObject1 = "";
      break label57;
      i = -1;
      break label106;
      paramJdSearchRsp = "";
      break label132;
      paramJdSearchRsp = "";
      break label158;
      f1 = 0.0F;
      break label212;
      f1 = 0.0F;
      break label243;
      f1 = 0.0F;
      break label274;
      paramJdSearchRsp = null;
      break label360;
      paramJdSearchRsp = "";
      break label475;
      paramJdSearchRsp = "";
      break label510;
      paramJdSearchRsp = "";
      break label545;
      paramJdSearchRsp = "";
      break label580;
    }
    label707:
    return localJDSearchResult;
  }
  
  private ARMIGObjectClassifyResult.MIGObjectSearchResult a()
  {
    boolean bool2 = false;
    if (c())
    {
      ARMIGObjectClassifyResult.MIGObjectSearchResult localMIGObjectSearchResult = new ARMIGObjectClassifyResult.MIGObjectSearchResult();
      ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = a();
      if (localRetrievalItem == null) {
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox != null)
      {
        localMIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.c, this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ObjectBox.d);
        if (!localRetrievalItem.jdField_b_of_type_Boolean) {
          break label127;
        }
        localMIGObjectSearchResult.jdField_a_of_type_JavaLangString = localRetrievalItem.jdField_a_of_type_JavaLangString;
        localMIGObjectSearchResult.jdField_a_of_type_Boolean = false;
        localMIGObjectSearchResult.jdField_a_of_type_Double = localRetrievalItem.jdField_a_of_type_Double;
      }
      for (;;)
      {
        return localMIGObjectSearchResult;
        localMIGObjectSearchResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        break;
        label127:
        localMIGObjectSearchResult.jdField_a_of_type_JavaLangString = localRetrievalItem.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource.jdField_a_of_type_JavaLangString;
        boolean bool1 = bool2;
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
      }
    }
    return null;
  }
  
  private ARMIGObjectClassifyResult.RetrievalItem a()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!c()) {}
    do
    {
      do
      {
        return localObject2;
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo.length)
        {
          int j = 0;
          while ((this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i].jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem != null) && (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i].jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem.length))
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[i].jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalItem[j].jdField_a_of_type_Double >= ((ARMIGObjectClassifyResult.RetrievalItem)localObject1).jdField_a_of_type_Double) {}
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
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
    } while (this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo.length != 1);
    localObject1 = new ARMIGObjectClassifyResult.RetrievalItem();
    ((ARMIGObjectClassifyResult.RetrievalItem)localObject1).jdField_b_of_type_Boolean = true;
    ((ARMIGObjectClassifyResult.RetrievalItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].jdField_a_of_type_JavaLangString;
    ((ARMIGObjectClassifyResult.RetrievalItem)localObject1).jdField_a_of_type_Double = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].jdField_a_of_type_Double;
    ((ARMIGObjectClassifyResult.RetrievalItem)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].jdField_a_of_type_JavaLangString;
    ((ARMIGObjectClassifyResult.RetrievalItem)localObject1).c = 0;
    ((ARMIGObjectClassifyResult.RetrievalItem)localObject1).g = "";
    return localObject1;
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
    return "";
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    if (paramARMIGObjectClassifyResult == null) {}
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem;
    do
    {
      return false;
      paramARMIGObjectClassifyResult = paramARMIGObjectClassifyResult.a();
      localRetrievalItem = a();
    } while ((paramARMIGObjectClassifyResult == null) || (localRetrievalItem == null) || (!paramARMIGObjectClassifyResult.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localRetrievalItem.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public byte[] a()
  {
    ARMIGObjectClassifyResult.MIGObjectSearchResult localMIGObjectSearchResult = a();
    if ((localMIGObjectSearchResult != null) && (localMIGObjectSearchResult.jdField_a_of_type_Boolean)) {
      return localMIGObjectSearchResult.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public String b()
  {
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = a();
    if (localRetrievalItem == null) {
      return "";
    }
    return localRetrievalItem.g;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchItem.length > 0);
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Int == 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo.length > 0)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].jdField_a_of_type_JavaLangString.equalsIgnoreCase("其他")) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean d()
  {
    boolean bool = true;
    ARMIGObjectClassifyResult.RetrievalItem localRetrievalItem = a();
    if (localRetrievalItem == null) {
      return false;
    }
    if (localRetrievalItem.c == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (c()) {
      localStringBuilder.append("\n {migObjectClassifyResult:" + this.jdField_a_of_type_ArrayOfComTencentMobileqqArArengineARMIGObjectClassifyResult$RetrievalClassInfo[0].toString() + "} \n");
    }
    if (b()) {
      localStringBuilder.append("\n {jdSearchResult:" + this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$JDSearchResult.toString() + "}\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult
 * JD-Core Version:    0.7.0.1
 */