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

public class aymg
  extends aynq
{
  private long a;
  protected TroopInfo a;
  protected CharSequence a;
  public String a;
  protected List<aymi> a;
  protected Set<aymi> a;
  private long b;
  protected String b;
  protected List<String> b;
  protected List<String> c;
  
  public aymg(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List<aymi> paramList)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = ayhr.T;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
    if (paramQQAppInterface.a().a().a(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
        this.jdField_b_of_type_Long = ayhr.K;
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_Long = ayhr.U;
  }
  
  private long a(amnz paramamnz, String paramString1, long paramLong, String paramString2)
  {
    boolean bool = true;
    switch (SearchConfigManager.sReduceDiscussionWeight)
    {
    default: 
      return ayvm.a(paramString2, paramString1, paramLong, false, false, true);
    case 0: 
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
        bool = false;
      }
      return ayvm.a(paramString2, paramString1, paramLong, false, false, bool);
    }
    if (paramamnz.a(this.jdField_a_of_type_JavaLangString)) {
      return ayvm.a(paramString2, paramString1, paramLong, false, false, false);
    }
    return ayvm.a(paramString2, paramString1, paramLong, false, false, true);
  }
  
  private long a(List<List<aymh>> paramList)
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
        localObject = ((aymh)((List)paramList.get(i)).get(j)).jdField_a_of_type_Aymi;
        if (!localHashMap3.containsKey(localObject))
        {
          localHashMap3.put(localObject, Integer.valueOf(-1));
          localHashMap1.put(localObject, Long.valueOf(0L));
        }
        l2 = l1;
        if (((aymh)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long > l1) {
          l2 = ((aymh)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long;
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
        localHashMap2.put((aymi)localIterator.next(), Long.valueOf(9223372036854775807L));
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
        aymi localaymi;
        while (localIterator.hasNext())
        {
          localaymi = (aymi)localIterator.next();
          if (!localHashSet.contains(localaymi))
          {
            l2 = ((Long)localHashMap2.get(localaymi)).longValue();
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
          localaymi = (aymi)localIterator.next();
          if (!localHashSet.contains(localaymi)) {
            localHashMap2.put(localaymi, Long.valueOf(((Long)localHashMap2.get(localaymi)).longValue() - l1));
          } else {
            localHashMap1.put(localaymi, Long.valueOf(((Long)localHashMap1.get(localaymi)).longValue() + l1));
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
      long l3 = ((aymh)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Long;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.jdField_a_of_type_JavaUtilSet.add(((aymh)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Aymi);
      this.jdField_b_of_type_JavaUtilList.add(((aymh)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_JavaLangString);
      i += 1;
      l1 = l2;
    }
  }
  
  static boolean a(int paramInt, List<List<aymh>> paramList, long[] paramArrayOfLong, Map<aymi, Long> paramMap1, int[] paramArrayOfInt, Map<aymi, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<aymi> paramSet, Map<aymi, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    if (i < ((List)paramList.get(paramInt)).size())
    {
      aymi localaymi = ((aymh)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Aymi;
      if (paramSet.contains(localaymi)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localaymi)).longValue() - ((aymh)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Long;
        if (l == 0L)
        {
          paramSet.add(localaymi);
          int j = ((Integer)paramMap.get(localaymi)).intValue();
          if ((j == -1) || (a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)))
          {
            paramMap.put(localaymi, Integer.valueOf(paramInt));
            paramArrayOfInt[paramInt] = i;
            return true;
          }
        }
        else if (l < ((Long)paramMap2.get(localaymi)).longValue())
        {
          paramMap2.put(localaymi, Long.valueOf(l));
        }
      }
    }
    return false;
  }
  
  private Object[] a(aymi paramaymi, String paramString)
  {
    amnz localamnz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    long l2 = -9223372036854775808L;
    long l1;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop())
    {
      l1 = ayhr.i;
      l1 = a(localamnz, paramaymi.c, l1, paramString);
      if (l1 <= -9223372036854775808L) {
        break label193;
      }
      str = paramaymi.c;
      paramaymi.jdField_a_of_type_Int = 66;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {}
      for (long l3 = ayhr.h;; l3 = ayhr.l)
      {
        long l4 = a(localamnz, paramaymi.jdField_b_of_type_JavaLangString, l3, paramString);
        l2 = l1;
        if (l4 > l1)
        {
          str = paramaymi.jdField_b_of_type_JavaLangString;
          paramaymi.jdField_a_of_type_Int = 88;
          l2 = l4;
        }
        l3 = a(localamnz, paramaymi.d, l3, paramString);
        l1 = l2;
        if (l3 > l2)
        {
          str = paramaymi.d;
          paramaymi.jdField_a_of_type_Int = 99;
          l1 = l3;
        }
        return new Object[] { Long.valueOf(l1), str };
        l1 = ayhr.q;
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
          Object localObject = (aymi)this.jdField_a_of_type_JavaUtilList.get(j);
          Object[] arrayOfObject = a((aymi)localObject, paramString[i]);
          long l = ((Long)arrayOfObject[0]).longValue();
          if ((((aymi)localObject).jdField_a_of_type_Long == -9223372036854775808L) || (l > ((aymi)localObject).jdField_a_of_type_Long))
          {
            ((aymi)localObject).jdField_a_of_type_Long = l;
            ((aymi)localObject).jdField_b_of_type_Int = ((aymi)localObject).jdField_a_of_type_Int;
          }
          if (l != -9223372036854775808L)
          {
            localObject = new aymh();
            ((aymh)localObject).jdField_a_of_type_Long = l;
            ((aymh)localObject).jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
            ((aymh)localObject).jdField_a_of_type_Aymi = ((aymi)this.jdField_a_of_type_JavaUtilList.get(j));
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
      localObject3 = a((aymi)this.jdField_a_of_type_JavaUtilList.get(i), paramString);
      long l2 = ((Long)localObject3[0]).longValue();
      if (l2 <= l1) {
        break label273;
      }
      localObject1 = (aymi)this.jdField_a_of_type_JavaUtilList.get(i);
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
        localSpannableStringBuilder.append(ayvm.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.c.get(j), 6, false));
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
        localObject = (aymi)this.jdField_a_of_type_JavaUtilList.get(i);
        k = j;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          if (this.c.size() != 1) {
            break label283;
          }
          m = ((aymi)localObject).jdField_a_of_type_Int;
          label218:
          if (m != 66) {
            break label293;
          }
          localObject = ((aymi)localObject).c;
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
          m = ((aymi)localObject).jdField_b_of_type_Int;
          break label218;
          if (m == 88)
          {
            localObject = ((aymi)localObject).jdField_b_of_type_JavaLangString;
            break label232;
          }
          k = j;
        } while (m != 99);
        localObject = ((aymi)localObject).d;
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
    if (ayvm.a(this.jdField_b_of_type_Int))
    {
      String str = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
      ajlb.a = true;
      ajlb.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 1, str, false);
      amcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      ayvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_JavaLangString, "", 1);
      ayvm.a(this.jdField_b_of_type_JavaLangString, 20, 2, paramView);
      ayvm.a(this.jdField_b_of_type_JavaLangString, 20, paramView, false);
      ayvm.a(this, paramView);
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        ayvm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
          break label234;
        }
        aysc.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      if (SearchConfigManager.needSeparate) {
        ayvm.a("search", "group", "groups", 0, 0, new String[] { ayvm.a(this.jdField_b_of_type_Int) });
      }
      return;
      label234:
      aysc.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
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
    return bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
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
 * Qualified Name:     aymg
 * JD-Core Version:    0.7.0.1
 */