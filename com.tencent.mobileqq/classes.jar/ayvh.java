import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.ArrayList;
import java.util.ArrayList<Lahip;>;
import java.util.Iterator;
import java.util.List;

public class ayvh
{
  public static int a;
  public static String a;
  public static long[] a;
  public static String b;
  
  public static int a(ArrayList<ahip> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return 2;
    }
    int i = 2;
    Object localObject1 = "";
    Iterator localIterator1 = paramArrayList.iterator();
    paramArrayList = (ArrayList<ahip>)localObject1;
    while (localIterator1.hasNext())
    {
      localObject1 = (ahip)localIterator1.next();
      if (localObject1 != null)
      {
        int j = i;
        if (((ahip)localObject1).jdField_a_of_type_Int == 80000001)
        {
          j = i;
          if (((ahip)localObject1).b != null)
          {
            j = i;
            if (((ahip)localObject1).b.size() > 0)
            {
              Iterator localIterator2 = ((ahip)localObject1).b.iterator();
              do
              {
                j = i;
                if (!localIterator2.hasNext()) {
                  break;
                }
                localObject2 = (AccountSearchPb.record)localIterator2.next();
              } while (localObject2 == null);
              Object localObject2 = String.valueOf(((AccountSearchPb.record)localObject2).code.get());
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramString))) {}
              for (i = 1;; i = 2)
              {
                ayvm.a("add_page", "all_result", "exp_grp", 0, i, new String[] { localObject2, "", paramString, "" });
                break;
              }
            }
          }
        }
        switch (((ahip)localObject1).jdField_a_of_type_Int)
        {
        }
        for (;;)
        {
          i = j;
          break;
          if (TextUtils.isEmpty(paramArrayList))
          {
            paramArrayList = "1";
          }
          else
          {
            paramArrayList = paramArrayList + "::1";
            continue;
            if (TextUtils.isEmpty(paramArrayList))
            {
              paramArrayList = "2";
            }
            else
            {
              paramArrayList = paramArrayList + "::2";
              continue;
              if (TextUtils.isEmpty(paramArrayList))
              {
                paramArrayList = "3";
              }
              else
              {
                paramArrayList = paramArrayList + "::3";
                continue;
                if (TextUtils.isEmpty(paramArrayList)) {
                  paramArrayList = "4";
                } else {
                  paramArrayList = paramArrayList + "::4";
                }
              }
            }
          }
        }
      }
    }
    ayvm.a("add_page", "all_result", "exp", 0, i, new String[] { "", paramArrayList, paramString, "" });
    return i;
  }
  
  public static int a(List<aynu> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 2;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (aynu)paramList.next();
      if ((localObject instanceof ayms))
      {
        localObject = (ayms)localObject;
        if ((((ayms)localObject).d() == 1002) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((ayms)localObject).b()))) {
          return 1;
        }
      }
    }
    return 2;
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_ArrayOfLong = null;
    jdField_a_of_type_JavaLangString = null;
    b = null;
  }
  
  public static void a(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
    jdField_a_of_type_JavaLangString = paramString1;
    b = paramString2;
  }
  
  public static void a(ayms paramayms)
  {
    if ((paramayms == null) || (paramayms.d() != 1002)) {}
    String str1;
    String str2;
    String str3;
    int i;
    long[] arrayOfLong;
    do
    {
      return;
      str1 = paramayms.a();
      str2 = paramayms.b();
      str3 = paramayms.d();
      i = paramayms.h;
      paramayms = i + 1 + "";
      if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2))) {}
      for (i = 1;; i = 2)
      {
        arrayOfLong = jdField_a_of_type_ArrayOfLong;
        if ((arrayOfLong == null) || (arrayOfLong.length != 2) || (arrayOfLong[0] != 1001L) || (arrayOfLong[1] != 1002L)) {
          break;
        }
        ayvm.a("all_search", "user_grp", "clk_grp", 0, i, new String[] { str2, paramayms, str1, str3 });
        return;
      }
    } while ((arrayOfLong == null) || (arrayOfLong.length != 1) || (arrayOfLong[0] != 1002L));
    ayvm.a("all_search", "more_grp", "clk_grp", 0, i, new String[] { str2, paramayms, str1, str3 });
  }
  
  public static void a(List<aynu> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    long[] arrayOfLong;
    do
    {
      return;
      arrayOfLong = jdField_a_of_type_ArrayOfLong;
    } while ((arrayOfLong == null) || (arrayOfLong.length != 2) || (arrayOfLong[0] != 1001L) || (arrayOfLong[1] != 1002L));
    ayvm.a("all_search", "user_grp", "clk_more_grp", 0, a(paramList, paramString), new String[] { "", "", paramString, "" });
  }
  
  public static void a(List<ayns> paramList, List<aynt> paramList1, boolean paramBoolean, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    int j = 2;
    if ((paramList1 != null) && (paramList1.size() > 0)) {}
    String str;
    for (paramString1 = "1";; paramString1 = "2")
    {
      str = "";
      if ((paramArrayOfLong == null) || (paramArrayOfLong.length != 2) || (paramArrayOfLong[0] != 1001L) || (paramArrayOfLong[1] != 1002L)) {
        break label418;
      }
      if (!paramBoolean) {
        break;
      }
      return;
    }
    paramArrayOfLong = str;
    int i = j;
    if (paramList1 != null)
    {
      paramArrayOfLong = str;
      i = j;
      if (paramList1.size() > 0)
      {
        paramList1 = paramList1.iterator();
        paramList = str;
        label103:
        paramArrayOfLong = paramList;
        i = j;
        if (paramList1.hasNext())
        {
          paramArrayOfLong = (aynt)paramList1.next();
          if ((!(paramArrayOfLong instanceof aymr)) || (paramArrayOfLong.a() == null)) {
            break label823;
          }
          paramArrayOfLong = (aymr)paramArrayOfLong;
          if (paramArrayOfLong.a == 1001L) {
            if (TextUtils.isEmpty(paramList)) {
              paramList = "1";
            }
          }
        }
      }
    }
    label418:
    label814:
    label823:
    for (;;)
    {
      break label103;
      paramList = paramList + "::1";
      continue;
      if (paramArrayOfLong.a == 1002L)
      {
        if (TextUtils.isEmpty(paramList)) {}
        for (paramList = "2";; paramList = paramList + "::2")
        {
          paramArrayOfLong = paramArrayOfLong.a();
          j = a(paramArrayOfLong, paramString2);
          paramArrayOfLong = paramArrayOfLong.iterator();
          while (paramArrayOfLong.hasNext())
          {
            paramString1 = (aynu)paramArrayOfLong.next();
            if ((paramString1 instanceof ayms))
            {
              paramString1 = (ayms)paramString1;
              if (paramString1.d() == 1002)
              {
                i = paramString1.h;
                str = i + 1 + "";
                ayvm.a("all_search", "user_grp", "exp_grp", 0, j, new String[] { paramString1.b(), str, paramString2, paramString1.d() });
              }
            }
          }
        }
        ayvm.a("all_search", "user_grp", "exp", 0, i, new String[] { "", paramArrayOfLong, paramString2, "" });
        return;
        if ((paramArrayOfLong == null) || (paramArrayOfLong.length != 1) || (paramArrayOfLong[0] != 1002L)) {
          break;
        }
        if ((paramBoolean) && (paramList != null) && (!paramList.isEmpty()))
        {
          paramList = paramList.iterator();
          i = 0;
          while (paramList.hasNext())
          {
            if (!((ayns)paramList.next() instanceof ayms)) {
              break label814;
            }
            i += 1;
          }
        }
        for (;;)
        {
          int k = j;
          if (paramList1 != null)
          {
            k = j;
            if (paramList1.size() > 0)
            {
              paramList = paramList1.iterator();
              do
              {
                do
                {
                  k = j;
                  if (!paramList.hasNext()) {
                    break;
                  }
                  paramList1 = (aynt)paramList.next();
                } while ((!(paramList1 instanceof aymr)) || (paramList1.a() == null));
                paramList1 = (aymr)paramList1;
              } while (paramList1.a != 1002L);
              paramList = paramList1.a();
              j = a(paramList, paramString2);
              k = j;
              if (paramList != null)
              {
                paramList = paramList.iterator();
                for (;;)
                {
                  k = j;
                  if (!paramList.hasNext()) {
                    break;
                  }
                  paramList1 = (aynu)paramList.next();
                  if ((paramList1 instanceof ayms))
                  {
                    paramList1 = (ayms)paramList1;
                    if (paramList1.d() == 1002)
                    {
                      paramList1.h += i;
                      k = paramList1.h;
                      paramArrayOfLong = k + 1 + "";
                      ayvm.a("all_search", "more_grp", "exp_grp", 0, j, new String[] { paramList1.b(), paramArrayOfLong, paramString2, paramList1.d() });
                    }
                  }
                }
              }
            }
          }
          if (paramBoolean)
          {
            ayvm.a("all_search", "more_grp", "load_more", 0, k, new String[] { paramString1, "", paramString2, "" });
            return;
          }
          ayvm.a("all_search", "more_grp", "exp", 0, k, new String[] { paramString1, "", paramString2, "" });
          return;
          break;
          i = 0;
        }
      }
    }
  }
  
  public static void b(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    a(paramInt, paramArrayOfLong, paramString1, paramString2);
    if (paramInt == 2) {}
    for (paramString1 = "2";; paramString1 = "1")
    {
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 2) && (paramArrayOfLong[0] == 1001L) && (paramArrayOfLong[1] == 1002L)) {
        ayvm.a("all_search", "user_grp", "search_cnt", 0, 0, new String[] { "", paramString1, paramString2, "" });
      }
      while ((paramArrayOfLong == null) || (paramArrayOfLong.length != 1) || (paramArrayOfLong[0] != 1002L)) {
        return;
      }
      ayvm.a("all_search", "more_grp", "search_cnt", 0, 0, new String[] { "", paramString1, paramString2, "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvh
 * JD-Core Version:    0.7.0.1
 */