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

public class awmn
  extends awpp
{
  public List<awmo> a;
  
  public awmn(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public awmn(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramArrayOfByte);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryDataModel", 2, "fabricateModel, isFromReadInjoy mTabType= " + this.jdField_b_of_type_Int);
    }
    return this.jdField_b_of_type_Int == 10;
  }
  
  private void c()
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = null;
    Object localObject3;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject3 = (awmo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (((awmo)localObject3).jdField_c_of_type_Int == 1) {
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (((awmo)localObject3).jdField_c_of_type_Int != 4) {
        if (((awmo)localObject3).jdField_c_of_type_Int == 3)
        {
          localObject1 = localObject3;
          continue;
          localObject3 = new ArrayList();
          Object localObject4 = new awmo();
          ((awmo)localObject4).jdField_a_of_type_JavaLangString = ajya.a(2131701254);
          ((awmo)localObject4).jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190816141611_NQ31kYWAQJ.png";
          ((awmo)localObject4).jdField_a_of_type_ArrayOfLong = new long[0];
          ((awmo)localObject4).jdField_c_of_type_JavaLangString = "mqqapi://contact/search_might_know";
          ((awmo)localObject4).jdField_a_of_type_Int = 0;
          ((awmo)localObject4).jdField_b_of_type_Int = 0;
          ((awmo)localObject4).jdField_c_of_type_Int = 104;
          ((List)localObject3).add(localObject4);
          if (awvx.c(1))
          {
            localObject4 = awvx.a(1);
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryDataModel", 2, "fabricateModel, EmojiEntrySwitchOn url= " + (String)localObject4);
            }
            awmo localawmo = new awmo();
            localawmo.jdField_a_of_type_JavaLangString = ajya.a(2131701267);
            localawmo.jdField_b_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/files/20190522/88ab43d24bc14de9a48d3ee11471b7ea.png";
            localawmo.jdField_a_of_type_ArrayOfLong = new long[0];
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localawmo.jdField_c_of_type_JavaLangString = ((String)localObject4);
            }
            localawmo.jdField_a_of_type_Int = 0;
            localawmo.jdField_b_of_type_Int = 0;
            localawmo.jdField_c_of_type_Int = 101;
            ((List)localObject3).add(localawmo);
          }
          if (localObject2 != null)
          {
            ((awmo)localObject2).jdField_b_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/files/20190522/299abcb70f194aeab89292db649698f5.png";
            if (!amtb.f()) {
              break label509;
            }
            localObject4 = amtb.a();
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              break label500;
            }
            ((awmo)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject4);
            MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "expo", "2");
          }
          for (;;)
          {
            ((List)localObject3).add(localObject2);
            localObject2 = new awmo();
            ((awmo)localObject2).jdField_a_of_type_JavaLangString = ajya.a(2131701268);
            ((awmo)localObject2).jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190529143225_pb7ADOBDqd.png";
            ((awmo)localObject2).jdField_a_of_type_ArrayOfLong = new long[0];
            ((awmo)localObject2).jdField_c_of_type_JavaLangString = "mqqapi://miniapp/open?_atype=0&_mappid=1109875297&_mvid=&_vt=3&via=2005_1&_sig=4bf2da5e43a83ba7a9e2446bf338da983e145d8c21ed6e9a3bdcb28c3f125c12";
            ((awmo)localObject2).jdField_a_of_type_Int = 0;
            ((awmo)localObject2).jdField_b_of_type_Int = 0;
            ((awmo)localObject2).jdField_c_of_type_Int = 103;
            ((List)localObject3).add(localObject2);
            if (localObject1 != null)
            {
              ((awmo)localObject1).jdField_b_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/files/20190522/cd2f6f83d9814d529c5efed2b45dbecd.png";
              ((List)localObject3).add(localObject1);
            }
            localObject1 = new awmo();
            ((awmo)localObject1).jdField_a_of_type_JavaLangString = ajya.a(2131701248);
            ((awmo)localObject1).jdField_b_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/files/20190522/7b5f61f779db42e38d8d8b6757a72e1b.png";
            ((awmo)localObject1).jdField_a_of_type_ArrayOfLong = new long[0];
            ((awmo)localObject1).jdField_c_of_type_JavaLangString = "https://h5.qzone.qq.com/qzone/ugcsearch?_wv=17039363&_wwv=1293&_proxy=1";
            ((awmo)localObject1).jdField_a_of_type_Int = 0;
            ((awmo)localObject1).jdField_b_of_type_Int = 0;
            ((awmo)localObject1).jdField_c_of_type_Int = 102;
            ((List)localObject3).add(localObject1);
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
            return;
            label500:
            ((awmo)localObject2).jdField_c_of_type_JavaLangString = "mqqapi://miniapp/open?_atype=0&_mappid=1109740431&_mvid=&_vt=3&referer=2005&via=2005_4&_sig=6ee2c9e5075a2d129ac57b0a38af3fcdab417ff1fef97908d5e4806f94eb44af";
            break;
            label509:
            MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "expo", "1");
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
    awmo localawmo;
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
          localawmo = new awmo();
          localawmo.jdField_a_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
          localawmo.jdField_b_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
          localList = ((DynamicDiscovery.SubBusinessItem)localObject).group_masks.get();
          localawmo.jdField_a_of_type_ArrayOfLong = new long[localList.size()];
          j = 0;
          while (j < localList.size())
          {
            localawmo.jdField_a_of_type_ArrayOfLong[j] = ((Long)localList.get(j)).longValue();
            j += 1;
          }
          localawmo.jdField_c_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
          localawmo.jdField_a_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).has_red_dot.get();
          localawmo.jdField_b_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).red_seq.get();
          localawmo.jdField_c_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).bzid.get();
          this.jdField_a_of_type_JavaUtilList.add(localawmo);
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
        localawmo = new awmo();
        localawmo.jdField_a_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
        localawmo.jdField_b_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
        localList = ((UnifySearchDiscovery.SubBusinessItem)localObject).group_masks.get();
        localawmo.jdField_a_of_type_ArrayOfLong = new long[localList.size()];
        j = 0;
        while (j < localList.size())
        {
          localawmo.jdField_a_of_type_ArrayOfLong[j] = ((Long)localList.get(j)).longValue();
          j += 1;
        }
        localawmo.jdField_c_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
        localawmo.jdField_a_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).has_red_dot.get();
        localawmo.jdField_b_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).red_seq.get();
        localawmo.jdField_c_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).bzid.get();
        this.jdField_a_of_type_JavaUtilList.add(localawmo);
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
 * Qualified Name:     awmn
 * JD-Core Version:    0.7.0.1
 */