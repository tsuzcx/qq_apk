package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import bdla;
import bhdj;
import bkzi;
import bkzq;
import bkzs;
import bkzz;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import nfc;
import nfv;
import nga;
import nin;
import nio;
import niq;
import nju;
import njv;
import nkd;
import nke;
import nkf;
import nkg;
import nkh;

public class SeatView
  extends GridView
  implements bkzq, bkzs, njv, nkh
{
  protected bkzi a;
  protected Player a;
  public nju a;
  protected nkg a;
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
    this.jdField_a_of_type_Nju = new nke(this);
  }
  
  private void a(Player paramPlayer)
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(getContext(), 230);
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.setMessage(2131690357);
      paramPlayer = new nkf(this, paramPlayer);
      localQQCustomDialog.setPositiveButton(2131694399, paramPlayer);
      localQQCustomDialog.setNegativeButton(2131690697, paramPlayer);
      localQQCustomDialog.show();
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Bkzi == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
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
        this.jdField_a_of_type_Bkzi.a(null);
        this.jdField_a_of_type_Bkzi.dismiss();
        this.jdField_a_of_type_Bkzi = null;
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
      this.jdField_a_of_type_Nju.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_Nju.c(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
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
        nin.a((View)localObject, arrayOfInt);
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
  
  public List<niq> a()
  {
    ArrayList localArrayList = new ArrayList();
    RoomInfo localRoomInfo = nfc.a().a().a();
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = ((MemberItemView)localObject).a(this.jdField_a_of_type_Nju);
        if ((localObject != null) && (localRoomInfo.getPlayer(String.valueOf(((niq)localObject).a)) != null)) {
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
  
  public nju a()
  {
    return this.jdField_a_of_type_Nju;
  }
  
  public void a()
  {
    nfv localnfv = nfc.a().a();
    if ((localnfv != null) && (localnfv.a() != null)) {}
    for (int i = localnfv.a().a;; i = 0)
    {
      if (nfc.a().a()) {}
      for (int j = 1;; j = 2)
      {
        bdla.b(null, "dc00898", "", "", "0X800B0A6", "0X800B0A6", i, 0, "" + j, "", "", "");
        this.jdField_a_of_type_Nju.a();
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
  
  public void a(nfv paramnfv)
  {
    this.jdField_a_of_type_Nkg.a(this.jdField_a_of_type_Nju.a(), this.jdField_a_of_type_Nju.a());
    this.jdField_a_of_type_Nkg.notifyDataSetChanged();
  }
  
  public void a(nio paramnio)
  {
    this.jdField_a_of_type_Nju.a(paramnio);
    setNumColumns(4);
    this.jdField_a_of_type_Nkg = new nkg(getContext(), this.jdField_a_of_type_Nju);
    this.jdField_a_of_type_Nkg.a(this.jdField_a_of_type_Nju.a(), this.jdField_a_of_type_Nju.a());
    setAdapter(this.jdField_a_of_type_Nkg);
    this.jdField_a_of_type_Nkg.a(this);
  }
  
  public void a(nkd paramnkd)
  {
    if ((paramnkd == null) || (paramnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
    this.jdField_a_of_type_Boolean = nfc.a().a();
    this.b = false;
    if (nfc.a().a() != null)
    {
      paramnkd = nfc.a().a().getAccount();
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin, paramnkd)) {
        this.b = true;
      }
    }
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(getContext(), null));
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      this.jdField_a_of_type_Bkzi.b(2131690297);
    }
    this.jdField_a_of_type_Bkzi.b(2131690300);
    if (!this.b) {
      this.jdField_a_of_type_Bkzi.b(2131690296);
    }
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.a(this);
    this.jdField_a_of_type_Bkzi.a(this);
    try
    {
      this.jdField_a_of_type_Bkzi.show();
      bdla.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", "" + nfc.a().a().a(), "", "");
      return;
    }
    catch (Exception paramnkd)
    {
      for (;;)
      {
        QLog.e("SeatView", 1, "onMemberItemClick error:", paramnkd);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
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
    if (this.jdField_a_of_type_Bkzi == null) {
      return;
    }
    this.jdField_a_of_type_Bkzi.a(null);
    this.jdField_a_of_type_Bkzi = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatView
 * JD-Core Version:    0.7.0.1
 */