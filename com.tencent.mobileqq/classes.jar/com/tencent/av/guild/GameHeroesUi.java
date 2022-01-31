package com.tencent.av.guild;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo.HeroDetail;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.stageview.MemberEffect;
import com.tencent.av.widget.stageview.StageEffectView.StageMember;
import com.tencent.qphone.base.util.QLog;
import jku;
import jkw;

public class GameHeroesUi
  implements jku
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext = null;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public SessionInfo.HeroDetail a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  GameHeroesProtocol jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol = null;
  StageEffectView.StageMember jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember = null;
  boolean jdField_a_of_type_Boolean = false;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup = null;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public Button c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public TextView c;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  TextView g;
  TextView h;
  TextView i;
  TextView j;
  TextView k;
  TextView l;
  TextView m;
  TextView n;
  TextView o;
  TextView p;
  TextView q;
  
  GameHeroesUi(VideoAppInterface paramVideoAppInterface, GuildMultiActivity paramGuildMultiActivity, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail = null;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isDevelopLevel()) {
      QLog.d("GameHeroesUi", 2, "GameHeroesUi init");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramGuildMultiActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol = new GameHeroesProtocol(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.a(this);
  }
  
  BitmapDrawable a()
  {
    BitmapDrawable localBitmapDrawable = null;
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130840309, (BitmapFactory.Options)localObject1);
    int i1 = ((BitmapFactory.Options)localObject1).outWidth / UITools.a(this.jdField_a_of_type_AndroidContentContext);
    int i2 = ((BitmapFactory.Options)localObject1).outHeight / UITools.b(this.jdField_a_of_type_AndroidContentContext);
    if (i1 < i2) {
      ((BitmapFactory.Options)localObject1).inSampleSize = i1;
    }
    for (;;)
    {
      if (((BitmapFactory.Options)localObject1).inSampleSize <= 0) {
        ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      }
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130840309, (BitmapFactory.Options)localObject1);
        if (localObject1 != null) {
          localBitmapDrawable = BitmapTools.a((Bitmap)localObject1, 20);
        }
        return localBitmapDrawable;
        ((BitmapFactory.Options)localObject1).inSampleSize = i2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameHeroesUi", 2, "bg = null !");
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new jkw(this));
    }
  }
  
  void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("GameHeroesUi", 2, "setShadeStatus uin :" + (String)localObject1 + ",pos" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup.getBackground() == null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(a());
    }
    localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366039);
    Object localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - 54);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366043)).setImageDrawable(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366042)).setContentDescription(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_AndroidContentResResources.getString(2131429338));
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366044);
    localObject2 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_b_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString))
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString.contains("%s "))) {
          break label365;
        }
        localObject1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString.replace("%s ", "");
      }
    }
    for (paramInt = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_Int;; paramInt = -1)
    {
      localTextView.setTextColor(paramInt);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setContentDescription((CharSequence)localObject1);
      localTextView.setTextSize(20.0F);
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail == null) || ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int > -2))) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
      label365:
      localObject1 = String.format(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString, new Object[] { localObject2 });
      break;
      localObject1 = localObject2;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((paramInt == 0) && (this.jdField_c_of_type_AndroidWidgetButton != null))
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      if (paramLong >= 30L)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559918);
        this.jdField_c_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429340));
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429340));
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429347));
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429347));
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131429339);
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429340));
  }
  
  void a(StageEffectView.StageMember paramStageMember, long paramLong1, SessionInfo.HeroDetail paramHeroDetail, int paramInt1, long paramLong2, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    String str;
    do
    {
      return;
      str = paramStageMember.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember = paramStageMember;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail = paramHeroDetail;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_Long = paramLong2;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equalsIgnoreCase(str);
      if (this.jdField_a_of_type_AndroidContentResResources == null) {
        d();
      }
    } while (this.jdField_a_of_type_AndroidContentResResources == null);
    f();
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int <= 0))
    {
      a(paramInt2);
      label98:
      if (!this.jdField_b_of_type_Boolean) {
        break label166;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.a(str, paramLong1, this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail);
      return;
      e();
      break label98;
      label166:
      g();
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  void b(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    g();
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    if (this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol != null)
    {
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.a(null);
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol = null;
    }
  }
  
  void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("GameHeroesUi", 2, "initUI");
    }
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366046));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366041));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366047));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366036));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetButton.getLayoutParams());
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366007));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366037));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366045));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366011));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366014));
    this.g = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366013));
    this.h = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366016));
    this.i = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366015));
    this.j = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366018));
    this.k = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366017));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366021));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366023));
    this.l = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366024));
    this.m = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366025));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366026));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366028));
    this.n = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366029));
    this.o = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366030));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366031));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366033));
    this.p = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366034));
    this.q = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366035));
  }
  
  public void e()
  {
    ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366009)).setImageDrawable(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    String str2 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_b_of_type_JavaLangString;
    ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366008)).setContentDescription(str2 + this.jdField_a_of_type_AndroidContentResResources.getString(2131429338));
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366010);
    String str1;
    if (this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString))
      {
        if ((!TextUtils.isEmpty(str2)) || (!this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString.contains("%s "))) {
          break label619;
        }
        str1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString.replace("%s ", "");
      }
    }
    for (int i1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_Int;; i1 = -1)
    {
      localTextView.setTextColor(i1);
      localTextView.setText(str1);
      localTextView.setContentDescription(str1);
      if (this.jdField_b_of_type_AndroidViewViewGroup.getBackground() == null) {
        this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundDrawable(a());
      }
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_JavaLangString + "：" + this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_JavaLangString);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.c);
        this.g.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.d);
        this.h.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.e);
        this.i.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.f);
        this.j.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.g);
        this.k.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.h);
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap == null) {
          break label715;
        }
      }
      label455:
      label715:
      for (i1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length;; i1 = 0)
      {
        if ((i1 > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] != null))
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0]);
          this.l.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfJavaLangString[0]);
          this.m.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_ArrayOfJavaLangString[0]);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366019).setVisibility(0);
          if ((i1 <= 1) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[1] == null)) {
            break label685;
          }
          this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[1]);
          this.n.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfJavaLangString[1]);
          this.o.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_ArrayOfJavaLangString[1]);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((i1 <= 2) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[2] == null)) {
            break label704;
          }
          this.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[2]);
          this.p.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfJavaLangString[2]);
          this.q.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_ArrayOfJavaLangString[2]);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          return;
          label619:
          str1 = String.format(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString, new Object[] { str2 });
          break;
          this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366019).setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          break label455;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          break label528;
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        }
      }
      label528:
      label685:
      label704:
      str1 = str2;
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int <= 0))
    {
      this.jdField_c_of_type_AndroidWidgetButton = this.jdField_a_of_type_AndroidWidgetButton;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      this.jdField_c_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton = this.jdField_b_of_type_AndroidWidgetButton;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    this.jdField_c_of_type_AndroidWidgetImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public void g()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject1 = localObject2;
    }
    while (localObject1 != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840080);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559919);
      this.jdField_c_of_type_AndroidWidgetButton.setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_c_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429345));
      this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429345));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429344));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429344));
      continue;
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840084);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429343));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429343));
      continue;
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840082);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429346));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429346));
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_a_of_type_Long >= 30L)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429340));
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429340));
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559918);
        this.jdField_c_of_type_AndroidWidgetButton.setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        localObject1 = localObject2;
        break;
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131429347));
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429347));
        this.jdField_c_of_type_AndroidWidgetButton.setText(2131429339);
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429340));
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.guild.GameHeroesUi
 * JD-Core Version:    0.7.0.1
 */