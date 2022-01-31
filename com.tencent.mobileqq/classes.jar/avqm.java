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
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unify.search.UnifySearchCommon.ResultItemGroup;

public class avqm
  implements avqi<avom>
{
  private boolean a;
  
  public List<avom> a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 3)) {
      return null;
    }
    String str1 = "";
    if ((paramVarArgs[0] instanceof String)) {
      str1 = (String)paramVarArgs[0];
    }
    if ((paramVarArgs[1] instanceof List)) {}
    int i;
    ArrayList localArrayList1;
    UnifySearchCommon.ResultItemGroup localResultItemGroup;
    long l3;
    String str2;
    ArrayList localArrayList2;
    for (Object localObject = (List)paramVarArgs[1];; localObject = new ArrayList())
    {
      i = -1;
      if ((paramVarArgs[2] instanceof Integer)) {
        i = ((Integer)paramVarArgs[2]).intValue();
      }
      localArrayList1 = new ArrayList(((List)localObject).size());
      Iterator localIterator = ((List)localObject).iterator();
      if (!localIterator.hasNext()) {
        break label1241;
      }
      localResultItemGroup = (UnifySearchCommon.ResultItemGroup)localIterator.next();
      l3 = localResultItemGroup.group_mask.get();
      str2 = localResultItemGroup.group_name.get().toStringUtf8();
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
        break label1244;
      }
      bool1 = true;
    }
    label458:
    label595:
    label1114:
    label1244:
    for (;;)
    {
      String str3 = localResultItemGroup.group_footer_name.get().toStringUtf8();
      String str4 = localResultItemGroup.group_footer_jump_url.get().toStringUtf8();
      long l1 = localList.size();
      int j = 0;
      label381:
      boolean bool2;
      for (;;)
      {
        if (j >= localList.size()) {
          break label1114;
        }
        paramVarArgs = (UnifySearchCommon.ResultItem)localList.get(j);
        localObject = paramVarArgs.sub_result_items.get();
        int m = ((List)localObject).size() + 1;
        ArrayList localArrayList4 = new ArrayList(m);
        localArrayList4.add(paramVarArgs);
        localArrayList4.addAll((Collection)localObject);
        int k = 0;
        if (k < m)
        {
          UnifySearchCommon.ResultItem localResultItem = (UnifySearchCommon.ResultItem)localArrayList4.get(k);
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
              break label932;
            }
            localObject = null;
            paramVarArgs = (Object[])localObject;
            switch (localResultItem.layout_id.get())
            {
            default: 
              paramVarArgs = (Object[])localObject;
            case 5: 
            case 10: 
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
            break label381;
            bool1 = false;
            break;
            l2 = l3;
            break label458;
            paramVarArgs = new avou(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpq(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avov(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpd(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpm(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpj(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpk(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpa(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avoy(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpb(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpl(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpi(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            paramVarArgs = new avpg(str1, l3, localArrayList2, localResultItem, i);
            break label595;
            l2 = l1 - 1L;
            continue;
            if (!avwf.b(l2))
            {
              QLog.e("Q.uniteSearch.NetBaseParser", 1, "itemGroupMask is not valid. mask=" + l2);
              l2 = l1;
            }
            else if (l2 == 2073745984L)
            {
              paramVarArgs = new avpw(str1, str7, -4, str5);
              paramVarArgs.r = localResultItem.seporator_type.get();
              localArrayList3.add(paramVarArgs);
              l2 = l1;
            }
            else
            {
              paramVarArgs = new avnl(str1, paramVarArgs, (String)localObject, str5, str6, str7, l2, localArrayList2, i);
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
      if (l1 <= 0L) {
        break;
      }
      l1 = localResultItemGroup.total_result_count.get();
      paramVarArgs = localResultItemGroup.more_url.get().toStringUtf8();
      localObject = localResultItemGroup.more_name.get().toStringUtf8();
      if (localResultItemGroup.highlight_title_keyword.get() == 1)
      {
        bool2 = true;
        if (localResultItemGroup.hide_title_blank_view.get() != 1) {
          break label1235;
        }
      }
      for (boolean bool3 = true;; bool3 = false)
      {
        localArrayList1.add(new avnk(str1, l3, str2, localArrayList3, l1, paramVarArgs, (String)localObject, localArrayList2, bool1, bool2, bool3, str3, str4));
        break;
        bool2 = false;
        break label1171;
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
 * Qualified Name:     avqm
 * JD-Core Version:    0.7.0.1
 */