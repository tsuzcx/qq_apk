package com.tencent.mobileqq.activity.aio.tips;

import ahqq;
import ahqs;
import ahrb;
import ahrc;
import amrb;
import amsw;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bcef;
import bfur;
import bfxg;
import bfxl;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import lmq;
import lmr;
import lzb;
import mqq.os.MqqHandler;
import mrd;
import mum;

public class VideoStatusTipsBar
  implements ahqq, View.OnClickListener
{
  protected float a;
  private ahqs jdField_a_of_type_Ahqs;
  Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private VideoStatusTipsBar.RefreshMultiStateRunnable jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private ImageView[] jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
  
  public VideoStatusTipsBar(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ahqs paramahqs, Context paramContext, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaLangString = ("VideoStatusTipsBar." + paramSessionInfo.curType + "." + paramSessionInfo.curFriendUin + "_" + AudioHelper.b());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Ahqs = paramahqs;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    if (AudioHelper.f()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "VideoStatusTipsBar, curFriendUin[" + paramSessionInfo.curFriendUin + "], curType[" + paramSessionInfo.curType + "]");
    }
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    case 22: 
    default: 
      i = 3;
    case 20: 
    case 21: 
      return i;
    }
    return 2;
  }
  
  private String a(long paramLong, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter() != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramLong, paramInt);
      }
    }
    if ((localObject1 != null) && (((lmr)localObject1).a())) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131689916);
    }
    if ((localObject1 != null) && (((lmr)localObject1).b())) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131689887);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131689912);
  }
  
  private String a(boolean paramBoolean, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter() != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramLong1, paramInt1);
      }
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
      {
        if ((localObject1 != null) && (((lmr)localObject1).a())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689892);
        }
        if ((localObject1 != null) && (((lmr)localObject1).b())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689887);
        }
        return this.jdField_a_of_type_AndroidContentContext.getString(2131689884);
      }
      if ((paramInt1 == 2) && (paramLong2 > 99L))
      {
        if ((localObject1 != null) && (((lmr)localObject1).a())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689913);
        }
        if ((localObject1 != null) && (((lmr)localObject1).b())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689915);
        }
        return this.jdField_a_of_type_AndroidContentContext.getString(2131689914);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
      {
        if ((localObject1 != null) && (((lmr)localObject1).a())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689892);
        }
        if ((localObject1 != null) && (((lmr)localObject1).b())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689887);
        }
        return this.jdField_a_of_type_AndroidContentContext.getString(2131689883);
      }
      if ((paramInt1 == 2) && (paramLong2 > 99L))
      {
        if ((localObject1 != null) && (((lmr)localObject1).a())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689913);
        }
        if ((localObject1 != null) && (((lmr)localObject1).b())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689915);
        }
        return this.jdField_a_of_type_AndroidContentContext.getString(2131689893);
      }
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    if (!NetworkUtil.isNetSupport(paramContext.getApplicationContext())) {
      QQToast.a(paramContext, 2131694035, 0).b(paramContext.getApplicationContext().getResources().getDimensionPixelSize(2131299076));
    }
    boolean bool2;
    Intent localIntent;
    long[] arrayOfLong;
    for (;;)
    {
      return;
      if (paramString1 != null)
      {
        bool2 = paramQQAppInterface.getAVNotifyCenter().a(paramString1);
        if ((paramInt2 == 2) && (!bool2))
        {
          paramString2 = new HashMap();
          paramString2.put("MultiAVType", String.valueOf(2));
          paramString2.put("from", "tipBar");
          GroupVideoChatAppInfo.startGroupVideoOrVoice(paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2);
          return;
        }
        if (paramQQAppInterface.getAVNotifyCenter().e() == 4) {}
        for (boolean bool1 = true; !paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramInt1, paramString1, bool1); bool1 = false)
        {
          localIntent = new Intent(paramContext, MultiVideoEnterPageActivity.class);
          localIntent.addFlags(262144);
          localIntent.addFlags(268435456);
          if (paramInt1 != 3000) {
            break label270;
          }
          ArrayList localArrayList = ((amrb)paramQQAppInterface.getManager(53)).a(paramString1);
          if (localArrayList == null) {
            break label389;
          }
          int j = localArrayList.size();
          arrayOfLong = new long[j];
          int i = 0;
          while (i < j)
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i);
            if (localDiscussionMemberInfo != null) {
              arrayOfLong[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
            }
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", arrayOfLong);
      label270:
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uinType", paramInt1);
      localIntent.putExtra("Type", 3);
      localIntent.putExtra("GroupId", paramString1);
      localIntent.putExtra("openClass", paramBoolean);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("Fromwhere", paramString2);
      localIntent.putExtra("flag", bool2);
      if (1 == paramInt1) {
        localIntent.putExtra("groupInfo", bfxg.a(paramQQAppInterface, paramString1));
      }
      paramContext.startActivity(localIntent);
      return;
      label389:
      arrayOfLong = null;
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a())
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        mrd.e(false, true);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startGroupAudio phone is calling!");
        }
        String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695240);
        String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131695219);
        bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, str2, str1, 2131690620, 2131694201, new ahrb(this), null).show();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      bfxl.a();
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131558626, null);
      this.jdField_a_of_type_AndroidViewView.setId(2131371470);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F), 0, (int)(this.jdField_a_of_type_Float * 2.0F));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label252;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839510);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363150));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363128));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363130));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363132));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363256));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363253));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363254));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363255));
      return;
      label252:
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#1f1f1f"));
    }
  }
  
  public int a()
  {
    return 62;
  }
  
  public ahrc a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, TextView paramTextView)
  {
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    lmq locallmq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramInt1, paramLong1);
    if (locallmq == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689922);
      }
      for (;;)
      {
        str = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
        localObject1 = str;
        localObject2 = localObject3;
        if (paramInt2 == 2)
        {
          localObject1 = str;
          localObject2 = localObject3;
          if (paramLong2 > 99L)
          {
            localObject1 = a(true, paramLong1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong2);
            localObject2 = localObject3;
          }
        }
        paramTextView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 3000) {
          break;
        }
        mum.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131695074));
        label169:
        paramTextView = new ahrc();
        paramTextView.b = ((String)localObject2);
        paramTextView.jdField_a_of_type_JavaLangString = ((String)localObject1);
        return paramTextView;
        localObject1 = localObject4;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
          localObject1 = a(true, paramLong1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong2);
        }
      }
    }
    if (locallmq.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(locallmq.jdField_a_of_type_Long);
      if (localObject1 == null) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689922);
          label287:
          localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
          if ((paramInt2 != 2) || (paramLong2 <= 99L)) {
            break label745;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689914);
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
        break label287;
      }
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689884);
      break label287;
      if (paramLong2 == 1L)
      {
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689923);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689921);
        }
        for (;;)
        {
          localObject2 = String.format((String)localObject2, new Object[] { Long.valueOf(paramLong2) });
          if ((paramInt2 != 2) || (paramLong2 <= 99L)) {
            break label742;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689893);
          break;
          localObject2 = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689883);
          }
        }
        localObject2 = Long.toString(locallmq.jdField_a_of_type_Long);
        localObject3 = Long.toString(paramLong1);
        paramInt1 = 2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
          paramInt1 = 1;
        }
        localObject3 = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, (String)localObject3, paramInt1, 0);
        if (paramLong2 == 1L)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689923);
          localObject2 = localObject3;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689921);
        }
        for (;;)
        {
          str = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
          localObject1 = str;
          localObject2 = localObject3;
          if (paramInt2 != 2) {
            break;
          }
          localObject1 = str;
          localObject2 = localObject3;
          if (paramLong2 <= 99L) {
            break;
          }
          localObject1 = a(false, paramLong1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong2);
          localObject2 = localObject3;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
            localObject1 = a(false, paramLong1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong2);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
          break label169;
        }
        mum.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131695107), paramInt2);
        break label169;
        label742:
        continue;
        label745:
        localObject1 = null;
      }
    }
  }
  
  public ahrc a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, TextView paramTextView, ImageView paramImageView)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject2 = Long.toString(paramLong1);
    if ((paramLong1 != 0L) && (!((String)localObject3).equals(Long.valueOf(paramLong1))) && (paramInt1 != 2))
    {
      localObject1 = Long.toString(paramLong2);
      int i = 2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
        i = 1;
      }
      localObject3 = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, (String)localObject1, i, 0);
      if (paramInt2 == 1) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689925);
        }
      }
    }
    for (;;)
    {
      paramTextView.setVisibility(8);
      label122:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
        mum.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131692638));
      }
      for (;;)
      {
        paramImageView.setVisibility(0);
        paramTextView = new ahrc();
        paramTextView.b = ((String)localObject3);
        paramTextView.jdField_a_of_type_JavaLangString = ((String)localObject1);
        return paramTextView;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
          break label475;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689885);
        break;
        if (paramInt2 != 2) {
          break label475;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689926);
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
          break label475;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689886);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f())
        {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689927);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(false);
          localObject3 = localObject4;
          localObject1 = localObject2;
          if (paramInt1 != 2) {
            break label122;
          }
          paramTextView.setVisibility(8);
          localObject3 = localObject4;
          localObject1 = localObject2;
          break label122;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689919);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(true);
          localObject2 = localObject1;
          if (localObject1 != null) {
            localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong3) });
          }
          paramTextView.setVisibility(0);
          localObject3 = localObject4;
          localObject1 = localObject2;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
            localObject1 = a(paramLong2, paramInt1);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
          mum.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131692639), paramInt1);
        }
      }
      label475:
      localObject1 = null;
    }
  }
  
  protected Drawable a(String paramString)
  {
    return FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)4);
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramFloat = f1;
        paramContext = paramString;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramContext = paramTextView;
          paramFloat = f1;
          if (f1 == 0.0F)
          {
            paramContext = paramTextView;
            paramFloat = f1;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0) {
            paramTextView = paramContext + "...";
          }
        }
      }
    }
    return paramTextView;
  }
  
  public void a()
  {
    a("showMeetinInvitedInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 4, 0L);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(paramString1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g();
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f();
    int i;
    if (bool1) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(paramString1);
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshVideoStatus, uinType[" + paramInt + "], peerUin[" + paramString1 + "], extraUin[" + paramString2 + "], sessionType[" + i + "], isOtherTerminalAvChatting[" + bool1 + "], isVideoChatting[" + bool2 + "], SmallScreenState[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g() + "], isReceiver[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g() + "], isWaittingState[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f() + "]");
      ImageView localImageView;
      TextView localTextView;
      if (((bool2) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().k()) && ((i == 1) || (i == 2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == paramInt) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString2)))) || ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin.equals(paramString1)))) {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131558626, null);
          this.jdField_a_of_type_AndroidViewView.setId(2131371470);
          this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float));
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839510);
          this.jdField_a_of_type_AndroidViewView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363150));
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363256));
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368271);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378474);
          label440:
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c() == null) {}
        }
      }
      try
      {
        Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c());
        label507:
        String str;
        if (bool1)
        {
          mum.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131694893));
          str = "";
          if (!bool1) {
            break label841;
          }
          paramString2 = str;
          if (i == 1) {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694893);
          }
          if (i != 2) {
            break label989;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695464);
          label559:
          a(null, paramString2, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167020), paramString1, 0);
          QLog.i(this.jdField_a_of_type_JavaLangString, 1, "refreshVideoStatus info=" + paramString2 + ", peerUin=" + paramString1);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label920;
          }
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839510);
          localImageView.setImageResource(2130839500);
          label654:
          localImageView.setVisibility(0);
          if ((!bool2) || (bool1)) {
            break label947;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g() != 2) {
            break label941;
          }
          bool1 = true;
          label687:
          a(bool1);
          label693:
          if ((!bool2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f())) {
            break label955;
          }
          localTextView.setVisibility(0);
        }
        label841:
        do
        {
          return;
          if (!bool2) {
            break label992;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().e();
          break;
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368271);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378474);
          break label440;
          if (!bool2) {
            break label507;
          }
          if (paramInt == 1)
          {
            mum.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131690189), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b()));
            break label507;
          }
          mum.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131690189));
          break label507;
          paramString2 = str;
          if (!bool2) {
            break label989;
          }
          if (bool3)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695505);
            break label559;
          }
          if (i == 1)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694902);
            break label559;
          }
          paramString2 = str;
          if (i != 2) {
            break label989;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695479);
          break label559;
          this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14737633);
          localImageView.setImageResource(2130839501);
          break label654;
          bool1 = false;
          break label687;
          a(true);
          break label693;
          localTextView.setVisibility(8);
          return;
        } while (b() != this.jdField_a_of_type_Ahqs.a());
        label920:
        label941:
        label947:
        label955:
        this.jdField_a_of_type_Ahqs.a();
        return;
      }
      catch (Exception paramString2)
      {
        label989:
        for (;;) {}
        label992:
        i = 0;
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    label547:
    for (;;)
    {
      return;
      long l3 = AudioHelper.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1))
      {
        a("onAIOEvent_1_" + paramInt + "." + l3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0, 0L);
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().e();
      if (i == 3)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
          a("onAIOEvent_2_" + paramInt + "." + l3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0, 0L);
        }
      }
      else {
        for (;;)
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (!((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
            break label547;
          }
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(paramVarArgs))
          {
            i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(paramVarArgs);
            if (i == 1) {
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
            }
            if (i == 2) {
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
            }
          }
          a(0, paramVarArgs, "");
          long l1 = 0L;
          try
          {
            long l2 = Long.parseLong(paramVarArgs);
            l1 = l2;
          }
          catch (Exception localException)
          {
            label344:
            Intent localIntent;
            break label344;
          }
          if (l1 == 0L) {
            break;
          }
          l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramVarArgs);
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo.notify, eventType[" + paramInt + "], roomId[" + l1 + "], peerUin[" + paramVarArgs + "], seq[" + l3 + "]");
          localIntent = new Intent("tencent.video.q2v.sendQueryRoomInfoRequest");
          localIntent.putExtra("roomId", l1);
          localIntent.putExtra("peerUin", Long.parseLong(paramVarArgs));
          localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          localIntent.putExtra("seq", l3);
          this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
          return;
          if ((i == 1) || (i == 2)) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d());
          }
        }
      }
    }
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable = new VideoStatusTipsBar.RefreshMultiStateRunnable(this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable, paramLong);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(false);
      }
      return;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable);
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    if (AudioHelper.f()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus[" + paramString1 + "], uinType[" + paramInt1 + "], uin[" + paramString2 + "], type[" + paramInt2 + "], memberUin[" + paramLong + "], curType[" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType + "]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1)) {}
    for (;;)
    {
      if (b() == this.jdField_a_of_type_Ahqs.a()) {
        this.jdField_a_of_type_Ahqs.a();
      }
      return;
      label1920:
      try
      {
        l3 = Long.parseLong(paramString2);
        k = mum.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(k, l3);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l3);
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(l3);
        bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(k, l3);
        l1 = l2;
        paramInt1 = paramInt2;
        if (k == 1)
        {
          l1 = l2;
          paramInt1 = paramInt2;
          if (!bool3)
          {
            l1 = l2;
            paramInt1 = paramInt2;
            if (paramString2 != null)
            {
              l1 = l2;
              paramInt1 = paramInt2;
              if (TextUtils.isDigitsOnly(paramString2)) {
                i = paramInt2;
              }
            }
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        label1536:
        label2306:
        for (;;)
        {
          long l2;
          try
          {
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.parseLong(paramString2));
            if (paramString1 == null) {
              break label2329;
            }
            i = paramInt2;
            if (paramString1.b == 10)
            {
              i = paramInt2;
              if (paramString1.a > 0)
              {
                i = paramInt2;
                if (System.currentTimeMillis() > paramString1.jdField_c_of_type_Long + 90000L)
                {
                  i = paramInt2;
                  QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus, 跑马灯超时," + paramString1 + "]");
                  i = paramInt2;
                  paramString1.a = 0;
                  i = paramInt2;
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(14, k, l3, null, 0L);
                }
              }
            }
            i = paramInt2;
            paramInt1 = a(paramString1.f);
            i = paramInt1;
            paramInt2 = paramString1.a;
            l1 = paramInt2;
          }
          catch (NumberFormatException paramString1)
          {
            try
            {
              i = paramString1.b;
              j = 1;
              paramInt2 = paramInt1;
              paramInt1 = j;
              j = paramInt2;
              paramInt2 = i;
              i = paramInt1;
              if ((paramInt2 == 10) || (paramInt2 == 2))
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l3, paramInt2, (int)l1);
                if (paramInt2 == 2)
                {
                  paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l3, paramInt2);
                  paramInt1 = 21;
                  if (paramString1 != null)
                  {
                    if (paramString1.a <= 0) {
                      paramInt1 = 23;
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(2, l3, paramInt2, paramString1.d, paramString1.e, paramString1.jdField_c_of_type_Int, paramInt1, paramString1.a);
                  }
                }
              }
              if (l1 <= 0L) {
                break;
              }
              if (QLog.isDevelopLevel()) {
                QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus, 显示跑马灯, memberNum[" + l1 + "], avtype[" + paramInt2 + "], isChating[" + bool3 + "], step[" + i + "]");
              }
              f();
              localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378474);
              localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368271);
              localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368270);
              if (!bool3) {
                break label989;
              }
              paramString1 = a(paramLong, l3, paramInt2, j, l1, localTextView, localImageView1);
              if ((j != 1) && (j != 2)) {
                break label1007;
              }
              a(3000L);
              paramInt1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167167);
              a(paramString1.b, paramString1.jdField_a_of_type_JavaLangString, paramInt1, String.valueOf(l3), paramInt2);
              localTextView.setTextColor(paramInt1);
              bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((paramInt2 != 2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramString2))) {
                break label1309;
              }
              localImageView2.setImageDrawable(null);
              bcef.b(null, "dc00899", "Grp_video", "", "notice", "exp_aio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "" + TroopUtils.getTroopIdentity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), "", "");
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              if ((localObject != null) && (((Vector)localObject).size() != 0)) {
                break label1017;
              }
              paramString1 = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
              paramInt2 = paramString1.length;
              paramInt1 = 0;
              if (paramInt1 >= paramInt2) {
                break label1086;
              }
              paramString1[paramInt1].setVisibility(8);
              paramInt1 += 1;
              continue;
              paramString1 = paramString1;
              l3 = 0L;
            }
            catch (NumberFormatException paramString1)
            {
              for (;;)
              {
                long l3;
                int k;
                Object localObject;
                boolean bool3;
                TextView localTextView;
                ImageView localImageView1;
                ImageView localImageView2;
                boolean bool2;
                boolean bool1;
                l2 = l1;
                i = paramInt1;
                continue;
                paramString1 = (String)localObject;
              }
            }
            paramString1 = paramString1;
          }
          long l1 = l2;
          paramInt1 = i;
          if (QLog.isColorLevel())
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "refreshMultiVideoStatus error : " + paramString1);
            paramInt1 = i;
            l1 = l2;
          }
          int i = 0;
          paramInt2 = j;
          int j = paramInt1;
          continue;
          label989:
          paramString1 = a(k, l3, paramInt2, l1, localTextView);
          continue;
          label1007:
          a(90000L);
          continue;
          label1017:
          if (((Vector)localObject).size() == 1)
          {
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lmq)((Vector)localObject).get(0)).jdField_a_of_type_Long)));
            if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              break label2295;
            }
            localImageView1.setImageResource(2130839500);
            bool2 = true;
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
            {
              bool1 = bool2;
              if (bool3) {
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g() != 2) {
                  break label2306;
                }
              }
            }
          }
          label1086:
          label1104:
          for (bool1 = true;; bool1 = false)
          {
            a(bool1);
            return;
            if (((Vector)localObject).size() == 2)
            {
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lmq)((Vector)localObject).get(0)).jdField_a_of_type_Long)));
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setImageDrawable(a(String.valueOf(((lmq)((Vector)localObject).get(1)).jdField_a_of_type_Long)));
              break;
            }
            paramInt1 = 0;
            while (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length)
            {
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setImageDrawable(a(String.valueOf(((lmq)((Vector)localObject).get(paramInt1)).jdField_a_of_type_Long)));
              paramInt1 += 1;
            }
            break;
            if (((paramInt2 == 10) || (paramInt2 == 1) || (k == 2)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramString2)))
            {
              if (k != 2) {
                break label2323;
              }
              paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(k, l3);
              if ((paramString1 != null) && (paramString1.size() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equalsIgnoreCase(String.valueOf(((lmq)paramString1.get(0)).jdField_a_of_type_Long))))
              {
                bool1 = true;
                label1405:
                if ((paramString1 != null) && (paramString1.size() != 0) && (!bool1)) {
                  break label1536;
                }
                if (!bool2) {
                  break label1529;
                }
              }
              label1529:
              for (paramInt1 = 2130849771;; paramInt1 = 2130849770)
              {
                localImageView2.setImageResource(paramInt1);
                if (bool1)
                {
                  paramString1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373225);
                  if (paramString1 != null) {
                    paramString1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689920));
                  }
                }
                this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                QLog.w(this.jdField_a_of_type_JavaLangString, 1, "拿不到用户数据，放弃展示 aloneStatus:" + bool1);
                break;
                bool1 = false;
                break label1405;
              }
              localImageView2.setImageBitmap(null);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              amsw localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              localObject = new ArrayList(3);
              paramInt1 = 0;
              if (paramInt1 < paramString1.size())
              {
                if (localamsw.b(String.valueOf(((lmq)paramString1.get(paramInt1)).jdField_a_of_type_Long))) {
                  ((ArrayList)localObject).add(paramString1.get(paramInt1));
                }
                if (((ArrayList)localObject).size() != 3) {}
              }
              else
              {
                localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (((ArrayList)localObject).size() != 0) {
                  break label1920;
                }
                paramLong = ((lmq)paramString1.get(0)).jdField_a_of_type_Long;
                paramString1 = String.valueOf(paramLong);
                if (!localamsw.b(paramString1)) {
                  break label2150;
                }
                if (((ArrayList)localObject).size() != 1) {
                  break label1937;
                }
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lmq)((ArrayList)localObject).get(0)).jdField_a_of_type_Long)));
              }
              for (;;)
              {
                paramInt1 = 2;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
                  paramInt1 = 1;
                }
                paramString2 = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramInt1, 0);
                paramString1 = null;
                if (l1 != 1L) {
                  break label2184;
                }
                paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689924);
                localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373225);
                if (localObject != null)
                {
                  float f = this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131297149);
                  ((TextView)localObject).setText(new StringBuilder(mum.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramString2.toString(), (TextView)localObject, f)).append(paramString1));
                }
                if (localTextView.getVisibility() == 0) {
                  localTextView.setVisibility(8);
                }
                paramString1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371476);
                if (paramString1 == null) {
                  break;
                }
                paramString1.setVisibility(8);
                break;
                paramInt1 += 1;
                break label1585;
                paramLong = ((lmq)((ArrayList)localObject).get(0)).jdField_a_of_type_Long;
                break label1670;
                if (((ArrayList)localObject).size() == 2)
                {
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(0);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lmq)((ArrayList)localObject).get(0)).jdField_a_of_type_Long)));
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setImageDrawable(a(String.valueOf(((lmq)((ArrayList)localObject).get(1)).jdField_a_of_type_Long)));
                }
                else if (((ArrayList)localObject).size() == 3)
                {
                  paramInt1 = 0;
                  while (paramInt1 < this.jdField_b_of_type_ArrayOfAndroidWidgetImageView.length)
                  {
                    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setVisibility(0);
                    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setImageDrawable(a(String.valueOf(((lmq)((ArrayList)localObject).get(paramInt1)).jdField_a_of_type_Long)));
                    paramInt1 += 1;
                  }
                }
                else
                {
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(paramString1));
                }
              }
              label2150:
              if (bool2) {}
              for (paramInt1 = 2130849771;; paramInt1 = 2130849770)
              {
                localImageView2.setImageResource(paramInt1);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
                paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689921);
              }
              for (;;)
              {
                paramString1 = String.format(paramString1, new Object[] { Long.valueOf(l1) });
                break;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
                  paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689883);
                }
              }
            }
            if (bool2) {}
            for (paramInt1 = 2130849771;; paramInt1 = 2130849770)
            {
              localImageView2.setImageResource(paramInt1);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              break;
            }
            label2295:
            localImageView1.setImageResource(2130839501);
            break label1104;
          }
          label1309:
          label1585:
          paramInt1 = 0;
          label1670:
          label1937:
          label2323:
          label2329:
          i = j;
          label2184:
          l1 = l2;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378473);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localTextView.setId(2131371476);
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297383);
      paramString1 = a(this.jdField_a_of_type_AndroidContentContext, paramString1, localTextView, f);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt1);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297158));
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setText(paramString1);
      localLinearLayout.addView(localTextView);
    }
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {}
    try
    {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(Long.valueOf(paramString3).longValue());
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = (String)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c.get(paramString3);
        if (paramString1 == null) {
          break label413;
        }
        i = Integer.valueOf(paramString1.split(";")[0]).intValue();
        paramInt2 = Integer.valueOf(paramString1.split(";")[1]).intValue();
        if (i != 1) {
          break label372;
        }
        if (paramInt2 > 99) {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695143);
        }
      }
      else
      {
        localTextView.setText(paramString1);
        localTextView.setId(2131373225);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          localTextView.setTextColor(Color.parseColor("#A8A8A8"));
        }
        localLinearLayout.addView(localTextView);
        return;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int i;
        paramInt1 = 0;
        continue;
        paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695142), new Object[] { Integer.valueOf(paramInt2) });
        continue;
        label372:
        paramString1 = paramString2;
        if (paramInt1 == 2)
        {
          paramString1 = paramString2.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719034), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719035));
          continue;
          label413:
          paramInt2 = 0;
          i = 0;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))) {}
    for (boolean bool = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).isResume();; bool = false)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_Ahqs != null)) {
        this.jdField_a_of_type_Ahqs.a(this, new Object[0]);
      }
      lzb.a(this.jdField_a_of_type_AndroidViewView, paramBoolean, bool);
      return;
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    a("cancelMeetingInvitedInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 4, 0L);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(true);
    a("doRefreshMultiState", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0, 0L);
  }
  
  void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onClick_multi");
    }
    int k = mum.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    Object localObject = new HashMap();
    lmr locallmr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l);
    int i;
    boolean bool;
    if (locallmr != null)
    {
      i = locallmr.b;
      if ((i == 2) && (locallmr.d == 2) && (locallmr.e == 4))
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(9, l, i);
        ((Map)localObject).put("MultiAVType", String.valueOf(i));
        if (i == 2)
        {
          ((Map)localObject).put("Fromwhere", "SmallScreen");
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
            bcef.b(null, "dc00899", "Grp_video", "", "notice", "Clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "" + TroopUtils.getTroopIdentity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), "2", "");
          }
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(k, l)) {
          break label430;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(String.valueOf(l)) != 14) {
          break label396;
        }
        ((Map)localObject).put("from", "tipBar");
        GroupVideoChatAppInfo.startGroupVideoOrVoice(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, (Map)localObject);
        label307:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(k, l)) {
            break label661;
          }
        }
      }
    }
    label396:
    label661:
    for (localObject = "Cover_back";; localObject = "Clk_discuss_floating")
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", (String)localObject, 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(l);
      bool = false;
      break;
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true, true, null, (Map)localObject);
      break label307;
      label430:
      int m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      int j = 1;
      if (m == 4) {
        j = 2;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onClick_multi, sessionType[" + m + "], enterType[" + j + "]");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_AndroidContentContext, j, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {}
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
          break label629;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(l) != 10) {
          break label631;
        }
        bcef.b(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
        break;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, i, bool, null);
      }
      label629:
      break label307;
      label631:
      bcef.b(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
      break label307;
    }
  }
  
  void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onClick_double");
    }
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().e() == 1) {
      bool = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin) == 1)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
        bool = true;
      }
    }
    for (;;)
    {
      if (bool) {}
      for (int i = 1;; i = 2)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_AndroidContentContext, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
          break label187;
        }
        return;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
        bool = false;
        break;
      }
      label187:
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, null, bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, false, true, null, "from_internal");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1))
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        lmr locallmr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l);
        if (locallmr != null) {}
        for (int i = locallmr.b;; i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(l))
        {
          if (((i != 10) || (bool)) && (a())) {
            break label148;
          }
          d();
          break;
        }
      }
      else
      {
        label148:
        if (!a()) {
          e();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */