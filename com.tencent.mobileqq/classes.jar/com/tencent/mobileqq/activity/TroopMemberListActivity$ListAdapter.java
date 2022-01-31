package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import ucf;

public class TroopMemberListActivity$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public int a;
  public String a;
  public LinkedHashMap a;
  public List a;
  public int[] a;
  public String[] a;
  public int b;
  public List b;
  public List c;
  
  public TroopMemberListActivity$ListAdapter(TroopMemberListActivity paramTroopMemberListActivity)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.app, paramTroopMemberListActivity.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, true);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 11)) {
      paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433729);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramTroopMemberListActivity;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 5) {
        paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131430407);
      } else {
        paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433142);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) {
      return 0;
    }
    return 2130969056;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public String a(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    if (paramLong == 0L) {
      return paramArrayOfString[7];
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
    if (i <= 0) {
      return paramArrayOfString[0];
    }
    if (i <= 7) {
      return paramArrayOfString[1];
    }
    if (i <= 30) {
      return paramArrayOfString[2];
    }
    if (i <= 90) {
      return paramArrayOfString[3];
    }
    if (i <= 180) {
      return paramArrayOfString[4];
    }
    if (i <= 365) {
      return paramArrayOfString[5];
    }
    return paramArrayOfString[6];
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "mAdapter.notifyDataSetChanged2()");
    }
    QLog.d(".troop.troopManagerVASH", 2, new Object[] { "notifyDataSetChanged2 List count: ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size()) });
    Object[] arrayOfObject = a();
    if (arrayOfObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct result == null!");
      }
    }
    do
    {
      return;
      if (arrayOfObject.length >= 3)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
        this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
        this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.runOnUiThread(new ucf(this));
        return;
      }
    } while ((arrayOfObject.length != 0) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 13) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 21)));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 19)) {
      if (paramView != null) {
        paramView.setVisibility(8);
      }
    }
    while ((this.jdField_a_of_type_ArrayOfInt.length <= 0) || (this.jdField_a_of_type_ArrayOfJavaLangString.length <= 0)) {
      return;
    }
    paramInt = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramInt < 0) {
      paramInt = -(paramInt + 1) - 1;
    }
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      if ((localList != null) && (localList.size() > 1))
      {
        ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433145, new Object[] { Integer.valueOf(localList.size()) }));
        return;
      }
      ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) {}
    while (Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) < 0) {
      return false;
    }
    return true;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public Object[] a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject4 = new LinkedHashMap();
    Object localObject6 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getManager(202);
    Object localObject9;
    Object localObject10;
    Object localObject7;
    ArrayList localArrayList1;
    Object localObject8;
    int i;
    label792:
    label799:
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList2;
      TroopMemberListActivity.ATroopMember localATroopMember;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i != 0) {
          break label1441;
        }
        localObject9 = new ArrayList();
        localObject10 = new ArrayList();
        localObject7 = new ArrayList();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localObject8 = new ArrayList();
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator.next();
        if (((TroopRobotManager)localObject6).b(localATroopMember.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 2)) {
            continue;
          }
          ((List)localObject8).add(localATroopMember);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 12) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 20))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.m != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.m.contains(localATroopMember.jdField_a_of_type_JavaLangString))) {
          localArrayList2.add(localATroopMember);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.l != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.l.contains(localATroopMember.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localATroopMember))) {
          this.jdField_a_of_type_JavaUtilList.add(localATroopMember);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_JavaUtilArrayList.contains(localATroopMember.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localATroopMember)))
        {
          this.jdField_a_of_type_JavaUtilList.add(localATroopMember);
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_JavaUtilArrayList.remove(localATroopMember.jdField_a_of_type_JavaLangString);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 13) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 21))
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) && ((localATroopMember.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_JavaUtilList.contains(localATroopMember.jdField_a_of_type_JavaLangString)))) {
          ((List)localObject9).add(localATroopMember);
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) && (localATroopMember.jdField_b_of_type_Boolean)) {
          localArrayList1.add(localATroopMember);
        }
        if ((!localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getCurrentAccountUin())) && (localATroopMember.jdField_d_of_type_Long == 1L)) {
          ((List)localObject10).add(localATroopMember);
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString.equals(localATroopMember.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f.contains(localATroopMember.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) && ((localATroopMember.jdField_a_of_type_Int == 332) || (localATroopMember.jdField_a_of_type_Int == 333))))
      {
        ((List)localObject7).add(localATroopMember);
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "constructHashStruct uin = " + localATroopMember.jdField_a_of_type_JavaLangString + ", name = " + localATroopMember.g + ", level = " + localATroopMember.jdField_a_of_type_Int);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 5) && (!TextUtils.isEmpty(localATroopMember.u)))
      {
        ((List)localObject7).add(localATroopMember);
      }
      else
      {
        if (localATroopMember.jdField_c_of_type_JavaLangString == null) {
          break label3531;
        }
        if (localATroopMember.jdField_c_of_type_JavaLangString.length() == 0) {
          break label3531;
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (localObject1.length() == 1)
          {
            i = localObject1.charAt(0);
            if ((65 > i) || (i > 90)) {
              break label3539;
            }
            localObject3 = localObject1.toUpperCase();
          }
          if (((LinkedHashMap)localObject4).get(localObject3) == null) {
            ((LinkedHashMap)localObject4).put(localObject3, new ArrayList());
          }
          this.jdField_b_of_type_Int += 1;
          ((List)((LinkedHashMap)localObject4).get(localObject3)).add(localATroopMember);
          break;
          localObject2 = localATroopMember.jdField_c_of_type_JavaLangString.substring(0, 1);
        }
      }
    }
    localObject6 = new TroopMemberListActivity.MyComparator(0, true);
    Object localObject3 = new LinkedHashMap();
    label961:
    char c1;
    label1303:
    label1370:
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 19)
    {
      if (((List)localObject7).size() > 0)
      {
        Collections.sort((List)localObject7, (Comparator)localObject6);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((List)localObject7, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f);
        ((LinkedHashMap)localObject3).put(TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity), localObject7);
      }
    }
    else
    {
      label1924:
      label2200:
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_Boolean) {
          ((LinkedHashMap)localObject2).remove(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131435364));
        }
        localObject3 = new int[((LinkedHashMap)localObject2).keySet().size()];
        localObject4 = new String[localObject3.length];
        ??? = ((LinkedHashMap)localObject2).keySet().iterator();
        if (localObject3.length != 0) {
          break label3323;
        }
        return new Object[0];
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_Int = 0;
          Collections.sort((List)localObject7, (Comparator)localObject6);
          ((LinkedHashMap)localObject3).put("接收人", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList);
          break label3562;
        }
        if ((((List)localObject9).size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 12))
        {
          Collections.sort((List)localObject9, (Comparator)localObject6);
          ((LinkedHashMap)localObject3).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131435364), localObject9);
        }
        if (localArrayList1.size() > 0)
        {
          Collections.sort(localArrayList1, (Comparator)localObject6);
          ((LinkedHashMap)localObject3).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131435375), localArrayList1);
        }
        if (((List)localObject10).size() > 0)
        {
          Collections.sort((List)localObject10, (Comparator)localObject6);
          ((LinkedHashMap)localObject3).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433149), localObject10);
        }
        if (((List)localObject7).size() > 0)
        {
          Collections.sort((List)localObject7, (Comparator)localObject6);
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((List)localObject7, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) {
            break label1370;
          }
        }
        for (localObject2 = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity);; localObject2 = this.jdField_a_of_type_JavaLangString)
        {
          ((LinkedHashMap)localObject3).put(localObject2, localObject7);
          if (((List)localObject8).size() <= 0) {
            break label3569;
          }
          Collections.sort((List)localObject8, (Comparator)localObject6);
          ((LinkedHashMap)localObject3).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433148), localObject8);
          break label3569;
          if (c1 > 'Z') {
            break;
          }
          if (((LinkedHashMap)localObject4).get(String.valueOf(c1)) == null) {
            break label3575;
          }
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)((LinkedHashMap)localObject4).get(String.valueOf(c1)), (Comparator)localObject6);
          ((LinkedHashMap)localObject3).put(String.valueOf(c1), ((LinkedHashMap)localObject4).get(String.valueOf(c1)));
          break label3575;
        }
        if (((LinkedHashMap)localObject4).get("#") != null)
        {
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)((LinkedHashMap)localObject4).get("#"), (Comparator)localObject6);
          ((LinkedHashMap)localObject3).put("#", ((LinkedHashMap)localObject4).get("#"));
        }
        ((LinkedHashMap)localObject4).clear();
        break label3562;
        label1441:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i == 2)
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131296287);
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject6).next();
            if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject7).r)) {
              ((TroopMemberListActivity.ATroopMember)localObject7).r = a((String[])localObject3, ((TroopMemberListActivity.ATroopMember)localObject7).jdField_b_of_type_Long, (Calendar)localObject2);
            }
            if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject7).r) == null) {
              ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject7).r, new ArrayList());
            }
            ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject7).r)).add(localObject7);
          }
          localObject2 = new LinkedHashMap();
          i = localObject3.length - 1;
          label1619:
          if (i >= 0)
          {
            if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
              break label3583;
            }
            Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(2, false));
            ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
            break label3583;
          }
          ((LinkedHashMap)localObject4).clear();
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i == 6)
        {
          if (TroopMemberListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).size() == 0) {
            return null;
          }
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject3).next();
            if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).r))
            {
              if (((TroopMemberListActivity.ATroopMember)localObject6).jdField_b_of_type_Long == 0L) {
                ((TroopMemberListActivity.ATroopMember)localObject6).jdField_b_of_type_Long = ((TroopMemberListActivity.ATroopMember)localObject6).jdField_a_of_type_Long;
              }
              ((TroopMemberListActivity.ATroopMember)localObject6).r = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(((TroopMemberListActivity.ATroopMember)localObject6).jdField_b_of_type_Long, (Calendar)localObject2, TroopMemberListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity), TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
            }
            if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).r) == null) {
              ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject6).r, new ArrayList());
            }
            if (!TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).r)) {
              ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject6).r)).add(localObject6);
            }
          }
          localObject2 = new LinkedHashMap();
          i = TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).size() - 1;
          if (i >= 0)
          {
            if (((LinkedHashMap)localObject4).get(TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).get(i)) == null) {
              break label3590;
            }
            Collections.sort((List)((LinkedHashMap)localObject4).get(TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).get(i)), new TroopMemberListActivity.MyComparator(2, false));
            ((LinkedHashMap)localObject2).put(TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).get(i), ((LinkedHashMap)localObject4).get(TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).get(i)));
            break label3590;
          }
          ((LinkedHashMap)localObject4).clear();
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i != 3) {
            break;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2131296309);
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject6).next();
            if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject7).q)) {
              ((TroopMemberListActivity.ATroopMember)localObject7).q = b((String[])localObject3, ((TroopMemberListActivity.ATroopMember)localObject7).jdField_a_of_type_Long, (Calendar)localObject2);
            }
            if (((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject7).q) == null) {
              ((LinkedHashMap)localObject4).put(((TroopMemberListActivity.ATroopMember)localObject7).q, new ArrayList());
            }
            ((List)((LinkedHashMap)localObject4).get(((TroopMemberListActivity.ATroopMember)localObject7).q)).add(localObject7);
          }
          localObject2 = new LinkedHashMap();
          i = localObject3.length - 1;
          if (i >= 0)
          {
            if (((LinkedHashMap)localObject4).get(localObject3[i]) == null) {
              break label3597;
            }
            Collections.sort((List)((LinkedHashMap)localObject4).get(localObject3[i]), new TroopMemberListActivity.MyComparator(3, false));
            ((LinkedHashMap)localObject2).put(localObject3[i], ((LinkedHashMap)localObject4).get(localObject3[i]));
            break label3597;
          }
          ((LinkedHashMap)localObject4).clear();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i == 1)
      {
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject7 = new ArrayList();
        localObject8 = new ArrayList();
        localObject9 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject9).hasNext())
        {
          localObject10 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject9).next();
          if (((TroopRobotManager)localObject6).b(((TroopMemberListActivity.ATroopMember)localObject10).jdField_a_of_type_JavaLangString))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 5) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 2)) {
              if ((this.c != null) && (this.c.contains(((TroopMemberListActivity.ATroopMember)localObject10).jdField_a_of_type_JavaLangString)))
              {
                ((List)localObject2).add(localObject10);
                ((TroopMemberListActivity.ATroopMember)localObject10).jdField_d_of_type_Boolean = true;
              }
              else
              {
                ((List)localObject8).add(localObject10);
                ((TroopMemberListActivity.ATroopMember)localObject10).jdField_d_of_type_Boolean = false;
              }
            }
          }
          else if ((this.c != null) && (this.c.contains(((TroopMemberListActivity.ATroopMember)localObject10).jdField_a_of_type_JavaLangString)))
          {
            ((TroopMemberListActivity.ATroopMember)localObject10).jdField_d_of_type_Boolean = true;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString.equals(((TroopMemberListActivity.ATroopMember)localObject10).jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f.contains(((TroopMemberListActivity.ATroopMember)localObject10).jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) && ((((TroopMemberListActivity.ATroopMember)localObject10).jdField_a_of_type_Int == 332) || (((TroopMemberListActivity.ATroopMember)localObject10).jdField_a_of_type_Int == 333)))) {
              ((List)localObject3).add(localObject10);
            } else {
              ((List)localObject7).add(localObject10);
            }
          }
          else
          {
            ((TroopMemberListActivity.ATroopMember)localObject10).jdField_d_of_type_Boolean = false;
            ((List)localObject8).add(localObject10);
          }
        }
        ((LinkedHashMap)localObject4).clear();
        Collections.sort((List)localObject2, new TroopMemberListActivity.MyComparator(1, false));
        if (((List)localObject2).size() > 0) {
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433148), localObject2);
        }
        if (((List)localObject3).size() > 0)
        {
          Collections.sort((List)localObject3, new TroopMemberListActivity.MyComparator(1, false));
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((List)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) {
            break label2827;
          }
        }
        label2827:
        for (localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433144);; localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433143))
        {
          ((LinkedHashMap)localObject4).put(localObject2, localObject3);
          Collections.sort((List)localObject7, new TroopMemberListActivity.MyComparator(1, false));
          if (((List)localObject7).size() > 0) {
            ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433152), localObject7);
          }
          Collections.sort((List)localObject8, new TroopMemberListActivity.MyComparator(1, false));
          if (((List)localObject8).size() <= 0) {
            break;
          }
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433153), localObject8);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i == 7)
      {
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject6 = new ArrayList();
        localObject7 = new ArrayList();
        j = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size();
        localObject8 = new HashMap(j);
        i = 0;
        while (i < j)
        {
          localObject9 = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.get(i);
          ((TroopMemberListActivity.ATroopMember)localObject9).e = 0;
          ((HashMap)localObject8).put(((TroopMemberListActivity.ATroopMember)localObject9).jdField_a_of_type_JavaLangString, localObject9);
          i += 1;
        }
        if (TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) != null)
        {
          i = 0;
          label2976:
          if (i < TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).length)
          {
            localObject9 = (TroopMemberListActivity.ATroopMember)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)[i]));
            if (localObject9 == null) {
              break label3611;
            }
            ((List)localObject2).add(localObject9);
            break label3611;
          }
        }
        if (TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) != null)
        {
          i = 0;
          label3040:
          if (i < TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).length)
          {
            localObject9 = (TroopMemberListActivity.ATroopMember)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)[i]));
            if (localObject9 == null) {
              break label3618;
            }
            ((List)localObject3).add(localObject9);
            break label3618;
          }
        }
        if (TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) != null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).length)
      {
        localObject9 = (TroopMemberListActivity.ATroopMember)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)[i]));
        if (localObject9 != null) {
          ((List)localObject6).add(localObject9);
        }
      }
      else
      {
        localObject8 = ((HashMap)localObject8).entrySet().iterator();
        while (((Iterator)localObject8).hasNext()) {
          ((List)localObject7).add(((Map.Entry)((Iterator)localObject8).next()).getValue());
        }
        Collections.sort((List)localObject2, new TroopMemberListActivity.MyComparator(2, true));
        if (!((List)localObject2).isEmpty()) {
          ((LinkedHashMap)localObject4).put("今天过生日的人", localObject2);
        }
        if (!((List)localObject3).isEmpty()) {
          ((LinkedHashMap)localObject4).put("我送过礼物的人", localObject3);
        }
        if (!((List)localObject6).isEmpty()) {
          ((LinkedHashMap)localObject4).put("送过我礼物的人", localObject6);
        }
        Collections.sort((List)localObject7, new TroopMemberListActivity.MyComparator(2, true));
        if (!((List)localObject7).isEmpty()) {
          ((LinkedHashMap)localObject4).put("最近活跃的人", localObject7);
        }
        localObject2 = localObject4;
        break label961;
        label3323:
        localObject3[0] = 0;
        i = 1;
        while (i < localObject3.length)
        {
          j = localObject3[i];
          int k = localObject3[(i - 1)];
          localObject3[i] = (((List)((LinkedHashMap)localObject2).get(((Iterator)???).next())).size() + k + 1 + j);
          i += 1;
        }
        ??? = ((LinkedHashMap)localObject2).keySet().iterator();
        i = 0;
        while (((Iterator)???).hasNext())
        {
          localObject4[i] = ((String)((Iterator)???).next());
          i += 1;
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct, time:" + (l2 - l1) + ", sortType:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i + ", listSize:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size());
        }
        return new Object[] { localObject2, localObject3, localObject4 };
        label3531:
        localObject2 = "#";
        break;
        label3539:
        if ((97 <= i) && (i <= 122)) {
          break label792;
        }
        localObject3 = "#";
        break label799;
        label3562:
        localObject2 = localObject3;
        break label961;
        label3569:
        c1 = 'A';
        break label1303;
        label3575:
        c1 = (char)(c1 + '\001');
        break label1303;
        label3583:
        i -= 1;
        break label1619;
        label3590:
        i -= 1;
        break label1924;
        label3597:
        i -= 1;
        break label2200;
        localObject2 = localObject4;
        break label961;
        label3611:
        i += 1;
        break label2976;
        label3618:
        i += 1;
        break label3040;
      }
      i += 1;
    }
  }
  
  public String b(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramLong > 0L) {
      localCalendar.setTimeInMillis(1000L * paramLong);
    }
    int i;
    for (;;)
    {
      i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
      if (i > 0) {
        break;
      }
      return paramArrayOfString[0];
      localCalendar.set(1, 2012);
      localCalendar.set(2, 5);
      localCalendar.set(5, 1);
    }
    if (i <= 7) {
      return paramArrayOfString[1];
    }
    if (i <= 30) {
      return paramArrayOfString[2];
    }
    if (i <= 90) {
      return paramArrayOfString[3];
    }
    if (i <= 180) {
      return paramArrayOfString[4];
    }
    if (i <= 365) {
      return paramArrayOfString[5];
    }
    if (i <= 730) {
      return paramArrayOfString[6];
    }
    if (i <= 1095) {
      return paramArrayOfString[7];
    }
    if (i <= 1825) {
      return paramArrayOfString[8];
    }
    if (i <= 2555) {
      return paramArrayOfString[9];
    }
    if (i <= 3650) {
      return paramArrayOfString[10];
    }
    return paramArrayOfString[11];
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList != null) {}
    }
    while (this.jdField_a_of_type_ArrayOfInt.length == 0)
    {
      return 0;
      return this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size();
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt <= this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size() - 1) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    do
    {
      return localObject1;
      i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      localObject1 = localObject2;
    } while (i >= 0);
    int i = -(i + 1) - 1;
    return (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity))
    {
      int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      if (i < 0)
      {
        i = -(i + 1) - 1;
        TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
        if ((TextUtils.isEmpty(localATroopMember.m)) && (!TextUtils.isEmpty(localATroopMember.p)) && (!TextUtils.isEmpty(localATroopMember.g)) && (!localATroopMember.g.equals(localATroopMember.p))) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    int i = getItemViewType(paramInt);
    Object localObject;
    if (paramView == null) {
      if (i == 0)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971680, paramViewGroup, false);
        paramView = new TroopMemberListActivity.TmViewHolder(paramViewGroup, false);
        paramViewGroup.setTag(paramView);
        localObject = paramView;
        paramView = paramViewGroup;
      }
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (TroopMemberListActivity.TmViewHolder)paramView.getTag())
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = "";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 9) {
        break label206;
      }
      localObject = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.h.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(paramViewGroup, (TroopMemberListActivity.ATroopMember)localObject, a(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString, 2), false, false);
      return paramView;
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971682, paramViewGroup, false);
      paramView = new TroopMemberListActivity.TmViewHolder(paramViewGroup, true);
      break;
    }
    label206:
    int j = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (j < 0)
    {
      j = -(j + 1) - 1;
      localObject = (TroopMemberListActivity.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[j] - 1);
      paramViewGroup.h.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      label359:
      TroopMemberListActivity localTroopMemberListActivity;
      Bitmap localBitmap;
      if (((TroopMemberListActivity.ATroopMember)localObject).jdField_c_of_type_Boolean)
      {
        paramViewGroup.e.setText(((TroopMemberListActivity.ATroopMember)localObject).jdField_b_of_type_JavaLangString);
        paramViewGroup.c.setImageResource(2130838732);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.c);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 12)
        {
          if (!this.jdField_a_of_type_JavaUtilList.contains(localObject)) {
            break label441;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return paramView;
        }
      }
      else
      {
        localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
        localBitmap = a(((TroopMemberListActivity.ATroopMember)localObject).jdField_a_of_type_JavaLangString, 2);
        if (i != 1) {
          break label435;
        }
      }
      for (;;)
      {
        localTroopMemberListActivity.a(paramViewGroup, (TroopMemberListActivity.ATroopMember)localObject, localBitmap, false, bool);
        break label359;
        break;
        label435:
        bool = false;
      }
      label441:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
    paramViewGroup.h.setTag("");
    paramViewGroup.jdField_b_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(-1));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 19))
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 12)
      {
        localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
        paramInt = paramInt - this.jdField_a_of_type_ArrayOfInt[j] - 1;
        if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
        {
          localObject = (TroopMemberListActivity.ATroopMember)((List)localObject).get(paramInt);
          if (!this.jdField_a_of_type_JavaUtilList.contains(localObject)) {
            break label814;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setContentDescription("");
      return paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
      if (localObject == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433148).equals(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j])))
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j]));
        break;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j]) + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131433145, new Object[] { Integer.valueOf(((List)localObject).size()) }));
      break;
      label814:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */