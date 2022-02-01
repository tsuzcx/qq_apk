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
import aqxe;
import bdla;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import nfc;
import nff;
import nfv;
import nga;
import nin;
import nio;
import nir;
import nis;
import niw;
import nix;
import njd;
import nje;
import njf;
import njg;
import njh;
import nji;
import njj;
import njk;
import njl;
import nmu;
import nqc;
import nqf;
import nqg;

public class GameListView
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, nir, njk
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
  public nio a;
  private nix jdField_a_of_type_Nix;
  protected njj a;
  public nmu a;
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
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new njd(this);
    this.jdField_b_of_type_AndroidViewView$OnTouchListener = new nje(this);
    this.jdField_c_of_type_AndroidViewView$OnTouchListener = new njf(this);
    this.jdField_d_of_type_AndroidViewView$OnTouchListener = new njg(this);
    this.jdField_a_of_type_Njj = new niw(this);
  }
  
  private void a(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_Nmu.a().getLocationInWindow(arrayOfInt);
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.right = (localRectF.left + this.jdField_a_of_type_Nmu.a().getMeasuredWidth());
    localRectF.top = (arrayOfInt[1] - ViewUtils.dip2px(5.0F));
    localRectF.bottom = (localRectF.top + this.jdField_a_of_type_Nmu.a().getMeasuredHeight());
    this.jdField_a_of_type_Nio.a().a(paramString, localRectF, paramInt);
  }
  
  private void a(nga paramnga)
  {
    if (paramnga == null) {
      return;
    }
    Object localObject = nfc.a();
    boolean bool;
    if (((nfc)localObject).a()) {
      if (((nfc)localObject).a(paramnga))
      {
        this.jdField_a_of_type_Nmu.a().setVisibility(0);
        localObject = nqf.a("avgame_start_game_owner_normal@3x.png");
        if (localObject != null) {
          this.jdField_a_of_type_Nmu.a().setImageBitmap((Bitmap)localObject);
        }
        this.jdField_a_of_type_Nmu.a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        bool = a(0);
        this.jdField_a_of_type_Nmu.a().setTag(Integer.valueOf(0));
        nqc.a().a("param_StepGameCanStart", 0);
        a(false, "");
        if (a(bool)) {
          a(getContext().getString(2131690344), 174);
        }
      }
    }
    for (;;)
    {
      b(paramnga);
      return;
      if (nff.b(paramnga))
      {
        this.jdField_a_of_type_Nmu.a().setVisibility(4);
      }
      else
      {
        this.jdField_a_of_type_Nmu.a().setVisibility(0);
        this.jdField_a_of_type_Nmu.a().setOnTouchListener(null);
        Bitmap localBitmap = nqf.a("avgame_start_game_owner_disabled@3x.png");
        if (localBitmap != null) {
          this.jdField_a_of_type_Nmu.a().setImageBitmap(localBitmap);
        }
        bool = a(1);
        this.jdField_a_of_type_Nmu.a().setTag(Integer.valueOf(1));
        a(true, getContext().getString(2131690344));
        if ((a(bool)) && (((nfc)localObject).a() > 1))
        {
          this.jdField_a_of_type_Nio.a(getContext().getString(2131690348));
          continue;
          if (!nff.b(paramnga))
          {
            this.jdField_a_of_type_Nmu.a().setVisibility(0);
            this.jdField_a_of_type_Nmu.a().setOnTouchListener(null);
            if (QLog.isColorLevel()) {
              QLog.i("GameListView", 2, "update() selfStatus:" + ((nfc)localObject).a().b());
            }
            if (((nfc)localObject).a().b() == 0)
            {
              setPrepareNorImage();
              this.jdField_a_of_type_Nmu.a().setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
              bool = a(2);
              a(false, "");
              if (a(bool)) {
                a(getContext().getString(2131690345), 174);
              }
              this.jdField_a_of_type_Nmu.a().setTag(Integer.valueOf(2));
            }
            else
            {
              setCancelPrepareNorImage();
              this.jdField_a_of_type_Nmu.a().setOnTouchListener(this.jdField_c_of_type_AndroidViewView$OnTouchListener);
              bool = a(3);
              a(true, getContext().getString(2131690345));
              if ((a(bool)) && (((nfc)localObject).b(paramnga))) {
                this.jdField_a_of_type_Nio.a(getContext().getString(2131690350));
              }
              for (;;)
              {
                this.jdField_a_of_type_Nmu.a().setTag(Integer.valueOf(3));
                break;
                if (!((nfc)localObject).b(paramnga)) {
                  a(false, "");
                }
              }
            }
          }
          else
          {
            this.jdField_a_of_type_Nmu.a().setVisibility(4);
          }
        }
      }
    }
  }
  
  private void a(nga paramnga, int paramInt)
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
      localMessage.obj = paramnga;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      i = 128;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 2;
    localMessage.obj = paramnga;
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
      this.jdField_a_of_type_Nio.a().b(paramString);
      return;
    }
    this.jdField_a_of_type_Nio.d();
  }
  
  private boolean a(int paramInt)
  {
    return (!(this.jdField_a_of_type_Nmu.a().getTag() instanceof Integer)) || (((Integer)this.jdField_a_of_type_Nmu.a().getTag()).intValue() != paramInt);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return paramBoolean;
    }
    this.jdField_a_of_type_Boolean = false;
    Activity localActivity = this.jdField_a_of_type_Nio.a();
    if ((localActivity instanceof AVGameActivity)) {
      return ((AVGameActivity)localActivity).b();
    }
    return false;
  }
  
  private void b(nga paramnga)
  {
    if (paramnga == null) {
      return;
    }
    if (nfc.a().a()) {}
    for (String str1 = getResources().getString(2131690305);; str1 = getResources().getString(2131690306))
    {
      String str2 = str1;
      if (paramnga.a != null) {
        str2 = String.format(str1, new Object[] { paramnga.a });
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      return;
    }
  }
  
  private void d()
  {
    Object localObject = nfc.a();
    boolean bool = ((nfc)localObject).e();
    if (((nfc)localObject).a()) {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!bool) {
          removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
        label45:
        if (!bool) {
          break label138;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690381);
        label59:
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (!bool) {
          break label151;
        }
      }
    }
    label138:
    label151:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (bool) {}
      for (localObject = "avgame_match_stop_normal@2x.png";; localObject = "avgame_match_start_normal@2x.png")
      {
        localObject = nqf.a((String)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_d_of_type_AndroidViewView$OnTouchListener);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label45;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690379);
      break label59;
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
      if (nfc.a().a()) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      int i = this.jdField_a_of_type_Njj.a();
      a(this.jdField_a_of_type_Nix.a(i), i);
      bdla.b(null, "dc00898", "", "", "0X800B0F7", "0X800B0F7", nfc.a().a().d(), 0, "" + paramInt, "" + nfc.a().a().a().players.size(), "", "");
      return;
      e();
      bdla.b(null, "dc00898", "", "", "0X800B029", "0X800B029", 0, 0, "", "" + nfc.a().a().a(), "", "");
      return;
      f();
      bdla.b(null, "dc00898", "", "", "0X800B028", "0X800B028", 0, 0, "", "" + nfc.a().a().a(), "", "");
      return;
    }
  }
  
  private void e()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Njj.b();
  }
  
  private void f()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Njj.a();
  }
  
  public Context a()
  {
    return getContext();
  }
  
  public njj a()
  {
    return this.jdField_a_of_type_Njj;
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Nix.a(paramInt);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidAppDialog = nis.a(getContext(), (nga)localObject);
    }
    this.jdField_c_of_type_Boolean = true;
    if (nfc.a().a()) {}
    for (localObject = "0X800B352";; localObject = "0X800B353")
    {
      bdla.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void a(nfv paramnfv)
  {
    if (paramnfv.e()) {
      setVisibility(8);
    }
    do
    {
      return;
      int i = paramnfv.a();
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "refreshUI  gameStatus:" + i + " currentItem: currentGameIndex:" + this.jdField_a_of_type_Njj.a() + " showMatch:" + this.jdField_d_of_type_Boolean);
      }
      if (i == 0)
      {
        this.jdField_a_of_type_Nix.a(this.jdField_a_of_type_Njj.a(), this.jdField_a_of_type_Njj.a(), this.jdField_a_of_type_Njj.a());
        if (getVisibility() == 8) {
          a();
        }
        a(this.jdField_a_of_type_Nix.a(this.jdField_a_of_type_Njj.a()));
        d();
        return;
      }
    } while (getVisibility() != 0);
    b();
    this.jdField_b_of_type_Boolean = false;
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(nio paramnio, nmu paramnmu)
  {
    this.jdField_a_of_type_Nio = paramnio;
    this.jdField_a_of_type_Nmu = paramnmu;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Njj.a(paramnio);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367538));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367513));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690379);
    this.jdField_a_of_type_Nmu.a().setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131367536));
    this.jdField_a_of_type_Nix = new nix(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this, paramnio);
    this.jdField_a_of_type_Nix.a(3);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new njh(this));
    findViewById(2131363679).setOnClickListener(new nji(this));
    paramnio = (ImageView)findViewById(2131367503);
    paramnmu = nqf.a("avgame_room_bg@2x.png");
    if (paramnmu != null)
    {
      int i = paramnmu.getWidth();
      Matrix localMatrix = new Matrix();
      float f = nin.d / i;
      localMatrix.setScale(f, f);
      paramnio.setImageMatrix(localMatrix);
      paramnio.setImageBitmap(paramnmu);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367525));
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = nin.b;
      this.jdField_a_of_type_AndroidViewView = findViewById(2131370798);
      paramnio = (nqg)aqxe.a().a(642);
      this.jdField_d_of_type_Boolean = paramnio.b();
      if (QLog.isColorLevel()) {
        QLog.d("GameListView", 2, "avGameConfBean:" + paramnio.toString() + "  avGameConfBean.isStrangerMatchShow：" + paramnio.b());
      }
      a(nfc.a().a());
      postDelayed(new GameListView.8(this), 2000L);
      return;
      paramnio.setBackgroundColor(getResources().getColor(2131165344));
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
    if (nfc.a().a()) {
      if (paramInt != nfc.a().a().jdField_a_of_type_Int)
      {
        c(paramInt);
        a(this.jdField_a_of_type_Nix.a(paramInt));
        if ((!this.jdField_b_of_type_Boolean) && (nfc.a().a() == 1) && (!nfc.a().e()))
        {
          this.jdField_b_of_type_Boolean = true;
          RectF localRectF = this.jdField_a_of_type_Nio.a();
          if (localRectF == null) {
            return;
          }
          this.jdField_a_of_type_Nio.a().a(getContext().getString(2131690346), localRectF, 146);
          bdla.b(null, "dc00898", "", "", "0X800B350", "0X800B350", 2, 0, "", "", "", "");
        }
        bdla.b(null, "dc00898", "", "", "0X800B351", "0X800B351", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_Nio.a(getContext().getResources().getString(2131690304));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Nix != null) {
      this.jdField_a_of_type_Nix.a();
    }
  }
  
  public void c(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    while (nfc.a().a().a() != 0) {
      return;
    }
    nfc.a().a().jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.jdField_a_of_type_Nix.a(paramInt);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
    b(this.jdField_a_of_type_Nix.a(paramInt));
    this.jdField_a_of_type_Nix.a(nfc.a().a(), paramInt, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Njj.a((nga)paramMessage.obj, paramMessage.arg1);
      continue;
      this.jdField_a_of_type_Njj.b((nga)paramMessage.obj, paramMessage.arg1);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_Nmu.a()) {
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
        if (!nfc.a().e()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "stopMatch");
        }
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_Njj.d();
        str = "0X800B498";
        bdla.b(null, "dc00898", "", "", str, str, nfc.a().a().a().players.size(), 0, "", "", nfc.a().a().a() + "", "");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "startMatch");
    }
    if (nfc.a().a().d()) {
      this.jdField_a_of_type_Nio.a(getContext().getString(2131690380));
    }
    for (;;)
    {
      str = "0X800B497";
      break;
      this.jdField_a_of_type_Int = nfc.a().a();
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "startMatch currentPlayNum:" + this.jdField_a_of_type_Int);
      }
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
      this.jdField_a_of_type_Njj.c();
    }
  }
  
  public void setCancelPrepareNorImage()
  {
    Bitmap localBitmap = nqf.a("avgame_cancel_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_Nmu.a() != null)) {
      this.jdField_a_of_type_Nmu.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setCancelPreparePressImage()
  {
    Bitmap localBitmap = nqf.a("avgame_cancel_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_Nmu.a() != null)) {
      this.jdField_a_of_type_Nmu.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setPrepareNorImage()
  {
    Bitmap localBitmap = nqf.a("avgame_ready_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_Nmu.a() != null)) {
      this.jdField_a_of_type_Nmu.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setPreparePressImage()
  {
    Bitmap localBitmap = nqf.a("avgame_ready_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_Nmu.a() != null)) {
      this.jdField_a_of_type_Nmu.a().setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView
 * JD-Core Version:    0.7.0.1
 */