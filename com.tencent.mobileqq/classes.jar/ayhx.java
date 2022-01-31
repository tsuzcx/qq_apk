import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ayhx
  extends ayjh
{
  private long a;
  protected TroopInfo a;
  protected CharSequence a;
  public String a;
  protected List<ayhz> a;
  protected Set<ayhz> a;
  private long b;
  protected String b;
  protected List<String> b;
  protected List<String> c;
  
  public ayhx(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List<ayhz> paramList)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = aydi.T;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
    if (paramQQAppInterface.a().a().a(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
        this.jdField_b_of_type_Long = aydi.K;
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_Long = aydi.U;
  }
  
  private long a(amjk paramamjk, String paramString1, long paramLong, String paramString2)
  {
    boolean bool = true;
    switch (SearchConfigManager.sReduceDiscussionWeight)
    {
    default: 
      return ayrd.a(paramString2, paramString1, paramLong, false, false, true);
    case 0: 
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
        bool = false;
      }
      return ayrd.a(paramString2, paramString1, paramLong, false, false, bool);
    }
    if (paramamjk.a(this.jdField_a_of_type_JavaLangString)) {
      return ayrd.a(paramString2, paramString1, paramLong, false, false, false);
    }
    return ayrd.a(paramString2, paramString1, paramLong, false, false, true);
  }
  
  private long a(List<List<ayhy>> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int[] arrayOfInt = new int[paramList.size()];
    HashMap localHashMap3 = new HashMap();
    int i = 0;
    int j;
    Object localObject;
    long l2;
    while (i < paramList.size())
    {
      l1 = -9223372036854775808L;
      j = 0;
      while (j < ((List)paramList.get(i)).size())
      {
        localObject = ((ayhy)((List)paramList.get(i)).get(j)).jdField_a_of_type_Ayhz;
        if (!localHashMap3.containsKey(localObject))
        {
          localHashMap3.put(localObject, Integer.valueOf(-1));
          localHashMap1.put(localObject, Long.valueOf(0L));
        }
        l2 = l1;
        if (((ayhy)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long > l1) {
          l2 = ((ayhy)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long;
        }
        j += 1;
        l1 = l2;
      }
      arrayOfLong[i] = l1;
      i += 1;
    }
    i = 0;
    while (i < paramList.size())
    {
      localObject = new boolean[paramList.size()];
      Arrays.fill((boolean[])localObject, false);
      HashSet localHashSet = new HashSet();
      Iterator localIterator = localHashMap1.keySet().iterator();
      while (localIterator.hasNext()) {
        localHashMap2.put((ayhz)localIterator.next(), Long.valueOf(9223372036854775807L));
      }
      for (;;)
      {
        localHashSet.clear();
        Arrays.fill((boolean[])localObject, false);
        if (a(i, paramList, arrayOfLong, localHashMap1, arrayOfInt, localHashMap3, (boolean[])localObject, localHashSet, localHashMap2)) {
          break;
        }
        l1 = 9223372036854775807L;
        localIterator = localHashMap2.keySet().iterator();
        ayhz localayhz;
        while (localIterator.hasNext())
        {
          localayhz = (ayhz)localIterator.next();
          if (!localHashSet.contains(localayhz))
          {
            l2 = ((Long)localHashMap2.get(localayhz)).longValue();
            if (l2 < l1) {
              l1 = l2;
            }
          }
        }
        if ((l1 == 9223372036854775807L) || (l1 == 0L))
        {
          l2 = -9223372036854775808L;
          return l2;
        }
        j = 0;
        if (j <= i)
        {
          if (localObject[j] == 0) {}
          for (;;)
          {
            j += 1;
            break;
            arrayOfLong[j] -= l1;
          }
        }
        localIterator = localHashMap1.keySet().iterator();
        while (localIterator.hasNext())
        {
          localayhz = (ayhz)localIterator.next();
          if (!localHashSet.contains(localayhz)) {
            localHashMap2.put(localayhz, Long.valueOf(((Long)localHashMap2.get(localayhz)).longValue() - l1));
          } else {
            localHashMap1.put(localayhz, Long.valueOf(((Long)localHashMap1.get(localayhz)).longValue() + l1));
          }
        }
      }
      i += 1;
    }
    long l1 = -9223372036854775808L;
    i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= paramList.size()) {
        break;
      }
      long l3 = ((ayhy)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Long;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.jdField_a_of_type_JavaUtilSet.add(((ayhy)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Ayhz);
      this.jdField_b_of_type_JavaUtilList.add(((ayhy)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_JavaLangString);
      i += 1;
      l1 = l2;
    }
  }
  
  static boolean a(int paramInt, List<List<ayhy>> paramList, long[] paramArrayOfLong, Map<ayhz, Long> paramMap1, int[] paramArrayOfInt, Map<ayhz, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<ayhz> paramSet, Map<ayhz, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    if (i < ((List)paramList.get(paramInt)).size())
    {
      ayhz localayhz = ((ayhy)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Ayhz;
      if (paramSet.contains(localayhz)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localayhz)).longValue() - ((ayhy)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Long;
        if (l == 0L)
        {
          paramSet.add(localayhz);
          int j = ((Integer)paramMap.get(localayhz)).intValue();
          if ((j == -1) || (a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)))
          {
            paramMap.put(localayhz, Integer.valueOf(paramInt));
            paramArrayOfInt[paramInt] = i;
            return true;
          }
        }
        else if (l < ((Long)paramMap2.get(localayhz)).longValue())
        {
          paramMap2.put(localayhz, Long.valueOf(l));
        }
      }
    }
    return false;
  }
  
  private Object[] a(ayhz paramayhz, String paramString)
  {
    amjk localamjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    long l2 = -9223372036854775808L;
    long l1;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop())
    {
      l1 = aydi.i;
      l1 = a(localamjk, paramayhz.c, l1, paramString);
      if (l1 <= -9223372036854775808L) {
        break label193;
      }
      str = paramayhz.c;
      paramayhz.jdField_a_of_type_Int = 66;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {}
      for (long l3 = aydi.h;; l3 = aydi.l)
      {
        long l4 = a(localamjk, paramayhz.jdField_b_of_type_JavaLangString, l3, paramString);
        l2 = l1;
        if (l4 > l1)
        {
          str = paramayhz.jdField_b_of_type_JavaLangString;
          paramayhz.jdField_a_of_type_Int = 88;
          l2 = l4;
        }
        l3 = a(localamjk, paramayhz.d, l3, paramString);
        l1 = l2;
        if (l3 > l2)
        {
          str = paramayhz.d;
          paramayhz.jdField_a_of_type_Int = 99;
          l1 = l3;
        }
        return new Object[] { Long.valueOf(l1), str };
        l1 = aydi.q;
        break;
      }
      label193:
      str = null;
      l1 = l2;
    }
  }
  
  private long c(String paramString)
  {
    paramString = paramString.split("\\s+");
    if ((paramString != null) && (paramString.length >= 2))
    {
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      while (i < paramString.length)
      {
        this.c.add(paramString[i]);
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.add(localArrayList2);
        int j = 0;
        while (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject = (ayhz)this.jdField_a_of_type_JavaUtilList.get(j);
          Object[] arrayOfObject = a((ayhz)localObject, paramString[i]);
          long l = ((Long)arrayOfObject[0]).longValue();
          if ((((ayhz)localObject).jdField_a_of_type_Long == -9223372036854775808L) || (l > ((ayhz)localObject).jdField_a_of_type_Long))
          {
            ((ayhz)localObject).jdField_a_of_type_Long = l;
            ((ayhz)localObject).jdField_b_of_type_Int = ((ayhz)localObject).jdField_a_of_type_Int;
          }
          if (l != -9223372036854775808L)
          {
            localObject = new ayhy();
            ((ayhy)localObject).jdField_a_of_type_Long = l;
            ((ayhy)localObject).jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
            ((ayhy)localObject).jdField_a_of_type_Ayhz = ((ayhz)this.jdField_a_of_type_JavaUtilList.get(j));
            localArrayList2.add(localObject);
          }
          j += 1;
        }
        if (localArrayList2.isEmpty()) {
          return -9223372036854775808L;
        }
        i += 1;
      }
      return a(localArrayList1);
    }
    return -9223372036854775808L;
  }
  
  public long a()
  {
    return super.a();
  }
  
  protected long a(String paramString)
  {
    Object localObject2 = null;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    int i = 0;
    long l1 = -9223372036854775808L;
    Object localObject1 = null;
    Object localObject3;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject3 = a((ayhz)this.jdField_a_of_type_JavaUtilList.get(i), paramString);
      long l2 = ((Long)localObject3[0]).longValue();
      if (l2 <= l1) {
        break label273;
      }
      localObject1 = (ayhz)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = (String)localObject3[1];
      l1 = l2;
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaUtilSet.add(localObject2);
        this.jdField_b_of_type_JavaUtilList.add(localObject1);
        this.c.add(paramString);
      }
      if (l1 > this.jdField_a_of_type_Long) {
        this.jdField_a_of_type_Long = l1;
      }
      if (this.jdField_a_of_type_Long == -9223372036854775808L)
      {
        l1 = c(paramString);
        if (l1 > this.jdField_a_of_type_Long) {
          this.jdField_a_of_type_Long = l1;
        }
      }
      if (this.jdField_a_of_type_Long != -9223372036854775808L)
      {
        this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
        a();
      }
      return this.jdField_a_of_type_Long;
      label273:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopName())) {
      return c();
    }
    return super.a();
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localSpannableStringBuilder.append("包含: ");
      int j = this.jdField_b_of_type_JavaUtilList.size() - 1;
      int i = 0;
      if (j >= 0)
      {
        k = 1;
        label45:
        if (i >= 10) {
          break label124;
        }
      }
      label124:
      for (int m = 1;; m = 0)
      {
        if ((m & k) == 0) {
          break label130;
        }
        localSpannableStringBuilder.append(ayrd.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.c.get(j), 6, false));
        i += 1;
        localSpannableStringBuilder.append("、");
        j -= 1;
        break;
        k = 0;
        break label45;
      }
      label130:
      int k = 0;
      j = i;
      i = k;
      label151:
      label160:
      Object localObject;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        k = 1;
        if (j >= 10) {
          break label277;
        }
        m = 1;
        if ((m & k) == 0) {
          break label329;
        }
        localObject = (ayhz)this.jdField_a_of_type_JavaUtilList.get(i);
        k = j;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          if (this.c.size() != 1) {
            break label283;
          }
          m = ((ayhz)localObject).jdField_a_of_type_Int;
          label218:
          if (m != 66) {
            break label293;
          }
          localObject = ((ayhz)localObject).c;
        }
      }
      for (;;)
      {
        label232:
        k = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k = j + 1;
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.append("、");
        }
        label277:
        label283:
        label293:
        do
        {
          i += 1;
          j = k;
          break;
          k = 0;
          break label151;
          m = 0;
          break label160;
          m = ((ayhz)localObject).jdField_b_of_type_Int;
          break label218;
          if (m == 88)
          {
            localObject = ((ayhz)localObject).jdField_b_of_type_JavaLangString;
            break label232;
          }
          k = j;
        } while (m != 99);
        localObject = ((ayhz)localObject).d;
      }
    }
    label329:
    if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、'))
    {
      this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1);
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (ayrd.a(this.jdField_b_of_type_Int))
    {
      String str = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
      ajgm.a = true;
      ajgm.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 1, str, false);
      alxr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      ayrd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_JavaLangString, "", 1);
      ayrd.a(this.jdField_b_of_type_JavaLangString, 20, 2, paramView);
      ayrd.a(this.jdField_b_of_type_JavaLangString, 20, paramView, false);
      ayrd.a(this, paramView);
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        ayrd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
          break label234;
        }
        aynt.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      if (SearchConfigManager.needSeparate) {
        ayrd.a("search", "group", "groups", 0, 0, new String[] { ayrd.a(this.jdField_b_of_type_Int) });
      }
      return;
      label234:
      aynt.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int c()
  {
    return 4;
  }
  
  public CharSequence c()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String c()
  {
    return bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
  }
  
  public int d()
  {
    return 1;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int e()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhx
 * JD-Core Version:    0.7.0.1
 */