package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.qphone.base.util.QLog;
import mxz;
import mzl;
import naf;
import ncp;
import ncs;
import ndt;
import ndv;
import ndw;

public class MemberItemView
  extends RelativeLayout
{
  public ImageView a;
  public TextView a;
  public CoverRoundCornerRelativeLayout a;
  public TalkingEffectLayout a;
  public ndw a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  
  public MemberItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MemberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MemberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public RectF a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Ndw == null) || (this.jdField_a_of_type_Ndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      localObject = null;
    }
    RectF localRectF;
    do
    {
      return localObject;
      localObject = new int[2];
      ncp.a(this, (int[])localObject);
      localRectF = new RectF();
      localRectF.left = localObject[0];
      localRectF.top = localObject[1];
      localRectF.right = (localRectF.left + getMeasuredWidth());
      localRectF.bottom = (localRectF.top + getMeasuredHeight());
      localObject = localRectF;
    } while (!QLog.isColorLevel());
    QLog.i("MemberItemView", 2, "getPlayerHeadViewRect rectF:" + localRectF);
    return localRectF;
  }
  
  public ncs a(ndt paramndt)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Ndw == null) || (this.jdField_a_of_type_Ndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return null;
    }
    ncs localncs = new ncs();
    int[] arrayOfInt = new int[2];
    String str = this.jdField_a_of_type_Ndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin;
    ncp.a(this.jdField_c_of_type_AndroidWidgetImageView, arrayOfInt);
    localncs.jdField_a_of_type_Int = arrayOfInt[0];
    localncs.jdField_b_of_type_Int = arrayOfInt[1];
    localncs.jdField_c_of_type_Int = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localncs.d = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredHeight();
    localncs.jdField_a_of_type_Long = Long.valueOf(str).longValue();
    paramndt = paramndt.a(str);
    boolean bool1 = bool2;
    if (paramndt != null)
    {
      bool1 = bool2;
      if (paramndt.hasCameraVideo()) {
        bool1 = true;
      }
    }
    localncs.jdField_a_of_type_Boolean = bool1;
    paramndt = mzl.a().a();
    if ((bool1) && (paramndt.b(str))) {
      localncs.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MemberItemView", 2, "getVideoDisplayInfo info:" + localncs.toString());
      }
      return localncs;
      if (paramndt.c(str)) {
        localncs.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371615));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376824));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376825));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372449));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368177));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376008));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout = ((TalkingEffectLayout)findViewById(2131378214));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setAnimatorListener(new ndv(this));
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout = ((CoverRoundCornerRelativeLayout)findViewById(2131378916));
    float f = ncp.s * 24 / 180;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setRadius(getResources().getColor(2131165342), f);
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setPressCoverColor(1073741824);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.getLayoutParams();
    localLayoutParams.width = ncp.s;
    localLayoutParams.height = ncp.s;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.getLayoutParams();
    localLayoutParams.width = ncp.s;
    localLayoutParams.height = ncp.s;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(mxz parammxz, ndw paramndw, ndt paramndt)
  {
    if ((paramndw == null) || (paramndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) || (mzl.a().a() == null)) {}
    label141:
    label159:
    label418:
    label562:
    label597:
    for (;;)
    {
      return;
      naf localnaf = mzl.a().a();
      Player localPlayer = paramndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
      this.jdField_a_of_type_Ndw = paramndw;
      String str;
      int i;
      boolean bool1;
      label120:
      boolean bool2;
      int j;
      if (TextUtils.isEmpty(localPlayer.nick))
      {
        str = localPlayer.uin;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        i = localnaf.a(localPlayer.uin);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
        paramndt = paramndt.a(String.valueOf(localPlayer.uin));
        if ((paramndt == null) || (!paramndt.hasCameraVideo())) {
          break label383;
        }
        bool1 = true;
        if ((!bool1) || (!localnaf.b(localPlayer.uin))) {
          break label389;
        }
        bool2 = true;
        if ((!bool1) || (bool2)) {
          break label395;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(null);
        if (localPlayer.isHost())
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838736);
        }
        j = mzl.a().a().a();
        if ((j != 0) && (j != 10)) {
          break label418;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (j != 0) {
          break label562;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (localPlayer.status != 0) {
          break label516;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690367);
        if (!localPlayer.isHost()) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label597;
        }
        QLog.i("MemberItemView", 2, "update player:" + localPlayer + " hasCameraVideo:" + bool1 + " isBigVideo:" + bool2 + " gameStatus:" + j + " iScore:" + i + " player:" + localPlayer);
        return;
        str = localPlayer.nick;
        break;
        label383:
        bool1 = false;
        break label120;
        bool2 = false;
        break label141;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(parammxz.a(String.valueOf(localPlayer.uin), (byte)1));
        break label159;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        switch (paramndw.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838738);
          break;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838739);
          break;
        case 2: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838740);
          break;
        case 3: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838741);
          break;
          if (!localPlayer.isHost())
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838737);
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          continue;
          if (!localPlayer.isHost()) {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MemberItemView", 2, "playSpeakingAnim isSpeaking = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.b();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_Ndw != null) && (this.jdField_a_of_type_Ndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_Ndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setIsPressed(isPressed());
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.MemberItemView
 * JD-Core Version:    0.7.0.1
 */