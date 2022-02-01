package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RecommendTroopAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new RecommendTroopAdapter.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<RecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private View.OnClickListener b = new RecommendTroopAdapter.2(this);
  
  public RecommendTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561686, null);
    RecommendTroopAdapter.ViewHolder localViewHolder = new RecommendTroopAdapter.ViewHolder();
    localViewHolder.jdField_a_of_type_AndroidViewView = localView;
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369848));
    if ((localViewHolder.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)localViewHolder.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
    }
    localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131380681));
    localViewHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131364035));
    localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)localView.findViewById(2131363482));
    localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)localView.findViewById(2131363489));
    localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)localView.findViewById(2131380300));
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380297));
    localViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener2);
    localView.setOnClickListener(paramOnClickListener1);
    localView.setTag(localViewHolder);
    if (paramOnClickListener3 != null)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener3);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localView.setTag(-3, Integer.valueOf(AIOUtils.a(100.0F, paramContext.getResources())));
      return localView;
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localView.setTag(-3, null);
    return localView;
  }
  
  public static void a(RecommendTroopAdapter.ViewHolder paramViewHolder, RecommendTroopItem paramRecommendTroopItem, Drawable paramDrawable)
  {
    if ((paramViewHolder == null) || (paramRecommendTroopItem == null))
    {
      QLog.d("RecommendTroop", 1, "viewHolder == null || troopItem == null");
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecommendTroopItem.name);
    paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecommendTroopItem.name);
    if (paramRecommendTroopItem.activity > 0)
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramRecommendTroopItem.activity);
      paramDrawable = GroupViewAdapter.a(paramRecommendTroopItem);
      if ((paramDrawable == null) || (paramDrawable.size() <= 0)) {
        break label274;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setAutoCreateDistanceTextView(true);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramDrawable);
      label122:
      if ((!paramRecommendTroopItem.isJoined()) && (!paramRecommendTroopItem.hasRequestJoin)) {
        break label298;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      if (!paramRecommendTroopItem.hasRequestJoin) {
        break label286;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699384);
      label160:
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.a(60.0F));
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.a(29.0F));
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(0, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), 0, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      label215:
      if (!TextUtils.isEmpty(paramRecommendTroopItem.intro)) {
        break label374;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(-1, paramRecommendTroopItem);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(-1, paramRecommendTroopItem);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(-1, paramRecommendTroopItem);
      return;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
      break;
      label274:
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
      break label122;
      label286:
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699385);
      break label160;
      label298:
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699383);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
      int i = ViewUtils.a(16.0F);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(i, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), i, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
      break label215;
      label374:
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new QQText(paramRecommendTroopItem.intro, 11, 16));
    }
  }
  
  protected abstract int a();
  
  public RecommendTroopItem a(int paramInt)
  {
    return (RecommendTroopItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    RecommendTroopItem localRecommendTroopItem;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
    } while (!paramString.equals(localRecommendTroopItem.uin));
    localRecommendTroopItem.hasRequestJoin = true;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroop", 2, "updateJoinStatus, troopUin: " + paramString);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<RecommendTroopItem> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  protected abstract int b();
  
  protected void b(RecommendTroopItem paramRecommendTroopItem) {}
  
  protected abstract int c();
  
  protected void c(RecommendTroopItem paramRecommendTroopItem) {}
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof RecommendTroopAdapter.ViewHolder))) {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
    }
    for (;;)
    {
      RecommendTroopAdapter.ViewHolder localViewHolder = (RecommendTroopAdapter.ViewHolder)paramView.getTag();
      RecommendTroopItem localRecommendTroopItem = a(paramInt);
      a(localViewHolder, localRecommendTroopItem, FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localRecommendTroopItem.uin));
      c(localRecommendTroopItem);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapter
 * JD-Core Version:    0.7.0.1
 */