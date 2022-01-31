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
import pb.unite.search.DynamicSearch.ResultItem;
import pb.unite.search.DynamicSearch.ResultItemGroup;

public class aypq
  implements aypp<aynt>
{
  public List<aynt> a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 3)) {
      return null;
    }
    String str1 = "";
    if ((paramVarArgs[0] instanceof String)) {
      str1 = (String)paramVarArgs[0];
    }
    Object localObject;
    int i;
    ArrayList localArrayList1;
    Iterator localIterator;
    if ((paramVarArgs[1] instanceof List))
    {
      localObject = (List)paramVarArgs[1];
      i = -1;
      if ((paramVarArgs[2] instanceof Integer)) {
        i = ((Integer)paramVarArgs[2]).intValue();
      }
      localArrayList1 = new ArrayList(((List)localObject).size());
      localIterator = ((List)localObject).iterator();
    }
    label920:
    for (;;)
    {
      label448:
      label1223:
      if (localIterator.hasNext())
      {
        DynamicSearch.ResultItemGroup localResultItemGroup = (DynamicSearch.ResultItemGroup)localIterator.next();
        long l3 = localResultItemGroup.group_mask.get();
        String str2 = localResultItemGroup.group_name.get().toStringUtf8();
        paramVarArgs = localResultItemGroup.rpt_highlight_words.get();
        ArrayList localArrayList2 = new ArrayList(paramVarArgs.size());
        paramVarArgs = paramVarArgs.iterator();
        for (;;)
        {
          if (paramVarArgs.hasNext())
          {
            localArrayList2.add(((ByteStringMicro)paramVarArgs.next()).toStringUtf8());
            continue;
            localObject = new ArrayList();
            break;
          }
        }
        List localList = localResultItemGroup.result_items.get();
        ArrayList localArrayList3 = new ArrayList(localList.size());
        boolean bool1;
        String str3;
        String str4;
        long l1;
        int j;
        if (localResultItemGroup.hide_title.get() == 1)
        {
          bool1 = true;
          str3 = localResultItemGroup.group_footer_name.get().toStringUtf8();
          str4 = localResultItemGroup.group_footer_jump_url.get().toStringUtf8();
          l1 = localList.size();
          j = 0;
        }
        label371:
        boolean bool2;
        for (;;)
        {
          if (j >= localList.size()) {
            break label1102;
          }
          paramVarArgs = (DynamicSearch.ResultItem)localList.get(j);
          localObject = paramVarArgs.sub_result_items.get();
          int m = ((List)localObject).size() + 1;
          ArrayList localArrayList4 = new ArrayList(m);
          localArrayList4.add(paramVarArgs);
          localArrayList4.addAll((Collection)localObject);
          int k = 0;
          if (k < m)
          {
            DynamicSearch.ResultItem localResultItem = (DynamicSearch.ResultItem)localArrayList4.get(k);
            paramVarArgs = localResultItem.result_id.get().toStringUtf8();
            bool2 = localResultItem.layout_id.has();
            localObject = localResultItem.name.get().toStringUtf8();
            long l2;
            String str5;
            String str6;
            String str7;
            if (localResultItem.group_mask.has())
            {
              l2 = localResultItem.group_mask.get();
              str5 = localResultItem.pic_url.get().toStringUtf8();
              str6 = localResultItem.jmp_url.get().toStringUtf8();
              str7 = localResultItem.extension.get().toStringUtf8();
              if (!bool2) {
                break label920;
              }
              localObject = null;
              paramVarArgs = (Object[])localObject;
              switch (localResultItem.layout_id.get())
              {
              default: 
                paramVarArgs = (Object[])localObject;
              case 5: 
              case 10: 
                label583:
                if ((paramVarArgs != null) && (paramVarArgs.b()))
                {
                  paramVarArgs.r = localResultItem.seporator_type.get();
                  paramVarArgs.a = bool1;
                  localArrayList3.add(paramVarArgs);
                  l2 = l1;
                }
                break;
              }
            }
            for (;;)
            {
              k += 1;
              l1 = l2;
              break label371;
              bool1 = false;
              break;
              l2 = l3;
              break label448;
              paramVarArgs = new ayob(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayox(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayoc(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayok(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayot(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayoq(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayor(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayoh(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayof(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayoi(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayos(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayop(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              paramVarArgs = new ayon(str1, l3, localArrayList2, localResultItem, i);
              break label583;
              l2 = l1 - 1L;
              continue;
              if (!ayvm.b(l2))
              {
                QLog.e("Q.uniteSearch.NetBaseParser", 1, "itemGroupMask is not valid. mask=" + l2);
                l2 = l1;
              }
              else if (l2 == 2073745984L)
              {
                paramVarArgs = new aypd(str1, str7, -4, str5);
                paramVarArgs.r = localResultItem.seporator_type.get();
                localArrayList3.add(paramVarArgs);
                l2 = l1;
              }
              else
              {
                paramVarArgs = new ayms(str1, paramVarArgs, (String)localObject, str5, str6, str7, l2, localArrayList2, i);
                l2 = l1;
                if (paramVarArgs != null)
                {
                  paramVarArgs.r = localResultItem.seporator_type.get();
                  paramVarArgs.c = bool1;
                  paramVarArgs.g = j;
                  paramVarArgs.h = j;
                  paramVarArgs.a = i;
                  localArrayList3.add(paramVarArgs);
                  l2 = l1;
                }
              }
            }
          }
          j += 1;
        }
        label1102:
        if (l1 > 0L)
        {
          l1 = localResultItemGroup.total_result_count.get();
          paramVarArgs = localResultItemGroup.more_url.get().toStringUtf8();
          localObject = localResultItemGroup.more_name.get().toStringUtf8();
          if (localResultItemGroup.highlight_title_keyword.get() == 1)
          {
            bool2 = true;
            if (localResultItemGroup.hide_title_blank_view.get() != 1) {
              break label1223;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            localArrayList1.add(new aymr(str1, l3, str2, localArrayList3, l1, paramVarArgs, (String)localObject, localArrayList2, bool1, bool2, bool3, str3, str4));
            break;
            bool2 = false;
            break label1159;
          }
        }
      }
    }
    label1159:
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypq
 * JD-Core Version:    0.7.0.1
 */