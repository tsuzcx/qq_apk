package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import ajyc;
import amkg;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import bbjw;
import bcpw;
import bkur;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import qol;
import udc;
import udd;
import ude;
import udf;
import udg;
import udh;
import ueg;
import wio;
import wip;
import wpw;
import wpy;
import wtt;
import wtu;
import wtv;
import wtx;
import wty;
import wtz;
import wua;
import wub;
import wuc;
import wud;
import wue;
import wuf;
import wug;
import wuh;
import wui;
import wuj;
import wuk;
import wul;
import wum;
import wun;
import wuo;
import xhe;

public class VideoPlayerView
  extends FrameLayout
  implements NetworkManager.NetStatusListener, TVK_IMediaPlayer.OnSeekCompleteListener, udd, ude, udf, udg, udh, wpy
{
  private static float jdField_a_of_type_Float = 1.0F;
  private static boolean n;
  private final int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private final Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  protected View a;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ProgressBar a;
  public SeekBar a;
  protected TextView a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private SubscribeVideoDetailFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment;
  private VideoNextFeedsView jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
  private FollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<WeakReference<View>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private ConcurrentHashMap<WeakReference<View>, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private udh jdField_a_of_type_Udh;
  private ueg jdField_a_of_type_Ueg;
  private final wtt jdField_a_of_type_Wtt;
  private wtu jdField_a_of_type_Wtu;
  private wuo jdField_a_of_type_Wuo;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int = 2;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public TextView b;
  private FollowTextView jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private SquareImageView jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = bkur.a(getContext());
  private final int jdField_c_of_type_Int = 3;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  protected ImageView c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  protected ImageView d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  public ImageView e;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 1;
  private long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean = true;
  private View jdField_h_of_type_AndroidViewView;
  private boolean jdField_h_of_type_Boolean;
  private View jdField_i_of_type_AndroidViewView;
  private boolean jdField_i_of_type_Boolean;
  private View jdField_j_of_type_AndroidViewView;
  private boolean jdField_j_of_type_Boolean;
  private View jdField_k_of_type_AndroidViewView;
  private boolean jdField_k_of_type_Boolean;
  private View jdField_l_of_type_AndroidViewView;
  private boolean jdField_l_of_type_Boolean;
  private boolean m;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  
  public VideoPlayerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(getContext());
    if (a() != null) {
      addView(a().a(), new FrameLayout.LayoutParams(-1, -1));
    }
    m();
    j();
    this.jdField_a_of_type_Wtt = new wtt();
  }
  
  private void A()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
      if (((Activity)this.jdField_a_of_type_AndroidContentContext).getRequestedOrientation() != 0) {
        break label42;
      }
    }
    label42:
    for (int i1 = 25;; i1 = 12)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setMaxEms(i1);
      return;
    }
  }
  
  private void B()
  {
    int i2 = 0;
    label107:
    View localView;
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.get() != 0) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()) != null))
    {
      i1 = 1;
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setOnlyFollowMode(true);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
      }
      if ((i1 != 0) || (this.r) || (!f())) {
        break label229;
      }
      i1 = 1;
      if (this.jdField_e_of_type_AndroidViewView != null)
      {
        if (i1 != 0)
        {
          this.r = true;
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
            xhe.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "half_exp", 0, 0, new String[] { "", "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
          }
        }
        localView = this.jdField_e_of_type_AndroidViewView;
        if (i1 == 0) {
          break label234;
        }
      }
    }
    label229:
    label234:
    for (int i1 = i2;; i1 = 8)
    {
      localView.setVisibility(i1);
      a().sendEmptyMessageDelayed(3, 5000L);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label107;
    }
  }
  
  private void C()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838660);
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setRequestedOrientation(1);
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setMaxEms(12);
      }
    }
    b(this.jdField_a_of_type_ArrayOfInt);
    a(0);
    e(false);
    C();
    if (this.jdField_f_of_type_Int == 10) {
      v();
    }
    amkg.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if ("auto".equals(paramString2)) {
      str = "hd";
    }
    paramString1 = new File(wip.d + "st" + String.valueOf(20161223) + "_" + paramString1 + "." + str);
    if ((paramString1.exists()) && (paramString1.isDirectory()))
    {
      paramString1 = paramString1.listFiles();
      int i2 = paramString1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        paramString2 = paramString1[i1];
        if ((paramString2.getName().endsWith("tmp")) || (paramString2.getName().endsWith("mp4"))) {
          return paramString2.getAbsolutePath();
        }
        i1 += 1;
      }
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((View)localWeakReference.get()).setVisibility(paramInt);
        }
      }
    }
  }
  
  private void a(WeakReference<View> paramWeakReference, int paramInt1, int paramInt2)
  {
    a(paramWeakReference, paramInt1, paramInt2, false);
  }
  
  private void a(WeakReference<View> paramWeakReference, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramWeakReference.get() == null) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramWeakReference.get(), "alpha", new float[] { paramInt1, paramInt2 });
    localObjectAnimator.setDuration(0L);
    localObjectAnimator.addListener(new wuc(this, paramWeakReference, paramInt2, paramBoolean, paramInt1));
    localObjectAnimator.start();
  }
  
  private void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a();
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.c((CertifiedAccountMeta.StFeed)localObject);
      str = ((CertifiedAccountMeta.StFeed)localObject).poster.id.get();
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (Object localObject = "next_play";; localObject = "next_clk")
    {
      xhe.b(str, "auth_video", (String)localObject, 0, 0, new String[0]);
      if (this.jdField_e_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(0);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
    }
  }
  
  private void b(int[] paramArrayOfInt)
  {
    getLayoutParams().width = paramArrayOfInt[0];
    getLayoutParams().height = paramArrayOfInt[1];
    setLayoutParams(getLayoutParams());
  }
  
  private void c(boolean paramBoolean)
  {
    int i2 = 8;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (paramBoolean)
      {
        i1 = 0;
        ((ProgressBar)localObject).setVisibility(i1);
      }
    }
    else if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int i1 = i2;; i1 = 0)
    {
      ((ImageView)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (!bkur.b()) {}
    do
    {
      do
      {
        return;
        if ((!paramBoolean) || (this.q)) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.a(true, this.jdField_g_of_type_Int);
        }
      } while (this.jdField_b_of_type_AndroidViewView == null);
      this.jdField_b_of_type_AndroidViewView.setPadding(0, this.jdField_g_of_type_Int, 0, 0);
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.a(false, this.jdField_g_of_type_Int);
      }
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    View localView;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null))
    {
      localView = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().getDecorView();
      if (!this.jdField_a_of_type_Boolean) {
        break label126;
      }
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().setFlags(1024, 1024);
      bkur.c(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
      qol.a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setUIState(paramBoolean, this.q);
      }
      d(this.jdField_a_of_type_Boolean);
      return;
      label126:
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(0, 10);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().clearFlags(1024);
      bkur.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new wtv(this));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new wug(this));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new wui(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new wuj(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new wuk(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wul(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new wum(this));
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new wun(this));
    wpw.a().a(this);
  }
  
  private void k()
  {
    if ((a() != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      if (a().a()) {
        a();
      }
    }
    else {
      return;
    }
    d();
  }
  
  private void l()
  {
    if (this.jdField_f_of_type_Boolean) {
      s();
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = true;
      return;
      t();
    }
  }
  
  private void m()
  {
    this.jdField_j_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558712, this, false);
    addView(this.jdField_j_of_type_AndroidViewView);
    n();
    u();
    this.jdField_g_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131369448);
    this.jdField_h_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131369449);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131368728));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131366331);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378181));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131368642));
    this.jdField_f_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131379457);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378218));
    o();
    if (a() != null) {
      a().setXYaxis(2);
    }
    NetworkManager.registNetStatusListener(this);
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131375467);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378409));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378378));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378408));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368581));
    this.jdField_i_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131369365);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131369461);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131369469);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368732));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368734));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368731));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131368730));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131375779));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(1000);
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_b_of_type_AndroidViewView), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_d_of_type_AndroidWidgetImageView), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_b_of_type_AndroidWidgetImageView), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_c_of_type_AndroidWidgetImageView), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_a_of_type_AndroidWidgetSeekBar), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_a_of_type_AndroidWidgetImageView), Integer.valueOf(0));
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_b_of_type_AndroidViewView.getId(), true);
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_g_of_type_AndroidViewView.getId(), true);
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_h_of_type_AndroidViewView.getId(), true);
  }
  
  private void p()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.p = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Long = 0L;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    a().removeCallbacksAndMessages(null);
  }
  
  private void q()
  {
    b(1);
    this.r = false;
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_i_of_type_AndroidViewView != null) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838663);
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      c(true);
    }
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    w();
    a().removeMessages(3);
  }
  
  private void r()
  {
    long l1;
    Object localObject;
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null) && (a() != null))
    {
      l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      localObject = new StringBuilder();
      if (l1 < a().b()) {
        break label368;
      }
    }
    label368:
    for (int i1 = 1;; i1 = 0)
    {
      localObject = i1 + "";
      xhe.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "play", 0, 0, new String[] { a().b() + "", l1 + "", localObject, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get() });
      if (this.jdField_e_of_type_Int > 0)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("time_cost", Long.valueOf(this.jdField_f_of_type_Long));
        ((HashMap)localObject).put("count", Integer.valueOf(this.jdField_e_of_type_Int));
        ((HashMap)localObject).put("url", this.jdField_b_of_type_JavaLangString);
        xhe.a("subscribe_account_video_play_extra_buffer", xhe.b((HashMap)localObject));
      }
      if (a() != null)
      {
        double d2 = a().a();
        double d1 = a().b();
        if ((d2 > 0.0D) && (d1 > 0.0D) && (d2 <= d1))
        {
          d2 /= d1;
          localObject = new HashMap();
          ((HashMap)localObject).put("rate", String.format("%.2f", new Object[] { Double.valueOf(d2 * 100.0D) }));
          ((HashMap)localObject).put("url", this.jdField_b_of_type_JavaLangString);
          ((HashMap)localObject).put("attach_info", String.valueOf(d1));
          xhe.a("subscribe_account_video_play_complete_rate", xhe.b((HashMap)localObject));
        }
      }
      return;
    }
  }
  
  private void s()
  {
    if ((this.jdField_f_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        a((WeakReference)localIterator.next(), 1, 0);
      }
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  private void t()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        a((WeakReference)localIterator.next(), 0, 1);
      }
      this.jdField_f_of_type_Boolean = true;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  private void u()
  {
    this.jdField_k_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131366327);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView = ((VideoNextFeedsView)this.jdField_k_of_type_AndroidViewView.findViewById(2131379298));
    this.jdField_l_of_type_AndroidViewView = this.jdField_k_of_type_AndroidViewView.findViewById(2131369450);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_k_of_type_AndroidViewView.findViewById(2131366326));
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_k_of_type_AndroidViewView.findViewById(2131368578));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_k_of_type_AndroidViewView.findViewById(2131369387));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131378183));
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131366844));
    this.jdField_a_of_type_AndroidViewView = this.jdField_k_of_type_AndroidViewView.findViewById(2131378322);
    wud localwud = new wud(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(localwud);
    this.jdField_l_of_type_AndroidViewView.setOnClickListener(localwud);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnClickListener(new wue(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnCounterListener(new wuf(this));
  }
  
  private void v()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_k_of_type_AndroidViewView != null) {
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getLayoutParams();
      if (f())
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
        if (!f()) {
          break label370;
        }
        i1 = 0;
        label124:
        ((LinearLayout)localObject).setVisibility(i1);
      }
      if (!f()) {
        break label407;
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get());
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
        wio.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get(), this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
      if (this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
      {
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setOnlyFollowMode(true);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new wuh(this));
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (((Activity)this.jdField_a_of_type_AndroidContentContext).getRequestedOrientation() != 0)) {
          break label376;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(2, this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getId());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        ((LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.getLayoutParams()).rightMargin = ImmersiveUtils.a(12.0F);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.requestLayout();
      }
      if (this.jdField_l_of_type_AndroidViewView != null) {
        this.jdField_l_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label370:
    label376:
    while (this.jdField_l_of_type_AndroidViewView == null) {
      for (;;)
      {
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
        break;
        i1 = 8;
        break label124;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        ((LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.getLayoutParams()).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 0);
      }
    }
    label407:
    this.jdField_l_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void w()
  {
    if ((this.jdField_k_of_type_AndroidViewView != null) && (this.jdField_k_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_k_of_type_AndroidViewView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.b();
    }
  }
  
  private void x()
  {
    if (a() != null) {
      if (a().getViewWidth() <= a().getViewHeight()) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      return;
    }
  }
  
  private void y()
  {
    x();
    int i1 = this.jdField_b_of_type_ArrayOfInt[0];
    if (getLayoutParams().width != -1) {
      i1 = getLayoutParams().width;
    }
    this.jdField_a_of_type_ArrayOfInt = new int[] { i1, getLayoutParams().height };
    if (this.q)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).setRequestedOrientation(0);
      }
      b(new int[] { this.jdField_b_of_type_ArrayOfInt[1], this.jdField_b_of_type_ArrayOfInt[0] });
    }
    for (;;)
    {
      a(8);
      e(true);
      z();
      amkg.a(BaseApplicationImpl.getContext(), 2, false);
      return;
      b(new int[] { this.jdField_b_of_type_ArrayOfInt[0], this.jdField_b_of_type_ArrayOfInt[1] });
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      A();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838658);
    }
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new wub(this));
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public IVideoViewBase a()
  {
    if ((a() != null) && ((a().a() instanceof IVideoViewBase))) {
      return (IVideoViewBase)a().a();
    }
    return null;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(CommentListShowStateEvent.class);
    localArrayList.add(SharePanelShowStateEvent.class);
    return localArrayList;
  }
  
  public ueg a()
  {
    if (this.jdField_a_of_type_Ueg == null)
    {
      if (!TVK_SDKMgr.isInstalled(getContext())) {
        break label113;
      }
      xhe.a("subscribe_tvk_install_event_name", xhe.a(0L, 0L));
      this.jdField_a_of_type_Ueg = new ueg(getContext(), String.valueOf(System.identityHashCode(this)));
      this.jdField_a_of_type_Ueg.a(this);
      this.jdField_a_of_type_Ueg.a(this);
      this.jdField_a_of_type_Ueg.a(this);
      this.jdField_a_of_type_Ueg.a(this);
      this.jdField_a_of_type_Ueg.a(this);
      this.jdField_a_of_type_Ueg.a(this);
      this.jdField_a_of_type_Ueg.a("bus_type_subscribe");
    }
    for (;;)
    {
      return this.jdField_a_of_type_Ueg;
      label113:
      xhe.a("subscribe_tvk_install_event_name", xhe.a(-1L, 0L));
      QLog.w("VideoPlayerView", 1, "tvk is not installed");
    }
  }
  
  public void a()
  {
    if (a() != null)
    {
      b(7);
      if (a().a())
      {
        a().c();
        this.jdField_k_of_type_Boolean = true;
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838663);
      }
    }
  }
  
  public void a(long paramLong)
  {
    long l1 = 0L;
    if (a() != null)
    {
      long l2 = a().b();
      if ((paramLong <= l2) || (l2 == 0L)) {
        break label141;
      }
      QLog.d("VideoPlayerView", 1, "seek over position=" + paramLong + "duration=" + l2);
      paramLong = l2;
    }
    label141:
    for (;;)
    {
      if (paramLong < 0L)
      {
        QLog.d("VideoPlayerView", 1, "seek invalid position=" + paramLong + "duration=" + a().b());
        paramLong = l1;
      }
      for (;;)
      {
        a().a(paramLong);
        this.p = true;
        return;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_d_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext)) {
      a();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramView));
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FollowUpdateEvent)) {
      if ((((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 0) && (this.jdField_a_of_type_JavaUtilHashMap != null))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(((FollowUpdateEvent)paramSimpleBaseEvent).useId);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
          this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.set(0);
        }
      }
    }
    do
    {
      return;
      if ((paramSimpleBaseEvent instanceof CommentListShowStateEvent))
      {
        this.s = ((CommentListShowStateEvent)paramSimpleBaseEvent).shown;
        return;
      }
    } while (!(paramSimpleBaseEvent instanceof SharePanelShowStateEvent));
    this.s = ((SharePanelShowStateEvent)paramSimpleBaseEvent).shown;
  }
  
  public void a(String paramString, File paramFile, int paramInt, JSONObject paramJSONObject) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    xhe.a("subscribe_account_video_download", xhe.a(xhe.a(paramInt, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    xhe.a("subscribe_account_video_download", xhe.a(xhe.a(0L, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
  }
  
  public void a(udc paramudc)
  {
    b(10);
    if (a() != null)
    {
      v();
      t();
      this.jdField_g_of_type_Boolean = true;
    }
    if (!this.s) {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)
      {
        if (!b()) {
          break label88;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a();
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoComplete(false);
      }
      return;
      label88:
      if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a()) && (this.jdField_e_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2131165283);
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(null);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
        {
          xhe.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "finish_exp", 0, 0, new String[] { "", "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
          continue;
          q();
          f();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i1 = 2130838665;; i1 = 2130838664)
    {
      localImageView.setImageResource(i1);
      return;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      paramArrayOfInt = this.jdField_c_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ArrayOfInt[0] <= this.jdField_a_of_type_ArrayOfInt[1]) {
        break label41;
      }
    }
    label41:
    for (int i1 = 25;; i1 = 12)
    {
      paramArrayOfInt.setMaxEms(i1);
      return;
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Ueg != null) && (this.jdField_a_of_type_Ueg.a() != null))
    {
      if (f()) {
        D();
      }
      ThreadManager.getUIHandler().postDelayed(new VideoPlayerView.9(this), 500L);
      return true;
    }
    QLog.d("VideoPlayerView", 4, "enterFloat to early, player is not init");
    return false;
  }
  
  public boolean a(udc paramudc, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    b(9);
    QLog.e("VideoPlayerView", 1, "what:" + paramInt2 + ",model:" + paramInt1 + ",extra:" + paramString);
    c(false);
    xhe.a("subscribe_account_video_play", xhe.a(xhe.a(paramInt2, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
    if (paramInt2 == 102) {
      return false;
    }
    if (!this.jdField_j_of_type_Boolean) {
      bcpw.a(getContext(), 1, ajyc.a(2131716344), 0).a();
    }
    return false;
  }
  
  public boolean a(udc paramudc, int paramInt, Object paramObject)
  {
    if (paramInt == 2)
    {
      b(4);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_g_of_type_Boolean = true;
      c(true);
      t();
    }
    while (paramInt != 3) {
      return false;
    }
    b(5);
    this.jdField_g_of_type_Boolean = false;
    if (!this.p)
    {
      this.jdField_e_of_type_Int += 1;
      this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
    }
    c(false);
    s();
    return false;
  }
  
  public void a_(udc paramudc)
  {
    xhe.a("subscribe_account_video_play", xhe.a(xhe.a(0L, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
    xhe.a("subscribe_account_video_play_first_buffer", xhe.a(xhe.a(0L, System.currentTimeMillis() - this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString, 0L)));
    b(10);
    this.jdField_g_of_type_Boolean = false;
    x();
    A();
    a().setXYaxis(0);
    int i1;
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
      if (this.q)
      {
        i1 = 21;
        localLayoutParams.gravity = i1;
        int i2 = ImmersiveUtils.a(25.0F);
        if (!this.q) {
          break label419;
        }
        i1 = 0;
        label125:
        localLayoutParams.setMargins(0, 0, i2, i1);
        this.jdField_e_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) && (b()) && (a() != null))
      {
        if (!this.m) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onOrientationChange(this.q);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoSize(a().getViewWidth(), a().getViewHeight());
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        c(false);
      }
      if (this.jdField_i_of_type_AndroidViewView != null) {
        this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      }
      long l1 = paramudc.b() / 1000L;
      if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setMax((int)paramudc.b());
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("/" + String.format("%02d:%02d", new Object[] { Integer.valueOf((int)l1 / 60), Integer.valueOf((int)l1 % 60) }));
      }
      h();
      if (((!this.jdField_c_of_type_Boolean) || (!NetworkUtils.isWifiConnected(getContext()))) && (!n)) {
        break label429;
      }
      if (!this.jdField_k_of_type_Boolean)
      {
        d();
        this.jdField_d_of_type_Long = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Udh != null) {
        this.jdField_a_of_type_Udh.a_(paramudc);
      }
      s();
      return;
      i1 = 85;
      break;
      label419:
      i1 = ImmersiveUtils.a(82.0F);
      break label125;
      label429:
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      } else if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener = FloatingScreenManager.getInstance().setFloatingVideoListener(new wtx(this));
    FloatingScreenManager.getInstance().setFullScreenViewClickListener(new wty(this));
    FloatingScreenManager.getInstance().setWindowClickListener(0, new wtz(this));
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(paramView), Integer.valueOf(paramView.getVisibility()));
  }
  
  public boolean b()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public void c()
  {
    if (a() != null)
    {
      a().f();
      this.jdField_k_of_type_Boolean = false;
      a().g();
    }
  }
  
  public boolean c()
  {
    return (a() != null) && (a().a());
  }
  
  public void d()
  {
    if (a() != null)
    {
      b(5);
      if (this.jdField_a_of_type_Wtt != null) {
        this.jdField_a_of_type_Wtt.a(a().a(), new wua(this));
      }
      if ((this.jdField_k_of_type_Boolean) && (this.jdField_c_of_type_Long > 0L))
      {
        this.jdField_b_of_type_Long -= System.currentTimeMillis() - this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      this.jdField_k_of_type_Boolean = false;
      a().b();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoStart((int)this.jdField_a_of_type_Ueg.b());
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838662);
      }
    }
  }
  
  public boolean d()
  {
    return this.q;
  }
  
  public void e()
  {
    r();
    if (a() != null)
    {
      b(8);
      a().f();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      D();
      return true;
    }
    return false;
  }
  
  public void f()
  {
    if (a() != null)
    {
      a().f();
      this.jdField_k_of_type_Boolean = false;
      a().g();
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    r();
    if (a() != null) {
      a().e();
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_Wtt != null) {
      this.jdField_a_of_type_Wtt.a();
    }
    wpw.a().b(this);
    this.jdField_k_of_type_Boolean = false;
    a().removeCallbacksAndMessages(null);
    NetworkManager.unregistNetStatusListener(this);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new VideoPlayerView.14(this), 0L, 33L);
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Ueg != null) && (!this.jdField_a_of_type_Ueg.a())) {
      d();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_i_of_type_Boolean = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_i_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.b();
    }
    a().removeCallbacksAndMessages(null);
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    if (!"wifi".equals(paramString2)) {
      a().post(new VideoPlayerView.21(this));
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.p = false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((f()) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null)) {
      qol.a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
  }
  
  public void setCleanMode(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void setContinueFeeds(List<CertifiedAccountMeta.StFeed> paramList)
  {
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setData(paramList);
    }
  }
  
  public void setDarkFrameCheckListener(wtu paramwtu)
  {
    this.jdField_a_of_type_Wtu = paramwtu;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostFragment(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment = paramSubscribeVideoDetailFragment;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity()).mSystemBarComp;
      this.jdField_g_of_type_Int = bkur.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (a() != null) {
      a().a(paramBoolean);
    }
  }
  
  public void setNeedWifiTips(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setNextVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnPrepareListener(udh paramudh)
  {
    this.jdField_a_of_type_Udh = paramudh;
  }
  
  public void setOnProgressListener(wuo paramwuo)
  {
    this.jdField_a_of_type_Wuo = paramwuo;
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (a() != null) {
      a().b(paramBoolean);
    }
  }
  
  public void setPreviewVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRevertProgress(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoFeeds(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    setVideoPath(paramStFeed.video.fileId.get(), null, paramStFeed.video.playUrl.get(), paramStFeed.video.fileSize.get(), paramStFeed.video.duration.get(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      wio.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get());
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    p();
    q();
    xhe.a();
    Object localObject = "auto";
    if ((!bbjw.a(paramString3)) && (paramString3.startsWith("http://qzvv.video.qq.com/qzone")))
    {
      Uri localUri = Uri.parse(paramString3);
      paramString3 = paramString1;
      if (localUri != null)
      {
        str = localUri.getQueryParameter("playerformat");
        localObject = str;
        paramString3 = paramString1;
        if (bbjw.a(paramString1))
        {
          paramString3 = localUri.getQueryParameter("vid");
          localObject = str;
        }
      }
      String str = null;
      paramString1 = paramString3;
      paramString3 = str;
    }
    for (;;)
    {
      if (paramString3 != null)
      {
        this.jdField_b_of_type_JavaLangString = paramString3;
        if (!bbjw.a(paramString2)) {
          break label210;
        }
        paramString2 = a(paramString1, (String)localObject);
      }
      label210:
      for (;;)
      {
        t();
        this.jdField_g_of_type_Boolean = true;
        if (a() != null)
        {
          a().a(paramString1, paramString2, paramString3, (String)localObject, paramInt1, paramInt2, paramInt3);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          xhe.a("subscribe_account_video_start_play", xhe.a(xhe.a(0L, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
          xhe.a("subscribe_account_video_start_download", xhe.a(xhe.a(0L, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        return;
        this.jdField_b_of_type_JavaLangString = paramString1;
        break;
      }
      localObject = "auto";
    }
  }
  
  public void setVideoViewCover(String paramString)
  {
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130841453);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130841453);
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setWifiAutoPlay(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView
 * JD-Core Version:    0.7.0.1
 */