import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unify.search.UnifySearchCommon.ResultItemGroup;

public class bbas
  implements bbao<bays>
{
  private boolean a;
  
  public List<bays> a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 3)) {
      return null;
    }
    String str2 = "";
    if ((paramVarArgs[0] instanceof String)) {
      str2 = (String)paramVarArgs[0];
    }
    if ((paramVarArgs[1] instanceof List)) {}
    int j;
    ArrayList localArrayList1;
    UnifySearchCommon.ResultItemGroup localResultItemGroup;
    long l3;
    String str7;
    ArrayList localArrayList2;
    for (Object localObject1 = (List)paramVarArgs[1];; localObject1 = new ArrayList())
    {
      j = -1;
      if ((paramVarArgs[2] instanceof Integer)) {
        j = ((Integer)paramVarArgs[2]).intValue();
      }
      localArrayList1 = new ArrayList(((List)localObject1).size());
      Iterator localIterator = ((List)localObject1).iterator();
      if (!localIterator.hasNext()) {
        break label1659;
      }
      localResultItemGroup = (UnifySearchCommon.ResultItemGroup)localIterator.next();
      l3 = localResultItemGroup.group_mask.get();
      str7 = localResultItemGroup.group_name.get().toStringUtf8();
      paramVarArgs = localResultItemGroup.rpt_highlight_words.get();
      localArrayList2 = new ArrayList(paramVarArgs.size());
      paramVarArgs = paramVarArgs.iterator();
      while (paramVarArgs.hasNext()) {
        localArrayList2.add(((ByteStringMicro)paramVarArgs.next()).toStringUtf8());
      }
    }
    List localList = localResultItemGroup.result_items.get();
    ArrayList localArrayList3 = new ArrayList(localList.size());
    boolean bool1;
    if (localResultItemGroup.hide_title.get() == 1)
    {
      bool1 = true;
      if (!this.a) {
        break label1662;
      }
      bool1 = true;
    }
    label462:
    label1532:
    label1662:
    for (;;)
    {
      String str8 = localResultItemGroup.group_footer_name.get().toStringUtf8();
      String str9 = localResultItemGroup.group_footer_jump_url.get().toStringUtf8();
      long l1 = localList.size();
      int k = 0;
      boolean bool2;
      for (;;)
      {
        if (k >= localList.size()) {
          break label1532;
        }
        paramVarArgs = (UnifySearchCommon.ResultItem)localList.get(k);
        localObject1 = paramVarArgs.sub_result_items.get();
        int i2 = ((List)localObject1).size() + 1;
        ArrayList localArrayList4 = new ArrayList(i2);
        localArrayList4.add(paramVarArgs);
        localArrayList4.addAll((Collection)localObject1);
        int m = 0;
        if (m < i2)
        {
          UnifySearchCommon.ResultItem localResultItem = (UnifySearchCommon.ResultItem)localArrayList4.get(m);
          String str10 = localResultItem.result_id.get().toStringUtf8();
          bool2 = localResultItem.layout_id.has();
          String str11 = localResultItem.name.get().toStringUtf8();
          long l2;
          String str12;
          String str13;
          String str14;
          String str3;
          String str5;
          int n;
          String str4;
          Object localObject4;
          String str6;
          int i;
          Object localObject2;
          String str1;
          if (localResultItem.group_mask.has())
          {
            l2 = localResultItem.group_mask.get();
            str12 = localResultItem.pic_url.get().toStringUtf8();
            str13 = localResultItem.jmp_url.get().toStringUtf8();
            str14 = localResultItem.extension.get().toStringUtf8();
            str3 = "";
            str5 = "";
            int i1 = 0;
            n = 0;
            str4 = "";
            localObject4 = "";
            str6 = "";
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.NetBaseParser", 2, "exhibition Result" + str14);
            }
            paramVarArgs = (Object[])localObject4;
            localObject1 = str4;
            i = i1;
            localObject2 = str5;
            str1 = str3;
            if (l2 != 8001L) {
              break label1042;
            }
            paramVarArgs = (Object[])localObject4;
            localObject1 = str4;
            i = i1;
            localObject2 = str5;
            str1 = str3;
            if (str14.equals("")) {
              break label1042;
            }
            paramVarArgs = (Object[])localObject4;
            localObject1 = str4;
            i = n;
            localObject2 = str5;
            str1 = str3;
          }
          for (;;)
          {
            try
            {
              Object localObject5 = new JSONObject(str14);
              paramVarArgs = (Object[])localObject4;
              localObject1 = str4;
              i = n;
              localObject2 = str5;
              str1 = str3;
              JSONObject localJSONObject = new JSONObject(((JSONObject)localObject5).optJSONArray("attribute").get(0).toString());
              paramVarArgs = (Object[])localObject4;
              localObject1 = str4;
              i = n;
              localObject2 = str5;
              str1 = str3;
              str3 = localJSONObject.optString("exhibition_type");
              paramVarArgs = (Object[])localObject4;
              localObject1 = str4;
              i = n;
              localObject2 = str5;
              str1 = str3;
              str5 = localJSONObject.optString("exhibition_name");
              paramVarArgs = (Object[])localObject4;
              localObject1 = str4;
              i = n;
              localObject2 = str5;
              str1 = str3;
              n = localJSONObject.optInt("count");
              paramVarArgs = (Object[])localObject4;
              localObject1 = str4;
              i = n;
              localObject2 = str5;
              str1 = str3;
              str4 = localJSONObject.optString("color");
              paramVarArgs = (Object[])localObject4;
              localObject1 = str4;
              i = n;
              localObject2 = str5;
              str1 = str3;
              localObject4 = localJSONObject.optString("exhibition_msg");
              paramVarArgs = (Object[])localObject4;
              localObject1 = str4;
              i = n;
              localObject2 = str5;
              str1 = str3;
              localObject5 = ((JSONObject)localObject5).optString("jumpPath");
              paramVarArgs = (Object[])localObject5;
              localObject1 = localObject4;
              localObject2 = str4;
              localObject4 = paramVarArgs;
              paramVarArgs = (Object[])localObject1;
              localObject1 = str5;
              str1 = str3;
              if (!bool2) {
                break label1333;
              }
              localObject1 = null;
              paramVarArgs = (Object[])localObject1;
              switch (localResultItem.layout_id.get())
              {
              default: 
                paramVarArgs = (Object[])localObject1;
              case 5: 
              case 10: 
                if ((paramVarArgs == null) || (!paramVarArgs.b())) {
                  break label1324;
                }
                paramVarArgs.u = localResultItem.seporator_type.get();
                paramVarArgs.a = bool1;
                localArrayList3.add(paramVarArgs);
                l2 = l1;
                m += 1;
                l1 = l2;
              }
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
            bool1 = false;
            break;
            l2 = l3;
            break label462;
            Object localObject3 = localObject1;
            localObject1 = localObject2;
            n = i;
            localObject2 = localObject3;
            localObject4 = str6;
            continue;
            paramVarArgs = new baza(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazw(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazb(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazj(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazs(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazp(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazq(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazg(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new baze(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazh(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazr(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazo(str2, l3, localArrayList2, localResultItem, j);
            continue;
            paramVarArgs = new bazm(str2, l3, localArrayList2, localResultItem, j);
            continue;
            l2 = l1 - 1L;
            continue;
            if (!bbgk.b(l2))
            {
              QLog.e("Q.uniteSearch.NetBaseParser", 1, "itemGroupMask is not valid. mask=" + l2);
              l2 = l1;
            }
            else if (l2 == 2073745984L)
            {
              paramVarArgs = new bbac(str2, str14, -4, str12);
              paramVarArgs.u = localResultItem.seporator_type.get();
              localArrayList3.add(paramVarArgs);
              l2 = l1;
            }
            else
            {
              paramVarArgs = new baxr(str2, str10, str11, str12, str13, str14, l2, localArrayList2, j, str1, (String)localObject1, n, (String)localObject2, paramVarArgs, (String)localObject4);
              l2 = l1;
              if (paramVarArgs != null)
              {
                paramVarArgs.u = localResultItem.seporator_type.get();
                paramVarArgs.c = bool1;
                paramVarArgs.j = k;
                paramVarArgs.k = k;
                paramVarArgs.a = j;
                localArrayList3.add(paramVarArgs);
                l2 = l1;
              }
            }
          }
        }
        k += 1;
      }
      if (l1 <= 0L) {
        break;
      }
      l1 = localResultItemGroup.total_result_count.get();
      paramVarArgs = localResultItemGroup.more_url.get().toStringUtf8();
      localObject1 = localResultItemGroup.more_name.get().toStringUtf8();
      if (localResultItemGroup.highlight_title_keyword.get() == 1)
      {
        bool2 = true;
        if (localResultItemGroup.hide_title_blank_view.get() != 1) {
          break label1653;
        }
      }
      for (boolean bool3 = true;; bool3 = false)
      {
        localArrayList1.add(new baxq(str2, l3, str7, localArrayList3, l1, paramVarArgs, (String)localObject1, localArrayList2, bool1, bool2, bool3, str8, str9));
        break;
        bool2 = false;
        break label1589;
      }
      return localArrayList1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbas
 * JD-Core Version:    0.7.0.1
 */