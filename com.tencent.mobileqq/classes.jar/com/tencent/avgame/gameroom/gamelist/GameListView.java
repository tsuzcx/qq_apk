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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.video.IAVControlUiPresenter;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtil;
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
    jdField_a_of_type_Int = AVGameUtil.c();
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
    LayoutInflater.from(getContext()).inflate(2131558697, this, true);
  }
  
  private void a(GameItem paramGameItem)
  {
    if (paramGameItem == null) {
      return;
    }
    Object localObject1 = IGameEngine.a();
    boolean bool;
    Object localObject2;
    if (((IGameEngine)localObject1).a())
    {
      if (((IGameEngine)localObject1).a(paramGameItem))
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(0);
        localObject1 = AVGameUtil.a("avgame_start_game_owner_normal@3x.png");
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap((Bitmap)localObject1);
        }
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        bool = a(0);
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setTag(Integer.valueOf(0));
        AVGamePerfReporter.a().a("param_StepGameCanStart", 0);
        a(false, "");
        if (a(bool)) {
          a(getContext().getString(2131690347), 174);
        }
      }
      else if (GameUtil.b(paramGameItem))
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(4);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(0);
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(null);
        localObject2 = AVGameUtil.a("avgame_start_game_owner_disabled@3x.png");
        if (localObject2 != null) {
          this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap((Bitmap)localObject2);
        }
        bool = a(1);
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setTag(Integer.valueOf(1));
        a(true, getContext().getString(2131690347));
        if ((a(bool)) && (((IGameEngine)localObject1).a() > 1)) {
          this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(getContext().getString(2131690352));
        }
      }
    }
    else if (!GameUtil.b(paramGameItem))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(0);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(null);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("update() selfStatus:");
        ((StringBuilder)localObject2).append(((IGameEngine)localObject1).a().b());
        QLog.i("GameListView", 2, ((StringBuilder)localObject2).toString());
      }
      if (((IGameEngine)localObject1).a().b() == 0)
      {
        setPrepareNorImage();
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
        bool = a(2);
        a(false, "");
        if (a(bool)) {
          a(getContext().getString(2131690348), 174);
        }
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setTag(Integer.valueOf(2));
      }
      else
      {
        setCancelPrepareNorImage();
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnTouchListener(this.jdField_c_of_type_AndroidViewView$OnTouchListener);
        bool = a(3);
        a(true, getContext().getString(2131690348));
        if ((a(bool)) && (((IGameEngine)localObject1).b(paramGameItem))) {
          this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(getContext().getString(2131690354));
        } else if (!((IGameEngine)localObject1).b(paramGameItem)) {
          a(false, "");
        }
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setTag(Integer.valueOf(3));
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a(4);
    }
    b(paramGameItem);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideToast isBubble: ");
      localStringBuilder.append(paramBoolean);
      QLog.i("GameListView", 2, localStringBuilder.toString());
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
    paramBoolean = false;
    this.jdField_a_of_type_Boolean = false;
    Activity localActivity = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
    if ((localActivity instanceof IAVGameRootContainer)) {
      paramBoolean = ((IAVGameRootContainer)localActivity).isNewEnter();
    }
    return paramBoolean;
  }
  
  private void b(GameItem paramGameItem)
  {
    if (paramGameItem == null) {
      return;
    }
    String str1;
    if (IGameEngine.a().a()) {
      str1 = getResources().getString(2131690295);
    } else {
      str1 = getResources().getString(2131690296);
    }
    String str2 = str1;
    if (paramGameItem.a != null) {
      str2 = String.format(str1, new Object[] { paramGameItem.a });
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
  }
  
  private void e()
  {
    if (IGameEngine.k()) {
      return;
    }
    if ((AVGameUtil.b() == 2) && (IGameEngine.a().e()) && (IGameEngine.a().a()) && (IGameEngine.a().a().a() == 0) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(3)) && (IGameEngine.a().a().a() == 0)) {
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
    int i = AVGameUtil.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkABTestControl ");
      localStringBuilder.append(i);
      QLog.i("GameListView", 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      g();
      return;
    }
    if (i == 1)
    {
      h();
      return;
    }
    if (i == 2) {
      i();
    }
  }
  
  private void f(int paramInt)
  {
    Object localObject = getResources().getString(2131690394);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("s");
    localTextView.setText(localStringBuilder.toString());
    if (paramInt > 0)
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      ((Message)localObject).arg1 = (paramInt - 1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if (IGameEngine.k()) {
      return;
    }
    if (IGameEngine.a().a() <= 1)
    {
      m();
      return;
    }
    a().a(IGameEngine.a().a().a());
  }
  
  private void g()
  {
    a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a()));
    j();
  }
  
  private void g(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleStartOrReadyBtnClick opCode");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("GameListView", 2, ((StringBuilder)localObject).toString());
    }
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          l();
          if (IGameEngine.k()) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(IGameEngine.a().a().a());
          ReportController.b(null, "dc00898", "", "", "0X800B028", "0X800B028", 0, 0, "", ((StringBuilder)localObject).toString(), "", "");
          return;
        }
        k();
        if (IGameEngine.k()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(IGameEngine.a().a().a());
        ReportController.b(null, "dc00898", "", "", "0X800B029", "0X800B029", 0, 0, "", ((StringBuilder)localObject).toString(), "", "");
      }
    }
    else
    {
      paramInt = i;
      if (!IGameEngine.a().a()) {
        paramInt = 2;
      }
      i = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a();
      a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(i), i);
      if (IGameEngine.k()) {
        return;
      }
      i = IGameEngine.a().a().d();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(IGameEngine.a().a().a().players.size());
      ReportController.b(null, "dc00898", "", "", "0X800B0F7", "0X800B0F7", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
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
    boolean bool = IGameEngine.k();
    int j = 1;
    int i = j;
    if (!bool)
    {
      i = j;
      if (IGameEngine.a().a())
      {
        i = j;
        if (!IGameEngine.a().e()) {
          if (IGameEngine.a().a().k()) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
    }
    if (i != 0)
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
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131363701);
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (GameRoomViewLayoutParamsDef.jdField_b_of_type_Int + ViewUtils.a(10.0F));
        addView(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView, (ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a()));
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "checkControlForABTestB2 show list");
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameCardView;
    if (localObject != null) {
      ((GameCardView)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a()));
  }
  
  private void j()
  {
    Object localObject = IGameEngine.a();
    boolean bool1 = ((IGameEngine)localObject).e();
    boolean bool2 = ((IGameEngine)localObject).a();
    int i = 0;
    if (bool2)
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (bool1) {
          localObject = "avgame_match_stop_normal@2x.png";
        } else {
          localObject = "avgame_match_start_normal@2x.png";
        }
        localObject = AVGameUtil.a((String)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_d_of_type_AndroidViewView$OnTouchListener);
      }
      if (!bool1)
      {
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "checkGameMatchStatus  removeCallbacks mCheckMatchResultRunnable");
        }
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (bool1) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690394);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690389);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (!bool1) {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
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
    DialogUtil.a(getContext(), 230, null, getResources().getString(2131690392), getResources().getString(2131690499), null, null, new GameListView.10(this)).show();
  }
  
  private void n()
  {
    Context localContext = getContext();
    if ((localContext != null) && (!((Activity)localContext).isFinishing()))
    {
      String str1 = localContext.getString(2131690497);
      String str2 = localContext.getString(2131690495);
      String str3 = localContext.getString(2131690496);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDialogTip when game match content:");
      localStringBuilder.append(str3);
      QLog.d("GameListView", 2, localStringBuilder.toString());
      DialogUtil.a(localContext, 230, null, str3, str1, str2, new GameListView.11(this), new GameListView.12(this)).show();
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.c(true);
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.f(true);
    this.jdField_b_of_type_Int = IGameEngine.a().a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startMatch currentPlayNum:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.i("GameListView", 2, localStringBuilder.toString());
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
    if (IGameEngine.a().a()) {
      localObject = "0X800B352";
    } else {
      localObject = "0X800B353";
    }
    ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
  }
  
  public void a(EngineData paramEngineData)
  {
    if (paramEngineData.f())
    {
      setVisibility(8);
      return;
    }
    int i = paramEngineData.a();
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("refreshUI  gameStatus:");
      paramEngineData.append(i);
      paramEngineData.append(" currentItem: currentGameIndex:");
      paramEngineData.append(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a());
      paramEngineData.append(" showMatch:");
      paramEngineData.append(this.jdField_d_of_type_Boolean);
      QLog.i("GameListView", 2, paramEngineData.toString());
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
    if (getVisibility() == 0)
    {
      b();
      this.jdField_b_of_type_Boolean = false;
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "refreshUI  removeCallbacks mCheckMatchResultRunnable");
      }
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter, IAVControlUiPresenter paramIAVControlUiPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter = paramIAVControlUiPresenter;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a(paramIGameRoomPresenter);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367484));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367453));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131690389);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131367482));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter = new GameListRecyclerViewAdapter(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this, paramIGameRoomPresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(3);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new GameListView.6(this));
    findViewById(2131363701).setOnClickListener(new GameListView.7(this));
    paramIGameRoomPresenter = (ImageView)findViewById(2131367443);
    paramIAVControlUiPresenter = AVGameUtil.a("avgame_room_bg@2x.png");
    if (paramIAVControlUiPresenter != null)
    {
      int i = paramIAVControlUiPresenter.getWidth();
      Matrix localMatrix = new Matrix();
      float f = GameRoomViewLayoutParamsDef.d / i;
      localMatrix.setScale(f, f);
      paramIGameRoomPresenter.setImageMatrix(localMatrix);
      paramIGameRoomPresenter.setImageBitmap(paramIAVControlUiPresenter);
    }
    else
    {
      paramIGameRoomPresenter.setBackgroundColor(getResources().getColor(2131165310));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367468));
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370713);
    paramIGameRoomPresenter = AvGameConfigUtil.a();
    this.jdField_d_of_type_Boolean = paramIGameRoomPresenter.b();
    if (QLog.isColorLevel())
    {
      paramIAVControlUiPresenter = new StringBuilder();
      paramIAVControlUiPresenter.append("avGameConfBean:");
      paramIAVControlUiPresenter.append(paramIGameRoomPresenter.toString());
      paramIAVControlUiPresenter.append("  avGameConfBean.isStrangerMatchShow：");
      paramIAVControlUiPresenter.append(paramIGameRoomPresenter.b());
      QLog.d("GameListView", 2, paramIAVControlUiPresenter.toString());
    }
    if (IGameEngine.k()) {
      return;
    }
    a(IGameEngine.a().a());
    postDelayed(new GameListView.8(this), 2000L);
    e();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("autoStartGameFail ");
      localStringBuilder.append(paramString);
      QLog.i("GameListView", 2, localStringBuilder.toString());
    }
    if (paramString != null) {
      DialogUtil.a(getContext(), 230, null, paramString, getResources().getString(2131690499), null, null, new GameListView.9(this)).show();
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
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void b(int paramInt)
  {
    if (IGameEngine.k()) {
      return;
    }
    if (IGameEngine.a().a())
    {
      if (IGameEngine.a().e())
      {
        int i = AVGameUtil.b();
        if ((i == 1) || (i == 2)) {
          return;
        }
      }
      if (paramInt != IGameEngine.a().a().jdField_a_of_type_Int)
      {
        d(paramInt);
        a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(paramInt));
        if ((!this.jdField_b_of_type_Boolean) && (IGameEngine.a().a() == 1) && (!IGameEngine.a().e()))
        {
          this.jdField_b_of_type_Boolean = true;
          RectF localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
          if (localRectF == null) {
            return;
          }
          this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(getContext().getString(2131690349), localRectF, 146);
          ReportController.b(null, "dc00898", "", "", "0X800B350", "0X800B350", 2, 0, "", "", "", "");
        }
        ReportController.b(null, "dc00898", "", "", "0X800B351", "0X800B351", 0, 0, "", "", "", "");
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(getContext().getResources().getString(2131690294));
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c()
  {
    GameListRecyclerViewAdapter localGameListRecyclerViewAdapter = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter;
    if (localGameListRecyclerViewAdapter != null) {
      localGameListRecyclerViewAdapter.a();
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startCountDownGameStart ");
      localStringBuilder.append(paramInt);
      QLog.i("GameListView", 2, localStringBuilder.toString());
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
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      return;
    }
    if (IGameEngine.k()) {
      return;
    }
    if (IGameEngine.a().a().a() != 0) {
      return;
    }
    IGameEngine.a().a().jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(paramInt);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
    b(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(paramInt));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListRecyclerViewAdapter.a(IGameEngine.a().a(), paramInt, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        f(paramMessage.arg1);
        return true;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.b((GameItem)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.a((GameItem)paramMessage.obj, paramMessage.arg1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a())
    {
      if ((paramView.getTag() instanceof Integer)) {
        g(((Integer)paramView.getTag()).intValue());
      }
    }
    else if ((paramView == this.jdField_a_of_type_AndroidWidgetImageView) && (!IGameEngine.k()))
    {
      if (IGameEngine.a().e())
      {
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "stopMatch");
        }
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListPresenter.d();
      }
      for (String str = "0X800B498";; str = "0X800B497")
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "startMatch");
        }
        if (IGameEngine.a().a().e()) {
          this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(getContext().getString(2131690393));
        } else if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.b()) {
          o();
        } else {
          n();
        }
      }
      int i = IGameEngine.a().a().a().players.size();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(IGameEngine.a().a().a());
      localStringBuilder.append("");
      ReportController.b(null, "dc00898", "", "", str, str, i, 0, "", "", localStringBuilder.toString(), "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCancelPrepareNorImage()
  {
    Bitmap localBitmap = AVGameUtil.a("avgame_cancel_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a() != null)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setCancelPreparePressImage()
  {
    Bitmap localBitmap = AVGameUtil.a("avgame_cancel_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a() != null)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setPrepareNorImage()
  {
    Bitmap localBitmap = AVGameUtil.a("avgame_ready_button_nor@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a() != null)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
    }
  }
  
  public void setPreparePressImage()
  {
    Bitmap localBitmap = AVGameUtil.a("avgame_ready_button_press@2x.png");
    if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a() != null)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoIAVControlUiPresenter.a().setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView
 * JD-Core Version:    0.7.0.1
 */