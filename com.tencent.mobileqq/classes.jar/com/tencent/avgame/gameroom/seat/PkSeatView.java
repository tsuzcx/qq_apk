package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import bdla;
import bkzi;
import bkzq;
import bkzs;
import bkzz;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.PKDrawRes;
import com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgView;
import com.tencent.avgame.ui.RoundEmptyRectRelativeLayout;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ndl;
import nfc;
import nfv;
import nfw;
import nfz;
import ngl;
import nin;
import nio;
import niq;
import njl;
import nju;
import njv;
import nka;
import nkb;
import nkc;
import nkd;
import nke;
import nkj;
import nqa;
import nqf;

public class PkSeatView
  extends RoundEmptyRectRelativeLayout
  implements View.OnClickListener, bkzq, bkzs, njv
{
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new nkc(this));
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new nka(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected bkzi a;
  protected Player a;
  private PkMemberItemView jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
  private SurvivalSeatBgView jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView;
  protected ndl a;
  private nio jdField_a_of_type_Nio;
  public nju a;
  private nkd jdField_a_of_type_Nkd;
  private nkj jdField_a_of_type_Nkj;
  private nqa jdField_a_of_type_Nqa;
  protected boolean a;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new nkb(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private PkMemberItemView jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
  private nkd jdField_b_of_type_Nkd;
  private nqa jdField_b_of_type_Nqa;
  protected boolean b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  
  public PkSeatView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PkSeatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PkSeatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private String a(String paramString)
  {
    return "file:///" + ngl.c() + paramString;
  }
  
  private nkd a()
  {
    nkd localnkd = new nkd();
    localnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = new Player();
    localnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin = "0";
    localnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick = "loser";
    return localnkd;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ndl = ((ndl)nfc.a().a().a(2));
    this.jdField_a_of_type_Nju = new nke(this);
    View localView = View.inflate(getContext(), 2131558763, null);
    addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131558765, null);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView = ((PkMemberItemView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370844));
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView = ((PkMemberItemView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370848));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    ((ImageView)localView.findViewById(2131363290)).setImageBitmap(nqf.a("avgame_pk_member_blue@2x.png"));
    ((ImageView)localView.findViewById(2131363291)).setImageBitmap(nqf.a("avgame_pk_member_red@2x.png"));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363289));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(nqf.a("avgame_pk_logo_static@2x.png"));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363282));
    this.c = ((ImageView)localView.findViewById(2131363292));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.c.setVisibility(8);
    this.d = ((ImageView)localView.findViewById(2131363301));
    this.e = ((ImageView)localView.findViewById(2131363304));
    this.d.setImageBitmap(nqf.a("avgame_pk_member_bg_blue@2x.png"));
    this.e.setImageBitmap(nqf.a("avgame_pk_member_bg_red@2x.png"));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView = ((SurvivalSeatBgView)localView.findViewById(2131363302));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.setHorizontalSpacing(nin.x);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.setVerticalSpacing(nin.x);
    if (QLog.isColorLevel()) {
      QLog.d("PkSeatView", 2, "SurvivalSeatBgView seatBgItemWidth= " + nin.v + " seatBgItemGapH=" + nin.x + " seatBgItemMaxNum=" + nin.y + " seatBgViewHeight=" + nin.z + "seatBgViewHeight:" + nin.A);
    }
    this.jdField_a_of_type_Nkj = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.a();
    post(new PkSeatView.3(this));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    ApngImage.resumeAll();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mUseApngImage = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", 1);
    localURLDrawableOptions.mExtraInfo = localBundle;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(a(paramString), localURLDrawableOptions));
    paramImageView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    }
    for (;;)
    {
      b(paramBoolean);
      c(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(1));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    }
  }
  
  private void b()
  {
    Object localObject2 = this.jdField_a_of_type_Nju.a();
    this.jdField_a_of_type_Nkd = null;
    this.jdField_b_of_type_Nkd = null;
    if (localObject2 != null)
    {
      if (!((List)localObject2).isEmpty()) {
        break label144;
      }
      this.jdField_a_of_type_Nkd = new nkd();
      localObject1 = new Player();
      ((Player)localObject1).uin = nfc.a().a().getCurrentAccountUin();
      if ((((Player)localObject1).uin.equals(((Player)localObject1).nick)) || (TextUtils.isEmpty(((Player)localObject1).nick)))
      {
        localObject2 = new ArrayList(1);
        ((ArrayList)localObject2).add(((Player)localObject1).uin);
        localObject2 = (String)this.jdField_a_of_type_Ndl.a((List)localObject2).get(((Player)localObject1).uin);
        if (localObject2 != null) {
          ((Player)localObject1).nick = ((String)localObject2);
        }
      }
      this.jdField_a_of_type_Nkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
    }
    label144:
    do
    {
      return;
      if (((List)localObject2).size() == 1)
      {
        this.jdField_a_of_type_Nkd = ((nkd)((List)localObject2).get(0));
        return;
      }
    } while (((List)localObject2).size() <= 1);
    Object localObject1 = (nkd)((List)localObject2).get(0);
    localObject2 = (nkd)((List)localObject2).get(1);
    if (nfc.a().a().getCurrentAccountUin().equals(((nkd)localObject1).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin))
    {
      this.jdField_a_of_type_Nkd = ((nkd)localObject1);
      this.jdField_b_of_type_Nkd = ((nkd)localObject2);
      return;
    }
    this.jdField_a_of_type_Nkd = ((nkd)localObject2);
    this.jdField_b_of_type_Nkd = ((nkd)localObject1);
  }
  
  private void b(boolean paramBoolean)
  {
    ImageView localImageView;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(160.0F), ViewUtils.dpToPx(160.0F));
      if (!paramBoolean) {
        break label83;
      }
      localLayoutParams.leftMargin = ViewUtils.dpToPx(25.0F);
      label45:
      if (!paramBoolean) {
        break label97;
      }
    }
    label83:
    label97:
    for (int i = 3;; i = 5)
    {
      localLayoutParams.gravity = (i | 0x10);
      localImageView.setLayoutParams(localLayoutParams);
      a(localImageView, "avgame_pk_member_win@2x.png");
      return;
      localImageView = this.c;
      break;
      localLayoutParams.rightMargin = ViewUtils.dpToPx(25.0F);
      break label45;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.b();
    this.jdField_a_of_type_Nio.a().a(getResources().getString(2131690457), this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(), 60);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void c(boolean paramBoolean)
  {
    ImageView localImageView;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localImageView = this.c;
      localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(80.0F), ViewUtils.dpToPx(80.0F));
      localLayoutParams.bottomMargin = ViewUtils.dpToPx(9.0F);
      if (!paramBoolean) {
        break label94;
      }
      localLayoutParams.rightMargin = ViewUtils.dpToPx(65.0F);
      label56:
      if (!paramBoolean) {
        break label108;
      }
    }
    label94:
    label108:
    for (int i = 5;; i = 3)
    {
      localLayoutParams.gravity = (i | 0x10);
      localImageView.setLayoutParams(localLayoutParams);
      a(localImageView, "avgame_pk_member_fail@2x.png");
      return;
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      break;
      localLayoutParams.leftMargin = ViewUtils.dpToPx(65.0F);
      break label56;
    }
  }
  
  private void d()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_logo_apng@2x.png");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(0));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Bkzi == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    switch (paramInt)
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
      this.jdField_a_of_type_Nju.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_Nju.c(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    }
  }
  
  public RectF a()
  {
    return null;
  }
  
  public RectF a(long paramLong)
  {
    RectF localRectF = null;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(String.valueOf(paramLong))) {
      localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
    }
    while (!this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(String.valueOf(paramLong))) {
      return localRectF;
    }
    return this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public List<niq> a()
  {
    ArrayList localArrayList = new ArrayList();
    RoomInfo localRoomInfo = nfc.a().a().a();
    niq localniq = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Nju);
    if ((localniq != null) && (localRoomInfo.getPlayer(String.valueOf(localniq.a)) != null)) {
      localArrayList.add(localniq);
    }
    localniq = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Nju);
    if ((localniq != null) && (localRoomInfo.getPlayer(String.valueOf(localniq.a)) != null)) {
      localArrayList.add(localniq);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PkSeatView", 2, "getMemberHeadViewDisplayInfoList infoList:" + localArrayList);
    }
    return localArrayList;
  }
  
  public nju a()
  {
    return this.jdField_a_of_type_Nju;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    String str = String.valueOf(paramLong);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(str)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(paramBoolean);
    }
    while (!this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(str)) {
      return;
    }
    this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(paramBoolean);
  }
  
  public void a(nfv paramnfv)
  {
    int i = paramnfv.n();
    QLog.d("lgx", 2, "refreshUI " + i);
    if (4 > i) {
      b();
    }
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      Object localObject = paramnfv.c();
      if ((localObject != null) && (((List)localObject).size() > 0) && (this.jdField_a_of_type_Nkj != null))
      {
        this.jdField_a_of_type_Nkj.a((List)localObject);
        ((List)localObject).clear();
      }
      paramnfv = paramnfv.d();
      if ((paramnfv != null) && (paramnfv.size() > 0) && (this.jdField_a_of_type_Nkj != null))
      {
        this.jdField_a_of_type_Nkj.b(paramnfv);
        paramnfv.clear();
      }
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Ndl, this.jdField_a_of_type_Nkd, this.jdField_a_of_type_Nju, true);
      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Ndl, this.jdField_a_of_type_Nju, false);
      if (this.jdField_a_of_type_Int >= 4)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView.setAlpha(1.0F);
        this.jdField_a_of_type_Nkj.b();
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.d();
        this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.d();
      }
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        if (i != this.jdField_a_of_type_Int)
        {
          if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a()) {
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Ndl, this.jdField_a_of_type_Nkd, this.jdField_a_of_type_Nju, true);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.c();
          this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.c();
          if (this.jdField_a_of_type_Int >= 4)
          {
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.d();
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.d();
            if (this.jdField_a_of_type_Int == 8) {
              this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Nju, false);
            }
          }
          else
          {
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Nju, false);
            continue;
            if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a()) {
              this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Ndl, this.jdField_a_of_type_Nkd, this.jdField_a_of_type_Nju, true);
            }
            if (this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a()) {
              this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Ndl, this.jdField_b_of_type_Nkd, this.jdField_a_of_type_Nju, false);
            }
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Nkd);
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_b_of_type_Nkd);
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Ndl, this.jdField_a_of_type_Nkd, this.jdField_a_of_type_Nju, true);
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Ndl, this.jdField_b_of_type_Nkd, this.jdField_a_of_type_Nju, false);
            continue;
            this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_Ndl, this.jdField_b_of_type_Nkd, this.jdField_a_of_type_Nju, false);
            if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 0))
            {
              this.jdField_a_of_type_Nkj.a();
              this.jdField_a_of_type_Nkj.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgView);
              this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView);
              d();
              continue;
              PkMemberItemView localPkMemberItemView = this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView;
              ndl localndl = this.jdField_a_of_type_Ndl;
              if (this.jdField_b_of_type_Nkd == null) {}
              for (localObject = a();; localObject = this.jdField_b_of_type_Nkd)
              {
                localPkMemberItemView.a(localndl, (nkd)localObject, this.jdField_a_of_type_Nju, false);
                if (this.jdField_a_of_type_Int == i) {
                  break;
                }
                c();
                break;
              }
              if (this.jdField_a_of_type_Int != i) {
                if (paramnfv.a() == 2)
                {
                  this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PkSeatView.4(this), paramnfv.a().a.f * 1000);
                }
                else
                {
                  c();
                  continue;
                  if (this.jdField_a_of_type_Int == 3)
                  {
                    a(true);
                    localObject = paramnfv.a().pkDrawRes;
                    if ((localObject != null) && (((SurvivalPkResultInfo.PKDrawRes)localObject).isDraw))
                    {
                      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(((SurvivalPkResultInfo.PKDrawRes)localObject).selfCost, true);
                      this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(((SurvivalPkResultInfo.PKDrawRes)localObject).peerCost, false);
                      continue;
                      if ((this.jdField_a_of_type_Int == 3) && (!paramnfv.a().isBothClose))
                      {
                        a(false);
                        localObject = paramnfv.a().pkDrawRes;
                        if ((localObject != null) && (((SurvivalPkResultInfo.PKDrawRes)localObject).isDraw))
                        {
                          this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(((SurvivalPkResultInfo.PKDrawRes)localObject).selfCost, false);
                          this.jdField_b_of_type_ComTencentAvgameGameroomSeatPkMemberItemView.a(((SurvivalPkResultInfo.PKDrawRes)localObject).peerCost, true);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(nio paramnio)
  {
    this.jdField_a_of_type_Nio = paramnio;
    this.jdField_a_of_type_Nju.a(paramnio);
    paramnio = new ArrayList(1);
    paramnio.add(nfc.a().a().getCurrentAccountUin());
    this.jdField_a_of_type_Ndl.a(paramnio);
  }
  
  public void a(nkd paramnkd)
  {
    if ((paramnkd == null) || (paramnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
    this.jdField_a_of_type_Boolean = nfc.a().a();
    this.jdField_b_of_type_Boolean = false;
    if (nfc.a().a() != null)
    {
      paramnkd = nfc.a().a().getAccount();
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin, paramnkd)) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(getContext(), null));
    this.jdField_a_of_type_Bkzi.b(2131690300);
    if (!this.jdField_b_of_type_Boolean) {
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
        QLog.e("PkSeatView", 1, "onMemberItemClick error:", paramnkd);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PkSeatView", 2, "enableClipRectForPk enable:" + paramBoolean1 + " left:" + paramBoolean2);
    }
    nqa localnqa;
    if (paramBoolean2)
    {
      localnqa = this.jdField_a_of_type_Nqa;
      if (!paramBoolean1) {
        break label79;
      }
    }
    label79:
    for (paramBoolean1 = a(localnqa);; paramBoolean1 = b(localnqa))
    {
      if (paramBoolean1) {
        invalidate();
      }
      return;
      localnqa = this.jdField_b_of_type_Nqa;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this.jdField_b_of_type_Nkd);
      continue;
      a(this.jdField_a_of_type_Nkd);
    }
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
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkSeatView
 * JD-Core Version:    0.7.0.1
 */