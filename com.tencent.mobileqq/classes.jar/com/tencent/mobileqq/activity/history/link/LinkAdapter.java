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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
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
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130838632);
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
      paramString.setDecodeHandler(URLDrawableDecodeHandler.i);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      label100:
      break label100;
    }
    paramImageView.setImageDrawable(localDrawable);
  }
  
  private void a(LinkAdapter.ViewHolder paramViewHolder, TroopLinkElement paramTroopLinkElement)
  {
    if (!TextUtils.isEmpty(paramTroopLinkElement.iconUrl)) {
      a(LinkAdapter.ViewHolder.a(paramViewHolder), paramTroopLinkElement.iconUrl);
    } else {
      LinkAdapter.ViewHolder.a(paramViewHolder).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850832));
    }
    if (!TextUtils.isEmpty(paramTroopLinkElement.title)) {
      LinkAdapter.ViewHolder.a(paramViewHolder).setText(paramTroopLinkElement.title);
    } else {
      LinkAdapter.ViewHolder.a(paramViewHolder).setText(paramTroopLinkElement.url);
    }
    Object localObject = new Date(Long.parseLong(paramTroopLinkElement.timeSecond) * 1000L);
    localObject = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
    LinkAdapter.ViewHolder.b(paramViewHolder).setText((CharSequence)localObject);
    localObject = ((IBizTroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberNickNoEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseFragment.a(), paramTroopLinkElement.uin);
    LinkAdapter.ViewHolder.c(paramViewHolder).setText((CharSequence)localObject);
    LinkAdapter.ViewHolder.a(paramViewHolder).setOnClickListener(new LinkAdapter.2(this, paramTroopLinkElement, paramViewHolder));
    if (this.jdField_a_of_type_Boolean)
    {
      LinkAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      boolean bool = this.b.contains(paramTroopLinkElement);
      LinkAdapter.ViewHolder.a(paramViewHolder).setChecked(bool);
      paramTroopLinkElement = (LinearLayout.LayoutParams)LinkAdapter.ViewHolder.a(paramViewHolder).getLayoutParams();
      paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), paramTroopLinkElement.bottomMargin);
      LinkAdapter.ViewHolder.a(paramViewHolder).setLayoutParams(paramTroopLinkElement);
      return;
    }
    LinkAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
    paramTroopLinkElement = (LinearLayout.LayoutParams)LinkAdapter.ViewHolder.a(paramViewHolder).getLayoutParams();
    paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), paramTroopLinkElement.bottomMargin);
    LinkAdapter.ViewHolder.a(paramViewHolder).setLayoutParams(paramTroopLinkElement);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramString))
    {
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        return;
      }
      boolean bool = ((Boolean)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString)).booleanValue();
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (bool)
      {
        int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramString);
        this.jdField_a_of_type_JavaUtilList.addAll(i + 1, localArrayList);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "2", "2", "", "");
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.removeAll(localArrayList);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "2", "1", "", "");
      }
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString, Boolean.valueOf(bool ^ true));
      notifyDataSetChanged();
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
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
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
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("[setElements]data size: ");
        paramMap.append(this.jdField_a_of_type_JavaUtilMap.size());
        paramMap.append(" header size: ");
        paramMap.append(this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size());
        paramMap.append(" elements size: ");
        paramMap.append(this.jdField_a_of_type_JavaUtilList.size());
        QLog.d("LinkAdapter", 2, paramMap.toString());
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getCount]data size: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.size());
      localStringBuilder.append(" header size: ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size());
      localStringBuilder.append(" elements size: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("LinkAdapter", 2, localStringBuilder.toString());
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
    Object localObject1;
    if ((localObject2 instanceof TroopLinkElement))
    {
      localObject2 = (TroopLinkElement)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof LinkAdapter.ViewHolder)))
      {
        localObject1 = (LinkAdapter.ViewHolder)paramView.getTag();
      }
      else
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558794, null);
        localObject1 = new LinkAdapter.ViewHolder(paramView);
        paramView.setTag(localObject1);
      }
      a((LinkAdapter.ViewHolder)localObject1, (TroopLinkElement)localObject2);
      localObject1 = paramView;
    }
    else
    {
      localObject1 = paramView;
      if ((localObject2 instanceof String))
      {
        if ((paramView != null) && ((paramView.getTag() instanceof LinkAdapter.DividerViewHolder)))
        {
          localObject1 = (LinkAdapter.DividerViewHolder)paramView.getTag();
        }
        else
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558793, null);
          localObject1 = new LinkAdapter.DividerViewHolder();
          ((LinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
          ((LinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378615));
          paramView.setTag(localObject1);
          paramView.setOnClickListener(new LinkAdapter.1(this, (LinkAdapter.DividerViewHolder)localObject1));
        }
        ((LinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((Boolean)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject2)).booleanValue() ^ true);
        ((LinkAdapter.DividerViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject2);
        localObject1 = paramView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.LinkAdapter
 * JD-Core Version:    0.7.0.1
 */