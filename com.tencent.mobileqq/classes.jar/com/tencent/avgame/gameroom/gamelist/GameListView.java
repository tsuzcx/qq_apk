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
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.video.IAVControlUiPresenter;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class GameListView
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, GameGridItemView.GameGridClickListener, IGameListView
{
  public static final int a;
  protected long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected Handler a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public View.OnTouchListener a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  protected IGameRoomPresenter a;
  private GameCardView jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView;
  private GameListRecyclerViewAdapter jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter;
  protected IGameListPresenter a;
  protected IAVControlUiPresenter a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GameListView.1(this);
  protected boolean a;
  private int jdField_b_of_type_Int = 0;
  public View.OnTouchListener b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected boolean b;
  public View.OnTouchListener c;
  protected boolean c;
  public View.OnTouchListener d;
  protected boolean d;
  
  static
  {
    jdField_a_of_type_Int = AVGameUtils.c();
  }
  
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
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new GameListView.2(this);
    this.jdField_b_of_type_AndroidViewView$OnTouchListener = new GameListView.3(this);
    this.jdField_c_of_type_AndroidViewView$OnTouchListener = new GameListView.4(this);
    this.jdField_d_of_type_AndroidViewView$OnTouchListener = new GameListView.5(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter = new GameListPresenterImp(this);
  }
  
  private void a(GameItem paramGameItem)
  {
    if (paramGameItem == null) {
      return;
    }
    Object localObject = GameEngine.a();
    boolean bool;
    if (((GameEngine)localObject).a()) {
      if (((GameEngine)localObject).a(paramGameItem))
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(0);
        localObject = AVGameUtils.a("avgame_start_game_owner_normal@3x.png");
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap((Bitmap)localObject);
        }
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        bool = a(0);
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setTag(Integer.valueOf(0));
        AVGamePerfReporter.a().a("param_StepGameCanStart", 0);
        a(false, "");
        if (a(bool)) {
          a(getContext().getString(2131690423), 174);
        }
      }
    }
    for (;;)
    {
      b(paramGameItem);
      return;
      if (GameUtil.b(paramGameItem))
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(4);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(0);
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(null);
        Bitmap localBitmap = AVGameUtils.a("avgame_start_game_owner_disabled@3x.png");
        if (localBitmap != null) {
          this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
        }
        bool = a(1);
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setTag(Integer.valueOf(1));
        a(true, getContext().getString(2131690423));
        if ((a(bool)) && (((GameEngine)localObject).a() > 1))
        {
          this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(getContext().getString(2131690428));
          continue;
          if (!GameUtil.b(paramGameItem))
          {
            this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(0);
            this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(null);
            if (QLog.isColorLevel()) {
              QLog.i("GameListView", 2, "update() selfStatus:" + ((GameEngine)localObject).a().b());
            }
            if (((GameEngine)localObject).a().b() == 0)
            {
              setPrepareNorImage();
              this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
              bool = a(2);
              a(false, "");
              if (a(bool)) {
                a(getContext().getString(2131690424), 174);
              }
              this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setTag(Integer.valueOf(2));
            }
            else
            {
              setCancelPrepareNorImage();
              this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(this.jdField_c_of_type_AndroidViewView$OnTouchListener);
              bool = a(3);
              a(true, getContext().getString(2131690424));
              if ((a(bool)) && (((GameEngine)localObject).b(paramGameItem))) {
                this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(getContext().getString(2131690430));
              }
              for (;;)
              {
                this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setTag(Integer.valueOf(3));
                break;
                if (!((GameEngine)localObject).b(paramGameItem)) {
                  a(false, "");
                }
              }
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(4);
          }
        }
      }
    }
  }
  
  private void a(GameItem paramGameItem, int paramInt)
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
      localMessage.obj = paramGameItem;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      i = 128;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 2;
    localMessage.obj = paramGameItem;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, i);
  }
  
  private void a(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().getLocationInWindow(arrayOfInt);
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.right = (localRectF.left + this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().getMeasuredWidth());
    localRectF.top = (arrayOfInt[1] - ViewUtils.a(5.0F));
    localRectF.bottom = (localRectF.top + this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().getMeasuredHeight());
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(paramString, localRectF, paramInt);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "hideToast isBubble: " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.d();
  }
  
  private boolean a(int paramInt)
  {
    return (!(this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().getTag() instanceof Integer)) || (((Integer)this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().getTag()).intValue() != paramInt);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return paramBoolean;
    }
    this.jdField_a_of_type_Boolean = false;
    Activity localActivity = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
    if ((localActivity instanceof AVGameActivity)) {
      return ((AVGameActivity)localActivity).c();
    }
    return false;
  }
  
  private void b(GameItem paramGameItem)
  {
    if (paramGameItem == null) {
      return;
    }
    if (GameEngine.a().a()) {}
    for (String str1 = getResources().getString(2131690372);; str1 = getResources().getString(2131690373))
    {
      String str2 = str1;
      if (paramGameItem.a != null) {
        str2 = String.format(str1, new Object[] { paramGameItem.a });
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      return;
    }
  }
  
  private void e()
  {
    if ((AVGameUtils.b() == 2) && (GameEngine.a().e()) && (GameEngine.a().a()) && (GameEngine.a().a().a() == 0) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(3)) && (GameEngine.a().a().a() == 0)) {
      f(jdField_a_of_type_Int);
    }
  }
  
  private void e(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
    f(paramInt);
  }
  
  private void f()
  {
    int i = AVGameUtils.b();
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "checkABTestControl " + i);
    }
    if (i == 0) {
      g();
    }
    do
    {
      return;
      if (i == 1)
      {
        h();
        return;
      }
    } while (i != 2);
    i();
  }
  
  private void f(int paramInt)
  {
    Object localObject = getResources().getString(2131690470);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((String)localObject + " " + paramInt + "s");
    if (paramInt > 0)
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      ((Message)localObject).arg1 = (paramInt - 1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if (GameEngine.a().a() <= 1)
    {
      m();
      return;
    }
    a().a(GameEngine.a().a().a());
  }
  
  private void g()
  {
    a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a()));
    j();
  }
  
  private void g(int paramInt)
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
      if (GameEngine.a().a()) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      int i = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a();
      a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(i), i);
      ReportController.b(null, "dc00898", "", "", "0X800B0F7", "0X800B0F7", GameEngine.a().a().d(), 0, "" + paramInt, "" + GameEngine.a().a().a().players.size(), "", "");
      return;
      k();
      ReportController.b(null, "dc00898", "", "", "0X800B029", "0X800B029", 0, 0, "", "" + GameEngine.a().a().a(), "", "");
      return;
      l();
      ReportController.b(null, "dc00898", "", "", "0X800B028", "0X800B028", 0, 0, "", "" + GameEngine.a().a().a(), "", "");
      return;
    }
  }
  
  private void h()
  {
    a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a()));
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    }
    j();
  }
  
  private void i()
  {
    j();
    int i;
    if (GameEngine.a().a()) {
      if ((GameEngine.a().e()) || (GameEngine.a().a().k())) {
        i = 1;
      }
    }
    while (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "checkControlForABTestB2 showBigCard");
      }
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView == null)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView = new GameCardView(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(10, -1);
        localLayoutParams.addRule(2, 2131363772);
        localLayoutParams.addRule(14, -1);
        localLayoutParams.topMargin = (GameRoomViewLayoutParamsDef.jdField_b_of_type_Int + ViewUtils.a(10.0F));
        addView(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView, localLayoutParams);
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a()));
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      i = 0;
      continue;
      i = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "checkControlForABTestB2 show list");
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a()));
  }
  
  private void j()
  {
    Object localObject = GameEngine.a();
    boolean bool = ((GameEngine)localObject).e();
    if (((GameEngine)localObject).a()) {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!bool)
        {
          removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          if (QLog.isColorLevel()) {
            QLog.i("GameListView", 2, "checkGameMatchStatus  removeCallbacks mCheckMatchResultRunnable");
          }
        }
        label60:
        if (!bool) {
          break label153;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690470);
        label74:
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (!bool) {
          break label166;
        }
      }
    }
    label153:
    label166:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (bool) {}
      for (localObject = "avgame_match_stop_normal@2x.png";; localObject = "avgame_match_start_normal@2x.png")
      {
        localObject = AVGameUtils.a((String)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_d_of_type_AndroidViewView$OnTouchListener);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label60;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690465);
      break label74;
    }
  }
  
  private void k()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.b();
  }
  
  private void l()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a();
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "showMatchV2TimeoutDialog");
    }
    DialogUtil.a(getContext(), 230, null, getResources().getString(2131690468), getResources().getString(2131690571), null, null, new GameListView.10(this)).show();
  }
  
  private void n()
  {
    Context localContext = getContext();
    if ((localContext != null) && (!((Activity)localContext).isFinishing()))
    {
      String str1 = localContext.getString(2131690570);
      String str2 = localContext.getString(2131690568);
      String str3 = localContext.getString(2131690569);
      QLog.d("GameListView", 2, "showDialogTip when game match content:" + str3);
      DialogUtil.a(localContext, 230, null, str3, str1, str2, new GameListView.11(this), new GameListView.12(this)).show();
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.c(true);
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.f(true);
    this.jdField_b_of_type_Int = GameEngine.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "startMatch currentPlayNum:" + this.jdField_b_of_type_Int);
    }
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.c();
  }
  
  public Context a()
  {
    return getContext();
  }
  
  public IGameListPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter;
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(paramInt);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidAppDialog = GameListDescriptionDialog.a(getContext(), (GameItem)localObject);
    }
    this.jdField_c_of_type_Boolean = true;
    if (GameEngine.a().a()) {}
    for (localObject = "0X800B352";; localObject = "0X800B353")
    {
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    if (paramEngineData.f()) {
      setVisibility(8);
    }
    do
    {
      do
      {
        return;
        int i = paramEngineData.a();
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "refreshUI  gameStatus:" + i + " currentItem: currentGameIndex:" + this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a() + " showMatch:" + this.jdField_d_of_type_Boolean);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(), this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(), this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a());
          if (getVisibility() == 8) {
            a();
          }
          f();
          return;
        }
      } while (getVisibility() != 0);
      b();
      this.jdField_b_of_type_Boolean = false;
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    } while (!QLog.isColorLevel());
    QLog.i("GameListView", 2, "refreshUI  removeCallbacks mCheckMatchResultRunnable");
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter, IAVControlUiPresenter paramIAVControlUiPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter = paramIAVControlUiPresenter;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramIGameRoomPresenter);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367727));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367700));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690465);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131367725));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter = new GameListRecyclerViewAdapter(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this, paramIGameRoomPresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(3);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new GameListView.6(this));
    findViewById(2131363772).setOnClickListener(new GameListView.7(this));
    paramIGameRoomPresenter = (ImageView)findViewById(2131367690);
    paramIAVControlUiPresenter = AVGameUtils.a("avgame_room_bg@2x.png");
    if (paramIAVControlUiPresenter != null)
    {
      int i = paramIAVControlUiPresenter.getWidth();
      Matrix localMatrix = new Matrix();
      float f = GameRoomViewLayoutParamsDef.d / i;
      localMatrix.setScale(f, f);
      paramIGameRoomPresenter.setImageMatrix(localMatrix);
      paramIGameRoomPresenter.setImageBitmap(paramIAVControlUiPresenter);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367713));
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidViewView = findViewById(2131371079);
      paramIGameRoomPresenter = (AvGameConfBean)QConfigManager.a().a(642);
      this.jdField_d_of_type_Boolean = paramIGameRoomPresenter.b();
      if (QLog.isColorLevel()) {
        QLog.d("GameListView", 2, "avGameConfBean:" + paramIGameRoomPresenter.toString() + "  avGameConfBean.isStrangerMatchShow：" + paramIGameRoomPresenter.b());
      }
      a(GameEngine.a().a());
      postDelayed(new GameListView.8(this), 2000L);
      e();
      return;
      paramIGameRoomPresenter.setBackgroundColor(getResources().getColor(2131165344));
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "autoStartGameFail " + paramString);
    }
    if (paramString != null) {
      DialogUtil.a(getContext(), 230, null, paramString, getResources().getString(2131690571), null, null, new GameListView.9(this)).show();
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
    if (GameEngine.a().a())
    {
      if (GameEngine.a().e())
      {
        int i = AVGameUtils.b();
        if ((i != 1) && (i != 2)) {}
      }
      RectF localRectF;
      do
      {
        return;
        if (paramInt == GameEngine.a().a().jdField_a_of_type_Int) {
          break label190;
        }
        d(paramInt);
        a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(paramInt));
        if ((this.jdField_b_of_type_Boolean) || (GameEngine.a().a() != 1) || (GameEngine.a().e())) {
          break;
        }
        this.jdField_b_of_type_Boolean = true;
        localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
      } while (localRectF == null);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(getContext().getString(2131690425), localRectF, 146);
      ReportController.b(null, "dc00898", "", "", "0X800B350", "0X800B350", 2, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B351", "0X800B351", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      label190:
      this.jdField_c_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(getContext().getResources().getString(2131690371));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a();
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "startCountDownGameStart " + paramInt);
    }
    if (paramInt > 0)
    {
      e(paramInt);
      return;
    }
    f(0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "destroy  removeCallbacks mCheckMatchResultRunnable");
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.g();
  }
  
  public void d(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    while (GameEngine.a().a().a() != 0) {
      return;
    }
    GameEngine.a().a().jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(paramInt);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
    b(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(paramInt));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(GameEngine.a().a(), paramInt, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a((GameItem)paramMessage.obj, paramMessage.arg1);
      continue;
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.b((GameItem)paramMessage.obj, paramMessage.arg1);
      continue;
      f(paramMessage.arg1);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a()) {
      if ((paramView.getTag() instanceof Integer)) {
        g(((Integer)paramView.getTag()).intValue());
      }
    }
    String str;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        if (!GameEngine.a().e()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "stopMatch");
        }
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.d();
        str = "0X800B498";
        ReportController.b(null, "dc00898", "", "", str, str, GameEngine.a().a().a().players.size(), 0, "", "", GameEngine.a().a().a() + "", "");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "startMatch");
    }
    if (GameEngine.a().a().e()) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(getContext().getString(2131690469));
    }
    for (;;)
    {
      str = "0X800B497";
      break;
      if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b()) {
        o();
      } else {
        n();
      }
    }
  }
  
  public void setCancelPrepareNorImage()
  {
    Bitmap localBitmap = AVGameUtils.a("avgame_cancel_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a() != null)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setCancelPreparePressImage()
  {
    Bitmap localBitmap = AVGameUtils.a("avgame_cancel_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a() != null)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setPrepareNorImage()
  {
    Bitmap localBitmap = AVGameUtils.a("avgame_ready_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a() != null)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setPreparePressImage()
  {
    Bitmap localBitmap = AVGameUtils.a("avgame_ready_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a() != null)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView
 * JD-Core Version:    0.7.0.1
 */