package com.tencent.mobileqq.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.campuscircle.CampusCircleHelper;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wholepeople.WholePeopleConstant;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import yeh;
import yej;

public class LebaListViewAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  public Context a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public QQAppInterface a;
  String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  
  public LebaListViewAdapter(Context paramContext, List paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void a(RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return;
    }
    Object localObject1 = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
    oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject1).a();
    if (localRedDotInfo == null)
    {
      paramRedTouch.b();
      return;
    }
    StoryReportor.a("dynamic", "exp_story", 0, ((TroopRedTouchManager)localObject1).b(), new String[0]);
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    int i;
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      i = -1;
    case 11: 
    case 37: 
    case 8: 
      while (i != -1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "更新动态红点:" + TroopRedTouchManager.a(localRedDotInfo));
        }
        localRedTypeInfo.red_type.set(i);
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramRedTouch.a(localRedTypeInfo);
        return;
        localRedTypeInfo.red_content.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8() + "");
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        i = 4;
        continue;
        localObject1 = "New";
        try
        {
          String str = new JSONObject(localRedDotInfo.str_custom_buffer.get().toStringUtf8()).getString("red_word");
          localObject1 = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            SLog.d("LebaListViewAdapter", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
          }
        }
        localRedTypeInfo.red_content.set((String)localObject1);
        localRedTypeInfo.red_desc.set("{'cn':'#00000000' ,'cr':'#777777'}");
        i = 4;
        continue;
        i = 0;
      }
    case 35: 
      label138:
      i = localRedDotInfo.uint32_cmd_uin_type.get();
      if (i == 0)
      {
        localObject2 = localRedDotInfo.str_face_url.get().toStringUtf8();
        localObject1 = String.format("{'uin':'%s','dot':1, 'av':1}", new Object[] { localRedDotInfo.uint64_cmd_uin.get() + "" });
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = "{'av':1, 'dot':1}";
          localRedTypeInfo.red_content.set((String)localObject2);
        }
        localRedTypeInfo.red_desc.set((String)localObject1);
      }
      for (;;)
      {
        i = 3;
        break label138;
        if (i != 1) {
          break;
        }
        localObject1 = "http://p.qlogo.cn/gh/" + localRedDotInfo.uint64_cmd_uin.get() + "/" + localRedDotInfo.uint64_cmd_uin.get() + "/100?t=" + TroopRedTouchManager.c;
        localRedTypeInfo.red_content.set((String)localObject1);
        localRedTypeInfo.red_desc.set("{'av':1, 'dot':1}");
      }
    }
    Object localObject2 = localRedTypeInfo.red_content;
    if (localRedDotInfo.uint32_number.get() > 99) {}
    for (localObject1 = "99+";; localObject1 = localRedDotInfo.uint32_number.get() + "")
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      i = 4;
      break;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (ReadInJoyNotifyRedTouchInfo.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      b(paramRedTouch);
      return;
    }
    if (String.valueOf(3050).equals(paramString1))
    {
      a(paramRedTouch);
      return;
    }
    if ("com.android.campus".equals(paramString2))
    {
      CampusCircleHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRedTouch);
      return;
    }
    if (WholePeopleConstant.jdField_a_of_type_JavaLangString.equals(paramString2))
    {
      WholePeopleConstant.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRedTouch);
      return;
    }
    paramString1 = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramString1);
    paramRedTouch.a(paramString1);
    ThreadManager.post(new yej(this, paramString1), 2, null, true);
  }
  
  private void b(RedTouch paramRedTouch)
  {
    Object localObject;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = (ReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95);
      if (localObject != null)
      {
        localRedTypeInfo = ((ReadInJoyManager)localObject).a();
        localAppInfo = ((ReadInJoyManager)localObject).a();
        localObject = ((ReadInJoyManager)localObject).a();
      }
    }
    int i;
    switch (((ReadInJoyNotifyRedTouchInfo)localObject).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      i = ((ReadInJoyNotifyRedTouchInfo)localObject).jdField_b_of_type_Int;
      if (i > 99) {
        localRedTypeInfo.red_content.set("99+");
      }
      for (;;)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramRedTouch.a(localAppInfo);
        return;
        localRedTypeInfo.red_content.set(i + "");
      }
    case 3: 
      localRedTypeInfo.red_type.set(3);
      i = ((ReadInJoyNotifyRedTouchInfo)localObject).c;
      localRedTypeInfo.red_desc.set("{'drawable':" + i + "}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    case 2: 
      localObject = ((ReadInJoyNotifyRedTouchInfo)localObject).jdField_b_of_type_JavaLangString;
      localRedTypeInfo.red_content.set((String)localObject + "");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#777777'}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(9);
      localRedTypeInfo.red_content.set(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F) + "");
      localRedTypeInfo.red_desc.set("");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    case 4: 
      localObject = ((ReadInJoyNotifyRedTouchInfo)localObject).jdField_b_of_type_JavaLangString;
      localRedTypeInfo.red_content.set((String)localObject + "");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#FF0000'}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    }
    paramRedTouch.b();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a(LebaViewItem paramLebaViewItem)
  {
    return !TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_JavaLangString);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return null;
    }
    return (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    if (TextUtils.isEmpty(((LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItem(paramInt) == null) {
      return paramView;
    }
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    int i = getItemViewType(paramInt);
    label140:
    label216:
    Object localObject;
    if (i == 0) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.jdField_a_of_type_Int, null);
        paramViewGroup = new LebaListViewAdapter.CornerListItemHolder(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364306));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364310));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364307));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131363776));
        paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).c(36).a();
        paramView.setTag(paramViewGroup);
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494212));
        if (Build.VERSION.SDK_INT < 16) {
          break label663;
        }
        paramViewGroup.b.setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845783));
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
          break label731;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LebaListViewAdapter", 2, "item.icon == null, info=" + localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
        }
        if (localLebaViewItem.jdField_b_of_type_JavaLangString == null)
        {
          localObject = LebaUtil.a(this.jdField_a_of_type_AndroidContentContext, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL);
          if (localObject != null) {
            localLebaViewItem.jdField_b_of_type_JavaLangString = ("LebaIcon://" + ((File)localObject).getAbsolutePath());
          }
        }
        if (localLebaViewItem.jdField_b_of_type_JavaLangString == null) {
          break label718;
        }
        localObject = localLebaViewItem.jdField_b_of_type_JavaLangString;
        Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageHashMap.get(localObject);
        if (localBitmap == null) {
          break label686;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        if (QLog.isColorLevel()) {
          QLog.d("LebaListViewAdapter", 2, "found bitmap from cache, info=" + localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
        }
        label416:
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
        switch (localLebaViewItem.jdField_a_of_type_Int)
        {
        default: 
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838625);
          label466:
          if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
            a((RedTouch)paramView, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "", localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
          }
          if ((AppSetting.b) && (localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName)))
          {
            AccessibilityUtil.a(paramView, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName, Button.class.getName());
            paramViewGroup = paramView;
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (paramViewGroup != null)
      {
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramView = paramViewGroup;
      if (localLebaViewItem == null) {
        break;
      }
      paramView = paramViewGroup;
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) {
        break;
      }
      paramView = paramViewGroup;
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 770L) {
        break;
      }
      paramView = paramViewGroup;
      if (localObject == null) {
        break;
      }
      ((LebaHelper)localObject).g();
      return paramViewGroup;
      paramViewGroup = (LebaListViewAdapter.CornerListItemHolder)paramView.getTag();
      break label140;
      label663:
      paramViewGroup.b.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845783));
      break label216;
      label686:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842572);
      ThreadManager.post(new yeh(this, localLebaViewItem, (String)localObject, paramViewGroup), 5, null, true);
      break label416;
      label718:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842572);
      break label416;
      label731:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842572);
      break label416;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838625);
      break label466;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838632);
      break label466;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838630);
      break label466;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838630);
      break label466;
      if (i == 1)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.jdField_b_of_type_Int, null);
        }
      }
      else
      {
        paramViewGroup = null;
        continue;
        paramViewGroup = paramView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    if (!a((LebaViewItem)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListViewAdapter
 * JD-Core Version:    0.7.0.1
 */