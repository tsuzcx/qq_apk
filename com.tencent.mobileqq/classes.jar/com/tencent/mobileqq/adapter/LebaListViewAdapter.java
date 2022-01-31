package com.tencent.mobileqq.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.LebaHelper;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wholepeople.WholePeopleConstant;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import ynv;

public class LebaListViewAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public QQAppInterface a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString = "";
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet(30);
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  
  public LebaListViewAdapter(Context paramContext, List paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, ListView paramListView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842699);
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
    if (String.valueOf(6005).equals(paramString1))
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
    ThreadManager.post(new ynv(this, paramString1), 2, null, true);
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
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((((View)localObject).getTag(-1) != null) && ((((View)localObject).getTag(-1) instanceof Integer)) && (((Integer)((View)localObject).getTag(-1)).intValue() == 0))
          {
            if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
            }
            if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10001L))) {
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10001L));
            }
            if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(826L))) {
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(826L));
            }
          }
          else if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof LebaListViewAdapter.CornerListItemHolder)))
          {
            localObject = (LebaListViewAdapter.CornerListItemHolder)((View)localObject).getTag();
            if ((localObject != null) && (((LebaListViewAdapter.CornerListItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem != null) && (((LebaListViewAdapter.CornerListItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null))
            {
              long l = ((LebaListViewAdapter.CornerListItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
              }
            }
          }
        }
      }
    }
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
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((Long)localIterator.next());
        if (localIterator.hasNext()) {
          localStringBuilder.append(";");
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_plugin", "old_plugin_exp", 0, 0, "", "", localStringBuilder.toString(), "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
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
    if (i == 0) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.jdField_a_of_type_Int, null);
        paramViewGroup = new LebaListViewAdapter.CornerListItemHolder(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364355));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364359));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364356));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131363823));
        paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).c(36).a();
        paramView.setTag(paramViewGroup);
        label140:
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494225));
        if (Build.VERSION.SDK_INT < 16) {
          break label694;
        }
        paramViewGroup.b.setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845991));
        label216:
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL))) {
          break label717;
        }
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL, (URLDrawable.URLDrawableOptions)localObject);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        label318:
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
        switch (localLebaViewItem.jdField_a_of_type_Int)
        {
        default: 
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838635);
          label370:
          if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null))
          {
            a((RedTouch)paramView, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "", localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
            if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId))) {
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId));
            }
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
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == 770L) && (paramView != null)) {
        paramView.f();
      }
      paramView = paramViewGroup;
      if (paramInt != 0) {
        break;
      }
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
      }
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10001L))) {
        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10001L));
      }
      paramView = paramViewGroup;
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(826L))) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(826L));
      return paramViewGroup;
      paramViewGroup = (LebaListViewAdapter.CornerListItemHolder)paramView.getTag();
      break label140;
      label694:
      paramViewGroup.b.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845991));
      break label216;
      label717:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label318;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838635);
      break label370;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838642);
      break label370;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838640);
      break label370;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838640);
      break label370;
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