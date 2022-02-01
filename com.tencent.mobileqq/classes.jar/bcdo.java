import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import pb.unify.search.UnifySearchDiscovery.Result;
import pb.unify.search.UnifySearchDiscovery.SubBusinessItem;
import pb.unite.search.DynamicDiscovery.Result;
import pb.unite.search.DynamicDiscovery.SubBusinessItem;

public class bcdo
  extends bcgq
{
  public List<bcdp> a;
  
  public bcdo(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public bcdo(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramArrayOfByte);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryDataModel", 2, "fabricateModel, isFromReadInjoy mTabType= " + this.d);
    }
    return this.d == 10;
  }
  
  private void c()
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = null;
    Object localObject3;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject3 = (bcdp)this.jdField_a_of_type_JavaUtilList.get(i);
      if (((bcdp)localObject3).jdField_c_of_type_Int == 1) {
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (((bcdp)localObject3).jdField_c_of_type_Int != 4) {
        if (((bcdp)localObject3).jdField_c_of_type_Int == 3)
        {
          localObject1 = localObject3;
          continue;
          localObject3 = new ArrayList();
          Object localObject4 = new bcdp();
          ((bcdp)localObject4).jdField_a_of_type_JavaLangString = anvx.a(2131700752);
          ((bcdp)localObject4).jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190816141611_NQ31kYWAQJ.png";
          ((bcdp)localObject4).jdField_a_of_type_ArrayOfLong = new long[0];
          ((bcdp)localObject4).jdField_c_of_type_JavaLangString = "mqqapi://contact/search_might_know";
          ((bcdp)localObject4).jdField_a_of_type_Int = 0;
          ((bcdp)localObject4).jdField_b_of_type_Int = 0;
          ((bcdp)localObject4).jdField_c_of_type_Int = 104;
          ((List)localObject3).add(localObject4);
          Object localObject5;
          if (bcmz.b("emoji"))
          {
            localObject4 = bcmz.a("emoji");
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryDataModel", 2, "fabricateModel, EmojiEntrySwitchOn url= " + (String)localObject4);
            }
            localObject5 = new bcdp();
            ((bcdp)localObject5).jdField_a_of_type_JavaLangString = anvx.a(2131700765);
            ((bcdp)localObject5).jdField_b_of_type_JavaLangString = "https://pub.idqqimg.com/pc/misc/files/20190522/88ab43d24bc14de9a48d3ee11471b7ea.png";
            ((bcdp)localObject5).jdField_a_of_type_ArrayOfLong = new long[0];
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              ((bcdp)localObject5).jdField_c_of_type_JavaLangString = ((String)localObject4);
            }
            ((bcdp)localObject5).jdField_a_of_type_Int = 0;
            ((bcdp)localObject5).jdField_b_of_type_Int = 0;
            ((bcdp)localObject5).jdField_c_of_type_Int = 101;
            ((List)localObject3).add(localObject5);
          }
          if (localObject2 != null)
          {
            ((bcdp)localObject2).jdField_b_of_type_JavaLangString = "https://pub.idqqimg.com/pc/misc/files/20190522/299abcb70f194aeab89292db649698f5.png";
            if (!arbw.b()) {
              break label659;
            }
            localObject4 = arbw.a();
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              ((bcdp)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject4);
              MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "expo", "2");
              label330:
              ((List)localObject3).add(localObject2);
            }
          }
          else
          {
            localObject2 = new bcdp();
            ((bcdp)localObject2).jdField_a_of_type_JavaLangString = anvx.a(2131700766);
            ((bcdp)localObject2).jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190529143225_pb7ADOBDqd.png";
            ((bcdp)localObject2).jdField_a_of_type_ArrayOfLong = new long[0];
            ((bcdp)localObject2).jdField_c_of_type_JavaLangString = "mqqapi://miniapp/open?_atype=0&_mappid=1109875297&_mvid=&_vt=3&via=2005_1&_sig=4bf2da5e43a83ba7a9e2446bf338da983e145d8c21ed6e9a3bdcb28c3f125c12";
            ((bcdp)localObject2).jdField_a_of_type_Int = 0;
            ((bcdp)localObject2).jdField_b_of_type_Int = 0;
            ((bcdp)localObject2).jdField_c_of_type_Int = 103;
            ((List)localObject3).add(localObject2);
            if (!bcmz.b("heihua")) {
              break label673;
            }
            localObject4 = bcmz.a("heihua");
            localObject5 = bcmz.b("heihua");
            localObject2 = bcmz.c("heihua");
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryDataModel", 2, "fabricateModel, isWikiEntrySwitchOn wikiUrl= " + (String)localObject4 + ", wikiIconUrl = " + (String)localObject5);
            }
            bcdp localbcdp = new bcdp();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = anvx.a(2131718387);
            }
            localbcdp.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localbcdp.jdField_a_of_type_ArrayOfLong = new long[0];
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localbcdp.jdField_c_of_type_JavaLangString = ((String)localObject4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject5)) {
              localbcdp.jdField_b_of_type_JavaLangString = ((String)localObject5);
            }
            localbcdp.jdField_a_of_type_Int = 0;
            localbcdp.jdField_b_of_type_Int = 0;
            localbcdp.jdField_c_of_type_Int = 105;
            ((List)localObject3).add(localbcdp);
          }
          for (;;)
          {
            localObject1 = new bcdp();
            ((bcdp)localObject1).jdField_a_of_type_JavaLangString = anvx.a(2131700746);
            ((bcdp)localObject1).jdField_b_of_type_JavaLangString = "https://pub.idqqimg.com/pc/misc/files/20190522/7b5f61f779db42e38d8d8b6757a72e1b.png";
            ((bcdp)localObject1).jdField_a_of_type_ArrayOfLong = new long[0];
            ((bcdp)localObject1).jdField_c_of_type_JavaLangString = "https://h5.qzone.qq.com/qzone/ugcsearch?_wv=17039363&_wwv=1293&_proxy=1";
            ((bcdp)localObject1).jdField_a_of_type_Int = 0;
            ((bcdp)localObject1).jdField_b_of_type_Int = 0;
            ((bcdp)localObject1).jdField_c_of_type_Int = 102;
            ((List)localObject3).add(localObject1);
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
            return;
            ((bcdp)localObject2).jdField_c_of_type_JavaLangString = "mqqapi://miniapp/open?_atype=0&_mappid=1109740431&_mvid=&_vt=3&referer=2005&via=2005_4&_sig=6ee2c9e5075a2d129ac57b0a38af3fcdab417ff1fef97908d5e4806f94eb44af";
            break;
            label659:
            MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "expo", "1");
            break label330;
            label673:
            if ((localObject1 != null) && (!bdvn.a()))
            {
              ((bcdp)localObject1).jdField_b_of_type_JavaLangString = "https://pub.idqqimg.com/pc/misc/files/20190522/cd2f6f83d9814d529c5efed2b45dbecd.png";
              ((List)localObject3).add(localObject1);
            }
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int i;
    bcdp localbcdp;
    List localList;
    int j;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = new DynamicDiscovery.Result();
      try
      {
        ((DynamicDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject).sub_business_items.get();
        i = 0;
        while (i < paramArrayOfByte.size())
        {
          localObject = (DynamicDiscovery.SubBusinessItem)paramArrayOfByte.get(i);
          localbcdp = new bcdp();
          localbcdp.jdField_a_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
          localbcdp.jdField_b_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
          localList = ((DynamicDiscovery.SubBusinessItem)localObject).group_masks.get();
          localbcdp.jdField_a_of_type_ArrayOfLong = new long[localList.size()];
          j = 0;
          while (j < localList.size())
          {
            localbcdp.jdField_a_of_type_ArrayOfLong[j] = ((Long)localList.get(j)).longValue();
            j += 1;
          }
          localbcdp.jdField_c_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
          localbcdp.jdField_a_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).has_red_dot.get();
          localbcdp.jdField_b_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).red_seq.get();
          localbcdp.jdField_c_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).bzid.get();
          this.jdField_a_of_type_JavaUtilList.add(localbcdp);
          i += 1;
        }
        if (!a()) {
          c();
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SearchEntryDataModel", 2, "fabricateModel, DynamicDiscovery InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
          }
        }
      }
      QLog.d("SearchEntryDataModel818searchProto_old", 2, "fabricateModel");
      return;
    }
    Object localObject = new UnifySearchDiscovery.Result();
    try
    {
      ((UnifySearchDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = ((UnifySearchDiscovery.Result)localObject).sub_business_items.get();
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        localObject = (UnifySearchDiscovery.SubBusinessItem)paramArrayOfByte.get(i);
        localbcdp = new bcdp();
        localbcdp.jdField_a_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
        localbcdp.jdField_b_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
        localList = ((UnifySearchDiscovery.SubBusinessItem)localObject).group_masks.get();
        localbcdp.jdField_a_of_type_ArrayOfLong = new long[localList.size()];
        j = 0;
        while (j < localList.size())
        {
          localbcdp.jdField_a_of_type_ArrayOfLong[j] = ((Long)localList.get(j)).longValue();
          j += 1;
        }
        localbcdp.jdField_c_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
        localbcdp.jdField_a_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).has_red_dot.get();
        localbcdp.jdField_b_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).red_seq.get();
        localbcdp.jdField_c_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).bzid.get();
        this.jdField_a_of_type_JavaUtilList.add(localbcdp);
        i += 1;
      }
      if (!a()) {
        c();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SearchEntryDataModel", 2, "fabricateModel, UnifySearchDiscovery InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
        }
      }
    }
    QLog.d("SearchEntryDataModel818searchProto_new", 2, "fabricateModel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdo
 * JD-Core Version:    0.7.0.1
 */