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

public class anct
  extends anaz
  implements anbb
{
  public static final String a;
  public int a;
  public long a;
  public ancw a;
  public ancz a;
  public anda[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131701112);
  }
  
  public anct()
  {
    super(2, 0);
    this.jdField_a_of_type_Int = -1;
  }
  
  public static ancw a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    float f2 = 0.0F;
    ancw localancw = new ancw();
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
    ancv localancv;
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localancw.jdField_a_of_type_Int = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label633;
      }
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
      localancw.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (!paramJdSearchRsp.jd_search_detail.has()) {
        break label707;
      }
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (!((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        break label640;
      }
      i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      localancw.jdField_b_of_type_Int = i;
      if (!((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        break label645;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      localancw.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      if (!((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        break label651;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      localancw.d = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localancw.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.left.has()) {
          break label657;
        }
        f1 = paramJdSearchRsp.left.get();
        ((RectF)localObject2).left = f1;
        localObject2 = localancw.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.top.has()) {
          break label662;
        }
        f1 = paramJdSearchRsp.top.get();
        ((RectF)localObject2).top = f1;
        localObject2 = localancw.jdField_a_of_type_AndroidGraphicsRectF;
        if (!paramJdSearchRsp.right.has()) {
          break label667;
        }
        f1 = paramJdSearchRsp.right.get();
        label274:
        ((RectF)localObject2).right = f1;
        localObject2 = localancw.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        i = j;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          i = paramJdSearchRsp.is_user_rectangle.get();
        }
        localancw.c = i;
      }
      if (!((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        break label672;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      label360:
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localancw.jdField_a_of_type_ArrayOfAncv = new ancv[paramJdSearchRsp.size()];
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
      localancw.jdField_a_of_type_ArrayOfAncv[i] = new ancv();
      localancv = localancw.jdField_a_of_type_ArrayOfAncv[i];
      if (!((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
        break label677;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
      label475:
      localancv.jdField_a_of_type_JavaLangString = paramJdSearchRsp;
      localancv = localancw.jdField_a_of_type_ArrayOfAncv[i];
      if (!((JDSearch.JdSkuItem)localObject2).image_url.has()) {
        break label683;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
      label510:
      localancv.jdField_b_of_type_JavaLangString = paramJdSearchRsp;
      localancv = localancw.jdField_a_of_type_ArrayOfAncv[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
        break label689;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
      label545:
      localancv.c = paramJdSearchRsp;
      localancv = localancw.jdField_a_of_type_ArrayOfAncv[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
        break label695;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
      label580:
      localancv.d = paramJdSearchRsp;
      localancv = localancw.jdField_a_of_type_ArrayOfAncv[i];
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
      localancv.e = paramJdSearchRsp;
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
    return localancw;
  }
  
  private ancy a()
  {
    boolean bool2 = false;
    if (c())
    {
      ancy localancy = new ancy();
      andb localandb = a();
      if (localandb == null) {
        return null;
      }
      if (this.jdField_a_of_type_Ancz != null)
      {
        localancy.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Ancz.jdField_a_of_type_Int, this.jdField_a_of_type_Ancz.c, this.jdField_a_of_type_Ancz.jdField_b_of_type_Int, this.jdField_a_of_type_Ancz.d);
        if (!localandb.jdField_b_of_type_Boolean) {
          break label127;
        }
        localancy.jdField_a_of_type_JavaLangString = localandb.jdField_a_of_type_JavaLangString;
        localancy.jdField_a_of_type_Boolean = false;
        localancy.jdField_a_of_type_Double = localandb.jdField_a_of_type_Double;
      }
      for (;;)
      {
        return localancy;
        localancy.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        break;
        label127:
        localancy.jdField_a_of_type_JavaLangString = localandb.jdField_a_of_type_Ancx.jdField_a_of_type_JavaLangString;
        boolean bool1 = bool2;
        if (localandb.jdField_a_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (localandb.jdField_a_of_type_ArrayOfByte.length > 20) {
            bool1 = true;
          }
        }
        localancy.jdField_a_of_type_Boolean = bool1;
        localancy.jdField_a_of_type_Double = localandb.jdField_a_of_type_Double;
        localancy.jdField_a_of_type_ArrayOfByte = localandb.jdField_a_of_type_ArrayOfByte;
        localancy.jdField_b_of_type_JavaLangString = localandb.d;
        localancy.c = localandb.e;
        localancy.d = localandb.f;
        localancy.jdField_b_of_type_Boolean = localandb.jdField_a_of_type_Boolean;
      }
    }
    return null;
  }
  
  private andb a()
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
        while (i < this.jdField_a_of_type_ArrayOfAnda.length)
        {
          int j = 0;
          while ((this.jdField_a_of_type_ArrayOfAnda[i].jdField_a_of_type_ArrayOfAndb != null) && (j < this.jdField_a_of_type_ArrayOfAnda[i].jdField_a_of_type_ArrayOfAndb.length))
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ArrayOfAnda[i].jdField_a_of_type_ArrayOfAndb[j].jdField_a_of_type_Double >= ((andb)localObject1).jdField_a_of_type_Double) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ArrayOfAnda[i].jdField_a_of_type_ArrayOfAndb[i];
            }
            j += 1;
            localObject1 = localObject2;
          }
          i += 1;
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
    } while (this.jdField_a_of_type_ArrayOfAnda.length != 1);
    localObject1 = new andb();
    ((andb)localObject1).jdField_b_of_type_Boolean = true;
    ((andb)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAnda[0].jdField_a_of_type_JavaLangString;
    ((andb)localObject1).jdField_a_of_type_Double = this.jdField_a_of_type_ArrayOfAnda[0].jdField_a_of_type_Double;
    ((andb)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfAnda[0].jdField_a_of_type_JavaLangString;
    ((andb)localObject1).c = 0;
    ((andb)localObject1).g = "";
    return localObject1;
  }
  
  public int a()
  {
    if (!a()) {
      return -1;
    }
    if (c())
    {
      andb localandb = a();
      if ((localandb != null) && (localandb.jdField_a_of_type_ArrayOfByte != null) && (localandb.jdField_a_of_type_ArrayOfByte.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public ancu a()
  {
    ancu localancu = new ancu();
    localancu.jdField_a_of_type_Boolean = true;
    localancu.jdField_a_of_type_Ancw = this.jdField_a_of_type_Ancw;
    localancu.jdField_a_of_type_Ancy = a();
    localancu.c = false;
    return localancu;
  }
  
  public String a()
  {
    andb localandb = a();
    if (localandb == null) {
      return "";
    }
    return localandb.g;
  }
  
  public boolean a()
  {
    return c();
  }
  
  public boolean a(anct paramanct)
  {
    if (paramanct == null) {}
    andb localandb;
    do
    {
      return false;
      paramanct = paramanct.a();
      localandb = a();
    } while ((paramanct == null) || (localandb == null) || (!paramanct.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localandb.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public byte[] a()
  {
    ancy localancy = a();
    if ((localancy != null) && (localancy.jdField_a_of_type_Boolean)) {
      return localancy.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Ancw != null) && (this.jdField_a_of_type_Ancw.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Ancw.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Ancw.jdField_a_of_type_ArrayOfAncv != null) && (this.jdField_a_of_type_Ancw.jdField_a_of_type_ArrayOfAncv.length > 0);
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
        if (this.jdField_a_of_type_ArrayOfAnda != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfAnda.length > 0)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_ArrayOfAnda[0].jdField_a_of_type_JavaLangString.equalsIgnoreCase(jdField_a_of_type_JavaLangString)) {
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
    andb localandb = a();
    if (localandb == null) {
      return false;
    }
    if (localandb.c == 1) {}
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
      localStringBuilder.append("\n {migObjectClassifyResult:" + this.jdField_a_of_type_ArrayOfAnda[0].toString() + "} \n");
    }
    if (b()) {
      localStringBuilder.append("\n {jdSearchResult:" + this.jdField_a_of_type_Ancw.toString() + "}\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anct
 * JD-Core Version:    0.7.0.1
 */