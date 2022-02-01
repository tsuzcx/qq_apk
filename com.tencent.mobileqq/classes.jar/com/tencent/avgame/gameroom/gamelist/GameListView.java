package com.tencent.avgame.gameroom.gamelist;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.widget.TextView;
import bdll;
import bhtq;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import myk;
import myn;
import mze;
import mzj;
import nbp;
import nbs;
import nbt;
import nbx;
import nby;
import ncb;
import ncc;
import ncd;
import nce;
import ncf;
import ncg;
import nch;
import nci;
import nhp;
import nhs;

public class GameListView
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, nbs, nch
{
  protected long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected Handler a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public View.OnTouchListener a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected nbp a;
  private nby jdField_a_of_type_Nby;
  protected ncg a;
  protected boolean a;
  public View.OnTouchListener b;
  protected boolean b;
  public View.OnTouchListener c;
  public boolean c;
  
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
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ncb(this);
    this.jdField_b_of_type_AndroidViewView$OnTouchListener = new ncc(this);
    this.jdField_c_of_type_AndroidViewView$OnTouchListener = new ncd(this);
    this.jdField_a_of_type_Ncg = new nbx(this);
  }
  
  private void a(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidWidgetImageView.getLocationInWindow(arrayOfInt);
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.right = (localRectF.left + this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth());
    localRectF.top = (arrayOfInt[1] - bhtq.a(5.0F));
    localRectF.bottom = (localRectF.top + this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight());
    this.jdField_a_of_type_Nbp.a().a(paramString, localRectF, paramInt);
  }
  
  private void a(mzj parammzj)
  {
    if (parammzj == null) {
      return;
    }
    Object localObject = myk.a();
    boolean bool;
    if (((myk)localObject).a()) {
      if (((myk)localObject).a(parammzj))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = nhs.a("avgame_start_game_owner_normal@3x.png");
        if (localObject != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        bool = a(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(0));
        nhp.a().a("param_StepGameCanStart", 0);
        a(false, "");
        if (a(bool)) {
          a(getContext().getString(2131690280), 174);
        }
      }
    }
    for (;;)
    {
      b(parammzj);
      return;
      if (myn.b(parammzj))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
        Bitmap localBitmap = nhs.a("avgame_start_game_owner_disabled@3x.png");
        if (localBitmap != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
        bool = a(1);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
        a(true, getContext().getString(2131690280));
        if ((a(bool)) && (((myk)localObject).a() > 1))
        {
          this.jdField_a_of_type_Nbp.a(getContext().getString(2131690284));
          continue;
          if (!myn.b(parammzj))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
            if (QLog.isColorLevel()) {
              QLog.i("GameListView", 2, "update() selfStatus:" + ((myk)localObject).a().b());
            }
            if (((myk)localObject).a().b() == 0)
            {
              setPrepareNorImage();
              this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
              bool = a(2);
              a(false, "");
              if (a(bool)) {
                a(getContext().getString(2131690281), 174);
              }
              this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
            }
            else
            {
              setCancelPrepareNorImage();
              this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_c_of_type_AndroidViewView$OnTouchListener);
              bool = a(3);
              a(true, getContext().getString(2131690281));
              if ((a(bool)) && (((myk)localObject).b(parammzj))) {
                this.jdField_a_of_type_Nbp.a(getContext().getString(2131690286));
              }
              for (;;)
              {
                this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
                break;
                if (!((myk)localObject).b(parammzj)) {
                  a(false, "");
                }
              }
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          }
        }
      }
    }
  }
  
  private void a(mzj parammzj, int paramInt)
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
      localMessage.obj = parammzj;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      i = 128;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 2;
    localMessage.obj = parammzj;
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
      this.jdField_a_of_type_Nbp.a().b(paramString);
      return;
    }
    this.jdField_a_of_type_Nbp.d();
  }
  
  private boolean a(int paramInt)
  {
    return (!(this.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof Integer)) || (((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue() != paramInt);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return paramBoolean;
    }
    this.jdField_a_of_type_Boolean = false;
    Activity localActivity = this.jdField_a_of_type_Nbp.a();
    if ((localActivity instanceof AVGameActivity)) {
      return ((AVGameActivity)localActivity).b();
    }
    return false;
  }
  
  private void b(mzj parammzj)
  {
    if (parammzj == null) {
      return;
    }
    if (myk.a().a()) {}
    for (String str1 = getResources().getString(2131690242);; str1 = getResources().getString(2131690243))
    {
      String str2 = str1;
      if (parammzj.a != null) {
        str2 = String.format(str1, new Object[] { parammzj.a });
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      return;
    }
  }
  
  private void d()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Ncg.b();
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
      if (myk.a().a()) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      int i = this.jdField_a_of_type_Ncg.a();
      a(this.jdField_a_of_type_Nby.a(i), i);
      bdll.b(null, "dc00898", "", "", "0X800B0F7", "0X800B0F7", myk.a().a().d(), 0, "" + paramInt, "" + myk.a().a().a().players.size(), "", "");
      return;
      d();
      bdll.b(null, "dc00898", "", "", "0X800B029", "0X800B029", 0, 0, "", "" + myk.a().a().a(), "", "");
      return;
      e();
      bdll.b(null, "dc00898", "", "", "0X800B028", "0X800B028", 0, 0, "", "" + myk.a().a().a(), "", "");
      return;
    }
  }
  
  private void e()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Ncg.a();
  }
  
  public Context a()
  {
    return getContext();
  }
  
  public ncg a()
  {
    return this.jdField_a_of_type_Ncg;
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Nby.a(paramInt);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidAppDialog = nbt.a(getContext(), (mzj)localObject);
    }
    this.jdField_c_of_type_Boolean = true;
    if (myk.a().a()) {}
    for (localObject = "0X800B352";; localObject = "0X800B353")
    {
      bdll.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void a(mze parammze)
  {
    int i = parammze.a();
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "refreshUI  gameStatus:" + i + " currentItem: currentGameIndex:" + this.jdField_a_of_type_Ncg.a());
    }
    if (i == 0)
    {
      this.jdField_a_of_type_Nby.a(this.jdField_a_of_type_Ncg.a(), this.jdField_a_of_type_Ncg.a(), this.jdField_a_of_type_Ncg.a());
      if (getVisibility() == 8) {
        a();
      }
      a(this.jdField_a_of_type_Nby.a(this.jdField_a_of_type_Ncg.a()));
    }
    while (getVisibility() != 0) {
      return;
    }
    b();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(nbp paramnbp)
  {
    this.jdField_a_of_type_Nbp = paramnbp;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Ncg.a(paramnbp);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367362));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367363));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131367380));
    this.jdField_a_of_type_Nby = new nby(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this, paramnbp);
    this.jdField_a_of_type_Nby.a(3);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new nce(this));
    findViewById(2131363581).setOnClickListener(new ncf(this));
    a(myk.a().a());
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
    if (myk.a().a()) {
      if (paramInt != myk.a().a().a)
      {
        c(paramInt);
        a(this.jdField_a_of_type_Nby.a(paramInt));
        if ((!this.jdField_b_of_type_Boolean) && (myk.a().a() == 1))
        {
          this.jdField_b_of_type_Boolean = true;
          RectF localRectF = this.jdField_a_of_type_Nbp.a();
          if (localRectF == null) {
            return;
          }
          this.jdField_a_of_type_Nbp.a().a(getContext().getString(2131690282), localRectF, 146);
          bdll.b(null, "dc00898", "", "", "0X800B350", "0X800B350", 2, 0, "", "", "", "");
        }
        bdll.b(null, "dc00898", "", "", "0X800B351", "0X800B351", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_Nbp.a(getContext().getResources().getString(2131690241));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Nby != null) {
      this.jdField_a_of_type_Nby.a();
    }
  }
  
  public void c(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    while (myk.a().a().a() != 0) {
      return;
    }
    myk.a().a().a = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.jdField_a_of_type_Nby.a(paramInt);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
    b(this.jdField_a_of_type_Nby.a(paramInt));
    this.jdField_a_of_type_Nby.a(myk.a().a(), paramInt, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Ncg.a((mzj)paramMessage.obj, paramMessage.arg1);
      continue;
      this.jdField_a_of_type_Ncg.b((mzj)paramMessage.obj, paramMessage.arg1);
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
      if ((paramView.getTag() instanceof Integer)) {
        d(((Integer)paramView.getTag()).intValue());
      }
    }
  }
  
  public void setCancelPrepareNorImage()
  {
    Bitmap localBitmap = nhs.a("avgame_cancel_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void setCancelPreparePressImage()
  {
    Bitmap localBitmap = nhs.a("avgame_cancel_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void setPrepareNorImage()
  {
    Bitmap localBitmap = nhs.a("avgame_ready_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void setPreparePressImage()
  {
    Bitmap localBitmap = nhs.a("avgame_ready_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView
 * JD-Core Version:    0.7.0.1
 */