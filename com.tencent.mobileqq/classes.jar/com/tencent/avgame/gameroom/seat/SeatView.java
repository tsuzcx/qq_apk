package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import bcef;
import bfur;
import bjnw;
import bjoe;
import bjog;
import bjon;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mzl;
import naf;
import nak;
import ncp;
import ncq;
import ncs;
import ndt;
import ndu;
import ndw;
import ndx;
import ndy;
import ndz;
import nea;

public class SeatView
  extends GridView
  implements bjoe, bjog, ndu, nea
{
  protected bjnw a;
  protected Player a;
  public ndt a;
  protected ndz a;
  protected boolean a;
  protected boolean b;
  protected boolean c;
  
  public SeatView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SeatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SeatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Ndt = new ndx(this);
  }
  
  private void a(Player paramPlayer)
  {
    QQCustomDialog localQQCustomDialog = bfur.a(getContext(), 230);
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.setMessage(2131690318);
      paramPlayer = new ndy(this, paramPlayer);
      localQQCustomDialog.setPositiveButton(2131694201, paramPlayer);
      localQQCustomDialog.setNegativeButton(2131690620, paramPlayer);
      localQQCustomDialog.show();
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Bjnw == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = paramInt;
      if (!this.b) {}
    }
    else
    {
      i = paramInt + 1;
    }
    switch (i)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bjnw.a(null);
        this.jdField_a_of_type_Bjnw.dismiss();
        this.jdField_a_of_type_Bjnw = null;
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_Ndt.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_Ndt.c(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    }
  }
  
  public RectF a()
  {
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof AddMemberItemView))
      {
        localObject = (AddMemberItemView)localObject;
        int[] arrayOfInt = new int[2];
        ncp.a((View)localObject, arrayOfInt);
        RectF localRectF = new RectF();
        localRectF.left = arrayOfInt[0];
        localRectF.top = arrayOfInt[1];
        localRectF.right = (localRectF.left + ((AddMemberItemView)localObject).getMeasuredWidth());
        float f = localRectF.top;
        localRectF.bottom = (((AddMemberItemView)localObject).getMeasuredHeight() + f);
        return localRectF;
      }
      i += 1;
    }
    return null;
  }
  
  public RectF a(long paramLong)
  {
    int i = 0;
    if (i < getChildCount())
    {
      localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = (MemberItemView)localObject;
        if (!((MemberItemView)localObject).a(String.valueOf(paramLong))) {}
      }
    }
    for (Object localObject = ((MemberItemView)localObject).a();; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SeatView", 2, "getPlayerHeadViewRect result:" + localObject);
      }
      return localObject;
      i += 1;
      break;
    }
  }
  
  public List<ncs> a()
  {
    ArrayList localArrayList = new ArrayList();
    RoomInfo localRoomInfo = mzl.a().a().a();
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = ((MemberItemView)localObject).a(this.jdField_a_of_type_Ndt);
        if ((localObject != null) && (localRoomInfo.getPlayer(String.valueOf(((ncs)localObject).a)) != null)) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SeatView", 2, "getMemberHeadViewDisplayInfoList infoList:" + localArrayList);
    }
    return localArrayList;
  }
  
  public ndt a()
  {
    return this.jdField_a_of_type_Ndt;
  }
  
  public void a()
  {
    naf localnaf = mzl.a().a();
    if ((localnaf != null) && (localnaf.a() != null)) {}
    for (int i = localnaf.a().a;; i = 0)
    {
      if (mzl.a().a()) {}
      for (int j = 1;; j = 2)
      {
        bcef.b(null, "dc00898", "", "", "0X800B0A6", "0X800B0A6", i, 0, "" + j, "", "", "");
        this.jdField_a_of_type_Ndt.a();
        this.c = true;
        return;
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    if (i < getChildCount())
    {
      localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = (MemberItemView)localObject;
        if (!((MemberItemView)localObject).a(String.valueOf(paramLong))) {}
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((MemberItemView)localObject).a(paramBoolean);
      }
      return;
      i += 1;
      break;
      localObject = null;
    }
  }
  
  public void a(naf paramnaf)
  {
    this.jdField_a_of_type_Ndz.a(this.jdField_a_of_type_Ndt.a(), this.jdField_a_of_type_Ndt.a());
    this.jdField_a_of_type_Ndz.notifyDataSetChanged();
  }
  
  public void a(ncq paramncq)
  {
    this.jdField_a_of_type_Ndt.a(paramncq);
    setNumColumns(4);
    this.jdField_a_of_type_Ndz = new ndz(getContext(), this.jdField_a_of_type_Ndt);
    this.jdField_a_of_type_Ndz.a(this.jdField_a_of_type_Ndt.a(), this.jdField_a_of_type_Ndt.a());
    setAdapter(this.jdField_a_of_type_Ndz);
    this.jdField_a_of_type_Ndz.a(this);
  }
  
  public void a(ndw paramndw)
  {
    if ((paramndw == null) || (paramndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
    this.jdField_a_of_type_Boolean = mzl.a().a();
    this.b = false;
    if (mzl.a().a() != null)
    {
      paramndw = mzl.a().a().getAccount();
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin, paramndw)) {
        this.b = true;
      }
    }
    this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(getContext(), null));
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      this.jdField_a_of_type_Bjnw.b(2131690259);
    }
    this.jdField_a_of_type_Bjnw.b(2131690262);
    if (!this.b) {
      this.jdField_a_of_type_Bjnw.b(2131690258);
    }
    this.jdField_a_of_type_Bjnw.c(2131690620);
    this.jdField_a_of_type_Bjnw.a(this);
    this.jdField_a_of_type_Bjnw.a(this);
    try
    {
      this.jdField_a_of_type_Bjnw.show();
      bcef.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", "" + mzl.a().a().a(), "", "");
      return;
    }
    catch (Exception paramndw)
    {
      for (;;)
      {
        QLog.e("SeatView", 1, "onMemberItemClick error:", paramndw);
      }
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public RectF b()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof AddMemberItemView)) {
        return ((AddMemberItemView)localView).a();
      }
      i += 1;
    }
    return null;
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    if (this.jdField_a_of_type_Bjnw == null) {
      return;
    }
    this.jdField_a_of_type_Bjnw.a(null);
    this.jdField_a_of_type_Bjnw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatView
 * JD-Core Version:    0.7.0.1
 */