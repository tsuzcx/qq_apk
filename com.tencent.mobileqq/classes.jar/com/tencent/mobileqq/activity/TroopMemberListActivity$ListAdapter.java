package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.memberlist.AddFrdHelper;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;

public class TroopMemberListActivity$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public LinkedHashMap<String, List<TroopMemberListActivity.ATroopMember>> a = new LinkedHashMap();
  public int[] b = new int[0];
  public String[] c = new String[0];
  public List<TroopMemberListActivity.ATroopMember> d = new ArrayList();
  public List<String> e = new ArrayList();
  protected List<String> f;
  protected List<String> g;
  protected List<oidb_0xa2a.UserInfo> h;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public String l;
  
  public TroopMemberListActivity$ListAdapter(TroopMemberListActivity paramTroopMemberListActivity)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.app, paramTroopMemberListActivity.mListView, true);
    if ((this.m.mFrom != 1) && (this.m.mFrom != 11))
    {
      int n;
      if (this.m.mFrom == 5)
      {
        paramTroopMemberListActivity = this.m;
        n = 2131894074;
      }
      else
      {
        paramTroopMemberListActivity = this.m;
        n = 2131917604;
      }
      paramTroopMemberListActivity = paramTroopMemberListActivity.getString(n);
    }
    else
    {
      paramTroopMemberListActivity = this.m.getString(2131888734);
    }
    this.l = paramTroopMemberListActivity;
  }
  
  public int a()
  {
    if (this.m.mFrom == 9) {
      return 0;
    }
    return 2131625259;
  }
  
  public String a(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    if (paramLong == 0L) {
      return paramArrayOfString[7];
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    int n = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
    if (n <= 0) {
      return paramArrayOfString[0];
    }
    if (n <= 7) {
      return paramArrayOfString[1];
    }
    if (n <= 30) {
      return paramArrayOfString[2];
    }
    if (n <= 90) {
      return paramArrayOfString[3];
    }
    if (n <= 180) {
      return paramArrayOfString[4];
    }
    if (n <= 365) {
      return paramArrayOfString[5];
    }
    return paramArrayOfString[6];
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.m.mFrom != 9) && (this.m.mFrom != 19))
    {
      Object localObject = this.b;
      if ((localObject.length > 0) && (this.c.length > 0))
      {
        int n = Arrays.binarySearch((int[])localObject, paramInt);
        paramInt = n;
        if (n < 0) {
          paramInt = -(n + 1) - 1;
        }
        localObject = (List)this.a.get(this.c[paramInt]);
        if ((localObject != null) && (((List)localObject).size() > 1))
        {
          TextView localTextView = (TextView)paramView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.c[paramInt]);
          localStringBuilder.append(this.m.getString(2131918187, new Object[] { Integer.valueOf(((List)localObject).size()) }));
          localTextView.setText(localStringBuilder.toString());
        }
        else
        {
          ((TextView)paramView).setText(this.c[paramInt]);
        }
        if (this.m.mIsDefaultTheme) {
          paramView.setBackgroundResource(2130838958);
        } else {
          paramView.setBackgroundResource(2130852226);
        }
        paramView.setPadding((int)(this.m.mDensity * 10.0F), 0, 0, 0);
      }
    }
    else if (paramView != null)
    {
      paramView.setVisibility(8);
    }
  }
  
  public boolean a(int paramInt)
  {
    int n = this.m.mFrom;
    boolean bool = false;
    if (n == 9) {
      return false;
    }
    if (Arrays.binarySearch(this.b, paramInt) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public String b(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramLong > 0L)
    {
      localCalendar.setTimeInMillis(paramLong * 1000L);
    }
    else
    {
      localCalendar.set(1, 2012);
      localCalendar.set(2, 5);
      localCalendar.set(5, 1);
    }
    int n = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
    if (n <= 0) {
      return paramArrayOfString[0];
    }
    if (n <= 7) {
      return paramArrayOfString[1];
    }
    if (n <= 30) {
      return paramArrayOfString[2];
    }
    if (n <= 90) {
      return paramArrayOfString[3];
    }
    if (n <= 180) {
      return paramArrayOfString[4];
    }
    if (n <= 365) {
      return paramArrayOfString[5];
    }
    if (n <= 730) {
      return paramArrayOfString[6];
    }
    if (n <= 1095) {
      return paramArrayOfString[7];
    }
    if (n <= 1825) {
      return paramArrayOfString[8];
    }
    if (n <= 2555) {
      return paramArrayOfString[9];
    }
    if (n <= 3650) {
      return paramArrayOfString[10];
    }
    return paramArrayOfString[11];
  }
  
  @SuppressLint({"UseSparseArrays"})
  public Object[] b()
  {
    long l1 = System.currentTimeMillis();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject7 = (ITroopRobotService)this.m.app.getRuntimeService(ITroopRobotService.class, "all");
    Object localObject4;
    Object localObject5;
    int n;
    char c1;
    label4627:
    Object localObject3;
    label4634:
    label4637:
    label4644:
    label4651:
    label4659:
    label4682:
    label4690:
    label4697:
    label4704:
    label4711:
    label4718:
    label4725:
    label4732:
    synchronized (this.m)
    {
      Object localObject8;
      Object localObject1;
      Object localObject9;
      if (this.m.mSortType == 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localObject8 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        localObject1 = new ArrayList();
        localObject9 = new ArrayList();
        this.j = 0;
        this.i = 0;
        this.k = 0;
        localObject6 = this.m.mListData.iterator();
        if (((Iterator)localObject6).hasNext())
        {
          TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)((Iterator)localObject6).next();
          if (((ITroopRobotService)localObject7).isRobotUin(localATroopMember.a))
          {
            localObject4 = localObject1;
            if (this.m.mFrom == 5) {
              break label4627;
            }
            localObject4 = localObject1;
            if (this.m.mFrom == 2) {
              break label4627;
            }
            localObject4 = localObject1;
            if (TroopMemberListActivity.access$2700(this.m)) {
              break label4627;
            }
            ((List)localObject9).add(localATroopMember);
            localObject4 = localObject1;
            break label4627;
          }
          if ((this.m.mFrom == 12) || (this.m.mFrom == 20))
          {
            if ((this.m.mRecMems != null) && (this.m.mRecMems.contains(localATroopMember.a))) {
              ((List)localObject1).add(localATroopMember);
            }
            if ((this.m.mPickedMems != null) && (this.m.mPickedMems.contains(localATroopMember.a)) && (!this.d.contains(localATroopMember))) {
              this.d.add(localATroopMember);
            }
            if ((this.m.mPreSelectedUins != null) && (this.m.mPreSelectedUins.contains(localATroopMember.a)) && (!this.d.contains(localATroopMember)))
            {
              this.d.add(localATroopMember);
              this.m.mPreSelectedUins.remove(localATroopMember.a);
            }
          }
          if ((this.m.mFrom == 13) || (this.m.mFrom == 21)) {
            break label4634;
          }
          if ((!this.m.mIsHomeworkTroop) && ((localATroopMember.z) || (this.m.mMgrList.contains(localATroopMember.a)))) {
            localArrayList1.add(localATroopMember);
          }
          if ((!this.m.mIsHomeworkTroop) && (localATroopMember.J)) {
            localArrayList3.add(localATroopMember);
          }
          if (localATroopMember.a.equals(this.m.app.getCurrentAccountUin())) {
            break label4634;
          }
          if (localATroopMember.y == 1L) {
            localArrayList2.add(localATroopMember);
          }
          if (((this.m.mTroopOwnerUin != null) && (this.m.mTroopOwnerUin.equals(localATroopMember.a))) || ((this.m.mTroopAdminUins != null) && (this.m.mTroopAdminUins.contains(localATroopMember.a))) || ((this.m.mIsHomeworkTroop) && ((localATroopMember.w == 332) || (localATroopMember.w == 333))))
          {
            ((List)localObject8).add(localATroopMember);
            if (!QLog.isColorLevel()) {
              break label4637;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("constructHashStruct uin = ");
            ((StringBuilder)localObject4).append(localATroopMember.a);
            ((StringBuilder)localObject4).append(", name = ");
            ((StringBuilder)localObject4).append(localATroopMember.h);
            ((StringBuilder)localObject4).append(", level = ");
            ((StringBuilder)localObject4).append(localATroopMember.w);
            QLog.d("zivonchen", 2, ((StringBuilder)localObject4).toString());
            break label4644;
          }
          if ((this.m.mFrom == 5) && (!TextUtils.isEmpty(localATroopMember.C)))
          {
            ((List)localObject8).add(localATroopMember);
            break label4644;
          }
          if ((localATroopMember.d == null) || (localATroopMember.d.length() == 0)) {
            break label4651;
          }
          localObject4 = localATroopMember.d.substring(0, 1);
          localObject5 = localObject4;
          if (((String)localObject4).length() == 1)
          {
            n = ((String)localObject4).charAt(0);
            if ((65 > n) || (n > 90)) {
              break label4659;
            }
            localObject5 = ((String)localObject4).toUpperCase();
          }
          if (localLinkedHashMap.get(localObject5) == null) {
            localLinkedHashMap.put(localObject5, new ArrayList());
          }
          this.j += 1;
          ((List)localLinkedHashMap.get(localObject5)).add(localATroopMember);
          break label4644;
        }
        char c2 = 'A';
        localObject5 = new TroopMemberListActivity.MyComparator(0, true);
        localObject4 = new LinkedHashMap();
        if (this.m.mFrom == 19)
        {
          localObject1 = localObject4;
          if (((List)localObject8).size() > 0)
          {
            Collections.sort((List)localObject8, (Comparator)localObject5);
            this.m.sortAdminsWithHomework((List)localObject8, this.m.mTroopOwnerUin, this.m.mTroopAdminUins);
            ((LinkedHashMap)localObject4).put(TroopMemberListActivity.access$600(this.m), localObject8);
            localObject1 = localObject4;
          }
        }
        else if (this.m.mFrom == 21)
        {
          this.i = 0;
          Collections.sort((List)localObject8, (Comparator)localObject5);
          ((LinkedHashMap)localObject4).put(HardCodeUtil.a(2131912842), this.m.mListData);
          localObject1 = localObject4;
        }
        else
        {
          if ((localArrayList1.size() > 0) && (this.m.mFrom != 12))
          {
            Collections.sort(localArrayList1, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.m.getString(2131916742), localArrayList1);
          }
          if ((localArrayList3.size() > 0) && (this.m.mFrom != 3))
          {
            Collections.sort(localArrayList3, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.m.getString(2131917577), localArrayList3);
          }
          if ((localArrayList2.size() > 0) && (this.m.mFrom != 3))
          {
            Collections.sort(localArrayList2, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.m.getString(2131888258), localArrayList2);
          }
          if (((List)localObject8).size() > 0)
          {
            Collections.sort((List)localObject8, (Comparator)localObject5);
            this.k += ((List)localObject8).size();
            this.m.sortAdminsWithHomework((List)localObject8, this.m.mTroopOwnerUin, this.m.mTroopAdminUins);
            if (this.m.mIsHomeworkTroop) {
              localObject1 = TroopMemberListActivity.access$600(this.m);
            } else {
              localObject1 = this.l;
            }
            ((LinkedHashMap)localObject4).put(localObject1, localObject8);
          }
          c1 = c2;
          if (((List)localObject9).size() > 0)
          {
            Collections.sort((List)localObject9, (Comparator)localObject5);
            this.k += ((List)localObject9).size();
            ((LinkedHashMap)localObject4).put(this.m.getString(2131917609), localObject9);
            c1 = c2;
          }
          if (c1 <= 'Z')
          {
            if (localLinkedHashMap.get(String.valueOf(c1)) == null) {
              break label4682;
            }
            this.i += 1;
            Collections.sort((List)localLinkedHashMap.get(String.valueOf(c1)), (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(String.valueOf(c1), localLinkedHashMap.get(String.valueOf(c1)));
            break label4682;
          }
          if (localLinkedHashMap.get("#") != null)
          {
            this.i += 1;
            Collections.sort((List)localLinkedHashMap.get("#"), (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put("#", localLinkedHashMap.get("#"));
          }
          localLinkedHashMap.clear();
          localObject1 = localObject4;
        }
      }
      else if (this.m.mSortType == 2)
      {
        localObject4 = this.m.getResources().getStringArray(2130968681);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject5 = this.m.mListData.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject5).next();
          if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).u)) {
            ((TroopMemberListActivity.ATroopMember)localObject6).u = a((String[])localObject4, ((TroopMemberListActivity.ATroopMember)localObject6).t, (Calendar)localObject1);
          }
          if (localLinkedHashMap.get(((TroopMemberListActivity.ATroopMember)localObject6).u) == null) {
            localLinkedHashMap.put(((TroopMemberListActivity.ATroopMember)localObject6).u, new ArrayList());
          }
          ((List)localLinkedHashMap.get(((TroopMemberListActivity.ATroopMember)localObject6).u)).add(localObject6);
        }
        localObject1 = new LinkedHashMap();
        n = 0;
        if (n < localObject4.length)
        {
          if (localLinkedHashMap.get(localObject4[n]) == null) {
            break label4690;
          }
          Collections.sort((List)localLinkedHashMap.get(localObject4[n]), new TroopMemberListActivity.MyComparator(2, true));
          ((LinkedHashMap)localObject1).put(localObject4[n], localLinkedHashMap.get(localObject4[n]));
          break label4690;
        }
        localLinkedHashMap.clear();
      }
      else if (this.m.mSortType == 6)
      {
        if (TroopMemberListActivity.access$2800(this.m).size() == 0) {
          return null;
        }
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject4 = this.m.mListData.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject4).next();
          if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject5).u))
          {
            if (((TroopMemberListActivity.ATroopMember)localObject5).t == 0L) {
              ((TroopMemberListActivity.ATroopMember)localObject5).t = ((TroopMemberListActivity.ATroopMember)localObject5).r;
            }
            ((TroopMemberListActivity.ATroopMember)localObject5).u = this.m.getInactiveSeq(((TroopMemberListActivity.ATroopMember)localObject5).t, (Calendar)localObject1, TroopMemberListActivity.access$2800(this.m), TroopMemberListActivity.access$2900(this.m));
          }
          if (localLinkedHashMap.get(((TroopMemberListActivity.ATroopMember)localObject5).u) == null) {
            localLinkedHashMap.put(((TroopMemberListActivity.ATroopMember)localObject5).u, new ArrayList());
          }
          if (!TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject5).u)) {
            ((List)localLinkedHashMap.get(((TroopMemberListActivity.ATroopMember)localObject5).u)).add(localObject5);
          }
        }
        localObject1 = new LinkedHashMap();
        n = TroopMemberListActivity.access$2900(this.m).size() - 1;
        if (n >= 0)
        {
          if (localLinkedHashMap.get(TroopMemberListActivity.access$2900(this.m).get(n)) == null) {
            break label4697;
          }
          Collections.sort((List)localLinkedHashMap.get(TroopMemberListActivity.access$2900(this.m).get(n)), new TroopMemberListActivity.MyComparator(2, false));
          ((LinkedHashMap)localObject1).put(TroopMemberListActivity.access$2900(this.m).get(n), localLinkedHashMap.get(TroopMemberListActivity.access$2900(this.m).get(n)));
          break label4697;
        }
        localLinkedHashMap.clear();
      }
      else if (this.m.mSortType == 3)
      {
        localObject4 = this.m.getResources().getStringArray(2130968682);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject5 = this.m.mListData.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject5).next();
          if (TextUtils.isEmpty(((TroopMemberListActivity.ATroopMember)localObject6).s)) {
            ((TroopMemberListActivity.ATroopMember)localObject6).s = b((String[])localObject4, ((TroopMemberListActivity.ATroopMember)localObject6).r, (Calendar)localObject1);
          }
          if (localLinkedHashMap.get(((TroopMemberListActivity.ATroopMember)localObject6).s) == null) {
            localLinkedHashMap.put(((TroopMemberListActivity.ATroopMember)localObject6).s, new ArrayList());
          }
          ((List)localLinkedHashMap.get(((TroopMemberListActivity.ATroopMember)localObject6).s)).add(localObject6);
        }
        localObject1 = new LinkedHashMap();
        n = localObject4.length - 1;
        if (n >= 0)
        {
          if (localLinkedHashMap.get(localObject4[n]) == null) {
            break label4704;
          }
          Collections.sort((List)localLinkedHashMap.get(localObject4[n]), new TroopMemberListActivity.MyComparator(3, false));
          ((LinkedHashMap)localObject1).put(localObject4[n], localLinkedHashMap.get(localObject4[n]));
          break label4704;
        }
        localLinkedHashMap.clear();
      }
      else
      {
        if (this.m.mSortType == 1)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          localObject6 = new ArrayList();
          localObject8 = this.m.mListData.iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject9 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject8).next();
            if (((ITroopRobotService)localObject7).isRobotUin(((TroopMemberListActivity.ATroopMember)localObject9).a))
            {
              if ((this.m.mFrom != 5) && (this.m.mFrom != 2) && (!TroopMemberListActivity.access$2700(this.m))) {
                if ((this.f != null) && (this.f.contains(((TroopMemberListActivity.ATroopMember)localObject9).a)))
                {
                  ((List)localObject1).add(localObject9);
                  ((TroopMemberListActivity.ATroopMember)localObject9).L = true;
                }
                else
                {
                  ((List)localObject6).add(localObject9);
                  ((TroopMemberListActivity.ATroopMember)localObject9).L = false;
                }
              }
            }
            else if ((this.f != null) && (this.f.contains(((TroopMemberListActivity.ATroopMember)localObject9).a)))
            {
              ((TroopMemberListActivity.ATroopMember)localObject9).L = true;
              if (((this.m.mTroopOwnerUin != null) && (this.m.mTroopOwnerUin.equals(((TroopMemberListActivity.ATroopMember)localObject9).a))) || ((this.m.mTroopAdminUins != null) && (this.m.mTroopAdminUins.contains(((TroopMemberListActivity.ATroopMember)localObject9).a))) || ((this.m.mIsHomeworkTroop) && ((((TroopMemberListActivity.ATroopMember)localObject9).w == 332) || (((TroopMemberListActivity.ATroopMember)localObject9).w == 333)))) {
                ((List)localObject4).add(localObject9);
              } else {
                ((List)localObject5).add(localObject9);
              }
            }
            else
            {
              ((TroopMemberListActivity.ATroopMember)localObject9).L = false;
              ((List)localObject6).add(localObject9);
            }
          }
          localLinkedHashMap.clear();
          Collections.sort((List)localObject1, new TroopMemberListActivity.MyComparator(1, false));
          if (((List)localObject1).size() > 0) {
            localLinkedHashMap.put(this.m.getString(2131917609), localObject1);
          }
          if (((List)localObject4).size() > 0)
          {
            Collections.sort((List)localObject4, new TroopMemberListActivity.MyComparator(1, false));
            this.m.sortAdminsWithHomework((List)localObject4, this.m.mTroopOwnerUin, this.m.mTroopAdminUins);
            if (this.m.mIsHomeworkTroop) {
              localObject1 = this.m.getString(2131892293);
            } else {
              localObject1 = this.m.getString(2131892292);
            }
            localLinkedHashMap.put(localObject1, localObject4);
          }
          Collections.sort((List)localObject5, new TroopMemberListActivity.MyComparator(1, false));
          if (((List)localObject5).size() > 0) {
            localLinkedHashMap.put(this.m.getString(2131917602), localObject5);
          }
          Collections.sort((List)localObject6, new TroopMemberListActivity.MyComparator(1, false));
          if (((List)localObject6).size() <= 0) {
            break label4739;
          }
          localLinkedHashMap.put(this.m.getString(2131917601), localObject6);
          break label4739;
        }
        int i1;
        if (this.m.mSortType == 7)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          localObject6 = new ArrayList();
          i1 = this.m.mListData.size();
          localObject7 = new HashMap(i1);
          n = 0;
          while (n < i1)
          {
            localObject8 = (TroopMemberListActivity.ATroopMember)this.m.mListData.get(n);
            ((TroopMemberListActivity.ATroopMember)localObject8).S = 0;
            ((HashMap)localObject7).put(((TroopMemberListActivity.ATroopMember)localObject8).a, localObject8);
            n += 1;
          }
          if (TroopMemberListActivity.access$1200(this.m) != null)
          {
            n = 0;
            if (n < TroopMemberListActivity.access$1200(this.m).length)
            {
              localObject8 = (TroopMemberListActivity.ATroopMember)((HashMap)localObject7).remove(String.valueOf(TroopMemberListActivity.access$1200(this.m)[n]));
              if (localObject8 == null) {
                break label4711;
              }
              ((List)localObject1).add(localObject8);
              break label4711;
            }
          }
          if (TroopMemberListActivity.access$1300(this.m) != null)
          {
            n = 0;
            if (n < TroopMemberListActivity.access$1300(this.m).length)
            {
              localObject8 = (TroopMemberListActivity.ATroopMember)((HashMap)localObject7).remove(String.valueOf(TroopMemberListActivity.access$1300(this.m)[n]));
              if (localObject8 == null) {
                break label4718;
              }
              ((List)localObject4).add(localObject8);
              break label4718;
            }
          }
          if (TroopMemberListActivity.access$1400(this.m) != null)
          {
            n = 0;
            if (n < TroopMemberListActivity.access$1400(this.m).length)
            {
              localObject8 = (TroopMemberListActivity.ATroopMember)((HashMap)localObject7).remove(String.valueOf(TroopMemberListActivity.access$1400(this.m)[n]));
              if (localObject8 == null) {
                break label4725;
              }
              ((List)localObject5).add(localObject8);
              break label4725;
            }
          }
          localObject7 = ((HashMap)localObject7).entrySet().iterator();
          while (((Iterator)localObject7).hasNext()) {
            ((List)localObject6).add(((Map.Entry)((Iterator)localObject7).next()).getValue());
          }
          Collections.sort((List)localObject1, new TroopMemberListActivity.MyComparator(2, true));
          if (!((List)localObject1).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131912874), localObject1);
          }
          if (!((List)localObject4).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131912849), localObject4);
          }
          if (!((List)localObject5).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131912893), localObject5);
          }
          Collections.sort((List)localObject6, new TroopMemberListActivity.MyComparator(2, true));
          if (((List)localObject6).isEmpty()) {
            break label4739;
          }
          localLinkedHashMap.put(HardCodeUtil.a(2131912841), localObject6);
          break label4739;
        }
        if (this.m.mSortType == 8)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new HashMap();
          if (this.h != null)
          {
            i1 = this.h.size();
            n = 0;
            while (n < i1)
            {
              localObject6 = (oidb_0xa2a.UserInfo)this.h.get(n);
              ((HashMap)localObject5).put(String.valueOf(((oidb_0xa2a.UserInfo)localObject6).uin.get()), localObject6);
              n += 1;
            }
          }
          localObject6 = this.m.mListData.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject6).next();
            localObject8 = (oidb_0xa2a.UserInfo)((HashMap)localObject5).get(((TroopMemberListActivity.ATroopMember)localObject7).a);
            if (localObject8 != null)
            {
              ((List)localObject1).add(localObject7);
              ((TroopMemberListActivity.ATroopMember)localObject7).T = ((oidb_0xa2a.UserInfo)localObject8).score.get();
            }
            else
            {
              ((List)localObject4).add(localObject7);
            }
          }
          if (((List)localObject1).size() > 0)
          {
            Collections.sort((List)localObject1, new TroopMemberListActivity.MyComparator(8, false));
            localLinkedHashMap.put(HardCodeUtil.a(2131912855), localObject1);
          }
          if (((List)localObject4).size() <= 0) {
            break label4739;
          }
          Collections.sort((List)localObject4, new TroopMemberListActivity.MyComparator(8, false));
          localLinkedHashMap.put(HardCodeUtil.a(2131912908), localObject4);
          break label4739;
        }
        if (this.m.mSortType == 4)
        {
          localObject1 = new LinkedHashMap();
          localObject4 = this.m.getResources().getStringArray(2130968676);
          localObject5 = HardCodeUtil.a(2131912843);
          localObject6 = this.m.mListData.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject6).next();
            i1 = ((TroopMemberListActivity.ATroopMember)localObject7).w;
            n = i1;
            if (i1 >= 10000) {
              n = ((TroopMemberListActivity.ATroopMember)localObject7).w - 10000;
            }
            if ((n >= 321) && (n <= 327))
            {
              localObject8 = localObject4[(n - 321)];
              if (((LinkedHashMap)localObject1).get(localObject8) == null) {
                ((LinkedHashMap)localObject1).put(localObject8, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject1).get(localObject8)).add(localObject7);
            }
            else
            {
              if (((LinkedHashMap)localObject1).get(localObject5) == null) {
                ((LinkedHashMap)localObject1).put(localObject5, new ArrayList());
              }
              ((List)((LinkedHashMap)localObject1).get(localObject5)).add(localObject7);
            }
          }
          n = localObject4.length - 1;
          if (n >= 0)
          {
            if (((LinkedHashMap)localObject1).get(localObject4[n]) == null) {
              break label4732;
            }
            Collections.sort((List)((LinkedHashMap)localObject1).get(localObject4[n]), new TroopMemberListActivity.MyComparator(0, false));
            localLinkedHashMap.put(localObject4[n], ((LinkedHashMap)localObject1).get(localObject4[n]));
            break label4732;
          }
          if (((LinkedHashMap)localObject1).get(localObject5) != null)
          {
            Collections.sort((List)((LinkedHashMap)localObject1).get(localObject5), new TroopMemberListActivity.MyComparator(0, false));
            localLinkedHashMap.put(localObject5, ((LinkedHashMap)localObject1).get(localObject5));
          }
          ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).reportDC00087(null, "846", "205607", "", "84601", "1", "145");
          break label4739;
        }
        if (this.m.mSortType != 5) {
          break label4739;
        }
        localObject1 = new ArrayList();
        localObject4 = new ArrayList();
        localObject5 = this.m.mListData.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (TroopMemberListActivity.ATroopMember)((Iterator)localObject5).next();
          if (!((ITroopRobotService)localObject7).isRobotUin(((TroopMemberListActivity.ATroopMember)localObject6).a)) {
            if ((this.g != null) && (this.g.contains(((TroopMemberListActivity.ATroopMember)localObject6).a)))
            {
              ((TroopMemberListActivity.ATroopMember)localObject6).L = true;
              ((List)localObject1).add(localObject6);
            }
            else
            {
              ((TroopMemberListActivity.ATroopMember)localObject6).L = false;
              ((List)localObject4).add(localObject6);
            }
          }
        }
        localLinkedHashMap.clear();
        Collections.sort((List)localObject1, new TroopMemberListActivity.MyComparator(0, false));
        if (((List)localObject1).size() > 0) {
          localLinkedHashMap.put(this.m.getString(2131917493), localObject1);
        }
        Collections.sort((List)localObject4, new TroopMemberListActivity.MyComparator(0, false));
        if (((List)localObject4).size() <= 0) {
          break label4739;
        }
        localLinkedHashMap.put(this.m.getString(2131917492), localObject4);
        break label4739;
      }
      if (this.m.mIsQidianPrivateTroop) {
        ((LinkedHashMap)localObject1).remove(this.m.getString(2131916742));
      }
      localObject4 = new int[((LinkedHashMap)localObject1).keySet().size()];
      localObject5 = new String[localObject4.length];
      Object localObject6 = ((LinkedHashMap)localObject1).keySet().iterator();
      if (localObject4.length == 0) {
        return new Object[0];
      }
      localObject4[0] = 0;
      n = 1;
      while (n < localObject4.length)
      {
        localObject4[n] += localObject4[(n - 1)] + ((List)((LinkedHashMap)localObject1).get(((Iterator)localObject6).next())).size() + 1;
        n += 1;
      }
      localObject6 = ((LinkedHashMap)localObject1).keySet().iterator();
      n = 0;
      while (((Iterator)localObject6).hasNext())
      {
        localObject5[n] = ((String)((Iterator)localObject6).next());
        n += 1;
      }
      if (this.m.mFrom == 0) {
        this.m.updateMaxItemCount((int[])localObject4);
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("constructHashStruct, time:");
        ((StringBuilder)localObject6).append(l2 - l1);
        ((StringBuilder)localObject6).append(", sortType:");
        ((StringBuilder)localObject6).append(this.m.mSortType);
        ((StringBuilder)localObject6).append(", listSize:");
        ((StringBuilder)localObject6).append(this.m.mListData.size());
        QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject6).toString());
      }
      return new Object[] { localObject1, localObject4, localObject5 };
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "mAdapter.notifyDataSetChanged2()");
    }
    QLog.d(".troop.troopManagerVASH", 2, new Object[] { "notifyDataSetChanged2 List count: ", Integer.valueOf(this.m.mListData.size()) });
    Object[] arrayOfObject = b();
    if (arrayOfObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct result == null!");
      }
      return;
    }
    if (arrayOfObject.length >= 3)
    {
      this.a = ((LinkedHashMap)arrayOfObject[0]);
      this.b = ((int[])arrayOfObject[1]);
      this.c = ((String[])arrayOfObject[2]);
      this.m.runOnUiThread(new TroopMemberListActivity.ListAdapter.1(this));
      return;
    }
    if ((arrayOfObject.length == 0) && ((this.m.mFrom == 13) || (this.m.mFrom == 21)))
    {
      this.a.clear();
      this.b = new int[0];
      this.c = new String[0];
      notifyDataSetChanged();
    }
  }
  
  public int g_(String paramString)
  {
    if (this.c != null)
    {
      int n = 0;
      for (;;)
      {
        String[] arrayOfString = this.c;
        if (n >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[n].equals(paramString)) {
          break label42;
        }
        n += 1;
      }
      n = -1;
      label42:
      if (n >= 0) {
        return this.b[n];
      }
    }
    return -1;
  }
  
  public int getCount()
  {
    if (this.m.mFrom == 9)
    {
      if (this.m.mListData == null) {
        return 0;
      }
      return this.m.mListData.size();
    }
    Object localObject = this.b;
    if (localObject.length == 0) {
      return 0;
    }
    int n = localObject[(localObject.length - 1)];
    localObject = this.a;
    String[] arrayOfString = this.c;
    return n + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.m.mFrom == 9)
    {
      if ((paramInt >= 0) && (paramInt <= this.m.mListData.size() - 1)) {
        return this.m.mListData.get(paramInt);
      }
      return null;
    }
    int n = Arrays.binarySearch(this.b, paramInt);
    if (n >= 0) {
      return null;
    }
    n = -(n + 1) - 1;
    return (TroopMemberListActivity.ATroopMember)((List)this.a.get(this.c[n])).get(paramInt - this.b[n] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (TroopMemberListActivity.access$2500(this.m))
    {
      int n = Arrays.binarySearch(this.b, paramInt);
      if (n < 0)
      {
        n = -(n + 1) - 1;
        TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)((List)this.a.get(this.c[n])).get(paramInt - this.b[n] - 1);
        if ((TextUtils.isEmpty(localATroopMember.n)) && (!TextUtils.isEmpty(localATroopMember.q)) && (!TextUtils.isEmpty(localATroopMember.h)) && (!localATroopMember.h.equals(localATroopMember.q))) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int n = getItemViewType(paramInt);
    boolean bool = true;
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      if (n == 0)
      {
        localView = this.m.mLayoutInflater.inflate(2131629583, paramViewGroup, false);
        paramView = new TroopMemberListActivity.TmViewHolder(localView, false);
      }
      else
      {
        localView = this.m.mLayoutInflater.inflate(2131629587, paramViewGroup, false);
        paramView = new TroopMemberListActivity.TmViewHolder(localView, true);
      }
      if (this.m.mIsDefaultTheme) {
        paramView.c.setBackgroundResource(2130839577);
      } else {
        paramView.c.setBackgroundResource(2130839574);
      }
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (TroopMemberListActivity.TmViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    paramView.y = "";
    if (this.m.mFrom == 9)
    {
      localObject1 = (TroopMemberListActivity.ATroopMember)this.m.mListData.get(paramInt);
      paramView.o.setTag(((TroopMemberListActivity.ATroopMember)localObject1).a);
      paramView.f.setTag(((TroopMemberListActivity.ATroopMember)localObject1).a);
      paramView.d.setTag(((TroopMemberListActivity.ATroopMember)localObject1).a);
      paramView.c.setTag(Integer.valueOf(paramInt));
      this.m.setItemViewValue(paramView, (TroopMemberListActivity.ATroopMember)localObject1, a(((TroopMemberListActivity.ATroopMember)localObject1).a, 2), false, false);
    }
    else
    {
      int i1 = Arrays.binarySearch(this.b, paramInt);
      Object localObject2;
      Object localObject3;
      if (i1 < 0)
      {
        i1 = -(i1 + 1) - 1;
        localObject1 = (TroopMemberListActivity.ATroopMember)((List)this.a.get(this.c[i1])).get(paramInt - this.b[i1] - 1);
        paramView.o.setTag(((TroopMemberListActivity.ATroopMember)localObject1).a);
        paramView.f.setTag(((TroopMemberListActivity.ATroopMember)localObject1).a);
        paramView.d.setTag(((TroopMemberListActivity.ATroopMember)localObject1).a);
        paramView.c.setTag(Integer.valueOf(paramInt));
        if (((TroopMemberListActivity.ATroopMember)localObject1).K)
        {
          localObject2 = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).createColorNickText(((TroopMemberListActivity.ATroopMember)localObject1).c, 16);
          paramView.l.setText((CharSequence)localObject2);
          ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).setColorText(this.m.app, paramView.l, (Spannable)localObject2);
          paramView.A.setImageResource(2130839779);
          paramView.c.setOnClickListener(this.m.mOnItemClickListener);
        }
        else
        {
          localObject2 = this.m;
          localObject3 = a(((TroopMemberListActivity.ATroopMember)localObject1).a, 2);
          if (n != 1) {
            bool = false;
          }
          ((TroopMemberListActivity)localObject2).setItemViewValue(paramView, (TroopMemberListActivity.ATroopMember)localObject1, (Bitmap)localObject3, false, bool);
        }
        if (this.m.mFrom == 12) {
          if (this.d.contains(localObject1)) {
            paramView.t.setVisibility(0);
          } else {
            paramView.t.setVisibility(8);
          }
        }
        if (this.m.mIsInMultiDeleteState)
        {
          paramView.w.setVisibility(8);
        }
        else if (this.m.mAddFrdHelper != null)
        {
          this.m.mAddFrdHelper.a(paramView, (TroopMemberListActivity.ATroopMember)localObject1);
          if (paramView.w.getVisibility() == 0)
          {
            n = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
            paramView.l.setMaxWidth(n);
            TroopMemberListActivity.access$2600(this.m.app, paramView.l, paramView.n, ((TroopMemberListActivity.ATroopMember)localObject1).a, n);
          }
        }
      }
      else
      {
        paramView.c.b(false);
        paramView.c.setVisibility(8);
        paramView.a.setVisibility(8);
        paramView.t.setVisibility(8);
        paramView.c.setOnClickListener(null);
        paramView.o.setTag("");
        paramView.f.setTag("");
        paramView.d.setTag("");
        paramView.c.setTag(Integer.valueOf(-1));
        if ((this.m.mFrom != 9) && (this.m.mFrom != 19))
        {
          paramView.b.setVisibility(0);
          localObject1 = (List)this.a.get(this.c[i1]);
          if (localObject1 != null) {
            if (this.m.getString(2131917609).equals(String.valueOf(this.c[i1])))
            {
              paramView.b.setText(String.valueOf(this.c[i1]));
            }
            else
            {
              localObject2 = paramView.b;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(String.valueOf(this.c[i1]));
              ((StringBuilder)localObject3).append(this.m.getString(2131918187, new Object[] { Integer.valueOf(((List)localObject1).size()) }));
              ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
            }
          }
        }
        else
        {
          paramView.b.setVisibility(8);
        }
        if (this.m.mFrom == 12)
        {
          localObject1 = (List)this.a.get(this.c[i1]);
          n = paramInt - this.b[i1] - 1;
          if ((n >= 0) && (n < ((List)localObject1).size()))
          {
            localObject1 = (TroopMemberListActivity.ATroopMember)((List)localObject1).get(n);
            if (this.d.contains(localObject1)) {
              paramView.t.setVisibility(0);
            } else {
              paramView.t.setVisibility(8);
            }
          }
        }
        paramView.c.setContentDescription("");
      }
    }
    if ((paramView.p != null) && (this.m.mIndexView != null)) {
      if (this.m.mIndexView.getVisibility() == 0) {
        paramView.p.setVisibility(0);
      } else {
        paramView.p.setVisibility(8);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
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