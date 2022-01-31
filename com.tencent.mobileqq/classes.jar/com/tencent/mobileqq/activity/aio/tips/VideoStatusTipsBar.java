package com.tencent.mobileqq.activity.aio.tips;

import aenz;
import aeob;
import aeok;
import aeol;
import ajhh;
import ajjj;
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
import awqx;
import azlj;
import azwp;
import babh;
import babr;
import badq;
import baei;
import baen;
import bafb;
import bbmy;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import lcz;
import lda;
import lor;
import mga;
import mjg;
import mqq.os.MqqHandler;

public class VideoStatusTipsBar
  implements aenz, View.OnClickListener
{
  protected float a;
  private aeob jdField_a_of_type_Aeob;
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
  
  public VideoStatusTipsBar(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aeob paramaeob, Context paramContext, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaLangString = ("VideoStatusTipsBar." + paramSessionInfo.jdField_a_of_type_Int + "." + paramSessionInfo.jdField_a_of_type_JavaLangString + "_" + AudioHelper.b());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Aeob = paramaeob;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "VideoStatusTipsBar, curFriendUin[" + paramSessionInfo.jdField_a_of_type_JavaLangString + "], curType[" + paramSessionInfo.jdField_a_of_type_Int + "]");
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    if (!badq.d(paramContext.getApplicationContext())) {
      bbmy.a(paramContext, 2131628882, 0).b(paramContext.getApplicationContext().getResources().getDimensionPixelSize(2131167766));
    }
    while (paramString == null) {
      return;
    }
    boolean bool = paramQQAppInterface.a().a(paramString);
    Object localObject;
    if ((paramInt2 == 2) && (!bool))
    {
      localObject = new HashMap();
      ((Map)localObject).put("MultiAVType", String.valueOf(2));
      ((Map)localObject).put("from", "tipBar");
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramInt1, paramString, (Map)localObject);
      return;
    }
    Intent localIntent = new Intent(paramContext, MultiVideoEnterPageActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    if (paramInt1 == 3000)
    {
      ArrayList localArrayList = ((ajhh)paramQQAppInterface.getManager(53)).a(paramString);
      if (localArrayList == null) {
        break label324;
      }
      int j = localArrayList.size();
      localObject = new long[j];
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i);
        if (localDiscussionMemberInfo != null) {
          localObject[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        i += 1;
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", (long[])localObject);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uinType", paramInt1);
      localIntent.putExtra("Type", 3);
      localIntent.putExtra("GroupId", paramString);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("flag", bool);
      if (1 == paramInt1) {
        localIntent.putExtra("groupInfo", baei.a(paramQQAppInterface, paramString));
      }
      paramContext.startActivity(localIntent);
      return;
      label324:
      localObject = null;
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        mga.e(false, true);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startGroupAudio phone is calling!");
        }
        String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131630319);
        String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131630299);
        babr.a(this.jdField_a_of_type_AndroidContentContext, 230, str2, str1, 2131625035, 2131629116, new aeok(this), null).show();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      baen.a();
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131493011, null);
      this.jdField_a_of_type_AndroidViewView.setId(2131304843);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F), 0, (int)(this.jdField_a_of_type_Float * 2.0F));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label252;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839174);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297424));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297401));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297403));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297405));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297441));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297438));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297439));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131297440));
      return;
      label252:
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#1f1f1f"));
    }
  }
  
  public int a()
  {
    return 61;
  }
  
  public aeol a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, TextView paramTextView)
  {
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    lcz locallcz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1, paramLong1);
    if (locallcz == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624413);
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
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624405);
            localObject2 = localObject3;
          }
        }
        paramTextView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break;
        }
        mjg.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131630163));
        label162:
        paramTextView = new aeol();
        paramTextView.b = ((String)localObject2);
        paramTextView.jdField_a_of_type_JavaLangString = ((String)localObject1);
        return paramTextView;
        localObject1 = localObject4;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624372);
        }
      }
    }
    if (locallcz.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(locallcz.jdField_a_of_type_Long);
      if (localObject1 == null) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624413);
          label273:
          localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
          if ((paramInt2 != 2) || (paramLong2 <= 99L)) {
            break label721;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624405);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label273;
      }
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624372);
      break label273;
      if (paramLong2 == 1L)
      {
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624414);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624412);
        }
        for (;;)
        {
          localObject2 = String.format((String)localObject2, new Object[] { Long.valueOf(paramLong2) });
          if ((paramInt2 != 2) || (paramLong2 <= 99L)) {
            break label718;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624377);
          break;
          localObject2 = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624371);
          }
        }
        localObject2 = Long.toString(locallcz.jdField_a_of_type_Long);
        localObject3 = Long.toString(paramLong1);
        paramInt1 = 2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          paramInt1 = 1;
        }
        localObject3 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, (String)localObject3, paramInt1, 0);
        if (paramLong2 == 1L)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624414);
          localObject2 = localObject3;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624412);
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
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624377);
          localObject2 = localObject3;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624371);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label162;
        }
        mjg.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131630192), paramInt2);
        break label162;
        label718:
        continue;
        label721:
        localObject1 = null;
      }
    }
  }
  
  public aeol a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, TextView paramTextView, ImageView paramImageView)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject2 = Long.toString(paramLong1);
    if ((paramLong1 != 0L) && (!((String)localObject3).equals(Long.valueOf(paramLong1))) && (paramInt1 != 2))
    {
      localObject1 = Long.toString(paramLong2);
      int i = 2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        i = 1;
      }
      localObject3 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, (String)localObject1, i, 0);
      if (paramInt2 == 1) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624416);
        }
      }
    }
    for (;;)
    {
      paramTextView.setVisibility(8);
      label122:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        mjg.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131627331));
      }
      for (;;)
      {
        paramImageView.setVisibility(0);
        paramTextView = new aeol();
        paramTextView.b = ((String)localObject3);
        paramTextView.jdField_a_of_type_JavaLangString = ((String)localObject1);
        return paramTextView;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label478;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624373);
        break;
        if (paramInt2 != 2) {
          break label478;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624417);
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label478;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624374);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f())
        {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624418);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(false);
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
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624409);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(true);
          localObject2 = localObject1;
          if (localObject1 != null) {
            localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong3) });
          }
          paramTextView.setVisibility(0);
          localObject3 = localObject4;
          localObject1 = localObject2;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624404);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          mjg.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131627332), paramInt1);
        }
      }
      label478:
      localObject1 = null;
    }
  }
  
  protected Drawable a(String paramString)
  {
    return azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)4);
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
    a("showMeetinInvitedInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4, 0L);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
    int i;
    if (bool1) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshVideoStatus, uinType[" + paramInt + "], peerUin[" + paramString1 + "], extraUin[" + paramString2 + "], sessionType[" + i + "], isOtherTerminalAvChatting[" + bool1 + "], isVideoChatting[" + bool2 + "], SmallScreenState[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() + "], isReceiver[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() + "], isWaittingState[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f() + "]");
      ImageView localImageView;
      TextView localTextView;
      if (((bool2) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().k()) && ((i == 1) || (i == 2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2)))) || ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)))) {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131493011, null);
          this.jdField_a_of_type_AndroidViewView.setId(2131304843);
          this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float));
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839174);
          this.jdField_a_of_type_AndroidViewView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297424));
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297441));
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302090);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311321);
          label440:
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c() == null) {}
        }
      }
      try
      {
        Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c());
        label507:
        String str;
        if (bool1)
        {
          mjg.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131629991));
          str = "";
          if (!bool1) {
            break label842;
          }
          paramString2 = str;
          if (i == 1) {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131629991);
          }
          if (i != 2) {
            break label990;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131630522);
          label560:
          a(null, paramString2, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101268), paramString1, 0);
          QLog.i(this.jdField_a_of_type_JavaLangString, 1, "refreshVideoStatus info=" + paramString2 + ", peerUin=" + paramString1);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label921;
          }
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839174);
          localImageView.setImageResource(2130839164);
          label655:
          localImageView.setVisibility(0);
          if ((!bool2) || (bool1)) {
            break label948;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() != 2) {
            break label942;
          }
          bool1 = true;
          label688:
          a(bool1);
          label694:
          if ((!bool2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f())) {
            break label956;
          }
          localTextView.setVisibility(0);
        }
        label842:
        do
        {
          return;
          if (!bool2) {
            break label993;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
          break;
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302090);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311321);
          break label440;
          if (!bool2) {
            break label507;
          }
          if (paramInt == 1)
          {
            mjg.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131624710), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b()));
            break label507;
          }
          mjg.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131624710));
          break label507;
          paramString2 = str;
          if (!bool2) {
            break label990;
          }
          if (bool3)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131630563);
            break label560;
          }
          if (i == 1)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131630000);
            break label560;
          }
          paramString2 = str;
          if (i != 2) {
            break label990;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131630537);
          break label560;
          this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14737633);
          localImageView.setImageResource(2130839165);
          break label655;
          bool1 = false;
          break label688;
          a(true);
          break label694;
          localTextView.setVisibility(8);
          return;
        } while (b() != this.jdField_a_of_type_Aeob.a());
        label921:
        label942:
        label948:
        label956:
        this.jdField_a_of_type_Aeob.a();
        return;
      }
      catch (Exception paramString2)
      {
        label990:
        for (;;) {}
        label993:
        i = 0;
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    label559:
    for (;;)
    {
      return;
      long l3 = AudioHelper.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        a("onAIOEvent_1_" + paramInt + "." + l3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
      if (i == 3)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          a("onAIOEvent_2_" + paramInt + "." + l3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
        }
      }
      else {
        for (;;)
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            break label559;
          }
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramVarArgs))
          {
            i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs);
            if (i == 1) {
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
            }
            if (i == 2) {
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
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
            label357:
            Intent localIntent;
            break label357;
          }
          if (l1 == 0L) {
            break;
          }
          l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs);
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "QueryRoomInfo.notify, eventType[" + paramInt + "], roomId[" + l1 + "], peerUin[" + paramVarArgs + "], seq[" + l3 + "]");
          localIntent = new Intent("tencent.video.q2v.sendQueryRoomInfoRequest");
          localIntent.putExtra("roomId", l1);
          localIntent.putExtra("peerUin", Long.parseLong(paramVarArgs));
          localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          localIntent.putExtra("seq", l3);
          this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
          return;
          if ((i == 1) || (i == 2)) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d());
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(false);
      }
      return;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar$RefreshMultiStateRunnable);
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus[" + paramString1 + "], uinType[" + paramInt1 + "], uin[" + paramString2 + "], type[" + paramInt2 + "], memberUin[" + paramLong + "], curType[" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + "]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {}
    for (;;)
    {
      if (b() == this.jdField_a_of_type_Aeob.a()) {
        this.jdField_a_of_type_Aeob.a();
      }
      return;
      try
      {
        l3 = Long.parseLong(paramString2);
        k = mjg.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3);
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l3);
        bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3);
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
        label2176:
        for (;;)
        {
          long l2;
          try
          {
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.parseLong(paramString2));
            if (paramString1 == null) {
              break label2322;
            }
            i = paramInt2;
            if (paramString1.b == 10)
            {
              i = paramInt2;
              if (paramString1.jdField_a_of_type_Int > 0)
              {
                i = paramInt2;
                if (System.currentTimeMillis() > paramString1.jdField_c_of_type_Long + 90000L)
                {
                  i = paramInt2;
                  QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus, 跑马灯超时," + paramString1 + "]");
                  i = paramInt2;
                  paramString1.jdField_a_of_type_Int = 0;
                  i = paramInt2;
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(14, k, l3, null, 0L);
                }
              }
            }
            i = paramInt2;
            paramInt1 = a(paramString1.jdField_c_of_type_Int);
            i = paramInt1;
            paramInt2 = paramString1.jdField_a_of_type_Int;
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
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, paramInt2, (int)l1);
                if (paramInt2 == 2)
                {
                  paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, paramInt2);
                  paramInt1 = 21;
                  if (paramString1 != null)
                  {
                    if (paramString1.jdField_a_of_type_Int <= 0) {
                      paramInt1 = 23;
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, l3, paramInt2, paramInt1, paramString1.jdField_a_of_type_Int);
                  }
                }
              }
              if (l1 <= 0L) {
                break;
              }
              if (QLog.isDevelopLevel()) {
                QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus, 显示跑马灯, memberNum[" + l1 + "], avtype[" + paramInt2 + "], isChating[" + bool3 + "], step[" + i + "]");
              }
              e();
              localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311321);
              localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302090);
              localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302089);
              if (!bool3) {
                break label981;
              }
              paramString1 = a(paramLong, l3, paramInt2, j, l1, localTextView, localImageView1);
              if ((j != 1) && (j != 2)) {
                break label999;
              }
              a(3000L);
              paramInt1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101402);
              a(paramString1.b, paramString1.jdField_a_of_type_JavaLangString, paramInt1, String.valueOf(l3), paramInt2);
              localTextView.setTextColor(paramInt1);
              bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((paramInt2 != 2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2))) {
                break label1301;
              }
              localImageView2.setImageDrawable(null);
              awqx.b(null, "dc00899", "Grp_video", "", "notice", "exp_aio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "");
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              if ((localObject != null) && (((Vector)localObject).size() != 0)) {
                break label1009;
              }
              paramString1 = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
              paramInt2 = paramString1.length;
              paramInt1 = 0;
              if (paramInt1 >= paramInt2) {
                break label1078;
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
          label981:
          paramString1 = a(k, l3, paramInt2, l1, localTextView);
          continue;
          label999:
          a(90000L);
          continue;
          label1009:
          if (((Vector)localObject).size() == 1)
          {
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lcz)((Vector)localObject).get(0)).jdField_a_of_type_Long)));
            if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              break label2288;
            }
            localImageView1.setImageResource(2130839164);
            bool2 = true;
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
            {
              bool1 = bool2;
              if (bool3) {
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() != 2) {
                  break label2299;
                }
              }
            }
          }
          label1078:
          label1096:
          label1397:
          label1528:
          label2299:
          for (bool1 = true;; bool1 = false)
          {
            a(bool1);
            return;
            if (((Vector)localObject).size() == 2)
            {
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lcz)((Vector)localObject).get(0)).jdField_a_of_type_Long)));
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setImageDrawable(a(String.valueOf(((lcz)((Vector)localObject).get(1)).jdField_a_of_type_Long)));
              break;
            }
            paramInt1 = 0;
            while (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length)
            {
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setImageDrawable(a(String.valueOf(((lcz)((Vector)localObject).get(paramInt1)).jdField_a_of_type_Long)));
              paramInt1 += 1;
            }
            break;
            if (((paramInt2 == 10) || (paramInt2 == 1) || (k == 2)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2)))
            {
              if (k != 2) {
                break label2316;
              }
              paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3);
              if ((paramString1 != null) && (paramString1.size() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equalsIgnoreCase(String.valueOf(((lcz)paramString1.get(0)).jdField_a_of_type_Long))))
              {
                bool1 = true;
                if ((paramString1 != null) && (paramString1.size() != 0) && (!bool1)) {
                  break label1528;
                }
                if (!bool2) {
                  break label1521;
                }
              }
              for (paramInt1 = 2130848539;; paramInt1 = 2130848538)
              {
                localImageView2.setImageResource(paramInt1);
                if (bool1)
                {
                  paramString1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306491);
                  if (paramString1 != null) {
                    paramString1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131624411));
                  }
                }
                this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                QLog.w(this.jdField_a_of_type_JavaLangString, 1, "拿不到用户数据，放弃展示 aloneStatus:" + bool1);
                break;
                bool1 = false;
                break label1397;
              }
              localImageView2.setImageBitmap(null);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              ajjj localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              localObject = new ArrayList(3);
              paramInt1 = 0;
              if (paramInt1 < paramString1.size())
              {
                if (localajjj.b(String.valueOf(((lcz)paramString1.get(paramInt1)).jdField_a_of_type_Long))) {
                  ((ArrayList)localObject).add(paramString1.get(paramInt1));
                }
                if (((ArrayList)localObject).size() != 3) {}
              }
              else
              {
                localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (((ArrayList)localObject).size() != 0) {
                  break label1912;
                }
                paramLong = ((lcz)paramString1.get(0)).jdField_a_of_type_Long;
                label1662:
                paramString1 = String.valueOf(paramLong);
                if (!localajjj.b(paramString1)) {
                  break label2142;
                }
                if (((ArrayList)localObject).size() != 1) {
                  break label1929;
                }
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lcz)((ArrayList)localObject).get(0)).jdField_a_of_type_Long)));
              }
              for (;;)
              {
                paramInt1 = 2;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                  paramInt1 = 1;
                }
                paramString2 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramInt1, 0);
                paramString1 = null;
                if (l1 != 1L) {
                  break label2176;
                }
                paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624415);
                localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306491);
                if (localObject != null)
                {
                  float f = this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131165937);
                  ((TextView)localObject).setText(new StringBuilder(mjg.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramString2.toString(), (TextView)localObject, f)).append(paramString1));
                }
                if (localTextView.getVisibility() == 0) {
                  localTextView.setVisibility(8);
                }
                paramString1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304849);
                if (paramString1 == null) {
                  break;
                }
                paramString1.setVisibility(8);
                break;
                paramInt1 += 1;
                break label1577;
                paramLong = ((lcz)((ArrayList)localObject).get(0)).jdField_a_of_type_Long;
                break label1662;
                if (((ArrayList)localObject).size() == 2)
                {
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(0);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lcz)((ArrayList)localObject).get(0)).jdField_a_of_type_Long)));
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setImageDrawable(a(String.valueOf(((lcz)((ArrayList)localObject).get(1)).jdField_a_of_type_Long)));
                }
                else if (((ArrayList)localObject).size() == 3)
                {
                  paramInt1 = 0;
                  while (paramInt1 < this.jdField_b_of_type_ArrayOfAndroidWidgetImageView.length)
                  {
                    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setVisibility(0);
                    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setImageDrawable(a(String.valueOf(((lcz)((ArrayList)localObject).get(paramInt1)).jdField_a_of_type_Long)));
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
              if (bool2) {}
              for (paramInt1 = 2130848539;; paramInt1 = 2130848538)
              {
                localImageView2.setImageResource(paramInt1);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624412);
              }
              for (;;)
              {
                paramString1 = String.format(paramString1, new Object[] { Long.valueOf(l1) });
                break;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                  paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624371);
                }
              }
            }
            if (bool2) {}
            for (paramInt1 = 2130848539;; paramInt1 = 2130848538)
            {
              localImageView2.setImageResource(paramInt1);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              break;
            }
            localImageView1.setImageResource(2130839165);
            break label1096;
          }
          label1301:
          label1521:
          label1912:
          paramInt1 = 0;
          label1577:
          label2142:
          label2288:
          i = j;
          label1929:
          label2316:
          label2322:
          l1 = l2;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131311320);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localTextView.setId(2131304849);
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131166153);
      paramString1 = a(this.jdField_a_of_type_AndroidContentContext, paramString1, localTextView, f);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt1);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165946));
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
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(paramString3).longValue());
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = (String)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c.get(paramString3);
        if (paramString1 == null) {
          break label413;
        }
        i = Integer.valueOf(paramString1.split(";")[0]).intValue();
        paramInt2 = Integer.valueOf(paramString1.split(";")[1]).intValue();
        if (i != 1) {
          break label372;
        }
        if (paramInt2 > 99) {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131630225);
        }
      }
      else
      {
        localTextView.setText(paramString1);
        localTextView.setId(2131306491);
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
        paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131630224), new Object[] { Integer.valueOf(paramInt2) });
        continue;
        label372:
        paramString1 = paramString2;
        if (paramInt1 == 2)
        {
          paramString1 = paramString2.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131654463), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131654464));
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
      if ((paramBoolean) && (this.jdField_a_of_type_Aeob != null)) {
        this.jdField_a_of_type_Aeob.a(this, new Object[0]);
      }
      lor.a(this.jdField_a_of_type_AndroidViewView, paramBoolean, bool);
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
    a("cancelMeetingInvitedInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4, 0L);
  }
  
  void c()
  {
    int j = mjg.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = new HashMap();
    lda locallda = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    int i;
    if (locallda != null)
    {
      i = locallda.b;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(9, l, i);
      ((Map)localObject).put("MultiAVType", String.valueOf(i));
      if (i == 2)
      {
        ((Map)localObject).put("Fromwhere", "SmallScreen");
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          awqx.b(null, "dc00899", "Grp_video", "", "notice", "Clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "2", "");
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, l)) {
        break label380;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(String.valueOf(l)) != 14) {
        break label346;
      }
      ((Map)localObject).put("from", "tipBar");
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (Map)localObject);
      label262:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, l)) {
          break label505;
        }
      }
    }
    label346:
    label505:
    for (localObject = "Cover_back";; localObject = "Clk_discuss_floating")
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", (String)localObject, 0, 0, "", "", "", "");
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l);
      break;
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Map)localObject);
      break label262;
      label380:
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label262;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l) == 10)
      {
        awqx.b(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
        break label262;
      }
      awqx.b(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
      break label262;
    }
  }
  
  void d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e() == 1) {
      bool = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 1)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
        bool = true;
      }
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, null, bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, false, true, null, "from_internal");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
      return;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
          break;
        }
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
        if (paramView != null) {}
        for (int i = paramView.b; ((i == 10) && (!bool)) || (!a()); i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l))
        {
          c();
          return;
        }
      }
    } while (a());
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */