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
  private final ChatHistoryBaseFragment a;
  private QQAppInterface b;
  private Context c;
  @NonNull
  private List<Object> d = new ArrayList();
  private Map<String, ArrayList<TroopLinkElement>> e = new LinkedHashMap();
  private ArrayMap<String, Boolean> f = new ArrayMap();
  private SimpleDateFormat g;
  private boolean h;
  private List<TroopLinkElement> i;
  
  public LinkAdapter(QQAppInterface paramQQAppInterface, Context paramContext, ChatHistoryBaseFragment paramChatHistoryBaseFragment)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.a = paramChatHistoryBaseFragment;
    this.g = new SimpleDateFormat("M月d日");
    this.i = new ArrayList();
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130838758);
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
      LinkAdapter.ViewHolder.a(paramViewHolder).setImageDrawable(this.c.getResources().getDrawable(2130852667));
    }
    if (!TextUtils.isEmpty(paramTroopLinkElement.title)) {
      LinkAdapter.ViewHolder.b(paramViewHolder).setText(paramTroopLinkElement.title);
    } else {
      LinkAdapter.ViewHolder.b(paramViewHolder).setText(paramTroopLinkElement.url);
    }
    Object localObject = new Date(Long.parseLong(paramTroopLinkElement.timeSecond) * 1000L);
    localObject = this.g.format((Date)localObject);
    LinkAdapter.ViewHolder.c(paramViewHolder).setText((CharSequence)localObject);
    localObject = ((IBizTroopMemberInfoService)this.b.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberNickNoEmpty(this.a.g(), paramTroopLinkElement.uin);
    LinkAdapter.ViewHolder.d(paramViewHolder).setText((CharSequence)localObject);
    LinkAdapter.ViewHolder.f(paramViewHolder).setOnClickListener(new LinkAdapter.2(this, paramTroopLinkElement, paramViewHolder));
    if (this.h)
    {
      LinkAdapter.ViewHolder.e(paramViewHolder).setVisibility(0);
      boolean bool = this.i.contains(paramTroopLinkElement);
      LinkAdapter.ViewHolder.e(paramViewHolder).setChecked(bool);
      paramTroopLinkElement = (LinearLayout.LayoutParams)LinkAdapter.ViewHolder.g(paramViewHolder).getLayoutParams();
      paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, UIUtils.a(this.c, 8.0F), paramTroopLinkElement.bottomMargin);
      LinkAdapter.ViewHolder.g(paramViewHolder).setLayoutParams(paramTroopLinkElement);
      return;
    }
    LinkAdapter.ViewHolder.e(paramViewHolder).setVisibility(8);
    paramTroopLinkElement = (LinearLayout.LayoutParams)LinkAdapter.ViewHolder.g(paramViewHolder).getLayoutParams();
    paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, UIUtils.a(this.c, 50.0F), paramTroopLinkElement.bottomMargin);
    LinkAdapter.ViewHolder.g(paramViewHolder).setLayoutParams(paramTroopLinkElement);
  }
  
  private void a(String paramString)
  {
    if (this.f.containsKey(paramString))
    {
      if (!this.e.containsKey(paramString)) {
        return;
      }
      boolean bool = ((Boolean)this.f.get(paramString)).booleanValue();
      ArrayList localArrayList = (ArrayList)this.e.get(paramString);
      if (bool)
      {
        int j = this.d.indexOf(paramString);
        this.d.addAll(j + 1, localArrayList);
        ReportController.b(this.b, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "2", "2", "", "");
      }
      else
      {
        this.d.removeAll(localArrayList);
        ReportController.b(this.b, "dc00898", "", "", "0X800AC87", "0X800AC87", 5, 0, "2", "1", "", "");
      }
      this.f.put(paramString, Boolean.valueOf(bool ^ true));
      notifyDataSetChanged();
    }
  }
  
  public List<TroopLinkElement> a()
  {
    return this.i;
  }
  
  public void a(Map<String, ArrayList<TroopLinkElement>> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return;
      }
      this.e = paramMap;
      this.f.clear();
      this.d.clear();
      paramMap = this.e.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (ArrayList)((Map.Entry)localObject).getValue();
        this.f.put(str, Boolean.valueOf(false));
        this.d.add(str);
        this.d.addAll((Collection)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("[setElements]data size: ");
        paramMap.append(this.e.size());
        paramMap.append(" header size: ");
        paramMap.append(this.f.size());
        paramMap.append(" elements size: ");
        paramMap.append(this.d.size());
        QLog.d("LinkAdapter", 2, paramMap.toString());
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    this.i.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getCount]data size: ");
      localStringBuilder.append(this.e.size());
      localStringBuilder.append(" header size: ");
      localStringBuilder.append(this.f.size());
      localStringBuilder.append(" elements size: ");
      localStringBuilder.append(this.d.size());
      QLog.d("LinkAdapter", 2, localStringBuilder.toString());
    }
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
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
        paramView = LayoutInflater.from(this.c).inflate(2131624414, null);
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
          paramView = LayoutInflater.from(this.c).inflate(2131624413, null);
          localObject1 = new LinkAdapter.DividerViewHolder();
          ((LinkAdapter.DividerViewHolder)localObject1).b = ((CheckBox)paramView.findViewById(2131436369));
          ((LinkAdapter.DividerViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131447246));
          paramView.setTag(localObject1);
          paramView.setOnClickListener(new LinkAdapter.1(this, (LinkAdapter.DividerViewHolder)localObject1));
        }
        ((LinkAdapter.DividerViewHolder)localObject1).b.setChecked(((Boolean)this.f.get(localObject2)).booleanValue() ^ true);
        ((LinkAdapter.DividerViewHolder)localObject1).a.setText((String)localObject2);
        localObject1 = paramView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.LinkAdapter
 * JD-Core Version:    0.7.0.1
 */