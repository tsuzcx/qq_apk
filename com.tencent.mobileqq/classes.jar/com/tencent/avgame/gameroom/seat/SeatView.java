package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import bdll;
import bhlq;
import bhpc;
import blir;
import bliz;
import bljb;
import blji;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import myk;
import mze;
import mzj;
import nbo;
import nbp;
import nbr;
import nco;
import ncp;
import ncr;
import ncs;
import nct;
import ncu;
import ncv;

public class SeatView
  extends GridView
  implements bliz, bljb, ncp, ncv
{
  protected blir a;
  protected Player a;
  public nco a;
  protected ncu a;
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
    this.jdField_a_of_type_Nco = new ncs(this);
  }
  
  private void a(Player paramPlayer)
  {
    bhpc localbhpc = bhlq.a(getContext(), 230);
    if (localbhpc != null)
    {
      localbhpc.setMessage(2131690293);
      paramPlayer = new nct(this, paramPlayer);
      localbhpc.setPositiveButton(2131694098, paramPlayer);
      localbhpc.setNegativeButton(2131690580, paramPlayer);
      localbhpc.show();
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Blir == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
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
        this.jdField_a_of_type_Blir.a(null);
        this.jdField_a_of_type_Blir.dismiss();
        this.jdField_a_of_type_Blir = null;
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
      this.jdField_a_of_type_Nco.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_Nco.c(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
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
        nbo.a((View)localObject, arrayOfInt);
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
  
  public List<nbr> a()
  {
    ArrayList localArrayList = new ArrayList();
    RoomInfo localRoomInfo = myk.a().a().a();
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = ((MemberItemView)localObject).a(this.jdField_a_of_type_Nco);
        if ((localObject != null) && (localRoomInfo.getPlayer(String.valueOf(((nbr)localObject).a)) != null)) {
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
  
  public nco a()
  {
    return this.jdField_a_of_type_Nco;
  }
  
  public void a()
  {
    mze localmze = myk.a().a();
    if ((localmze != null) && (localmze.a() != null)) {}
    for (int i = localmze.a().a;; i = 0)
    {
      if (myk.a().a()) {}
      for (int j = 1;; j = 2)
      {
        bdll.b(null, "dc00898", "", "", "0X800B0A6", "0X800B0A6", i, 0, "" + j, "", "", "");
        this.jdField_a_of_type_Nco.a();
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
  
  public void a(mze parammze)
  {
    this.jdField_a_of_type_Ncu.a(this.jdField_a_of_type_Nco.a(), this.jdField_a_of_type_Nco.a());
    this.jdField_a_of_type_Ncu.notifyDataSetChanged();
  }
  
  public void a(nbp paramnbp)
  {
    this.jdField_a_of_type_Nco.a(paramnbp);
    setNumColumns(4);
    this.jdField_a_of_type_Ncu = new ncu(getContext(), this.jdField_a_of_type_Nco);
    this.jdField_a_of_type_Ncu.a(this.jdField_a_of_type_Nco.a(), this.jdField_a_of_type_Nco.a());
    setAdapter(this.jdField_a_of_type_Ncu);
    this.jdField_a_of_type_Ncu.a(this);
  }
  
  public void a(ncr paramncr)
  {
    if ((paramncr == null) || (paramncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
    this.jdField_a_of_type_Boolean = myk.a().a();
    this.b = false;
    if (myk.a().a() != null)
    {
      paramncr = myk.a().a().getAccount();
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin, paramncr)) {
        this.b = true;
      }
    }
    this.jdField_a_of_type_Blir = ((blir)blji.a(getContext(), null));
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      this.jdField_a_of_type_Blir.b(2131690234);
    }
    this.jdField_a_of_type_Blir.b(2131690237);
    if (!this.b) {
      this.jdField_a_of_type_Blir.b(2131690233);
    }
    this.jdField_a_of_type_Blir.c(2131690580);
    this.jdField_a_of_type_Blir.a(this);
    this.jdField_a_of_type_Blir.a(this);
    try
    {
      this.jdField_a_of_type_Blir.show();
      bdll.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", "" + myk.a().a().a(), "", "");
      return;
    }
    catch (Exception paramncr)
    {
      for (;;)
      {
        QLog.e("SeatView", 1, "onMemberItemClick error:", paramncr);
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
    if (this.jdField_a_of_type_Blir == null) {
      return;
    }
    this.jdField_a_of_type_Blir.a(null);
    this.jdField_a_of_type_Blir = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatView
 * JD-Core Version:    0.7.0.1
 */