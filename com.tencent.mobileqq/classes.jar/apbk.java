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

public class apbk
  extends aozq
  implements aozs
{
  public static final String a;
  public int a;
  public long a;
  public apbn a;
  public apbq a;
  public apbr[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131699537);
  }
  
  public apbk()
  {
    super(2, 0);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static apbn a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    float f2 = 0.0F;
    apbn localapbn = new apbn();
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
    apbm localapbm;
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localapbn.jdField_a_of_type_Int = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label633;
      }
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
      localapbn.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (!paramJdSearchRsp.jd_search_detail.has()) {
        break label707;
      }
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (!((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        break label640;
      }
      i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      localapbn.jdField_b_of_type_Int = i;
      if (!((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        break label645;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      localapbn.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      if (!((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        break label651;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      localapbn.d = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localapbn.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.left.has()) {
          break label657;
        }
        f1 = paramJdSearchRsp.left.get();
        ((RectF)localObject2).left = f1;
        localObject2 = localapbn.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.top.has()) {
          break label662;
        }
        f1 = paramJdSearchRsp.top.get();
        ((RectF)localObject2).top = f1;
        localObject2 = localapbn.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.right.has()) {
          break label667;
        }
        f1 = paramJdSearchRsp.right.get();
        label274:
        ((RectF)localObject2).right = f1;
        localObject2 = localapbn.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        i = j;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          i = paramJdSearchRsp.is_user_rectangle.get();
        }
        localapbn.c = i;
      }
      if (!((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        break label672;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      label360:
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localapbn.jdField_a_of_type_ArrayOfApbm = new apbm[paramJdSearchRsp.size()];
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
      localapbn.jdField_a_of_type_ArrayOfApbm[i] = new apbm();
      localapbm = localapbn.jdField_a_of_type_ArrayOfApbm[i];
      if (!((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
        break label677;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
      label475:
      localapbm.jdField_a_of_type_JavaLangString = paramJdSearchRsp;
      localapbm = localapbn.jdField_a_of_type_ArrayOfApbm[i];
      if (!((JDSearch.JdSkuItem)localObject2).image_url.has()) {
        break label683;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
      label510:
      localapbm.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      localapbm = localapbn.jdField_a_of_type_ArrayOfApbm[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
        break label689;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
      label545:
      localapbm.c = paramJdSearchRsp;
      localapbm = localapbn.jdField_a_of_type_ArrayOfApbm[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
        break label695;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
      label580:
      localapbm.d = paramJdSearchRsp;
      localapbm = localapbn.jdField_a_of_type_ArrayOfApbm[i];
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
      localapbm.e = paramJdSearchRsp;
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
    return localapbn;
  }
  
  private apbp a()
  {
    boolean bool2 = false;
    if (c())
    {
      apbp localapbp = new apbp();
      apbs localapbs = a();
      if (localapbs == null) {
        return null;
      }
      if (this.jdField_a_of_type_Apbq != null)
      {
        localapbp.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Apbq.jdField_a_of_type_Int, this.jdField_a_of_type_Apbq.c, this.jdField_a_of_type_Apbq.jdField_b_of_type_Int, this.jdField_a_of_type_Apbq.d);
        if (!localapbs.jdField_b_of_type_Boolean) {
          break label127;
        }
        localapbp.jdField_a_of_type_JavaLangString = localapbs.jdField_a_of_type_JavaLangString;
        localapbp.jdField_a_of_type_Boolean = false;
        localapbp.jdField_a_of_type_Double = localapbs.jdField_a_of_type_Double;
      }
      for (;;)
      {
        return localapbp;
        localapbp.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        break;
        label127:
        localapbp.jdField_a_of_type_JavaLangString = localapbs.jdField_a_of_type_Apbo.jdField_a_of_type_JavaLangString;
        boolean bool1 = bool2;
        if (localapbs.jdField_a_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (localapbs.jdField_a_of_type_ArrayOfByte.length > 20) {
            bool1 = true;
          }
        }
        localapbp.jdField_a_of_type_Boolean = bool1;
        localapbp.jdField_a_of_type_Double = localapbs.jdField_a_of_type_Double;
        localapbp.jdField_a_of_type_ArrayOfByte = localapbs.jdField_a_of_type_ArrayOfByte;
        localapbp.jdField_b_of_type_JavaLangString = localapbs.d;
        localapbp.c = localapbs.e;
        localapbp.d = localapbs.f;
        localapbp.jdField_b_of_type_Boolean = localapbs.jdField_a_of_type_Boolean;
      }
    }
    return null;
  }
  
  private apbs a()
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
        while (i < this.jdField_a_of_type_ArrayOfApbr.length)
        {
          int j = 0;
          while ((this.jdField_a_of_type_ArrayOfApbr[i].jdField_a_of_type_ArrayOfApbs != null) && (j < this.jdField_a_of_type_ArrayOfApbr[i].jdField_a_of_type_ArrayOfApbs.length))
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ArrayOfApbr[i].jdField_a_of_type_ArrayOfApbs[j].jdField_a_of_type_Double >= ((apbs)localObject1).jdField_a_of_type_Double) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ArrayOfApbr[i].jdField_a_of_type_ArrayOfApbs[i];
            }
            j += 1;
            localObject1 = localObject2;
          }
          i += 1;
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
    } while (this.jdField_a_of_type_ArrayOfApbr.length != 1);
    localObject1 = new apbs();
    ((apbs)localObject1).jdField_b_of_type_Boolean = true;
    ((apbs)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfApbr[0].jdField_a_of_type_JavaLangString;
    ((apbs)localObject1).jdField_a_of_type_Double = this.jdField_a_of_type_ArrayOfApbr[0].jdField_a_of_type_Double;
    ((apbs)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfApbr[0].jdField_a_of_type_JavaLangString;
    ((apbs)localObject1).c = 0;
    ((apbs)localObject1).g = "";
    return localObject1;
  }
  
  public int a()
  {
    if (!a()) {
      return -1;
    }
    if (c())
    {
      apbs localapbs = a();
      if ((localapbs != null) && (localapbs.jdField_a_of_type_ArrayOfByte != null) && (localapbs.jdField_a_of_type_ArrayOfByte.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public apbl a()
  {
    apbl localapbl = new apbl();
    localapbl.jdField_a_of_type_Boolean = true;
    localapbl.jdField_a_of_type_Apbn = this.jdField_a_of_type_Apbn;
    localapbl.jdField_a_of_type_Apbp = a();
    localapbl.c = false;
    return localapbl;
  }
  
  public String a()
  {
    apbs localapbs = a();
    if (localapbs == null) {
      return "";
    }
    return localapbs.g;
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean a(apbk paramapbk)
  {
    if (paramapbk == null) {}
    apbs localapbs;
    do
    {
      return false;
      paramapbk = paramapbk.a();
      localapbs = a();
    } while ((paramapbk == null) || (localapbs == null) || (!paramapbk.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localapbs.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public byte[] a()
  {
    apbp localapbp = a();
    if ((localapbp != null) && (localapbp.jdField_a_of_type_Boolean)) {
      return localapbp.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Apbn != null) && (this.jdField_a_of_type_Apbn.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Apbn.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Apbn.jdField_a_of_type_ArrayOfApbm != null) && (this.jdField_a_of_type_Apbn.jdField_a_of_type_ArrayOfApbm.length > 0);
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
        if (this.jdField_a_of_type_ArrayOfApbr != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfApbr.length > 0)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_ArrayOfApbr[0].jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString)) {
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
    apbs localapbs = a();
    if (localapbs == null) {
      return false;
    }
    if (localapbs.c == 1) {}
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
      localStringBuilder.append("\n {migObjectClassifyResult:" + this.jdField_a_of_type_ArrayOfApbr[0].toString() + "} \n");
    }
    if (b()) {
      localStringBuilder.append("\n {jdSearchResult:" + this.jdField_a_of_type_Apbn.toString() + "}\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbk
 * JD-Core Version:    0.7.0.1
 */