package com.tencent.mobileqq.activity.history.link;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayMap<String, Boolean> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private final ChatHistoryBaseFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseFragment;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  @NonNull
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, ArrayList<TroopLinkElement>> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private boolean jdField_a_of_type_Boolean;
  private List<TroopLinkElement> b;
  
  public LinkAdapter(QQAppInterface paramQQAppInterface, Context paramContext, ChatHistoryBaseFragment paramChatHistoryBaseFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseFragment = paramChatHistoryBaseFragment;
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
    this.b = new ArrayList();
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130838812);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
    localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(URLDrawableDecodeHandler.b(localLayoutParams.width, localLayoutParams.height, UIUtils.a(localBaseApplication, 6.0F)));
      paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramImageView.setImageDrawable(localDrawable);
    }
  }
  
  private void a(LinkAdapter.ViewHolder paramViewHolder, TroopLinkElement paramTroopLinkElement)
  {
    if (!TextUtils.isEmpty(paramTroopLinkElement.iconUrl))
    {
      a(LinkAdapter.ViewHolder.a(paramViewHolder), paramTroopLinkElement.iconUrl);
      if (TextUtils.isEmpty(paramTroopLinkElement.title)) {
        break label248;
      }
      LinkAdapter.ViewHolder.a(paramViewHolder).setText(paramTroopLinkElement.title);
    }
    for (;;)
    {
      Object localObject = new Date(Long.parseLong(paramTroopLinkElement.timeSecond) * 1000L);
      localObject = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
      LinkAdapter.ViewHolder.b(paramViewHolder).setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseFragment.a(), paramTroopLinkElement.uin);
      LinkAdapter.ViewHolder.c(paramViewHolder).setText((CharSequence)localObject);
      LinkAdapter.ViewHolder.a(paramViewHolder).setOnClickListener(new LinkAdapter.2(this, paramTroopLinkElement, paramViewHolder));
      if (!this.jdField_a_of_type_Boolean) {
        break label262;
      }
      LinkAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      boolean bool = this.b.contains(paramTroopLinkElement);
      LinkAdapter.ViewHolder.a(paramViewHolder).setChecked(bool);
      paramTroopLinkElement = (LinearLayout.LayoutParams)LinkAdapter.ViewHolder.a(paramViewHolder).getLayoutParams();
      paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), paramTroopLinkElement.bottomMargin);
      LinkAdapter.ViewHolder.a(paramViewHolder).setLayoutParams(paramTroopLinkElement);
      return;
      LinkAdapter.ViewHolder.a(paramViewHolder).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850895));
      break;
      label248:
      LinkAdapter.ViewHolder.a(paramViewHolder).setText(paramTroopLinkElement.url);
    }
    label262:
    LinkAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
    paramTroopLinkElement = (LinearLayout.LayoutParams)LinkAdapter.ViewHolder.a(paramViewHolder).getLayoutParams();
    paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), paramTroopLinkElement.bottomMargin);
    LinkAdapter.ViewHolder.a(paramViewHolder).setLayoutParams(paramTroopLinkElement);
  }
  
  private void a(String paramString)
  {
    boolean bool1 = false;
    if ((!this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramString)) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      return;
    }
    boolean bool2 = ((Boolean)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString)).booleanValue();
    Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (bool2)
    {
      int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramString);
      this.jdField_a_of_type_JavaUtilList.addAll(i + 1, (Collection)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "2", "2", "", "");
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap;
      if (!bool2) {
        bool1 = true;
      }
      ((ArrayMap)localObject).put(paramString, Boolean.valueOf(bool1));
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList.removeAll((Collection)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "2", "1", "", "");
    }
  }
  
  public List<TroopLinkElement> a()
  {
    return this.b;
  }
  
  public void a()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(Map<String, ArrayList<TroopLinkElement>> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    paramMap = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ArrayList)((Map.Entry)localObject).getValue();
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(str, Boolean.valueOf(false));
      this.jdField_a_of_type_JavaUtilList.add(str);
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LinkAdapter", 2, "[setElements]data size: " + this.jdField_a_of_type_JavaUtilMap.size() + " header size: " + this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size() + " elements size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LinkAdapter", 2, "[getCount]data size: " + this.jdField_a_of_type_JavaUtilMap.size() + " header size: " + this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size() + " elements size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = getItem(paramInt);
    if ((localObject2 instanceof TroopLinkElement))
    {
      localObject2 = (TroopLinkElement)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof LinkAdapter.ViewHolder))) {
        localObject1 = (LinkAdapter.ViewHolder)paramView.getTag();
      }
      for (;;)
      {
        a((LinkAdapter.ViewHolder)localObject1, (TroopLinkElement)localObject2);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558896, null);
        localObject1 = new LinkAdapter.ViewHolder(paramView);
        paramView.setTag(localObject1);
      }
    }
    Object localObject1 = paramView;
    label137:
    CheckBox localCheckBox;
    if ((localObject2 instanceof String))
    {
      if ((paramView == null) || (!(paramView.getTag() instanceof LinkAdapter.DividerViewHolder))) {
        break label194;
      }
      localObject1 = (LinkAdapter.DividerViewHolder)paramView.getTag();
      localCheckBox = ((LinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox;
      if (((Boolean)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject2)).booleanValue()) {
        break label271;
      }
    }
    label271:
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      ((LinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject2);
      localObject1 = paramView;
      paramView = (View)localObject1;
      break;
      label194:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558895, null);
      localObject1 = new LinkAdapter.DividerViewHolder();
      ((LinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369653));
      ((LinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379254));
      paramView.setTag(localObject1);
      paramView.setOnClickListener(new LinkAdapter.1(this, (LinkAdapter.DividerViewHolder)localObject1));
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.LinkAdapter
 * JD-Core Version:    0.7.0.1
 */