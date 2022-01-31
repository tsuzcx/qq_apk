package com.tencent.mobileqq.activity.aio.tips;

import aeyt;
import aeyv;
import aeze;
import aezf;
import ajvi;
import ajxl;
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
import axqy;
import banb;
import bayh;
import bbcz;
import bbdj;
import bbfj;
import bbgb;
import bbgg;
import bbgu;
import bcql;
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
import lnl;
import lnm;
import lze;
import mqq.os.MqqHandler;
import mqw;
import muc;

public class VideoStatusTipsBar
  implements aeyt, View.OnClickListener
{
  protected float a;
  private aeyv jdField_a_of_type_Aeyv;
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
  
  public VideoStatusTipsBar(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aeyv paramaeyv, Context paramContext, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaLangString = ("VideoStatusTipsBar." + paramSessionInfo.jdField_a_of_type_Int + "." + paramSessionInfo.jdField_a_of_type_JavaLangString + "_" + AudioHelper.b());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Aeyv = paramaeyv;
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if (!bbfj.d(paramContext.getApplicationContext())) {
      bcql.a(paramContext, 2131694544, 0).b(paramContext.getApplicationContext().getResources().getDimensionPixelSize(2131298865));
    }
    boolean bool2;
    Object localObject;
    Intent localIntent;
    for (;;)
    {
      return;
      if (paramString != null)
      {
        bool2 = paramQQAppInterface.a().a(paramString);
        if ((paramInt2 == 2) && (!bool2))
        {
          localObject = new HashMap();
          ((Map)localObject).put("MultiAVType", String.valueOf(2));
          ((Map)localObject).put("from", "tipBar");
          ChatActivityUtils.a(paramQQAppInterface, paramContext, paramInt1, paramString, (Map)localObject);
          return;
        }
        if (paramQQAppInterface.a().e() == 4) {}
        for (boolean bool1 = true; !paramQQAppInterface.a().a(paramContext, paramInt1, paramString, bool1); bool1 = false)
        {
          localIntent = new Intent(paramContext, MultiVideoEnterPageActivity.class);
          localIntent.addFlags(262144);
          localIntent.addFlags(268435456);
          if (paramInt1 != 3000) {
            break label269;
          }
          ArrayList localArrayList = ((ajvi)paramQQAppInterface.getManager(53)).a(paramString);
          if (localArrayList == null) {
            break label370;
          }
          int j = localArrayList.size();
          localObject = new long[j];
          int i = 0;
          while (i < j)
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i);
            if (localDiscussionMemberInfo != null) {
              localObject[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
            }
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", (long[])localObject);
      label269:
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uinType", paramInt1);
      localIntent.putExtra("Type", 3);
      localIntent.putExtra("GroupId", paramString);
      localIntent.putExtra("openClass", paramBoolean);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("flag", bool2);
      if (1 == paramInt1) {
        localIntent.putExtra("groupInfo", bbgb.a(paramQQAppInterface, paramString));
      }
      paramContext.startActivity(localIntent);
      return;
      label370:
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
        mqw.e(false, true);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startGroupAudio phone is calling!");
        }
        String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696015);
        String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131695995);
        bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str2, str1, 2131690596, 2131694794, new aeze(this), null).show();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      bbgg.a();
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131558563, null);
      this.jdField_a_of_type_AndroidViewView.setId(2131370508);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F), 0, (int)(this.jdField_a_of_type_Float * 2.0F));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label252;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839199);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362963));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362940));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362942));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362944));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362980));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131362977));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131362978));
      this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131362979));
      return;
      label252:
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#1f1f1f"));
    }
  }
  
  public int a()
  {
    return 61;
  }
  
  public aezf a(int paramInt1, long paramLong1, int paramInt2, boolean paramBoolean, long paramLong2, TextView paramTextView)
  {
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    lnl locallnl = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt1, paramLong1);
    if (locallnl == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689963);
        str = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
        localObject1 = str;
        localObject2 = localObject3;
        if (paramInt2 == 2)
        {
          localObject1 = str;
          localObject2 = localObject3;
          if (paramLong2 > 99L)
          {
            if (!paramBoolean) {
              break label243;
            }
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689953);
          }
        }
      }
      for (localObject2 = localObject3;; localObject2 = localObject3)
      {
        paramTextView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break label773;
        }
        muc.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131695851));
        label167:
        paramTextView = new aezf();
        paramTextView.b = ((String)localObject2);
        paramTextView.jdField_a_of_type_JavaLangString = ((String)localObject1);
        return paramTextView;
        localObject1 = localObject4;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
        if (paramBoolean)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689924);
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689919);
        break;
        label243:
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689954);
      }
    }
    if (locallnl.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(locallnl.jdField_a_of_type_Long);
      if (localObject1 == null) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689963);
          label317:
          localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong2) });
          if ((paramInt2 != 2) || (paramLong2 <= 99L)) {
            break label809;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689954);
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
        break label317;
      }
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689919);
      break label317;
      if (paramLong2 == 1L)
      {
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689964);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689962);
        }
        for (;;)
        {
          localObject2 = String.format((String)localObject2, new Object[] { Long.valueOf(paramLong2) });
          if ((paramInt2 != 2) || (paramLong2 <= 99L)) {
            break label806;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689925);
          break;
          localObject2 = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689918);
          }
        }
        localObject2 = Long.toString(locallnl.jdField_a_of_type_Long);
        localObject3 = Long.toString(paramLong1);
        paramInt1 = 2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          paramInt1 = 1;
        }
        localObject3 = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, (String)localObject3, paramInt1, 0);
        if (paramLong2 == 1L)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689964);
          localObject2 = localObject3;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689962);
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
          if (!paramBoolean) {
            break label754;
          }
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689953);
          localObject2 = localObject3;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            if (paramBoolean) {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689924);
            } else {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689918);
            }
          }
        }
        label754:
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689925);
        localObject2 = localObject3;
        break;
        label773:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label167;
        }
        muc.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131695884), paramInt2);
        break label167;
        label806:
        continue;
        label809:
        localObject1 = null;
      }
    }
  }
  
  public aezf a(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong3, TextView paramTextView, ImageView paramImageView)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject1 = Long.toString(paramLong1);
    if ((paramLong1 != 0L) && (!((String)localObject2).equals(Long.valueOf(paramLong1))) && (paramInt1 != 2))
    {
      localObject2 = Long.toString(paramLong2);
      int i = 2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        i = 1;
      }
      localObject2 = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (String)localObject2, i, 0);
      if (paramInt2 == 1) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689966);
        }
      }
    }
    for (;;)
    {
      paramTextView.setVisibility(8);
      paramTextView = (TextView)localObject2;
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
        {
          muc.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131692970));
          label150:
          paramImageView.setVisibility(0);
          paramImageView = new aezf();
          paramImageView.b = paramTextView;
          paramImageView.jdField_a_of_type_JavaLangString = ((String)localObject1);
          return paramImageView;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label492;
          }
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689920);
          break;
          if (paramInt2 != 2) {
            break label492;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689967);
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label492;
          }
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689921);
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f())
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689968);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(false);
            localObject2 = localObject1;
            if (paramInt1 == 2)
            {
              paramTextView.setVisibility(8);
              paramTextView = null;
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
              break label407;
            }
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689959);
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(true);
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = String.format((String)localObject1, new Object[] { Long.valueOf(paramLong3) });
        }
        paramTextView.setVisibility(0);
        localObject1 = localObject2;
        paramTextView = null;
        break;
        label407:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          if (paramBoolean)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689956);
            continue;
          }
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689952);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break label150;
          }
          muc.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131692971), paramInt1);
          break label150;
        }
        localObject1 = null;
      }
      label492:
      localObject1 = null;
    }
  }
  
  protected Drawable a(String paramString)
  {
    return bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)4);
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
          this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131558563, null);
          this.jdField_a_of_type_AndroidViewView.setId(2131370508);
          this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float));
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839199);
          this.jdField_a_of_type_AndroidViewView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362963));
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362980));
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367708);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377135);
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
          muc.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131695673));
          str = "";
          if (!bool1) {
            break label842;
          }
          paramString2 = str;
          if (i == 1) {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695673);
          }
          if (i != 2) {
            break label990;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696226);
          label560:
          a(null, paramString2, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166862), paramString1, 0);
          QLog.i(this.jdField_a_of_type_JavaLangString, 1, "refreshVideoStatus info=" + paramString2 + ", peerUin=" + paramString1);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label921;
          }
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839199);
          localImageView.setImageResource(2130839189);
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
          localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367708);
          localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377135);
          break label440;
          if (!bool2) {
            break label507;
          }
          if (paramInt == 1)
          {
            muc.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131690271), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b()));
            break label507;
          }
          muc.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext.getString(2131690271));
          break label507;
          paramString2 = str;
          if (!bool2) {
            break label990;
          }
          if (bool3)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696267);
            break label560;
          }
          if (i == 1)
          {
            paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695682);
            break label560;
          }
          paramString2 = str;
          if (i != 2) {
            break label990;
          }
          paramString2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696241);
          break label560;
          this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14737633);
          localImageView.setImageResource(2130839190);
          break label655;
          bool1 = false;
          break label688;
          a(true);
          break label694;
          localTextView.setVisibility(8);
          return;
        } while (b() != this.jdField_a_of_type_Aeyv.a());
        label921:
        label942:
        label948:
        label956:
        this.jdField_a_of_type_Aeyv.a();
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
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            break label559;
          }
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramVarArgs))
          {
            i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs);
            if (i == 1) {
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
            }
            if (i == 2) {
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
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
      if (b() == this.jdField_a_of_type_Aeyv.a()) {
        this.jdField_a_of_type_Aeyv.a();
      }
      return;
      try
      {
        l3 = Long.parseLong(paramString2);
        k = muc.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3);
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l3);
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
              if (TextUtils.isDigitsOnly(paramString2))
              {
                paramInt1 = paramInt2;
                try
                {
                  paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.parseLong(paramString2));
                  if (paramString1 == null) {
                    break label2361;
                  }
                  paramInt1 = paramInt2;
                  if (paramString1.b == 10)
                  {
                    paramInt1 = paramInt2;
                    if (paramString1.jdField_a_of_type_Int > 0)
                    {
                      paramInt1 = paramInt2;
                      if (System.currentTimeMillis() > paramString1.jdField_c_of_type_Long + 90000L)
                      {
                        paramInt1 = paramInt2;
                        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus, 跑马灯超时," + paramString1 + "]");
                        paramInt1 = paramInt2;
                        paramString1.jdField_a_of_type_Int = 0;
                        paramInt1 = paramInt2;
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(14, k, l3, null, 0L);
                      }
                    }
                  }
                  paramInt1 = paramInt2;
                  paramInt2 = a(paramString1.e);
                  paramInt1 = paramInt2;
                  j = paramString1.jdField_a_of_type_Int;
                  l1 = j;
                }
                catch (NumberFormatException paramString1)
                {
                  label570:
                  paramInt2 = paramInt1;
                }
              }
            }
          }
        }
        try
        {
          paramInt1 = paramString1.b;
          j = 1;
          i = paramInt1;
          paramInt1 = j;
          j = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = i;
          i = j;
          if ((paramInt2 != 10) && (paramInt2 != 2)) {
            break label2355;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, paramInt2, (int)l1);
          if (paramInt2 != 2) {
            break label2355;
          }
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, paramInt2);
          j = 21;
          if (paramString1 == null) {
            break label2355;
          }
          if ((paramString1.jdField_c_of_type_Int != 2) || (paramString1.d != 4)) {
            break label1009;
          }
          bool1 = true;
          if (paramString1.jdField_a_of_type_Int <= 0) {
            j = 23;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, l3, paramInt2, paramString1.jdField_c_of_type_Int, paramString1.d, j, paramString1.jdField_a_of_type_Int);
        }
        catch (NumberFormatException paramString1)
        {
          for (;;)
          {
            ajxl localajxl;
            float f;
            l2 = l1;
            continue;
            paramString1 = (String)localObject;
          }
          bool1 = false;
          break label570;
        }
        if (l1 <= 0L) {
          continue;
        }
        if (QLog.isDevelopLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshMultiVideoStatus, 显示跑马灯, memberNum[" + l1 + "], avtype[" + paramInt2 + "], isChating[" + bool3 + "], step[" + i + "]");
        }
        f();
        localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377135);
        localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367708);
        localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367707);
        if (bool3)
        {
          paramString1 = a(paramLong, l3, paramInt2, bool1, paramInt1, l1, localTextView, localImageView1);
          if ((paramInt1 != 1) && (paramInt1 != 2)) {
            break label1035;
          }
          a(3000L);
          paramInt1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166997);
          a(paramString1.b, paramString1.jdField_a_of_type_JavaLangString, paramInt1, String.valueOf(l3), paramInt2);
          localTextView.setTextColor(paramInt1);
          bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if ((paramInt2 != 2) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2))) {
            break label1337;
          }
          localImageView2.setImageDrawable(null);
          axqy.b(null, "dc00899", "Grp_video", "", "notice", "exp_aio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "");
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localObject != null) && (((Vector)localObject).size() != 0)) {
            break label1045;
          }
          paramString1 = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
          paramInt2 = paramString1.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramString1[paramInt1].setVisibility(8);
            paramInt1 += 1;
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        for (;;)
        {
          int k;
          long l2;
          Object localObject;
          boolean bool3;
          TextView localTextView;
          ImageView localImageView1;
          ImageView localImageView2;
          boolean bool2;
          long l3 = 0L;
          continue;
          long l1 = l2;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "refreshMultiVideoStatus error : " + paramString1);
            paramInt1 = paramInt2;
            l1 = l2;
          }
          int j = 0;
          paramInt2 = i;
          int i = j;
          continue;
          label1009:
          boolean bool1 = false;
          continue;
          paramString1 = a(k, l3, paramInt2, bool1, l1, localTextView);
          continue;
          label1035:
          a(90000L);
          continue;
          label1045:
          if (((Vector)localObject).size() == 1)
          {
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
            this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lnl)((Vector)localObject).get(0)).jdField_a_of_type_Long)));
            if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              break label2324;
            }
            localImageView1.setImageResource(2130839189);
            label1132:
            bool2 = true;
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
            {
              bool1 = bool2;
              if (bool3) {
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() != 2) {
                  break label2335;
                }
              }
            }
          }
          label1433:
          label1564:
          label2335:
          for (bool1 = true;; bool1 = false)
          {
            a(bool1);
            return;
            if (((Vector)localObject).size() == 2)
            {
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lnl)((Vector)localObject).get(0)).jdField_a_of_type_Long)));
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setImageDrawable(a(String.valueOf(((lnl)((Vector)localObject).get(1)).jdField_a_of_type_Long)));
              break;
            }
            paramInt1 = 0;
            while (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length)
            {
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setVisibility(0);
              this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setImageDrawable(a(String.valueOf(((lnl)((Vector)localObject).get(paramInt1)).jdField_a_of_type_Long)));
              paramInt1 += 1;
            }
            break;
            label1337:
            if (((paramInt2 == 10) || (paramInt2 == 1) || (k == 2)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2)))
            {
              if (k != 2) {
                break label2349;
              }
              paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(k, l3);
              if ((paramString1 != null) && (paramString1.size() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equalsIgnoreCase(String.valueOf(((lnl)paramString1.get(0)).jdField_a_of_type_Long))))
              {
                bool1 = true;
                if ((paramString1 != null) && (paramString1.size() != 0) && (!bool1)) {
                  break label1564;
                }
                if (!bool2) {
                  break label1557;
                }
              }
              for (paramInt1 = 2130848788;; paramInt1 = 2130848787)
              {
                localImageView2.setImageResource(paramInt1);
                if (bool1)
                {
                  paramString1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372190);
                  if (paramString1 != null) {
                    paramString1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689961));
                  }
                }
                this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                QLog.w(this.jdField_a_of_type_JavaLangString, 1, "拿不到用户数据，放弃展示 aloneStatus:" + bool1);
                break;
                bool1 = false;
                break label1433;
              }
              localImageView2.setImageBitmap(null);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              localajxl = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              localObject = new ArrayList(3);
              paramInt1 = 0;
              label1613:
              if (paramInt1 < paramString1.size())
              {
                if (localajxl.b(String.valueOf(((lnl)paramString1.get(paramInt1)).jdField_a_of_type_Long))) {
                  ((ArrayList)localObject).add(paramString1.get(paramInt1));
                }
                if (((ArrayList)localObject).size() != 3) {}
              }
              else
              {
                localajxl = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (((ArrayList)localObject).size() != 0) {
                  break label1948;
                }
                paramLong = ((lnl)paramString1.get(0)).jdField_a_of_type_Long;
                paramString1 = String.valueOf(paramLong);
                if (!localajxl.b(paramString1)) {
                  break label2178;
                }
                if (((ArrayList)localObject).size() != 1) {
                  break label1965;
                }
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(8);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lnl)((ArrayList)localObject).get(0)).jdField_a_of_type_Long)));
              }
              for (;;)
              {
                paramInt1 = 2;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                  paramInt1 = 1;
                }
                paramString2 = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramInt1, 0);
                paramString1 = null;
                if (l1 != 1L) {
                  break label2212;
                }
                paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689965);
                localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372190);
                if (localObject != null)
                {
                  f = this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131297012);
                  ((TextView)localObject).setText(new StringBuilder(muc.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramString2.toString(), (TextView)localObject, f)).append(paramString1));
                }
                if (localTextView.getVisibility() == 0) {
                  localTextView.setVisibility(8);
                }
                paramString1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370514);
                if (paramString1 == null) {
                  break;
                }
                paramString1.setVisibility(8);
                break;
                paramInt1 += 1;
                break label1613;
                paramLong = ((lnl)((ArrayList)localObject).get(0)).jdField_a_of_type_Long;
                break label1698;
                if (((ArrayList)localObject).size() == 2)
                {
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setVisibility(0);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setVisibility(0);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[2].setVisibility(8);
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[0].setImageDrawable(a(String.valueOf(((lnl)((ArrayList)localObject).get(0)).jdField_a_of_type_Long)));
                  this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[1].setImageDrawable(a(String.valueOf(((lnl)((ArrayList)localObject).get(1)).jdField_a_of_type_Long)));
                }
                else if (((ArrayList)localObject).size() == 3)
                {
                  paramInt1 = 0;
                  while (paramInt1 < this.jdField_b_of_type_ArrayOfAndroidWidgetImageView.length)
                  {
                    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setVisibility(0);
                    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView[paramInt1].setImageDrawable(a(String.valueOf(((lnl)((ArrayList)localObject).get(paramInt1)).jdField_a_of_type_Long)));
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
              for (paramInt1 = 2130848788;; paramInt1 = 2130848787)
              {
                localImageView2.setImageResource(paramInt1);
                this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
                paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689962);
              }
              for (;;)
              {
                paramString1 = String.format(paramString1, new Object[] { Long.valueOf(l1) });
                break;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                  paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689918);
                }
              }
            }
            label1698:
            label1965:
            if (bool2) {}
            label2212:
            for (paramInt1 = 2130848788;; paramInt1 = 2130848787)
            {
              localImageView2.setImageResource(paramInt1);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              break;
            }
            localImageView1.setImageResource(2130839190);
            break label1132;
          }
          label1557:
          label1948:
          label2349:
          label2355:
          label2361:
          paramInt1 = 0;
          label2178:
          label2324:
          l1 = l2;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377134);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localTextView.setId(2131370514);
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297234);
      paramString1 = a(this.jdField_a_of_type_AndroidContentContext, paramString1, localTextView, f);
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt1);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297021));
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
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695919);
        }
      }
      else
      {
        localTextView.setText(paramString1);
        localTextView.setId(2131372190);
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
        paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695918), new Object[] { Integer.valueOf(paramInt2) });
        continue;
        label372:
        paramString1 = paramString2;
        if (paramInt1 == 2)
        {
          paramString1 = paramString2.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720369), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720370));
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
      if ((paramBoolean) && (this.jdField_a_of_type_Aeyv != null)) {
        this.jdField_a_of_type_Aeyv.a(this, new Object[0]);
      }
      lze.a(this.jdField_a_of_type_AndroidViewView, paramBoolean, bool);
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
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(true);
    a("doRefreshMultiState", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
  }
  
  void d()
  {
    int j = muc.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = new HashMap();
    lnm locallnm = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    int i;
    boolean bool;
    if (locallnm != null)
    {
      i = locallnm.b;
      if ((i == 2) && (locallnm.jdField_c_of_type_Int == 2) && (locallnm.d == 4))
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(9, l, i);
        ((Map)localObject).put("MultiAVType", String.valueOf(i));
        if (i == 2)
        {
          ((Map)localObject).put("Fromwhere", "SmallScreen");
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            axqy.b(null, "dc00899", "Grp_video", "", "notice", "Clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "2", "");
          }
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, l)) {
          break label415;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(String.valueOf(l)) != 14) {
          break label381;
        }
        ((Map)localObject).put("from", "tipBar");
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (Map)localObject);
        label288:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, l)) {
            break label542;
          }
        }
      }
    }
    label542:
    for (localObject = "Cover_back";; localObject = "Clk_discuss_floating")
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", (String)localObject, 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l);
      bool = false;
      break;
      label381:
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Map)localObject);
      break label288;
      label415:
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label288;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l) == 10)
      {
        axqy.b(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
        break label288;
      }
      axqy.b(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
      break label288;
    }
  }
  
  void e()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e() == 1) {
      bool = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 1)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
        bool = true;
      }
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, null, bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, false, true, null, "from_internal");
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
      return;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
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
          d();
          return;
        }
      }
    } while (a());
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */