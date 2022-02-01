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
  public int a;
  public String a;
  public LinkedHashMap<String, List<ChatHistoryTroopMemberFragment.ATroopMember>> a;
  public List<ChatHistoryTroopMemberFragment.ATroopMember> a;
  public int[] a;
  public String[] a;
  public int b;
  public List<String> b;
  public int c;
  protected List<String> c;
  protected List<oidb_0xa2a.UserInfo> d;
  
  public ChatHistoryTroopMemberFragment$ListAdapter(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment)
  {
    super(paramChatHistoryTroopMemberFragment.getBaseActivity(), paramChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, true);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 11))
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 5)
      {
        paramChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
        i = 2131696308;
      }
      else
      {
        paramChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
        i = 2131719999;
      }
      paramChatHistoryTroopMemberFragment = paramChatHistoryTroopMemberFragment.getString(i);
    }
    else
    {
      paramChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131691772);
    }
    this.jdField_a_of_type_JavaLangString = paramChatHistoryTroopMemberFragment;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9) {
      return 0;
    }
    return 2131559310;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (i >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[i].equals(paramString)) {
          break label42;
        }
        i += 1;
      }
      i = -1;
      label42:
      if (i >= 0) {
        return this.jdField_a_of_type_ArrayOfInt[i];
      }
    }
    return -1;
  }
  
  public String a(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    if (paramLong == 0L) {
      return paramArrayOfString[7];
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
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
      QLog.d("Q.history.BaseFragment", 2, "mAdapter.notifyDataSetChanged2()");
    }
    QLog.d(".troop.troopManagerVASH", 2, new Object[] { "notifyDataSetChanged2 List count: ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size()) });
    Object[] arrayOfObject = a();
    if (arrayOfObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "constructHashStruct result == null!");
      }
      return;
    }
    if (arrayOfObject.length >= 3)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getBaseActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.ListAdapter.1(this));
      return;
    }
    if ((arrayOfObject.length == 0) && ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 13) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 21)))
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_ArrayOfInt = new int[0];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
      notifyDataSetChanged();
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 9) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 19))
    {
      Object localObject = this.jdField_a_of_type_ArrayOfInt;
      if ((localObject.length > 0) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
      {
        int i = Arrays.binarySearch((int[])localObject, paramInt);
        paramInt = i;
        if (i < 0) {
          paramInt = -(i + 1) - 1;
        }
        localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        if ((localObject != null) && (((List)localObject).size() > 1))
        {
          TextView localTextView = (TextView)paramView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131720487, new Object[] { Integer.valueOf(((List)localObject).size()) }));
          localTextView.setText(localStringBuilder.toString());
        }
        else
        {
          ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_n_of_type_Boolean) {
          paramView.setBackgroundResource(2130838739);
        } else {
          paramView.setBackgroundResource(2130850431);
        }
        paramView.setPadding((int)(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Float * 10.0F), 0, 0, 0);
      }
    }
    else if (paramView != null)
    {
      paramView.setVisibility(8);
    }
  }
  
  public boolean a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int;
    boolean bool = false;
    if (i == 9) {
      return false;
    }
    if (Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public Object[] a()
  {
    long l1 = System.currentTimeMillis();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject7 = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    Object localObject4;
    Object localObject5;
    int i;
    char c1;
    label4382:
    Object localObject3;
    label4389:
    label4392:
    label4399:
    label4406:
    label4414:
    label4437:
    label4445:
    label4452:
    label4459:
    label4466:
    label4473:
    synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)
    {
      Object localObject8;
      Object localObject1;
      Object localObject9;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localObject8 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        localObject1 = new ArrayList();
        localObject9 = new ArrayList();
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_c_of_type_Int = 0;
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)localObject6).hasNext())
        {
          ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject6).next();
          if (((ITroopRobotService)localObject7).isRobotUin(localATroopMember.jdField_a_of_type_JavaLangString))
          {
            localObject4 = localObject1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 5) {
              break label4382;
            }
            localObject4 = localObject1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 2) {
              break label4382;
            }
            localObject4 = localObject1;
            if (ChatHistoryTroopMemberFragment.f(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)) {
              break label4382;
            }
            ((List)localObject9).add(localATroopMember);
            localObject4 = localObject1;
            break label4382;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 12) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 20))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_n_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_n_of_type_JavaLangString.contains(localATroopMember.jdField_a_of_type_JavaLangString))) {
              ((List)localObject1).add(localATroopMember);
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_JavaLangString.contains(localATroopMember.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localATroopMember))) {
              this.jdField_a_of_type_JavaUtilList.add(localATroopMember);
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_JavaUtilArrayList.contains(localATroopMember.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localATroopMember)))
            {
              this.jdField_a_of_type_JavaUtilList.add(localATroopMember);
              this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_JavaUtilArrayList.remove(localATroopMember.jdField_a_of_type_JavaLangString);
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 13) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 21)) {
            break label4389;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) && ((localATroopMember.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_JavaUtilList.contains(localATroopMember.jdField_a_of_type_JavaLangString)))) {
            localArrayList1.add(localATroopMember);
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) && (localATroopMember.jdField_b_of_type_Boolean)) {
            localArrayList3.add(localATroopMember);
          }
          if (localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break label4389;
          }
          if (localATroopMember.jdField_d_of_type_Long == 1L) {
            localArrayList2.add(localATroopMember);
          }
          if (((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f.equals(localATroopMember.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString.contains(localATroopMember.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) && ((localATroopMember.jdField_b_of_type_Int == 332) || (localATroopMember.jdField_b_of_type_Int == 333))))
          {
            ((List)localObject8).add(localATroopMember);
            if (!QLog.isColorLevel()) {
              break label4392;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("constructHashStruct uin = ");
            ((StringBuilder)localObject4).append(localATroopMember.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject4).append(", name = ");
            ((StringBuilder)localObject4).append(localATroopMember.jdField_g_of_type_JavaLangString);
            ((StringBuilder)localObject4).append(", level = ");
            ((StringBuilder)localObject4).append(localATroopMember.jdField_b_of_type_Int);
            QLog.d("zivonchen", 2, ((StringBuilder)localObject4).toString());
            break label4399;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 5) && (!TextUtils.isEmpty(localATroopMember.u)))
          {
            ((List)localObject8).add(localATroopMember);
            break label4399;
          }
          if ((localATroopMember.jdField_c_of_type_JavaLangString == null) || (localATroopMember.jdField_c_of_type_JavaLangString.length() == 0)) {
            break label4406;
          }
          localObject4 = localATroopMember.jdField_c_of_type_JavaLangString.substring(0, 1);
          localObject5 = localObject4;
          if (((String)localObject4).length() == 1)
          {
            i = ((String)localObject4).charAt(0);
            if ((65 > i) || (i > 90)) {
              break label4414;
            }
            localObject5 = ((String)localObject4).toUpperCase();
          }
          if (localLinkedHashMap.get(localObject5) == null) {
            localLinkedHashMap.put(localObject5, new ArrayList());
          }
          this.jdField_b_of_type_Int += 1;
          ((List)localLinkedHashMap.get(localObject5)).add(localATroopMember);
          break label4399;
        }
        char c2 = 'A';
        localObject5 = new ChatHistoryTroopMemberFragment.MyComparator(0, true);
        localObject4 = new LinkedHashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 19)
        {
          localObject1 = localObject4;
          if (((List)localObject8).size() > 0)
          {
            Collections.sort((List)localObject8, (Comparator)localObject5);
            this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a((List)localObject8, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString);
            ((LinkedHashMap)localObject4).put(ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment), localObject8);
            localObject1 = localObject4;
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_Int = 0;
          Collections.sort((List)localObject8, (Comparator)localObject5);
          ((LinkedHashMap)localObject4).put(HardCodeUtil.a(2131701806), this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList);
          localObject1 = localObject4;
        }
        else
        {
          if ((localArrayList1.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 12))
          {
            Collections.sort(localArrayList1, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131719200), localArrayList1);
          }
          if ((localArrayList3.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 3))
          {
            Collections.sort(localArrayList3, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131719972), localArrayList3);
          }
          if ((localArrayList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 3))
          {
            Collections.sort(localArrayList2, (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131691306), localArrayList2);
          }
          if (((List)localObject8).size() > 0)
          {
            Collections.sort((List)localObject8, (Comparator)localObject5);
            this.jdField_c_of_type_Int += ((List)localObject8).size();
            this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a((List)localObject8, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) {
              localObject1 = ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment);
            } else {
              localObject1 = this.jdField_a_of_type_JavaLangString;
            }
            ((LinkedHashMap)localObject4).put(localObject1, localObject8);
          }
          c1 = c2;
          if (((List)localObject9).size() > 0)
          {
            Collections.sort((List)localObject9, (Comparator)localObject5);
            this.jdField_c_of_type_Int += ((List)localObject9).size();
            ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131720004), localObject9);
            c1 = c2;
          }
          if (c1 <= 'Z')
          {
            if (localLinkedHashMap.get(String.valueOf(c1)) == null) {
              break label4437;
            }
            this.jdField_a_of_type_Int += 1;
            Collections.sort((List)localLinkedHashMap.get(String.valueOf(c1)), (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put(String.valueOf(c1), localLinkedHashMap.get(String.valueOf(c1)));
            break label4437;
          }
          if (localLinkedHashMap.get("#") != null)
          {
            this.jdField_a_of_type_Int += 1;
            Collections.sort((List)localLinkedHashMap.get("#"), (Comparator)localObject5);
            ((LinkedHashMap)localObject4).put("#", localLinkedHashMap.get("#"));
          }
          localLinkedHashMap.clear();
          localObject1 = localObject4;
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 2)
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getResources().getStringArray(2130968679);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject5).next();
          if (TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).r)) {
            ((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).r = a((String[])localObject4, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).jdField_b_of_type_Long, (Calendar)localObject1);
          }
          if (localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).r) == null) {
            localLinkedHashMap.put(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).r, new ArrayList());
          }
          ((List)localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).r)).add(localObject6);
        }
        localObject1 = new LinkedHashMap();
        i = localObject4.length - 1;
        if (i >= 0)
        {
          if (localLinkedHashMap.get(localObject4[i]) == null) {
            break label4445;
          }
          Collections.sort((List)localLinkedHashMap.get(localObject4[i]), new ChatHistoryTroopMemberFragment.MyComparator(2, false));
          ((LinkedHashMap)localObject1).put(localObject4[i], localLinkedHashMap.get(localObject4[i]));
          break label4445;
        }
        localLinkedHashMap.clear();
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 6)
      {
        if (ChatHistoryTroopMemberFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).size() == 0) {
          return null;
        }
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject4).next();
          if (TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).r))
          {
            if (((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).jdField_b_of_type_Long == 0L) {
              ((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).jdField_b_of_type_Long = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).jdField_a_of_type_Long;
            }
            ((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).r = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).jdField_b_of_type_Long, (Calendar)localObject1, ChatHistoryTroopMemberFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment), ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment));
          }
          if (localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).r) == null) {
            localLinkedHashMap.put(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).r, new ArrayList());
          }
          if (!TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).r)) {
            ((List)localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject5).r)).add(localObject5);
          }
        }
        localObject1 = new LinkedHashMap();
        i = ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).size() - 1;
        if (i >= 0)
        {
          if (localLinkedHashMap.get(ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).get(i)) == null) {
            break label4452;
          }
          Collections.sort((List)localLinkedHashMap.get(ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).get(i)), new ChatHistoryTroopMemberFragment.MyComparator(2, false));
          ((LinkedHashMap)localObject1).put(ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).get(i), localLinkedHashMap.get(ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).get(i)));
          break label4452;
        }
        localLinkedHashMap.clear();
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 3)
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getResources().getStringArray(2130968680);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject5).next();
          if (TextUtils.isEmpty(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).q)) {
            ((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).q = b((String[])localObject4, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).jdField_a_of_type_Long, (Calendar)localObject1);
          }
          if (localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).q) == null) {
            localLinkedHashMap.put(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).q, new ArrayList());
          }
          ((List)localLinkedHashMap.get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject6).q)).add(localObject6);
        }
        localObject1 = new LinkedHashMap();
        i = localObject4.length - 1;
        if (i >= 0)
        {
          if (localLinkedHashMap.get(localObject4[i]) == null) {
            break label4459;
          }
          Collections.sort((List)localLinkedHashMap.get(localObject4[i]), new ChatHistoryTroopMemberFragment.MyComparator(3, false));
          ((LinkedHashMap)localObject1).put(localObject4[i], localLinkedHashMap.get(localObject4[i]));
          break label4459;
        }
        localLinkedHashMap.clear();
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 1)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          localObject6 = new ArrayList();
          localObject8 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject9 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject8).next();
            if (((ITroopRobotService)localObject7).isRobotUin(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_a_of_type_JavaLangString))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 5) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 2) && (!ChatHistoryTroopMemberFragment.f(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment))) {
                if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.contains(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_a_of_type_JavaLangString)))
                {
                  ((List)localObject1).add(localObject9);
                  ((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_d_of_type_Boolean = true;
                }
                else
                {
                  ((List)localObject6).add(localObject9);
                  ((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_d_of_type_Boolean = false;
                }
              }
            }
            else if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.contains(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_a_of_type_JavaLangString)))
            {
              ((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_d_of_type_Boolean = true;
              if (((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f.equals(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString.contains(((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) && ((((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_b_of_type_Int == 332) || (((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_b_of_type_Int == 333)))) {
                ((List)localObject4).add(localObject9);
              } else {
                ((List)localObject5).add(localObject9);
              }
            }
            else
            {
              ((ChatHistoryTroopMemberFragment.ATroopMember)localObject9).jdField_d_of_type_Boolean = false;
              ((List)localObject6).add(localObject9);
            }
          }
          localLinkedHashMap.clear();
          Collections.sort((List)localObject1, new ChatHistoryTroopMemberFragment.MyComparator(1, false));
          if (((List)localObject1).size() > 0) {
            localLinkedHashMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131720004), localObject1);
          }
          if (((List)localObject4).size() > 0)
          {
            Collections.sort((List)localObject4, new ChatHistoryTroopMemberFragment.MyComparator(1, false));
            this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a((List)localObject4, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131694609);
            } else {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131694608);
            }
            localLinkedHashMap.put(localObject1, localObject4);
          }
          Collections.sort((List)localObject5, new ChatHistoryTroopMemberFragment.MyComparator(1, false));
          if (((List)localObject5).size() > 0) {
            localLinkedHashMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131719997), localObject5);
          }
          Collections.sort((List)localObject6, new ChatHistoryTroopMemberFragment.MyComparator(1, false));
          if (((List)localObject6).size() <= 0) {
            break label4494;
          }
          localLinkedHashMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131719996), localObject6);
          break label4494;
        }
        int j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 7)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new ArrayList();
          localObject6 = new ArrayList();
          j = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size();
          localObject7 = new HashMap(j);
          i = 0;
          while (i < j)
          {
            localObject8 = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.get(i);
            ((ChatHistoryTroopMemberFragment.ATroopMember)localObject8).jdField_m_of_type_Int = 0;
            ((HashMap)localObject7).put(((ChatHistoryTroopMemberFragment.ATroopMember)localObject8).jdField_a_of_type_JavaLangString, localObject8);
            i += 1;
          }
          if (ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment) != null)
          {
            i = 0;
            if (i < ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).length)
            {
              localObject8 = (ChatHistoryTroopMemberFragment.ATroopMember)((HashMap)localObject7).remove(String.valueOf(ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)[i]));
              if (localObject8 == null) {
                break label4466;
              }
              ((List)localObject1).add(localObject8);
              break label4466;
            }
          }
          if (ChatHistoryTroopMemberFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment) != null)
          {
            i = 0;
            if (i < ChatHistoryTroopMemberFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).length)
            {
              localObject8 = (ChatHistoryTroopMemberFragment.ATroopMember)((HashMap)localObject7).remove(String.valueOf(ChatHistoryTroopMemberFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)[i]));
              if (localObject8 == null) {
                break label4473;
              }
              ((List)localObject4).add(localObject8);
              break label4473;
            }
          }
          if (ChatHistoryTroopMemberFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment) != null)
          {
            i = 0;
            if (i < ChatHistoryTroopMemberFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).length)
            {
              localObject8 = (ChatHistoryTroopMemberFragment.ATroopMember)((HashMap)localObject7).remove(String.valueOf(ChatHistoryTroopMemberFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)[i]));
              if (localObject8 == null) {
                break label4480;
              }
              ((List)localObject5).add(localObject8);
              break label4480;
            }
          }
          localObject7 = ((HashMap)localObject7).entrySet().iterator();
          while (((Iterator)localObject7).hasNext()) {
            ((List)localObject6).add(((Map.Entry)((Iterator)localObject7).next()).getValue());
          }
          Collections.sort((List)localObject1, new ChatHistoryTroopMemberFragment.MyComparator(2, true));
          if (!((List)localObject1).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131701819), localObject1);
          }
          if (!((List)localObject4).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131701879), localObject4);
          }
          if (!((List)localObject5).isEmpty()) {
            localLinkedHashMap.put(HardCodeUtil.a(2131701845), localObject5);
          }
          Collections.sort((List)localObject6, new ChatHistoryTroopMemberFragment.MyComparator(2, true));
          if (((List)localObject6).isEmpty()) {
            break label4494;
          }
          localLinkedHashMap.put(HardCodeUtil.a(2131701804), localObject6);
          break label4494;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 8)
        {
          localObject1 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = new HashMap();
          if (this.jdField_d_of_type_JavaUtilList != null)
          {
            j = this.jdField_d_of_type_JavaUtilList.size();
            i = 0;
            while (i < j)
            {
              localObject6 = (oidb_0xa2a.UserInfo)this.jdField_d_of_type_JavaUtilList.get(i);
              ((HashMap)localObject5).put(String.valueOf(((oidb_0xa2a.UserInfo)localObject6).uin.get()), localObject6);
              i += 1;
            }
          }
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject6).next();
            localObject8 = (oidb_0xa2a.UserInfo)((HashMap)localObject5).get(((ChatHistoryTroopMemberFragment.ATroopMember)localObject7).jdField_a_of_type_JavaLangString);
            if (localObject8 != null)
            {
              ((List)localObject1).add(localObject7);
              ((ChatHistoryTroopMemberFragment.ATroopMember)localObject7).n = ((oidb_0xa2a.UserInfo)localObject8).score.get();
            }
            else
            {
              ((List)localObject4).add(localObject7);
            }
          }
          if (((List)localObject1).size() > 0)
          {
            Collections.sort((List)localObject1, new ChatHistoryTroopMemberFragment.MyComparator(8, false));
            localLinkedHashMap.put(HardCodeUtil.a(2131701841), localObject1);
          }
          if (((List)localObject4).size() <= 0) {
            break label4494;
          }
          Collections.sort((List)localObject4, new ChatHistoryTroopMemberFragment.MyComparator(8, false));
          localLinkedHashMap.put(HardCodeUtil.a(2131701834), localObject4);
          break label4494;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int != 4) {
          break label4494;
        }
        localObject1 = new LinkedHashMap();
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getResources().getStringArray(2130968674);
        localObject5 = HardCodeUtil.a(2131701810);
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject6).next();
          j = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject7).jdField_b_of_type_Int;
          i = j;
          if (j >= 10000) {
            i = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject7).jdField_b_of_type_Int - 10000;
          }
          if ((i >= 321) && (i <= 327))
          {
            localObject8 = localObject4[(i - 321)];
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
        i = localObject4.length - 1;
        if (i >= 0)
        {
          if (((LinkedHashMap)localObject1).get(localObject4[i]) == null) {
            break label4487;
          }
          Collections.sort((List)((LinkedHashMap)localObject1).get(localObject4[i]), new ChatHistoryTroopMemberFragment.MyComparator(0, false));
          localLinkedHashMap.put(localObject4[i], ((LinkedHashMap)localObject1).get(localObject4[i]));
          break label4487;
        }
        if (((LinkedHashMap)localObject1).get(localObject5) != null)
        {
          Collections.sort((List)((LinkedHashMap)localObject1).get(localObject5), new ChatHistoryTroopMemberFragment.MyComparator(0, false));
          localLinkedHashMap.put(localObject5, ((LinkedHashMap)localObject1).get(localObject5));
        }
        GameCenterUtils.a(null, "846", "205607", "", "84601", "1", "145");
        break label4494;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.h) {
        ((LinkedHashMap)localObject1).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131719200));
      }
      localObject4 = new int[((LinkedHashMap)localObject1).keySet().size()];
      localObject5 = new String[localObject4.length];
      Object localObject6 = ((LinkedHashMap)localObject1).keySet().iterator();
      if (localObject4.length == 0) {
        return new Object[0];
      }
      localObject4[0] = 0;
      i = 1;
      while (i < localObject4.length)
      {
        localObject4[i] += localObject4[(i - 1)] + ((List)((LinkedHashMap)localObject1).get(((Iterator)localObject6).next())).size() + 1;
        i += 1;
      }
      localObject6 = ((LinkedHashMap)localObject1).keySet().iterator();
      i = 0;
      while (((Iterator)localObject6).hasNext())
      {
        localObject5[i] = ((String)((Iterator)localObject6).next());
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a((int[])localObject4);
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("constructHashStruct, time:");
        ((StringBuilder)localObject6).append(l2 - l1);
        ((StringBuilder)localObject6).append(", sortType:");
        ((StringBuilder)localObject6).append(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int);
        ((StringBuilder)localObject6).append(", listSize:");
        ((StringBuilder)localObject6).append(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size());
        QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject6).toString());
      }
      return new Object[] { localObject1, localObject4, localObject5 };
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList == null) {
        return 0;
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size();
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    if (localObject.length == 0) {
      return 0;
    }
    int i = localObject[(localObject.length - 1)];
    localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    return i + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9)
    {
      if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size() - 1)) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
      return null;
    }
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (ChatHistoryTroopMemberFragment.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment))
    {
      int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      if (i < 0)
      {
        i = -(i + 1) - 1;
        ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
        if ((TextUtils.isEmpty(localATroopMember.jdField_m_of_type_JavaLangString)) && (!TextUtils.isEmpty(localATroopMember.p)) && (!TextUtils.isEmpty(localATroopMember.jdField_g_of_type_JavaLangString)) && (!localATroopMember.jdField_g_of_type_JavaLangString.equals(localATroopMember.p))) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    boolean bool = true;
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      if (i == 0)
      {
        localView = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562975, paramViewGroup, false);
        paramView = new ChatHistoryTroopMemberFragment.TmViewHolder(localView, false);
      }
      else
      {
        localView = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562979, paramViewGroup, false);
        paramView = new ChatHistoryTroopMemberFragment.TmViewHolder(localView, true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_n_of_type_Boolean) {
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setBackgroundResource(2130839393);
      } else {
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setBackgroundResource(2130839390);
      }
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (ChatHistoryTroopMemberFragment.TmViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    paramView.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9)
    {
      localObject1 = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.g.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString);
      paramView.jdField_b_of_type_AndroidViewView.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidViewView.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a(paramView, (ChatHistoryTroopMemberFragment.ATroopMember)localObject1, a(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString, 2), false, false);
    }
    else
    {
      int j = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      Object localObject2;
      Object localObject3;
      if (j < 0)
      {
        j = -(j + 1) - 1;
        localObject1 = (ChatHistoryTroopMemberFragment.ATroopMember)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[j] - 1);
        paramView.g.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString);
        paramView.jdField_b_of_type_AndroidViewView.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString);
        paramView.jdField_a_of_type_AndroidViewView.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString);
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        if (((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_c_of_type_Boolean)
        {
          localObject2 = new ColorNickText(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_b_of_type_JavaLangString, 16).a();
          paramView.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramView.jdField_e_of_type_AndroidWidgetTextView, (Spannable)localObject2);
          paramView.c.setImageResource(2130839566);
          paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.c);
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
          localObject3 = a(((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString, 2);
          if (i != 1) {
            bool = false;
          }
          ((ChatHistoryTroopMemberFragment)localObject2).a(paramView, (ChatHistoryTroopMemberFragment.ATroopMember)localObject1, (Bitmap)localObject3, false, bool);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 12) {
          if (this.jdField_a_of_type_JavaUtilList.contains(localObject1)) {
            paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_Boolean)
        {
          paramView.f.setVisibility(8);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper.a(paramView, (ChatHistoryTroopMemberFragment.ATroopMember)localObject1);
          if (paramView.f.getVisibility() == 0)
          {
            i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
            paramView.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(i);
            ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramView.jdField_e_of_type_AndroidWidgetTextView, paramView.d, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject1).jdField_a_of_type_JavaLangString, i);
          }
        }
      }
      else
      {
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.b(false);
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setOnClickListener(null);
        paramView.g.setTag("");
        paramView.jdField_b_of_type_AndroidViewView.setTag("");
        paramView.jdField_a_of_type_AndroidViewView.setTag("");
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(-1));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 9) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 19))
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          localObject1 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
          if (localObject1 != null) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131720004).equals(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j])))
            {
              paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j]));
            }
            else
            {
              localObject2 = paramView.jdField_b_of_type_AndroidWidgetTextView;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j]));
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131720487, new Object[] { Integer.valueOf(((List)localObject1).size()) }));
              ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
            }
          }
        }
        else
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 12)
        {
          localObject1 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
          i = paramInt - this.jdField_a_of_type_ArrayOfInt[j] - 1;
          if ((i >= 0) && (i < ((List)localObject1).size()))
          {
            localObject1 = (ChatHistoryTroopMemberFragment.ATroopMember)((List)localObject1).get(i);
            if (this.jdField_a_of_type_JavaUtilList.contains(localObject1)) {
              paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            } else {
              paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
        }
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setContentDescription("");
      }
    }
    if ((paramView.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqWidgetIndexView != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() == 0) {
        paramView.jdField_e_of_type_AndroidViewView.setVisibility(0);
      } else {
        paramView.jdField_e_of_type_AndroidViewView.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ListAdapter
 * JD-Core Version:    0.7.0.1
 */