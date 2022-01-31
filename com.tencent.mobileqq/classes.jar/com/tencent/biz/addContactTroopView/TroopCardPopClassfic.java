package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.GridViewForScrollView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import kld;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopItem;
import tencent.im.troop_search_popclassifc.popclassifc.TitleBar;
import tencent.im.troop_search_searchtab.searchtab.Card;

public class TroopCardPopClassfic
  extends BaseTroopCardView
  implements View.OnClickListener
{
  protected BaseAdapter a;
  protected ImageView a;
  protected TextView a;
  protected GridViewForScrollView a;
  public popclassifc.PopCard a;
  
  public TroopCardPopClassfic(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = new kld(this);
  }
  
  private void a(int paramInt)
  {
    popclassifc.PopItem localPopItem = (popclassifc.PopItem)((popclassifc.PopCard)this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.get()).rpt_pop_items.get(paramInt);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", localPopItem.str_transfer_url.get());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_hotcal", 0, 0, "", localPopItem.str_desc.get(), "", "");
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366399));
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView = ((GridViewForScrollView)findViewById(2131366401));
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366400));
  }
  
  public void a()
  {
    setContentView(2130969417);
    f();
  }
  
  public void a(searchtab.Card paramCard) {}
  
  public void e()
  {
    super.e();
  }
  
  public void onClick(View paramView)
  {
    try
    {
      a(((TroopCardPopClassfic.ViewHolder)paramView.getTag()).a);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void setData(popclassifc.PopCard paramPopCard)
  {
    if (paramPopCard != null)
    {
      this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard = paramPopCard;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.title_bar.str_desc.get());
      int i = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 17.0F);
      int j = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 15.0F);
      paramPopCard = new LinearLayout.LayoutParams(i, i);
      paramPopCard.leftMargin = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramPopCard);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.title_bar.str_icon_url.get())) {
        break label128;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846197);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      return;
      label128:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.title_bar.str_icon_url.get(), null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic
 * JD-Core Version:    0.7.0.1
 */