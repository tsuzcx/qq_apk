import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
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

public class awmq
  extends awoe
{
  private long jdField_a_of_type_Long;
  private ajxl jdField_a_of_type_Ajxl;
  private DiscussionInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private List<DiscussionMemberInfo> jdField_a_of_type_JavaUtilList;
  private Set<DiscussionMemberInfo> jdField_a_of_type_JavaUtilSet;
  boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = awii.L;
  private String jdField_b_of_type_JavaLangString;
  private List<String> jdField_b_of_type_JavaUtilList;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private List<String> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  
  public awmq(QQAppInterface paramQQAppInterface, int paramInt1, DiscussionInfo paramDiscussionInfo, List<DiscussionMemberInfo> paramList, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    this.jdField_a_of_type_Ajxl = ((ajxl)paramQQAppInterface.getManager(51));
    if (!paramDiscussionInfo.hasRenamed()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      return;
    }
  }
  
  private long a(aktf paramaktf, String paramString1, long paramLong, String paramString2)
  {
    switch (SearchConfigManager.sReduceDiscussionWeight)
    {
    default: 
      return awwa.a(paramString2, paramString1, paramLong);
    case 0: 
      return awwa.a(paramString2, paramString1, paramLong);
    }
    if (paramaktf.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin)) {
      return awwa.a(paramString2, paramString1, paramLong, true, false, false);
    }
    return awwa.a(paramString2, paramString1, paramLong);
  }
  
  private long a(List<List<awmr>> paramList)
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
        localObject = ((awmr)((List)paramList.get(i)).get(j)).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
        if (!localHashMap3.containsKey(localObject))
        {
          localHashMap3.put(localObject, Integer.valueOf(-1));
          localHashMap1.put(localObject, Long.valueOf(0L));
        }
        l2 = l1;
        if (((awmr)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long > l1) {
          l2 = ((awmr)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long;
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
        localHashMap2.put((DiscussionMemberInfo)localIterator.next(), Long.valueOf(9223372036854775807L));
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
        DiscussionMemberInfo localDiscussionMemberInfo;
        while (localIterator.hasNext())
        {
          localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
          if (!localHashSet.contains(localDiscussionMemberInfo))
          {
            l2 = ((Long)localHashMap2.get(localDiscussionMemberInfo)).longValue();
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
          localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
          if (!localHashSet.contains(localDiscussionMemberInfo)) {
            localHashMap2.put(localDiscussionMemberInfo, Long.valueOf(((Long)localHashMap2.get(localDiscussionMemberInfo)).longValue() - l1));
          } else {
            localHashMap1.put(localDiscussionMemberInfo, Long.valueOf(((Long)localHashMap1.get(localDiscussionMemberInfo)).longValue() + l1));
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
      long l3 = ((awmr)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Long;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.jdField_a_of_type_JavaUtilSet.add(((awmr)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo);
      this.jdField_b_of_type_JavaUtilList.add(((awmr)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_JavaLangString);
      i += 1;
      l1 = l2;
    }
  }
  
  private void a()
  {
    int i = 0;
    int n = 0;
    if ((awwa.a(this.jdField_b_of_type_Int)) || (this.jdField_b_of_type_Int == 5))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localSpannableStringBuilder.append("包含: ");
        int j = this.jdField_b_of_type_JavaUtilList.size() - 1;
        i = 0;
        if (j >= 0)
        {
          k = 1;
          label67:
          if (i >= 10) {
            break label157;
          }
        }
        label157:
        for (int m = 1;; m = 0)
        {
          if ((m & k) == 0) {
            break label163;
          }
          localSpannableStringBuilder.append(awwa.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.jdField_c_of_type_JavaUtilList.get(j), 6));
          i += 1;
          if (i < this.jdField_a_of_type_JavaUtilList.size()) {
            localSpannableStringBuilder.append("、");
          }
          j -= 1;
          break;
          k = 0;
          break label67;
        }
        label163:
        int k = 0;
        j = i;
        i = k;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          k = 1;
          label184:
          if (j >= 10) {
            break label307;
          }
          m = 1;
          label193:
          if ((m & k) == 0) {
            break label323;
          }
          localObject = (DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          k = j;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject)) {
            if (((DiscussionMemberInfo)localObject).inteRemark == null) {
              break label313;
            }
          }
        }
        label307:
        label313:
        for (localObject = ((DiscussionMemberInfo)localObject).inteRemark;; localObject = ((DiscussionMemberInfo)localObject).memberName)
        {
          k = j;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            j += 1;
            localSpannableStringBuilder.append((CharSequence)localObject);
            k = j;
            if (j < this.jdField_a_of_type_JavaUtilList.size())
            {
              localSpannableStringBuilder.append("、");
              k = j;
            }
          }
          i += 1;
          j = k;
          break;
          k = 0;
          break label184;
          m = 0;
          break label193;
        }
      }
      label323:
      this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder;
      localObject = new StringBuilder().append("(");
      i = n;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
      this.jdField_c_of_type_JavaLangCharSequence = (i + ajya.a(2131702528));
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = ajya.a(2131702585);
    Object localObject = new SpannableStringBuilder();
    if (!this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasRenamed())
    {
      ((SpannableStringBuilder)localObject).append("(");
      if (this.jdField_a_of_type_JavaUtilList != null) {
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
      ((SpannableStringBuilder)localObject).append(String.valueOf(i));
      ((SpannableStringBuilder)localObject).append(")");
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaLangCharSequence = ((CharSequence)localObject);
      return;
      if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        ((SpannableStringBuilder)localObject).append("(");
        i = this.jdField_b_of_type_JavaUtilList.size() - 1;
        while (i >= 0)
        {
          ((SpannableStringBuilder)localObject).append(awwa.a((String)this.jdField_b_of_type_JavaUtilList.get(i), (String)this.jdField_c_of_type_JavaUtilList.get(i), 6));
          if (i > 0) {
            ((SpannableStringBuilder)localObject).append("、");
          }
          i -= 1;
        }
        ((SpannableStringBuilder)localObject).append(")");
      }
    }
  }
  
  static boolean a(int paramInt, List<List<awmr>> paramList, long[] paramArrayOfLong, Map<DiscussionMemberInfo, Long> paramMap1, int[] paramArrayOfInt, Map<DiscussionMemberInfo, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<DiscussionMemberInfo> paramSet, Map<DiscussionMemberInfo, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    if (i < ((List)paramList.get(paramInt)).size())
    {
      DiscussionMemberInfo localDiscussionMemberInfo = ((awmr)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
      if (paramSet.contains(localDiscussionMemberInfo)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localDiscussionMemberInfo)).longValue() - ((awmr)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Long;
        if (l == 0L)
        {
          paramSet.add(localDiscussionMemberInfo);
          int j = ((Integer)paramMap.get(localDiscussionMemberInfo)).intValue();
          if ((j == -1) || (a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)))
          {
            paramMap.put(localDiscussionMemberInfo, Integer.valueOf(paramInt));
            paramArrayOfInt[paramInt] = i;
            return true;
          }
        }
        else if (l < ((Long)paramMap2.get(localDiscussionMemberInfo)).longValue())
        {
          paramMap2.put(localDiscussionMemberInfo, Long.valueOf(l));
        }
      }
    }
    return false;
  }
  
  private Object[] a(DiscussionMemberInfo paramDiscussionMemberInfo, String paramString)
  {
    aktf localaktf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    long l2 = -9223372036854775808L;
    long l1 = a(localaktf, paramDiscussionMemberInfo.inteRemark, awii.k, paramString);
    String str;
    if (l1 > -9223372036854775808L)
    {
      str = paramDiscussionMemberInfo.inteRemark;
      l2 = l1;
    }
    for (;;)
    {
      long l3 = a(localaktf, paramDiscussionMemberInfo.memberName, awii.l, paramString);
      l1 = l2;
      if (l3 > l2)
      {
        str = paramDiscussionMemberInfo.memberName;
        l1 = l3;
      }
      Friends localFriends = this.jdField_a_of_type_Ajxl.b(paramDiscussionMemberInfo.memberUin);
      paramDiscussionMemberInfo = str;
      l3 = l1;
      if (localFriends != null)
      {
        paramDiscussionMemberInfo = str;
        l3 = l1;
        if (localFriends.isFriend())
        {
          l3 = a(localaktf, localFriends.remark, awii.j, paramString);
          paramDiscussionMemberInfo = str;
          l2 = l1;
          if (l3 > l1)
          {
            paramDiscussionMemberInfo = localFriends.remark;
            l2 = l3;
          }
          l1 = a(localaktf, localFriends.name, awii.l, paramString);
          l3 = l2;
          if (l1 > l2)
          {
            paramDiscussionMemberInfo = localFriends.name;
            l3 = l1;
          }
        }
      }
      return new Object[] { Long.valueOf(l3), paramDiscussionMemberInfo };
      str = null;
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
        this.jdField_c_of_type_JavaUtilList.add(paramString[i]);
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.add(localArrayList2);
        int j = 0;
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j)).memberUin.equals(this.jdField_b_of_type_JavaLangString)) {}
          for (;;)
          {
            j += 1;
            break;
            Object[] arrayOfObject = a((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j), paramString[i]);
            long l = ((Long)arrayOfObject[0]).longValue();
            if (l != -9223372036854775808L)
            {
              awmr localawmr = new awmr();
              localawmr.jdField_a_of_type_Long = l;
              localawmr.jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
              localawmr.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo = ((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j));
              localArrayList2.add(localawmr);
            }
          }
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
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    if (!this.jdField_c_of_type_Boolean)
    {
      l1 = awwa.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, awii.e);
      if (l1 > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_Boolean = true;
      }
    }
    Object localObject1 = null;
    Object localObject2 = null;
    long l1 = -9223372036854775808L;
    int i = 0;
    Object localObject3;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i)).memberUin.equals(this.jdField_b_of_type_JavaLangString))
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localObject3 = a((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramString);
      long l2 = ((Long)localObject3[0]).longValue();
      if (l2 > l1)
      {
        localObject2 = (DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        localObject1 = (String)localObject3[1];
        l1 = l2;
        continue;
        if (localObject1 != null)
        {
          this.jdField_a_of_type_JavaUtilSet.add(localObject1);
          this.jdField_b_of_type_JavaUtilList.add(localObject2);
          this.jdField_c_of_type_JavaUtilList.add(paramString);
        }
        if (l1 > this.jdField_a_of_type_Long)
        {
          this.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_Boolean = false;
        }
        if (this.jdField_a_of_type_Long == -9223372036854775808L)
        {
          l1 = c(paramString);
          if (l1 > this.jdField_a_of_type_Long)
          {
            this.jdField_a_of_type_Long = l1;
            this.jdField_a_of_type_Boolean = false;
          }
        }
        if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_JavaUtilList.size())
        {
          i = 1;
          this.jdField_b_of_type_Long = awii.A;
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          if (i != 0)
          {
            this.jdField_b_of_type_Long = awii.y;
            label389:
            if (this.jdField_a_of_type_Long != -9223372036854775808L)
            {
              this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
              a();
            }
            return this.jdField_a_of_type_Long;
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilSet.size() != this.jdField_a_of_type_JavaUtilList.size() - 1) {
            break label564;
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
          } while ((paramString == null) || (!paramString.equals(((DiscussionMemberInfo)localObject2).memberUin)));
        }
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            i = 1;
            break;
            if (paramString.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin))
            {
              if (this.jdField_a_of_type_Boolean)
              {
                this.jdField_b_of_type_Long = awii.A;
                break label389;
              }
              this.jdField_b_of_type_Long = awii.J;
              break label389;
            }
            this.jdField_b_of_type_Long = awii.L;
            break label389;
          }
          label564:
          i = 0;
          break;
        }
      }
      else
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  public CharSequence a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return c();
    }
    return super.a();
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (awwa.a(this.jdField_b_of_type_Int))
    {
      ahpd.jdField_a_of_type_Boolean = true;
      ahpd.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, 3000, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, false);
      akgb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      awwa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, "", 3000);
      awwa.a(this.jdField_a_of_type_JavaLangString, 20, 3, paramView);
      awwa.a(this.jdField_a_of_type_JavaLangString, 30, paramView, false);
      awwa.a(this.jdField_a_of_type_JavaLangString);
      awwa.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        awwa.a("search", "group", "groups", 0, 0, new String[] { awwa.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        awwa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
          break label299;
        }
        awsq.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin }).a();
      return;
      label299:
      awsq.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
      continue;
      awwa.a(paramView, this);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return this.jdField_c_of_type_JavaLangCharSequence;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return 101;
  }
  
  public CharSequence c()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String c()
  {
    return bbcz.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
  }
  
  public int d()
  {
    return 3000;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangCharSequence.toString();
  }
  
  public int e()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmq
 * JD-Core Version:    0.7.0.1
 */