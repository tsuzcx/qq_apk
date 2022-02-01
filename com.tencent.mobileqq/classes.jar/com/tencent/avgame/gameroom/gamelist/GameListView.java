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
  public static final int k = ;
  protected TextView a;
  protected IGameListPresenter b = new GameListPresenterImp(this);
  protected IGameRoomPresenter c;
  protected IAVControlUiPresenter d;
  protected long e = 0L;
  protected boolean f = true;
  protected boolean g = false;
  protected boolean h = false;
  protected boolean i = false;
  protected Handler j;
  public View.OnTouchListener l = new GameListView.2(this);
  public View.OnTouchListener m = new GameListView.3(this);
  public View.OnTouchListener n = new GameListView.4(this);
  public View.OnTouchListener o = new GameListView.5(this);
  private RecyclerView p;
  private GameListRecyclerViewAdapter q;
  private ImageView r;
  private TextView s;
  private View t;
  private GameCardView u;
  private Dialog v;
  private int w = 0;
  private Runnable x = new GameListView.1(this);
  
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
    LayoutInflater.from(getContext()).inflate(2131624314, this, true);
  }
  
  private void a(GameItem paramGameItem)
  {
    if (paramGameItem == null) {
      return;
    }
    Object localObject1 = IGameEngine.I();
    boolean bool;
    Object localObject2;
    if (((IGameEngine)localObject1).d())
    {
      if (((IGameEngine)localObject1).a(paramGameItem))
      {
        this.d.a(0);
        localObject1 = AVGameUtil.c("avgame_start_game_owner_normal@3x.png");
        if (localObject1 != null) {
          this.d.h().setImageBitmap((Bitmap)localObject1);
        }
        this.d.h().setOnTouchListener(this.l);
        bool = e(0);
        this.d.h().setTag(Integer.valueOf(0));
        AVGamePerfReporter.a().a("param_StepGameCanStart", 0);
        a(false, "");
        if (a(bool)) {
          a(getContext().getString(2131887258), 174);
        }
      }
      else if (GameUtil.b(paramGameItem))
      {
        this.d.a(4);
      }
      else
      {
        this.d.a(0);
        this.d.h().setOnTouchListener(null);
        localObject2 = AVGameUtil.c("avgame_start_game_owner_disabled@3x.png");
        if (localObject2 != null) {
          this.d.h().setImageBitmap((Bitmap)localObject2);
        }
        bool = e(1);
        this.d.h().setTag(Integer.valueOf(1));
        a(true, getContext().getString(2131887258));
        if ((a(bool)) && (((IGameEngine)localObject1).e() > 1)) {
          this.c.b(getContext().getString(2131887263));
        }
      }
    }
    else if (!GameUtil.b(paramGameItem))
    {
      this.d.a(0);
      this.d.h().setOnTouchListener(null);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("update() selfStatus:");
        ((StringBuilder)localObject2).append(((IGameEngine)localObject1).s().m());
        QLog.i("GameListView", 2, ((StringBuilder)localObject2).toString());
      }
      if (((IGameEngine)localObject1).s().m() == 0)
      {
        setPrepareNorImage();
        this.d.h().setOnTouchListener(this.m);
        bool = e(2);
        a(false, "");
        if (a(bool)) {
          a(getContext().getString(2131887259), 174);
        }
        this.d.h().setTag(Integer.valueOf(2));
      }
      else
      {
        setCancelPrepareNorImage();
        this.d.h().setOnTouchListener(this.n);
        bool = e(3);
        a(true, getContext().getString(2131887259));
        if ((a(bool)) && (((IGameEngine)localObject1).b(paramGameItem))) {
          this.c.b(getContext().getString(2131887265));
        } else if (!((IGameEngine)localObject1).b(paramGameItem)) {
          a(false, "");
        }
        this.d.h().setTag(Integer.valueOf(3));
      }
    }
    else
    {
      this.d.a(4);
    }
    setGameChoseText(paramGameItem);
  }
  
  private void a(GameItem paramGameItem, int paramInt)
  {
    if (System.currentTimeMillis() - this.e < 1000L) {
      return;
    }
    this.e = System.currentTimeMillis();
    int i1 = 0;
    if (this.j.hasMessages(1))
    {
      this.j.removeMessages(1);
      localMessage = this.j.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramGameItem;
      localMessage.arg1 = paramInt;
      this.j.sendMessage(localMessage);
      i1 = 128;
    }
    this.j.removeMessages(2);
    Message localMessage = this.j.obtainMessage();
    localMessage.what = 2;
    localMessage.obj = paramGameItem;
    localMessage.arg1 = paramInt;
    this.j.sendMessageDelayed(localMessage, i1);
  }
  
  private void a(String paramString, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    this.d.h().getLocationInWindow(arrayOfInt);
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.right = (localRectF.left + this.d.h().getMeasuredWidth());
    localRectF.top = (arrayOfInt[1] - ViewUtils.dip2px(5.0F));
    localRectF.bottom = (localRectF.top + this.d.h().getMeasuredHeight());
    this.c.e().a(paramString, localRectF, paramInt);
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
      this.c.e().b(paramString);
      return;
    }
    this.c.q();
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!this.f) {
      return paramBoolean;
    }
    paramBoolean = false;
    this.f = false;
    Activity localActivity = this.c.m();
    if ((localActivity instanceof IAVGameRootContainer)) {
      paramBoolean = ((IAVGameRootContainer)localActivity).isNewEnter();
    }
    return paramBoolean;
  }
  
  private boolean e(int paramInt)
  {
    return (!(this.d.h().getTag() instanceof Integer)) || (((Integer)this.d.h().getTag()).intValue() != paramInt);
  }
  
  private void f()
  {
    if (IGameEngine.J()) {
      return;
    }
    if ((AVGameUtil.b() == 2) && (IGameEngine.I().v()) && (IGameEngine.I().d()) && (IGameEngine.I().s().j() == 0) && (!this.j.hasMessages(3)) && (IGameEngine.I().s().j() == 0)) {
      g(k);
    }
  }
  
  private void f(int paramInt)
  {
    this.j.removeMessages(3);
    Message localMessage = this.j.obtainMessage(3);
    localMessage.arg1 = paramInt;
    this.j.sendMessageDelayed(localMessage, 1000L);
    g(paramInt);
  }
  
  private void g()
  {
    int i1 = AVGameUtil.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkABTestControl ");
      localStringBuilder.append(i1);
      QLog.i("GameListView", 2, localStringBuilder.toString());
    }
    if (i1 == 0)
    {
      h();
      return;
    }
    if (i1 == 1)
    {
      i();
      return;
    }
    if (i1 == 2) {
      j();
    }
  }
  
  private void g(int paramInt)
  {
    Object localObject = getResources().getString(2131887305);
    TextView localTextView = this.s;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("s");
    localTextView.setText(localStringBuilder.toString());
    if (paramInt > 0)
    {
      localObject = this.j.obtainMessage(3);
      ((Message)localObject).arg1 = (paramInt - 1);
      this.j.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
    this.j.removeMessages(3);
    if (IGameEngine.J()) {
      return;
    }
    if (IGameEngine.I().e() <= 1)
    {
      n();
      return;
    }
    getPresenter().a(IGameEngine.I().s().f());
  }
  
  private void h()
  {
    a(this.q.b(this.b.c()));
    k();
  }
  
  private void h(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleStartOrReadyBtnClick opCode");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("GameListView", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          m();
          if (IGameEngine.J()) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(IGameEngine.I().s().i());
          ReportController.b(null, "dc00898", "", "", "0X800B028", "0X800B028", 0, 0, "", ((StringBuilder)localObject).toString(), "", "");
          return;
        }
        l();
        if (IGameEngine.J()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(IGameEngine.I().s().i());
        ReportController.b(null, "dc00898", "", "", "0X800B029", "0X800B029", 0, 0, "", ((StringBuilder)localObject).toString(), "", "");
      }
    }
    else
    {
      paramInt = i1;
      if (!IGameEngine.I().d()) {
        paramInt = 2;
      }
      i1 = this.b.c();
      a(this.q.b(i1), i1);
      if (IGameEngine.J()) {
        return;
      }
      i1 = IGameEngine.I().s().p();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(IGameEngine.I().s().e().players.size());
      ReportController.b(null, "dc00898", "", "", "0X800B0F7", "0X800B0F7", i1, 0, (String)localObject, localStringBuilder.toString(), "", "");
    }
  }
  
  private void i()
  {
    a(this.q.b(this.b.c()));
    if (this.p.getVisibility() != 0) {
      this.p.setVisibility(0);
    }
    k();
  }
  
  private void j()
  {
    k();
    boolean bool = IGameEngine.J();
    int i2 = 1;
    int i1 = i2;
    if (!bool)
    {
      i1 = i2;
      if (IGameEngine.I().d())
      {
        i1 = i2;
        if (!IGameEngine.I().v()) {
          if (IGameEngine.I().s().ac()) {
            i1 = i2;
          } else {
            i1 = 0;
          }
        }
      }
    }
    if (i1 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "checkControlForABTestB2 showBigCard");
      }
      if (this.p.getVisibility() == 0) {
        this.p.setVisibility(8);
      }
      if (this.u == null)
      {
        this.u = new GameCardView(getContext());
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131429618);
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (GameRoomViewLayoutParamsDef.b + ViewUtils.dip2px(10.0F));
        addView(this.u, (ViewGroup.LayoutParams)localObject);
      }
      this.u.a(this.q.b(this.b.c()));
      this.u.setVisibility(0);
      this.r.setVisibility(4);
      this.a.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "checkControlForABTestB2 show list");
    }
    if (this.p.getVisibility() != 0) {
      this.p.setVisibility(0);
    }
    Object localObject = this.u;
    if (localObject != null) {
      ((GameCardView)localObject).setVisibility(8);
    }
    this.r.setVisibility(0);
    this.a.setVisibility(0);
    a(this.q.b(this.b.c()));
  }
  
  private void k()
  {
    Object localObject = IGameEngine.I();
    boolean bool1 = ((IGameEngine)localObject).v();
    boolean bool2 = ((IGameEngine)localObject).d();
    int i1 = 0;
    if (bool2)
    {
      if (!this.i)
      {
        this.r.setVisibility(8);
      }
      else
      {
        this.r.setVisibility(0);
        if (bool1) {
          localObject = "avgame_match_stop_normal@2x.png";
        } else {
          localObject = "avgame_match_start_normal@2x.png";
        }
        localObject = AVGameUtil.c((String)localObject);
        this.r.setImageBitmap((Bitmap)localObject);
        this.r.setOnTouchListener(this.o);
      }
      if (!bool1)
      {
        removeCallbacks(this.x);
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "checkGameMatchStatus  removeCallbacks mCheckMatchResultRunnable");
        }
      }
    }
    else
    {
      this.r.setVisibility(8);
    }
    if (bool1) {
      this.s.setText(2131887305);
    } else {
      this.s.setText(2131887300);
    }
    localObject = this.t;
    if (!bool1) {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
  }
  
  private void l()
  {
    if (System.currentTimeMillis() - this.e < 500L) {
      return;
    }
    this.e = System.currentTimeMillis();
    this.b.e();
  }
  
  private void m()
  {
    if (System.currentTimeMillis() - this.e < 500L) {
      return;
    }
    this.e = System.currentTimeMillis();
    this.b.d();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "showMatchV2TimeoutDialog");
    }
    DialogUtil.a(getContext(), 230, null, getResources().getString(2131887303), getResources().getString(2131887410), null, null, new GameListView.10(this)).show();
  }
  
  private void o()
  {
    Context localContext = getContext();
    if ((localContext != null) && (!((Activity)localContext).isFinishing()))
    {
      String str1 = localContext.getString(2131887408);
      String str2 = localContext.getString(2131887406);
      String str3 = localContext.getString(2131887407);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDialogTip when game match content:");
      localStringBuilder.append(str3);
      QLog.d("GameListView", 2, localStringBuilder.toString());
      DialogUtil.a(localContext, 230, null, str3, str1, str2, new GameListView.11(this), new GameListView.12(this)).show();
    }
  }
  
  private void p()
  {
    this.d.c(true);
    this.c.f(true);
    this.w = IGameEngine.I().e();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startMatch currentPlayNum:");
      localStringBuilder.append(this.w);
      QLog.i("GameListView", 2, localStringBuilder.toString());
    }
    postDelayed(this.x, 10000L);
    this.b.f();
  }
  
  private void setGameChoseText(GameItem paramGameItem)
  {
    if (paramGameItem == null) {
      return;
    }
    String str1;
    if (IGameEngine.I().d()) {
      str1 = getResources().getString(2131887206);
    } else {
      str1 = getResources().getString(2131887207);
    }
    String str2 = str1;
    if (paramGameItem.b != null) {
      str2 = String.format(str1, new Object[] { paramGameItem.b });
    }
    this.a.setText(str2);
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.q.b(paramInt);
    if (localObject != null) {
      this.v = GameListDescriptionDialog.a(getContext(), (GameItem)localObject);
    }
    this.h = true;
    if (IGameEngine.I().d()) {
      localObject = "0X800B352";
    } else {
      localObject = "0X800B353";
    }
    ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
  }
  
  public void a(EngineData paramEngineData)
  {
    if (paramEngineData.M())
    {
      setVisibility(8);
      return;
    }
    int i1 = paramEngineData.j();
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("refreshUI  gameStatus:");
      paramEngineData.append(i1);
      paramEngineData.append(" currentItem: currentGameIndex:");
      paramEngineData.append(this.b.c());
      paramEngineData.append(" showMatch:");
      paramEngineData.append(this.i);
      QLog.i("GameListView", 2, paramEngineData.toString());
    }
    if (i1 == 0)
    {
      this.q.a(this.b.a(), this.b.b(), this.b.c());
      if (getVisibility() == 8) {
        a();
      }
      g();
      return;
    }
    if (getVisibility() == 0)
    {
      b();
      this.g = false;
      removeCallbacks(this.x);
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "refreshUI  removeCallbacks mCheckMatchResultRunnable");
      }
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter, IAVControlUiPresenter paramIAVControlUiPresenter)
  {
    this.c = paramIGameRoomPresenter;
    this.d = paramIAVControlUiPresenter;
    this.j = new Handler(this);
    this.b.a(paramIGameRoomPresenter);
    this.r = ((ImageView)findViewById(2131433993));
    this.r.setOnClickListener(this);
    this.s = ((TextView)findViewById(2131433956));
    this.s.setText(2131887300);
    this.d.h().setOnClickListener(this);
    this.p = ((RecyclerView)findViewById(2131433991));
    this.q = new GameListRecyclerViewAdapter(getContext(), this.p, this, paramIGameRoomPresenter);
    this.q.a(3);
    this.p.setOnScrollListener(new GameListView.6(this));
    findViewById(2131429618).setOnClickListener(new GameListView.7(this));
    paramIGameRoomPresenter = (ImageView)findViewById(2131433946);
    paramIAVControlUiPresenter = AVGameUtil.c("avgame_room_bg@2x.png");
    if (paramIAVControlUiPresenter != null)
    {
      int i1 = paramIAVControlUiPresenter.getWidth();
      Matrix localMatrix = new Matrix();
      float f1 = GameRoomViewLayoutParamsDef.d / i1;
      localMatrix.setScale(f1, f1);
      paramIGameRoomPresenter.setImageMatrix(localMatrix);
      paramIGameRoomPresenter.setImageBitmap(paramIAVControlUiPresenter);
    }
    else
    {
      paramIGameRoomPresenter.setBackgroundColor(getResources().getColor(2131165546));
    }
    this.a = ((TextView)findViewById(2131433974));
    ((RelativeLayout.LayoutParams)this.a.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.b;
    this.t = findViewById(2131437992);
    paramIGameRoomPresenter = AvGameConfigUtil.a();
    this.i = paramIGameRoomPresenter.k();
    if (QLog.isColorLevel())
    {
      paramIAVControlUiPresenter = new StringBuilder();
      paramIAVControlUiPresenter.append("avGameConfBean:");
      paramIAVControlUiPresenter.append(paramIGameRoomPresenter.toString());
      paramIAVControlUiPresenter.append("  avGameConfBean.isStrangerMatchShow：");
      paramIAVControlUiPresenter.append(paramIGameRoomPresenter.k());
      QLog.d("GameListView", 2, paramIAVControlUiPresenter.toString());
    }
    if (IGameEngine.J()) {
      return;
    }
    a(IGameEngine.I().s());
    postDelayed(new GameListView.8(this), 2000L);
    f();
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
      DialogUtil.a(getContext(), 230, null, paramString, getResources().getString(2131887410), null, null, new GameListView.9(this)).show();
    }
  }
  
  public void b()
  {
    setVisibility(8);
    c();
    Dialog localDialog = this.v;
    if ((localDialog != null) && (localDialog.isShowing()))
    {
      this.v.dismiss();
      this.v = null;
    }
  }
  
  public void b(int paramInt)
  {
    if (IGameEngine.J()) {
      return;
    }
    if (IGameEngine.I().d())
    {
      if (IGameEngine.I().v())
      {
        int i1 = AVGameUtil.b();
        if ((i1 == 1) || (i1 == 2)) {
          return;
        }
      }
      if (paramInt != IGameEngine.I().s().b)
      {
        d(paramInt);
        a(this.q.b(paramInt));
        if ((!this.g) && (IGameEngine.I().e() == 1) && (!IGameEngine.I().v()))
        {
          this.g = true;
          RectF localRectF = this.c.u();
          if (localRectF == null) {
            return;
          }
          this.c.e().a(getContext().getString(2131887260), localRectF, 146);
          ReportController.b(null, "dc00898", "", "", "0X800B350", "0X800B350", 2, 0, "", "", "", "");
        }
        ReportController.b(null, "dc00898", "", "", "0X800B351", "0X800B351", 0, 0, "", "", "", "");
      }
    }
    else
    {
      this.c.b(getContext().getResources().getString(2131887205));
    }
    this.h = true;
  }
  
  public void c()
  {
    GameListRecyclerViewAdapter localGameListRecyclerViewAdapter = this.q;
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
      f(paramInt);
      return;
    }
    g(0);
  }
  
  public void d()
  {
    this.j.removeCallbacksAndMessages(null);
    removeCallbacks(this.x);
    if (QLog.isColorLevel()) {
      QLog.i("GameListView", 2, "destroy  removeCallbacks mCheckMatchResultRunnable");
    }
    this.b.j();
  }
  
  public void d(int paramInt)
  {
    if (System.currentTimeMillis() - this.e < 1000L) {
      return;
    }
    if (IGameEngine.J()) {
      return;
    }
    if (IGameEngine.I().s().j() != 0) {
      return;
    }
    IGameEngine.I().s().b = paramInt;
    this.j.removeMessages(1);
    Message localMessage = this.j.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = this.q.b(paramInt);
    localMessage.arg1 = paramInt;
    this.j.sendMessageDelayed(localMessage, 1000L);
    setGameChoseText(this.q.b(paramInt));
    this.q.a(IGameEngine.I().d(), paramInt, true);
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public boolean getGameMatchButtonShown()
  {
    return this.r.getVisibility() == 0;
  }
  
  public IGameListPresenter getPresenter()
  {
    return this.b;
  }
  
  public Context getViewContext()
  {
    return getContext();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return true;
        }
        g(paramMessage.arg1);
        return true;
      }
      this.b.b((GameItem)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    this.b.a((GameItem)paramMessage.obj, paramMessage.arg1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.d.h())
    {
      if ((paramView.getTag() instanceof Integer)) {
        h(((Integer)paramView.getTag()).intValue());
      }
    }
    else if ((paramView == this.r) && (!IGameEngine.J()))
    {
      if (IGameEngine.I().v())
      {
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "stopMatch");
        }
        removeCallbacks(this.x);
        this.b.g();
      }
      for (String str = "0X800B498";; str = "0X800B497")
      {
        break;
        if (QLog.isColorLevel()) {
          QLog.i("GameListView", 2, "startMatch");
        }
        if (IGameEngine.I().s().L()) {
          this.c.b(getContext().getString(2131887304));
        } else if (this.d.j()) {
          p();
        } else {
          o();
        }
      }
      int i1 = IGameEngine.I().s().e().players.size();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(IGameEngine.I().s().i());
      localStringBuilder.append("");
      ReportController.b(null, "dc00898", "", "", str, str, i1, 0, "", "", localStringBuilder.toString(), "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCancelPrepareNorImage()
  {
    Bitmap localBitmap = AVGameUtil.c("avgame_cancel_button_nor@2x.png");
    if ((localBitmap != null) && (this.d.h() != null)) {
      this.d.h().setImageBitmap(localBitmap);
    }
  }
  
  public void setCancelPreparePressImage()
  {
    Bitmap localBitmap = AVGameUtil.c("avgame_cancel_button_press@2x.png");
    if ((localBitmap != null) && (this.d.h() != null)) {
      this.d.h().setImageBitmap(localBitmap);
    }
  }
  
  public void setPrepareNorImage()
  {
    Bitmap localBitmap = AVGameUtil.c("avgame_ready_button_nor@2x.png");
    if ((localBitmap != null) && (this.d.h() != null)) {
      this.d.h().setImageBitmap(localBitmap);
    }
  }
  
  public void setPreparePressImage()
  {
    Bitmap localBitmap = AVGameUtil.c("avgame_ready_button_press@2x.png");
    if ((localBitmap != null) && (this.d.h() != null)) {
      this.d.h().setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView
 * JD-Core Version:    0.7.0.1
 */