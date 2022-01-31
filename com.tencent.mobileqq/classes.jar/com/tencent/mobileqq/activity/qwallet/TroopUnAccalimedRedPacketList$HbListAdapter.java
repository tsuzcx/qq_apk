package com.tencent.mobileqq.activity.qwallet;

import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.aio.item.QQWalletTroopHbItem;
import java.util.ArrayList;
import java.util.List;
import xid;
import xie;
import xif;

public class TroopUnAccalimedRedPacketList$HbListAdapter
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList;
  
  TroopUnAccalimedRedPacketList$HbListAdapter(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public xie a(ViewGroup paramViewGroup, int paramInt)
  {
    return new xie(this, new xif(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList, this.jdField_a_of_type_AndroidContentContext, new QQWalletTroopHbItem(TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), this.jdField_a_of_type_AndroidContentContext, TroopUnAccalimedRedPacketList.a(), TroopUnAccalimedRedPacketList.a(), TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList))));
  }
  
  void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    int i = 0;
    label22:
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      RedPackGrapInfo localRedPackGrapInfo = (RedPackGrapInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localRedPackGrapInfo == null) || (!localRedPackGrapInfo.sBiilNo.equals(paramString))) {}
    }
    for (;;)
    {
      int j = i;
      if (i == this.jdField_a_of_type_JavaUtilList.size()) {
        j = i - 1;
      }
      this.jdField_a_of_type_JavaUtilList.remove(j);
      notifyItemRemoved(j);
      notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size());
      if (TroopUnAccalimedRedPacketList.a() == null) {
        break;
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (TroopUnAccalimedRedPacketList.a() == null) {
          break;
        }
        TroopUnAccalimedRedPacketList.a().dismiss();
        return;
        i += 1;
        break label22;
      }
      TroopUnAccalimedRedPacketList.a().postDelayed(new xid(this), 300L);
      return;
      i = 0;
    }
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(xie paramxie, int paramInt)
  {
    xif localxif = paramxie.a;
    paramxie = (RedPackGrapInfo)this.jdField_a_of_type_JavaUtilList.get(paramxie.getPosition());
    if (paramxie == null) {
      return;
    }
    localxif.a(paramxie);
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbListAdapter
 * JD-Core Version:    0.7.0.1
 */