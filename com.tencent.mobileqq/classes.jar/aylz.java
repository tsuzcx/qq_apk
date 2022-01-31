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

public class aylz
  extends aypb
{
  public List<ayma> a;
  
  public aylz(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public aylz(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
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
      localObject3 = (ayma)this.jdField_a_of_type_JavaUtilList.get(i);
      if (((ayma)localObject3).jdField_c_of_type_Int == 1) {
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (((ayma)localObject3).jdField_c_of_type_Int != 4) {
        if (((ayma)localObject3).jdField_c_of_type_Int == 3)
        {
          localObject1 = localObject3;
          continue;
          localObject3 = new ArrayList();
          Object localObject4 = new ayma();
          ((ayma)localObject4).jdField_a_of_type_JavaLangString = alud.a(2131701635);
          ((ayma)localObject4).jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190816141611_NQ31kYWAQJ.png";
          ((ayma)localObject4).jdField_a_of_type_ArrayOfLong = new long[0];
          ((ayma)localObject4).jdField_c_of_type_JavaLangString = "mqqapi://contact/search_might_know";
          ((ayma)localObject4).jdField_a_of_type_Int = 0;
          ((ayma)localObject4).jdField_b_of_type_Int = 0;
          ((ayma)localObject4).jdField_c_of_type_Int = 104;
          ((List)localObject3).add(localObject4);
          if (ayvj.b("emoji"))
          {
            localObject4 = ayvj.b("emoji");
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryDataModel", 2, "fabricateModel, EmojiEntrySwitchOn url= " + (String)localObject4);
            }
            ayma localayma = new ayma();
            localayma.jdField_a_of_type_JavaLangString = alud.a(2131701648);
            localayma.jdField_b_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/files/20190522/88ab43d24bc14de9a48d3ee11471b7ea.png";
            localayma.jdField_a_of_type_ArrayOfLong = new long[0];
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localayma.jdField_c_of_type_JavaLangString = ((String)localObject4);
            }
            localayma.jdField_a_of_type_Int = 0;
            localayma.jdField_b_of_type_Int = 0;
            localayma.jdField_c_of_type_Int = 101;
            ((List)localObject3).add(localayma);
          }
          if (localObject2 != null)
          {
            ((ayma)localObject2).jdField_b_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/files/20190522/299abcb70f194aeab89292db649698f5.png";
            if (!aoom.f()) {
              break label598;
            }
            localObject4 = aoom.a();
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              ((ayma)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject4);
              MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "expo", "2");
              label330:
              ((List)localObject3).add(localObject2);
            }
          }
          else
          {
            localObject2 = new ayma();
            ((ayma)localObject2).jdField_a_of_type_JavaLangString = alud.a(2131701649);
            ((ayma)localObject2).jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190529143225_pb7ADOBDqd.png";
            ((ayma)localObject2).jdField_a_of_type_ArrayOfLong = new long[0];
            ((ayma)localObject2).jdField_c_of_type_JavaLangString = "mqqapi://miniapp/open?_atype=0&_mappid=1109875297&_mvid=&_vt=3&via=2005_1&_sig=4bf2da5e43a83ba7a9e2446bf338da983e145d8c21ed6e9a3bdcb28c3f125c12";
            ((ayma)localObject2).jdField_a_of_type_Int = 0;
            ((ayma)localObject2).jdField_b_of_type_Int = 0;
            ((ayma)localObject2).jdField_c_of_type_Int = 103;
            ((List)localObject3).add(localObject2);
            if ((localObject1 != null) && (!babd.a()))
            {
              ((ayma)localObject1).jdField_b_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/files/20190522/cd2f6f83d9814d529c5efed2b45dbecd.png";
              ((List)localObject3).add(localObject1);
            }
            if (!ayvj.b("wiki")) {
              break label612;
            }
            localObject1 = ayvj.b("wiki");
            localObject2 = ayvj.c("wiki");
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryDataModel", 2, "fabricateModel, isWikiEntrySwitchOn wikiUrl= " + (String)localObject1 + ", wikiIconUrl = " + (String)localObject2);
            }
            localObject4 = new ayma();
            ((ayma)localObject4).jdField_a_of_type_JavaLangString = alud.a(2131719599);
            ((ayma)localObject4).jdField_a_of_type_ArrayOfLong = new long[0];
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((ayma)localObject4).jdField_c_of_type_JavaLangString = ((String)localObject1);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((ayma)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject2);
            }
            ((ayma)localObject4).jdField_a_of_type_Int = 0;
            ((ayma)localObject4).jdField_b_of_type_Int = 0;
            ((ayma)localObject4).jdField_c_of_type_Int = 105;
            ((List)localObject3).add(localObject4);
          }
          for (;;)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
            return;
            ((ayma)localObject2).jdField_c_of_type_JavaLangString = "mqqapi://miniapp/open?_atype=0&_mappid=1109740431&_mvid=&_vt=3&referer=2005&via=2005_4&_sig=6ee2c9e5075a2d129ac57b0a38af3fcdab417ff1fef97908d5e4806f94eb44af";
            break;
            label598:
            MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "expo", "1");
            break label330;
            label612:
            localObject1 = new ayma();
            ((ayma)localObject1).jdField_a_of_type_JavaLangString = alud.a(2131701629);
            ((ayma)localObject1).jdField_b_of_type_JavaLangString = "http://pub.idqqimg.com/pc/misc/files/20190522/7b5f61f779db42e38d8d8b6757a72e1b.png";
            ((ayma)localObject1).jdField_a_of_type_ArrayOfLong = new long[0];
            ((ayma)localObject1).jdField_c_of_type_JavaLangString = "https://h5.qzone.qq.com/qzone/ugcsearch?_wv=17039363&_wwv=1293&_proxy=1";
            ((ayma)localObject1).jdField_a_of_type_Int = 0;
            ((ayma)localObject1).jdField_b_of_type_Int = 0;
            ((ayma)localObject1).jdField_c_of_type_Int = 102;
            ((List)localObject3).add(localObject1);
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
    ayma localayma;
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
          localayma = new ayma();
          localayma.jdField_a_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
          localayma.jdField_b_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
          localList = ((DynamicDiscovery.SubBusinessItem)localObject).group_masks.get();
          localayma.jdField_a_of_type_ArrayOfLong = new long[localList.size()];
          j = 0;
          while (j < localList.size())
          {
            localayma.jdField_a_of_type_ArrayOfLong[j] = ((Long)localList.get(j)).longValue();
            j += 1;
          }
          localayma.jdField_c_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
          localayma.jdField_a_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).has_red_dot.get();
          localayma.jdField_b_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).red_seq.get();
          localayma.jdField_c_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).bzid.get();
          this.jdField_a_of_type_JavaUtilList.add(localayma);
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
        localayma = new ayma();
        localayma.jdField_a_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
        localayma.jdField_b_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
        localList = ((UnifySearchDiscovery.SubBusinessItem)localObject).group_masks.get();
        localayma.jdField_a_of_type_ArrayOfLong = new long[localList.size()];
        j = 0;
        while (j < localList.size())
        {
          localayma.jdField_a_of_type_ArrayOfLong[j] = ((Long)localList.get(j)).longValue();
          j += 1;
        }
        localayma.jdField_c_of_type_JavaLangString = ((UnifySearchDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
        localayma.jdField_a_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).has_red_dot.get();
        localayma.jdField_b_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).red_seq.get();
        localayma.jdField_c_of_type_Int = ((UnifySearchDiscovery.SubBusinessItem)localObject).bzid.get();
        this.jdField_a_of_type_JavaUtilList.add(localayma);
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
 * Qualified Name:     aylz
 * JD-Core Version:    0.7.0.1
 */