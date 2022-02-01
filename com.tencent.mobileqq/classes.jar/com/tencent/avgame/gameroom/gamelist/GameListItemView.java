package com.tencent.avgame.gameroom.gamelist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcst;
import bdzx;
import bglf;
import bgtn;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mxl;
import mxo;
import myc;
import myg;
import nak;
import nal;
import nao;
import nap;
import naq;
import nar;
import nat;
import nav;
import nfu;
import nfx;

public class GameListItemView
  extends RelativeLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener
{
  protected int a;
  public View.OnTouchListener a;
  public ImageView a;
  protected RelativeLayout.LayoutParams a;
  protected TextView a;
  protected URLDrawable a;
  protected String a;
  protected myg a;
  protected nal a;
  protected nar a;
  protected boolean a;
  public View.OnTouchListener b;
  protected TextView b;
  protected URLDrawable b;
  protected String b;
  public View.OnTouchListener c = new naq(this);
  
  public GameListItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameListItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameListItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new nao(this);
    this.jdField_b_of_type_AndroidViewView$OnTouchListener = new nap(this);
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListItemView", 2, "handleStartOrReadyBtnClick opCode" + paramInt);
    }
    switch (paramInt)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return;
      } while (this.jdField_a_of_type_Nar == null);
      if (mxl.a().a()) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      this.jdField_a_of_type_Nar.a(this.jdField_a_of_type_Myg, this.jdField_a_of_type_Int);
      bcst.b(null, "dc00898", "", "", "0X800B0F7", "0X800B0F7", mxl.a().a().d(), 0, "" + paramInt, "" + mxl.a().a().a().players.size(), "", "");
      return;
      if (this.jdField_a_of_type_Nar == null) {
        break;
      }
      this.jdField_a_of_type_Nar.a();
      bcst.b(null, "dc00898", "", "", "0X800B029", "0X800B029", 0, 0, "", "" + mxl.a().a().a(), "", "");
      return;
      if (this.jdField_a_of_type_Nar == null) {
        break;
      }
      this.jdField_a_of_type_Nar.b();
      bcst.b(null, "dc00898", "", "", "0X800B028", "0X800B028", 0, 0, "", "" + mxl.a().a().a(), "", "");
      return;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidWidgetImageView.getGlobalVisibleRect(localRect);
    if ((localRect.left == 0) && (localRect.top == 0)) {
      return;
    }
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_Nal.a().a(arrayOfInt);
    RectF localRectF = new RectF();
    localRectF.left = (localRect.left + arrayOfInt[0]);
    localRectF.right = (localRectF.left + this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth());
    localRectF.top = (localRect.top + arrayOfInt[1]);
    localRectF.bottom = (localRectF.top + this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight());
    this.jdField_a_of_type_Nal.a().a(paramString, localRectF, paramInt);
  }
  
  private void a(myg parammyg)
  {
    if (!TextUtils.isEmpty(parammyg.k))
    {
      int i = 60;
      if (a(parammyg)) {
        i = 128;
      }
      if ((!TextUtils.equals(this.jdField_b_of_type_JavaLangString, parammyg.k)) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = 340;
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mLoadingDrawable = bdzx.a;
        localURLDrawableOptions.mFailedDrawable = bdzx.a;
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
        }
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(parammyg.k, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setTargetDensity(320);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      int j = i * nak.g / 340;
      i = j;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight() > 0)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth() > 0) {
          i = nak.g * this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight() / this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth();
        }
      }
      if (i != this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = i;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = bgtn.b(7.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_JavaLangString = parammyg.k;
      if (!a(parammyg)) {
        break label375;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setMinHeight(bgtn.b(42.0F));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(parammyg.jdField_b_of_type_JavaLangString);
      return;
      if (-2 != this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = -2;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = bgtn.b(2.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      this.jdField_b_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parammyg.jdField_a_of_type_JavaLangString);
      break;
      label375:
      this.jdField_b_of_type_AndroidWidgetTextView.setMinHeight(bgtn.b(68.0F));
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListItemView", 2, "hideToast isBubble: " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Nal.a().b(paramString);
      return;
    }
    this.jdField_a_of_type_Nal.d();
  }
  
  private boolean a(int paramInt)
  {
    return (!(this.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof Integer)) || (((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue() != paramInt);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != paramInt2) {
      paramBoolean = false;
    }
    while (!this.jdField_a_of_type_Boolean) {
      return paramBoolean;
    }
    this.jdField_a_of_type_Boolean = false;
    Activity localActivity = this.jdField_a_of_type_Nal.a();
    if ((localActivity instanceof AVGameActivity)) {
      return ((AVGameActivity)localActivity).b();
    }
    return false;
  }
  
  private boolean a(myg parammyg)
  {
    boolean bool;
    if (bglf.a(this.jdField_a_of_type_Myg.jdField_a_of_type_JavaLangString) >= 6.0F)
    {
      bool = true;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
        break label66;
      }
    }
    label66:
    for (int i = this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight();; i = 0)
    {
      if (i > 0)
      {
        if (i > bgtn.b(30.0F) * 1.5F)
        {
          return true;
          bool = false;
          break;
        }
        return false;
      }
      return bool;
    }
  }
  
  public void a(myg parammyg, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Myg = parammyg;
    this.jdField_a_of_type_Int = paramInt2;
    a(parammyg);
    Object localObject = mxl.a();
    if (paramBoolean) {
      if (((mxl)localObject).a(parammyg))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = nfx.a("avgame_start_game_owner_normal@3x.png");
        if (localObject != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        paramBoolean = a(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(0));
        nfu.a().a("param_StepGameCanStart", 0);
        a(false, "");
        if (a(paramInt1, paramInt2, paramBoolean)) {
          a(getContext().getString(2131690275), 174);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parammyg.c)) || (this.jdField_b_of_type_ComTencentImageURLDrawable == null))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = nak.f;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = nak.h;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bdzx.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bdzx.a;
        this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(parammyg.c, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_b_of_type_ComTencentImageURLDrawable.setTargetDensity(320);
        setBackgroundDrawable(this.jdField_b_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_a_of_type_JavaLangString = parammyg.c;
      return;
      if (mxo.b(parammyg))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        Bitmap localBitmap = nfx.a("avgame_start_game_owner_disabled@3x.png");
        if (localBitmap != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
        paramBoolean = a(1);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
        a(true, getContext().getString(2131690275));
        if ((a(paramInt1, paramInt2, paramBoolean)) && (((mxl)localObject).a() > 1))
        {
          this.jdField_a_of_type_Nal.a(getContext().getString(2131690279));
          continue;
          if (!mxo.b(parammyg))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
            if (QLog.isColorLevel()) {
              QLog.i("GameListItemView", 2, "update() selfStatus:" + ((mxl)localObject).a().b());
            }
            if (((mxl)localObject).a().b() == 0)
            {
              setPrepareNorImage();
              paramBoolean = a(2);
              this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
              a(false, "");
              if (a(paramInt1, paramInt2, paramBoolean)) {
                a(getContext().getString(2131690276), 174);
              }
              this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
            }
            else
            {
              setCancelPrepareNorImage();
              paramBoolean = a(3);
              this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
              a(true, getContext().getString(2131690276));
              if ((a(paramInt1, paramInt2, paramBoolean)) && (((mxl)localObject).b(parammyg))) {
                this.jdField_a_of_type_Nal.a(getContext().getString(2131690281));
              }
              for (;;)
              {
                this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.c);
                break;
                if (!((mxl)localObject).b(parammyg)) {
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
  
  public void a(nal paramnal)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363363));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371539));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365369));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_a_of_type_Nal = paramnal;
    if (Math.abs(nak.a - 1.0F) < 0.01F)
    {
      int i = (int)(30.0F * nak.a);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, i);
    }
    setPadding(nak.i, 0, nak.i, nak.j);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof Integer)) {
      a(((Integer)paramView.getTag()).intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    a(this.jdField_a_of_type_Myg);
  }
  
  public void setCancelPrepareNorImage()
  {
    Bitmap localBitmap = nfx.a("avgame_cancel_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void setCancelPreparePressImage()
  {
    Bitmap localBitmap = nfx.a("avgame_cancel_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void setOnBeginOrPrepareClickListener(nar paramnar)
  {
    this.jdField_a_of_type_Nar = paramnar;
  }
  
  public void setPrepareNorImage()
  {
    Bitmap localBitmap = nfx.a("avgame_ready_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void setPreparePressImage()
  {
    Bitmap localBitmap = nfx.a("avgame_ready_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListItemView
 * JD-Core Version:    0.7.0.1
 */