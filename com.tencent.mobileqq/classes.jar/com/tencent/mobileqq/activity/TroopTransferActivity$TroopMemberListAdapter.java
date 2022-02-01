package com.tencent.mobileqq.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TroopTransferActivity$TroopMemberListAdapter
  extends FacePreloadBaseAdapter
{
  protected LayoutInflater a;
  protected ArrayList<TroopTransferActivity.TroopMemberItem> a;
  
  public TroopTransferActivity$TroopMemberListAdapter(Context paramContext, ArrayList<String> paramArrayList)
  {
    super(paramArrayList, paramContext.app, paramContext.a, 1, true);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramArrayList.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    TroopTransferActivity.TroopMemberItem localTroopMemberItem;
    int i;
    if (localTroopMemberItem == null) {
      i = 0;
    } else {
      i = localTroopMemberItem.size();
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = new ArrayList();
    int j = 0;
    while (j < i)
    {
      Object localObject = (String)localTroopMemberItem.get(j);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,}", (CharSequence)localObject)))
      {
        int k = ((String)localObject).indexOf('|');
        String str = ((String)localObject).substring(0, k);
        k = Integer.parseInt(((String)localObject).substring(k + 1));
        if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 1))
        {
          localObject = new TroopTransferActivity.TroopMemberItem();
          ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_Int = 1;
          ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString = str;
          ((TroopTransferActivity.TroopMemberItem)localObject).jdField_b_of_type_Int = k;
          localArrayList.add(localObject);
        }
        else if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 0))
        {
          localObject = new TroopTransferActivity.TroopMemberItem();
          ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_Int = 1;
          ((TroopTransferActivity.TroopMemberItem)localObject).jdField_a_of_type_JavaLangString = str;
          ((TroopTransferActivity.TroopMemberItem)localObject).jdField_b_of_type_Int = k;
          paramArrayList.add(localObject);
        }
      }
      j += 1;
    }
    if (localArrayList.size() > 0)
    {
      localTroopMemberItem = new TroopTransferActivity.TroopMemberItem();
      localTroopMemberItem.jdField_a_of_type_Int = 0;
      localTroopMemberItem.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, localTroopMemberItem);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    }
    if (paramArrayList.size() > 0)
    {
      localTroopMemberItem = new TroopTransferActivity.TroopMemberItem();
      localTroopMemberItem.jdField_a_of_type_Int = 0;
      localTroopMemberItem.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.add(localTroopMemberItem);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    ThreadManager.post(new TroopTransferActivity.TroopMemberListAdapter.1(this, paramContext), 8, null, false);
  }
  
  public TroopTransferActivity.TroopMemberItem a(String paramString)
  {
    Object localObject1 = null;
    int i = 0;
    while ((localObject1 == null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      Object localObject2 = localObject1;
      if (localTroopMemberItem != null)
      {
        localObject2 = localObject1;
        if (Utils.a(localTroopMemberItem.jdField_a_of_type_JavaLangString, paramString)) {
          localObject2 = localTroopMemberItem;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public List<TroopTransferActivity.TroopMemberItem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_a_of_type_Int == 0)) {
      return 0;
    }
    if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_a_of_type_Int == 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    String str = "";
    TroopTransferActivity.ViewHolder localViewHolder = null;
    Object localObject2 = null;
    Object localObject1;
    if (i == 0)
    {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559309, paramViewGroup, false);
        localViewHolder = new TroopTransferActivity.ViewHolder(null);
        localViewHolder.c = null;
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
        paramView.setTag(localViewHolder);
      }
      else
      {
        localViewHolder = (TroopTransferActivity.ViewHolder)paramView.getTag();
      }
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
      if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_b_of_type_Int == 1))
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131693882);
        localObject1 = paramView;
      }
      else if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_b_of_type_Int == 0))
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131719826);
        localObject1 = paramView;
      }
      else
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localObject1 = paramView;
      }
    }
    else
    {
      localObject1 = paramView;
      if (i == 1)
      {
        if (paramView == null)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562978, paramViewGroup, false);
          paramView.findViewById(2131379508).setVisibility(8);
          paramView.findViewById(2131363963).setVisibility(8);
          localViewHolder = new TroopTransferActivity.ViewHolder(null);
          localViewHolder.c = ((ImageView)paramView.findViewById(2131369373));
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379778));
          paramView.setTag(localViewHolder);
        }
        else
        {
          localViewHolder = (TroopTransferActivity.ViewHolder)paramView.getTag();
        }
        localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
        localObject1 = localObject2;
        if (localTroopMemberItem != null) {
          localObject1 = localTroopMemberItem.jdField_a_of_type_JavaLangString;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("0")))
        {
          localViewHolder.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localViewHolder.c.setImageBitmap(a(1, localTroopMemberItem.jdField_a_of_type_JavaLangString));
        }
        else
        {
          localViewHolder.c.setImageDrawable(ImageUtil.e());
        }
        localObject1 = str;
        if (localTroopMemberItem != null) {
          localObject1 = localTroopMemberItem.jdField_b_of_type_JavaLangString;
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject1 = paramView;
      }
    }
    if ((localViewHolder != null) && (localViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)) {
      ((View)localObject1).setContentDescription(localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */