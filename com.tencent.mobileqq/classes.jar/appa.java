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

public class appa
  extends apng
  implements apni
{
  public static final String a;
  public int a;
  public long a;
  public appd a;
  public appg a;
  public apph[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131699644);
  }
  
  public appa()
  {
    super(2, 0);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static appd a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    float f2 = 0.0F;
    appd localappd = new appd();
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
    appc localappc;
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localappd.jdField_a_of_type_Int = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label633;
      }
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
      localappd.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (!paramJdSearchRsp.jd_search_detail.has()) {
        break label707;
      }
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (!((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        break label640;
      }
      i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      localappd.jdField_b_of_type_Int = i;
      if (!((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        break label645;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      localappd.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      if (!((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        break label651;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      localappd.d = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localappd.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.left.has()) {
          break label657;
        }
        f1 = paramJdSearchRsp.left.get();
        ((RectF)localObject2).left = f1;
        localObject2 = localappd.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.top.has()) {
          break label662;
        }
        f1 = paramJdSearchRsp.top.get();
        ((RectF)localObject2).top = f1;
        localObject2 = localappd.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.right.has()) {
          break label667;
        }
        f1 = paramJdSearchRsp.right.get();
        label274:
        ((RectF)localObject2).right = f1;
        localObject2 = localappd.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        i = j;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          i = paramJdSearchRsp.is_user_rectangle.get();
        }
        localappd.c = i;
      }
      if (!((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        break label672;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      label360:
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localappd.jdField_a_of_type_ArrayOfAppc = new appc[paramJdSearchRsp.size()];
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
      localappd.jdField_a_of_type_ArrayOfAppc[i] = new appc();
      localappc = localappd.jdField_a_of_type_ArrayOfAppc[i];
      if (!((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
        break label677;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
      label475:
      localappc.jdField_a_of_type_JavaLangString = paramJdSearchRsp;
      localappc = localappd.jdField_a_of_type_ArrayOfAppc[i];
      if (!((JDSearch.JdSkuItem)localObject2).image_url.has()) {
        break label683;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
      label510:
      localappc.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      localappc = localappd.jdField_a_of_type_ArrayOfAppc[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
        break label689;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
      label545:
      localappc.c = paramJdSearchRsp;
      localappc = localappd.jdField_a_of_type_ArrayOfAppc[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
        break label695;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
      label580:
      localappc.d = paramJdSearchRsp;
      localappc = localappd.jdField_a_of_type_ArrayOfAppc[i];
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
      localappc.e = paramJdSearchRsp;
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
    return localappd;
  }
  
  private appf a()
  {
    boolean bool2 = false;
    if (c())
    {
      appf localappf = new appf();
      appi localappi = a();
      if (localappi == null) {
        return null;
      }
      if (this.jdField_a_of_type_Appg != null)
      {
        localappf.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Appg.jdField_a_of_type_Int, this.jdField_a_of_type_Appg.c, this.jdField_a_of_type_Appg.jdField_b_of_type_Int, this.jdField_a_of_type_Appg.d);
        if (!localappi.jdField_b_of_type_Boolean) {
          break label127;
        }
        localappf.jdField_a_of_type_JavaLangString = localappi.jdField_a_of_type_JavaLangString;
        localappf.jdField_a_of_type_Boolean = false;
        localappf.jdField_a_of_type_Double = localappi.jdField_a_of_type_Double;
      }
      for (;;)
      {
        return localappf;
        localappf.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        break;
        label127:
        localappf.jdField_a_of_type_JavaLangString = localappi.jdField_a_of_type_Appe.jdField_a_of_type_JavaLangString;
        boolean bool1 = bool2;
        if (localappi.jdField_a_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (localappi.jdField_a_of_type_ArrayOfByte.length > 20) {
            bool1 = true;
          }
        }
        localappf.jdField_a_of_type_Boolean = bool1;
        localappf.jdField_a_of_type_Double = localappi.jdField_a_of_type_Double;
        localappf.jdField_a_of_type_ArrayOfByte = localappi.jdField_a_of_type_ArrayOfByte;
        localappf.jdField_b_of_type_JavaLangString = localappi.d;
        localappf.c = localappi.e;
        localappf.d = localappi.f;
        localappf.jdField_b_of_type_Boolean = localappi.jdField_a_of_type_Boolean;
      }
    }
    return null;
  }
  
  private appi a()
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
        while (i < this.jdField_a_of_type_ArrayOfApph.length)
        {
          int j = 0;
          while ((this.jdField_a_of_type_ArrayOfApph[i].jdField_a_of_type_ArrayOfAppi != null) && (j < this.jdField_a_of_type_ArrayOfApph[i].jdField_a_of_type_ArrayOfAppi.length))
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ArrayOfApph[i].jdField_a_of_type_ArrayOfAppi[j].jdField_a_of_type_Double >= ((appi)localObject1).jdField_a_of_type_Double) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ArrayOfApph[i].jdField_a_of_type_ArrayOfAppi[i];
            }
            j += 1;
            localObject1 = localObject2;
          }
          i += 1;
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
    } while (this.jdField_a_of_type_ArrayOfApph.length != 1);
    localObject1 = new appi();
    ((appi)localObject1).jdField_b_of_type_Boolean = true;
    ((appi)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfApph[0].jdField_a_of_type_JavaLangString;
    ((appi)localObject1).jdField_a_of_type_Double = this.jdField_a_of_type_ArrayOfApph[0].jdField_a_of_type_Double;
    ((appi)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfApph[0].jdField_a_of_type_JavaLangString;
    ((appi)localObject1).c = 0;
    ((appi)localObject1).g = "";
    return localObject1;
  }
  
  public int a()
  {
    if (!a()) {
      return -1;
    }
    if (c())
    {
      appi localappi = a();
      if ((localappi != null) && (localappi.jdField_a_of_type_ArrayOfByte != null) && (localappi.jdField_a_of_type_ArrayOfByte.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public appb a()
  {
    appb localappb = new appb();
    localappb.jdField_a_of_type_Boolean = true;
    localappb.jdField_a_of_type_Appd = this.jdField_a_of_type_Appd;
    localappb.jdField_a_of_type_Appf = a();
    localappb.c = false;
    return localappb;
  }
  
  public String a()
  {
    appi localappi = a();
    if (localappi == null) {
      return "";
    }
    return localappi.g;
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean a(appa paramappa)
  {
    if (paramappa == null) {}
    appi localappi;
    do
    {
      return false;
      paramappa = paramappa.a();
      localappi = a();
    } while ((paramappa == null) || (localappi == null) || (!paramappa.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localappi.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public byte[] a()
  {
    appf localappf = a();
    if ((localappf != null) && (localappf.jdField_a_of_type_Boolean)) {
      return localappf.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Appd != null) && (this.jdField_a_of_type_Appd.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Appd.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Appd.jdField_a_of_type_ArrayOfAppc != null) && (this.jdField_a_of_type_Appd.jdField_a_of_type_ArrayOfAppc.length > 0);
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
        if (this.jdField_a_of_type_ArrayOfApph != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfApph.length > 0)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_ArrayOfApph[0].jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString)) {
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
    appi localappi = a();
    if (localappi == null) {
      return false;
    }
    if (localappi.c == 1) {}
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
      localStringBuilder.append("\n {migObjectClassifyResult:" + this.jdField_a_of_type_ArrayOfApph[0].toString() + "} \n");
    }
    if (b()) {
      localStringBuilder.append("\n {jdSearchResult:" + this.jdField_a_of_type_Appd.toString() + "}\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appa
 * JD-Core Version:    0.7.0.1
 */