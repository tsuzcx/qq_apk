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

public class amyk
  extends amwq
  implements amws
{
  public static final String a;
  public int a;
  public long a;
  public amyn a;
  public amyq a;
  public amyr[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131701100);
  }
  
  public amyk()
  {
    super(2, 0);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static amyn a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    float f2 = 0.0F;
    amyn localamyn = new amyn();
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
    amym localamym;
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localamyn.jdField_a_of_type_Int = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label633;
      }
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
      localamyn.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (!paramJdSearchRsp.jd_search_detail.has()) {
        break label707;
      }
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (!((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        break label640;
      }
      i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      localamyn.jdField_b_of_type_Int = i;
      if (!((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        break label645;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      localamyn.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      if (!((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        break label651;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      localamyn.d = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localamyn.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.left.has()) {
          break label657;
        }
        f1 = paramJdSearchRsp.left.get();
        ((RectF)localObject2).left = f1;
        localObject2 = localamyn.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.top.has()) {
          break label662;
        }
        f1 = paramJdSearchRsp.top.get();
        ((RectF)localObject2).top = f1;
        localObject2 = localamyn.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.right.has()) {
          break label667;
        }
        f1 = paramJdSearchRsp.right.get();
        label274:
        ((RectF)localObject2).right = f1;
        localObject2 = localamyn.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        i = j;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          i = paramJdSearchRsp.is_user_rectangle.get();
        }
        localamyn.c = i;
      }
      if (!((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        break label672;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      label360:
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localamyn.jdField_a_of_type_ArrayOfAmym = new amym[paramJdSearchRsp.size()];
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
      localamyn.jdField_a_of_type_ArrayOfAmym[i] = new amym();
      localamym = localamyn.jdField_a_of_type_ArrayOfAmym[i];
      if (!((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
        break label677;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
      label475:
      localamym.jdField_a_of_type_JavaLangString = paramJdSearchRsp;
      localamym = localamyn.jdField_a_of_type_ArrayOfAmym[i];
      if (!((JDSearch.JdSkuItem)localObject2).image_url.has()) {
        break label683;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
      label510:
      localamym.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      localamym = localamyn.jdField_a_of_type_ArrayOfAmym[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
        break label689;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
      label545:
      localamym.c = paramJdSearchRsp;
      localamym = localamyn.jdField_a_of_type_ArrayOfAmym[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
        break label695;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
      label580:
      localamym.d = paramJdSearchRsp;
      localamym = localamyn.jdField_a_of_type_ArrayOfAmym[i];
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
      localamym.e = paramJdSearchRsp;
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
    return localamyn;
  }
  
  private amyp a()
  {
    boolean bool2 = false;
    if (c())
    {
      amyp localamyp = new amyp();
      amys localamys = a();
      if (localamys == null) {
        return null;
      }
      if (this.jdField_a_of_type_Amyq != null)
      {
        localamyp.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Amyq.jdField_a_of_type_Int, this.jdField_a_of_type_Amyq.c, this.jdField_a_of_type_Amyq.jdField_b_of_type_Int, this.jdField_a_of_type_Amyq.d);
        if (!localamys.jdField_b_of_type_Boolean) {
          break label127;
        }
        localamyp.jdField_a_of_type_JavaLangString = localamys.jdField_a_of_type_JavaLangString;
        localamyp.jdField_a_of_type_Boolean = false;
        localamyp.jdField_a_of_type_Double = localamys.jdField_a_of_type_Double;
      }
      for (;;)
      {
        return localamyp;
        localamyp.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        break;
        label127:
        localamyp.jdField_a_of_type_JavaLangString = localamys.jdField_a_of_type_Amyo.jdField_a_of_type_JavaLangString;
        boolean bool1 = bool2;
        if (localamys.jdField_a_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (localamys.jdField_a_of_type_ArrayOfByte.length > 20) {
            bool1 = true;
          }
        }
        localamyp.jdField_a_of_type_Boolean = bool1;
        localamyp.jdField_a_of_type_Double = localamys.jdField_a_of_type_Double;
        localamyp.jdField_a_of_type_ArrayOfByte = localamys.jdField_a_of_type_ArrayOfByte;
        localamyp.jdField_b_of_type_JavaLangString = localamys.d;
        localamyp.c = localamys.e;
        localamyp.d = localamys.f;
        localamyp.jdField_b_of_type_Boolean = localamys.jdField_a_of_type_Boolean;
      }
    }
    return null;
  }
  
  private amys a()
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
        while (i < this.jdField_a_of_type_ArrayOfAmyr.length)
        {
          int j = 0;
          while ((this.jdField_a_of_type_ArrayOfAmyr[i].jdField_a_of_type_ArrayOfAmys != null) && (j < this.jdField_a_of_type_ArrayOfAmyr[i].jdField_a_of_type_ArrayOfAmys.length))
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ArrayOfAmyr[i].jdField_a_of_type_ArrayOfAmys[j].jdField_a_of_type_Double >= ((amys)localObject1).jdField_a_of_type_Double) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ArrayOfAmyr[i].jdField_a_of_type_ArrayOfAmys[i];
            }
            j += 1;
            localObject1 = localObject2;
          }
          i += 1;
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
    } while (this.jdField_a_of_type_ArrayOfAmyr.length != 1);
    localObject1 = new amys();
    ((amys)localObject1).jdField_b_of_type_Boolean = true;
    ((amys)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAmyr[0].jdField_a_of_type_JavaLangString;
    ((amys)localObject1).jdField_a_of_type_Double = this.jdField_a_of_type_ArrayOfAmyr[0].jdField_a_of_type_Double;
    ((amys)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAmyr[0].jdField_a_of_type_JavaLangString;
    ((amys)localObject1).c = 0;
    ((amys)localObject1).g = "";
    return localObject1;
  }
  
  public int a()
  {
    if (!a()) {
      return -1;
    }
    if (c())
    {
      amys localamys = a();
      if ((localamys != null) && (localamys.jdField_a_of_type_ArrayOfByte != null) && (localamys.jdField_a_of_type_ArrayOfByte.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public amyl a()
  {
    amyl localamyl = new amyl();
    localamyl.jdField_a_of_type_Boolean = true;
    localamyl.jdField_a_of_type_Amyn = this.jdField_a_of_type_Amyn;
    localamyl.jdField_a_of_type_Amyp = a();
    localamyl.c = false;
    return localamyl;
  }
  
  public String a()
  {
    amys localamys = a();
    if (localamys == null) {
      return "";
    }
    return localamys.g;
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean a(amyk paramamyk)
  {
    if (paramamyk == null) {}
    amys localamys;
    do
    {
      return false;
      paramamyk = paramamyk.a();
      localamys = a();
    } while ((paramamyk == null) || (localamys == null) || (!paramamyk.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localamys.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public byte[] a()
  {
    amyp localamyp = a();
    if ((localamyp != null) && (localamyp.jdField_a_of_type_Boolean)) {
      return localamyp.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Amyn != null) && (this.jdField_a_of_type_Amyn.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Amyn.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Amyn.jdField_a_of_type_ArrayOfAmym != null) && (this.jdField_a_of_type_Amyn.jdField_a_of_type_ArrayOfAmym.length > 0);
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
        if (this.jdField_a_of_type_ArrayOfAmyr != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfAmyr.length > 0)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_ArrayOfAmyr[0].jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString)) {
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
    amys localamys = a();
    if (localamys == null) {
      return false;
    }
    if (localamys.c == 1) {}
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
      localStringBuilder.append("\n {migObjectClassifyResult:" + this.jdField_a_of_type_ArrayOfAmyr[0].toString() + "} \n");
    }
    if (b()) {
      localStringBuilder.append("\n {jdSearchResult:" + this.jdField_a_of_type_Amyn.toString() + "}\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyk
 * JD-Core Version:    0.7.0.1
 */