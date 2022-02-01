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
import mwp;
import mxl;
import myc;
import nak;
import nan;
import nbb;
import nbd;
import nbe;

public class MemberItemView
  extends RelativeLayout
{
  public ImageView a;
  public TextView a;
  public CoverRoundCornerRelativeLayout a;
  public TalkingEffectLayout a;
  public nbe a;
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
    if ((this.jdField_a_of_type_Nbe == null) || (this.jdField_a_of_type_Nbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      localObject = null;
    }
    RectF localRectF;
    do
    {
      return localObject;
      localObject = new int[2];
      nak.a(this, (int[])localObject);
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
  
  public nan a(nbb paramnbb)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Nbe == null) || (this.jdField_a_of_type_Nbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return null;
    }
    nan localnan = new nan();
    int[] arrayOfInt = new int[2];
    String str = this.jdField_a_of_type_Nbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin;
    nak.a(this.jdField_c_of_type_AndroidWidgetImageView, arrayOfInt);
    localnan.jdField_a_of_type_Int = arrayOfInt[0];
    localnan.jdField_b_of_type_Int = arrayOfInt[1];
    localnan.jdField_c_of_type_Int = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localnan.d = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredHeight();
    localnan.jdField_a_of_type_Long = Long.valueOf(str).longValue();
    paramnbb = paramnbb.a(str);
    boolean bool1 = bool2;
    if (paramnbb != null)
    {
      bool1 = bool2;
      if (paramnbb.hasCameraVideo()) {
        bool1 = true;
      }
    }
    localnan.jdField_a_of_type_Boolean = bool1;
    paramnbb = mxl.a().a();
    if ((bool1) && (paramnbb.b(str))) {
      localnan.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MemberItemView", 2, "getVideoDisplayInfo info:" + localnan.toString());
      }
      return localnan;
      if (paramnbb.c(str)) {
        localnan.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371539));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376934));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376935));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372368));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368076));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376102));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout = ((TalkingEffectLayout)findViewById(2131378290));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setAnimatorListener(new nbd(this));
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout = ((CoverRoundCornerRelativeLayout)findViewById(2131378982));
    float f = nak.s * 24 / 180;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setRadius(getResources().getColor(2131165334), f);
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setPressCoverColor(1073741824);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.getLayoutParams();
    localLayoutParams.width = nak.s;
    localLayoutParams.height = nak.s;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setLayoutParams(localLayoutParams);
    int i = nak.s * 16 / 180;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setPadding(i, i, i, i);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.getLayoutParams();
    localLayoutParams.width = nak.s;
    localLayoutParams.height = nak.s;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(mwp parammwp, nbe paramnbe, nbb paramnbb)
  {
    if ((paramnbe == null) || (paramnbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) || (mxl.a().a() == null)) {}
    label141:
    label159:
    label418:
    label562:
    label597:
    for (;;)
    {
      return;
      myc localmyc = mxl.a().a();
      Player localPlayer = paramnbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
      this.jdField_a_of_type_Nbe = paramnbe;
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
        i = localmyc.a(localPlayer.uin);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
        paramnbb = paramnbb.a(String.valueOf(localPlayer.uin));
        if ((paramnbb == null) || (!paramnbb.hasCameraVideo())) {
          break label383;
        }
        bool1 = true;
        if ((!bool1) || (!localmyc.b(localPlayer.uin))) {
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
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838684);
        }
        j = mxl.a().a().a();
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690323);
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(parammwp.a(String.valueOf(localPlayer.uin), (byte)1));
        break label159;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        switch (paramnbe.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838686);
          break;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838687);
          break;
        case 2: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838688);
          break;
        case 3: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838689);
          break;
          if (!localPlayer.isHost())
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838685);
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
    return (this.jdField_a_of_type_Nbe != null) && (this.jdField_a_of_type_Nbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_Nbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
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