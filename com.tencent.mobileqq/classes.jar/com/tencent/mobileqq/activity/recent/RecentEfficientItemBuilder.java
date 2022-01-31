package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class RecentEfficientItemBuilder
  extends RecentItemBaseBuilder
{
  private List a;
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    Object localObject1;
    label79:
    Object localObject2;
    if ((paramView != null) && ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)))
    {
      paramOnDragModeChangedListener = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramOnDragModeChangedListener;
      localObject1 = paramContext.getResources();
      paramOnDragModeChangedListener = ((Resources)localObject1).getColorStateList(2131494260);
      localObject1 = ((Resources)localObject1).getColorStateList(2131494261);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label644;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.b) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label658;
      }
      localObject2 = (RecentBaseData)paramObject;
      localObject1 = ((RecentBaseData)localObject2).a();
      paramOnDragModeChangedListener = null;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a((RecentBaseData)localObject2);
      }
      a(paramViewGroup, (RecentBaseData)localObject2, paramContext, paramOnDragModeChangedListener);
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.b) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format("点击进入%1$s资料卡页面", new Object[] { ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangString }));
        }
      }
    }
    for (paramRecentFaceDecoder = (RecentFaceDecoder)localObject1;; paramRecentFaceDecoder = "")
    {
      if ((PublicAccountConfigUtil.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramRecentFaceDecoder)) {
        QZoneReport.a(1);
      }
      return paramViewGroup;
      paramOnDragModeChangedListener = new RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder();
      localObject1 = a(paramContext, 2130971438, paramOnDragModeChangedListener);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject1).findViewById(2131362701));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131363189));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131363360));
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131374720));
      paramOnDragModeChangedListener.b = ((SingleLineTextView)((View)localObject1).findViewById(2131365632));
      paramOnDragModeChangedListener.b.setGravity(16);
      localObject2 = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramView = ((Resources)localObject2).getColorStateList(2131494260);
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131494212);
      localObject2 = ((Resources)localObject2).getColorStateList(2131494261);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      }
      for (;;)
      {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramOnDragModeChangedListener.b.setTextColor(paramView);
        paramOnDragModeChangedListener.b.setExtendTextPadding((int)(f * 2.0F), 1);
        paramOnDragModeChangedListener.b.setExtendTextSize(14.0F, 1);
        ((View)localObject1).setTag(paramOnDragModeChangedListener);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = paramOnDragModeChangedListener;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
          break;
        }
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
        paramViewGroup = (ViewGroup)localObject1;
        paramView = paramOnDragModeChangedListener;
        break;
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label644:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramOnDragModeChangedListener, 0);
      break label79;
      label658:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.b.setText("");
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int k = paramRecentBaseData.f;
    paramContext = paramContext.getResources();
    int m;
    int i;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      m = k & 0xF0;
      int j = 2;
      i = 3;
      if ((paramRecentBaseData.a() == 3000) || (paramRecentBaseData.a() == 1))
      {
        j = 8;
        i = 7;
      }
      if (m != 32) {
        break label149;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[j]));
    }
    for (;;)
    {
      if ((k & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label149:
      if (m == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[i]));
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)) {}
    for (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder localRecentEfficientItemBuilderHolder = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();; localRecentEfficientItemBuilderHolder = null)
    {
      if (localRecentEfficientItemBuilderHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      QQAppInterface localQQAppInterface;
      int j;
      int i;
      RecentDynamicAvatarView localRecentDynamicAvatarView;
      String str;
      boolean bool1;
      if (a(paramRecentBaseData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("RecentDefaultItemBuilder", 2, "bindview user:" + paramRecentBaseData.a());
        }
        localQQAppInterface = ((BaseActivity)paramContext).app;
        j = ((Integer)RecentFaceDecoder.a(localQQAppInterface, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        localRecentDynamicAvatarView = localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        str = paramRecentBaseData.a();
        if (localQQAppInterface.a.a() == 1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool1, 0);
        label224:
        paramDrawable = null;
        if (paramRecentBaseData.jdField_d_of_type_Int != 0) {
          paramDrawable = paramContext.getResources().getDrawable(paramRecentBaseData.jdField_d_of_type_Int);
        }
        localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(null, paramDrawable);
        if (localRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).j == 1))
          {
            localRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(QIMUserManager.a().b(3));
            localRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        paramContext = paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        label334:
        boolean bool2;
        boolean bool3;
        boolean bool4;
        label508:
        int m;
        label512:
        label537:
        label562:
        int k;
        label643:
        label676:
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramContext, 2);
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.jdField_c_of_type_JavaLangString, 0);
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.jdField_b_of_type_JavaLangString);
          if (!TextUtils.isEmpty(paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence)) {
            localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence);
          }
          if ((paramRecentBaseData.a() != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData))) {
            break label1087;
          }
          long l1 = ((RecentItemChatMsgData)paramRecentBaseData).b;
          long l2 = ((RecentItemChatMsgData)paramRecentBaseData).jdField_c_of_type_Long;
          long l3 = ((RecentItemChatMsgData)paramRecentBaseData).d;
          bool1 = HotReactiveHelper.a(HotReactiveHelper.b(), 1000L * l2);
          bool2 = HotReactiveHelper.a(HotReactiveHelper.b(), 1000L * l1);
          bool3 = HotReactiveHelper.a(HotReactiveHelper.b(), l3 * 1000L);
          i = ((RecentItemChatMsgData)paramRecentBaseData).m;
          bool4 = ((RecentItemChatMsgData)paramRecentBaseData).jdField_c_of_type_Boolean;
          if (i != 1) {
            break label927;
          }
          if (!bool4) {
            break label919;
          }
          i = 2130845794;
          m = i;
          i = ((RecentItemChatMsgData)paramRecentBaseData).l;
          if (i != 1) {
            break label972;
          }
          if (!bool2) {
            break label964;
          }
          i = 2130845803;
          j = ((RecentItemChatMsgData)paramRecentBaseData).k;
          if (j != 1) {
            break label1013;
          }
          if (!bool1) {
            break label1005;
          }
          j = 2130845800;
          k = ((RecentItemChatMsgData)paramRecentBaseData).n;
          if (k != 1) {
            break label1054;
          }
          if (!bool3) {
            break label1046;
          }
          k = 2130845796;
          label587:
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(m, i, j, k);
          label603:
          switch (paramRecentBaseData.jdField_a_of_type_Int)
          {
          default: 
            i = 0;
            localRecentEfficientItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(i, 0);
            i = paramRecentBaseData.e;
            paramContext = paramRecentBaseData.jdField_d_of_type_JavaLangCharSequence;
            if (paramContext != null)
            {
              paramContext = paramContext.toString();
              paramDrawable = paramContext;
              if (paramContext != null)
              {
                paramDrawable = paramContext;
                if (paramContext.length() > 0)
                {
                  paramDrawable = paramContext;
                  if (!paramContext.endsWith(" ")) {
                    paramDrawable = paramContext + " ";
                  }
                }
              }
              if ((!TextUtils.isEmpty(paramDrawable)) && (i != 0)) {
                localRecentEfficientItemBuilderHolder.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              localRecentEfficientItemBuilderHolder.b.setExtendText(paramDrawable, 1);
            }
            break;
          }
        }
        try
        {
          localRecentEfficientItemBuilderHolder.b.setText(paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence);
          m = paramRecentBaseData.jdField_c_of_type_Int;
          j = 0;
          i = paramRecentBaseData.jdField_b_of_type_Int;
          if (m > 0) {
            if (i == 0)
            {
              i = 0;
              j = 0;
              m = 0;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
              CustomWidgetUtil.a(localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if ((paramRecentBaseData.f & 0xF0) != 32) {
                break label1312;
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            try
            {
              localRecentEfficientItemBuilderHolder.f.setBackgroundResource(2130838584);
              if (AppSetting.b) {
                paramView.setContentDescription(paramRecentBaseData.jdField_d_of_type_JavaLangString);
              }
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.c());
              return;
              bool1 = false;
              break;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
              break label224;
              paramContext = "";
              break label334;
              label919:
              i = 2130845801;
              break label508;
              label927:
              if (i == 2)
              {
                if (bool4)
                {
                  i = 2130845793;
                  m = i;
                  break label512;
                }
                i = 2130845787;
                continue;
              }
              m = 0;
              break label512;
              label964:
              i = 2130845802;
              break label537;
              label972:
              if (i == 2)
              {
                if (bool2)
                {
                  i = 2130845789;
                  break label537;
                }
                i = 2130845788;
                break label537;
              }
              i = 0;
              break label537;
              label1005:
              j = 2130845799;
              break label562;
              label1013:
              if (j == 2)
              {
                if (bool1)
                {
                  j = 2130845786;
                  break label562;
                }
                j = 2130845785;
                break label562;
              }
              j = 0;
              break label562;
              label1046:
              k = 2130845795;
              break label587;
              label1054:
              if (k == 2)
              {
                if (bool3)
                {
                  k = 2130845798;
                  break label587;
                }
                k = 2130845797;
                break label587;
              }
              k = 0;
              break label587;
              label1087:
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              break label603;
              i = 2130840207;
              break label643;
              if (paramRecentBaseData.jdField_a_of_type_Boolean)
              {
                i = 2130840214;
                break label643;
              }
              i = 2130840207;
              break label643;
              if (paramRecentBaseData.jdField_a_of_type_Boolean)
              {
                i = 2130840214;
                break label643;
              }
              i = 2130840215;
              break label643;
              i = 2130840215;
              break label643;
              i = 2130838697;
              break label643;
              paramContext = "";
              break label676;
              paramContext = paramContext;
              paramContext.printStackTrace();
              localRecentEfficientItemBuilderHolder.b.setText(paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence + " ");
              continue;
              if (i == 2)
              {
                i = 1;
                j = 0;
                m = 0;
                localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                k = 99;
                continue;
              }
              if (i == 3)
              {
                i = 3;
                j = 2130845928;
                if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
                localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
                k = 99;
                continue;
              }
              i = 3;
              j = 2130845927;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              k = 99;
              continue;
              label1312:
              localRecentEfficientItemBuilderHolder.f.setBackgroundResource(2130838583);
              continue;
            }
            catch (Throwable paramContext)
            {
              continue;
            }
            m = 0;
            i = 0;
            k = 99;
          }
        }
      }
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.a();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder
 * JD-Core Version:    0.7.0.1
 */