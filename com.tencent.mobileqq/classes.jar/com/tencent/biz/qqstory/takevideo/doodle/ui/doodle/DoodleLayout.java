package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bdee;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import ykq;
import ykv;
import ykw;
import ynw;
import yqu;
import yqv;
import yqw;
import yrd;
import yre;
import yri;
import yro;
import yrt;
import yrv;
import yrx;
import yso;
import yti;
import ytj;
import ytk;
import ytl;
import ytm;
import ytn;
import yto;
import ytp;
import ytq;
import ytr;
import yts;
import ytt;
import ytw;
import ytx;
import yty;
import ytz;
import yua;
import yud;
import yuh;
import yum;
import yup;
import yuv;
import yvn;
import zbq;

@TargetApi(14)
public class DoodleLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  public static boolean a;
  public int a;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Rect a;
  public SparseArray<yrt> a;
  public SparseBooleanArray a;
  public View a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public EditVideoParams a;
  public DoodleEditView a;
  public DoodleTextureView a;
  public DoodleView a;
  public FacePanel a;
  public HorizontalSelectColorLayout a;
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksLock.newCondition();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public yqw a;
  private yro jdField_a_of_type_Yro;
  public yso a;
  public yto a;
  public ytp a;
  public ytq a;
  private ytx jdField_a_of_type_Ytx;
  public ytz a;
  public int b;
  public Rect b;
  public SparseArray<yts> b;
  public SparseBooleanArray b;
  public RelativeLayout b;
  public boolean b;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h;
  private int i;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_b_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Ytz = new ytz(this, null);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    k();
    this.h = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {}
    for (String str = "2";; str = "1")
    {
      a(paramString, 0, 0, new String[] { str });
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    ykv.a("video_edit", paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  private boolean a(boolean paramBoolean)
  {
    a();
    ykq.b("DoodleLayout", "onBackPressed, buttonState:" + this.jdField_b_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    if ((this.jdField_b_of_type_Int == 0) || ((this.jdField_b_of_type_Int == 2) && (!paramBoolean))) {
      return false;
    }
    f();
    d(0);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a())
    {
      ykq.b("DoodleLayout", "onBackPressed, resetDoodleView.");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.d();
    }
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        ykq.b("DoodleLayout", "rubbish active.");
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166367));
      }
    }
    else
    {
      return;
    }
    ykq.b("DoodleLayout", "rubbish unActive.");
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131166368));
  }
  
  private void e(int paramInt)
  {
    Object localObject1 = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject2 = (yrt)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int j;
    if ((localObject1 == null) || (localObject2 == null))
    {
      ykq.b("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      localObject1 = new yqv(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
      yre localyre = new yre(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
      yri localyri = new yri(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
      localObject2 = (yuh)localyre.a(103);
      if ((localObject2 != null) && (this.jdField_c_of_type_Int != -1)) {
        ((yuh)localObject2).b(this.jdField_c_of_type_Int);
      }
      if ((localObject2 != null) && (this.jdField_d_of_type_Int != -1) && (this.e != -1)) {
        ((yuh)localObject2).b(this.jdField_d_of_type_Int, this.e);
      }
      localObject2 = new yrv().a(new ytw(new yro[] { localObject1, localyre, localyri }));
      if (this.f != -1)
      {
        j = this.f;
        localObject2 = ((yrv)localObject2).a(j);
        if (this.g == -1) {
          break label465;
        }
        j = this.g;
        label222:
        yrt localyrt = ((yrv)localObject2).b(j).a();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig(localyrt);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
        }
        localObject2 = new yts(localyri, localyre, (yqv)localObject1, (yqu)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("EmptyLayer"));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localyrt);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
        localyre.a(new ytt(this, null));
        localyre.a(new ytk(this));
        ((yqv)localObject1).a(this.jdField_a_of_type_Ytz);
        ((yqv)localObject1).a(new ytl(this));
        localObject1 = localObject2;
        if (!this.jdField_c_of_type_Boolean)
        {
          localyri.a(this.jdField_a_of_type_Ytz);
          localyri.a(new yua(this, null));
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      localObject2 = a();
      ((yre)localObject2).a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
      ((yre)localObject2).a.a(new ytm(this));
      ((yum)((yre)localObject2).a.a(102)).a(false);
      ((yts)localObject1).jdField_a_of_type_Yre.b();
      return;
      j = 480;
      break;
      label465:
      j = 640;
      break label222;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((yrt)localObject2);
    }
  }
  
  private void k()
  {
    LayoutInflater.from(super.getContext()).inflate(2131561655, this);
    l();
    e(this.jdField_a_of_type_Int);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365212));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379795));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131377009));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369532));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370784);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel = ((FacePanel)super.findViewById(2131366369));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel.setOnFaceSelectedListener(new ytr(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)super.findViewById(2131371921));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnUndoViewClickListener(new yti(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new ytj(this));
    n();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365800));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131365802));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView = new DoodleTextureView(super.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, localLayoutParams);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)super.findViewById(2131365801));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleLayout(this);
    setOnTextDialogShowListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnLayerTouchListener();
    this.jdField_b_of_type_Boolean = bdee.b();
    if (!this.jdField_b_of_type_Boolean)
    {
      a(new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      setDoodleGLViewVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    f();
  }
  
  private void m()
  {
    ykq.b("DoodleLayout", "onClickInside: showEditTextDialog.");
    this.jdField_a_of_type_Ytq = new ytq(this, null);
    this.jdField_a_of_type_Yso = new yso(super.getContext());
    this.jdField_a_of_type_Yso.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    this.jdField_a_of_type_Yso.a(a());
    this.jdField_a_of_type_Yso.setContentView(2131561660);
    this.jdField_a_of_type_Yso.a(this.jdField_a_of_type_Ytq);
    this.jdField_a_of_type_Yso.show();
  }
  
  private void n()
  {
    AppInterface localAppInterface = null;
    if ((super.getContext() instanceof QQStoryBaseActivity)) {
      localAppInterface = ((QQStoryBaseActivity)super.getContext()).a;
    }
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || ((!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalVideoSource)) && (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalGifSource)) && (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalPhotoSource))))
    {
      bool1 = true;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (ynw.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEnableMasks, 32768))) {
        break label133;
      }
    }
    label133:
    for (boolean bool2 = true;; bool2 = false)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new zbq(localAppInterface, bool1, bool2), true, 1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(zbt.a[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int a()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int j = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    int k = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (j + k);
  }
  
  public int a(int paramInt)
  {
    yts localyts = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyts != null)
    {
      paramInt = localyts.jdField_a_of_type_Yri.a();
      int j = localyts.jdField_a_of_type_Yre.a();
      int k = localyts.jdField_a_of_type_Yqv.a();
      ykq.b("DoodleLayout", "DoodleCount: text->" + paramInt + ",line->" + j + ",face->" + k);
      return k + (paramInt + j);
    }
    return 0;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public Bitmap a(int paramInt)
  {
    yts localyts = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyts != null) {
      return localyts.jdField_a_of_type_Yre.a();
    }
    return null;
  }
  
  public FacePanel a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel;
  }
  
  public String a(int paramInt)
  {
    Object localObject = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((yts)localObject).jdField_a_of_type_Yri.a();
      if (localObject != null)
      {
        ykq.b("DoodleLayout", "doodle text :" + ((yrx)localObject).a);
        return ((yrx)localObject).a;
      }
    }
    return null;
  }
  
  public List<String> a(int paramInt)
  {
    Object localObject = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((yts)localObject).jdField_a_of_type_Yre.a.a();
      StringBuilder localStringBuilder = new StringBuilder().append("image doodle type count:");
      if ((localObject == null) || (((List)localObject).isEmpty())) {}
      for (paramInt = 0;; paramInt = ((List)localObject).size())
      {
        ykq.b("DoodleLayout", paramInt);
        return localObject;
      }
    }
    return Collections.emptyList();
  }
  
  public Map<String, List<String>> a(int paramInt)
  {
    Object localObject = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((yts)localObject).jdField_a_of_type_Yqv.a;
      ykq.b("DoodleLayout", "Using face map:" + localObject.toString());
      return Collections.unmodifiableMap((Map)localObject);
    }
    return Collections.emptyMap();
  }
  
  public yqu a()
  {
    yts localyts = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localyts == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localyts.jdField_a_of_type_Yqu;
  }
  
  public yqv a()
  {
    yts localyts = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localyts == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localyts.jdField_a_of_type_Yqv;
  }
  
  public yre a()
  {
    yts localyts = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localyts == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localyts.jdField_a_of_type_Yre;
  }
  
  public yri a()
  {
    yts localyts = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localyts == null)
    {
      ykq.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return localyts.jdField_a_of_type_Yri;
  }
  
  protected void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
    }
  }
  
  public void a(int paramInt)
  {
    ykq.b("DoodleLayout", "changeVideoIndex from %d to %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int = paramInt;
    e(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ykq.b("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    setDoodleBitmapMaxSize(paramInt1, paramInt2);
    int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth();
    int k = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.e();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.onSizeChanged(paramInt1, paramInt2, j, k);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(paramInt1, paramInt2);
    }
    localObject = (yuh)a().a(104);
    if (localObject != null) {
      ((yuh)localObject).e();
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Ytp != null) {
      this.jdField_a_of_type_Ytp.b(paramInt, paramObject);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("bitmap should not be null or recycled");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      throw new IllegalStateException("add bitmap as buffer duplicate");
    }
    this.jdField_a_of_type_JavaLangRuntimeException = null;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signal();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Yro != null)
    {
      this.jdField_a_of_type_Yro.d(paramMotionEvent);
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      return;
      this.jdField_a_of_type_Yro = a();
    }
  }
  
  public void a(yuv paramyuv)
  {
    a();
    if (paramyuv == null) {
      ykq.e("DoodleLayout", "the item is null.");
    }
    boolean bool1;
    do
    {
      return;
      ykq.b("DoodleLayout", "addLocationFaceItem:" + paramyuv.toString());
      yrd localyrd = yvn.a(paramyuv, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight());
      if (localyrd == null) {
        break;
      }
      boolean bool2 = false;
      bool1 = bool2;
      if (paramyuv.a != null)
      {
        yqv localyqv = a();
        bool1 = bool2;
        if (localyqv != null) {
          bool1 = localyqv.a(null, paramyuv.c, paramyuv.a, localyrd);
        }
      }
    } while (!bool1);
    this.jdField_a_of_type_Ytp.a(paramyuv);
    ykw.a("0X80076CE");
    return;
    ykq.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
  }
  
  public void a(boolean paramBoolean)
  {
    int k = 0;
    View localView;
    if (paramBoolean)
    {
      j = getResources().getColor(2131165708);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(j);
      super.setBackgroundColor(j);
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int j = k;; j = 4)
    {
      localView.setVisibility(j);
      return;
      j = 0;
      break;
    }
  }
  
  public void a(View... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      View localView = paramVarArgs[j];
      if (localView != null) {
        localView.setVisibility(4);
      }
      j += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b();
  }
  
  public boolean a(float paramFloat1, float paramFloat2, Rect paramRect)
  {
    boolean bool = false;
    if (paramRect == null) {}
    for (int j = 0;; j = paramRect.width() / 2)
    {
      if ((paramFloat1 < -j) || (paramFloat2 < -j) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.width() + j) || (paramFloat2 > j + this.jdField_a_of_type_AndroidGraphicsRect.height())) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b(paramMotionEvent);
    if (paramMotionEvent != a())
    {
      ykq.b("DoodleLayout", "layer accept the outside MotionEvent. Layer->" + paramMotionEvent.toString());
      this.jdField_a_of_type_Yro = paramMotionEvent;
      return true;
    }
    ykq.b("DoodleLayout", "no layer accept the outside MotionEvent.");
    this.jdField_a_of_type_Yro = a();
    return false;
  }
  
  public byte[] a(int paramInt)
  {
    yts localyts = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyts == null) {
      return null;
    }
    return localyts.jdField_a_of_type_Yre.a();
  }
  
  public int[] a(int paramInt)
  {
    Object localObject = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((yts)localObject).jdField_a_of_type_Yre.a.a();
      ykq.b("DoodleLayout", "normal path count:" + localObject[0] + ",mosaic path count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int b()
  {
    int j = 0;
    int k = 0;
    while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      yts localyts = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j);
      k = k + localyts.jdField_a_of_type_Yri.a() + localyts.jdField_a_of_type_Yre.a() + localyts.jdField_a_of_type_Yqv.a();
      j += 1;
    }
    return k;
  }
  
  public Bitmap b()
  {
    if (this.jdField_a_of_type_Yto == null) {
      return null;
    }
    return this.jdField_a_of_type_Yto.b();
  }
  
  /* Error */
  public Bitmap b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 195	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Lcom/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 866	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:a	()I
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 195	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Lcom/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 868	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:b	()I
    //   15: istore_3
    //   16: iload_2
    //   17: ifle +7 -> 24
    //   20: iload_3
    //   21: ifgt +31 -> 52
    //   24: ldc 179
    //   26: ldc_w 870
    //   29: iconst_2
    //   30: anewarray 656	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: iload_2
    //   36: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: iload_3
    //   43: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic 872	ykq:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aconst_null
    //   51: areturn
    //   52: aload_0
    //   53: getfield 87	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: iconst_0
    //   57: invokevirtual 875	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   60: ifeq +15 -> 75
    //   63: aload_0
    //   64: iload_2
    //   65: iload_3
    //   66: getstatic 881	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   69: invokestatic 885	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   72: putfield 755	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   75: aload_0
    //   76: getfield 92	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   79: invokeinterface 753 1 0
    //   84: aload_0
    //   85: getfield 755	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   88: astore 6
    //   90: aload 6
    //   92: ifnonnull +118 -> 210
    //   95: ldc 179
    //   97: ldc_w 887
    //   100: invokestatic 889	ykq:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 100	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   107: ldc2_w 890
    //   110: getstatic 897	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   113: invokeinterface 901 4 0
    //   118: ifne -34 -> 84
    //   121: ldc 179
    //   123: ldc_w 903
    //   126: iconst_1
    //   127: anewarray 656	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: invokestatic 909	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   135: invokevirtual 913	java/lang/Thread:getId	()J
    //   138: invokestatic 918	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: aastore
    //   142: invokestatic 672	ykq:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 759	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   149: ifnull -65 -> 84
    //   152: ldc 179
    //   154: ldc_w 920
    //   157: aload_0
    //   158: getfield 759	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   161: invokestatic 923	ykq:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: goto -80 -> 84
    //   167: astore 6
    //   169: ldc 179
    //   171: ldc_w 925
    //   174: aload 6
    //   176: invokestatic 923	ykq:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: goto -95 -> 84
    //   182: astore 6
    //   184: aload_0
    //   185: getfield 92	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   188: invokeinterface 767 1 0
    //   193: aload 6
    //   195: athrow
    //   196: astore 6
    //   198: ldc 179
    //   200: ldc_w 927
    //   203: aload 6
    //   205: invokestatic 929	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: aconst_null
    //   209: areturn
    //   210: aload_0
    //   211: getfield 755	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   214: astore 6
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 755	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   221: new 931	android/graphics/Canvas
    //   224: dup
    //   225: aload 6
    //   227: invokespecial 933	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   230: astore 7
    //   232: new 935	android/graphics/Paint
    //   235: dup
    //   236: invokespecial 936	android/graphics/Paint:<init>	()V
    //   239: astore 8
    //   241: aload 8
    //   243: new 938	android/graphics/PorterDuffXfermode
    //   246: dup
    //   247: getstatic 944	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   250: invokespecial 947	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   253: invokevirtual 951	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   256: pop
    //   257: aload 7
    //   259: aload 8
    //   261: invokevirtual 955	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   264: aload_0
    //   265: getfield 70	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   268: iload_1
    //   269: invokevirtual 248	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   272: checkcast 250	yts
    //   275: astore 8
    //   277: aload 8
    //   279: ifnonnull +34 -> 313
    //   282: ldc 179
    //   284: ldc_w 957
    //   287: iconst_1
    //   288: anewarray 656	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: iload_1
    //   294: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 872	ykq:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload_0
    //   302: getfield 92	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   305: invokeinterface 767 1 0
    //   310: aload 6
    //   312: areturn
    //   313: invokestatic 962	android/os/SystemClock:uptimeMillis	()J
    //   316: lstore 4
    //   318: aload 8
    //   320: getfield 387	yts:jdField_a_of_type_Yre	Lyre;
    //   323: astore 9
    //   325: aload 9
    //   327: getfield 371	yre:a	Lyud;
    //   330: invokevirtual 963	yud:a	()Z
    //   333: ifeq +126 -> 459
    //   336: ldc 179
    //   338: ldc_w 965
    //   341: invokestatic 889	ykq:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield 314	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams	Lcom/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   348: getfield 968	com/tencent/biz/qqstory/takevideo/EditVideoParams:mBusinessId	I
    //   351: iconst_1
    //   352: if_icmpne +98 -> 450
    //   355: aload 9
    //   357: getfield 371	yre:a	Lyud;
    //   360: invokevirtual 969	yud:b	()Z
    //   363: ifeq +87 -> 450
    //   366: iconst_1
    //   367: newarray int
    //   369: astore 10
    //   371: aload 10
    //   373: iconst_0
    //   374: iconst_0
    //   375: iastore
    //   376: iconst_5
    //   377: istore_1
    //   378: aload 9
    //   380: getfield 371	yre:a	Lyud;
    //   383: new 971	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$8
    //   386: dup
    //   387: aload_0
    //   388: aload 9
    //   390: iload_2
    //   391: aload 10
    //   393: invokespecial 974	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$8:<init>	(Lcom/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;Lyre;I[I)V
    //   396: invokevirtual 977	yud:a	(Ljava/lang/Runnable;)V
    //   399: aload 10
    //   401: iconst_0
    //   402: iaload
    //   403: istore_2
    //   404: iload_2
    //   405: iconst_1
    //   406: if_icmpeq +53 -> 459
    //   409: iload_1
    //   410: iconst_1
    //   411: isub
    //   412: istore_2
    //   413: iload_1
    //   414: ifle +45 -> 459
    //   417: ldc2_w 890
    //   420: invokestatic 981	java/lang/Thread:sleep	(J)V
    //   423: ldc 179
    //   425: ldc_w 983
    //   428: iload_2
    //   429: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   432: invokestatic 263	ykq:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   435: iload_2
    //   436: istore_1
    //   437: goto -38 -> 399
    //   440: astore 11
    //   442: aload 11
    //   444: invokevirtual 986	java/lang/InterruptedException:printStackTrace	()V
    //   447: goto -24 -> 423
    //   450: aload 9
    //   452: getfield 371	yre:a	Lyud;
    //   455: iload_2
    //   456: invokevirtual 987	yud:b	(I)V
    //   459: aload_0
    //   460: getfield 314	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams	Lcom/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   463: ifnull +20 -> 483
    //   466: aload_0
    //   467: getfield 314	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams	Lcom/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   470: invokevirtual 990	com/tencent/biz/qqstory/takevideo/EditVideoParams:isEditPhoto	()Z
    //   473: ifeq +10 -> 483
    //   476: aload 9
    //   478: aload 7
    //   480: invokevirtual 993	yre:c	(Landroid/graphics/Canvas;)V
    //   483: aload 8
    //   485: getfield 996	yts:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   488: invokevirtual 1002	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   491: astore 8
    //   493: aload 8
    //   495: invokeinterface 1007 1 0
    //   500: ifeq +21 -> 521
    //   503: aload 8
    //   505: invokeinterface 1011 1 0
    //   510: checkcast 291	yro
    //   513: aload 7
    //   515: invokevirtual 1013	yro:b	(Landroid/graphics/Canvas;)V
    //   518: goto -25 -> 493
    //   521: ldc 179
    //   523: new 181	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 1015
    //   533: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokestatic 962	android/os/SystemClock:uptimeMillis	()J
    //   539: lload 4
    //   541: lsub
    //   542: invokevirtual 1018	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   545: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 212	ykq:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload_0
    //   552: getfield 92	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   555: invokeinterface 767 1 0
    //   560: aload 6
    //   562: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	DoodleLayout
    //   0	563	1	paramInt	int
    //   7	449	2	j	int
    //   15	51	3	k	int
    //   316	224	4	l	long
    //   88	3	6	localBitmap1	Bitmap
    //   167	8	6	localInterruptedException1	java.lang.InterruptedException
    //   182	12	6	localObject1	Object
    //   196	8	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   214	347	6	localBitmap2	Bitmap
    //   230	284	7	localCanvas	android.graphics.Canvas
    //   239	265	8	localObject2	Object
    //   323	154	9	localyre	yre
    //   369	31	10	arrayOfInt	int[]
    //   440	3	11	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   95	164	167	java/lang/InterruptedException
    //   84	90	182	finally
    //   95	164	182	finally
    //   169	179	182	finally
    //   210	277	182	finally
    //   282	301	182	finally
    //   313	371	182	finally
    //   378	399	182	finally
    //   417	423	182	finally
    //   423	435	182	finally
    //   442	447	182	finally
    //   450	459	182	finally
    //   459	483	182	finally
    //   483	493	182	finally
    //   493	518	182	finally
    //   521	551	182	finally
    //   63	75	196	java/lang/OutOfMemoryError
    //   417	423	440	java/lang/InterruptedException
  }
  
  public List<yqw> b(int paramInt)
  {
    Object localObject = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((yts)localObject).jdField_a_of_type_Yqv.b;
      ykq.b("DoodleLayout", "Using poi list:" + localObject.toString());
      return Collections.unmodifiableList((List)localObject);
    }
    return Collections.emptyList();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.post(new DoodleLayout.3(this));
    }
  }
  
  public void b(int paramInt)
  {
    a();
    ykq.b("DoodleLayout", "onTextPressed, buttonState:" + this.jdField_b_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    String str;
    if (paramInt == 2)
    {
      str = "add_text";
      a(str);
      if (paramInt != 2) {
        break label104;
      }
      ykw.a("0X80076B9", ykw.jdField_b_of_type_Int);
      label74:
      if (this.jdField_b_of_type_Int != 3) {
        break label113;
      }
      if (this.jdField_a_of_type_Yso != null) {
        this.jdField_a_of_type_Yso.dismiss();
      }
    }
    label104:
    label113:
    do
    {
      do
      {
        return;
        str = "edit_text";
        break;
        ykw.a("0X80076C3");
        break label74;
        m();
        a(new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout });
      } while (this.jdField_b_of_type_Int == 0);
      if (this.jdField_b_of_type_Int == 1)
      {
        a(false);
        a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
        b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
        return;
      }
    } while (this.jdField_b_of_type_Int != 2);
    a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
  }
  
  public void b(View... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      View localView = paramVarArgs[j];
      if (localView != null) {
        localView.setVisibility(0);
      }
      j += 1;
    }
  }
  
  public boolean b(int paramInt)
  {
    return this.jdField_b_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false);
  }
  
  public int[] b(int paramInt)
  {
    Object localObject = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((yts)localObject).jdField_a_of_type_Yqv.a();
      ykq.b("DoodleLayout", "normal face count:" + localObject[0] + ",location face count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    a();
    yre localyre = a();
    ykq.b("DoodleLayout", "undo, activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() + ",pathCount:" + localyre.a.a());
    if (localyre.d())
    {
      localyre.c();
      if (localyre.a.a() == 0) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
  }
  
  public void c(int paramInt)
  {
    if (!yty.a(paramInt))
    {
      ykq.e("DoodleLayout", "illegal state.");
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public boolean c(int paramInt)
  {
    Object localObject = (yts)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((yts)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((yro)((Iterator)localObject).next()).a()) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId;
  }
  
  public void d()
  {
    a();
    ykq.b("DoodleLayout", "onFacePressed, buttonState:" + this.jdField_b_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    ykw.a("0X80076BA", ykw.jdField_b_of_type_Int);
    a(true);
    super.setBackgroundColor(getResources().getColor(2131165708));
    a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    setDoodleGLViewVisibility(4);
    b(new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout });
    if (this.jdField_b_of_type_Int == 0) {
      b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
    }
    for (;;)
    {
      c(1);
      return;
      if (this.jdField_b_of_type_Int == 3)
      {
        c(1);
        this.jdField_a_of_type_Yso.dismiss();
        super.postDelayed(new DoodleLayout.7(this), 100L);
        return;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        a().b(false);
        a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
      }
    }
  }
  
  public void d(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void e()
  {
    a();
    ykq.b("DoodleLayout", "onLinePressed, buttonState:" + this.jdField_b_of_type_Int + ",activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    ykw.a("0X80076B8", ykw.jdField_b_of_type_Int);
    yre localyre = a();
    a(new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout });
    b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    localyre.b(true);
    if (localyre.b())
    {
      yup localyup = (yup)localyre.a(101);
      if (localyup != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(localyup.jdField_b_of_type_Int);
      }
    }
    if (localyre.a.a() > 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
      if (this.jdField_b_of_type_Int != 0) {
        break label170;
      }
    }
    for (;;)
    {
      c(2);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
      break;
      label170:
      if (this.jdField_b_of_type_Int == 3)
      {
        c(2);
        this.jdField_a_of_type_Yso.dismiss();
        a(new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout });
        return;
      }
      if (this.jdField_b_of_type_Int == 1)
      {
        a(false);
        a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
        b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
    }
  }
  
  public void f()
  {
    a();
    b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    setDoodleGLViewVisibility(0);
    a(new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout });
    a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    if ((this.jdField_a_of_type_Yso != null) && (this.jdField_a_of_type_Yso.isShowing()))
    {
      this.jdField_a_of_type_Yso.dismiss();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.d();
    c(0);
  }
  
  public void g()
  {
    String str = Build.MODEL;
    if (((str.equals("vivo Y75A")) || (str.equals("PACM00"))) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onResume, onStillRequestRender");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.requestLayout();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.invalidate();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.a();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.g();
  }
  
  public void i()
  {
    this.jdField_c_of_type_Boolean = true;
    int j = 0;
    while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      yri localyri = ((yts)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j)).jdField_a_of_type_Yri;
      localyri.a(null);
      localyri.a(null);
      j += 1;
    }
  }
  
  public void j()
  {
    if (this.jdField_b_of_type_Int == 6)
    {
      a(2, Boolean.valueOf(false));
      c(2);
      if (a().a.a() <= 0) {
        break label135;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
    }
    for (;;)
    {
      b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new ytn(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation(localAlphaAnimation);
      if (this.jdField_a_of_type_Yto != null) {
        this.jdField_a_of_type_Yto.b(localAlphaAnimation);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen");
      }
      return;
      label135:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.jdField_a_of_type_AndroidWidgetTextView) && (!a(false)) && (this.jdField_a_of_type_Ytp != null)) {
        this.jdField_a_of_type_Ytp.h();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.b();
    super.onDetachedFromWindow();
  }
  
  public void setDoodleBitmapMaxSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      ykq.e("DoodleLayout", "width or height is illegal, width=" + paramInt1 + ",height=" + paramInt2);
    }
    for (;;)
    {
      return;
      ykq.b("DoodleLayout", "setDoodleBitmapMaxSize, maxWidth" + paramInt1 + ",maxHeight:" + paramInt2);
      this.f = paramInt1;
      this.g = paramInt2;
      int j = 0;
      while (j < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((yrt)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).jdField_a_of_type_Int = paramInt1;
        ((yrt)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).jdField_b_of_type_Int = paramInt2;
        j += 1;
      }
    }
  }
  
  public void setDoodleBtnOperationHelper(yto paramyto)
  {
    this.jdField_a_of_type_Yto = paramyto;
  }
  
  public void setDoodleEventListener(ytp paramytp)
  {
    this.jdField_a_of_type_Ytp = paramytp;
  }
  
  @TargetApi(14)
  public void setDoodleGLViewVisibility(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      ykq.b("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.a(paramInt);
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramEditVideoParams);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(paramEditVideoParams);
    jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditPhoto();
    n();
  }
  
  public void setLocation(String paramString)
  {
    if (this.jdField_a_of_type_Yqw == null)
    {
      ykq.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    ykq.b("DoodleLayout", "setLocation: clickItem-->" + this.jdField_a_of_type_Yqw);
    if (a() != null) {
      a().a(this.jdField_a_of_type_Yqw, paramString);
    }
    this.jdField_a_of_type_Yqw = null;
  }
  
  public void setMosaicSize(int paramInt)
  {
    int j = paramInt;
    if (paramInt < 1)
    {
      ykq.e("DoodleLayout", "MosaicSize little than 1.");
      j = 1;
    }
    this.jdField_c_of_type_Int = j;
    paramInt = 0;
    while (paramInt < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      yuh localyuh = (yuh)((yts)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(paramInt)).jdField_a_of_type_Yre.a(103);
      if (localyuh != null) {
        localyuh.b(j);
      }
      paramInt += 1;
    }
  }
  
  public void setMosaicStandardSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      ykq.e("DoodleLayout", "StandardMosaicSize, width or height <= 0. width:" + paramInt1 + ",height:" + paramInt2);
    }
    for (;;)
    {
      return;
      this.jdField_d_of_type_Int = paramInt1;
      this.e = paramInt2;
      int j = 0;
      while (j < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        yuh localyuh = (yuh)((yts)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(j)).jdField_a_of_type_Yre.a(103);
        if (localyuh != null) {
          localyuh.b(paramInt1, paramInt2);
        }
        j += 1;
      }
    }
  }
  
  public void setOnTextDialogShowListener(ytx paramytx)
  {
    this.jdField_a_of_type_Ytx = paramytx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */