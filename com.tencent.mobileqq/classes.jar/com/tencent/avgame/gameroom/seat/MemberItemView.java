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
import mxo;
import myk;
import mze;
import nbo;
import nbr;
import nco;
import ncq;
import ncr;

public class MemberItemView
  extends RelativeLayout
{
  public ImageView a;
  public TextView a;
  public CoverRoundCornerRelativeLayout a;
  public TalkingEffectLayout a;
  public ncr a;
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
    if ((this.jdField_a_of_type_Ncr == null) || (this.jdField_a_of_type_Ncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      localObject = null;
    }
    RectF localRectF;
    do
    {
      return localObject;
      localObject = new int[2];
      nbo.a(this, (int[])localObject);
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
  
  public nbr a(nco paramnco)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Ncr == null) || (this.jdField_a_of_type_Ncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return null;
    }
    nbr localnbr = new nbr();
    int[] arrayOfInt = new int[2];
    String str = this.jdField_a_of_type_Ncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin;
    nbo.a(this.jdField_c_of_type_AndroidWidgetImageView, arrayOfInt);
    localnbr.jdField_a_of_type_Int = arrayOfInt[0];
    localnbr.jdField_b_of_type_Int = arrayOfInt[1];
    localnbr.jdField_c_of_type_Int = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localnbr.d = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredHeight();
    localnbr.jdField_a_of_type_Long = Long.valueOf(str).longValue();
    paramnco = paramnco.a(str);
    boolean bool1 = bool2;
    if (paramnco != null)
    {
      bool1 = bool2;
      if (paramnco.hasCameraVideo()) {
        bool1 = true;
      }
    }
    localnbr.jdField_a_of_type_Boolean = bool1;
    paramnco = myk.a().a();
    if ((bool1) && (paramnco.b(str))) {
      localnbr.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MemberItemView", 2, "getVideoDisplayInfo info:" + localnbr.toString());
      }
      return localnbr;
      if (paramnco.c(str)) {
        localnbr.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371647));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377073));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377074));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372481));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368148));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376242));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout = ((TalkingEffectLayout)findViewById(2131378447));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setAnimatorListener(new ncq(this));
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout = ((CoverRoundCornerRelativeLayout)findViewById(2131379146));
    float f = nbo.w * 24 / 180;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setRadius(getResources().getColor(2131165334), f);
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setPressCoverColor(1073741824);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.getLayoutParams();
    localLayoutParams.width = nbo.w;
    localLayoutParams.height = nbo.w;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setLayoutParams(localLayoutParams);
    int i = nbo.w * 16 / 180;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setPadding(i, i, i, i);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.getLayoutParams();
    localLayoutParams.width = nbo.w;
    localLayoutParams.height = nbo.w;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(mxo parammxo, ncr paramncr, nco paramnco)
  {
    if ((paramncr == null) || (paramncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) || (myk.a().a() == null)) {}
    label141:
    label159:
    label418:
    label562:
    label597:
    for (;;)
    {
      return;
      mze localmze = myk.a().a();
      Player localPlayer = paramncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
      this.jdField_a_of_type_Ncr = paramncr;
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
        i = localmze.a(localPlayer.uin);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
        paramnco = paramnco.a(String.valueOf(localPlayer.uin));
        if ((paramnco == null) || (!paramnco.hasCameraVideo())) {
          break label383;
        }
        bool1 = true;
        if ((!bool1) || (!localmze.b(localPlayer.uin))) {
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
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838706);
        }
        j = myk.a().a().a();
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690328);
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(parammxo.a(String.valueOf(localPlayer.uin), (byte)1));
        break label159;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        switch (paramncr.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838708);
          break;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838709);
          break;
        case 2: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838710);
          break;
        case 3: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838711);
          break;
          if (!localPlayer.isHost())
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838707);
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
    return (this.jdField_a_of_type_Ncr != null) && (this.jdField_a_of_type_Ncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_Ncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
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