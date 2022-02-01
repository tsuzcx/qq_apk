package com.tencent.mobileqq.activity.history;

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
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.mobileqq.vas.ColorNickManager;
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

public class ChatHistoryTroopMemberFragment$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public LinkedHashMap<String, List<ChatHistoryTroopMemberFragment.ATroopMember>> a = new LinkedHashMap();
  public int[] b = new int[0];
  public String[] c = new String[0];
  public List<ChatHistoryTroopMemberFragment.ATroopMember> d = new ArrayList();
  public List<String> e = new ArrayList();
  protected List<String> f;
  protected List<oidb_0xa2a.UserInfo> g;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public String k;
  
  public ChatHistoryTroopMemberFragment$ListAdapter(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment)
  {
    super(paramChatHistoryTroopMemberFragment.getBaseActivity(), paramChatHistoryTroopMemberFragment.bc, paramChatHistoryTroopMemberFragment.s, true);
    if ((this.l.az != 1) && (this.l.az != 11))
    {
      int m;
      if (this.l.az == 5)
      {
        paramChatHistoryTroopMemberFragment = this.l;
        m = 2131894074;
      }
      else
      {
        paramChatHistoryTroopMemberFragment = this.l;
        m = 2131917604;
      }
      paramChatHistoryTroopMemberFragment = paramChatHistoryTroopMemberFragment.getString(m);
    }
    else
    {
      paramChatHistoryTroopMemberFragment = this.l.getString(2131888734);
    }
    this.k = paramChatHistoryTroopMemberFragment;
  }
  
  public int a()
  {
    if (this.l.az == 9) {
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
    int m = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
    if (m <= 0) {
      return paramArrayOfString[0];
    }
    if (m <= 7) {
      return paramArrayOfString[1];
    }
    if (m <= 30) {
      return paramArrayOfString[2];
    }
    if (m <= 90) {
      return paramArrayOfString[3];
    }
    if (m <= 180) {
      return paramArrayOfString[4];
    }
    if (m <= 365) {
      return paramArrayOfString[5];
    }
    return paramArrayOfString[6];
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.l.az != 9) && (this.l.az != 19))
    {
      Object localObject = this.b;
      if ((localObject.length > 0) && (this.c.length > 0))
      {
        int m = Arrays.binarySearch((int[])localObject, paramInt);
        paramInt = m;
        if (m < 0) {
          paramInt = -(m + 1) - 1;
        }
        localObject = (List)this.a.get(this.c[paramInt]);
        if ((localObject != null) && (((List)localObject).size() > 1))
        {
          TextView localTextView = (TextView)paramView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.c[paramInt]);
          localStringBuilder.append(this.l.getString(2131918187, new Object[] { Integer.valueOf(((List)localObject).size()) }));
          localTextView.setText(localStringBuilder.toString());
        }
        else
        {
          ((TextView)paramView).setText(this.c[paramInt]);
        }
        if (this.l.bb) {
          paramView.setBackgroundResource(2130838958);
        } else {
          paramView.setBackgroundResource(2130852226);
        }
        paramView.setPadding((int)(this.l.I * 10.0F), 0, 0, 0);
      }
    }
    else if (paramView != null)
    {
      paramView.setVisibility(8);
    }
  }
  
  public boolean a(int paramInt)
  {
    int m = this.l.az;
    boolean bool = false;
    if (m == 9) {
      return false;
    }
    if (Arrays.binarySearch(this.b, paramInt) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public int b(String paramString)
  {
    if (this.c != null)
    {
      int m = 0;
      for (;;)
      {
        String[] arrayOfString = this.c;
        if (m >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[m].equals(paramString)) {
          break label42;
        }
        m += 1;
      }
      m = -1;
      label42:
      if (m >= 0) {
        return this.b[m];
      }
    }
    return -1;
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
    int m = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
    if (m <= 0) {
      return paramArrayOfString[0];
    }
    if (m <= 7) {
      return paramArrayOfString[1];
    }
    if (m <= 30) {
      return paramArrayOfString[2];
    }
    if (m <= 90) {
      return paramArrayOfString[3];
    }
    if (m <= 180) {
      return paramArrayOfString[4];
    }
    if (m <= 365) {
      return paramArrayOfString[5];
    }
    if (m <= 730) {
      return paramArrayOfString[6];
    }
    if (m <= 1095) {
      return paramArrayOfString[7];
    }
    if (m <= 1825) {
      return paramArrayOfString[8];
    }
    if (m <= 2555) {
      return paramArrayOfString[9];
    }
    if (m <= 3650) {
      return paramArrayOfString[10];
    }
    return paramArrayOfString[11];
  }
  
  @SuppressLint({"UseSparseArrays"})
  public Object[] b()
  {
    long l1 = System.currentTimeMillis();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject7 = (ITroopRobotService)this.l.bc.getRuntimeService(ITroopRobotService.class, "all");
    Object localObject4;
    Object localObject5;
    int m;
    char c1;
    label4383:
    Object localObject3;
    label4390:
    label4393:
    label4400:
    label4407:
    label4415:
    label4438:
    label4446:
    label4453:
    label4460:
    label4467:
    label4474:
    synchronized (this.l)
    {
      Object localObject8;
      Object localObject1;
      Object localObject9;
      if (this.l.bj == 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localObject8 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        localObject1 = new ArrayList();
        localObject9 = new ArrayList();
        this.i = 0;
        this.h = 0;
        this.j = 0;
        localObject6 = this.l.J.iterator();
        if (((Iterator)localObject6).hasNext())
        {
          ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject6).next();
          if (((ITroopRobotService)localObject7).isRobotUin(localATroopMember.a))
          {
            localObject4 = localObject1;
            if (this.l.az == 5) {
              break label4383;
            }
            localObject4 = localObject1;
            if (this.l.az == 2) {
              break label4383;
            }
            localObject4 = localObject1;
            if (ChatHistoryTroopMemberFragment.s(this.l)) {
              break label4383;
            }
            ((List)localObject9).add(localATroopMember);
            localObject4 = localObject1;
            break label4383;
          }
          if ((this.l.az == 12) || (this.l.az == 20))
          {
            if ((this.l.aG != null) && (this.l.aG.contains(localATroopMember.a))) {
              ((List)localObject1).add(localATroopMember);
            }
            if ((this.l.aF != null) && (this.l.aF.contains(localATroopMember.a)) && (!this.d.contains(localATroopMember))) {
              this.d.add(localATroopMember);
            }
            if ((this.l.aU != null) && (this.l.aU.contains(localATroopMember.a)) && (!this.d.contains(localATroopMember)))
            {
              this.d.add(localATroopMember);
              this.l.aU.remove(localATroopMember.a);
            }
          }
          if ((this.l.az == 13) || (this.l.az == 21)) {
            break label4390;
          }
          if ((!this.l.u) && ((localATroopMember.A) || (this.l.as.contains(localATroopMember.a)))) {
            localArrayList1.add(localATroopMember);
          }
          if ((!this.l.u) && (localATroopMember.I)) {
            localArrayList3.add(localATroopMember);
          }
          if (localATroopMember.a.equals(this.l.bc.getCurrentAccountUin())) {
            break label4390;
          }
          if (localATroopMember.z == 1L) {
            localArrayList2.add(localATroopMember);
          }
          if (((this.l.C != null) && (this.l.C.equals(localATroopMember.a))) || ((this.l.D != null) && (this.l.D.contains(localATroopMember.a))) || ((this.l.u) && ((localATroopMember.x == 332) || (localATroopMember.x == 333))))
          {
            ((List)localObject8).add(localATroopMember);
            if (!QLog.isColorLevel()) {
              break label4393;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("constructHashStruct uin = ");
            ((StringBuilder)localObject4).append(localATroopMember.a);
            ((StringBuilder)localObject4).append(", name = ");
            ((StringBuilder)localObject4).append(localATroopMember.h);
            ((StringBuilder)localObject4).append(", level = ");
            ((StringBuilder)localObject4).append(localATroopMember.x);
            QLog.d("zivonchen", 2, ((StringBuilder)localObject4).toString());
            break label4400;
          }
          if ((this.l.az == 5) && (!TextUtils.isEmpty(localATroopMember.D)))
          {
            ((List)localObject8).add(localATroopMember);
            break label4400;
          }
          if ((localATroopMember.d == null) || (localATroopMember.d.length() == 0)) {
            break label4407;
          }
          localObject4 = localATroopMember.d.substring(0, 1);
          localObject5 = localObject4;
          if (((String)localObject4).length() == 1)
          {
            m = ((String)localObject4).charAt(0);
            if ((65 > m) || (m > 90)) {
              break label4415;
            }
            localObject5 = ((String)localObject4).toUpperCase();
          }
          if (localLinkedHashMap.get(localObject5) == null) {
            localLinkedHashMap.put(localObject5, new ArrayList());
          }
          this.i += 1;
          ((List)localLinkedHashMap.get(localObject5)).add(localATroopMember);
          break label4400;
        }
        char c2 = 'A';
        localObject5 = new ChatHistoryTroopMemberFragment.MyComparator(0, true);
        localObject4 = new LinkedHashMap();
        if (this.l.az == 19)
        {
          localObject1 = localObject4;
          if (((List)localObject8).size() > 0)
          {
            Collections.sort((List)localObject8, (Comparator)localObject5);
            this.l.a((List)localObject8, this.l.C, this.l.D);
            ((LinkedHashMap)localObject4).put(ChatHistoryTroopMemberFragment.g(this.l), localObject8);
            localObject1 = localObject4;
          }
        }
        else if (this.l.az == 21)
        {
          this.h = 0;
          Collections.sort((List)localObject8, (Comparator)localObject5);
          ((LinkedHashMap)localObject4).put(HardCodeUtil.a(2131899824), this.l.J);
          localObject1 = localObject4;
        }
        else
        {
          if ((localArrayList1.size() > 0) && (this.l.az != 12))
          {
            Collections.sort(localArrayList1, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.l.getString(2131916742), localArrayList1);
          }
          if ((localArrayList3.size() > 0) && (this.l.az != 3))
          {
            Collections.sort(localArrayList3, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.l.getString(2131917577), localArrayList3);
          }
          if ((localArrayList2.size() > 0) && (this.l.az != 3))
          {
            Collections.sort(localArrayList2, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.l.getString(2131888258), localArrayList2);
          }
          if (((List)localObject8).size() > 0)
          {
            Collections.sort((List)localObject8, (Comparator)localObject5);
            this.j += ((List)localObject8).size();
            this.l.a((List)localObject8, this.l.C, this.l.D);
            if (this.l.u) {
              localObject1 = ChatHistoryTroopMemberFragment.g(this.l);
            } else {
              localObject1 = this.k;
            }
            ((LinkedHashMap)localObject4).put(localObject1, localObject8);
          }
          c1 = c2;
          if (((List)localObject9).size() > 0)
          {
            Collections.sort((List)localObject9, (Comparator)localObject5);
            this.j += ((List)localObject9).size();
            ((LinkedHashMap)localObject4).put(this.l.getString(2131917609), localObject9);
            c1 = c2;
          }
          if (c1 <= 'Z')
          {
            if (localLinkedHashMap.get(String.valueOf(c1)) == null) {
              break label4438;
            }
            this.h += 1;
            Collections.sort((List)localLinkedHashMap.get(String.valueOf(c1)), (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(String.valueOf(c1), localLinkedHashMap.get(String.valueOf(c1)));
            break label4438;
          }
          if (localLinkedHashMap.get("#") != null)
          {
            this.h += 1;
            Collections.sort((List)localLinkedHashMap.get("#"), (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put("#", localLinkedHashMap.get("#"));
          }
          localLinkedHashMap.clear();
          localObject1 = localObject4;
        }
      }
      else if (this.l.bj == 2)
      {
        localObject4 = this.l.getResources().getStringArray(2130968681);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject5 = this.l.J.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject5).next();
          if (TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).v)) {
            ((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).v = a((String[])localObject4, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).u, (Calendar)localObject1);
          }
          if (localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).v) == null) {
            localLinkedHashMap.put(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).v, new ArrayList());
          }
          ((List)localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).v)).add(localObject6);
        }
        localObject1 = new LinkedHashMap();
        m = localObject4.length - 1;
        if (m >= 0)
        {
          if (localLinkedHashMap.get(localObject4[m]) == null) {
            break label4446;
          }
          Collections.sort((List)localLinkedHashMap.get(localObject4[m]), new ChatHistoryTroopMemberFragment.MyComparator(2, false));
          ((LinkedHashMap)localObject1).put(localObject4[m], localLinkedHashMap.get(localObject4[m]));
          break label4446;
        }
        localLinkedHashMap.clear();
      }
      else if (this.l.bj == 6)
      {
        if (ChatHistoryTroopMemberFragment.t(this.l).size() == 0) {
          return null;
        }
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject4 = this.l.J.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject4).next();
          if (TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).v))
          {
            if (((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).u == 0L) {
              ((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).u = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).s;
            }
            ((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).v = this.l.a(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).u, (Calendar)localObject1, ChatHistoryTroopMemberFragment.t(this.l), ChatHistoryTroopMemberFragment.u(this.l));
          }
          if (localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).v) == null) {
            localLinkedHashMap.put(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).v, new ArrayList());
          }
          if (!TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).v)) {
            ((List)localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).v)).add(localObject5);
          }
        }
        localObject1 = new LinkedHashMap();
        m = ChatHistoryTroopMemberFragment.u(this.l).size() - 1;
        if (m >= 0)
        {
          if (localLinkedHashMap.get(ChatHistoryTroopMemberFragment.u(this.l).get(m)) == null) {
            break label4453;
          }
          Collections.sort((List)localLinkedHashMap.get(ChatHistoryTroopMemberFragment.u(this.l).get(m)), new ChatHistoryTroopMemberFragment.MyComparator(2, false));
          ((LinkedHashMap)localObject1).put(ChatHistoryTroopMemberFragment.u(this.l).get(m), localLinkedHashMap.get(ChatHistoryTroopMemberFragment.u(this.l).get(m)));
          break label4453;
        }
        localLinkedHashMap.clear();
      }
      else if (this.l.bj == 3)
      {
        localObject4 = this.l.getResources().getStringArray(2130968682);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject5 = this.l.J.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject5).next();
          if (TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).t)) {
            ((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).t = b((String[])localObject4, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).s, (Calendar)localObject1);
          }
          if (localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).t) == null) {
            localLinkedHashMap.put(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).t, new ArrayList());
          }
          ((List)localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).t)).add(localObject6);
        }
        localObject1 = new LinkedHashMap();
        m = localObject4.length - 1;
        if (m >= 0)
        {
          if (localLinkedHashMap.get(localObject4[m]) == null) {
            break label4460;
          }
          Collections.sort((List)localLinkedHashMap.get(localObject4[m]), new ChatHistoryTroopMemberFragment.MyComparator(3, false));
          ((LinkedHashMap)localObject1).put(localObject4[m], localLinkedHashMap.get(localObject4[m]));
          break label4460;
        }
        localLinkedHashMap.clear();
      }
      else
      {
        if (this.l.bj == 1)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          localObject6 = new ArrayList();
          localObject8 = this.l.J.iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject9 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject8).next();
            if (((ITroopRobotService)localObject7).isRobotUin(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).a))
            {
              if ((this.l.az != 5) && (this.l.az != 2) && (!ChatHistoryTroopMemberFragment.s(this.l))) {
                if ((this.f != null) && (this.f.contains(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).a)))
                {
                  ((List)localObject1).add(localObject9);
                  ((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).K = true;
                }
                else
                {
                  ((List)localObject6).add(localObject9);
                  ((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).K = false;
                }
              }
            }
            else if ((this.f != null) && (this.f.contains(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).a)))
            {
              ((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).K = true;
              if (((this.l.C != null) && (this.l.C.equals(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).a))) || ((this.l.D != null) && (this.l.D.contains(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).a))) || ((this.l.u) && ((((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).x == 332) || (((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).x == 333)))) {
                ((List)localObject4).add(localObject9);
              } else {
                ((List)localObject5).add(localObject9);
              }
            }
            else
            {
              ((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).K = false;
              ((List)localObject6).add(localObject9);
            }
          }
          localLinkedHashMap.clear();
          Collections.sort((List)localObject1, new ChatHistoryTroopMemberFragment.MyComparator(1, false));
          if (((List)localObject1).size() > 0) {
            localLinkedHashMap.put(this.l.getString(2131917609), localObject1);
          }
          if (((List)localObject4).size() > 0)
          {
            Collections.sort((List)localObject4, new ChatHistoryTroopMemberFragment.MyComparator(1, false));
            this.l.a((List)localObject4, this.l.C, this.l.D);
            if (this.l.u) {
              localObject1 = this.l.getString(2131892293);
            } else {
              localObject1 = this.l.getString(2131892292);
            }
            localLinkedHashMap.put(localObject1, localObject4);
          }
          Collections.sort((List)localObject5, new ChatHistoryTroopMemberFragment.MyComparator(1, false));
          if (((List)localObject5).size() > 0) {
            localLinkedHashMap.put(this.l.getString(2131917602), localObject5);
          }
          Collections.sort((List)localObject6, new ChatHistoryTroopMemberFragment.MyComparator(1, false));
          if (((List)localObject6).size() <= 0) {
            break label4495;
          }
          localLinkedHashMap.put(this.l.getString(2131917601), localObject6);
          break label4495;
        }
        int n;
        if (this.l.bj == 7)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          localObject6 = new ArrayList();
          n = this.l.J.size();
          localObject7 = new HashMap(n);
          m = 0;
          while (m < n)
          {
            localObject8 = (ChatHistoryTroopMemberFragment.ATroopMember)this.l.J.get(m);
            ((ChatHistoryTroopMemberFragment.ATroopMember)localObject8).R = 0;
            ((HashMap)localObject7).put(((ChatHistoryTroopMemberFragment.ATroopMember)localObject8).a, localObject8);
            m += 1;
          }
          if (ChatHistoryTroopMemberFragment.v(this.l) != null)
          {
            m = 0;
            if (m < ChatHistoryTroopMemberFragment.v(this.l).length)
            {
              localObject8 = (ChatHistoryTroopMemberFragment.ATroopMember)((HashMap)localObject7).remove(String.valueOf(ChatHistoryTroopMemberFragment.v(this.l)[m]));
              if (localObject8 == null) {
                break label4467;
              }
              ((List)localObject1).add(localObject8);
              break label4467;
            }
          }
          if (ChatHistoryTroopMemberFragment.w(this.l) != null)
          {
            m = 0;
            if (m < ChatHistoryTroopMemberFragment.w(this.l).length)
            {
              localObject8 = (ChatHistoryTroopMemberFragment.ATroopMember)((HashMap)localObject7).remove(String.valueOf(ChatHistoryTroopMemberFragment.w(this.l)[m]));
              if (localObject8 == null) {
                break label4474;
              }
              ((List)localObject4).add(localObject8);
              break label4474;
            }
          }
          if (ChatHistoryTroopMemberFragment.x(this.l) != null)
          {
            m = 0;
            if (m < ChatHistoryTroopMemberFragment.x(this.l).length)
            {
              localObject8 = (ChatHistoryTroopMemberFragment.ATroopMember)((HashMap)localObject7).remove(String.valueOf(ChatHistoryTroopMemberFragment.x(this.l)[m]));
              if (localObject8 == null) {
                break label4481;
              }
              ((List)localObject5).add(localObject8);
              break label4481;
            }
          }
          localObject7 = ((HashMap)localObject7).entrySet().iterator();
          while (((Iterator)localObject7).hasNext()) {
            ((List)localObject6).add(((Map.Entry)((Iterator)localObject7).next()).getValue());
          }
          Collections.sort((List)localObject1, new ChatHistoryTroopMemberFragment.MyComparator(2, true));
          if (!((List)localObject1).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131899837), localObject1);
          }
          if (!((List)localObject4).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131899895), localObject4);
          }
          if (!((List)localObject5).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131899862), localObject5);
          }
          Collections.sort((List)localObject6, new ChatHistoryTroopMemberFragment.MyComparator(2, true));
          if (((List)localObject6).isEmpty()) {
            break label4495;
          }
          localLinkedHashMap.put(HardCodeUtil.a(2131899822), localObject6);
          break label4495;
        }
        if (this.l.bj == 8)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new HashMap();
          if (this.g != null)
          {
            n = this.g.size();
            m = 0;
            while (m < n)
            {
              localObject6 = (oidb_0xa2a.UserInfo)this.g.get(m);
              ((HashMap)localObject5).put(String.valueOf(((oidb_0xa2a.UserInfo)localObject6).uin.get()), localObject6);
              m += 1;
            }
          }
          localObject6 = this.l.J.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject6).next();
            localObject8 = (oidb_0xa2a.UserInfo)((HashMap)localObject5).get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject7).a);
            if (localObject8 != null)
            {
              ((List)localObject1).add(localObject7);
              ((ChatHistoryTroopMemberFragment.ATroopMember)localObject7).V = ((oidb_0xa2a.UserInfo)localObject8).score.get();
            }
            else
            {
              ((List)localObject4).add(localObject7);
            }
          }
          if (((List)localObject1).size() > 0)
          {
            Collections.sort((List)localObject1, new ChatHistoryTroopMemberFragment.MyComparator(8, false));
            localLinkedHashMap.put(HardCodeUtil.a(2131899858), localObject1);
          }
          if (((List)localObject4).size() <= 0) {
            break label4495;
          }
          Collections.sort((List)localObject4, new ChatHistoryTroopMemberFragment.MyComparator(8, false));
          localLinkedHashMap.put(HardCodeUtil.a(2131899851), localObject4);
          break label4495;
        }
        if (this.l.bj != 4) {
          break label4495;
        }
        localObject1 = new LinkedHashMap();
        localObject4 = this.l.getResources().getStringArray(2130968676);
        localObject5 = HardCodeUtil.a(2131899828);
        localObject6 = this.l.J.iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject6).next();
          n = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject7).x;
          m = n;
          if (n >= 10000) {
            m = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject7).x - 10000;
          }
          if ((m >= 321) && (m <= 327))
          {
            localObject8 = localObject4[(m - 321)];
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
        m = localObject4.length - 1;
        if (m >= 0)
        {
          if (((LinkedHashMap)localObject1).get(localObject4[m]) == null) {
            break label4488;
          }
          Collections.sort((List)((LinkedHashMap)localObject1).get(localObject4[m]), new ChatHistoryTroopMemberFragment.MyComparator(0, false));
          localLinkedHashMap.put(localObject4[m], ((LinkedHashMap)localObject1).get(localObject4[m]));
          break label4488;
        }
        if (((LinkedHashMap)localObject1).get(localObject5) != null)
        {
          Collections.sort((List)((LinkedHashMap)localObject1).get(localObject5), new ChatHistoryTroopMemberFragment.MyComparator(0, false));
          localLinkedHashMap.put(localObject5, ((LinkedHashMap)localObject1).get(localObject5));
        }
        GameCenterUtils.a(null, "846", "205607", "", "84601", "1", "145");
        break label4495;
      }
      if (this.l.B) {
        ((LinkedHashMap)localObject1).remove(this.l.getString(2131916742));
      }
      localObject4 = new int[((LinkedHashMap)localObject1).keySet().size()];
      localObject5 = new String[localObject4.length];
      Object localObject6 = ((LinkedHashMap)localObject1).keySet().iterator();
      if (localObject4.length == 0) {
        return new Object[0];
      }
      localObject4[0] = 0;
      m = 1;
      while (m < localObject4.length)
      {
        localObject4[m] += localObject4[(m - 1)] + ((List)((LinkedHashMap)localObject1).get(((Iterator)localObject6).next())).size() + 1;
        m += 1;
      }
      localObject6 = ((LinkedHashMap)localObject1).keySet().iterator();
      m = 0;
      while (((Iterator)localObject6).hasNext())
      {
        localObject5[m] = ((String)((Iterator)localObject6).next());
        m += 1;
      }
      if (this.l.az == 0) {
        this.l.a((int[])localObject4);
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("constructHashStruct, time:");
        ((StringBuilder)localObject6).append(l2 - l1);
        ((StringBuilder)localObject6).append(", sortType:");
        ((StringBuilder)localObject6).append(this.l.bj);
        ((StringBuilder)localObject6).append(", listSize:");
        ((StringBuilder)localObject6).append(this.l.J.size());
        QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject6).toString());
      }
      return new Object[] { localObject1, localObject4, localObject5 };
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "mAdapter.notifyDataSetChanged2()");
    }
    QLog.d(".troop.troopManagerVASH", 2, new Object[] { "notifyDataSetChanged2 List count: ", Integer.valueOf(this.l.J.size()) });
    Object[] arrayOfObject = b();
    if (arrayOfObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "constructHashStruct result == null!");
      }
      return;
    }
    if (arrayOfObject.length >= 3)
    {
      this.a = ((LinkedHashMap)arrayOfObject[0]);
      this.b = ((int[])arrayOfObject[1]);
      this.c = ((String[])arrayOfObject[2]);
      this.l.getBaseActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.ListAdapter.1(this));
      return;
    }
    if ((arrayOfObject.length == 0) && ((this.l.az == 13) || (this.l.az == 21)))
    {
      this.a.clear();
      this.b = new int[0];
      this.c = new String[0];
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    if (this.l.az == 9)
    {
      if (this.l.J == null) {
        return 0;
      }
      return this.l.J.size();
    }
    Object localObject = this.b;
    if (localObject.length == 0) {
      return 0;
    }
    int m = localObject[(localObject.length - 1)];
    localObject = this.a;
    String[] arrayOfString = this.c;
    return m + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.l.az == 9)
    {
      if ((paramInt >= 0) && (paramInt <= this.l.J.size() - 1)) {
        return this.l.J.get(paramInt);
      }
      return null;
    }
    int m = Arrays.binarySearch(this.b, paramInt);
    if (m >= 0) {
      return null;
    }
    m = -(m + 1) - 1;
    return (ChatHistoryTroopMemberFragment.ATroopMember)((List)this.a.get(this.c[m])).get(paramInt - this.b[m] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ChatHistoryTroopMemberFragment.r(this.l))
    {
      int m = Arrays.binarySearch(this.b, paramInt);
      if (m < 0)
      {
        m = -(m + 1) - 1;
        ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)((List)this.a.get(this.c[m])).get(paramInt - this.b[m] - 1);
        if ((TextUtils.isEmpty(localATroopMember.n)) && (!TextUtils.isEmpty(localATroopMember.r)) && (!TextUtils.isEmpty(localATroopMember.h)) && (!localATroopMember.h.equals(localATroopMember.r))) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int m = getItemViewType(paramInt);
    boolean bool = true;
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      if (m == 0)
      {
        localView = this.l.al.inflate(2131629583, paramViewGroup, false);
        paramView = new ChatHistoryTroopMemberFragment.TmViewHolder(localView, false);
      }
      else
      {
        localView = this.l.al.inflate(2131629587, paramViewGroup, false);
        paramView = new ChatHistoryTroopMemberFragment.TmViewHolder(localView, true);
      }
      if (this.l.bb) {
        paramView.c.setBackgroundResource(2130839577);
      } else {
        paramView.c.setBackgroundResource(2130839574);
      }
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (ChatHistoryTroopMemberFragment.TmViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    paramView.y = "";
    if (this.l.az == 9)
    {
      localObject1 = (ChatHistoryTroopMemberFragment.ATroopMember)this.l.J.get(paramInt);
      paramView.m.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a);
      paramView.f.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a);
      paramView.d.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a);
      paramView.c.setTag(Integer.valueOf(paramInt));
      this.l.a(paramView, (ChatHistoryTroopMemberFragment.ATroopMember)localObject1, a(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a, 2), false, false);
    }
    else
    {
      int n = Arrays.binarySearch(this.b, paramInt);
      Object localObject2;
      Object localObject3;
      if (n < 0)
      {
        n = -(n + 1) - 1;
        localObject1 = (ChatHistoryTroopMemberFragment.ATroopMember)((List)this.a.get(this.c[n])).get(paramInt - this.b[n] - 1);
        paramView.m.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a);
        paramView.f.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a);
        paramView.d.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a);
        paramView.c.setTag(Integer.valueOf(paramInt));
        if (((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).J)
        {
          localObject2 = new ColorNickText(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).c, 16).b();
          paramView.j.setText((CharSequence)localObject2);
          ColorNickManager.a(this.l.bc, paramView.j, (Spannable)localObject2);
          paramView.A.setImageResource(2130839779);
          paramView.c.setOnClickListener(this.l.bo);
        }
        else
        {
          localObject2 = this.l;
          localObject3 = a(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a, 2);
          if (m != 1) {
            bool = false;
          }
          ((ChatHistoryTroopMemberFragment)localObject2).a(paramView, (ChatHistoryTroopMemberFragment.ATroopMember)localObject1, (Bitmap)localObject3, false, bool);
        }
        if (this.l.az == 12) {
          if (this.d.contains(localObject1)) {
            paramView.r.setVisibility(0);
          } else {
            paramView.r.setVisibility(8);
          }
        }
        if (this.l.A)
        {
          paramView.u.setVisibility(8);
        }
        else if (this.l.ba != null)
        {
          this.l.ba.a(paramView, (ChatHistoryTroopMemberFragment.ATroopMember)localObject1);
          if (paramView.u.getVisibility() == 0)
          {
            m = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
            paramView.j.setMaxWidth(m);
            ChatHistoryTroopMemberFragment.a(this.l.bc, paramView.j, paramView.l, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).a, m);
          }
        }
      }
      else
      {
        paramView.c.b(false);
        paramView.c.setVisibility(8);
        paramView.a.setVisibility(8);
        paramView.r.setVisibility(8);
        paramView.c.setOnClickListener(null);
        paramView.m.setTag("");
        paramView.f.setTag("");
        paramView.d.setTag("");
        paramView.c.setTag(Integer.valueOf(-1));
        if ((this.l.az != 9) && (this.l.az != 19))
        {
          paramView.b.setVisibility(0);
          localObject1 = (List)this.a.get(this.c[n]);
          if (localObject1 != null) {
            if (this.l.getString(2131917609).equals(String.valueOf(this.c[n])))
            {
              paramView.b.setText(String.valueOf(this.c[n]));
            }
            else
            {
              localObject2 = paramView.b;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(String.valueOf(this.c[n]));
              ((StringBuilder)localObject3).append(this.l.getString(2131918187, new Object[] { Integer.valueOf(((List)localObject1).size()) }));
              ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
            }
          }
        }
        else
        {
          paramView.b.setVisibility(8);
        }
        if (this.l.az == 12)
        {
          localObject1 = (List)this.a.get(this.c[n]);
          m = paramInt - this.b[n] - 1;
          if ((m >= 0) && (m < ((List)localObject1).size()))
          {
            localObject1 = (ChatHistoryTroopMemberFragment.ATroopMember)((List)localObject1).get(m);
            if (this.d.contains(localObject1)) {
              paramView.r.setVisibility(0);
            } else {
              paramView.r.setVisibility(8);
            }
          }
        }
        paramView.c.setContentDescription("");
      }
    }
    if ((paramView.n != null) && (this.l.af != null)) {
      if (this.l.af.getVisibility() == 0) {
        paramView.n.setVisibility(0);
      } else {
        paramView.n.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ListAdapter
 * JD-Core Version:    0.7.0.1
 */