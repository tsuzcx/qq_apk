package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class VideoStatusTipsBar
  implements View.OnClickListener, TipsBarTask
{
  protected float a;
  Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private VideoStatusTipsBar.RefreshMultiStateRunnable jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private ImageView[] jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
  
  public VideoStatusTipsBar(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager, Context paramContext, MqqHandler paramMqqHandler)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoStatusTipsBar.");
    localStringBuilder.append(paramBaseSessionInfo.jdField_a_of_type_Int);
    localStringBuilder.append(".");
    localStringBuilder.append(paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(QQAudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    if (QQAudioHelper.c())
    {
      paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
      paramTipsManager = new StringBuilder();
      paramTipsManager.append("VideoStatusTipsBar, curFriendUin[");
      paramTipsManager.append(paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
      paramTipsManager.append("], curType[");
      paramTipsManager.append(paramBaseSessionInfo.jdField_a_of_type_Int);
      paramTipsManager.append("]");
      QLog.w(paramQQAppInterface, 1, paramTipsManager.toString());
    }
  }
  
  private int a(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt != 20)
    {
      i = j;
      if (paramInt != 21)
      {
        if (paramInt != 23) {
          return 3;
        }
        i = 2;
      }
    }
    return i;
  }
  
  private String a(long paramLong, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject != null) && (((QQAppInterface)localObject).getAVNotifyCenter() != null)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramLong, paramInt);
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131689902);
    }
    if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131689873);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131689898);
  }
  
  private String a(boolean paramBoolean, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject != null) && (((QQAppInterface)localObject).getAVNotifyCenter() != null)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramLong1, paramInt1);
    } else {
      localObject = null;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1)
      {
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689878);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689873);
        }
        return this.jdField_a_of_type_AndroidContentContext.getString(2131689870);
      }
      if ((paramInt1 == 2) && (paramLong2 > 99L))
      {
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689899);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689901);
        }
        return this.jdField_a_of_type_AndroidContentContext.getString(2131689900);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1)
      {
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689878);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689873);
        }
        return this.jdField_a_of_type_AndroidContentContext.getString(2131689869);
      }
      if ((paramInt1 == 2) && (paramLong2 > 99L))
      {
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).a())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689899);
        }
        if ((localObject != null) && (((AVNotifyCenter.VideoRoomInfo)localObject).b())) {
          return this.jdField_a_of_type_AndroidContentContext.getString(2131689901);
        }
        return this.jdField_a_of_type_AndroidContentContext.getString(2131689879);
      }
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    boolean bool1 = NetworkUtil.isNetSupport(paramContext.getApplicationContext());
    int i = 0;
    if (!bool1)
    {
      QQToast.a(paramContext, 2131694395, 0).b(paramContext.getApplicationContext().getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if (paramString1 == null) {
      return;
    }
    boolean bool2 = paramQQAppInterface.getAVNotifyCenter().a(paramString1);
    if ((paramInt2 == 2) && (!bool2))
    {
      paramString2 = new HashMap();
      paramString2.put("MultiAVType", String.valueOf(2));
      paramString2.put("from", "tipBar");
      GroupVideoChatAppInfo.startGroupVideoOrVoice(paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2);
      return;
    }
    if (paramQQAppInterface.getAVNotifyCenter().e() == 4) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramInt1, paramString1, bool1)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, MultiVideoEnterPageActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    if (paramInt1 == 3000)
    {
      long[] arrayOfLong = null;
      ArrayList localArrayList = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString1);
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        arrayOfLong = new long[j];
        while (i < j)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i);
          if (localDiscussionMemberInfo != null) {
            arrayOfLong[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
          }
          i += 1;
        }
      }
      localIntent.putExtra("DiscussUinList", arrayOfLong);
    }
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
      localIntent.putExtra("groupInfo", QAVGroupConfig.a(paramQQAppInterface, paramString1));
    }
    paramContext.startActivity(localIntent);
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()))
    {
      DataReport.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startGroupAudio phone is calling!");
      }
      String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695712);
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131695691);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str2, str1, 2131690728, 2131694583, new VideoStatusTipsBar.1(this), null).show();
      return true;
    }
    return false;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QAVGroupConfig.Report.a();
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131558560, null);
      this.jdField_a_of_type_AndroidViewView.setId(2131371576);
      View localView = this.jdField_a_of_type_AndroidViewView;
      float f = this.jdField_a_of_type_Float;
      localView.setPadding(0, (int)(f * 2.0F), 0, (int)(f * 2.0F));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839468);
      } else {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#1f1f1f"));
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363159));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363137));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363139));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363141));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363330));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363327));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363328));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363329));
    }
  }
  
  public int a()
  {
    return 62;
  }
  
  protected Drawable a(String paramString)
  {
    return FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)4);
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public VideoStatusTipsBar.TextInfo a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramInt1, paramLong1);
    if (localObject == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689908);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
        localObject = a(true, paramLong1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, paramLong2);
      } else {
        localObject = null;
      }
      str1 = String.format((String)localObject, new Object[] { Long.valueOf(paramLong2) });
      localObject = str1;
      if (paramInt2 == 2)
      {
        localObject = str1;
        if (paramLong2 > 99L) {
          localObject = a(true, paramLong1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, paramLong2);
        }
      }
    }
    for (;;)
    {
      str1 = null;
      break label625;
      if (!((AVNotifyCenter.UserInfo)localObject).jdField_a_of_type_Boolean) {
        break label426;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(((AVNotifyCenter.UserInfo)localObject).jdField_a_of_type_Long);
      if (str1 != null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689908);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689870);
      } else {
        localObject = null;
      }
      str1 = String.format((String)localObject, new Object[] { Long.valueOf(paramLong2) });
      localObject = str1;
      if (paramInt2 == 2)
      {
        localObject = str1;
        if (paramLong2 > 99L) {
          localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689900);
        }
      }
    }
    if (paramLong2 == 1L) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689909);
    }
    String str2;
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689907);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689869);
      } else {
        localObject = null;
      }
      str2 = String.format((String)localObject, new Object[] { Long.valueOf(paramLong2) });
      localObject = str2;
      if (paramInt2 == 2)
      {
        localObject = str2;
        if (paramLong2 > 99L) {
          localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689879);
        }
      }
    }
    label426:
    localObject = Long.toString(((AVNotifyCenter.UserInfo)localObject).jdField_a_of_type_Long);
    String str1 = Long.toString(paramLong1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    str1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, str1, paramInt1, 0);
    if (paramLong2 == 1L) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689909);
    }
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131689907);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
        localObject = a(false, paramLong1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, paramLong2);
      } else {
        localObject = null;
      }
      str2 = String.format((String)localObject, new Object[] { Long.valueOf(paramLong2) });
      localObject = str2;
      if (paramInt2 == 2)
      {
        localObject = str2;
        if (paramLong2 > 99L) {
          localObject = a(false, paramLong1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, paramLong2);
        }
      }
    }
    label625:
    paramTextView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
      UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131695541));
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
      UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131695574), paramInt2);
    }
    paramTextView = new VideoStatusTipsBar.TextInfo();
    paramTextView.b = str1;
    paramTextView.jdField_a_of_type_JavaLangString = ((String)localObject);
    return paramTextView;
  }
  
  public VideoStatusTipsBar.TextInfo a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, TextView paramTextView, ImageView paramImageView)
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject1 = Long.toString(paramLong1);
    Object localObject4 = null;
    Object localObject2 = null;
    if ((paramLong1 != 0L) && (!((String)localObject3).equals(Long.valueOf(paramLong1))) && (paramInt1 != 2))
    {
      localObject3 = Long.toString(paramLong2);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
        i = 1;
      } else {
        i = 2;
      }
      localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (String)localObject3, i, 0);
      if (paramInt2 == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689911);
        }
        else
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689871);
          }
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramInt2 == 2) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689912);
          }
          else
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689872);
            }
          }
        }
      }
      paramTextView.setVisibility(8);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f())
    {
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689913);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(false);
      localObject1 = localObject2;
      localObject3 = localObject4;
      if (paramInt1 == 2)
      {
        paramTextView.setVisibility(8);
        localObject1 = localObject2;
        localObject3 = localObject4;
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689905);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
        localObject1 = a(paramLong2, paramInt1);
      } else {
        localObject1 = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(true);
      localObject2 = localObject1;
      if (localObject1 != null) {
        localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong3) });
      }
      paramTextView.setVisibility(0);
      localObject3 = localObject4;
      localObject1 = localObject2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000) {
      UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131692838));
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
      UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131692839), paramInt1);
    }
    paramImageView.setVisibility(0);
    paramTextView = new VideoStatusTipsBar.TextInfo();
    paramTextView.b = ((String)localObject3);
    paramTextView.jdField_a_of_type_JavaLangString = ((String)localObject1);
    return paramTextView;
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
        paramContext = paramString;
        paramFloat = f1;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramFloat = f1;
          paramContext = paramTextView;
          if (f1 == 0.0F)
          {
            paramFloat = f1;
            paramContext = paramTextView;
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
          if (paramContext.length() > 0)
          {
            paramString = new StringBuilder();
            paramString.append(paramContext);
            paramString.append("...");
            paramTextView = paramString.toString();
          }
        }
      }
    }
    return paramTextView;
  }
  
  public void a()
  {
    a("showMeetinInvitedInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, 4, 0L);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(paramString1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g();
    boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f();
    int i;
    if (bool3) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(paramString1);
    } else if (bool2) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().e();
    } else {
      i = 0;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("refreshVideoStatus, uinType[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("], peerUin[");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("], extraUin[");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("], sessionType[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], isOtherTerminalAvChatting[");
    ((StringBuilder)localObject2).append(bool3);
    ((StringBuilder)localObject2).append("], isVideoChatting[");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append("], SmallScreenState[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g());
    ((StringBuilder)localObject2).append("], isReceiver[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g());
    ((StringBuilder)localObject2).append("], isWaittingState[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f());
    ((StringBuilder)localObject2).append("]");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool1 = true;
    QLog.w((String)localObject1, 1, (String)localObject2);
    if (((bool2) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().k()) && ((i == 1) || (i == 2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == paramInt) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2)))) || ((bool3) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1))))
    {
      paramString2 = this.jdField_a_of_type_AndroidViewView;
      if (paramString2 == null)
      {
        this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131558560, null);
        this.jdField_a_of_type_AndroidViewView.setId(2131371576);
        paramString2 = this.jdField_a_of_type_AndroidViewView;
        float f = this.jdField_a_of_type_Float;
        paramString2.setPadding(0, (int)(f * 2.0F), 0, (int)(f * 2.0F));
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839468);
        this.jdField_a_of_type_AndroidViewView.setClickable(true);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363159));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363330));
        localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368376);
        paramString2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378560);
      }
      else
      {
        localObject1 = (ImageView)paramString2.findViewById(2131368376);
        paramString2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378560);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c() == null) {}
    }
    try
    {
      Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c());
    }
    catch (Exception localException)
    {
      label620:
      String str;
      StringBuilder localStringBuilder;
      break label620;
    }
    if (bool3) {
      UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131695362));
    } else if (bool2) {
      if (paramInt == 1) {
        UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131690209), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b()));
      } else {
        UITools.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131690209));
      }
    }
    str = paramString2;
    localObject2 = "";
    if (bool3)
    {
      paramString2 = (String)localObject2;
      if (i == 1) {
        paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695362);
      }
      if (i == 2) {
        paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695939);
      }
    }
    else
    {
      paramString2 = (String)localObject2;
      if (bool2) {
        if (bool4)
        {
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695981);
        }
        else if (i == 1)
        {
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695371);
        }
        else
        {
          paramString2 = (String)localObject2;
          if (i == 2) {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695954);
          }
        }
      }
    }
    a(null, paramString2, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167064), paramString1, 0);
    localObject2 = this.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshVideoStatus info=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", peerUin=");
    localStringBuilder.append(paramString1);
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839468);
      ((ImageView)localObject1).setImageResource(2130839458);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14737633);
      ((ImageView)localObject1).setImageResource(2130839459);
    }
    ((ImageView)localObject1).setVisibility(0);
    if ((bool2) && (!bool3))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g() != 2) {
        bool1 = false;
      }
      a(bool1);
    }
    else
    {
      a(true);
    }
    if ((bool2) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f()))
    {
      str.setVisibility(0);
      return;
    }
    str.setVisibility(8);
    return;
    if (b() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    long l2 = QQAudioHelper.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().e();
      if (i == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
          return;
        }
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("onAIOEvent_2_");
        paramVarArgs.append(paramInt);
        paramVarArgs.append(".");
        paramVarArgs.append(l2);
        a(paramVarArgs.toString(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
      }
      else if ((i == 1) || (i == 2))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().f(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d());
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) || (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label607;
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(paramVarArgs))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(paramVarArgs);
        if (i == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
        }
        if (i == 2) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
        }
      }
      a(0, paramVarArgs, "");
    }
    try
    {
      l1 = Long.parseLong(paramVarArgs);
    }
    catch (Exception localException)
    {
      long l1;
      label351:
      Object localObject;
      StringBuilder localStringBuilder;
      label607:
      break label351;
    }
    l1 = 0L;
    if (l1 != 0L)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramVarArgs);
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QueryRoomInfo.notify, eventType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], roomId[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramVarArgs);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l2);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      localObject = new Intent("tencent.video.q2v.sendQueryRoomInfoRequest");
      ((Intent)localObject).putExtra("roomId", l1);
      ((Intent)localObject).putExtra("peerUin", Long.parseLong(paramVarArgs));
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ((Intent)localObject).putExtra("seq", l2);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
      return;
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("onAIOEvent_1_");
      paramVarArgs.append(paramInt);
      paramVarArgs.append(".");
      paramVarArgs.append(l2);
      a(paramVarArgs.toString(), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
    }
  }
  
  void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable;
    if (localObject == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable = new VideoStatusTipsBar.RefreshMultiStateRunnable(this);
    } else {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks((Runnable)localObject);
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable, paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(false);
    }
  }
  
  /* Error */
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 101	com/tencent/mobileqq/utils/QQAudioHelper:c	()Z
    //   3: ifeq +143 -> 146
    //   6: aload_0
    //   7: getfield 68	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: astore 23
    //   12: new 34	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   19: astore 24
    //   21: aload 24
    //   23: ldc_w 694
    //   26: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 24
    //   32: aload_1
    //   33: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 24
    //   39: ldc_w 696
    //   42: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 24
    //   48: iload_2
    //   49: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 24
    //   55: ldc_w 698
    //   58: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 24
    //   64: aload_3
    //   65: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 24
    //   71: ldc_w 700
    //   74: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 24
    //   80: iload 4
    //   82: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 24
    //   88: ldc_w 702
    //   91: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 24
    //   97: lload 5
    //   99: invokevirtual 63	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 24
    //   105: ldc 105
    //   107: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 24
    //   113: aload_0
    //   114: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   117: getfield 46	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   120: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 24
    //   126: ldc 107
    //   128: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 23
    //   134: iconst_1
    //   135: aload 24
    //   137: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 113	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: goto +3 -> 146
    //   146: aload_0
    //   147: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   150: getfield 46	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   153: sipush 3000
    //   156: if_icmpeq +17 -> 173
    //   159: aload_0
    //   160: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   163: getfield 46	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   166: iconst_1
    //   167: if_icmpeq +6 -> 173
    //   170: goto +485 -> 655
    //   173: aload_3
    //   174: invokestatic 577	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   177: lstore 11
    //   179: goto +6 -> 185
    //   182: lconst_0
    //   183: lstore 11
    //   185: aload_0
    //   186: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   189: getfield 46	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   192: invokestatic 704	com/tencent/av/utils/UITools:b	(I)I
    //   195: istore 9
    //   197: aload_0
    //   198: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   201: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   204: iload 9
    //   206: lload 11
    //   208: invokevirtual 707	com/tencent/av/gaudio/AVNotifyCenter:a	(IJ)J
    //   211: lstore 13
    //   213: aload_0
    //   214: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   217: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   220: lload 11
    //   222: invokevirtual 710	com/tencent/av/gaudio/AVNotifyCenter:a	(J)Ljava/util/Vector;
    //   225: astore 26
    //   227: aload_0
    //   228: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   231: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   234: lload 11
    //   236: invokevirtual 583	com/tencent/av/gaudio/AVNotifyCenter:b	(J)I
    //   239: istore 8
    //   241: aload_0
    //   242: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   245: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   248: iload 9
    //   250: lload 11
    //   252: invokevirtual 713	com/tencent/av/gaudio/AVNotifyCenter:a	(IJ)Z
    //   255: istore 19
    //   257: iload 9
    //   259: iconst_1
    //   260: if_icmpne +282 -> 542
    //   263: iload 19
    //   265: ifne +277 -> 542
    //   268: aload_3
    //   269: ifnull +273 -> 542
    //   272: aload_3
    //   273: invokestatic 719	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   276: ifeq +266 -> 542
    //   279: aload_0
    //   280: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   283: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   286: astore_1
    //   287: aload_1
    //   288: aload_3
    //   289: invokestatic 577	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   292: invokevirtual 722	com/tencent/av/gaudio/AVNotifyCenter:a	(J)Lcom/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo;
    //   295: astore_1
    //   296: aload_1
    //   297: ifnull +173 -> 470
    //   300: aload_1
    //   301: getfield 724	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:b	I
    //   304: bipush 10
    //   306: if_icmpne +2142 -> 2448
    //   309: aload_1
    //   310: getfield 725	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:jdField_a_of_type_Int	I
    //   313: ifle +2135 -> 2448
    //   316: invokestatic 730	java/lang/System:currentTimeMillis	()J
    //   319: lstore 15
    //   321: aload_1
    //   322: getfield 732	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:jdField_c_of_type_Long	J
    //   325: lstore 17
    //   327: lload 15
    //   329: lload 17
    //   331: ldc2_w 733
    //   334: ladd
    //   335: lcmp
    //   336: ifle +2105 -> 2441
    //   339: aload_0
    //   340: getfield 68	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   343: astore 23
    //   345: new 34	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   352: astore 24
    //   354: aload 24
    //   356: ldc_w 736
    //   359: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 24
    //   365: aload_1
    //   366: invokevirtual 739	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 24
    //   372: ldc 107
    //   374: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 23
    //   380: iconst_1
    //   381: aload 24
    //   383: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 113	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: iload 4
    //   391: istore_2
    //   392: aload_1
    //   393: iconst_0
    //   394: putfield 725	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:jdField_a_of_type_Int	I
    //   397: iload 4
    //   399: istore_2
    //   400: aload_0
    //   401: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   404: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   407: bipush 14
    //   409: iload 9
    //   411: lload 11
    //   413: aconst_null
    //   414: lconst_0
    //   415: invokevirtual 742	com/tencent/av/gaudio/AVNotifyCenter:a	(IIJ[JJ)V
    //   418: goto +3 -> 421
    //   421: iload 4
    //   423: istore_2
    //   424: aload_0
    //   425: aload_1
    //   426: getfield 744	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:f	I
    //   429: invokespecial 746	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(I)I
    //   432: istore 4
    //   434: iload 4
    //   436: istore_2
    //   437: aload_1
    //   438: getfield 725	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:jdField_a_of_type_Int	I
    //   441: istore 10
    //   443: iload 10
    //   445: i2l
    //   446: lstore 13
    //   448: aload_1
    //   449: getfield 724	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:b	I
    //   452: istore_2
    //   453: iconst_1
    //   454: istore 8
    //   456: goto +24 -> 480
    //   459: astore_1
    //   460: goto +28 -> 488
    //   463: astore_1
    //   464: iload_2
    //   465: istore 4
    //   467: goto +21 -> 488
    //   470: iconst_0
    //   471: istore 10
    //   473: iload 8
    //   475: istore_2
    //   476: iload 10
    //   478: istore 8
    //   480: goto +68 -> 548
    //   483: astore_1
    //   484: goto +4 -> 488
    //   487: astore_1
    //   488: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +48 -> 539
    //   494: aload_0
    //   495: getfield 68	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   498: astore 23
    //   500: new 34	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   507: astore 24
    //   509: aload 24
    //   511: ldc_w 748
    //   514: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 24
    //   520: aload_1
    //   521: invokevirtual 739	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 23
    //   527: iconst_2
    //   528: aload 24
    //   530: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 750	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: goto +6 -> 542
    //   539: goto +3 -> 542
    //   542: iload 8
    //   544: istore_2
    //   545: iconst_0
    //   546: istore 8
    //   548: iload_2
    //   549: bipush 10
    //   551: if_icmpeq +8 -> 559
    //   554: iload_2
    //   555: iconst_2
    //   556: if_icmpne +92 -> 648
    //   559: aload_0
    //   560: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   563: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   566: lload 11
    //   568: iload_2
    //   569: lload 13
    //   571: l2i
    //   572: invokevirtual 753	com/tencent/av/gaudio/AVNotifyCenter:a	(JII)V
    //   575: iload_2
    //   576: iconst_2
    //   577: if_icmpne +71 -> 648
    //   580: aload_0
    //   581: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   584: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   587: lload 11
    //   589: iload_2
    //   590: invokevirtual 127	com/tencent/av/gaudio/AVNotifyCenter:a	(JI)Lcom/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo;
    //   593: astore_1
    //   594: aload_1
    //   595: ifnull +53 -> 648
    //   598: aload_1
    //   599: getfield 725	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:jdField_a_of_type_Int	I
    //   602: ifgt +10 -> 612
    //   605: bipush 23
    //   607: istore 10
    //   609: goto +7 -> 616
    //   612: bipush 21
    //   614: istore 10
    //   616: aload_0
    //   617: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   620: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   623: iconst_2
    //   624: lload 11
    //   626: iload_2
    //   627: aload_1
    //   628: getfield 755	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:d	I
    //   631: aload_1
    //   632: getfield 757	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:e	I
    //   635: aload_1
    //   636: getfield 759	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:jdField_c_of_type_Int	I
    //   639: iload 10
    //   641: aload_1
    //   642: getfield 725	com/tencent/av/gaudio/AVNotifyCenter$VideoRoomInfo:jdField_a_of_type_Int	I
    //   645: invokevirtual 762	com/tencent/av/gaudio/AVNotifyCenter:a	(IJIIIIII)V
    //   648: lload 13
    //   650: lconst_0
    //   651: lcmp
    //   652: ifgt +25 -> 677
    //   655: aload_0
    //   656: invokevirtual 612	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:b	()I
    //   659: aload_0
    //   660: getfield 74	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager	Lcom/tencent/mobileqq/activity/aio/tips/TipsManager;
    //   663: invokevirtual 616	com/tencent/mobileqq/activity/aio/tips/TipsManager:a	()I
    //   666: if_icmpne +10 -> 676
    //   669: aload_0
    //   670: getfield 74	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager	Lcom/tencent/mobileqq/activity/aio/tips/TipsManager;
    //   673: invokevirtual 617	com/tencent/mobileqq/activity/aio/tips/TipsManager:a	()V
    //   676: return
    //   677: invokestatic 765	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   680: ifeq +105 -> 785
    //   683: aload_0
    //   684: getfield 68	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   687: astore_1
    //   688: new 34	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   695: astore 23
    //   697: aload 23
    //   699: ldc_w 767
    //   702: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 23
    //   708: lload 13
    //   710: invokevirtual 63	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload 23
    //   716: ldc_w 769
    //   719: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 23
    //   725: iload_2
    //   726: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 23
    //   732: ldc_w 771
    //   735: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 23
    //   741: iload 19
    //   743: invokevirtual 555	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 23
    //   749: ldc_w 773
    //   752: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload 23
    //   758: iload 8
    //   760: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload 23
    //   766: ldc 107
    //   768: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload_1
    //   773: iconst_1
    //   774: aload 23
    //   776: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 113	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: goto +3 -> 785
    //   785: iload 19
    //   787: istore 20
    //   789: aload_0
    //   790: invokespecial 775	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:f	()V
    //   793: aload_0
    //   794: getfield 345	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   797: ldc_w 570
    //   800: invokevirtual 407	android/view/View:findViewById	(I)Landroid/view/View;
    //   803: checkcast 465	android/widget/TextView
    //   806: astore 25
    //   808: aload_0
    //   809: getfield 345	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   812: ldc_w 569
    //   815: invokevirtual 407	android/view/View:findViewById	(I)Landroid/view/View;
    //   818: checkcast 28	android/widget/ImageView
    //   821: astore 24
    //   823: aload_0
    //   824: getfield 345	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   827: ldc_w 776
    //   830: invokevirtual 407	android/view/View:findViewById	(I)Landroid/view/View;
    //   833: checkcast 28	android/widget/ImageView
    //   836: astore 27
    //   838: iload 20
    //   840: ifeq +25 -> 865
    //   843: aload_0
    //   844: lload 5
    //   846: lload 11
    //   848: iload_2
    //   849: iload 4
    //   851: lload 13
    //   853: aload 25
    //   855: aload 24
    //   857: invokevirtual 778	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(JJIIJLandroid/widget/TextView;Landroid/widget/ImageView;)Lcom/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar$TextInfo;
    //   860: astore 23
    //   862: goto +18 -> 880
    //   865: aload_0
    //   866: iload 9
    //   868: lload 11
    //   870: iload_2
    //   871: lload 13
    //   873: aload 25
    //   875: invokevirtual 780	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(IJIJLandroid/widget/TextView;)Lcom/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar$TextInfo;
    //   878: astore 23
    //   880: aload 26
    //   882: astore_1
    //   883: aload 27
    //   885: astore 26
    //   887: iconst_0
    //   888: istore 21
    //   890: iload 4
    //   892: iconst_1
    //   893: if_icmpeq +22 -> 915
    //   896: iload 4
    //   898: iconst_2
    //   899: if_icmpne +6 -> 905
    //   902: goto +13 -> 915
    //   905: aload_0
    //   906: ldc2_w 733
    //   909: invokevirtual 782	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(J)V
    //   912: goto +10 -> 922
    //   915: aload_0
    //   916: ldc2_w 783
    //   919: invokevirtual 782	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(J)V
    //   922: aload_0
    //   923: getfield 76	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   926: invokevirtual 84	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   929: ldc_w 785
    //   932: invokevirtual 592	android/content/res/Resources:getColor	(I)I
    //   935: istore 4
    //   937: aload_0
    //   938: aload 23
    //   940: getfield 483	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar$TextInfo:b	Ljava/lang/String;
    //   943: aload 23
    //   945: getfield 484	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar$TextInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   948: iload 4
    //   950: lload 11
    //   952: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   955: iload_2
    //   956: invokevirtual 595	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V
    //   959: aload 25
    //   961: iload 4
    //   963: invokevirtual 790	android/widget/TextView:setTextColor	(I)V
    //   966: aload_0
    //   967: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   970: invokestatic 387	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   973: istore 22
    //   975: iload_2
    //   976: iconst_2
    //   977: if_icmpne +375 -> 1352
    //   980: aload_0
    //   981: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   984: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   987: aload_3
    //   988: invokevirtual 179	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;)Z
    //   991: ifne +361 -> 1352
    //   994: aload 26
    //   996: aconst_null
    //   997: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1000: aload_0
    //   1001: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   1004: getfield 53	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1007: astore_3
    //   1008: new 34	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   1015: astore 23
    //   1017: aload 23
    //   1019: ldc 152
    //   1021: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: aload 23
    //   1027: aload_0
    //   1028: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1031: aload_0
    //   1032: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   1035: getfield 53	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1038: invokestatic 799	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   1041: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aconst_null
    //   1046: ldc_w 801
    //   1049: ldc_w 803
    //   1052: ldc 152
    //   1054: ldc_w 805
    //   1057: ldc_w 807
    //   1060: iconst_0
    //   1061: iconst_0
    //   1062: aload_3
    //   1063: aload 23
    //   1065: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1068: ldc 152
    //   1070: ldc 152
    //   1072: invokestatic 642	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1075: aload_0
    //   1076: getfield 411	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1079: iconst_0
    //   1080: invokevirtual 571	android/widget/LinearLayout:setVisibility	(I)V
    //   1083: aload_1
    //   1084: ifnull +233 -> 1317
    //   1087: aload_1
    //   1088: invokevirtual 810	java/util/Vector:size	()I
    //   1091: ifne +6 -> 1097
    //   1094: goto +223 -> 1317
    //   1097: aload_1
    //   1098: invokevirtual 810	java/util/Vector:size	()I
    //   1101: iconst_1
    //   1102: if_icmpne +65 -> 1167
    //   1105: aload_0
    //   1106: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1109: iconst_0
    //   1110: aaload
    //   1111: iconst_0
    //   1112: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1115: aload_0
    //   1116: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1119: iconst_1
    //   1120: aaload
    //   1121: bipush 8
    //   1123: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1126: aload_0
    //   1127: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1130: iconst_2
    //   1131: aaload
    //   1132: bipush 8
    //   1134: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1137: aload_0
    //   1138: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1141: iconst_0
    //   1142: aaload
    //   1143: aload_0
    //   1144: aload_1
    //   1145: iconst_0
    //   1146: invokevirtual 811	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1149: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1152: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1155: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1158: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1161: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1164: goto +185 -> 1349
    //   1167: aload_1
    //   1168: invokevirtual 810	java/util/Vector:size	()I
    //   1171: iconst_2
    //   1172: if_icmpne +91 -> 1263
    //   1175: aload_0
    //   1176: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1179: iconst_0
    //   1180: aaload
    //   1181: iconst_0
    //   1182: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1185: aload_0
    //   1186: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1189: iconst_1
    //   1190: aaload
    //   1191: iconst_0
    //   1192: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1195: aload_0
    //   1196: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1199: iconst_2
    //   1200: aaload
    //   1201: bipush 8
    //   1203: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1206: aload_0
    //   1207: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1210: iconst_0
    //   1211: aaload
    //   1212: aload_0
    //   1213: aload_1
    //   1214: iconst_0
    //   1215: invokevirtual 811	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1218: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1221: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1224: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1227: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1230: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1233: aload_0
    //   1234: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1237: iconst_1
    //   1238: aaload
    //   1239: aload_0
    //   1240: aload_1
    //   1241: iconst_1
    //   1242: invokevirtual 811	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1245: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1248: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1251: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1254: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1257: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1260: goto +89 -> 1349
    //   1263: iconst_0
    //   1264: istore_2
    //   1265: aload_0
    //   1266: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1269: astore_3
    //   1270: iload_2
    //   1271: aload_3
    //   1272: arraylength
    //   1273: if_icmpge +76 -> 1349
    //   1276: aload_3
    //   1277: iload_2
    //   1278: aaload
    //   1279: iconst_0
    //   1280: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1283: aload_0
    //   1284: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1287: iload_2
    //   1288: aaload
    //   1289: aload_0
    //   1290: aload_1
    //   1291: iload_2
    //   1292: invokevirtual 811	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1295: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1298: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1301: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1304: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1307: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1310: iload_2
    //   1311: iconst_1
    //   1312: iadd
    //   1313: istore_2
    //   1314: goto -49 -> 1265
    //   1317: aload_0
    //   1318: getfield 30	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1321: astore_1
    //   1322: aload_1
    //   1323: arraylength
    //   1324: istore 4
    //   1326: iconst_0
    //   1327: istore_2
    //   1328: iload_2
    //   1329: iload 4
    //   1331: if_icmpge +18 -> 1349
    //   1334: aload_1
    //   1335: iload_2
    //   1336: aaload
    //   1337: bipush 8
    //   1339: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1342: iload_2
    //   1343: iconst_1
    //   1344: iadd
    //   1345: istore_2
    //   1346: goto -18 -> 1328
    //   1349: goto +1012 -> 2361
    //   1352: iload_2
    //   1353: bipush 10
    //   1355: if_icmpeq +17 -> 1372
    //   1358: iload_2
    //   1359: iconst_1
    //   1360: if_icmpeq +12 -> 1372
    //   1363: iload 9
    //   1365: iconst_2
    //   1366: if_icmpne +955 -> 2321
    //   1369: goto +3 -> 1372
    //   1372: aload_0
    //   1373: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1376: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1379: aload_3
    //   1380: invokevirtual 179	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;)Z
    //   1383: ifne +938 -> 2321
    //   1386: iload 9
    //   1388: iconst_2
    //   1389: if_icmpne +21 -> 1410
    //   1392: aload_0
    //   1393: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1396: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1399: iload 9
    //   1401: lload 11
    //   1403: invokevirtual 816	com/tencent/av/gaudio/AVNotifyCenter:a	(IJ)Ljava/util/Vector;
    //   1406: astore_1
    //   1407: goto +3 -> 1410
    //   1410: aload_1
    //   1411: ifnull +44 -> 1455
    //   1414: aload_1
    //   1415: invokevirtual 810	java/util/Vector:size	()I
    //   1418: iconst_1
    //   1419: if_icmpne +36 -> 1455
    //   1422: aload_0
    //   1423: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1426: invokevirtual 819	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1429: aload_1
    //   1430: iconst_0
    //   1431: invokevirtual 811	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1434: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1437: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1440: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1443: invokevirtual 822	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1446: ifeq +9 -> 1455
    //   1449: iconst_1
    //   1450: istore 19
    //   1452: goto +6 -> 1458
    //   1455: iconst_0
    //   1456: istore 19
    //   1458: aload_1
    //   1459: ifnull +745 -> 2204
    //   1462: aload_1
    //   1463: invokevirtual 810	java/util/Vector:size	()I
    //   1466: ifeq +738 -> 2204
    //   1469: iload 19
    //   1471: ifeq +6 -> 1477
    //   1474: goto +730 -> 2204
    //   1477: aload 26
    //   1479: aconst_null
    //   1480: invokevirtual 826	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1483: aload_0
    //   1484: getfield 411	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1487: bipush 8
    //   1489: invokevirtual 571	android/widget/LinearLayout:setVisibility	(I)V
    //   1492: aload_0
    //   1493: getfield 418	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1496: iconst_0
    //   1497: invokevirtual 571	android/widget/LinearLayout:setVisibility	(I)V
    //   1500: aload_0
    //   1501: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1504: getstatic 629	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1507: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1510: checkcast 631	com/tencent/mobileqq/app/FriendsManager
    //   1513: astore 27
    //   1515: new 241	java/util/ArrayList
    //   1518: dup
    //   1519: iconst_3
    //   1520: invokespecial 828	java/util/ArrayList:<init>	(I)V
    //   1523: astore 23
    //   1525: iconst_0
    //   1526: istore_2
    //   1527: iload_2
    //   1528: aload_1
    //   1529: invokevirtual 810	java/util/Vector:size	()I
    //   1532: if_icmpge +55 -> 1587
    //   1535: aload 27
    //   1537: aload_1
    //   1538: iload_2
    //   1539: invokevirtual 811	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1542: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1545: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1548: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1551: invokevirtual 633	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   1554: ifeq +14 -> 1568
    //   1557: aload 23
    //   1559: aload_1
    //   1560: iload_2
    //   1561: invokevirtual 811	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1564: invokevirtual 831	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1567: pop
    //   1568: aload 23
    //   1570: invokevirtual 244	java/util/ArrayList:size	()I
    //   1573: iconst_3
    //   1574: if_icmpne +6 -> 1580
    //   1577: goto +10 -> 1587
    //   1580: iload_2
    //   1581: iconst_1
    //   1582: iadd
    //   1583: istore_2
    //   1584: goto -57 -> 1527
    //   1587: aload_0
    //   1588: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1591: getstatic 629	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   1594: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1597: checkcast 631	com/tencent/mobileqq/app/FriendsManager
    //   1600: astore 27
    //   1602: aload 23
    //   1604: invokevirtual 244	java/util/ArrayList:size	()I
    //   1607: ifne +12 -> 1619
    //   1610: aload_1
    //   1611: iconst_0
    //   1612: invokevirtual 811	java/util/Vector:get	(I)Ljava/lang/Object;
    //   1615: astore_1
    //   1616: goto +10 -> 1626
    //   1619: aload 23
    //   1621: iconst_0
    //   1622: invokevirtual 248	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1625: astore_1
    //   1626: aload_1
    //   1627: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1630: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1633: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1636: astore_1
    //   1637: aload 27
    //   1639: aload_1
    //   1640: invokevirtual 633	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   1643: ifeq +290 -> 1933
    //   1646: aload 23
    //   1648: invokevirtual 244	java/util/ArrayList:size	()I
    //   1651: iconst_1
    //   1652: if_icmpne +66 -> 1718
    //   1655: aload_0
    //   1656: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1659: iconst_0
    //   1660: aaload
    //   1661: iconst_0
    //   1662: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1665: aload_0
    //   1666: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1669: iconst_1
    //   1670: aaload
    //   1671: bipush 8
    //   1673: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1676: aload_0
    //   1677: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1680: iconst_2
    //   1681: aaload
    //   1682: bipush 8
    //   1684: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1687: aload_0
    //   1688: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1691: iconst_0
    //   1692: aaload
    //   1693: aload_0
    //   1694: aload 23
    //   1696: iconst_0
    //   1697: invokevirtual 248	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1700: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1703: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1706: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1709: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1712: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1715: goto +249 -> 1964
    //   1718: aload 23
    //   1720: invokevirtual 244	java/util/ArrayList:size	()I
    //   1723: iconst_2
    //   1724: if_icmpne +93 -> 1817
    //   1727: aload_0
    //   1728: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1731: iconst_0
    //   1732: aaload
    //   1733: iconst_0
    //   1734: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1737: aload_0
    //   1738: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1741: iconst_1
    //   1742: aaload
    //   1743: iconst_0
    //   1744: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1747: aload_0
    //   1748: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1751: iconst_2
    //   1752: aaload
    //   1753: bipush 8
    //   1755: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1758: aload_0
    //   1759: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1762: iconst_0
    //   1763: aaload
    //   1764: aload_0
    //   1765: aload 23
    //   1767: iconst_0
    //   1768: invokevirtual 248	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1771: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1774: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1777: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1780: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1783: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1786: aload_0
    //   1787: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1790: iconst_1
    //   1791: aaload
    //   1792: aload_0
    //   1793: aload 23
    //   1795: iconst_1
    //   1796: invokevirtual 248	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1799: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1802: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1805: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1808: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1811: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1814: goto +150 -> 1964
    //   1817: aload 23
    //   1819: invokevirtual 244	java/util/ArrayList:size	()I
    //   1822: iconst_3
    //   1823: if_icmpne +61 -> 1884
    //   1826: iconst_0
    //   1827: istore_2
    //   1828: aload_0
    //   1829: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1832: astore 26
    //   1834: iload_2
    //   1835: aload 26
    //   1837: arraylength
    //   1838: if_icmpge +126 -> 1964
    //   1841: aload 26
    //   1843: iload_2
    //   1844: aaload
    //   1845: iconst_0
    //   1846: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1849: aload_0
    //   1850: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1853: iload_2
    //   1854: aaload
    //   1855: aload_0
    //   1856: aload 23
    //   1858: iload_2
    //   1859: invokevirtual 248	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1862: checkcast 445	com/tencent/av/gaudio/AVNotifyCenter$UserInfo
    //   1865: getfield 451	com/tencent/av/gaudio/AVNotifyCenter$UserInfo:jdField_a_of_type_Long	J
    //   1868: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1871: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1874: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1877: iload_2
    //   1878: iconst_1
    //   1879: iadd
    //   1880: istore_2
    //   1881: goto -53 -> 1828
    //   1884: aload_0
    //   1885: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1888: iconst_0
    //   1889: aaload
    //   1890: iconst_0
    //   1891: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1894: aload_0
    //   1895: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1898: iconst_1
    //   1899: aaload
    //   1900: bipush 8
    //   1902: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1905: aload_0
    //   1906: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1909: iconst_2
    //   1910: aaload
    //   1911: bipush 8
    //   1913: invokevirtual 507	android/widget/ImageView:setVisibility	(I)V
    //   1916: aload_0
    //   1917: getfield 32	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_ArrayOfAndroidWidgetImageView	[Landroid/widget/ImageView;
    //   1920: iconst_0
    //   1921: aaload
    //   1922: aload_0
    //   1923: aload_1
    //   1924: invokevirtual 813	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1927: invokevirtual 794	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1930: goto +34 -> 1964
    //   1933: iload 22
    //   1935: ifeq +10 -> 1945
    //   1938: ldc_w 832
    //   1941: istore_2
    //   1942: goto +7 -> 1949
    //   1945: ldc_w 833
    //   1948: istore_2
    //   1949: aload 26
    //   1951: iload_2
    //   1952: invokevirtual 606	android/widget/ImageView:setImageResource	(I)V
    //   1955: aload_0
    //   1956: getfield 418	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1959: bipush 8
    //   1961: invokevirtual 571	android/widget/LinearLayout:setVisibility	(I)V
    //   1964: aload_0
    //   1965: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   1968: getfield 46	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   1971: iconst_1
    //   1972: if_icmpne +8 -> 1980
    //   1975: iconst_1
    //   1976: istore_2
    //   1977: goto +5 -> 1982
    //   1980: iconst_2
    //   1981: istore_2
    //   1982: aload_0
    //   1983: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1986: aload_1
    //   1987: aload_3
    //   1988: iload_2
    //   1989: iconst_0
    //   1990: invokestatic 463	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   1993: astore_3
    //   1994: lload 13
    //   1996: lconst_1
    //   1997: lcmp
    //   1998: ifne +17 -> 2015
    //   2001: aload_0
    //   2002: getfield 76	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2005: ldc_w 834
    //   2008: invokevirtual 136	android/content/Context:getString	(I)Ljava/lang/String;
    //   2011: astore_1
    //   2012: goto +73 -> 2085
    //   2015: aload_0
    //   2016: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   2019: getfield 46	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   2022: sipush 3000
    //   2025: if_icmpne +17 -> 2042
    //   2028: aload_0
    //   2029: getfield 76	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2032: ldc_w 456
    //   2035: invokevirtual 136	android/content/Context:getString	(I)Ljava/lang/String;
    //   2038: astore_1
    //   2039: goto +29 -> 2068
    //   2042: aload_0
    //   2043: getfield 72	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   2046: getfield 46	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   2049: iconst_1
    //   2050: if_icmpne +16 -> 2066
    //   2053: aload_0
    //   2054: getfield 76	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2057: ldc 149
    //   2059: invokevirtual 136	android/content/Context:getString	(I)Ljava/lang/String;
    //   2062: astore_1
    //   2063: goto +5 -> 2068
    //   2066: aconst_null
    //   2067: astore_1
    //   2068: aload_1
    //   2069: iconst_1
    //   2070: anewarray 4	java/lang/Object
    //   2073: dup
    //   2074: iconst_0
    //   2075: lload 13
    //   2077: invokestatic 439	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2080: aastore
    //   2081: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2084: astore_1
    //   2085: aload_0
    //   2086: getfield 345	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2089: ldc_w 835
    //   2092: invokevirtual 407	android/view/View:findViewById	(I)Landroid/view/View;
    //   2095: checkcast 465	android/widget/TextView
    //   2098: astore 23
    //   2100: aload 23
    //   2102: ifnull +57 -> 2159
    //   2105: aload_0
    //   2106: getfield 345	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2109: invokevirtual 836	android/view/View:getResources	()Landroid/content/res/Resources;
    //   2112: ldc_w 837
    //   2115: invokevirtual 173	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   2118: i2f
    //   2119: fstore 7
    //   2121: new 34	java/lang/StringBuilder
    //   2124: dup
    //   2125: aload_0
    //   2126: getfield 345	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2129: invokevirtual 840	android/view/View:getContext	()Landroid/content/Context;
    //   2132: aload_3
    //   2133: invokevirtual 841	java/lang/String:toString	()Ljava/lang/String;
    //   2136: aload 23
    //   2138: fload 7
    //   2140: invokestatic 843	com/tencent/av/utils/UITools:a	(Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;F)Ljava/lang/String;
    //   2143: invokespecial 844	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2146: astore_3
    //   2147: aload_3
    //   2148: aload_1
    //   2149: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: pop
    //   2153: aload 23
    //   2155: aload_3
    //   2156: invokevirtual 848	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2159: aload 25
    //   2161: invokevirtual 851	android/widget/TextView:getVisibility	()I
    //   2164: ifne +13 -> 2177
    //   2167: aload 25
    //   2169: bipush 8
    //   2171: invokevirtual 468	android/widget/TextView:setVisibility	(I)V
    //   2174: goto +3 -> 2177
    //   2177: aload_0
    //   2178: getfield 345	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2181: ldc_w 852
    //   2184: invokevirtual 407	android/view/View:findViewById	(I)Landroid/view/View;
    //   2187: checkcast 465	android/widget/TextView
    //   2190: astore_1
    //   2191: aload_1
    //   2192: ifnull -843 -> 1349
    //   2195: aload_1
    //   2196: bipush 8
    //   2198: invokevirtual 468	android/widget/TextView:setVisibility	(I)V
    //   2201: goto -852 -> 1349
    //   2204: iload 22
    //   2206: ifeq +10 -> 2216
    //   2209: ldc_w 832
    //   2212: istore_2
    //   2213: goto +7 -> 2220
    //   2216: ldc_w 833
    //   2219: istore_2
    //   2220: aload 26
    //   2222: iload_2
    //   2223: invokevirtual 606	android/widget/ImageView:setImageResource	(I)V
    //   2226: iload 19
    //   2228: ifeq +35 -> 2263
    //   2231: aload_0
    //   2232: getfield 345	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2235: ldc_w 835
    //   2238: invokevirtual 407	android/view/View:findViewById	(I)Landroid/view/View;
    //   2241: checkcast 465	android/widget/TextView
    //   2244: astore_1
    //   2245: aload_1
    //   2246: ifnull +17 -> 2263
    //   2249: aload_1
    //   2250: aload_0
    //   2251: getfield 76	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2254: ldc_w 853
    //   2257: invokevirtual 136	android/content/Context:getString	(I)Ljava/lang/String;
    //   2260: invokevirtual 848	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2263: aload_0
    //   2264: getfield 411	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2267: bipush 8
    //   2269: invokevirtual 571	android/widget/LinearLayout:setVisibility	(I)V
    //   2272: aload_0
    //   2273: getfield 418	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2276: bipush 8
    //   2278: invokevirtual 571	android/widget/LinearLayout:setVisibility	(I)V
    //   2281: aload_0
    //   2282: getfield 68	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2285: astore_1
    //   2286: new 34	java/lang/StringBuilder
    //   2289: dup
    //   2290: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   2293: astore_3
    //   2294: aload_3
    //   2295: ldc_w 855
    //   2298: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: pop
    //   2302: aload_3
    //   2303: iload 19
    //   2305: invokevirtual 555	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2308: pop
    //   2309: aload_1
    //   2310: iconst_1
    //   2311: aload_3
    //   2312: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2315: invokestatic 113	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2318: goto +43 -> 2361
    //   2321: iload 22
    //   2323: ifeq +10 -> 2333
    //   2326: ldc_w 832
    //   2329: istore_2
    //   2330: goto +7 -> 2337
    //   2333: ldc_w 833
    //   2336: istore_2
    //   2337: aload 26
    //   2339: iload_2
    //   2340: invokevirtual 606	android/widget/ImageView:setImageResource	(I)V
    //   2343: aload_0
    //   2344: getfield 411	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2347: bipush 8
    //   2349: invokevirtual 571	android/widget/LinearLayout:setVisibility	(I)V
    //   2352: aload_0
    //   2353: getfield 418	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2356: bipush 8
    //   2358: invokevirtual 571	android/widget/LinearLayout:setVisibility	(I)V
    //   2361: aload_0
    //   2362: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2365: invokestatic 387	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   2368: ifne +14 -> 2382
    //   2371: aload 24
    //   2373: ldc_w 603
    //   2376: invokevirtual 606	android/widget/ImageView:setImageResource	(I)V
    //   2379: goto +11 -> 2390
    //   2382: aload 24
    //   2384: ldc_w 608
    //   2387: invokevirtual 606	android/widget/ImageView:setImageResource	(I)V
    //   2390: aload_0
    //   2391: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2394: invokevirtual 310	com/tencent/mobileqq/app/QQAppInterface:isVideoChatting	()Z
    //   2397: ifeq +26 -> 2423
    //   2400: iload 20
    //   2402: ifeq +21 -> 2423
    //   2405: iload 21
    //   2407: istore 19
    //   2409: aload_0
    //   2410: getfield 70	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2413: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2416: invokevirtual 561	com/tencent/av/gaudio/AVNotifyCenter:g	()I
    //   2419: iconst_2
    //   2420: if_icmpne +6 -> 2426
    //   2423: iconst_1
    //   2424: istore 19
    //   2426: aload_0
    //   2427: iload 19
    //   2429: invokevirtual 610	com/tencent/mobileqq/activity/aio/tips/VideoStatusTipsBar:a	(Z)V
    //   2432: return
    //   2433: astore_1
    //   2434: goto -2252 -> 182
    //   2437: astore_1
    //   2438: goto -1950 -> 488
    //   2441: goto -2020 -> 421
    //   2444: astore_1
    //   2445: goto -1957 -> 488
    //   2448: goto -2027 -> 421
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2451	0	this	VideoStatusTipsBar
    //   0	2451	1	paramString1	String
    //   0	2451	2	paramInt1	int
    //   0	2451	3	paramString2	String
    //   0	2451	4	paramInt2	int
    //   0	2451	5	paramLong	long
    //   2119	20	7	f	float
    //   239	520	8	i	int
    //   195	1205	9	j	int
    //   441	199	10	k	int
    //   177	1225	11	l1	long
    //   211	1865	13	l2	long
    //   319	9	15	l3	long
    //   325	5	17	l4	long
    //   255	2173	19	bool1	boolean
    //   787	1614	20	bool2	boolean
    //   888	1518	21	bool3	boolean
    //   973	1349	22	bool4	boolean
    //   10	2144	23	localObject1	Object
    //   19	2364	24	localObject2	Object
    //   806	1362	25	localTextView	TextView
    //   225	2113	26	localObject3	Object
    //   836	802	27	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   448	453	459	java/lang/NumberFormatException
    //   392	397	463	java/lang/NumberFormatException
    //   400	418	463	java/lang/NumberFormatException
    //   424	434	463	java/lang/NumberFormatException
    //   437	443	463	java/lang/NumberFormatException
    //   287	296	483	java/lang/NumberFormatException
    //   300	321	483	java/lang/NumberFormatException
    //   279	287	487	java/lang/NumberFormatException
    //   173	179	2433	java/lang/NumberFormatException
    //   339	389	2437	java/lang/NumberFormatException
    //   321	327	2444	java/lang/NumberFormatException
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378559);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localTextView.setId(2131371582);
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297441);
      paramString1 = a(this.jdField_a_of_type_AndroidContentContext, paramString1, localTextView, f);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt1);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297162));
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
    }
    catch (Exception paramString1)
    {
      label202:
      int i;
      break label202;
    }
    paramInt1 = 0;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = (String)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c.get(paramString3);
      if (paramString1 != null)
      {
        paramInt2 = Integer.valueOf(paramString1.split(";")[0]).intValue();
        i = Integer.valueOf(paramString1.split(";")[1]).intValue();
      }
      else
      {
        i = 0;
        paramInt2 = 0;
      }
      if (paramInt2 == 1)
      {
        if (i > 99) {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695610);
        } else {
          paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695609), new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt1 == 2) {
          paramString1 = paramString2.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719735), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719736));
        }
      }
    }
    localTextView.setText(paramString1);
    localTextView.setId(2131373324);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    localLinearLayout.addView(localTextView);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    boolean bool;
    if ((localObject != null) && ((localObject instanceof BaseActivity))) {
      bool = ((BaseActivity)localObject).isResume();
    } else {
      bool = false;
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
      if (localObject != null) {
        ((TipsManager)localObject).a(this, new Object[0]);
      }
    }
    SmallScreenUtils.a(this.jdField_a_of_type_AndroidViewView, paramBoolean, bool);
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
    a("cancelMeetingInvitedInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, 4, 0L);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(true);
    a("doRefreshMultiState", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
  }
  
  void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onClick_multi");
    }
    int k = UITools.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l);
    boolean bool2 = false;
    int j = 2;
    int i;
    boolean bool1;
    if (localObject2 != null)
    {
      i = ((AVNotifyCenter.VideoRoomInfo)localObject2).b;
      bool1 = bool2;
      if (i == 2)
      {
        bool1 = bool2;
        if (((AVNotifyCenter.VideoRoomInfo)localObject2).d == 2)
        {
          bool1 = bool2;
          if (((AVNotifyCenter.VideoRoomInfo)localObject2).e == 4) {
            bool1 = true;
          }
        }
      }
    }
    else
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(l);
      bool1 = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(9, l, i);
    ((Map)localObject1).put("MultiAVType", String.valueOf(i));
    if (i == 2)
    {
      ((Map)localObject1).put("Fromwhere", "SmallScreen");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString));
        ReportController.b(null, "dc00899", "Grp_video", "", "notice", "Clk_video", 0, 0, (String)localObject2, localStringBuilder.toString(), "2", "");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(k, l))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(String.valueOf(l)) == 14)
      {
        ((Map)localObject1).put("from", "tipBar");
        GroupVideoChatAppInfo.startGroupVideoOrVoice(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, (Map)localObject1);
      }
      else
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Map)localObject1);
      }
    }
    else
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      if (m != 4) {
        j = 1;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onClick_multi, sessionType[");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append("], enterType[");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("]");
        QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_AndroidContentContext, j, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, i, bool1, null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(l) == 10) {
          ReportController.b(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 3000)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(k, l)) {
        localObject1 = "Cover_back";
      } else {
        localObject1 = "Clk_discuss_floating";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", (String)localObject1, 0, 0, "", "", "", "");
    }
  }
  
  void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onClick_double");
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().e();
    int i = 1;
    boolean bool;
    if (j == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString) == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
        bool = true;
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
        bool = false;
      }
    }
    if (!bool) {
      i = 2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_AndroidContentContext, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.d, null, bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.b, false, true, null, "from_internal");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131371576) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1))
      {
        if (!a()) {
          e();
        }
      }
      else
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        AVNotifyCenter.VideoRoomInfo localVideoRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l);
        int i;
        if (localVideoRoomInfo != null) {
          i = localVideoRoomInfo.b;
        } else {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b(l);
        }
        if (((i == 10) && (!bool)) || (!a())) {
          d();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */