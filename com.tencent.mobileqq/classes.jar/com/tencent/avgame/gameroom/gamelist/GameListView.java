package com.tencent.avgame.gameroom.gamelist;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apub;
import bcef;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mzl;
import mzo;
import naf;
import nak;
import ncp;
import ncq;
import nct;
import ncu;
import ncy;
import ncz;
import ndf;
import ndg;
import ndh;
import ndi;
import ndj;
import ndk;
import ndl;
import ndm;
import ndn;
import ngc;
import nje;
import njh;
import nji;

public class GameListView
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, nct, ndm
{
  private int jdField_a_of_type_Int;
  protected long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected Handler a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public View.OnTouchListener a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GameListView.1(this);
  public ncq a;
  private ncz jdField_a_of_type_Ncz;
  protected ndl a;
  public ngc a;
  protected boolean a;
  public View.OnTouchListener b;
  private TextView b;
  protected boolean b;
  public View.OnTouchListener c;
  public boolean c;
  public View.OnTouchListener d;
  protected boolean d;
  
  public GameListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ndf(this);
    this.jdField_b_of_type_AndroidViewView$OnTouchListener = new ndg(this);
    this.jdField_c_of_type_AndroidViewView$OnTouchListener = new ndh(this);
    this.jdField_d_of_type_AndroidViewView$OnTouchListener = new ndi(this);
    this.jdField_a_of_type_Ndl = new ncy(this);
  }
  
  private void a(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_Ngc.a().getLocationInWindow(arrayOfInt);
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.right = (localRectF.left + this.jdField_a_of_type_Ngc.a().getMeasuredWidth());
    localRectF.top = (arrayOfInt[1] - ViewUtils.dip2px(5.0F));
    localRectF.bottom = (localRectF.top + this.jdField_a_of_type_Ngc.a().getMeasuredHeight());
    this.jdField_a_of_type_Ncq.a().a(paramString, localRectF, paramInt);
  }
  
  private void a(nak paramnak)
  {
    if (paramnak == null) {
      return;
    }
    Object localObject = mzl.a();
    boolean bool;
    if (((mzl)localObject).a()) {
      if (((mzl)localObject).a(paramnak))
      {
        this.jdField_a_of_type_Ngc.a().setVisibility(0);
        localObject = njh.a("avgame_start_game_owner_normal@3x.png");
        if (localObject != null) {
          this.jdField_a_of_type_Ngc.a().setImageBitmap((Bitmap)localObject);
        }
        this.jdField_a_of_type_Ngc.a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        bool = a(0);
        this.jdField_a_of_type_Ngc.a().setTag(Integer.valueOf(0));
        nje.a().a("param_StepGameCanStart", 0);
        a(false, "");
        if (a(bool)) {
          a(getContext().getString(2131690305), 174);
        }
      }
    }
    for (;;)
    {
      b(paramnak);
      return;
      if (mzo.b(paramnak))
      {
        this.jdField_a_of_type_Ngc.a().setVisibility(4);
      }
      else
      {
        this.jdField_a_of_type_Ngc.a().setVisibility(0);
        this.jdField_a_of_type_Ngc.a().setOnTouchListener(null);
        Bitmap localBitmap = njh.a("avgame_start_game_owner_disabled@3x.png");
        if (localBitmap != null) {
          this.jdField_a_of_type_Ngc.a().setImageBitmap(localBitmap);
        }
        bool = a(1);
        this.jdField_a_of_type_Ngc.a().setTag(Integer.valueOf(1));
        a(true, getContext().getString(2131690305));
        if ((a(bool)) && (((mzl)localObject).a() > 1))
        {
          this.jdField_a_of_type_Ncq.a(getContext().getString(2131690309));
          continue;
          if (!mzo.b(paramnak))
          {
            this.jdField_a_of_type_Ngc.a().setVisibility(0);
            this.jdField_a_of_type_Ngc.a().setOnTouchListener(null);
            if (QLog.isColorLevel()) {
              QLog.i("GameListView", 2, "update() selfStatus:" + ((mzl)localObject).a().b());
            }
            if (((mzl)localObject).a().b() == 0)
            {
              setPrepareNorImage();
              this.jdField_a_of_type_Ngc.a().setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
              bool = a(2);
              a(false, "");
              if (a(bool)) {
                a(getContext().getString(2131690306), 174);
              }
              this.jdField_a_of_type_Ngc.a().setTag(Integer.valueOf(2));
            }
            else
            {
              setCancelPrepareNorImage();
              this.jdField_a_of_type_Ngc.a().setOnTouchListener(this.jdField_c_of_type_AndroidViewView$OnTouchListener);
              bool = a(3);
              a(true, getContext().getString(2131690306));
              if ((a(bool)) && (((mzl)localObject).b(paramnak))) {
                this.jdField_a_of_type_Ncq.a(getContext().getString(2131690311));
              }
              for (;;)
              {
                this.jdField_a_of_type_Ngc.a().setTag(Integer.valueOf(3));
                break;
                if (!((mzl)localObject).b(paramnak)) {
                  a(false, "");
                }
              }
            }
          }
          else
          {
            this.jdField_a_of_type_Ngc.a().setVisibility(4);
          }
        }
      }
    }
  }
  
  private void a(nak paramnak, int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int i = 0;
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramnak;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      i = 128;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 2;
    localMessage.obj = paramnak;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, i);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "hideToast isBubble: " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ncq.a().b(paramString);
      return;
    }
    this.jdField_a_of_type_Ncq.d();
  }
  
  private boolean a(int paramInt)
  {
    return (!(this.jdField_a_of_type_Ngc.a().getTag() instanceof Integer)) || (((Integer)this.jdField_a_of_type_Ngc.a().getTag()).intValue() != paramInt);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return paramBoolean;
    }
    this.jdField_a_of_type_Boolean = false;
    Activity localActivity = this.jdField_a_of_type_Ncq.a();
    if ((localActivity instanceof AVGameActivity)) {
      return ((AVGameActivity)localActivity).b();
    }
    return false;
  }
  
  private void b(nak paramnak)
  {
    if (paramnak == null) {
      return;
    }
    if (mzl.a().a()) {}
    for (String str1 = getResources().getString(2131690267);; str1 = getResources().getString(2131690268))
    {
      String str2 = str1;
      if (paramnak.a != null) {
        str2 = String.format(str1, new Object[] { paramnak.a });
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      return;
    }
  }
  
  private void d()
  {
    Object localObject = mzl.a();
    boolean bool = ((mzl)localObject).e();
    if (((mzl)localObject).a()) {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690339);
        if (!bool) {
          removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
        label55:
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (!bool) {
          break label161;
        }
      }
    }
    label161:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (bool) {}
      for (localObject = "avgame_match_stop_normal@2x.png";; localObject = "avgame_match_start_normal@2x.png")
      {
        localObject = njh.a((String)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_d_of_type_AndroidViewView$OnTouchListener);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (bool)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690341);
        break label55;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690339);
      break label55;
    }
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "handleStartOrReadyBtnClick opCode" + paramInt);
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      if (mzl.a().a()) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      int i = this.jdField_a_of_type_Ndl.a();
      a(this.jdField_a_of_type_Ncz.a(i), i);
      bcef.b(null, "dc00898", "", "", "0X800B0F7", "0X800B0F7", mzl.a().a().d(), 0, "" + paramInt, "" + mzl.a().a().a().players.size(), "", "");
      return;
      e();
      bcef.b(null, "dc00898", "", "", "0X800B029", "0X800B029", 0, 0, "", "" + mzl.a().a().a(), "", "");
      return;
      f();
      bcef.b(null, "dc00898", "", "", "0X800B028", "0X800B028", 0, 0, "", "" + mzl.a().a().a(), "", "");
      return;
    }
  }
  
  private void e()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Ndl.b();
  }
  
  private void f()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Ndl.a();
  }
  
  public Context a()
  {
    return getContext();
  }
  
  public ndl a()
  {
    return this.jdField_a_of_type_Ndl;
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Ncz.a(paramInt);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidAppDialog = ncu.a(getContext(), (nak)localObject);
    }
    this.jdField_c_of_type_Boolean = true;
    if (mzl.a().a()) {}
    for (localObject = "0X800B352";; localObject = "0X800B353")
    {
      bcef.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void a(naf paramnaf)
  {
    int i = paramnaf.a();
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "refreshUI  gameStatus:" + i + " currentItem: currentGameIndex:" + this.jdField_a_of_type_Ndl.a() + " showMatch:" + this.jdField_d_of_type_Boolean);
    }
    if (i == 0)
    {
      this.jdField_a_of_type_Ncz.a(this.jdField_a_of_type_Ndl.a(), this.jdField_a_of_type_Ndl.a(), this.jdField_a_of_type_Ndl.a());
      if (getVisibility() == 8) {
        a();
      }
      a(this.jdField_a_of_type_Ncz.a(this.jdField_a_of_type_Ndl.a()));
      d();
    }
    while (getVisibility() != 0) {
      return;
    }
    b();
    this.jdField_b_of_type_Boolean = false;
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(ncq paramncq, ngc paramngc)
  {
    this.jdField_a_of_type_Ncq = paramncq;
    this.jdField_a_of_type_Ngc = paramngc;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Ndl.a(paramncq);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367409));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367389));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690339);
    this.jdField_a_of_type_Ngc.a().setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131367407));
    this.jdField_a_of_type_Ncz = new ncz(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this, paramncq);
    this.jdField_a_of_type_Ncz.a(3);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new ndj(this));
    findViewById(2131363610).setOnClickListener(new ndk(this));
    paramncq = (ImageView)findViewById(2131367379);
    paramngc = njh.a("avgame_room_bg@2x.png");
    if (paramngc != null)
    {
      int i = paramngc.getWidth();
      Matrix localMatrix = new Matrix();
      float f = ncp.d / i;
      localMatrix.setScale(f, f);
      paramncq.setImageMatrix(localMatrix);
      paramncq.setImageBitmap(paramngc);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367399));
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = ncp.b;
      this.jdField_a_of_type_AndroidViewView = findViewById(2131370615);
      paramncq = (nji)apub.a().a(642);
      this.jdField_d_of_type_Boolean = paramncq.b();
      if (QLog.isColorLevel()) {
        QLog.d("GameListView", 2, "avGameConfBean:" + paramncq.toString() + "  avGameConfBean.isStrangerMatchShow：" + paramncq.b());
      }
      a(mzl.a().a());
      postDelayed(new GameListView.8(this), 2000L);
      return;
      paramncq.setBackgroundColor(getResources().getColor(2131165341));
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    setVisibility(8);
    c();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void b(int paramInt)
  {
    if (mzl.a().a()) {
      if (paramInt != mzl.a().a().jdField_a_of_type_Int)
      {
        c(paramInt);
        a(this.jdField_a_of_type_Ncz.a(paramInt));
        if ((!this.jdField_b_of_type_Boolean) && (mzl.a().a() == 1) && (!mzl.a().e()))
        {
          this.jdField_b_of_type_Boolean = true;
          RectF localRectF = this.jdField_a_of_type_Ncq.a();
          if (localRectF == null) {
            return;
          }
          this.jdField_a_of_type_Ncq.a().a(getContext().getString(2131690307), localRectF, 146);
          bcef.b(null, "dc00898", "", "", "0X800B350", "0X800B350", 2, 0, "", "", "", "");
        }
        bcef.b(null, "dc00898", "", "", "0X800B351", "0X800B351", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_Ncq.a(getContext().getResources().getString(2131690266));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ncz != null) {
      this.jdField_a_of_type_Ncz.a();
    }
  }
  
  public void c(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    while (mzl.a().a().a() != 0) {
      return;
    }
    mzl.a().a().jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.jdField_a_of_type_Ncz.a(paramInt);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
    b(this.jdField_a_of_type_Ncz.a(paramInt));
    this.jdField_a_of_type_Ncz.a(mzl.a().a(), paramInt, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Ndl.a((nak)paramMessage.obj, paramMessage.arg1);
      continue;
      this.jdField_a_of_type_Ndl.b((nak)paramMessage.obj, paramMessage.arg1);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_Ngc.a()) {
      if ((paramView.getTag() instanceof Integer)) {
        d(((Integer)paramView.getTag()).intValue());
      }
    }
    String str;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        if (!mzl.a().e()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "stopMatch");
        }
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_Ndl.d();
        str = "0X800B498";
        bcef.b(null, "dc00898", "", "", str, str, mzl.a().a().a().players.size(), 0, "", "", mzl.a().a().a() + "", "");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "startMatch");
    }
    if (mzl.a().a().d()) {
      this.jdField_a_of_type_Ncq.a(getContext().getString(2131690340));
    }
    for (;;)
    {
      str = "0X800B497";
      break;
      this.jdField_a_of_type_Int = mzl.a().a();
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "startMatch currentPlayNum:" + this.jdField_a_of_type_Int);
      }
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
      this.jdField_a_of_type_Ndl.c();
    }
  }
  
  public void setCancelPrepareNorImage()
  {
    Bitmap localBitmap = njh.a("avgame_cancel_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_Ngc.a() != null)) {
      this.jdField_a_of_type_Ngc.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setCancelPreparePressImage()
  {
    Bitmap localBitmap = njh.a("avgame_cancel_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_Ngc.a() != null)) {
      this.jdField_a_of_type_Ngc.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setPrepareNorImage()
  {
    Bitmap localBitmap = njh.a("avgame_ready_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_Ngc.a() != null)) {
      this.jdField_a_of_type_Ngc.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setPreparePressImage()
  {
    Bitmap localBitmap = njh.a("avgame_ready_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_Ngc.a() != null)) {
      this.jdField_a_of_type_Ngc.a().setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView
 * JD-Core Version:    0.7.0.1
 */