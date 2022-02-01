package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import bcst;
import bglp;
import bgpa;
import bkho;
import bkhw;
import bkhy;
import bkif;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mxl;
import myc;
import myg;
import nak;
import nal;
import nan;
import nbb;
import nbc;
import nbe;
import nbf;
import nbg;
import nbh;
import nbi;

public class SeatView
  extends GridView
  implements bkhw, bkhy, nbc, nbi
{
  protected bkho a;
  protected Player a;
  public nbb a;
  protected nbh a;
  protected boolean a;
  protected boolean b;
  
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
    this.jdField_a_of_type_Nbb = new nbf(this);
  }
  
  private void a(Player paramPlayer)
  {
    bgpa localbgpa = bglp.a(getContext(), 230);
    if (localbgpa != null)
    {
      localbgpa.setMessage(2131690290);
      paramPlayer = new nbg(this, paramPlayer);
      localbgpa.setPositiveButton(2131694081, paramPlayer);
      localbgpa.setNegativeButton(2131690582, paramPlayer);
      localbgpa.show();
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Bkho == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
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
        this.jdField_a_of_type_Bkho.a(null);
        this.jdField_a_of_type_Bkho.dismiss();
        this.jdField_a_of_type_Bkho = null;
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
      this.jdField_a_of_type_Nbb.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_Nbb.c(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    }
  }
  
  public RectF a()
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
  
  public List<nan> a()
  {
    ArrayList localArrayList = new ArrayList();
    RoomInfo localRoomInfo = mxl.a().a().a();
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = ((MemberItemView)localObject).a(this.jdField_a_of_type_Nbb);
        if ((localObject != null) && (localRoomInfo.getPlayer(String.valueOf(((nan)localObject).a)) != null)) {
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
  
  public nbb a()
  {
    return this.jdField_a_of_type_Nbb;
  }
  
  public void a()
  {
    myc localmyc = mxl.a().a();
    if ((localmyc != null) && (localmyc.a() != null)) {}
    for (int i = localmyc.a().a;; i = 0)
    {
      if (mxl.a().a()) {}
      for (int j = 1;; j = 2)
      {
        bcst.b(null, "dc00898", "", "", "0X800B0A6", "0X800B0A6", i, 0, "" + j, "", "", "");
        this.jdField_a_of_type_Nbb.a();
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
  
  public void a(myc parammyc)
  {
    this.jdField_a_of_type_Nbh.a(this.jdField_a_of_type_Nbb.a(), this.jdField_a_of_type_Nbb.a());
    this.jdField_a_of_type_Nbh.notifyDataSetChanged();
  }
  
  public void a(nal paramnal)
  {
    this.jdField_a_of_type_Nbb.a(paramnal);
    setNumColumns(4);
    this.jdField_a_of_type_Nbh = new nbh(getContext(), this.jdField_a_of_type_Nbb);
    this.jdField_a_of_type_Nbh.a(this.jdField_a_of_type_Nbb.a(), this.jdField_a_of_type_Nbb.a());
    setAdapter(this.jdField_a_of_type_Nbh);
    this.jdField_a_of_type_Nbh.a(this);
  }
  
  public void a(nbe paramnbe)
  {
    if ((paramnbe == null) || (paramnbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramnbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
    this.jdField_a_of_type_Boolean = mxl.a().a();
    this.b = false;
    if (mxl.a().a() != null)
    {
      paramnbe = mxl.a().a().getAccount();
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin, paramnbe)) {
        this.b = true;
      }
    }
    this.jdField_a_of_type_Bkho = ((bkho)bkif.a(getContext(), null));
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      this.jdField_a_of_type_Bkho.b(2131690228);
    }
    this.jdField_a_of_type_Bkho.b(2131690232);
    if (!this.b) {
      this.jdField_a_of_type_Bkho.b(2131690227);
    }
    this.jdField_a_of_type_Bkho.c(2131690582);
    this.jdField_a_of_type_Bkho.a(this);
    this.jdField_a_of_type_Bkho.a(this);
    try
    {
      this.jdField_a_of_type_Bkho.show();
      bcst.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", "" + mxl.a().a().a(), "", "");
      return;
    }
    catch (Exception paramnbe)
    {
      for (;;)
      {
        QLog.e("SeatView", 1, "onMemberItemClick error:", paramnbe);
      }
    }
  }
  
  public RectF b()
  {
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof AddMemberItemView))
      {
        localObject = (AddMemberItemView)localObject;
        int[] arrayOfInt = new int[2];
        nak.a((View)localObject, arrayOfInt);
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
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    if (this.jdField_a_of_type_Bkho == null) {
      return;
    }
    this.jdField_a_of_type_Bkho.a(null);
    this.jdField_a_of_type_Bkho = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatView
 * JD-Core Version:    0.7.0.1
 */