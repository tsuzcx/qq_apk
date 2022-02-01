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
    ArrayList localArrayList;
    int j;
    label71:
    Object localObject;
    if (localTroopMemberItem == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      paramArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label272;
      }
      localObject = (String)localTroopMemberItem.get(j);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,}", (CharSequence)localObject))) {
        break label125;
      }
    }
    for (;;)
    {
      j += 1;
      break label71;
      i = localTroopMemberItem.size();
      break;
      label125:
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
    label272:
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
    Object localObject = null;
    int i = 0;
    if ((localObject == null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localTroopMemberItem == null) || (!Utils.a(localTroopMemberItem.jdField_a_of_type_JavaLangString, paramString))) {
        break label61;
      }
      localObject = localTroopMemberItem;
    }
    label61:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return localObject1;
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
    Object localObject1;
    if (i == 0) {
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559435, paramViewGroup, false);
        paramView = new TroopTransferActivity.ViewHolder(null);
        paramView.c = null;
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
        ((View)localObject1).setTag(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
        if ((localTroopMemberItem == null) || (localTroopMemberItem.jdField_b_of_type_Int != 1)) {
          break label156;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131693926);
      }
    }
    label281:
    label410:
    for (;;)
    {
      if ((paramView != null) && (paramView.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((View)localObject1).setContentDescription(paramView.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      Object localObject2 = (TroopTransferActivity.ViewHolder)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label156:
      if ((localTroopMemberItem != null) && (localTroopMemberItem.jdField_b_of_type_Int == 0))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131720094);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("");
        continue;
        if (i == 1)
        {
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563155, paramViewGroup, false);
            paramView.findViewById(2131380189).setVisibility(8);
            paramView.findViewById(2131364037).setVisibility(8);
            localObject1 = new TroopTransferActivity.ViewHolder(null);
            ((TroopTransferActivity.ViewHolder)localObject1).c = ((ImageView)paramView.findViewById(2131369676));
            ((TroopTransferActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380475));
            paramView.setTag(localObject1);
            ((TroopTransferActivity.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
            if (localTroopMemberItem == null) {
              break label376;
            }
            localObject2 = localTroopMemberItem.jdField_a_of_type_JavaLangString;
            label300:
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("0"))) {
              break label382;
            }
            ((TroopTransferActivity.ViewHolder)localObject1).c.setImageDrawable(ImageUtil.c());
            label329:
            if (localTroopMemberItem == null) {
              break label410;
            }
          }
          for (localObject2 = localTroopMemberItem.jdField_b_of_type_JavaLangString;; localObject2 = "")
          {
            ((TroopTransferActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
            break;
            localObject1 = (TroopTransferActivity.ViewHolder)paramView.getTag();
            break label281;
            label376:
            localObject2 = null;
            break label300;
            label382:
            ((TroopTransferActivity.ViewHolder)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((TroopTransferActivity.ViewHolder)localObject1).c.setImageBitmap(a(1, localTroopMemberItem.jdField_a_of_type_JavaLangString));
            break label329;
          }
        }
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */