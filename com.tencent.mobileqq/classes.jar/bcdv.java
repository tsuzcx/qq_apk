import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bcdv
  extends bcff
{
  private long a;
  protected TroopInfo a;
  protected CharSequence a;
  public String a;
  protected List<bcdx> a;
  protected Set<bcdx> a;
  private long b;
  protected String b;
  protected List<String> b;
  protected List<String> c;
  
  public bcdv(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List<bcdx> paramList)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = bbzc.T;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    if (paramQQAppInterface.getProxyManager().a().isUinInRecent(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {
        this.jdField_b_of_type_Long = bbzc.K;
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_Long = bbzc.U;
  }
  
  private long a(aoxz paramaoxz, String paramString1, long paramLong, String paramString2)
  {
    boolean bool = true;
    switch (SearchConfigManager.sReduceDiscussionWeight)
    {
    default: 
      return bcnc.a(paramString2, paramString1, paramLong, false, false, true);
    case 0: 
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {
        bool = false;
      }
      return bcnc.a(paramString2, paramString1, paramLong, false, false, bool);
    }
    if (paramaoxz.isUinInRecent(this.jdField_a_of_type_JavaLangString)) {
      return bcnc.a(paramString2, paramString1, paramLong, false, false, false);
    }
    return bcnc.a(paramString2, paramString1, paramLong, false, false, true);
  }
  
  private long a(List<List<bcdw>> paramList)
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
        localObject = ((bcdw)((List)paramList.get(i)).get(j)).jdField_a_of_type_Bcdx;
        if (!localHashMap3.containsKey(localObject))
        {
          localHashMap3.put(localObject, Integer.valueOf(-1));
          localHashMap1.put(localObject, Long.valueOf(0L));
        }
        l2 = l1;
        if (((bcdw)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long > l1) {
          l2 = ((bcdw)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long;
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
        localHashMap2.put((bcdx)localIterator.next(), Long.valueOf(9223372036854775807L));
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
        bcdx localbcdx;
        while (localIterator.hasNext())
        {
          localbcdx = (bcdx)localIterator.next();
          if (!localHashSet.contains(localbcdx))
          {
            l2 = ((Long)localHashMap2.get(localbcdx)).longValue();
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
          localbcdx = (bcdx)localIterator.next();
          if (!localHashSet.contains(localbcdx)) {
            localHashMap2.put(localbcdx, Long.valueOf(((Long)localHashMap2.get(localbcdx)).longValue() - l1));
          } else {
            localHashMap1.put(localbcdx, Long.valueOf(((Long)localHashMap1.get(localbcdx)).longValue() + l1));
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
      long l3 = ((bcdw)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Long;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.jdField_a_of_type_JavaUtilSet.add(((bcdw)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Bcdx);
      this.jdField_b_of_type_JavaUtilList.add(((bcdw)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_JavaLangString);
      i += 1;
      l1 = l2;
    }
  }
  
  static boolean a(int paramInt, List<List<bcdw>> paramList, long[] paramArrayOfLong, Map<bcdx, Long> paramMap1, int[] paramArrayOfInt, Map<bcdx, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<bcdx> paramSet, Map<bcdx, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    if (i < ((List)paramList.get(paramInt)).size())
    {
      bcdx localbcdx = ((bcdw)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Bcdx;
      if (paramSet.contains(localbcdx)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localbcdx)).longValue() - ((bcdw)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Long;
        if (l == 0L)
        {
          paramSet.add(localbcdx);
          int j = ((Integer)paramMap.get(localbcdx)).intValue();
          if ((j == -1) || (a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)))
          {
            paramMap.put(localbcdx, Integer.valueOf(paramInt));
            paramArrayOfInt[paramInt] = i;
            return true;
          }
        }
        else if (l < ((Long)paramMap2.get(localbcdx)).longValue())
        {
          paramMap2.put(localbcdx, Long.valueOf(l));
        }
      }
    }
    return false;
  }
  
  private Object[] a(bcdx parambcdx, String paramString)
  {
    aoxz localaoxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    long l2 = -9223372036854775808L;
    long l1;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop())
    {
      l1 = bbzc.i;
      l1 = a(localaoxz, parambcdx.c, l1, paramString);
      if (l1 <= -9223372036854775808L) {
        break label193;
      }
      str = parambcdx.c;
      parambcdx.jdField_a_of_type_Int = 66;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {}
      for (long l3 = bbzc.h;; l3 = bbzc.l)
      {
        long l4 = a(localaoxz, parambcdx.jdField_b_of_type_JavaLangString, l3, paramString);
        l2 = l1;
        if (l4 > l1)
        {
          str = parambcdx.jdField_b_of_type_JavaLangString;
          parambcdx.jdField_a_of_type_Int = 88;
          l2 = l4;
        }
        l3 = a(localaoxz, parambcdx.d, l3, paramString);
        l1 = l2;
        if (l3 > l2)
        {
          str = parambcdx.d;
          parambcdx.jdField_a_of_type_Int = 99;
          l1 = l3;
        }
        return new Object[] { Long.valueOf(l1), str };
        l1 = bbzc.q;
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
          Object localObject = (bcdx)this.jdField_a_of_type_JavaUtilList.get(j);
          Object[] arrayOfObject = a((bcdx)localObject, paramString[i]);
          long l = ((Long)arrayOfObject[0]).longValue();
          if ((((bcdx)localObject).jdField_a_of_type_Long == -9223372036854775808L) || (l > ((bcdx)localObject).jdField_a_of_type_Long))
          {
            ((bcdx)localObject).jdField_a_of_type_Long = l;
            ((bcdx)localObject).jdField_b_of_type_Int = ((bcdx)localObject).jdField_a_of_type_Int;
          }
          if (l != -9223372036854775808L)
          {
            localObject = new bcdw();
            ((bcdw)localObject).jdField_a_of_type_Long = l;
            ((bcdw)localObject).jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
            ((bcdw)localObject).jdField_a_of_type_Bcdx = ((bcdx)this.jdField_a_of_type_JavaUtilList.get(j));
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
      localObject3 = a((bcdx)this.jdField_a_of_type_JavaUtilList.get(i), paramString);
      long l2 = ((Long)localObject3[0]).longValue();
      if (l2 <= l1) {
        break label273;
      }
      localObject1 = (bcdx)this.jdField_a_of_type_JavaUtilList.get(i);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopName())) {
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
        localSpannableStringBuilder.append(bcnc.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.c.get(j), 6, false));
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
        localObject = (bcdx)this.jdField_a_of_type_JavaUtilList.get(i);
        k = j;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          if (this.c.size() != 1) {
            break label283;
          }
          m = ((bcdx)localObject).jdField_a_of_type_Int;
          label218:
          if (m != 66) {
            break label293;
          }
          localObject = ((bcdx)localObject).c;
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
          m = ((bcdx)localObject).jdField_b_of_type_Int;
          break label218;
          if (m == 88)
          {
            localObject = ((bcdx)localObject).jdField_b_of_type_JavaLangString;
            break label232;
          }
          k = j;
        } while (m != 99);
        localObject = ((bcdx)localObject).d;
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
    if (bcnc.a(this.jdField_b_of_type_Int))
    {
      String str = ContactUtils.getTroopName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
      alik.a = true;
      alik.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 1, str, false);
      aode.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      bcnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_JavaLangString, "", 1);
      bcnc.a(this.jdField_b_of_type_JavaLangString, 20, 2, paramView);
      bcnc.a(this.jdField_b_of_type_JavaLangString, 20, paramView, false);
      bcnc.a(this, paramView);
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        bcnc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
          break label234;
        }
        bcjs.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      if (SearchConfigManager.needSeparate) {
        bcnc.a("search", "group", "groups", 0, 0, new String[] { bcnc.a(this.jdField_b_of_type_Int) });
      }
      return;
      label234:
      bcjs.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
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
    return ContactUtils.getTroopName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
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
 * Qualified Name:     bcdv
 * JD-Core Version:    0.7.0.1
 */